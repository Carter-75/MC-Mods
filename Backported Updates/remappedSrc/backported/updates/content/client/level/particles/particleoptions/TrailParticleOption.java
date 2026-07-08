/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  net.minecraft.class_243
 *  net.minecraft.class_5699
 *  net.minecraft.class_9129
 *  net.minecraft.class_9135
 *  net.minecraft.class_9139
 */
package backported.updates.content.client.level.particles.particleoptions;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.core.util.AdditionalCodecs;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_243;
import net.minecraft.class_5699;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;

public record TrailParticleOption(class_243 target, int color, int duration) implements class_2394
{
    public static final MapCodec<TrailParticleOption> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_243.field_38277.fieldOf("target").forGetter(TrailParticleOption::target), (App)AdditionalCodecs.RGB_COLOR_CODEC.fieldOf("color").forGetter(TrailParticleOption::color), (App)class_5699.field_33442.fieldOf("duration").forGetter(TrailParticleOption::duration)).apply((Applicative)instance, TrailParticleOption::new));
    public static final class_9139<class_9129, TrailParticleOption> STREAM_CODEC = class_9139.method_56436(AdditionalCodecs.VEC3_STREAM_CODEC, TrailParticleOption::target, (class_9139)class_9135.field_49675, TrailParticleOption::color, (class_9139)class_9135.field_48550, TrailParticleOption::duration, TrailParticleOption::new);

    public class_2396<?> method_10295() {
        return ModParticles.TRAIL.get();
    }
}

