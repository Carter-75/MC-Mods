/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_243
 *  net.minecraft.class_4184
 */
package org.valkyrienskies.mod.compat.flywheel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_243;
import net.minecraft.class_4184;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/ShipEffectCamera;", "Lnet/minecraft/class_4184;", "camera", "", "update", "(Lnet/minecraft/class_4184;)V", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "<init>", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)V", "valkyrienskies-120"})
public final class ShipEffectCamera
extends class_4184 {
    @NotNull
    private final ClientShip ship;

    public ShipEffectCamera(@NotNull ClientShip ship) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        this.ship = ship;
    }

    @NotNull
    public final ClientShip getShip() {
        return this.ship;
    }

    public final void update(@NotNull class_4184 camera) {
        Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
        Matrix4dc matrix4dc = this.ship.getRenderTransform().getWorldToShip();
        class_243 class_2432 = camera.method_19326();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getPosition(...)");
        Vector3d newPos = matrix4dc.transformPosition(VectorConversionsMCKt.toJOML(class_2432));
        this.method_19327(newPos.x(), newPos.y(), newPos.z());
        Vector3f direction = this.ship.getRenderTransform().getWorldToShip().transformDirection(camera.method_19335());
        float yaw = -((float)Math.atan2(direction.x, direction.z));
        float pitch = -((float)Math.atan2(direction.y, (float)Math.sqrt(direction.x * direction.x + direction.z * direction.z)));
        this.method_19325((float)((double)yaw * 57.29577951308232), (float)((double)pitch * 57.29577951308232));
    }
}

