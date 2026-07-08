/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1657
 *  net.minecraft.class_1678
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.BossMercuryEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1657;
import net.minecraft.class_1678;
import net.minecraft.class_1937;
import net.minecraft.class_243;

public class BossMercuryAttackGoal
extends class_1352 {
    private final BossMercuryEntity entity;
    public int cooldown;

    public BossMercuryAttackGoal(class_1314 mob) {
        this.entity = (BossMercuryEntity)mob;
    }

    public boolean method_6264() {
        return this.entity.method_5968() != null;
    }

    public void method_6269() {
        super.method_6269();
        this.cooldown = 0;
    }

    public void method_6270() {
        this.entity.method_19540(false);
        this.entity.attackAnimationTimeout = 0;
        super.method_6270();
    }

    public boolean method_38846() {
        return true;
    }

    public void method_6268() {
        class_1309 livingEntity = this.entity.method_5968();
        if (livingEntity != null) {
            double d = 64.0;
            if (livingEntity.method_5858((class_1297)this.entity) < 4096.0 && this.entity.method_6057((class_1297)livingEntity)) {
                class_1937 world = this.entity.method_37908();
                ++this.cooldown;
                this.entity.method_5988().method_20248(livingEntity.method_23317(), livingEntity.method_23320(), livingEntity.method_23321());
                if (this.cooldown == 20) {
                    double e = 4.0;
                    class_243 vec3d = this.entity.method_5828(1.0f);
                    double f = livingEntity.method_23317() - (this.entity.method_23317() + vec3d.field_1352 * 4.0);
                    double g = livingEntity.method_23323(0.5) - (0.5 + this.entity.method_23323(0.5));
                    double h = livingEntity.method_23321() - (this.entity.method_23321() + vec3d.field_1350 * 4.0);
                    world.method_8444((class_1657)null, 1033, this.entity.method_24515(), 0);
                    class_1678 bulletEntity = new class_1678(world, (class_1309)this.entity, (class_1297)livingEntity, this.entity.method_5755().method_10166());
                    bulletEntity.method_5814(this.entity.method_23317() + vec3d.field_1352 * 2.0, this.entity.method_23323(0.5) + 0.5, bulletEntity.method_23321() + vec3d.field_1350 * 2.0);
                    world.method_8649((class_1297)bulletEntity);
                    class_1678 bulletEntity2 = new class_1678(world, (class_1309)this.entity, (class_1297)livingEntity, this.entity.method_5755().method_10166());
                    bulletEntity2.method_5814(this.entity.method_23317() + vec3d.field_1352 * 2.0, this.entity.method_23323(0.5) + 0.5, bulletEntity.method_23321() + vec3d.field_1350 * 2.0);
                    world.method_8649((class_1297)bulletEntity2);
                    this.cooldown = -20;
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }
            this.entity.method_19540(this.cooldown > 10);
        }
    }
}

