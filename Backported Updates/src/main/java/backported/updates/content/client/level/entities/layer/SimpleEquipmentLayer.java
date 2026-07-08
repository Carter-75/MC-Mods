/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.OverlayTexture
 *  net.minecraft.client.render.entity.model.EntityModel
 */
package backported.updates.content.client.level.entities.layer;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(value=EnvType.CLIENT)
public class SimpleEquipmentLayer<T extends LivingEntity, M extends EntityModel<T>>
extends FeatureRenderer<T, M> {
    private final Map<ItemStack, Identifier> textureByItem;
    private final BiPredicate<ItemStack, T> itemGetter;
    private final Predicate<T> shouldRender;
    private final EntityModel<T> model;
    private final EntityModel<T> babyModel;

    public SimpleEquipmentLayer(FeatureRendererContext<T, M> renderer, Map<ItemStack, Identifier> textureByItem, BiPredicate<ItemStack, T> itemGetter, Predicate<T> shouldRender, EntityModel<T> model, EntityModel<T> babyModel) {
        super(renderer);
        this.textureByItem = textureByItem;
        this.itemGetter = itemGetter;
        this.shouldRender = shouldRender;
        this.model = model;
        this.babyModel = babyModel;
    }

    public SimpleEquipmentLayer(FeatureRendererContext<T, M> renderer, Map<ItemStack, Identifier> textureByItem, EquipmentSlot slot, Predicate<T> shouldRender, EntityModel<T> model, EntityModel<T> babyModel) {
        this(renderer, textureByItem, (ItemStack stack, T entity) -> entity.getEquippedStack(slot).isOf(stack.getItem()), shouldRender, model, babyModel);
    }

    public void render(MatrixStack pose, VertexConsumerProvider buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        Optional<Identifier> texture = this.textureByItem.entrySet().stream().filter(entry -> this.itemGetter.test((ItemStack)entry.getKey(), entity)).map(Map.Entry::getValue).findFirst();
        if (this.shouldRender.test(entity) && texture.isPresent() && (!entity.isBaby() || this.babyModel != null)) {
            EntityModel<T> model = entity.isBaby() ? this.babyModel : this.model;
            this.getContextModel().copyStateTo(model);
            model.animateModel(entity, limbSwing, limbSwingAmount, partialTick);
            model.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer vertices = buffer.getBuffer(RenderLayer.getEntityCutoutNoCull(texture.get()));
            model.render(pose, vertices, packedLight, OverlayTexture.DEFAULT_UV);
        }
    }
}

