/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.SpawnEggItem
 *  net.minecraft.block.Block
 */
package backported.updates.copper.fabric.registry;

import backported.updates.copper.fabric.item.Copper3DBlockItem;
import backported.updates.copper.registry.ModEntities;
import backported.updates.copper.registry.ModItemHelper;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.block.Block;

public class ModItemHelperImpl
implements ModItemHelper {
    private static final int PRIMARY_COPPER = 12088115;
    private static final int SECONDARY_OXIDIZED = 4772300;

    @Override
    public Item createSpawnEgg() {
        return new SpawnEggItem(ModEntities.COPPER_GOLEM.get(), 12088115, 4772300, new Item.Settings());
    }

    @Override
    public BlockItem create3DBlockItem(Block block, Item.Settings properties) {
        return new Copper3DBlockItem(block, properties);
    }
}

