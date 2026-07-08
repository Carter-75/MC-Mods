import os
import shutil
import glob

def organize_mods():
    source_mods_dir = "mods"
    target_base_dir = "mod-split"
    
    # Ensure target directory exists and is clean-ish
    if os.path.exists(target_base_dir):
        # Wipe the directory to remove old/duplicate folders
        print(f"Cleaning up {target_base_dir}...")
        shutil.rmtree(target_base_dir)
    
    os.makedirs(target_base_dir)
        
    # Find text files
    txt_files = glob.glob("mods_*.txt")
    
    if not txt_files:
        print("No category text files found in current directory.")
        return

    print(f"Found {len(txt_files)} category files. Organizing...")

    for txt_file in txt_files:
        # Parse filename: mods_{Category}_{ModCount}_{LibCount}_{TotalCount}.txt
        parts = txt_file.replace('.txt', '').split('_')
        if len(parts) < 5:
            print(f"Skipping malformed file: {txt_file}")
            continue
            
        # Reconstruct category name (handles underscores in category name)
        category_name_only = "_".join(parts[1:-3])
        counts = "_".join(parts[-3:])
        
        # Folder Name: Category_ModCount_LibCount_TotalCount
        folder_name = f"{category_name_only}_{counts}"
        
        # Setup directories
        cat_dir = os.path.join(target_base_dir, folder_name)
        mods_dest_dir = os.path.join(cat_dir, "mods")
        
        if not os.path.exists(mods_dest_dir):
            os.makedirs(mods_dest_dir)
            
        # Move text file
        dest_txt_path = os.path.join(cat_dir, txt_file)
        if os.path.exists(dest_txt_path):
            os.remove(dest_txt_path) # Overwrite existing
        shutil.move(txt_file, dest_txt_path)
        
        # Read jars from text file and determine type/numbering
        # We need to parse the file structure to know if it's a library or a numbered mod.
        # Structure:
        # [Lib Title]
        # File: lib.jar
        # ...
        # 1. [Mod Title]
        # File: mod.jar
        
        items_to_copy = [] # List of dicts: {'file': 'x.jar', 'is_lib': True/False, 'number': 1}
        
        with open(dest_txt_path, 'r', encoding='utf-8') as f:
            lines = f.readlines()
            
        current_number = None
        is_lib = False
        
        for line in lines:
            line = line.strip()
            if not line: continue
            
            # Check for Title line
            # Mod: "1. [Title]"
            # Lib: "[Title]"
            # Mod Menu: "* [Title]"
            import re
            mod_match = re.match(r'^(\d+)\.\s*\[.*\]$', line)
            lib_match = re.match(r'^\[.*\]$', line)
            mod_menu_match = re.match(r'^\*\s*\[.*\]$', line)
            
            if mod_match:
                current_number = int(mod_match.group(1))
                is_lib = False
                is_mod_menu = False
            elif mod_menu_match:
                current_number = None
                is_lib = False
                is_mod_menu = True
            elif lib_match:
                current_number = None
                is_lib = True
                is_mod_menu = False
            elif line.startswith("File: "):
                filename = line.replace("File: ", "").strip()
                items_to_copy.append({
                    'file': filename,
                    'is_lib': is_lib,
                    'is_mod_menu': is_mod_menu,
                    'number': current_number
                })

        # Copy files
        if os.path.exists(source_mods_dir):
            count = 0
            for item in items_to_copy:
                jar = item['file']
                src = os.path.join(source_mods_dir, jar)
                
                # Determine destination filename
                clean_jar_name = re.sub(r'^\d+\.\s*', '', jar)
                
                if item['is_mod_menu']:
                    # Mod Menu: Prefix with + to sort at top but not be a library
                    dst_filename = f"+{clean_jar_name}"
                elif item['is_lib']:
                    # Library: Prefix with underscore
                    dst_filename = f"_{clean_jar_name}"
                else:
                    # Mod: Prefix with number
                    num = item['number']
                    dst_filename = f"{num}. {clean_jar_name}"
                
                dst = os.path.join(mods_dest_dir, dst_filename)
                
                if os.path.exists(src):
                    shutil.copy2(src, dst)
                    count += 1
                else:
                    print(f"  [Missing] {jar} not found in source mods folder.")
            print(f"  Processed {folder_name}: Copied {count}/{len(items_to_copy)} mods.")
        else:
            print(f"  Processed {folder_name}: Text file moved (No source 'mods' folder found).")

if __name__ == "__main__":
    organize_mods()
