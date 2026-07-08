/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.Dilation
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.garden.entity;

import backported.updates.garden.entity.CreakingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class CreakingModel
extends EntityModel<CreakingEntity> {
    private final ModelPart head;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart body;

    public CreakingModel(ModelPart root) {
        this.head = root.getChild("head");
        this.rightLeg = root.getChild("rightLeg");
        this.leftLeg = root.getChild("leftLeg");
        this.leftArm = root.getChild("leftArm");
        this.rightArm = root.getChild("rightArm");
        this.body = root.getChild("body");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot((float)-3.25f, (float)-5.375f, (float)-0.5f));
        ModelPartData headMain_r1 = head.addChild("headMain_r1", ModelPartBuilder.create().uv(0, 18).cuboid(-3.5f, -19.5f, -5.75f, 5.0f, 12.0f, 6.0f, new Dilation(0.0f)).uv(0, 46).cuboid(1.5f, -22.5f, -9.75f, 0.0f, 13.0f, 4.0f, new Dilation(0.0f)).uv(46, 0).cuboid(1.5f, -17.5f, 0.25f, 0.0f, 10.0f, 4.0f, new Dilation(0.0f)).uv(34, 35).cuboid(-3.5f, -23.5f, -5.75f, 5.0f, 4.0f, 6.0f, new Dilation(0.0f)), ModelTransform.of((float)2.75f, (float)7.875f, (float)0.25f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData rightLeg = modelPartData.addChild("rightLeg", ModelPartBuilder.create(), ModelTransform.pivot((float)2.75f, (float)8.0f, (float)-0.75f));
        ModelPartData rightArm_r1 = rightLeg.addChild("rightArm_r1", ModelPartBuilder.create().uv(22, 18).cuboid(-1.5f, 5.5f, 1.25f, 3.0f, 16.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)-3.25f, (float)-5.5f, (float)0.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData right_foot_r1 = rightLeg.addChild("right_foot_r1", ModelPartBuilder.create().uv(-1, 41).cuboid(-7.5f, 21.5f, 1.25f, 9.0f, 0.0f, 5.0f, new Dilation(0.0f)), ModelTransform.of((float)-3.25f, (float)-5.5f, (float)-3.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData leftLeg = modelPartData.addChild("leftLeg", ModelPartBuilder.create(), ModelTransform.pivot((float)-2.0f, (float)4.0f, (float)-0.25f));
        ModelPartData left_leg_top_r1 = leftLeg.addChild("left_leg_top_r1", ModelPartBuilder.create().uv(46, 15).cuboid(-1.5f, 0.5f, -2.75f, 3.0f, 1.0f, 3.0f, new Dilation(0.0f)).uv(22, 18).cuboid(-1.5f, 1.5f, -2.75f, 3.0f, 20.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)1.5f, (float)-1.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData left_foot_r1 = leftLeg.addChild("left_foot_r1", ModelPartBuilder.create().uv(26, 45).cuboid(-5.5f, 21.5f, -4.75f, 7.0f, 0.0f, 5.0f, new Dilation(0.0f)), ModelTransform.of((float)1.5f, (float)-1.5f, (float)-2.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData leftArm = modelPartData.addChild("leftArm", ModelPartBuilder.create(), ModelTransform.pivot((float)-7.75f, (float)-4.0f, (float)-0.25f));
        ModelPartData arm_left_bottom_r1 = leftArm.addChild("arm_left_bottom_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5f, 10.5f, -8.75f, 3.0f, 4.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)7.25f, (float)6.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData leftArm_r1 = leftArm.addChild("leftArm_r1", ModelPartBuilder.create().uv(34, 0).cuboid(-1.5f, 0.5f, -1.5f, 3.0f, 19.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)0.0f, (float)-2.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData rightArm = modelPartData.addChild("rightArm", ModelPartBuilder.create(), ModelTransform.pivot((float)7.25f, (float)-4.0f, (float)-0.25f));
        ModelPartData arm_right_bottom_r1 = rightArm.addChild("arm_right_bottom_r1", ModelPartBuilder.create().uv(0, 36).cuboid(-1.5f, 9.5f, 6.25f, 3.0f, 3.0f, 3.0f, new Dilation(0.0f)).uv(8, 46).cuboid(-1.5f, -11.5f, 6.25f, 3.0f, 3.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)-7.75f, (float)6.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData rightArm_r2 = rightArm.addChild("rightArm_r2", ModelPartBuilder.create().uv(34, 0).cuboid(-1.5f, 0.0f, -1.5f, 3.0f, 18.0f, 3.0f, new Dilation(0.0f)), ModelTransform.of((float)0.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot((float)1.25f, (float)1.25f, (float)0.5f));
        ModelPartData body_bottom_r1 = body.addChild("body_bottom_r1", ModelPartBuilder.create().uv(34, 22).cuboid(-2.5f, -1.5f, 0.25f, 4.0f, 7.0f, 6.0f, new Dilation(0.0f)).uv(0, 0).cuboid(-3.5f, -7.5f, -5.75f, 5.0f, 6.0f, 12.0f, new Dilation(0.0f)), ModelTransform.of((float)-1.75f, (float)1.25f, (float)-0.75f, (float)0.0f, (float)1.5708f, (float)0.0f));
        return TexturedModelData.of((ModelData)modelData, (int)64, (int)64);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.head.render(matrices, vertices, light, overlay, color);
        this.rightLeg.render(matrices, vertices, light, overlay, color);
        this.leftLeg.render(matrices, vertices, light, overlay, color);
        this.leftArm.render(matrices, vertices, light, overlay, color);
        this.rightArm.render(matrices, vertices, light, overlay, color);
        this.body.render(matrices, vertices, light, overlay, color);
    }

    public void setAngles(CreakingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.rightArm.pitch = MathHelper.cos((float)(limbAngle * 0.6662f)) * 1.1f * limbDistance;
        this.leftArm.pitch = MathHelper.cos((float)(limbAngle * 0.6662f + (float)Math.PI)) * 1.1f * limbDistance;
        this.rightLeg.pitch = MathHelper.cos((float)(limbAngle * 0.6662f + (float)Math.PI)) * 1.1f * limbDistance;
        this.leftLeg.pitch = MathHelper.cos((float)(limbAngle * 0.6662f)) * 1.1f * limbDistance;
        this.head.pitch = headPitch * ((float)Math.PI / 180);
        this.head.yaw = headYaw * ((float)Math.PI / 180);
    }
}

