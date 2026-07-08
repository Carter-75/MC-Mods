/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1439;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.utils.ModRenderTypes;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CandleGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class CandleGolemRenderer
extends BaseGolemRenderer<CandleGolem> {
    public static final class_2960 GLOW_1 = GolemOverhaul.asResource("textures/entity/candle/candle_golem_1_glow.png");
    public static final class_2960 GLOW_2 = GolemOverhaul.asResource("textures/entity/candle/candle_golem_2_glow.png");
    public static final class_2960 MODEL_1 = GolemOverhaul.asResource("geo/entity/candle/candle_golem_1.geo.json");
    public static final class_2960 MODEL_2 = GolemOverhaul.asResource("geo/entity/candle/candle_golem_2.geo.json");
    public static final class_2960 MODEL_3 = GolemOverhaul.asResource("geo/entity/candle/candle_golem_3.geo.json");

    public CandleGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<CandleGolem>(ModEntityTypes.CANDLE_GOLEM, true, 90){

            public class_2960 getModelResource(CandleGolem golem) {
                return switch (golem.getCrackiness()) {
                    default -> throw new IncompatibleClassChangeError();
                    case class_1439.class_4621.field_21081, class_1439.class_4621.field_21082 -> MODEL_1;
                    case class_1439.class_4621.field_21083 -> MODEL_2;
                    case class_1439.class_4621.field_21084 -> MODEL_3;
                };
            }
        });
        this.addRenderLayer((GeoRenderLayer)new AutoGlowingGeoLayer<CandleGolem>((GeoRenderer)this){

            protected class_1921 getRenderType(CandleGolem golem) {
                return switch (golem.getCrackiness()) {
                    default -> throw new IncompatibleClassChangeError();
                    case class_1439.class_4621.field_21081, class_1439.class_4621.field_21082 -> ModRenderTypes.eyesNoCull(GLOW_1);
                    case class_1439.class_4621.field_21083 -> ModRenderTypes.eyesNoCull(GLOW_2);
                    case class_1439.class_4621.field_21084 -> super.getRenderType((GeoAnimatable)golem);
                };
            }

            public void render(class_4587 poseStack, CandleGolem golem, BakedGeoModel bakedModel, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, float partialTick, int packedLight, int packedOverlay) {
                if (golem.isLit()) {
                    super.render(poseStack, (GeoAnimatable)golem, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
                }
            }
        });
    }
}

