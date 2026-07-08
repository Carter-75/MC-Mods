/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  rbasamoyai.createbigcannons.utils.CBCUtils
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import rbasamoyai.createbigcannons.utils.CBCUtils;

@Pseudo
@Mixin(targets={"rbasamoyai.createbigcannons.utils.CBCUtils"})
public abstract class MixinCBCUtils {
    @Inject(method={"getSurfaceNormalVector(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"}, at={@At(value="RETURN")}, cancellable=true)
    private static void getSurfaceNormalVector(class_1937 level, class_2338 hitPos, class_243 normal, CallbackInfoReturnable<class_243> cir) {
        Ship s = VSGameUtilsKt.getShipManagingPos(level, hitPos);
        if (s != null) {
            cir.setReturnValue((Object)VectorConversionsMCKt.toMinecraft(s.getShipToWorld().transformDirection(VectorConversionsMCKt.toJOML(normal))));
        }
    }

    @Inject(method={"playBlastLikeSoundOnServer"}, at={@At(value="HEAD")}, cancellable=true)
    private static void mixinBlastLocation(class_3218 level, double x, double y, double z, class_3414 soundEvent, class_3419 soundSource, float volume, float pitch, float airAbsorption, CallbackInfo ci) {
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)level, x, y, z)) {
            Vector3d world = VSGameUtilsKt.toWorldCoordinates((class_1937)level, x, y, z);
            CBCUtils.playBlastLikeSoundOnServer((class_3218)level, (double)world.x, (double)world.y, (double)world.z, (class_3414)soundEvent, (class_3419)soundSource, (float)volume, (float)pitch, (float)airAbsorption);
            ci.cancel();
        }
    }
}

