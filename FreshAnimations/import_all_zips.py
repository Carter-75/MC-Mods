import zipfile
import os
import shutil
from pathlib import Path

def process_zips():
    # Define paths
    root_dir = Path(r"c:/Users/carte/OneDrive/Desktop/Code/MC Mods")
    fa_resources_dir = root_dir / "FreshAnimations/src/main/resources/resourcepacks"
    fa_resources_dir.mkdir(parents=True, exist_ok=True)

    # Walk through directories
    # Logic: Search root_dir and FA dir. 
    # NOTE: Be careful not to recursively process existing zips inside "build" folders if we only want source zips.
    # The user said "root directprry mc mods".
    
    dirs_to_search = [root_dir, root_dir / "FreshAnimations"]
    
    for search_dir in dirs_to_search:
        if not search_dir.exists():
            continue
            
        print(f"Scanning {search_dir}...")
        # Only look for immediate children zips to avoid scanning massive build/gradle folders deep down
        for file_path in search_dir.glob("*.zip"):
             print(f"Found: {file_path.name}")
             
             # Clean name for folder
             clean_name = file_path.stem.replace("+", "_").replace("-", "_").replace(" ", "_")
             target_dir = fa_resources_dir / clean_name
             
             if target_dir.exists():
                 print(f"  Target {target_dir} exists. Skipping extraction.")
             else:
                 print(f"  Extracting to {target_dir}...")
                 try:
                     with zipfile.ZipFile(file_path, 'r') as zf:
                         # Filter out unwanted MacOS files if present
                         members = [m for m in zf.namelist() if not m.startswith('__MACOSX')]
                         zf.extractall(target_dir, members)
                     print("  Extraction complete.")
                 except zipfile.BadZipFile:
                     print("  ERROR: Bad Zip File. Skipping.")
                     continue

             # Delete original? User said "remove the xzips bc i want need them"
             print(f"  Deleting {file_path}...")
             try:
                os.remove(file_path)
             except OSError as e:
                print(f"  Error deleting: {e}")

if __name__ == "__main__":
    process_zips()
