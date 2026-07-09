import os
import subprocess
import shutil
import sys
import glob

def main():
    project_dir = os.path.dirname(os.path.abspath(__file__))
    mod_dir = os.path.join(project_dir, 'mod')
    backup_dir = os.path.join(mod_dir, 'backup')

    # Ensure directories exist
    os.makedirs(mod_dir, exist_ok=True)
    os.makedirs(backup_dir, exist_ok=True)

    print("Running Gradle build...")
    gradlew_cmd = "gradlew.bat" if os.name == 'nt' else "./gradlew"
    
    try:
        subprocess.run([gradlew_cmd, "build"], cwd=project_dir, check=True)
    except subprocess.CalledProcessError as e:
        print(f"Gradle build failed with exit code {e.returncode}")
        sys.exit(1)
    except FileNotFoundError:
        print(f"Could not find {gradlew_cmd}. Make sure you are running this from the project root.")
        sys.exit(1)

    print("Build successful. Looking for output jar...")
    
    # The output jar is typically in build/libs
    libs_dir = os.path.join(project_dir, 'build', 'libs')
    if not os.path.exists(libs_dir):
        print("Error: build/libs directory does not exist.")
        sys.exit(1)

    # Find the standard mod jar (ignoring -dev or -sources)
    jars = glob.glob(os.path.join(libs_dir, '*.jar'))
    target_jar = None
    for jar in jars:
        jar_name = os.path.basename(jar)
        if not jar_name.endswith('-dev.jar') and not jar_name.endswith('-sources.jar'):
            target_jar = jar
            break
            
    if not target_jar:
        print("Error: Could not find the built jar file in build/libs.")
        sys.exit(1)

    print(f"Found built jar: {target_jar}")

    # Prepare for moving
    new_jar_name = "Item-Uncrafting-26.2.jar"
    final_jar_path = os.path.join(mod_dir, new_jar_name)

    # Backup existing jar if it exists
    if os.path.exists(final_jar_path):
        backup_path = os.path.join(backup_dir, new_jar_name)
        print(f"Backing up existing jar to {backup_path}")
        if os.path.exists(backup_path):
            os.remove(backup_path) # Overwrite existing backup
        shutil.move(final_jar_path, backup_path)
    
    # Also backup any other jar in the mod folder just in case
    for existing_mod in glob.glob(os.path.join(mod_dir, '*.jar')):
        mod_name = os.path.basename(existing_mod)
        backup_path = os.path.join(backup_dir, mod_name)
        print(f"Backing up {mod_name} to {backup_path}")
        if os.path.exists(backup_path):
            os.remove(backup_path)
        shutil.move(existing_mod, backup_path)

    # Move new jar
    print(f"Moving new jar to {final_jar_path}")
    shutil.copy2(target_jar, final_jar_path)
    
    print("Build and deployment complete!")

if __name__ == "__main__":
    main()
