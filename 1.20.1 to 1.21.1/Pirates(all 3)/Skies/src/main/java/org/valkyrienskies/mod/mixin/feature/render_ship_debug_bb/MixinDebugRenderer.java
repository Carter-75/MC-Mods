/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4668
 *  net.minecraft.class_638
 *  net.minecraft.class_761
 *  net.minecraft.class_863
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.render_ship_debug_bb;

import java.util.function.BiConsumer;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4668;
import net.minecraft.class_638;
import net.minecraft.class_761;
import net.minecraft.class_863;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.primitives.AABBic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.DragInfoReporter;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_863.class})
public class MixinDebugRenderer {
    @Unique
    private static class_1921 XRAY_LINES;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void postRender(class_4587 matrices, class_4597.class_4598 vertexConsumersIgnore, double cameraX, double cameraY, double cameraZ, CallbackInfo ci) {
        class_4597.class_4598 bufferSource = class_4597.method_22991((class_287)class_289.method_1348().method_1349());
        class_638 world = class_310.method_1551().field_1687;
        VsiClientShipWorld shipObjectClientWorld = VSGameUtilsKt.getShipObjectWorld(world);
        if (class_310.method_1551().method_1561().method_3958()) {
            matrices.method_22903();
            matrices.method_22904(-cameraX, -cameraY, -cameraZ);
            class_1297 camera = class_310.method_1551().method_1560();
            class_243 eyeVec = camera.method_5836(0.0f);
            class_243 viewVec = camera.method_5828(0.0f).method_1021(20.0);
            class_243 targetVec = eyeVec.method_1019(viewVec);
            class_3965 hit = world.method_17742(new class_3959(eyeVec, targetVec, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, camera));
            if (class_310.method_1551().method_1555()) {
                return;
            }
            for (ClientShip shipObjectClient : shipObjectClientWorld.getLoadedShips()) {
                ShipTransform shipRenderTransform = shipObjectClient.getRenderTransform();
                Vector3dc shipRenderPosition = shipRenderTransform.getPosition();
                boolean xrayEligible = class_310.method_1551().field_1724.method_7325() || class_310.method_1551().field_1724.method_7337() || shipObjectClient.getRenderAABB().containsPoint(VectorConversionsMCKt.toJOML(class_310.method_1551().field_1724.method_19538())) || shipObjectClient.getRenderAABB().intersectsLineSegment(cameraX, cameraY, cameraZ, hit.field_1329.field_1352, hit.field_1329.field_1351, hit.field_1329.field_1350, new Vector2d()) != -1;
                AABBic shipAABB = shipObjectClient.getShipAABB();
                class_238 renderAABB = VectorConversionsMCKt.toMinecraft(shipObjectClient.getRenderAABB());
                if (shipAABB == null) {
                    class_761.method_22982((class_4587)matrices, (class_4588)bufferSource.getBuffer((class_1921)(xrayEligible ? XRAY_LINES : class_1921.field_21695)), (class_238)renderAABB.method_1014(0.25), (float)1.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    continue;
                }
                Vector3d centerOfShip = shipAABB.center(new Vector3d());
                class_238 shipVoxelAABBAfterOffset = new class_238((double)shipAABB.minX() - centerOfShip.x(), (double)shipAABB.minY() - centerOfShip.y(), (double)shipAABB.minZ() - centerOfShip.z(), (double)shipAABB.maxX() - centerOfShip.x(), (double)shipAABB.maxY() - centerOfShip.y(), (double)shipAABB.maxZ() - centerOfShip.z());
                matrices.method_22903();
                VSClientGameUtils.transformRenderWithShip(shipRenderTransform, matrices, centerOfShip.x(), centerOfShip.y(), centerOfShip.z(), 0.0, 0.0, 0.0);
                class_761.method_22982((class_4587)matrices, (class_4588)bufferSource.getBuffer((class_1921)class_1921.field_21695), (class_238)shipVoxelAABBAfterOffset, (float)0.5f, (float)0.0f, (float)0.0f, (float)1.0f);
                Vector3d centerOfMass = shipRenderTransform.getPositionInModel().sub(centerOfShip, new Vector3d());
                double comBoxSize = 0.25;
                class_238 comBox = class_238.method_30048((class_243)VectorConversionsMCKt.toMinecraft(centerOfMass), (double)0.25, (double)0.25, (double)0.25);
                class_761.method_22982((class_4587)matrices, (class_4588)bufferSource.getBuffer((class_1921)(xrayEligible ? XRAY_LINES : class_1921.field_21695)), (class_238)comBox, (float)0.98039216f, (float)0.7607843f, (float)0.07450981f, (float)1.0f);
                if (xrayEligible) {
                    MixinDebugRenderer.vs_renderGizmoInsideAABB(matrices, bufferSource.getBuffer(XRAY_LINES), shipVoxelAABBAfterOffset, centerOfMass.x, centerOfMass.y, centerOfMass.z, 1.0f, 0.125f);
                }
                matrices.method_22909();
                class_761.method_22982((class_4587)matrices, (class_4588)bufferSource.getBuffer((class_1921)class_1921.field_21695), (class_238)renderAABB, (float)0.91764706f, (float)0.0f, (float)0.8509804f, (float)1.0f);
                Vector3dc dragForce = DragInfoReporter.INSTANCE.getShipDragValues().get(shipObjectClient.getId());
                Vector3dc liftForce = DragInfoReporter.INSTANCE.getShipLiftValues().get(shipObjectClient.getId());
                if (dragForce != null) {
                    MixinDebugRenderer.vs_renderForce(matrices, bufferSource.getBuffer((class_1921)class_1921.field_21695), shipRenderPosition, dragForce, 0.01, 10.0, 0.0f, 0.5f, 1.0f, 1.0f);
                }
                if (liftForce == null) continue;
                MixinDebugRenderer.vs_renderForce(matrices, bufferSource.getBuffer((class_1921)class_1921.field_21695), shipRenderPosition, liftForce, 0.01, 10.0, 0.0f, 1.0f, 0.5f, 1.0f);
            }
            matrices.method_22909();
        }
        bufferSource.method_22993();
    }

    @Unique
    private static void vs_renderForce(class_4587 poseStack, class_4588 vertexConsumer, Vector3dc pos, Vector3dc force, double scale, double cap, float r, float g2, float b2, float alpha) {
        Matrix4f m4 = poseStack.method_23760().method_23761();
        Matrix3f m3 = poseStack.method_23760().method_23762();
        Vector3d diff = new Vector3d(Math.min(Math.max(-cap, force.x() * scale), cap), Math.min(Math.max(-cap, force.y() * scale), cap), Math.min(Math.max(-cap, force.z() * scale), cap));
        vertexConsumer.method_22918(m4, (float)pos.x(), (float)pos.y(), (float)pos.z()).method_22915(r, g2, b2, alpha).method_23763(m3, (float)diff.x, (float)diff.y, (float)diff.z).method_1344();
        vertexConsumer.method_22918(m4, (float)(pos.x() + diff.x), (float)(pos.y() + diff.y), (float)(pos.z() + diff.z)).method_22915(1.0f, 1.0f, 1.0f, 0.0f).method_23763(m3, (float)diff.x, (float)diff.y, (float)diff.z).method_1344();
    }

    @Unique
    private static void vs_renderGizmoInsideAABB(class_4587 poseStack, class_4588 vertexConsumer, class_238 aABB, double cx, double cy, double cz, float alpha, float gizmoSize) {
        MixinDebugRenderer.vs_renderGizmoInsideAABB(poseStack, vertexConsumer, aABB.field_1323, aABB.field_1322, aABB.field_1321, aABB.field_1320, aABB.field_1325, aABB.field_1324, cx, cy, cz, alpha, gizmoSize);
    }

    @Unique
    private static void vs_renderGizmoInsideAABB(class_4587 poseStack, class_4588 vertexConsumer, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, double cx, double cy, double cz, float alpha, float gizmoSize) {
        Matrix4f m4 = poseStack.method_23760().method_23761();
        Matrix3f m3 = poseStack.method_23760().method_23762();
        float mx = (float)minX;
        float my = (float)minY;
        float mz = (float)minZ;
        float Mx = (float)maxX;
        float My = (float)maxY;
        float Mz = (float)maxZ;
        float fx = (float)cx;
        float fy2 = (float)cy;
        float fz = (float)cz;
        Vector3f p1 = new Vector3f();
        Vector3f p2 = new Vector3f();
        Vector3f color = new Vector3f();
        BiConsumer<Vector3f, Vector3f> line = (a2, b2) -> {
            float dx = b2.x - a2.x;
            float dy = b2.y - a2.y;
            float dz = b2.z - a2.z;
            vertexConsumer.method_22918(m4, a2.x, a2.y, a2.z).method_22915(color.x, color.y, color.z, alpha).method_23763(m3, dx, dy, dz).method_1344();
            vertexConsumer.method_22918(m4, b2.x, b2.y, b2.z).method_22915(color.x, color.y, color.z, alpha).method_23763(m3, dx, dy, dz).method_1344();
        };
        color.set(1.0f, 0.0f, 0.0f);
        line.accept(p1.set(mx, fy2, fz), p2.set(Mx, fy2, fz));
        line.accept(p1.set(mx, fy2 - gizmoSize, fz - gizmoSize), p2.set(mx, fy2 + gizmoSize, fz + gizmoSize));
        line.accept(p1.set(mx, fy2 - gizmoSize, fz + gizmoSize), p2.set(mx, fy2 + gizmoSize, fz - gizmoSize));
        float backX = Mx - gizmoSize;
        line.accept(p1.set(backX, fy2 - gizmoSize, fz), p2.set(Mx, fy2, fz));
        line.accept(p1.set(backX, fy2 + gizmoSize, fz), p2.set(Mx, fy2, fz));
        line.accept(p1.set(backX, fy2, fz - gizmoSize), p2.set(Mx, fy2, fz));
        line.accept(p1.set(backX, fy2, fz + gizmoSize), p2.set(Mx, fy2, fz));
        color.set(0.0f, 1.0f, 0.0f);
        line.accept(p1.set(fx, my, fz), p2.set(fx, My, fz));
        line.accept(p1.set(fx - gizmoSize, my, fz - gizmoSize), p2.set(fx + gizmoSize, my, fz + gizmoSize));
        line.accept(p1.set(fx - gizmoSize, my, fz + gizmoSize), p2.set(fx + gizmoSize, my, fz - gizmoSize));
        float backY = My - gizmoSize;
        line.accept(p1.set(fx - gizmoSize, backY, fz), p2.set(fx, My, fz));
        line.accept(p1.set(fx + gizmoSize, backY, fz), p2.set(fx, My, fz));
        line.accept(p1.set(fx, backY, fz - gizmoSize), p2.set(fx, My, fz));
        line.accept(p1.set(fx, backY, fz + gizmoSize), p2.set(fx, My, fz));
        color.set(0.0f, 0.0f, 1.0f);
        line.accept(p1.set(fx, fy2, mz), p2.set(fx, fy2, Mz));
        line.accept(p1.set(fx - gizmoSize, fy2 - gizmoSize, mz), p2.set(fx + gizmoSize, fy2 + gizmoSize, mz));
        line.accept(p1.set(fx - gizmoSize, fy2 + gizmoSize, mz), p2.set(fx + gizmoSize, fy2 - gizmoSize, mz));
        float backZ = Mz - gizmoSize;
        line.accept(p1.set(fx - gizmoSize, fy2, backZ), p2.set(fx, fy2, Mz));
        line.accept(p1.set(fx + gizmoSize, fy2, backZ), p2.set(fx, fy2, Mz));
        line.accept(p1.set(fx, fy2 - gizmoSize, backZ), p2.set(fx, fy2, Mz));
        line.accept(p1.set(fx, fy2 + gizmoSize, backZ), p2.set(fx, fy2, Mz));
    }

    static {
        new class_4668(null, null, null){

            public static class_1921 createXrayLines() {
                return class_1921.method_24049((String)"xray_lines", (class_293)class_290.field_29337, (class_293.class_5596)class_293.class_5596.field_27377, (int)256, (boolean)false, (boolean)false, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34578(class_4668.field_29433).method_23609(class_4668.field_21360).method_23607(class_4668.field_22241).method_23615(class_4668.field_21370).method_23610(class_4668.field_25643).method_23616(class_4668.field_21349).method_23603(class_4668.field_21345).method_23604(class_4668.field_21346).method_23617(false));
            }
        };
        XRAY_LINES = 1.createXrayLines();
    }
}

