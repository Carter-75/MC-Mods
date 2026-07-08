/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4096$class_5397
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.feature.ai.goal;

import net.minecraft.class_4096;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_4096.class_5397.class})
public interface JitteredLinearRetryAccessor {
    @Invoker(value="<init>")
    public static class_4096.class_5397 create(class_5819 randomSource, long l2) {
        throw new AssertionError();
    }
}

