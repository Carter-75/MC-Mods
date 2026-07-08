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
import net._void.civilizations.entity.custom.NordicBossEntity;
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

public class NordicBossModel<T extends NordicBossEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public NordicBossModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 beard = head.method_32117("beard", class_5606.method_32108().method_32101(66, 34).method_32098(-3.0f, -24.0f, -4.0f, 6.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(68, 26).method_32098(-2.0f, -23.0f, -4.0f, 4.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(74, 47).method_32098(-1.0f, -22.0f, -4.0f, 2.0f, 2.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        class_5610 hair = head.method_32117("hair", class_5606.method_32108().method_32101(24, 16).method_32098(-2.0f, -33.0f, -5.0f, 4.0f, 2.0f, 10.0f, new class_5605(0.0f)).method_32101(72, 58).method_32098(-2.0f, -31.0f, 4.0f, 4.0f, 6.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(32, 0).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 axe = rightarm.method_32117("axe", class_5606.method_32108().method_32101(52, 20).method_32098(-0.5f, -4.9783f, -3.0435f, 1.0f, 1.0f, 7.0f, new class_5605(0.0f)).method_32101(36, 55).method_32098(-0.5f, -3.9783f, -4.0435f, 1.0f, 1.0f, 8.0f, new class_5605(0.0f)).method_32101(48, 12).method_32098(-0.5f, -3.9783f, -8.0435f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(52, 10).method_32098(-0.5f, -2.9783f, -5.0435f, 1.0f, 1.0f, 9.0f, new class_5605(0.0f)).method_32101(16, 49).method_32098(-0.5f, -2.9783f, -8.0435f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(16, 46).method_32098(-0.5f, -1.9783f, 1.9565f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(48, 10).method_32098(-0.5f, -0.9783f, 2.9565f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 0).method_32098(-0.5f, -1.9783f, -8.0435f, 1.0f, 1.0f, 9.0f, new class_5605(0.0f)).method_32101(46, 28).method_32098(-0.5f, -0.9783f, -8.0435f, 1.0f, 1.0f, 9.0f, new class_5605(0.0f)).method_32101(66, 28).method_32098(-0.5f, 3.0217f, -5.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(36, 64).method_32098(-0.5f, 1.0217f, -7.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(16, 65).method_32098(-0.5f, 2.0217f, -6.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(24, 28).method_32098(-0.5f, 0.0217f, -8.0435f, 1.0f, 1.0f, 10.0f, new class_5605(0.0f)).method_32101(48, 73).method_32098(-0.5f, 1.0217f, -0.0435f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(0, 73).method_32098(-0.5f, 2.0217f, 0.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(72, 69).method_32098(-0.5f, 3.0217f, 1.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(72, 65).method_32098(-0.5f, 4.0217f, 2.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(40, 70).method_32098(-0.5f, 5.0217f, 3.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(28, 65).method_32098(-0.5f, 6.0217f, 4.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(16, 43).method_32098(-0.5f, 7.0217f, 5.9565f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(0, 67).method_32098(-0.5f, -5.9783f, -2.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(48, 67).method_32098(-0.5f, -6.9783f, -3.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(60, 67).method_32098(-0.5f, -7.9783f, -4.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)), class_5603.method_32091((float)-0.5f, (float)7.9783f, (float)-9.9565f, (float)0.7854f, (float)0.0f, (float)0.0f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(22, 39).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 axe2 = leftarm.method_32117("axe2", class_5606.method_32108().method_32101(0, 59).method_32098(-0.5f, -4.9783f, -3.0435f, 1.0f, 1.0f, 7.0f, new class_5605(0.0f)).method_32101(54, 58).method_32098(-0.5f, -3.9783f, -4.0435f, 1.0f, 1.0f, 8.0f, new class_5605(0.0f)).method_32101(48, 14).method_32098(-0.5f, -3.9783f, -8.0435f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 38).method_32098(-0.5f, -2.9783f, -5.0435f, 1.0f, 1.0f, 9.0f, new class_5605(0.0f)).method_32101(16, 52).method_32098(-0.5f, -2.9783f, -8.0435f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(48, 64).method_32098(-0.5f, -1.9783f, 1.9565f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(66, 36).method_32098(-0.5f, -0.9783f, 2.9565f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(54, 48).method_32098(-0.5f, -1.9783f, -8.0435f, 1.0f, 1.0f, 9.0f, new class_5605(0.0f)).method_32101(16, 55).method_32098(-0.5f, -0.9783f, -8.0435f, 1.0f, 1.0f, 9.0f, new class_5605(0.0f)).method_32101(68, 0).method_32098(-0.5f, 3.0217f, -5.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(68, 20).method_32098(-0.5f, 1.0217f, -7.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(28, 70).method_32098(-0.5f, 2.0217f, -6.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(0, 32).method_32098(-0.5f, 0.0217f, -8.0435f, 1.0f, 1.0f, 10.0f, new class_5605(0.0f)).method_32101(56, 73).method_32098(-0.5f, 1.0217f, -0.0435f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(64, 73).method_32098(-0.5f, 2.0217f, 0.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(72, 73).method_32098(-0.5f, 3.0217f, 1.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(74, 36).method_32098(-0.5f, 4.0217f, 2.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(40, 74).method_32098(-0.5f, 5.0217f, 3.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(74, 40).method_32098(-0.5f, 6.0217f, 4.9565f, 1.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(74, 44).method_32098(-0.5f, 7.0217f, 5.9565f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(12, 71).method_32098(-0.5f, -5.9783f, -2.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(72, 6).method_32098(-0.5f, -6.9783f, -3.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(72, 12).method_32098(-0.5f, -7.9783f, -4.0435f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.5f, (float)7.9783f, (float)-9.9565f, (float)0.7854f, (float)0.0f, (float)0.0f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(38, 39).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(0, 43).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)128, (int)128);
    }

    public void setAngles(NordicBossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_48741(ModAnimations.EGYPT_CIVILIAN_MOVE, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.method_43782(entity.idleAnimationState, ModAnimations.EGYPT_CIVILIAN_IDLE, ageInTicks, 1.0f);
        this.method_43782(entity.attackAnimationState, ModAnimations.NORDIC_BOSS_ATTACK, ageInTicks, 1.0f);
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

