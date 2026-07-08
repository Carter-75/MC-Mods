/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.utils.ModRenderTypes;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CoalGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class CoalGolemRenderer
extends BaseGolemRenderer<CoalGolem> {
    public static final class_2960 TEXTURE = GolemOverhaul.asResource("textures/entity/coal/coal_golem.png");
    public static final class_2960 LIT_TEXTURE = GolemOverhaul.asResource("textures/entity/coal/coal_golem_lit.png");

    public CoalGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<CoalGolem>(ModEntityTypes.COAL_GOLEM, false, 0));
        this.addRenderLayer((GeoRenderLayer)new AutoGlowingGeoLayer<CoalGolem>((GeoRenderer)this){

            protected class_1921 getRenderType(CoalGolem golem) {
                return golem.isLit() ? ModRenderTypes.eyesNoCull(LIT_TEXTURE) : class_1921.method_23576((class_2960)TEXTURE);
            }
        });
    }

    @NotNull
    public class_2960 getTextureLocation(CoalGolem golem) {
        return golem.isLit() ? LIT_TEXTURE : TEXTURE;
    }

    protected void applyRotations(CoalGolem golem, class_4587 poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        int deathTime = golem.field_6213;
        golem.field_6213 = 0;
        super.applyRotations((class_1297)golem, poseStack, ageInTicks, rotationYaw, partialTick);
        golem.field_6213 = deathTime;
    }
}

