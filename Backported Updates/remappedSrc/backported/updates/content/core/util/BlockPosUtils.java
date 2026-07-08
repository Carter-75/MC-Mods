/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.core.util;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Optional;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;

public class BlockPosUtils {
    public static Iterable<class_2338> betweenClosed(class_238 box) {
        class_2338 min = class_2338.method_49637((double)box.field_1323, (double)box.field_1322, (double)box.field_1321);
        class_2338 max = class_2338.method_49637((double)box.field_1320, (double)box.field_1325, (double)box.field_1324);
        return class_2338.method_10097((class_2338)min, (class_2338)max);
    }

    public static boolean forEachBlockIntersectedBetween(class_243 start, class_243 end, class_238 aabb, BlockStepVisitor visitor) {
        class_243 direction = end.method_1020(start);
        if (direction.method_1027() < (double)class_3532.method_27285((float)0.99999f)) {
            for (class_2338 pos : BlockPosUtils.betweenClosed(aabb)) {
                if (visitor.visit(pos, 0)) continue;
                return false;
            }
            return true;
        }
        LongOpenHashSet visitedPositions = new LongOpenHashSet();
        class_243 minPosition = new class_243(aabb.field_1323, aabb.field_1322, aabb.field_1321);
        class_243 startOffset = minPosition.method_1020(direction);
        int stepCount = BlockPosUtils.addCollisionsAlongTravel((LongSet)visitedPositions, startOffset, minPosition, aabb, visitor);
        if (stepCount < 0) {
            return false;
        }
        for (class_2338 pos : BlockPosUtils.betweenClosed(aabb)) {
            if (visitedPositions.contains(pos.method_10063()) || visitor.visit(pos, stepCount + 1)) continue;
            return false;
        }
        return true;
    }

    private static int addCollisionsAlongTravel(LongSet visitedPositions, class_243 startPos, class_243 endPos, class_238 box, BlockStepVisitor visitor) {
        class_243 travel = endPos.method_1020(startPos);
        int startX = class_3532.method_15357((double)startPos.field_1352);
        int startY = class_3532.method_15357((double)startPos.field_1351);
        int startZ = class_3532.method_15357((double)startPos.field_1350);
        int signX = class_3532.method_17822((double)travel.field_1352);
        int signY = class_3532.method_17822((double)travel.field_1351);
        int signZ = class_3532.method_17822((double)travel.field_1350);
        double invDirX = signX == 0 ? Double.MAX_VALUE : (double)signX / travel.field_1352;
        double invDirY = signY == 0 ? Double.MAX_VALUE : (double)signY / travel.field_1351;
        double invDirZ = signZ == 0 ? Double.MAX_VALUE : (double)signZ / travel.field_1350;
        double targetMaxX = invDirX * (signX > 0 ? 1.0 - class_3532.method_15385((double)startPos.field_1352) : class_3532.method_15385((double)startPos.field_1352));
        double targetMaxY = invDirY * (signY > 0 ? 1.0 - class_3532.method_15385((double)startPos.field_1351) : class_3532.method_15385((double)startPos.field_1351));
        double targetMaxZ = invDirZ * (signZ > 0 ? 1.0 - class_3532.method_15385((double)startPos.field_1350) : class_3532.method_15385((double)startPos.field_1350));
        int stepsTaken = 0;
        class_2338.class_2339 mutable = new class_2338.class_2339();
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
            Optional<class_243> intersectionPoint = BlockPosUtils.clip(startX, startY, startZ, startX + 1, startY + 1, startZ + 1, startPos, endPos);
            if (intersectionPoint.isEmpty()) continue;
            class_243 hitPoint = intersectionPoint.get();
            double x = class_3532.method_15350((double)hitPoint.field_1352, (double)((double)startX + (double)1.0E-5f), (double)((double)startX + 1.0 - (double)1.0E-5f));
            double y = class_3532.method_15350((double)hitPoint.field_1351, (double)((double)startY + (double)1.0E-5f), (double)((double)startY + 1.0 - (double)1.0E-5f));
            double z = class_3532.method_15350((double)hitPoint.field_1350, (double)((double)startZ + (double)1.0E-5f), (double)((double)startZ + 1.0 - (double)1.0E-5f));
            int maxX = class_3532.method_15357((double)(x + box.method_17939()));
            int maxY = class_3532.method_15357((double)(y + box.method_17940()));
            int maxZ = class_3532.method_15357((double)(z + box.method_17941()));
            for (int localX = startX; localX <= maxX; ++localX) {
                for (int localY = startY; localY <= maxY; ++localY) {
                    for (int localZ = startZ; localZ <= maxZ; ++localZ) {
                        if (!visitedPositions.add(class_2338.method_10064((int)localX, (int)localY, (int)localZ)) || visitor.visit((class_2338)mutable.method_10103(localX, localY, localZ), stepsTaken)) continue;
                        return -1;
                    }
                }
            }
        }
        return stepsTaken;
    }

    public static Optional<class_243> clip(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, class_243 start, class_243 end) {
        double[] distances = new double[]{1.0};
        double dirX = end.field_1352 - start.field_1352;
        double dirY = end.field_1351 - start.field_1351;
        double dirZ = end.field_1350 - start.field_1350;
        class_2350 direction = BlockPosUtils.getDirection(minX, minY, minZ, maxX, maxY, maxZ, start, distances, null, dirX, dirY, dirZ);
        if (direction == null) {
            return Optional.empty();
        }
        double distance = distances[0];
        return Optional.of(start.method_1031(distance * dirX, distance * dirY, distance * dirZ));
    }

    @Nullable
    private static class_2350 getDirection(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, class_243 start, double[] minDistance, @Nullable class_2350 prevDirection, double dirX, double dirY, double dirZ) {
        if (dirX > 1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirX, dirY, dirZ, minX, minY, maxY, minZ, maxZ, class_2350.field_11039, start.field_1352, start.field_1351, start.field_1350);
        } else if (dirX < -1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirX, dirY, dirZ, maxX, minY, maxY, minZ, maxZ, class_2350.field_11034, start.field_1352, start.field_1351, start.field_1350);
        }
        if (dirY > 1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirY, dirZ, dirX, minY, minZ, maxZ, minX, maxX, class_2350.field_11033, start.field_1351, start.field_1350, start.field_1352);
        } else if (dirY < -1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirY, dirZ, dirX, maxY, minZ, maxZ, minX, maxX, class_2350.field_11036, start.field_1351, start.field_1350, start.field_1352);
        }
        if (dirZ > 1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirZ, dirX, dirY, minZ, minX, maxX, minY, maxY, class_2350.field_11043, start.field_1350, start.field_1352, start.field_1351);
        } else if (dirZ < -1.0E-7) {
            prevDirection = BlockPosUtils.clipPoint(minDistance, prevDirection, dirZ, dirX, dirY, maxZ, minX, maxX, minY, maxY, class_2350.field_11035, start.field_1350, start.field_1352, start.field_1351);
        }
        return prevDirection;
    }

    @Nullable
    private static class_2350 clipPoint(double[] minDistance, @Nullable class_2350 prevDirection, double mainAxisDir, double secondAxisDir, double thirdAxisDir, double facePosition, double secondAxisMin, double secondAxisMax, double thirdAxisMin, double thirdAxisMax, class_2350 hitDirection, double startMain, double startSecond, double startThird) {
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
        public boolean visit(class_2338 var1, int var2);
    }
}

