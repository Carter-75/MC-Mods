/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
 *  net.minecraft.class_1935
 */
package net._void.civilizations.datagen;

import net._void.civilizations.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.class_1935;

public class ModBlockLootTableProvider
extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public void method_10379() {
        this.method_45988(ModBlocks.SMOOTH_LIMESTONE, this.method_45983(ModBlocks.SMOOTH_LIMESTONE, (class_1935)ModBlocks.LIMESTONE));
        this.method_46025(ModBlocks.LIMESTONE);
        this.method_46025(ModBlocks.LIMESTONE_PILLAR);
        this.method_46025(ModBlocks.LIMESTONE_BRICKS);
        this.method_46025(ModBlocks.TOMBSTONE);
    }
}

