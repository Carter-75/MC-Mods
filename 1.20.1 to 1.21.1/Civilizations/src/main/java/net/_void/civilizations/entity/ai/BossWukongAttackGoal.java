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
 *  net.minecraft.class_1352
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.BossWukongEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;

public class BossWukongAttackGoal
extends class_1352 {
    protected final class_1314 mob;
    private final BossWukongEntity entity;
    public int cooldown;
    public int type = 0;

    public BossWukongAttackGoal(class_1314 mob) {
        this.mob = mob;
        this.entity = (BossWukongEntity)mob;
    }

    public boolean method_6264() {
        return this.entity.method_5968() != null;
    }

    public void method_6269() {
        super.method_6269();
        this.cooldown = 0;
    }

    public void method_6270() {
        switch (this.type) {
            case 1: {
                this.entity.method_19540(false);
                this.entity.attackAnimationTimeout = 0;
                break;
            }
            case 2: {
                this.entity.setSpelling(false);
                this.entity.spellAnimationTimeout = 0;
            }
        }
        super.method_6270();
    }

    public boolean method_38846() {
        return true;
    }

    public void method_6268() {
        class_1309 livingEntity = this.entity.method_5968();
        if (livingEntity != null) {
            if (livingEntity.method_5858((class_1297)this.entity) < 4096.0 && this.entity.method_6057((class_1297)livingEntity)) {
                class_1937 world = this.entity.method_37908();
                if (this.cooldown == 0) {
                    this.type = (int)(Math.random() * 6.0 + 1.0) == 1 ? 2 : 1;
                }
                ++this.cooldown;
                this.entity.method_5988().method_20248(livingEntity.method_23317(), livingEntity.method_23320(), livingEntity.method_23321());
                if (this.cooldown == 20) {
                    switch (this.type) {
                        case 1: {
                            if (livingEntity.method_5858((class_1297)this.entity) < 25.0) {
                                this.mob.method_6104(class_1268.field_5808);
                                this.mob.method_6121((class_1297)livingEntity);
                            }
                            this.cooldown = -20;
                            break;
                        }
                        case 2: {
                            for (double i = -7.0; i <= 7.0; i += 1.0) {
                                for (double j = -7.0; j <= 7.0; j += 1.0) {
                                    if (!(Math.pow(i, 2.0) + Math.pow(j, 2.0) >= Math.pow(4.0, 2.0)) || !(Math.pow(i, 2.0) + Math.pow(j, 2.0) <= Math.pow(6.0, 2.0))) continue;
                                    int y = (int)this.entity.method_23318();
                                    boolean done = false;
                                    int limit = 0;
                                    while (!done && limit <= 7) {
                                        if (world.method_8320(new class_2338((int)this.entity.method_23317() + (int)i, y - 1, (int)this.entity.method_23321() + (int)j)) != class_2246.field_10124.method_9564() && world.method_8320(new class_2338((int)this.entity.method_23317() + (int)i, y, (int)this.entity.method_23321() + (int)j)).equals(class_2246.field_10124.method_9564())) {
                                            world.method_8501(new class_2338((int)this.entity.method_23317() + (int)i, y, (int)this.entity.method_23321() + (int)j), class_2246.field_10036.method_9564());
                                            done = true;
                                            continue;
                                        }
                                        if (world.method_8320(new class_2338((int)this.entity.method_23317() + (int)i, y, (int)this.entity.method_23321() + (int)j)) != class_2246.field_10124.method_9564()) {
                                            ++y;
                                            ++limit;
                                            continue;
                                        }
                                        if (!world.method_8320(new class_2338((int)this.entity.method_23317() + (int)i, y, (int)this.entity.method_23321() + (int)j)).equals(class_2246.field_10124.method_9564())) continue;
                                        --y;
                                        ++limit;
                                    }
                                }
                            }
                            this.entity.method_6092(new class_1293(class_1294.field_5910, 60, 1, false, false));
                            world.method_8444((class_1657)null, 1502, this.entity.method_24515(), 0);
                            this.cooldown = -20;
                        }
                    }
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }
            switch (this.type) {
                case 1: {
                    this.entity.method_19540(this.cooldown > 10);
                    break;
                }
                case 2: {
                    this.entity.setSpelling(this.cooldown > 10);
                }
            }
        }
    }
}

