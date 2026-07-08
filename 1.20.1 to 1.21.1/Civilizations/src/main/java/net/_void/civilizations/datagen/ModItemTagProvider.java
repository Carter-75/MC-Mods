/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$ItemTagProvider
 *  net.minecraft.class_3489
 *  net.minecraft.class_7225$class_7874
 */
package net._void.civilizations.datagen;

import java.util.concurrent.CompletableFuture;
import net._void.civilizations.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_3489;
import net.minecraft.class_7225;

public class ModItemTagProvider
extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> completableFuture) {
        super(output, completableFuture);
    }

    protected void method_10514(class_7225.class_7874 arg) {
        this.getOrCreateTagBuilder(class_3489.field_15541).add((Object)ModItems.HIGH_MOUNTAINS_AND_FLOWING_WATER_MUSIC_DISC).add((Object)ModItems.AUTUMN_MOON_OVER_HAN_PALACE_MUSIC_DISC);
        this.getOrCreateTagBuilder(class_3489.field_23969).add((Object)ModItems.HIGH_MOUNTAINS_AND_FLOWING_WATER_MUSIC_DISC).add((Object)ModItems.AUTUMN_MOON_OVER_HAN_PALACE_MUSIC_DISC);
    }
}

