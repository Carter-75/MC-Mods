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
import net._void.civilizations.entity.custom.ChinaGuardEntity;
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

public class ChinaGuardModel<T extends ChinaGuardEntity>
extends class_5597<T> {
    private final class_630 body;
    private final class_630 head;

    public ChinaGuardModel(class_630 root) {
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32098(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new class_5605(-0.02f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5610 rightarm = body.method_32117("rightarm", class_5606.method_32108().method_32101(24, 16).method_32098(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)-5.0f, (float)2.0f, (float)0.0f, (float)-0.4556f, (float)-0.4478f, (float)-0.9828f));
        class_5610 leftarm = body.method_32117("leftarm", class_5606.method_32108().method_32101(0, 32).method_32098(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)5.0f, (float)2.0f, (float)0.0f, (float)-0.582f, (float)0.1975f, (float)0.2898f));
        class_5610 bow = leftarm.method_32117("bow", class_5606.method_32108().method_32101(46, 38).method_32098(6.25f, -4.1042f, -0.5f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(46, 35).method_32098(5.25f, -2.1042f, -0.5f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 46).method_32098(4.25f, -0.1042f, -0.5f, 1.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(44, 45).method_32098(0.25f, 3.8958f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(38, 45).method_32098(-1.75f, 4.8958f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(44, 43).method_32098(-3.75f, 5.8958f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(0, 48).method_32098(2.25f, 2.8958f, -0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(44, 41).method_32098(2.25f, 1.8958f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 44).method_32098(1.25f, 0.8958f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(38, 43).method_32098(0.25f, -0.1042f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(42, 33).method_32098(-0.75f, -1.1042f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(44, 47).method_32098(7.25f, -6.1042f, -0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 24).method_32098(4.25f, -7.1042f, -0.5f, 3.0f, 3.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 36).method_32098(-1.75f, -5.1042f, -0.5f, 2.0f, 4.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 32).method_32098(0.25f, -6.1042f, -0.5f, 4.0f, 3.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 47).method_32098(-5.75f, -7.1042f, -0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(42, 31).method_32098(-5.75f, -6.1042f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(38, 41).method_32098(-4.75f, -5.1042f, -0.5f, 2.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 41).method_32098(-3.75f, -4.1042f, -0.5f, 2.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 28).method_32098(-4.75f, -2.1042f, -0.5f, 3.0f, 2.0f, 1.0f, new class_5605(0.0f)).method_32101(32, 36).method_32098(-5.75f, -0.1042f, -0.5f, 3.0f, 4.0f, 1.0f, new class_5605(0.0f)).method_32101(40, 20).method_32098(-6.75f, 3.8958f, -0.5f, 3.0f, 3.0f, 1.0f, new class_5605(0.0f)).method_32101(36, 47).method_32098(-5.75f, 6.8958f, -0.5f, 1.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.4514f, (float)7.6889f, (float)0.5f, (float)1.7063f, (float)0.8189f, (float)-1.4672f));
        class_5610 rightleg = body.method_32117("rightleg", class_5606.method_32108().method_32101(32, 0).method_32098(-2.1f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
        class_5610 leftleg = body.method_32117("leftleg", class_5606.method_32108().method_32101(16, 32).method_32098(-1.9f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)64, (int)64);
    }

    public void setAngles(ChinaGuardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.method_48741(ModAnimations.CHINA_GUARD_WALK, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        this.method_43782(entity.shootingAnimationState, ModAnimations.CHINA_GUARD_SHOOT, ageInTicks, 1.0f);
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

