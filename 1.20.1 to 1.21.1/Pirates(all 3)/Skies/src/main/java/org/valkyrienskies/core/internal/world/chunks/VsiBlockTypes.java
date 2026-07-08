/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world.chunks;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u000e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006 \u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "type", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "getState", "(Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;)Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "state", "getType", "(Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;)Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "getAir", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "air", "getAirState", "()Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "airState", "getEmpty", "empty", "getEmptyState", "emptyState", "getLava", "lava", "getLavaState", "lavaState", "getSolid", "solid", "getSolidState", "solidState", "getWater", "water", "getWaterState", "waterState", "internal"})
public interface VsiBlockTypes {
    @NotNull
    public VsiBlockType getAir();

    @NotNull
    public VsiBlockType getSolid();

    @NotNull
    public VsiBlockType getLava();

    @NotNull
    public VsiBlockType getWater();

    @NotNull
    public VsiBlockType getEmpty();

    @NotNull
    public VsiBlockState getAirState();

    @NotNull
    public VsiBlockState getSolidState();

    @NotNull
    public VsiBlockState getLavaState();

    @NotNull
    public VsiBlockState getWaterState();

    @NotNull
    public VsiBlockState getEmptyState();

    @Nullable
    public VsiBlockType getType(@NotNull VsiBlockState var1);

    @Nullable
    public VsiBlockState getState(@NotNull VsiBlockType var1);
}

