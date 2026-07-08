/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3695
 *  net.minecraft.class_4309
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.client.resources;

import backported.updates.content.core.VanillaBackport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3695;
import net.minecraft.class_4309;
import net.minecraft.class_7923;
import org.jetbrains.annotations.Nullable;

@Environment(value=EnvType.CLIENT)
public class LeafColorReloadListener
extends class_4309 {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final Map<class_2248, Properties> CUSTOM_COLORS = new ConcurrentHashMap<class_2248, Properties>();
    public static final LeafColorReloadListener INSTANCE = new LeafColorReloadListener();

    public LeafColorReloadListener() {
        super(GSON, "leaf_colors");
    }

    protected void apply(Map<class_2960, JsonElement> resources, class_3300 resourceManager, class_3695 profiler) {
        HashMap<class_2248, Map> blockEntries = new HashMap<class_2248, Map>();
        int skippedCount = 0;
        for (Map.Entry<class_2960, JsonElement> entry : resources.entrySet()) {
            JsonElement element = entry.getValue();
            if (!element.isJsonObject()) continue;
            JsonObject object = element.getAsJsonObject();
            if (!object.has("block") || !object.has("properties")) {
                ++skippedCount;
                continue;
            }
            String blockId = object.get("block").getAsString();
            class_2960 blockLocation = class_2960.method_12829((String)blockId);
            if (blockLocation == null || !class_7923.field_41175.method_10250(blockLocation)) {
                ++skippedCount;
                continue;
            }
            JsonObject properties = object.getAsJsonObject("properties");
            if (!properties.has("color")) {
                ++skippedCount;
                continue;
            }
            class_2248 block3 = (class_2248)class_7923.field_41175.method_10223(blockLocation);
            int color = properties.get("color").getAsInt();
            int priority = properties.has("priority") ? properties.get("priority").getAsInt() : 0;
            blockEntries.computeIfAbsent(block3, k -> new HashMap()).put(entry.getKey(), new Properties(color, priority));
        }
        CUSTOM_COLORS.clear();
        for (Map.Entry<Object, Object> entry : blockEntries.entrySet()) {
            class_2248 block2 = (class_2248)entry.getKey();
            Properties selectedEntry = LeafColorReloadListener.getColorProperties(entry);
            if (selectedEntry == null) continue;
            CUSTOM_COLORS.put(block2, selectedEntry);
        }
        for (Map.Entry<Object, Object> entry : CUSTOM_COLORS.entrySet()) {
            int maxPriority;
            class_2248 block2 = (class_2248)entry.getKey();
            Properties finalProps = (Properties)entry.getValue();
            Map allEntries = (Map)blockEntries.get(block2);
            if (allEntries == null || allEntries.size() <= 1 || finalProps.priority == (maxPriority = allEntries.values().stream().mapToInt(p -> p.priority).max().orElse(0))) continue;
            Properties correctEntry = allEntries.values().stream().filter(p -> p.priority == maxPriority).findFirst().orElse(finalProps);
            CUSTOM_COLORS.put(block2, correctEntry);
        }
        if (skippedCount > 0) {
            VanillaBackport.LOGGER.info("Skipping {} leaf color(s).", (Object)skippedCount);
        }
        if (!CUSTOM_COLORS.isEmpty()) {
            VanillaBackport.LOGGER.info("Loaded {} custom leaf colors: {}", (Object)CUSTOM_COLORS.size(), CUSTOM_COLORS.keySet().stream().map(block -> class_7923.field_41175.method_10221(block).toString()).sorted().toList());
        }
    }

    @Nullable
    private static Properties getColorProperties(Map.Entry<class_2248, Map<class_2960, Properties>> blockEntry) {
        Map<class_2960, Properties> entries = blockEntry.getValue();
        Properties selectedEntry = null;
        int highestPriority = Integer.MIN_VALUE;
        for (Map.Entry<class_2960, Properties> entry : entries.entrySet()) {
            Properties props = entry.getValue();
            if (props.priority <= highestPriority) continue;
            highestPriority = props.priority;
            selectedEntry = props;
        }
        return selectedEntry;
    }

    public static int getCustomColor(class_2248 block) {
        Properties entry = CUSTOM_COLORS.get(block);
        return entry != null ? entry.color : 0;
    }

    public static boolean hasCustomColor(class_2248 block) {
        return CUSTOM_COLORS.containsKey(block);
    }

    private record Properties(int color, int priority) {
    }
}

