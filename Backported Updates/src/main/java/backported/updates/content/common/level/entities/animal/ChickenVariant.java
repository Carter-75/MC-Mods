/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.StringIdentifiable
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodecs
 *  net.minecraft.network.codec.PacketCodec
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
import net.minecraft.util.StringIdentifiable;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.codec.PacketCodec;

public record ChickenVariant(ModelAndTexture<ModelType> modelAndTexture, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition>
{
    public static final PacketCodec<RegistryByteBuf, ChickenVariant> STREAM_CODEC = PacketCodecs.registryValue(ModRegistries.CHICKEN_VARIANT_KEY);
    public static final Codec<ChickenVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(ModelAndTexture.codec(ModelType.CODEC, ModelType.NORMAL).forGetter(ChickenVariant::modelAndTexture), SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(ChickenVariant::spawnConditions)).apply(instance, ChickenVariant::new));

    private ChickenVariant(ModelAndTexture<ModelType> modelAndTexture) {
        this(modelAndTexture, SpawnPrioritySelectors.EMPTY);
    }

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }

    public static enum ModelType implements StringIdentifiable
    {
        NORMAL("normal"),
        COLD("cold");

        public static final Codec<ModelType> CODEC;
        private final String name;

        private ModelType(String name) {
            this.name = name;
        }

        public String asString() {
            return this.name;
        }

        static {
            CODEC = StringIdentifiable.createCodec(ModelType::values);
        }
    }
}

