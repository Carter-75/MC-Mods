/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.world.BlockView
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.fluid.FluidState
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.core.util;

import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.fluid.FluidState;
import org.jetbrains.annotations.Nullable;

public class CollisionUtils {
    public static boolean intersects(Box box, BlockPos pos) {
        return box.intersects((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 1), (double)(pos.getZ() + 1));
    }

    public static boolean collidedWithFluid(LivingEntity entity, FluidState state, BlockPos pos, Vec3d origin, Vec3d target) {
        Box box = CollisionUtils.getFluidAABB(state, (BlockView)entity.getWorld(), pos);
        return box != null && CollisionUtils.collidedWithShapeMovingFrom(entity, origin, target, List.of(box));
    }

    public static boolean collidedWithShapeMovingFrom(LivingEntity entity, Vec3d origin, Vec3d target, List<Box> boxes) {
        Box box = entity.getBoundingBox().offset(origin.subtract(entity.getPos()));
        Vec3d distance = target.subtract(origin);
        return CollisionUtils.collidedAlongVector(box, distance, boxes);
    }

    @Nullable
    public static Box getFluidAABB(FluidState state, BlockView level, BlockPos pos) {
        if (state.isEmpty()) {
            return null;
        }
        float fluidHeight = state.getHeight(level, pos);
        return new Box((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX() + 1.0, (double)((float)pos.getY() + fluidHeight), (double)pos.getZ() + 1.0);
    }

    public static boolean collidedAlongVector(Box entityBox, Vec3d origin, List<Box> obstacles) {
        Vec3d center = entityBox.getCenter();
        Vec3d distance = center.add(origin);
        for (Box obstacle : obstacles) {
            Box box = obstacle.expand(entityBox.getLengthX() * 0.5, entityBox.getLengthY() * 0.5, entityBox.getLengthZ() * 0.5);
            if (box.contains(distance) || box.contains(center)) {
                return true;
            }
            if (!box.raycast(center, distance).isPresent()) continue;
            return true;
        }
        return false;
    }
}

