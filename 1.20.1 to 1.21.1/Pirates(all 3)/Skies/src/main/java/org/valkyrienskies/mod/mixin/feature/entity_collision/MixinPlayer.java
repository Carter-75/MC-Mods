/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1313
 *  net.minecraft.class_1656
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.entity_collision;

import net.minecraft.class_1313;
import net.minecraft.class_1656;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.internal.world.VsiShipWorld;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDragger;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={class_1657.class})
public abstract class MixinPlayer
implements IEntityDraggingInformationProvider {
    @Shadow
    @Final
    private class_1656 field_7503;

    @Shadow
    protected abstract boolean method_21825();

    @Inject(method={"maybeBackOffFromEdge"}, at={@At(value="HEAD")}, cancellable=true)
    private void preMaybeBackOffFromEdge(class_243 vec3, class_1313 moverType, CallbackInfoReturnable<class_243> callbackInfoReturnable) {
        class_1657 player;
        class_1937 level;
        if (this.getDraggingInformation().isEntityBeingDraggedByAShip() && this.getDraggingInformation().getLastShipStoodOn() != null && this.getDraggingInformation().getTicksSinceStoodOnShip() < 1 && (level = (player = (class_1657)this).method_37908()) != null) {
            VsiShipWorld shipWorld = VSGameUtilsKt.getShipObjectWorld(level);
            if (shipWorld == null) {
                return;
            }
            LoadedShip ship = shipWorld.getLoadedShips().getById(this.getDraggingInformation().getLastShipStoodOn());
            if (ship == null) {
                return;
            }
            if (vec3.field_1351 <= 0.0 && (moverType == class_1313.field_6308 || moverType == class_1313.field_6305) && this.method_21825() && !this.field_7503.field_7479) {
                class_243 adjustedVec = EntityDragger.backOff(vec3, ship, player, level);
                callbackInfoReturnable.setReturnValue((Object)adjustedVec);
            }
        }
    }
}

