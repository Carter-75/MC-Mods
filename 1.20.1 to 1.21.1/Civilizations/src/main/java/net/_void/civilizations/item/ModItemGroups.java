/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
 *  net.minecraft.class_1761
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2378
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_7923
 */
package net._void.civilizations.item;

import net._void.civilizations.Civilizations;
import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModItemGroups {
    public static final class_1761 CIVILIZATIONS = (class_1761)class_2378.method_10230((class_2378)class_7923.field_44687, (class_2960)new class_2960("civilizations", "civilizations"), (Object)FabricItemGroup.builder().method_47321((class_2561)class_2561.method_43471((String)"itemgroup.civilizations")).method_47320(() -> new class_1799((class_1935)class_1802.field_8251)).method_47317((displayContext, entries) -> {
        entries.method_45421((class_1935)ModItems.EGYPT_KEY);
        entries.method_45421((class_1935)ModItems.EGYPT_COIN);
        entries.method_45421((class_1935)ModBlocks.SMOOTH_LIMESTONE);
        entries.method_45421((class_1935)ModBlocks.LIMESTONE);
        entries.method_45421((class_1935)ModBlocks.ROUGH_LIMESTONE);
        entries.method_45421((class_1935)ModBlocks.LIMESTONE_BRICKS);
        entries.method_45421((class_1935)ModBlocks.LIMESTONE_PILLAR);
        entries.method_45421((class_1935)ModBlocks.EGYPT_DOOR);
        entries.method_45421((class_1935)ModItems.PAPYRUS);
        entries.method_45421((class_1935)ModBlocks.TRADING_STATION);
        entries.method_45421((class_1935)ModBlocks.TOMBSTONE);
        entries.method_45421((class_1935)ModBlocks.COFFIN_TOP);
        entries.method_45421((class_1935)ModBlocks.COFFIN_BOTTOM);
        entries.method_45421((class_1935)ModItems.EGYPT_CROOK);
        entries.method_45421((class_1935)ModItems.CHINA_KEY_FRAGMENT);
        entries.method_45421((class_1935)ModItems.CHINA_KEY);
        entries.method_45421((class_1935)ModItems.CHINA_COIN);
        entries.method_45421((class_1935)ModItems.CHINA_SWORD);
        entries.method_45421((class_1935)ModItems.HIGH_MOUNTAINS_AND_FLOWING_WATER_MUSIC_DISC);
        entries.method_45421((class_1935)ModItems.AUTUMN_MOON_OVER_HAN_PALACE_MUSIC_DISC);
        entries.method_45421((class_1935)ModBlocks.CHINA_CHEST);
        entries.method_45421((class_1935)ModItems.NORDIC_BATTLE_AXE);
        entries.method_45421((class_1935)ModItems.GREECE_KEY);
        entries.method_45421((class_1935)ModBlocks.GREECE_CHEST);
        entries.method_45421((class_1935)ModItems.GREECE_SWORD);
        entries.method_45421((class_1935)ModItems.GREECE_COIN);
        entries.method_45421((class_1935)ModItems.ROME_COIN);
        entries.method_45421((class_1935)ModItems.ROME_KEY);
        entries.method_45421((class_1935)ModItems.ROME_KEY_FRAGMENT);
        entries.method_45421((class_1935)ModBlocks.ROME_CHEST);
        entries.method_45421((class_1935)ModItems.ROME_SWORD);
        entries.method_45421((class_1935)ModItems.BOOK_SHARPNESS);
        entries.method_45421((class_1935)ModItems.BOOK_POWER);
        entries.method_45421((class_1935)ModItems.BOOK_FIRE_ASPECT);
        entries.method_45421((class_1935)ModItems.BOOK_UNBREAKING);
        entries.method_45421((class_1935)ModItems.BOOK_PROTECTION);
        entries.method_45421((class_1935)ModItems.BOOK_FEATHER_FALLING);
        entries.method_45421((class_1935)ModItems.BOOK_THORNS);
        entries.method_45421((class_1935)ModItems.BOOK_FROST_WALKER);
        entries.method_45421((class_1935)ModItems.BOOK_DEPTH_STRIDER);
        entries.method_45421((class_1935)ModItems.BOOK_EFFICIENCY);
        entries.method_45421((class_1935)ModItems.BOOK_FORTUNE);
        entries.method_45421((class_1935)ModItems.GREECE_CORE);
        entries.method_45421((class_1935)ModItems.ARTEMIS_CORE);
        entries.method_45421((class_1935)ModItems.ARTEMIS_RUNE);
        entries.method_45421((class_1935)ModItems.EGYPT_CORE);
        entries.method_45421((class_1935)ModItems.ANUBIS_CORE);
        entries.method_45421((class_1935)ModItems.ANUBIS_RUNE);
        entries.method_45421((class_1935)ModItems.ROME_CORE);
        entries.method_45421((class_1935)ModItems.MERCURY_CORE);
        entries.method_45421((class_1935)ModItems.MERCURY_RUNE);
        entries.method_45421((class_1935)ModItems.CHINA_CORE);
        entries.method_45421((class_1935)ModItems.WUKONG_CORE);
        entries.method_45421((class_1935)ModItems.WUKONG_RUNE);
        entries.method_45421((class_1935)ModItems.NORDIC_CORE);
        entries.method_45421((class_1935)ModItems.LOKI_CORE);
        entries.method_45421((class_1935)ModItems.LOKI_RUNE);
        entries.method_45421((class_1935)ModItems.ARTEMIS_BOW);
        entries.method_45421((class_1935)ModItems.ANUBIS_ANKH);
        entries.method_45421((class_1935)ModItems.MERCURY_BOOTS);
        entries.method_45421((class_1935)ModItems.LOKI_NECKLACE);
        entries.method_45421((class_1935)ModItems.WUKONG_SWORD);
    }).method_47324());

    public static void registerItemGroups() {
        Civilizations.LOGGER.info("Registering Item Groups for civilizations");
    }
}

