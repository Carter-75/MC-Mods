/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.api.variant.spawn.check.raw;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public record RawBiomeCheck(TagKey<Biome> requiredBiomes) implements SpawnCondition
{
    public static final MapCodec<RawBiomeCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(TagKey.unprefixedCodec(RegistryKeys.BIOME).fieldOf("biomes").forGetter(RawBiomeCheck::requiredBiomes)).apply(instance, RawBiomeCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return context.biome().isIn(this.requiredBiomes);
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

