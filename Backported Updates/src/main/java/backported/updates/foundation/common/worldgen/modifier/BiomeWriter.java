/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.world.gen.GenerationStep$Carver
 *  net.minecraft.world.gen.GenerationStep$Feature
 *  net.minecraft.world.gen.carver.ConfiguredCarver
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.biome.SpawnSettings$SpawnEntry
 *  net.minecraft.world.gen.feature.PlacedFeature
 */
package backported.updates.foundation.common.worldgen.modifier;

import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import java.util.function.BiConsumer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.PlacedFeature;

public abstract class BiomeWriter {
    public void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        modifier.accept(this, this.context());
    }

    public abstract Identifier name();

    public abstract BiomeContext context();

    public abstract void addFeature(GenerationStep.Feature var1, RegistryKey<PlacedFeature> var2);

    public abstract void removeFeature(GenerationStep.Feature var1, RegistryKey<PlacedFeature> var2);

    public void replaceFeature(GenerationStep.Feature decoration, RegistryKey<PlacedFeature> feature, RegistryKey<PlacedFeature> replacement) {
        if (this.context().hasFeature(feature)) {
            this.removeFeature(decoration, feature);
            this.addFeature(decoration, replacement);
        }
    }

    public abstract void addCarver(GenerationStep.Carver var1, RegistryKey<ConfiguredCarver<?>> var2);

    public abstract void removeCarver(GenerationStep.Carver var1, RegistryKey<ConfiguredCarver<?>> var2);

    public abstract void addSpawn(SpawnGroup var1, SpawnSettings.SpawnEntry var2);

    public abstract void removeSpawn(EntityType<?> var1);

    public void replaceSpawn(SpawnGroup category, SpawnSettings.SpawnEntry data) {
        if (this.context().hasEntity(() -> data.type)) {
            this.removeSpawn(data.type);
            this.addSpawn(category, data);
        }
    }
}

