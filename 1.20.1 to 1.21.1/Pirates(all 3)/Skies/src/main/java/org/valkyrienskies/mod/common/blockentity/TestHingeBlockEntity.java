/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 */
package org.valkyrienskies.mod.common.blockentity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/mod/common/blockentity/TestHingeBlockEntity;", "Lnet/minecraft/class_2586;", "", "tick", "()V", "Lnet/minecraft/class_2338;", "otherHingePos", "Lnet/minecraft/class_2338;", "getOtherHingePos", "()Lnet/minecraft/class_2338;", "setOtherHingePos", "(Lnet/minecraft/class_2338;)V", "", "Lorg/valkyrienskies/core/internal/joints/VSJointId;", "constraintId", "Ljava/lang/Integer;", "getConstraintId", "()Ljava/lang/Integer;", "setConstraintId", "(Ljava/lang/Integer;)V", "blockPos", "Lnet/minecraft/class_2680;", "blockState", "<init>", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "valkyrienskies-120"})
public final class TestHingeBlockEntity
extends class_2586 {
    @Nullable
    private class_2338 otherHingePos;
    @Nullable
    private volatile Integer constraintId;

    public TestHingeBlockEntity(@NotNull class_2338 blockPos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        super(ValkyrienSkiesMod.INSTANCE.getTEST_HINGE_BLOCK_ENTITY_TYPE(), blockPos, blockState);
    }

    @Nullable
    public final class_2338 getOtherHingePos() {
        return this.otherHingePos;
    }

    public final void setOtherHingePos(@Nullable class_2338 class_23382) {
        this.otherHingePos = class_23382;
    }

    @Nullable
    public final Integer getConstraintId() {
        return this.constraintId;
    }

    public final void setConstraintId(@Nullable Integer n2) {
        this.constraintId = n2;
    }

    public final void tick() {
    }
}

