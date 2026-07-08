/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.copper.client;

import backported.updates.copper.registry.RegistryHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MinecraftClient.class})
public abstract class MinecraftDisconnectMixin {
    @Inject(method={"disconnect(Lnet/minecraft/client/gui/screen/Screen;Z)V"}, at={@At(value="HEAD")})
    private void copperagebackport$restoreMinecraftEntriesBeforeDisconnect(Screen screen, boolean immediate, CallbackInfo ci) {
        RegistryHelper.getInstance().restoreVanillaNamespaceEntries();
    }
}

