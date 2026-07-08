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
import net._void.civilizations.entity.custom.ChinaBossEntity;
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

public class ChinaBossModel<T extends ChinaBossEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public ChinaBossModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(24, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.25f)).method_32101(48, 16).method_32098(4.0f, 12.0f, -1.0f, 1.0f, 11.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)).method_32101(16, 48).method_32098(-2.0f, -10.0f, 2.0f, 4.0f, 4.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 beard = head.method_32117("beard", class_5606.method_32108().method_32101(48, 31).method_32098(-3.0f, -24.0f, -4.0f, 6.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 50).method_32098(-2.0f, -23.0f, -4.0f, 4.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(52, 50).method_32098(-1.0f, -21.0f, -4.0f, 2.0f, 3.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(0, 32).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 0).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(16, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 sword = leftarm.method_32117("sword", class_5606.method_32108().method_32101(54, 18).method_32098(5.0f, -10.0f, -2.0f, 3.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(42, 52).method_32098(4.0f, -9.0f, -2.0f, 4.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(46, 48).method_32098(3.0f, -8.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 45).method_32098(2.0f, -7.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 43).method_32098(1.0f, -6.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 41).method_32098(0.0f, -5.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 39).method_32098(-1.0f, -4.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 37).method_32098(-2.0f, -3.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 35).method_32098(-3.0f, -2.0f, -2.0f, 5.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 24).method_32098(-5.0f, -2.0f, -2.0f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 29).method_32098(-6.0f, -1.0f, -2.0f, 7.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 33).method_32098(-6.0f, 0.0f, -2.0f, 6.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(42, 50).method_32098(-5.0f, 1.0f, -2.0f, 4.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 22).method_32098(-3.0f, 3.0f, -2.0f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 48).method_32098(-6.0f, 2.0f, -2.0f, 6.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 16).method_32098(-7.0f, 3.0f, -2.0f, 3.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 53).method_32098(-8.0f, 4.0f, -2.0f, 3.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 20).method_32098(-8.0f, 5.0f, -2.0f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32091((float)2.0f, (float)9.0f, (float)-7.0f, (float)1.5708f, (float)0.8727f, (float)1.5708f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(0, 48).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(48, 0).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)64, (int)64);
    }

    public void setAngles(ChinaBossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_48741(ModAnimations.CHINA_BOSS_MOVE, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.method_43782(entity.idleAnimationState, ModAnimations.EGYPT_CIVILIAN_IDLE, ageInTicks, 1.0f);
        this.method_43782(entity.attackAnimationState, ModAnimations.CHINA_BOSS_ATTACK, ageInTicks, 1.0f);
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

