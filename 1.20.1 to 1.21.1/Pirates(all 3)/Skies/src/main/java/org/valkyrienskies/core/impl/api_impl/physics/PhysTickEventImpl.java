/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.events.PhysTickEvent;
import org.valkyrienskies.core.api.world.PhysLevel;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/PhysTickEventImpl;", "Lorg/valkyrienskies/core/api/events/PhysTickEvent;", "", "toString", "()Ljava/lang/String;", "", "delta", "D", "getDelta", "()D", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "world", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "getWorld", "()Lorg/valkyrienskies/core/api/world/PhysLevel;", "<init>", "(Lorg/valkyrienskies/core/api/world/PhysLevel;D)V"})
public final class PhysTickEventImpl
implements PhysTickEvent {
    private final PhysLevel world;
    private final double delta;

    /*
     * WARNING - void declaration
     */
    public PhysTickEventImpl(PhysLevel world, double delta) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        this.world = var1_1;
        this.delta = var2_2;
    }

    @Override
    @JvmName(name="getWorld")
    public final PhysLevel getWorld() {
        return this.world;
    }

    @Override
    @JvmName(name="getDelta")
    public final double getDelta() {
        return this.delta;
    }

    public final String toString() {
        return "PhysTick(world=" + this.getWorld() + ", delta=" + this.getDelta() + ")";
    }
}

