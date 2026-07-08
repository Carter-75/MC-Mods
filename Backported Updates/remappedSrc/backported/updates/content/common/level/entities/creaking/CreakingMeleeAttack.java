/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1792
 *  net.minecraft.class_1811
 *  net.minecraft.class_4102
 *  net.minecraft.class_4140
 *  net.minecraft.class_6670
 *  net.minecraft.class_7894
 *  net.minecraft.class_7898
 */
package backported.updates.content.common.level.entities.creaking;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1811;
import net.minecraft.class_4102;
import net.minecraft.class_4140;
import net.minecraft.class_6670;
import net.minecraft.class_7894;
import net.minecraft.class_7898;

public class CreakingMeleeAttack {
    public static <T extends class_1308> class_7894<T> create(Predicate<T> canAttackPredicate, int cooldownBetweenAttacks) {
        return class_7898.method_47224(instance -> instance.group((App)instance.method_47235(class_4140.field_18446), (App)instance.method_47244(class_4140.field_22355), (App)instance.method_47245(class_4140.field_22475), (App)instance.method_47244(class_4140.field_18442)).apply((Applicative)instance, (lookTarget, attackTarget, attackCoolingDown, nearestVisibleLivingEntities) -> (level, body, timestamp) -> {
            class_1309 target = (class_1309)instance.method_47243(attackTarget);
            if (canAttackPredicate.test(body) && !CreakingMeleeAttack.isHoldingUsableProjectileWeapon(body) && body.method_42150(target) && ((class_6670)instance.method_47243(nearestVisibleLivingEntities)).method_38972(target)) {
                lookTarget.method_47249((Object)new class_4102((class_1297)target, true));
                body.method_6104(class_1268.field_5808);
                body.method_6121((class_1297)target);
                attackCoolingDown.method_47250((Object)true, (long)cooldownBetweenAttacks);
                return true;
            }
            return false;
        }));
    }

    private static boolean isHoldingUsableProjectileWeapon(class_1308 body) {
        return body.method_24520(stack -> {
            class_1811 projectile;
            class_1792 item = stack.method_7909();
            return item instanceof class_1811 && body.method_25938(projectile = (class_1811)item);
        });
    }
}

