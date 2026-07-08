/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_638
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.fix_render_chunk_sorting;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import net.minecraft.class_846;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_846.class_851.class})
public class MixinRenderChunk {
    @Shadow
    public class_238 field_4458;
    @Shadow
    @Final
    private class_2338.class_2339 field_4467;

    @Inject(method={"getDistToPlayerSqr"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetSquaredCameraDistance(CallbackInfoReturnable<Double> cir) {
        class_638 world = class_310.method_1551().field_1687;
        if (world == null) {
            return;
        }
        ClientShip shipObject = VSGameUtilsKt.getLoadedShipManagingPos(world, (class_2382)this.field_4467);
        if (shipObject != null) {
            class_4184 camera = class_310.method_1551().field_1773.method_19418();
            Vector3d chunkPosInWorld = shipObject.getRenderTransform().getShipToWorldMatrix().transformPosition(new Vector3d(this.field_4458.field_1323 + 8.0, this.field_4458.field_1322 + 8.0, this.field_4458.field_1321 + 8.0));
            double relDistanceSq = chunkPosInWorld.distanceSquared(camera.method_19326().field_1352, camera.method_19326().field_1351, camera.method_19326().field_1350);
            cir.setReturnValue((Object)relDistanceSq);
        }
    }

    @Inject(method={"hasAllNeighbors"}, at={@At(value="HEAD")}, cancellable=true)
    private void preHasAllNeighbors(CallbackInfoReturnable<Boolean> cir) {
        class_638 world = class_310.method_1551().field_1687;
        if (world == null) {
            return;
        }
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)world, (class_2338)this.field_4467)) {
            cir.setReturnValue((Object)true);
        }
    }
}

