/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_2547
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  rbasamoyai.createbigcannons.network.ServerboundSetFixedCannonMountValuePacket
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import java.util.concurrent.Executor;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_2547;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import rbasamoyai.createbigcannons.network.ServerboundSetFixedCannonMountValuePacket;

@Mixin(value={ServerboundSetFixedCannonMountValuePacket.class})
public abstract class MixinSSFCMVP {
    @Unique
    private class_1937 level;

    @Inject(method={"handle"}, at={@At(value="HEAD")})
    private void stealLevel(Executor exec, class_2547 listener, class_3222 sender, CallbackInfo ci) {
        this.level = sender.method_37908();
    }

    @Redirect(method={"*"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z"))
    private boolean mixinCloserThan(class_2338 instance, class_2382 arg, double d2) {
        if (this.level != null) {
            class_2338 newInstance = instance;
            Ship ship = VSGameUtilsKt.getShipManagingPos(this.level, instance);
            if (ship != null) {
                newInstance = class_2338.method_49638((class_2374)VectorConversionsMCKt.toMinecraft(VSGameUtilsKt.toWorldCoordinates(ship, instance)));
            }
            return newInstance.method_19771(arg, d2);
        }
        return instance.method_19771(arg, d2);
    }
}

