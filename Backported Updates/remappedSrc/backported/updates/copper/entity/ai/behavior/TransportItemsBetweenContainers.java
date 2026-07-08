/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  net.minecraft.class_11
 *  net.minecraft.class_1263
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1408
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1923
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_2818
 *  net.minecraft.class_3218
 *  net.minecraft.class_3719
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_4097
 *  net.minecraft.class_4099
 *  net.minecraft.class_4140
 *  net.minecraft.class_4141
 *  net.minecraft.class_4208
 *  net.minecraft.class_4215
 *  net.minecraft.class_5321
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.entity.ai.behavior;

import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.compat.ModCompat;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.ai.navigation.CopperGolemNavigation;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_11;
import net.minecraft.class_1263;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1408;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1923;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_2818;
import net.minecraft.class_3218;
import net.minecraft.class_3719;
import net.minecraft.class_3959;
import net.minecraft.class_4097;
import net.minecraft.class_4099;
import net.minecraft.class_4140;
import net.minecraft.class_4141;
import net.minecraft.class_4208;
import net.minecraft.class_4215;
import net.minecraft.class_5321;
import org.jetbrains.annotations.Nullable;

public class TransportItemsBetweenContainers
extends class_4097<class_1314> {
    public static final int TARGET_INTERACTION_TIME = 60;
    private static final int VISITED_POSITIONS_MEMORY_TIME = 6000;
    private static final int TRANSPORTED_ITEM_MAX_STACK_SIZE = 16;
    private static final int MAX_VISITED_POSITIONS = 10;
    private static final int MAX_UNREACHABLE_POSITIONS = 50;
    private static final int PASSENGER_MOB_TARGET_SEARCH_DISTANCE = 1;
    private static final int IDLE_COOLDOWN = 140;
    private static final double CLOSE_ENOUGH_TO_START_QUEUING_DISTANCE = 3.0;
    private static final double CLOSE_ENOUGH_TO_START_INTERACTING_WITH_TARGET_DISTANCE = 0.5;
    private static final double CLOSE_ENOUGH_TO_START_INTERACTING_WITH_TARGET_PATH_END_DISTANCE = 1.0;
    private static final double CLOSE_ENOUGH_TO_CONTINUE_INTERACTING_WITH_TARGET = 2.0;
    private final float speedModifier;
    private final int horizontalSearchDistance;
    private final int verticalSearchDistance;
    private final Predicate<class_2680> sourceBlockType;
    private final Predicate<class_2680> destinationBlockType;
    private final Predicate<TransportItemTarget> shouldQueueForTarget;
    private final Consumer<class_1314> onStartTravelling;
    private final Map<ContainerInteractionState, OnTargetReachedInteraction> onTargetInteractionActions;
    @Nullable
    private TransportItemTarget target = null;
    private TransportItemState state;
    @Nullable
    private ContainerInteractionState interactionState;
    private int ticksSinceReachingTarget;

    public TransportItemsBetweenContainers(float speedModifier, Predicate<class_2680> sourceBlockType, Predicate<class_2680> destinationBlockType, int horizontalSearchDistance, int verticalSearchDistance, Map<ContainerInteractionState, OnTargetReachedInteraction> onTargetInteractionActions, Consumer<class_1314> onStartTravelling, Predicate<TransportItemTarget> shouldQueueForTarget) {
        super((Map)ImmutableMap.of(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), (Object)class_4141.field_18458, ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get(), (Object)class_4141.field_18458, ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object)class_4141.field_18457, (Object)class_4140.field_39408, (Object)class_4141.field_18457));
        this.speedModifier = speedModifier;
        this.sourceBlockType = sourceBlockType;
        this.destinationBlockType = destinationBlockType;
        this.horizontalSearchDistance = horizontalSearchDistance;
        this.verticalSearchDistance = verticalSearchDistance;
        this.onStartTravelling = onStartTravelling;
        this.shouldQueueForTarget = shouldQueueForTarget;
        this.onTargetInteractionActions = onTargetInteractionActions;
        this.state = TransportItemState.TRAVELLING;
    }

    protected void start(class_3218 level, class_1314 mob, long gameTime) {
        class_1408 class_14082 = mob.method_5942();
        if (class_14082 instanceof CopperGolemNavigation) {
            CopperGolemNavigation copperGolemNavigation = (CopperGolemNavigation)class_14082;
            copperGolemNavigation.setCanPathToTargetsBelowSurface(true);
        }
    }

    protected boolean checkExtraStartConditions(class_3218 level, class_1314 mob) {
        if (mob.method_18868().method_18904(ModMemoryTypes.IS_PRESSING_BUTTON.get()).orElse(false).booleanValue()) {
            return false;
        }
        return !mob.method_60953();
    }

    protected boolean canStillUse(class_3218 level, class_1314 mob, long gameTime) {
        return mob.method_18868().method_18904(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get()).isEmpty() && mob.method_18868().method_18904(class_4140.field_39408).isEmpty() && !mob.method_60953();
    }

    protected boolean method_18915(long gameTime) {
        return false;
    }

    protected void tick(class_3218 level, class_1314 mob, long gameTime) {
        boolean flag = this.updateInvalidTarget(level, mob);
        if (this.target == null) {
            this.stop(level, mob, gameTime);
        } else if (!flag) {
            if (this.state.equals((Object)TransportItemState.QUEUING)) {
                this.onQueuingForTarget(this.target, (class_1937)level, mob);
            }
            if (this.state.equals((Object)TransportItemState.TRAVELLING)) {
                this.onTravelToTarget(this.target, (class_1937)level, mob);
            }
            if (this.state.equals((Object)TransportItemState.INTERACTING)) {
                this.onReachedTarget(this.target, (class_1937)level, mob);
            }
        }
    }

    private boolean updateInvalidTarget(class_3218 level, class_1314 mob) {
        if (!this.hasValidTarget((class_1937)level, mob)) {
            this.stopTargetingCurrentTarget(mob);
            Optional<TransportItemTarget> optional = this.getTransportTarget(level, mob);
            if (optional.isPresent()) {
                this.target = optional.get();
                this.onStartTravelling(mob);
                this.setVisitedBlockPos(mob, (class_1937)level, this.target.pos);
                return true;
            }
            this.enterCooldownAfterNoMatchingTargetFound(mob);
            return true;
        }
        return false;
    }

    private void onQueuingForTarget(TransportItemTarget target, class_1937 level, class_1314 mob) {
        if (!this.isAnotherMobInteractingWithTarget(target, level)) {
            this.resumeTravelling(mob);
        }
    }

    protected void onTravelToTarget(TransportItemTarget target, class_1937 level, class_1314 mob) {
        if (this.isWithinTargetDistance(3.0, target, level, mob, this.getCenterPos(mob)) && this.isAnotherMobInteractingWithTarget(target, level)) {
            this.startQueuing(mob);
        } else if (this.isWithinTargetDistance(TransportItemsBetweenContainers.getInteractionRange(mob), target, level, mob, this.getCenterPos(mob))) {
            this.startOnReachedTargetInteraction(target, mob);
        } else {
            this.walkTowardsTarget(mob);
        }
    }

    private class_243 getCenterPos(class_1314 mob) {
        return this.setMiddleYPosition(mob, mob.method_19538());
    }

    protected void onReachedTarget(TransportItemTarget target, class_1937 level, class_1314 mob) {
        if (!this.isWithinTargetDistance(2.0, target, level, mob, this.getCenterPos(mob))) {
            this.onStartTravelling(mob);
        } else {
            ++this.ticksSinceReachingTarget;
            this.onTargetInteraction(target, mob);
            if (this.ticksSinceReachingTarget >= 60) {
                this.doReachedTargetInteraction(mob, target.container, this::pickUpItems, (mobParam, containerParam) -> this.stopTargetingCurrentTarget(mob), this::putDownItem, (mobParam, containerParam) -> this.stopTargetingCurrentTarget(mob));
                this.onStartTravelling(mob);
            }
        }
    }

    private void startQueuing(class_1314 mob) {
        this.stopInPlace(mob);
        this.setTransportingState(TransportItemState.QUEUING);
    }

    private void resumeTravelling(class_1314 mob) {
        this.setTransportingState(TransportItemState.TRAVELLING);
        this.walkTowardsTarget(mob);
    }

    private void walkTowardsTarget(class_1314 mob) {
        if (this.target != null) {
            class_4215.method_24561((class_1309)mob, (class_2338)this.target.pos, (float)this.speedModifier, (int)0);
        }
    }

    private void startOnReachedTargetInteraction(TransportItemTarget target, class_1314 mob) {
        this.doReachedTargetInteraction(mob, target.container, this.onReachedInteraction(ContainerInteractionState.PICKUP_ITEM), this.onReachedInteraction(ContainerInteractionState.PICKUP_NO_ITEM), this.onReachedInteraction(ContainerInteractionState.PLACE_ITEM), this.onReachedInteraction(ContainerInteractionState.PLACE_NO_ITEM));
        this.setTransportingState(TransportItemState.INTERACTING);
    }

    private void onStartTravelling(class_1314 mob) {
        this.onStartTravelling.accept(mob);
        this.setTransportingState(TransportItemState.TRAVELLING);
        this.interactionState = null;
        this.ticksSinceReachingTarget = 0;
    }

    private BiConsumer<class_1314, class_1263> onReachedInteraction(ContainerInteractionState interactionState) {
        return (mob, container) -> this.setInteractionState(interactionState);
    }

    private void setTransportingState(TransportItemState transportingState) {
        this.state = transportingState;
    }

    private void setInteractionState(ContainerInteractionState interactionState) {
        this.interactionState = interactionState;
    }

    private void onTargetInteraction(TransportItemTarget target, class_1314 mob) {
        mob.method_18868().method_18878(class_4140.field_18446, (Object)new class_4099(target.pos));
        this.stopInPlace(mob);
        if (this.interactionState != null) {
            Optional.ofNullable(this.onTargetInteractionActions.get((Object)this.interactionState)).ifPresent(action -> action.accept(mob, target, this.ticksSinceReachingTarget));
        }
    }

    private void doReachedTargetInteraction(class_1314 mob, class_1263 container, BiConsumer<class_1314, class_1263> pickupItem, BiConsumer<class_1314, class_1263> pickupNoItem, BiConsumer<class_1314, class_1263> placeItem, BiConsumer<class_1314, class_1263> placeNoItem) {
        if (TransportItemsBetweenContainers.isPickingUpItems(mob)) {
            if (TransportItemsBetweenContainers.matchesGettingItemsRequirement(container)) {
                pickupItem.accept(mob, container);
            } else {
                pickupNoItem.accept(mob, container);
            }
        } else if (TransportItemsBetweenContainers.matchesLeavingItemsRequirement(mob, container)) {
            placeItem.accept(mob, container);
        } else {
            placeNoItem.accept(mob, container);
        }
    }

    private Optional<TransportItemTarget> getTransportTarget(class_3218 level, class_1314 mob) {
        class_238 aabb = this.getTargetSearchArea(mob);
        Set<class_4208> set = TransportItemsBetweenContainers.getVisitedPositions(mob);
        Set<class_4208> set1 = TransportItemsBetweenContainers.getUnreachablePositions(mob);
        List list = class_1923.method_19280((class_1923)new class_1923(mob.method_24515()), (int)(Math.floorDiv(this.getHorizontalSearchDistance(mob), 16) + 1)).toList();
        ArrayList<Object> allBlockEntities = new ArrayList<Object>();
        for (class_1923 chunkpos : list) {
            class_2818 levelchunk = level.method_14178().method_21730(chunkpos.field_9181, chunkpos.field_9180);
            if (levelchunk == null) continue;
            allBlockEntities.addAll(levelchunk.method_12214().values());
        }
        allBlockEntities.sort(Comparator.comparingInt(be -> be.method_11016().hashCode()).reversed());
        TransportItemTarget transportitemsbetweencontainers$transportitemtarget = null;
        double d0 = 3.4028234663852886E38;
        for (class_2586 class_25862 : allBlockEntities) {
            TransportItemTarget transportitemsbetweencontainers$transportitemtarget1;
            double d1;
            class_2680 blockState = level.method_8320(class_25862.method_11016());
            boolean isVanillaContainer = class_25862 instanceof class_2595 || class_25862 instanceof class_3719;
            boolean isModContainer = ModCompat.isValidModContainer(blockState);
            if (!isVanillaContainer && !isModContainer || !((d1 = class_25862.method_11016().method_19770((class_2374)mob.method_19538())) < d0) || (transportitemsbetweencontainers$transportitemtarget1 = this.isTargetValidToPick(mob, (class_1937)level, class_25862, set, set1, aabb)) == null) continue;
            transportitemsbetweencontainers$transportitemtarget = transportitemsbetweencontainers$transportitemtarget1;
            d0 = d1;
        }
        return transportitemsbetweencontainers$transportitemtarget == null ? Optional.empty() : Optional.of(transportitemsbetweencontainers$transportitemtarget);
    }

    @Nullable
    private TransportItemTarget isTargetValidToPick(class_1314 mob, class_1937 level, class_2586 blockEntity, Set<class_4208> visited, Set<class_4208> unreachable, class_238 searchArea) {
        class_2338 blockpos = blockEntity.method_11016();
        boolean flag = searchArea.method_1008((double)blockpos.method_10263(), (double)blockpos.method_10264(), (double)blockpos.method_10260());
        if (!flag) {
            return null;
        }
        TransportItemTarget transportitemsbetweencontainers$transportitemtarget = TransportItemTarget.tryCreatePossibleTarget(blockEntity, level);
        if (transportitemsbetweencontainers$transportitemtarget == null) {
            return null;
        }
        boolean flag1 = this.isWantedBlock(mob, transportitemsbetweencontainers$transportitemtarget.state) && !this.isPositionAlreadyVisited(visited, unreachable, transportitemsbetweencontainers$transportitemtarget, level) && !this.isContainerLocked(transportitemsbetweencontainers$transportitemtarget);
        return flag1 ? transportitemsbetweencontainers$transportitemtarget : null;
    }

    private boolean isContainerLocked(TransportItemTarget target) {
        return false;
    }

    private boolean hasValidTarget(class_1937 level, class_1314 mob) {
        boolean flag;
        boolean bl = flag = this.target != null && this.isWantedBlock(mob, this.target.state) && this.targetHasNotChanged(level, this.target);
        if (flag && !this.isTargetBlocked(level, this.target)) {
            if (!this.state.equals((Object)TransportItemState.TRAVELLING)) {
                return true;
            }
            if (this.hasValidTravellingPath(level, this.target, mob)) {
                return true;
            }
            this.markVisitedBlockPosAsUnreachable(mob, level, this.target.pos);
        }
        return false;
    }

    private boolean hasValidTravellingPath(class_1937 level, TransportItemTarget target, class_1314 mob) {
        class_11 path = mob.method_5942().method_6345() == null ? mob.method_5942().method_6348(target.pos, 0) : mob.method_5942().method_6345();
        class_243 vec3 = this.getPositionToReachTargetFrom(path, mob);
        boolean flag = this.isWithinTargetDistance(TransportItemsBetweenContainers.getInteractionRange(mob), target, level, mob, vec3);
        boolean flag1 = path == null && !flag;
        return flag1 || this.targetIsReachableFromPosition(level, flag, vec3, target, mob);
    }

    private class_243 getPositionToReachTargetFrom(@Nullable class_11 path, class_1314 mob) {
        boolean flag = path == null || path.method_45() == null;
        class_243 vec3 = flag ? mob.method_19538() : class_243.method_24955((class_2382)path.method_45().method_22879());
        return this.setMiddleYPosition(mob, vec3);
    }

    private class_243 setMiddleYPosition(class_1314 mob, class_243 pos) {
        return pos.method_1031(0.0, mob.method_5829().method_17940() / 2.0, 0.0);
    }

    private boolean isTargetBlocked(class_1937 level, TransportItemTarget target) {
        return class_2281.method_9756((class_1936)level, (class_2338)target.pos);
    }

    private boolean targetHasNotChanged(class_1937 level, TransportItemTarget target) {
        return target.blockEntity.equals(level.method_8321(target.pos));
    }

    private Stream<TransportItemTarget> getConnectedTargets(TransportItemTarget target, class_1937 level) {
        if (!target.state.method_28498((class_2769)class_2281.field_10770)) {
            return Stream.of(target);
        }
        if (target.state.method_11654((class_2769)class_2281.field_10770) != class_2745.field_12569) {
            class_2338 connectedPos = this.getConnectedChestPos(target.pos, target.state);
            TransportItemTarget transportitemsbetweencontainers$transportitemtarget = TransportItemTarget.tryCreatePossibleTarget(connectedPos, level);
            return transportitemsbetweencontainers$transportitemtarget != null ? Stream.of(target, transportitemsbetweencontainers$transportitemtarget) : Stream.of(target);
        }
        return Stream.of(target);
    }

    private class_2338 getConnectedChestPos(class_2338 pos, class_2680 state) {
        class_2350 facing = (class_2350)state.method_11654((class_2769)class_2741.field_12481);
        class_2745 chestType = (class_2745)state.method_11654((class_2769)class_2281.field_10770);
        class_2350 connectedDir = chestType == class_2745.field_12574 ? facing.method_10170() : facing.method_10160();
        return pos.method_10093(connectedDir);
    }

    private class_238 getTargetSearchArea(class_1314 mob) {
        int i = this.getHorizontalSearchDistance(mob);
        return new class_238(mob.method_24515()).method_1009((double)i, (double)this.getVerticalSearchDistance(mob), (double)i);
    }

    private int getHorizontalSearchDistance(class_1314 mob) {
        return mob.method_5765() ? 1 : this.horizontalSearchDistance;
    }

    private int getVerticalSearchDistance(class_1314 mob) {
        return mob.method_5765() ? 1 : this.verticalSearchDistance;
    }

    private static Set<class_4208> getVisitedPositions(class_1314 mob) {
        return mob.method_18868().method_18904(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get()).orElse(Set.of());
    }

    private static Set<class_4208> getUnreachablePositions(class_1314 mob) {
        return mob.method_18868().method_18904(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get()).orElse(Set.of());
    }

    private boolean isPositionAlreadyVisited(Set<class_4208> visited, Set<class_4208> unreachable, TransportItemTarget target, class_1937 level) {
        return this.getConnectedTargets(target, level).map(t -> class_4208.method_19443((class_5321)level.method_27983(), (class_2338)t.pos)).anyMatch(globalPos -> visited.contains(globalPos) || unreachable.contains(globalPos));
    }

    private static boolean hasFinishedPath(class_1314 mob) {
        return mob.method_5942().method_6345() != null && mob.method_5942().method_6345().method_46();
    }

    protected void setVisitedBlockPos(class_1314 mob, class_1937 level, class_2338 pos) {
        HashSet<class_4208> set = new HashSet<class_4208>(TransportItemsBetweenContainers.getVisitedPositions(mob));
        set.add(class_4208.method_19443((class_5321)level.method_27983(), (class_2338)pos));
        if (set.size() > 10) {
            this.enterCooldownAfterNoMatchingTargetFound(mob);
        } else {
            mob.method_18868().method_24525(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), set, 6000L);
        }
    }

    protected void markVisitedBlockPosAsUnreachable(class_1314 mob, class_1937 level, class_2338 pos) {
        HashSet<class_4208> set = new HashSet<class_4208>(TransportItemsBetweenContainers.getVisitedPositions(mob));
        set.remove(class_4208.method_19443((class_5321)level.method_27983(), (class_2338)pos));
        HashSet<class_4208> set1 = new HashSet<class_4208>(TransportItemsBetweenContainers.getUnreachablePositions(mob));
        set1.add(class_4208.method_19443((class_5321)level.method_27983(), (class_2338)pos));
        if (set1.size() > 50) {
            this.enterCooldownAfterNoMatchingTargetFound(mob);
        } else {
            mob.method_18868().method_24525(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), set, 6000L);
            mob.method_18868().method_24525(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get(), set1, 6000L);
        }
    }

    private boolean isWantedBlock(class_1314 mob, class_2680 state) {
        return TransportItemsBetweenContainers.isPickingUpItems(mob) ? this.sourceBlockType.test(state) : this.destinationBlockType.test(state);
    }

    private static double getInteractionRange(class_1314 mob) {
        return TransportItemsBetweenContainers.hasFinishedPath(mob) ? 1.0 : 0.5;
    }

    private boolean isWithinTargetDistance(double distance, TransportItemTarget target, class_1937 level, class_1314 mob, class_243 center) {
        class_238 aabb = mob.method_5829();
        class_238 aabb1 = class_238.method_30048((class_243)center, (double)aabb.method_17939(), (double)aabb.method_17940(), (double)aabb.method_17941());
        return target.state.method_26220((class_1922)level, target.pos).method_1107().method_1009(distance, 0.5, distance).method_996(target.pos).method_994(aabb1);
    }

    private boolean targetIsReachableFromPosition(class_1937 level, boolean withinDistance, class_243 targetPos, TransportItemTarget target, class_1314 mob) {
        return withinDistance && this.canSeeAnyTargetSide(target, level, mob, targetPos);
    }

    private boolean canSeeAnyTargetSide(TransportItemTarget target, class_1937 level, class_1314 mob, class_243 pos) {
        class_243 vec3 = target.pos.method_46558();
        return class_2350.method_42013().map(direction -> vec3.method_1031(0.5 * (double)direction.method_10148(), 0.5 * (double)direction.method_10164(), 0.5 * (double)direction.method_10165())).map(targetVec -> level.method_17742(new class_3959(pos, targetVec, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)mob))).anyMatch(hitResult -> hitResult.method_17783() == class_239.class_240.field_1332 && hitResult.method_17777().equals((Object)target.pos));
    }

    private boolean isAnotherMobInteractingWithTarget(TransportItemTarget target, class_1937 level) {
        return this.getConnectedTargets(target, level).anyMatch(this.shouldQueueForTarget);
    }

    private static boolean isPickingUpItems(class_1314 mob) {
        return mob.method_6047().method_7960();
    }

    private static boolean matchesGettingItemsRequirement(class_1263 container) {
        return !container.method_5442();
    }

    private static boolean matchesLeavingItemsRequirement(class_1314 mob, class_1263 container) {
        return container.method_5442() || TransportItemsBetweenContainers.hasItemMatchingHandItem(mob, container);
    }

    private static boolean hasItemMatchingHandItem(class_1314 mob, class_1263 container) {
        class_1799 itemstack = mob.method_6047();
        for (int i = 0; i < container.method_5439(); ++i) {
            class_1799 itemstack1 = container.method_5438(i);
            if (!class_1799.method_7984((class_1799)itemstack1, (class_1799)itemstack)) continue;
            return true;
        }
        return false;
    }

    private void pickUpItems(class_1314 mob, class_1263 container) {
        mob.method_5673(class_1304.field_6173, TransportItemsBetweenContainers.pickupItemFromContainer(container));
        mob.method_25939(class_1304.field_6173);
        container.method_5431();
        this.clearMemoriesAfterMatchingTargetFound(mob);
    }

    private void putDownItem(class_1314 mob, class_1263 container) {
        class_1799 itemstack = TransportItemsBetweenContainers.addItemsToContainer(mob, container);
        container.method_5431();
        mob.method_5673(class_1304.field_6173, itemstack);
        if (itemstack.method_7960()) {
            this.clearMemoriesAfterMatchingTargetFound(mob);
        } else {
            this.stopTargetingCurrentTarget(mob);
        }
    }

    private static class_1799 pickupItemFromContainer(class_1263 container) {
        for (int i = 0; i < container.method_5439(); ++i) {
            class_1799 itemstack = container.method_5438(i);
            if (itemstack.method_7960()) continue;
            int j = Math.min(itemstack.method_7947(), CommonConfig.golemTransportStackSize());
            return container.method_5434(i, j);
        }
        return class_1799.field_8037;
    }

    private static class_1799 addItemsToContainer(class_1314 mob, class_1263 container) {
        class_1799 itemstack = mob.method_6047();
        for (int i = 0; i < container.method_5439(); ++i) {
            class_1799 itemstack1 = container.method_5438(i);
            if (itemstack1.method_7960()) {
                container.method_5447(i, itemstack);
                return class_1799.field_8037;
            }
            if (!class_1799.method_31577((class_1799)itemstack1, (class_1799)itemstack) || itemstack1.method_7947() >= itemstack1.method_7914()) continue;
            int j = itemstack1.method_7914() - itemstack1.method_7947();
            int k = Math.min(j, itemstack.method_7947());
            itemstack1.method_7939(itemstack1.method_7947() + k);
            itemstack.method_7939(itemstack.method_7947() - j);
            container.method_5447(i, itemstack1);
            if (!itemstack.method_7960()) continue;
            return class_1799.field_8037;
        }
        return itemstack;
    }

    protected void stopTargetingCurrentTarget(class_1314 mob) {
        this.ticksSinceReachingTarget = 0;
        this.target = null;
        mob.method_5942().method_6340();
        mob.method_18868().method_18875(class_4140.field_18445);
    }

    protected void clearMemoriesAfterMatchingTargetFound(class_1314 mob) {
        this.stopTargetingCurrentTarget(mob);
        mob.method_18868().method_18875(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get());
        mob.method_18868().method_18875(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get());
    }

    private void enterCooldownAfterNoMatchingTargetFound(class_1314 mob) {
        this.stopTargetingCurrentTarget(mob);
        mob.method_18868().method_18878(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object)140);
        mob.method_18868().method_18875(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get());
        mob.method_18868().method_18875(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get());
        mob.method_18868().method_18878(ModMemoryTypes.LAST_CONTAINER_EMPTY.get(), (Object)mob.method_37908().method_8510());
    }

    protected void stop(class_3218 level, class_1314 mob, long gameTime) {
        this.onStartTravelling(mob);
        class_1408 class_14082 = mob.method_5942();
        if (class_14082 instanceof CopperGolemNavigation) {
            CopperGolemNavigation copperGolemNavigation = (CopperGolemNavigation)class_14082;
            copperGolemNavigation.setCanPathToTargetsBelowSurface(false);
        }
    }

    private void stopInPlace(class_1314 mob) {
        mob.method_5942().method_6340();
        mob.method_5938(0.0f);
        mob.method_5976(0.0f);
        mob.method_6125(0.0f);
        mob.method_18800(0.0, mob.method_18798().field_1351, 0.0);
    }

    public record TransportItemTarget(class_2338 pos, class_1263 container, class_2586 blockEntity, class_2680 state) {
        @Nullable
        public static TransportItemTarget tryCreatePossibleTarget(class_2586 blockEntity, class_1937 level) {
            class_2338 blockpos = blockEntity.method_11016();
            class_2680 blockstate = blockEntity.method_11010();
            class_1263 container = TransportItemTarget.getBlockEntityContainer(blockEntity, blockstate, level, blockpos);
            return container != null ? new TransportItemTarget(blockpos, container, blockEntity, blockstate) : null;
        }

        @Nullable
        public static TransportItemTarget tryCreatePossibleTarget(class_2338 pos, class_1937 level) {
            class_2586 blockentity = level.method_8321(pos);
            return blockentity == null ? null : TransportItemTarget.tryCreatePossibleTarget(blockentity, level);
        }

        @Nullable
        private static class_1263 getBlockEntityContainer(class_2586 blockEntity, class_2680 state, class_1937 level, class_2338 pos) {
            class_2248 class_22482 = state.method_26204();
            if (class_22482 instanceof class_2281) {
                class_2281 chestblock = (class_2281)class_22482;
                return class_2281.method_17458((class_2281)chestblock, (class_2680)state, (class_1937)level, (class_2338)pos, (boolean)false);
            }
            if (blockEntity instanceof class_1263) {
                class_1263 container = (class_1263)blockEntity;
                return container;
            }
            class_1263 modContainer = ModCompat.getModContainer(blockEntity, level, pos);
            if (modContainer != null) {
                return modContainer;
            }
            return null;
        }
    }

    public static enum TransportItemState {
        TRAVELLING,
        QUEUING,
        INTERACTING;

    }

    public static enum ContainerInteractionState {
        PICKUP_ITEM,
        PICKUP_NO_ITEM,
        PLACE_ITEM,
        PLACE_NO_ITEM;

    }

    @FunctionalInterface
    public static interface OnTargetReachedInteraction {
        public void accept(class_1314 var1, TransportItemTarget var2, Integer var3);
    }
}

