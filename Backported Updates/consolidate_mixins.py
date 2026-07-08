import json
import os

os.chdir(r'c:\Users\carte\OneDrive\Desktop\Code\MC Mods\backports\Backported Updates\src\main\resources')

mixin_files = [
    'blended_vanillabackport_vanillabackport.mixins.json',
    'blended_copperagebackport_copperagebackport.fabric.mixins.json',
    'blended_i_iwie.mixins.json',
    'blended_platform_platform.mixins.json',
    'blended_platform_platform-common.mixins.json'
]

all_mixins = {'mixins': [], 'client': [], 'server': []}

print("=== Consolidating Mixin Configurations ===\n")

for filename in mixin_files:
    if os.path.exists(filename):
        with open(filename, 'r') as f:
            data = json.load(f)
        print(f"Reading {filename}")
        if 'mixins' in data:
            all_mixins['mixins'].extend(data['mixins'])
        if 'client' in data:
            all_mixins['client'].extend(data['client'])
        if 'server' in data:
            all_mixins['server'].extend(data['server'])
        print(f"  - Added {len(data.get('mixins', []))} mixins")
        print(f"  - Added {len(data.get('client', []))} client mixins")
        print(f"  - Added {len(data.get('server', []))} server mixins\n")

def remove_dupes(lst):
    seen = set()
    result = []
    for item in lst:
        if item not in seen:
            seen.add(item)
            result.append(item)
    return result

all_mixins['mixins'] = remove_dupes(all_mixins['mixins'])
all_mixins['client'] = remove_dupes(all_mixins['client'])
all_mixins['server'] = remove_dupes(all_mixins['server'])

consolidated = {
    "required": True,
    "minVersion": "0.8",
    "package": "backported_updates.mixin",
    "mixins": all_mixins['mixins'],
    "client": all_mixins['client'],
    "server": all_mixins['server']
}

output_file = 'backported_updates.mixins.json'
with open(output_file, 'w') as f:
    json.dump(consolidated, f, indent=2)

print(f"✓ Created {output_file}")
print(f"  Total mixins: {len(all_mixins['mixins'])}")
print(f"  Total client: {len(all_mixins['client'])}")
print(f"  Total server: {len(all_mixins['server'])}\n")

print("Removing old mixin files...")
for filename in mixin_files:
    if os.path.exists(filename):
        os.remove(filename)
        print(f"  Deleted {filename}")

print("\n✓ Mixin consolidation complete")
