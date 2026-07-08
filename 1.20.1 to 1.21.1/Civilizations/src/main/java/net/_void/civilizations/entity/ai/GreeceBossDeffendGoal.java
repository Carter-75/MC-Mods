/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 */
package net._void.civilizations.entity.ai;

import net._void.civilizations.entity.custom.GreeceBossEntity;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;

public class GreeceBossDeffendGoal
extends class_1352 {
    private final GreeceBossEntity entity;
    public int cooldown;

    public GreeceBossDeffendGoal(class_1314 mob) {
        this.entity = (GreeceBossEntity)mob;
    }

    public boolean method_6264() {
        return this.entity.method_5968() != null;
    }

    public void method_6269() {
        super.method_6269();
        this.cooldown = 0;
    }

    public void method_6270() {
        this.entity.setDeffending(false);
        this.entity.deffendAnimationTimeout = 0;
        super.method_6270();
    }

    public boolean method_38846() {
        return true;
    }

    public void method_6268() {
        class_1309 livingEntity = this.entity.method_5968();
        if (livingEntity != null) {
            ++this.cooldown;
            if (this.cooldown == 20) {
                this.cooldown = -200;
            }
            this.entity.setDeffending(this.cooldown > -80);
        }
    }
}

