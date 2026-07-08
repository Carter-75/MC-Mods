# Realtime Clock Gamerule

A tiny Fabric mod for Minecraft 1.21.1 that adds a single gamerule to synchronize every world's daylight cycle with the server's local time. When enabled, midnight in real life matches midnight in game, regardless of `doDaylightCycle`.

## Features
- `realtimeClockSync` gamerule (per world) that forces the sun and moon to mirror the host machine's local clock.
- Works across dimensions and ignores the vanilla daylight cycle once enabled.
- Zero configuration beyond toggling the gamerule.

## Usage
1. Install Fabric Loader 0.15.10+ and Fabric API 0.102.0+ for Minecraft 1.21.1.
2. Drop the built JAR into your server/client `mods` folder.
3. In game or via console, toggle the rule:
   - `/gamerule realtimeClockSync true` to lock the world clock to local time.
   - `/gamerule realtimeClockSync false` to return to vanilla behavior.

When enabled the mod continuously sets each world's time so that:
- Real midnight aligns with Minecraft midnight (18000 ticks).
- Real noon aligns with Minecraft noon (6000 ticks).

## Building
Run `./gradlew build` (or `gradlew.bat build` on Windows). The compiled JAR appears under `build/libs`.
