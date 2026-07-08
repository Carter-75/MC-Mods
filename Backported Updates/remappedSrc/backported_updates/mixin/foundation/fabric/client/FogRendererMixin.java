/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  net.minecraft.class_638
 *  net.minecraft.class_6854
 *  net.minecraft.class_758
 *  net.minecraft.class_758$class_4596
 *  net.minecraft.class_758$class_7285
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
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_6854;
import net.minecraft.class_758;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_758.class})
public class FogRendererMixin {
    @Shadow
    private static float field_4034;
    @Shadow
    private static float field_4033;
    @Shadow
    private static float field_4032;

    @ModifyArgs(method={"setupColor"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V", remap=false))
    private static void platform$fogColors(Args args, class_4184 camera, float tickDelta, class_638 level, int farPlaneDistance, float skyDarkness) {
        FogRendering.ColorData data = new FogRendering.ColorData(camera, field_4034, field_4033, field_4032);
        FogRendering.FOG_COLOR.invoker().setColor(data, tickDelta);
        field_4034 = data.getRed();
        field_4033 = data.getGreen();
        field_4032 = data.getBlue();
    }

    @Inject(method={"setupFog"}, at={@At(value="HEAD")}, cancellable=true)
    private static void platform$fogDensity(class_4184 camera, class_758.class_4596 mode, float farPlaneDistance, boolean nearFog, float tickDelta, CallbackInfo ci) {
        float density = FogRendering.FOG_DENSITY.invoker().setDensity(camera, 0.1f);
        if (density != 0.1f) {
            RenderSystem.setShaderFogStart((float)-8.0f);
            RenderSystem.setShaderFogEnd((float)(density * 0.5f));
            ci.cancel();
        }
    }

    @Inject(method={"setupFog"}, at={@At(value="TAIL")})
    private static void platform$fogRendering(class_4184 camera, class_758.class_4596 mode, float farPlaneDistance, boolean nearFog, float tickDelta, CallbackInfo ci, @Local class_5636 type, @Local class_758.class_7285 fogData) {
        FogRendering.FogData data = new FogRendering.FogData(fogData.field_38340, fogData.field_38341, fogData.field_38342);
        if (FogRendering.FOG_RENDER.invoker().onFogRender(mode, type, camera, tickDelta, farPlaneDistance, fogData.field_38340, fogData.field_38341, fogData.field_38342, data).isCancelled()) {
            RenderSystem.setShaderFogStart((float)data.getNearPlaneDistance());
            RenderSystem.setShaderFogEnd((float)data.getFarPlaneDistance());
            RenderSystem.setShaderFogShape((class_6854)data.getShape());
        }
    }
}

