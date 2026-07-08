/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2591
 *  net.minecraft.class_2960
 *  net.minecraft.class_7923
 */
package net._void.civilizations.block.entity;

import net._void.civilizations.Civilizations;
import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.block.entity.TombstoneBlockEntity;
import net._void.civilizations.block.entity.TradingStationBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModBlockEntities {
    public static final class_2591<TradingStationBlockEntity> TRADING_STATION_BLOCK_ENTITY = (class_2591)class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)new class_2960("civilizations", "trading_station_be"), (Object)FabricBlockEntityTypeBuilder.create(TradingStationBlockEntity::new, (class_2248[])new class_2248[]{ModBlocks.TRADING_STATION}).build());
    public static final class_2591<TombstoneBlockEntity> TOMBSTONE_BLOCK_ENTITY = (class_2591)class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)new class_2960("civilizations", "tombstone_be"), (Object)FabricBlockEntityTypeBuilder.create(TombstoneBlockEntity::new, (class_2248[])new class_2248[]{ModBlocks.TOMBSTONE}).build());

    public static void registerBlockEntities() {
        Civilizations.LOGGER.info("Registering Block Entities for civilizations");
    }
}

