/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5617$class_5618
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.cache.object.GeoBone
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5617;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.KelpGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class KelpGolemRenderer
extends BaseGolemRenderer<KelpGolem> {
    public static final class_2960 GLOW = GolemOverhaul.asResource("textures/entity/kelp/kelp_golem_glow.png");

    public KelpGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<KelpGolem>(ModEntityTypes.KELP_GOLEM, true, 90));
        this.addRenderLayer((GeoRenderLayer)new AutoGlowingGeoLayer<KelpGolem>((GeoRenderer)this){

            protected class_1921 getRenderType(KelpGolem animatable) {
                return class_1921.method_23026((class_2960)GLOW);
            }

            public void render(class_4587 poseStack, KelpGolem golem, BakedGeoModel bakedModel, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, float partialTick, int packedLight, int packedOverlay) {
                float percent = golem.method_6032() / golem.method_6063();
                renderType = this.getRenderType((KelpGolem)KelpGolemRenderer.this.animatable);
                this.getRenderer().reRender(bakedModel, poseStack, bufferSource, (GeoAnimatable)golem, renderType, bufferSource.getBuffer(renderType), partialTick, 0xF000F0, class_4608.field_21444, percent, percent, percent, percent);
            }
        });
    }

    public void renderRecursively(class_4587 poseStack, KelpGolem golem, GeoBone bone, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (("particle".equals(bone.getName()) || "particle2".equals(bone.getName())) && !golem.isCharged()) {
            return;
        }
        super.renderRecursively(poseStack, (class_1297)golem, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}

