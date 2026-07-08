import os
import subprocess
import sys

def main():
    project_dir = os.path.dirname(os.path.abspath(__file__))
    
    print("Launching Minecraft via Gradle (runClient)...")
    print("This will launch the game with Flat-XP-Gain, ModMenu, and Cloth Config automatically loaded!")
    
    gradlew_cmd = "gradlew.bat" if os.name == 'nt' else "./gradlew"
    
    try:
        # Run the gradle runClient task which automatically handles setting up the game,
        # logging you in to a dev account, and loading your workspace mod + dependencies.
        subprocess.run([gradlew_cmd, "runClient"], cwd=project_dir, check=True)
    except subprocess.CalledProcessError as e:
        print(f"Minecraft closed or crashed with exit code {e.returncode}")
        sys.exit(1)
    except FileNotFoundError:
        print(f"Could not find {gradlew_cmd}. Make sure you are running this from the project root.")
        sys.exit(1)

if __name__ == "__main__":
    main()
