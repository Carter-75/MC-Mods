/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.CowEntity
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.model.ModelPartBuilder
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.model.ModelData
 *  net.minecraft.client.model.ModelPartData
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.level.entities.model.cow;

import backported.updates.content.client.level.entities.model.cow.CowVariantModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class WarmCowModel<T extends CowEntity>
extends CowVariantModel<T> {
    public WarmCowModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData createBodyLayer() {
        ModelData mesh = WarmCowModel.createBaseCowModel();
        ModelPartData root = mesh.getRoot();
        root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -4.0f, -6.0f, 8.0f, 8.0f, 6.0f).uv(1, 33).cuboid(-3.0f, 1.0f, -7.0f, 6.0f, 3.0f, 1.0f).uv(27, 0).cuboid(-8.0f, -3.0f, -5.0f, 4.0f, 2.0f, 2.0f).uv(39, 0).cuboid(-8.0f, -5.0f, -5.0f, 2.0f, 2.0f, 2.0f).uv(27, 0).mirrored().cuboid(4.0f, -3.0f, -5.0f, 4.0f, 2.0f, 2.0f).mirrored(false).uv(39, 0).mirrored().cuboid(6.0f, -5.0f, -5.0f, 2.0f, 2.0f, 2.0f).mirrored(false), ModelTransform.pivot((float)0.0f, (float)4.0f, (float)-8.0f));
        return TexturedModelData.of((ModelData)mesh, (int)64, (int)64);
    }
}

