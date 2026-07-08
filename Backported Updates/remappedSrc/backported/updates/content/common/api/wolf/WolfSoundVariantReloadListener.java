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
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3695
 *  net.minecraft.class_4309
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
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3695;
import net.minecraft.class_4309;

public class WolfSoundVariantReloadListener
extends class_4309 {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final String DIRECTORY = "wolf_sound_variant";
    public static final WolfSoundVariantReloadListener INSTANCE = new WolfSoundVariantReloadListener();

    public WolfSoundVariantReloadListener() {
        super(GSON, DIRECTORY);
    }

    protected void apply(Map<class_2960, JsonElement> resources, class_3300 manager, class_3695 profiler) {
        profiler.method_15396("Loading wolf sound variants");
        ModBuiltinRegistries.WOLF_SOUND_VARIANTS.clearDataDrivenEntries();
        for (Map.Entry<class_2960, JsonElement> entry : resources.entrySet()) {
            class_2960 name = entry.getKey();
            try {
                WolfSoundVariant.CODEC.parse((DynamicOps)JsonOps.INSTANCE, (Object)entry.getValue()).resultOrPartial(error -> VanillaBackport.LOGGER.error("Failed to parse wolf sound variant {}: {}", (Object)name, error)).ifPresent(variant -> ModBuiltinRegistries.WOLF_SOUND_VARIANTS.registerDataDriven(name, (WolfSoundVariant)variant));
            }
            catch (JsonParseException exception) {
                VanillaBackport.LOGGER.error("Failed to parse wolf sound variant JSON {}: {}", new Object[]{name, exception.getMessage(), exception});
            }
            catch (Exception exception) {
                VanillaBackport.LOGGER.error("Unexpected error processing wolf sound variant {}", (Object)name, (Object)exception);
            }
        }
        profiler.method_15407();
    }
}

