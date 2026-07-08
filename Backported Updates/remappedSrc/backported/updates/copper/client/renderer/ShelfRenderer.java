/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1746
 *  net.minecraft.class_1799
 *  net.minecraft.class_2350
 *  net.minecraft.class_2371
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5614$class_5615
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  net.minecraft.class_827
 *  net.minecraft.class_918
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.shelf.ShelfBlock;
import backported.updates.copper.block.shelf.ShelfBlockEntity;
import net.minecraft.class_1746;
import net.minecraft.class_1799;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5614;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_827;
import net.minecraft.class_918;

public class ShelfRenderer
implements class_827<ShelfBlockEntity> {
    private static final float ITEM_SIZE = 0.25f;
    private static final float SLOT_OFFSET = 0.3125f;
    private static final float ALIGN_ITEMS_TO_BOTTOM_OFFSET = -0.25f;
    private static final float BANNER_SCALE = 0.5f;
    private static final float BANNER_Y_OFFSET = -0.1f;
    private final class_918 itemRenderer;

    public ShelfRenderer(class_5614.class_5615 context) {
        this.itemRenderer = context.method_43335();
    }

    public void render(ShelfBlockEntity blockEntity, float partialTick, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        class_2350 direction = (class_2350)blockEntity.method_11010().method_11654(ShelfBlock.FACING);
        class_2371<class_1799> items = blockEntity.getItems();
        int seed = (int)blockEntity.method_11016().method_10063();
        boolean alignToBottom = blockEntity.getAlignItemsToBottom();
        float rotation = direction.method_10166().method_10179() ? -direction.method_10144() : 180.0f;
        for (int i = 0; i < items.size(); ++i) {
            class_1799 itemStack = (class_1799)items.get(i);
            if (itemStack.method_7960()) continue;
            poseStack.method_22903();
            poseStack.method_46416(0.5f, 0.5f, 0.5f);
            poseStack.method_22907(class_7833.field_40716.rotationDegrees(rotation));
            float horizontalOffset = (float)(i - 1) * 0.3125f;
            float verticalOffset = alignToBottom ? -0.25f : 0.0f;
            float depthOffset = -0.25f;
            poseStack.method_46416(horizontalOffset, verticalOffset, depthOffset);
            poseStack.method_22907(class_7833.field_40716.rotationDegrees(180.0f));
            float scale = this.getItemScale(itemStack);
            float yOffset = this.getItemYOffset(itemStack);
            poseStack.method_46416(0.0f, yOffset, 0.0f);
            poseStack.method_22905(scale, scale, scale);
            this.itemRenderer.method_23178(itemStack, class_811.field_4319, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.method_10997(), seed + i);
            poseStack.method_22909();
        }
    }

    private float getItemScale(class_1799 itemStack) {
        if (itemStack.method_7909() instanceof class_1746) {
            return 0.5f;
        }
        return 0.25f;
    }

    private float getItemYOffset(class_1799 itemStack) {
        if (itemStack.method_7909() instanceof class_1746) {
            return -0.1f;
        }
        return 0.0f;
    }
}

