/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.Brain$Profile
 *  net.minecraft.entity.ai.brain.task.LookAroundTask
 *  net.minecraft.entity.ai.brain.task.MoveToTargetTask
 *  net.minecraft.entity.ai.brain.task.RandomTask
 *  net.minecraft.entity.ai.brain.task.GoTowardsLookTargetTask
 *  net.minecraft.entity.ai.brain.task.StayAboveWaterTask
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.MemoryModuleState
 *  net.minecraft.entity.ai.brain.sensor.Sensor
 *  net.minecraft.entity.ai.brain.sensor.SensorType
 *  net.minecraft.entity.ai.brain.Activity
 *  net.minecraft.entity.ai.brain.task.StrollTask
 *  net.minecraft.entity.ai.brain.task.TemptationCooldownTask
 *  net.minecraft.entity.ai.brain.task.TemptTask
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 *  net.minecraft.entity.ai.brain.task.FleeTask
 */
package backported.updates.content.common.level.entities.happyghast;

import backported.updates.content.common.level.entities.happyghast.GhastlingFollowAdult;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.registries.ModSensorTypes;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.LookAroundTask;
import net.minecraft.entity.ai.brain.task.MoveToTargetTask;
import net.minecraft.entity.ai.brain.task.RandomTask;
import net.minecraft.entity.ai.brain.task.GoTowardsLookTargetTask;
import net.minecraft.entity.ai.brain.task.StayAboveWaterTask;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.task.StrollTask;
import net.minecraft.entity.ai.brain.task.TemptationCooldownTask;
import net.minecraft.entity.ai.brain.task.TemptTask;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.entity.ai.brain.task.FleeTask;

public class HappyGhastAi {
    private static final float IDLE_SPEED = 1.0f;
    private static final float TEMPTED_SPEED = 1.25f;
    private static final float FOLLOWING_ADULT_SPEED = 1.1f;
    private static final double CLOSE_ENOUGH_DIST = 5.0;
    private static final UniformIntProvider ADULT_FOLLOW_RANGE = UniformIntProvider.create((int)5, (int)16);
    private static final ImmutableList<SensorType<? extends Sensor<? super HappyGhast>>> SENSOR_TYPES = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.HURT_BY, ModSensorTypes.HAPPY_GHAST_TEMPTATIONS.get(), ModSensorTypes.NEAREST_ADULT_ANY_TYPE.get(), SensorType.NEAREST_PLAYERS);
    private static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.WALK_TARGET, MemoryModuleType.LOOK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.PATH, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.TEMPTING_PLAYER, MemoryModuleType.TEMPTATION_COOLDOWN_TICKS, MemoryModuleType.IS_TEMPTED, MemoryModuleType.BREED_TARGET, MemoryModuleType.IS_PANICKING, MemoryModuleType.HURT_BY, MemoryModuleType.NEAREST_VISIBLE_ADULT, MemoryModuleType.NEAREST_PLAYERS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER);

    public static Brain.Profile<HappyGhast> brainProvider() {
        return Brain.createProfile(MEMORY_TYPES, SENSOR_TYPES);
    }

    protected static Brain<?> makeBrain(Brain<HappyGhast> brain) {
        HappyGhastAi.initCoreActivity(brain);
        HappyGhastAi.initIdleActivity(brain);
        HappyGhastAi.initPanicActivity(brain);
        brain.setCoreActivities(Set.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.resetPossibleActivities();
        return brain;
    }

    private static void initCoreActivity(Brain<HappyGhast> brain) {
        brain.setTaskList(Activity.CORE, 0, (ImmutableList)ImmutableList.of(new StayAboveWaterTask(0.8f), new FleeTask(2.0f), new LookAroundTask(45, 90), new MoveToTargetTask(), new TemptationCooldownTask(MemoryModuleType.TEMPTATION_COOLDOWN_TICKS)));
    }

    private static void initIdleActivity(Brain<HappyGhast> brain) {
        brain.setTaskList(Activity.IDLE, ImmutableList.of(Pair.of(1, new TemptTask(entity -> Float.valueOf(1.25f), entity -> 5.0)), Pair.of(2, GhastlingFollowAdult.create(ADULT_FOLLOW_RANGE, entity -> Float.valueOf(1.1f), (MemoryModuleType<? extends LivingEntity>)MemoryModuleType.NEAREST_VISIBLE_PLAYER)), Pair.of(3, GhastlingFollowAdult.create(ADULT_FOLLOW_RANGE, entity -> Float.valueOf(1.1f), (MemoryModuleType<? extends LivingEntity>)MemoryModuleType.NEAREST_VISIBLE_ADULT)), Pair.of(4, new RandomTask(ImmutableList.of(Pair.of(StrollTask.createSolidTargeting((float)1.0f), 1), Pair.of(GoTowardsLookTargetTask.create((float)1.0f, (int)3), 1))))));
    }

    private static void initPanicActivity(Brain<HappyGhast> brain) {
        brain.setTaskList(Activity.PANIC, ImmutableList.of(), Set.of(Pair.of(MemoryModuleType.IS_PANICKING, MemoryModuleState.VALUE_PRESENT)));
    }

    public static void updateActivity(HappyGhast happyGhast) {
        happyGhast.getBrain().resetPossibleActivities(ImmutableList.of(Activity.PANIC, Activity.IDLE));
    }
}

