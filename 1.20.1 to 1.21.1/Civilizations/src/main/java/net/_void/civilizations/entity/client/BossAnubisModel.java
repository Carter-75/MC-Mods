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
import net._void.civilizations.entity.custom.BossAnubisEntity;
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

public class BossAnubisModel<T extends BossAnubisEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public BossAnubisModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(24, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)).method_32101(40, 64).method_32098(-2.0f, -4.0f, -8.0f, 4.0f, 4.0f, 4.0f, new class_5605(-0.02f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 hat = head.method_32117("hat", class_5606.method_32108().method_32101(54, 0).method_32098(3.0f, -26.0f, -3.0f, 3.0f, 7.0f, 1.0f, new class_5605(0.0f)).method_32101(0, 32).method_32098(-4.0f, -33.0f, -2.0f, 8.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(64, 14).method_32098(-4.0f, -32.0f, 4.0f, 8.0f, 8.0f, 1.0f, new class_5605(0.0f)).method_32101(64, 0).method_32098(4.0f, -32.0f, -2.0f, 1.0f, 8.0f, 6.0f, new class_5605(0.0f)).method_32101(60, 29).method_32098(-5.0f, -32.0f, -2.0f, 1.0f, 8.0f, 6.0f, new class_5605(0.0f)).method_32101(16, 39).method_32098(-6.0f, -26.0f, -3.0f, 3.0f, 7.0f, 1.0f, new class_5605(0.0f)).method_32101(24, 42).method_32098(1.0f, -38.0f, -3.0f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 29).method_32098(1.0f, -36.0f, -3.0f, 2.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 13).method_32098(1.0f, -34.0f, -3.0f, 3.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(24, 39).method_32098(-2.0f, -38.0f, -3.0f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 29).method_32098(-3.0f, -36.0f, -3.0f, 2.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 13).method_32098(-4.0f, -34.0f, -3.0f, 3.0f, 2.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(28, 32).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(0, 39).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 weapon = rightarm.method_32117("weapon", class_5606.method_32108().method_32101(60, 43).method_32098(-0.5f, -0.6875f, 4.0f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(24, 45).method_32098(-0.5f, -0.6875f, -5.0f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(64, 50).method_32098(-0.5f, -5.6875f, -3.0f, 1.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(22, 64).method_32098(-0.5f, -4.6875f, -4.0f, 1.0f, 1.0f, 8.0f, new class_5605(0.0f)).method_32101(32, 0).method_32098(-0.5f, -3.6875f, -5.0f, 1.0f, 3.0f, 10.0f, new class_5605(0.0f)).method_32101(64, 43).method_32098(-0.5f, -0.6875f, -3.0f, 1.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(54, 8).method_32098(-0.5f, 0.3125f, -2.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(16, 64).method_32098(-0.5f, 1.3125f, -1.0f, 1.0f, 20.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32091((float)-0.5f, (float)8.6875f, (float)-13.0f, (float)1.5708f, (float)0.0f, (float)0.0f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(44, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 13).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(16, 48).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 48).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(48, 48).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(0, 55).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)128, (int)128);
    }

    public void setAngles(BossAnubisEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_43782(entity.attackAnimationState, ModAnimations.ANUBIS_ATTACK, ageInTicks, 1.0f);
        this.method_43782(entity.spellAnimationState, ModAnimations.ANUBIS_SPELL, ageInTicks, 1.0f);
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

