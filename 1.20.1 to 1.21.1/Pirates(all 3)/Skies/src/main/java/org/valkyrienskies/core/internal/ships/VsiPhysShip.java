/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.ships;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.internal.ships.VsiShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ships/VsiPhysShip;", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "Lorg/valkyrienskies/core/internal/ships/VsiShip;", "Lorg/valkyrienskies/core/api/ships/DragController;", "getDragController", "()Lorg/valkyrienskies/core/api/ships/DragController;", "dragController", "Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "getKinematicTarget", "()Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "setKinematicTarget", "(Lorg/valkyrienskies/core/api/ships/properties/PhysPose;)V", "kinematicTarget", "internal"})
@PhysTickOnly
public interface VsiPhysShip
extends PhysShip,
VsiShip {
    @Nullable
    public PhysPose getKinematicTarget();

    public void setKinematicTarget(@Nullable PhysPose var1);

    @Nullable
    public DragController getDragController();
}

