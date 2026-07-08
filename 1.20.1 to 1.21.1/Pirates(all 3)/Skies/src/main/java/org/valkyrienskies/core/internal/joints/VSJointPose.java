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
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "Lorg/joml/Quaterniondc;", "component2", "()Lorg/joml/Quaterniondc;", "pos", "rot", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;)Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getPos", "Lorg/joml/Quaterniondc;", "getRot", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;)V", "internal"})
@PhysTickOnly
public final class VSJointPose {
    @NotNull
    private final Vector3dc pos;
    @NotNull
    private final Quaterniondc rot;

    public VSJointPose(@NotNull Vector3dc pos, @NotNull Quaterniondc rot) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)rot, (String)"rot");
        this.pos = pos;
        this.rot = rot;
    }

    @NotNull
    public final Vector3dc getPos() {
        return this.pos;
    }

    @NotNull
    public final Quaterniondc getRot() {
        return this.rot;
    }

    @NotNull
    public final Vector3dc component1() {
        return this.pos;
    }

    @NotNull
    public final Quaterniondc component2() {
        return this.rot;
    }

    @NotNull
    public final VSJointPose copy(@NotNull Vector3dc pos, @NotNull Quaterniondc rot) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)rot, (String)"rot");
        return new VSJointPose(pos, rot);
    }

    public static /* synthetic */ VSJointPose copy$default(VSJointPose vSJointPose, Vector3dc vector3dc, Quaterniondc quaterniondc, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = vSJointPose.pos;
        }
        if ((n2 & 2) != 0) {
            quaterniondc = vSJointPose.rot;
        }
        return vSJointPose.copy(vector3dc, quaterniondc);
    }

    @NotNull
    public String toString() {
        return "VSJointPose(pos=" + this.pos + ", rot=" + this.rot + ")";
    }

    public int hashCode() {
        int result2 = this.pos.hashCode();
        result2 = result2 * 31 + this.rot.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSJointPose)) {
            return false;
        }
        VSJointPose vSJointPose = (VSJointPose)other;
        if (!Intrinsics.areEqual((Object)this.pos, (Object)vSJointPose.pos)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.rot, (Object)vSJointPose.rot);
    }
}

