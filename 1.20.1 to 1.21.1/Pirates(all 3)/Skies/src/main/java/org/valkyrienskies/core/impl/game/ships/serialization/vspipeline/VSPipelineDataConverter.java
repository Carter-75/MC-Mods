/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import java.util.List;
import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV4;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.shadow.EG;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH&\u00a2\u0006\u0004\b\n\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;", "", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "data", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "convertShipData", "(Ljava/util/List;)Ljava/util/List;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;", "Lorg/valkyrienskies/core/impl/shadow/EG;", "convertToModel", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;)Lorg/valkyrienskies/core/impl/shadow/EG;"})
public interface VSPipelineDataConverter {
    public EG convertToModel(VSPipelineDataV4 var1);

    public List<ShipData> convertShipData(List<ServerShipDataV4> var1);
}

