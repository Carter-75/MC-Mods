/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/mod/common/util/ShipSettings;", "", "", "component1", "()Z", "component2", "shouldGenerateChunks", "changeDimensionOnTouchPortals", "copy", "(ZZ)Lorg/valkyrienskies/mod/common/util/ShipSettings;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getShouldGenerateChunks", "setShouldGenerateChunks", "(Z)V", "getChangeDimensionOnTouchPortals", "setChangeDimensionOnTouchPortals", "<init>", "(ZZ)V", "valkyrienskies-120"})
public final class ShipSettings {
    private boolean shouldGenerateChunks;
    private boolean changeDimensionOnTouchPortals;

    public ShipSettings(boolean shouldGenerateChunks, boolean changeDimensionOnTouchPortals) {
        this.shouldGenerateChunks = shouldGenerateChunks;
        this.changeDimensionOnTouchPortals = changeDimensionOnTouchPortals;
    }

    public /* synthetic */ ShipSettings(boolean bl, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        if ((n2 & 2) != 0) {
            bl2 = true;
        }
        this(bl, bl2);
    }

    public final boolean getShouldGenerateChunks() {
        return this.shouldGenerateChunks;
    }

    public final void setShouldGenerateChunks(boolean bl) {
        this.shouldGenerateChunks = bl;
    }

    public final boolean getChangeDimensionOnTouchPortals() {
        return this.changeDimensionOnTouchPortals;
    }

    public final void setChangeDimensionOnTouchPortals(boolean bl) {
        this.changeDimensionOnTouchPortals = bl;
    }

    public final boolean component1() {
        return this.shouldGenerateChunks;
    }

    public final boolean component2() {
        return this.changeDimensionOnTouchPortals;
    }

    @NotNull
    public final ShipSettings copy(boolean shouldGenerateChunks, boolean changeDimensionOnTouchPortals) {
        return new ShipSettings(shouldGenerateChunks, changeDimensionOnTouchPortals);
    }

    public static /* synthetic */ ShipSettings copy$default(ShipSettings shipSettings, boolean bl, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = shipSettings.shouldGenerateChunks;
        }
        if ((n2 & 2) != 0) {
            bl2 = shipSettings.changeDimensionOnTouchPortals;
        }
        return shipSettings.copy(bl, bl2);
    }

    @NotNull
    public String toString() {
        return "ShipSettings(shouldGenerateChunks=" + this.shouldGenerateChunks + ", changeDimensionOnTouchPortals=" + this.changeDimensionOnTouchPortals + ")";
    }

    public int hashCode() {
        int result2 = Boolean.hashCode(this.shouldGenerateChunks);
        result2 = result2 * 31 + Boolean.hashCode(this.changeDimensionOnTouchPortals);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipSettings)) {
            return false;
        }
        ShipSettings shipSettings = (ShipSettings)other;
        if (this.shouldGenerateChunks != shipSettings.shouldGenerateChunks) {
            return false;
        }
        return this.changeDimensionOnTouchPortals == shipSettings.changeDimensionOnTouchPortals;
    }

    public ShipSettings() {
        this(false, false, 3, null);
    }
}

