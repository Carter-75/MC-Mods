/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3031
 *  net.minecraft.class_3037
 *  net.minecraft.class_3491
 *  net.minecraft.class_3828
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init.worldgen;

import com.mojang.serialization.Codec;
import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.world.feature.LocalGravityProcessor;
import dev.mim1q.derelict.world.feature.NbtFeature;
import dev.mim1q.derelict.world.feature.SpiderSilkParabola;
import dev.mim1q.derelict.world.feature.SpiderSilkPillar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3491;
import net.minecraft.class_3828;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J9\u0010\r\u001a\u00028\u0001\"\b\b\u0000\u0010\u0007*\u00020\u0006\"\u000e\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\"\b\b\u0000\u0010\u0010*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/init/worldgen/ModFeatures;", "", "<init>", "()V", "", "init", "Lnet/minecraft/class_3037;", "C", "Lnet/minecraft/class_3031;", "F", "", "name", "feature", "register", "(Ljava/lang/String;Lnet/minecraft/class_3031;)Lnet/minecraft/class_3031;", "Lnet/minecraft/class_3491;", "P", "id", "Lcom/mojang/serialization/Codec;", "codec", "Lnet/minecraft/class_3828;", "registerProcessor", "(Ljava/lang/String;Lcom/mojang/serialization/Codec;)Lnet/minecraft/class_3828;", "Ldev/mim1q/derelict/world/feature/LocalGravityProcessor;", "LOCAL_GRAVITY_PROCESSOR", "Lnet/minecraft/class_3828;", "getLOCAL_GRAVITY_PROCESSOR", "()Lnet/minecraft/class_3828;", "derelict"})
public final class ModFeatures {
    @NotNull
    public static final ModFeatures INSTANCE = new ModFeatures();
    @NotNull
    private static final class_3828<LocalGravityProcessor> LOCAL_GRAVITY_PROCESSOR = INSTANCE.registerProcessor("local_gravity", LocalGravityProcessor.Companion.getCODEC());

    private ModFeatures() {
    }

    @NotNull
    public final class_3828<LocalGravityProcessor> getLOCAL_GRAVITY_PROCESSOR() {
        return LOCAL_GRAVITY_PROCESSOR;
    }

    public final void init() {
        this.register("spider_silk_pillar", (class_3031)new SpiderSilkPillar());
        this.register("spider_silk_parabola", (class_3031)new SpiderSilkParabola());
        this.register("nbt_feature", (class_3031)new NbtFeature());
    }

    private final <C extends class_3037, F extends class_3031<C>> F register(String name, F feature) {
        Object object = class_2378.method_10230((class_2378)class_7923.field_41144, (class_2960)Derelict.INSTANCE.id(name), feature);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (F)((class_3031)object);
    }

    private final <P extends class_3491> class_3828<P> registerProcessor(String id, Codec<P> codec) {
        Object object = class_2378.method_10230((class_2378)class_7923.field_41161, (class_2960)Derelict.INSTANCE.id(id), () -> ModFeatures.registerProcessor$lambda$0(codec));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (class_3828)object;
    }

    private static final Codec registerProcessor$lambda$0(Codec $codec) {
        Intrinsics.checkNotNullParameter((Object)$codec, (String)"$codec");
        return $codec;
    }
}

