/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.trains.track.ITrackBlock
 *  net.createmod.catnip.data.Iterate
 *  net.createmod.catnip.data.Pair
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2352
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 *  org.spongepowered.asm.mixin.Shadow
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.simibubi.create.content.trains.track.ITrackBlock;
import java.util.List;
import net.createmod.catnip.data.Iterate;
import net.createmod.catnip.data.Pair;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ITrackBlock.class})
public interface MixinITrackBlock {
    @Shadow
    public List<class_243> getTrackAxes(class_1922 var1, class_2338 var2, class_2680 var3);

    @Overwrite
    default public Pair<class_243, class_2350.class_2352> getNearestTrackAxis(class_1922 world, class_2338 pos, class_2680 state, class_243 lookVec) {
        Ship ship = VSGameUtilsKt.getShipManagingPos((class_1937)world, pos);
        if (ship != null) {
            Vector3d vecInShipJOML = ship.getTransform().getWorldToShip().transformDirection(lookVec.field_1352, lookVec.field_1351, lookVec.field_1350, new Vector3d());
            lookVec = VectorConversionsMCKt.toMinecraft(vecInShipJOML);
        }
        class_243 best = null;
        double bestDiff = Double.MAX_VALUE;
        for (class_243 vec3 : this.getTrackAxes(world, pos, state)) {
            for (int opposite : Iterate.positiveAndNegative) {
                double distanceTo = vec3.method_1029().method_1022(lookVec.method_1021((double)opposite));
                if (distanceTo > bestDiff) continue;
                bestDiff = distanceTo;
                best = vec3;
            }
        }
        return Pair.of(best, (Object)(lookVec.method_1026(best.method_18805(1.0, 0.0, 1.0).method_1029()) < 0.0 ? class_2350.class_2352.field_11056 : class_2350.class_2352.field_11060));
    }
}

