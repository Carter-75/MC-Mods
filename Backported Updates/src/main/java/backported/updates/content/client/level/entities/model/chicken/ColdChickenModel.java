/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.ChickenEntity
 *  net.minecraft.client.render.entity.model.ChickenEntityModel
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.level.entities.model.chicken;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class ColdChickenModel<T extends ChickenEntity>
extends ChickenEntityModel<T> {
    public ColdChickenModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = new ModelData();
        ModelPartData root = mesh.getRoot();
        root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0f, -6.0f, -2.0f, 4.0f, 6.0f, 3.0f), ModelTransform.pivot((float)0.0f, (float)15.0f, (float)-4.0f));
        root.addChild("beak", ModelPartBuilder.create().uv(14, 0).cuboid(-2.0f, -4.0f, -4.0f, 4.0f, 2.0f, 2.0f), ModelTransform.pivot((float)0.0f, (float)15.0f, (float)-4.0f));
        root.addChild("red_thing", ModelPartBuilder.create().uv(14, 4).cuboid(-1.0f, -2.0f, -3.0f, 2.0f, 2.0f, 2.0f), ModelTransform.pivot((float)0.0f, (float)15.0f, (float)-4.0f));
        root.addChild("body", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0f, -4.0f, -3.0f, 6.0f, 8.0f, 6.0f), ModelTransform.of((float)0.0f, (float)16.0f, (float)0.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        ModelPartBuilder legShape = ModelPartBuilder.create().uv(26, 0).cuboid(-1.0f, 0.0f, -3.0f, 3.0f, 5.0f, 3.0f);
        root.addChild("right_leg", legShape, ModelTransform.pivot((float)-2.0f, (float)19.0f, (float)1.0f));
        root.addChild("left_leg", legShape, ModelTransform.pivot((float)1.0f, (float)19.0f, (float)1.0f));
        root.addChild("right_wing", ModelPartBuilder.create().uv(24, 13).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 4.0f, 6.0f), ModelTransform.pivot((float)-4.0f, (float)13.0f, (float)0.0f));
        root.addChild("left_wing", ModelPartBuilder.create().uv(24, 13).cuboid(-1.0f, 0.0f, -3.0f, 1.0f, 4.0f, 6.0f), ModelTransform.pivot((float)4.0f, (float)13.0f, (float)0.0f));
        root.addChild("body", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0f, -4.0f, -3.0f, 6.0f, 8.0f, 6.0f).uv(38, 9).cuboid(0.0f, 3.0f, -1.0f, 0.0f, 3.0f, 5.0f), ModelTransform.of((float)0.0f, (float)16.0f, (float)0.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0f, -6.0f, -2.0f, 4.0f, 6.0f, 3.0f).uv(44, 0).cuboid(-3.0f, -7.0f, -2.015f, 6.0f, 3.0f, 4.0f), ModelTransform.pivot((float)0.0f, (float)15.0f, (float)-4.0f));
        return TexturedModelData.of((ModelData)mesh, (int)64, (int)32);
    }
}

