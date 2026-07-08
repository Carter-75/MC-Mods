/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV4;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.dy_1;
import org.valkyrienskies.core.impl.shadow.em_0;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "data", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "convertShipData", "(Ljava/util/List;)Ljava/util/List;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;", "Lorg/valkyrienskies/core/impl/shadow/EG;", "convertToModel", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;)Lorg/valkyrienskies/core/impl/shadow/EG;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "converter", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;)V"})
public final class VSPipelineDataConverterImpl
implements VSPipelineDataConverter {
    private final ServerShipDataConverter converter;

    /*
     * WARNING - void declaration
     */
    @Inject
    public VSPipelineDataConverterImpl(ServerShipDataConverter converter) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)converter, (String)"");
        this.converter = var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final EG convertToModel(VSPipelineDataV4 data) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        return new EG(new em_0((Iterable)this.convertShipData(data.getShips())), var1_1.getChunkAllocator());
    }

    @Override
    public final List<ShipData> convertShipData(List<ServerShipDataV4> data) {
        Iterable iterable;
        Intrinsics.checkNotNullParameter(data, (String)"");
        iterable = iterable;
        Object object = iterable;
        iterable = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (ServerShipDataV4)object2;
            Iterable iterable2 = iterable;
            iterable2.add(this.converter.convertToModel((ServerShipDataV4)object2));
        }
        return (List)iterable;
    }
}

