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
import net._void.civilizations.entity.custom.RomeBossEntity;
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

public class RomeBossModel<T extends RomeBossEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public RomeBossModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(24, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(0, 32).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 0).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 sword = rightarm.method_32117("sword", class_5606.method_32108().method_32101(62, 40).method_32098(-0.5f, -7.125f, -7.1875f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(60, 51).method_32098(-0.5f, -6.125f, -7.1875f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(44, 58).method_32098(-0.5f, -5.125f, -7.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(32, 56).method_32098(-0.5f, -4.125f, -6.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(48, 52).method_32098(-0.5f, -3.125f, -5.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(48, 46).method_32098(-0.5f, -2.125f, -4.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(44, 56).method_32098(-0.5f, -2.125f, 1.8125f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 48).method_32098(-0.5f, -1.125f, -3.1875f, 1.0f, 1.0f, 7.0f, new class_5605(0.0f)).method_32101(48, 39).method_32098(-0.5f, -0.125f, -2.1875f, 1.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(60, 46).method_32098(-0.5f, 0.875f, -1.1875f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(56, 63).method_32098(-0.5f, 2.875f, -1.1875f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(48, 32).method_32098(-0.5f, 1.875f, -2.1875f, 1.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(62, 36).method_32098(-0.5f, 2.875f, 1.8125f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(56, 58).method_32098(-0.5f, 3.875f, 2.8125f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(62, 32).method_32098(-0.5f, 4.875f, 3.8125f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(32, 62).method_32098(-0.5f, 5.875f, 3.8125f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)-0.5f, (float)9.125f, (float)-4.8125f, (float)0.7854f, (float)0.0f, (float)0.0f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(16, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(0, 48).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 0).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(16, 48).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 16).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)128, (int)128);
    }

    public void setAngles(RomeBossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_48741(ModAnimations.CHINA_BOSS_MOVE, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.method_43782(entity.idleAnimationState, ModAnimations.EGYPT_BOSS_IDLE, ageInTicks, 1.0f);
        this.method_43782(entity.attackAnimationState, ModAnimations.ROME_BOSS_ATTACK, ageInTicks, 1.0f);
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

