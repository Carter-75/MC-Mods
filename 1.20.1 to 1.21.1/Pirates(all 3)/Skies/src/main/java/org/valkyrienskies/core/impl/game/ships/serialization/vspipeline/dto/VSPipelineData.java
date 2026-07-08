/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@JsonSubTypes(value={@JsonSubTypes.Type(value=VSPipelineDataV1.class), @JsonSubTypes.Type(value=VSPipelineDataV2.class), @JsonSubTypes.Type(value=VSPipelineDataV3.class), @JsonSubTypes.Type(value=VSPipelineDataV4.class)})
@JsonTypeInfo(use=JsonTypeInfo.Id.MINIMAL_CLASS)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bw\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineData;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;"})
public interface VSPipelineData {
}

