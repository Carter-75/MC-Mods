/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonParseException
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.JsonOps
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceManager
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.resource.JsonDataLoader
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.common.api.wolf.WolfSoundVariant;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import java.util.Map;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.resource.JsonDataLoader;

public class WolfSoundVariantReloadListener
extends JsonDataLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final String DIRECTORY = "wolf_sound_variant";
    public static final WolfSoundVariantReloadListener INSTANCE = new WolfSoundVariantReloadListener();

    public WolfSoundVariantReloadListener() {
        super(GSON, DIRECTORY);
    }

    protected void apply(Map<Identifier, JsonElement> resources, ResourceManager manager, Profiler profiler) {
        profiler.push("Loading wolf sound variants");
        ModBuiltinRegistries.WOLF_SOUND_VARIANTS.clearDataDrivenEntries();
        for (Map.Entry<Identifier, JsonElement> entry : resources.entrySet()) {
            Identifier name = entry.getKey();
            try {
                WolfSoundVariant.CODEC.parse((DynamicOps)JsonOps.INSTANCE, entry.getValue()).resultOrPartial(error -> VanillaBackport.LOGGER.error("Failed to parse wolf sound variant {}: {}", name, error)).ifPresent(variant -> ModBuiltinRegistries.WOLF_SOUND_VARIANTS.registerDataDriven(name, (WolfSoundVariant)variant));
            }
            catch (JsonParseException exception) {
                VanillaBackport.LOGGER.error("Failed to parse wolf sound variant JSON {}: {}", new Object[]{name, exception.getMessage(), exception});
            }
            catch (Exception exception) {
                VanillaBackport.LOGGER.error("Unexpected error processing wolf sound variant {}", name, exception);
            }
        }
        profiler.pop();
    }
}

