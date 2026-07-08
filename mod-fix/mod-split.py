import re
import os
import glob
import subprocess

# Configuration
OLLAMA_MODEL = 'llama3.1'

def call_ollama(prompt):
    try:
        result = subprocess.run(
            ['ollama', 'run', OLLAMA_MODEL],
            input=prompt,
            capture_output=True, text=True, encoding='utf-8',
            check=True, timeout=180 
        )
        return result.stdout.strip()
    except Exception as e:
        print(f"  AI Error: {e}")
        return None

def filter_libraries_for_category(category, mods, all_libraries):
    if not mods: return []
    if not all_libraries: return []

    # Extract clean titles for the prompt
    mod_names = [re.sub(r'\[|\]', '', m[0]).strip() for m in mods]
    lib_names = [re.sub(r'\[|\]', '', l[0]).strip() for l in all_libraries]
    
    prompt = (
        f"You are an expert Minecraft mod librarian. Your task is to identify required dependencies.\n"
        f"I have a list of Minecraft Mods in the '{category}' category and a list of available Library/API mods.\n"
        f"Please identify which of the Library mods are likely required dependencies for the Mods in this category.\n\n"
        f"Mods in {category}:\n" + "\n".join(mod_names) + "\n\n"
        f"Available Libraries:\n" + "\n".join(lib_names) + "\n\n"
        f"Task: Return a list of the Library names from the 'Available Libraries' list that are likely used by the Mods above.\n"
        f"Include common dependencies (like Fabric API, Cloth Config, Architectury, GeckoLib) if they are generally useful or required.\n"
        f"If you are unsure if a library is needed, INCLUDE it to be safe.\n"
        f"Return ONLY the names of the libraries, one per line. Do not include explanations."
    )
    
    response = call_ollama(prompt)
    if not response:
        print("    AI failed to filter. Including all libraries as fallback.")
        return all_libraries

    filtered_libs = []
    response_lines = [line.strip().lower() for line in response.split('\n') if line.strip()]
    
    for lib in all_libraries:
        lib_title = re.sub(r'\[|\]', '', lib[0]).strip().lower()
        
        # Check if this lib title matches any line in the response
        # We check if the lib_title is contained in a response line or vice versa
        is_match = False
        for resp_line in response_lines:
            # Remove bullet points if AI added them
            clean_resp = re.sub(r'^[-*]\s*', '', resp_line)
            if clean_resp == lib_title or clean_resp in lib_title or lib_title in clean_resp:
                is_match = True
                break
        
        if is_match:
            filtered_libs.append(lib)
            
    print(f"    Selected {len(filtered_libs)}/{len(all_libraries)} libraries for {category}.")
    return filtered_libs

def split_modinfo_by_category(input_file):
    if not os.path.exists(input_file):
        print(f"Error: File '{input_file}' not found.")
        return

    with open(input_file, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    categories = {}
    current_category = "Uncategorized"
    current_mod = []
    
    # Regex for category header: === Name ===
    cat_pattern = re.compile(r'^===\s*(.*?)\s*===$')
    # Regex for mod title: [Name]
    mod_pattern = re.compile(r'^\[(.*?)\]$')

    # Initialize
    categories[current_category] = []

    for line in lines:
        line = line.strip()
        if not line:
            continue
            
        cat_match = cat_pattern.match(line)
        mod_match = mod_pattern.match(line)
        
        if cat_match:
            # New Category found
            # Save previous mod if exists
            if current_mod:
                categories[current_category].append(current_mod)
                current_mod = []
            
            # Extract clean category name (remove stats in parens if present)
            raw_cat = cat_match.group(1)
            current_category = raw_cat.split(' (')[0].strip()
            
            if current_category not in categories:
                categories[current_category] = []
                
        elif mod_match:
            # New Mod found
            # Save previous mod if exists
            if current_mod:
                categories[current_category].append(current_mod)
            
            # Start new mod
            current_mod = [line] 
        else:
            # Content of the mod
            if current_mod:
                current_mod.append(line)

    # Append last mod
    if current_mod:
        categories[current_category].append(current_mod)

    # --- NEW: Collect Global Libraries & Mod Menu ---
    global_libraries = []
    seen_libs = set()
    mod_menu_entry = None
    
    def is_real_mod_menu(mod_lines):
        if not mod_lines: return False
        
        # Check Title
        title = mod_lines[0].lower()
        if "[mod menu]" in title:
            return True
            
        # Check File
        for line in mod_lines:
            if line.startswith("File:"):
                filename = line.split("File:")[1].strip().lower()
                if "modmenu" in filename and ".jar" in filename:
                    # Exclude known addons/libs that share the name
                    if "badges" in filename:
                        return False
                    # Ensure it looks like the main mod (usually modmenu-X.X.X.jar or modmenu-vX.X.X.jar)
                    # We check if it starts with modmenu- and follows with a number or v+number
                    if re.search(r'modmenu-v?\d', filename):
                        return True
        return False

    for cat, mods in categories.items():
        for mod_lines in mods:
            if is_real_mod_menu(mod_lines):
                mod_menu_entry = mod_lines
                continue # Don't add to libraries or normal mods yet

            is_lib = any("Type: Library" in line for line in mod_lines)
            if is_lib:
                # Use title as unique key
                title = mod_lines[0]
                if title not in seen_libs:
                    global_libraries.append(mod_lines)
                    seen_libs.add(title)
    
    print(f"Found {len(global_libraries)} unique libraries to distribute.")
    if mod_menu_entry:
        print("Found Mod Menu. Will distribute to all categories.")

    # Clean up old split files first
    for f in glob.glob("mods_*.txt"):
        os.remove(f)

    # Output files
    for cat, mods in categories.items():
        if not mods:
            continue
            
        # Strategy:
        # 1. Identify mods in this category that are NOT libraries and NOT Mod Menu.
        # 2. Filter libraries relevant to this category.
        # 3. Combine.
        
        non_lib_mods = []
        for m in mods:
            if is_real_mod_menu(m):
                continue # Skip Mod Menu (handled separately)
            
            if not any("Type: Library" in line for line in m):
                non_lib_mods.append(m)
        
        # Filter libraries
        relevant_libraries = []
        # User requested ALL libraries in ALL categories to ensure stability.
        # "but also all libriries i mean the cureforge/modridth hould tell u them that eay why u priotiing anything"
        # This implies we should not try to be smart and filter them, just give them all.
        relevant_libraries = global_libraries
        print(f"  Including all {len(relevant_libraries)} libraries for {cat} (User Request).")
        
        final_mods = relevant_libraries + non_lib_mods
        if mod_menu_entry:
            final_mods.append(mod_menu_entry)
        
        # Clean category name for filename
        # Replace non-alphanumeric with underscore, then collapse multiple underscores
        safe_cat = re.sub(r'[^a-zA-Z0-9]', '_', cat)
        safe_cat = re.sub(r'_+', '_', safe_cat).strip('_')
        
        # Determine counts
        total_count = len(final_mods)
        lib_count = len(relevant_libraries)
        mod_count = len(non_lib_mods)
        
        # Sort: Libraries first (alphabetical), then Mods (alphabetical)
        
        def get_title(m_lines):
            return m_lines[0] if m_lines else ""
            
        relevant_libraries.sort(key=get_title)
        non_lib_mods.sort(key=get_title)
        
        # Include counts in filename: Category_Mods_Libs_Total
        output_filename = f"mods_{safe_cat}_{mod_count}_{lib_count}_{total_count}.txt"
        
        with open(output_filename, 'w', encoding='utf-8') as f:
            f.write(f"=== {cat} ===\n\n")
            
            # Write Libraries (No Numbering)
            for mod_lines in relevant_libraries:
                # Ensure title is clean
                title_line = mod_lines[0]
                clean_title = re.sub(r'^\d+\.\s*', '', title_line)
                
                f.write(f"{clean_title}\n")
                for content_line in mod_lines[1:]:
                    f.write(f"{content_line}\n")
                f.write("\n")
            
            # Write Mod Menu (Special Formatting)
            if mod_menu_entry:
                title_line = mod_menu_entry[0]
                clean_title = re.sub(r'^\d+\.\s*', '', title_line)
                f.write(f"* {clean_title}\n") # Special bullet for Mod Menu
                for content_line in mod_menu_entry[1:]:
                    f.write(f"{content_line}\n")
                f.write("\n")

            # Write Mods (Numbered 1..N)
            for i, mod_lines in enumerate(non_lib_mods, 1):
                title_line = mod_lines[0]
                clean_title = re.sub(r'^\d+\.\s*', '', title_line)
                
                f.write(f"{i}. {clean_title}\n")
                for content_line in mod_lines[1:]:
                    f.write(f"{content_line}\n")
                f.write("\n")
        
        print(f"Created {output_filename} with {len(final_mods)} entries.")

if __name__ == "__main__":
    # Default to modinfo_advanced.txt
    if os.path.exists("modinfo_advanced.txt"):
        split_modinfo_by_category("modinfo_advanced.txt")
    else:
        print("Error: modinfo_advanced.txt not found. Please run advanced_process_mods.py first.")
