package com.resoursepackloader.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.resoursepackloader.ResoursePackLoader;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public record AutoPackConfig(List<String> packsToEnable, boolean enableAllAvailable, boolean reloadAfterApplying) {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("resourse-pack-loader.json");

	public AutoPackConfig {
		packsToEnable = sanitize(packsToEnable);
	}

	private static List<String> sanitize(List<String> raw) {
		if (raw == null || raw.isEmpty()) {
			return List.of();
		}

		return raw.stream()
			.map(entry -> entry == null ? "" : entry.trim())
			.filter(entry -> !entry.isBlank())
			.distinct()
			.collect(Collectors.toList());
	}

	public static AutoPackConfig load() {
		if (Files.exists(CONFIG_PATH)) {
			try (Reader reader = Files.newBufferedReader(CONFIG_PATH, StandardCharsets.UTF_8)) {
				AutoPackConfig config = GSON.fromJson(reader, AutoPackConfig.class);
				if (config != null) {
					return config;
				}
			} catch (IOException | JsonSyntaxException ex) {
				ResoursePackLoader.LOGGER.warn("Failed to read {}, falling back to defaults", CONFIG_PATH, ex);
			}
		}

		AutoPackConfig defaults = defaultConfig();
		save(defaults);
		return defaults;
	}

	public static void save(AutoPackConfig config) {
		try {
			Files.createDirectories(CONFIG_PATH.getParent());
			try (Writer writer = Files.newBufferedWriter(CONFIG_PATH, StandardCharsets.UTF_8)) {
				GSON.toJson(config, writer);
			}
		} catch (IOException ex) {
			ResoursePackLoader.LOGGER.error("Unable to write config {}", CONFIG_PATH, ex);
		}
	}

	public static AutoPackConfig defaultConfig() {
		return new AutoPackConfig(List.of(), false, true);
	}

	public Path path() {
		return CONFIG_PATH;
	}
}
