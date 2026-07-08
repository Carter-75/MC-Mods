/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.floats.Float2FloatFunction
 *  it.unimi.dsi.fastutil.ints.Int2IntFunction
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.entity.LidOpenable
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.Property
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.TexturedRenderLayers
 *  net.minecraft.client.util.SpriteIdentifier
 *  net.minecraft.block.DoubleBlockProperties$PropertyRetriever
 *  net.minecraft.block.DoubleBlockProperties$PropertySource
 *  net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever
 *  net.minecraft.client.render.entity.model.EntityModelLayers
 *  net.minecraft.client.render.block.entity.BlockEntityRendererFactory$Context
 *  net.minecraft.client.model.ModelPart
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.client.render.block.entity.BlockEntityRenderer
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.registry.ModBlocks;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.Direction;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.ChestType;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.model.ModelPart;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;

public class CopperChestRenderer
implements BlockEntityRenderer<ChestBlockEntity> {
    private static final SpriteIdentifier COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper");
    private static final SpriteIdentifier COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_left");
    private static final SpriteIdentifier COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_right");
    private static final SpriteIdentifier EXPOSED_COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper_exposed");
    private static final SpriteIdentifier EXPOSED_COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_exposed_left");
    private static final SpriteIdentifier EXPOSED_COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_exposed_right");
    private static final SpriteIdentifier WEATHERED_COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper_weathered");
    private static final SpriteIdentifier WEATHERED_COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_weathered_left");
    private static final SpriteIdentifier WEATHERED_COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_weathered_right");
    private static final SpriteIdentifier OXIDIZED_COPPER_CHEST_MATERIAL = CopperChestRenderer.chestMaterial("copper_oxidized");
    private static final SpriteIdentifier OXIDIZED_COPPER_CHEST_LEFT_MATERIAL = CopperChestRenderer.chestMaterial("copper_oxidized_left");
    private static final SpriteIdentifier OXIDIZED_COPPER_CHEST_RIGHT_MATERIAL = CopperChestRenderer.chestMaterial("copper_oxidized_right");
    private final ModelPart lid;
    private final ModelPart bottom;
    private final ModelPart lock;
    private final ModelPart doubleLeftLid;
    private final ModelPart doubleLeftBottom;
    private final ModelPart doubleLeftLock;
    private final ModelPart doubleRightLid;
    private final ModelPart doubleRightBottom;
    private final ModelPart doubleRightLock;

    public CopperChestRenderer(BlockEntityRendererFactory.Context context) {
        ModelPart singleChest = context.getLayerModelPart(EntityModelLayers.CHEST);
        this.bottom = singleChest.getChild("bottom");
        this.lid = singleChest.getChild("lid");
        this.lock = singleChest.getChild("lock");
        ModelPart doubleChestLeft = context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_LEFT);
        this.doubleLeftBottom = doubleChestLeft.getChild("bottom");
        this.doubleLeftLid = doubleChestLeft.getChild("lid");
        this.doubleLeftLock = doubleChestLeft.getChild("lock");
        ModelPart doubleChestRight = context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_RIGHT);
        this.doubleRightBottom = doubleChestRight.getChild("bottom");
        this.doubleRightLid = doubleChestRight.getChild("lid");
        this.doubleRightLock = doubleChestRight.getChild("lock");
    }

    private static SpriteIdentifier chestMaterial(String name) {
        return new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, Identifier.ofVanilla((String)("entity/chest/" + name)));
    }

    public void render(ChestBlockEntity blockEntity, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        Block block;
        World level;
        boolean flag;
        BlockState blockstate = blockEntity.getCachedState();
        if (!(blockstate.getBlock() instanceof CopperChestBlock)) {
            blockstate = ModBlocks.COPPER_CHEST.get().getDefaultState();
        }
        boolean bl = flag = (level = blockEntity.getWorld()) != null;
        if (blockstate.contains(ChestBlock.FACING) && !flag) {
            blockstate = blockstate.with(ChestBlock.FACING, Direction.SOUTH);
        }
        if (!blockstate.contains(ChestBlock.FACING)) {
            blockstate = blockstate.with(ChestBlock.FACING, Direction.SOUTH);
        }
        if ((block = blockstate.getBlock()) instanceof CopperChestBlock) {
            CopperChestBlock copperChestBlock = (CopperChestBlock)block;
            poseStack.push();
            float f = ((Direction)blockstate.get(ChestBlock.FACING)).asRotation();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-f));
            poseStack.translate(-0.5f, -0.5f, -0.5f);
            DoubleBlockProperties.PropertySource result = flag ? copperChestBlock.getBlockEntitySource(blockstate, level, blockEntity.getPos(), true) : DoubleBlockProperties.PropertyRetriever::getFallback;
            float openness = ((Float2FloatFunction)result.apply(ChestBlock.getAnimationProgressRetriever((LidOpenable)blockEntity))).get(partialTick);
            openness = 1.0f - openness;
            openness = 1.0f - openness * openness * openness;
            int light = ((Int2IntFunction)result.apply((DoubleBlockProperties.PropertyRetriever)new LightmapCoordinatesRetriever())).applyAsInt(packedLight);
            ChestType chestType = blockstate.contains(ChestBlock.CHEST_TYPE) ? (ChestType)blockstate.get(ChestBlock.CHEST_TYPE) : ChestType.SINGLE;
            SpriteIdentifier material = this.getMaterial(blockstate, chestType);
            VertexConsumer vertexconsumer = material.getVertexConsumer(bufferSource, RenderLayer::getEntityCutout);
            if (chestType == ChestType.LEFT) {
                this.renderParts(poseStack, vertexconsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, openness, light, packedOverlay);
            } else if (chestType == ChestType.RIGHT) {
                this.renderParts(poseStack, vertexconsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, openness, light, packedOverlay);
            } else {
                this.renderParts(poseStack, vertexconsumer, this.lid, this.lock, this.bottom, openness, light, packedOverlay);
            }
            poseStack.pop();
        }
    }

    private void renderParts(MatrixStack poseStack, VertexConsumer consumer, ModelPart lid, ModelPart lock, ModelPart bottom, float openness, int light, int overlay) {
        lock.pitch = lid.pitch = -(openness * 1.5707964f);
        lid.render(poseStack, consumer, light, overlay);
        lock.render(poseStack, consumer, light, overlay);
        bottom.render(poseStack, consumer, light, overlay);
    }

    private SpriteIdentifier getMaterial(BlockState state, ChestType chestType) {
        Block block = state.getBlock();
        if (block == ModBlocks.COPPER_CHEST.get() || block == ModBlocks.WAXED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case ChestType.LEFT -> COPPER_CHEST_LEFT_MATERIAL;
                case ChestType.RIGHT -> COPPER_CHEST_RIGHT_MATERIAL;
                default -> COPPER_CHEST_MATERIAL;
            };
        }
        if (block == ModBlocks.EXPOSED_COPPER_CHEST.get() || block == ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case ChestType.LEFT -> EXPOSED_COPPER_CHEST_LEFT_MATERIAL;
                case ChestType.RIGHT -> EXPOSED_COPPER_CHEST_RIGHT_MATERIAL;
                default -> EXPOSED_COPPER_CHEST_MATERIAL;
            };
        }
        if (block == ModBlocks.WEATHERED_COPPER_CHEST.get() || block == ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case ChestType.LEFT -> WEATHERED_COPPER_CHEST_LEFT_MATERIAL;
                case ChestType.RIGHT -> WEATHERED_COPPER_CHEST_RIGHT_MATERIAL;
                default -> WEATHERED_COPPER_CHEST_MATERIAL;
            };
        }
        if (block == ModBlocks.OXIDIZED_COPPER_CHEST.get() || block == ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get()) {
            return switch (chestType) {
                case ChestType.LEFT -> OXIDIZED_COPPER_CHEST_LEFT_MATERIAL;
                case ChestType.RIGHT -> OXIDIZED_COPPER_CHEST_RIGHT_MATERIAL;
                default -> OXIDIZED_COPPER_CHEST_MATERIAL;
            };
        }
        return TexturedRenderLayers.NORMAL;
    }
}

