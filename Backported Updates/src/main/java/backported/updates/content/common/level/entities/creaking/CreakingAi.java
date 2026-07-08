/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableSet
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.Brain$Profile
 *  net.minecraft.entity.ai.brain.task.WaitTask
 *  net.minecraft.entity.ai.brain.task.LookAroundTask
 *  net.minecraft.entity.ai.brain.task.MoveToTargetTask
 *  net.minecraft.entity.ai.brain.task.RandomTask
 *  net.minecraft.entity.ai.brain.task.GoTowardsLookTargetTask
 *  net.minecraft.entity.ai.brain.task.StayAboveWaterTask
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.sensor.Sensor
 *  net.minecraft.entity.ai.brain.sensor.SensorType
 *  net.minecraft.entity.ai.brain.Activity
 *  net.minecraft.entity.ai.brain.task.StrollTask
 *  net.minecraft.entity.ai.brain.task.RangedApproachTask
 *  net.minecraft.entity.ai.brain.task.UpdateAttackTargetTask
 *  net.minecraft.entity.ai.brain.task.ForgetAttackTargetTask
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 *  net.minecraft.entity.ai.brain.task.LookAtMobWithIntervalTask
 */
package backported.updates.content.common.level.entities.creaking;

import backported.updates.content.common.level.entities.creaking.Creaking;
import backported.updates.content.common.level.entities.creaking.CreakingMeleeAttack;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.WaitTask;
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
import net.minecraft.entity.ai.brain.task.RangedApproachTask;
import net.minecraft.entity.ai.brain.task.UpdateAttackTargetTask;
import net.minecraft.entity.ai.brain.task.ForgetAttackTargetTask;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.entity.ai.brain.task.LookAtMobWithIntervalTask;

public class CreakingAi {
    protected static final ImmutableList<? extends SensorType<? extends Sensor<? super Creaking>>> SENSOR_TYPES = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS);
    protected static final ImmutableList<? extends MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.LOOK_TARGET, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.PATH, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN);

    static void initCoreActivity(Brain<Creaking> brain) {
        brain.setTaskList(Activity.CORE, ImmutableList.of(Pair.of(0, new StayAboveWaterTask(0.8f){

            protected boolean shouldRun(ServerWorld level, MobEntity owner) {
                Creaking creaking;
                if (owner instanceof Creaking && (creaking = (Creaking)owner).canMove()) {
                    return super.shouldRun(level, owner);
                }
                return false;
            }
        }), Pair.of(0, new LookAroundTask(45, 90)), Pair.of(0, new MoveToTargetTask())));
    }

    static void initIdleActivity(Brain<Creaking> brain) {
        brain.setTaskList(Activity.IDLE, ImmutableList.of(Pair.of(10, UpdateAttackTargetTask.create(Creaking::isActive, creaking -> creaking.getBrain().getOptionalRegisteredMemory(MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER))), Pair.of(10, LookAtMobWithIntervalTask.follow((float)8.0f, (UniformIntProvider)UniformIntProvider.create((int)30, (int)60))), Pair.of(10, new RandomTask(ImmutableList.of(Pair.of(StrollTask.create((float)0.3f), 2), Pair.of(GoTowardsLookTargetTask.create((float)0.3f, (int)3), 2), Pair.of(new WaitTask(30, 60), 1))))));
    }

    static void initFightActivity(Brain<Creaking> brain) {
        brain.setTaskList(Activity.FIGHT, ImmutableList.of(Pair.of(10, RangedApproachTask.create((float)1.0f)), Pair.of(10, CreakingMeleeAttack.create(Creaking::canMove, 40)), Pair.of(10, ForgetAttackTargetTask.create())), ImmutableSet.of(Pair.of(MemoryModuleType.ATTACK_TARGET, MemoryModuleState.VALUE_PRESENT)));
    }

    public static Brain.Profile<Creaking> brainProvider() {
        return Brain.createProfile(MEMORY_TYPES, SENSOR_TYPES);
    }

    public static Brain<Creaking> makeBrain(Brain<Creaking> brain) {
        CreakingAi.initCoreActivity(brain);
        CreakingAi.initIdleActivity(brain);
        CreakingAi.initFightActivity(brain);
        brain.setCoreActivities((Set)ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.resetPossibleActivities();
        return brain;
    }

    public static void updateActivity(Creaking creaking) {
        if (!creaking.canMove()) {
            creaking.getBrain().resetPossibleActivities();
        } else {
            creaking.getBrain().resetPossibleActivities(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
        }
    }
}

