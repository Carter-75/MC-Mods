/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5614$class_5615
 *  net.minecraft.class_827
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.client.model.CopperGolemStatueModel;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5614;
import net.minecraft.class_827;

public class CopperGolemStatueRenderer
implements class_827<CopperGolemStatueBlockEntity> {
    private final Map<CopperGolemStatueBlock.Pose, CopperGolemStatueModel> models = new HashMap<CopperGolemStatueBlock.Pose, CopperGolemStatueModel>();

    public CopperGolemStatueRenderer(class_5614.class_5615 context) {
        this.models.put(CopperGolemStatueBlock.Pose.STANDING, new CopperGolemStatueModel(context.method_32140(CopperGolemModel.STATUE_STANDING)));
        this.models.put(CopperGolemStatueBlock.Pose.RUNNING, new CopperGolemStatueModel(context.method_32140(CopperGolemModel.STATUE_RUNNING)));
        this.models.put(CopperGolemStatueBlock.Pose.SITTING, new CopperGolemStatueModel(context.method_32140(CopperGolemModel.STATUE_SITTING)));
        this.models.put(CopperGolemStatueBlock.Pose.STAR, new CopperGolemStatueModel(context.method_32140(CopperGolemModel.STATUE_STAR)));
    }

    public void render(CopperGolemStatueBlockEntity blockEntity, float partialTick, class_4587 poseStack, class_4597 bufferSource, int packedLight, int packedOverlay) {
        class_2680 blockState = blockEntity.method_11010();
        class_2248 class_22482 = blockState.method_26204();
        if (!(class_22482 instanceof CopperGolemStatueBlock)) {
            return;
        }
        CopperGolemStatueBlock statueBlock = (CopperGolemStatueBlock)class_22482;
        CopperGolemStatueBlock.Pose pose = (CopperGolemStatueBlock.Pose)((Object)blockState.method_11654(CopperGolemStatueBlock.POSE));
        class_1937 level = blockEntity.method_10997();
        boolean hasLevel = level != null;
        class_2350 facing = hasLevel ? (class_2350)blockState.method_11654((class_2769)CopperGolemStatueBlock.FACING) : class_2350.field_11035;
        CopperGolemStatueModel model = this.models.get((Object)pose);
        if (model == null) {
            return;
        }
        class_2960 texture = CopperGolemOxidationLevels.getOxidationLevel(statueBlock.getWeatheringState()).texture();
        poseStack.method_22903();
        poseStack.method_22904(0.5, 0.0, 0.5);
        model.setupAnim(facing);
        class_1921 renderType = class_1921.method_23578((class_2960)texture);
        model.method_2828(poseStack, bufferSource.getBuffer(renderType), packedLight, packedOverlay, -1);
        poseStack.method_22909();
    }
}

