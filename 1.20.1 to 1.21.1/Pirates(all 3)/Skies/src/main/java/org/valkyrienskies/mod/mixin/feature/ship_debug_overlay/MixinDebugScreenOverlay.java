/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_124
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3218
 *  net.minecraft.class_340
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.ship_debug_overlay;

import com.llamalad7.mixinextras.sugar.Local;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_124;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3218;
import net.minecraft.class_340;
import net.minecraft.class_3965;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={class_340.class})
public abstract class MixinDebugScreenOverlay {
    @Shadow
    @Final
    private class_310 field_2079;
    @Shadow
    private class_239 field_2082;

    @Shadow
    protected abstract class_1937 method_1840();

    @Inject(method={"getGameInformation"}, at={@At(value="INVOKE", target="Ljava/util/List;add(Ljava/lang/Object;)Z", ordinal=1)})
    private void addShipCountInformation(CallbackInfoReturnable<List<String>> cir, @Local List<String> list) {
        class_1937 l2 = this.method_1840();
        if (l2 instanceof class_3218) {
            VsiServerShipWorld world = VSGameUtilsKt.getShipObjectWorld((class_3218)l2);
            list.add("Ships Loaded: " + world.getLoadedShips().size() + "/" + world.getAllShips().size());
        }
    }

    @Inject(method={"getGameInformation"}, at={@At(value="INVOKE", target="Ljava/util/List;add(Ljava/lang/Object;)Z", ordinal=6, shift=At.Shift.AFTER)})
    private void addPlayerDraggingInformation(CallbackInfoReturnable<List<String>> cir, @Local List<String> list) {
        Object ship;
        Long shipId;
        EntityDraggingInformation info = ((IEntityDraggingInformationProvider)this.field_2079.field_1724).getDraggingInformation();
        if (info != null && info.isEntityBeingDraggedByAShip() && (shipId = info.getLastShipStoodOn()) != null && (ship = VSGameUtilsKt.getAllShips(this.method_1840()).getById(shipId)) != null) {
            list.add("Dragged by: " + VSGameUtilsKt.getAllShips(this.method_1840()).getById(info.getLastShipStoodOn()).getSlug());
        }
    }

    @Inject(method={"getSystemInformation"}, at={@At(value="INVOKE", target="Ljava/util/List;add(Ljava/lang/Object;)Z", ordinal=0)})
    private void addShipInformation(CallbackInfoReturnable<List<String>> cir, @Local List<String> list) {
        LoadedServerShip lsship;
        class_1937 l2 = this.method_1840();
        class_2338 blockPos = ((class_3965)this.field_2082).method_17777();
        Ship ship = VSGameUtilsKt.getShipManagingPos(l2, blockPos);
        LoadedServerShip loadedServerShip = lsship = l2 instanceof class_3218 ? VSGameUtilsKt.getLoadedShipManagingPos((class_3218)l2, (class_2382)blockPos) : null;
        if (ship != null) {
            list.add("");
            list.add(String.valueOf(class_124.field_1073) + "Targeted Ship: " + ship.getSlug());
            if (lsship != null) {
                list.add("Static: " + lsship.isStatic());
                list.add("Mass: " + lsship.getInertiaData().getMass() + " kg");
                list.add("");
            }
            Vector3dc scale = ship.getTransform().getShipToWorldScaling();
            list.add(String.format(Locale.ROOT, "Ship Scale: %.3f / %.3f / %.3f", scale.x(), scale.y(), scale.z()));
            Vector3dc linVel = ship.getVelocity();
            list.add(String.format(Locale.ROOT, "Linear Velocity: %.3f / %.3f / %.3f, total: %.3f m/s", linVel.x(), linVel.y(), linVel.z(), linVel.length()));
            Vector3dc angVel = ship.getOmega();
            list.add(String.format(Locale.ROOT, "Angular Velocity: %.3f / %.3f / %.3f", angVel.x(), angVel.y(), angVel.z()));
            class_243 pos = VSGameUtilsKt.toWorldCoordinates(ship, blockPos.method_46558());
            list.add(String.format(Locale.ROOT, "Targeted World Position: %.3f / %.3f / %.3f", pos.method_10216(), pos.method_10214(), pos.method_10215()));
        }
    }
}

