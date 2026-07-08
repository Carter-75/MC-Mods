/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.client.CloseablePoseStack
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1921
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.cache.object.GeoBone
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.layers;

import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1921;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.BarrelGolem;

public class BarrelGolemHeldItemLayer
extends GeoRenderLayer<BarrelGolem> {
    public BarrelGolemHeldItemLayer(GeoRenderer<BarrelGolem> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(class_4587 poseStack, BarrelGolem golem, BakedGeoModel bakedModel, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, float partialTick, int packedLight, int packedOverlay) {
        if (!golem.isBartering() || golem.getBarteringTicks() < 34) {
            return;
        }
        if (golem.method_29504()) {
            return;
        }
        class_1799 stack = golem.method_6047();
        if (stack.method_7960()) {
            return;
        }
        GeoBone itemBone = this.getGeoModel().getBone("item").orElse(null);
        if (itemBone == null) {
            return;
        }
        float lerped = class_3532.method_17821((float)partialTick, (float)golem.field_6220, (float)golem.field_6283);
        try (CloseablePoseStack pose = new CloseablePoseStack(poseStack);){
            pose.method_22907(class_7833.field_40716.rotationDegrees(180.0f));
            pose.method_22907(class_7833.field_40716.rotationDegrees(-lerped));
            pose.method_34425(itemBone.getModelRotationMatrix());
            class_310.method_1551().method_1480().method_23177((class_1309)golem, stack, class_811.field_4322, false, (class_4587)pose, bufferSource, golem.method_37908(), packedLight, packedOverlay, golem.method_5628());
        }
    }
}

