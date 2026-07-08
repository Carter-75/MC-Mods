/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.physics.RayCastResult;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.util.AerodynamicUtils;
import org.valkyrienskies.core.api.world.PhysLevel;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J'\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\n\u0010\u0014\u001a\u00020\u0013\"\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010 \u001a\u00060\u001cj\u0002`\u001d8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FO;", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "p0", "p1", "", "disableCollisionBetween", "(JJ)Z", "enableCollisionBetween", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "getShipById", "(J)Lorg/valkyrienskies/core/api/ships/PhysShip;", "", "", "physTick", "(D)V", "Lorg/joml/Vector3dc;", "p2", "", "p3", "Lorg/valkyrienskies/core/api/physics/RayCastResult;", "rayCast", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[J)Lorg/valkyrienskies/core/api/physics/RayCastResult;", "Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "getAerodynamicUtils", "()Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "a", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimension", "()Ljava/lang/String;", "b", "<init>", "()V"})
public final class FO
implements PhysLevel {
    public static final FO INSTANCE = new FO();

    private FO() {
    }

    @Override
    @JvmName(name="getDimension")
    public final String getDimension() {
        return "minecraft:dimension:minecraft:overworld";
    }

    @Override
    @JvmName(name="getAerodynamicUtils")
    public final AerodynamicUtils getAerodynamicUtils() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final PhysShip getShipById(long shipId) {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void physTick(double delta) {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final RayCastResult rayCast(Vector3dc start, Vector3dc direction, double length, long ... ignoredShips) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)start, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        Intrinsics.checkNotNullParameter((Object)ignoredShips, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final boolean enableCollisionBetween(long shipId0, long shipId1) {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final boolean disableCollisionBetween(long shipId0, long shipId1) {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }
}

