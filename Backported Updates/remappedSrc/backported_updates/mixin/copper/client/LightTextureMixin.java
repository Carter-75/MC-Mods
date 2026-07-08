/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1011
 *  net.minecraft.class_310
 *  net.minecraft.class_5294$class_5401
 *  net.minecraft.class_638
 *  net.minecraft.class_765
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
import net.minecraft.class_1011;
import net.minecraft.class_310;
import net.minecraft.class_5294;
import net.minecraft.class_638;
import net.minecraft.class_765;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_765.class})
public abstract class LightTextureMixin {
    private static final int PURPLE_R = 230;
    private static final int PURPLE_G = 128;
    private static final int PURPLE_B = 255;
    @Shadow
    @Final
    private class_310 field_4137;
    @Shadow
    @Final
    private class_1011 field_4133;
    @Unique
    private float copperagebackport$endFlashIntensity;

    @Inject(method={"updateLightTexture"}, at={@At(value="HEAD")})
    private void copperagebackport$captureEndFlashIntensity(float partialTicks, CallbackInfo ci) {
        this.copperagebackport$endFlashIntensity = 0.0f;
        class_638 level = this.field_4137.field_1687;
        if (level == null || level.method_28103().method_29992() != class_5294.class_5401.field_25641) {
            return;
        }
        EndFlashState state = EndFlashAccessor.get(level);
        if (state == null || ((Boolean)this.field_4137.field_1690.method_41784().method_41753()).booleanValue()) {
            return;
        }
        float intensity = state.getIntensity(partialTicks);
        if (intensity <= 0.0f) {
            return;
        }
        if (this.field_4137.field_1705.method_1740().method_1800()) {
            intensity /= 3.0f;
        }
        this.copperagebackport$endFlashIntensity = intensity;
    }

    @Inject(method={"updateLightTexture"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/texture/DynamicTexture;upload()V")})
    private void copperagebackport$applyEndFlashTint(float partialTicks, CallbackInfo ci) {
        if (this.copperagebackport$endFlashIntensity <= 0.0f) {
            return;
        }
        class_638 level = this.field_4137.field_1687;
        if (level == null || level.method_28103().method_29992() != class_5294.class_5401.field_25641) {
            return;
        }
        float intensity = this.copperagebackport$endFlashIntensity;
        float brightnessBoost = 1.0f + intensity * 0.5f;
        for (int sky = 0; sky < 16; ++sky) {
            for (int block = 0; block < 16; ++block) {
                int pixel = this.field_4133.method_4315(block, sky);
                int alpha = pixel >>> 24 & 0xFF;
                int blue = pixel >>> 16 & 0xFF;
                int green = pixel >>> 8 & 0xFF;
                int red = pixel & 0xFF;
                red = (int)Math.min(255.0f, ((float)red + (float)(230 - red) * intensity) * brightnessBoost);
                green = (int)Math.min(255.0f, ((float)green + (float)(128 - green) * intensity) * brightnessBoost);
                blue = (int)Math.min(255.0f, ((float)blue + (float)(255 - blue) * intensity) * brightnessBoost);
                this.field_4133.method_4305(block, sky, alpha << 24 | blue << 16 | green << 8 | red);
            }
        }
    }
}

