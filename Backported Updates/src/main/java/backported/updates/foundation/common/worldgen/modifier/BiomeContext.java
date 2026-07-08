/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.biome.SpawnSettings
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.world.biome.source.MultiNoiseBiomeSourceParameterList$Preset
 */
package backported.updates.foundation.common.worldgen.modifier;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.source.MultiNoiseBiomeSourceParameterList;

public interface BiomeContext {
    public static final Predicate<BiomeContext> OVERWORLD_BIOME = context -> MultiNoiseBiomeSourceParameterList.Preset.OVERWORLD.biomeStream().anyMatch(context::is);

    public RegistryKey<Biome> resource();

    public Biome biome();

    public boolean is(TagKey<Biome> var1);

    public boolean is(RegistryKey<Biome> var1);

    public boolean is(Predicate<BiomeContext> var1);

    public boolean hasFeature(RegistryKey<PlacedFeature> var1);

    default public boolean hasEntity(Supplier<EntityType<?>> entities) {
        return this.hasEntity((Set<Supplier<EntityType<?>>>)ImmutableSet.of(entities));
    }

    default public boolean hasEntity(Set<Supplier<EntityType<?>>> entitySet) {
        Set entities = entitySet.stream().map(Supplier::get).collect(Collectors.toSet());
        SpawnSettings settings = this.biome().getSpawnSettings();
        return Arrays.stream(SpawnGroup.values()).flatMap(category -> settings.getSpawnEntries(category).getEntries().stream()).anyMatch(spawner -> entities.contains(spawner.type));
    }
}

