/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.item.BuiltinModelItemRenderer
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 *  net.minecraft.component.type.BlockStateComponent
 *  net.minecraft.component.DataComponentTypes
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.platform.Services;
import backported.updates.copper.registry.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.component.type.BlockStateComponent;
import net.minecraft.component.DataComponentTypes;

public class CopperItemRenderer
extends BuiltinModelItemRenderer {
    public CopperItemRenderer() {
        super(MinecraftClient.getInstance().getBlockEntityRenderDispatcher(), MinecraftClient.getInstance().getEntityModelLoader());
    }

    public void render(ItemStack stack, ModelTransformationMode displayContext, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        Item class_17922 = stack.getItem();
        if (!(class_17922 instanceof BlockItem)) {
            return;
        }
        BlockItem blockItem = (BlockItem)class_17922;
        Block block = blockItem.getBlock();
        if (this.isChestBlock(block)) {
            if (Services.PLATFORM.isFastChestSimplifiedEnabled()) {
                this.renderChestItemAsBlock(block, poseStack, bufferSource, packedLight, packedOverlay);
            } else {
                this.renderChestItem(block, poseStack, bufferSource, packedLight, packedOverlay);
            }
        } else if (block instanceof CopperGolemStatueBlock) {
            this.renderStatueItem(block, stack, poseStack, bufferSource, packedLight, packedOverlay);
        }
    }

    private boolean isChestBlock(Block block) {
        return block == ModBlocks.COPPER_CHEST.get() || block == ModBlocks.EXPOSED_COPPER_CHEST.get() || block == ModBlocks.WEATHERED_COPPER_CHEST.get() || block == ModBlocks.OXIDIZED_COPPER_CHEST.get() || block == ModBlocks.WAXED_COPPER_CHEST.get() || block == ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get() || block == ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get() || block == ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get();
    }

    private void renderChestItem(Block block, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        CopperChestBlockEntity blockEntity = new CopperChestBlockEntity(BlockPos.ORIGIN, block.getDefaultState());
        MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity((BlockEntity)blockEntity, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private void renderChestItemAsBlock(Block block, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        BlockState state = block.getDefaultState();
        poseStack.push();
        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f));
        poseStack.translate(-0.5, 0.0, -0.5);
        MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(state, poseStack, bufferSource, packedLight, packedOverlay);
        poseStack.pop();
    }

    private void renderStatueItem(Block block, ItemStack stack, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        BlockState state = this.resolveBlockState(block, stack);
        CopperGolemStatueBlockEntity blockEntity = new CopperGolemStatueBlockEntity(BlockPos.ORIGIN, state);
        blockEntity.readComponents(stack);
        MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity((BlockEntity)blockEntity, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private BlockState resolveBlockState(Block block, ItemStack stack) {
        BlockState state = block.getDefaultState();
        BlockStateComponent properties = (BlockStateComponent)stack.get(DataComponentTypes.BLOCK_STATE);
        if (properties != null && !properties.isEmpty()) {
            state = properties.applyToState(state);
        }
        return state;
    }
}

