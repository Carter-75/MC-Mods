/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.MobEntityRenderer
 */
package backported.updates.content.client.level.entities.renderer;

import backported.updates.content.client.level.entities.layer.LivingEntityEmissiveLayer;
import backported.updates.content.client.level.entities.model.CreakingModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.creaking.Creaking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

@Environment(value=EnvType.CLIENT)
public class CreakingRenderer<T extends Creaking>
extends MobEntityRenderer<T, CreakingModel<T>> {
    private static final Identifier TEXTURE_LOCATION = Identifier.ofVanilla((String)"textures/entity/creaking/creaking.png");
    private static final Identifier EYES_TEXTURE_LOCATION = Identifier.ofVanilla((String)"textures/entity/creaking/creaking_eyes.png");

    public CreakingRenderer(EntityRendererFactory.Context context) {
        super(context, new CreakingModel<>(context.getPart(ModModelLayers.CREAKING)), 0.7f);
        this.addFeature(new LivingEntityEmissiveLayer<>(this, creaking -> EYES_TEXTURE_LOCATION, (creaking, ageInTicks) -> creaking.shouldEyesGlow() ? 1.0f : 0.0f, new CreakingModel<>(context.getPart(ModModelLayers.CREAKING)), RenderLayer::getEyes, true));
    }

    public Identifier getTexture(Creaking entity) {
        return TEXTURE_LOCATION;
    }
}

