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
import net._void.civilizations.entity.custom.BossMercuryEntity;
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

public class BossMercuryModel<T extends BossMercuryEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public BossMercuryModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(24, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 hat = head.method_32117("hat", class_5606.method_32108().method_32101(22, 64).method_32098(4.0f, -32.0f, -3.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(64, 15).method_32098(-5.0f, -32.0f, -3.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        class_5610 r1 = hat.method_32117("r1", class_5606.method_32108().method_32101(64, 20).method_32098(-6.0f, -33.0f, -3.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 r2 = hat.method_32117("r2", class_5606.method_32108().method_32101(32, 61).method_32098(-8.0f, -34.0f, -3.0f, 2.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 r3 = hat.method_32117("r3", class_5606.method_32108().method_32101(52, 54).method_32098(-11.0f, -35.0f, -2.0f, 3.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 l1 = hat.method_32117("l1", class_5606.method_32108().method_32101(64, 25).method_32098(5.0f, -33.0f, -3.0f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 l2 = hat.method_32117("l2", class_5606.method_32108().method_32101(0, 64).method_32098(6.0f, -34.0f, -3.0f, 2.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 l3 = hat.method_32117("l3", class_5606.method_32108().method_32101(32, 56).method_32098(8.0f, -35.0f, -2.0f, 3.0f, 1.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(0, 32).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 0).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-5.0f, (float)2.0f, (float)0.0f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(16, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)5.0f, (float)2.0f, (float)0.0f));
        class_5610 weapon = leftarm.method_32117("weapon", class_5606.method_32108().method_32101(64, 33).method_32098(-0.5f, -1.4074f, 5.5f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(12, 64).method_32098(-0.5f, -2.4074f, 3.5f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 32).method_32098(-0.5f, -3.4074f, 0.5f, 1.0f, 1.0f, 7.0f, new class_5605(0.0f)).method_32101(52, 47).method_32098(-0.5f, -4.4074f, 0.5f, 1.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(58, 59).method_32098(-0.5f, -5.4074f, 0.5f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(64, 10).method_32098(-0.5f, -6.4074f, 0.5f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(64, 30).method_32098(-0.5f, -1.4074f, -7.5f, 1.0f, 1.0f, 2.0f, new class_5605(0.0f)).method_32101(64, 5).method_32098(-0.5f, -2.4074f, -7.5f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(32, 48).method_32098(-0.5f, -3.4074f, -7.5f, 1.0f, 1.0f, 7.0f, new class_5605(0.0f)).method_32101(52, 40).method_32098(-0.5f, -4.4074f, -6.5f, 1.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(46, 59).method_32098(-0.5f, -5.4074f, -5.5f, 1.0f, 1.0f, 5.0f, new class_5605(0.0f)).method_32101(64, 0).method_32098(-0.5f, -6.4074f, -4.5f, 1.0f, 1.0f, 4.0f, new class_5605(0.0f)).method_32101(66, 44).method_32098(-0.5f, -1.4074f, 0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(66, 42).method_32098(-0.5f, -0.4074f, 1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(66, 40).method_32098(-0.5f, 0.5926f, 0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 66).method_32098(-0.5f, -1.4074f, -1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(36, 66).method_32098(-0.5f, -0.4074f, -2.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 66).method_32098(-0.5f, 0.5926f, -1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(64, 65).method_32098(-0.5f, 4.5926f, -1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(60, 65).method_32098(-0.5f, 3.5926f, -2.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(56, 65).method_32098(-0.5f, 2.5926f, -1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(52, 65).method_32098(-0.5f, 2.5926f, 0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 65).method_32098(-0.5f, 3.5926f, 1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(44, 65).method_32098(-0.5f, 4.5926f, 0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(64, 38).method_32098(-0.5f, 6.5926f, -1.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(64, 36).method_32098(-0.5f, 6.5926f, 0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(48, 40).method_32098(-0.5f, -7.4074f, -0.5f, 1.0f, 18.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.5f, (float)8.4074f, (float)-11.5f, (float)1.5708f, (float)0.0f, (float)0.0f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(0, 48).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 0).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(16, 48).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)).method_32101(48, 16).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.25f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)128, (int)128);
    }

    public void setAngles(BossMercuryEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_43782(entity.idleAnimationState, ModAnimations.MERCURY_IDLE, ageInTicks, 1.0f);
        this.method_43782(entity.attackAnimationState, ModAnimations.MERCURY_ATTACK, ageInTicks, 1.0f);
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

