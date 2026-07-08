/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.bed_fix;

import java.util.Optional;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_1657.class})
public abstract class MixinPlayer {
    @Inject(method={"findRespawnPositionAndUseSpawnBlock"}, at={@At(value="RETURN")}, cancellable=true)
    private static void cancelIfInShipyard(class_3218 serverLevel, class_2338 blockPos, float f2, boolean bl, boolean bl2, CallbackInfoReturnable<Optional<class_243>> cir) {
        if (((Optional)cir.getReturnValue()).isEmpty()) {
            return;
        }
        class_243 pos = (class_243)((Optional)cir.getReturnValue()).get();
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)serverLevel, pos) && VSGameUtilsKt.getShipManagingPos((class_1937)serverLevel, (class_2374)pos) == null) {
            cir.setReturnValue(Optional.empty());
        }
    }
}

