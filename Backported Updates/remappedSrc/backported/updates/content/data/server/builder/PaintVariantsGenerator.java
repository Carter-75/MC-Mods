/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.class_1535
 *  net.minecraft.class_5321
 *  net.minecraft.class_7225$class_7226
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7924
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.registries.ModPaintingVariants;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.class_1535;
import net.minecraft.class_5321;
import net.minecraft.class_7225;
import net.minecraft.class_7924;

public class PaintVariantsGenerator
extends FabricDynamicRegistryProvider {
    public PaintVariantsGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(class_7225.class_7874 provider, FabricDynamicRegistryProvider.Entries entries) {
        this.add(provider, entries, ModPaintingVariants.DENNIS);
    }

    private void add(class_7225.class_7874 provider, FabricDynamicRegistryProvider.Entries entries, class_5321<class_1535> key) {
        class_7225.class_7226 registry = provider.method_46762(class_7924.field_41209);
        entries.add(key, (Object)((class_1535)registry.method_46747(key).comp_349()));
    }

    public String method_10321() {
        return "painting_variants";
    }
}

