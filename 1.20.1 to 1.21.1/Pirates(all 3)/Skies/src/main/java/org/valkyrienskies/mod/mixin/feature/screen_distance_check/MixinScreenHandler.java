/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.feature.screen_distance_check;

import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDragger;

@Mixin(value={class_1703.class})
public class MixinScreenHandler {
    @Redirect(method={"*"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Player;distanceToSqr(DDD)D"), require=0)
    private static double includeShipsInDistanceCheck(class_1657 receiver, double x, double y, double z) {
        class_243 eye = EntityDragger.INSTANCE.serversideEyePosition((class_1297)receiver);
        return VSGameUtilsKt.squaredDistanceToInclShips((class_1297)receiver, eye.field_1352, eye.field_1351, eye.field_1350);
    }
}

