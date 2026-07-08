/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5321
 *  net.minecraft.class_5819
 *  net.minecraft.class_6880
 *  net.minecraft.class_9346
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
import net.minecraft.class_5321;
import net.minecraft.class_5819;
import net.minecraft.class_6880;
import net.minecraft.class_9346;

public class VanillaWolfVariantRegistry {
    private static final Map<class_5321<class_9346>, VanillaWolfVariantSpawnSelector> SELECTORS = new ConcurrentHashMap<class_5321<class_9346>, VanillaWolfVariantSpawnSelector>();

    public static void register(class_5321<class_9346> key, VanillaWolfVariantSpawnSelector selector) {
        SELECTORS.put(key, selector);
    }

    public static Collection<VanillaWolfVariantSpawnSelector> getSelectors() {
        return Collections.unmodifiableCollection(SELECTORS.values());
    }

    public static Optional<VanillaWolfVariantSpawnSelector> getSelector(class_5321<class_9346> key) {
        return Optional.ofNullable(SELECTORS.get(key));
    }

    public static Optional<class_6880<class_9346>> selectVariantForSpawn(SpawnContext context, class_5819 random) {
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

