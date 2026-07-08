/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_3532
 *  net.minecraft.class_769
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.flywheel_renderer;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3532;
import net.minecraft.class_769;
import net.minecraft.class_846;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.ShipRenderer;
import org.valkyrienskies.mod.common.config.ShipRendererKt;
import org.valkyrienskies.mod.compat.LoadedMods;
import org.valkyrienskies.mod.compat.flywheel.FlywheelCompat;

@Mixin(value={class_769.class})
public class MixinViewArea {
    @Shadow
    @Final
    protected class_1937 field_4151;
    @Shadow
    protected int field_4149;

    @Inject(method={"setDirty"}, at={@At(value="HEAD")}, cancellable=true)
    private void preScheduleRebuild(int x, int y, int z, boolean important, CallbackInfo callbackInfo) {
        int yIndex = y - this.field_4151.method_32891();
        if (yIndex < 0 || yIndex >= this.field_4149) {
            return;
        }
        ClientShip ship = (ClientShip)VSGameUtilsKt.getShipManagingPos(this.field_4151, x, z);
        if (ship == null) {
            return;
        }
        if (ShipRendererKt.getShipRenderer(ship) != ShipRenderer.FLYWHEEL) {
            return;
        }
        if (LoadedMods.getFlywheel() != LoadedMods.FlywheelVersion.V1) {
            throw new IllegalStateException("Trying to render with flywheel, but no flywheel installed");
        }
        FlywheelCompat.INSTANCE.setShipEffectDirty(ship, x, y, z, important);
    }

    @Inject(method={"getRenderChunkAt"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetRenderedChunk(class_2338 pos, CallbackInfoReturnable<class_846.class_851> callbackInfoReturnable) {
        int chunkX = class_3532.method_48116((int)pos.method_10263(), (int)16);
        int chunkY = class_3532.method_48116((int)(pos.method_10264() - this.field_4151.method_31607()), (int)16);
        int chunkZ = class_3532.method_48116((int)pos.method_10260(), (int)16);
        if (chunkY < 0 || chunkY >= this.field_4149) {
            return;
        }
        ClientShip ship = (ClientShip)VSGameUtilsKt.getShipManagingPos(this.field_4151, chunkX, chunkZ);
        if (ship != null && ShipRendererKt.getShipRenderer(ship) == ShipRenderer.FLYWHEEL) {
            callbackInfoReturnable.setReturnValue(null);
        }
    }
}

