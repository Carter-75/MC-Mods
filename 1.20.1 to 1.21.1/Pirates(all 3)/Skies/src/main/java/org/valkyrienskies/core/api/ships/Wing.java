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
import org.joml.Vector3dc;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\u0007JD\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b!\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0004\u00a8\u0006'"}, d2={"Lorg/valkyrienskies/core/api/ships/Wing;", "", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "", "component2", "()D", "component3", "component4", "()Ljava/lang/Double;", "component5", "wingNormal", "wingLiftPower", "wingDragPower", "wingBreakingForce", "wingCamberAttackAngleBias", "copy", "(Lorg/joml/Vector3dc;DDLjava/lang/Double;D)Lorg/valkyrienskies/core/api/ships/Wing;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Double;", "getWingBreakingForce", "D", "getWingCamberAttackAngleBias", "getWingDragPower", "getWingLiftPower", "Lorg/joml/Vector3dc;", "getWingNormal", "<init>", "(Lorg/joml/Vector3dc;DDLjava/lang/Double;D)V", "api"})
public final class Wing {
    @NotNull
    private final Vector3dc wingNormal;
    private final double wingLiftPower;
    private final double wingDragPower;
    @Nullable
    private final Double wingBreakingForce;
    private final double wingCamberAttackAngleBias;

    public Wing(@NotNull Vector3dc wingNormal, double wingLiftPower, double wingDragPower, @Nullable Double wingBreakingForce, double wingCamberAttackAngleBias) {
        Intrinsics.checkNotNullParameter((Object)wingNormal, (String)"wingNormal");
        this.wingNormal = wingNormal;
        this.wingLiftPower = wingLiftPower;
        this.wingDragPower = wingDragPower;
        this.wingBreakingForce = wingBreakingForce;
        this.wingCamberAttackAngleBias = wingCamberAttackAngleBias;
    }

    @NotNull
    public final Vector3dc getWingNormal() {
        return this.wingNormal;
    }

    public final double getWingLiftPower() {
        return this.wingLiftPower;
    }

    public final double getWingDragPower() {
        return this.wingDragPower;
    }

    @Nullable
    public final Double getWingBreakingForce() {
        return this.wingBreakingForce;
    }

    public final double getWingCamberAttackAngleBias() {
        return this.wingCamberAttackAngleBias;
    }

    @NotNull
    public final Vector3dc component1() {
        return this.wingNormal;
    }

    public final double component2() {
        return this.wingLiftPower;
    }

    public final double component3() {
        return this.wingDragPower;
    }

    @Nullable
    public final Double component4() {
        return this.wingBreakingForce;
    }

    public final double component5() {
        return this.wingCamberAttackAngleBias;
    }

    @NotNull
    public final Wing copy(@NotNull Vector3dc wingNormal, double wingLiftPower, double wingDragPower, @Nullable Double wingBreakingForce, double wingCamberAttackAngleBias) {
        Intrinsics.checkNotNullParameter((Object)wingNormal, (String)"wingNormal");
        return new Wing(wingNormal, wingLiftPower, wingDragPower, wingBreakingForce, wingCamberAttackAngleBias);
    }

    public static /* synthetic */ Wing copy$default(Wing wing, Vector3dc vector3dc, double d2, double d3, Double d4, double d5, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = wing.wingNormal;
        }
        if ((n2 & 2) != 0) {
            d2 = wing.wingLiftPower;
        }
        if ((n2 & 4) != 0) {
            d3 = wing.wingDragPower;
        }
        if ((n2 & 8) != 0) {
            d4 = wing.wingBreakingForce;
        }
        if ((n2 & 0x10) != 0) {
            d5 = wing.wingCamberAttackAngleBias;
        }
        return wing.copy(vector3dc, d2, d3, d4, d5);
    }

    @NotNull
    public String toString() {
        return "Wing(wingNormal=" + this.wingNormal + ", wingLiftPower=" + this.wingLiftPower + ", wingDragPower=" + this.wingDragPower + ", wingBreakingForce=" + this.wingBreakingForce + ", wingCamberAttackAngleBias=" + this.wingCamberAttackAngleBias + ")";
    }

    public int hashCode() {
        int result2 = this.wingNormal.hashCode();
        result2 = result2 * 31 + Double.hashCode(this.wingLiftPower);
        result2 = result2 * 31 + Double.hashCode(this.wingDragPower);
        result2 = result2 * 31 + (this.wingBreakingForce == null ? 0 : ((Object)this.wingBreakingForce).hashCode());
        result2 = result2 * 31 + Double.hashCode(this.wingCamberAttackAngleBias);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Wing)) {
            return false;
        }
        Wing wing = (Wing)other;
        if (!Intrinsics.areEqual((Object)this.wingNormal, (Object)wing.wingNormal)) {
            return false;
        }
        if (Double.compare(this.wingLiftPower, wing.wingLiftPower) != 0) {
            return false;
        }
        if (Double.compare(this.wingDragPower, wing.wingDragPower) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.wingBreakingForce, (Object)wing.wingBreakingForce)) {
            return false;
        }
        return Double.compare(this.wingCamberAttackAngleBias, wing.wingCamberAttackAngleBias) == 0;
    }
}

