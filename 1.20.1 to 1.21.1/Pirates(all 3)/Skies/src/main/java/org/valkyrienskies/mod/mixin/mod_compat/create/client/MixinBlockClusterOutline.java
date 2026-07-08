/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.outliner.BlockClusterOutline
 *  net.createmod.catnip.outliner.Outline
 *  net.createmod.catnip.render.BindableTexture
 *  net.createmod.catnip.render.PonderRenderTypes
 *  net.createmod.catnip.render.SuperRenderTypeBuffer
 *  net.minecraft.class_1921
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2350$class_2352
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import java.util.Iterator;
import net.createmod.catnip.outliner.BlockClusterOutline;
import net.createmod.catnip.outliner.Outline;
import net.createmod.catnip.render.BindableTexture;
import net.createmod.catnip.render.PonderRenderTypes;
import net.createmod.catnip.render.SuperRenderTypeBuffer;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.mod_compat.create.accessors.OutlineParamsAccessor;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.CWCluster;

@Mixin(value={BlockClusterOutline.class})
public abstract class MixinBlockClusterOutline
extends Outline {
    @Unique
    private CWCluster cw$cluster = null;
    @Shadow
    @Final
    protected Vector3f originTemp;

    @Shadow
    protected abstract void bufferBlockFace(class_4587.class_4665 var1, class_4588 var2, class_2338 var3, class_2350 var4, Vector4f var5, int var6);

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void postInit(Iterable<class_2338> positions, CallbackInfo ci) {
        class_638 level;
        class_2338 firstPos;
        Iterator<class_2338> iterator2 = positions.iterator();
        class_2338 class_23382 = firstPos = iterator2.hasNext() ? iterator2.next() : null;
        if (firstPos != null && (level = class_310.method_1551().field_1687) != null && VSGameUtilsKt.getShipManagingPos((class_1937)level, firstPos) != null) {
            this.cw$cluster = new CWCluster();
            positions.forEach(this.cw$cluster::include);
        }
    }

    @Inject(method={"renderFaces"}, at={@At(value="HEAD")}, cancellable=true)
    private void preRenderFaces(class_4587 ms, SuperRenderTypeBuffer buffer, class_243 camera, float pt, Vector4f color, int lightmap, CallbackInfo ci) {
        if (this.cw$cluster != null) {
            class_2338 anchorPos = this.cw$cluster.anchor;
            if (anchorPos == null) {
                return;
            }
            class_638 level = class_310.method_1551().field_1687;
            ClientShip ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)level, anchorPos);
            if (ship != null) {
                BindableTexture faceTexture = ((OutlineParamsAccessor)this.params).getFaceTexture();
                if (faceTexture == null) {
                    return;
                }
                ShipTransform renderTransform = ship.getRenderTransform();
                ms.method_22903();
                ms.method_22904(renderTransform.getPositionInWorld().x() - camera.field_1352, renderTransform.getPositionInWorld().y() - camera.field_1351, renderTransform.getPositionInWorld().z() - camera.field_1350);
                ms.method_22905((float)renderTransform.getShipToWorldScaling().x(), (float)renderTransform.getShipToWorldScaling().y(), (float)renderTransform.getShipToWorldScaling().z());
                ms.method_22907(VectorConversionsMCKt.toFloat(renderTransform.getShipToWorldRotation()));
                ms.method_22904((double)this.cw$cluster.anchor.method_10263() - renderTransform.getPositionInShip().x(), (double)this.cw$cluster.anchor.method_10264() - renderTransform.getPositionInShip().y(), (double)this.cw$cluster.anchor.method_10260() - renderTransform.getPositionInShip().z());
                class_4587.class_4665 pose = ms.method_23760();
                class_1921 renderType = PonderRenderTypes.outlineTranslucent((class_2960)faceTexture.getLocation(), (boolean)true);
                class_4588 consumer = buffer.getLateBuffer(renderType);
                this.cw$cluster.visibleFaces.forEach((face, axisDirection) -> {
                    class_2350 direction = class_2350.method_10156((class_2350.class_2352)axisDirection, (class_2350.class_2351)face.axis);
                    class_2338 pos = face.pos;
                    if (axisDirection == class_2350.class_2352.field_11056) {
                        pos = pos.method_10093(direction.method_10153());
                    }
                    this.bufferBlockFace(pose, consumer, pos, direction, color, lightmap);
                });
                ms.method_22909();
                ci.cancel();
            }
        }
    }

    @Inject(method={"renderEdges"}, at={@At(value="HEAD")}, cancellable=true)
    private void preRenderEdges(class_4587 ms, SuperRenderTypeBuffer buffer, class_243 camera, float pt, Vector4f color, int lightmap, boolean disableNormals, CallbackInfo ci) {
        if (this.cw$cluster != null) {
            class_2338 anchorPos = this.cw$cluster.anchor;
            if (anchorPos == null) {
                return;
            }
            class_638 level = class_310.method_1551().field_1687;
            ClientShip ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)level, anchorPos);
            if (ship != null) {
                float lineWidth = this.params.getLineWidth();
                if (lineWidth == 0.0f) {
                    return;
                }
                if (this.cw$cluster.isEmpty()) {
                    return;
                }
                ShipTransform renderTransform = ship.getRenderTransform();
                ms.method_22903();
                ms.method_22904(renderTransform.getPositionInWorld().x() - camera.field_1352, renderTransform.getPositionInWorld().y() - camera.field_1351, renderTransform.getPositionInWorld().z() - camera.field_1350);
                ms.method_22905((float)renderTransform.getShipToWorldScaling().x(), (float)renderTransform.getShipToWorldScaling().y(), (float)renderTransform.getShipToWorldScaling().z());
                ms.method_22907(VectorConversionsMCKt.toFloat(renderTransform.getShipToWorldRotation()));
                ms.method_22904((double)this.cw$cluster.anchor.method_10263() - renderTransform.getPositionInShip().x(), (double)this.cw$cluster.anchor.method_10264() - renderTransform.getPositionInShip().y(), (double)this.cw$cluster.anchor.method_10260() - renderTransform.getPositionInShip().z());
                class_4587.class_4665 pose = ms.method_23760();
                class_4588 consumer = buffer.getBuffer(PonderRenderTypes.outlineSolid());
                this.cw$cluster.visibleEdges.forEach(edge -> {
                    class_2338 pos = edge.pos;
                    Vector3f origin = this.originTemp;
                    origin.set(pos.method_10263(), pos.method_10264(), pos.method_10260());
                    class_2350 direction = class_2350.method_10156((class_2350.class_2352)class_2350.class_2352.field_11056, (class_2350.class_2351)edge.axis);
                    this.bufferCuboidLine(pose, consumer, origin, direction, 1.0f, lineWidth, color, lightmap, disableNormals);
                });
                ms.method_22909();
                ci.cancel();
            }
        }
    }
}

