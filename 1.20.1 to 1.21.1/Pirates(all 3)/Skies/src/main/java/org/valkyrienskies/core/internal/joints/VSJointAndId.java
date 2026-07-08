/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.joints;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.internal.joints.VSJoint;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\u00a8\u0006\u001a"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSJointAndId;", "", "", "component1", "()I", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJoint;", "jointId", "joint", "copy", "(ILorg/valkyrienskies/core/internal/joints/VSJoint;)Lorg/valkyrienskies/core/internal/joints/VSJointAndId;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "getJoint", "I", "getJointId", "<init>", "(ILorg/valkyrienskies/core/internal/joints/VSJoint;)V", "internal"})
@PhysTickOnly
public final class VSJointAndId {
    private final int jointId;
    @NotNull
    private final VSJoint joint;

    public VSJointAndId(int jointId, @NotNull VSJoint joint) {
        Intrinsics.checkNotNullParameter((Object)joint, (String)"joint");
        this.jointId = jointId;
        this.joint = joint;
    }

    public final int getJointId() {
        return this.jointId;
    }

    @NotNull
    public final VSJoint getJoint() {
        return this.joint;
    }

    public final int component1() {
        return this.jointId;
    }

    @NotNull
    public final VSJoint component2() {
        return this.joint;
    }

    @NotNull
    public final VSJointAndId copy(int jointId, @NotNull VSJoint joint) {
        Intrinsics.checkNotNullParameter((Object)joint, (String)"joint");
        return new VSJointAndId(jointId, joint);
    }

    public static /* synthetic */ VSJointAndId copy$default(VSJointAndId vSJointAndId, int n2, VSJoint vSJoint, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = vSJointAndId.jointId;
        }
        if ((n3 & 2) != 0) {
            vSJoint = vSJointAndId.joint;
        }
        return vSJointAndId.copy(n2, vSJoint);
    }

    @NotNull
    public String toString() {
        return "VSJointAndId(jointId=" + this.jointId + ", joint=" + this.joint + ")";
    }

    public int hashCode() {
        int result2 = Integer.hashCode(this.jointId);
        result2 = result2 * 31 + this.joint.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSJointAndId)) {
            return false;
        }
        VSJointAndId vSJointAndId = (VSJointAndId)other;
        if (this.jointId != vSJointAndId.jointId) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.joint, (Object)vSJointAndId.joint);
    }
}

