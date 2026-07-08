package com.drone_army.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
    private static ModConfig INSTANCE;
    private static final File CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("dronearmy.json")
            .toFile();

    // Config Fields
    public float essenceDropChance = 0.01f; // 1%
    public int unitCooldownMinutes = 10;
    public boolean allowFriendlyFire = false;
    public int maxUnitsBase = 1;

    // Robot Stats Multipliers (For easy balancing)
    public double combatDroneHealth = 30.0;
    public double combatDroneDamage = 8.0;

    public double sentinelHealth = 60.0;
    public double sentinelDamage = 5.0;

    public double artilleryHealth = 20.0;
    public double artilleryDamage = 4.0;

    public static ModConfig get() {
        if (INSTANCE == null) {
            load();
        }
        return INSTANCE;
    }

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                INSTANCE = new Gson().fromJson(reader, ModConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
                INSTANCE = new ModConfig();
            }
        } else {
            INSTANCE = new ModConfig();
            save(); // Save defaults
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(INSTANCE, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
