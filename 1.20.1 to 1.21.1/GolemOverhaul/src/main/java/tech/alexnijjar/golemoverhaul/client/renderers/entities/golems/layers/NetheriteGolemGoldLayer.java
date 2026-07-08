/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.layers;

import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.NetheriteGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;

public class NetheriteGolemGoldLayer
extends GeoRenderLayer<NetheriteGolem> {
    public NetheriteGolemGoldLayer(GeoRenderer<NetheriteGolem> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(class_4587 poseStack, NetheriteGolem golem, BakedGeoModel bakedModel, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, float partialTick, int packedLight, int packedOverlay) {
        if (!golem.isGilded()) {
            return;
        }
        class_4588 vertexConsumer = bufferSource.getBuffer(class_1921.method_23576((class_2960)NetheriteGolemRenderer.GOLD_OVERLAY));
        this.getRenderer().reRender(this.getDefaultBakedModel((GeoAnimatable)golem), poseStack, bufferSource, (GeoAnimatable)golem, renderType, vertexConsumer, partialTick, packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
    }
}

