/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
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
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HandledScreen.class})
public class AbstractContainerScreenMixin<T extends ScreenHandler> {
    @Shadow
    @Final
    protected T handler;
    @Shadow
    @Nullable
    protected Slot focusedSlot;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/ingame/HandledScreen;drawForeground(Lnet/minecraft/client/gui/DrawContext;II)V")})
    private void platform$stopHoveringOnRender(DrawContext graphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        for (int i = 0; i < ((ScreenHandler)this.handler).slots.size(); ++i) {
            Slot slot = this.handler.getSlot(i);
            if (slot == this.focusedSlot) continue;
            HudInteractions.STOP_HOVERING.invoker().onStopHovering(MinecraftClient.getInstance(), (HandledScreen)(Object)this, slot);
        }
    }

    @Inject(method={"close"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;closeHandledScreen()V", shift=At.Shift.AFTER)})
    private void platform$stopHoveringOnClose(CallbackInfo ci) {
        if (this.focusedSlot != null) {
            HudInteractions.STOP_HOVERING.invoker().onStopHovering(MinecraftClient.getInstance(), (HandledScreen)(Object)this, this.focusedSlot);
        }
    }

    @Inject(method={"onMouseClick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerInteractionManager;clickSlot(IIILnet/minecraft/screen/slot/SlotActionType;Lnet/minecraft/entity/player/PlayerEntity;)V")})
    private void platform$onSlotClick(Slot slot, int slotId, int mouseButton, SlotActionType type, CallbackInfo ci) {
        HudInteractions.SLOT_CLICK.invoker().onMouseClick(MinecraftClient.getInstance(), (HandledScreen)(Object)this, slot, type);
    }
}

