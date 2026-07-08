/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3;
import org.valkyrienskies.core.impl.shadow.dy_1;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2;", "data", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3;", "update", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2;)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2Updater;", "updater", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2Updater;", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2Updater;)V"})
public final class VSPipelineDataV2UpdaterImpl
implements VSPipelineDataV2Updater {
    private final ServerShipDataV2Updater updater;

    /*
     * WARNING - void declaration
     */
    @Inject
    public VSPipelineDataV2UpdaterImpl(ServerShipDataV2Updater updater) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)updater, (String)"");
        this.updater = var1_1;
    }

    @Override
    public final VSPipelineDataV3 update(VSPipelineDataV2 data) {
        Iterable iterable;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        iterable = ((VSPipelineDataV2)((Object)iterable)).getShips();
        ChunkAllocator chunkAllocator = data.getChunkAllocator();
        Object object = iterable;
        iterable = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (ServerShipDataV2)object2;
            Iterable iterable2 = iterable;
            iterable2.add((ServerShipDataV3)this.updater.update(object2));
        }
        iterable = (List)iterable;
        object = chunkAllocator;
        return new VSPipelineDataV3((ChunkAllocator)object, (List<ServerShipDataV3>)iterable);
    }
}

