/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_756
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  net.minecraft.class_9275
 *  net.minecraft.class_9334
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.platform.Services;
import backported.updates.copper.registry.ModBlocks;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_756;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_9275;
import net.minecraft.class_9334;

public class CopperItemRenderer
extends class_756 {
    public CopperItemRenderer() {
        super(class_310.method_1551().method_31975(), class_310.method_1551().method_31974());
    }

    public void method_3166(class_1799 stack, class_811 displayContext, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        class_1792 class_17922 = stack.method_7909();
        if (!(class_17922 instanceof class_1747)) {
            return;
        }
        class_1747 blockItem = (class_1747)class_17922;
        class_2248 block = blockItem.method_7711();
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

    private boolean isChestBlock(class_2248 block) {
        return block == ModBlocks.COPPER_CHEST.get() || block == ModBlocks.EXPOSED_COPPER_CHEST.get() || block == ModBlocks.WEATHERED_COPPER_CHEST.get() || block == ModBlocks.OXIDIZED_COPPER_CHEST.get() || block == ModBlocks.WAXED_COPPER_CHEST.get() || block == ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get() || block == ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get() || block == ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get();
    }

    private void renderChestItem(class_2248 block, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        CopperChestBlockEntity blockEntity = new CopperChestBlockEntity(class_2338.field_10980, block.method_9564());
        class_310.method_1551().method_31975().method_23077((class_2586)blockEntity, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private void renderChestItemAsBlock(class_2248 block, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        class_2680 state = block.method_9564();
        poseStack.method_22903();
        poseStack.method_22904(0.5, 0.0, 0.5);
        poseStack.method_22907(class_7833.field_40716.rotationDegrees(180.0f));
        poseStack.method_22904(-0.5, 0.0, -0.5);
        class_310.method_1551().method_1541().method_3353(state, poseStack, bufferSource, packedLight, packedOverlay);
        poseStack.method_22909();
    }

    private void renderStatueItem(class_2248 block, class_1799 stack, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        class_2680 state = this.resolveBlockState(block, stack);
        CopperGolemStatueBlockEntity blockEntity = new CopperGolemStatueBlockEntity(class_2338.field_10980, state);
        blockEntity.method_58683(stack);
        class_310.method_1551().method_31975().method_23077((class_2586)blockEntity, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private class_2680 resolveBlockState(class_2248 block, class_1799 stack) {
        class_2680 state = block.method_9564();
        class_9275 properties = (class_9275)stack.method_57824(class_9334.field_49623);
        if (properties != null && !properties.method_57414()) {
            state = properties.method_57415(state);
        }
        return state;
    }
}

