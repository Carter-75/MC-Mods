/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.OverlayTexture
 *  net.minecraft.client.render.block.BlockRenderManager
 *  net.minecraft.util.math.RotationAxis
 */
package backported.updates.copper.client.renderer.layers;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.entity.CopperGolemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.util.math.RotationAxis;

public class CopperGolemAntennaLayer
extends FeatureRenderer<CopperGolemEntity, CopperGolemModel> {
    private final BlockRenderManager blockRenderer = MinecraftClient.getInstance().getBlockRenderManager();

    public CopperGolemAntennaLayer(FeatureRendererContext<CopperGolemEntity, CopperGolemModel> renderer) {
        super(renderer);
    }

    public void render(MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, CopperGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack antennaItem = entity.getEquippedStack(CopperGolemEntity.EQUIPMENT_SLOT_ANTENNA);
        if (antennaItem.isEmpty()) {
            return;
        }
        Item class_17922 = antennaItem.getItem();
        if (!(class_17922 instanceof BlockItem)) {
            return;
        }
        BlockItem blockItem = (BlockItem)class_17922;
        BlockState blockState = blockItem.getBlock().getDefaultState();
        poseStack.push();
        ((CopperGolemModel)this.getContextModel()).applyBlockOnAntennaTransform(poseStack);
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0f));
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.translate(-0.5, -0.5, -0.5);
        this.blockRenderer.renderBlockAsEntity(blockState, poseStack, buffer, packedLight, OverlayTexture.DEFAULT_UV);
        poseStack.pop();
    }
}

