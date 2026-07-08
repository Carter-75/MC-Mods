/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007\u0012\u000e\u0010\u0012\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u0004JP\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\f\b\u0002\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001\u00a2\u0006\u0004\b\u001d\u0010\tR\u001b\u0010\u0011\u001a\u00060\u0006j\u0002`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\tR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u0004R\u001f\u0010\u0012\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b$\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b%\u0010\u0004\u00a8\u0006("}, d2={"Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "component2", "", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "component3", "()Ljava/lang/String;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component4", "()Ljava/lang/Long;", "component5", "pos", "vel", "dimensionId", "mountedShip", "mountedPos", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Long;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDimensionId", "Lorg/joml/Vector3dc;", "getMountedPos", "Ljava/lang/Long;", "getMountedShip", "getPos", "getVel", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Long;Lorg/joml/Vector3dc;)V", "internal"})
public final class VsiPlayerState {
    @NotNull
    private final Vector3dc pos;
    @NotNull
    private final Vector3dc vel;
    @NotNull
    private final String dimensionId;
    @Nullable
    private final Long mountedShip;
    @Nullable
    private final Vector3dc mountedPos;

    public VsiPlayerState(@NotNull Vector3dc pos, @NotNull Vector3dc vel, @NotNull String dimensionId, @Nullable Long mountedShip, @Nullable Vector3dc mountedPos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)vel, (String)"vel");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        this.pos = pos;
        this.vel = vel;
        this.dimensionId = dimensionId;
        this.mountedShip = mountedShip;
        this.mountedPos = mountedPos;
    }

    @NotNull
    public final Vector3dc getPos() {
        return this.pos;
    }

    @NotNull
    public final Vector3dc getVel() {
        return this.vel;
    }

    @NotNull
    public final String getDimensionId() {
        return this.dimensionId;
    }

    @Nullable
    public final Long getMountedShip() {
        return this.mountedShip;
    }

    @Nullable
    public final Vector3dc getMountedPos() {
        return this.mountedPos;
    }

    @NotNull
    public final Vector3dc component1() {
        return this.pos;
    }

    @NotNull
    public final Vector3dc component2() {
        return this.vel;
    }

    @NotNull
    public final String component3() {
        return this.dimensionId;
    }

    @Nullable
    public final Long component4() {
        return this.mountedShip;
    }

    @Nullable
    public final Vector3dc component5() {
        return this.mountedPos;
    }

    @NotNull
    public final VsiPlayerState copy(@NotNull Vector3dc pos, @NotNull Vector3dc vel, @NotNull String dimensionId, @Nullable Long mountedShip, @Nullable Vector3dc mountedPos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)vel, (String)"vel");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        return new VsiPlayerState(pos, vel, dimensionId, mountedShip, mountedPos);
    }

    public static /* synthetic */ VsiPlayerState copy$default(VsiPlayerState vsiPlayerState, Vector3dc vector3dc, Vector3dc vector3dc2, String string, Long l2, Vector3dc vector3dc3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = vsiPlayerState.pos;
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = vsiPlayerState.vel;
        }
        if ((n2 & 4) != 0) {
            string = vsiPlayerState.dimensionId;
        }
        if ((n2 & 8) != 0) {
            l2 = vsiPlayerState.mountedShip;
        }
        if ((n2 & 0x10) != 0) {
            vector3dc3 = vsiPlayerState.mountedPos;
        }
        return vsiPlayerState.copy(vector3dc, vector3dc2, string, l2, vector3dc3);
    }

    @NotNull
    public String toString() {
        return "VsiPlayerState(pos=" + this.pos + ", vel=" + this.vel + ", dimensionId=" + this.dimensionId + ", mountedShip=" + this.mountedShip + ", mountedPos=" + this.mountedPos + ")";
    }

    public int hashCode() {
        int result2 = this.pos.hashCode();
        result2 = result2 * 31 + this.vel.hashCode();
        result2 = result2 * 31 + this.dimensionId.hashCode();
        result2 = result2 * 31 + (this.mountedShip == null ? 0 : ((Object)this.mountedShip).hashCode());
        result2 = result2 * 31 + (this.mountedPos == null ? 0 : this.mountedPos.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VsiPlayerState)) {
            return false;
        }
        VsiPlayerState vsiPlayerState = (VsiPlayerState)other;
        if (!Intrinsics.areEqual((Object)this.pos, (Object)vsiPlayerState.pos)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.vel, (Object)vsiPlayerState.vel)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dimensionId, (Object)vsiPlayerState.dimensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.mountedShip, (Object)vsiPlayerState.mountedShip)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.mountedPos, (Object)vsiPlayerState.mountedPos);
    }
}

