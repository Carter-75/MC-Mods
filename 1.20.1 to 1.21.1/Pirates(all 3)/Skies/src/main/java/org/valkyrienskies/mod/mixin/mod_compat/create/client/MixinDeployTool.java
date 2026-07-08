/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.schematics.client.tools.DeployTool
 *  com.simibubi.create.content.schematics.client.tools.SchematicToolBase
 *  net.createmod.catnip.animation.AnimationTickHolder
 *  net.createmod.catnip.render.SuperRenderTypeBuffer
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.schematics.client.tools.DeployTool;
import com.simibubi.create.content.schematics.client.tools.SchematicToolBase;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.SuperRenderTypeBuffer;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={DeployTool.class})
public abstract class MixinDeployTool
extends SchematicToolBase {
    @Redirect(method={"renderTool"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V", ordinal=0))
    private void redirectTranslate(class_4587 ms, double _x, double _y, double _z) {
    }

    @Inject(method={"renderTool"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V", ordinal=0)})
    private void mixinRenderTool(class_4587 ms, SuperRenderTypeBuffer buffer, class_243 camera, CallbackInfo ci) {
        float pt = AnimationTickHolder.getPartialTicks();
        double x = class_3532.method_16436((double)pt, (double)this.lastChasingSelectedPos.field_1352, (double)this.chasingSelectedPos.field_1352);
        double y = class_3532.method_16436((double)pt, (double)this.lastChasingSelectedPos.field_1351, (double)this.chasingSelectedPos.field_1351);
        double z = class_3532.method_16436((double)pt, (double)this.lastChasingSelectedPos.field_1350, (double)this.chasingSelectedPos.field_1350);
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, x, y, z);
        class_238 bounds = this.schematicHandler.getBounds();
        class_243 center = bounds.method_1005();
        int centerX = (int)center.field_1352;
        int centerZ = (int)center.field_1350;
        if (ship != null) {
            VSClientGameUtils.transformRenderWithShip(ship.getTransform(), ms, x - (double)centerX, y, z - (double)centerZ, camera.field_1352, camera.field_1351, camera.field_1350);
        } else {
            ms.method_22904(x - (double)centerX - camera.field_1352, y - camera.field_1351, z - (double)centerZ - camera.field_1350);
        }
    }
}

