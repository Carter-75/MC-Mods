/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.outliner.Outline
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4608
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import net.createmod.catnip.outliner.Outline;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import net.minecraft.class_638;
import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={Outline.class})
public abstract class MixinOutline {
    @Shadow
    public abstract void bufferCuboidLine(class_4587 var1, class_4588 var2, class_243 var3, Vector3d var4, Vector3d var5, float var6, Vector4f var7, int var8, boolean var9);

    @Shadow
    public abstract void bufferQuad(class_4587.class_4665 var1, class_4588 var2, Vector3f var3, Vector3f var4, Vector3f var5, Vector3f var6, Vector4f var7, float var8, float var9, float var10, float var11, int var12, Vector3f var13);

    @Inject(method={"bufferCuboidLine(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/world/phys/Vec3;Lorg/joml/Vector3d;Lorg/joml/Vector3d;FLorg/joml/Vector4f;IZ)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void preBufferCuboidLine0(class_4587 poseStack, class_4588 consumer, class_243 camera, Vector3d start, Vector3d end, float width, Vector4f color, int lightmap, boolean disableNormals, CallbackInfo ci) {
        Vector3d average;
        ClientShip ship;
        class_638 level = class_310.method_1551().field_1687;
        if (level != null && (ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)level, (Vector3dc)(average = new Vector3d((start.x + end.x) / 2.0, (start.y + end.y) / 2.0, (start.z + end.z) / 2.0)))) != null) {
            ShipTransform transform2 = ship.getRenderTransform();
            Vector3d startTransformed = transform2.getShipToWorld().transformPosition(new Vector3d(start.x, start.y, start.z));
            Vector3d endTransformed = transform2.getShipToWorld().transformPosition(new Vector3d(end.x, end.y, end.z));
            float scaledWidth = (float)((double)width * transform2.getShipToWorldScaling().x());
            this.bufferCuboidLine(poseStack, consumer, camera, new Vector3d(startTransformed.x(), startTransformed.y(), startTransformed.z()), new Vector3d(endTransformed.x(), endTransformed.y(), endTransformed.z()), scaledWidth, color, lightmap, disableNormals);
            ci.cancel();
        }
    }

    @Inject(method={"bufferCuboid"}, at={@At(value="HEAD")}, cancellable=true)
    private void preBufferCuboid(class_4587.class_4665 pose, class_4588 consumer, Vector3f minPos, Vector3f maxPos, Vector4f color, int lightmap, boolean disableNormals, CallbackInfo ci) {
        Vector3d average;
        ClientShip ship;
        class_638 level = class_310.method_1551().field_1687;
        if (level != null && (ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)level, (Vector3dc)(average = new Vector3d((double)(minPos.x() + maxPos.x()) / 2.0, (double)(minPos.y() + maxPos.y()) / 2.0, (double)(minPos.z() + maxPos.z()) / 2.0)))) != null) {
            ShipTransform transform2 = ship.getRenderTransform();
            Vector3d temp = new Vector3d();
            float minX = minPos.x();
            float minY = minPos.y();
            float minZ = minPos.z();
            float maxX = maxPos.x();
            float maxY = maxPos.y();
            float maxZ = maxPos.z();
            Matrix4d newPosMatrix = new Matrix4d(pose.method_23761()).mul(transform2.getShipToWorld());
            temp.set(minX, minY, maxZ);
            newPosMatrix.transformPosition(temp);
            double x0 = temp.x();
            double y0 = temp.y();
            double z0 = temp.z();
            temp.set(minX, minY, minZ);
            newPosMatrix.transformPosition(temp);
            double x1 = temp.x();
            double y1 = temp.y();
            double z1 = temp.z();
            temp.set(maxX, minY, minZ);
            newPosMatrix.transformPosition(temp);
            double x2 = temp.x();
            double y2 = temp.y();
            double z2 = temp.z();
            temp.set(maxX, minY, maxZ);
            newPosMatrix.transformPosition(temp);
            double x3 = temp.x();
            double y3 = temp.y();
            double z3 = temp.z();
            temp.set(minX, maxY, minZ);
            newPosMatrix.transformPosition(temp);
            double x4 = temp.x();
            double y4 = temp.y();
            double z4 = temp.z();
            temp.set(minX, maxY, maxZ);
            newPosMatrix.transformPosition(temp);
            double x5 = temp.x();
            double y5 = temp.y();
            double z5 = temp.z();
            temp.set(maxX, maxY, maxZ);
            newPosMatrix.transformPosition(temp);
            double x6 = temp.x();
            double y6 = temp.y();
            double z6 = temp.z();
            temp.set(maxX, maxY, minZ);
            newPosMatrix.transformPosition(temp);
            double x7 = temp.x();
            double y7 = temp.y();
            double z7 = temp.z();
            float r = color.x();
            float g2 = color.y();
            float b2 = color.z();
            float a2 = color.w();
            if (disableNormals) {
                temp.set(0.0, 1.0, 0.0);
            } else {
                temp.set(0.0, -1.0, 0.0);
            }
            newPosMatrix.transformDirection(temp).normalize();
            float nx0 = (float)temp.x();
            float ny0 = (float)temp.y();
            float nz0 = (float)temp.z();
            consumer.method_22912(x0, y0, z0).method_22915(r, g2, b2, a2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx0, ny0, nz0).method_1344();
            consumer.method_22912(x1, y1, z1).method_22915(r, g2, b2, a2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx0, ny0, nz0).method_1344();
            consumer.method_22912(x2, y2, z2).method_22915(r, g2, b2, a2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx0, ny0, nz0).method_1344();
            consumer.method_22912(x3, y3, z3).method_22915(r, g2, b2, a2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx0, ny0, nz0).method_1344();
            temp.set(0.0, 1.0, 0.0);
            newPosMatrix.transformDirection(temp).normalize();
            float nx1 = (float)temp.x();
            float ny1 = (float)temp.y();
            float nz1 = (float)temp.z();
            consumer.method_22912(x4, y4, z4).method_22915(r, g2, b2, a2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx1, ny1, nz1).method_1344();
            consumer.method_22912(x5, y5, z5).method_22915(r, g2, b2, a2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx1, ny1, nz1).method_1344();
            consumer.method_22912(x6, y6, z6).method_22915(r, g2, b2, a2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx1, ny1, nz1).method_1344();
            consumer.method_22912(x7, y7, z7).method_22915(r, g2, b2, a2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx1, ny1, nz1).method_1344();
            if (disableNormals) {
                temp.set(0.0, 1.0, 0.0);
            } else {
                temp.set(0.0, 0.0, -1.0);
            }
            newPosMatrix.transformDirection(temp).normalize();
            float nx2 = (float)temp.x();
            float ny2 = (float)temp.y();
            float nz2 = (float)temp.z();
            consumer.method_22912(x7, y7, z7).method_22915(r, g2, b2, a2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx2, ny2, nz2).method_1344();
            consumer.method_22912(x2, y2, z2).method_22915(r, g2, b2, a2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx2, ny2, nz2).method_1344();
            consumer.method_22912(x1, y1, z1).method_22915(r, g2, b2, a2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx2, ny2, nz2).method_1344();
            consumer.method_22912(x4, y4, z4).method_22915(r, g2, b2, a2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx2, ny2, nz2).method_1344();
            if (disableNormals) {
                temp.set(0.0, 1.0, 0.0);
            } else {
                temp.set(0.0, 0.0, 1.0);
            }
            newPosMatrix.transformDirection(temp).normalize();
            float nx3 = (float)temp.x();
            float ny3 = (float)temp.y();
            float nz3 = (float)temp.z();
            consumer.method_22912(x5, y5, z5).method_22915(r, g2, b2, a2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx3, ny3, nz3).method_1344();
            consumer.method_22912(x0, y0, z0).method_22915(r, g2, b2, a2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx3, ny3, nz3).method_1344();
            consumer.method_22912(x3, y3, z3).method_22915(r, g2, b2, a2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx3, ny3, nz3).method_1344();
            consumer.method_22912(x6, y6, z6).method_22915(r, g2, b2, a2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx3, ny3, nz3).method_1344();
            if (disableNormals) {
                temp.set(0.0, 1.0, 0.0);
            } else {
                temp.set(-1.0, 0.0, 0.0);
            }
            newPosMatrix.transformDirection(temp).normalize();
            float nx4 = (float)temp.x();
            float ny4 = (float)temp.y();
            float nz4 = (float)temp.z();
            consumer.method_22912(x4, y4, z4).method_22915(r, g2, b2, a2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx4, ny4, nz4).method_1344();
            consumer.method_22912(x1, y1, z1).method_22915(r, g2, b2, a2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx4, ny4, nz4).method_1344();
            consumer.method_22912(x0, y0, z0).method_22915(r, g2, b2, a2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx4, ny4, nz4).method_1344();
            consumer.method_22912(x5, y5, z5).method_22915(r, g2, b2, a2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx4, ny4, nz4).method_1344();
            if (disableNormals) {
                temp.set(0.0, 1.0, 0.0);
            } else {
                temp.set(1.0, 0.0, 0.0);
            }
            newPosMatrix.transformDirection(temp).normalize();
            float nx5 = (float)temp.x();
            float ny5 = (float)temp.y();
            float nz5 = (float)temp.z();
            consumer.method_22912(x6, y6, z6).method_22915(r, g2, b2, a2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx5, ny5, nz5).method_1344();
            consumer.method_22912(x3, y3, z3).method_22915(r, g2, b2, a2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx5, ny5, nz5).method_1344();
            consumer.method_22912(x2, y2, z2).method_22915(r, g2, b2, a2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx5, ny5, nz5).method_1344();
            consumer.method_22912(x7, y7, z7).method_22915(r, g2, b2, a2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_22916(lightmap).method_22914(nx5, ny5, nz5).method_1344();
            ci.cancel();
        }
    }

    @Inject(method={"bufferQuad(Lcom/mojang/blaze3d/vertex/PoseStack$Pose;Lcom/mojang/blaze3d/vertex/VertexConsumer;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector4f;FFFFILorg/joml/Vector3f;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void preBufferQuad(class_4587.class_4665 pose, class_4588 consumer, Vector3f pos0, Vector3f pos1, Vector3f pos2, Vector3f pos3, Vector4f color, float minU, float minV, float maxU, float maxV, int lightmap, Vector3f normal, CallbackInfo ci) {
        Vector3d average;
        ClientShip ship;
        class_638 level = class_310.method_1551().field_1687;
        if (level != null && (ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)level, (Vector3dc)(average = new Vector3d((double)(pos0.x() + pos1.x() + pos2.x() + pos3.x()) / 4.0, (double)(pos0.y() + pos1.y() + pos2.y() + pos3.y()) / 4.0, (double)(pos0.z() + pos1.z() + pos2.z() + pos3.z()) / 4.0)))) != null) {
            ShipTransform transform2 = ship.getRenderTransform();
            Vector3d pos0Transformed = transform2.getShipToWorld().transformPosition(new Vector3d(pos0.x(), pos0.y(), pos0.z()));
            Vector3d pos1Transformed = transform2.getShipToWorld().transformPosition(new Vector3d(pos1.x(), pos1.y(), pos1.z()));
            Vector3d pos2Transformed = transform2.getShipToWorld().transformPosition(new Vector3d(pos2.x(), pos2.y(), pos2.z()));
            Vector3d pos3Transformed = transform2.getShipToWorld().transformPosition(new Vector3d(pos3.x(), pos3.y(), pos3.z()));
            Vector3d normalTransformed = transform2.getShipToWorld().transformDirection(new Vector3d(normal.x(), normal.y(), normal.z()));
            this.bufferQuad(pose, consumer, new Vector3f((float)pos0Transformed.x(), (float)pos0Transformed.y(), (float)pos0Transformed.z()), new Vector3f((float)pos1Transformed.x(), (float)pos1Transformed.y(), (float)pos1Transformed.z()), new Vector3f((float)pos2Transformed.x(), (float)pos2Transformed.y(), (float)pos2Transformed.z()), new Vector3f((float)pos3Transformed.x(), (float)pos3Transformed.y(), (float)pos3Transformed.z()), color, minU, minV, maxU, maxV, lightmap, new Vector3f((float)normalTransformed.x(), (float)normalTransformed.y(), (float)normalTransformed.z()));
            ci.cancel();
        }
    }
}

