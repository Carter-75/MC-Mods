/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.impl.api_impl.config.ConfigPhysicsBackendType;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&\u00a2\u0006\u0004\b\u000e\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\u000f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u00198&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001d\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "", "", "computePhysTps", "()D", "", "getLoadedVoxelChunks", "()I", "Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "getPhysicsBackendType", "()Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "", "postTickGame", "()V", "preTickGame", "", "getArePhysicsRunning", "()Z", "setArePhysicsRunning", "(Z)V", "arePhysicsRunning", "getDeleteResources", "setDeleteResources", "deleteResources", "isUsingDummyPhysics", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "getShipWorld", "()Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "shipWorld", "internal"})
public interface VsiPipeline {
    public boolean getArePhysicsRunning();

    public void setArePhysicsRunning(boolean var1);

    public boolean getDeleteResources();

    public void setDeleteResources(boolean var1);

    public boolean isUsingDummyPhysics();

    @NotNull
    public VsiServerShipWorld getShipWorld();

    public void preTickGame();

    public void postTickGame();

    public double computePhysTps();

    public int getLoadedVoxelChunks();

    @NotNull
    public ConfigPhysicsBackendType getPhysicsBackendType();
}

