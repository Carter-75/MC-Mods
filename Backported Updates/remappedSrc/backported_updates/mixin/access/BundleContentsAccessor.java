/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_9276
 *  org.apache.commons.lang3.math.Fraction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.class_1799;
import net.minecraft.class_9276;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_9276.class})
public interface BundleContentsAccessor {
    @Invoker
    public static Fraction callGetWeight(class_1799 stack) {
        throw new UnsupportedOperationException();
    }
}

