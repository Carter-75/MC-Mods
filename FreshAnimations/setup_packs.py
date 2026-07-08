import zipfile
import os
from pathlib import Path

def setup_packs():
    base_dir = Path.cwd()
    resources_dir = base_dir / "src" / "main" / "resources"
    packs_dir = resources_dir / "resourcepacks"
    packs_dir.mkdir(parents=True, exist_ok=True)

    # Find zips
    for file in base_dir.glob("FA+*.zip"):
        pack_name = file.stem.replace("+", "_").replace("-", "_").replace(".", "_") # Clean name
        # e.g. FA+Details-v2.1 -> FA_Details_v2_1
        
        target_dir = packs_dir / pack_name
        if target_dir.exists():
            print(f"Skipping {pack_name}, already exists")
            continue
            
        print(f"Extracting {file.name} to {target_dir}")
        with zipfile.ZipFile(file, 'r') as zf:
            zf.extractall(target_dir)

if __name__ == "__main__":
    setup_packs()
