import argparse
import datetime
import json
import os
import shutil
import sys
import tempfile
import zipfile
from dataclasses import dataclass
from pathlib import Path


@dataclass(frozen=True)
class PackSource:
    name: str
    source_path: Path
    root_prefix: str  # for zip packs, '' or 'SomeFolder/'
    is_zip: bool


def is_valid_pack_dir(path: Path) -> bool:
    return (path / "pack.mcmeta").is_file() and (path / "assets").is_dir()


def discover_pack_dirs(root: Path) -> list[PackSource]:
    packs: list[PackSource] = []
    for item in sorted(root.iterdir(), key=lambda p: p.name.lower()):
        if item.is_dir() and is_valid_pack_dir(item):
            packs.append(PackSource(name=item.name, source_path=item, root_prefix="", is_zip=False))
    return packs


def discover_pack_zips(root: Path) -> list[PackSource]:
    packs: list[PackSource] = []
    for item in sorted(root.iterdir(), key=lambda p: p.name.lower()):
        if item.is_file() and item.suffix.lower() == ".zip":
            try:
                with zipfile.ZipFile(item, "r") as zf:
                    pack_roots: set[str] = set()
                    names = zf.namelist()
                    for name in names:
                        if name.endswith("pack.mcmeta"):
                            root_prefix = name[: -len("pack.mcmeta")]
                            if any(n.startswith(f"{root_prefix}assets/") for n in names):
                                pack_roots.add(root_prefix)
                    for root_prefix in sorted(pack_roots):
                        pack_name = f"{item.stem}{root_prefix.rstrip('/').replace('/', '_')}"
                        packs.append(PackSource(name=pack_name, source_path=item, root_prefix=root_prefix, is_zip=True))
            except zipfile.BadZipFile:
                continue
    return packs


def ensure_clean_assets_dir(output_assets: Path) -> None:
    if output_assets.exists():
        shutil.rmtree(output_assets)
    output_assets.mkdir(parents=True, exist_ok=True)


def zip_entry_mtime(info: zipfile.ZipInfo) -> float:
    dt = datetime.datetime(*info.date_time)
    return dt.timestamp()


def copy_file(src_path: Path, dest_path: Path, mtime: float) -> None:
    dest_path.parent.mkdir(parents=True, exist_ok=True)
    shutil.copy2(src_path, dest_path)
    os.utime(dest_path, (mtime, mtime))


def write_zip_file(zf: zipfile.ZipFile, info: zipfile.ZipInfo, dest_path: Path, mtime: float) -> None:
    dest_path.parent.mkdir(parents=True, exist_ok=True)
    with zf.open(info, "r") as src, open(dest_path, "wb") as dst:
        shutil.copyfileobj(src, dst)
    os.utime(dest_path, (mtime, mtime))


def merge_packs(packs: list[PackSource], output_assets: Path, report_path: Path) -> dict:
    conflicts: list[str] = []
    total_files = 0

    for pack in packs:
        if pack.is_zip:
            with zipfile.ZipFile(pack.source_path, "r") as zf:
                entries = [
                    info
                    for info in zf.infolist()
                    if not info.is_dir() and info.filename.startswith(f"{pack.root_prefix}assets/")
                ]
                entries.sort(key=lambda i: i.filename)
                for info in entries:
                    rel_path = info.filename[len(f"{pack.root_prefix}assets/") :]
                    if not rel_path:
                        continue
                    dest_path = output_assets / rel_path
                    src_mtime = zip_entry_mtime(info)
                    if dest_path.exists():
                        dest_mtime = dest_path.stat().st_mtime
                        if src_mtime > dest_mtime:
                            conflicts.append(
                                f"OVERWRITE: {rel_path} | {datetime.datetime.fromtimestamp(dest_mtime)} -> {datetime.datetime.fromtimestamp(src_mtime)} | {pack.source_path.name}"
                            )
                            write_zip_file(zf, info, dest_path, src_mtime)
                            total_files += 1
                    else:
                        write_zip_file(zf, info, dest_path, src_mtime)
                        total_files += 1
        else:
            assets_dir = pack.source_path / "assets"
            for root, _, files in os.walk(assets_dir):
                files.sort()
                for filename in files:
                    src_path = Path(root) / filename
                    rel_path = src_path.relative_to(assets_dir).as_posix()
                    dest_path = output_assets / rel_path
                    src_mtime = src_path.stat().st_mtime
                    if dest_path.exists():
                        dest_mtime = dest_path.stat().st_mtime
                        if src_mtime > dest_mtime:
                            conflicts.append(
                                f"OVERWRITE: {rel_path} | {datetime.datetime.fromtimestamp(dest_mtime)} -> {datetime.datetime.fromtimestamp(src_mtime)} | {pack.source_path.name}"
                            )
                            copy_file(src_path, dest_path, src_mtime)
                            total_files += 1
                    else:
                        copy_file(src_path, dest_path, src_mtime)
                        total_files += 1

    report_path.write_text("\n".join(conflicts), encoding="utf-8")
    return {
        "packs": len(packs),
        "files": total_files,
        "conflicts": len(conflicts),
    }


def ensure_default_font_reference(output_assets: Path) -> None:
    font_path = output_assets / "minecraft" / "font" / "default.json"
    if not font_path.is_file():
        return

    try:
        data = json.loads(font_path.read_text(encoding="utf-8"))
    except json.JSONDecodeError:
        print(f"Warning: invalid JSON in {font_path}", file=sys.stderr)
        return

    providers = data.get("providers")
    if not isinstance(providers, list):
        return

    providers = [
        p
        for p in providers
        if not (
            isinstance(p, dict)
            and p.get("type") == "reference"
            and p.get("id") in {"minecraft:default", "minecraft:include/default"}
        )
    ]
    providers.insert(0, {"type": "reference", "id": "minecraft:include/default"})

    data["providers"] = providers
    font_path.write_text(json.dumps(data, indent=4, ensure_ascii=True), encoding="utf-8")


def main() -> int:
    parser = argparse.ArgumentParser(description="Merge resource pack assets into a Fabric mod assets folder.")
    parser.add_argument("--packs-dir", required=True, help="Path to folder containing resource packs")
    parser.add_argument("--template-dir", required=True, help="Path to Fabric mod template")
    parser.add_argument("--report", default="merge_report.txt", help="Merge report output path")
    args = parser.parse_args()

    packs_dir = Path(args.packs_dir).resolve()
    template_dir = Path(args.template_dir).resolve()
    report_path = Path(args.report).resolve()

    output_assets = template_dir / "src" / "main" / "resources" / "assets"

    packs = discover_pack_dirs(packs_dir) + discover_pack_zips(packs_dir)
    packs.sort(key=lambda p: (p.source_path.as_posix().lower(), p.root_prefix))

    if not packs:
        print("No valid resource packs found.")
        return 1

    ensure_clean_assets_dir(output_assets)

    stats = merge_packs(packs, output_assets, report_path)
    ensure_default_font_reference(output_assets)

    print(f"Packs merged: {stats['packs']}")
    print(f"Total files merged: {stats['files']}")
    print(f"Conflicts: {stats['conflicts']}")
    print(f"Report: {report_path}")
    print(f"Assets output: {output_assets}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
