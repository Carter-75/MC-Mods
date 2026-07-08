/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1366
 *  net.minecraft.class_1588
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 */
package backported.updates.garden.entity.ai.goal;

import backported.updates.garden.entity.CreakingEntity;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1366;
import net.minecraft.class_1588;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;

public class CreakingMeleeAttackGoal
extends class_1366 {
    protected final class_1314 mob;

    public CreakingMeleeAttackGoal(class_1314 mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.mob = mob;
    }

    public boolean isInMovableRange() {
        if (this.mob instanceof CreakingEntity && ((CreakingEntity)this.mob).boundHeart != null) {
            class_2338 pos1;
            class_243 pos0 = this.mob.method_19538();
            double range = pos0.method_1022(class_243.method_24954((class_2382)(pos1 = ((CreakingEntity)this.mob).boundHeart)));
            return range < 30.0;
        }
        return false;
    }

    public boolean method_6264() {
        if (this.isPlayerNotLookingAtEntity(this.mob.method_5968(), (class_1588)this.mob) && this.isInMovableRange()) {
            return super.method_6264();
        }
        return false;
    }

    public boolean method_6266() {
        if (this.isPlayerNotLookingAtEntity(this.mob.method_5968(), (class_1588)this.mob)) {
            return super.method_6266();
        }
        return false;
    }

    private boolean isPlayerNotLookingAtEntity(class_1309 player, class_1588 entity) {
        float angleToEntity;
        if (player == null) {
            return true;
        }
        double deltaX = entity.method_23317() - player.method_23317();
        double deltaZ = entity.method_23321() - player.method_23321();
        float targetYaw = player.method_5705(1.0f);
        float angleDifference = Math.abs(targetYaw - (angleToEntity = (float)(Math.atan2(deltaZ, deltaX) * 57.29577951308232) - 90.0f));
        return !(angleDifference < 45.0f) && !(angleDifference > 315.0f);
    }
}

