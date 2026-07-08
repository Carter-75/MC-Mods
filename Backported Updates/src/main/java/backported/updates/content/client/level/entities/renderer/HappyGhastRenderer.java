/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.MobEntityRenderer
 */
package backported.updates.content.client.level.entities.renderer;

import backported.updates.content.client.level.entities.layer.GhastHarnessLayer;
import backported.updates.content.client.level.entities.layer.RopesLayer;
import backported.updates.content.client.level.entities.layer.SimpleEquipmentLayer;
import backported.updates.content.client.level.entities.model.HappyGhastHarnessModel;
import backported.updates.content.client.level.entities.model.HappyGhastModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;

@Environment(value=EnvType.CLIENT)
public class HappyGhastRenderer
extends MobEntityRenderer<HappyGhast, HappyGhastModel> {
    private static final Identifier GHAST_LOCATION = Identifier.ofVanilla((String)"textures/entity/ghast/happy_ghast.png");
    private static final Identifier GHAST_BABY_LOCATION = Identifier.ofVanilla((String)"textures/entity/ghast/happy_ghast_baby.png");
    private static final Identifier GHAST_ROPES = Identifier.ofVanilla((String)"textures/entity/ghast/happy_ghast_ropes.png");

    public HappyGhastRenderer(EntityRendererFactory.Context context) {
        super(context, new HappyGhastModel(context.getPart(ModModelLayers.HAPPY_GHAST)), 1.5f);
        this.addFeature(new SimpleEquipmentLayer<HappyGhast, HappyGhastModel>(this, GhastHarnessLayer.TEXTURE_BY_ITEM, EquipmentSlot.CHEST, HappyGhast::isHarnessed, new HappyGhastHarnessModel(context.getPart(ModModelLayers.HAPPY_GHAST_HARNESS)), null));
        this.addFeature(new RopesLayer(this, context.getModelLoader(), GHAST_ROPES));
    }

    public Identifier getTexture(HappyGhast entity) {
        return entity.isBaby() ? GHAST_BABY_LOCATION : GHAST_LOCATION;
    }

    protected void scale(HappyGhast entity, MatrixStack matrices, float partialTicks) {
        float scale = entity.isBaby() ? 0.95f : 4.0f;
        matrices.scale(scale, scale, scale);
    }
}

