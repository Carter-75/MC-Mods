/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.util.ClientShipSettings;
import org.valkyrienskies.mod.common.util.ShipSettings;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\b*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "Lorg/valkyrienskies/mod/common/util/ShipSettings;", "getSettings", "(Lorg/valkyrienskies/core/api/ships/LoadedServerShip;)Lorg/valkyrienskies/mod/common/util/ShipSettings;", "getSettings$annotations", "(Lorg/valkyrienskies/core/api/ships/LoadedServerShip;)V", "settings", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lorg/valkyrienskies/mod/common/util/ClientShipSettings;", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)Lorg/valkyrienskies/mod/common/util/ClientShipSettings;", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipSettings.kt\norg/valkyrienskies/mod/common/util/ShipSettingsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
public final class ShipSettingsKt {
    @NotNull
    public static final ShipSettings getSettings(@NotNull LoadedServerShip $this$settings) {
        Intrinsics.checkNotNullParameter((Object)$this$settings, (String)"<this>");
        ShipSettings shipSettings = $this$settings.getAttachment(ShipSettings.class);
        if (shipSettings == null) {
            ShipSettings shipSettings2;
            ShipSettings it = shipSettings2 = new ShipSettings(false, false, 3, null);
            boolean bl = false;
            $this$settings.setAttachment(it);
            shipSettings = shipSettings2;
        }
        return shipSettings;
    }

    public static /* synthetic */ void getSettings$annotations(LoadedServerShip loadedServerShip) {
    }

    @NotNull
    public static final ClientShipSettings getSettings(@NotNull ClientShip $this$settings) {
        Intrinsics.checkNotNullParameter((Object)$this$settings, (String)"<this>");
        return new ClientShipSettings(null, 1, null);
    }
}

