/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.cache.object.GeoBone
 *  software.bernie.geckolib.core.animatable.model.CoreGeoBone
 *  software.bernie.geckolib.util.RenderUtils
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.util.RenderUtils;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.SlimeGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class SlimeGolemRenderer
extends BaseGolemRenderer<SlimeGolem> {
    public static final class_2960 LARGE_TEXTURE = GolemOverhaul.asResource("textures/entity/slime/slime_golem.png");
    public static final class_2960 SMALL_TEXTURE = GolemOverhaul.asResource("textures/entity/slime/small_slime_golem.png");
    public static final class_2960 LARGE_MODEL = GolemOverhaul.asResource("geo/entity/slime/slime_golem.geo.json");
    public static final class_2960 SMALL_MODEL = GolemOverhaul.asResource("geo/entity/slime/small_slime_golem.geo.json");

    public SlimeGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<SlimeGolem>(ModEntityTypes.SLIME_GOLEM, false, 0){

            public class_2960 getModelResource(SlimeGolem golem) {
                return golem.getSize().isLarge() ? LARGE_MODEL : SMALL_MODEL;
            }
        });
    }

    public class_2960 getTextureLocation(SlimeGolem golem) {
        return golem.getSize().isLarge() ? LARGE_TEXTURE : SMALL_TEXTURE;
    }

    @Nullable
    public class_1921 getRenderType(SlimeGolem animatable, class_2960 texture, @Nullable class_4597 bufferSource, float partialTick) {
        return class_1921.method_23580((class_2960)texture);
    }

    public void renderRecursively(class_4587 poseStack, SlimeGolem golem, GeoBone bone, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        boolean isInnerBodyBone = "body_2".equals(bone.getName());
        if (isInnerBodyBone) {
            float healthPercent = 0.5f + class_3532.method_15363((float)(golem.method_6032() / 2.0f / golem.method_6063()), (float)0.0f, (float)0.5f);
            poseStack.method_22903();
            RenderUtils.translateToPivotPoint((class_4587)poseStack, (CoreGeoBone)bone);
            poseStack.method_22905(healthPercent, healthPercent, healthPercent);
            RenderUtils.translateAwayFromPivotPoint((class_4587)poseStack, (CoreGeoBone)bone);
        }
        super.renderRecursively(poseStack, (class_1297)golem, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        if (isInnerBodyBone) {
            poseStack.method_22909();
        }
    }
}

