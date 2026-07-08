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
 *  net.minecraft.registry.entry.RegistryEntryList
 *  net.minecraft.registry.RegistryCodecs
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.api.variant.spawn.check;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;

public record BiomeCheck(RegistryEntryList<Biome> requiredBiomes) implements SpawnCondition
{
    public static final MapCodec<BiomeCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(RegistryCodecs.entryList(RegistryKeys.BIOME).fieldOf("biomes").forGetter(BiomeCheck::requiredBiomes)).apply(instance, BiomeCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return this.requiredBiomes.contains(context.biome());
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

