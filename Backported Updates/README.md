# Backported Updates

Backported Updates is a custom Fabric mod for Minecraft 1.21.1 focused on bringing newer-style content, blocks, items, entities, world features, and visual additions into one cohesive experience.

## Included content

- Copper content, blocks, tools, armor, entities, and supporting mechanics
- Pale Garden and related world content
- Bundles, variants, particles, sounds, and rendering additions
- Custom worldgen, data, mixins, and resource overrides required by the mod

## Project structure

- `src/main/java/`: mod source
- `src/main/resources/`: assets, data, metadata, mixins, access wideners, and packaged runtime content
- `build.gradle`, `settings.gradle`, `gradlew*`: build files
- `Build-Backported-Updates.ps1`: rebuilds the mod jar
- `Launch-Backported-Updates.ps1`: launches the local test instance

## Build

Use the provided PowerShell script:

```powershell
.\Build-Backported-Updates.ps1
```

Or run Gradle directly:

```powershell
.\gradlew.bat buildModJar
```

## Run

Launch the local Fabric test setup with:

```powershell
.\Launch-Backported-Updates.ps1
```

## Notes

- The built output is `backported_updates.jar`.
- Previous jar builds are stored in `backups/` when rebuilding.
- The active packaged mod metadata lives in `src/main/resources/fabric.mod.json`.
- The active project license lives in `src/main/resources/LICENSE`.
