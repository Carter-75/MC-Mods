/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.RangedWeaponItem
 *  net.minecraft.entity.ai.brain.EntityLookTarget
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.LivingTargetCache
 *  net.minecraft.entity.ai.brain.task.SingleTickTask
 *  net.minecraft.entity.ai.brain.task.TaskTriggerer
 */
package backported.updates.content.common.level.entities.creaking;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Predicate;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.entity.ai.brain.EntityLookTarget;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.LivingTargetCache;
import net.minecraft.entity.ai.brain.task.SingleTickTask;
import net.minecraft.entity.ai.brain.task.TaskTriggerer;

public class CreakingMeleeAttack {
    public static <T extends MobEntity> SingleTickTask<T> create(Predicate<T> canAttackPredicate, int cooldownBetweenAttacks) {
        return TaskTriggerer.task(instance -> instance.group(instance.queryMemoryOptional(MemoryModuleType.LOOK_TARGET), instance.queryMemoryValue(MemoryModuleType.ATTACK_TARGET), instance.queryMemoryAbsent(MemoryModuleType.ATTACK_COOLING_DOWN), instance.queryMemoryValue(MemoryModuleType.VISIBLE_MOBS)).apply(instance, (lookTarget, attackTarget, attackCoolingDown, nearestVisibleLivingEntities) -> (level, body, timestamp) -> {
            LivingEntity target = (LivingEntity)instance.getValue(attackTarget);
            if (canAttackPredicate.test(body) && !CreakingMeleeAttack.isHoldingUsableProjectileWeapon(body) && body.isInAttackRange(target) && ((LivingTargetCache)instance.getValue(nearestVisibleLivingEntities)).contains(target)) {
                lookTarget.remember(new EntityLookTarget((Entity)target, true));
                body.swingHand(Hand.MAIN_HAND);
                body.tryAttack((Entity)target);
                attackCoolingDown.remember(true, (long)cooldownBetweenAttacks);
                return true;
            }
            return false;
        }));
    }

    private static boolean isHoldingUsableProjectileWeapon(MobEntity body) {
        return body.isHolding(stack -> {
            RangedWeaponItem projectile;
            Item item = stack.getItem();
            return item instanceof RangedWeaponItem && body.canUseRangedWeapon(projectile = (RangedWeaponItem)item);
        });
    }
}

