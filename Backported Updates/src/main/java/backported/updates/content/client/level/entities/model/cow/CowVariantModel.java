/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.CowEntity
 *  net.minecraft.client.render.entity.model.CowEntityModel
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.level.entities.model.cow;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class CowVariantModel<T extends CowEntity>
extends CowEntityModel<T> {
    public CowVariantModel(ModelPart root) {
        super(root);
    }

    static ModelData createBaseCowModel() {
        ModelData mesh = new ModelData();
        ModelPartData root = mesh.getRoot();
        root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -4.0f, -6.0f, 8.0f, 8.0f, 6.0f).uv(1, 33).cuboid(-3.0f, 1.0f, -7.0f, 6.0f, 3.0f, 1.0f).uv(22, 0).cuboid("right_horn", -5.0f, -5.0f, -5.0f, 1.0f, 3.0f, 1.0f).uv(22, 0).cuboid("left_horn", 4.0f, -5.0f, -5.0f, 1.0f, 3.0f, 1.0f), ModelTransform.pivot((float)0.0f, (float)4.0f, (float)-8.0f));
        root.addChild("body", ModelPartBuilder.create().uv(18, 4).cuboid(-6.0f, -10.0f, -7.0f, 12.0f, 18.0f, 10.0f).uv(52, 0).cuboid(-2.0f, 2.0f, -8.0f, 4.0f, 6.0f, 1.0f), ModelTransform.of((float)0.0f, (float)5.0f, (float)2.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        ModelPartBuilder leftLeg = ModelPartBuilder.create().mirrored().uv(0, 16).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        ModelPartBuilder rightLeg = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        root.addChild("right_hind_leg", rightLeg, ModelTransform.pivot((float)-4.0f, (float)12.0f, (float)7.0f));
        root.addChild("left_hind_leg", leftLeg, ModelTransform.pivot((float)4.0f, (float)12.0f, (float)7.0f));
        root.addChild("right_front_leg", rightLeg, ModelTransform.pivot((float)-4.0f, (float)12.0f, (float)-5.0f));
        root.addChild("left_front_leg", leftLeg, ModelTransform.pivot((float)4.0f, (float)12.0f, (float)-5.0f));
        return mesh;
    }
}

