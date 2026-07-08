/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1308
 *  net.minecraft.class_1330
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.spider.control;

import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1308;
import net.minecraft.class_1330;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/entity/spider/control/ArachneBodyControl;", "Lnet/minecraft/class_1330;", "Lnet/minecraft/class_1308;", "entity", "", "factor", "<init>", "(Lnet/minecraft/class_1308;F)V", "", "tick", "()V", "Lnet/minecraft/class_1308;", "F", "derelict"})
public final class ArachneBodyControl
extends class_1330 {
    @NotNull
    private final class_1308 entity;
    private final float factor;

    public ArachneBodyControl(@NotNull class_1308 entity, float factor) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        super(entity);
        this.entity = entity;
        this.factor = factor;
    }

    public /* synthetic */ ArachneBodyControl(class_1308 class_13082, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            f = 0.1f;
        }
        this(class_13082, f);
    }

    public void method_6224() {
        class_243 movementVector = new class_243(this.entity.method_23317() - this.entity.field_6014, 0.0, this.entity.method_23321() - this.entity.field_5969);
        float targetBodyYaw = MathExtensionsKt.degrees((float)Math.atan2(movementVector.field_1350, movementVector.field_1352)) - 90.0f;
        float difference = MathUtilsKt.degreesDifference(this.entity.field_6283, targetBodyYaw);
        if (difference > 40.0f) {
            targetBodyYaw = class_3532.method_17821((float)this.factor, (float)targetBodyYaw, (float)this.entity.field_6283);
        }
        if (movementVector.method_37268() > 1.0E-4) {
            this.entity.method_5636(class_3532.method_17821((float)this.factor, (float)this.entity.field_6283, (float)targetBodyYaw));
            this.entity.field_6241 = class_3532.method_20306((float)this.entity.field_6241, (float)this.entity.field_6283, (float)this.entity.method_5986());
        } else {
            this.entity.method_5636(class_3532.method_17821((float)this.factor, (float)this.entity.field_6283, (float)this.entity.field_6241));
        }
    }
}

