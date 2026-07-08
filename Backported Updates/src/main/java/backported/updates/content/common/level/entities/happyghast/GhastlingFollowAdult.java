/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.brain.EntityLookTarget
 *  net.minecraft.entity.ai.brain.LookTarget
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.WalkTarget
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 *  net.minecraft.entity.ai.brain.task.SingleTickTask
 *  net.minecraft.entity.ai.brain.task.TaskTriggerer
 */
package backported.updates.content.common.level.entities.happyghast;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.EntityLookTarget;
import net.minecraft.entity.ai.brain.LookTarget;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.entity.ai.brain.task.SingleTickTask;
import net.minecraft.entity.ai.brain.task.TaskTriggerer;

public class GhastlingFollowAdult {
    public static SingleTickTask<LivingEntity> create(UniformIntProvider followRange, float speed) {
        return GhastlingFollowAdult.create(followRange, entity -> Float.valueOf(speed), (MemoryModuleType<? extends LivingEntity>)MemoryModuleType.NEAREST_VISIBLE_ADULT);
    }

    public static SingleTickTask<LivingEntity> create(UniformIntProvider followRange, Function<LivingEntity, Float> speedFactory, MemoryModuleType<? extends LivingEntity> memory) {
        return TaskTriggerer.task(instance -> instance.group(instance.queryMemoryValue(memory), instance.queryMemoryOptional(MemoryModuleType.LOOK_TARGET), instance.queryMemoryAbsent(MemoryModuleType.WALK_TARGET)).apply(instance, (followTarget, lookTarget, walkTarget) -> (level, entity, gameTme) -> {
            if (!entity.isBaby()) {
                return false;
            }
            LivingEntity leader = (LivingEntity)instance.getValue(followTarget);
            if (entity.isInRange((Entity)leader, (double)(followRange.getMax() + 1)) && !entity.isInRange((Entity)leader, (double)followRange.getMin())) {
                WalkTarget target = new WalkTarget((LookTarget)new EntityLookTarget((Entity)leader, false), ((Float)speedFactory.apply(entity)).floatValue(), followRange.getMin() - 1);
                lookTarget.remember(new EntityLookTarget((Entity)leader, true));
                walkTarget.remember(target);
                return true;
            }
            return false;
        }));
    }
}

