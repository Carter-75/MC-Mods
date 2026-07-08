/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.OrientedContraptionEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import com.simibubi.create.content.contraptions.OrientedContraptionEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(targets={"rbasamoyai.createbigcannons.cannon_control.contraption.PitchOrientedContraptionEntity"})
public abstract class MixinPitchOrientedContraptionEntity
extends OrientedContraptionEntity {
    @Shadow
    private class_2338 controllerPos;

    public MixinPitchOrientedContraptionEntity(class_1299<?> type, class_1937 world) {
        super(type, world);
    }

    @Inject(method={"processRiderPositionHook"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    protected void vsProcesssRiderPositionHook(class_1297 passenger, @Nullable class_243 original, CallbackInfoReturnable<class_243> ci) {
        if (original != null && this.controllerPos != null) {
            Vector3d editOriginal = VectorConversionsMCKt.toJOML(original);
            LoadedShip ship = VSGameUtilsKt.getLoadedShipManagingPos(this.method_37908(), (class_2382)this.controllerPos);
            if (ship != null) {
                ship.getShipToWorld().transformPosition(editOriginal);
                original = VectorConversionsMCKt.toMinecraft(editOriginal).method_1031(0.5, 1.0, 0.5).method_1023(0.0, (double)passenger.method_5751(), 0.0);
                ci.setReturnValue((Object)original);
            }
        }
    }

    @Inject(method={"getPassengerPosition"}, at={@At(value="RETURN")}, cancellable=true, remap=false)
    protected void vsGetPassengerPosition(class_1297 passenger, float partialTicks, CallbackInfoReturnable<class_243> cir) {
        if (VSGameUtilsKt.getLoadedShipManagingPos(passenger.method_37908(), (Vector3dc)VectorConversionsMCKt.toJOML(this.method_19538())) != null) {
            cir.setReturnValue((Object)((class_243)cir.getReturnValue()).method_1031(0.0, 0.1, 0.0));
        }
    }
}

