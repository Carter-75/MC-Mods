/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_3542
 *  net.minecraft.class_9129
 *  net.minecraft.class_9135
 *  net.minecraft.class_9139
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ModelAndTexture;
import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.core.registries.ModRegistries;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.class_3542;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;

public record PigVariant(ModelAndTexture<ModelType> modelAndTexture, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition>
{
    public static final class_9139<class_9129, PigVariant> STREAM_CODEC = class_9135.method_56365(ModRegistries.PIG_VARIANT_KEY);
    public static final Codec<PigVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)ModelAndTexture.codec(ModelType.CODEC, ModelType.NORMAL).forGetter(PigVariant::modelAndTexture), (App)SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(PigVariant::spawnConditions)).apply((Applicative)instance, PigVariant::new));

    private PigVariant(ModelAndTexture<ModelType> modelAndTexture) {
        this(modelAndTexture, SpawnPrioritySelectors.EMPTY);
    }

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }

    public static enum ModelType implements class_3542
    {
        NORMAL("normal"),
        COLD("cold");

        public static final Codec<ModelType> CODEC;
        private final String name;

        private ModelType(String name) {
            this.name = name;
        }

        public String method_15434() {
            return this.name;
        }

        static {
            CODEC = class_3542.method_28140(ModelType::values);
        }
    }
}

