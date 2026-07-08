/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3225
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.fabric.mixin.server.network;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3225;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_3225.class})
public class MixinServerPlayerGameMode {
    @Final
    @Shadow
    protected class_3222 field_14008;
    @Shadow
    protected class_3218 field_14007;

    @Redirect(method={"handleBlockBreakAction"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D"))
    public double handleBlockBreakAction(class_243 instance, class_243 vec3) {
        class_2338 pos = class_2338.method_49638((class_2374)vec3.method_1023(0.5, 0.5, 0.5));
        if (VSGameConfig.SERVER.getEnableInteractDistanceChecks()) {
            Vector3d blockCenter = VectorConversionsMCKt.toJOMLD((class_2382)pos).add(0.5, 0.5, 0.5);
            return VSGameUtilsKt.getWorldCoordinates((class_1937)this.field_14007, pos, blockCenter).distanceSquared(this.field_14008.method_23317(), this.field_14008.method_23318() + 1.5, this.field_14008.method_23321());
        }
        return instance.method_1025(vec3);
    }
}

