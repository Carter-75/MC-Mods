/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  net.minecraft.class_2400
 *  net.minecraft.class_7923
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported_updates.mixin.foundation.access.SimpleParticleTypeAccessor;
import com.mojang.serialization.MapCodec;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2400;
import net.minecraft.class_7923;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public class ParticleRegistry {
    private final CoreRegistry<class_2396<?>> particles;

    private ParticleRegistry(String modId) {
        this.particles = CoreRegistry.create(class_7923.field_41180, modId);
    }

    public static ParticleRegistry create(String modId) {
        return new ParticleRegistry(modId);
    }

    public Supplier<class_2400> register(String name) {
        return this.register(name, false);
    }

    public Supplier<class_2400> register(String name, boolean overrideLimiter) {
        return this.particles.register(name, () -> SimpleParticleTypeAccessor.createSimpleParticleType(overrideLimiter));
    }

    public <T extends class_2394> Supplier<class_2396<T>> register(String name, boolean overrideLimiter, final Function<class_2396<T>, MapCodec<T>> deserializer, final Function<class_2396<T>, class_9139<? super class_9129, T>> factory) {
        return this.particles.register(name, () -> new class_2396<T>(this, overrideLimiter){

            public MapCodec<T> method_29138() {
                return (MapCodec)deserializer.apply(this);
            }

            public class_9139<? super class_9129, T> method_56179() {
                return (class_9139)factory.apply(this);
            }
        });
    }

    public void register() {
        this.particles.register();
    }

    public CoreRegistry<class_2396<?>> registry() {
        return this.particles;
    }
}

