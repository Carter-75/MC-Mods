/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.core.util;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Optional;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class BlockPosUtils {
    public static Iterable<BlockPos> betweenClosed(Box box) {
        BlockPos min = BlockPos.ofFloored((double)box.minX, (double)box.minY, (double)box.minZ);
        BlockPos max = BlockPos.ofFloored((double)box.maxX, (double)box.maxY, (double)box.maxZ);
        return BlockPos.iterate((BlockPos)min, (BlockPos)max);
    }

    public static boolean forEachBlockIntersectedBetween(Vec3d start, Vec3d end, Box aabb, BlockStepVisitor visitor) {
        Vec3d direction = end.subtract(start);
        if (direction.lengthSquared() < (double)MathHelper.square((float)0.99999f)) {
            for (BlockPos pos : BlockPosUtils.betweenClosed(aabb)) {
                if (visitor.visit(pos, 0)) continue;
                return false;
            }
            return true;
        }
        LongOpenHashSet visitedPositions = new LongOpenHashSet();
        Vec3d minPosition = new Vec3d(aabb.minX, aabb.minY, aabb.minZ);
        Vec3d startOffset = minPosition.subtract(direction);
        int stepCount = BlockPosUtils.addCollisionsAlongTravel((LongSet)visitedPositions, startOffset, minPosition, aabb, visitor);
        if (stepCount < 0) {
            return false;
        }
        for (BlockPos pos : BlockPosUtils.betweenClosed(aabb)) {
            if (visitedPositions.contains(pos.asLong()) || visitor.visit(pos, stepCount + 1)) continue;
            return false;
        }
        return true;
    }

    private static int addCollisionsAlongTravel(LongSet visitedPositions, Vec3d startPos, Vec3d endPos, Box box, BlockStepVisitor visitor) {
        Vec3d travel = endPos.subtract(startPos);
        int startX = MathHelper.floor((double)startPos.x);
        int startY = MathHelper.floor((double)startPos.y);
        int startZ = MathHelper.floor((double)startPos.z);
        int signX = MathHelper.sign((double)travel.x);
        int signY = MathHelper.sign((double)travel.y);
        int signZ = MathHelper.sign((double)travel.z);
        double invDirX = signX == 0 ? Double.MAX_VALUE : (double)signX / travel.x;
        double invDirY = signY == 0 ? Double.MAX_VALUE : (double)signY / travel.y;
        double invDirZ = signZ == 0 ? Double.MAX_VALUE : (double)signZ / travel.z;
        double targetMaxX = invDirX * (signX > 0 ? 1.0 - MathHelper.fractionalPart((double)startPos.x) : MathHelper.fractionalPart((double)startPos.x));
        double targetMaxY = invDirY * (signY > 0 ? 1.0 - MathHelper.fractionalPart((double)startPos.y) : MathHelper.fractionalPart((double)startPos.y));
        double targetMaxZ = invDirZ * (signZ > 0 ? 1.0 - MathHelper.fractionalPart((double)startPos.z) : MathHelper.fractionalPart((double)startPos.z));
        int stepsTaken = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        while (targetMaxX <= 1.0 || targetMaxY <= 1.0 || targetMaxZ <= 1.0) {
            if (targetMaxX < targetMaxY) {
                if (targetMaxX < targetMaxZ) {
                    startX += signX;
                    targetMaxX += invDirX;
                } else {
                    startZ += signZ;
                    targetMaxZ += invDirZ;
                }
            } else if (targetMaxY < targetMaxZ) {
                startY += signY;
                targetMaxY += invDirY;
            } else {
                startZ += signZ;
                targetMaxZ += invDirZ;
            }
            if (stepsTaken++ > 16) break;
            Optional<Vec3d> intersectionPoint = BlockPosUtils.clip(startX, startY, startZ, startX + 1, startY + 1, startZ + 1, startPos, endPos);
            if (intersectionPoint.isEmpty()) continue;
            Vec3d hitPoint = intersectionPoint.get();
            double x = MathHelper.clamp((double)hitPoint.x, (double)((double)startX + (double)1.0E-5f), (double)((double)startX + 1.0 - (double)1.0E-5f));
            double y = MathHelper.clamp((double)hitPoint.y, (double)((double)startY + (double)1.0E-5f), (double)((double)startY + 1.0 - (double)1.0E-5f));
            double z = MathHelper.clamp((double)hitPoint.z, (double)((double)startZ + (double)1.0E-5f), (double)((double)startZ + 1.0 - (double)1.0E-5f));
            int maxX = MathHelper.floor((double)(x + box.getLengthX()));
            int maxY = MathHelper.floor((double)(y + box.getLengthY()));
            int maxZ = MathHelper.floor((double)(z + box.getLengthZ()));
            for (int localX = startX; localX <= maxX; ++localX) {
                for (int localY = startY; localY <= maxY; ++localY) {
                    for (int localZ = startZ; localZ <= maxZ; ++localZ) {
                        if (!visitedPositions.add(BlockPos.asLong((int)localX, (int)localY, (int)localZ)) || visitor.visit((BlockPos)mutable.set(localX, localY, localZ), stepsTaken)) continue;
                        return -1;
                    }
                }
            }
        }
        return stepsTaken;
    }

    public static Optional<Vec3d> clip(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Vec3d start, Vec3d end) {
        double[] distances = new double[]{1.0};
        double dirX = end.x - start.x;
        double dirY = end.y - start.y;
        double dirZ = end.z - start.z;
        Direction direction = BlockPosUtils.getDirection(minX, minY, minZ, maxX, maxY, maxZ, start, distances, null, dirX, dirY, dirZ);
        if (direction == null) {
            return Optional.empty();
        }
        double distance = distances[0];
        return Optional.of(start.add(distance * dirX, distance * dirY, distance * dirZ));
    }

    @Nullable
    private static Direction getDirection(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Vec3d start, double[] minDistance, @Nullable Direction prevDirection, double dirX, double dirY, double dirZ) {
        if (dirX > 1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirX, dirY, dirZ, minX, minY, maxY, minZ, maxZ, Direction.WEST, start.x, start.y, start.z);
        } else if (dirX < -1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirX, dirY, dirZ, maxX, minY, maxY, minZ, maxZ, Direction.EAST, start.x, start.y, start.z);
        }
        if (dirY > 1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirY, dirZ, dirX, minY, minZ, maxZ, minX, maxX, Direction.DOWN, start.y, start.z, start.x);
        } else if (dirY < -1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirY, dirZ, dirX, maxY, minZ, maxZ, minX, maxX, Direction.UP, start.y, start.z, start.x);
        }
        if (dirZ > 1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirZ, dirX, dirY, minZ, minX, maxX, minY, maxY, Direction.NORTH, start.z, start.x, start.y);
        } else if (dirZ < -1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirZ, dirX, dirY, maxZ, minX, maxX, minY, maxY, Direction.SOUTH, start.z, start.x, start.y);
        }
        return prevDirection;
    }

    @Nullable
    private static Direction clipPoint(double[] minDistance, @Nullable Direction prevDirection, double mainAxisDir, double secondAxisDir, double thirdAxisDir, double facePosition, double secondAxisMin, double secondAxisMax, double thirdAxisMin, double thirdAxisMax, Direction hitDirection, double startMain, double startSecond, double startThird) {
        double intersectionTime = (facePosition - startMain) / mainAxisDir;
        double secondAxisPos = startSecond + intersectionTime * secondAxisDir;
        double thirdAxisPos = startThird + intersectionTime * thirdAxisDir;
        if (0.0 < intersectionTime && intersectionTime < minDistance[0] && secondAxisMin - 1.0E-7 < secondAxisPos && secondAxisPos < secondAxisMax + 1.0E-7 && thirdAxisMin - 1.0E-7 < thirdAxisPos && thirdAxisPos < thirdAxisMax + 1.0E-7) {
            minDistance[0] = intersectionTime;
            return hitDirection;
        }
        return prevDirection;
    }

    @FunctionalInterface
    public static interface BlockStepVisitor {
        public boolean visit(BlockPos var1, int var2);
    }
}

