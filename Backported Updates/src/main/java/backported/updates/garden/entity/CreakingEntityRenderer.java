/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.MobEntityRenderer
 */
package backported.updates.garden.entity;

import backported.updates.garden.ClientInit;
import backported.updates.garden.entity.CreakingEntity;
import backported.updates.garden.entity.CreakingModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;

@Environment(value=EnvType.CLIENT)
public class CreakingEntityRenderer
extends MobEntityRenderer<CreakingEntity, CreakingModel> {
    public CreakingEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CreakingModel(context.getPart(ClientInit.MODEL_CREAKING_LAYER)), 0.5f);
    }

    public Identifier getTexture(CreakingEntity entity) {
        return Identifier.of((String)"iwie", (String)"textures/entity/creaking/creaking.png");
    }
}

