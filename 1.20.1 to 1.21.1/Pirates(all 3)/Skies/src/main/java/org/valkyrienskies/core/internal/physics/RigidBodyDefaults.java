/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.physics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2={"Lorg/valkyrienskies/core/internal/physics/RigidBodyDefaults;", "", "", "DEFAULT_COLLISION_MASK", "I", "", "DEFAULT_DYNAMIC_FRICTION_COEFFICIENT", "D", "DEFAULT_RESTITUTION_COEFFICIENT", "DEFAULT_STATIC_FRICTION_COEFFICIENT", "<init>", "()V", "internal"})
public final class RigidBodyDefaults {
    @NotNull
    public static final RigidBodyDefaults INSTANCE = new RigidBodyDefaults();
    public static final int DEFAULT_COLLISION_MASK = -1;
    public static final double DEFAULT_STATIC_FRICTION_COEFFICIENT = 0.3;
    public static final double DEFAULT_DYNAMIC_FRICTION_COEFFICIENT = 0.3;
    public static final double DEFAULT_RESTITUTION_COEFFICIENT = 0.6;

    private RigidBodyDefaults() {
    }
}

