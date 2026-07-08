/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3532
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3532;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u001a%\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0005\u001a+\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017\"\u0017\u0010\u0018\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"", "start", "end", "delta", "lerpAngleRadians", "(FFF)F", "radians", "wrapRadians", "(F)F", "a", "b", "degreesDifference", "(FF)F", "from", "to", "max", "wrapDegrees", "T", "", "", "Lnet/minecraft/class_5819;", "random", "pickWeightedRandom", "(Ljava/util/Map;Lnet/minecraft/class_5819;)Ljava/lang/Object;", "TWO_PI", "F", "getTWO_PI", "()F", "derelict"})
public final class MathUtilsKt {
    private static final float TWO_PI = (float)Math.PI * 2;

    public static final float getTWO_PI() {
        return TWO_PI;
    }

    public static final float lerpAngleRadians(float start, float end, float delta) {
        return start + delta * MathUtilsKt.wrapRadians(end - start);
    }

    /*
     * WARNING - void declaration
     */
    public static final float wrapRadians(float radians) {
        void var1_1;
        float it = radians % TWO_PI;
        boolean bl = false;
        return it >= (float)Math.PI ? it - TWO_PI : (it < (float)(-Math.PI) ? it + TWO_PI : var1_1);
    }

    public static final float degreesDifference(float a, float b) {
        return Math.min(Math.abs(a - b), (float)360 - Math.abs(a - b));
    }

    public static final float wrapDegrees(float from, float to, float max) {
        float g;
        float f = class_3532.method_15393((float)(to - from));
        if (f > max) {
            f = max;
        }
        if (f < -max) {
            f = -max;
        }
        if ((g = from + f) < 0.0f) {
            g += 360.0f;
        } else if (g > 360.0f) {
            g -= 360.0f;
        }
        return g;
    }

    public static final <T> T pickWeightedRandom(@NotNull Map<T, Integer> $this$pickWeightedRandom, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter($this$pickWeightedRandom, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        int totalWeight = 0;
        Set<T> keys = $this$pickWeightedRandom.keySet();
        for (T key : keys) {
            Integer n = $this$pickWeightedRandom.get(key);
            Intrinsics.checkNotNull((Object)n);
            totalWeight += ((Number)n).intValue();
        }
        int randomWeight = random.method_43048(totalWeight);
        int currentWeight = 0;
        for (T key : keys) {
            Integer n = $this$pickWeightedRandom.get(key);
            Intrinsics.checkNotNull((Object)n);
            if ((currentWeight += ((Number)n).intValue()) < randomWeight) continue;
            return key;
        }
        return (T)CollectionsKt.first((Iterable)keys);
    }
}

