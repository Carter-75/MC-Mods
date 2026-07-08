/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.properties.PhysPose;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/PhysPoseImpl;", "Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "Lorg/joml/Quaterniondc;", "component2", "()Lorg/joml/Quaterniondc;", "pos", "rot", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;)Lorg/valkyrienskies/core/impl/game/ships/PhysPoseImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getPos", "Lorg/joml/Quaterniondc;", "getRot", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;)V"})
public final class PhysPoseImpl
implements PhysPose {
    private final Vector3dc pos;
    private final Quaterniondc rot;

    /*
     * WARNING - void declaration
     */
    public PhysPoseImpl(Vector3dc pos, Quaterniondc rot) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)pos, (String)"");
        Intrinsics.checkNotNullParameter((Object)rot, (String)"");
        this.pos = var1_1;
        this.rot = var2_2;
    }

    @Override
    @JvmName(name="getPos")
    public final Vector3dc getPos() {
        return this.pos;
    }

    @Override
    @JvmName(name="getRot")
    public final Quaterniondc getRot() {
        return this.rot;
    }

    public final Vector3dc component1() {
        return this.pos;
    }

    public final Quaterniondc component2() {
        return this.rot;
    }

    /*
     * WARNING - void declaration
     */
    public final PhysPoseImpl copy(Vector3dc pos, Quaterniondc rot) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)pos, (String)"");
        Intrinsics.checkNotNullParameter((Object)rot, (String)"");
        return new PhysPoseImpl((Vector3dc)var1_1, (Quaterniondc)var2_2);
    }

    public static /* synthetic */ PhysPoseImpl copy$default(PhysPoseImpl physPoseImpl, Vector3dc vector3dc, Quaterniondc quaterniondc, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = physPoseImpl.pos;
        }
        if ((n2 & 2) != 0) {
            quaterniondc = physPoseImpl.rot;
        }
        return physPoseImpl.copy(vector3dc, quaterniondc);
    }

    public final String toString() {
        return "PhysPoseImpl(pos=" + this.pos + ", rot=" + this.rot + ")";
    }

    public final int hashCode() {
        int n2 = this.pos.hashCode();
        n2 = n2 * 31 + this.rot.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        PhysPoseImpl physPoseImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysPoseImpl)) {
            return false;
        }
        physPoseImpl = physPoseImpl;
        if (!Intrinsics.areEqual((Object)this.pos, (Object)physPoseImpl.pos)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.rot, (Object)physPoseImpl.rot);
    }
}

