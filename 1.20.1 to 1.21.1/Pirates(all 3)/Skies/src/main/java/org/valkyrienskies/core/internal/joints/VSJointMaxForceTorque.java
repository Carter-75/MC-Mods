/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.joints;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "", "component1", "()F", "component2", "maxForce", "maxTorque", "copy", "(FF)Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "F", "getMaxForce", "getMaxTorque", "<init>", "(FF)V", "internal"})
@PhysTickOnly
public final class VSJointMaxForceTorque {
    private final float maxForce;
    private final float maxTorque;

    public VSJointMaxForceTorque(float maxForce, float maxTorque) {
        this.maxForce = maxForce;
        this.maxTorque = maxTorque;
    }

    public final float getMaxForce() {
        return this.maxForce;
    }

    public final float getMaxTorque() {
        return this.maxTorque;
    }

    public final float component1() {
        return this.maxForce;
    }

    public final float component2() {
        return this.maxTorque;
    }

    @NotNull
    public final VSJointMaxForceTorque copy(float maxForce, float maxTorque) {
        return new VSJointMaxForceTorque(maxForce, maxTorque);
    }

    public static /* synthetic */ VSJointMaxForceTorque copy$default(VSJointMaxForceTorque vSJointMaxForceTorque, float f2, float f3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f2 = vSJointMaxForceTorque.maxForce;
        }
        if ((n2 & 2) != 0) {
            f3 = vSJointMaxForceTorque.maxTorque;
        }
        return vSJointMaxForceTorque.copy(f2, f3);
    }

    @NotNull
    public String toString() {
        return "VSJointMaxForceTorque(maxForce=" + this.maxForce + ", maxTorque=" + this.maxTorque + ")";
    }

    public int hashCode() {
        int result2 = Float.hashCode(this.maxForce);
        result2 = result2 * 31 + Float.hashCode(this.maxTorque);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSJointMaxForceTorque)) {
            return false;
        }
        VSJointMaxForceTorque vSJointMaxForceTorque = (VSJointMaxForceTorque)other;
        if (Float.compare(this.maxForce, vSJointMaxForceTorque.maxForce) != 0) {
            return false;
        }
        return Float.compare(this.maxTorque, vSJointMaxForceTorque.maxTorque) == 0;
    }
}

