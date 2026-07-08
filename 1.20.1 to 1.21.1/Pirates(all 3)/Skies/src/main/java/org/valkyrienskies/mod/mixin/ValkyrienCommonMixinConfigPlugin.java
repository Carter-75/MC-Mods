/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.MixinExtrasBootstrap
 *  org.objectweb.asm.tree.ClassNode
 *  org.spongepowered.asm.mixin.Mixins
 *  org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin
 *  org.spongepowered.asm.mixin.extensibility.IMixinInfo
 *  org.spongepowered.asm.service.MixinService
 */
package org.valkyrienskies.mod.mixin;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.service.MixinService;
import org.valkyrienskies.mod.compat.LoadedMods;
import org.valkyrienskies.mod.compat.VSRenderer;

public class ValkyrienCommonMixinConfigPlugin
implements IMixinConfigPlugin {
    private static final boolean PATH_FINDING_DEBUG = "false".equals(System.getProperty("org.valkyrienskies.render_pathfinding"));
    private static VSRenderer vsRenderer = null;

    public static VSRenderer getVSRenderer() {
        if (vsRenderer == null) {
            vsRenderer = ValkyrienCommonMixinConfigPlugin.getVSRendererHelper();
        }
        return vsRenderer;
    }

    private static VSRenderer getVSRendererHelper() {
        if (ValkyrienCommonMixinConfigPlugin.classExists("optifine.OptiFineTransformationService")) {
            return VSRenderer.OPTIFINE;
        }
        if (ValkyrienCommonMixinConfigPlugin.classExists("me.jellysquid.mods.sodium.client.SodiumClientMod")) {
            return VSRenderer.SODIUM;
        }
        return VSRenderer.VANILLA;
    }

    private static boolean classExists(String className) {
        try {
            Class.forName(className, false, ValkyrienCommonMixinConfigPlugin.class.getClassLoader());
            return true;
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
    }

    public void onLoad(String s) {
        MixinExtrasBootstrap.init();
        Mixins.registerErrorHandlerClass((String)"org.valkyrienskies.mod.mixin.ValkyrienMixinErrorHandler");
    }

    public String getRefMapperConfig() {
        return null;
    }

    public boolean shouldApplyMixin(String s, String mixinClassName) {
        VSRenderer renderer = ValkyrienCommonMixinConfigPlugin.getVSRenderer();
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.immersive_portals")) {
            return LoadedMods.getImmersivePortals();
        }
        if (mixinClassName.equals("org.valkyrienskies.mod.mixin.client.world.MixinClientChunkCache") || mixinClassName.equals("org.valkyrienskies.mod.mixin.mod_compat.vanilla_renderer.MixinViewAreaVanilla")) {
            return !LoadedMods.getImmersivePortals();
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.sodium")) {
            return renderer == VSRenderer.SODIUM;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.optifine_vanilla")) {
            return renderer == VSRenderer.VANILLA || renderer == VSRenderer.OPTIFINE;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.vanilla_renderer")) {
            return renderer == VSRenderer.VANILLA;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.optifine")) {
            return renderer == VSRenderer.OPTIFINE;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.feature.render_pathfinding")) {
            return PATH_FINDING_DEBUG;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.flywheel")) {
            return LoadedMods.getFlywheel() == LoadedMods.FlywheelVersion.V1;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.flywheel_renderer")) {
            return LoadedMods.getFlywheel() == LoadedMods.FlywheelVersion.V1;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.old_flywheel")) {
            return LoadedMods.getFlywheel() == LoadedMods.FlywheelVersion.V06;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.common_create.client.trackOutlines") && ValkyrienCommonMixinConfigPlugin.classExists("org.valkyrienskies.create_interactive.mixin.client.MixinTrackBlockOutline")) {
            MixinService.getService().getLogger("mixin").info("[VS2] found Interactive, disabling VS2's trackOutline Compat - " + mixinClassName.substring(mixinClassName.lastIndexOf(".") + 1), new Object[0]);
            return false;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.common_create")) {
            return LoadedMods.getCreate() || LoadedMods.getOldCreate();
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.old_create")) {
            return LoadedMods.getOldCreate();
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.mixin.mod_compat.create")) {
            return LoadedMods.getCreate();
        }
        return !mixinClassName.equals("org.valkyrienskies.mod.mixin.mod_compat.etf.MixinBlockEntity") || ValkyrienCommonMixinConfigPlugin.classExists("traben.entity_texture_features.utils.ETFEntity");
    }

    public void acceptTargets(Set<String> set, Set<String> set1) {
    }

    public List<String> getMixins() {
        return null;
    }

    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }

    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }
}

