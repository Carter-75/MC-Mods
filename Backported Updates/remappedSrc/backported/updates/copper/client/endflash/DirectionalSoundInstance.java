/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1101
 *  net.minecraft.class_1113$class_1114
 *  net.minecraft.class_243
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_4184
 *  net.minecraft.class_5819
 */
package backported.updates.copper.client.endflash;

import net.minecraft.class_1101;
import net.minecraft.class_1113;
import net.minecraft.class_243;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_4184;
import net.minecraft.class_5819;

public class DirectionalSoundInstance
extends class_1101 {
    private final class_4184 camera;
    private final float xAngle;
    private final float yAngle;

    public DirectionalSoundInstance(class_3414 soundEvent, class_3419 source, class_5819 random, class_4184 camera, float xAngle, float yAngle) {
        super(soundEvent, source, random);
        this.camera = camera;
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.setPosition();
    }

    private void setPosition() {
        class_243 vec3 = class_243.method_1030((float)this.xAngle, (float)this.yAngle).method_1021(10.0);
        this.field_5439 = this.camera.method_19326().field_1352 + vec3.field_1352;
        this.field_5450 = this.camera.method_19326().field_1351 + vec3.field_1351;
        this.field_5449 = this.camera.method_19326().field_1350 + vec3.field_1350;
        this.field_5440 = class_1113.class_1114.field_5478;
    }

    public void method_16896() {
        this.setPosition();
    }
}

