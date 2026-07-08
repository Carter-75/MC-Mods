/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.particle.SimpleParticleType
 *  net.minecraft.registry.Registries
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported_updates.mixin.foundation.access.SimpleParticleTypeAccessor;
import com.mojang.serialization.MapCodec;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public class ParticleRegistry {
    private final CoreRegistry<ParticleType<?>> particles;

    private ParticleRegistry(String modId) {
        this.particles = CoreRegistry.create(Registries.PARTICLE_TYPE, modId);
    }

    public static ParticleRegistry create(String modId) {
        return new ParticleRegistry(modId);
    }

    public Supplier<SimpleParticleType> register(String name) {
        return this.register(name, false);
    }

    public Supplier<SimpleParticleType> register(String name, boolean overrideLimiter) {
        return this.particles.register(name, () -> SimpleParticleTypeAccessor.createSimpleParticleType(overrideLimiter));
    }

    public <T extends ParticleEffect> Supplier<ParticleType<T>> register(String name, boolean overrideLimiter, final Function<ParticleType<T>, MapCodec<T>> deserializer, final Function<ParticleType<T>, PacketCodec<? super RegistryByteBuf, T>> factory) {
        return this.particles.register(name, () -> new ParticleType<T>(overrideLimiter){

            public MapCodec<T> getCodec() {
                return (MapCodec)deserializer.apply(this);
            }

            public PacketCodec<? super RegistryByteBuf, T> getPacketCodec() {
                return (PacketCodec)factory.apply(this);
            }
        });
    }

    public void register() {
        this.particles.register();
    }

    public CoreRegistry<ParticleType<?>> registry() {
        return this.particles;
    }
}

