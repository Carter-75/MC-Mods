# Minecraft Mod Organizer

This tool automatically organizes your Minecraft mods using AI.

## What It Does
1. Reads mod filenames from modlist.txt.
2. Fetches metadata from Modrinth and CurseForge.
3. Uses local AI (Ollama) to generate professional summaries and categorize mods.
4. Outputs a clean JSON database and a readable text report.

## How to Run
1. Ensure you have Python installed.
2. Install dependencies:
   pip install requests beautifulsoup4
3. Install and run Ollama (e.g., ollama run llama3).
4. Run the script:
   python advanced_process_mods.py

## Output
- organized_mods.json: Full data for use in other apps.
- modinfo_advanced.txt: Easy-to-read list of your mods.
