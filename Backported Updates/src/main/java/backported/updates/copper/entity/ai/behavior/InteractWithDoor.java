/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Sets
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  net.minecraft.entity.ai.pathing.Path
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.world.World
 *  net.minecraft.block.DoorBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Position
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.util.math.GlobalPos
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.entity.ai.brain.task.Task
 *  net.minecraft.entity.ai.brain.task.TaskTriggerer
 *  net.minecraft.entity.ai.brain.MemoryQueryResult
 *  net.minecraft.entity.ai.pathing.PathNode
 *  org.apache.commons.lang3.mutable.MutableInt
 *  org.apache.commons.lang3.mutable.MutableObject
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.entity.ai.behavior;

import com.google.common.collect.Sets;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.block.DoorBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.registry.RegistryKey;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.ai.brain.task.TaskTriggerer;
import net.minecraft.entity.ai.brain.MemoryQueryResult;
import net.minecraft.entity.ai.pathing.PathNode;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;

public class InteractWithDoor {
    private static final int COOLDOWN_BEFORE_RERUNNING_IN_SAME_NODE = 10;
    private static final double SKIP_CLOSING_DOOR_IF_FURTHER_AWAY_THAN = 3.0;
    private static final double MAX_DISTANCE_TO_HOLD_DOOR_OPEN_FOR_OTHER_MOBS = 2.0;

    public static Task<LivingEntity> create() {
        MutableObject lastPathNode = new MutableObject(null);
        MutableInt cooldown = new MutableInt(0);
        return TaskTriggerer.task(instance -> instance.group(instance.queryMemoryValue(MemoryModuleType.PATH), instance.queryMemoryOptional(MemoryModuleType.DOORS_TO_CLOSE), instance.queryMemoryOptional(MemoryModuleType.MOBS)).apply(instance, (pathMemory, doorsToCloseMemory, nearestEntitiesMemory) -> (level, entity, gameTime) -> {
            Path path = (Path)instance.getValue(pathMemory);
            Optional<Set<GlobalPos>> doorsToClose = instance.getOptionalValue(doorsToCloseMemory);
            if (!path.isStart() && !path.isFinished()) {
                DoorBlock door;
                BlockPos nextPos;
                BlockState nextState;
                if (Objects.equals(lastPathNode.getValue(), path.getCurrentNode())) {
                    cooldown.setValue(10);
                } else if (cooldown.decrementAndGet() > 0) {
                    return false;
                }
                lastPathNode.setValue(path.getCurrentNode());
                PathNode previousNode = path.getLastNode();
                PathNode nextNode = path.getCurrentNode();
                BlockPos previousPos = previousNode.getBlockPos();
                BlockState previousState = level.getBlockState(previousPos);
                if (previousState.isIn(BlockTags.WOODEN_DOORS) && previousState.getBlock() instanceof DoorBlock) {
                    DoorBlock door2 = (DoorBlock)previousState.getBlock();
                    if (!door2.isOpen(previousState)) {
                        door2.setOpen((Entity)entity, (World)level, previousState, previousPos, true);
                    }
                    doorsToClose = InteractWithDoor.rememberDoorToClose(doorsToCloseMemory, doorsToClose, level, previousPos);
                }
                if ((nextState = level.getBlockState(nextPos = nextNode.getBlockPos())).isIn(BlockTags.WOODEN_DOORS) && nextState.getBlock() instanceof DoorBlock && !(door = (DoorBlock)nextState.getBlock()).isOpen(nextState)) {
                    door.setOpen((Entity)entity, (World)level, nextState, nextPos, true);
                    doorsToClose = InteractWithDoor.rememberDoorToClose(doorsToCloseMemory, doorsToClose, level, nextPos);
                }
                doorsToClose.ifPresent(doors -> InteractWithDoor.closeDoorsThatIHaveOpenedOrPassedThrough(level, entity, previousNode, nextNode, doors, instance.getOptionalValue(nearestEntitiesMemory)));
                return true;
            }
            return false;
        }));
    }

    public static void closeDoorsThatIHaveOpenedOrPassedThrough(ServerWorld level, LivingEntity entity, @Nullable PathNode previous, @Nullable PathNode next, Set<GlobalPos> doorPositions, Optional<List<LivingEntity>> nearestLivingEntities) {
        Iterator<GlobalPos> iterator = doorPositions.iterator();
        while (iterator.hasNext()) {
            GlobalPos doorPos = iterator.next();
            BlockPos blockPos = doorPos.pos();
            if (previous != null && previous.getBlockPos().equals(blockPos) || next != null && next.getBlockPos().equals(blockPos)) continue;
            if (InteractWithDoor.isDoorTooFarAway(level, entity, doorPos)) {
                iterator.remove();
                continue;
            }
            BlockState blockState = level.getBlockState(blockPos);
            if (!blockState.isIn(BlockTags.WOODEN_DOORS) || !(blockState.getBlock() instanceof DoorBlock)) {
                iterator.remove();
                continue;
            }
            DoorBlock door = (DoorBlock)blockState.getBlock();
            if (!door.isOpen(blockState)) {
                iterator.remove();
                continue;
            }
            if (InteractWithDoor.areOtherMobsComingThroughDoor(entity, blockPos, nearestLivingEntities)) {
                iterator.remove();
                continue;
            }
            door.setOpen((Entity)entity, (World)level, blockState, blockPos, false);
            iterator.remove();
        }
    }

    private static boolean areOtherMobsComingThroughDoor(LivingEntity entity, BlockPos doorPos, Optional<List<LivingEntity>> nearestLivingEntities) {
        if (nearestLivingEntities.isEmpty()) {
            return false;
        }
        return nearestLivingEntities.get().stream().filter(mob -> mob.getType() == entity.getType()).filter(mob -> doorPos.isWithinDistance((Position)mob.getPos(), 2.0)).anyMatch(mob -> InteractWithDoor.isMobComingThroughDoor(mob.getBrain(), doorPos));
    }

    private static boolean isMobComingThroughDoor(Brain<?> brain, BlockPos doorPos) {
        if (!brain.hasMemoryModule(MemoryModuleType.PATH)) {
            return false;
        }
        Path path = (Path)brain.getOptionalRegisteredMemory(MemoryModuleType.PATH).get();
        if (path.isFinished()) {
            return false;
        }
        PathNode previousNode = path.getLastNode();
        if (previousNode == null) {
            return false;
        }
        PathNode nextNode = path.getCurrentNode();
        return doorPos.equals(previousNode.getBlockPos()) || doorPos.equals(nextNode.getBlockPos());
    }

    private static boolean isDoorTooFarAway(ServerWorld level, LivingEntity entity, GlobalPos doorPos) {
        return doorPos.dimension() != level.getRegistryKey() || !doorPos.pos().isWithinDistance((Position)entity.getPos(), 3.0);
    }

    private static Optional<Set<GlobalPos>> rememberDoorToClose(MemoryQueryResult<?, Set<GlobalPos>> doorsToCloseMemory, Optional<Set<GlobalPos>> doorPositions, ServerWorld level, BlockPos doorPos) {
        GlobalPos globalPos = GlobalPos.create(level.getRegistryKey(), (BlockPos)doorPos);
        return Optional.of(doorPositions.map(doors -> {
            doors.add(globalPos);
            return doors;
        }).orElseGet(() -> {
            HashSet newDoors = Sets.newHashSet((Object[])new GlobalPos[]{globalPos});
            doorsToCloseMemory.remember(newDoors);
            return newDoors;
        }));
    }
}

