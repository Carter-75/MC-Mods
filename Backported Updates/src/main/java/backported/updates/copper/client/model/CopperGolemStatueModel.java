/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.math.Direction
 *  net.minecraft.Model
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.copper.client.model;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.Direction;
import net.minecraft.client.model.Model;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.model.ModelPart;

public class CopperGolemStatueModel
extends Model {
    private final ModelPart root;

    public CopperGolemStatueModel(ModelPart root) {
        super(RenderLayer::getEntityCutoutNoCull);
        this.root = root;
    }

    public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    public void setupAnim(Direction facing) {
        this.root.pivotY = 0.0f;
        this.root.yaw = facing.getOpposite().asRotation() * ((float)Math.PI / 180);
        this.root.roll = (float)Math.PI;
    }
}

