# Flat XP Gain

A Minecraft Fabric mod (Version 26.2) that allows you to fully customize how much XP is required to level up! You can completely flatten the XP curve or make it scale strictly linearly. 

## Features
By default, Minecraft's XP system uses a quadratic curve, meaning higher levels become exponentially harder to reach. **Flat XP Gain** allows you to override this system with two distinct modes:

* **Flat XP Mode**: Make every single level cost the exact same amount of XP. 
* **Linear XP Mode (Default)**: Make the XP cost scale strictly linearly, adding a fixed amount of XP cost per level. 

## Configuration
This mod comes with full in-game configuration support using **ModMenu** and **Cloth Config API**. 

You can configure the following settings:
* **Mod Enabled**: Toggle the mod's custom XP scaling on or off (Default: `Yes`).
* **Flat XP Enabled**: Enable Flat XP mode (Default: `No`).
* **Linear XP Enabled**: Enable Linear XP mode (Default: `Yes`).
* **Level 1 XP Cost**: The base cost of Level 1 (Default: `100`).
* **Next XP Addition**: The fixed amount of XP added to the cost for each subsequent level when using Linear mode (Default: `1`).

## Server & Client
This mod can be installed on the **Server side only** and it will fully function for all players. However, if clients want to view and edit the config through the ModMenu UI in singleplayer (or access the settings screen at all), they will need it installed on the client side alongside ModMenu and Cloth Config. 

## License
This mod is completely free to use for any purpose, including commercial use, modifying, distributing, and video creation. The only requirement is that you give appropriate credit to the author ("Carter") if you use it in a video or for commercial purposes.

*(See the `LICENSE` file for the full CC0 1.0 Universal legal code)*
