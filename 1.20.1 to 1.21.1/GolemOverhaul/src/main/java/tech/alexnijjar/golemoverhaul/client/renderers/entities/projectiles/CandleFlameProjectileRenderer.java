/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_7833
 *  net.minecraft.class_897
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix3f
 *  org.joml.Matrix4f
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.projectiles;

import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5617;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.CandleFlameProjectile;

public class CandleFlameProjectileRenderer
extends class_897<CandleFlameProjectile> {
    private static final class_2960 TEXTURE = new class_2960("textures/particle/flame.png");

    public CandleFlameProjectileRenderer(class_5617.class_5618 context) {
        super(context);
    }

    public void render(@NotNull CandleFlameProjectile entity, float entityYaw, float partialTick, class_4587 poseStack, class_4597 buffer, int packedLight) {
        poseStack.method_22903();
        poseStack.method_22907(this.field_4676.method_24197());
        poseStack.method_22907(class_7833.field_40716.rotationDegrees(180.0f));
        class_4587.class_4665 pose = poseStack.method_23760();
        Matrix4f matrix4f = pose.method_23761();
        Matrix3f matrix3f = pose.method_23762();
        class_4588 vertexConsumer = buffer.getBuffer(class_1921.method_23580((class_2960)this.getTextureLocation(entity)));
        this.addVertex(vertexConsumer, matrix4f, matrix3f, -0.25f, -0.1f, 1.0f, 1.0f);
        this.addVertex(vertexConsumer, matrix4f, matrix3f, 0.25f, -0.1f, 0.0f, 1.0f);
        this.addVertex(vertexConsumer, matrix4f, matrix3f, 0.25f, 0.4f, 0.0f, 0.0f);
        this.addVertex(vertexConsumer, matrix4f, matrix3f, -0.25f, 0.4f, 1.0f, 0.0f);
        poseStack.method_22909();
    }

    private void addVertex(class_4588 consumer, Matrix4f matrix4f, Matrix3f matrix3f, float x, float y, float u, float v) {
        consumer.method_22918(matrix4f, x, y, 0.0f).method_1336(255, 255, 255, 255).method_22913(u, v).method_22922(class_4608.field_21444).method_22916(0xF000F0).method_23763(matrix3f, 0.0f, 1.0f, 0.0f).method_1344();
    }

    @NotNull
    public class_2960 getTextureLocation(@NotNull CandleFlameProjectile entity) {
        return TEXTURE;
    }
}

