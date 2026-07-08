/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1041
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_9801
 */
package backported.updates.foundation.client.event;

import backported.updates.foundation.core.util.event.Event;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1041;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_9801;

@Environment(value=EnvType.CLIENT)
public class HudRenderEvent {
    public static final Event<RenderHud> RENDER_HUD = Event.create(RenderHud.class);

    @FunctionalInterface
    public static interface RenderHud {
        public void render(class_332 var1, float var2, ElementType var3, RenderContext var4);
    }

    public static enum ElementType {
        DEFAULT,
        HEALTH,
        EXPERIENCE,
        FIRST_PERSON,
        VIGNETTE;

    }

    public static interface RenderContext {
        default public class_1041 window() {
            return this.minecraft().method_22683();
        }

        default public int screenWidth() {
            return this.window().method_4486();
        }

        default public int screenHeight() {
            return this.window().method_4502();
        }

        default public class_310 minecraft() {
            return class_310.method_1551();
        }

        default public class_746 player() {
            return this.minecraft().field_1724;
        }

        default public class_329 gui() {
            return this.minecraft().field_1705;
        }

        default public void renderTextureOverlay(class_2960 texture, float alpha) {
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask((boolean)false);
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(class_757::method_34542);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
            RenderSystem.setShaderTexture((int)0, (class_2960)texture);
            class_289 tesselator = class_289.method_1348();
            class_287 bufferBuilder = tesselator.method_60827(class_293.class_5596.field_27382, class_290.field_1585);
            bufferBuilder.method_22912(0.0f, (float)this.screenHeight(), -90.0f).method_22913(0.0f, 1.0f);
            bufferBuilder.method_22912((float)this.screenWidth(), (float)this.screenHeight(), -90.0f).method_22913(0.0f, 1.0f);
            bufferBuilder.method_22912((float)this.screenWidth(), 0.0f, -90.0f).method_22913(1.0f, 0.0f);
            bufferBuilder.method_22912(0.0f, 0.0f, -90.0f).method_22913(0.0f, 0.0f);
            class_286.method_43433((class_9801)bufferBuilder.method_60800());
            RenderSystem.depthMask((boolean)true);
            RenderSystem.enableDepthTest();
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }
}

