/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.block.Block
 */
package backported.updates.copper.registry;

import backported.updates.copper.platform.Services;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;

public interface ModItemHelper {
    public Item createSpawnEgg();

    public BlockItem create3DBlockItem(Block var1, Item.Settings var2);

    public static Item createSpawnEggItem() {
        return Services.ITEM_HELPER.createSpawnEgg();
    }

    public static BlockItem create3DBlockItemForPlatform(Block block, Item.Settings properties) {
        return Services.ITEM_HELPER.create3DBlockItem(block, properties);
    }
}

