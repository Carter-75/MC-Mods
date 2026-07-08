/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0002\u001a\u0011\u0010\u0001\u001a\u00020\u0004*\u00020\u0004\u00a2\u0006\u0004\b\u0001\u0010\u0005\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0005\u001a!\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00070\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"", "radians", "(F)F", "degrees", "", "(D)D", "Lnet/minecraft/class_1297;", "Lnet/minecraft/class_243;", "offset", "kotlin.jvm.PlatformType", "getLocallyOffsetPos", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "derelict"})
public final class MathExtensionsKt {
    public static final float radians(float $this$radians) {
        return $this$radians * ((float)Math.PI / 180);
    }

    public static final float degrees(float $this$degrees) {
        return $this$degrees * 57.295776f;
    }

    public static final double radians(double $this$radians) {
        return $this$radians * 0.01745329238474369;
    }

    public static final double degrees(double $this$degrees) {
        return $this$degrees * 57.2957763671875;
    }

    public static final class_243 getLocallyOffsetPos(@NotNull class_1297 $this$getLocallyOffsetPos, @NotNull class_243 offset) {
        Intrinsics.checkNotNullParameter((Object)$this$getLocallyOffsetPos, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        return $this$getLocallyOffsetPos.method_19538().method_1019(offset.method_1024(-MathExtensionsKt.radians($this$getLocallyOffsetPos.method_43078())));
    }
}

