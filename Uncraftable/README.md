# Uncraftable

A Minecraft Fabric mod (Version 26.2) that allows you to uncraft items back into their raw materials using an **Uncraftable Crate**. It dynamically scans registered recipes at runtime to reverse crafting combinations—fully compatible with both vanilla and modded items!

## Features
- **Dynamic Uncrafting**: Place any craftable item alone in the crafting grid to output an **Uncraftable Crate** containing its component ingredients.
- **Durability Degradation**: If an item is damaged (has less than 100% durability), you receive a proportional, randomized percentage of the original materials back (rounded down).
- **Flexible Quantities**: Supports uncrafting blocks, stairs, slabs, weapons, tools, armor, and more. 
- **Inventory/Hand Interactivity**: 
  - Sneak (Shift) + Right-Click while holding the crate to open it instantly.
  - Right-click the crate stack directly within your inventory screen to unpack it into your inventory.
  - Break the placed block in the world to retrieve the uncrafted items.
- **Active Stack Size Enforcement**: Enforces natural stack limits so that non-stackable items (like tools or swords) cannot exceed a stack size of 1 in the crafting grid slots.

## Setup & Building
- Use `python build.py` to compile and pack the mod jar.
- Use `python launch.py` to run a client instance with the mod loaded.

## License
This mod is completely free to use for any purpose, including commercial use, modifying, distributing, and video creation. The only requirement is that you give appropriate credit to the author ("Carter") if you use it in a video or for commercial purposes.

*(See the `LICENSE` file for the full CC0 1.0 Universal legal code)*
