/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/entity/ShipyardPosSavable;", "", "Lorg/joml/Vector3d;", "valkyrienskies$getUnloadedShipyardPos", "()Lorg/joml/Vector3d;", "vector3d", "", "valkyrienskies$setUnloadedShipyardPos", "(Lorg/joml/Vector3d;)V", "valkyrienskies-120"})
public interface ShipyardPosSavable {
    @Nullable
    public Vector3d valkyrienskies$getUnloadedShipyardPos();

    public void valkyrienskies$setUnloadedShipyardPos(@Nullable Vector3d var1);
}

