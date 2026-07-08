/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5321
 *  net.minecraft.class_7923
 *  net.minecraft.class_9331
 *  net.minecraft.class_9331$class_9332
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.core.registries.ModRegistries;
import backported.updates.foundation.core.CoreRegistry;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_9331;

public class ModDataComponents {
    public static final CoreRegistry<class_9331<?>> COMPONENTS = CoreRegistry.create(class_7923.field_49658, "minecraft");
    public static final Supplier<class_9331<class_5321<ChickenVariant>>> CHICKEN_VARIANT = ModDataComponents.register("chicken/variant", builder -> builder.method_57881(class_5321.method_39154(ModRegistries.CHICKEN_VARIANT_KEY)).method_57882(class_5321.method_56038(ModRegistries.CHICKEN_VARIANT_KEY)));

    public static <T> Supplier<class_9331<T>> register(String key, UnaryOperator<class_9331.class_9332<T>> operator) {
        return COMPONENTS.register(key, () -> ((class_9331.class_9332)operator.apply(class_9331.method_57873())).method_57880());
    }
}

