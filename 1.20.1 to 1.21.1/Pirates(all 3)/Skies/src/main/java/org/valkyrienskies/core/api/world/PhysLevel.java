/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.world;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.physics.RayCastResult;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.util.AerodynamicUtils;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H&\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H&\u00a2\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H&\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a2\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\u00020\u0017\"\u00060\u0002j\u0002`\u0003H&\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010$\u001a\u00060 j\u0002`!8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006%\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/world/PhysLevel;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId0", "shipId1", "", "disableCollisionBetween", "(JJ)Z", "enableCollisionBetween", "shipId", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "getShipById", "(J)Lorg/valkyrienskies/core/api/ships/PhysShip;", "", "delta", "", "physTick", "(D)V", "Lorg/joml/Vector3dc;", "start", "direction", "length", "", "ignoredShips", "Lorg/valkyrienskies/core/api/physics/RayCastResult;", "rayCast", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[J)Lorg/valkyrienskies/core/api/physics/RayCastResult;", "Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "getAerodynamicUtils", "()Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "aerodynamicUtils", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimension", "()Ljava/lang/String;", "dimension", "api"})
@PhysTickOnly
public interface PhysLevel {
    @NotNull
    public String getDimension();

    @NotNull
    public AerodynamicUtils getAerodynamicUtils();

    @Nullable
    public PhysShip getShipById(long var1);

    public void physTick(double var1);

    @Nullable
    public RayCastResult rayCast(@NotNull Vector3dc var1, @NotNull Vector3dc var2, double var3, long ... var5);

    public boolean enableCollisionBetween(long var1, long var3);

    public boolean disableCollisionBetween(long var1, long var3);
}

