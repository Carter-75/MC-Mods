/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.PathAwareEntity
 *  net.minecraft.world.World
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.block.BarrelBlock
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.Brain$Profile
 *  net.minecraft.entity.ai.brain.task.WaitTask
 *  net.minecraft.entity.ai.brain.task.LookAroundTask
 *  net.minecraft.entity.ai.brain.task.MoveToTargetTask
 *  net.minecraft.entity.ai.brain.task.RandomTask
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.MemoryModuleState
 *  net.minecraft.entity.ai.brain.sensor.Sensor
 *  net.minecraft.entity.ai.brain.sensor.SensorType
 *  net.minecraft.entity.ai.brain.Activity
 *  net.minecraft.entity.ai.brain.task.StrollTask
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.entity.ai.brain.task.TemptationCooldownTask
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 *  net.minecraft.entity.ai.brain.task.FleeTask
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.ai.brain.task.LookAtMobWithIntervalTask
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.entity.ai;

import backported.updates.copper.Constants;
import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.ModSounds;
import backported.updates.copper.ModTags;
import backported.updates.copper.compat.ModCompat;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemState;
import backported.updates.copper.entity.ai.behavior.InteractWithDoor;
import backported.updates.copper.entity.ai.behavior.PressRandomCopperButton;
import backported.updates.copper.entity.ai.behavior.TransportItemsBetweenContainers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.block.BarrelBlock;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.WaitTask;
import net.minecraft.entity.ai.brain.task.LookAroundTask;
import net.minecraft.entity.ai.brain.task.MoveToTargetTask;
import net.minecraft.entity.ai.brain.task.RandomTask;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.task.StrollTask;
import net.minecraft.world.event.GameEvent;
import net.minecraft.entity.ai.brain.task.TemptationCooldownTask;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.entity.ai.brain.task.FleeTask;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.ai.brain.task.LookAtMobWithIntervalTask;
import org.jetbrains.annotations.Nullable;

public class CopperGolemAi {
    private static final ImmutableList<SensorType<? extends Sensor<? super CopperGolemEntity>>> SENSOR_TYPES = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.HURT_BY);
    private static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.PATH, MemoryModuleType.WALK_TARGET, MemoryModuleType.LOOK_TARGET, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.IS_PANICKING, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.MOBS, MemoryModuleType.DOORS_TO_CLOSE, ModMemoryTypes.GAZE_COOLDOWN_TICKS.get(), ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get(), ModMemoryTypes.IS_PRESSING_BUTTON.get(), ModMemoryTypes.LAST_CONTAINER_EMPTY.get());

    public static Brain.Profile<CopperGolemEntity> brainProvider() {
        return Brain.createProfile(MEMORY_TYPES, SENSOR_TYPES);
    }

    public static Brain<CopperGolemEntity> makeBrain(Brain<CopperGolemEntity> brain) {
        CopperGolemAi.initCoreActivity(brain);
        CopperGolemAi.initIdleActivity(brain);
        brain.setCoreActivities((Set)ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.resetPossibleActivities();
        return brain;
    }

    private static void initCoreActivity(Brain<CopperGolemEntity> brain) {
        brain.setTaskList(Activity.CORE, ImmutableList.of(Pair.of(0, new FleeTask(1.5f)), Pair.of(0, new LookAroundTask(45, 90)), Pair.of(0, new MoveToTargetTask()), Pair.of(0, InteractWithDoor.create()), Pair.of(0, new TemptationCooldownTask(ModMemoryTypes.GAZE_COOLDOWN_TICKS.get())), Pair.of(0, new TemptationCooldownTask(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get()))));
    }

    private static void initIdleActivity(Brain<CopperGolemEntity> brain) {
        ImmutableList.Builder behaviorsBuilder = ImmutableList.builder();
        behaviorsBuilder.add(Pair.of(0, (new TransportItemsBetweenContainers(1.0f, state -> state.isIn(ModTags.Blocks.COPPER_CHESTS), state -> CopperGolemAi.isValidDestinationContainer(state), 32, 8, CopperGolemAi.getTargetReachedInteractions(), CopperGolemAi.onTravelling(), CopperGolemAi.shouldQueueForTarget()))));
        if (CommonConfig.golemPressesButtons()) {
            behaviorsBuilder.add(Pair.of(1, (new PressRandomCopperButton(1.0f, 16, 4, 150))));
        }
        behaviorsBuilder.add(Pair.of(2, LookAtMobWithIntervalTask.follow((EntityType)EntityType.PLAYER, (float)6.0f, (UniformIntProvider)UniformIntProvider.create((int)40, (int)80))));
        behaviorsBuilder.add(Pair.of(3, new RandomTask(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryModuleState.VALUE_ABSENT, ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), MemoryModuleState.VALUE_PRESENT), ImmutableList.of(Pair.of(StrollTask.create((float)1.0f, (int)2, (int)2), 1), Pair.of(new WaitTask(30, 60), 1)))));
        brain.setTaskList(Activity.IDLE, behaviorsBuilder.build());
    }

    private static Map<TransportItemsBetweenContainers.ContainerInteractionState, TransportItemsBetweenContainers.OnTargetReachedInteraction> getTargetReachedInteractions() {
        return Map.of(TransportItemsBetweenContainers.ContainerInteractionState.PICKUP_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.GETTING_ITEM, ModSounds.COPPER_GOLEM_ITEM_GET.get()), TransportItemsBetweenContainers.ContainerInteractionState.PICKUP_NO_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.GETTING_NO_ITEM, ModSounds.COPPER_GOLEM_ITEM_NO_GET.get()), TransportItemsBetweenContainers.ContainerInteractionState.PLACE_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.DROPPING_ITEM, ModSounds.COPPER_GOLEM_ITEM_DROP.get()), TransportItemsBetweenContainers.ContainerInteractionState.PLACE_NO_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.DROPPING_NO_ITEM, ModSounds.COPPER_GOLEM_ITEM_NO_DROP.get()));
    }

    private static TransportItemsBetweenContainers.OnTargetReachedInteraction onReachedTargetInteraction(CopperGolemState state, @Nullable SoundEvent sound) {
        return (mob, target, tick) -> {
            if (mob instanceof CopperGolemEntity) {
                CopperGolemEntity copperGolem = (CopperGolemEntity)mob;
                if (tick == 1) {
                    CopperGolemAi.playChestSound(copperGolem, target.pos(), true);
                    copperGolem.setOpenedChestPos(target.pos());
                    copperGolem.setState(state);
                }
                if (tick == 9 && sound != null) {
                    copperGolem.playSound(sound, 1.0f, 1.0f);
                }
                if (tick == 60) {
                    CopperGolemAi.playChestSound(copperGolem, target.pos(), false);
                    copperGolem.clearOpenedChestPos();
                }
            }
        };
    }

    private static void playChestSound(CopperGolemEntity golem, BlockPos pos, boolean open) {
        BlockState blockState;
        World level = golem.getWorld();
        if (ModCompat.handleChestOpen(level, pos, blockState = level.getBlockState(pos), open)) {
            level.emitGameEvent((Entity)golem, (RegistryEntry)(open ? GameEvent.CONTAINER_OPEN : GameEvent.CONTAINER_CLOSE), pos);
            return;
        }
        SoundEvent soundEvent = blockState.isIn(ModTags.Blocks.COPPER_CHESTS) ? (open ? ModSounds.COPPER_CHEST_OPEN.get() : ModSounds.COPPER_CHEST_CLOSE.get()) : (blockState.getBlock() instanceof BarrelBlock ? (open ? SoundEvents.BLOCK_BARREL_OPEN : SoundEvents.BLOCK_BARREL_CLOSE) : (open ? SoundEvents.BLOCK_CHEST_OPEN : SoundEvents.BLOCK_CHEST_CLOSE));
        level.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
        try {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity != null) {
                if (blockState.getBlock() instanceof BarrelBlock) {
                    if (blockState.contains(BarrelBlock.OPEN)) {
                        level.setBlockState(pos, blockState.with(BarrelBlock.OPEN, Boolean.valueOf(open)), 3);
                    }
                } else if (blockState.getBlock() instanceof ChestBlock) {
                    level.addSyncedBlockEvent(pos, blockState.getBlock(), 1, open ? 1 : 0);
                } else {
                    level.addSyncedBlockEvent(pos, blockState.getBlock(), 1, open ? 1 : 0);
                }
            }
        }
        catch (Exception e) {
            Constants.LOG.debug("Failed to animate container at {}: {}", pos, e.getMessage());
        }
        level.emitGameEvent((Entity)golem, (RegistryEntry)(open ? GameEvent.CONTAINER_OPEN : GameEvent.CONTAINER_CLOSE), pos);
    }

    private static Consumer<PathAwareEntity> onTravelling() {
        return mob -> {
            if (mob instanceof CopperGolemEntity) {
                CopperGolemEntity copperGolem = (CopperGolemEntity)mob;
                copperGolem.clearOpenedChestPos();
                copperGolem.setState(CopperGolemState.IDLE);
            }
        };
    }

    private static Predicate<TransportItemsBetweenContainers.TransportItemTarget> shouldQueueForTarget() {
        return target -> false;
    }

    private static boolean isValidDestinationContainer(BlockState state) {
        if (state.isIn(ModTags.Blocks.COPPER_CHESTS)) {
            return false;
        }
        if (state.getBlock() instanceof ChestBlock) {
            return true;
        }
        if (state.getBlock() instanceof BarrelBlock) {
            return true;
        }
        return ModCompat.isValidModContainer(state);
    }

    public static void updateActivity(CopperGolemEntity golem) {
        golem.getBrain().resetPossibleActivities(ImmutableList.of(Activity.IDLE));
    }
}

