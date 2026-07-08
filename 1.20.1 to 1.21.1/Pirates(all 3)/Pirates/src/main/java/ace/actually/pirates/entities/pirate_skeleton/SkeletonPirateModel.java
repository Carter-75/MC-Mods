/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1306
 *  net.minecraft.class_3532
 *  net.minecraft.class_3881
 *  net.minecraft.class_3882
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5597
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package ace.actually.pirates.entities.pirate_skeleton;

import ace.actually.pirates.entities.pirate_skeleton.SkeletonPirateEntity;
import net.minecraft.class_1306;
import net.minecraft.class_3532;
import net.minecraft.class_3881;
import net.minecraft.class_3882;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

public class SkeletonPirateModel<T extends SkeletonPirateEntity>
extends class_5597<T>
implements class_3881,
class_3882 {
    private final class_630 root;
    private final class_630 head;
    private final class_630 hat;
    private final class_630 body;
    private final class_630 left_arm;
    private final class_630 right_arm;
    private final class_630 left_leg;
    private final class_630 right_leg;

    public SkeletonPirateModel(class_630 root) {
        this.root = root;
        this.head = root.method_32086("head");
        this.hat = this.head.method_32086("hat");
        this.hat.field_3665 = false;
        this.body = root.method_32086("body");
        this.left_arm = root.method_32086("left_arm");
        this.right_arm = root.method_32086("right_arm");
        this.left_leg = root.method_32086("left_leg");
        this.right_leg = root.method_32086("right_leg");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 head = modelPartData.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 hat = head.method_32117("hat", class_5606.method_32108().method_32101(20, 4).method_32098(6.0f, 0.0f, -5.0f, 0.0f, 0.0f, 0.0f, new class_5605(0.5f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(16, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(0, 32).method_32098(-4.5f, -0.5f, -2.5f, 9.0f, 14.0f, 5.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 left_arm = modelPartData.method_32117("left_arm", class_5606.method_32108().method_32101(40, 16).method_32096().method_32098(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new class_5605(0.0f)).method_32106(false), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 right_arm = modelPartData.method_32117("right_arm", class_5606.method_32108().method_32101(40, 16).method_32098(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 left_leg = modelPartData.method_32117("left_leg", class_5606.method_32108().method_32101(0, 16).method_32096().method_32098(-1.0f, 0.0f, -1.1f, 2.0f, 12.0f, 2.0f, new class_5605(0.0f)).method_32106(false), class_5603.method_32090((float)2.0f, (float)12.0f, (float)0.1f));
        class_5610 right_leg = modelPartData.method_32117("right_leg", class_5606.method_32108().method_32101(0, 16).method_32098(-1.0f, 0.0f, -1.1f, 2.0f, 12.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32090((float)-2.0f, (float)12.0f, (float)0.1f));
        return class_5607.method_32110((class_5609)modelData, (int)64, (int)64);
    }

    public void setupAnim(SkeletonPirateEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.right_arm.field_3654 = class_3532.method_15362((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.right_arm.field_3675 = 0.0f;
        this.right_arm.field_3674 = 0.0f;
        this.left_arm.field_3654 = class_3532.method_15362((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.left_arm.field_3675 = 0.0f;
        this.left_arm.field_3674 = 0.0f;
        this.right_leg.field_3654 = class_3532.method_15362((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.right_leg.field_3675 = 0.0f;
        this.right_leg.field_3674 = 0.0f;
        this.left_leg.field_3654 = class_3532.method_15362((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.left_leg.field_3675 = 0.0f;
        this.left_leg.field_3674 = 0.0f;
        if (entity.method_6510()) {
            this.right_arm.field_3675 = -0.1f + this.head.field_3675;
            this.right_arm.field_3654 = -1.5707964f + this.head.field_3654;
            this.left_arm.field_3654 = -0.9424779f + this.head.field_3654;
            this.left_arm.field_3675 = this.head.field_3675 - 0.4f;
            this.left_arm.field_3674 = 1.5707964f;
        }
    }

    public class_630 method_32008() {
        return this.root;
    }

    public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.hat.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.body.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.left_arm.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.right_arm.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.left_leg.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.right_leg.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    private class_630 getAttackingArm(class_1306 arm) {
        return arm == class_1306.field_6182 ? this.left_arm : this.right_arm;
    }

    public void method_2803(class_1306 arm, class_4587 matrices) {
        this.getAttackingArm(arm).method_22703(matrices);
    }

    public class_630 getHat() {
        return this.hat;
    }

    public class_630 method_2838() {
        return this.head;
    }
}

