/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.visualization.VisualizationManager
 *  dev.engine_room.flywheel.impl.visualization.VisualManagerImpl
 *  dev.engine_room.flywheel.lib.visualization.VisualizationHelper
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_4076
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import dev.engine_room.flywheel.impl.visualization.VisualManagerImpl;
import dev.engine_room.flywheel.lib.visualization.VisualizationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_4076;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.compat.LoadedMods;
import org.valkyrienskies.mod.compat.flywheel.ShipEffect;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006$"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/FlywheelCompat;", "", "", "initClient", "()V", "Lnet/minecraft/class_2586;", "blockEntity", "Lnet/minecraft/class_1937;", "level", "", "validate", "(Lnet/minecraft/class_2586;Lnet/minecraft/class_1937;)Z", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "getEffect", "(Lnet/minecraft/class_2586;)Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "", "x", "y", "z", "important", "setShipEffectDirty", "(Lorg/valkyrienskies/core/api/ships/ClientShip;IIIZ)V", "Lnet/minecraft/class_4076;", "pos", "onLightUpdate", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_4076;)V", "Lorg/joml/Matrix4f;", "viewProjection", "Lorg/joml/Matrix4f;", "getViewProjection", "()Lorg/joml/Matrix4f;", "setViewProjection", "(Lorg/joml/Matrix4f;)V", "<init>", "valkyrienskies-120"})
public final class FlywheelCompat {
    @NotNull
    public static final FlywheelCompat INSTANCE = new FlywheelCompat();
    public static Matrix4f viewProjection;

    private FlywheelCompat() {
    }

    public final void initClient() {
    }

    public final boolean validate(@NotNull class_2586 blockEntity, @NotNull class_1937 level) {
        Intrinsics.checkNotNullParameter((Object)blockEntity, (String)"blockEntity");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (!VisualizationHelper.canVisualize((class_2586)blockEntity)) {
            return false;
        }
        return VisualizationManager.get((class_1936)((class_1936)level)) != null;
    }

    private final ShipEffect getEffect(class_2586 blockEntity) {
        if (LoadedMods.getFlywheel() != LoadedMods.FlywheelVersion.V1) {
            return null;
        }
        class_1937 class_19372 = blockEntity.method_10997();
        if (!(class_19372 != null ? class_19372.field_9236 : false)) {
            return null;
        }
        if (!VisualizationManager.supportsVisualization((class_1936)((class_1936)blockEntity.method_10997()))) {
            return null;
        }
        if (!VisualizationHelper.canVisualize((class_2586)blockEntity)) {
            return null;
        }
        class_1937 class_19373 = blockEntity.method_10997();
        Intrinsics.checkNotNull((Object)class_19373);
        class_2338 class_23382 = blockEntity.method_11016();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getBlockPos(...)");
        Ship ship = VSGameUtilsKt.getShipManagingPos(class_19373, class_23382);
        if (ship == null) {
            return null;
        }
        Ship ship2 = ship;
        return ShipEffect.Companion.getShipEffect((ClientShip)ship2);
    }

    public final void setShipEffectDirty(@NotNull ClientShip ship, int x, int y, int z, boolean important) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        ShipEffect.Companion.getShipEffect(ship).setDirty(x, y, z, important);
    }

    public static /* synthetic */ void setShipEffectDirty$default(FlywheelCompat flywheelCompat, ClientShip clientShip, int n2, int n3, int n4, boolean bl, int n5, Object object) {
        if ((n5 & 0x10) != 0) {
            bl = false;
        }
        flywheelCompat.setShipEffectDirty(clientShip, n2, n3, n4, bl);
    }

    public final void onLightUpdate(@NotNull ClientShip ship, @NotNull class_4076 pos) {
        block0: {
            VisualManagerImpl manager;
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            VisualManagerImpl visualManagerImpl = manager = (VisualManagerImpl)ShipEffect.Companion.getShipEffect(ship).getManager$valkyrienskies_120();
            if (visualManagerImpl == null) break block0;
            visualManagerImpl.onLightUpdate(pos.method_18694());
        }
    }

    @NotNull
    public final Matrix4f getViewProjection() {
        Matrix4f matrix4f = viewProjection;
        if (matrix4f != null) {
            return matrix4f;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"viewProjection");
        return null;
    }

    public final void setViewProjection(@NotNull Matrix4f matrix4f) {
        Intrinsics.checkNotNullParameter((Object)matrix4f, (String)"<set-?>");
        viewProjection = matrix4f;
    }
}

