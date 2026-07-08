import os
import glob
import subprocess
import sys
import re

# Configuration
OLLAMA_MODEL = 'llama3.1' 

def call_ollama(prompt):
    try:
        # Increased timeout for analysis as it processes a list
        # Use input=prompt to avoid command line length limits (WinError 206)
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

def parse_mod_file(filepath):
    mods = []
    
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()
        
    # Split by double newline to get blocks
    blocks = content.split('\n\n')
    
    for block in blocks:
        lines = block.strip().split('\n')
        if not lines: continue
        
        # Skip category header
        if lines[0].startswith("==="):
            continue
            
        mod_data = {}
        # First line is title (e.g. "1. [Title]" or "[Title]")
        # Remove numbering "1. " and brackets
        raw_title = lines[0]
        title = re.sub(r'^\d+\.\s*', '', raw_title).strip('[]')
        mod_data['title'] = title
        
        for line in lines[1:]:
            if line.startswith("Type:"):
                mod_data['type'] = line.replace("Type:", "").strip()
            elif line.startswith("Summary:"):
                mod_data['summary'] = line.replace("Summary:", "").strip()
                
        if 'title' in mod_data:
            mods.append(mod_data)
            
    return mods

def analyze_category(folder_path):
    # Find the mods_*.txt file
    txt_files = glob.glob(os.path.join(folder_path, "mods_*.txt"))
    if not txt_files:
        return
        
    mod_file = txt_files[0]
    mods = parse_mod_file(mod_file)
    
    # Filter out libraries - we only want to compare gameplay mods
    gameplay_mods = [m for m in mods if m.get('type') == 'Mod']
    
    if len(gameplay_mods) < 2:
        print(f"  Skipping {os.path.basename(folder_path)} (Not enough mods to compare).")
        return

    print(f"  Analyzing {len(gameplay_mods)} mods in {os.path.basename(folder_path)}...")
    
    # Prepare prompt
    mod_list_str = ""
    for m in gameplay_mods:
        mod_list_str += f"- {m['title']}: {m.get('summary', 'No summary')}\n"
        
    prompt = (
        f"You are an expert Minecraft modpack developer. Your task is to identify redundant or conflicting mods.\n"
        f"Analyze the following list of Minecraft mods from the '{os.path.basename(folder_path)}' category.\n"
        f"Identify any mods that provide the SAME core functionality (e.g., two minimaps, two JEI addons that do the same thing, two performance mods that conflict).\n"
        f"Group them together and explain the overlap.\n"
        f"If a mod is unique or compatible with others, do NOT list it.\n"
        f"If no redundant mods are found, simply say 'No similar mods found'.\n\n"
        f"Mod List:\n{mod_list_str}\n\n"
        f"Output Format:\n"
        f"Group 1:\n- Mod A\n- Mod B\nReason: [Explain the overlap]\n\n"
    )
    
    analysis = call_ollama(prompt)
    
    if analysis:
        output_path = os.path.join(folder_path, "similar_mods.txt")
        with open(output_path, 'w', encoding='utf-8') as f:
            f.write(analysis)
        print(f"  Saved analysis to {output_path}")

def main():
    print("--- Step 4: Analyzing Similar Mods ---")
    
    force = "--force" in sys.argv
    
    base_dir = "mod-split"
    if not os.path.exists(base_dir):
        print("mod-split folder not found.")
        return
        
    # Iterate over category folders
    for item in os.listdir(base_dir):
        item_path = os.path.join(base_dir, item)
        if os.path.isdir(item_path):
            # Check if we should skip
            if not force and os.path.exists(os.path.join(item_path, "similar_mods.txt")):
                print(f"  Skipping {item} (Analysis exists).")
                continue
                
            analyze_category(item_path)
            
    print("--- Step 4 Completed ---")

if __name__ == "__main__":
    main()
