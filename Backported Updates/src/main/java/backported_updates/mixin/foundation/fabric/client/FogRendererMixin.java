/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.render.Camera
 *  net.minecraft.block.enums.CameraSubmersionType
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.render.FogShape
 *  net.minecraft.client.render.BackgroundRenderer
 *  net.minecraft.client.render.BackgroundRenderer$FogType
 *  net.minecraft.client.render.BackgroundRenderer$FogData
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.FogRendering;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.Camera;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.render.FogShape;
import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={BackgroundRenderer.class})
public class FogRendererMixin {
    @Shadow
    private static float red;
    @Shadow
    private static float green;
    @Shadow
    private static float blue;

    @ModifyArgs(method={"render"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V", remap=false))
    private static void platform$fogColors(Args args, Camera camera, float tickDelta, ClientWorld level, int farPlaneDistance, float skyDarkness) {
        FogRendering.ColorData data = new FogRendering.ColorData(camera, red, green, blue);
        FogRendering.FOG_COLOR.invoker().setColor(data, tickDelta);
        red = data.getRed();
        green = data.getGreen();
        blue = data.getBlue();
    }

    @Inject(method={"applyFog"}, at={@At(value="HEAD")}, cancellable=true)
    private static void platform$fogDensity(Camera camera, BackgroundRenderer.FogType mode, float farPlaneDistance, boolean nearFog, float tickDelta, CallbackInfo ci) {
        float density = FogRendering.FOG_DENSITY.invoker().setDensity(camera, 0.1f);
        if (density != 0.1f) {
            RenderSystem.setShaderFogStart((float)-8.0f);
            RenderSystem.setShaderFogEnd((float)(density * 0.5f));
            ci.cancel();
        }
    }

    @Inject(method={"applyFog"}, at={@At(value="TAIL")})
    private static void platform$fogRendering(Camera camera, BackgroundRenderer.FogType mode, float farPlaneDistance, boolean nearFog, float tickDelta, CallbackInfo ci, @Local CameraSubmersionType type, @Local BackgroundRenderer.FogData fogData) {
        FogRendering.FogData data = new FogRendering.FogData(fogData.fogStart, fogData.fogEnd, fogData.fogShape);
        if (FogRendering.FOG_RENDER.invoker().onFogRender(mode, type, camera, tickDelta, farPlaneDistance, fogData.fogStart, fogData.fogEnd, fogData.fogShape, data).isCancelled()) {
            RenderSystem.setShaderFogStart((float)data.getNearPlaneDistance());
            RenderSystem.setShaderFogEnd((float)data.getFarPlaneDistance());
            RenderSystem.setShaderFogShape((FogShape)data.getShape());
        }
    }
}

