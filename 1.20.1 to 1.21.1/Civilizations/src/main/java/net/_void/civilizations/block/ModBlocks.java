/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2323
 *  net.minecraft.class_2378
 *  net.minecraft.class_2766
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_7923
 *  net.minecraft.class_8177
 */
package net._void.civilizations.block;

import net._void.civilizations.Civilizations;
import net._void.civilizations.block.custom.ChinaChest;
import net._void.civilizations.block.custom.CoffinBottom;
import net._void.civilizations.block.custom.CoffinTop;
import net._void.civilizations.block.custom.GreeceChest;
import net._void.civilizations.block.custom.RomeChest;
import net._void.civilizations.block.custom.TombstoneBlock;
import net._void.civilizations.block.custom.TradingStationBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2323;
import net.minecraft.class_2378;
import net.minecraft.class_2766;
import net.minecraft.class_2960;
import net.minecraft.class_4970;
import net.minecraft.class_7923;
import net.minecraft.class_8177;

public class ModBlocks {
    public static final class_2248 LIMESTONE_PILLAR = ModBlocks.registerBlock("limestone_pillar", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_9979)));
    public static final class_2248 LIMESTONE_BRICKS = ModBlocks.registerBlock("limestone_bricks", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_9979).strength(3.0f, 16.0f)));
    public static final class_2248 LIMESTONE = ModBlocks.registerBlock("limestone", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_9979).strength(2.0f)));
    public static final class_2248 SMOOTH_LIMESTONE = ModBlocks.registerBlock("smooth_limestone", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_9979).strength(4.0f)));
    public static final class_2248 ROUGH_LIMESTONE = ModBlocks.registerBlock("rough_limestone", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_9979).strength(-1.0f, 3600000.0f)));
    public static final class_2248 EGYPT_DOOR = ModBlocks.registerBlock("egypt_door", (class_2248)new class_2323((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_9973).strength(-1.0f).instrument(class_2766.field_12653), class_8177.field_42819));
    public static final class_2248 TRADING_STATION = ModBlocks.registerBlock("trading_station", (class_2248)new TradingStationBlock((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(-1.0f, 3600000.0f)));
    public static final class_2248 TOMBSTONE = ModBlocks.registerBlock("tombstone", (class_2248)new TombstoneBlock((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(4.0f, 3600000.0f)));
    public static final class_2248 COFFIN_TOP = ModBlocks.registerBlock("coffin_top", (class_2248)new CoffinTop((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(-1.0f, 3600000.0f)));
    public static final class_2248 COFFIN_BOTTOM = ModBlocks.registerBlock("coffin_bottom", (class_2248)new CoffinBottom((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(-1.0f, 3600000.0f)));
    public static final class_2248 CHINA_CHEST = ModBlocks.registerBlock("china_chest", (class_2248)new ChinaChest((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(-1.0f, 3600000.0f)));
    public static final class_2248 GREECE_CHEST = ModBlocks.registerBlock("greece_chest", (class_2248)new GreeceChest((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(-1.0f, 3600000.0f)));
    public static final class_2248 ROME_CHEST = ModBlocks.registerBlock("rome_chest", (class_2248)new RomeChest((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)class_2246.field_10085).nonOpaque().strength(-1.0f, 3600000.0f)));

    private static class_2248 registerBlock(String name, class_2248 block) {
        ModBlocks.registerBlockItem(name, block);
        return (class_2248)class_2378.method_10230((class_2378)class_7923.field_41175, (class_2960)new class_2960("civilizations", name), (Object)block);
    }

    private static class_1792 registerBlockItem(String name, class_2248 block) {
        return (class_1792)class_2378.method_10230((class_2378)class_7923.field_41178, (class_2960)new class_2960("civilizations", name), (Object)new class_1747(block, (class_1792.class_1793)new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Civilizations.LOGGER.info("Registering ModBlocks for civilizations");
    }
}

