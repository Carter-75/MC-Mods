/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.schematics.client.SchematicTransformation
 *  dev.engine_room.flywheel.lib.transform.PoseTransformStack
 *  dev.engine_room.flywheel.lib.transform.Translate
 *  net.createmod.catnip.animation.AnimationTickHolder
 *  net.createmod.catnip.math.VecHelper
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.schematics.client.SchematicTransformation;
import dev.engine_room.flywheel.lib.transform.PoseTransformStack;
import dev.engine_room.flywheel.lib.transform.Translate;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={SchematicTransformation.class}, remap=false)
public abstract class MixinSchematicTransformation {
    @Shadow
    private class_2338 target;
    @Shadow
    private class_243 chasingPos;
    @Shadow
    private class_243 prevChasingPos;

    @Redirect(method={"applyTransformations(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/phys/Vec3;)V"}, at=@At(value="INVOKE", target="Ldev/engine_room/flywheel/lib/transform/PoseTransformStack;translate(Lnet/minecraft/world/phys/Vec3;)Ldev/engine_room/flywheel/lib/transform/Translate;", ordinal=0), require=0)
    private Translate<?> redirectTranslate(PoseTransformStack instance, class_243 orig) {
        class_4587 ms = instance.unwrap();
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, (double)this.target.method_10263(), (double)this.target.method_10264(), (double)this.target.method_10260());
        if (ship != null) {
            float pt = AnimationTickHolder.getPartialTicks();
            class_243 pos = VecHelper.lerp((float)pt, (class_243)this.prevChasingPos, (class_243)this.chasingPos);
            class_243 camera = pos.method_1020(orig);
            VSClientGameUtils.transformRenderWithShip(ship.getTransform(), ms, pos.field_1352, pos.field_1351, pos.field_1350, camera.field_1352, camera.field_1351, camera.field_1350);
            return instance;
        }
        return instance.translate(orig);
    }
}

