/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2400
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import net.minecraft.class_2400;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_2400.class})
public interface SimpleParticleTypeAccessor {
    @Invoker(value="<init>")
    public static class_2400 createSimpleParticleType(boolean overrideLimiter) {
        throw new AssertionError();
    }
}

