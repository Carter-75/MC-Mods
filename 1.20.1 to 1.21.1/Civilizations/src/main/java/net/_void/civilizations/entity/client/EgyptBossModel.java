/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
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
package net._void.civilizations.entity.client;

import net._void.civilizations.entity.animation.ModAnimations;
import net._void.civilizations.entity.custom.EgyptBossEntity;
import net.minecraft.class_3532;
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

public class EgyptBossModel<T extends EgyptBossEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public EgyptBossModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108(), class_5603.method_32090((float)0.0f, (float)22.0f, (float)0.0f));
        class_5610 torso = body.method_32117("torso", class_5606.method_32108().method_32101(0, 27).method_32098(-4.0f, -26.0f, -2.0f, 8.0f, 13.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)2.0f, (float)0.0f));
        class_5610 right_leg = body.method_32117("right_leg", class_5606.method_32108().method_32101(24, 37).method_32098(-2.0f, -1.0f, -2.0f, 4.0f, 13.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-2.0f, (float)-10.0f, (float)0.0f));
        class_5610 left_leg = body.method_32117("left_leg", class_5606.method_32108().method_32101(36, 0).method_32098(-2.0f, -1.0f, -2.0f, 4.0f, 13.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)2.0f, (float)-10.0f, (float)0.0f));
        class_5610 right_arm = body.method_32117("right_arm", class_5606.method_32108().method_32101(0, 44).method_32098(-2.0f, -2.0f, -2.0f, 4.0f, 13.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-6.0f, (float)-22.0f, (float)0.0f));
        class_5610 left_arm = body.method_32117("left_arm", class_5606.method_32108(), class_5603.method_32090((float)6.0f, (float)-22.0f, (float)0.0f));
        class_5610 left_arm_r1 = left_arm.method_32117("left_arm_r1", class_5606.method_32108().method_32101(40, 37).method_32098(-1.0f, -13.0f, -1.0f, 4.0f, 13.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)-1.0f, (float)-2.0f, (float)1.0f, (float)3.1416f, (float)0.0f, (float)0.0f));
        class_5610 crook = left_arm.method_32117("crook", class_5606.method_32108().method_32101(30, 54).method_32098(4.0f, -27.0f, -9.0f, 1.0f, 13.0f, 1.0f, new class_5605(0.0f)).method_32101(56, 46).method_32098(4.0f, -28.0f, -8.0f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(56, 36).method_32098(4.0f, -31.0f, -7.0f, 1.0f, 4.0f, 1.0f, new class_5605(0.0f)).method_32101(56, 49).method_32098(4.0f, -32.0f, -8.0f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(52, 13).method_32098(4.0f, -32.0f, -10.0f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(56, 52).method_32098(4.0f, -32.0f, -11.0f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(56, 41).method_32098(4.0f, -31.0f, -12.0f, 1.0f, 4.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32091((float)-6.0f, (float)1.0f, (float)18.0f, (float)1.5708f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 12).method_32098(-4.0f, -7.0f, -4.0f, 8.0f, 7.0f, 8.0f, new class_5605(0.0f)).method_32101(50, 54).method_32098(-1.0f, 0.0f, -4.0f, 2.0f, 4.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-24.0f, (float)0.0f));
        class_5610 hat = head.method_32117("hat", class_5606.method_32108().method_32101(0, 0).method_32098(-5.0f, -37.0f, -4.0f, 10.0f, 4.0f, 8.0f, new class_5605(0.0f)).method_32101(48, 16).method_32098(-7.0f, -33.0f, -2.0f, 3.0f, 7.0f, 6.0f, new class_5605(0.0f)).method_32101(32, 17).method_32098(-6.0f, -36.0f, -2.0f, 1.0f, 3.0f, 6.0f, new class_5605(0.0f)).method_32101(52, 0).method_32098(4.0f, -33.0f, -2.0f, 3.0f, 7.0f, 6.0f, new class_5605(0.0f)).method_32101(16, 55).method_32098(5.0f, -36.0f, -2.0f, 1.0f, 3.0f, 6.0f, new class_5605(0.0f)).method_32101(24, 28).method_32098(-5.0f, -33.0f, 4.0f, 10.0f, 7.0f, 2.0f, new class_5605(0.0f)).method_32101(48, 32).method_32098(-5.0f, -36.0f, 4.0f, 10.0f, 3.0f, 1.0f, new class_5605(0.0f)).method_32101(42, 54).method_32098(5.0f, -33.0f, 4.0f, 1.0f, 7.0f, 1.0f, new class_5605(0.0f)).method_32101(46, 54).method_32098(-6.0f, -33.0f, 4.0f, 1.0f, 7.0f, 1.0f, new class_5605(0.0f)).method_32101(16, 44).method_32098(-6.0f, -28.0f, -3.0f, 3.0f, 8.0f, 1.0f, new class_5605(0.0f)).method_32101(34, 54).method_32098(3.0f, -28.0f, -3.0f, 3.0f, 8.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 29).method_32098(-5.0f, -26.0f, 2.0f, 10.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(32, 12).method_32098(0.0f, -37.0f, -5.0f, 1.0f, 3.0f, 1.0f, new class_5605(0.0f)).method_32101(56, 55).method_32098(-1.0f, -36.0f, -5.0f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 26).method_32098(-1.0f, -36.0f, -6.0f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)26.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)128, (int)128);
    }

    public void setAngles(EgyptBossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_48741(ModAnimations.EGYPT_BOSS_MOVE, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.method_43782(entity.idleAnimationState, ModAnimations.EGYPT_BOSS_IDLE, ageInTicks, 1.0f);
        this.method_43782(entity.attackAnimationState, ModAnimations.EGYPT_BOSS_ATTACK, ageInTicks, 1.0f);
        this.method_43782(entity.shootingAnimationState, ModAnimations.EGYPT_BOSS_SHOOT, ageInTicks, 1.0f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = class_3532.method_15363((float)headYaw, (float)-30.0f, (float)30.0f);
        headPitch = class_3532.method_15363((float)headPitch, (float)-25.0f, (float)45.0f);
        this.head.field_3675 = headYaw * ((float)Math.PI / 180);
        this.head.field_3654 = headPitch * ((float)Math.PI / 180);
    }

    public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.body.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    public class_630 method_32008() {
        return this.body;
    }
}

