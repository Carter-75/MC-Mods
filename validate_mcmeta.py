import os
import json

def validate_mcmeta(root_dir):
    print(f"Scanning {root_dir}")
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if file == "pack.mcmeta":
                path = os.path.join(root, file)
                try:
                    with open(path, 'r', encoding='utf-8-sig') as f:
                        json.load(f)
                        # print(f"OK: {path}")
                except json.JSONDecodeError as e:
                    print(f"ERROR: {path}")
                    print(f"  {e}")
                except Exception as e:
                    print(f"ERROR: {path}")
                    print(f"  {e}")

if __name__ == "__main__":
    validate_mcmeta("c:/Users/carte/OneDrive/Desktop/Code/MC Mods/PacksMod/src/main/resources/resourcepacks")
