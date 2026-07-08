/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dan200.computercraft.shared.turtle.blocks.TurtleBlockEntity
 *  dan200.computercraft.shared.turtle.core.TurtleBrain
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package org.valkyrienskies.mod.mixin.mod_compat.cc_tweaked;

import dan200.computercraft.shared.turtle.blocks.TurtleBlockEntity;
import dan200.computercraft.shared.turtle.core.TurtleBrain;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import org.joml.Vector3d;
import org.joml.primitives.AABBic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;

@Pseudo
@Mixin(value={TurtleBrain.class}, priority=2000)
public abstract class MixinTurtleBrain {
    @Shadow(remap=false)
    public abstract TurtleBlockEntity getOwner();

    @Shadow
    public abstract class_1937 getLevel();

    @ModifyVariable(method={"Ldan200/computercraft/shared/turtle/core/TurtleBrain;teleportTo(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)Z"}, at=@At(value="HEAD"), index=2)
    private class_2338 teleportTo$modify$blockPos(class_2338 pos) {
        TurtleBlockEntity owner = this.getOwner();
        class_2338 oldPos = owner.method_11016();
        class_1937 world = this.getLevel();
        Ship ship = VSGameUtilsKt.getShipManagingPos(world, oldPos);
        if (ship == null) {
            return pos;
        }
        AABBic box = ship.getShipAABB();
        if (box.minX() <= pos.method_10263() && pos.method_10263() < box.maxX() && box.minY() <= pos.method_10264() && pos.method_10264() < box.maxY() && box.minZ() <= pos.method_10260() && pos.method_10260() < box.maxZ()) {
            return pos;
        }
        class_2382 dirVec = owner.getDirection().method_10163();
        Vector3d directionVec = ship.getShipToWorld().transformDirection((double)dirVec.method_10263(), (double)dirVec.method_10264(), (double)dirVec.method_10260(), new Vector3d());
        owner.setDirection(class_2350.method_10142((double)directionVec.x, (double)directionVec.y, (double)directionVec.z));
        if (!ship.getTransform().getShipToWorldScaling().equals(1.0, 1.0, 1.0) && !VSGameConfig.SERVER.getComputerCraft().getCanTurtlesLeaveScaledShips()) {
            return pos;
        }
        Vector3d worldPos = VSGameUtilsKt.toWorldCoordinates(world, (double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5);
        return class_2338.method_49637((double)worldPos.x, (double)worldPos.y, (double)worldPos.z);
    }
}

