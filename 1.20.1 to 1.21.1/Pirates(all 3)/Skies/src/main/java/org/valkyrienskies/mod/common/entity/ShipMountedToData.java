/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedShip;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/mod/common/entity/ShipMountedToData;", "", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "component1", "()Lorg/valkyrienskies/core/api/ships/LoadedShip;", "Lorg/joml/Vector3dc;", "component2", "()Lorg/joml/Vector3dc;", "shipMountedTo", "mountPosInShip", "copy", "(Lorg/valkyrienskies/core/api/ships/LoadedShip;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/mod/common/entity/ShipMountedToData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "getShipMountedTo", "Lorg/joml/Vector3dc;", "getMountPosInShip", "<init>", "(Lorg/valkyrienskies/core/api/ships/LoadedShip;Lorg/joml/Vector3dc;)V", "valkyrienskies-120"})
public final class ShipMountedToData {
    @NotNull
    private final LoadedShip shipMountedTo;
    @NotNull
    private final Vector3dc mountPosInShip;

    public ShipMountedToData(@NotNull LoadedShip shipMountedTo, @NotNull Vector3dc mountPosInShip) {
        Intrinsics.checkNotNullParameter((Object)shipMountedTo, (String)"shipMountedTo");
        Intrinsics.checkNotNullParameter((Object)mountPosInShip, (String)"mountPosInShip");
        this.shipMountedTo = shipMountedTo;
        this.mountPosInShip = mountPosInShip;
    }

    @NotNull
    public final LoadedShip getShipMountedTo() {
        return this.shipMountedTo;
    }

    @NotNull
    public final Vector3dc getMountPosInShip() {
        return this.mountPosInShip;
    }

    @NotNull
    public final LoadedShip component1() {
        return this.shipMountedTo;
    }

    @NotNull
    public final Vector3dc component2() {
        return this.mountPosInShip;
    }

    @NotNull
    public final ShipMountedToData copy(@NotNull LoadedShip shipMountedTo, @NotNull Vector3dc mountPosInShip) {
        Intrinsics.checkNotNullParameter((Object)shipMountedTo, (String)"shipMountedTo");
        Intrinsics.checkNotNullParameter((Object)mountPosInShip, (String)"mountPosInShip");
        return new ShipMountedToData(shipMountedTo, mountPosInShip);
    }

    public static /* synthetic */ ShipMountedToData copy$default(ShipMountedToData shipMountedToData, LoadedShip loadedShip, Vector3dc vector3dc, int n2, Object object) {
        if ((n2 & 1) != 0) {
            loadedShip = shipMountedToData.shipMountedTo;
        }
        if ((n2 & 2) != 0) {
            vector3dc = shipMountedToData.mountPosInShip;
        }
        return shipMountedToData.copy(loadedShip, vector3dc);
    }

    @NotNull
    public String toString() {
        return "ShipMountedToData(shipMountedTo=" + this.shipMountedTo + ", mountPosInShip=" + this.mountPosInShip + ")";
    }

    public int hashCode() {
        int result2 = this.shipMountedTo.hashCode();
        result2 = result2 * 31 + this.mountPosInShip.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipMountedToData)) {
            return false;
        }
        ShipMountedToData shipMountedToData = (ShipMountedToData)other;
        if (!Intrinsics.areEqual((Object)this.shipMountedTo, (Object)shipMountedToData.shipMountedTo)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.mountPosInShip, (Object)shipMountedToData.mountPosInShip);
    }
}

