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
 *  net.minecraft.class_5455
 *  net.minecraft.class_6903
 *  net.minecraft.class_7225$class_7874
 */
package backported.updates.content.common.resource;

import backported.updates.content.common.level.entities.animal.PigVariant;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.common.resource.RegistryAwareJsonReloadListener;
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
import net.minecraft.class_5455;
import net.minecraft.class_6903;
import net.minecraft.class_7225;

public class PigVariantReloadListener
extends RegistryAwareJsonReloadListener {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final String DIRECTORY = "pig_variant";

    public PigVariantReloadListener() {
        super(GSON, DIRECTORY);
    }

    @Override
    public void parse(Map<class_2960, JsonElement> resources, class_5455 registryAccess, class_3300 manager, class_3695 profiler) {
        profiler.method_15396("Loading pig variants");
        ModBuiltinRegistries.PIG_VARIANTS.clearDataDrivenEntries();
        class_6903 ops = class_6903.method_46632((DynamicOps)JsonOps.INSTANCE, (class_7225.class_7874)registryAccess);
        for (Map.Entry<class_2960, JsonElement> entry : resources.entrySet()) {
            class_2960 name = entry.getKey();
            JsonElement element = entry.getValue();
            try {
                PigVariant.CODEC.parse((DynamicOps)ops, (Object)element).resultOrPartial(error -> VanillaBackport.LOGGER.error("Failed to parse pig variant {}: {}", (Object)name, error)).ifPresent(variant -> ModBuiltinRegistries.PIG_VARIANTS.registerDataDriven(name, (PigVariant)variant));
            }
            catch (JsonParseException exception) {
                VanillaBackport.LOGGER.error("Failed to parse pig variant JSON {}: {}", new Object[]{name, exception.getMessage(), exception});
            }
            catch (Exception exception) {
                VanillaBackport.LOGGER.error("Unexpected error processing pig variant {}", (Object)name, (Object)exception);
            }
        }
        profiler.method_15407();
    }
}

