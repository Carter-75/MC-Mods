/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2794
 *  net.minecraft.class_3031
 *  net.minecraft.class_3111
 *  net.minecraft.class_5281
 *  net.minecraft.class_5431
 *  net.minecraft.class_5819
 *  net.minecraft.class_5821
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.world.feature;

import dev.mim1q.derelict.world.feature.SilkPlacer;
import dev.mim1q.derelict.world.feature.SpiderSilkPillarKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2794;
import net.minecraft.class_3031;
import net.minecraft.class_3111;
import net.minecraft.class_5281;
import net.minecraft.class_5431;
import net.minecraft.class_5819;
import net.minecraft.class_5821;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Ldev/mim1q/derelict/world/feature/SpiderSilkPillar;", "Lnet/minecraft/class_3031;", "Lnet/minecraft/class_3111;", "<init>", "()V", "config", "Lnet/minecraft/class_5281;", "world", "Lnet/minecraft/class_2794;", "chunkGenerator", "Lnet/minecraft/class_5819;", "random", "Lnet/minecraft/class_2338;", "origin", "", "generateIfValid", "(Lnet/minecraft/class_3111;Lnet/minecraft/class_5281;Lnet/minecraft/class_2794;Lnet/minecraft/class_5819;Lnet/minecraft/class_2338;)Z", "Lnet/minecraft/class_5821;", "context", "generate", "(Lnet/minecraft/class_5821;)Z", "derelict"})
public final class SpiderSilkPillar
extends class_3031<class_3111> {
    public SpiderSilkPillar() {
        super(class_3111.field_24893);
    }

    public boolean generateIfValid(@NotNull class_3111 config, @NotNull class_5281 world, @NotNull class_2794 chunkGenerator, @NotNull class_5819 random, @NotNull class_2338 origin) {
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)chunkGenerator, (String)"chunkGenerator");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        class_2338.class_2339 topPos = origin.method_25503();
        boolean found = false;
        for (int i = 0; i < 32; ++i) {
            class_2338 aboveTopPos = topPos.method_10084();
            if (world.method_8320((class_2338)topPos).method_26215() && world.method_8320(aboveTopPos).method_30368((class_1922)world, aboveTopPos, class_2350.field_11033, class_5431.field_25822)) {
                found = true;
                break;
            }
            topPos.method_33098(topPos.method_10264() + 1);
        }
        if (!found) {
            return false;
        }
        class_2338 topOrigin = topPos.method_10062();
        Pair randomDir = (Pair)ArraysKt.random((Object[])SpiderSilkPillarKt.access$getPOSSIBLE_DIRECTIONS$p(), (Random)((Random)Random.Default));
        double randomSlope = random.method_43058() * 0.3;
        return new SilkPlacer().generate((class_1936)world, random, (Function2<? super class_2338.class_2339, ? super Integer, Unit>)((Function2)(arg_0, arg_1) -> SpiderSilkPillar.generateIfValid$lambda$0(topOrigin, randomSlope, randomDir, arg_0, arg_1)), ((Number)randomDir.getSecond()).intValue());
    }

    public boolean method_13151(@NotNull class_5821<class_3111> context) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        return true;
    }

    private static final Unit generateIfValid$lambda$0(class_2338 $topOrigin, double $randomSlope, Pair $randomDir, class_2338.class_2339 it, int i) {
        Intrinsics.checkNotNullParameter((Object)$randomDir, (String)"$randomDir");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.method_10103($topOrigin.method_10263() + (int)Math.rint((double)i * $randomSlope * (double)((class_2382)$randomDir.getFirst()).method_10263()), $topOrigin.method_10264() - i, $topOrigin.method_10260() + (int)Math.rint((double)i * $randomSlope * (double)((class_2382)$randomDir.getFirst()).method_10260()));
        return Unit.INSTANCE;
    }
}

