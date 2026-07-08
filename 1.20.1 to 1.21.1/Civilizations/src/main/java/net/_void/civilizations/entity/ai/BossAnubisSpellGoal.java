/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1576
 *  net.minecraft.class_1639
 *  net.minecraft.class_1937
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.BossAnubisEntity;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1576;
import net.minecraft.class_1639;
import net.minecraft.class_1937;

public class BossAnubisSpellGoal
extends class_1352 {
    private final BossAnubisEntity entity;
    private int timer = 0;

    public BossAnubisSpellGoal(class_1314 mob) {
        this.entity = (BossAnubisEntity)mob;
    }

    public boolean method_6264() {
        return this.entity.method_5968() != null;
    }

    public void method_6269() {
        super.method_6269();
        this.timer = 0;
    }

    public void method_6270() {
        this.entity.setSpelling(false);
        this.entity.spellAnimationTimeout = 0;
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
                ++this.timer;
                if (this.timer == 20) {
                    this.timer = -300;
                    for (int i = 0; i <= 3; ++i) {
                        int x = (int)(Math.random() * 21.0 - 10.0);
                        int z = (int)(Math.random() * 21.0 - 10.0);
                        class_1576 husk1 = (class_1576)((class_1299)class_1299.method_5898((String)"minecraft:husk").get()).method_5883(world);
                        husk1.method_30634(this.entity.method_23317() + (double)x, 199.5, this.entity.method_23321() + (double)z);
                        world.method_8649((class_1297)husk1);
                        husk1.method_6092(new class_1293(class_1294.field_5902, 40, 0, false, false));
                        int x2 = (int)(Math.random() * 21.0 - 10.0);
                        int z2 = (int)(Math.random() * 21.0 - 10.0);
                        class_1639 skeleton1 = (class_1639)((class_1299)class_1299.method_5898((String)"minecraft:wither_skeleton").get()).method_5883(world);
                        skeleton1.method_30634(this.entity.method_23317() + (double)x2, 199.5, this.entity.method_23321() + (double)z2);
                        world.method_8649((class_1297)skeleton1);
                        skeleton1.method_6092(new class_1293(class_1294.field_5902, 40, 0, false, false));
                    }
                }
            } else if (this.timer >= 0) {
                --this.timer;
            }
            this.entity.setSpelling(this.timer > 0);
        }
    }
}

