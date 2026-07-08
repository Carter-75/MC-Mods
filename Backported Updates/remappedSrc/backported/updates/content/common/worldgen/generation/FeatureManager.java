/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_2893$class_2895
 *  net.minecraft.class_5321
 *  net.minecraft.class_6796
 *  net.minecraft.class_6862
 */
package backported.updates.content.common.worldgen.generation;

import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import backported.updates.foundation.common.worldgen.modifier.BiomeWriter;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import net.minecraft.class_1959;
import net.minecraft.class_2893;
import net.minecraft.class_5321;
import net.minecraft.class_6796;
import net.minecraft.class_6862;

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

    protected Builder getOrCreateBiomeBuilder(class_5321<class_1959> biome) {
        return new Builder(this.context, ctx -> ctx.is(biome));
    }

    protected Builder getOrCreateBiomeBuilder(class_6862<class_1959> biome) {
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

    protected void addVegetation(class_5321<class_6796> feature) {
        this.writer.addFeature(class_2893.class_2895.field_13178, feature);
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

