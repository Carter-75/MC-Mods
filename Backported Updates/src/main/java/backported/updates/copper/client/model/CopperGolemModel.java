/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.model.ModelWithArms
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.entity.model.SinglePartEntityModel
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.Dilation
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.model.ModelPart
 *  net.minecraft.client.render.entity.animation.Animation
 *  net.minecraft.util.math.RotationAxis
 */
package backported.updates.copper.client.model;

import backported.updates.copper.client.animation.CopperGolemAnimation;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemState;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.util.math.RotationAxis;

public class CopperGolemModel
extends SinglePartEntityModel<CopperGolemEntity>
implements ModelWithArms {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of((String)"copperagebackport", (String)"copper_golem"), "main");
    public static final EntityModelLayer STATUE_STANDING = new EntityModelLayer(Identifier.of((String)"copperagebackport", (String)"copper_golem_statue_standing"), "main");
    public static final EntityModelLayer STATUE_RUNNING = new EntityModelLayer(Identifier.of((String)"copperagebackport", (String)"copper_golem_statue_running"), "main");
    public static final EntityModelLayer STATUE_SITTING = new EntityModelLayer(Identifier.of((String)"copperagebackport", (String)"copper_golem_statue_sitting"), "main");
    public static final EntityModelLayer STATUE_STAR = new EntityModelLayer(Identifier.of((String)"copperagebackport", (String)"copper_golem_statue_star"), "main");
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final Animation walkAnimation;
    private final Animation walkWithItemAnimation;
    private final Animation idleAnimation;
    private final Animation interactionGetItem;
    private final Animation interactionGetNoItem;
    private final Animation interactionDropItem;
    private final Animation interactionDropNoItem;
    private final Animation pressButton;

    public CopperGolemModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.rightArm = this.body.getChild("right_arm");
        this.leftArm = this.body.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.walkAnimation = CopperGolemAnimation.COPPER_GOLEM_WALK;
        this.walkWithItemAnimation = CopperGolemAnimation.COPPER_GOLEM_WALK_ITEM;
        this.idleAnimation = CopperGolemAnimation.COPPER_GOLEM_IDLE;
        this.interactionGetItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_NOITEM_GET;
        this.interactionGetNoItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_NOITEM_NOGET;
        this.interactionDropItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_ITEM_DROP;
        this.interactionDropNoItem = CopperGolemAnimation.COPPER_GOLEM_CHEST_INTERACTION_ITEM_NODROP;
        this.pressButton = CopperGolemAnimation.COPPER_GOLEM_PRESS_BUTTON;
    }

    public static TexturedModelData createBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 15).cuboid(-4.0f, -6.0f, -3.0f, 8.0f, 6.0f, 6.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -5.0f, -5.0f, 8.0f, 5.0f, 10.0f, new Dilation(0.015f)).uv(56, 0).cuboid(-1.0f, -2.0f, -6.0f, 2.0f, 3.0f, 2.0f, new Dilation(0.0f)).uv(37, 8).cuboid(-1.0f, -9.0f, -1.0f, 2.0f, 4.0f, 2.0f, new Dilation(-0.015f)).uv(37, 0).cuboid(-2.0f, -13.0f, -2.0f, 4.0f, 4.0f, 4.0f, new Dilation(-0.015f)), ModelTransform.pivot((float)0.0f, (float)-6.0f, (float)0.0f));
        body.addChild("right_arm", ModelPartBuilder.create().uv(36, 16).cuboid(-3.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)-4.0f, (float)-6.0f, (float)0.0f));
        body.addChild("left_arm", ModelPartBuilder.create().uv(50, 16).cuboid(0.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)4.0f, (float)-6.0f, (float)0.0f));
        partdefinition.addChild("right_leg", ModelPartBuilder.create().uv(0, 27).cuboid(-4.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        partdefinition.addChild("left_leg", ModelPartBuilder.create().uv(16, 27).cuboid(0.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        return TexturedModelData.of((ModelData)meshdefinition, (int)64, (int)64);
    }

    public static TexturedModelData createStandingStatueBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 15).cuboid(-4.0f, -6.0f, -3.0f, 8.0f, 6.0f, 6.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -5.0f, -5.0f, 8.0f, 5.0f, 10.0f, new Dilation(0.015f)).uv(56, 0).cuboid(-1.0f, -2.0f, -6.0f, 2.0f, 3.0f, 2.0f, new Dilation(0.0f)).uv(37, 8).cuboid(-1.0f, -9.0f, -1.0f, 2.0f, 4.0f, 2.0f, new Dilation(-0.015f)).uv(37, 0).cuboid(-2.0f, -13.0f, -2.0f, 4.0f, 4.0f, 4.0f, new Dilation(-0.015f)), ModelTransform.pivot((float)0.0f, (float)-6.0f, (float)0.0f));
        body.addChild("right_arm", ModelPartBuilder.create().uv(36, 16).cuboid(-3.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)-4.0f, (float)-6.0f, (float)0.0f));
        body.addChild("left_arm", ModelPartBuilder.create().uv(50, 16).cuboid(0.0f, -1.0f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)4.0f, (float)-6.0f, (float)0.0f));
        partdefinition.addChild("right_leg", ModelPartBuilder.create().uv(0, 27).cuboid(-4.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        partdefinition.addChild("left_leg", ModelPartBuilder.create().uv(16, 27).cuboid(0.0f, 0.0f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        return TexturedModelData.of((ModelData)meshdefinition, (int)64, (int)64);
    }

    public static TexturedModelData createRunningPoseBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot((float)-1.064f, (float)-5.0f, (float)0.0f));
        body.addChild("body_r1", ModelPartBuilder.create().uv(0, 15).cuboid(-4.02f, -6.116f, -3.5f, 8.0f, 6.0f, 6.0f, new Dilation(0.0f)), ModelTransform.of((float)1.1f, (float)0.1f, (float)0.7f, (float)0.1204f, (float)-0.0064f, (float)-0.0779f));
        body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -5.1f, -5.0f, 8.0f, 5.0f, 10.0f, new Dilation(0.0f)).uv(56, 0).cuboid(-1.02f, -2.1f, -6.0f, 2.0f, 3.0f, 2.0f, new Dilation(0.0f)).uv(37, 8).cuboid(-1.02f, -9.1f, -1.0f, 2.0f, 4.0f, 2.0f, new Dilation(-0.015f)).uv(37, 0).cuboid(-2.0f, -13.1f, -2.0f, 4.0f, 4.0f, 4.0f, new Dilation(-0.015f)), ModelTransform.pivot((float)0.7f, (float)-5.6f, (float)-1.8f));
        ModelPartData rightArm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot((float)-4.0f, (float)-6.0f, (float)0.0f));
        rightArm.addChild("right_arm_r1", ModelPartBuilder.create().uv(36, 16).cuboid(-3.052f, -1.11f, -2.036f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.7f, (float)-0.248f, (float)-1.62f, (float)1.0036f, (float)0.0f, (float)0.0f));
        ModelPartData leftArm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot((float)4.0f, (float)-6.0f, (float)0.0f));
        leftArm.addChild("left_arm_r1", ModelPartBuilder.create().uv(50, 16).cuboid(0.032f, -1.1f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.732f, (float)0.0f, (float)0.0f, (float)-0.8715f, (float)-0.0535f, (float)-0.0449f));
        ModelPartData rightLeg = partdefinition.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot((float)-3.064f, (float)-5.0f, (float)0.0f));
        rightLeg.addChild("right_leg_r1", ModelPartBuilder.create().uv(0, 27).cuboid(-1.856f, -0.1f, -1.09f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)1.048f, (float)0.0f, (float)-0.9f, (float)-0.8727f, (float)0.0f, (float)0.0f));
        ModelPartData leftLeg = partdefinition.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot((float)0.936f, (float)-5.0f, (float)0.0f));
        leftLeg.addChild("left_leg_r1", ModelPartBuilder.create().uv(16, 27).cuboid(-2.088f, -0.1f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)1.0f, (float)0.0f, (float)0.0f, (float)0.7854f, (float)0.0f, (float)0.0f));
        return TexturedModelData.of((ModelData)meshdefinition, (int)64, (int)64);
    }

    public static TexturedModelData createSittingPoseBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(3, 19).cuboid(-3.0f, -4.0f, -4.525f, 6.0f, 1.0f, 6.0f, new Dilation(0.0f)).uv(0, 15).cuboid(-4.0f, -3.0f, -3.525f, 8.0f, 6.0f, 6.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-3.0f, (float)2.325f));
        body.addChild("body_r1", ModelPartBuilder.create().uv(3, 18).cuboid(-4.0f, -3.0f, -2.2f, 8.0f, 6.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)0.0f, (float)-1.0f, (float)-4.325f, (float)0.0f, (float)0.0f, (float)-3.1416f));
        body.addChild("head", ModelPartBuilder.create().uv(37, 8).cuboid(-1.0f, -7.0f, -3.3f, 2.0f, 4.0f, 2.0f, new Dilation(-0.015f)).uv(37, 0).cuboid(-2.0f, -11.0f, -4.3f, 4.0f, 4.0f, 4.0f, new Dilation(-0.015f)).uv(0, 0).cuboid(-4.0f, -3.0f, -7.325f, 8.0f, 5.0f, 10.0f, new Dilation(0.0f)).uv(56, 0).cuboid(-1.0f, 0.0f, -8.325f, 2.0f, 3.0f, 2.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-6.0f, (float)-0.2f));
        ModelPartData rightArm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.of((float)-4.0f, (float)-5.6f, (float)-1.8f, (float)0.4363f, (float)0.0f, (float)0.0f));
        rightArm.addChild("right_arm_r1", ModelPartBuilder.create().uv(36, 16).cuboid(-3.075f, -0.9733f, -1.9966f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.0f, (float)0.0893f, (float)0.1198f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        ModelPartData leftArm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.of((float)4.0f, (float)-5.6f, (float)-1.7f, (float)0.4363f, (float)0.0f, (float)0.0f));
        leftArm.addChild("left_arm_r1", ModelPartBuilder.create().uv(50, 16).cuboid(0.075f, -1.0443f, -1.8997f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.0f, (float)-0.0015f, (float)-0.0808f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        ModelPartData rightLeg = partdefinition.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot((float)-2.1f, (float)-2.1f, (float)-2.075f));
        rightLeg.addChild("right_leg_r1", ModelPartBuilder.create().uv(0, 27).cuboid(-2.0f, 0.975f, 0.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.05f, (float)-1.9f, (float)1.075f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        ModelPartData leftLeg = partdefinition.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot((float)2.0f, (float)-2.0f, (float)-2.075f));
        leftLeg.addChild("left_leg_r1", ModelPartBuilder.create().uv(16, 27).cuboid(-2.0f, 0.975f, 0.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.05f, (float)-2.0f, (float)1.075f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        return TexturedModelData.of((ModelData)meshdefinition, (int)64, (int)64);
    }

    public static TexturedModelData createStarPoseBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 15).cuboid(-4.0f, -6.0f, -3.0f, 8.0f, 6.0f, 6.0f, new Dilation(0.0f)), ModelTransform.pivot((float)0.0f, (float)-5.0f, (float)0.0f));
        body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -5.0f, -5.0f, 8.0f, 5.0f, 10.0f, new Dilation(0.0f)).uv(56, 0).cuboid(-1.0f, -2.0f, -6.0f, 2.0f, 3.0f, 2.0f, new Dilation(0.0f)).uv(37, 8).cuboid(-1.0f, -9.0f, -1.0f, 2.0f, 4.0f, 2.0f, new Dilation(-0.015f)).uv(37, 0).cuboid(-2.0f, -13.0f, -2.0f, 4.0f, 4.0f, 4.0f, new Dilation(-0.015f)), ModelTransform.pivot((float)0.0f, (float)-6.0f, (float)0.0f));
        ModelPartData rightArm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot((float)-4.0f, (float)-6.0f, (float)0.0f));
        rightArm.addChild("right_arm_r1", ModelPartBuilder.create().uv(36, 16).cuboid(-1.5f, -5.0f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)1.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.9199f));
        ModelPartData leftArm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot((float)4.0f, (float)-6.0f, (float)0.0f));
        leftArm.addChild("left_arm_r1", ModelPartBuilder.create().uv(50, 16).cuboid(-1.5f, -5.0f, -2.0f, 3.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)-1.0f, (float)1.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-1.9199f));
        ModelPartData rightLeg = partdefinition.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot((float)-3.0f, (float)-5.0f, (float)0.0f));
        rightLeg.addChild("right_leg_r1", ModelPartBuilder.create().uv(0, 27).cuboid(-2.0f, -2.5f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)0.35f, (float)2.0f, (float)0.01f, (float)0.0f, (float)0.0f, (float)0.2618f));
        ModelPartData leftLeg = partdefinition.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot((float)1.0f, (float)-5.0f, (float)0.0f));
        leftLeg.addChild("left_leg_r1", ModelPartBuilder.create().uv(16, 27).cuboid(-2.0f, -2.5f, -2.0f, 4.0f, 5.0f, 4.0f, new Dilation(0.0f)), ModelTransform.of((float)1.65f, (float)2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        return TexturedModelData.of((ModelData)meshdefinition, (int)64, (int)64);
    }

    public void setAngles(CopperGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean hasItems;
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180);
        this.head.pitch = headPitch * ((float)Math.PI / 180);
        CopperGolemState state = entity.getState();
        boolean bl = hasItems = !entity.getMainHandStack().isEmpty();
        if (limbSwingAmount > 0.0f && state != CopperGolemState.PRESSING_BUTTON) {
            if (hasItems) {
                this.animateMovement(this.walkWithItemAnimation, limbSwing, limbSwingAmount, 2.0f, 2.5f);
                this.poseHeldItemArmsIfStill();
            } else {
                this.animateMovement(this.walkAnimation, limbSwing, limbSwingAmount, 2.0f, 2.5f);
            }
        }
        if (state == CopperGolemState.IDLE) {
            this.updateAnimation(entity.idleAnimationState, this.idleAnimation, ageInTicks);
        }
        switch (state) {
            case GETTING_ITEM: {
                this.updateAnimation(entity.interactionGetItemAnimationState, this.interactionGetItem, ageInTicks);
                break;
            }
            case GETTING_NO_ITEM: {
                this.updateAnimation(entity.interactionGetNoItemAnimationState, this.interactionGetNoItem, ageInTicks);
                break;
            }
            case DROPPING_ITEM: {
                this.updateAnimation(entity.interactionDropItemAnimationState, this.interactionDropItem, ageInTicks);
                break;
            }
            case DROPPING_NO_ITEM: {
                this.updateAnimation(entity.interactionDropNoItemAnimationState, this.interactionDropNoItem, ageInTicks);
                break;
            }
            case PRESSING_BUTTON: {
                this.updateAnimation(entity.pressingButtonAnimationState, this.pressButton, ageInTicks);
                break;
            }
        }
    }

    public ModelPart getPart() {
        return this.root;
    }

    public void setArmAngle(Arm arm, MatrixStack poseStack) {
        this.root.rotate(poseStack);
        this.body.rotate(poseStack);
        ModelPart armPart = arm == Arm.RIGHT ? this.rightArm : this.leftArm;
        armPart.rotate(poseStack);
        CopperGolemState state = CopperGolemState.IDLE;
        if (state == CopperGolemState.IDLE) {
            poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(arm == Arm.RIGHT ? -90.0f : 90.0f));
            poseStack.translate(0.0f, 0.0f, 0.125f);
        } else {
            poseStack.scale(0.55f, 0.55f, 0.55f);
            poseStack.translate(-0.125f, 0.3125f, -0.1875f);
        }
    }

    public void applyBlockOnAntennaTransform(MatrixStack poseStack) {
        this.root.rotate(poseStack);
        this.body.rotate(poseStack);
        this.head.rotate(poseStack);
        poseStack.translate(0.0, -1.05, 0.0);
    }

    private void poseHeldItemArmsIfStill() {
        this.rightArm.pitch = Math.min(this.rightArm.pitch, -0.87266463f);
        this.leftArm.pitch = Math.min(this.leftArm.pitch, -0.87266463f);
        this.rightArm.yaw = Math.min(this.rightArm.yaw, -0.1134464f);
        this.leftArm.yaw = Math.max(this.leftArm.yaw, 0.1134464f);
        this.rightArm.roll = Math.min(this.rightArm.roll, -0.064577185f);
        this.leftArm.roll = Math.max(this.leftArm.roll, 0.064577185f);
    }
}

