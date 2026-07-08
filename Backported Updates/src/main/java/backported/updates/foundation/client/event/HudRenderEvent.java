/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.util.Window
 *  net.minecraft.client.render.BufferRenderer
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.render.VertexFormat$DrawMode
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.render.BuiltBuffer
 */
package backported.updates.foundation.client.event;

import backported.updates.foundation.core.util.event.Event;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.Window;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.BuiltBuffer;

@Environment(value=EnvType.CLIENT)
public class HudRenderEvent {
    public static final Event<RenderHud> RENDER_HUD = Event.create(RenderHud.class);

    @FunctionalInterface
    public static interface RenderHud {
        public void render(DrawContext var1, float var2, ElementType var3, RenderContext var4);
    }

    public static enum ElementType {
        DEFAULT,
        HEALTH,
        EXPERIENCE,
        FIRST_PERSON,
        VIGNETTE;

    }

    public static interface RenderContext {
        default public Window window() {
            return this.minecraft().getWindow();
        }

        default public int screenWidth() {
            return this.window().getScaledWidth();
        }

        default public int screenHeight() {
            return this.window().getScaledHeight();
        }

        default public MinecraftClient minecraft() {
            return MinecraftClient.getInstance();
        }

        default public ClientPlayerEntity player() {
            return this.minecraft().player;
        }

        default public InGameHud gui() {
            return this.minecraft().inGameHud;
        }

        default public void renderTextureOverlay(Identifier texture, float alpha) {
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask((boolean)false);
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
            RenderSystem.setShaderTexture((int)0, texture);
            Tessellator tesselator = Tessellator.getInstance();
            BufferBuilder bufferBuilder = tesselator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
            bufferBuilder.vertex(0.0f, (float)this.screenHeight(), -90.0f).texture(0.0f, 1.0f);
            bufferBuilder.vertex((float)this.screenWidth(), (float)this.screenHeight(), -90.0f).texture(0.0f, 1.0f);
            bufferBuilder.vertex((float)this.screenWidth(), 0.0f, -90.0f).texture(1.0f, 0.0f);
            bufferBuilder.vertex(0.0f, 0.0f, -90.0f).texture(0.0f, 0.0f);
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)bufferBuilder.end());
            RenderSystem.depthMask((boolean)true);
            RenderSystem.enableDepthTest();
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }
}

