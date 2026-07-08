/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  me.jellysquid.mods.sodium.client.render.chunk.map.ChunkTracker
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.sodium;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import me.jellysquid.mods.sodium.client.render.chunk.map.ChunkTracker;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={ChunkTracker.class})
public class MixinChunkTracker {
    @Shadow
    @Final
    private Long2IntOpenHashMap chunkStatus;
    @Shadow
    @Final
    private LongOpenHashSet chunkReady;
    @Shadow
    @Final
    private LongSet unloadQueue;
    @Shadow
    @Final
    private LongSet loadQueue;

    @Inject(method={"updateMerged"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    public void beforeUpdateMerged(int x, int z, CallbackInfo ci) {
        class_638 level = class_310.method_1551().field_1687;
        if (level == null || !VSGameUtilsKt.isChunkInShipyard((class_1937)level, x, z)) {
            return;
        }
        long key = class_1923.method_8331((int)x, (int)z);
        int flags = this.chunkStatus.get(key);
        if (flags == 3) {
            if (this.chunkReady.add(key) && !this.unloadQueue.remove(key)) {
                this.loadQueue.add(key);
            }
        } else if (this.chunkReady.remove(key) && !this.loadQueue.remove(key)) {
            this.unloadQueue.add(key);
        }
        ci.cancel();
    }
}

