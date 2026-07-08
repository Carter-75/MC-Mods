/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.entity.decoration.painting.PaintingVariant
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.registries.ModPaintingVariants;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;

public class PaintVariantsGenerator
extends FabricDynamicRegistryProvider {
    public PaintVariantsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries) {
        this.add(provider, entries, ModPaintingVariants.DENNIS);
    }

    private void add(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries, RegistryKey<PaintingVariant> key) {
        RegistryWrapper.Impl registry = provider.getWrapperOrThrow(RegistryKeys.PAINTING_VARIANT);
        entries.add(key, ((PaintingVariant)registry.getOrThrow(key).value()));
    }

    public String getName() {
        return "painting_variants";
    }
}

