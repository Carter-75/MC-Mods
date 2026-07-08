/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiCoreCommands;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DS;", "Lorg/valkyrienskies/core/internal/VsiCoreCommands;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "p0", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "p1", "", "deleteShips", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Ljava/util/List;)V", "", "renameShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Ljava/lang/String;)V", "", "p2", "scaleShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;D)V", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "teleportShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "<init>", "()V"})
public final class DS
implements VsiCoreCommands {
    public static final DS INSTANCE = new DS();

    private DS() {
    }

    @Override
    public final void deleteShips(ServerShipWorld world, List<? extends ServerShip> ships) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        Intrinsics.checkNotNullParameter(ships, (String)"");
        VsiServerShipWorld cfr_ignored_0 = (VsiServerShipWorld)world;
        object = (Iterable)object;
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (ServerShip)object2;
            ((VsiServerShipWorld)world).deleteShip((ServerShip)object2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void renameShip(ServerShip ship, String newName) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        Intrinsics.checkNotNullParameter((Object)newName, (String)"");
        var1_1.setSlug((String)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void scaleShip(ServerShipWorld world, ServerShip ship, double newScale) {
        void var2_2;
        void var1_1;
        void var3_3;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        ShipTransform shipTransform = ship.getTransform();
        ShipTeleportDataImpl shipTeleportDataImpl = new ShipTeleportDataImpl(shipTransform.getPositionInWorld(), shipTransform.getShipToWorldRotation(), new Vector3d(), new Vector3d(), null, (double)var3_3, null, 80, null);
        this.teleportShip((ServerShipWorld)var1_1, (ServerShip)var2_2, shipTeleportDataImpl);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportShip(ServerShipWorld world, ServerShip ship, ShipTeleportData teleportData) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        Intrinsics.checkNotNullParameter((Object)teleportData, (String)"");
        VsiServerShipWorld cfr_ignored_0 = (VsiServerShipWorld)world;
        ((VsiServerShipWorld)var1_1).teleportShip((ServerShip)var2_2, (ShipTeleportData)var3_3);
    }
}

