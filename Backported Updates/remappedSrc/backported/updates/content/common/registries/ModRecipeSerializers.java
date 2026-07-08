/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1865
 *  net.minecraft.class_1866
 *  net.minecraft.class_7923
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.crafting.BundleColoring;
import backported.updates.foundation.core.CoreRegistry;
import java.util.function.Supplier;
import net.minecraft.class_1865;
import net.minecraft.class_1866;
import net.minecraft.class_7923;

public class ModRecipeSerializers {
    public static final CoreRegistry<class_1865<?>> SERIALIZERS = CoreRegistry.create(class_7923.field_41189, "minecraft");
    public static final Supplier<class_1865<BundleColoring>> BUNDLE_COLORING = SERIALIZERS.register("crafting_special_bundlecoloring", () -> new class_1866(BundleColoring::new));
}

