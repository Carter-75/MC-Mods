/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1548
 *  net.minecraft.class_1614
 *  net.minecraft.class_1628
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.BossLokiCloneEntity;
import net._void.civilizations.entity.custom.BossLokiEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1548;
import net.minecraft.class_1614;
import net.minecraft.class_1628;
import net.minecraft.class_1657;
import net.minecraft.class_1937;

public class BossLokiAttackGoal
extends class_1352 {
    protected final class_1314 mob;
    private final BossLokiEntity entity;
    public int cooldown;
    public int type = 0;

    public BossLokiAttackGoal(class_1314 mob) {
        this.mob = mob;
        this.entity = (BossLokiEntity)mob;
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
                this.entity.setPotioning(false);
                this.entity.potionAnimationTimeout = 0;
                break;
            }
            case 3: {
                this.entity.setCloning(false);
                this.entity.cloneAnimationTimeout = 0;
                break;
            }
            case 4: {
                this.entity.setSummoning(false);
                this.entity.summonAnimationTimeout = 0;
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
                    this.type = (int)(Math.random() * 4.0 + 1.0);
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
                            this.entity.method_6092(new class_1293(class_1294.field_5905, 100));
                            world.method_8444((class_1657)null, 1033, this.entity.method_24515(), 0);
                            this.cooldown = -60;
                            break;
                        }
                        case 3: {
                            BossLokiCloneEntity customEntity;
                            int i;
                            for (i = -1; i <= 1; i += 2) {
                                customEntity = (BossLokiCloneEntity)((class_1299)class_1299.method_5898((String)"civilizations:boss_loki_clone").get()).method_5883(world);
                                customEntity.method_30634(this.entity.method_23317() + (double)i, this.entity.method_23318(), this.entity.method_23321());
                                world.method_8649((class_1297)customEntity);
                            }
                            for (i = -1; i <= 1; i += 2) {
                                customEntity = (BossLokiCloneEntity)((class_1299)class_1299.method_5898((String)"civilizations:boss_loki_clone").get()).method_5883(world);
                                customEntity.method_30634(this.entity.method_23317(), this.entity.method_23318(), this.entity.method_23321() + (double)i);
                                world.method_8649((class_1297)customEntity);
                            }
                            world.method_8444((class_1657)null, 1503, this.entity.method_24515(), 0);
                            this.cooldown = -100;
                            break;
                        }
                        case 4: {
                            for (int i = -1; i <= 1; i += 2) {
                                block20: for (int j = -1; j <= 1; j += 2) {
                                    int r = (int)(Math.random() * 3.0 + 1.0);
                                    switch (r) {
                                        case 1: {
                                            class_1614 customEntity = (class_1614)((class_1299)class_1299.method_5898((String)"minecraft:silverfish").get()).method_5883(world);
                                            customEntity.method_30634(this.entity.method_23317() + (double)i, this.entity.method_23318(), this.entity.method_23321() + (double)j);
                                            world.method_8649((class_1297)customEntity);
                                            customEntity.method_6092(new class_1293(class_1294.field_5904, 1800, 1, false, false));
                                            customEntity.method_6092(new class_1293(class_1294.field_5898, 600, 4, false, false));
                                            continue block20;
                                        }
                                        case 2: {
                                            class_1614 customEntity = (class_1628)((class_1299)class_1299.method_5898((String)"minecraft:spider").get()).method_5883(world);
                                            customEntity.method_30634(this.entity.method_23317() + (double)i, this.entity.method_23318(), this.entity.method_23321() + (double)j);
                                            world.method_8649((class_1297)customEntity);
                                            customEntity.method_6092(new class_1293(class_1294.field_5905, 1800, 0, false, false));
                                            continue block20;
                                        }
                                        case 3: {
                                            class_1614 customEntity = (class_1548)((class_1299)class_1299.method_5898((String)"minecraft:creeper").get()).method_5883(world);
                                            customEntity.method_30634(this.entity.method_23317() + (double)i, this.entity.method_23318(), this.entity.method_23321() + (double)j);
                                            world.method_8649((class_1297)customEntity);
                                            customEntity.method_6092(new class_1293(class_1294.field_5904, 1800, 1, false, false));
                                        }
                                    }
                                }
                            }
                            world.method_8444((class_1657)null, 1502, this.entity.method_24515(), 0);
                            this.cooldown = -80;
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
                    this.entity.setPotioning(this.cooldown > 10);
                    break;
                }
                case 3: {
                    this.entity.setCloning(this.cooldown > 10);
                    break;
                }
                case 4: {
                    this.entity.setSummoning(this.cooldown > 10);
                }
            }
        }
    }
}

