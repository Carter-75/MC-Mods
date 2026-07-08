/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.util.math.MathHelper
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
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class HappyGhastModel
extends SinglePartEntityModel<HappyGhast> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart inner_body;
    private final ModelPart[] tentacles = new ModelPart[9];

    public HappyGhastModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.inner_body = this.body.getChild("inner_body");
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i] = this.body.getChild(HappyGhastModel.createTentacleName(i));
        }
    }

    private static String createTentacleName(int index) {
        return "tentacle" + index;
    }

    public static TexturedModelData createBodyLayer(Dilation deformation) {
        ModelData mesh = new ModelData();
        ModelPartData root = mesh.getRoot();
        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, deformation), ModelTransform.pivot((float)0.0f, (float)16.0f, (float)0.0f));
        body.addChild("inner_body", ModelPartBuilder.create().uv(0, 32).cuboid(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, deformation.add(-0.5f)), ModelTransform.pivot((float)0.0f, (float)8.0f, (float)0.0f));
        body.addChild(HappyGhastModel.createTentacleName(0), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), ModelTransform.pivot((float)-3.75f, (float)7.0f, (float)-5.0f));
        body.addChild(HappyGhastModel.createTentacleName(1), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 7.0f, 2.0f, deformation), ModelTransform.pivot((float)1.25f, (float)7.0f, (float)-5.0f));
        body.addChild(HappyGhastModel.createTentacleName(2), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 4.0f, 2.0f, deformation), ModelTransform.pivot((float)6.25f, (float)7.0f, (float)-5.0f));
        body.addChild(HappyGhastModel.createTentacleName(3), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), ModelTransform.pivot((float)-6.25f, (float)7.0f, (float)0.0f));
        body.addChild(HappyGhastModel.createTentacleName(4), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), ModelTransform.pivot((float)-1.25f, (float)7.0f, (float)0.0f));
        body.addChild(HappyGhastModel.createTentacleName(5), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 7.0f, 2.0f, deformation), ModelTransform.pivot((float)3.75f, (float)7.0f, (float)0.0f));
        body.addChild(HappyGhastModel.createTentacleName(6), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 8.0f, 2.0f, deformation), ModelTransform.pivot((float)-3.75f, (float)7.0f, (float)5.0f));
        body.addChild(HappyGhastModel.createTentacleName(7), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 8.0f, 2.0f, deformation), ModelTransform.pivot((float)1.25f, (float)7.0f, (float)5.0f));
        body.addChild(HappyGhastModel.createTentacleName(8), ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), ModelTransform.pivot((float)6.25f, (float)7.0f, (float)5.0f));
        return TexturedModelData.of((ModelData)mesh, (int)64, (int)64);
    }

    @Override
    public void setAngles(HappyGhast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.inner_body.visible = entity.isBaby();
        if (entity.hasStackEquipped(EquipmentSlot.CHEST)) {
            this.body.xScale = 0.9375f;
            this.body.yScale = 0.9375f;
            this.body.zScale = 0.9375f;
        }
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].pitch = 0.2f * MathHelper.sin((float)(ageInTicks * 0.3f + (float)i)) + 0.4f;
        }
    }

    public ModelPart getPart() {
        return this.root;
    }
}

