/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_465
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.client;

import backported.updates.foundation.client.event.screen.HudInteractions;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_465;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_465.class})
public class AbstractContainerScreenMixin<T extends class_1703> {
    @Shadow
    @Final
    protected T field_2797;
    @Shadow
    @Nullable
    protected class_1735 field_2787;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderLabels(Lnet/minecraft/client/gui/GuiGraphics;II)V")})
    private void platform$stopHoveringOnRender(class_332 graphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        for (int i = 0; i < ((class_1703)this.field_2797).field_7761.size(); ++i) {
            class_1735 slot = this.field_2797.method_7611(i);
            if (slot == this.field_2787) continue;
            HudInteractions.STOP_HOVERING.invoker().onStopHovering(class_310.method_1551(), (class_465)this, slot);
        }
    }

    @Inject(method={"onClose"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;closeContainer()V", shift=At.Shift.AFTER)})
    private void platform$stopHoveringOnClose(CallbackInfo ci) {
        if (this.field_2787 != null) {
            HudInteractions.STOP_HOVERING.invoker().onStopHovering(class_310.method_1551(), (class_465)this, this.field_2787);
        }
    }

    @Inject(method={"slotClicked"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;handleInventoryMouseClick(IIILnet/minecraft/world/inventory/ClickType;Lnet/minecraft/world/entity/player/Player;)V")})
    private void platform$onSlotClick(class_1735 slot, int slotId, int mouseButton, class_1713 type, CallbackInfo ci) {
        HudInteractions.SLOT_CLICK.invoker().onMouseClick(class_310.method_1551(), (class_465)this, slot, type);
    }
}

