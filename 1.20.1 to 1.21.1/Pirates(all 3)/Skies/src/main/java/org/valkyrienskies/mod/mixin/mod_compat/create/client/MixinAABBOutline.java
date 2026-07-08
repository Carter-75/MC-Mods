/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.outliner.AABBOutline
 *  net.createmod.catnip.outliner.Outline
 *  net.createmod.catnip.render.PonderRenderTypes
 *  net.createmod.catnip.render.SuperRenderTypeBuffer
 *  net.minecraft.class_1937
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import net.createmod.catnip.outliner.AABBOutline;
import net.createmod.catnip.outliner.Outline;
import net.createmod.catnip.render.PonderRenderTypes;
import net.createmod.catnip.render.SuperRenderTypeBuffer;
import net.minecraft.class_1937;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
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
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.mod_compat.create.accessors.OutlineParamsAccessor;

@Mixin(value={AABBOutline.class})
public abstract class MixinAABBOutline
extends Outline {
    @Shadow
    protected abstract void renderBoxFaces(class_4587 var1, SuperRenderTypeBuffer var2, boolean var3, class_2350 var4, Vector3f var5, Vector3f var6, Vector4f var7, int var8);

    @Shadow
    protected abstract void renderBoxEdges(class_4587 var1, class_4588 var2, Vector3f var3, Vector3f var4, float var5, Vector4f var6, int var7, boolean var8);

    @Inject(method={"renderBox"}, at={@At(value="HEAD")}, cancellable=true)
    private void preRenderBox(class_4587 ms, SuperRenderTypeBuffer buffer, class_243 camera, class_238 box, Vector4f color, int lightmap, boolean disableLineNormals, CallbackInfo ci) {
        Vector3d average;
        ClientShip ship;
        class_638 level = class_310.method_1551().field_1687;
        if (level != null && (ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)level, (Vector3dc)(average = VectorConversionsMCKt.toJOML(box.method_1005())))) != null) {
            ShipTransform renderTransform = ship.getRenderTransform();
            Vector3f minPos = new Vector3f();
            Vector3f maxPos = new Vector3f();
            Vector3d cameraInShip = renderTransform.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(camera));
            boolean cameraInside = box.method_1006(VectorConversionsMCKt.toMinecraft(cameraInShip));
            boolean cull = !cameraInside && !((OutlineParamsAccessor)this.params).getDisableCull();
            float inflate = cameraInside ? -0.0078125f : 0.0078125f;
            class_238 boxRelShipCenter = box.method_989(-renderTransform.getPositionInShip().x(), -renderTransform.getPositionInShip().y(), -renderTransform.getPositionInShip().z());
            minPos.set((float)boxRelShipCenter.field_1323 - inflate, (float)boxRelShipCenter.field_1322 - inflate, (float)boxRelShipCenter.field_1321 - inflate);
            maxPos.set((float)boxRelShipCenter.field_1320 + inflate, (float)boxRelShipCenter.field_1325 + inflate, (float)boxRelShipCenter.field_1324 + inflate);
            ms.method_22903();
            ms.method_22904(renderTransform.getPositionInWorld().x() - camera.field_1352, renderTransform.getPositionInWorld().y() - camera.field_1351, renderTransform.getPositionInWorld().z() - camera.field_1350);
            ms.method_22905((float)renderTransform.getShipToWorldScaling().x(), (float)renderTransform.getShipToWorldScaling().y(), (float)renderTransform.getShipToWorldScaling().z());
            ms.method_22907(VectorConversionsMCKt.toFloat(renderTransform.getShipToWorldRotation()));
            this.renderBoxFaces(ms, buffer, cull, this.params.getHighlightedFace(), minPos, maxPos, color, lightmap);
            float lineWidth = this.params.getLineWidth();
            if (lineWidth == 0.0f) {
                return;
            }
            class_4588 consumer = buffer.getBuffer(PonderRenderTypes.outlineSolid());
            this.renderBoxEdges(ms, consumer, minPos, maxPos, lineWidth, color, lightmap, disableLineNormals);
            ms.method_22909();
            ci.cancel();
        }
    }
}

