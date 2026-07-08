/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.connectivity;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.events.SplitEvent;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nH\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001c8\u0017@\u0017X\u0097\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!R\u001a\u0010\u000f\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b$\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b%\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\n8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/connectivity/SplitEventImpl;", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "", "component1", "()Z", "Lorg/joml/Vector3ic;", "component2", "()Lorg/joml/Vector3ic;", "component3", "component4", "", "component5", "()I", "wasPocket", "oldRoot", "newRootA", "newRootB", "voxelType", "copy", "(ZLorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;I)Lorg/valkyrienskies/core/impl/api_impl/connectivity/SplitEventImpl;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Ljava/lang/String;", "getDimensionId", "setDimensionId", "(Ljava/lang/String;)V", "Lorg/joml/Vector3ic;", "getNewRootA", "getNewRootB", "getOldRoot", "I", "getVoxelType", "Z", "getWasPocket", "<init>", "(ZLorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;I)V"})
public final class SplitEventImpl
implements SplitEvent {
    private final boolean wasPocket;
    private final Vector3ic oldRoot;
    private final Vector3ic newRootA;
    private final Vector3ic newRootB;
    private final int voxelType;
    private String dimensionId;

    /*
     * WARNING - void declaration
     */
    public SplitEventImpl(boolean wasPocket, Vector3ic oldRoot, Vector3ic newRootA, Vector3ic newRootB, int voxelType) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)oldRoot, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRootA, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRootB, (String)"");
        this.wasPocket = var1_1;
        this.oldRoot = var2_2;
        this.newRootA = var3_3;
        this.newRootB = newRootB;
        this.voxelType = voxelType;
    }

    @Override
    @JvmName(name="getWasPocket")
    public final boolean getWasPocket() {
        return this.wasPocket;
    }

    @Override
    @JvmName(name="getOldRoot")
    public final Vector3ic getOldRoot() {
        return this.oldRoot;
    }

    @Override
    @JvmName(name="getNewRootA")
    public final Vector3ic getNewRootA() {
        return this.newRootA;
    }

    @Override
    @JvmName(name="getNewRootB")
    public final Vector3ic getNewRootB() {
        return this.newRootB;
    }

    @Override
    @JvmName(name="getVoxelType")
    public final int getVoxelType() {
        return this.voxelType;
    }

    @Override
    @JvmName(name="getDimensionId")
    public final String getDimensionId() {
        return this.dimensionId;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setDimensionId")
    public final void setDimensionId(String string) {
        void var1_1;
        this.dimensionId = var1_1;
    }

    public final String toString() {
        return "SplitEvent(wasPocket=" + this.getWasPocket() + ", oldRoot=" + this.getOldRoot() + ", newRootA=" + this.getNewRootA() + ", newRootB=" + this.getNewRootB() + ", voxelType=" + this.getVoxelType() + ", dimensionId=" + this.getDimensionId() + ")";
    }

    public final boolean component1() {
        return this.wasPocket;
    }

    public final Vector3ic component2() {
        return this.oldRoot;
    }

    public final Vector3ic component3() {
        return this.newRootA;
    }

    public final Vector3ic component4() {
        return this.newRootB;
    }

    public final int component5() {
        return this.voxelType;
    }

    /*
     * WARNING - void declaration
     */
    public final SplitEventImpl copy(boolean wasPocket, Vector3ic oldRoot, Vector3ic newRootA, Vector3ic newRootB, int voxelType) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)oldRoot, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRootA, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRootB, (String)"");
        return new SplitEventImpl((boolean)var1_1, (Vector3ic)var2_2, (Vector3ic)var3_3, newRootB, voxelType);
    }

    public static /* synthetic */ SplitEventImpl copy$default(SplitEventImpl splitEventImpl, boolean bl, Vector3ic vector3ic, Vector3ic vector3ic2, Vector3ic vector3ic3, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            bl = splitEventImpl.wasPocket;
        }
        if ((n3 & 2) != 0) {
            vector3ic = splitEventImpl.oldRoot;
        }
        if ((n3 & 4) != 0) {
            vector3ic2 = splitEventImpl.newRootA;
        }
        if ((n3 & 8) != 0) {
            vector3ic3 = splitEventImpl.newRootB;
        }
        if ((n3 & 0x10) != 0) {
            n2 = splitEventImpl.voxelType;
        }
        return splitEventImpl.copy(bl, vector3ic, vector3ic2, vector3ic3, n2);
    }

    public final int hashCode() {
        int n2 = Boolean.hashCode(this.wasPocket);
        n2 = n2 * 31 + this.oldRoot.hashCode();
        n2 = n2 * 31 + this.newRootA.hashCode();
        n2 = n2 * 31 + this.newRootB.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.voxelType);
        return n2;
    }

    public final boolean equals(Object other) {
        SplitEventImpl splitEventImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof SplitEventImpl)) {
            return false;
        }
        splitEventImpl = splitEventImpl;
        if (this.wasPocket != splitEventImpl.wasPocket) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.oldRoot, (Object)splitEventImpl.oldRoot)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newRootA, (Object)splitEventImpl.newRootA)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newRootB, (Object)splitEventImpl.newRootB)) {
            return false;
        }
        return this.voxelType == splitEventImpl.voxelType;
    }
}

