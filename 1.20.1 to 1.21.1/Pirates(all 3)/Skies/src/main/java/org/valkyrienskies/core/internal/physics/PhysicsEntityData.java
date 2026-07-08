/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.physics;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;

@Deprecated(message="To be replaced by VsBodies eventually.")
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\u0006\u0010#\u001a\u00020\u0016\u0012\b\b\u0002\u0010$\u001a\u00020\u0019\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\t\u00a2\u0006\u0004\bX\u0010YJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0016H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u00c6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u001c\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\bJ\u0082\u0001\u0010)\u001a\u00020\u00002\f\b\u0002\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00162\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\u00002\n\u0010+\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0019H\u00d6\u0001\u00a2\u0006\u0004\b1\u0010\u001bJ\u0010\u00103\u001a\u000202H\u00d6\u0001\u00a2\u0006\u0004\b3\u00104R\"\u0010\"\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u00105\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u00108R\"\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u00109\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010<R\"\u0010#\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010=\u001a\u0004\b>\u0010\u0018\"\u0004\b?\u0010@R\"\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010A\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010DR\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010E\u001a\u0004\bF\u0010\u0011\"\u0004\bG\u0010HR\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010I\u001a\u0004\b(\u0010\u000b\"\u0004\bJ\u0010KR\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00105\u001a\u0004\bL\u0010\u0014\"\u0004\bM\u00108R\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010A\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010DR\u001b\u0010\u001e\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010P\u001a\u0004\bQ\u0010\u0005R\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010A\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010DR\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010T\u001a\u0004\bU\u0010\u000e\"\u0004\bV\u0010W\u00a8\u0006Z"}, d2={"Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "", "component10", "()D", "", "component11", "()Z", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "component2", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "component3", "()Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "Lorg/joml/Vector3dc;", "component4", "()Lorg/joml/Vector3dc;", "component5", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "component6", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "", "component7", "()I", "component8", "component9", "shipId", "transform", "inertiaData", "linearVelocity", "angularVelocity", "collisionShapeData", "collisionMask", "staticFrictionCoefficient", "dynamicFrictionCoefficient", "restitutionCoefficient", "isStatic", "copy", "(JLorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;IDDDZ)Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "newId", "copyPhysicsEntityDataWithNewId", "(J)Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getAngularVelocity", "setAngularVelocity", "(Lorg/joml/Vector3dc;)V", "I", "getCollisionMask", "setCollisionMask", "(I)V", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "getCollisionShapeData", "setCollisionShapeData", "(Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)V", "D", "getDynamicFrictionCoefficient", "setDynamicFrictionCoefficient", "(D)V", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "getInertiaData", "setInertiaData", "(Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;)V", "Z", "setStatic", "(Z)V", "getLinearVelocity", "setLinearVelocity", "getRestitutionCoefficient", "setRestitutionCoefficient", "J", "getShipId", "getStaticFrictionCoefficient", "setStaticFrictionCoefficient", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getTransform", "setTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)V", "<init>", "(JLorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;IDDDZ)V", "internal"})
public final class PhysicsEntityData {
    private final long shipId;
    @NotNull
    private ShipTransform transform;
    @NotNull
    private ShipInertiaData inertiaData;
    @NotNull
    private Vector3dc linearVelocity;
    @NotNull
    private Vector3dc angularVelocity;
    @NotNull
    private VSCollisionShapeData collisionShapeData;
    private int collisionMask;
    private double staticFrictionCoefficient;
    private double dynamicFrictionCoefficient;
    private double restitutionCoefficient;
    private boolean isStatic;

    public PhysicsEntityData(long shipId, @NotNull ShipTransform transform2, @NotNull ShipInertiaData inertiaData, @NotNull Vector3dc linearVelocity, @NotNull Vector3dc angularVelocity, @NotNull VSCollisionShapeData collisionShapeData, int collisionMask, double staticFrictionCoefficient, double dynamicFrictionCoefficient, double restitutionCoefficient, boolean isStatic) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"inertiaData");
        Intrinsics.checkNotNullParameter((Object)linearVelocity, (String)"linearVelocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"collisionShapeData");
        this.shipId = shipId;
        this.transform = transform2;
        this.inertiaData = inertiaData;
        this.linearVelocity = linearVelocity;
        this.angularVelocity = angularVelocity;
        this.collisionShapeData = collisionShapeData;
        this.collisionMask = collisionMask;
        this.staticFrictionCoefficient = staticFrictionCoefficient;
        this.dynamicFrictionCoefficient = dynamicFrictionCoefficient;
        this.restitutionCoefficient = restitutionCoefficient;
        this.isStatic = isStatic;
    }

    public /* synthetic */ PhysicsEntityData(long l2, ShipTransform shipTransform, ShipInertiaData shipInertiaData, Vector3dc vector3dc, Vector3dc vector3dc2, VSCollisionShapeData vSCollisionShapeData, int n2, double d2, double d3, double d4, boolean bl, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 0x40) != 0) {
            n2 = -1;
        }
        if ((n3 & 0x80) != 0) {
            d2 = 0.3;
        }
        if ((n3 & 0x100) != 0) {
            d3 = 0.3;
        }
        if ((n3 & 0x200) != 0) {
            d4 = 0.6;
        }
        if ((n3 & 0x400) != 0) {
            bl = false;
        }
        this(l2, shipTransform, shipInertiaData, vector3dc, vector3dc2, vSCollisionShapeData, n2, d2, d3, d4, bl);
    }

    public final long getShipId() {
        return this.shipId;
    }

    @NotNull
    public final ShipTransform getTransform() {
        return this.transform;
    }

    public final void setTransform(@NotNull ShipTransform shipTransform) {
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"<set-?>");
        this.transform = shipTransform;
    }

    @NotNull
    public final ShipInertiaData getInertiaData() {
        return this.inertiaData;
    }

    public final void setInertiaData(@NotNull ShipInertiaData shipInertiaData) {
        Intrinsics.checkNotNullParameter((Object)shipInertiaData, (String)"<set-?>");
        this.inertiaData = shipInertiaData;
    }

    @NotNull
    public final Vector3dc getLinearVelocity() {
        return this.linearVelocity;
    }

    public final void setLinearVelocity(@NotNull Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"<set-?>");
        this.linearVelocity = vector3dc;
    }

    @NotNull
    public final Vector3dc getAngularVelocity() {
        return this.angularVelocity;
    }

    public final void setAngularVelocity(@NotNull Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"<set-?>");
        this.angularVelocity = vector3dc;
    }

    @NotNull
    public final VSCollisionShapeData getCollisionShapeData() {
        return this.collisionShapeData;
    }

    public final void setCollisionShapeData(@NotNull VSCollisionShapeData vSCollisionShapeData) {
        Intrinsics.checkNotNullParameter((Object)vSCollisionShapeData, (String)"<set-?>");
        this.collisionShapeData = vSCollisionShapeData;
    }

    public final int getCollisionMask() {
        return this.collisionMask;
    }

    public final void setCollisionMask(int n2) {
        this.collisionMask = n2;
    }

    public final double getStaticFrictionCoefficient() {
        return this.staticFrictionCoefficient;
    }

    public final void setStaticFrictionCoefficient(double d2) {
        this.staticFrictionCoefficient = d2;
    }

    public final double getDynamicFrictionCoefficient() {
        return this.dynamicFrictionCoefficient;
    }

    public final void setDynamicFrictionCoefficient(double d2) {
        this.dynamicFrictionCoefficient = d2;
    }

    public final double getRestitutionCoefficient() {
        return this.restitutionCoefficient;
    }

    public final void setRestitutionCoefficient(double d2) {
        this.restitutionCoefficient = d2;
    }

    public final boolean isStatic() {
        return this.isStatic;
    }

    public final void setStatic(boolean bl) {
        this.isStatic = bl;
    }

    @NotNull
    public final PhysicsEntityData copyPhysicsEntityDataWithNewId(long newId) {
        return new PhysicsEntityData(newId, this.transform, this.inertiaData, this.linearVelocity, this.angularVelocity, this.collisionShapeData, this.collisionMask, this.staticFrictionCoefficient, this.dynamicFrictionCoefficient, this.restitutionCoefficient, this.isStatic);
    }

    public final long component1() {
        return this.shipId;
    }

    @NotNull
    public final ShipTransform component2() {
        return this.transform;
    }

    @NotNull
    public final ShipInertiaData component3() {
        return this.inertiaData;
    }

    @NotNull
    public final Vector3dc component4() {
        return this.linearVelocity;
    }

    @NotNull
    public final Vector3dc component5() {
        return this.angularVelocity;
    }

    @NotNull
    public final VSCollisionShapeData component6() {
        return this.collisionShapeData;
    }

    public final int component7() {
        return this.collisionMask;
    }

    public final double component8() {
        return this.staticFrictionCoefficient;
    }

    public final double component9() {
        return this.dynamicFrictionCoefficient;
    }

    public final double component10() {
        return this.restitutionCoefficient;
    }

    public final boolean component11() {
        return this.isStatic;
    }

    @NotNull
    public final PhysicsEntityData copy(long shipId, @NotNull ShipTransform transform2, @NotNull ShipInertiaData inertiaData, @NotNull Vector3dc linearVelocity, @NotNull Vector3dc angularVelocity, @NotNull VSCollisionShapeData collisionShapeData, int collisionMask, double staticFrictionCoefficient, double dynamicFrictionCoefficient, double restitutionCoefficient, boolean isStatic) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"inertiaData");
        Intrinsics.checkNotNullParameter((Object)linearVelocity, (String)"linearVelocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"collisionShapeData");
        return new PhysicsEntityData(shipId, transform2, inertiaData, linearVelocity, angularVelocity, collisionShapeData, collisionMask, staticFrictionCoefficient, dynamicFrictionCoefficient, restitutionCoefficient, isStatic);
    }

    public static /* synthetic */ PhysicsEntityData copy$default(PhysicsEntityData physicsEntityData, long l2, ShipTransform shipTransform, ShipInertiaData shipInertiaData, Vector3dc vector3dc, Vector3dc vector3dc2, VSCollisionShapeData vSCollisionShapeData, int n2, double d2, double d3, double d4, boolean bl, int n3, Object object) {
        if ((n3 & 1) != 0) {
            l2 = physicsEntityData.shipId;
        }
        if ((n3 & 2) != 0) {
            shipTransform = physicsEntityData.transform;
        }
        if ((n3 & 4) != 0) {
            shipInertiaData = physicsEntityData.inertiaData;
        }
        if ((n3 & 8) != 0) {
            vector3dc = physicsEntityData.linearVelocity;
        }
        if ((n3 & 0x10) != 0) {
            vector3dc2 = physicsEntityData.angularVelocity;
        }
        if ((n3 & 0x20) != 0) {
            vSCollisionShapeData = physicsEntityData.collisionShapeData;
        }
        if ((n3 & 0x40) != 0) {
            n2 = physicsEntityData.collisionMask;
        }
        if ((n3 & 0x80) != 0) {
            d2 = physicsEntityData.staticFrictionCoefficient;
        }
        if ((n3 & 0x100) != 0) {
            d3 = physicsEntityData.dynamicFrictionCoefficient;
        }
        if ((n3 & 0x200) != 0) {
            d4 = physicsEntityData.restitutionCoefficient;
        }
        if ((n3 & 0x400) != 0) {
            bl = physicsEntityData.isStatic;
        }
        return physicsEntityData.copy(l2, shipTransform, shipInertiaData, vector3dc, vector3dc2, vSCollisionShapeData, n2, d2, d3, d4, bl);
    }

    @NotNull
    public String toString() {
        return "PhysicsEntityData(shipId=" + this.shipId + ", transform=" + this.transform + ", inertiaData=" + this.inertiaData + ", linearVelocity=" + this.linearVelocity + ", angularVelocity=" + this.angularVelocity + ", collisionShapeData=" + this.collisionShapeData + ", collisionMask=" + this.collisionMask + ", staticFrictionCoefficient=" + this.staticFrictionCoefficient + ", dynamicFrictionCoefficient=" + this.dynamicFrictionCoefficient + ", restitutionCoefficient=" + this.restitutionCoefficient + ", isStatic=" + this.isStatic + ")";
    }

    public int hashCode() {
        int result2 = Long.hashCode(this.shipId);
        result2 = result2 * 31 + this.transform.hashCode();
        result2 = result2 * 31 + this.inertiaData.hashCode();
        result2 = result2 * 31 + this.linearVelocity.hashCode();
        result2 = result2 * 31 + this.angularVelocity.hashCode();
        result2 = result2 * 31 + this.collisionShapeData.hashCode();
        result2 = result2 * 31 + Integer.hashCode(this.collisionMask);
        result2 = result2 * 31 + Double.hashCode(this.staticFrictionCoefficient);
        result2 = result2 * 31 + Double.hashCode(this.dynamicFrictionCoefficient);
        result2 = result2 * 31 + Double.hashCode(this.restitutionCoefficient);
        result2 = result2 * 31 + Boolean.hashCode(this.isStatic);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysicsEntityData)) {
            return false;
        }
        PhysicsEntityData physicsEntityData = (PhysicsEntityData)other;
        if (this.shipId != physicsEntityData.shipId) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.transform, (Object)physicsEntityData.transform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.inertiaData, (Object)physicsEntityData.inertiaData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.linearVelocity, (Object)physicsEntityData.linearVelocity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.angularVelocity, (Object)physicsEntityData.angularVelocity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.collisionShapeData, (Object)physicsEntityData.collisionShapeData)) {
            return false;
        }
        if (this.collisionMask != physicsEntityData.collisionMask) {
            return false;
        }
        if (Double.compare(this.staticFrictionCoefficient, physicsEntityData.staticFrictionCoefficient) != 0) {
            return false;
        }
        if (Double.compare(this.dynamicFrictionCoefficient, physicsEntityData.dynamicFrictionCoefficient) != 0) {
            return false;
        }
        if (Double.compare(this.restitutionCoefficient, physicsEntityData.restitutionCoefficient) != 0) {
            return false;
        }
        return this.isStatic == physicsEntityData.isStatic;
    }
}

