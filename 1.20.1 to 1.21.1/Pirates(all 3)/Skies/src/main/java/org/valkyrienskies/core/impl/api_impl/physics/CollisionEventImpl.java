/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.physics.ContactPoint;
import org.valkyrienskies.core.api.world.PhysLevel;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\n\u0010\u0013\u001a\u00060\bj\u0002`\t\u0012\n\u0010\u0014\u001a\u00060\bj\u0002`\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u00060\bj\u0002`\tH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\f\b\u0002\u0010\u0013\u001a\u00060\bj\u0002`\t2\f\b\u0002\u0010\u0014\u001a\u00060\bj\u0002`\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b \u0010\u0004R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0017X\u0097\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0007R\u001e\u0010\u0013\u001a\u00060\bj\u0002`\t8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u000bR\u001e\u0010\u0014\u001a\u00060\bj\u0002`\t8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b)\u0010\u000b"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/CollisionEventImpl;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "", "component1", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "component2", "()Lorg/valkyrienskies/core/api/world/PhysLevel;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component3", "()J", "component4", "", "Lorg/valkyrienskies/core/api/physics/ContactPoint;", "component5", "()Ljava/util/Collection;", "dimensionId", "physLevel", "shipIdA", "shipIdB", "contactPoints", "copy", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/world/PhysLevel;JJLjava/util/Collection;)Lorg/valkyrienskies/core/impl/api_impl/physics/CollisionEventImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Collection;", "getContactPoints", "Ljava/lang/String;", "getDimensionId", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "getPhysLevel", "J", "getShipIdA", "getShipIdB", "<init>", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/world/PhysLevel;JJLjava/util/Collection;)V"})
public final class CollisionEventImpl
implements CollisionEvent {
    private final String dimensionId;
    private final PhysLevel physLevel;
    private final long shipIdA;
    private final long shipIdB;
    private final Collection<ContactPoint> contactPoints;

    /*
     * WARNING - void declaration
     */
    public CollisionEventImpl(String dimensionId, PhysLevel physLevel, long shipIdA, long shipIdB, Collection<? extends ContactPoint> contactPoints) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"");
        Intrinsics.checkNotNullParameter(contactPoints, (String)"");
        this.dimensionId = var1_1;
        this.physLevel = var2_2;
        this.shipIdA = var3_3;
        this.shipIdB = shipIdB;
        this.contactPoints = contactPoints;
    }

    @Override
    @JvmName(name="getDimensionId")
    public final String getDimensionId() {
        return this.dimensionId;
    }

    @Override
    @JvmName(name="getPhysLevel")
    public final PhysLevel getPhysLevel() {
        return this.physLevel;
    }

    @Override
    @JvmName(name="getShipIdA")
    public final long getShipIdA() {
        return this.shipIdA;
    }

    @Override
    @JvmName(name="getShipIdB")
    public final long getShipIdB() {
        return this.shipIdB;
    }

    @Override
    @JvmName(name="getContactPoints")
    public final Collection<ContactPoint> getContactPoints() {
        return this.contactPoints;
    }

    public final String toString() {
        return "ContactInfo(dimensionId='" + this.getDimensionId() + "', contactPoints=" + this.getContactPoints() + ")";
    }

    public final String component1() {
        return this.dimensionId;
    }

    public final PhysLevel component2() {
        return this.physLevel;
    }

    public final long component3() {
        return this.shipIdA;
    }

    public final long component4() {
        return this.shipIdB;
    }

    public final Collection<ContactPoint> component5() {
        return this.contactPoints;
    }

    /*
     * WARNING - void declaration
     */
    public final CollisionEventImpl copy(String dimensionId, PhysLevel physLevel, long shipIdA, long shipIdB, Collection<? extends ContactPoint> contactPoints) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"");
        Intrinsics.checkNotNullParameter(contactPoints, (String)"");
        return new CollisionEventImpl((String)var1_1, (PhysLevel)var2_2, (long)var3_3, shipIdB, contactPoints);
    }

    public static /* synthetic */ CollisionEventImpl copy$default(CollisionEventImpl collisionEventImpl, String string, PhysLevel physLevel, long l2, long l3, Collection collection, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = collisionEventImpl.dimensionId;
        }
        if ((n2 & 2) != 0) {
            physLevel = collisionEventImpl.physLevel;
        }
        if ((n2 & 4) != 0) {
            l2 = collisionEventImpl.shipIdA;
        }
        if ((n2 & 8) != 0) {
            l3 = collisionEventImpl.shipIdB;
        }
        if ((n2 & 0x10) != 0) {
            collection = collisionEventImpl.contactPoints;
        }
        return collisionEventImpl.copy(string, physLevel, l2, l3, collection);
    }

    public final int hashCode() {
        int n2 = this.dimensionId.hashCode();
        n2 = n2 * 31 + this.physLevel.hashCode();
        n2 = n2 * 31 + Long.hashCode(this.shipIdA);
        n2 = n2 * 31 + Long.hashCode(this.shipIdB);
        n2 = n2 * 31 + ((Object)this.contactPoints).hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        CollisionEventImpl collisionEventImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollisionEventImpl)) {
            return false;
        }
        collisionEventImpl = collisionEventImpl;
        if (!Intrinsics.areEqual((Object)this.dimensionId, (Object)collisionEventImpl.dimensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.physLevel, (Object)collisionEventImpl.physLevel)) {
            return false;
        }
        if (this.shipIdA != collisionEventImpl.shipIdA) {
            return false;
        }
        if (this.shipIdB != collisionEventImpl.shipIdB) {
            return false;
        }
        return Intrinsics.areEqual(this.contactPoints, collisionEventImpl.contactPoints);
    }
}

