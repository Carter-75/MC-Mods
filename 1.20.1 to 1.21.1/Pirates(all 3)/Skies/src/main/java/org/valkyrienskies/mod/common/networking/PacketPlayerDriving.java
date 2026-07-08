/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.networking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007\u00a8\u0006\u001f"}, d2={"Lorg/valkyrienskies/mod/common/networking/PacketPlayerDriving;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "Lorg/joml/Vector3f;", "component1", "()Lorg/joml/Vector3f;", "", "component2", "()Z", "component3", "impulse", "sprint", "cruise", "copy", "(Lorg/joml/Vector3f;ZZ)Lorg/valkyrienskies/mod/common/networking/PacketPlayerDriving;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3f;", "getImpulse", "Z", "getSprint", "getCruise", "<init>", "(Lorg/joml/Vector3f;ZZ)V", "valkyrienskies-120"})
public final class PacketPlayerDriving
implements SimplePacket {
    @NotNull
    private final Vector3f impulse;
    private final boolean sprint;
    private final boolean cruise;

    public PacketPlayerDriving(@NotNull Vector3f impulse, boolean sprint, boolean cruise) {
        Intrinsics.checkNotNullParameter((Object)impulse, (String)"impulse");
        this.impulse = impulse;
        this.sprint = sprint;
        this.cruise = cruise;
    }

    @NotNull
    public final Vector3f getImpulse() {
        return this.impulse;
    }

    public final boolean getSprint() {
        return this.sprint;
    }

    public final boolean getCruise() {
        return this.cruise;
    }

    @NotNull
    public final Vector3f component1() {
        return this.impulse;
    }

    public final boolean component2() {
        return this.sprint;
    }

    public final boolean component3() {
        return this.cruise;
    }

    @NotNull
    public final PacketPlayerDriving copy(@NotNull Vector3f impulse, boolean sprint, boolean cruise) {
        Intrinsics.checkNotNullParameter((Object)impulse, (String)"impulse");
        return new PacketPlayerDriving(impulse, sprint, cruise);
    }

    public static /* synthetic */ PacketPlayerDriving copy$default(PacketPlayerDriving packetPlayerDriving, Vector3f vector3f, boolean bl, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3f = packetPlayerDriving.impulse;
        }
        if ((n2 & 2) != 0) {
            bl = packetPlayerDriving.sprint;
        }
        if ((n2 & 4) != 0) {
            bl2 = packetPlayerDriving.cruise;
        }
        return packetPlayerDriving.copy(vector3f, bl, bl2);
    }

    @NotNull
    public String toString() {
        return "PacketPlayerDriving(impulse=" + this.impulse + ", sprint=" + this.sprint + ", cruise=" + this.cruise + ")";
    }

    public int hashCode() {
        int result2 = this.impulse.hashCode();
        result2 = result2 * 31 + Boolean.hashCode(this.sprint);
        result2 = result2 * 31 + Boolean.hashCode(this.cruise);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketPlayerDriving)) {
            return false;
        }
        PacketPlayerDriving packetPlayerDriving = (PacketPlayerDriving)other;
        if (!Intrinsics.areEqual((Object)this.impulse, (Object)packetPlayerDriving.impulse)) {
            return false;
        }
        if (this.sprint != packetPlayerDriving.sprint) {
            return false;
        }
        return this.cruise == packetPlayerDriving.cruise;
    }
}

