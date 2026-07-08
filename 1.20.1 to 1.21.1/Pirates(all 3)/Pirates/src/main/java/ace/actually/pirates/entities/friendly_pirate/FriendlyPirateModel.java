/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1306
 *  net.minecraft.class_3532
 *  net.minecraft.class_3881
 *  net.minecraft.class_3882
 *  net.minecraft.class_4587
 *  net.minecraft.class_5597
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package ace.actually.pirates.entities.friendly_pirate;

import ace.actually.pirates.entities.friendly_pirate.FriendlyPirateEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1306;
import net.minecraft.class_3532;
import net.minecraft.class_3881;
import net.minecraft.class_3882;
import net.minecraft.class_4587;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class FriendlyPirateModel<T extends FriendlyPirateEntity>
extends class_5597<T>
implements class_3881,
class_3882 {
    private final class_630 root;
    private final class_630 head;
    private final class_630 hat;
    private final class_630 arms;
    private final class_630 leftLeg;
    private final class_630 rightLeg;
    private final class_630 rightArm;
    private final class_630 leftArm;

    public FriendlyPirateModel(class_630 root) {
        this.root = root;
        this.head = root.method_32086("head");
        this.hat = this.head.method_32086("hat");
        this.hat.field_3665 = false;
        this.arms = root.method_32086("arms");
        this.leftLeg = root.method_32086("left_leg");
        this.rightLeg = root.method_32086("right_leg");
        this.leftArm = root.method_32086("left_arm");
        this.rightArm = root.method_32086("right_arm");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 modelPartData2 = modelPartData.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-4.0f, -10.0f, -4.0f, 8.0f, 10.0f, 8.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        modelPartData2.method_32117("hat", class_5606.method_32108().method_32101(32, 0).method_32098(-4.0f, -10.0f, -4.0f, 8.0f, 12.0f, 8.0f, new class_5605(0.45f)), class_5603.field_27701);
        modelPartData2.method_32117("nose", class_5606.method_32108().method_32101(24, 0).method_32097(-1.0f, -1.0f, -6.0f, 2.0f, 4.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)-2.0f, (float)0.0f));
        modelPartData.method_32117("body", class_5606.method_32108().method_32101(16, 20).method_32097(-4.0f, 0.0f, -3.0f, 8.0f, 12.0f, 6.0f).method_32101(0, 38).method_32098(-4.0f, 0.0f, -3.0f, 8.0f, 20.0f, 6.0f, new class_5605(0.5f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 modelPartData3 = modelPartData.method_32117("arms", class_5606.method_32108().method_32101(44, 22).method_32097(-8.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f).method_32101(40, 38).method_32097(-4.0f, 2.0f, -2.0f, 8.0f, 4.0f, 4.0f), class_5603.method_32091((float)0.0f, (float)3.0f, (float)-1.0f, (float)-0.75f, (float)0.0f, (float)0.0f));
        modelPartData3.method_32117("left_shoulder", class_5606.method_32108().method_32101(44, 22).method_32096().method_32097(4.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f), class_5603.field_27701);
        modelPartData.method_32117("right_leg", class_5606.method_32108().method_32101(0, 22).method_32097(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), class_5603.method_32090((float)-2.0f, (float)12.0f, (float)0.0f));
        modelPartData.method_32117("left_leg", class_5606.method_32108().method_32101(0, 22).method_32096().method_32097(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f), class_5603.method_32090((float)2.0f, (float)12.0f, (float)0.0f));
        modelPartData.method_32117("right_arm", class_5606.method_32108().method_32101(40, 46).method_32097(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        modelPartData.method_32117("left_arm", class_5606.method_32108().method_32101(40, 46).method_32096().method_32097(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)64, (int)64);
    }

    public class_630 method_32008() {
        return this.root;
    }

    public void setupAnim(T illagerEntity, float f, float g, float h, float i, float j) {
        this.head.field_3675 = i * ((float)Math.PI / 180);
        this.head.field_3654 = j * ((float)Math.PI / 180);
        if (this.field_3449) {
            this.rightArm.field_3654 = -0.62831855f;
            this.rightArm.field_3675 = 0.0f;
            this.rightArm.field_3674 = 0.0f;
            this.leftArm.field_3654 = -0.62831855f;
            this.leftArm.field_3675 = 0.0f;
            this.leftArm.field_3674 = 0.0f;
            this.rightLeg.field_3654 = -1.4137167f;
            this.rightLeg.field_3675 = 0.31415927f;
            this.rightLeg.field_3674 = 0.07853982f;
            this.leftLeg.field_3654 = -1.4137167f;
            this.leftLeg.field_3675 = -0.31415927f;
            this.leftLeg.field_3674 = -0.07853982f;
        } else {
            this.rightArm.field_3654 = class_3532.method_15362((float)(f * 0.6662f + (float)Math.PI)) * 2.0f * g * 0.5f;
            this.rightArm.field_3675 = 0.0f;
            this.rightArm.field_3674 = 0.0f;
            this.leftArm.field_3654 = class_3532.method_15362((float)(f * 0.6662f)) * 2.0f * g * 0.5f;
            this.leftArm.field_3675 = 0.0f;
            this.leftArm.field_3674 = 0.0f;
            this.rightLeg.field_3654 = class_3532.method_15362((float)(f * 0.6662f)) * 1.4f * g * 0.5f;
            this.rightLeg.field_3675 = 0.0f;
            this.rightLeg.field_3674 = 0.0f;
            this.leftLeg.field_3654 = class_3532.method_15362((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * g * 0.5f;
            this.leftLeg.field_3675 = 0.0f;
            this.leftLeg.field_3674 = 0.0f;
        }
        if (illagerEntity.method_6510()) {
            this.rightArm.field_3675 = -0.1f + this.head.field_3675;
            this.rightArm.field_3654 = -1.5707964f + this.head.field_3654;
            this.leftArm.field_3654 = -0.9424779f + this.head.field_3654;
            this.leftArm.field_3675 = this.head.field_3675 - 0.4f;
            this.leftArm.field_3674 = 1.5707964f;
        }
        this.arms.field_3665 = false;
        this.leftArm.field_3665 = true;
        this.rightArm.field_3665 = true;
    }

    private class_630 getAttackingArm(class_1306 arm) {
        return arm == class_1306.field_6182 ? this.leftArm : this.rightArm;
    }

    public class_630 getHat() {
        return this.hat;
    }

    public class_630 method_2838() {
        return this.head;
    }

    public void method_2803(class_1306 arm, class_4587 matrices) {
        this.getAttackingArm(arm).method_22703(matrices);
    }
}

