/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.item.trim.ArmorTrimMaterial
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.registries.ModTrimMaterials;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.trim.ArmorTrimMaterial;

public class TrimMaterialGenerator
extends FabricDynamicRegistryProvider {
    public TrimMaterialGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries) {
        this.add(provider, entries, ModTrimMaterials.RESIN);
    }

    private void add(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries, RegistryKey<ArmorTrimMaterial> key) {
        RegistryWrapper.Impl registry = provider.getWrapperOrThrow(RegistryKeys.TRIM_MATERIAL);
        entries.add(key, ((ArmorTrimMaterial)registry.getOrThrow(key).value()));
    }

    public String getName() {
        return "trim_materials";
    }
}

