/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.ships;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.internal.ships.VsiShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ships/VsiServerShip;", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lorg/valkyrienskies/core/internal/ships/VsiShip;", "Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "getKinematicTarget", "()Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "setKinematicTarget", "(Lorg/valkyrienskies/core/api/ships/properties/PhysPose;)V", "kinematicTarget", "internal"})
public interface VsiServerShip
extends ServerShip,
VsiShip {
    @Nullable
    public PhysPose getKinematicTarget();

    public void setKinematicTarget(@Nullable PhysPose var1);
}

