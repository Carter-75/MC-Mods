/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_3532
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util;

import kotlin.Metadata;
import net.minecraft.class_3532;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\t\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/util/Easing;", "", "<init>", "()V", "", "a", "b", "delta", "easeInOutQuad", "(FFF)F", "value", "min", "max", "smoothStep", "derelict"})
public final class Easing {
    @NotNull
    public static final Easing INSTANCE = new Easing();

    private Easing() {
    }

    public final float easeInOutQuad(float a, float b, float delta) {
        float d = delta < 0.5f ? 2.0f * delta * delta : 1.0f - (-2.0f * delta + 2.0f) * (-2.0f * delta + 2.0f) * 0.5f;
        return class_3532.method_16439((float)d, (float)a, (float)b);
    }

    public final float smoothStep(float value, float min, float max) {
        float x = class_3532.method_15363((float)((value - min) / (max - min)), (float)0.0f, (float)1.0f);
        return x * x * (3.0f - 2.0f * x);
    }

    public static /* synthetic */ float smoothStep$default(Easing easing, float f, float f2, float f3, int n, Object object) {
        if ((n & 2) != 0) {
            f2 = 0.0f;
        }
        if ((n & 4) != 0) {
            f3 = 1.0f;
        }
        return easing.smoothStep(f, f2, f3);
    }
}

