/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_412
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.client.gui.screens;

import net.minecraft.class_412;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Mixin(value={class_412.class})
public class MixinConnectScreen {
    @Inject(method={"startConnecting"}, at={@At(value="HEAD")})
    private static void preStartConnecting(CallbackInfo ci) {
        ValkyrienSkiesMod.getVsCore().setClientUsesUDP(false);
    }
}

