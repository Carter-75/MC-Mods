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

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;

@Deprecated(message="To be replaced by VsBodies eventually.")
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bI\b\u0087\b\u0018\u00002\u00020\u0001B\u00a3\u0001\u0012\n\u0010)\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010*\u001a\u00060\u0016j\u0002`\u0017\u0012\u0006\u0010+\u001a\u00020\u001a\u0012\u0006\u0010,\u001a\u00020\u001a\u0012\u0006\u0010-\u001a\u00020\u001e\u0012\u0006\u0010.\u001a\u00020!\u0012\u0006\u0010/\u001a\u00020!\u0012\u0006\u00100\u001a\u00020\u0006\u0012\u0006\u00101\u001a\u00020&\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\b\b\u0002\u00103\u001a\u00020\t\u0012\b\b\u0002\u00104\u001a\u00020\t\u0012\b\b\u0002\u00105\u001a\u00020\t\u0012\b\b\u0002\u00106\u001a\u00020\u000e\u0012\b\b\u0002\u00107\u001a\u00020\u000e\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\bm\u0010nJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u001eH\u00c6\u0003\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!H\u00c6\u0003\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020!H\u00c6\u0003\u00a2\u0006\u0004\b$\u0010#J\u0010\u0010%\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b%\u0010\bJ\u0010\u0010'\u001a\u00020&H\u00c6\u0003\u00a2\u0006\u0004\b'\u0010(J\u00be\u0001\u00109\u001a\u00020\u00002\f\b\u0002\u0010)\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010*\u001a\u00060\u0016j\u0002`\u00172\b\b\u0002\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010,\u001a\u00020\u001a2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010/\u001a\u00020!2\b\b\u0002\u00100\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u00020&2\b\b\u0002\u00102\u001a\u00020\u00062\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020\t2\b\b\u0002\u00105\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020\u000e2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00c6\u0001\u00a2\u0006\u0004\b9\u0010:J\u001a\u0010<\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0006H\u00d6\u0001\u00a2\u0006\u0004\b>\u0010\bJ\u0010\u0010?\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b?\u0010\u0019R\"\u0010,\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010@\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010CR\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010D\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010GR\"\u00101\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010H\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010KR\u001b\u0010*\u001a\u00060\u0016j\u0002`\u00178\u0006\u00a2\u0006\f\n\u0004\b*\u0010L\u001a\u0004\bM\u0010\u0019R\"\u00104\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010N\u001a\u0004\bO\u0010\u000b\"\u0004\bP\u0010QR\u001b\u0010)\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b)\u0010R\u001a\u0004\bS\u0010\u0005R\"\u0010-\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010T\u001a\u0004\bU\u0010 \"\u0004\bV\u0010WR\"\u00106\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010X\u001a\u0004\b6\u0010\u0010\"\u0004\bY\u0010ZR\"\u0010+\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010@\u001a\u0004\b[\u0010\u001c\"\u0004\b\\\u0010CR\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010X\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010ZR\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b8\u0010_\u001a\u0004\b`\u0010\u0015R\"\u0010/\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010a\u001a\u0004\bb\u0010#\"\u0004\bc\u0010dR\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010N\u001a\u0004\be\u0010\u000b\"\u0004\bf\u0010QR\"\u00100\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010D\u001a\u0004\bg\u0010\b\"\u0004\bh\u0010GR\"\u0010.\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010a\u001a\u0004\bi\u0010#\"\u0004\bj\u0010dR\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010N\u001a\u0004\bk\u0010\u000b\"\u0004\bl\u0010Q\u00a8\u0006o"}, d2={"Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "", "component10", "()I", "", "component11", "()D", "component12", "component13", "", "component14", "()Z", "component15", "", "Lorg/valkyrienskies/core/api/ships/ShipPhysicsListener;", "component16", "()Ljava/util/List;", "", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "component2", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "component3", "()Lorg/joml/Vector3dc;", "component4", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "component5", "()Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "component6", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "component7", "component8", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "component9", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "id", "dimensionId", "linearVelocity", "angularVelocity", "inertiaData", "shipTransform", "prevTickShipTransform", "shipTeleportId", "collisionShapeData", "collisionMask", "staticFrictionCoefficient", "dynamicFrictionCoefficient", "restitutionCoefficient", "isStatic", "needsUpdating", "physicsListeners", "copy", "(JLjava/lang/String;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;ILorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;IDDDZZLjava/util/List;)Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Lorg/joml/Vector3dc;", "getAngularVelocity", "setAngularVelocity", "(Lorg/joml/Vector3dc;)V", "I", "getCollisionMask", "setCollisionMask", "(I)V", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "getCollisionShapeData", "setCollisionShapeData", "(Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)V", "Ljava/lang/String;", "getDimensionId", "D", "getDynamicFrictionCoefficient", "setDynamicFrictionCoefficient", "(D)V", "J", "getId", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "getInertiaData", "setInertiaData", "(Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;)V", "Z", "setStatic", "(Z)V", "getLinearVelocity", "setLinearVelocity", "getNeedsUpdating", "setNeedsUpdating", "Ljava/util/List;", "getPhysicsListeners", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickShipTransform", "setPrevTickShipTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)V", "getRestitutionCoefficient", "setRestitutionCoefficient", "getShipTeleportId", "setShipTeleportId", "getShipTransform", "setShipTransform", "getStaticFrictionCoefficient", "setStaticFrictionCoefficient", "<init>", "(JLjava/lang/String;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;ILorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;IDDDZZLjava/util/List;)V", "internal"})
public final class PhysicsEntityServer {
    private final long id;
    @NotNull
    private final String dimensionId;
    @NotNull
    private Vector3dc linearVelocity;
    @NotNull
    private Vector3dc angularVelocity;
    @NotNull
    private ShipInertiaData inertiaData;
    @NotNull
    private ShipTransform shipTransform;
    @NotNull
    private ShipTransform prevTickShipTransform;
    private int shipTeleportId;
    @NotNull
    private VSCollisionShapeData collisionShapeData;
    private int collisionMask;
    private double staticFrictionCoefficient;
    private double dynamicFrictionCoefficient;
    private double restitutionCoefficient;
    private boolean isStatic;
    private boolean needsUpdating;
    @NotNull
    private final List<ShipPhysicsListener> physicsListeners;

    public PhysicsEntityServer(long id, @NotNull String dimensionId, @NotNull Vector3dc linearVelocity, @NotNull Vector3dc angularVelocity, @NotNull ShipInertiaData inertiaData, @NotNull ShipTransform shipTransform, @NotNull ShipTransform prevTickShipTransform, int shipTeleportId, @NotNull VSCollisionShapeData collisionShapeData, int collisionMask, double staticFrictionCoefficient, double dynamicFrictionCoefficient, double restitutionCoefficient, boolean isStatic, boolean needsUpdating, @NotNull List<ShipPhysicsListener> physicsListeners) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)linearVelocity, (String)"linearVelocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"inertiaData");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"shipTransform");
        Intrinsics.checkNotNullParameter((Object)prevTickShipTransform, (String)"prevTickShipTransform");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"collisionShapeData");
        Intrinsics.checkNotNullParameter(physicsListeners, (String)"physicsListeners");
        this.id = id;
        this.dimensionId = dimensionId;
        this.linearVelocity = linearVelocity;
        this.angularVelocity = angularVelocity;
        this.inertiaData = inertiaData;
        this.shipTransform = shipTransform;
        this.prevTickShipTransform = prevTickShipTransform;
        this.shipTeleportId = shipTeleportId;
        this.collisionShapeData = collisionShapeData;
        this.collisionMask = collisionMask;
        this.staticFrictionCoefficient = staticFrictionCoefficient;
        this.dynamicFrictionCoefficient = dynamicFrictionCoefficient;
        this.restitutionCoefficient = restitutionCoefficient;
        this.isStatic = isStatic;
        this.needsUpdating = needsUpdating;
        this.physicsListeners = physicsListeners;
    }

    public /* synthetic */ PhysicsEntityServer(long l2, String string, Vector3dc vector3dc, Vector3dc vector3dc2, ShipInertiaData shipInertiaData, ShipTransform shipTransform, ShipTransform shipTransform2, int n2, VSCollisionShapeData vSCollisionShapeData, int n3, double d2, double d3, double d4, boolean bl, boolean bl2, List list, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x200) != 0) {
            n3 = -1;
        }
        if ((n4 & 0x400) != 0) {
            d2 = 0.3;
        }
        if ((n4 & 0x800) != 0) {
            d3 = 0.3;
        }
        if ((n4 & 0x1000) != 0) {
            d4 = 0.6;
        }
        if ((n4 & 0x2000) != 0) {
            bl = false;
        }
        if ((n4 & 0x4000) != 0) {
            bl2 = false;
        }
        if ((n4 & 0x8000) != 0) {
            list = new ArrayList();
        }
        this(l2, string, vector3dc, vector3dc2, shipInertiaData, shipTransform, shipTransform2, n2, vSCollisionShapeData, n3, d2, d3, d4, bl, bl2, list);
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getDimensionId() {
        return this.dimensionId;
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
    public final ShipInertiaData getInertiaData() {
        return this.inertiaData;
    }

    public final void setInertiaData(@NotNull ShipInertiaData shipInertiaData) {
        Intrinsics.checkNotNullParameter((Object)shipInertiaData, (String)"<set-?>");
        this.inertiaData = shipInertiaData;
    }

    @NotNull
    public final ShipTransform getShipTransform() {
        return this.shipTransform;
    }

    public final void setShipTransform(@NotNull ShipTransform shipTransform) {
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"<set-?>");
        this.shipTransform = shipTransform;
    }

    @NotNull
    public final ShipTransform getPrevTickShipTransform() {
        return this.prevTickShipTransform;
    }

    public final void setPrevTickShipTransform(@NotNull ShipTransform shipTransform) {
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"<set-?>");
        this.prevTickShipTransform = shipTransform;
    }

    public final int getShipTeleportId() {
        return this.shipTeleportId;
    }

    public final void setShipTeleportId(int n2) {
        this.shipTeleportId = n2;
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

    public final boolean getNeedsUpdating() {
        return this.needsUpdating;
    }

    public final void setNeedsUpdating(boolean bl) {
        this.needsUpdating = bl;
    }

    @NotNull
    public final List<ShipPhysicsListener> getPhysicsListeners() {
        return this.physicsListeners;
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.dimensionId;
    }

    @NotNull
    public final Vector3dc component3() {
        return this.linearVelocity;
    }

    @NotNull
    public final Vector3dc component4() {
        return this.angularVelocity;
    }

    @NotNull
    public final ShipInertiaData component5() {
        return this.inertiaData;
    }

    @NotNull
    public final ShipTransform component6() {
        return this.shipTransform;
    }

    @NotNull
    public final ShipTransform component7() {
        return this.prevTickShipTransform;
    }

    public final int component8() {
        return this.shipTeleportId;
    }

    @NotNull
    public final VSCollisionShapeData component9() {
        return this.collisionShapeData;
    }

    public final int component10() {
        return this.collisionMask;
    }

    public final double component11() {
        return this.staticFrictionCoefficient;
    }

    public final double component12() {
        return this.dynamicFrictionCoefficient;
    }

    public final double component13() {
        return this.restitutionCoefficient;
    }

    public final boolean component14() {
        return this.isStatic;
    }

    public final boolean component15() {
        return this.needsUpdating;
    }

    @NotNull
    public final List<ShipPhysicsListener> component16() {
        return this.physicsListeners;
    }

    @NotNull
    public final PhysicsEntityServer copy(long id, @NotNull String dimensionId, @NotNull Vector3dc linearVelocity, @NotNull Vector3dc angularVelocity, @NotNull ShipInertiaData inertiaData, @NotNull ShipTransform shipTransform, @NotNull ShipTransform prevTickShipTransform, int shipTeleportId, @NotNull VSCollisionShapeData collisionShapeData, int collisionMask, double staticFrictionCoefficient, double dynamicFrictionCoefficient, double restitutionCoefficient, boolean isStatic, boolean needsUpdating, @NotNull List<ShipPhysicsListener> physicsListeners) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        Intrinsics.checkNotNullParameter((Object)linearVelocity, (String)"linearVelocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"inertiaData");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"shipTransform");
        Intrinsics.checkNotNullParameter((Object)prevTickShipTransform, (String)"prevTickShipTransform");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"collisionShapeData");
        Intrinsics.checkNotNullParameter(physicsListeners, (String)"physicsListeners");
        return new PhysicsEntityServer(id, dimensionId, linearVelocity, angularVelocity, inertiaData, shipTransform, prevTickShipTransform, shipTeleportId, collisionShapeData, collisionMask, staticFrictionCoefficient, dynamicFrictionCoefficient, restitutionCoefficient, isStatic, needsUpdating, physicsListeners);
    }

    public static /* synthetic */ PhysicsEntityServer copy$default(PhysicsEntityServer physicsEntityServer, long l2, String string, Vector3dc vector3dc, Vector3dc vector3dc2, ShipInertiaData shipInertiaData, ShipTransform shipTransform, ShipTransform shipTransform2, int n2, VSCollisionShapeData vSCollisionShapeData, int n3, double d2, double d3, double d4, boolean bl, boolean bl2, List list, int n4, Object object) {
        if ((n4 & 1) != 0) {
            l2 = physicsEntityServer.id;
        }
        if ((n4 & 2) != 0) {
            string = physicsEntityServer.dimensionId;
        }
        if ((n4 & 4) != 0) {
            vector3dc = physicsEntityServer.linearVelocity;
        }
        if ((n4 & 8) != 0) {
            vector3dc2 = physicsEntityServer.angularVelocity;
        }
        if ((n4 & 0x10) != 0) {
            shipInertiaData = physicsEntityServer.inertiaData;
        }
        if ((n4 & 0x20) != 0) {
            shipTransform = physicsEntityServer.shipTransform;
        }
        if ((n4 & 0x40) != 0) {
            shipTransform2 = physicsEntityServer.prevTickShipTransform;
        }
        if ((n4 & 0x80) != 0) {
            n2 = physicsEntityServer.shipTeleportId;
        }
        if ((n4 & 0x100) != 0) {
            vSCollisionShapeData = physicsEntityServer.collisionShapeData;
        }
        if ((n4 & 0x200) != 0) {
            n3 = physicsEntityServer.collisionMask;
        }
        if ((n4 & 0x400) != 0) {
            d2 = physicsEntityServer.staticFrictionCoefficient;
        }
        if ((n4 & 0x800) != 0) {
            d3 = physicsEntityServer.dynamicFrictionCoefficient;
        }
        if ((n4 & 0x1000) != 0) {
            d4 = physicsEntityServer.restitutionCoefficient;
        }
        if ((n4 & 0x2000) != 0) {
            bl = physicsEntityServer.isStatic;
        }
        if ((n4 & 0x4000) != 0) {
            bl2 = physicsEntityServer.needsUpdating;
        }
        if ((n4 & 0x8000) != 0) {
            list = physicsEntityServer.physicsListeners;
        }
        return physicsEntityServer.copy(l2, string, vector3dc, vector3dc2, shipInertiaData, shipTransform, shipTransform2, n2, vSCollisionShapeData, n3, d2, d3, d4, bl, bl2, list);
    }

    @NotNull
    public String toString() {
        return "PhysicsEntityServer(id=" + this.id + ", dimensionId=" + this.dimensionId + ", linearVelocity=" + this.linearVelocity + ", angularVelocity=" + this.angularVelocity + ", inertiaData=" + this.inertiaData + ", shipTransform=" + this.shipTransform + ", prevTickShipTransform=" + this.prevTickShipTransform + ", shipTeleportId=" + this.shipTeleportId + ", collisionShapeData=" + this.collisionShapeData + ", collisionMask=" + this.collisionMask + ", staticFrictionCoefficient=" + this.staticFrictionCoefficient + ", dynamicFrictionCoefficient=" + this.dynamicFrictionCoefficient + ", restitutionCoefficient=" + this.restitutionCoefficient + ", isStatic=" + this.isStatic + ", needsUpdating=" + this.needsUpdating + ", physicsListeners=" + this.physicsListeners + ")";
    }

    public int hashCode() {
        int result2 = Long.hashCode(this.id);
        result2 = result2 * 31 + this.dimensionId.hashCode();
        result2 = result2 * 31 + this.linearVelocity.hashCode();
        result2 = result2 * 31 + this.angularVelocity.hashCode();
        result2 = result2 * 31 + this.inertiaData.hashCode();
        result2 = result2 * 31 + this.shipTransform.hashCode();
        result2 = result2 * 31 + this.prevTickShipTransform.hashCode();
        result2 = result2 * 31 + Integer.hashCode(this.shipTeleportId);
        result2 = result2 * 31 + this.collisionShapeData.hashCode();
        result2 = result2 * 31 + Integer.hashCode(this.collisionMask);
        result2 = result2 * 31 + Double.hashCode(this.staticFrictionCoefficient);
        result2 = result2 * 31 + Double.hashCode(this.dynamicFrictionCoefficient);
        result2 = result2 * 31 + Double.hashCode(this.restitutionCoefficient);
        result2 = result2 * 31 + Boolean.hashCode(this.isStatic);
        result2 = result2 * 31 + Boolean.hashCode(this.needsUpdating);
        result2 = result2 * 31 + ((Object)this.physicsListeners).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysicsEntityServer)) {
            return false;
        }
        PhysicsEntityServer physicsEntityServer = (PhysicsEntityServer)other;
        if (this.id != physicsEntityServer.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dimensionId, (Object)physicsEntityServer.dimensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.linearVelocity, (Object)physicsEntityServer.linearVelocity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.angularVelocity, (Object)physicsEntityServer.angularVelocity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.inertiaData, (Object)physicsEntityServer.inertiaData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipTransform, (Object)physicsEntityServer.shipTransform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.prevTickShipTransform, (Object)physicsEntityServer.prevTickShipTransform)) {
            return false;
        }
        if (this.shipTeleportId != physicsEntityServer.shipTeleportId) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.collisionShapeData, (Object)physicsEntityServer.collisionShapeData)) {
            return false;
        }
        if (this.collisionMask != physicsEntityServer.collisionMask) {
            return false;
        }
        if (Double.compare(this.staticFrictionCoefficient, physicsEntityServer.staticFrictionCoefficient) != 0) {
            return false;
        }
        if (Double.compare(this.dynamicFrictionCoefficient, physicsEntityServer.dynamicFrictionCoefficient) != 0) {
            return false;
        }
        if (Double.compare(this.restitutionCoefficient, physicsEntityServer.restitutionCoefficient) != 0) {
            return false;
        }
        if (this.isStatic != physicsEntityServer.isStatic) {
            return false;
        }
        if (this.needsUpdating != physicsEntityServer.needsUpdating) {
            return false;
        }
        return Intrinsics.areEqual(this.physicsListeners, physicsEntityServer.physicsListeners);
    }
}

