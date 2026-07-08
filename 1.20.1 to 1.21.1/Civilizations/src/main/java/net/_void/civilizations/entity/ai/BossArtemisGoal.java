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
 *  net.minecraft.class_243
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.BossArtemisEntity;
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
import net.minecraft.class_243;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class BossArtemisGoal
extends class_1352 {
    private final BossArtemisEntity entity;
    public int cooldown;
    public double shotsTaken;

    public BossArtemisGoal(class_1314 mob) {
        this.entity = (BossArtemisEntity)mob;
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
                    persistentProjectileEntity.method_5639(100);
                    persistentProjectileEntity.method_7439(true);
                    persistentProjectileEntity.method_7438(persistentProjectileEntity.method_7448() + 2.0);
                    class_1665 persistentProjectileEntity2 = class_1675.method_18813((class_1309)this.entity, (class_1799)itemStack, (float)1.0f);
                    class_243 vec3d = this.entity.method_18864(1.0f);
                    Quaternionf quaternionf = new Quaternionf().setAngleAxis(0.1745329201221466, vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
                    class_243 vec3d2 = this.entity.method_5828(1.0f);
                    Vector3f vector3f = vec3d2.method_46409().rotate((Quaternionfc)quaternionf);
                    persistentProjectileEntity2.method_7485((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), 1.6f, 1.0f);
                    persistentProjectileEntity2.method_5639(100);
                    persistentProjectileEntity2.method_7439(true);
                    persistentProjectileEntity2.method_7438(persistentProjectileEntity2.method_7448() + 2.0);
                    class_1665 persistentProjectileEntity3 = class_1675.method_18813((class_1309)this.entity, (class_1799)itemStack, (float)1.0f);
                    Quaternionf quaternionf2 = new Quaternionf().setAngleAxis(-0.1745329201221466, vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
                    Vector3f vector3f2 = vec3d2.method_46409().rotate((Quaternionfc)quaternionf2);
                    persistentProjectileEntity3.method_7485((double)vector3f2.x(), (double)vector3f2.y(), (double)vector3f2.z(), 1.6f, 1.0f);
                    persistentProjectileEntity3.method_5639(100);
                    persistentProjectileEntity3.method_7439(true);
                    persistentProjectileEntity3.method_7438(persistentProjectileEntity3.method_7448() + 2.0);
                    world.method_8649((class_1297)persistentProjectileEntity);
                    world.method_8649((class_1297)persistentProjectileEntity2);
                    world.method_8649((class_1297)persistentProjectileEntity3);
                    if (this.entity.getMode() == 1) {
                        this.cooldown = 10;
                    } else if (this.shotsTaken < 2.0) {
                        this.shotsTaken += 1.0;
                        this.cooldown = 15;
                    } else {
                        this.shotsTaken = 0.0;
                        this.cooldown = -100;
                    }
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }
            this.entity.setShooting(this.cooldown > 10);
        }
    }
}

