import os
import shutil
import subprocess
import sys
from pathlib import Path

def main():
    root_dir = Path(os.getcwd())
    pm_dir = root_dir / "PacksMod"
    playrun_dir = root_dir / "playrun_pm"
    mods_dir = playrun_dir / "mods"
    
    # Clean playrun mods
    if mods_dir.exists():
        print(f"Cleaning {mods_dir}...")
        shutil.rmtree(mods_dir)
    mods_dir.mkdir(parents=True, exist_ok=True)

    print("\n--- Building PacksMod ---")
    run_gradle_build(pm_dir)

    # Launching PM is trickier because we need a client to run it in.
    # We can use the PacksMod gradle project's runClient directly.
    # It will include PacksMod on the classpath.
    
    print("\n--- Launching Minecraft (PacksMod Only) ---")
    game_dir_arg = f"--gameDir \"{playrun_dir.absolute()}\""
    gradlew = pm_dir / "gradlew.bat"
    
    launch_client(gradlew, pm_dir, game_dir_arg)

def run_gradle_build(directory):
    gradlew = directory / "gradlew.bat"
    if not gradlew.exists():
        print(f"ERROR: gradlew.bat not found at {gradlew}")
        sys.exit(1)
    try:
        subprocess.check_call([str(gradlew), "build"], cwd=directory, shell=True)
    except subprocess.CalledProcessError:
        print(f"Build failed in {directory}")
        sys.exit(1)

def launch_client(gradlew, cwd, args):
    cmd = [str(gradlew), "runClient", f"--args={args}"]
    try:
        subprocess.check_call(cmd, cwd=cwd, shell=True)
    except subprocess.CalledProcessError:
        print("Error launching game")
        sys.exit(1)

if __name__ == "__main__":
    main()
