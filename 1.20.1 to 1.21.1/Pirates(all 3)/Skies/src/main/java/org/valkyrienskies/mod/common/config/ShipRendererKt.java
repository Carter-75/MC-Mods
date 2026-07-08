/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.config.ShipRenderer;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.ShipSettingsKt;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "getShipRenderer", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "shipRenderer", "valkyrienskies-120"})
public final class ShipRendererKt {
    @NotNull
    public static final ShipRenderer getShipRenderer(@NotNull ClientShip $this$shipRenderer) {
        Intrinsics.checkNotNullParameter((Object)$this$shipRenderer, (String)"<this>");
        ShipRenderer shipRenderer = ShipSettingsKt.getSettings($this$shipRenderer).getRenderer();
        if (shipRenderer == null) {
            shipRenderer = VSGameConfig.CLIENT.getDefaultRenderer();
        }
        return shipRenderer;
    }
}

