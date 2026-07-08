package com.packsmod.packs;

import com.packsmod.config.PacksModConfig;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class PackRegistry {
	private static final List<PackDefinition> PACKS = List.of(
		new PackDefinition("knight_armor", "!§bKnightArmor", "knight_armor", PackCategory.ARMOR),
		new PackDefinition("3d_sugar_cane", "3D Sugar Cane", "3d_sugar_cane", PackCategory.RESOURCE),
		new PackDefinition("3d_muskets", "3D-muskets-1.1", "3d_muskets", PackCategory.RESOURCE),
		new PackDefinition("3d_mase", "3dMase", "3d_mase", PackCategory.RESOURCE),
		new PackDefinition("a_good_place_sample_pack", "A Good Place Sample Pack", "a_good_place_sample_pack", PackCategory.RESOURCE),
		new PackDefinition("alittle_axolotl", "Alittle_Axolotl", "alittle_axolotl", PackCategory.RESOURCE),
		new PackDefinition("animated_items", "animated-items-1_21-1 - 1_4_2", "animated_items", PackCategory.RESOURCE),
		new PackDefinition("beautiful_enchanted_books", "Beautiful Enchanted Books - MC 1.21.1 - 8.0.0", "beautiful_enchanted_books", PackCategory.RESOURCE),
		new PackDefinition("better_3d_ladder", "Better 3D Ladder", "better_3d_ladder", PackCategory.RESOURCE),
		new PackDefinition("better_bows", "Better Bows", "better_bows", PackCategory.RESOURCE),
		new PackDefinition("better_trident", "Better Trident v2", "better_trident", PackCategory.RESOURCE),
		new PackDefinition("better_lanterns", "Better+Lanterns+v1.2(mc-1.21)", "better_lanterns", PackCategory.RESOURCE),
		new PackDefinition("betterbetterx", "BetterBetterX-v1.1-noStone", "betterbetterx", PackCategory.RESOURCE),
		new PackDefinition("blockier_goat_horn", "Blockier Goat Horn v1.1 f9-34", "blockier_goat_horn", PackCategory.RESOURCE),
		new PackDefinition("bsl_shader", "BSL_v10.1", "bsl_shader", PackCategory.RESOURCE),
		new PackDefinition("capitalized_font", "Capitalized Font 1.20.x", "capitalized_font", PackCategory.FONT),
		new PackDefinition("connected_paths", "Connected-Paths 1.14-1.21.8 v2.0", "connected_paths", PackCategory.RESOURCE),
		new PackDefinition("cubic_leaves", "Cubic Leaves 2.3 (performance)", "cubic_leaves", PackCategory.RESOURCE),
		new PackDefinition("door_tweaks", "DoorTweaks-v3.5", "door_tweaks", PackCategory.RESOURCE),
		new PackDefinition("duskfall_ui", "DuskfallUI-1.0.2", "duskfall_ui", PackCategory.RESOURCE),
		new PackDefinition("enchantment_outline", "Enchantment-Outline1.9.9", "enchantment_outline", PackCategory.RESOURCE),
		new PackDefinition("everything_animated", "Everything Animated! 0.3.10", "everything_animated", PackCategory.RESOURCE),
		new PackDefinition("fancy_crops", "Fancy Crops v1.3", "fancy_crops", PackCategory.RESOURCE),
		new PackDefinition("fire_rekindled", "Fire_Rekindled", "fire_rekindled", PackCategory.RESOURCE),
		new PackDefinition("fresh_ores_and_ingots", "Fresh Ores and Ingots 1.2", "fresh_ores_and_ingots", PackCategory.RESOURCE),
		new PackDefinition("icons_effects", "Icons - Effects v.1.1", "icons_effects", PackCategory.RESOURCE),
		new PackDefinition("icons_enchantments", "Icons - Enchantments v.1.1", "icons_enchantments", PackCategory.RESOURCE),
		new PackDefinition("icons_tooltips", "Icons - Tooltips v.1.1", "icons_tooltips", PackCategory.RESOURCE),
		new PackDefinition("luminous", "Luminous1.4", "luminous", PackCategory.RESOURCE),
		new PackDefinition("mb_3d_items", "MB-3D Items Pack 1.6.0", "mb_3d_items", PackCategory.RESOURCE),
		new PackDefinition("mickey_joes_noteblocks", "MickeyJoesNoteBlocks", "mickey_joes_noteblocks", PackCategory.RESOURCE),
		new PackDefinition("mossy_better_dirt", "Mossy's_Better_Dirt_1.0", "mossy_better_dirt", PackCategory.RESOURCE),
		new PackDefinition("optimum_realism", "Optimum Realism R3.5.0 64x [Kappa, BSL,etc]", "optimum_realism", PackCategory.RESOURCE),
		new PackDefinition("os_colorful_grasses", "Os' Colorful Grasses (Mix)", "os_colorful_grasses", PackCategory.RESOURCE),
		new PackDefinition("recolourful_containers", "Recolourful Containers 3.0.1 (1.19.4+)", "recolourful_containers", PackCategory.RESOURCE),
		new PackDefinition("rekindled_ctm", "Rekindled_CTM", "rekindled_ctm", PackCategory.RESOURCE),
		new PackDefinition("serified_font", "Serified Font v1.2", "serified_font", PackCategory.FONT),
		new PackDefinition("simple_3d_chain", "simple-3d-chain", "simple_3d_chain", PackCategory.RESOURCE),
		new PackDefinition("simple_3d_iron_bars", "simple-3d-iron-bars", "simple_3d_iron_bars", PackCategory.RESOURCE),
		new PackDefinition("sun_moon_circular", "Sun and Moon Circular", "sun_moon_circular", PackCategory.RESOURCE),
		new PackDefinition("traben_3d_armor", "Traben's 3D Armor - 1.0.1", "traben_3d_armor", PackCategory.ARMOR),
		new PackDefinition("trabens_3d_arrows", "trabens-3d-arrows-1.1", "trabens_3d_arrows", PackCategory.RESOURCE),
		new PackDefinition("undopia_3d_rails", "Undopia_3D_Rails_1.21_v.1.0", "undopia_3d_rails", PackCategory.RESOURCE),
		new PackDefinition("redstone_torch", "§c1.21.2 Redstone Torch§r", "redstone_torch", PackCategory.RESOURCE),
		new PackDefinition("torches_reimagined", "§eTorches§8-§eReimagined§0_§8[v1.7.2]§0", "torches_reimagined", PackCategory.RESOURCE)
	);

	private static final List<String> ORDERED_KEYS = List.of(
		"a_good_place_sample_pack",
		"alittle_axolotl",
		"animated_items",
		"beautiful_enchanted_books",
		"better_3d_ladder",
		"better_bows",
		"better_trident",
		"better_lanterns",
		"betterbetterx",
		"blockier_goat_horn",
		"connected_paths",
		"cubic_leaves",
		"door_tweaks",
		"duskfall_ui",
		"enchantment_outline",
		"everything_animated",
		"fancy_crops",
		"fire_rekindled",
		"fresh_ores_and_ingots",
		"icons_effects",
		"icons_enchantments",
		"icons_tooltips",
		"luminous",
		"mb_3d_items",
		"mickey_joes_noteblocks",
		"mossy_better_dirt",
		"optimum_realism",
		"os_colorful_grasses",
		"recolourful_containers",
		"rekindled_ctm",
		"simple_3d_chain",
		"simple_3d_iron_bars",
		"sun_moon_circular",
		"trabens_3d_arrows",
		"undopia_3d_rails",
		"redstone_torch",
		"torches_reimagined",
		"3d_sugar_cane",
		"3d_muskets",
		"3d_mase",
		"knight_armor",
		"traben_3d_armor",
		"capitalized_font",
		"serified_font"
	);

	private static final Map<String, PackDefinition> BY_KEY;

	static {
		Map<String, PackDefinition> map = new LinkedHashMap<>();
		for (PackDefinition pack : PACKS) {
			map.put(pack.key(), pack);
		}
		BY_KEY = Collections.unmodifiableMap(map);
	}

	private PackRegistry() {
	}

	public static List<PackDefinition> packs() {
		return PACKS;
	}

	public static Map<String, PackDefinition> byKey() {
		return BY_KEY;
	}

	public static List<String> orderedKeys() {
		return ORDERED_KEYS;
	}

	public static Optional<PackDefinition> find(String key) {
		return Optional.ofNullable(BY_KEY.get(key));
	}

	public static PackDefinition resolveFont(PacksModConfig.FontSelection selection) {
		if (selection == null) {
			return null;
		}

		return switch (selection) {
			case CAPITALIZED -> BY_KEY.get("capitalized_font");
			case SERIFIED -> BY_KEY.get("serified_font");
			case OFF -> null;
		};
	}

	public static PackDefinition resolveArmor(PacksModConfig.ArmorSelection selection) {
		if (selection == null) {
			return null;
		}

		return switch (selection) {
			case KNIGHT -> BY_KEY.get("knight_armor");
			case TRABEN_3D -> BY_KEY.get("traben_3d_armor");
			case OFF -> null;
		};
	}

	public static Map<String, Boolean> defaultPackToggles() {
		Map<String, Boolean> defaults = new LinkedHashMap<>();
		for (PackDefinition pack : PACKS) {
			if (pack.category() == PackCategory.RESOURCE) {
				defaults.put(pack.key(), true);
			}
			if (pack.category() == PackCategory.SHADER) {
				defaults.put(pack.key(), false);
			}
		}
		return defaults;
	}
}
