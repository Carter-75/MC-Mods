/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 */
package backported.updates.copper.config;

import backported.updates.copper.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

public final class CommonConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String KEY_GOLEM_BUILD_SPAWNING = "golemBuildSpawning";
    private static final String KEY_GOLEM_PRESSES_BUTTONS = "golemPressesButtons";
    private static final String KEY_BUTTON_PRESS_CHANCE = "buttonPressChancePercent";
    private static final String KEY_GOLEM_TRANSPORT_STACK_SIZE = "golemTransportStackSize";
    private static final String KEY_WEATHERING_TICK_FROM = "weatheringTickFrom";
    private static final String KEY_WEATHERING_TICK_TO = "weatheringTickTo";
    private static final boolean DEFAULT_GOLEM_BUILD_SPAWNING = true;
    private static final boolean DEFAULT_GOLEM_PRESSES_BUTTONS = true;
    private static final int DEFAULT_BUTTON_PRESS_CHANCE = 5;
    private static final int DEFAULT_GOLEM_TRANSPORT_STACK_SIZE = 16;
    private static final int DEFAULT_WEATHERING_TICK_FROM = 504000;
    private static final int DEFAULT_WEATHERING_TICK_TO = 552000;
    private static boolean golemBuildSpawning = true;
    private static boolean golemPressesButtons = true;
    private static int buttonPressChancePercent = 5;
    private static int golemTransportStackSize = 16;
    private static int weatheringTickFrom = 504000;
    private static int weatheringTickTo = 552000;
    private static Path configPath;

    private CommonConfig() {
    }

    public static void init(Path configDir) {
        configPath = configDir.resolve("copperagebackport.json");
        CommonConfig.load();
    }

    public static boolean golemBuildSpawning() {
        return golemBuildSpawning;
    }

    public static void setGolemBuildSpawning(boolean value) {
        golemBuildSpawning = value;
    }

    public static boolean golemPressesButtons() {
        return golemPressesButtons;
    }

    public static void setGolemPressesButtons(boolean value) {
        golemPressesButtons = value;
    }

    public static int buttonPressChancePercent() {
        return buttonPressChancePercent;
    }

    public static void setButtonPressChancePercent(int value) {
        buttonPressChancePercent = CommonConfig.clamp(value, 0, 100);
    }

    public static int golemTransportStackSize() {
        return golemTransportStackSize;
    }

    public static void setGolemTransportStackSize(int value) {
        golemTransportStackSize = CommonConfig.clamp(value, 1, 64);
    }

    public static int weatheringTickFrom() {
        return weatheringTickFrom;
    }

    public static void setWeatheringTickFrom(int value) {
        weatheringTickFrom = Math.max(0, value);
    }

    public static int weatheringTickTo() {
        return weatheringTickTo;
    }

    public static void setWeatheringTickTo(int value) {
        weatheringTickTo = Math.max(weatheringTickFrom, value);
    }

    public static void load() {
        if (configPath == null) {
            Constants.LOG.warn("Config path not set, using defaults");
            return;
        }
        if (!Files.exists(configPath, new LinkOption[0])) {
            CommonConfig.save();
            return;
        }
        try (BufferedReader reader = Files.newBufferedReader(configPath, StandardCharsets.UTF_8);){
            JsonObject json = (JsonObject)GSON.fromJson((Reader)reader, JsonObject.class);
            if (json == null) {
                return;
            }
            if (json.has(KEY_GOLEM_BUILD_SPAWNING)) {
                golemBuildSpawning = json.get(KEY_GOLEM_BUILD_SPAWNING).getAsBoolean();
            }
            if (json.has(KEY_GOLEM_PRESSES_BUTTONS)) {
                golemPressesButtons = json.get(KEY_GOLEM_PRESSES_BUTTONS).getAsBoolean();
            }
            if (json.has(KEY_BUTTON_PRESS_CHANCE)) {
                buttonPressChancePercent = CommonConfig.clamp(json.get(KEY_BUTTON_PRESS_CHANCE).getAsInt(), 0, 100);
            }
            if (json.has(KEY_GOLEM_TRANSPORT_STACK_SIZE)) {
                golemTransportStackSize = CommonConfig.clamp(json.get(KEY_GOLEM_TRANSPORT_STACK_SIZE).getAsInt(), 1, 64);
            }
            if (json.has(KEY_WEATHERING_TICK_FROM)) {
                weatheringTickFrom = Math.max(0, json.get(KEY_WEATHERING_TICK_FROM).getAsInt());
            }
            if (json.has(KEY_WEATHERING_TICK_TO)) {
                weatheringTickTo = Math.max(weatheringTickFrom, json.get(KEY_WEATHERING_TICK_TO).getAsInt());
            }
            Constants.LOG.info("Loaded config: golemBuildSpawning={}, golemPressesButtons={}, buttonPressChance={}%, golemTransportStackSize={}, weatheringTickFrom={}, weatheringTickTo={}", new Object[]{golemBuildSpawning, golemPressesButtons, buttonPressChancePercent, golemTransportStackSize, weatheringTickFrom, weatheringTickTo});
        }
        catch (IOException | IllegalStateException e) {
            Constants.LOG.error("Failed to load config, using defaults", (Throwable)e);
        }
    }

    public static void save() {
        if (configPath == null) {
            Constants.LOG.warn("Config path not set, cannot save");
            return;
        }
        JsonObject json = new JsonObject();
        json.addProperty(KEY_GOLEM_BUILD_SPAWNING, Boolean.valueOf(golemBuildSpawning));
        json.addProperty(KEY_GOLEM_PRESSES_BUTTONS, Boolean.valueOf(golemPressesButtons));
        json.addProperty(KEY_BUTTON_PRESS_CHANCE, (Number)buttonPressChancePercent);
        json.addProperty(KEY_GOLEM_TRANSPORT_STACK_SIZE, (Number)golemTransportStackSize);
        json.addProperty(KEY_WEATHERING_TICK_FROM, (Number)weatheringTickFrom);
        json.addProperty(KEY_WEATHERING_TICK_TO, (Number)weatheringTickTo);
        try {
            Files.createDirectories(configPath.getParent(), new FileAttribute[0]);
            try (BufferedWriter writer = Files.newBufferedWriter(configPath, StandardCharsets.UTF_8, new OpenOption[0]);){
                GSON.toJson((JsonElement)json, (Appendable)writer);
            }
        }
        catch (IOException e) {
            Constants.LOG.error("Failed to save config", (Throwable)e);
        }
    }

    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}

