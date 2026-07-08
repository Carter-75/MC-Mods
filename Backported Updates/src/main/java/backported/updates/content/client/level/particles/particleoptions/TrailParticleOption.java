/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.dynamic.Codecs
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodecs
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.client.level.particles.particleoptions;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.core.util.AdditionalCodecs;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.codec.PacketCodec;

public record TrailParticleOption(Vec3d target, int color, int duration) implements ParticleEffect
{
    public static final MapCodec<TrailParticleOption> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Vec3d.CODEC.fieldOf("target").forGetter(TrailParticleOption::target), AdditionalCodecs.RGB_COLOR_CODEC.fieldOf("color").forGetter(TrailParticleOption::color), Codecs.POSITIVE_INT.fieldOf("duration").forGetter(TrailParticleOption::duration)).apply(instance, TrailParticleOption::new));
    public static final PacketCodec<RegistryByteBuf, TrailParticleOption> STREAM_CODEC = PacketCodec.tuple(AdditionalCodecs.VEC3_STREAM_CODEC, TrailParticleOption::target, (PacketCodec)PacketCodecs.INTEGER, TrailParticleOption::color, (PacketCodec)PacketCodecs.VAR_INT, TrailParticleOption::duration, TrailParticleOption::new);

    public ParticleType<?> getType() {
        return ModParticles.TRAIL.get();
    }
}

