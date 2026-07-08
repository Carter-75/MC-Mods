/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  rbasamoyai.createbigcannons.cannon_control.ControlPitchContraption
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.GameToPhysicsAdapter;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import rbasamoyai.createbigcannons.cannon_control.ControlPitchContraption;

@Mixin(targets={"rbasamoyai.createbigcannons.cannon_control.contraption.MountedAutocannonContraption", "rbasamoyai.createbigcannons.cannon_control.contraption.MountedBigCannonContraption"})
public class MixinCannonContraption {
    @WrapOperation(method={"fireShot"}, at={@At(value="INVOKE", target="Lrbasamoyai/createbigcannons/cannon_control/ControlPitchContraption;onRecoil(Lnet/minecraft/world/phys/Vec3;Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;)V")})
    public void onFireShot(ControlPitchContraption instance, class_243 vector, AbstractContraptionEntity cannon, Operation<Void> original, @Local(name={"recoilMagnitude"}) float recoilMagnitude) {
        this.vs$handleRecoil(instance, vector, cannon, recoilMagnitude);
        original.call(new Object[]{instance, vector, cannon});
    }

    @Unique
    private void vs$handleRecoil(ControlPitchContraption instance, class_243 vector, AbstractContraptionEntity cannon, float magnitude) {
        GameToPhysicsAdapter applier;
        LoadedServerShip ship = (LoadedServerShip)VSGameUtilsKt.getLoadedShipManagingPos(cannon.method_37908(), (class_2382)class_2338.method_49638((class_2374)cannon.getAnchorVec()));
        if (VSGameConfig.SERVER.getCbc().getShellRecoil() && (applier = ValkyrienSkiesMod.getOrCreateGTPA(VSGameUtilsKt.getDimensionId(cannon.method_37908()))) != null) {
            double recoilForce = (double)magnitude * VSGameConfig.SERVER.getCbc().getShellRecoilMult();
            applier.applyInvariantForceToPos(ship.getId(), ship.getTransform().getShipToWorldRotation().transform(VectorConversionsMCKt.toJOML(vector).negate().normalize()).mul(recoilForce), VectorConversionsMCKt.toJOML(cannon.getAnchorVec().method_1031(0.5, 0.5, 0.5)).sub(ship.getTransform().getPositionInShip()));
        }
    }
}

