/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.thrown_velocity;

import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={class_1297.class})
public class MixinEntity {
    @Shadow
    private class_1937 field_6002;

    @Inject(method={"spawnAtLocation(Lnet/minecraft/world/item/ItemStack;F)Lnet/minecraft/world/entity/item/ItemEntity;"}, at={@At(value="RETURN")})
    private void setItemDragged(class_1799 itemStack, float f2, CallbackInfoReturnable<class_1542> cir) {
        class_1542 result2 = (class_1542)cir.getReturnValue();
        if (result2 == null) {
            return;
        }
        Ship ship = VSGameUtilsKt.getShipMountedTo((class_1297)class_1297.class.cast(this));
        EntityDraggingInformation info = ((IEntityDraggingInformationProvider)((Object)this)).getDraggingInformation();
        if (ship == null && info.isEntityBeingDraggedByAShip()) {
            ship = ValkyrienSkies.getShipById(this.field_6002, info.getLastShipStoodOn());
        }
        ((IEntityDraggingInformationProvider)result2).vs$dragImmediately(ship);
    }
}

