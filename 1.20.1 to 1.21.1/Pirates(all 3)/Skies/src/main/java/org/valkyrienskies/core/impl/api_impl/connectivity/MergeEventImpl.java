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
import org.valkyrienskies.core.api.events.MergeEvent;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nH\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001c8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!R\u001a\u0010\u0010\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b$\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b%\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\n8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\f"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/connectivity/MergeEventImpl;", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "", "component1", "()Z", "Lorg/joml/Vector3ic;", "component2", "()Lorg/joml/Vector3ic;", "component3", "component4", "", "component5", "()I", "stillPocket", "oldRootA", "oldRootB", "newRoot", "voxelType", "copy", "(ZLorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;I)Lorg/valkyrienskies/core/impl/api_impl/connectivity/MergeEventImpl;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Ljava/lang/String;", "getDimensionId", "setDimensionId", "(Ljava/lang/String;)V", "Lorg/joml/Vector3ic;", "getNewRoot", "getOldRootA", "getOldRootB", "Z", "getStillPocket", "I", "getVoxelType", "<init>", "(ZLorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;I)V"})
public final class MergeEventImpl
implements MergeEvent {
    private final boolean stillPocket;
    private final Vector3ic oldRootA;
    private final Vector3ic oldRootB;
    private final Vector3ic newRoot;
    private final int voxelType;
    private String dimensionId;

    /*
     * WARNING - void declaration
     */
    public MergeEventImpl(boolean stillPocket, Vector3ic oldRootA, Vector3ic oldRootB, Vector3ic newRoot, int voxelType) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)oldRootA, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldRootB, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRoot, (String)"");
        this.stillPocket = var1_1;
        this.oldRootA = var2_2;
        this.oldRootB = var3_3;
        this.newRoot = newRoot;
        this.voxelType = voxelType;
    }

    @Override
    @JvmName(name="getStillPocket")
    public final boolean getStillPocket() {
        return this.stillPocket;
    }

    @Override
    @JvmName(name="getOldRootA")
    public final Vector3ic getOldRootA() {
        return this.oldRootA;
    }

    @Override
    @JvmName(name="getOldRootB")
    public final Vector3ic getOldRootB() {
        return this.oldRootB;
    }

    @Override
    @JvmName(name="getNewRoot")
    public final Vector3ic getNewRoot() {
        return this.newRoot;
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
        return "MergeEvent(stillPocket=" + this.getStillPocket() + ", oldRootA=" + this.getOldRootA() + ", oldRootB=" + this.getOldRootB() + ", newRoot=" + this.getNewRoot() + ", voxelType=" + this.getVoxelType() + ", dimensionId=" + this.getDimensionId() + ")";
    }

    public final boolean component1() {
        return this.stillPocket;
    }

    public final Vector3ic component2() {
        return this.oldRootA;
    }

    public final Vector3ic component3() {
        return this.oldRootB;
    }

    public final Vector3ic component4() {
        return this.newRoot;
    }

    public final int component5() {
        return this.voxelType;
    }

    /*
     * WARNING - void declaration
     */
    public final MergeEventImpl copy(boolean stillPocket, Vector3ic oldRootA, Vector3ic oldRootB, Vector3ic newRoot, int voxelType) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)oldRootA, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldRootB, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRoot, (String)"");
        return new MergeEventImpl((boolean)var1_1, (Vector3ic)var2_2, (Vector3ic)var3_3, newRoot, voxelType);
    }

    public static /* synthetic */ MergeEventImpl copy$default(MergeEventImpl mergeEventImpl, boolean bl, Vector3ic vector3ic, Vector3ic vector3ic2, Vector3ic vector3ic3, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            bl = mergeEventImpl.stillPocket;
        }
        if ((n3 & 2) != 0) {
            vector3ic = mergeEventImpl.oldRootA;
        }
        if ((n3 & 4) != 0) {
            vector3ic2 = mergeEventImpl.oldRootB;
        }
        if ((n3 & 8) != 0) {
            vector3ic3 = mergeEventImpl.newRoot;
        }
        if ((n3 & 0x10) != 0) {
            n2 = mergeEventImpl.voxelType;
        }
        return mergeEventImpl.copy(bl, vector3ic, vector3ic2, vector3ic3, n2);
    }

    public final int hashCode() {
        int n2 = Boolean.hashCode(this.stillPocket);
        n2 = n2 * 31 + this.oldRootA.hashCode();
        n2 = n2 * 31 + this.oldRootB.hashCode();
        n2 = n2 * 31 + this.newRoot.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.voxelType);
        return n2;
    }

    public final boolean equals(Object other) {
        MergeEventImpl mergeEventImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeEventImpl)) {
            return false;
        }
        mergeEventImpl = mergeEventImpl;
        if (this.stillPocket != mergeEventImpl.stillPocket) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.oldRootA, (Object)mergeEventImpl.oldRootA)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.oldRootB, (Object)mergeEventImpl.oldRootB)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newRoot, (Object)mergeEventImpl.newRoot)) {
            return false;
        }
        return this.voxelType == mergeEventImpl.voxelType;
    }
}

