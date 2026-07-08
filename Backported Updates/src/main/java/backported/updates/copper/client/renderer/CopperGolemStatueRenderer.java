/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.block.entity.BlockEntityRendererFactory$Context
 *  net.minecraft.client.render.block.entity.BlockEntityRenderer
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.client.model.CopperGolemStatueModel;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;

public class CopperGolemStatueRenderer
implements BlockEntityRenderer<CopperGolemStatueBlockEntity> {
    private final Map<CopperGolemStatueBlock.Pose, CopperGolemStatueModel> models = new HashMap<CopperGolemStatueBlock.Pose, CopperGolemStatueModel>();

    public CopperGolemStatueRenderer(BlockEntityRendererFactory.Context context) {
        this.models.put(CopperGolemStatueBlock.Pose.STANDING, new CopperGolemStatueModel(context.getLayerModelPart(CopperGolemModel.STATUE_STANDING)));
        this.models.put(CopperGolemStatueBlock.Pose.RUNNING, new CopperGolemStatueModel(context.getLayerModelPart(CopperGolemModel.STATUE_RUNNING)));
        this.models.put(CopperGolemStatueBlock.Pose.SITTING, new CopperGolemStatueModel(context.getLayerModelPart(CopperGolemModel.STATUE_SITTING)));
        this.models.put(CopperGolemStatueBlock.Pose.STAR, new CopperGolemStatueModel(context.getLayerModelPart(CopperGolemModel.STATUE_STAR)));
    }

    public void render(CopperGolemStatueBlockEntity blockEntity, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        BlockState blockState = blockEntity.getCachedState();
        Block class_22482 = blockState.getBlock();
        if (!(class_22482 instanceof CopperGolemStatueBlock)) {
            return;
        }
        CopperGolemStatueBlock statueBlock = (CopperGolemStatueBlock)class_22482;
        CopperGolemStatueBlock.Pose pose = (CopperGolemStatueBlock.Pose)(blockState.get(CopperGolemStatueBlock.POSE));
        World level = blockEntity.getWorld();
        boolean hasLevel = level != null;
        Direction facing = hasLevel ? (Direction)blockState.get(CopperGolemStatueBlock.FACING) : Direction.SOUTH;
        CopperGolemStatueModel model = this.models.get(pose);
        if (model == null) {
            return;
        }
        Identifier texture = CopperGolemOxidationLevels.getOxidationLevel(statueBlock.getWeatheringState()).texture();
        poseStack.push();
        poseStack.translate(0.5, 0.0, 0.5);
        model.setupAnim(facing);
        RenderLayer renderType = RenderLayer.getEntityCutoutNoCull(texture);
        model.render(poseStack, bufferSource.getBuffer(renderType), packedLight, packedOverlay, -1);
        poseStack.pop();
    }
}

