/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.render.entity.model.SinglePartEntityModel
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.level.entities.model;

import backported.updates.content.client.level.entities.animation.CreakingAnimation;
import backported.updates.content.common.level.entities.creaking.Creaking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class CreakingModel<T extends Creaking>
extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;

    public CreakingModel(ModelPart root) {
        this.root = root.getChild("root");
        ModelPart upperBody = this.root.getChild("upper_body");
        this.head = upperBody.getChild("head");
    }

    private static ModelData createMesh() {
        ModelData mesh = new ModelData();
        ModelPartData base = mesh.getRoot();
        ModelPartData root = base.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot((float)0.0f, (float)24.0f, (float)0.0f));
        ModelPartData upperBody = root.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot((float)-1.0f, (float)-19.0f, (float)0.0f));
        upperBody.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0f, -10.0f, -3.0f, 6.0f, 10.0f, 6.0f).uv(28, 31).cuboid(-3.0f, -13.0f, -3.0f, 6.0f, 3.0f, 6.0f).uv(12, 40).cuboid(3.0f, -13.0f, 0.0f, 9.0f, 14.0f, 0.0f).uv(34, 12).cuboid(-12.0f, -14.0f, 0.0f, 9.0f, 14.0f, 0.0f), ModelTransform.pivot((float)-3.0f, (float)-11.0f, (float)0.0f));
        upperBody.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(0.0f, -3.0f, -3.0f, 6.0f, 13.0f, 5.0f).uv(24, 0).cuboid(-6.0f, -4.0f, -3.0f, 6.0f, 7.0f, 5.0f), ModelTransform.pivot((float)0.0f, (float)-7.0f, (float)1.0f));
        upperBody.addChild("right_arm", ModelPartBuilder.create().uv(22, 13).cuboid(-2.0f, -1.5f, -1.5f, 3.0f, 21.0f, 3.0f).uv(46, 0).cuboid(-2.0f, 19.5f, -1.5f, 3.0f, 4.0f, 3.0f), ModelTransform.pivot((float)-7.0f, (float)-9.5f, (float)1.5f));
        upperBody.addChild("left_arm", ModelPartBuilder.create().uv(30, 40).cuboid(0.0f, -1.0f, -1.5f, 3.0f, 16.0f, 3.0f).uv(52, 12).cuboid(0.0f, -5.0f, -1.5f, 3.0f, 4.0f, 3.0f).uv(52, 19).cuboid(0.0f, 15.0f, -1.5f, 3.0f, 4.0f, 3.0f), ModelTransform.pivot((float)6.0f, (float)-9.0f, (float)0.5f));
        root.addChild("left_leg", ModelPartBuilder.create().uv(42, 40).cuboid(-1.5f, 0.0f, -1.5f, 3.0f, 16.0f, 3.0f).uv(45, 55).cuboid(-1.5f, 15.7f, -4.5f, 5.0f, 0.0f, 9.0f), ModelTransform.pivot((float)1.5f, (float)-16.0f, (float)0.5f));
        root.addChild("right_leg", ModelPartBuilder.create().uv(0, 34).cuboid(-3.0f, -1.5f, -1.5f, 3.0f, 19.0f, 3.0f).uv(45, 46).cuboid(-5.0f, 17.2f, -4.5f, 5.0f, 0.0f, 9.0f).uv(12, 34).cuboid(-3.0f, -4.5f, -1.5f, 3.0f, 3.0f, 3.0f), ModelTransform.pivot((float)-1.0f, (float)-17.5f, (float)0.5f));
        return mesh;
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = CreakingModel.createMesh();
        return TexturedModelData.of((ModelData)mesh, (int)64, (int)64);
    }

    public ModelPart getPart() {
        return this.root;
    }

    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.head.pitch = headPitch * ((float)Math.PI / 180);
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180);
        if (((Creaking)(entity)).canMove()) {
            this.animateMovement(CreakingAnimation.CREAKING_WALK, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        }
        this.updateAnimation(((Creaking)(entity)).attackAnimationState, CreakingAnimation.CREAKING_ATTACK, ageInTicks);
        this.updateAnimation(((Creaking)(entity)).invulnerabilityAnimationState, CreakingAnimation.CREAKING_INVULNERABLE, ageInTicks);
        this.updateAnimation(((Creaking)(entity)).deathAnimationState, CreakingAnimation.CREAKING_DEATH, ageInTicks);
    }
}

