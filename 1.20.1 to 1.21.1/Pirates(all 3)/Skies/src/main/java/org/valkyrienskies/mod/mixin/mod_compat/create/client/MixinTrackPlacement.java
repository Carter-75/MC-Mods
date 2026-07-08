/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.simibubi.create.content.trains.track.TrackPlacement
 *  com.simibubi.create.content.trains.track.TrackPlacement$PlacementInfo
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.simibubi.create.content.trains.track.TrackPlacement;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.PlayerUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={TrackPlacement.class})
public abstract class MixinTrackPlacement {
    @WrapMethod(method={"tryConnect"})
    private static TrackPlacement.PlacementInfo wrapTryConnect(class_1937 level, class_1657 player, class_2338 pos2, class_2680 state2, class_1799 stack, boolean girder, boolean maximiseTurn, Operation<TrackPlacement.PlacementInfo> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(level, pos2);
        if (ship != null) {
            PlayerUtil.transformPlayerTemporarily(player, level, pos2);
            TrackPlacement.PlacementInfo info = (TrackPlacement.PlacementInfo)original.call(new Object[]{level, player, pos2, state2, stack, girder, maximiseTurn});
            PlayerUtil.untransformPlayer(player);
            return info;
        }
        return (TrackPlacement.PlacementInfo)original.call(new Object[]{level, player, pos2, state2, stack, girder, maximiseTurn});
    }
}

