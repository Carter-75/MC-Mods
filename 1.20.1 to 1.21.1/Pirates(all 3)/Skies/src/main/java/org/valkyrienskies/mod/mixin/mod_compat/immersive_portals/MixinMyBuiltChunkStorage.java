/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_3532
 *  net.minecraft.class_761
 *  net.minecraft.class_769
 *  net.minecraft.class_846
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  qouteall.imm_ptl.core.render.MyBuiltChunkStorage
 */
package org.valkyrienskies.mod.mixin.mod_compat.immersive_portals;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Objects;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3532;
import net.minecraft.class_761;
import net.minecraft.class_769;
import net.minecraft.class_846;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.client.render.IVSViewAreaMethods;
import qouteall.imm_ptl.core.render.MyBuiltChunkStorage;

@Mixin(value={MyBuiltChunkStorage.class})
public class MixinMyBuiltChunkStorage
extends class_769
implements IVSViewAreaMethods {
    @Unique
    private final Long2ObjectMap<class_846.class_851[]> vs$shipRenderChunks = new Long2ObjectOpenHashMap();
    @Unique
    private class_846 vs$chunkBuilder;

    public MixinMyBuiltChunkStorage(class_846 chunkRenderDispatcher, class_1937 level, int i2, class_761 levelRenderer) {
        super(chunkRenderDispatcher, level, i2, levelRenderer);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void postInit(class_846 chunkBuilder, class_1937 world, int viewDistance, class_761 worldRenderer, CallbackInfo callbackInfo) {
        this.vs$chunkBuilder = chunkBuilder;
    }

    @Inject(method={"setDirty"}, at={@At(value="HEAD")}, cancellable=true)
    private void preScheduleRebuild(int x, int y, int z, boolean important, CallbackInfo callbackInfo) {
        int yIndex = y - this.field_4151.method_32891();
        if (yIndex < 0 || yIndex >= this.field_4149) {
            return;
        }
        if (VSGameUtilsKt.isChunkInShipyard(this.field_4151, x, z)) {
            long chunkPosAsLong = class_1923.method_8331((int)x, (int)z);
            class_846.class_851[] renderChunksArray = (class_846.class_851[])this.vs$shipRenderChunks.computeIfAbsent(chunkPosAsLong, k2 -> new class_846.class_851[this.field_4149]);
            if (renderChunksArray[yIndex] == null) {
                class_846.class_851 builtChunk;
                class_846 class_8462 = this.vs$chunkBuilder;
                Objects.requireNonNull(class_8462);
                renderChunksArray[yIndex] = builtChunk = new class_846.class_851(class_8462, 0, x << 4, y << 4, z << 4);
            }
            renderChunksArray[yIndex].method_3654(important);
            callbackInfo.cancel();
        }
    }

    @Inject(method={"getRenderChunkAt"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetRenderedChunk(class_2338 pos, CallbackInfoReturnable<class_846.class_851> callbackInfoReturnable) {
        int chunkX = class_3532.method_48116((int)pos.method_10263(), (int)16);
        int chunkY = class_3532.method_48116((int)(pos.method_10264() - this.field_4151.method_31607()), (int)16);
        int chunkZ = class_3532.method_48116((int)pos.method_10260(), (int)16);
        if (chunkY < 0 || chunkY >= this.field_4149) {
            return;
        }
        if (VSGameUtilsKt.isChunkInShipyard(this.field_4151, chunkX, chunkZ)) {
            long chunkPosAsLong = class_1923.method_8331((int)chunkX, (int)chunkZ);
            class_846.class_851[] renderChunksArray = (class_846.class_851[])this.vs$shipRenderChunks.get(chunkPosAsLong);
            if (renderChunksArray == null) {
                callbackInfoReturnable.setReturnValue(null);
                return;
            }
            class_846.class_851 renderChunk = renderChunksArray[chunkY];
            callbackInfoReturnable.setReturnValue((Object)renderChunk);
        }
    }

    @Override
    public void unloadChunk(int chunkX, int chunkZ) {
        class_846.class_851[] chunks;
        if (VSGameUtilsKt.isChunkInShipyard(this.field_4151, chunkX, chunkZ) && (chunks = (class_846.class_851[])this.vs$shipRenderChunks.remove(class_1923.method_8331((int)chunkX, (int)chunkZ))) != null) {
            for (class_846.class_851 chunk : chunks) {
                if (chunk == null) continue;
                chunk.method_3659();
            }
        }
    }

    @Inject(method={"releaseAllBuffers"}, at={@At(value="HEAD")})
    private void postReleaseAllBuffers(CallbackInfo ci) {
        for (Long2ObjectMap.Entry entry : this.vs$shipRenderChunks.long2ObjectEntrySet()) {
            for (class_846.class_851 renderChunk : (class_846.class_851[])entry.getValue()) {
                if (renderChunk == null) continue;
                renderChunk.method_3659();
            }
        }
        this.vs$shipRenderChunks.clear();
    }
}

