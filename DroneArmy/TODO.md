# DroneArmy Future Development Tasks

This document outlines the planned future features, polish, and balancing for the DroneArmy mod.

## Visuals & Polish
- [ ] **Textures**: Replace placeholder textures with final pixel art for:
    - [ ] Combat Drone
    - [ ] Sentinel
    - [ ] Artillery
    - [ ] Controller Items (Tier 1-10)
    - [ ] Essence Item
    - [ ] Robot Core & Upgrade Component
- [ ] **Models**: Create custom GeoModels (GeckoLib or AzureLib) for robots.
    - [ ] Combat Drone: Rotors, blades.
    - [ ] Sentinel: Heavy plating, tracks/legs.
    - [ ] Artillery: Cannon barrel, stabilizing legs.
    - [ ] Rocket Projectile: Custom missile model.
- [ ] **Animations**:
    - [ ] Idle, Walk, Attack animations.
    - [ ] Deployment animation (particle effects).
    - [ ] Recall particle effects.

## Audio
- [x] **Sound Effects**:
    - [x] Robot ambient sounds (ticks, whirs).
    - [x] Combat Drone blade spins.
    - [x] Sentinel heavy steps.
    - [x] Artillery firing (cannon blast).
    - [x] Controller interaction beeps.

## Gameplay & Balance
- [ ] **Balancing**:
    - [ ] Adjust Robot health and damage values based on playtesting.
    - [ ] Tune Essence drop rate (currently 1%).
    - [ ] Tune Cooldown times (currently 10 mins).
- [x] **Config**:
    - [x] Add configuration file for global settings (Drop rates, Cooldowns, Friendly Fire).
- [ ] **New Features**:
    - [ ] **Team System**: Allow players to ally their armies.
    - [ ] **Robot Customization**: Modules to upgrade individual robots (Speed, Armor, Damage).
    - [ ] **Chunk Loading**: Implement "Anchor" upgrade to keep chunks loaded for Artillery?

## Technical
- [ ] **Integration**:
    - [ ] REI/JEI support for Essence recipes.
    - [ ] Patchouli guide book.
- [ ] **Optimization**:
    - [ ] Optimize active unit tracking for large servers.
