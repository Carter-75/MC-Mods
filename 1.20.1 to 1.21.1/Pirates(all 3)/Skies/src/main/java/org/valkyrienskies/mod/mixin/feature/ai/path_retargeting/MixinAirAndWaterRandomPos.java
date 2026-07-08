/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1314
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_5493
 *  net.minecraft.class_5530
 *  net.minecraft.class_5535
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.ai.path_retargeting;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1314;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_5493;
import net.minecraft.class_5530;
import net.minecraft.class_5535;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_5530.class})
public class MixinAirAndWaterRandomPos {
    @Inject(method={"generateRandomPos"}, at={@At(value="TAIL")}, cancellable=true)
    private static void preGenerateRandomPos(class_1314 pathfinderMob, int i2, int j2, int k2, double d2, double e2, double f2, boolean bl, CallbackInfoReturnable<class_2338> cir, @Local(ordinal=1) class_2338 blockPos2) {
        if (cir.getReturnValue() != null) {
            return;
        }
        if (pathfinderMob.method_37908() != null) {
            if (blockPos2 == null) {
                return;
            }
            class_238 checker = new class_238(blockPos2);
            Iterable ships = VSGameUtilsKt.getShipObjectWorld(pathfinderMob.method_37908()).getLoadedShips().getIntersecting(VectorConversionsMCKt.toJOML(checker), VSGameUtilsKt.getDimensionId(pathfinderMob.method_37908()));
            if (ships.iterator().hasNext()) {
                for (LoadedShip ship : ships) {
                    Vector3d posInShip = ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOMLD((class_2382)blockPos2), new Vector3d());
                    class_2338 blockPosInShip = class_2338.method_49638((class_2374)VectorConversionsMCKt.toMinecraft(posInShip));
                    if (class_5493.method_31521((boolean)bl, (class_1314)pathfinderMob, (class_2338)blockPosInShip) || class_5493.method_31522((class_1314)pathfinderMob, (class_2338)(blockPos2 = class_5535.method_31540((class_2338)blockPos2, (int)pathfinderMob.method_37908().method_31600(), arg2 -> class_5493.method_31523((class_1314)pathfinderMob, (class_2338)arg2))))) continue;
                    cir.setReturnValue((Object)blockPosInShip);
                    break;
                }
            }
        }
    }
}

