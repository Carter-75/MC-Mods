/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.internal.ShipTeleportData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0004J\u0018\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0004Jb\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u00d6\u0003\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%H\u00d6\u0001\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\nH\u00d6\u0001\u00a2\u0006\u0004\b(\u0010\rR\"\u0010\u0016\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010/\u001a\u0004\b0\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b2\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b3\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/game/ShipTeleportDataImpl;", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "Lorg/joml/Quaterniondc;", "component2", "()Lorg/joml/Quaterniondc;", "component3", "component4", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "component5", "()Ljava/lang/String;", "", "component6", "()Ljava/lang/Double;", "component7", "newPos", "newRot", "newVel", "newOmega", "newDimension", "newScale", "newPosInShip", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Double;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/game/ShipTeleportDataImpl;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "oldShipTransform", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "createNewShipTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getNewDimension", "Lorg/joml/Vector3dc;", "getNewOmega", "getNewPos", "getNewPosInShip", "Lorg/joml/Quaterniondc;", "getNewRot", "Ljava/lang/Double;", "getNewScale", "getNewVel", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Double;Lorg/joml/Vector3dc;)V"})
public final class ShipTeleportDataImpl
implements ShipTeleportData {
    private final Vector3dc newPos;
    private final Quaterniondc newRot;
    private final Vector3dc newVel;
    private final Vector3dc newOmega;
    private final String newDimension;
    private final Double newScale;
    private final Vector3dc newPosInShip;

    /*
     * WARNING - void declaration
     */
    public ShipTeleportDataImpl(Vector3dc newPos, Quaterniondc newRot, Vector3dc newVel, Vector3dc newOmega, String newDimension, Double newScale, Vector3dc newPosInShip) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)newPos, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRot, (String)"");
        Intrinsics.checkNotNullParameter((Object)newVel, (String)"");
        Intrinsics.checkNotNullParameter((Object)newOmega, (String)"");
        this.newPos = var1_1;
        this.newRot = var2_2;
        this.newVel = var3_3;
        this.newOmega = newOmega;
        this.newDimension = newDimension;
        this.newScale = newScale;
        this.newPosInShip = newPosInShip;
    }

    public /* synthetic */ ShipTeleportDataImpl(Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3, String string, Double d2, Vector3dc vector3dc4, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            vector3dc = new Vector3d();
        }
        if ((n2 & 2) != 0) {
            quaterniondc = new Quaterniond();
        }
        if ((n2 & 4) != 0) {
            vector3dc2 = new Vector3d();
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = new Vector3d();
        }
        if ((n2 & 0x10) != 0) {
            string = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = null;
        }
        if ((n2 & 0x40) != 0) {
            vector3dc4 = null;
        }
        this(vector3dc, quaterniondc, vector3dc2, vector3dc3, string, d2, vector3dc4);
    }

    @Override
    @JvmName(name="getNewPos")
    public final Vector3dc getNewPos() {
        return this.newPos;
    }

    @Override
    @JvmName(name="getNewRot")
    public final Quaterniondc getNewRot() {
        return this.newRot;
    }

    @Override
    @JvmName(name="getNewVel")
    public final Vector3dc getNewVel() {
        return this.newVel;
    }

    @Override
    @JvmName(name="getNewOmega")
    public final Vector3dc getNewOmega() {
        return this.newOmega;
    }

    @Override
    @JvmName(name="getNewDimension")
    public final String getNewDimension() {
        return this.newDimension;
    }

    @Override
    @JvmName(name="getNewScale")
    public final Double getNewScale() {
        return this.newScale;
    }

    @Override
    @JvmName(name="getNewPosInShip")
    public final Vector3dc getNewPosInShip() {
        return this.newPosInShip;
    }

    @Override
    public final BodyKinematics createNewShipTransform(ShipTransform oldShipTransform) {
        Vector3dc vector3dc;
        Vector3dc vector3dc2;
        Vector3dc vector3dc3;
        Vector3dc vector3dc4;
        Intrinsics.checkNotNullParameter((Object)oldShipTransform, (String)"");
        BodyKinematicsFactory bodyKinematicsFactory = BodyKinematicsFactory.INSTANCE;
        Vector3dc vector3dc5 = this.getNewOmega();
        Vector3dc vector3dc6 = this.getNewVel();
        if (this.getNewPosInShip() != null) {
            Double d2 = this.getNewScale();
            v1 = this.getNewPos().add(this.getNewPosInShip().sub(oldShipTransform.getPositionInShip(), new Vector3d()).mul(d2 != null ? d2 : 1.0).rotate(this.getNewRot()), new Vector3d());
        } else {
            v1 = vector3dc4 = this.getNewPos();
        }
        if ((vector3dc3 = this.getNewPosInShip()) == null) {
            vector3dc3 = oldShipTransform.getPositionInShip();
        }
        Vector3dc vector3dc7 = vector3dc3;
        Quaterniondc quaterniondc = this.getNewRot();
        Double d3 = this.getNewScale();
        if (d3 != null) {
            double d4 = ((Number)d3).doubleValue();
            vector3dc2 = new Vector3d(d4);
        } else {
            vector3dc2 = vector3dc.getShipToWorldScaling();
        }
        vector3dc = vector3dc2;
        Intrinsics.checkNotNullExpressionValue((Object)vector3dc4, (String)"");
        return bodyKinematicsFactory.create(vector3dc6, vector3dc5, vector3dc4, quaterniondc, vector3dc, vector3dc7);
    }

    public final Vector3dc component1() {
        return this.newPos;
    }

    public final Quaterniondc component2() {
        return this.newRot;
    }

    public final Vector3dc component3() {
        return this.newVel;
    }

    public final Vector3dc component4() {
        return this.newOmega;
    }

    public final String component5() {
        return this.newDimension;
    }

    public final Double component6() {
        return this.newScale;
    }

    public final Vector3dc component7() {
        return this.newPosInShip;
    }

    /*
     * WARNING - void declaration
     */
    public final ShipTeleportDataImpl copy(Vector3dc newPos, Quaterniondc newRot, Vector3dc newVel, Vector3dc newOmega, String newDimension, Double newScale, Vector3dc newPosInShip) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)newPos, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRot, (String)"");
        Intrinsics.checkNotNullParameter((Object)newVel, (String)"");
        Intrinsics.checkNotNullParameter((Object)newOmega, (String)"");
        return new ShipTeleportDataImpl((Vector3dc)var1_1, (Quaterniondc)var2_2, (Vector3dc)var3_3, newOmega, newDimension, newScale, newPosInShip);
    }

    public static /* synthetic */ ShipTeleportDataImpl copy$default(ShipTeleportDataImpl shipTeleportDataImpl, Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3, String string, Double d2, Vector3dc vector3dc4, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = shipTeleportDataImpl.newPos;
        }
        if ((n2 & 2) != 0) {
            quaterniondc = shipTeleportDataImpl.newRot;
        }
        if ((n2 & 4) != 0) {
            vector3dc2 = shipTeleportDataImpl.newVel;
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = shipTeleportDataImpl.newOmega;
        }
        if ((n2 & 0x10) != 0) {
            string = shipTeleportDataImpl.newDimension;
        }
        if ((n2 & 0x20) != 0) {
            d2 = shipTeleportDataImpl.newScale;
        }
        if ((n2 & 0x40) != 0) {
            vector3dc4 = shipTeleportDataImpl.newPosInShip;
        }
        return shipTeleportDataImpl.copy(vector3dc, quaterniondc, vector3dc2, vector3dc3, string, d2, vector3dc4);
    }

    public final String toString() {
        return "ShipTeleportDataImpl(newPos=" + this.newPos + ", newRot=" + this.newRot + ", newVel=" + this.newVel + ", newOmega=" + this.newOmega + ", newDimension=" + this.newDimension + ", newScale=" + this.newScale + ", newPosInShip=" + this.newPosInShip + ")";
    }

    public final int hashCode() {
        int n2 = this.newPos.hashCode();
        n2 = n2 * 31 + this.newRot.hashCode();
        n2 = n2 * 31 + this.newVel.hashCode();
        n2 = n2 * 31 + this.newOmega.hashCode();
        n2 = n2 * 31 + (this.newDimension == null ? 0 : this.newDimension.hashCode());
        n2 = n2 * 31 + (this.newScale == null ? 0 : ((Object)this.newScale).hashCode());
        n2 = n2 * 31 + (this.newPosInShip == null ? 0 : this.newPosInShip.hashCode());
        return n2;
    }

    public final boolean equals(Object other) {
        ShipTeleportDataImpl shipTeleportDataImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipTeleportDataImpl)) {
            return false;
        }
        shipTeleportDataImpl = shipTeleportDataImpl;
        if (!Intrinsics.areEqual((Object)this.newPos, (Object)shipTeleportDataImpl.newPos)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newRot, (Object)shipTeleportDataImpl.newRot)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newVel, (Object)shipTeleportDataImpl.newVel)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newOmega, (Object)shipTeleportDataImpl.newOmega)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newDimension, (Object)shipTeleportDataImpl.newDimension)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newScale, (Object)shipTeleportDataImpl.newScale)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.newPosInShip, (Object)shipTeleportDataImpl.newPosInShip);
    }

    public ShipTeleportDataImpl() {
        this(null, null, null, null, null, null, null, 127, null);
    }
}

