/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.spider.legs;

import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0013\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001f\u00a8\u0006%"}, d2={"Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "", "Lkotlin/Function0;", "", "upperLengthGetter", "lowerLengthGetter", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lnet/minecraft/class_243;", "target", "", "negativeLowerRoll", "", "solve", "(Lnet/minecraft/class_243;Z)V", "Lnet/minecraft/class_1297;", "entity", "offset", "", "maxLength", "convertToLocalAndSolve", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_243;ZD)V", "tickDelta", "getYaw", "(F)F", "getUpperRoll", "getLowerRoll", "Lkotlin/jvm/functions/Function0;", "firstTick", "Z", "yaw", "F", "upperRoll", "lowerRoll", "lastYaw", "lastUpperRoll", "lastLowerRoll", "derelict"})
public final class SpiderLegIKSolver {
    @NotNull
    private final Function0<Float> upperLengthGetter;
    @NotNull
    private final Function0<Float> lowerLengthGetter;
    private boolean firstTick;
    private float yaw;
    private float upperRoll;
    private float lowerRoll;
    private float lastYaw;
    private float lastUpperRoll;
    private float lastLowerRoll;

    public SpiderLegIKSolver(@NotNull Function0<Float> upperLengthGetter, @NotNull Function0<Float> lowerLengthGetter) {
        Intrinsics.checkNotNullParameter(upperLengthGetter, (String)"upperLengthGetter");
        Intrinsics.checkNotNullParameter(lowerLengthGetter, (String)"lowerLengthGetter");
        this.upperLengthGetter = upperLengthGetter;
        this.lowerLengthGetter = lowerLengthGetter;
        this.firstTick = true;
    }

    public final void solve(@NotNull class_243 target, boolean negativeLowerRoll) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        float upperLength = ((Number)this.upperLengthGetter.invoke()).floatValue();
        float lowerLength = ((Number)this.lowerLengthGetter.invoke()).floatValue();
        this.lastUpperRoll = this.upperRoll;
        this.lastLowerRoll = this.lowerRoll;
        this.lastYaw = this.yaw;
        this.yaw = MathUtilsKt.lerpAngleRadians(this.yaw, (float)Math.atan2((float)target.field_1350, (float)target.field_1352), 0.7f);
        float lowerRollCosine = RangesKt.coerceIn((float)(((float)target.method_1027() - upperLength * upperLength - lowerLength * lowerLength) / (2.0f * upperLength * lowerLength)), (float)-1.0f, (float)1.0f);
        float newLowerRoll = (float)Math.acos(lowerRollCosine);
        if (negativeLowerRoll) {
            newLowerRoll = -newLowerRoll;
        }
        this.lowerRoll = newLowerRoll;
        float lowerRollSine = (float)Math.sin(newLowerRoll);
        float adjacent = upperLength + lowerLength * lowerRollCosine;
        float opposite = lowerLength * lowerRollSine;
        float targetHorizontal = (float)target.method_37267();
        float targetVertical = (float)target.field_1351;
        float tangentY = targetVertical * adjacent - targetHorizontal * opposite;
        float tangentX = targetHorizontal * adjacent + targetVertical * opposite;
        this.upperRoll = (float)Math.atan2(tangentY, tangentX);
        if (this.firstTick) {
            this.firstTick = false;
            this.lastYaw = this.yaw;
            this.lastUpperRoll = this.upperRoll;
            this.lastLowerRoll = this.lowerRoll;
        }
    }

    public final void convertToLocalAndSolve(@NotNull class_1297 entity, @NotNull class_243 offset, @NotNull class_243 target, boolean negativeLowerRoll, double maxLength) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        class_243 localTarget = target.method_1020(MathExtensionsKt.getLocallyOffsetPos(entity, offset));
        if (localTarget.method_37268() > maxLength * maxLength) {
            double length = localTarget.method_37267();
            double normalizedX = localTarget.field_1352 / length;
            double normalizedZ = localTarget.field_1350 / length;
            this.solve(new class_243(normalizedX * maxLength, localTarget.field_1351, normalizedZ * maxLength), negativeLowerRoll);
            return;
        }
        Intrinsics.checkNotNull((Object)localTarget);
        this.solve(localTarget, negativeLowerRoll);
    }

    public static /* synthetic */ void convertToLocalAndSolve$default(SpiderLegIKSolver spiderLegIKSolver, class_1297 class_12972, class_243 class_2432, class_243 class_2433, boolean bl, double d, int n, Object object) {
        if ((n & 0x10) != 0) {
            d = Double.MAX_VALUE;
        }
        spiderLegIKSolver.convertToLocalAndSolve(class_12972, class_2432, class_2433, bl, d);
    }

    public final float getYaw(float tickDelta) {
        return MathUtilsKt.lerpAngleRadians(this.lastYaw, this.yaw, tickDelta);
    }

    public final float getUpperRoll(float tickDelta) {
        return Easing.lerp((float)this.lastUpperRoll, (float)this.upperRoll, (float)tickDelta);
    }

    public final float getLowerRoll(float tickDelta) {
        return Easing.lerp((float)this.lastLowerRoll, (float)this.lowerRoll, (float)tickDelta);
    }
}

