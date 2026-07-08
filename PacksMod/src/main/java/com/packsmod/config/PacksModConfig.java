package com.packsmod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.packsmod.PacksMod;
import com.packsmod.packs.PackRegistry;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class PacksModConfig {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("packsmod.json");

	public Map<String, Boolean> packToggles = new LinkedHashMap<>();
	public FontSelection fontSelection = FontSelection.OFF;
	public ArmorSelection armorSelection = ArmorSelection.OFF;
	public boolean reloadAfterApplying = true;
	public boolean installMissingPacks = true;
	public boolean replaceExistingPacks = false;
	public boolean autoResolveConflicts = true;

	public enum FontSelection {
		OFF,
		CAPITALIZED,
		SERIFIED
	}

	public enum ArmorSelection {
		OFF,
		KNIGHT,
		TRABEN_3D
	}

	public static PacksModConfig load() {
		if (Files.exists(CONFIG_PATH)) {
			try (Reader reader = Files.newBufferedReader(CONFIG_PATH, StandardCharsets.UTF_8)) {
				PacksModConfig config = GSON.fromJson(reader, PacksModConfig.class);
				if (config != null) {
					config.applyDefaults();
					return config;
				}
			} catch (IOException | JsonSyntaxException ex) {
				PacksMod.LOGGER.warn("Failed to read {}, falling back to defaults", CONFIG_PATH, ex);
			}
		}

		PacksModConfig defaults = defaultConfig();
		save(defaults);
		return defaults;
	}

	public static void save(PacksModConfig config) {
		try {
			Files.createDirectories(CONFIG_PATH.getParent());
			try (Writer writer = Files.newBufferedWriter(CONFIG_PATH, StandardCharsets.UTF_8)) {
				GSON.toJson(config, writer);
			}
		} catch (IOException ex) {
			PacksMod.LOGGER.error("Unable to write config {}", CONFIG_PATH, ex);
		}
	}

	public static PacksModConfig defaultConfig() {
		PacksModConfig config = new PacksModConfig();
		config.packToggles = new LinkedHashMap<>(PackRegistry.defaultPackToggles());
		config.fontSelection = FontSelection.OFF;
		config.armorSelection = ArmorSelection.OFF;
		config.reloadAfterApplying = true;
		config.installMissingPacks = true;
		config.replaceExistingPacks = false;
		return config;
	}

	public Path path() {
		return CONFIG_PATH;
	}

	private void applyDefaults() {
		if (packToggles == null) {
			packToggles = new LinkedHashMap<>();
		}

		Map<String, Boolean> defaults = PackRegistry.defaultPackToggles();
		for (Map.Entry<String, Boolean> entry : defaults.entrySet()) {
			packToggles.putIfAbsent(entry.getKey(), entry.getValue());
		}

		if (fontSelection == null) {
			fontSelection = FontSelection.OFF;
		}

		if (armorSelection == null) {
			armorSelection = ArmorSelection.OFF;
		}
	}
}
