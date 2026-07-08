/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.common.api.variant;

import backported.updates.content.core.ModChecker;
import backported.updates.content.core.VanillaBackport;

@FunctionalInterface
public interface VariantSpawner {
    public static final VariantSpawner DEFAULT = () -> true;
    public static final VariantSpawner FARM_ANIMALS = () -> VanillaBackport.COMMON_CONFIG.hasFarmAnimalVariants.get() != false && !ModChecker.MIXED_LITTER_LOADED;

    public boolean apply();
}

