/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1366
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.BossAnubisEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1366;

public class BossAnubisAttackGoal
extends class_1366 {
    private final BossAnubisEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public BossAnubisAttackGoal(class_1314 mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.entity = (BossAnubisEntity)mob;
    }

    public void method_6269() {
        super.method_6269();
        this.attackDelay = 20;
        this.ticksUntilNextAttack = 20;
    }

    protected void method_6288(class_1309 pEnemy, double squaredDistance) {
        if (this.isEnemyWithinAttackDistance(pEnemy)) {
            this.shouldCountTillNextAttack = true;
            if (this.isTimeToStartAttackAnimation()) {
                this.entity.method_19540(true);
            }
            if (this.isTimeToAttack()) {
                this.entity.method_5988().method_20248(pEnemy.method_23317(), pEnemy.method_23320(), pEnemy.method_23321());
                this.performAttack(pEnemy);
            }
        } else {
            this.resetAttackCooldown();
            this.shouldCountTillNextAttack = false;
            this.entity.method_19540(false);
            this.entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(class_1309 pEnemy) {
        return this.entity.method_5739((class_1297)pEnemy) <= 5.0f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.method_38847(this.attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= this.attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(class_1309 pEnemy) {
        this.resetAttackCooldown();
        this.entity.method_6104(class_1268.field_5808);
        this.entity.method_6121((class_1297)pEnemy);
        pEnemy.method_6092(new class_1293(class_1294.field_5920, 100));
    }

    public void method_6268() {
        super.method_6268();
        if (this.shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    public void method_6270() {
        this.entity.method_19540(false);
        super.method_6270();
    }
}

