/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0006\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "component2", "linearVelocity", "angularVelocity", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getAngularVelocity", "setAngularVelocity", "(Lorg/joml/Vector3dc;)V", "getLinearVelocity", "setLinearVelocity", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "Companion"})
public final class ShipPhysicsData {
    public static final Companion Companion = new Companion(null);
    private Vector3dc linearVelocity;
    private Vector3dc angularVelocity;

    /*
     * WARNING - void declaration
     */
    public ShipPhysicsData(Vector3dc linearVelocity, Vector3dc angularVelocity) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)linearVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        this.linearVelocity = var1_1;
        this.angularVelocity = var2_2;
    }

    @JvmName(name="getLinearVelocity")
    public final Vector3dc getLinearVelocity() {
        return this.linearVelocity;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setLinearVelocity")
    public final void setLinearVelocity(Vector3dc vector3dc) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.linearVelocity = var1_1;
    }

    @JvmName(name="getAngularVelocity")
    public final Vector3dc getAngularVelocity() {
        return this.angularVelocity;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setAngularVelocity")
    public final void setAngularVelocity(Vector3dc vector3dc) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.angularVelocity = var1_1;
    }

    public final Vector3dc component1() {
        return this.linearVelocity;
    }

    public final Vector3dc component2() {
        return this.angularVelocity;
    }

    /*
     * WARNING - void declaration
     */
    public final ShipPhysicsData copy(Vector3dc linearVelocity, Vector3dc angularVelocity) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)linearVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        return new ShipPhysicsData((Vector3dc)var1_1, (Vector3dc)var2_2);
    }

    public static /* synthetic */ ShipPhysicsData copy$default(ShipPhysicsData shipPhysicsData, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = shipPhysicsData.linearVelocity;
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = shipPhysicsData.angularVelocity;
        }
        return shipPhysicsData.copy(vector3dc, vector3dc2);
    }

    public final String toString() {
        return "ShipPhysicsData(linearVelocity=" + this.linearVelocity + ", angularVelocity=" + this.angularVelocity + ")";
    }

    public final int hashCode() {
        int n2 = this.linearVelocity.hashCode();
        n2 = n2 * 31 + this.angularVelocity.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ShipPhysicsData shipPhysicsData;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipPhysicsData)) {
            return false;
        }
        shipPhysicsData = shipPhysicsData;
        if (!Intrinsics.areEqual((Object)this.linearVelocity, (Object)shipPhysicsData.linearVelocity)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.angularVelocity, (Object)shipPhysicsData.angularVelocity);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData$Companion;", "", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "createEmpty", "()Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "<init>", "()V"})
    public static final class Companion {
        private Companion() {
        }

        public final ShipPhysicsData createEmpty() {
            return new ShipPhysicsData(new Vector3d(), new Vector3d());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

