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
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.world.PhysLevel;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0007\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\f\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/ShipPhysicsListener;", "", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "physShip", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "physTick", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;)V", "", "delta", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;D)V", "api"})
public interface ShipPhysicsListener {
    public void physTick(@NotNull PhysShip var1, @NotNull PhysLevel var2);

    default public void physTick(@NotNull PhysShip physShip, @NotNull PhysLevel physLevel, double delta) {
        Intrinsics.checkNotNullParameter((Object)physShip, (String)"physShip");
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"physLevel");
        this.physTick(physShip, physLevel);
    }
}

