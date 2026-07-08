/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1657
 *  net.minecraft.class_1674
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.EgyptBossEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1657;
import net.minecraft.class_1674;
import net.minecraft.class_1937;
import net.minecraft.class_243;

public class EgyptBossShootGoal
extends class_1352 {
    private final EgyptBossEntity entity;
    public int cooldown;
    public double shotsTaken;

    public EgyptBossShootGoal(class_1314 mob) {
        this.entity = (EgyptBossEntity)mob;
    }

    public boolean method_6264() {
        return this.entity.method_5968() != null;
    }

    public void method_6269() {
        super.method_6269();
        this.cooldown = 0;
        this.shotsTaken = 0.0;
    }

    public void method_6270() {
        this.entity.setShooting(false);
        this.entity.shootingAnimationTimeout = 0;
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
                if (this.cooldown == 20) {
                    double e = 4.0;
                    class_243 vec3d = this.entity.method_5828(1.0f);
                    double f = livingEntity.method_23317() - (this.entity.method_23317() + vec3d.field_1352 * 4.0);
                    double g = livingEntity.method_23323(0.5) - (0.5 + this.entity.method_23323(0.5));
                    double h = livingEntity.method_23321() - (this.entity.method_23321() + vec3d.field_1350 * 4.0);
                    world.method_8444((class_1657)null, 1017, this.entity.method_24515(), 0);
                    class_1674 fireballEntity = new class_1674(world, (class_1309)this.entity, f * 4.0, g * 4.0, h * 4.0, 3);
                    fireballEntity.method_5814(this.entity.method_23317() + vec3d.field_1352 * 2.0, this.entity.method_23323(0.5) + 0.5, fireballEntity.method_23321() + vec3d.field_1350 * 2.0);
                    world.method_8649((class_1297)fireballEntity);
                    if (this.shotsTaken < 5.0) {
                        this.shotsTaken += 1.0;
                        this.cooldown = 10;
                    } else {
                        this.shotsTaken = 0.0;
                        this.cooldown = -160;
                    }
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }
            this.entity.setShooting(this.cooldown > 10);
        }
    }
}

