/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 */
package backported.updates.garden.entity;

import backported.updates.garden.entity.CreakingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class CreakingModel
extends class_583<CreakingEntity> {
    private final class_630 head;
    private final class_630 rightLeg;
    private final class_630 leftLeg;
    private final class_630 leftArm;
    private final class_630 rightArm;
    private final class_630 body;

    public CreakingModel(class_630 root) {
        this.head = root.method_32086("head");
        this.rightLeg = root.method_32086("rightLeg");
        this.leftLeg = root.method_32086("leftLeg");
        this.leftArm = root.method_32086("leftArm");
        this.rightArm = root.method_32086("rightArm");
        this.body = root.method_32086("body");
    }

    public static class_5607 getTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 head = modelPartData.method_32117("head", class_5606.method_32108(), class_5603.method_32090((float)-3.25f, (float)-5.375f, (float)-0.5f));
        class_5610 headMain_r1 = head.method_32117("headMain_r1", class_5606.method_32108().method_32101(0, 18).method_32098(-3.5f, -19.5f, -5.75f, 5.0f, 12.0f, 6.0f, new class_5605(0.0f)).method_32101(0, 46).method_32098(1.5f, -22.5f, -9.75f, 0.0f, 13.0f, 4.0f, new class_5605(0.0f)).method_32101(46, 0).method_32098(1.5f, -17.5f, 0.25f, 0.0f, 10.0f, 4.0f, new class_5605(0.0f)).method_32101(34, 35).method_32098(-3.5f, -23.5f, -5.75f, 5.0f, 4.0f, 6.0f, new class_5605(0.0f)), class_5603.method_32091((float)2.75f, (float)7.875f, (float)0.25f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 rightLeg = modelPartData.method_32117("rightLeg", class_5606.method_32108(), class_5603.method_32090((float)2.75f, (float)8.0f, (float)-0.75f));
        class_5610 rightArm_r1 = rightLeg.method_32117("rightArm_r1", class_5606.method_32108().method_32101(22, 18).method_32098(-1.5f, 5.5f, 1.25f, 3.0f, 16.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)-3.25f, (float)-5.5f, (float)0.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 right_foot_r1 = rightLeg.method_32117("right_foot_r1", class_5606.method_32108().method_32101(-1, 41).method_32098(-7.5f, 21.5f, 1.25f, 9.0f, 0.0f, 5.0f, new class_5605(0.0f)), class_5603.method_32091((float)-3.25f, (float)-5.5f, (float)-3.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 leftLeg = modelPartData.method_32117("leftLeg", class_5606.method_32108(), class_5603.method_32090((float)-2.0f, (float)4.0f, (float)-0.25f));
        class_5610 left_leg_top_r1 = leftLeg.method_32117("left_leg_top_r1", class_5606.method_32108().method_32101(46, 15).method_32098(-1.5f, 0.5f, -2.75f, 3.0f, 1.0f, 3.0f, new class_5605(0.0f)).method_32101(22, 18).method_32098(-1.5f, 1.5f, -2.75f, 3.0f, 20.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.5f, (float)-1.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 left_foot_r1 = leftLeg.method_32117("left_foot_r1", class_5606.method_32108().method_32101(26, 45).method_32098(-5.5f, 21.5f, -4.75f, 7.0f, 0.0f, 5.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.5f, (float)-1.5f, (float)-2.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 leftArm = modelPartData.method_32117("leftArm", class_5606.method_32108(), class_5603.method_32090((float)-7.75f, (float)-4.0f, (float)-0.25f));
        class_5610 arm_left_bottom_r1 = leftArm.method_32117("arm_left_bottom_r1", class_5606.method_32108().method_32101(0, 0).method_32098(-1.5f, 10.5f, -8.75f, 3.0f, 4.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)7.25f, (float)6.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 leftArm_r1 = leftArm.method_32117("leftArm_r1", class_5606.method_32108().method_32101(34, 0).method_32098(-1.5f, 0.5f, -1.5f, 3.0f, 19.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 rightArm = modelPartData.method_32117("rightArm", class_5606.method_32108(), class_5603.method_32090((float)7.25f, (float)-4.0f, (float)-0.25f));
        class_5610 arm_right_bottom_r1 = rightArm.method_32117("arm_right_bottom_r1", class_5606.method_32108().method_32101(0, 36).method_32098(-1.5f, 9.5f, 6.25f, 3.0f, 3.0f, 3.0f, new class_5605(0.0f)).method_32101(8, 46).method_32098(-1.5f, -11.5f, 6.25f, 3.0f, 3.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)-7.75f, (float)6.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 rightArm_r2 = rightArm.method_32117("rightArm_r2", class_5606.method_32108().method_32101(34, 0).method_32098(-1.5f, 0.0f, -1.5f, 3.0f, 18.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        class_5610 body = modelPartData.method_32117("body", class_5606.method_32108(), class_5603.method_32090((float)1.25f, (float)1.25f, (float)0.5f));
        class_5610 body_bottom_r1 = body.method_32117("body_bottom_r1", class_5606.method_32108().method_32101(34, 22).method_32098(-2.5f, -1.5f, 0.25f, 4.0f, 7.0f, 6.0f, new class_5605(0.0f)).method_32101(0, 0).method_32098(-3.5f, -7.5f, -5.75f, 5.0f, 6.0f, 12.0f, new class_5605(0.0f)), class_5603.method_32091((float)-1.75f, (float)1.25f, (float)-0.75f, (float)0.0f, (float)1.5708f, (float)0.0f));
        return class_5607.method_32110((class_5609)modelData, (int)64, (int)64);
    }

    public void method_2828(class_4587 matrices, class_4588 vertices, int light, int overlay, int color) {
        this.head.method_22699(matrices, vertices, light, overlay, color);
        this.rightLeg.method_22699(matrices, vertices, light, overlay, color);
        this.leftLeg.method_22699(matrices, vertices, light, overlay, color);
        this.leftArm.method_22699(matrices, vertices, light, overlay, color);
        this.rightArm.method_22699(matrices, vertices, light, overlay, color);
        this.body.method_22699(matrices, vertices, light, overlay, color);
    }

    public void setAngles(CreakingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.rightArm.field_3654 = class_3532.method_15362((float)(limbAngle * 0.6662f)) * 1.1f * limbDistance;
        this.leftArm.field_3654 = class_3532.method_15362((float)(limbAngle * 0.6662f + (float)Math.PI)) * 1.1f * limbDistance;
        this.rightLeg.field_3654 = class_3532.method_15362((float)(limbAngle * 0.6662f + (float)Math.PI)) * 1.1f * limbDistance;
        this.leftLeg.field_3654 = class_3532.method_15362((float)(limbAngle * 0.6662f)) * 1.1f * limbDistance;
        this.head.field_3654 = headPitch * ((float)Math.PI / 180);
        this.head.field_3675 = headYaw * ((float)Math.PI / 180);
    }
}

