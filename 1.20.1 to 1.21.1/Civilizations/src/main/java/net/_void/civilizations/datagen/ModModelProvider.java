/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
 *  net.minecraft.class_1738
 *  net.minecraft.class_4910
 *  net.minecraft.class_4915
 *  net.minecraft.class_4943
 */
package net._void.civilizations.datagen;

import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.class_1738;
import net.minecraft.class_4910;
import net.minecraft.class_4915;
import net.minecraft.class_4943;

public class ModModelProvider
extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(class_4910 blockStateModelGenerator) {
        blockStateModelGenerator.method_25641(ModBlocks.LIMESTONE);
        blockStateModelGenerator.method_25641(ModBlocks.SMOOTH_LIMESTONE);
        blockStateModelGenerator.method_25641(ModBlocks.ROUGH_LIMESTONE);
        blockStateModelGenerator.method_25641(ModBlocks.LIMESTONE_BRICKS);
        blockStateModelGenerator.method_25641(ModBlocks.LIMESTONE_PILLAR);
        blockStateModelGenerator.method_25658(ModBlocks.EGYPT_DOOR);
        blockStateModelGenerator.method_25681(ModBlocks.TRADING_STATION);
        blockStateModelGenerator.method_25681(ModBlocks.TOMBSTONE);
        blockStateModelGenerator.method_25708(ModBlocks.COFFIN_TOP);
        blockStateModelGenerator.method_25708(ModBlocks.COFFIN_BOTTOM);
        blockStateModelGenerator.method_25708(ModBlocks.CHINA_CHEST);
        blockStateModelGenerator.method_25708(ModBlocks.GREECE_CHEST);
        blockStateModelGenerator.method_25708(ModBlocks.ROME_CHEST);
    }

    public void generateItemModels(class_4915 itemModelGenerator) {
        itemModelGenerator.method_25733(ModItems.EGYPT_KEY, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.EGYPT_COIN, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.PAPYRUS, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.CHINA_KEY_FRAGMENT, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.CHINA_KEY, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.NORDIC_BATTLE_AXE, class_4943.field_22939);
        itemModelGenerator.method_25733(ModItems.CHINA_COIN, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.CHINA_SWORD, class_4943.field_22939);
        itemModelGenerator.method_25733(ModItems.HIGH_MOUNTAINS_AND_FLOWING_WATER_MUSIC_DISC, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.AUTUMN_MOON_OVER_HAN_PALACE_MUSIC_DISC, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.GREECE_KEY, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.GREECE_SWORD, class_4943.field_22939);
        itemModelGenerator.method_25733(ModItems.GREECE_COIN, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ROME_COIN, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ROME_KEY, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ROME_KEY_FRAGMENT, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ROME_SWORD, class_4943.field_22939);
        itemModelGenerator.method_25733(ModItems.BOOK_SHARPNESS, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_POWER, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_FIRE_ASPECT, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_UNBREAKING, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_PROTECTION, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_FEATHER_FALLING, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_THORNS, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_FROST_WALKER, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_DEPTH_STRIDER, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_EFFICIENCY, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.BOOK_FORTUNE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.GREECE_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ARTEMIS_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ARTEMIS_RUNE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.EGYPT_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ANUBIS_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ANUBIS_RUNE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ROME_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.MERCURY_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.MERCURY_RUNE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.CHINA_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.WUKONG_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.WUKONG_RUNE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.NORDIC_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.LOKI_CORE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.LOKI_RUNE, class_4943.field_22938);
        itemModelGenerator.method_25733(ModItems.ANUBIS_ANKH, class_4943.field_22938);
        itemModelGenerator.method_48523((class_1738)ModItems.MERCURY_BOOTS);
        itemModelGenerator.method_25733(ModItems.LOKI_NECKLACE, class_4943.field_22938);
    }
}

