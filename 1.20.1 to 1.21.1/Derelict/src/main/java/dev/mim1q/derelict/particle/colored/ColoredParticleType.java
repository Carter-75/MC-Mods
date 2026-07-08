/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.particle.colored;

import com.mojang.serialization.Codec;
import dev.mim1q.derelict.particle.colored.ColoredParticleEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticleType;", "Lnet/minecraft/class_2396;", "Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;", "<init>", "()V", "Lcom/mojang/serialization/Codec;", "getCodec", "()Lcom/mojang/serialization/Codec;", "", "color", "Lnet/minecraft/class_2394;", "get", "(I)Lnet/minecraft/class_2394;", "Companion", "derelict"})
public final class ColoredParticleType
extends class_2396<ColoredParticleEffect> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    private ColoredParticleType() {
        super(true, ColoredParticleEffect.Companion.getPARAMETERS_FACTORY());
    }

    @NotNull
    public Codec<ColoredParticleEffect> method_29138() {
        return ColoredParticleEffect.Companion.createCodec((class_2396<ColoredParticleEffect>)((class_2396)this));
    }

    @NotNull
    public final class_2394 get(int color) {
        return new ColoredParticleEffect(this, color);
    }

    public /* synthetic */ ColoredParticleType(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticleType$Companion;", "", "<init>", "()V", "Ldev/mim1q/derelict/particle/colored/ColoredParticleType;", "create", "()Ldev/mim1q/derelict/particle/colored/ColoredParticleType;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ColoredParticleType create() {
            return new ColoredParticleType(null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

