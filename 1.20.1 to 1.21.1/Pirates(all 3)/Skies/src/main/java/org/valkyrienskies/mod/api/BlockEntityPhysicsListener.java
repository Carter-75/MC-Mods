/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.api.world.PhysLevel;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bR \u0010\u000f\u001a\u00060\tj\u0002`\n8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0010\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;", "", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "physShip", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "physTick", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;)V", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimension", "()Ljava/lang/String;", "setDimension", "(Ljava/lang/String;)V", "dimension", "valkyrienskies-120"})
@PhysTickOnly
public interface BlockEntityPhysicsListener {
    public void physTick(@Nullable PhysShip var1, @NotNull PhysLevel var2);

    @NotNull
    public String getDimension();

    public void setDimension(@NotNull String var1);
}

