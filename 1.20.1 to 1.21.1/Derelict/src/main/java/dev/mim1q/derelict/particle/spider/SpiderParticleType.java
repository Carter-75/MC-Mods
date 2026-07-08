/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394$class_2395
 *  net.minecraft.class_2396
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.particle.spider;

import com.mojang.serialization.Codec;
import dev.mim1q.derelict.particle.spider.SpiderParticleEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticleType;", "Lnet/minecraft/class_2396;", "Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "<init>", "()V", "Lcom/mojang/serialization/Codec;", "getCodec", "()Lcom/mojang/serialization/Codec;", "Lnet/minecraft/class_2350;", "direction", "get", "(Lnet/minecraft/class_2350;)Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "Companion", "derelict"})
public final class SpiderParticleType
extends class_2396<SpiderParticleEffect> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public SpiderParticleType() {
        super(true, (class_2394.class_2395)SpiderParticleEffect.ParametersFactory.INSTANCE);
    }

    @NotNull
    public Codec<SpiderParticleEffect> method_29138() {
        return SpiderParticleEffect.Companion.getCODEC();
    }

    @NotNull
    public final SpiderParticleEffect get(@NotNull class_2350 direction) {
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        return new SpiderParticleEffect((class_2396<SpiderParticleEffect>)((class_2396)this), direction);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticleType$Companion;", "", "<init>", "()V", "Ldev/mim1q/derelict/particle/spider/SpiderParticleType;", "create", "()Ldev/mim1q/derelict/particle/spider/SpiderParticleType;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SpiderParticleType create() {
            return new SpiderParticleType();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

