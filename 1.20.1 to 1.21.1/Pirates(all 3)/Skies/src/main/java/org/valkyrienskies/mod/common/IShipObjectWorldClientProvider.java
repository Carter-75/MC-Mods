/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.mod.common.IShipObjectWorldProvider;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/IShipObjectWorldClientProvider;", "Lorg/valkyrienskies/mod/common/IShipObjectWorldProvider;", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "getShipObjectWorld", "()Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "shipObjectWorld", "valkyrienskies-120"})
public interface IShipObjectWorldClientProvider
extends IShipObjectWorldProvider {
    @Override
    @Nullable
    public VsiClientShipWorld getShipObjectWorld();
}

