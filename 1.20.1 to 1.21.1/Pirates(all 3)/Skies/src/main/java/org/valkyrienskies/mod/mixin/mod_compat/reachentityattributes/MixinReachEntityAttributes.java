/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 */
package org.valkyrienskies.mod.mixin.mod_compat.reachentityattributes;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDragger;

@Pseudo
@Mixin(value={ReachEntityAttributes.class})
public class MixinReachEntityAttributes {
    @Shadow
    public static double getReachDistance(class_1309 entity, double baseReachDistance) {
        return 0.0;
    }

    @Overwrite
    public static List<class_1657> getPlayersWithinReach(Predicate<class_1657> viewerPredicate, class_1937 world, int x, int y, int z, double baseReachDistance) {
        ArrayList<class_1657> playersWithinReach = new ArrayList<class_1657>(0);
        for (class_1657 player : world.method_18456()) {
            if (!viewerPredicate.test(player)) continue;
            double reach = MixinReachEntityAttributes.getReachDistance((class_1309)player, baseReachDistance);
            class_243 eye = EntityDragger.INSTANCE.serversideEyePosition((class_1297)player);
            if (!(VSGameUtilsKt.squaredDistanceBetweenInclShips(world, (double)x + 0.5, (double)y + 0.5, (double)z + 0.5, eye.field_1352, eye.field_1351, eye.field_1350) <= reach * reach)) continue;
            playersWithinReach.add(player);
        }
        return playersWithinReach;
    }
}

