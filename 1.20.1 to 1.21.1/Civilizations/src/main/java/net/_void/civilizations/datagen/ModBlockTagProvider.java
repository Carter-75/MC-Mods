/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$BlockTagProvider
 *  net.minecraft.class_3481
 *  net.minecraft.class_7225$class_7874
 */
package net._void.civilizations.datagen;

import java.util.concurrent.CompletableFuture;
import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_3481;
import net.minecraft.class_7225;

public class ModBlockTagProvider
extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void method_10514(class_7225.class_7874 arg) {
        this.getOrCreateTagBuilder(ModTags.Blocks.EGYPT_KEY_OPENABLE).add((Object)ModBlocks.EGYPT_DOOR).add((Object)ModBlocks.COFFIN_TOP).add((Object)ModBlocks.COFFIN_BOTTOM);
        this.getOrCreateTagBuilder(class_3481.field_33715).add((Object)ModBlocks.SMOOTH_LIMESTONE).add((Object)ModBlocks.LIMESTONE).add((Object)ModBlocks.LIMESTONE_BRICKS).add((Object)ModBlocks.LIMESTONE_PILLAR).add((Object)ModBlocks.TOMBSTONE);
        this.getOrCreateTagBuilder(class_3481.field_33718).add((Object)ModBlocks.SMOOTH_LIMESTONE).add((Object)ModBlocks.LIMESTONE).add((Object)ModBlocks.TOMBSTONE);
    }
}

