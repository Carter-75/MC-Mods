/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.physics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\nJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u00d6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b$\u0010\nR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010\n\u00a8\u0006("}, d2={"Lorg/valkyrienskies/core/api/physics/RayCastResult;", "", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "component1", "()Lorg/valkyrienskies/core/api/ships/PhysShip;", "", "component2", "()D", "Lorg/joml/Vector3dc;", "component3", "()Lorg/joml/Vector3dc;", "component4", "component5", "hitBody", "distance", "hitNormal", "velocity", "angularVelocity", "copy", "(Lorg/valkyrienskies/core/api/ships/PhysShip;DLorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/physics/RayCastResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getAngularVelocity", "D", "getDistance", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "getHitBody", "getHitNormal", "getVelocity", "<init>", "(Lorg/valkyrienskies/core/api/ships/PhysShip;DLorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "api"})
@PhysTickOnly
public final class RayCastResult {
    @NotNull
    private final PhysShip hitBody;
    private final double distance;
    @NotNull
    private final Vector3dc hitNormal;
    @NotNull
    private final Vector3dc velocity;
    @NotNull
    private final Vector3dc angularVelocity;

    public RayCastResult(@NotNull PhysShip hitBody, double distance, @NotNull Vector3dc hitNormal, @NotNull Vector3dc velocity, @NotNull Vector3dc angularVelocity) {
        Intrinsics.checkNotNullParameter((Object)hitBody, (String)"hitBody");
        Intrinsics.checkNotNullParameter((Object)hitNormal, (String)"hitNormal");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"velocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        this.hitBody = hitBody;
        this.distance = distance;
        this.hitNormal = hitNormal;
        this.velocity = velocity;
        this.angularVelocity = angularVelocity;
    }

    @NotNull
    public final PhysShip getHitBody() {
        return this.hitBody;
    }

    public final double getDistance() {
        return this.distance;
    }

    @NotNull
    public final Vector3dc getHitNormal() {
        return this.hitNormal;
    }

    @NotNull
    public final Vector3dc getVelocity() {
        return this.velocity;
    }

    @NotNull
    public final Vector3dc getAngularVelocity() {
        return this.angularVelocity;
    }

    @NotNull
    public final PhysShip component1() {
        return this.hitBody;
    }

    public final double component2() {
        return this.distance;
    }

    @NotNull
    public final Vector3dc component3() {
        return this.hitNormal;
    }

    @NotNull
    public final Vector3dc component4() {
        return this.velocity;
    }

    @NotNull
    public final Vector3dc component5() {
        return this.angularVelocity;
    }

    @NotNull
    public final RayCastResult copy(@NotNull PhysShip hitBody, double distance, @NotNull Vector3dc hitNormal, @NotNull Vector3dc velocity, @NotNull Vector3dc angularVelocity) {
        Intrinsics.checkNotNullParameter((Object)hitBody, (String)"hitBody");
        Intrinsics.checkNotNullParameter((Object)hitNormal, (String)"hitNormal");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"velocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        return new RayCastResult(hitBody, distance, hitNormal, velocity, angularVelocity);
    }

    public static /* synthetic */ RayCastResult copy$default(RayCastResult rayCastResult, PhysShip physShip, double d2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            physShip = rayCastResult.hitBody;
        }
        if ((n2 & 2) != 0) {
            d2 = rayCastResult.distance;
        }
        if ((n2 & 4) != 0) {
            vector3dc = rayCastResult.hitNormal;
        }
        if ((n2 & 8) != 0) {
            vector3dc2 = rayCastResult.velocity;
        }
        if ((n2 & 0x10) != 0) {
            vector3dc3 = rayCastResult.angularVelocity;
        }
        return rayCastResult.copy(physShip, d2, vector3dc, vector3dc2, vector3dc3);
    }

    @NotNull
    public String toString() {
        return "RayCastResult(hitBody=" + this.hitBody + ", distance=" + this.distance + ", hitNormal=" + this.hitNormal + ", velocity=" + this.velocity + ", angularVelocity=" + this.angularVelocity + ")";
    }

    public int hashCode() {
        int result2 = this.hitBody.hashCode();
        result2 = result2 * 31 + Double.hashCode(this.distance);
        result2 = result2 * 31 + this.hitNormal.hashCode();
        result2 = result2 * 31 + this.velocity.hashCode();
        result2 = result2 * 31 + this.angularVelocity.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RayCastResult)) {
            return false;
        }
        RayCastResult rayCastResult = (RayCastResult)other;
        if (!Intrinsics.areEqual((Object)this.hitBody, (Object)rayCastResult.hitBody)) {
            return false;
        }
        if (Double.compare(this.distance, rayCastResult.distance) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hitNormal, (Object)rayCastResult.hitNormal)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.velocity, (Object)rayCastResult.velocity)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.angularVelocity, (Object)rayCastResult.angularVelocity);
    }
}

