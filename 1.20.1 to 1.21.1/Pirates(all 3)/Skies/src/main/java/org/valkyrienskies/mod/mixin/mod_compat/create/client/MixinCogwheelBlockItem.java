/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(targets={"com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem$SmallCogHelper", "com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem$LargeCogHelper", "com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem$DiagonalCogHelper", "com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem$IntegratedLargeCogHelper", "com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem$IntegratedSmallCogHelper"})
public class MixinCogwheelBlockItem {
    @Redirect(method={"getOffset"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/BlockHitResult;getLocation()Lnet/minecraft/world/phys/Vec3;"))
    private class_243 redirectGetLocation(class_3965 instance) {
        Ship ship;
        class_243 result2 = instance.method_17784();
        class_638 world = class_310.method_1551().field_1687;
        if (world != null && (ship = VSGameUtilsKt.getShipManagingPos((class_1937)world, instance.method_17777())) != null && !VSGameUtilsKt.isBlockInShipyard((class_1937)world, result2.field_1352, result2.field_1351, result2.field_1350)) {
            Vector3d tempVec = VectorConversionsMCKt.toJOML(result2);
            ship.getWorldToShip().transformPosition(tempVec, tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }
}

