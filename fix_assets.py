import os
import json
import glob

VALID_ROTATIONS = [-45.0, -22.5, 0.0, 22.5, 45.0]

def snap_rotation(angle):
    closest = min(VALID_ROTATIONS, key=lambda x: abs(x - angle))
    return closest

def fix_rotations(root_dir):
    print(f"Scanning for invalid rotations in {root_dir}...")
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if not file.endswith(".json"):
                continue
            path = os.path.join(root, file)
            changed = False
            try:
                with open(path, 'r', encoding='utf-8') as f:
                    data = json.load(f)
                
                # Recursive search for 'rotation' keys
                def distinct_fix(node):
                    nonlocal changed
                    if isinstance(node, dict):
                        for k, v in node.items():
                            if k == "rotation":
                                if isinstance(v, dict): # Rotation object {origin, axis, angle}
                                    if "angle" in v and isinstance(v["angle"], (int, float)):
                                        angle = float(v["angle"])
                                        if angle not in VALID_ROTATIONS:
                                            new_angle = snap_rotation(angle)
                                            print(f"Fixing {path}: {angle} -> {new_angle}")
                                            v["angle"] = new_angle
                                            changed = True
                                    distinct_fix(v)
                                elif isinstance(v, (int, float)): # Direct rotation value? (Rare/Invalid context but check)
                                    pass 
                            else:
                                distinct_fix(v)
                    elif isinstance(node, list):
                        for item in node:
                            distinct_fix(item)

                distinct_fix(data)

                if changed:
                    with open(path, 'w', encoding='utf-8') as f:
                        json.dump(data, f, indent=4)
            except Exception as e:
                print(f"Failed to read/fix {path}: {e}")

def cleanup_garbage(root_dir):
    print(f"Cleaning garbage files in {root_dir}...")
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if " - Copy" in file or file.startswith("."):
                path = os.path.join(root, file)
                try:
                    os.remove(path)
                    print(f"Deleted: {path}")
                except Exception as e:
                    print(f"Failed to delete {path}: {e}")

if __name__ == "__main__":
    packs_dir = "c:/Users/carte/OneDrive/Desktop/Code/MC Mods/PacksMod/src/main/resources/resourcepacks"
    fix_rotations(os.path.join(packs_dir, "fresh_ores_and_ingots"))
    cleanup_garbage(packs_dir)
