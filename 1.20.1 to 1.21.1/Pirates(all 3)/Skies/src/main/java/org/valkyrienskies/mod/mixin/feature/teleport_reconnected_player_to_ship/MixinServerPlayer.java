/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2487
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.teleport_reconnected_player_to_ship;

import com.mojang.authlib.GameProfile;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={class_3222.class})
public abstract class MixinServerPlayer
extends class_1657 {
    @Shadow
    public abstract class_3218 method_51469();

    public MixinServerPlayer(class_1937 level, class_2338 blockPos, float f2, GameProfile gameProfile) {
        super(level, blockPos, f2, gameProfile);
        throw new IllegalStateException("Unreachable");
    }

    @Inject(method={"readAdditionalSaveData"}, at={@At(value="RETURN")})
    void teleportToShip(class_2487 compoundTag, CallbackInfo ci) {
        if (!VSGameConfig.SERVER.getTeleportReconnectedPlayers()) {
            return;
        }
        if (!compoundTag.method_10545("LastShipId")) {
            return;
        }
        long lastShipId = compoundTag.method_10537("LastShipId");
        Object ship = VSGameUtilsKt.getShipObjectWorld(this.method_51469()).getAllShips().getById(lastShipId);
        if (ship == null) {
            return;
        }
        double x = compoundTag.method_10574("RelativeShipX");
        double y = compoundTag.method_10574("RelativeShipY");
        double z = compoundTag.method_10574("RelativeShipZ");
        Vector3d playerShipPosition = new Vector3d(x, y, z);
        Vector3d playerWorldPosition = ship.getShipToWorld().transformPosition(playerShipPosition);
        this.method_5814(playerWorldPosition.x, playerWorldPosition.y, playerWorldPosition.z);
    }

    @Inject(method={"addAdditionalSaveData"}, at={@At(value="RETURN")})
    void rememberLastShip(class_2487 compoundTag, CallbackInfo ci) {
        EntityDraggingInformation draggingInformation = ((IEntityDraggingInformationProvider)((Object)this)).getDraggingInformation();
        if (!draggingInformation.isEntityBeingDraggedByAShip()) {
            return;
        }
        Long lastShipId = draggingInformation.getLastShipStoodOn();
        if (lastShipId == null) {
            return;
        }
        Object ship = VSGameUtilsKt.getShipObjectWorld(this.method_51469()).getAllShips().getById(lastShipId);
        if (ship == null) {
            return;
        }
        compoundTag.method_10544("LastShipId", lastShipId.longValue());
        Vector3d playerWorldPosition = new Vector3d(this.method_23317(), this.method_23318(), this.method_23321());
        Vector3d playerShipPosition = ship.getWorldToShip().transformPosition(playerWorldPosition);
        compoundTag.method_10549("RelativeShipX", playerShipPosition.x);
        compoundTag.method_10549("RelativeShipY", playerShipPosition.y);
        compoundTag.method_10549("RelativeShipZ", playerShipPosition.z);
    }
}

