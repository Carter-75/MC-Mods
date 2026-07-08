/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1306
 *  net.minecraft.class_2960
 *  net.minecraft.class_3881
 *  net.minecraft.class_4587
 *  net.minecraft.class_5597
 *  net.minecraft.class_5601
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 *  net.minecraft.class_7184
 *  net.minecraft.class_7833
 */
package backported.updates.copper.client.model;

import backported.updates.copper.client.animation.CopperGolemAnimation;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemState;
import net.minecraft.class_1306;
import net.minecraft.class_2960;
import net.minecraft.class_3881;
import net.minecraft.class_4587;
import net.minecraft.class_5597;
import net.minecraft.class_5601;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;
import net.minecraft.class_7184;
import net.minecraft.class_7833;

public class CopperGolemModel
extends class_5597<CopperGolemEntity>
implements class_3881 {
    public static final class_5601 LAYER_LOCATION = new class_5601(class_2960.method_60655((String)"copperagebackport", (String)"copper_golem"), "main");
    public static final class_5601 STATUE_STANDING = new class_5601(class_2960.method_60655((String)"copperagebackport", (String)"copper_golem_statue_standing"), "main");
    public static final class_5601 STATUE_RUNNING = new class_5601(class_2960.method_60655((String)"copperagebackport", (String)"copper_golem_statue_running"), "main");
    public static final class_5601 STATUE_SITTING = new class_5601(class_2960.method_60655((String)"copperagebackport", (String)"copper_golem_statue_sitting"), "main");
    public static final class_5601 STATUE_STAR = new class_5601(class_2960.method_60655((String)"copperagebackport", (String)"copper_golem_statue_star"), "main");
    private final class_630 root;
    private final class_630 head;
    private final class_630 body;
    private final class_630 rightArm;
    private final class_630 leftArm;
    private final class_630 rightLeg;
    private final class_630 leftLeg;
    private final class_7184 walkAnimation;
    private final class_7184 walkWithItemAnimation;
    private final class_7184 idleAnimation;
    private final class_7184 interactionGetItem;
    private final class_7184 interactionGetNoItem;
    private final class_7184 interactionDropItem;
    private final class_7184 interactionDropNoItem;
    private final class_7184 pressButton;

    public CopperGolemModel(class_630 root) {
        this.root = root;
        this.body = root.method_32086("body");
        this.head = this.body.method_32086("head");
        this.rightArm = this.body.method_32086("right_arm");
        this.leftArm = this.body.method_32086("left_arm");
        this.rightLeg = root.method_32086("right_leg");
        this.leftLeg = root.method_32086("left_leg");
        this.walkAnimation = CopperGolemAnimation.COPPER_GOLEM_WALK;
        this.walkWithItemAnimation = CopperGolemAnimation.COPPER_GOLEM_WALK_ITEM;
        this.idleAnimation = CopperGolemAnimation.COPPER_GOLEM_IDLE;
        this.interactionGetItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_NOITEM_GET;
        this.interactionGetNoItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_NOITEM_NOGET;
        this.interactionDropItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_ITEM_DROP;
        this.interactionDropNoItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_ITEM_NODROP;
        this.pressButton = CopperGolemAnimation.COPPER_GOLEM_PRESS_BUTTON;
    }

    public static class_5607 createBodyLayer() {
        class_5609 meshdefinition = new class_5609();
        class_5610 partdefinition = meshdefinition.method_32111();
        class_5610 body = partdefinition.method_32117("body", class_5606.method_32108().method_32101(0, 15).method_32098(-4.0f, -6.0f, -3.0f, 8.0f, 6.0f, 6.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -5.0f, -5.0f, 8.0f, 5.0f, 10.0f, new class_5605(0.015f)).method_32101(56, 0).method_32098(-1.0f, -2.0f, -6.0f, 2.0f, 3.0f, 2.0f, new class_5605(0.0f)).method_32101(37, 8).method_32098(-1.0f, -9.0f, -1.0f, 2.0f, 4.0f, 2.0f, new class_5605(-0.015f)).method_32101(37, 0).method_32098(-2.0f, -13.0f, -2.0f, 4.0f, 4.0f, 4.0f, new class_5605(-0.015f)), class_5603.method_32090((float)0.0f, (float)-6.0f, (float)0.0f));
        body.method_32117("right_arm", class_5606.method_32108().method_32101(36, 16).method_32098(-3.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-4.0f, (float)-6.0f, (float)0.0f));
        body.method_32117("left_arm", class_5606.method_32108().method_32101(50, 16).method_32098(0.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)4.0f, (float)-6.0f, (float)0.0f));
        partdefinition.method_32117("right_leg", class_5606.method_32108().method_32101(0, 27).method_32098(-4.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        partdefinition.method_32117("left_leg", class_5606.method_32108().method_32101(16, 27).method_32098(0.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)meshdefinition, (int)64, (int)64);
    }

    public static class_5607 createStandingStatueBodyLayer() {
        class_5609 meshdefinition = new class_5609();
        class_5610 partdefinition = meshdefinition.method_32111();
        class_5610 body = partdefinition.method_32117("body", class_5606.method_32108().method_32101(0, 15).method_32098(-4.0f, -6.0f, -3.0f, 8.0f, 6.0f, 6.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -5.0f, -5.0f, 8.0f, 5.0f, 10.0f, new class_5605(0.015f)).method_32101(56, 0).method_32098(-1.0f, -2.0f, -6.0f, 2.0f, 3.0f, 2.0f, new class_5605(0.0f)).method_32101(37, 8).method_32098(-1.0f, -9.0f, -1.0f, 2.0f, 4.0f, 2.0f, new class_5605(-0.015f)).method_32101(37, 0).method_32098(-2.0f, -13.0f, -2.0f, 4.0f, 4.0f, 4.0f, new class_5605(-0.015f)), class_5603.method_32090((float)0.0f, (float)-6.0f, (float)0.0f));
        body.method_32117("right_arm", class_5606.method_32108().method_32101(36, 16).method_32098(-3.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)-4.0f, (float)-6.0f, (float)0.0f));
        body.method_32117("left_arm", class_5606.method_32108().method_32101(50, 16).method_32098(0.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)4.0f, (float)-6.0f, (float)0.0f));
        partdefinition.method_32117("right_leg", class_5606.method_32108().method_32101(0, 27).method_32098(-4.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        partdefinition.method_32117("left_leg", class_5606.method_32108().method_32101(16, 27).method_32098(0.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)meshdefinition, (int)64, (int)64);
    }

    public static class_5607 createRunningPoseBodyLayer() {
        class_5609 meshdefinition = new class_5609();
        class_5610 partdefinition = meshdefinition.method_32111();
        class_5610 body = partdefinition.method_32117("body", class_5606.method_32108(), class_5603.method_32090((float)-1.064f, (float)-5.0f, (float)0.0f));
        body.method_32117("body_r1", class_5606.method_32108().method_32101(0, 15).method_32098(-4.02f, -6.116f, -3.5f, 8.0f, 6.0f, 6.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.1f, (float)0.1f, (float)0.7f, (float)0.1204f, (float)-0.0064f, (float)-0.0779f));
        body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -5.1f, -5.0f, 8.0f, 5.0f, 10.0f, new class_5605(0.0f)).method_32101(56, 0).method_32098(-1.02f, -2.1f, -6.0f, 2.0f, 3.0f, 2.0f, new class_5605(0.0f)).method_32101(37, 8).method_32098(-1.02f, -9.1f, -1.0f, 2.0f, 4.0f, 2.0f, new class_5605(-0.015f)).method_32101(37, 0).method_32098(-2.0f, -13.1f, -2.0f, 4.0f, 4.0f, 4.0f, new class_5605(-0.015f)), class_5603.method_32090((float)0.7f, (float)-5.6f, (float)-1.8f));
        class_5610 rightArm = body.method_32117("right_arm", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)-6.0f, (float)0.0f));
        rightArm.method_32117("right_arm_r1", class_5606.method_32108().method_32101(36, 16).method_32098(-3.052f, -1.11f, -2.036f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.7f, (float)-0.248f, (float)-1.62f, (float)1.0036f, (float)0.0f, (float)0.0f));
        class_5610 leftArm = body.method_32117("left_arm", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)-6.0f, (float)0.0f));
        leftArm.method_32117("left_arm_r1", class_5606.method_32108().method_32101(50, 16).method_32098(0.032f, -1.1f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.732f, (float)0.0f, (float)0.0f, (float)-0.8715f, (float)-0.0535f, (float)-0.0449f));
        class_5610 rightLeg = partdefinition.method_32117("right_leg", class_5606.method_32108(), class_5603.method_32090((float)-3.064f, (float)-5.0f, (float)0.0f));
        rightLeg.method_32117("right_leg_r1", class_5606.method_32108().method_32101(0, 27).method_32098(-1.856f, -0.1f, -1.09f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.048f, (float)0.0f, (float)-0.9f, (float)-0.8727f, (float)0.0f, (float)0.0f));
        class_5610 leftLeg = partdefinition.method_32117("left_leg", class_5606.method_32108(), class_5603.method_32090((float)0.936f, (float)-5.0f, (float)0.0f));
        leftLeg.method_32117("left_leg_r1", class_5606.method_32108().method_32101(16, 27).method_32098(-2.088f, -0.1f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.0f, (float)0.0f, (float)0.0f, (float)0.7854f, (float)0.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)meshdefinition, (int)64, (int)64);
    }

    public static class_5607 createSittingPoseBodyLayer() {
        class_5609 meshdefinition = new class_5609();
        class_5610 partdefinition = meshdefinition.method_32111();
        class_5610 body = partdefinition.method_32117("body", class_5606.method_32108().method_32101(3, 19).method_32098(-3.0f, -4.0f, -4.525f, 6.0f, 1.0f, 6.0f, new class_5605(0.0f)).method_32101(0, 15).method_32098(-4.0f, -3.0f, -3.525f, 8.0f, 6.0f, 6.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-3.0f, (float)2.325f));
        body.method_32117("body_r1", class_5606.method_32108().method_32101(3, 18).method_32098(-4.0f, -3.0f, -2.2f, 8.0f, 6.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)-1.0f, (float)-4.325f, (float)0.0f, (float)0.0f, (float)-3.1416f));
        body.method_32117("head", class_5606.method_32108().method_32101(37, 8).method_32098(-1.0f, -7.0f, -3.3f, 2.0f, 4.0f, 2.0f, new class_5605(-0.015f)).method_32101(37, 0).method_32098(-2.0f, -11.0f, -4.3f, 4.0f, 4.0f, 4.0f, new class_5605(-0.015f)).method_32101(0, 0).method_32098(-4.0f, -3.0f, -7.325f, 8.0f, 5.0f, 10.0f, new class_5605(0.0f)).method_32101(56, 0).method_32098(-1.0f, 0.0f, -8.325f, 2.0f, 3.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-6.0f, (float)-0.2f));
        class_5610 rightArm = body.method_32117("right_arm", class_5606.method_32108(), class_5603.method_32091((float)-4.0f, (float)-5.6f, (float)-1.8f, (float)0.4363f, (float)0.0f, (float)0.0f));
        rightArm.method_32117("right_arm_r1", class_5606.method_32108().method_32101(36, 16).method_32098(-3.075f, -0.9733f, -1.9966f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)0.0893f, (float)0.1198f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        class_5610 leftArm = body.method_32117("left_arm", class_5606.method_32108(), class_5603.method_32091((float)4.0f, (float)-5.6f, (float)-1.7f, (float)0.4363f, (float)0.0f, (float)0.0f));
        leftArm.method_32117("left_arm_r1", class_5606.method_32108().method_32101(50, 16).method_32098(0.075f, -1.0443f, -1.8997f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)-0.0015f, (float)-0.0808f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        class_5610 rightLeg = partdefinition.method_32117("right_leg", class_5606.method_32108(), class_5603.method_32090((float)-2.1f, (float)-2.1f, (float)-2.075f));
        rightLeg.method_32117("right_leg_r1", class_5606.method_32108().method_32101(0, 27).method_32098(-2.0f, 0.975f, 0.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.05f, (float)-1.9f, (float)1.075f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        class_5610 leftLeg = partdefinition.method_32117("left_leg", class_5606.method_32108(), class_5603.method_32090((float)2.0f, (float)-2.0f, (float)-2.075f));
        leftLeg.method_32117("left_leg_r1", class_5606.method_32108().method_32101(16, 27).method_32098(-2.0f, 0.975f, 0.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.05f, (float)-2.0f, (float)1.075f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)meshdefinition, (int)64, (int)64);
    }

    public static class_5607 createStarPoseBodyLayer() {
        class_5609 meshdefinition = new class_5609();
        class_5610 partdefinition = meshdefinition.method_32111();
        class_5610 body = partdefinition.method_32117("body", class_5606.method_32108().method_32101(0, 15).method_32098(-4.0f, -6.0f, -3.0f, 8.0f, 6.0f, 6.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
        body.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -5.0f, -5.0f, 8.0f, 5.0f, 10.0f, new class_5605(0.0f)).method_32101(56, 0).method_32098(-1.0f, -2.0f, -6.0f, 2.0f, 3.0f, 2.0f, new class_5605(0.0f)).method_32101(37, 8).method_32098(-1.0f, -9.0f, -1.0f, 2.0f, 4.0f, 2.0f, new class_5605(-0.015f)).method_32101(37, 0).method_32098(-2.0f, -13.0f, -2.0f, 4.0f, 4.0f, 4.0f, new class_5605(-0.015f)), class_5603.method_32090((float)0.0f, (float)-6.0f, (float)0.0f));
        class_5610 rightArm = body.method_32117("right_arm", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)-6.0f, (float)0.0f));
        rightArm.method_32117("right_arm_r1", class_5606.method_32108().method_32101(36, 16).method_32098(-1.5f, -5.0f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.9199f));
        class_5610 leftArm = body.method_32117("left_arm", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)-6.0f, (float)0.0f));
        leftArm.method_32117("left_arm_r1", class_5606.method_32108().method_32101(50, 16).method_32098(-1.5f, -5.0f, -2.0f, 3.0f, 10.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)-1.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-1.9199f));
        class_5610 rightLeg = partdefinition.method_32117("right_leg", class_5606.method_32108(), class_5603.method_32090((float)-3.0f, (float)-5.0f, (float)0.0f));
        rightLeg.method_32117("right_leg_r1", class_5606.method_32108().method_32101(0, 27).method_32098(-2.0f, -2.5f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.35f, (float)2.0f, (float)0.01f, (float)0.0f, (float)0.0f, (float)0.2618f));
        class_5610 leftLeg = partdefinition.method_32117("left_leg", class_5606.method_32108(), class_5603.method_32090((float)1.0f, (float)-5.0f, (float)0.0f));
        leftLeg.method_32117("left_leg_r1", class_5606.method_32108().method_32101(16, 27).method_32098(-2.0f, -2.5f, -2.0f, 4.0f, 5.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32091((float)1.65f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        return class_5607.method_32110((class_5609)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(CopperGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean hasItems;
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.head.field_3675 = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_3654 = headPitch * ((float)Math.PI / 180);
        CopperGolemState state = entity.getState();
        boolean bl = hasItems = !entity.method_6047().method_7960();
        if (limbSwingAmount > 0.0f && state != CopperGolemState.PRESSING_BUTTON) {
            if (hasItems) {
                this.method_48741(this.walkWithItemAnimation, limbSwing, limbSwingAmount, 2.0f, 2.5f);
                this.poseHeldItemArmsIfStill();
            } else {
                this.method_48741(this.walkAnimation, limbSwing, limbSwingAmount, 2.0f, 2.5f);
            }
        }
        if (state == CopperGolemState.IDLE) {
            this.method_43781(entity.idleAnimationState, this.idleAnimation, ageInTicks);
        }
        switch (state) {
            case GETTING_ITEM: {
                this.method_43781(entity.interactionGetItemAnimationState, this.interactionGetItem, ageInTicks);
                break;
            }
            case GETTING_NO_ITEM: {
                this.method_43781(entity.interactionGetNoItemAnimationState, this.interactionGetNoItem, ageInTicks);
                break;
            }
            case DROPPING_ITEM: {
                this.method_43781(entity.interactionDropItemAnimationState, this.interactionDropItem, ageInTicks);
                break;
            }
            case DROPPING_NO_ITEM: {
                this.method_43781(entity.interactionDropNoItemAnimationState, this.interactionDropNoItem, ageInTicks);
                break;
            }
            case PRESSING_BUTTON: {
                this.method_43781(entity.pressingButtonAnimationState, this.pressButton, ageInTicks);
                break;
            }
        }
    }

    public class_630 method_32008() {
        return this.root;
    }

    public void method_2803(class_1306 arm, class_4587 poseStack) {
        this.root.method_22703(poseStack);
        this.body.method_22703(poseStack);
        class_630 armPart = arm == class_1306.field_6183 ? this.rightArm : this.leftArm;
        armPart.method_22703(poseStack);
        CopperGolemState state = CopperGolemState.IDLE;
        if (state == CopperGolemState.IDLE) {
            poseStack.method_22907(class_7833.field_40716.rotationDegrees(arm == class_1306.field_6183 ? -90.0f : 90.0f));
            poseStack.method_46416(0.0f, 0.0f, 0.125f);
        } else {
            poseStack.method_22905(0.55f, 0.55f, 0.55f);
            poseStack.method_46416(-0.125f, 0.3125f, -0.1875f);
        }
    }

    public void applyBlockOnAntennaTransform(class_4587 poseStack) {
        this.root.method_22703(poseStack);
        this.body.method_22703(poseStack);
        this.head.method_22703(poseStack);
        poseStack.method_22904(0.0, -1.05, 0.0);
    }

    private void poseHeldItemArmsIfStill() {
        this.rightArm.field_3654 = Math.min(this.rightArm.field_3654, -0.87266463f);
        this.leftArm.field_3654 = Math.min(this.leftArm.field_3654, -0.87266463f);
        this.rightArm.field_3675 = Math.min(this.rightArm.field_3675, -0.1134464f);
        this.leftArm.field_3675 = Math.max(this.leftArm.field_3675, 0.1134464f);
        this.rightArm.field_3674 = Math.min(this.rightArm.field_3674, -0.064577185f);
        this.leftArm.field_3674 = Math.max(this.leftArm.field_3674, 0.064577185f);
    }
}

