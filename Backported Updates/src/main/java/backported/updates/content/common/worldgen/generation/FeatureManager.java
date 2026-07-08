/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.gen.GenerationStep$Feature
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.registry.tag.TagKey
 */
package backported.updates.content.common.worldgen.generation;

import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import backported.updates.foundation.common.worldgen.modifier.BiomeWriter;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.tag.TagKey;

public abstract class FeatureManager {
    private final BiomeContext context;
    private final BiomeWriter writer;

    public FeatureManager(BiomeContext context, BiomeWriter writer) {
        this.context = context;
        this.writer = writer;
    }

    public abstract void bootstrap();

    protected Builder getOrCreateBiomeBuilder(boolean filter) {
        return new Builder(this.context, ctx -> filter);
    }

    protected Builder getOrCreateBiomeBuilder(RegistryKey<Biome> biome) {
        return new Builder(this.context, ctx -> ctx.is(biome));
    }

    protected Builder getOrCreateBiomeBuilder(TagKey<Biome> biome) {
        return new Builder(this.context, ctx -> ctx.is(biome));
    }

    protected Builder getOrCreateBiomeBuilder(Predicate<BiomeContext> context) {
        return new Builder(this.context, ctx -> ctx.is(context));
    }

    protected void add(BiConsumer<BiomeContext, BiomeWriter> feature) {
        feature.accept(this.context, this.writer);
    }

    protected void addIf(boolean filter, BiConsumer<BiomeContext, BiomeWriter> feature) {
        if (filter) {
            this.add(feature);
        }
    }

    protected void addIf(Predicate<BiomeContext> filter, BiConsumer<BiomeContext, BiomeWriter> feature) {
        this.addIf(filter.test(this.context), feature);
    }

    protected void addVegetation(RegistryKey<PlacedFeature> feature) {
        this.writer.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }

    public class Builder {
        private final BiomeContext context;
        private final Predicate<BiomeContext> filter;

        public Builder(BiomeContext context, Predicate<BiomeContext> filter) {
            this.context = context;
            this.filter = filter;
        }

        public Builder add(Runnable runnable) {
            if (this.filter.test(this.context)) {
                runnable.run();
            }
            return this;
        }

        public Builder addIf(BiConsumer<BiomeContext, BiomeWriter> feature) {
            if (this.filter.test(this.context)) {
                FeatureManager.this.add(feature);
            }
            return this;
        }
    }
}

