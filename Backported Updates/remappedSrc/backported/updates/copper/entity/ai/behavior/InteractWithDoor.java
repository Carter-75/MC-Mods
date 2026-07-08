/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Sets
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  net.minecraft.class_11
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2323
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3481
 *  net.minecraft.class_4095
 *  net.minecraft.class_4140
 *  net.minecraft.class_4208
 *  net.minecraft.class_5321
 *  net.minecraft.class_7893
 *  net.minecraft.class_7898
 *  net.minecraft.class_7906
 *  net.minecraft.class_9
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
import net.minecraft.class_11;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2323;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3481;
import net.minecraft.class_4095;
import net.minecraft.class_4140;
import net.minecraft.class_4208;
import net.minecraft.class_5321;
import net.minecraft.class_7893;
import net.minecraft.class_7898;
import net.minecraft.class_7906;
import net.minecraft.class_9;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;

public class InteractWithDoor {
    private static final int COOLDOWN_BEFORE_RERUNNING_IN_SAME_NODE = 10;
    private static final double SKIP_CLOSING_DOOR_IF_FURTHER_AWAY_THAN = 3.0;
    private static final double MAX_DISTANCE_TO_HOLD_DOOR_OPEN_FOR_OTHER_MOBS = 2.0;

    public static class_7893<class_1309> create() {
        MutableObject lastPathNode = new MutableObject(null);
        MutableInt cooldown = new MutableInt(0);
        return class_7898.method_47224(instance -> instance.group((App)instance.method_47244(class_4140.field_18449), (App)instance.method_47235(class_4140.field_26389), (App)instance.method_47235(class_4140.field_18441)).apply((Applicative)instance, (pathMemory, doorsToCloseMemory, nearestEntitiesMemory) -> (level, entity, gameTime) -> {
            class_11 path = (class_11)instance.method_47243(pathMemory);
            Optional<Set<class_4208>> doorsToClose = instance.method_47233(doorsToCloseMemory);
            if (!path.method_30849() && !path.method_46()) {
                class_2323 door;
                class_2338 nextPos;
                class_2680 nextState;
                if (Objects.equals(lastPathNode.getValue(), path.method_29301())) {
                    cooldown.setValue(10);
                } else if (cooldown.decrementAndGet() > 0) {
                    return false;
                }
                lastPathNode.setValue((Object)path.method_29301());
                class_9 previousNode = path.method_30850();
                class_9 nextNode = path.method_29301();
                class_2338 previousPos = previousNode.method_22879();
                class_2680 previousState = level.method_8320(previousPos);
                if (previousState.method_26164(class_3481.field_15494) && previousState.method_26204() instanceof class_2323) {
                    class_2323 door2 = (class_2323)previousState.method_26204();
                    if (!door2.method_30841(previousState)) {
                        door2.method_10033((class_1297)entity, (class_1937)level, previousState, previousPos, true);
                    }
                    doorsToClose = InteractWithDoor.rememberDoorToClose(doorsToCloseMemory, doorsToClose, level, previousPos);
                }
                if ((nextState = level.method_8320(nextPos = nextNode.method_22879())).method_26164(class_3481.field_15494) && nextState.method_26204() instanceof class_2323 && !(door = (class_2323)nextState.method_26204()).method_30841(nextState)) {
                    door.method_10033((class_1297)entity, (class_1937)level, nextState, nextPos, true);
                    doorsToClose = InteractWithDoor.rememberDoorToClose(doorsToCloseMemory, doorsToClose, level, nextPos);
                }
                doorsToClose.ifPresent(doors -> InteractWithDoor.closeDoorsThatIHaveOpenedOrPassedThrough(level, entity, previousNode, nextNode, doors, instance.method_47233(nearestEntitiesMemory)));
                return true;
            }
            return false;
        }));
    }

    public static void closeDoorsThatIHaveOpenedOrPassedThrough(class_3218 level, class_1309 entity, @Nullable class_9 previous, @Nullable class_9 next, Set<class_4208> doorPositions, Optional<List<class_1309>> nearestLivingEntities) {
        Iterator<class_4208> iterator = doorPositions.iterator();
        while (iterator.hasNext()) {
            class_4208 doorPos = iterator.next();
            class_2338 blockPos = doorPos.comp_2208();
            if (previous != null && previous.method_22879().equals((Object)blockPos) || next != null && next.method_22879().equals((Object)blockPos)) continue;
            if (InteractWithDoor.isDoorTooFarAway(level, entity, doorPos)) {
                iterator.remove();
                continue;
            }
            class_2680 blockState = level.method_8320(blockPos);
            if (!blockState.method_26164(class_3481.field_15494) || !(blockState.method_26204() instanceof class_2323)) {
                iterator.remove();
                continue;
            }
            class_2323 door = (class_2323)blockState.method_26204();
            if (!door.method_30841(blockState)) {
                iterator.remove();
                continue;
            }
            if (InteractWithDoor.areOtherMobsComingThroughDoor(entity, blockPos, nearestLivingEntities)) {
                iterator.remove();
                continue;
            }
            door.method_10033((class_1297)entity, (class_1937)level, blockState, blockPos, false);
            iterator.remove();
        }
    }

    private static boolean areOtherMobsComingThroughDoor(class_1309 entity, class_2338 doorPos, Optional<List<class_1309>> nearestLivingEntities) {
        if (nearestLivingEntities.isEmpty()) {
            return false;
        }
        return nearestLivingEntities.get().stream().filter(mob -> mob.method_5864() == entity.method_5864()).filter(mob -> doorPos.method_19769((class_2374)mob.method_19538(), 2.0)).anyMatch(mob -> InteractWithDoor.isMobComingThroughDoor(mob.method_18868(), doorPos));
    }

    private static boolean isMobComingThroughDoor(class_4095<?> brain, class_2338 doorPos) {
        if (!brain.method_18896(class_4140.field_18449)) {
            return false;
        }
        class_11 path = (class_11)brain.method_18904(class_4140.field_18449).get();
        if (path.method_46()) {
            return false;
        }
        class_9 previousNode = path.method_30850();
        if (previousNode == null) {
            return false;
        }
        class_9 nextNode = path.method_29301();
        return doorPos.equals((Object)previousNode.method_22879()) || doorPos.equals((Object)nextNode.method_22879());
    }

    private static boolean isDoorTooFarAway(class_3218 level, class_1309 entity, class_4208 doorPos) {
        return doorPos.comp_2207() != level.method_27983() || !doorPos.comp_2208().method_19769((class_2374)entity.method_19538(), 3.0);
    }

    private static Optional<Set<class_4208>> rememberDoorToClose(class_7906<?, Set<class_4208>> doorsToCloseMemory, Optional<Set<class_4208>> doorPositions, class_3218 level, class_2338 doorPos) {
        class_4208 globalPos = class_4208.method_19443((class_5321)level.method_27983(), (class_2338)doorPos);
        return Optional.of(doorPositions.map(doors -> {
            doors.add(globalPos);
            return doors;
        }).orElseGet(() -> {
            HashSet newDoors = Sets.newHashSet((Object[])new class_4208[]{globalPos});
            doorsToCloseMemory.method_47249((Object)newDoors);
            return newDoors;
        }));
    }
}

