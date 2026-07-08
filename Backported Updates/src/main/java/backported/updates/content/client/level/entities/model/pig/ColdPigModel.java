/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.PigEntity
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.Dilation
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.render.entity.model.PigEntityModel
 *  net.minecraft.client.render.entity.model.QuadrupedEntityModel
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.level.entities.model.pig;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class ColdPigModel<T extends PigEntity>
extends PigEntityModel<T> {
    public ColdPigModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = QuadrupedEntityModel.getModelData((int)6, (Dilation)Dilation.NONE);
        ModelPartData root = mesh.getRoot();
        root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -4.0f, -8.0f, 8.0f, 8.0f, 8.0f).uv(16, 16).cuboid(-2.0f, 0.0f, -9.0f, 4.0f, 3.0f, 1.0f), ModelTransform.pivot((float)0.0f, (float)12.0f, (float)-6.0f));
        root.addChild("body", ModelPartBuilder.create().uv(28, 8).cuboid(-5.0f, -10.0f, -7.0f, 10.0f, 16.0f, 8.0f).uv(28, 32).cuboid(-5.0f, -10.0f, -7.0f, 10.0f, 16.0f, 8.0f, new Dilation(0.5f)), ModelTransform.of((float)0.0f, (float)11.0f, (float)2.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        return TexturedModelData.of((ModelData)mesh, (int)64, (int)64);
    }
}

