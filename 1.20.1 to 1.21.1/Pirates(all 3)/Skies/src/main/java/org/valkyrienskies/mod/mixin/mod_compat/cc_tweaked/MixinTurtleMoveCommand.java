/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dan200.computercraft.api.turtle.ITurtleAccess
 *  dan200.computercraft.api.turtle.TurtleCommandResult
 *  dan200.computercraft.shared.turtle.core.MoveDirection
 *  dan200.computercraft.shared.turtle.core.TurtleMoveCommand
 *  dan200.computercraft.shared.turtle.core.TurtlePlayer
 *  dan200.computercraft.shared.util.WorldUtil
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_4971
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.Slice
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.cc_tweaked;

import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.TurtleCommandResult;
import dan200.computercraft.shared.turtle.core.MoveDirection;
import dan200.computercraft.shared.turtle.core.TurtleMoveCommand;
import dan200.computercraft.shared.turtle.core.TurtlePlayer;
import dan200.computercraft.shared.util.WorldUtil;
import java.util.function.Predicate;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.primitives.AABBic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(value={TurtleMoveCommand.class}, priority=2000)
public abstract class MixinTurtleMoveCommand {
    @Shadow(remap=false)
    @Final
    private MoveDirection direction;
    @Unique
    private class_2350 movingDirection = null;

    @Redirect(method={"execute"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;relative(Lnet/minecraft/core/Direction;)Lnet/minecraft/core/BlockPos;", remap=true), remap=false)
    public class_2338 execute$oldPosition$relative(class_2338 oldPosition, class_2350 direction, ITurtleAccess turtle) {
        class_2338 newPosition = oldPosition.method_10093(direction);
        this.movingDirection = null;
        Ship ship = VSGameUtilsKt.getShipManagingPos(turtle.getLevel(), turtle.getPosition());
        if (ship == null) {
            return newPosition;
        }
        AABBic box = ship.getShipAABB();
        if (box.minX() <= newPosition.method_10263() && newPosition.method_10263() < box.maxX() && box.minY() <= newPosition.method_10264() && newPosition.method_10264() < box.maxY() && box.minZ() <= newPosition.method_10260() && newPosition.method_10260() < box.maxZ()) {
            return newPosition;
        }
        if (!ship.getTransform().getShipToWorldScaling().equals(1.0, 1.0, 1.0) && !VSGameConfig.SERVER.getComputerCraft().getCanTurtlesLeaveScaledShips()) {
            return newPosition;
        }
        Matrix4dc transform2 = ship.getShipToWorld();
        class_2382 dirVec = direction.method_10163();
        Vector3d movingVec = transform2.transformDirection(new Vector3d(dirVec.method_10263(), dirVec.method_10264(), dirVec.method_10260()));
        this.movingDirection = class_2350.method_10142((double)movingVec.x, (double)movingVec.y, (double)movingVec.z);
        Vector3d worldPos = transform2.transformPosition(new Vector3d((double)newPosition.method_10263() + 0.5, (double)newPosition.method_10264() + 0.5, (double)newPosition.method_10260() + 0.5));
        return class_2338.method_49637((double)worldPos.x, (double)worldPos.y, (double)worldPos.z);
    }

    @Redirect(method={"execute"}, slice=@Slice(from=@At(value="INVOKE", target="Ldan200/computercraft/api/turtle/ITurtleAccess;consumeFuel")), at=@At(value="FIELD", target="Ldan200/computercraft/shared/turtle/core/TurtleMoveCommand;direction:Ldan200/computercraft/shared/turtle/core/MoveDirection;", opcode=180), remap=false)
    public MoveDirection execute$load$direction(TurtleMoveCommand command2, ITurtleAccess turtle) {
        if (this.movingDirection == null) {
            return this.direction;
        }
        class_2350 turtleDir = turtle.getDirection();
        if (this.movingDirection == turtleDir) {
            return MoveDirection.FORWARD;
        }
        if (this.movingDirection == turtleDir.method_10153()) {
            return MoveDirection.BACK;
        }
        if (this.movingDirection == class_2350.field_11036) {
            return MoveDirection.UP;
        }
        if (this.movingDirection == class_2350.field_11033) {
            return MoveDirection.DOWN;
        }
        return this.direction;
    }

    @Inject(method={"canEnter"}, at={@At(value="HEAD")}, remap=false, cancellable=true)
    private static void canEnter(TurtlePlayer turtlePlayer, class_3218 world, class_2338 position, CallbackInfoReturnable<TurtleCommandResult> cir) {
        ServerShip ship = VSGameUtilsKt.getShipManagingPos(world, position);
        Vector3d testPos = new Vector3d((double)position.method_10263() + 0.5, (double)position.method_10264() + 0.5, (double)position.method_10260() + 0.5);
        if (ship != null) {
            class_1923 chunk = world.method_8500(position).method_12004();
            if (!ship.getChunkClaim().contains(chunk.field_9181, chunk.field_9180)) {
                cir.setReturnValue((Object)TurtleCommandResult.failure((String)"Out of ship chunk"));
                return;
            }
            VSGameUtilsKt.toWorldCoordinates((class_1937)world, testPos);
        }
        boolean isAir = VSGameUtilsKt.transformToNearbyShipsAndWorld((class_1937)world, testPos.x, testPos.y, testPos.z, 0.1).stream().map(VectorConversionsMCKt::toMinecraft).map(class_2338::method_49638).filter(pos -> VSGameUtilsKt.getShipManagingPos(world, pos) != ship).map(arg_0 -> ((class_3218)world).method_8320(arg_0)).allMatch(((Predicate<class_2680>)WorldUtil::isEmptyBlock).or(class_4970.class_4971::method_45474));
        if (!isAir) {
            cir.setReturnValue((Object)TurtleCommandResult.failure((String)"Movement obstructed by ship"));
        }
    }
}

