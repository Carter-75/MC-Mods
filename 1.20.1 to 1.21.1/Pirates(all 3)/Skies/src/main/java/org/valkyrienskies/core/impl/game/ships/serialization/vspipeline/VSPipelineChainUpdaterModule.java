/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdater;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.shadow.dw_1;
import org.valkyrienskies.core.impl.shadow.dx_1;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineChainUpdaterModule;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1Updater;", "v1", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2Updater;", "v2", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3Updater;", "v3", "Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;", "updater", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1Updater;Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV2Updater;Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV3Updater;)Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdater;", "<init>", "()V"})
public final class VSPipelineChainUpdaterModule {
    /*
     * WARNING - void declaration
     */
    @dx_1
    public final ChainUpdater<VSPipelineDataV4> updater(VSPipelineDataV1Updater v1, VSPipelineDataV2Updater v2, VSPipelineDataV3Updater v3) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)v1, (String)"");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"");
        Intrinsics.checkNotNullParameter((Object)v3, (String)"");
        Pair[] pairArray = new Pair[3];
        Pair[] pairArray2 = pairArray;
        pairArray[0] = TuplesKt.to(VSPipelineDataV1.class, (Object)var1_1);
        pairArray2[1] = TuplesKt.to(VSPipelineDataV2.class, (Object)var2_2);
        pairArray2[2] = TuplesKt.to(VSPipelineDataV3.class, (Object)var3_3);
        return new ChainUpdaterImpl<VSPipelineDataV4>(VSPipelineDataV4.class, pairArray2);
    }
}

