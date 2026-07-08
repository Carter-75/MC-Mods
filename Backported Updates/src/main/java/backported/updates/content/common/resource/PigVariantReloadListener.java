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
 *  net.minecraft.registry.DynamicRegistryManager
 *  net.minecraft.registry.RegistryOps
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
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
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.RegistryWrapper;

public class PigVariantReloadListener
extends RegistryAwareJsonReloadListener {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final String DIRECTORY = "pig_variant";

    public PigVariantReloadListener() {
        super(GSON, DIRECTORY);
    }

    @Override
    public void parse(Map<Identifier, JsonElement> resources, DynamicRegistryManager registryAccess, ResourceManager manager, Profiler profiler) {
        profiler.push("Loading pig variants");
        ModBuiltinRegistries.PIG_VARIANTS.clearDataDrivenEntries();
        RegistryOps ops = RegistryOps.of((DynamicOps)JsonOps.INSTANCE, (RegistryWrapper.WrapperLookup)registryAccess);
        for (Map.Entry<Identifier, JsonElement> entry : resources.entrySet()) {
            Identifier name = entry.getKey();
            JsonElement element = entry.getValue();
            try {
                PigVariant.CODEC.parse((DynamicOps)ops, element).resultOrPartial(error -> VanillaBackport.LOGGER.error("Failed to parse pig variant {}: {}", name, error)).ifPresent(variant -> ModBuiltinRegistries.PIG_VARIANTS.registerDataDriven(name, (PigVariant)variant));
            }
            catch (JsonParseException exception) {
                VanillaBackport.LOGGER.error("Failed to parse pig variant JSON {}: {}", new Object[]{name, exception.getMessage(), exception});
            }
            catch (Exception exception) {
                VanillaBackport.LOGGER.error("Unexpected error processing pig variant {}", name, exception);
            }
        }
        profiler.pop();
    }
}

