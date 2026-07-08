/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.client.CloseablePoseStack
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_7833
 *  net.minecraft.class_7923
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.DefaultedEntityGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.projectiles;

import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_7833;
import net.minecraft.class_7923;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.HoneyBlobProjectile;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class HoneyBlobProjectileRenderer
extends GeoEntityRenderer<HoneyBlobProjectile> {
    public HoneyBlobProjectileRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, (GeoModel)new DefaultedEntityGeoModel(class_7923.field_41177.method_10221((Object)((class_1299)ModEntityTypes.HONEY_BLOB.get()))));
    }

    public class_1921 getRenderType(HoneyBlobProjectile animatable, class_2960 texture, class_4597 bufferSource, float partialTick) {
        return class_1921.method_42600((class_2960)texture);
    }

    public void actuallyRender(class_4587 poseStack, HoneyBlobProjectile animatable, BakedGeoModel model, class_1921 renderType, class_4597 bufferSource, class_4588 buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        try (CloseablePoseStack pose = new CloseablePoseStack(poseStack);){
            pose.method_22907(class_7833.field_40716.rotationDegrees(class_3532.method_16439((float)partialTick, (float)animatable.field_5982, (float)animatable.method_36454())));
            pose.method_22907(class_7833.field_40713.rotationDegrees(class_3532.method_16439((float)partialTick, (float)animatable.field_6004, (float)animatable.method_36455())));
            super.actuallyRender(poseStack, (class_1297)animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}

