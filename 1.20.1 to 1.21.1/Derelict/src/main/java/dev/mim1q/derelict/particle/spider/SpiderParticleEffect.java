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
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394
 *  net.minecraft.class_2394$class_2395
 *  net.minecraft.class_2396
 *  net.minecraft.class_2540
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.particle.spider;

import com.mojang.brigadier.StringReader;
import com.mojang.serialization.Codec;
import dev.mim1q.derelict.init.ModParticles;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2540;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0016B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "Lnet/minecraft/class_2394;", "Lnet/minecraft/class_2396;", "type", "Lnet/minecraft/class_2350;", "direction", "<init>", "(Lnet/minecraft/class_2396;Lnet/minecraft/class_2350;)V", "getType", "()Lnet/minecraft/class_2396;", "Lnet/minecraft/class_2540;", "buf", "", "write", "(Lnet/minecraft/class_2540;)V", "", "asString", "()Ljava/lang/String;", "Lnet/minecraft/class_2396;", "Lnet/minecraft/class_2350;", "getDirection", "()Lnet/minecraft/class_2350;", "Companion", "ParametersFactory", "derelict"})
public final class SpiderParticleEffect
implements class_2394 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_2396<SpiderParticleEffect> type;
    @NotNull
    private final class_2350 direction;
    @NotNull
    private static final Codec<SpiderParticleEffect> CODEC;

    public SpiderParticleEffect(@NotNull class_2396<SpiderParticleEffect> type, @NotNull class_2350 direction) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        this.type = type;
        this.direction = direction;
    }

    @NotNull
    public final class_2350 getDirection() {
        return this.direction;
    }

    @NotNull
    public class_2396<SpiderParticleEffect> method_10295() {
        return this.type;
    }

    public void method_10294(@NotNull class_2540 buf) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        buf.writeInt(this.direction.method_10146());
    }

    @NotNull
    public String method_10293() {
        return "" + class_7923.field_41180.method_10221(this.type) + this.direction;
    }

    private static final SpiderParticleEffect CODEC$lambda$0(int direction) {
        class_2396 class_23962 = ModParticles.INSTANCE.getSPIDER();
        class_2350 class_23502 = class_2350.method_10143((int)direction);
        Intrinsics.checkNotNullExpressionValue((Object)class_23502, (String)"byId(...)");
        return new SpiderParticleEffect((class_2396<SpiderParticleEffect>)class_23962, class_23502);
    }

    private static final SpiderParticleEffect CODEC$lambda$1(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (SpiderParticleEffect)$tmp0.invoke(p0);
    }

    private static final Integer CODEC$lambda$2(SpiderParticleEffect it) {
        return it.direction.method_10146();
    }

    private static final Integer CODEC$lambda$3(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Integer)$tmp0.invoke(p0);
    }

    static {
        Codec codec = Codec.INT.xmap(arg_0 -> SpiderParticleEffect.CODEC$lambda$1(SpiderParticleEffect::CODEC$lambda$0, arg_0), arg_0 -> SpiderParticleEffect.CODEC$lambda$3(SpiderParticleEffect::CODEC$lambda$2, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"xmap(...)");
        CODEC = codec;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect$Companion;", "", "<init>", "()V", "Lcom/mojang/serialization/Codec;", "Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "CODEC", "Lcom/mojang/serialization/Codec;", "getCODEC", "()Lcom/mojang/serialization/Codec;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Codec<SpiderParticleEffect> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\t\u0010\r\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect$ParametersFactory;", "Lnet/minecraft/class_2394$class_2395;", "Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "<init>", "()V", "Lnet/minecraft/class_2396;", "particleType", "Lcom/mojang/brigadier/StringReader;", "stringReader", "read", "(Lnet/minecraft/class_2396;Lcom/mojang/brigadier/StringReader;)Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "Lnet/minecraft/class_2540;", "packetByteBuf", "(Lnet/minecraft/class_2396;Lnet/minecraft/class_2540;)Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "derelict"})
    public static final class ParametersFactory
    implements class_2394.class_2395<SpiderParticleEffect> {
        @NotNull
        public static final ParametersFactory INSTANCE = new ParametersFactory();

        private ParametersFactory() {
        }

        @NotNull
        public SpiderParticleEffect read(@NotNull class_2396<SpiderParticleEffect> particleType, @NotNull StringReader stringReader) {
            Intrinsics.checkNotNullParameter(particleType, (String)"particleType");
            Intrinsics.checkNotNullParameter((Object)stringReader, (String)"stringReader");
            stringReader.expect(' ');
            class_2350 class_23502 = class_2350.method_10143((int)stringReader.readInt());
            Intrinsics.checkNotNullExpressionValue((Object)class_23502, (String)"byId(...)");
            return new SpiderParticleEffect(particleType, class_23502);
        }

        @NotNull
        public SpiderParticleEffect read(@NotNull class_2396<SpiderParticleEffect> particleType, @NotNull class_2540 packetByteBuf) {
            Intrinsics.checkNotNullParameter(particleType, (String)"particleType");
            Intrinsics.checkNotNullParameter((Object)packetByteBuf, (String)"packetByteBuf");
            class_2350 class_23502 = class_2350.method_10143((int)packetByteBuf.readInt());
            Intrinsics.checkNotNullExpressionValue((Object)class_23502, (String)"byId(...)");
            return new SpiderParticleEffect(particleType, class_23502);
        }
    }
}

