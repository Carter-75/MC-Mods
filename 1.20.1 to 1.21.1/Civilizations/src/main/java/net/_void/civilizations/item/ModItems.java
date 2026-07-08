/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
 *  net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1813
 *  net.minecraft.class_1814
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_1834
 *  net.minecraft.class_1935
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_7706
 *  net.minecraft.class_7923
 */
package net._void.civilizations.item;

import net._void.civilizations.Civilizations;
import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.item.ModArmorMaterials;
import net._void.civilizations.item.custom.AnubisAnkhItem;
import net._void.civilizations.item.custom.AnubisCore;
import net._void.civilizations.item.custom.ArtemisBowItem;
import net._void.civilizations.item.custom.ArtemisCore;
import net._void.civilizations.item.custom.ChinaKey;
import net._void.civilizations.item.custom.CustomEnchantedBookItem;
import net._void.civilizations.item.custom.EgyptCrook;
import net._void.civilizations.item.custom.EgyptKey;
import net._void.civilizations.item.custom.GreeceKey;
import net._void.civilizations.item.custom.LokiCore;
import net._void.civilizations.item.custom.LokiNecklaceItem;
import net._void.civilizations.item.custom.MercuryBoots;
import net._void.civilizations.item.custom.MercuryCore;
import net._void.civilizations.item.custom.NordicBattleAxe;
import net._void.civilizations.item.custom.RomeKey;
import net._void.civilizations.item.custom.WukongCore;
import net._void.civilizations.item.custom.WukongSwordItem;
import net._void.civilizations.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.class_1738;
import net.minecraft.class_1792;
import net.minecraft.class_1813;
import net.minecraft.class_1814;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1834;
import net.minecraft.class_1935;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7706;
import net.minecraft.class_7923;

public class ModItems {
    public static final class_1792 EGYPT_KEY = ModItems.registerItem("egypt_key", new EgyptKey((class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8903)));
    public static final class_1792 EGYPT_COIN = ModItems.registerItem("egypt_coin", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907)));
    public static final class_1792 PAPYRUS = ModItems.registerItem("papyrus", new class_1792((class_1792.class_1793)new FabricItemSettings()));
    public static final class_1792 EGYPT_CROOK = ModItems.registerItem("egypt_crook", (class_1792)new EgyptCrook(3, -2.0f, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8904)));
    public static final class_1792 CHINA_KEY_FRAGMENT = ModItems.registerItem("china_key_fragment", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907)));
    public static final class_1792 CHINA_KEY = ModItems.registerItem("china_key", new ChinaKey((class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8903)));
    public static final class_1792 NORDIC_BATTLE_AXE = ModItems.registerItem("nordic_battle_axe", (class_1792)new NordicBattleAxe(5, -2.8f, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8904)));
    public static final class_1792 CHINA_COIN = ModItems.registerItem("china_coin", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907)));
    public static final class_1792 CHINA_SWORD = ModItems.registerItem("china_sword", (class_1792)new class_1829((class_1832)class_1834.field_22033, 2, -1.5f, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8904)));
    public static final class_1792 HIGH_MOUNTAINS_AND_FLOWING_WATER_MUSIC_DISC = ModItems.registerItem("high_mountains_music_disc", (class_1792)new class_1813(7, ModSounds.HIGH_MOUNTAINS_AND_FLOWING_WATER, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8903), 382));
    public static final class_1792 AUTUMN_MOON_OVER_HAN_PALACE_MUSIC_DISC = ModItems.registerItem("autumn_moon_music_disc", (class_1792)new class_1813(7, ModSounds.AUTUMN_MOON_OVER_HAN_PALACE, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8903), 312));
    public static final class_1792 GREECE_KEY = ModItems.registerItem("greece_key", new GreeceKey((class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8903)));
    public static final class_1792 GREECE_SWORD = ModItems.registerItem("greece_sword", (class_1792)new class_1829((class_1832)class_1834.field_22033, 4, -2.0f, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8904)));
    public static final class_1792 GREECE_COIN = ModItems.registerItem("greece_coin", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907)));
    public static final class_1792 ROME_COIN = ModItems.registerItem("rome_coin", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907)));
    public static final class_1792 ROME_KEY = ModItems.registerItem("rome_key", new RomeKey((class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8903)));
    public static final class_1792 ROME_KEY_FRAGMENT = ModItems.registerItem("rome_key_fragment", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907)));
    public static final class_1792 ROME_SWORD = ModItems.registerItem("rome_sword", (class_1792)new class_1829((class_1832)class_1834.field_22033, 1, -1.0f, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8904)));
    public static final class_1792 BOOK_SHARPNESS = ModItems.registerItem("sharpness_book", new CustomEnchantedBookItem("sharpness", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_POWER = ModItems.registerItem("power_book", new CustomEnchantedBookItem("power", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_FIRE_ASPECT = ModItems.registerItem("fire_aspect_book", new CustomEnchantedBookItem("fire_aspect", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_UNBREAKING = ModItems.registerItem("unbreaking_book", new CustomEnchantedBookItem("unbreaking", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_PROTECTION = ModItems.registerItem("protection_book", new CustomEnchantedBookItem("protection", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_FEATHER_FALLING = ModItems.registerItem("feather_falling_book", new CustomEnchantedBookItem("feather_falling", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_THORNS = ModItems.registerItem("thorns_book", new CustomEnchantedBookItem("thorns", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_FROST_WALKER = ModItems.registerItem("frost_walker_book", new CustomEnchantedBookItem("frost_walker", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_DEPTH_STRIDER = ModItems.registerItem("depth_strider_book", new CustomEnchantedBookItem("depth_strider", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_EFFICIENCY = ModItems.registerItem("efficiency_book", new CustomEnchantedBookItem("efficiency", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 BOOK_FORTUNE = ModItems.registerItem("fortune_book", new CustomEnchantedBookItem("fortune", (class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8907).maxCount(1)));
    public static final class_1792 GREECE_CORE = ModItems.registerItem("greece_core", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 ARTEMIS_CORE = ModItems.registerItem("artemis_core", new ArtemisCore((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 ARTEMIS_RUNE = ModItems.registerItem("artemis_rune", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8903)));
    public static final class_1792 EGYPT_CORE = ModItems.registerItem("egypt_core", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 ANUBIS_CORE = ModItems.registerItem("anubis_core", new AnubisCore((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 ANUBIS_RUNE = ModItems.registerItem("anubis_rune", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8903)));
    public static final class_1792 ROME_CORE = ModItems.registerItem("rome_core", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 MERCURY_CORE = ModItems.registerItem("mercury_core", new MercuryCore((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 MERCURY_RUNE = ModItems.registerItem("mercury_rune", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8903)));
    public static final class_1792 CHINA_CORE = ModItems.registerItem("china_core", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 WUKONG_CORE = ModItems.registerItem("wukong_core", new WukongCore((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 WUKONG_RUNE = ModItems.registerItem("wukong_rune", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8903)));
    public static final class_1792 NORDIC_CORE = ModItems.registerItem("nordic_core", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 LOKI_CORE = ModItems.registerItem("loki_core", new LokiCore((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8904).maxCount(1)));
    public static final class_1792 LOKI_RUNE = ModItems.registerItem("loki_rune", new class_1792((class_1792.class_1793)new FabricItemSettings().rarity(class_1814.field_8903)));
    public static final class_1792 ARTEMIS_BOW = ModItems.registerItem("artemis_bow", (class_1792)new ArtemisBowItem(new class_1792.class_1793().method_7895(2031).method_7894(class_1814.field_8904)));
    public static final class_1792 ANUBIS_ANKH = ModItems.registerItem("anubis_ankh", new AnubisAnkhItem(new class_1792.class_1793().method_7889(1).method_7894(class_1814.field_8904)));
    public static final class_1792 MERCURY_BOOTS = ModItems.registerItem("mercury_boots", (class_1792)new MercuryBoots(ModArmorMaterials.MERCURY, class_1738.class_8051.field_41937, (class_1792.class_1793)new FabricItemSettings().maxDamage(481).rarity(class_1814.field_8904)));
    public static final class_1792 LOKI_NECKLACE = ModItems.registerItem("loki_necklace", new LokiNecklaceItem(new class_1792.class_1793().method_7889(1).method_7894(class_1814.field_8904)));
    public static final class_1792 WUKONG_SWORD = ModItems.registerItem("wukong_sword", (class_1792)new WukongSwordItem(6, -1.5f, (class_1792.class_1793)new FabricItemSettings().maxCount(1).rarity(class_1814.field_8904)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.method_45421((class_1935)EGYPT_COIN);
        entries.method_45421((class_1935)PAPYRUS);
        entries.method_45421((class_1935)CHINA_KEY_FRAGMENT);
        entries.method_45421((class_1935)CHINA_COIN);
        entries.method_45421((class_1935)GREECE_COIN);
        entries.method_45421((class_1935)ROME_COIN);
        entries.method_45421((class_1935)ROME_KEY_FRAGMENT);
        entries.method_45421((class_1935)BOOK_SHARPNESS);
        entries.method_45421((class_1935)BOOK_POWER);
        entries.method_45421((class_1935)BOOK_FIRE_ASPECT);
        entries.method_45421((class_1935)BOOK_UNBREAKING);
        entries.method_45421((class_1935)BOOK_PROTECTION);
        entries.method_45421((class_1935)BOOK_FEATHER_FALLING);
        entries.method_45421((class_1935)BOOK_THORNS);
        entries.method_45421((class_1935)BOOK_FROST_WALKER);
        entries.method_45421((class_1935)BOOK_DEPTH_STRIDER);
        entries.method_45421((class_1935)BOOK_EFFICIENCY);
        entries.method_45421((class_1935)BOOK_FORTUNE);
    }

    private static void addItemsToToolTabItemGroup(FabricItemGroupEntries entries) {
        entries.method_45421((class_1935)EGYPT_KEY);
        entries.method_45421((class_1935)CHINA_KEY);
        entries.method_45421((class_1935)GREECE_KEY);
        entries.method_45421((class_1935)ROME_KEY);
        entries.method_45421((class_1935)HIGH_MOUNTAINS_AND_FLOWING_WATER_MUSIC_DISC);
        entries.method_45421((class_1935)AUTUMN_MOON_OVER_HAN_PALACE_MUSIC_DISC);
    }

    private static void addItemsToBuildTabItemGroup(FabricItemGroupEntries entries) {
        entries.method_45421((class_1935)ModBlocks.SMOOTH_LIMESTONE);
        entries.method_45421((class_1935)ModBlocks.LIMESTONE);
        entries.method_45421((class_1935)ModBlocks.ROUGH_LIMESTONE);
        entries.method_45421((class_1935)ModBlocks.LIMESTONE_BRICKS);
        entries.method_45421((class_1935)ModBlocks.LIMESTONE_PILLAR);
    }

    private static void addItemsToRedstoneTabItemGroup(FabricItemGroupEntries entries) {
        entries.method_45421((class_1935)ModBlocks.EGYPT_DOOR);
    }

    private static void addItemsToFunctionalTabItemGroup(FabricItemGroupEntries entries) {
        entries.method_45421((class_1935)ModBlocks.TRADING_STATION);
        entries.method_45421((class_1935)ModBlocks.TOMBSTONE);
        entries.method_45421((class_1935)ModBlocks.COFFIN_TOP);
        entries.method_45421((class_1935)ModBlocks.COFFIN_BOTTOM);
        entries.method_45421((class_1935)ModBlocks.CHINA_CHEST);
        entries.method_45421((class_1935)ModBlocks.GREECE_CHEST);
        entries.method_45421((class_1935)ModBlocks.ROME_CHEST);
    }

    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {
        entries.method_45421((class_1935)EGYPT_CROOK);
        entries.method_45421((class_1935)NORDIC_BATTLE_AXE);
        entries.method_45421((class_1935)CHINA_SWORD);
        entries.method_45421((class_1935)GREECE_SWORD);
        entries.method_45421((class_1935)ROME_SWORD);
        entries.method_45421((class_1935)ARTEMIS_BOW);
        entries.method_45421((class_1935)MERCURY_BOOTS);
        entries.method_45421((class_1935)WUKONG_SWORD);
    }

    private static class_1792 registerItem(String name, class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_7923.field_41178, (class_2960)new class_2960("civilizations", name), (Object)item);
    }

    public static void registerModItems() {
        Civilizations.LOGGER.info("Registering Mod Items for civilizations");
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_41062).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_41060).register(ModItems::addItemsToToolTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40195).register(ModItems::addItemsToBuildTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40198).register(ModItems::addItemsToRedstoneTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40197).register(ModItems::addItemsToFunctionalTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40202).register(ModItems::addItemsToCombatTabItemGroup);
    }
}

