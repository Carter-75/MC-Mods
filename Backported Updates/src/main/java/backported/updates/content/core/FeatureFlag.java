/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.core;

@FunctionalInterface
public interface FeatureFlag {
    public static final FeatureFlag DEFAULT = () -> true;
    public static final FeatureFlag COPPER_AGE = () -> false;
    public static final FeatureFlag MOUNTS_OF_MAYHEM = () -> false;

    public boolean isEnabled();
}

