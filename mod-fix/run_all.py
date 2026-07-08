import subprocess
import sys
import os

def run_script(script_name):
    print(f"--- Running {script_name} ---")
    try:
        # Use sys.executable to ensure we use the same python interpreter
        result = subprocess.run([sys.executable, script_name], check=True)
        print(f"--- {script_name} completed successfully ---\n")
        return True
    except subprocess.CalledProcessError as e:
        print(f"Error running {script_name}: {e}")
        return False
    except FileNotFoundError:
        print(f"Error: {script_name} not found.")
        return False

def main():
    # 1. Run the main processor
    print("--- Step 1: Processing Mods ---")
    
    args = []
    if "--force" in sys.argv:
        args.append("--force")
        
    try:
        result = subprocess.run([sys.executable, "advanced_process_mods.py"] + args, check=False)
        exit_code = result.returncode
    except FileNotFoundError:
        print("Error: advanced_process_mods.py not found.")
        return

    if exit_code == 1:
        print("Error in processing script. Stopping.")
        return
    
    # Exit Code 2 means "Skipped" (No changes)
    # Exit Code 0 means "Updated" (Changes made)
    
    force_update = (exit_code == 0)
    
    if exit_code == 2:
        print("--- Step 1 Skipped (No changes detected) ---")
    else:
        print("--- Step 1 Completed (Changes detected) ---")

    # 2. Run the splitter
    # User logic: "if the split is done exactly the same but even if it looks ame redo it... if the first script ran and updated"
    # So if force_update is True, we MUST run Step 2.
    # If force_update is False, we check if we need to run it (e.g. missing files).
    
    run_step_2 = force_update
    if not run_step_2:
        # Check if split files exist
        import glob
        if not glob.glob("mods_*.txt"):
            print("Split files missing. Running Step 2 anyway.")
            run_step_2 = True
            
    if run_step_2:
        if not run_script("mod-split.py"):
            print("Stopping due to error.")
            return
    else:
        print("--- Step 2 Skipped (No updates needed) ---")

    # 3. Run the file organizer
    # Same logic: If Step 2 ran, Step 3 should run.
    run_step_3 = run_step_2
    if not run_step_3:
         if not os.path.exists("mod-split"):
             print("Mod-split folder missing. Running Step 3 anyway.")
             run_step_3 = True

    if run_step_3:
        if not run_script("organize_files.py"):
            print("Stopping due to error.")
            return
    else:
        print("--- Step 3 Skipped (No updates needed) ---")

    # 4. Run the similarity analyzer
    # Logic: Run if Step 3 ran (new files) OR if forced.
    # The script itself handles skipping if files exist and not forced, 
    # but we can pass --force if we want to force it.
    # If force_update is True (from Step 1 or args), we pass --force to Step 4.
    
    run_step_4 = True # Always try to run it, let the script decide to skip
    
    step_4_args = []
    if force_update or "--force" in sys.argv:
        step_4_args.append("--force")
        
    print("--- Step 4: Analyzing Similar Mods ---")
    try:
        subprocess.run([sys.executable, "find_similar_mods.py"] + step_4_args, check=False)
    except FileNotFoundError:
        print("Error: find_similar_mods.py not found.")

    print("All tasks completed!")

if __name__ == "__main__":
    main()
