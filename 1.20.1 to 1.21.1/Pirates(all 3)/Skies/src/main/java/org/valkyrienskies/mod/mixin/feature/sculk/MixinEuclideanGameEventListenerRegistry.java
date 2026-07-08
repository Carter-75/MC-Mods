/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_5711
 *  net.minecraft.class_5714
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.sculk;

import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_5711;
import net.minecraft.class_5714;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_5711.class})
public abstract class MixinEuclideanGameEventListenerRegistry {
    @Inject(method={"getPostableListenerPosition"}, at={@At(value="HEAD")}, cancellable=true)
    private static void vsAwareDistance(class_3218 serverLevel, class_243 vec3, class_5714 gameEventListener, CallbackInfoReturnable<Optional<class_243>> cir) {
        Optional optional = gameEventListener.method_32946().method_32956((class_1937)serverLevel);
        if (optional.isEmpty()) {
            cir.setReturnValue(Optional.empty());
        } else {
            int i2;
            double d2;
            class_243 orig = (class_243)optional.get();
            class_243 sourcePos = vec3;
            class_243 listenPos = (class_243)optional.get();
            Ship sourceShip = VSGameUtilsKt.getShipManagingPos((class_1937)serverLevel, (class_2374)sourcePos);
            Ship listenShip = VSGameUtilsKt.getShipManagingPos((class_1937)serverLevel, (class_2374)listenPos);
            if (sourceShip != null) {
                sourcePos = VSGameUtilsKt.toWorldCoordinates(sourceShip, sourcePos);
            }
            if (listenShip != null) {
                listenPos = VSGameUtilsKt.toWorldCoordinates(listenShip, listenPos);
            }
            cir.setReturnValue((Object)((d2 = listenPos.method_1025(sourcePos)) > (double)(i2 = gameEventListener.method_32948() * gameEventListener.method_32948()) ? Optional.empty() : optional));
        }
        cir.cancel();
    }
}

