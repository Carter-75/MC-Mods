/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.gui.screen.Screen
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package backported_updates.mixin.foundation.fabric.client.input;

import backported.updates.foundation.client.event.screen.HudInteractions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={Mouse.class})
public class MouseHandlerMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method={"onMouseScroll"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;mouseScrolled(DDDD)Z", ordinal=0)}, cancellable=true, locals=LocalCapture.CAPTURE_FAILHARD)
    public void onMouseScrollPre(long handle, double xOffset, double yOffset, CallbackInfo ci, boolean discreteScroll, double scrollSensitivity, double deltaX, double deltaY, double x, double y) {
        if (!ci.isCancelled() && HudInteractions.SCROLLING_PRE.invoker().onScrolling(this.client, this.client.currentScreen, x, y, deltaX, deltaY).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;mouseScrolled(DDDD)Z", ordinal=0, shift=At.Shift.AFTER)}, locals=LocalCapture.CAPTURE_FAILHARD)
    public void onMouseScrollPost(long handle, double xOffset, double yOffset, CallbackInfo ci, boolean discreteScroll, double scrollSensitivity, double deltaX, double deltaY, double x, double y) {
        if (!ci.isCancelled()) {
            HudInteractions.SCROLLING_POST.invoker().onScrolling(this.client, this.client.currentScreen, x, y, deltaX, deltaY);
        }
    }

    @Inject(method={"lambda$onPress$0", "method_1611"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private static void onMouseClickPre(boolean[] processed, Screen screen, double mouseX, double mouseY, int button, CallbackInfo ci) {
        if (!ci.isCancelled() && HudInteractions.CLICKING_PRE.invoker().onClicking(MinecraftClient.getInstance(), screen, mouseX, mouseY, button).isCancelled()) {
            processed[0] = true;
            ci.cancel();
        }
    }

    @Inject(method={"lambda$onPress$0", "method_1611"}, at={@At(value="RETURN")}, cancellable=true, remap=false)
    private static void onMouseClickPost(boolean[] processed, Screen screen, double mouseX, double mouseY, int button, CallbackInfo ci) {
        if (!ci.isCancelled() && !processed[0] && HudInteractions.CLICKING_POST.invoker().onClicking(MinecraftClient.getInstance(), screen, mouseX, mouseY, button).isCancelled()) {
            processed[0] = true;
            ci.cancel();
        }
    }

    @Inject(method={"lambda$onPress$1", "method_1605"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private static void onMouseReleasePre(boolean[] processed, Screen screen, double mouseX, double mouseY, int button, CallbackInfo ci) {
        if (!ci.isCancelled() && HudInteractions.RELEASING_PRE.invoker().onReleasing(MinecraftClient.getInstance(), screen, mouseX, mouseY, button).isCancelled()) {
            processed[0] = true;
            ci.cancel();
        }
    }

    @Inject(method={"lambda$onPress$1", "method_1605"}, at={@At(value="RETURN")}, cancellable=true, remap=false)
    private static void onMouseReleasePost(boolean[] processed, Screen screen, double mouseX, double mouseY, int button, CallbackInfo ci) {
        if (!ci.isCancelled() && !processed[0] && HudInteractions.RELEASING_POST.invoker().onReleasing(MinecraftClient.getInstance(), screen, mouseX, mouseY, button).isCancelled()) {
            processed[0] = true;
            ci.cancel();
        }
    }
}

