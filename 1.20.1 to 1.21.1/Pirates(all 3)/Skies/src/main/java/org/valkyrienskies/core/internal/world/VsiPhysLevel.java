/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.internal.joints.VSJoint;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00020\bH&\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u001c\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u000b0\bH&\u00a2\u0006\u0004\b\u0014\u0010\nJ%\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u000b2\n\u0010\u0015\u001a\u00060\u0012j\u0002`\u0013H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00182\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\u00182\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u001b\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/VsiPhysLevel;", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "newJoint", "", "Lorg/valkyrienskies/core/internal/joints/VSJointId;", "addJoint", "(Lorg/valkyrienskies/core/internal/joints/VSJoint;)I", "", "getAllJoints", "()Ljava/util/Map;", "", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "getAllPhysShips", "()Ljava/util/Set;", "jointId", "getJointById", "(I)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getJointsByShipIds", "shipId", "getJointsFromShip", "(J)Ljava/util/Set;", "", "removeJoint", "(I)Z", "updatedJoint", "updateJoint", "(ILorg/valkyrienskies/core/internal/joints/VSJoint;)Z", "internal"})
@PhysTickOnly
public interface VsiPhysLevel
extends PhysLevel {
    @NotNull
    public Set<PhysShip> getAllPhysShips();

    @Nullable
    public VSJoint getJointById(int var1);

    @NotNull
    public Set<Integer> getJointsFromShip(long var1);

    @NotNull
    public Map<Integer, VSJoint> getAllJoints();

    @NotNull
    public Map<Long, Set<Integer>> getJointsByShipIds();

    public int addJoint(@NotNull VSJoint var1);

    public boolean updateJoint(int var1, @NotNull VSJoint var2);

    public boolean removeJoint(int var1);
}

