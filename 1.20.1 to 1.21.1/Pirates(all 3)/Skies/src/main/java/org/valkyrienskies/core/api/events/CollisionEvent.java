/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.events;

import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.physics.ContactPoint;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.api.world.PhysLevel;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u000b\u001a\u00060\u0007j\u0002`\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0014\u001a\u00060\u0010j\u0002`\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u00060\u0010j\u0002`\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0017\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/events/CollisionEvent;", "", "", "Lorg/valkyrienskies/core/api/physics/ContactPoint;", "getContactPoints", "()Ljava/util/Collection;", "contactPoints", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimensionId", "()Ljava/lang/String;", "dimensionId", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "getPhysLevel", "()Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getShipIdA", "()J", "shipIdA", "getShipIdB", "shipIdB", "api"})
@PhysTickOnly
public interface CollisionEvent {
    @NotNull
    public String getDimensionId();

    @NotNull
    public PhysLevel getPhysLevel();

    public long getShipIdA();

    public long getShipIdB();

    @NotNull
    public Collection<ContactPoint> getContactPoints();
}

