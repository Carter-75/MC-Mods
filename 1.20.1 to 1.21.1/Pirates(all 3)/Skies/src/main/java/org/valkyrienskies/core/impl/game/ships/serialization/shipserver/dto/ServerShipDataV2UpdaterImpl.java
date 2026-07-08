/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3;
import org.valkyrienskies.core.impl.shadow.dy_1;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2;", "data", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV3;", "update", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV3;", "<init>", "()V"})
public final class ServerShipDataV2UpdaterImpl
implements ServerShipDataV2Updater {
    @Inject
    public ServerShipDataV2UpdaterImpl() {
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ServerShipDataV3 update(ServerShipDataV2 data) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        return new ServerShipDataV3(data.getId(), data.getName(), data.getChunkClaim(), data.getChunkClaimDimension(), data.getPhysicsData().getLinearVelocity(), data.getPhysicsData().getAngularVelocity(), data.getInertiaData(), data.getShipTransform(), data.getPrevTickShipTransform(), data.getShipAABB(), data.getShipVoxelAABB(), data.getShipActiveChunksSet(), data.isStatic(), var1_1.getPersistentAttachedData());
    }
}

