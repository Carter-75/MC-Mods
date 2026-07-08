/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_6862
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.fabric.mixin.feature.water_in_ships_entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_6862;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_1297.class})
public abstract class MixinEntity {
    @Unique
    private boolean isModifyingWaterState = false;
    @Shadow
    public class_1937 field_6002;
    @Shadow
    private class_238 field_6005;
    @Unique
    private boolean isShipWater = false;
    @Unique
    private class_238 valkyrienskies$fluidPushAABB = null;
    @Unique
    private class_243 valkyrienskies$fluidPushVec = null;
    @Unique
    private int valkyrienskies$fluidPushNumber = 0;
    @Unique
    private boolean valkyrienskies$fluidPushRet = false;
    @Unique
    private double valkyrienskies$fluidPushE = 0.0;

    @Shadow
    public abstract double method_23320();

    @Shadow
    public abstract double method_23317();

    @Shadow
    public abstract double method_23321();

    @Shadow
    public abstract boolean method_5692(class_6862<class_3611> var1, double var2);

    @Unique
    private boolean inShipContext() {
        return this.valkyrienskies$fluidPushAABB != null;
    }

    @ModifyVariable(method={"updateFluidHeightAndDoFluidPushing"}, at=@At(value="STORE"))
    private class_238 setFluidPushInShipContext(class_238 original) {
        if (this.inShipContext()) {
            return this.valkyrienskies$fluidPushAABB;
        }
        return original;
    }

    @ModifyConstant(method={"updateFluidHeightAndDoFluidPushing"}, constant={@Constant(doubleValue=0.0)})
    private double setFluidPushInShipContext(double constant) {
        return this.valkyrienskies$fluidPushE;
    }

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;length()D", ordinal=0)}, method={"updateFluidHeightAndDoFluidPushing"}, cancellable=true)
    private void shouldProcessPush(class_6862<class_3611> tagKey, double d2, CallbackInfoReturnable<Boolean> cir, @Local(ordinal=6) int numberPush, @Local(ordinal=1) boolean bl2, @Local(ordinal=0) class_243 vec3, @Local(ordinal=1) double e2) {
        if (this.inShipContext()) {
            this.valkyrienskies$fluidPushE = e2;
            this.valkyrienskies$fluidPushNumber += numberPush;
            this.valkyrienskies$fluidPushVec = this.valkyrienskies$fluidPushVec.method_1019(vec3);
            cir.setReturnValue((Object)bl2);
        }
    }

    @Redirect(at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;length()D", ordinal=0), method={"updateFluidHeightAndDoFluidPushing"})
    private double collectShipFluidPush(class_243 instance, @Local(ordinal=0, argsOnly=true) class_6862<class_3611> tagKey, @Local(ordinal=0, argsOnly=true) double d2, @Local(ordinal=0) class_238 aabb, @Local(ordinal=1) boolean bl2, @Local(ordinal=6) int numberPush, @Local(ordinal=1) double e2) {
        this.valkyrienskies$fluidPushE = e2;
        this.valkyrienskies$fluidPushNumber = numberPush;
        this.valkyrienskies$fluidPushRet = bl2;
        this.valkyrienskies$fluidPushVec = instance;
        VSGameUtilsKt.transformFromWorldToNearbyShipsAndWorld(this.field_6002, aabb, shipAabb -> {
            this.valkyrienskies$fluidPushAABB = shipAabb;
            this.valkyrienskies$fluidPushRet = this.valkyrienskies$fluidPushRet || this.method_5692(tagKey, d2);
        });
        this.valkyrienskies$fluidPushAABB = null;
        return this.valkyrienskies$fluidPushVec.method_1033();
    }

    @ModifyVariable(method={"updateFluidHeightAndDoFluidPushing"}, at=@At(value="LOAD"), ordinal=6)
    private int loadO(int origin) {
        return this.valkyrienskies$fluidPushNumber;
    }

    @Redirect(method={"updateFluidHeightAndDoFluidPushing"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;scale(D)Lnet/minecraft/world/phys/Vec3;", ordinal=1))
    private class_243 setVec3ToPush(class_243 instance, double d2) {
        return this.valkyrienskies$fluidPushVec.method_1021(d2);
    }

    @Inject(method={"updateFluidHeightAndDoFluidPushing"}, at={@At(value="TAIL")}, cancellable=true)
    private void setFluidPushingReturnValue(class_6862<class_3611> tagKey, double d2, CallbackInfoReturnable<Boolean> cir) {
        this.valkyrienskies$fluidPushE = 0.0;
        cir.setReturnValue((Object)this.valkyrienskies$fluidPushRet);
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getFluidState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/FluidState;")}, method={"updateFluidOnEyes"})
    private class_3610 getFluidStateRedirect(class_1937 level, class_2338 blockPos, Operation<class_3610> getFluidState) {
        class_3610[] fluidState = new class_3610[]{(class_3610)getFluidState.call(new Object[]{level, blockPos})};
        this.isShipWater = false;
        if (fluidState[0].method_15769()) {
            double d2 = this.method_23320() - 0.1111111119389534;
            double origX = this.method_23317();
            double origY = d2;
            double origZ = this.method_23321();
            VSGameUtilsKt.transformToNearbyShipsAndWorld(this.field_6002, origX, origY, origZ, this.field_6005.method_995(), (x, y, z) -> {
                fluidState[0] = (class_3610)getFluidState.call(new Object[]{level, class_2338.method_49637((double)x, (double)y, (double)z)});
            });
            this.isShipWater = true;
        }
        return fluidState[0];
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/level/material/FluidState;getHeight(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F")}, method={"updateFluidOnEyes"})
    private float fluidHeightOverride(class_3610 instance, class_1922 arg, class_2338 arg2, Operation<Float> getHeight) {
        if (!instance.method_15769() && this.field_6002 instanceof class_1937 && this.isShipWater && instance.method_15771()) {
            return 1.0f;
        }
        return ((Float)getHeight.call(new Object[]{instance, arg, arg2})).floatValue();
    }
}

