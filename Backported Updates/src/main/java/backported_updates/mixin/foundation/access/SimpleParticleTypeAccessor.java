/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.particle.SimpleParticleType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import net.minecraft.particle.SimpleParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={SimpleParticleType.class})
public interface SimpleParticleTypeAccessor {
    @Invoker(value="<init>")
    public static SimpleParticleType createSimpleParticleType(boolean overrideLimiter) {
        throw new AssertionError();
    }
}

