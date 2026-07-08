/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BannerItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.collection.DefaultedList
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.block.entity.BlockEntityRendererFactory$Context
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 *  net.minecraft.client.render.block.entity.BlockEntityRenderer
 *  net.minecraft.client.render.item.ItemRenderer
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.shelf.ShelfBlock;
import backported.updates.copper.block.shelf.ShelfBlockEntity;
import net.minecraft.item.BannerItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;

public class ShelfRenderer
implements BlockEntityRenderer<ShelfBlockEntity> {
    private static final float ITEM_SIZE = 0.25f;
    private static final float SLOT_OFFSET = 0.3125f;
    private static final float ALIGN_ITEMS_TO_BOTTOM_OFFSET = -0.25f;
    private static final float BANNER_SCALE = 0.5f;
    private static final float BANNER_Y_OFFSET = -0.1f;
    private final ItemRenderer itemRenderer;

    public ShelfRenderer(BlockEntityRendererFactory.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    public void render(ShelfBlockEntity blockEntity, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        Direction direction = (Direction)blockEntity.getCachedState().get(ShelfBlock.FACING);
        DefaultedList<ItemStack> items = blockEntity.getItems();
        int seed = (int)blockEntity.getPos().asLong();
        boolean alignToBottom = blockEntity.getAlignItemsToBottom();
        float rotation = direction.getAxis().isHorizontal() ? -direction.asRotation() : 180.0f;
        for (int i = 0; i < items.size(); ++i) {
            ItemStack itemStack = (ItemStack)items.get(i);
            if (itemStack.isEmpty()) continue;
            poseStack.push();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
            float horizontalOffset = (float)(i - 1) * 0.3125f;
            float verticalOffset = alignToBottom ? -0.25f : 0.0f;
            float depthOffset = -0.25f;
            poseStack.translate(horizontalOffset, verticalOffset, depthOffset);
            poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f));
            float scale = this.getItemScale(itemStack);
            float yOffset = this.getItemYOffset(itemStack);
            poseStack.translate(0.0f, yOffset, 0.0f);
            poseStack.scale(scale, scale, scale);
            this.itemRenderer.renderItem(itemStack, ModelTransformationMode.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getWorld(), seed + i);
            poseStack.pop();
        }
    }

    private float getItemScale(ItemStack itemStack) {
        if (itemStack.getItem() instanceof BannerItem) {
            return 0.5f;
        }
        return 0.25f;
    }

    private float getItemYOffset(ItemStack itemStack) {
        if (itemStack.getItem() instanceof BannerItem) {
            return -0.1f;
        }
        return 0.0f;
    }
}

