/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 */
package backported.updates.copper.client.renderer.layers;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;

public class CopperGolemEyesLayer
extends class_3887<CopperGolemEntity, CopperGolemModel> {
    public CopperGolemEyesLayer(class_3883<CopperGolemEntity, CopperGolemModel> renderer) {
        super(renderer);
    }

    public void render(class_4587 poseStack, class_4597 buffer, int packedLight, CopperGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.method_5767()) {
            return;
        }
        class_2960 eyeTexture = CopperGolemOxidationLevels.getOxidationLevel(entity.getWeatherState()).eyeTexture();
        class_1921 renderType = class_1921.method_23026((class_2960)eyeTexture);
        class_4588 vertexConsumer = buffer.getBuffer(renderType);
        ((CopperGolemModel)this.method_17165()).method_2828(poseStack, vertexConsumer, 0xF000F0, class_4608.field_21444, -1);
    }
}

