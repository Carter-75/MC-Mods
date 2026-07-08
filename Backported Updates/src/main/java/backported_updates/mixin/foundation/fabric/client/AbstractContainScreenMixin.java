/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.screen.HudRendering;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HandledScreen.class})
public class AbstractContainScreenMixin
extends Screen {
    protected AbstractContainScreenMixin(Text title) {
        super(title);
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;render(Lnet/minecraft/client/gui/DrawContext;IIF)V", ordinal=0, shift=At.Shift.AFTER)})
    public void renderBackground(DrawContext graphics, int mouseX, int mouseY, float tickDelta, CallbackInfo ci) {
        HudRendering.RENDER_BACKGROUND.invoker().onRender(this.client, (HandledScreen)(Object)this, graphics, mouseX, mouseY, MinecraftClient.getInstance().getRenderTickCounter());
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/ingame/HandledScreen;drawForeground(Lnet/minecraft/client/gui/DrawContext;II)V", ordinal=0, shift=At.Shift.AFTER)})
    public void renderForeground(DrawContext graphics, int mouseX, int mouseY, float tickDelta, CallbackInfo ci) {
        HudRendering.RENDER_FOREGROUND.invoker().onRender(this.client, (HandledScreen)(Object)this, graphics, mouseX, mouseY, MinecraftClient.getInstance().getRenderTickCounter());
    }
}

