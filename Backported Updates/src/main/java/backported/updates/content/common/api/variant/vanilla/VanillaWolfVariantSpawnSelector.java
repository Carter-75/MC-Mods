/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryElementCodec
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.entity.passive.WolfVariant
 */
package backported.updates.content.common.api.variant.vanilla;

import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryElementCodec;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.entity.passive.WolfVariant;

public record VanillaWolfVariantSpawnSelector(RegistryEntry<WolfVariant> vanillaVariant, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition>
{
    public static final Codec<VanillaWolfVariantSpawnSelector> CODEC = RecordCodecBuilder.create(instance -> instance.group(RegistryElementCodec.of(RegistryKeys.WOLF_VARIANT, WolfVariant.CODEC).fieldOf("vanilla_variant").forGetter(VanillaWolfVariantSpawnSelector::vanillaVariant), SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(VanillaWolfVariantSpawnSelector::spawnConditions)).apply(instance, VanillaWolfVariantSpawnSelector::new));

    public static VanillaWolfVariantSpawnSelector fallback(RegistryEntry<WolfVariant> variant, int priority) {
        return new VanillaWolfVariantSpawnSelector(variant, SpawnPrioritySelectors.fallback(priority));
    }

    public static VanillaWolfVariantSpawnSelector withCondition(RegistryEntry<WolfVariant> variant, SpawnCondition condition, int priority) {
        return new VanillaWolfVariantSpawnSelector(variant, SpawnPrioritySelectors.single(condition, priority));
    }

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }
}

