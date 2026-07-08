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
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceManager
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.resource.JsonDataLoader
 *  net.minecraft.registry.Registries
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
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.registry.Registries;
import org.jetbrains.annotations.Nullable;

@Environment(value=EnvType.CLIENT)
public class LeafColorReloadListener
extends JsonDataLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final Map<Block, Properties> CUSTOM_COLORS = new ConcurrentHashMap<Block, Properties>();
    public static final LeafColorReloadListener INSTANCE = new LeafColorReloadListener();

    public LeafColorReloadListener() {
        super(GSON, "leaf_colors");
    }

    protected void apply(Map<Identifier, JsonElement> resources, ResourceManager resourceManager, Profiler profiler) {
        HashMap<Block, Map<Identifier, Properties>> blockEntries = new HashMap<>();
        int skippedCount = 0;
        for (Map.Entry<Identifier, JsonElement> entry : resources.entrySet()) {
            JsonElement element = entry.getValue();
            if (!element.isJsonObject()) continue;
            JsonObject object = element.getAsJsonObject();
            if (!object.has("block") || !object.has("properties")) {
                ++skippedCount;
                continue;
            }
            String blockId = object.get("block").getAsString();
            Identifier blockLocation = Identifier.tryParse((String)blockId);
            if (blockLocation == null || !Registries.BLOCK.containsId(blockLocation)) {
                ++skippedCount;
                continue;
            }
            JsonObject properties = object.getAsJsonObject("properties");
            if (!properties.has("color")) {
                ++skippedCount;
                continue;
            }
            Block block3 = (Block)Registries.BLOCK.get(blockLocation);
            int color = properties.get("color").getAsInt();
            int priority = properties.has("priority") ? properties.get("priority").getAsInt() : 0;
            blockEntries.computeIfAbsent(block3, k -> new HashMap<>()).put(entry.getKey(), new Properties(color, priority));
        }
        CUSTOM_COLORS.clear();
        for (Map.Entry<Block, Map<Identifier, Properties>> entry : blockEntries.entrySet()) {
            Block block2 = entry.getKey();
            Properties selectedEntry = LeafColorReloadListener.getColorProperties(entry);
            if (selectedEntry == null) continue;
            CUSTOM_COLORS.put(block2, selectedEntry);
        }
        for (Map.Entry<Block, Properties> entry : CUSTOM_COLORS.entrySet()) {
            int maxPriority;
            Block block2 = entry.getKey();
            Properties finalProps = entry.getValue();
            Map<Identifier, Properties> allEntries = blockEntries.get(block2);
            if (allEntries == null || allEntries.size() <= 1 || finalProps.priority == (maxPriority = allEntries.values().stream().mapToInt(p -> p.priority()).max().orElse(0))) continue;
            Properties correctEntry = allEntries.values().stream().filter(p -> p.priority() == maxPriority).findFirst().orElse(finalProps);
            CUSTOM_COLORS.put(block2, correctEntry);
        }
        if (skippedCount > 0) {
            VanillaBackport.LOGGER.info("Skipping {} leaf color(s).", skippedCount);
        }
        if (!CUSTOM_COLORS.isEmpty()) {
            VanillaBackport.LOGGER.info("Loaded {} custom leaf colors: {}", CUSTOM_COLORS.size(), CUSTOM_COLORS.keySet().stream().map(block -> Registries.BLOCK.getId(block).toString()).sorted().toList());
        }
    }

    @Nullable
    private static Properties getColorProperties(Map.Entry<Block, Map<Identifier, Properties>> blockEntry) {
        Map<Identifier, Properties> entries = blockEntry.getValue();
        Properties selectedEntry = null;
        int highestPriority = Integer.MIN_VALUE;
        for (Map.Entry<Identifier, Properties> entry : entries.entrySet()) {
            Properties props = entry.getValue();
            if (props.priority <= highestPriority) continue;
            highestPriority = props.priority;
            selectedEntry = props;
        }
        return selectedEntry;
    }

    public static int getCustomColor(Block block) {
        Properties entry = CUSTOM_COLORS.get(block);
        return entry != null ? entry.color : 0;
    }

    public static boolean hasCustomColor(Block block) {
        return CUSTOM_COLORS.containsKey(block);
    }

    private record Properties(int color, int priority) {
    }
}

