/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.passive.WolfVariant
 */
package backported.updates.content.common.api.variant.vanilla;

import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.vanilla.VanillaWolfVariantSpawnSelector;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.passive.WolfVariant;

public class VanillaWolfVariantRegistry {
    private static final Map<RegistryKey<WolfVariant>, VanillaWolfVariantSpawnSelector> SELECTORS = new ConcurrentHashMap<RegistryKey<WolfVariant>, VanillaWolfVariantSpawnSelector>();

    public static void register(RegistryKey<WolfVariant> key, VanillaWolfVariantSpawnSelector selector) {
        SELECTORS.put(key, selector);
    }

    public static Collection<VanillaWolfVariantSpawnSelector> getSelectors() {
        return Collections.unmodifiableCollection(SELECTORS.values());
    }

    public static Optional<VanillaWolfVariantSpawnSelector> getSelector(RegistryKey<WolfVariant> key) {
        return Optional.ofNullable(SELECTORS.get(key));
    }

    public static Optional<RegistryEntry<WolfVariant>> selectVariantForSpawn(SpawnContext context, Random random) {
        if (SELECTORS.isEmpty()) {
            return Optional.empty();
        }
        return PriorityProvider.pick(SELECTORS.values().stream(), selector -> selector, random, context).map(VanillaWolfVariantSpawnSelector::vanillaVariant);
    }

    public static void clear() {
        SELECTORS.clear();
    }

    public static boolean isEmpty() {
        return SELECTORS.isEmpty();
    }
}

