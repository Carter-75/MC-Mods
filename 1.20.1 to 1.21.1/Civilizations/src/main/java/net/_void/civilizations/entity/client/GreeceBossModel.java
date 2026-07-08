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
import net._void.civilizations.entity.custom.GreeceBossEntity;
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

public class GreeceBossModel<T extends GreeceBossEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public GreeceBossModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(26, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(0, 32).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(24, 44).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(40, 44).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 shield = rightarm.method_32117("shield", class_5606.method_32108().method_32101(72, 44).method_32098(-3.0f, 5.0f, -2.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(66, 39).method_32098(-3.0f, -6.0f, -2.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 60).method_32098(-3.0f, -5.0f, -4.0f, 1.0f, 1.0f, 8.0f, new class_5605(0.0f)).method_32101(54, 0).method_32098(-3.0f, 4.0f, -4.0f, 1.0f, 1.0f, 8.0f, new class_5605(0.0f)).method_32101(24, 32).method_32098(-3.0f, 2.0f, -5.0f, 1.0f, 2.0f, 10.0f, new class_5605(0.0f)).method_32101(32, 0).method_32098(-3.0f, -4.0f, -5.0f, 1.0f, 2.0f, 10.0f, new class_5605(0.0f)).method_32101(0, 16).method_32098(-3.0f, -2.0f, -6.0f, 1.0f, 4.0f, 12.0f, new class_5605(0.0f)), class_5603.method_32090((float)-1.0f, (float)9.0f, (float)0.0f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(0, 48).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(50, 12).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 sword = leftarm.method_32117("sword", class_5606.method_32108().method_32101(40, 12).method_32098(-0.5f, -7.75f, 5.8125f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(72, 0).method_32098(-0.5f, -6.75f, 3.8125f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(0, 70).method_32098(-0.5f, -5.75f, 2.8125f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(48, 69).method_32098(-0.5f, -4.75f, 1.8125f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(66, 66).method_32098(-0.5f, -3.75f, 0.8125f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(66, 33).method_32098(-0.5f, -1.75f, -1.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(66, 27).method_32098(-0.5f, -0.75f, -2.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(66, 60).method_32098(-0.5f, -2.75f, -0.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(66, 15).method_32098(-0.5f, 1.25f, -4.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(66, 21).method_32098(-0.5f, 0.25f, -3.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(72, 54).method_32098(-0.5f, 3.25f, -5.1875f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(66, 9).method_32098(-0.5f, 2.25f, -5.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(46, 32).method_32098(-0.5f, 3.25f, -7.1875f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(0, 64).method_32098(-0.5f, 4.25f, -7.1875f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(72, 49).method_32098(-0.5f, 5.25f, -7.1875f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 12).method_32098(-0.5f, 6.25f, -7.1875f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.5f, (float)9.75f, (float)-8.8125f, (float)2.3562f, (float)0.0f, (float)0.0f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(50, 28).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(56, 44).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(16, 60).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 60).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)128, (int)128);
    }

    public void setAngles(GreeceBossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_48741(ModAnimations.CHINA_BOSS_MOVE, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.method_43782(entity.idleAnimationState, ModAnimations.EGYPT_BOSS_IDLE, ageInTicks, 1.0f);
        this.method_43782(entity.attackAnimationState, ModAnimations.GREECE_BOSS_ATTACK, ageInTicks, 1.0f);
        this.method_43782(entity.deffendAnimationState, ModAnimations.GREECE_BOSS_DEFFEND, ageInTicks, 1.0f);
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

