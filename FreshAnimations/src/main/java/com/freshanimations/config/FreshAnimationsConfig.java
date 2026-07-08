package com.freshanimations.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.freshanimations.FreshAnimations;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FreshAnimationsConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("freshanimations.json");

    public static final Map<String, Boolean> PACK_TOGGLES = new HashMap<>();

    public static void load() {
        if (CONFIG_PATH.toFile().exists()) {
            try (FileReader reader = new FileReader(CONFIG_PATH.toFile())) {
                Map<String, Boolean> loaded = GSON.fromJson(reader, Map.class);
                if (loaded != null) {
                    PACK_TOGGLES.putAll(loaded);
                }
            } catch (IOException e) {
                FreshAnimations.LOGGER.error("Failed to load config", e);
            }
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_PATH.toFile())) {
            GSON.toJson(PACK_TOGGLES, writer);
        } catch (IOException e) {
            FreshAnimations.LOGGER.error("Failed to save config", e);
        }
    }

    public static void registerPack(String packId) {
        PACK_TOGGLES.putIfAbsent(packId, true);
    }

    public static boolean isPackEnabled(String packId) {
        return PACK_TOGGLES.getOrDefault(packId, false);
    }
}
