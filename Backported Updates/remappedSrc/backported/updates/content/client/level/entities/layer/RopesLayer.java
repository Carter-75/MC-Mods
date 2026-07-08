/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5599
 */
package backported.updates.content.client.level.entities.layer;

import backported.updates.content.client.level.entities.model.HappyGhastModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5599;

@Environment(value=EnvType.CLIENT)
public class RopesLayer<T extends HappyGhast>
extends class_3887<T, HappyGhastModel<T>> {
    private final class_1921 ropes;
    private final HappyGhastModel<T> model;

    public RopesLayer(class_3883<T, HappyGhastModel<T>> renderer, class_5599 modelSet, class_2960 texture) {
        super(renderer);
        this.ropes = class_1921.method_23578((class_2960)texture);
        this.model = new HappyGhastModel(modelSet.method_32072(ModModelLayers.HAPPY_GHAST_ROPES));
    }

    public void render(class_4587 poseStack, class_4597 buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (((HappyGhast)entity).isLeashHolder() && ((HappyGhast)entity).isHarnessed()) {
            this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.method_60879(poseStack, buffer.getBuffer(this.ropes), packedLight, class_4608.field_21444);
        }
    }
}

