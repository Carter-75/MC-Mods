/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.dto.ShipInertiaDataV0;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;
import org.valkyrienskies.core.impl.shadow.dy_1;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0;", "data", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1;", "update", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1;", "<init>", "()V"})
public final class ServerShipDataV0UpdaterImpl
implements ServerShipDataV0Updater {
    @Inject
    public ServerShipDataV0UpdaterImpl() {
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ServerShipDataV1 update(ServerShipDataV0 data) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        long l2 = data.getId();
        String string = data.getName();
        ChunkClaim chunkClaim = data.getChunkClaim();
        String string2 = data.getChunkClaimDimension();
        ShipPhysicsData shipPhysicsData = data.getPhysicsData();
        ShipInertiaDataV0 shipInertiaDataV0 = data.getInertiaData();
        ShipTransformDataV0 shipTransformDataV0 = data.getShipTransform();
        ShipTransformDataV0 shipTransformDataV02 = data.getShipTransform();
        AABBdc aABBdc = data.getShipAABB();
        AABBic aABBic = data.getShipVoxelAABB();
        IShipActiveChunksSet iShipActiveChunksSet = data.getShipActiveChunksSet();
        boolean bl = data.isStatic();
        ObjectNode objectNode = var1_1.getPersistentAttachedData();
        Intrinsics.checkNotNullExpressionValue((Object)objectNode, (String)"");
        return new ServerShipDataV1(l2, string, chunkClaim, string2, shipPhysicsData, shipInertiaDataV0, shipTransformDataV0, shipTransformDataV02, aABBdc, aABBic, iShipActiveChunksSet, bl, objectNode);
    }
}

