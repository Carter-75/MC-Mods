/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.trains.track.CurvedTrackDestroyPacket
 *  com.simibubi.create.content.trains.track.TrackBlockEntity
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.packets;

import com.simibubi.create.content.trains.track.CurvedTrackDestroyPacket;
import com.simibubi.create.content.trains.track.TrackBlockEntity;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_3222;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={CurvedTrackDestroyPacket.class})
public abstract class MixinCurvedTrackDestroyPacket {
    @Unique
    private class_1937 world;

    @Redirect(method={"applySettings(Lnet/minecraft/server/level/ServerPlayer;Lcom/simibubi/create/content/trains/track/TrackBlockEntity;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z"))
    private boolean redirectCloserThan(class_2338 instance, class_2382 vec3i, double v) {
        class_2338 blockPos = instance;
        if (VSGameUtilsKt.isBlockInShipyard(this.world, instance)) {
            Ship ship = VSGameUtilsKt.getShipManagingPos(this.world, instance);
            Vector3d tempVec = VSGameUtilsKt.toWorldCoordinates(ship, instance);
            blockPos = class_2338.method_49637((double)tempVec.x, (double)tempVec.y, (double)tempVec.z);
        }
        return blockPos.method_19771(vec3i, v);
    }

    @Inject(method={"applySettings(Lnet/minecraft/server/level/ServerPlayer;Lcom/simibubi/create/content/trains/track/TrackBlockEntity;)V"}, at={@At(value="HEAD")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void injectCaptureLevel(class_3222 player, TrackBlockEntity te, CallbackInfo ci) {
        this.world = player.method_37908();
    }
}

