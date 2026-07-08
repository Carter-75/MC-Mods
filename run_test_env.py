import os
import shutil
import subprocess
import sys
from pathlib import Path

def main():
    # Base Paths
    root_dir = Path(os.getcwd())
    fa_dir = root_dir / "FreshAnimations"
    pm_dir = root_dir / "PacksMod"
    playrun_dir = root_dir / "playrun"
    mods_dir = playrun_dir / "mods"
    
    # Clean playrun mods to prevent interference
    if mods_dir.exists():
        print(f"Cleaning {mods_dir}...")
        shutil.rmtree(mods_dir)
    mods_dir.mkdir(parents=True, exist_ok=True)

    print(f"Root Dir: {root_dir}")
    
    # 1. Build PacksMod
    print("\n--- Building PacksMod ---")
    run_gradle_build(pm_dir)
    
    # 2. Build FreshAnimations
    print("\n--- Building FreshAnimations ---")
    run_gradle_build(fa_dir)
    
    # 4. Copy PacksMod JAR
    # Find the jar (exclude sources)
    pm_build_libs = pm_dir / "build" / "libs"
    pm_jars = list(pm_build_libs.glob("PacksMod-*.jar"))
    pm_jar_to_copy = None
    
    for jar in pm_jars:
        if "sources" not in jar.name:
            pm_jar_to_copy = jar
            break
            
    if pm_jar_to_copy:
        print(f"Copying {pm_jar_to_copy.name} to {mods_dir}")
        shutil.copy2(pm_jar_to_copy, mods_dir / pm_jar_to_copy.name)
    else:
        print("ERROR: Could not find PacksMod jar!")
        sys.exit(1)

    # 5. Launch Game with FreshAnimations Client
    print("\n--- Launching Minecraft (Both Mods) ---")
    print(f"Game Directory: {playrun_dir}")
    
    game_dir_arg = f"--gameDir \"{playrun_dir.absolute()}\""
    gradlew = fa_dir / "gradlew.bat"
    
    launch_client(gradlew, fa_dir, game_dir_arg)

def run_gradle_build(directory):
    gradlew = directory / "gradlew.bat"
    if not gradlew.exists():
        print(f"ERROR: gradlew.bat not found at {gradlew}")
        sys.exit(1)
    
    try:
        subprocess.check_call([str(gradlew), "assemble", "-x", "remapSourcesJar"], cwd=directory, shell=True)
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
