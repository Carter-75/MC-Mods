/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.render.BufferRenderer
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.render.VertexFormat$DrawMode
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.client.render.BuiltBuffer
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
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.BuiltBuffer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={WorldRenderer.class})
public abstract class LevelRendererMixin {
    @Shadow
    @Final
    private MinecraftClient client;
    @Unique
    private static final Identifier END_FLASH_LOCATION = Identifier.ofVanilla((String)"textures/environment/end_flash.png");
    @Unique
    private static final float END_FLASH_HEIGHT = 100.0f;
    @Unique
    private static final float END_FLASH_SCALE = 60.0f;

    @Inject(method={"renderEndSky"}, at={@At(value="RETURN")})
    private void copperagebackport$renderEndFlash(MatrixStack poseStack, CallbackInfo ci) {
        ClientWorld level = this.client.world;
        if (level == null) {
            return;
        }
        EndFlashState endFlashState = EndFlashAccessor.get(level);
        if (endFlashState == null) {
            return;
        }
        float partialTick = this.client.getRenderTickCounter().getTickDelta(true);
        float intensity = endFlashState.getIntensity(partialTick);
        if (intensity <= 1.0E-4f) {
            return;
        }
        if (((Boolean)this.client.options.getHideLightningFlashes().getValue()).booleanValue()) {
            return;
        }
        if (this.client.inGameHud.getBossBarHud().shouldThickenFog()) {
            return;
        }
        float xAngle = endFlashState.getXAngle();
        float yAngle = endFlashState.getYAngle();
        poseStack.push();
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - yAngle));
        poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0f - xAngle));
        poseStack.translate(0.0f, 100.0f, 0.0f);
        poseStack.scale(60.0f, 1.0f, 60.0f);
        Matrix4f matrix4f = poseStack.peek().getPositionMatrix();
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((int)770, (int)1, (int)1, (int)0);
        RenderSystem.depthMask((boolean)false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        RenderSystem.setShaderTexture((int)0, END_FLASH_LOCATION);
        Tessellator tesselator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tesselator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        int colorValue = (int)(intensity * 255.0f);
        int color = colorValue << 24 | colorValue << 16 | colorValue << 8 | colorValue;
        bufferbuilder.vertex(matrix4f, -1.0f, 0.0f, -1.0f).texture(0.0f, 0.0f).color(color);
        bufferbuilder.vertex(matrix4f, 1.0f, 0.0f, -1.0f).texture(1.0f, 0.0f).color(color);
        bufferbuilder.vertex(matrix4f, 1.0f, 0.0f, 1.0f).texture(1.0f, 1.0f).color(color);
        bufferbuilder.vertex(matrix4f, -1.0f, 0.0f, 1.0f).texture(0.0f, 1.0f).color(color);
        BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferbuilder.end());
        RenderSystem.depthMask((boolean)true);
        RenderSystem.defaultBlendFunc();
        poseStack.pop();
    }
}

