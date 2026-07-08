/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.hit.BlockHitResult
 */
package backported.updates.copper.block.shelf;

import java.util.Optional;
import java.util.OptionalInt;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.hit.BlockHitResult;

public interface SelectableSlotContainer {
    public int getRows();

    public int getColumns();

    default public OptionalInt getHitSlot(BlockHitResult hitResult, Direction direction) {
        return SelectableSlotContainer.getRelativeHitCoordinatesForBlockFace(hitResult, direction).map(coords -> {
            int row = SelectableSlotContainer.getSection(1.0f - coords.y, this.getRows());
            int col = SelectableSlotContainer.getSection(coords.x, this.getColumns());
            return OptionalInt.of(col + row * this.getColumns());
        }).orElseGet(OptionalInt::empty);
    }

    private static Optional<Vec2f> getRelativeHitCoordinatesForBlockFace(BlockHitResult hitResult, Direction direction) {
        Direction hitDirection = hitResult.getSide();
        if (direction != hitDirection) {
            return Optional.empty();
        }
        Vec3d location = hitResult.getPos();
        double x = location.getX() - (double)hitResult.getBlockPos().getX();
        double y = location.getY() - (double)hitResult.getBlockPos().getY();
        double z = location.getZ() - (double)hitResult.getBlockPos().getZ();
        return switch (direction) {
            default -> throw new MatchException(null, null);
            case Direction.NORTH -> Optional.of(new Vec2f((float)(1.0 - x), (float)y));
            case Direction.SOUTH -> Optional.of(new Vec2f((float)x, (float)y));
            case Direction.WEST -> Optional.of(new Vec2f((float)z, (float)y));
            case Direction.EAST -> Optional.of(new Vec2f((float)(1.0 - z), (float)y));
            case Direction.DOWN, Direction.UP -> Optional.empty();
        };
    }

    private static int getSection(float pos, int count) {
        float scaledPos = pos * 16.0f;
        float sectionSize = 16.0f / (float)count;
        return MathHelper.clamp((int)MathHelper.floor((float)(scaledPos / sectionSize)), (int)0, (int)(count - 1));
    }
}

