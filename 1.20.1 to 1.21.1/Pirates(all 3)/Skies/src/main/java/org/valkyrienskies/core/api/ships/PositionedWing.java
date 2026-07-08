/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.Wing;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\t\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/core/api/ships/PositionedWing;", "", "", "component1", "()I", "component2", "component3", "Lorg/valkyrienskies/core/api/ships/Wing;", "component4", "()Lorg/valkyrienskies/core/api/ships/Wing;", "posX", "posY", "posZ", "wing", "copy", "(IIILorg/valkyrienskies/core/api/ships/Wing;)Lorg/valkyrienskies/core/api/ships/PositionedWing;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPosX", "getPosY", "getPosZ", "Lorg/valkyrienskies/core/api/ships/Wing;", "getWing", "<init>", "(IIILorg/valkyrienskies/core/api/ships/Wing;)V", "api"})
public final class PositionedWing {
    private final int posX;
    private final int posY;
    private final int posZ;
    @Nullable
    private final Wing wing;

    public PositionedWing(int posX, int posY, int posZ, @Nullable Wing wing) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.wing = wing;
    }

    public final int getPosX() {
        return this.posX;
    }

    public final int getPosY() {
        return this.posY;
    }

    public final int getPosZ() {
        return this.posZ;
    }

    @Nullable
    public final Wing getWing() {
        return this.wing;
    }

    public final int component1() {
        return this.posX;
    }

    public final int component2() {
        return this.posY;
    }

    public final int component3() {
        return this.posZ;
    }

    @Nullable
    public final Wing component4() {
        return this.wing;
    }

    @NotNull
    public final PositionedWing copy(int posX, int posY, int posZ, @Nullable Wing wing) {
        return new PositionedWing(posX, posY, posZ, wing);
    }

    public static /* synthetic */ PositionedWing copy$default(PositionedWing positionedWing, int n2, int n3, int n4, Wing wing, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n2 = positionedWing.posX;
        }
        if ((n5 & 2) != 0) {
            n3 = positionedWing.posY;
        }
        if ((n5 & 4) != 0) {
            n4 = positionedWing.posZ;
        }
        if ((n5 & 8) != 0) {
            wing = positionedWing.wing;
        }
        return positionedWing.copy(n2, n3, n4, wing);
    }

    @NotNull
    public String toString() {
        return "PositionedWing(posX=" + this.posX + ", posY=" + this.posY + ", posZ=" + this.posZ + ", wing=" + this.wing + ")";
    }

    public int hashCode() {
        int result2 = Integer.hashCode(this.posX);
        result2 = result2 * 31 + Integer.hashCode(this.posY);
        result2 = result2 * 31 + Integer.hashCode(this.posZ);
        result2 = result2 * 31 + (this.wing == null ? 0 : this.wing.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PositionedWing)) {
            return false;
        }
        PositionedWing positionedWing = (PositionedWing)other;
        if (this.posX != positionedWing.posX) {
            return false;
        }
        if (this.posY != positionedWing.posY) {
            return false;
        }
        if (this.posZ != positionedWing.posZ) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.wing, (Object)positionedWing.wing);
    }
}

