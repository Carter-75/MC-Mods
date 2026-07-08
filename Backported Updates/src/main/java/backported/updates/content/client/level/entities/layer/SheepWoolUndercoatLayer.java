/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.SheepEntity
 *  net.minecraft.util.DyeColor
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.client.render.entity.model.EntityModelLoader
 *  net.minecraft.client.render.entity.model.EntityModelLayers
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.model.SheepWoolEntityModel
 *  net.minecraft.client.render.entity.model.SheepEntityModel
 */
package backported.updates.content.client.level.entities.layer;

import backported.updates.content.client.util.LazyModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SheepWoolEntityModel;
import net.minecraft.client.render.entity.model.SheepEntityModel;

public class SheepWoolUndercoatLayer
extends FeatureRenderer<SheepEntity, SheepEntityModel<SheepEntity>> {
    private static final Identifier SHEEP_WOOL_UNDERCOAT_TEXTURE = Identifier.ofVanilla((String)"textures/entity/sheep/sheep_wool_undercoat.png");
    private final LazyModel<SheepEntity, EntityModel<SheepEntity>> model;

    public SheepWoolUndercoatLayer(FeatureRendererContext<SheepEntity, SheepEntityModel<SheepEntity>> renderer, EntityModelLoader models) {
        super(renderer);
        this.model = LazyModel.of(models, EntityModelLayers.SHEEP, SheepWoolEntityModel::new);
    }

    public void render(MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, SheepEntity sheep, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (sheep.getType() == EntityType.SHEEP && !sheep.isInvisible()) {
            int color;
            if (sheep.hasCustomName() && "jeb_".equals(sheep.getName().getString())) {
                int offset = sheep.age / 25 + sheep.getId();
                int size = DyeColor.values().length;
                int fromIndex = offset % size;
                int toIndex = (offset + 1) % size;
                float delta = ((float)(sheep.age % 25) + partialTick) / 25.0f;
                int fromColor = SheepEntity.getRgbColor((DyeColor)DyeColor.byId((int)fromIndex));
                int toColor = SheepEntity.getRgbColor((DyeColor)DyeColor.byId((int)toIndex));
                color = ColorHelper.Argb.lerp((float)delta, (int)fromColor, (int)toColor);
            } else {
                color = SheepEntity.getRgbColor((DyeColor)sheep.getColor());
            }
            SheepWoolUndercoatLayer.render(this.getContextModel(), this.model.get(), SHEEP_WOOL_UNDERCOAT_TEXTURE, poseStack, buffer, packedLight, sheep, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, color);
        }
    }
}

