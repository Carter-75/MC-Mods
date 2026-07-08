/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.crusher.CrushingWheelBlock
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.simibubi.create.content.kinetics.crusher.CrushingWheelBlock;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={CrushingWheelBlock.class})
public class MixinCrushingWheelBlock {
    @Unique
    private class_2338 blockPosInside;
    @Unique
    private class_1937 levelInside;

    @Inject(method={"entityInside"}, at={@At(value="HEAD")})
    void startInside(class_2680 state, class_1937 worldIn, class_2338 pos, class_1297 entityIn, CallbackInfo info) {
        this.blockPosInside = pos;
        this.levelInside = worldIn;
    }

    @Unique
    void transform(Vector3d in) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.levelInside, this.blockPosInside);
        if (ship != null) {
            ship.getWorldToShip().transformPosition(in);
        }
    }

    @Redirect(method={"entityInside"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getX()D"))
    double getXPos(class_1297 entity) {
        Vector3d vector3d = new Vector3d(entity.method_23317(), entity.method_23318(), entity.method_23321());
        this.transform(vector3d);
        return vector3d.x;
    }

    @Redirect(method={"entityInside"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getY()D"))
    double getYPos(class_1297 entity) {
        Vector3d vector3d = new Vector3d(entity.method_23317(), entity.method_23318(), entity.method_23321());
        this.transform(vector3d);
        return vector3d.x;
    }

    @Redirect(method={"entityInside"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getZ()D"))
    double getZPos(class_1297 entity) {
        Vector3d vector3d = new Vector3d(entity.method_23317(), entity.method_23318(), entity.method_23321());
        this.transform(vector3d);
        return vector3d.x;
    }
}

