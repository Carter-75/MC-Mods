/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 */
package org.valkyrienskies.mod.common.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "", "<init>", "(Ljava/lang/String;I)V", "VANILLA", "FLYWHEEL", "valkyrienskies-120"})
public final class ShipRenderer
extends Enum<ShipRenderer> {
    public static final /* enum */ ShipRenderer VANILLA = new ShipRenderer();
    public static final /* enum */ ShipRenderer FLYWHEEL = new ShipRenderer();
    private static final /* synthetic */ ShipRenderer[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ShipRenderer[] values() {
        return (ShipRenderer[])$VALUES.clone();
    }

    public static ShipRenderer valueOf(String value) {
        return Enum.valueOf(ShipRenderer.class, value);
    }

    @NotNull
    public static EnumEntries<ShipRenderer> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = shipRendererArray = new ShipRenderer[]{ShipRenderer.VANILLA, ShipRenderer.FLYWHEEL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

