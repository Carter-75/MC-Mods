/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  net.minecraft.entity.ai.pathing.Path
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.PathAwareEntity
 *  net.minecraft.entity.ai.pathing.EntityNavigation
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.property.Properties
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.Property
 *  net.minecraft.world.chunk.WorldChunk
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.block.entity.BarrelBlockEntity
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.entity.ai.brain.task.MultiTickTask
 *  net.minecraft.entity.ai.brain.BlockPosLookTarget
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.MemoryModuleState
 *  net.minecraft.util.math.GlobalPos
 *  net.minecraft.entity.ai.brain.task.LookTargetUtil
 *  net.minecraft.registry.RegistryKey
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
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.block.enums.ChestType;
import net.minecraft.state.property.Property;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.world.RaycastContext;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.ai.brain.BlockPosLookTarget;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

public class TransportItemsBetweenContainers
extends MultiTickTask<PathAwareEntity> {
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
    private final Predicate<BlockState> sourceBlockType;
    private final Predicate<BlockState> destinationBlockType;
    private final Predicate<TransportItemTarget> shouldQueueForTarget;
    private final Consumer<PathAwareEntity> onStartTravelling;
    private final Map<ContainerInteractionState, OnTargetReachedInteraction> onTargetInteractionActions;
    @Nullable
    private TransportItemTarget target = null;
    private TransportItemState state;
    @Nullable
    private ContainerInteractionState interactionState;
    private int ticksSinceReachingTarget;

    public TransportItemsBetweenContainers(float speedModifier, Predicate<BlockState> sourceBlockType, Predicate<BlockState> destinationBlockType, int horizontalSearchDistance, int verticalSearchDistance, Map<ContainerInteractionState, OnTargetReachedInteraction> onTargetInteractionActions, Consumer<PathAwareEntity> onStartTravelling, Predicate<TransportItemTarget> shouldQueueForTarget) {
        super(ImmutableMap.of(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), MemoryModuleState.REGISTERED, ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get(), MemoryModuleState.REGISTERED, ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), MemoryModuleState.VALUE_ABSENT, MemoryModuleType.IS_PANICKING, MemoryModuleState.VALUE_ABSENT));
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

    protected void start(ServerWorld level, PathAwareEntity mob, long gameTime) {
        EntityNavigation class_14082 = mob.getNavigation();
        if (class_14082 instanceof CopperGolemNavigation) {
            CopperGolemNavigation copperGolemNavigation = (CopperGolemNavigation)class_14082;
            copperGolemNavigation.setCanPathToTargetsBelowSurface(true);
        }
    }

    protected boolean checkExtraStartConditions(ServerWorld level, PathAwareEntity mob) {
        if (mob.getBrain().getOptionalRegisteredMemory(ModMemoryTypes.IS_PRESSING_BUTTON.get()).orElse(false).booleanValue()) {
            return false;
        }
        return !mob.isLeashed();
    }

    protected boolean canStillUse(ServerWorld level, PathAwareEntity mob, long gameTime) {
        return mob.getBrain().getOptionalRegisteredMemory(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get()).isEmpty() && mob.getBrain().getOptionalRegisteredMemory(MemoryModuleType.IS_PANICKING).isEmpty() && !mob.isLeashed();
    }

    protected boolean isTimeLimitExceeded(long gameTime) {
        return false;
    }

    protected void keepRunning(ServerWorld level, PathAwareEntity mob, long gameTime) {
        boolean flag = this.updateInvalidTarget(level, mob);
        if (this.target == null) {
            this.stop(level, mob, gameTime);
        } else if (!flag) {
            if (this.state.equals(TransportItemState.QUEUING)) {
                this.onQueuingForTarget(this.target, (World)level, mob);
            }
            if (this.state.equals(TransportItemState.TRAVELLING)) {
                this.onTravelToTarget(this.target, (World)level, mob);
            }
            if (this.state.equals(TransportItemState.INTERACTING)) {
                this.onReachedTarget(this.target, (World)level, mob);
            }
        }
    }

    private boolean updateInvalidTarget(ServerWorld level, PathAwareEntity mob) {
        if (!this.hasValidTarget((World)level, mob)) {
            this.stopTargetingCurrentTarget(mob);
            Optional<TransportItemTarget> optional = this.getTransportTarget(level, mob);
            if (optional.isPresent()) {
                this.target = optional.get();
                this.onStartTravelling(mob);
                this.setVisitedBlockPos(mob, (World)level, this.target.pos);
                return true;
            }
            this.enterCooldownAfterNoMatchingTargetFound(mob);
            return true;
        }
        return false;
    }

    private void onQueuingForTarget(TransportItemTarget target, World level, PathAwareEntity mob) {
        if (!this.isAnotherMobInteractingWithTarget(target, level)) {
            this.resumeTravelling(mob);
        }
    }

    protected void onTravelToTarget(TransportItemTarget target, World level, PathAwareEntity mob) {
        if (this.isWithinTargetDistance(3.0, target, level, mob, this.getCenterPos(mob)) && this.isAnotherMobInteractingWithTarget(target, level)) {
            this.startQueuing(mob);
        } else if (this.isWithinTargetDistance(TransportItemsBetweenContainers.getInteractionRange(mob), target, level, mob, this.getCenterPos(mob))) {
            this.startOnReachedTargetInteraction(target, mob);
        } else {
            this.walkTowardsTarget(mob);
        }
    }

    private Vec3d getCenterPos(PathAwareEntity mob) {
        return this.setMiddleYPosition(mob, mob.getPos());
    }

    protected void onReachedTarget(TransportItemTarget target, World level, PathAwareEntity mob) {
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

    private void startQueuing(PathAwareEntity mob) {
        this.stopInPlace(mob);
        this.setTransportingState(TransportItemState.QUEUING);
    }

    private void resumeTravelling(PathAwareEntity mob) {
        this.setTransportingState(TransportItemState.TRAVELLING);
        this.walkTowardsTarget(mob);
    }

    private void walkTowardsTarget(PathAwareEntity mob) {
        if (this.target != null) {
            LookTargetUtil.walkTowards((LivingEntity)mob, (BlockPos)this.target.pos, (float)this.speedModifier, (int)0);
        }
    }

    private void startOnReachedTargetInteraction(TransportItemTarget target, PathAwareEntity mob) {
        this.doReachedTargetInteraction(mob, target.container, this.onReachedInteraction(ContainerInteractionState.PICKUP_ITEM), this.onReachedInteraction(ContainerInteractionState.PICKUP_NO_ITEM), this.onReachedInteraction(ContainerInteractionState.PLACE_ITEM), this.onReachedInteraction(ContainerInteractionState.PLACE_NO_ITEM));
        this.setTransportingState(TransportItemState.INTERACTING);
    }

    private void onStartTravelling(PathAwareEntity mob) {
        this.onStartTravelling.accept(mob);
        this.setTransportingState(TransportItemState.TRAVELLING);
        this.interactionState = null;
        this.ticksSinceReachingTarget = 0;
    }

    private BiConsumer<PathAwareEntity, Inventory> onReachedInteraction(ContainerInteractionState interactionState) {
        return (mob, container) -> this.setInteractionState(interactionState);
    }

    private void setTransportingState(TransportItemState transportingState) {
        this.state = transportingState;
    }

    private void setInteractionState(ContainerInteractionState interactionState) {
        this.interactionState = interactionState;
    }

    private void onTargetInteraction(TransportItemTarget target, PathAwareEntity mob) {
        mob.getBrain().remember(MemoryModuleType.LOOK_TARGET, new BlockPosLookTarget(target.pos));
        this.stopInPlace(mob);
        if (this.interactionState != null) {
            Optional.ofNullable(this.onTargetInteractionActions.get(this.interactionState)).ifPresent(action -> action.accept(mob, target, this.ticksSinceReachingTarget));
        }
    }

    private void doReachedTargetInteraction(PathAwareEntity mob, Inventory container, BiConsumer<PathAwareEntity, Inventory> pickupItem, BiConsumer<PathAwareEntity, Inventory> pickupNoItem, BiConsumer<PathAwareEntity, Inventory> placeItem, BiConsumer<PathAwareEntity, Inventory> placeNoItem) {
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

    private Optional<TransportItemTarget> getTransportTarget(ServerWorld level, PathAwareEntity mob) {
        Box aabb = this.getTargetSearchArea(mob);
        Set<GlobalPos> set = TransportItemsBetweenContainers.getVisitedPositions(mob);
        Set<GlobalPos> set1 = TransportItemsBetweenContainers.getUnreachablePositions(mob);
        List<ChunkPos> list = ChunkPos.stream((ChunkPos)new ChunkPos(mob.getBlockPos()), (int)(Math.floorDiv(this.getHorizontalSearchDistance(mob), 16) + 1)).toList();
        ArrayList<BlockEntity> allBlockEntities = new ArrayList<BlockEntity>();
        for (ChunkPos chunkpos : list) {
            WorldChunk levelchunk = level.getChunkManager().getWorldChunk(chunkpos.x, chunkpos.z);
            if (levelchunk == null) continue;
            allBlockEntities.addAll(levelchunk.getBlockEntities().values());
        }
        allBlockEntities.sort(Comparator.comparingInt((BlockEntity be) -> be.getPos().hashCode()).reversed());
        TransportItemTarget transportitemsbetweencontainers$transportitemtarget = null;
        double d0 = 3.4028234663852886E38;
        for (BlockEntity class_25862 : allBlockEntities) {
            TransportItemTarget transportitemsbetweencontainers$transportitemtarget1;
            double d1;
            BlockState blockState = level.getBlockState(class_25862.getPos());
            boolean isVanillaContainer = class_25862 instanceof ChestBlockEntity || class_25862 instanceof BarrelBlockEntity;
            boolean isModContainer = ModCompat.isValidModContainer(blockState);
            if (!isVanillaContainer && !isModContainer || !((d1 = class_25862.getPos().getSquaredDistance((Position)mob.getPos())) < d0) || (transportitemsbetweencontainers$transportitemtarget1 = this.isTargetValidToPick(mob, (World)level, class_25862, set, set1, aabb)) == null) continue;
            transportitemsbetweencontainers$transportitemtarget = transportitemsbetweencontainers$transportitemtarget1;
            d0 = d1;
        }
        return transportitemsbetweencontainers$transportitemtarget == null ? Optional.empty() : Optional.of(transportitemsbetweencontainers$transportitemtarget);
    }

    @Nullable
    private TransportItemTarget isTargetValidToPick(PathAwareEntity mob, World level, BlockEntity blockEntity, Set<GlobalPos> visited, Set<GlobalPos> unreachable, Box searchArea) {
        BlockPos blockpos = blockEntity.getPos();
        boolean flag = searchArea.contains((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
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

    private boolean hasValidTarget(World level, PathAwareEntity mob) {
        boolean flag;
        boolean bl = flag = this.target != null && this.isWantedBlock(mob, this.target.state) && this.targetHasNotChanged(level, this.target);
        if (flag && !this.isTargetBlocked(level, this.target)) {
            if (!this.state.equals(TransportItemState.TRAVELLING)) {
                return true;
            }
            if (this.hasValidTravellingPath(level, this.target, mob)) {
                return true;
            }
            this.markVisitedBlockPosAsUnreachable(mob, level, this.target.pos);
        }
        return false;
    }

    private boolean hasValidTravellingPath(World level, TransportItemTarget target, PathAwareEntity mob) {
        Path path = mob.getNavigation().getCurrentPath() == null ? mob.getNavigation().findPathTo(target.pos, 0) : mob.getNavigation().getCurrentPath();
        Vec3d vec3 = this.getPositionToReachTargetFrom(path, mob);
        boolean flag = this.isWithinTargetDistance(TransportItemsBetweenContainers.getInteractionRange(mob), target, level, mob, vec3);
        boolean flag1 = path == null && !flag;
        return flag1 || this.targetIsReachableFromPosition(level, flag, vec3, target, mob);
    }

    private Vec3d getPositionToReachTargetFrom(@Nullable Path path, PathAwareEntity mob) {
        boolean flag = path == null || path.getEnd() == null;
        Vec3d vec3 = flag ? mob.getPos() : Vec3d.ofBottomCenter((Vec3i)path.getEnd().getBlockPos());
        return this.setMiddleYPosition(mob, vec3);
    }

    private Vec3d setMiddleYPosition(PathAwareEntity mob, Vec3d pos) {
        return pos.add(0.0, mob.getBoundingBox().getLengthY() / 2.0, 0.0);
    }

    private boolean isTargetBlocked(World level, TransportItemTarget target) {
        return ChestBlock.isChestBlocked((WorldAccess)level, (BlockPos)target.pos);
    }

    private boolean targetHasNotChanged(World level, TransportItemTarget target) {
        return target.blockEntity.equals(level.getBlockEntity(target.pos));
    }

    private Stream<TransportItemTarget> getConnectedTargets(TransportItemTarget target, World level) {
        if (!target.state.contains(ChestBlock.CHEST_TYPE)) {
            return Stream.of(target);
        }
        if (target.state.get(ChestBlock.CHEST_TYPE) != ChestType.SINGLE) {
            BlockPos connectedPos = this.getConnectedChestPos(target.pos, target.state);
            TransportItemTarget transportitemsbetweencontainers$transportitemtarget = TransportItemTarget.tryCreatePossibleTarget(connectedPos, level);
            return transportitemsbetweencontainers$transportitemtarget != null ? Stream.of(target, transportitemsbetweencontainers$transportitemtarget) : Stream.of(target);
        }
        return Stream.of(target);
    }

    private BlockPos getConnectedChestPos(BlockPos pos, BlockState state) {
        Direction facing = (Direction)state.get(Properties.HORIZONTAL_FACING);
        ChestType chestType = (ChestType)state.get(ChestBlock.CHEST_TYPE);
        Direction connectedDir = chestType == ChestType.LEFT ? facing.rotateYClockwise() : facing.rotateYCounterclockwise();
        return pos.offset(connectedDir);
    }

    private Box getTargetSearchArea(PathAwareEntity mob) {
        int i = this.getHorizontalSearchDistance(mob);
        return new Box(mob.getBlockPos()).expand((double)i, (double)this.getVerticalSearchDistance(mob), (double)i);
    }

    private int getHorizontalSearchDistance(PathAwareEntity mob) {
        return mob.hasVehicle() ? 1 : this.horizontalSearchDistance;
    }

    private int getVerticalSearchDistance(PathAwareEntity mob) {
        return mob.hasVehicle() ? 1 : this.verticalSearchDistance;
    }

    private static Set<GlobalPos> getVisitedPositions(PathAwareEntity mob) {
        return mob.getBrain().getOptionalRegisteredMemory(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get()).orElse(Set.of());
    }

    private static Set<GlobalPos> getUnreachablePositions(PathAwareEntity mob) {
        return mob.getBrain().getOptionalRegisteredMemory(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get()).orElse(Set.of());
    }

    private boolean isPositionAlreadyVisited(Set<GlobalPos> visited, Set<GlobalPos> unreachable, TransportItemTarget target, World level) {
        return this.getConnectedTargets(target, level).map(t -> GlobalPos.create(level.getRegistryKey(), (BlockPos)t.pos)).anyMatch(globalPos -> visited.contains(globalPos) || unreachable.contains(globalPos));
    }

    private static boolean hasFinishedPath(PathAwareEntity mob) {
        return mob.getNavigation().getCurrentPath() != null && mob.getNavigation().getCurrentPath().isFinished();
    }

    protected void setVisitedBlockPos(PathAwareEntity mob, World level, BlockPos pos) {
        HashSet<GlobalPos> set = new HashSet<GlobalPos>(TransportItemsBetweenContainers.getVisitedPositions(mob));
        set.add(GlobalPos.create(level.getRegistryKey(), (BlockPos)pos));
        if (set.size() > 10) {
            this.enterCooldownAfterNoMatchingTargetFound(mob);
        } else {
            mob.getBrain().remember(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), set, 6000L);
        }
    }

    protected void markVisitedBlockPosAsUnreachable(PathAwareEntity mob, World level, BlockPos pos) {
        HashSet<GlobalPos> set = new HashSet<GlobalPos>(TransportItemsBetweenContainers.getVisitedPositions(mob));
        set.remove(GlobalPos.create(level.getRegistryKey(), (BlockPos)pos));
        HashSet<GlobalPos> set1 = new HashSet<GlobalPos>(TransportItemsBetweenContainers.getUnreachablePositions(mob));
        set1.add(GlobalPos.create(level.getRegistryKey(), (BlockPos)pos));
        if (set1.size() > 50) {
            this.enterCooldownAfterNoMatchingTargetFound(mob);
        } else {
            mob.getBrain().remember(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), set, 6000L);
            mob.getBrain().remember(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get(), set1, 6000L);
        }
    }

    private boolean isWantedBlock(PathAwareEntity mob, BlockState state) {
        return TransportItemsBetweenContainers.isPickingUpItems(mob) ? this.sourceBlockType.test(state) : this.destinationBlockType.test(state);
    }

    private static double getInteractionRange(PathAwareEntity mob) {
        return TransportItemsBetweenContainers.hasFinishedPath(mob) ? 1.0 : 0.5;
    }

    private boolean isWithinTargetDistance(double distance, TransportItemTarget target, World level, PathAwareEntity mob, Vec3d center) {
        Box aabb = mob.getBoundingBox();
        Box aabb1 = Box.of((Vec3d)center, (double)aabb.getLengthX(), (double)aabb.getLengthY(), (double)aabb.getLengthZ());
        return target.state.getCollisionShape((BlockView)level, target.pos).getBoundingBox().expand(distance, 0.5, distance).offset(target.pos).intersects(aabb1);
    }

    private boolean targetIsReachableFromPosition(World level, boolean withinDistance, Vec3d targetPos, TransportItemTarget target, PathAwareEntity mob) {
        return withinDistance && this.canSeeAnyTargetSide(target, level, mob, targetPos);
    }

    private boolean canSeeAnyTargetSide(TransportItemTarget target, World level, PathAwareEntity mob, Vec3d pos) {
        Vec3d vec3 = target.pos.toCenterPos();
        return Direction.stream().map(direction -> vec3.add(0.5 * (double)direction.getOffsetX(), 0.5 * (double)direction.getOffsetY(), 0.5 * (double)direction.getOffsetZ())).map(targetVec -> level.raycast(new RaycastContext(pos, targetVec, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)mob))).anyMatch(hitResult -> hitResult.getType() == HitResult.Type.BLOCK && hitResult.getBlockPos().equals(target.pos));
    }

    private boolean isAnotherMobInteractingWithTarget(TransportItemTarget target, World level) {
        return this.getConnectedTargets(target, level).anyMatch(this.shouldQueueForTarget);
    }

    private static boolean isPickingUpItems(PathAwareEntity mob) {
        return mob.getMainHandStack().isEmpty();
    }

    private static boolean matchesGettingItemsRequirement(Inventory container) {
        return !container.isEmpty();
    }

    private static boolean matchesLeavingItemsRequirement(PathAwareEntity mob, Inventory container) {
        return container.isEmpty() || TransportItemsBetweenContainers.hasItemMatchingHandItem(mob, container);
    }

    private static boolean hasItemMatchingHandItem(PathAwareEntity mob, Inventory container) {
        ItemStack itemstack = mob.getMainHandStack();
        for (int i = 0; i < container.size(); ++i) {
            ItemStack itemstack1 = container.getStack(i);
            if (!ItemStack.areItemsEqual((ItemStack)itemstack1, (ItemStack)itemstack)) continue;
            return true;
        }
        return false;
    }

    private void pickUpItems(PathAwareEntity mob, Inventory container) {
        mob.equipStack(EquipmentSlot.MAINHAND, TransportItemsBetweenContainers.pickupItemFromContainer(container));
        mob.updateDropChances(EquipmentSlot.MAINHAND);
        container.markDirty();
        this.clearMemoriesAfterMatchingTargetFound(mob);
    }

    private void putDownItem(PathAwareEntity mob, Inventory container) {
        ItemStack itemstack = TransportItemsBetweenContainers.addItemsToContainer(mob, container);
        container.markDirty();
        mob.equipStack(EquipmentSlot.MAINHAND, itemstack);
        if (itemstack.isEmpty()) {
            this.clearMemoriesAfterMatchingTargetFound(mob);
        } else {
            this.stopTargetingCurrentTarget(mob);
        }
    }

    private static ItemStack pickupItemFromContainer(Inventory container) {
        for (int i = 0; i < container.size(); ++i) {
            ItemStack itemstack = container.getStack(i);
            if (itemstack.isEmpty()) continue;
            int j = Math.min(itemstack.getCount(), CommonConfig.golemTransportStackSize());
            return container.removeStack(i, j);
        }
        return ItemStack.EMPTY;
    }

    private static ItemStack addItemsToContainer(PathAwareEntity mob, Inventory container) {
        ItemStack itemstack = mob.getMainHandStack();
        for (int i = 0; i < container.size(); ++i) {
            ItemStack itemstack1 = container.getStack(i);
            if (itemstack1.isEmpty()) {
                container.setStack(i, itemstack);
                return ItemStack.EMPTY;
            }
            if (!ItemStack.areItemsAndComponentsEqual((ItemStack)itemstack1, (ItemStack)itemstack) || itemstack1.getCount() >= itemstack1.getMaxCount()) continue;
            int j = itemstack1.getMaxCount() - itemstack1.getCount();
            int k = Math.min(j, itemstack.getCount());
            itemstack1.setCount(itemstack1.getCount() + k);
            itemstack.setCount(itemstack.getCount() - j);
            container.setStack(i, itemstack1);
            if (!itemstack.isEmpty()) continue;
            return ItemStack.EMPTY;
        }
        return itemstack;
    }

    protected void stopTargetingCurrentTarget(PathAwareEntity mob) {
        this.ticksSinceReachingTarget = 0;
        this.target = null;
        mob.getNavigation().stop();
        mob.getBrain().forget(MemoryModuleType.WALK_TARGET);
    }

    protected void clearMemoriesAfterMatchingTargetFound(PathAwareEntity mob) {
        this.stopTargetingCurrentTarget(mob);
        mob.getBrain().forget(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get());
        mob.getBrain().forget(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get());
    }

    private void enterCooldownAfterNoMatchingTargetFound(PathAwareEntity mob) {
        this.stopTargetingCurrentTarget(mob);
        mob.getBrain().remember(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), 140);
        mob.getBrain().forget(ModMemoryTypes.VISITED_BLOCK_POSITIONS.get());
        mob.getBrain().forget(ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get());
        mob.getBrain().remember(ModMemoryTypes.LAST_CONTAINER_EMPTY.get(), mob.getWorld().getTime());
    }

    protected void finishRunning(ServerWorld level, PathAwareEntity mob, long gameTime) {
        this.onStartTravelling(mob);
        EntityNavigation class_14082 = mob.getNavigation();
        if (class_14082 instanceof CopperGolemNavigation) {
            CopperGolemNavigation copperGolemNavigation = (CopperGolemNavigation)class_14082;
            copperGolemNavigation.setCanPathToTargetsBelowSurface(false);
        }
    }

    private void stopInPlace(PathAwareEntity mob) {
        mob.getNavigation().stop();
        mob.setSidewaysSpeed(0.0f);
        mob.setUpwardSpeed(0.0f);
        mob.setMovementSpeed(0.0f);
        mob.setVelocity(0.0, mob.getVelocity().y, 0.0);
    }

    public record TransportItemTarget(BlockPos pos, Inventory container, BlockEntity blockEntity, BlockState state) {
        @Nullable
        public static TransportItemTarget tryCreatePossibleTarget(BlockEntity blockEntity, World level) {
            BlockPos blockpos = blockEntity.getPos();
            BlockState blockstate = blockEntity.getCachedState();
            Inventory container = TransportItemTarget.getBlockEntityContainer(blockEntity, blockstate, level, blockpos);
            return container != null ? new TransportItemTarget(blockpos, container, blockEntity, blockstate) : null;
        }

        @Nullable
        public static TransportItemTarget tryCreatePossibleTarget(BlockPos pos, World level) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            return blockentity == null ? null : TransportItemTarget.tryCreatePossibleTarget(blockentity, level);
        }

        @Nullable
        private static Inventory getBlockEntityContainer(BlockEntity blockEntity, BlockState state, World level, BlockPos pos) {
            Block class_22482 = state.getBlock();
            if (class_22482 instanceof ChestBlock) {
                ChestBlock chestblock = (ChestBlock)class_22482;
                return ChestBlock.getInventory((ChestBlock)chestblock, state, (World)level, (BlockPos)pos, (boolean)false);
            }
            if (blockEntity instanceof Inventory) {
                Inventory container = (Inventory)blockEntity;
                return container;
            }
            Inventory modContainer = ModCompat.getModContainer(blockEntity, level, pos);
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
        public void accept(PathAwareEntity var1, TransportItemTarget var2, Integer var3);
    }
}

