/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2350
 */
package org.valkyrienskies.mod.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2350;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="This API will be removed at a later date. Addons should make their own seat entities and handle their own inputs. ")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/api/SeatedControllingPlayer;", "", "Lnet/minecraft/class_2350;", "seatInDirection", "Lnet/minecraft/class_2350;", "getSeatInDirection", "()Lnet/minecraft/class_2350;", "", "forwardImpulse", "F", "getForwardImpulse", "()F", "setForwardImpulse", "(F)V", "leftImpulse", "getLeftImpulse", "setLeftImpulse", "upImpulse", "getUpImpulse", "setUpImpulse", "", "sprintOn", "Z", "getSprintOn", "()Z", "setSprintOn", "(Z)V", "cruise", "getCruise", "setCruise", "<init>", "(Lnet/minecraft/class_2350;)V", "valkyrienskies-120"})
public final class SeatedControllingPlayer {
    @NotNull
    private final class_2350 seatInDirection;
    private float forwardImpulse;
    private float leftImpulse;
    private float upImpulse;
    private boolean sprintOn;
    private boolean cruise;

    public SeatedControllingPlayer(@NotNull class_2350 seatInDirection) {
        Intrinsics.checkNotNullParameter((Object)seatInDirection, (String)"seatInDirection");
        this.seatInDirection = seatInDirection;
    }

    @NotNull
    public final class_2350 getSeatInDirection() {
        return this.seatInDirection;
    }

    public final float getForwardImpulse() {
        return this.forwardImpulse;
    }

    public final void setForwardImpulse(float f2) {
        this.forwardImpulse = f2;
    }

    public final float getLeftImpulse() {
        return this.leftImpulse;
    }

    public final void setLeftImpulse(float f2) {
        this.leftImpulse = f2;
    }

    public final float getUpImpulse() {
        return this.upImpulse;
    }

    public final void setUpImpulse(float f2) {
        this.upImpulse = f2;
    }

    public final boolean getSprintOn() {
        return this.sprintOn;
    }

    public final void setSprintOn(boolean bl) {
        this.sprintOn = bl;
    }

    public final boolean getCruise() {
        return this.cruise;
    }

    public final void setCruise(boolean bl) {
        this.cruise = bl;
    }
}

