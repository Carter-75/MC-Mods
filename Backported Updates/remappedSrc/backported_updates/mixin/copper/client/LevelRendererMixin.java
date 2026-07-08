/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_761
 *  net.minecraft.class_7833
 *  net.minecraft.class_9801
 *  org.joml.Matrix4f
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
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_7833;
import net.minecraft.class_9801;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_761.class})
public abstract class LevelRendererMixin {
    @Shadow
    @Final
    private class_310 field_4088;
    @Unique
    private static final class_2960 END_FLASH_LOCATION = class_2960.method_60656((String)"textures/environment/end_flash.png");
    @Unique
    private static final float END_FLASH_HEIGHT = 100.0f;
    @Unique
    private static final float END_FLASH_SCALE = 60.0f;

    @Inject(method={"renderEndSky"}, at={@At(value="RETURN")})
    private void copperagebackport$renderEndFlash(class_4587 poseStack, CallbackInfo ci) {
        class_638 level = this.field_4088.field_1687;
        if (level == null) {
            return;
        }
        EndFlashState endFlashState = EndFlashAccessor.get(level);
        if (endFlashState == null) {
            return;
        }
        float partialTick = this.field_4088.method_60646().method_60637(true);
        float intensity = endFlashState.getIntensity(partialTick);
        if (intensity <= 1.0E-4f) {
            return;
        }
        if (((Boolean)this.field_4088.field_1690.method_41784().method_41753()).booleanValue()) {
            return;
        }
        if (this.field_4088.field_1705.method_1740().method_1800()) {
            return;
        }
        float xAngle = endFlashState.getXAngle();
        float yAngle = endFlashState.getYAngle();
        poseStack.method_22903();
        poseStack.method_22907(class_7833.field_40716.rotationDegrees(180.0f - yAngle));
        poseStack.method_22907(class_7833.field_40714.rotationDegrees(-90.0f - xAngle));
        poseStack.method_46416(0.0f, 100.0f, 0.0f);
        poseStack.method_22905(60.0f, 1.0f, 60.0f);
        Matrix4f matrix4f = poseStack.method_23760().method_23761();
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((int)770, (int)1, (int)1, (int)0);
        RenderSystem.depthMask((boolean)false);
        RenderSystem.setShader(class_757::method_34543);
        RenderSystem.setShaderTexture((int)0, (class_2960)END_FLASH_LOCATION);
        class_289 tesselator = class_289.method_1348();
        class_287 bufferbuilder = tesselator.method_60827(class_293.class_5596.field_27382, class_290.field_1575);
        int colorValue = (int)(intensity * 255.0f);
        int color = colorValue << 24 | colorValue << 16 | colorValue << 8 | colorValue;
        bufferbuilder.method_22918(matrix4f, -1.0f, 0.0f, -1.0f).method_22913(0.0f, 0.0f).method_39415(color);
        bufferbuilder.method_22918(matrix4f, 1.0f, 0.0f, -1.0f).method_22913(1.0f, 0.0f).method_39415(color);
        bufferbuilder.method_22918(matrix4f, 1.0f, 0.0f, 1.0f).method_22913(1.0f, 1.0f).method_39415(color);
        bufferbuilder.method_22918(matrix4f, -1.0f, 0.0f, 1.0f).method_22913(0.0f, 1.0f).method_39415(color);
        class_286.method_43433((class_9801)bufferbuilder.method_60800());
        RenderSystem.depthMask((boolean)true);
        RenderSystem.defaultBlendFunc();
        poseStack.method_22909();
    }
}

