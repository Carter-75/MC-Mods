/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.DimensionEffects$SkyType
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.render.LightmapTextureManager
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.copper.client;

import backported.updates.copper.client.endflash.EndFlashAccessor;
import backported.updates.copper.client.endflash.EndFlashState;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LightmapTextureManager.class})
public abstract class LightTextureMixin {
    private static final int PURPLE_R = 230;
    private static final int PURPLE_G = 128;
    private static final int PURPLE_B = 255;
    @Shadow
    @Final
    private MinecraftClient client;
    @Shadow
    @Final
    private NativeImage image;
    @Unique
    private float copperagebackport$endFlashIntensity;

    @Inject(method={"update"}, at={@At(value="HEAD")})
    private void copperagebackport$captureEndFlashIntensity(float partialTicks, CallbackInfo ci) {
        this.copperagebackport$endFlashIntensity = 0.0f;
        ClientWorld level = this.client.world;
        if (level == null || level.getDimensionEffects().getSkyType() != DimensionEffects.SkyType.END) {
            return;
        }
        EndFlashState state = EndFlashAccessor.get(level);
        if (state == null || ((Boolean)this.client.options.getHideLightningFlashes().getValue()).booleanValue()) {
            return;
        }
        float intensity = state.getIntensity(partialTicks);
        if (intensity <= 0.0f) {
            return;
        }
        if (this.client.inGameHud.getBossBarHud().shouldThickenFog()) {
            intensity /= 3.0f;
        }
        this.copperagebackport$endFlashIntensity = intensity;
    }

    @Inject(method={"update"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/texture/NativeImageBackedTexture;upload()V")})
    private void copperagebackport$applyEndFlashTint(float partialTicks, CallbackInfo ci) {
        if (this.copperagebackport$endFlashIntensity <= 0.0f) {
            return;
        }
        ClientWorld level = this.client.world;
        if (level == null || level.getDimensionEffects().getSkyType() != DimensionEffects.SkyType.END) {
            return;
        }
        float intensity = this.copperagebackport$endFlashIntensity;
        float brightnessBoost = 1.0f + intensity * 0.5f;
        for (int sky = 0; sky < 16; ++sky) {
            for (int block = 0; block < 16; ++block) {
                int pixel = this.image.getColor(block, sky);
                int alpha = pixel >>> 24 & 0xFF;
                int blue = pixel >>> 16 & 0xFF;
                int green = pixel >>> 8 & 0xFF;
                int red = pixel & 0xFF;
                red = (int)Math.min(255.0f, ((float)red + (float)(230 - red) * intensity) * brightnessBoost);
                green = (int)Math.min(255.0f, ((float)green + (float)(128 - green) * intensity) * brightnessBoost);
                blue = (int)Math.min(255.0f, ((float)blue + (float)(255 - blue) * intensity) * brightnessBoost);
                this.image.setColor(block, sky, alpha << 24 | blue << 16 | green << 8 | red);
            }
        }
    }
}

