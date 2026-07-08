/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.dp_1;
import org.valkyrienskies.core.impl.shadow.dw_1;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H'\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u000bH'\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u000fH'\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataModule;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverterImpl;", "converter", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1UpdaterImpl;", "impl", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1Updater;", "v1", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2Updater;", "v2", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3Updater;", "v3", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3Updater;"})
public interface VSPipelineDataModule {
    @dp_1
    public VSPipelineDataConverter converter(VSPipelineDataConverterImpl var1);

    @dp_1
    public VSPipelineDataV1Updater v1(VSPipelineDataV1UpdaterImpl var1);

    @dp_1
    public VSPipelineDataV2Updater v2(VSPipelineDataV2UpdaterImpl var1);

    @dp_1
    public VSPipelineDataV3Updater v3(VSPipelineDataV3UpdaterImpl var1);
}

