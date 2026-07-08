/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.networking.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b(\u0010)J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\rH\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001\u00a2\u0006\u0004\b\u001d\u0010\tR\"\u0010\u0013\u001a\u00020\r8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010!R\u001b\u0010\u0011\u001a\u00060\u0006j\u0002`\u00078\u0007\u00a2\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\tR\u001b\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0007\u00a2\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u0005R\u0017\u0010\u0012\u001a\u00020\n8\u0007\u00a2\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\f"}, d2={"Lorg/valkyrienskies/core/impl/networking/impl/PhysEntityCreateData;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "component2", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "component3", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "component4", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "id", "dimensionId", "shipTransform", "collisionShapeData", "copy", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)Lorg/valkyrienskies/core/impl/networking/impl/PhysEntityCreateData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "getCollisionShapeData", "setCollisionShapeData", "(Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)V", "Ljava/lang/String;", "getDimensionId", "J", "getId", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getShipTransform", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)V"})
public final class PhysEntityCreateData {
    private final long id;
    private final String dimensionId;
    private final ShipTransform shipTransform;
    private VSCollisionShapeData collisionShapeData;

    /*
     * WARNING - void declaration
     */
    public PhysEntityCreateData(long id, String dimensionId, ShipTransform shipTransform, VSCollisionShapeData collisionShapeData) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"");
        this.id = var1_1;
        this.dimensionId = var3_2;
        this.shipTransform = shipTransform;
        this.collisionShapeData = collisionShapeData;
    }

    @JvmName(name="getId")
    public final long getId() {
        return this.id;
    }

    @JvmName(name="getDimensionId")
    public final String getDimensionId() {
        return this.dimensionId;
    }

    @JvmName(name="getShipTransform")
    public final ShipTransform getShipTransform() {
        return this.shipTransform;
    }

    @JvmName(name="getCollisionShapeData")
    public final VSCollisionShapeData getCollisionShapeData() {
        return this.collisionShapeData;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setCollisionShapeData")
    public final void setCollisionShapeData(VSCollisionShapeData vSCollisionShapeData) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)vSCollisionShapeData, (String)"");
        this.collisionShapeData = var1_1;
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.dimensionId;
    }

    public final ShipTransform component3() {
        return this.shipTransform;
    }

    public final VSCollisionShapeData component4() {
        return this.collisionShapeData;
    }

    /*
     * WARNING - void declaration
     */
    public final PhysEntityCreateData copy(long id, String dimensionId, ShipTransform shipTransform, VSCollisionShapeData collisionShapeData) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"");
        return new PhysEntityCreateData((long)var1_1, (String)var3_2, shipTransform, collisionShapeData);
    }

    public static /* synthetic */ PhysEntityCreateData copy$default(PhysEntityCreateData physEntityCreateData, long l2, String string, ShipTransform shipTransform, VSCollisionShapeData vSCollisionShapeData, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = physEntityCreateData.id;
        }
        if ((n2 & 2) != 0) {
            string = physEntityCreateData.dimensionId;
        }
        if ((n2 & 4) != 0) {
            shipTransform = physEntityCreateData.shipTransform;
        }
        if ((n2 & 8) != 0) {
            vSCollisionShapeData = physEntityCreateData.collisionShapeData;
        }
        return physEntityCreateData.copy(l2, string, shipTransform, vSCollisionShapeData);
    }

    public final String toString() {
        return "PhysEntityCreateData(id=" + this.id + ", dimensionId=" + this.dimensionId + ", shipTransform=" + this.shipTransform + ", collisionShapeData=" + this.collisionShapeData + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.id);
        n2 = n2 * 31 + this.dimensionId.hashCode();
        n2 = n2 * 31 + this.shipTransform.hashCode();
        n2 = n2 * 31 + this.collisionShapeData.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        PhysEntityCreateData physEntityCreateData;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysEntityCreateData)) {
            return false;
        }
        physEntityCreateData = physEntityCreateData;
        if (this.id != physEntityCreateData.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dimensionId, (Object)physEntityCreateData.dimensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipTransform, (Object)physEntityCreateData.shipTransform)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.collisionShapeData, (Object)physEntityCreateData.collisionShapeData);
    }
}

