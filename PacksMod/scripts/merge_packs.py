import json
import re
import shutil
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PACKS_DIR = ROOT
RESOURCES_DIR = ROOT / "src" / "main" / "resources"
RESOURCEPACKS_DIR = RESOURCES_DIR / "resourcepacks"
SHADERPACKS_DIR = RESOURCES_DIR / "shaderpacks"

PACKS = [
    {"key": "knight_armor", "file": "!§bKnightArmor.zip", "category": "armor"},
    {"key": "3d_sugar_cane", "file": "3D Sugar Cane.zip", "category": "resource"},
    {"key": "3d_muskets", "file": "3D-muskets-1.1.zip", "category": "resource"},
    {"key": "3d_mase", "file": "3dMase.zip", "category": "resource"},
    {"key": "a_good_place_sample_pack", "file": "A Good Place Sample Pack.zip", "category": "resource"},
    {"key": "alittle_axolotl", "file": "Alittle_Axolotl.zip", "category": "resource"},
    {"key": "animated_items", "file": "animated-items-1_21-1 - 1_4_2.zip", "category": "resource"},
    {"key": "beautiful_enchanted_books", "file": "Beautiful Enchanted Books - MC 1.21.1 - 8.0.0.zip", "category": "resource"},
    {"key": "better_3d_ladder", "file": "Better 3D Ladder.zip", "category": "resource"},
    {"key": "better_bows", "file": "Better Bows.zip", "category": "resource"},
    {"key": "better_trident", "file": "Better Trident v2.zip", "category": "resource"},
    {"key": "better_lanterns", "file": "Better+Lanterns+v1.2(mc-1.21).zip", "category": "resource"},
    {"key": "betterbetterx", "file": "BetterBetterX-v1.1-noStone.zip", "category": "resource"},
    {"key": "blockier_goat_horn", "file": "Blockier Goat Horn v1.1 f9-34.zip", "category": "resource"},
    {"key": "bsl_shader", "file": "BSL_v10.1.zip", "category": "shader"},
    {"key": "capitalized_font", "file": "Capitalized Font 1.20.x.zip", "category": "font"},
    {"key": "connected_paths", "file": "Connected-Paths 1.14-1.21.8 v2.0.zip", "category": "resource"},
    {"key": "cubic_leaves", "file": "Cubic Leaves 2.3 (performance).zip", "category": "resource"},
    {"key": "door_tweaks", "file": "DoorTweaks-v3.5.zip", "category": "resource"},
    {"key": "duskfall_ui", "file": "DuskfallUI-1.0.2.zip", "category": "resource"},
    {"key": "enchantment_outline", "file": "Enchantment-Outline1.9.9.zip", "category": "resource"},
    {"key": "everything_animated", "file": "Everything Animated! 0.3.10.zip", "category": "resource"},
    {"key": "fancy_crops", "file": "Fancy Crops v1.3.zip", "category": "resource"},
    {"key": "fire_rekindled", "file": "Fire_Rekindled.zip", "category": "resource"},
    {"key": "fresh_ores_and_ingots", "file": "Fresh Ores and Ingots 1.2.zip", "category": "resource"},
    {"key": "icons_effects", "file": "Icons - Effects v.1.1.zip", "category": "resource"},
    {"key": "icons_enchantments", "file": "Icons - Enchantments v.1.1.zip", "category": "resource"},
    {"key": "icons_tooltips", "file": "Icons - Tooltips v.1.1.zip", "category": "resource"},
    {"key": "luminous", "file": "Luminous1.4.zip", "category": "resource"},
    {"key": "mb_3d_items", "file": "MB-3D Items Pack 1.6.0.zip", "category": "resource"},
    {"key": "mickey_joes_noteblocks", "file": "MickeyJoesNoteBlocks.zip", "category": "resource"},
    {"key": "mossy_better_dirt", "file": "Mossy's_Better_Dirt_1.0.zip", "category": "resource"},
    {"key": "optimum_realism", "file": "Optimum Realism R3.5.0 64x [Kappa, BSL,etc].zip", "category": "resource"},
    {"key": "os_colorful_grasses", "file": "Os' Colorful Grasses (Mix).zip", "category": "resource"},
    {"key": "recolourful_containers", "file": "Recolourful Containers 3.0.1 (1.19.4+).zip", "category": "resource"},
    {"key": "rekindled_ctm", "file": "Rekindled_CTM.zip", "category": "resource"},
    {"key": "serified_font", "file": "Serified Font v1.2.zip", "category": "font"},
    {"key": "simple_3d_chain", "file": "simple-3d-chain.zip", "category": "resource"},
    {"key": "simple_3d_iron_bars", "file": "simple-3d-iron-bars.zip", "category": "resource"},
    {"key": "sun_moon_circular", "file": "Sun and Moon Circular.zip", "category": "resource"},
    {"key": "traben_3d_armor", "file": "Traben's 3D Armor - 1.0.1.zip", "category": "armor"},
    {"key": "trabens_3d_arrows", "file": "trabens-3d-arrows-1.1.zip", "category": "resource"},
    {"key": "undopia_3d_rails", "file": "Undopia_3D_Rails_1.21_v.1.0.zip", "category": "resource"},
    {"key": "redstone_torch", "file": "§c1.21.2 Redstone Torch§r.zip", "category": "resource"},
    {"key": "torches_reimagined", "file": "§eTorches§8-§eReimagined§0_§8[v1.7.2]§0.zip", "category": "resource"},
]

PACK_FORMAT_FALLBACK = 34
INVALID_CHARS = re.compile(r"[<>:\\|?*\x00-\x1f]")


def ensure_dir(path: Path) -> None:
    path.mkdir(parents=True, exist_ok=True)


def clean_dir(path: Path) -> None:
    if path.exists():
        shutil.rmtree(path)
    path.mkdir(parents=True, exist_ok=True)


def sanitize_zip_name(name: str) -> str:
    if not name:
        return ""
    parts = []
    for part in name.replace("\\", "/").split("/"):
        if not part or part in {".", ".."}:
            continue
        safe = INVALID_CHARS.sub("_", part)
        safe = safe.rstrip(". ")
        if not safe:
            continue
        parts.append(safe)
    return "/".join(parts)


def locate_pack_root(extracted_dir: Path) -> Path:
    if (extracted_dir / "pack.mcmeta").exists():
        return extracted_dir
    for nested in extracted_dir.rglob("pack.mcmeta"):
        return nested.parent
    return extracted_dir


def load_pack_format(root: Path) -> int:
    meta = root / "pack.mcmeta"
    if not meta.exists():
        return PACK_FORMAT_FALLBACK
    try:
        data = json.loads(meta.read_text(encoding="utf-8"))
        return int(data.get("pack", {}).get("pack_format", PACK_FORMAT_FALLBACK))
    except Exception:
        return PACK_FORMAT_FALLBACK


def ensure_pack_meta(root: Path, display_name: str, pack_format: int) -> None:
    meta = root / "pack.mcmeta"
    if meta.exists():
        return
    meta.write_text(
        json.dumps({"pack": {"pack_format": pack_format, "description": display_name}}, indent=2),
        encoding="utf-8",
    )


def extract_zip(zip_path: Path, target_dir: Path, display_name: str) -> None:
    temp_dir = target_dir.parent / f"_{target_dir.name}_tmp"
    clean_dir(temp_dir)

    with zipfile.ZipFile(zip_path, "r") as zf:
        for info in zf.infolist():
            safe_name = sanitize_zip_name(info.filename)
            if not safe_name:
                continue
            dest = temp_dir / safe_name
            if info.is_dir():
                dest.mkdir(parents=True, exist_ok=True)
                continue
            dest.parent.mkdir(parents=True, exist_ok=True)
            with zf.open(info, "r") as source, open(dest, "wb") as target:
                shutil.copyfileobj(source, target)

    root = locate_pack_root(temp_dir)
    pack_format = load_pack_format(root)

    clean_dir(target_dir)
    for item in root.iterdir():
        dest = target_dir / item.name
        if item.is_dir():
            shutil.copytree(item, dest)
        else:
            shutil.copy2(item, dest)

    ensure_pack_meta(target_dir, display_name, pack_format)
    shutil.rmtree(temp_dir)


def main() -> None:
    ensure_dir(RESOURCEPACKS_DIR)
    ensure_dir(SHADERPACKS_DIR)

    for pack in PACKS:
        zip_path = PACKS_DIR / pack["file"]
        if not zip_path.exists():
            raise SystemExit(f"Missing zip: {zip_path}")

        display_name = pack["file"].rsplit(".zip", 1)[0]
        if pack["category"] == "shader":
            target = SHADERPACKS_DIR / display_name
            extract_zip(zip_path, target, display_name)
        else:
            target = RESOURCEPACKS_DIR / pack["key"]
            extract_zip(zip_path, target, display_name)


if __name__ == "__main__":
    main()
