/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.phys_entities;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.game.ships.ShipTransformImpl;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017\u0012\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011\u0012\u0006\u00108\u001a\u00020#\u0012\u0006\u0010-\u001a\u00020#\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0007\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00060\u0016j\u0002`\u00178\u0007\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020#8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R$\u00102\u001a\u0002002\u0006\u00101\u001a\u0002008\u0007@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R$\u00106\u001a\u00020#2\u0006\u00101\u001a\u00020#8\u0007@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'R\"\u00108\u001a\u00020#8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010%\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)"}, d2={"Lorg/valkyrienskies/core/impl/game/phys_entities/PhysicsEntityClient;", "", "", "tickUpdateShipTransform", "()V", "", "partialTicks", "updateRenderShipTransform", "(D)V", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "collisionShapeData", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "getCollisionShapeData", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "setCollisionShapeData", "(Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)V", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Ljava/lang/String;", "getDimensionId", "()Ljava/lang/String;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "J", "getId", "()J", "", "latestNetworkTTick", "I", "getLatestNetworkTTick", "()I", "setLatestNetworkTTick", "(I)V", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "latestNetworkTransform", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getLatestNetworkTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "setLatestNetworkTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)V", "nextShipTransform", "getNextShipTransform", "setNextShipTransform", "prevTickShipTransform", "getPrevTickShipTransform", "setPrevTickShipTransform", "Lorg/joml/primitives/AABBdc;", "p0", "renderAABB", "Lorg/joml/primitives/AABBdc;", "getRenderAABB", "()Lorg/joml/primitives/AABBdc;", "renderTransform", "getRenderTransform", "shipTransform", "getShipTransform", "setShipTransform", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;)V"})
public final class PhysicsEntityClient {
    private final long id;
    private final String dimensionId;
    private ShipTransform shipTransform;
    private ShipTransform prevTickShipTransform;
    private VSCollisionShapeData collisionShapeData;
    private ShipTransform nextShipTransform;
    private ShipTransform renderTransform;
    private AABBdc renderAABB;
    private ShipTransform latestNetworkTransform;
    private int latestNetworkTTick;

    /*
     * WARNING - void declaration
     */
    public PhysicsEntityClient(long id, String dimensionId, ShipTransform shipTransform, ShipTransform prevTickShipTransform, VSCollisionShapeData collisionShapeData) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)prevTickShipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)collisionShapeData, (String)"");
        this.id = var1_1;
        this.dimensionId = var3_2;
        this.shipTransform = shipTransform;
        this.prevTickShipTransform = prevTickShipTransform;
        this.collisionShapeData = collisionShapeData;
        this.nextShipTransform = this.shipTransform;
        this.renderTransform = this.shipTransform;
        this.renderAABB = this.shipTransform.createEmptyAABB();
        this.latestNetworkTransform = this.shipTransform;
        this.latestNetworkTTick = Integer.MIN_VALUE;
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

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setShipTransform")
    public final void setShipTransform(ShipTransform shipTransform) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        this.shipTransform = var1_1;
    }

    @JvmName(name="getPrevTickShipTransform")
    public final ShipTransform getPrevTickShipTransform() {
        return this.prevTickShipTransform;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setPrevTickShipTransform")
    public final void setPrevTickShipTransform(ShipTransform shipTransform) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        this.prevTickShipTransform = var1_1;
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

    @JvmName(name="getNextShipTransform")
    public final ShipTransform getNextShipTransform() {
        return this.nextShipTransform;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setNextShipTransform")
    public final void setNextShipTransform(ShipTransform shipTransform) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        this.nextShipTransform = var1_1;
    }

    @JvmName(name="getRenderTransform")
    public final ShipTransform getRenderTransform() {
        return this.renderTransform;
    }

    @JvmName(name="getRenderAABB")
    public final AABBdc getRenderAABB() {
        return this.renderAABB;
    }

    @JvmName(name="getLatestNetworkTransform")
    public final ShipTransform getLatestNetworkTransform() {
        return this.latestNetworkTransform;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setLatestNetworkTransform")
    public final void setLatestNetworkTransform(ShipTransform shipTransform) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        this.latestNetworkTransform = var1_1;
    }

    @JvmName(name="getLatestNetworkTTick")
    public final int getLatestNetworkTTick() {
        return this.latestNetworkTTick;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setLatestNetworkTTick")
    public final void setLatestNetworkTTick(int n2) {
        void var1_1;
        this.latestNetworkTTick = var1_1;
    }

    public final void tickUpdateShipTransform() {
        this.nextShipTransform = this.latestNetworkTransform;
        this.prevTickShipTransform = this.shipTransform;
        this.shipTransform = ShipTransformImpl.Companion.createFromSlerp(this.shipTransform, this.nextShipTransform, 0.7);
    }

    /*
     * WARNING - void declaration
     */
    public final void updateRenderShipTransform(double partialTicks) {
        void var1_1;
        this.renderTransform = ShipTransformImpl.Companion.createFromSlerp(this.prevTickShipTransform, this.shipTransform, (double)var1_1);
        this.renderAABB = this.renderTransform.createEmptyAABB();
    }
}

