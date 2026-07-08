/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1101
 *  net.minecraft.class_1113
 *  net.minecraft.class_1309
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 */
package net._void.civilizations.sound;

import net.minecraft.class_1101;
import net.minecraft.class_1113;
import net.minecraft.class_1309;
import net.minecraft.class_3414;
import net.minecraft.class_3419;

public class CustomSoundInstance
extends class_1101 {
    private final class_1309 entity;

    public CustomSoundInstance(class_1309 entity, class_3414 soundEvent, class_3419 soundCategory) {
        super(soundEvent, soundCategory, class_1113.method_43221());
        this.entity = entity;
        this.field_5442 = 1.0f;
        this.field_5441 = 1.0f;
        this.field_5446 = true;
        this.setPositionToEntity();
    }

    public void method_16896() {
        if (this.entity == null || this.entity.method_31481() || this.entity.method_29504()) {
            this.method_24876();
            return;
        }
        this.setPositionToEntity();
    }

    public boolean method_4785() {
        return true;
    }

    private void setPositionToEntity() {
        this.field_5439 = this.entity.method_23317();
        this.field_5450 = this.entity.method_23318();
        this.field_5449 = this.entity.method_23321();
    }
}

