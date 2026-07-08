/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4604
 *  net.minecraft.class_638
 *  net.minecraft.class_761
 *  net.minecraft.class_761$class_762
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  qouteall.imm_ptl.core.render.MyBuiltChunkStorage
 *  qouteall.imm_ptl.core.render.VisibleSectionDiscovery
 */
package org.valkyrienskies.mod.mixin.mod_compat.immersive_portals;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4604;
import net.minecraft.class_638;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.mixinducks.client.render.LevelRendererVanillaDuck;
import qouteall.imm_ptl.core.render.MyBuiltChunkStorage;
import qouteall.imm_ptl.core.render.VisibleSectionDiscovery;

@Mixin(value={VisibleSectionDiscovery.class})
public class MixinVisibleSectionDiscovery {
    @Inject(method={"discoverVisibleSections"}, at={@At(value="RETURN")})
    private static void onDiscoverVisibleSections(class_638 world, MyBuiltChunkStorage builtChunks_, class_4184 camera, class_4604 frustum, ObjectArrayList<class_761.class_762> resultHolder_, CallbackInfo ci) {
        class_761 class_7612 = class_310.method_1551().field_1769;
        if (!(class_7612 instanceof LevelRendererVanillaDuck)) {
            return;
        }
        LevelRendererVanillaDuck renderer = (LevelRendererVanillaDuck)class_7612;
        renderer.vs$addShipVisibleChunks(frustum);
    }
}

