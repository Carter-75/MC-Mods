/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.floats.Float2FloatFunction
 *  it.unimi.dsi.fastutil.ints.Int2IntFunction
 *  net.minecraft.class_1921
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2350
 *  net.minecraft.class_2595
 *  net.minecraft.class_2618
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4722
 *  net.minecraft.class_4730
 *  net.minecraft.class_4732$class_3923
 *  net.minecraft.class_4732$class_4734
 *  net.minecraft.class_4737
 *  net.minecraft.class_5602
 *  net.minecraft.class_5614$class_5615
 *  net.minecraft.class_630
 *  net.minecraft.class_7833
 *  net.minecraft.class_827
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.registry.ModBlocks;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2350;
import net.minecraft.class_2595;
import net.minecraft.class_2618;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4722;
import net.minecraft.class_4730;
import net.minecraft.class_4732;
import net.minecraft.class_4737;
import net.minecraft.class_5602;
import net.minecraft.class_5614;
import net.minecraft.class_630;
import net.minecraft.class_7833;
import net.minecraft.class_827;

public class CopperChestRenderer
implements class_827<class_2595> {
    private static final class_4730 COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper");
    private static final class_4730 COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_left");
    private static final class_4730 COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_right");
    private static final class_4730 EXPOSED_COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper_exposed");
    private static final class_4730 EXPOSED_COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_exposed_left");
    private static final class_4730 EXPOSED_COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_exposed_right");
    private static final class_4730 WEATHERED_COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper_weathered");
    private static final class_4730 WEATHERED_COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_weathered_left");
    private static final class_4730 WEATHERED_COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_weathered_right");
    private static final class_4730 OXIDIZED_COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper_oxidized");
    private static final class_4730 OXIDIZED_COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_oxidized_left");
    private static final class_4730 OXIDIZED_COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_oxidized_right");
    private final class_630 lid;
    private final class_630 bottom;
    private final class_630 lock;
    private final class_630 doubleLeftLid;
    private final class_630 doubleLeftBottom;
    private final class_630 doubleLeftLock;
    private final class_630 doubleRightLid;
    private final class_630 doubleRightBottom;
    private final class_630 doubleRightLock;

    public CopperChestRenderer(class_5614.class_5615 context) {
        class_630 singleChest = context.method_32140(class_5602.field_27689);
        this.bottom = singleChest.method_32086("bottom");
        this.lid = singleChest.method_32086("lid");
        this.lock = singleChest.method_32086("lock");
        class_630 doubleChestLeft = context.method_32140(class_5602.field_27551);
        this.doubleLeftBottom = doubleChestLeft.method_32086("bottom");
        this.doubleLeftLid = doubleChestLeft.method_32086("lid");
        this.doubleLeftLock = doubleChestLeft.method_32086("lock");
        class_630 doubleChestRight = context.method_32140(class_5602.field_27552);
        this.doubleRightBottom = doubleChestRight.method_32086("bottom");
        this.doubleRightLid = doubleChestRight.method_32086("lid");
        this.doubleRightLock = doubleChestRight.method_32086("lock");
    }

    private static class_4730 chestMaterial(String name) {
        return new class_4730(class_4722.field_21709, class_2960.method_60656((String)("entity/chest/" + name)));
    }

    public void render(class_2595 blockEntity, float partialTick, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        class_2248 block;
        class_1937 level;
        boolean flag;
        class_2680 blockstate = blockEntity.method_11010();
        if (!(blockstate.method_26204() instanceof CopperChestBlock)) {
            blockstate = ModBlocks.COPPER_CHEST.get().method_9564();
        }
        boolean bl = flag = (level = blockEntity.method_10997()) != null;
        if (blockstate.method_28498((class_2769)class_2281.field_10768) && !flag) {
            blockstate = (class_2680)blockstate.method_11657((class_2769)class_2281.field_10768, (Comparable)class_2350.field_11035);
        }
        if (!blockstate.method_28498((class_2769)class_2281.field_10768)) {
            blockstate = (class_2680)blockstate.method_11657((class_2769)class_2281.field_10768, (Comparable)class_2350.field_11035);
        }
        if ((block = blockstate.method_26204()) instanceof CopperChestBlock) {
            CopperChestBlock copperChestBlock = (CopperChestBlock)block;
            poseStack.method_22903();
            float f = ((class_2350)blockstate.method_11654((class_2769)class_2281.field_10768)).method_10144();
            poseStack.method_46416(0.5f, 0.5f, 0.5f);
            poseStack.method_22907(class_7833.field_40716.rotationDegrees(-f));
            poseStack.method_46416(-0.5f, -0.5f, -0.5f);
            class_4732.class_4734 result = flag ? copperChestBlock.method_24167(blockstate, level, blockEntity.method_11016(), true) : class_4732.class_3923::method_24174;
            float openness = ((Float2FloatFunction)result.apply(class_2281.method_24166((class_2618)blockEntity))).get(partialTick);
            openness = 1.0f - openness;
            openness = 1.0f - openness * openness * openness;
            int light = ((Int2IntFunction)result.apply((class_4732.class_3923)new class_4737())).applyAsInt(packedLight);
            class_2745 chestType = blockstate.method_28498((class_2769)class_2281.field_10770) ? (class_2745)blockstate.method_11654((class_2769)class_2281.field_10770) : class_2745.field_12569;
            class_4730 material = this.getMaterial(blockstate, chestType);
            class_4588 vertexconsumer = material.method_24145(bufferSource, class_1921::method_23576);
            if (chestType == class_2745.field_12574) {
                this.renderParts(poseStack, vertexconsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, openness, light, packedOverlay);
            } else if (chestType == class_2745.field_12571) {
                this.renderParts(poseStack, vertexconsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, openness, light, packedOverlay);
            } else {
                this.renderParts(poseStack, vertexconsumer, this.lid, this.lock, this.bottom, openness, light, packedOverlay);
            }
            poseStack.method_22909();
        }
    }

    private void renderParts(class_4587 poseStack, class_4588 consumer, class_630 lid, class_630 lock, class_630 bottom, float openness, int light, int overlay) {
        lock.field_3654 = lid.field_3654 = -(openness * 1.5707964f);
        lid.method_22698(poseStack, consumer, light, overlay);
        lock.method_22698(poseStack, consumer, light, overlay);
        bottom.method_22698(poseStack, consumer, light, overlay);
    }

    private class_4730 getMaterial(class_2680 state, class_2745 chestType) {
        class_2248 block = state.method_26204();
        if (block == ModBlocks.COPPER_CHEST.get() || block == ModBlocks.WAXED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case class_2745.field_12574 -> COPPER_CHEST_LEFT_MATERIAL;
                case class_2745.field_12571 -> COPPER_CHEST_RIGHT_MATERIAL;
                default -> COPPER_CHEST_MATERIAL;
            };
        }
        if (block == ModBlocks.EXPOSED_COPPER_CHEST.get() || block == ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case class_2745.field_12574 -> EXPOSED_COPPER_CHEST_LEFT_MATERIAL;
                case class_2745.field_12571 -> EXPOSED_COPPER_CHEST_RIGHT_MATERIAL;
                default -> EXPOSED_COPPER_CHEST_MATERIAL;
            };
        }
        if (block == ModBlocks.WEATHERED_COPPER_CHEST.get() || block == ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case class_2745.field_12574 -> WEATHERED_COPPER_CHEST_LEFT_MATERIAL;
                case class_2745.field_12571 -> WEATHERED_COPPER_CHEST_RIGHT_MATERIAL;
                default -> WEATHERED_COPPER_CHEST_MATERIAL;
            };
        }
        if (block == ModBlocks.OXIDIZED_COPPER_CHEST.get() || block == ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case class_2745.field_12574 -> OXIDIZED_COPPER_CHEST_LEFT_MATERIAL;
                case class_2745.field_12571 -> OXIDIZED_COPPER_CHEST_RIGHT_MATERIAL;
                default -> OXIDIZED_COPPER_CHEST_MATERIAL;
            };
        }
        return class_4722.field_21720;
    }
}

