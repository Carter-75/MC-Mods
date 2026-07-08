/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.StringReader
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2394
 *  net.minecraft.class_2394$class_2395
 *  net.minecraft.class_2396
 *  net.minecraft.class_2540
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.particle.colored;

import com.mojang.brigadier.StringReader;
import com.mojang.serialization.Codec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2540;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u001d\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0012R\u001b\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\u0004\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b\u0006\u0010\u0015\u00a8\u0006\""}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;", "Lnet/minecraft/class_2394;", "Ljava/lang/Record;", "Lnet/minecraft/class_2396;", "type", "", "color", "<init>", "(Lnet/minecraft/class_2396;I)V", "getType", "()Lnet/minecraft/class_2396;", "Lnet/minecraft/class_2540;", "buf", "", "write", "(Lnet/minecraft/class_2540;)V", "", "asString", "()Ljava/lang/String;", "component1", "component2", "()I", "copy", "(Lnet/minecraft/class_2396;I)Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Lnet/minecraft/class_2396;", "I", "Companion", "derelict"})
public final class ColoredParticleEffect
extends Record
implements class_2394 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_2396<?> type;
    private final int color;
    @NotNull
    private static final class_2394.class_2395<ColoredParticleEffect> PARAMETERS_FACTORY = (class_2394.class_2395)new class_2394.class_2395<ColoredParticleEffect>(){

        public ColoredParticleEffect read(class_2396<ColoredParticleEffect> particleType, StringReader stringReader) {
            Intrinsics.checkNotNullParameter(particleType, (String)"particleType");
            Intrinsics.checkNotNullParameter((Object)stringReader, (String)"stringReader");
            stringReader.expect(' ');
            return new ColoredParticleEffect(particleType, stringReader.readInt());
        }

        public ColoredParticleEffect read(class_2396<ColoredParticleEffect> particleType, class_2540 packetByteBuf) {
            Intrinsics.checkNotNullParameter(particleType, (String)"particleType");
            Intrinsics.checkNotNullParameter((Object)packetByteBuf, (String)"packetByteBuf");
            return new ColoredParticleEffect(particleType, packetByteBuf.readInt());
        }
    };

    public ColoredParticleEffect(@NotNull class_2396<?> type, int color) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        this.type = type;
        this.color = color;
    }

    @NotNull
    public final class_2396<?> type() {
        return this.type;
    }

    public final int color() {
        return this.color;
    }

    @NotNull
    public class_2396<?> method_10295() {
        return this.type;
    }

    public void method_10294(@NotNull class_2540 buf) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        buf.writeInt(this.color);
    }

    @NotNull
    public String method_10293() {
        return "" + class_7923.field_41180.method_10221(this.type) + this.color;
    }

    @NotNull
    public final class_2396<?> component1() {
        return this.type;
    }

    public final int component2() {
        return this.color;
    }

    @NotNull
    public final ColoredParticleEffect copy(@NotNull class_2396<?> type, int color) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        return new ColoredParticleEffect(type, color);
    }

    public static /* synthetic */ ColoredParticleEffect copy$default(ColoredParticleEffect coloredParticleEffect, class_2396 class_23962, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            class_23962 = coloredParticleEffect.type;
        }
        if ((n2 & 2) != 0) {
            n = coloredParticleEffect.color;
        }
        return coloredParticleEffect.copy(class_23962, n);
    }

    @Override
    @NotNull
    public String toString() {
        return "ColoredParticleEffect(type=" + this.type + ", color=" + this.color + ")";
    }

    @Override
    public int hashCode() {
        int result = this.type.hashCode();
        result = result * 31 + Integer.hashCode(this.color);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColoredParticleEffect)) {
            return false;
        }
        ColoredParticleEffect coloredParticleEffect = (ColoredParticleEffect)other;
        if (!Intrinsics.areEqual(this.type, coloredParticleEffect.type)) {
            return false;
        }
        return this.color == coloredParticleEffect.color;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\b\u0010\tR#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2396;", "Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;", "type", "Lcom/mojang/serialization/Codec;", "createCodec", "(Lnet/minecraft/class_2396;)Lcom/mojang/serialization/Codec;", "Lnet/minecraft/class_2394$class_2395;", "PARAMETERS_FACTORY", "Lnet/minecraft/class_2394$class_2395;", "getPARAMETERS_FACTORY", "()Lnet/minecraft/class_2394$class_2395;", "getPARAMETERS_FACTORY$annotations", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2394.class_2395<ColoredParticleEffect> getPARAMETERS_FACTORY() {
            return PARAMETERS_FACTORY;
        }

        public static /* synthetic */ void getPARAMETERS_FACTORY$annotations() {
        }

        @NotNull
        public final Codec<ColoredParticleEffect> createCodec(@NotNull class_2396<ColoredParticleEffect> type) {
            Intrinsics.checkNotNullParameter(type, (String)"type");
            Codec codec = Codec.INT.xmap(arg_0 -> Companion.createCodec$lambda$1(arg_0 -> Companion.createCodec$lambda$0(type, arg_0), arg_0), arg_0 -> Companion.createCodec$lambda$3(Companion::createCodec$lambda$2, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"xmap(...)");
            return codec;
        }

        private static final ColoredParticleEffect createCodec$lambda$0(class_2396 $type, int color) {
            Intrinsics.checkNotNullParameter((Object)$type, (String)"$type");
            return new ColoredParticleEffect($type, color);
        }

        private static final ColoredParticleEffect createCodec$lambda$1(Function1 $tmp0, Object p0) {
            Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
            return (ColoredParticleEffect)$tmp0.invoke(p0);
        }

        private static final Integer createCodec$lambda$2(ColoredParticleEffect coloredParticleEffect) {
            Intrinsics.checkNotNullParameter((Object)coloredParticleEffect, (String)"<destruct>");
            int color = coloredParticleEffect.component2();
            return color;
        }

        private static final Integer createCodec$lambda$3(Function1 $tmp0, Object p0) {
            Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
            return (Integer)$tmp0.invoke(p0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

