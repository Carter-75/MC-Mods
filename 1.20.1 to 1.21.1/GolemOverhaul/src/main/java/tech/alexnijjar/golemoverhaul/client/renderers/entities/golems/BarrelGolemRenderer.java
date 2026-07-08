/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.layers.BarrelGolemHeldItemLayer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.BarrelGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class BarrelGolemRenderer
extends BaseGolemRenderer<BarrelGolem> {
    public static final class_2960 GLOW = GolemOverhaul.asResource("textures/entity/barrel/barrel_golem_glow.png");

    public BarrelGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<BarrelGolem>(ModEntityTypes.BARREL_GOLEM, true, 10){

            @Override
            public void setCustomAnimations(BarrelGolem golem, long instanceId, AnimationState<BarrelGolem> animationState) {
                boolean shouldAnimationOverrideHeadRotation;
                boolean bl = shouldAnimationOverrideHeadRotation = !golem.isOpen() || golem.isBartering();
                if (shouldAnimationOverrideHeadRotation) {
                    return;
                }
                super.setCustomAnimations(golem, instanceId, animationState);
            }
        });
        this.addRenderLayer((GeoRenderLayer)new AutoGlowingGeoLayer<BarrelGolem>((GeoRenderer)this){

            protected class_1921 getRenderType(BarrelGolem animatable) {
                return class_1921.method_23026((class_2960)GLOW);
            }
        });
        this.addRenderLayer(new BarrelGolemHeldItemLayer((GeoRenderer<BarrelGolem>)this));
    }
}

