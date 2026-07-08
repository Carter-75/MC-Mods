/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3532
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util.extensions;

import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3532;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u001a7\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\b\u001a#\u0010\n\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\f\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0004\b\f\u0010\u000b\u001a#\u0010\r\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lnet/minecraft/class_630;", "", "pitch", "roll", "yaw", "delta", "", "setPartialAngles", "(Lnet/minecraft/class_630;FFFF)V", "setPartialAnglesDegrees", "setPartialPitch", "(Lnet/minecraft/class_630;FF)V", "setPartialRoll", "setPartialYaw", "derelict"})
public final class ModelExtensionsKt {
    public static final void setPartialAngles(@NotNull class_630 $this$setPartialAngles, float pitch, float roll, float yaw, float delta) {
        Intrinsics.checkNotNullParameter((Object)$this$setPartialAngles, (String)"<this>");
        ModelExtensionsKt.setPartialPitch($this$setPartialAngles, pitch, delta);
        ModelExtensionsKt.setPartialRoll($this$setPartialAngles, roll, delta);
        ModelExtensionsKt.setPartialYaw($this$setPartialAngles, yaw, delta);
    }

    public static /* synthetic */ void setPartialAngles$default(class_630 class_6302, float f, float f2, float f3, float f4, int n, Object object) {
        if ((n & 1) != 0) {
            f = class_6302.field_3654;
        }
        if ((n & 2) != 0) {
            f2 = class_6302.field_3674;
        }
        if ((n & 4) != 0) {
            f3 = class_6302.field_3675;
        }
        ModelExtensionsKt.setPartialAngles(class_6302, f, f2, f3, f4);
    }

    public static final void setPartialAnglesDegrees(@NotNull class_630 $this$setPartialAnglesDegrees, float pitch, float roll, float yaw, float delta) {
        Intrinsics.checkNotNullParameter((Object)$this$setPartialAnglesDegrees, (String)"<this>");
        ModelExtensionsKt.setPartialAngles($this$setPartialAnglesDegrees, MathExtensionsKt.radians(pitch), MathExtensionsKt.radians(roll), MathExtensionsKt.radians(yaw), delta);
    }

    public static /* synthetic */ void setPartialAnglesDegrees$default(class_630 class_6302, float f, float f2, float f3, float f4, int n, Object object) {
        if ((n & 1) != 0) {
            f = class_6302.field_3654;
        }
        if ((n & 2) != 0) {
            f2 = class_6302.field_3674;
        }
        if ((n & 4) != 0) {
            f3 = class_6302.field_3675;
        }
        ModelExtensionsKt.setPartialAnglesDegrees(class_6302, f, f2, f3, f4);
    }

    public static final void setPartialPitch(@NotNull class_630 $this$setPartialPitch, float pitch, float delta) {
        Intrinsics.checkNotNullParameter((Object)$this$setPartialPitch, (String)"<this>");
        $this$setPartialPitch.field_3654 = class_3532.method_16439((float)delta, (float)$this$setPartialPitch.field_3654, (float)pitch);
    }

    public static /* synthetic */ void setPartialPitch$default(class_630 class_6302, float f, float f2, int n, Object object) {
        if ((n & 1) != 0) {
            f = class_6302.field_3654;
        }
        ModelExtensionsKt.setPartialPitch(class_6302, f, f2);
    }

    public static final void setPartialRoll(@NotNull class_630 $this$setPartialRoll, float roll, float delta) {
        Intrinsics.checkNotNullParameter((Object)$this$setPartialRoll, (String)"<this>");
        $this$setPartialRoll.field_3674 = class_3532.method_16439((float)delta, (float)$this$setPartialRoll.field_3674, (float)roll);
    }

    public static /* synthetic */ void setPartialRoll$default(class_630 class_6302, float f, float f2, int n, Object object) {
        if ((n & 1) != 0) {
            f = class_6302.field_3674;
        }
        ModelExtensionsKt.setPartialRoll(class_6302, f, f2);
    }

    public static final void setPartialYaw(@NotNull class_630 $this$setPartialYaw, float yaw, float delta) {
        Intrinsics.checkNotNullParameter((Object)$this$setPartialYaw, (String)"<this>");
        $this$setPartialYaw.field_3675 = class_3532.method_16439((float)delta, (float)$this$setPartialYaw.field_3675, (float)yaw);
    }

    public static /* synthetic */ void setPartialYaw$default(class_630 class_6302, float f, float f2, int n, Object object) {
        if ((n & 1) != 0) {
            f = class_6302.field_3675;
        }
        ModelExtensionsKt.setPartialYaw(class_6302, f, f2);
    }
}

