/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  net.minecraft.class_1132
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.server.MinecraftServer
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.vs2_alpha_hud;

import com.google.common.base.Strings;
import java.util.ArrayList;
import net.minecraft.class_1132;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.config.VSGameConfig;

@Mixin(value={class_329.class})
public class MixinGui {
    @Shadow
    @Final
    private class_310 field_2035;

    @Inject(method={"renderEffects"}, at={@At(value="HEAD")})
    private void preRenderStatusEffectOverlay(class_332 guiGraphics, CallbackInfo ci) {
        if (!VSGameConfig.CLIENT.getRenderDebugText()) {
            return;
        }
        class_327 fontRenderer = this.field_2035.field_1772;
        ArrayList<Object> debugText = new ArrayList<Object>();
        debugText.add("VS 2 Beta Build");
        class_1132 integratedServer = this.field_2035.method_1576();
        if (integratedServer != null) {
            Object physicsTPS = "Error";
            Object loadedVoxelChunks = "Error";
            Object physicsBackendType = "Error";
            try {
                physicsTPS = " " + Math.round(VSGameUtilsKt.getVsPipeline((MinecraftServer)integratedServer).computePhysTps());
                loadedVoxelChunks = " " + VSGameUtilsKt.getVsPipeline((MinecraftServer)integratedServer).getLoadedVoxelChunks();
                physicsBackendType = " " + VSGameUtilsKt.getVsPipeline((MinecraftServer)integratedServer).getPhysicsBackendType().name();
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            String worldPhysicsDebugText = "VS PhysTPS: " + (String)physicsTPS;
            debugText.add(worldPhysicsDebugText);
            String loadedVoxelChunkDebugText = "VS VoxelChunks: " + (String)loadedVoxelChunks;
            debugText.add(loadedVoxelChunkDebugText);
            String physicsBackendDebugText = "VS PhysicsBackendType: " + (String)physicsBackendType;
            debugText.add(physicsBackendDebugText);
        }
        debugText.add("Using UDP: " + ValkyrienSkiesMod.getVsCore().getClientUsesUDP());
        for (int i2 = 0; i2 < debugText.size(); ++i2) {
            String string = (String)debugText.get(i2);
            if (Strings.isNullOrEmpty((String)string)) continue;
            int textHeight = 9;
            int textLength = fontRenderer.method_1727(string);
            int posY = 20 + i2 * 9;
            boolean posX = true;
            guiGraphics.method_25294(1, posY - 1, 2 + textLength + 1, posY + 9 - 1, -1873784752);
            guiGraphics.method_25303(fontRenderer, string, 2, posY, 0xE0E0E0);
        }
    }
}

