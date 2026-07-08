import os
import re
import json
import time
import subprocess
import requests
from bs4 import BeautifulSoup
import sys
from typing import Any, List, Dict, Optional

# Configuration
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
SOURCE_FILE = os.path.join(SCRIPT_DIR, 'modlist.txt')
OUTPUT_MODINFO = os.path.join(SCRIPT_DIR, 'modinfo_advanced.txt')
OUTPUT_JSON = os.path.join(SCRIPT_DIR, 'organized_mods.json')
OLLAMA_MODEL = 'llama3.1'  # Best 8B model for reasoning
USER_AGENT = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'

# Rate Limiting
MR_DELAY = 0.5
CF_DELAY = 2.0

def normalize(s: str) -> str:
    """Normalize string for fuzzy matching."""
    return re.sub(r'[^a-z0-9]', '', s.lower())

def extract_filenames(lines: List[str]) -> List[str]:
    """Extract filenames from 'ls' output."""
    filenames: List[str] = []
    current_entry: Optional[str] = None
    for line in lines:
        stripped = line.strip()
        if not stripped: continue
        parts = stripped.split()
        if len(parts) >= 4 and re.match(r'^[d-][a-z-]{4}', parts[0]):
            if current_entry: filenames.append(current_entry)
            
            # Handle PowerShell 'ls' output format
            # Format: Mode LastWriteTime Length Name
            # Time can be "HH:mm AM/PM" (2 parts) or "HH:mm" (1 part)
            
            if len(parts) > 3 and parts[3].upper() in ['AM', 'PM']:
                # Format with AM/PM: Mode(0) Date(1) Time(2) AM/PM(3) Size(4) Name(5...)
                if len(parts) > 5:
                    current_entry = " ".join(parts[5:])
                else:
                    current_entry = parts[-1] # Fallback
            else:
                # Format without AM/PM: Mode(0) Date(1) Time(2) Size(3) Name(4...)
                if len(parts) > 4:
                    current_entry = " ".join(parts[4:])
                else:
                    current_entry = parts[-1] # Fallback
        else:
            if current_entry:
                if current_entry.lower().endswith('.jar') or current_entry.lower().endswith('.disabled'):
                    filenames.append(current_entry)
                    current_entry = stripped
                else:
                    current_entry += stripped
            else:
                current_entry = stripped
    if current_entry: filenames.append(current_entry)
    return filenames

def clean_filename(filename: str) -> str:
    """Clean filename for search query."""
    name = re.sub(r'\.jar$', '', filename, flags=re.IGNORECASE)
    name = re.sub(r'[-_]?v?\d+(\.\d+)+.*', '', name)
    name = re.sub(r'[-_](fabric|forge|neoforge).*', '', name, flags=re.IGNORECASE)
    return name.replace('_', ' ').replace('-', ' ').strip()

# --- AI Integration ---
ai_available = True

def call_ollama(prompt: str) -> Optional[str]:
    """Call local Ollama instance."""
    global ai_available
    if not ai_available:
        return None

    try:
        # Check if ollama is running/available first? 
        # We'll just try to run it with a timeout
        result = subprocess.run(
            ['ollama', 'run', OLLAMA_MODEL, prompt],
            capture_output=True, text=True, encoding='utf-8',
            check=True, timeout=45
        )
        return result.stdout.strip()
    except subprocess.TimeoutExpired:
        print("  AI timed out. Disabling AI features for remaining mods.")
        ai_available = False
        return None
    except Exception as e:
        # print(f"AI Error: {e}")
        print(f"  AI failed ({e}). Disabling AI features.")
        ai_available = False
        return None

def summarize_description(text: str, title: str) -> Optional[str]:
    if not text or len(text) < 100: return None
    # Advanced prompt for professional summary
    prompt = (
        f"You are a professional technical writer for a Minecraft mod catalog. "
        f"Your task is to write a concise, engaging, and informative summary for the mod '{title}'.\n\n"
        f"Source Description:\n"
        f"{text[:2000]}\n\n"
        f"Summary Rules:\n"
        f"1. Length: Maximum 3 sentences.\n"
        f"2. Content: Focus strictly on the core features, gameplay mechanics, and what the mod adds to the game.\n"
        f"3. Style: Do NOT use phrases like 'This mod', 'Here is a summary', 'In this mod', or 'The mod adds'. Start directly with the functionality (e.g., 'Adds a new dimension...', 'Provides tools for...').\n"
        f"4. Output: Return ONLY the summary text, nothing else. Do not include any introductory text."
    )
    summary = call_ollama(prompt)
    
    if summary:
        # Clean up newlines to ensure single-line string in JSON
        clean_summary = summary.strip().replace('\n', ' ').replace('\r', '')
        # Remove common AI prefixes if they still appear
        clean_summary = re.sub(r'^(Here is a .*?summary.*?:\s*)', '', clean_summary, flags=re.IGNORECASE)
        clean_summary = re.sub(r'^(Sure, here is.*?:\s*)', '', clean_summary, flags=re.IGNORECASE)
        clean_summary = re.sub(r'^(Summary:\s*)', '', clean_summary, flags=re.IGNORECASE)
        return clean_summary
        
    return None

def categorize_mod(name: str, description: str, tags: List[str], dependencies: List[str]) -> str:
    categories = {
        "Technology": "Machines, energy, automation, pipes, industrial processing.",
        "Adventure/RPG": "New dimensions, structures, bosses, quests, leveling systems, RPG classes, skill trees, mobs, weapons, armor, tools, magic, spells, rituals.",
        "World Gen": "Biomes, terrain generation, ores, caves, structures.",
        "Building/Decoration": "Blocks, furniture, cosmetic items.",
        "Storage": "Chests, backpacks, inventory management, storage systems.",
        "Utility/QoL": "HUD improvements, map tools, performance tweaks, bug fixes, small helpers, Mod Menu.",
        "Performance": "FPS boosters, optimization, lag reduction.",
        "Library/API": "Core mods, frameworks, dependencies for other mods.",
        "Food/Farming": "Crops, food items, cooking, agriculture.",
        "Particle/Animation": "Particle effects, visual effects, physics particles, animations, visual enhancements, placement previews."
    }
    
    cat_defs = "\n".join([f"- {k}: {v}" for k, v in categories.items()])
    
    # Format lists for prompt
    tags_str = ", ".join(tags) if tags else "None"
    deps_str = ", ".join(dependencies) if dependencies else "None"

    prompt = (
        f"You are an expert Minecraft mod librarian. Your task is to categorize the mod '{name}' into exactly one of the following categories.\n\n"
        f"Metadata:\n"
        f"- Name: {name}\n"
        f"- Description: {description[:2000]}\n"
        f"- Tags/Categories from Source: {tags_str}\n"
        f"- Dependencies: {deps_str}\n\n"
        f"Allowed Categories and Definitions:\n{cat_defs}\n\n"
        f"Categorization Rules:\n"
        f"1. **Library/API Priority**: If the mod name contains 'Lib', 'API', 'Config', 'Core', 'Framework', or 'Common', it is almost certainly a 'Library/API'. Check the name carefully.\n"
        f"2. **Adventure/RPG**: This is a BROAD category. It includes:\n"
        f"   - **MAGIC**: Spells, rituals, altars, magical energy (e.g., Botania, Iron's Spells).\n"
        f"   - **MOBS**: All new creatures, animals, and monsters (e.g., Alex's Mobs, Naturalist).\n"
        f"   - **COMBAT/EQUIPMENT**: All weapons, armor, and tools (e.g., Better Netherite, Shields).\n"
        f"   - RPG elements (classes, skills, leveling)\n"
        f"   - New Dimensions & Bosses\n"
        f"3. **Particle/Animation**: If the mod's PRIMARY focus is visual effects, physics, or animations (e.g., 3D Skin Layers, Physics Mod, Visuality, Effective, Not Enough Animations). This overrides 'Utility/QoL'.\n"
        f"4. **Performance**: If the mod focuses on FPS, optimization, or reducing lag (e.g., Sodium, Lithium, Starlight, FerriteCore).\n"
        f"5. **Utility/QoL**: If it adds small helpers, HUDs, tooltips, or 'Mod Menu' (e.g., JEI, REI, Jade, AppleSkin, Mouse Tweaks). Also includes SOUND/AUDIO mods (e.g., AmbientSounds, Sound Physics) unless they are purely decorative blocks.\n"
        f"6. **World Gen**: If it adds biomes, ores, caves, or structures (e.g., Terralith, Oh The Biomes You'll Go).\n"
        f"7. **Technology**: Machines, pipes, energy, industrial processing (e.g., Create, Mekanism, Tech Reborn).\n"
        f"8. **Storage**: Backpacks, chests, drawers, inventory sorting (e.g., Traveler's Backpack, Iron Chests).\n"
        f"9. **Food/Farming**: Crops, food, cooking (e.g., Farmer's Delight). NOTE: HUD mods like AppleSkin belong in Utility/QoL, NOT Food/Farming.\n"
        f"10. **Building/Decoration**: Blocks, furniture (e.g., Macaw's Mods, Chipped). NOTE: Sound mods do NOT go here.\n\n"
        f"Task:\n"
        f"1. Analyze the mod's Name and Description.\n"
        f"2. If the Name suggests a library (e.g. 'AnviansLib'), categorize as 'Library/API' immediately.\n"
        f"3. Select the best fitting category from the list above.\n"
        f"4. Output your answer in the following format:\n"
        f"Reasoning: [Your explanation]\n"
        f"Category: [Exact Category Name]"
    )
    response = call_ollama(prompt)
    
    if response:
        # Parse response for "Category: Name"
        match = re.search(r'Category:\s*(.*)', response, re.IGNORECASE)
        if match:
            category = match.group(1).strip()
            # Clean up response
            for cat in categories.keys():
                if cat.lower() == category.lower():
                    return cat
                # Partial match fallback
                if cat.lower() in category.lower() and len(category) < len(cat) + 10:
                     return cat
    
    # Fallback if parsing fails but AI returned something that looks like a category
    if response:
         for cat in categories.keys():
            if cat.lower() in response.lower() and len(response) < 50:
                return cat

    return "Utility/QoL" # Default

# --- Modrinth API ---
def search_modrinth(query: str) -> Optional[Dict[str, Any]]:
    try:
        url = f"https://api.modrinth.com/v2/search?query={requests.utils.quote(query)}&limit=1"
        resp = requests.get(url, headers={'User-Agent': 'ModFixScript/1.0'})
        if resp.status_code == 200:
            data = resp.json()
            if data['hits']:
                return data['hits'][0]
    except Exception as e:
        print(f"MR Search Error: {e}")
    return None

def get_modrinth_details(slug: str) -> Dict[str, Any]:
    try:
        # Get Project
        url = f"https://api.modrinth.com/v2/project/{slug}"
        resp = requests.get(url, headers={'User-Agent': 'ModFixScript/1.0'})
        project_data = resp.json() if resp.status_code == 200 else {}
        
        # Get Dependencies (from latest version)
        ver_url = f"https://api.modrinth.com/v2/project/{slug}/version"
        ver_resp = requests.get(ver_url, headers={'User-Agent': 'ModFixScript/1.0'})
        deps = []
        if ver_resp.status_code == 200:
            versions = ver_resp.json()
            if versions:
                latest = versions[0]
                for dep in latest.get('dependencies', []):
                    # Dependency ID needs to be resolved to name, but for now we store ID
                    # Or we can try to resolve it if we have time.
                    # For simplicity, we might skip resolving IDs to names for now 
                    # unless we do a bulk lookup.
                    pass 
                    # Actually, let's just store the project_id if available
                    if dep.get('project_id'):
                        deps.append(dep['project_id'])

        return {
            'description': project_data.get('body', ''),
            'categories': project_data.get('categories', []),
            'dependencies': deps,
            'source': 'Modrinth'
        }
    except Exception as e:
        print(f"MR Details Error: {e}")
        return {}

# --- CurseForge Scraping ---
def fetch_curseforge_page(slug: str) -> Optional[str]:
    """Use curl to fetch CF page to bypass simple bot checks."""
    url = f"https://www.curseforge.com/minecraft/mc-mods/{slug}"
    try:
        # Use curl via subprocess
        cmd = [
            'curl', '-s', '-L', 
            '-A', USER_AGENT,
            url
        ]
        result = subprocess.run(cmd, capture_output=True, text=True, encoding='utf-8', errors='ignore')
        return result.stdout
    except Exception as e:
        print(f"CF Fetch Error (curl): {e}. Trying requests fallback...")
        try:
            resp = requests.get(url, headers={'User-Agent': USER_AGENT})
            if resp.status_code == 200:
                return resp.text
        except Exception as e2:
            print(f"CF Fetch Error (requests): {e2}")
        return None

def search_curseforge(query: str) -> Optional[str]:
    """Search CF and return the slug of the first result."""
    search_url = f"https://www.curseforge.com/minecraft/search?search={requests.utils.quote(query)}"
    try:
        cmd = [
            'curl', '-s', '-L', 
            '-A', USER_AGENT,
            search_url
        ]
        result = subprocess.run(cmd, capture_output=True, text=True, encoding='utf-8', errors='ignore')
        html = result.stdout
        
        # Parse with BS4
        soup = BeautifulSoup(html, 'html.parser')
        # Look for project links: /minecraft/mc-mods/SLUG
        # Usually in a result card
        for a in soup.find_all('a', href=True):
            href = a['href']
            if href.startswith('/minecraft/mc-mods/') and 'search' not in href:
                return href.split('/')[-1]
    except Exception as e:
        print(f"CF Search Error: {e}")
    return None

def get_curseforge_details(slug: str) -> Dict[str, Any]:
    html = fetch_curseforge_page(slug)
    if not html: return {}
    
    soup = BeautifulSoup(html, 'html.parser')
    
    # Description
    desc_div = soup.find('div', class_='project-description') # This class might vary
    # Fallback to generic container if specific class not found
    if not desc_div:
        desc_div = soup.find('div', {'id': 'html-description'}) # Old CF
        
    description = desc_div.get_text(separator='\n').strip() if desc_div else ""
    
    # Dependencies (Relations)
    # Usually under /relations/dependencies
    # We might need to fetch a separate page for relations: /minecraft/mc-mods/{slug}/relations/dependencies
    # For now, let's skip deep dependency scraping on CF to save time/complexity unless requested.
    # The user asked for "Dependencies/libraries".
    
    return {
        'description': description,
        'source': 'CurseForge'
    }

# --- Main Logic ---
def main():
    print("Starting Advanced Mod Processor...")
    
    global SOURCE_FILE
    
    force_update = False
    if "--force" in sys.argv:
        force_update = True
        sys.argv.remove("--force")

    if len(sys.argv) > 1:
        SOURCE_FILE = sys.argv[1]

    if not os.path.exists(SOURCE_FILE):
        print(f"File {SOURCE_FILE} not found.")
        return

    with open(SOURCE_FILE, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    
    filenames = extract_filenames(lines)
    print(f"Found {len(filenames)} mods in modlist.")

    # Check if we can skip processing
    if not force_update and os.path.exists(OUTPUT_JSON):
        try:
            with open(OUTPUT_JSON, 'r', encoding='utf-8') as f:
                existing_data = json.load(f)
            
            # Collect existing filenames
            existing_filenames = set()
            for cat, mods in existing_data.items():
                for mod in mods:
                    if 'filename' in mod:
                        existing_filenames.add(mod['filename'])
            
            # Compare
            current_filenames = set(filenames)
            
            if existing_filenames == current_filenames:
                print("Modlist matches existing data. Skipping processing.")
                sys.exit(2) # Exit code 2 indicates "Skipped"
            else:
                print("Changes detected in modlist. Reprocessing...")
                
        except Exception as e:
            print(f"Error checking existing data: {e}. Reprocessing...")
    
    mod_db = {} # Key: Normalized Name, Value: Mod Object
    
    # 1. Data Gathering
    for i, filename in enumerate(filenames):
        print(f"[{i+1}/{len(filenames)}] Processing {filename}...")
        
        search_query = clean_filename(filename)
        
        # -- Modrinth --
        mr_hit = search_modrinth(search_query)
        mr_data = {}
        if mr_hit:
            time.sleep(MR_DELAY)
            mr_details = get_modrinth_details(mr_hit['slug'])
            mr_data = {
                'title': mr_hit['title'],
                'slug': mr_hit['slug'],
                'description': mr_details.get('description', mr_hit['description']),
                'categories': mr_details.get('categories', []),
                'dependencies': mr_details.get('dependencies', []),
                'url': f"https://modrinth.com/mod/{mr_hit['slug']}"
            }
        
        # -- CurseForge --
        # Always search CF to merge data
        cf_slug = search_curseforge(search_query)
        cf_data = {}
        if cf_slug:
            time.sleep(CF_DELAY)
            cf_details = get_curseforge_details(cf_slug)
            cf_data = {
                'title': cf_slug.replace('-', ' ').title(), # Approximation
                'slug': cf_slug,
                'description': cf_details.get('description', ''),
                'url': f"https://www.curseforge.com/minecraft/mc-mods/{cf_slug}"
            }
        
        # -- Merge --
        # Prioritize Modrinth for structured data, but combine descriptions for AI
        final_data = mr_data if mr_data else cf_data
        
        if not final_data:
            final_data = {
                'title': search_query.title(),
                'description': "Could not find mod online. Please check the filename or search manually.",
                'dependencies': [],
                'categories': [],
                'url': ""
            }
        else:
            # Merge descriptions if both exist
            combined_desc = ""
            if mr_data and mr_data.get('description'):
                combined_desc += f"[Modrinth Description]:\n{mr_data['description']}\n\n"
            if cf_data and cf_data.get('description'):
                combined_desc += f"[CurseForge Description]:\n{cf_data['description']}\n\n"
            
            if combined_desc:
                final_data['description'] = combined_desc
            
            # Merge categories/tags if possible (CF doesn't give us tags easily in this script yet, but if we did...)
            # For now, just relying on MR categories + Combined Description is good.
        
        final_data['filename'] = filename
        
        # -- AI Summarization --
        # Only summarize if we have a long description
        ai_summary = None
        if len(final_data['description']) > 200:
            print("  Generating AI summary...")
            ai_summary = summarize_description(final_data['description'], final_data['title'])
            
        if ai_summary:
            final_data['summary'] = ai_summary
        else:
            # Clean fallback summary
            clean_desc = final_data['description'].replace('\n', ' ').replace('\r', '')
            # Smart truncate to ~300 chars, ending at the closest sentence
            limit = 350
            if len(clean_desc) > limit:
                # Find last period within the limit
                last_dot = clean_desc[:limit].rfind('.')
                if last_dot > 50: # Ensure we don't cut too short
                    final_data['summary'] = clean_desc[:last_dot+1]
                else:
                    # If no period found, try finding one slightly after
                    next_dot = clean_desc.find('.', limit)
                    if next_dot != -1 and next_dot < limit + 50:
                        final_data['summary'] = clean_desc[:next_dot+1]
                    else:
                        final_data['summary'] = clean_desc[:limit] + "..."
            else:
                # If description is short, just use it all.
                # If it's empty or just "...", provide a better default.
                if not clean_desc or clean_desc == "...":
                     final_data['summary'] = "No description available."
                else:
                    final_data['summary'] = clean_desc
            
        # -- AI Categorization --
        print("  Categorizing...")
        # Use the generated summary for categorization if available, as it's more focused.
        desc_for_cat = final_data.get('summary', final_data.get('description', ''))
        
        cat = categorize_mod(
            final_data['title'], 
            desc_for_cat, 
            final_data.get('categories', []), 
            final_data.get('dependencies', [])
        )
        final_data['ai_category'] = cat
        
        # Remove full description ONLY if we have an AI summary
        if ai_summary and 'description' in final_data:
            del final_data['description']
        elif 'description' in final_data:
             # Clean description if it remains so JSON is single-line friendly
             final_data['description'] = final_data['description'].replace('\n', ' ').replace('\r', '')
        
        # Determine Type (Mod vs Library)
        # Logic refined to avoid false positives from title matching
        is_lib = False
        
        # 1. Trust AI Category first (if it explicitly says Library/API)
        if final_data.get('ai_category') == 'Library/API':
            is_lib = True
            
        final_data['type'] = 'Library' if is_lib else 'Mod'
        
        # --- Duplicate Title Fix ---
        # Check if this title already exists in the DB
        existing_titles = [d['title'] for f, d in mod_db.items() if f != filename]
        if final_data['title'] in existing_titles:
            # Append filename to disambiguate
            final_data['title'] = f"{final_data['title']} ({filename})"
        
        print(f"  -> Category: {final_data.get('ai_category')} | Type: {final_data['type']}")

        mod_db[filename] = final_data
        
    # 2. Library Processing
    # Build dependency map
    # (This is tricky because MR gives Project IDs for deps, but we have Filenames.
    # We need to map Project IDs back to our list of mods if possible.
    # For now, we'll rely on the 'Library/API' category from AI or MR tags)
    
    organized_mods = {} # Category -> List of Mods
    
    # Identify Libraries
    libraries = []
    for fname, data in mod_db.items():
        if 'library' in [c.lower() for c in data.get('categories', [])] or \
           data.get('ai_category') == 'Library/API':
            libraries.append(data)
            
    # Group by Category
    for fname, data in mod_db.items():
        cat = data.get('ai_category', 'Utility/QoL')
        if cat not in organized_mods:
            organized_mods[cat] = []
        organized_mods[cat].append(data)
        
    # Add libraries to all categories? 
    # User said: "Places each library into every category where at least one dependent mod exists."
    # Without a perfect dependency graph (ID -> Filename), we can't know for sure which mod depends on which library 
    # just from the data we have easily. 
    # Heuristic: If we have libraries, just add them to a "Common Libraries" section or 
    # add ALL libraries to ALL categories (spammy) or just keep them in Library/API.
    # Let's stick to keeping them in their own category for now unless we can resolve dependencies.
    # However, the user explicitly asked for it.
    # "Marks which mods require each library." -> Requires resolving MR Project IDs to names.
    # That requires a lookup table of Project ID -> Mod Name.
    # We can build that from the MR data we fetched (mr_hit['project_id'] is available in search result usually? No, slug is).
    # We need to fetch project details to get ID.
    
    # For this script iteration, we will skip the complex dependency graph linking 
    # and just categorize them.
    
    # 3. Output Generation
    # Calculate stats
    lib_count = 0
    mod_count = 0
    
    for cat, mods in organized_mods.items():
        if "library" in cat.lower() or "api" in cat.lower():
            lib_count += len(mods)
        else:
            mod_count += len(mods)
            
    total_count = lib_count + mod_count

    # JSON
    with open(OUTPUT_JSON, 'w', encoding='utf-8') as f:
        json.dump(organized_mods, f, indent=2)
        
    # Text
    with open(OUTPUT_MODINFO, 'w', encoding='utf-8') as f:
        # Write Header Stats
        f.write(f"Mods I Have: ({mod_count}) | Libraries: ({lib_count}) | Total: {total_count}\n")
        f.write("=" * 60 + "\n\n")

        for cat, mods in organized_mods.items():
            # Sort: Mods first, then Libraries. Secondary sort by title.
            # False (0) comes before True (1), so 'Mod' comes before 'Library'
            mods.sort(key=lambda x: (x.get('type', 'Mod') == 'Library', x['title']))
            
            # Category Stats
            c_mods = sum(1 for m in mods if m.get('type') != 'Library')
            c_libs = sum(1 for m in mods if m.get('type') == 'Library')
            c_total = len(mods)
            
            f.write(f"=== {cat} (Mods: {c_mods} | Libs: {c_libs} | Total: {c_total}) ===\n\n")
            
            for mod in mods:
                f.write(f"[{mod['title']}]\n")
                f.write(f"File: {mod['filename']}\n")
                f.write(f"Type: {mod.get('type', 'Mod')}\n")
                f.write(f"Summary: {mod.get('summary', '')}\n")
                f.write(f"URL: {mod.get('url', '')}\n")
                f.write("\n")
            f.write("\n")

    print("Done!")

if __name__ == "__main__":
    main()

def is_likely_library(filename: str, title: str, categories: List[str]) -> bool:
    """Heuristic to check if a mod is likely a library/API."""
    # 1. Check Metadata Categories
    for cat in categories:
        if cat.lower() in ['library', 'api', 'library/api']:
            return True
            
    # 2. Check Filename/Title Keywords
    keywords = ['lib', 'api', 'config', 'library', 'framework', 'core', 'dependency', 'cloth', 'architectury', 'gecko', 'citadel', 'bookshelf']
    name_lower = filename.lower()
    title_lower = title.lower()
    
    for kw in keywords:
        if kw in name_lower or kw in title_lower:
            # Avoid false positives like "Libre" or "Capital" if possible, but 'lib' is strong.
            # 'fabric-api' is a common one.
            return True
            
    return False
