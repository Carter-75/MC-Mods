/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.Entity
 *  net.minecraft.client.render.entity.model.SinglePartEntityModel
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.Dilation
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.level.entities.model;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class HappyGhastHarnessModel
extends SinglePartEntityModel<HappyGhast> {
    private final ModelPart root;
    private final ModelPart goggles;

    public HappyGhastHarnessModel(ModelPart root) {
        this.root = root;
        this.goggles = root.getChild("goggles");
    }

    public static TexturedModelData createHarnessLayer() {
        ModelData mesh = new ModelData();
        ModelPartData root = mesh.getRoot();
        root.addChild("harness", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f), ModelTransform.pivot((float)0.0f, (float)24.0f, (float)0.0f));
        root.addChild("goggles", ModelPartBuilder.create().uv(0, 32).cuboid(-8.0f, -2.5f, -2.5f, 16.0f, 5.0f, 5.0f, new Dilation(0.15f)), ModelTransform.pivot((float)0.0f, (float)14.0f, (float)-5.5f));
        return TexturedModelData.of((ModelData)mesh, (int)64, (int)64);
    }

    @Override
    public void setAngles(HappyGhast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.hasPassengers()) {
            this.goggles.pitch = 0.0f;
            this.goggles.pivotY = 14.0f;
        } else {
            this.goggles.pitch = -0.7854f;
            this.goggles.pivotY = 9.0f;
        }
    }

    public ModelPart getPart() {
        return this.root;
    }
}

