/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.events;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.util.GameTickOnly;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R$\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0019\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/events/SplitEvent;", "", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimensionId", "()Ljava/lang/String;", "setDimensionId", "(Ljava/lang/String;)V", "dimensionId", "Lorg/joml/Vector3ic;", "getNewRootA", "()Lorg/joml/Vector3ic;", "newRootA", "getNewRootB", "newRootB", "getOldRoot", "oldRoot", "", "getVoxelType", "()I", "voxelType", "", "getWasPocket", "()Z", "wasPocket", "api"})
@GameTickOnly
public interface SplitEvent {
    public boolean getWasPocket();

    @NotNull
    public Vector3ic getOldRoot();

    @NotNull
    public Vector3ic getNewRootA();

    @NotNull
    public Vector3ic getNewRootB();

    public int getVoxelType();

    @Nullable
    public String getDimensionId();

    public void setDimensionId(@Nullable String var1);
}

