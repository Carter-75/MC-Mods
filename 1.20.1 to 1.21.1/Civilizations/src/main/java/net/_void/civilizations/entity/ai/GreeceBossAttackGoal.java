/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1366
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.GreeceBossEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1366;

public class GreeceBossAttackGoal
extends class_1366 {
    private final GreeceBossEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountTillNextAttack = false;

    public GreeceBossAttackGoal(class_1314 mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.entity = (GreeceBossEntity)mob;
    }

    public void method_6269() {
        if (!this.entity.isDeffending()) {
            super.method_6269();
            this.attackDelay = 10;
            this.ticksUntilNextAttack = 15;
        }
    }

    protected void method_6288(class_1309 pEnemy, double squaredDistance) {
        if (!this.entity.isDeffending()) {
            if (this.isEnemyWithinAttackDistance(pEnemy)) {
                this.shouldCountTillNextAttack = true;
                if (this.isTimeToStartAttackAnimation()) {
                    this.entity.method_19540(true);
                }
                if (this.isTimeToAttack()) {
                    this.field_6503.method_5988().method_20248(pEnemy.method_23317(), pEnemy.method_23320(), pEnemy.method_23321());
                    this.performAttack(pEnemy);
                }
            } else {
                this.resetAttackCooldown();
                this.shouldCountTillNextAttack = false;
                this.entity.method_19540(false);
                this.entity.attackAnimationTimeout = 0;
            }
        }
    }

    private boolean isEnemyWithinAttackDistance(class_1309 pEnemy) {
        return this.entity.method_5739((class_1297)pEnemy) <= 4.0f;
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
        this.field_6503.method_6104(class_1268.field_5808);
        this.field_6503.method_6121((class_1297)pEnemy);
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

