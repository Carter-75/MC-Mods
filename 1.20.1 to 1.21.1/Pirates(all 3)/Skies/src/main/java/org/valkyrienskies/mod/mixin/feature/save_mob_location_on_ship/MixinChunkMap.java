/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_3898
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.save_mob_location_on_ship;

import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_3898;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.entity.ShipyardPosSavable;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_3898.class})
public class MixinChunkMap {
    @Shadow
    @Final
    class_3218 field_17214;

    @Inject(method={"removeEntity"}, at={@At(value="HEAD")})
    protected void unloadEntityMixin(class_1297 entity, CallbackInfo info) {
        class_1308 mob;
        Vector3d shipyardPos;
        if (entity instanceof class_1308 && (shipyardPos = this.valkyrienskies$getShipyardPos((class_1297)(mob = (class_1308)entity))) != null && VSGameUtilsKt.getShipManagingPos(this.field_17214, (Vector3dc)shipyardPos) != null && ((ShipyardPosSavable)mob).valkyrienskies$getUnloadedShipyardPos() == null) {
            ((ShipyardPosSavable)mob).valkyrienskies$setUnloadedShipyardPos(shipyardPos);
        }
    }

    @Inject(method={"addEntity"}, at={@At(value="RETURN")})
    protected void loadEntityMixin(class_1297 entity, CallbackInfo info) {
        class_1308 mob;
        Vector3d shipyardPos;
        if (entity instanceof class_1308 && (shipyardPos = ((ShipyardPosSavable)(mob = (class_1308)entity)).valkyrienskies$getUnloadedShipyardPos()) != null) {
            if (VSGameConfig.SERVER.getSaveMobsPositionOnShip()) {
                mob.method_5859(shipyardPos.x, shipyardPos.y, shipyardPos.z);
            }
            ((ShipyardPosSavable)mob).valkyrienskies$setUnloadedShipyardPos(null);
        }
    }

    @Unique
    private Vector3d valkyrienskies$getShipyardPos(class_1297 entity) {
        Object ship;
        EntityDraggingInformation dragInfo = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
        if (dragInfo.getLastShipStoodOn() != null && (ship = VSGameUtilsKt.getAllShips((class_1937)this.field_17214).getById(dragInfo.getLastShipStoodOn())) != null && ship.getWorldAABB().containsPoint(VectorConversionsMCKt.toJOML(entity.method_19538()))) {
            return ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(entity.method_19538()));
        }
        return null;
    }
}

