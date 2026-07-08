/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1657
 *  net.minecraft.class_1665
 *  net.minecraft.class_1675
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.ChinaGuardEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1675;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;

public class ChinaGuardShootGoal
extends class_1352 {
    private final ChinaGuardEntity entity;
    public int cooldown;
    public double shotsTaken;

    public ChinaGuardShootGoal(class_1314 mob) {
        this.entity = (ChinaGuardEntity)mob;
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
        super.method_6270();
        this.entity.setShooting(false);
        this.entity.shootingAnimationTimeout = 0;
    }

    public boolean method_38846() {
        return true;
    }

    public void method_6268() {
        class_1309 livingEntity = this.entity.method_5968();
        if (livingEntity != null) {
            if (livingEntity.method_5858((class_1297)this.entity) < 4096.0 && this.entity.method_6057((class_1297)livingEntity)) {
                class_1937 world = this.entity.method_37908();
                ++this.cooldown;
                this.entity.method_5988().method_20248(livingEntity.method_23317(), livingEntity.method_23320(), livingEntity.method_23321());
                if (this.cooldown == 20) {
                    world.method_8444((class_1657)null, 1004, this.entity.method_24515(), 0);
                    class_1799 itemStack = new class_1799((class_1935)class_1802.field_8102);
                    class_1665 persistentProjectileEntity = class_1675.method_18813((class_1309)this.entity, (class_1799)itemStack, (float)1.0f);
                    double j = livingEntity.method_23317() - this.entity.method_23317();
                    double e = livingEntity.method_23323(0.3333333333333333) - persistentProjectileEntity.method_23318();
                    double f = livingEntity.method_23321() - this.entity.method_23321();
                    double g = Math.sqrt(j * j + f * f);
                    persistentProjectileEntity.method_7485(j, e + g * (double)0.2f, f, 1.6f, (float)(14 - world.method_8407().method_5461() * 4));
                    world.method_8649((class_1297)persistentProjectileEntity);
                    if (this.shotsTaken < 2.0) {
                        this.shotsTaken += 1.0;
                        this.cooldown = 10;
                    } else {
                        this.shotsTaken = 0.0;
                        this.cooldown = -60;
                    }
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }
            this.entity.setShooting(this.cooldown > 10);
        }
    }
}

