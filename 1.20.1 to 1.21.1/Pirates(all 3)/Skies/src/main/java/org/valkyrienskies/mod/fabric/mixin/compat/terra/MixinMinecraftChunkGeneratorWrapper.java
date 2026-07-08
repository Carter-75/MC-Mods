/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.dfsek.terra.mod.generation.MinecraftChunkGeneratorWrapper
 *  net.minecraft.class_1923
 *  net.minecraft.class_1966
 *  net.minecraft.class_2680
 *  net.minecraft.class_2791
 *  net.minecraft.class_2794
 *  net.minecraft.class_2893$class_2894
 *  net.minecraft.class_3233
 *  net.minecraft.class_4543
 *  net.minecraft.class_4966
 *  net.minecraft.class_5138
 *  net.minecraft.class_5281
 *  net.minecraft.class_5284
 *  net.minecraft.class_5309
 *  net.minecraft.class_5539
 *  net.minecraft.class_6748
 *  net.minecraft.class_6880
 *  net.minecraft.class_7138
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.fabric.mixin.compat.terra;

import com.dfsek.terra.mod.generation.MinecraftChunkGeneratorWrapper;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.class_1923;
import net.minecraft.class_1966;
import net.minecraft.class_2680;
import net.minecraft.class_2791;
import net.minecraft.class_2794;
import net.minecraft.class_2893;
import net.minecraft.class_3233;
import net.minecraft.class_4543;
import net.minecraft.class_4966;
import net.minecraft.class_5138;
import net.minecraft.class_5281;
import net.minecraft.class_5284;
import net.minecraft.class_5309;
import net.minecraft.class_5539;
import net.minecraft.class_6748;
import net.minecraft.class_6880;
import net.minecraft.class_7138;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VS2ChunkAllocator;

@Mixin(value={MinecraftChunkGeneratorWrapper.class})
public abstract class MixinMinecraftChunkGeneratorWrapper
extends class_2794 {
    @Shadow
    @Final
    private class_6880<class_5284> settings;

    @Inject(method={"getBaseColumn"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetBaseColumn(int i2, int j2, class_5539 levelHeightAccessor, class_7138 randomState, CallbackInfoReturnable<class_4966> cir) {
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(i2, j2)) {
            class_5309 noiseSettings = ((class_5284)this.settings.comp_349()).comp_474();
            int k2 = Math.max(noiseSettings.comp_173(), levelHeightAccessor.method_31607());
            cir.setReturnValue((Object)new class_4966(k2, new class_2680[0]));
            cir.cancel();
        }
    }

    @Inject(method={"buildSurface"}, at={@At(value="HEAD")}, cancellable=true)
    private void preBuildSurface(class_3233 worldGenRegion, class_5138 structureManager, class_7138 randomState, class_2791 chunkAccess, CallbackInfo ci) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            ci.cancel();
        }
    }

    @Inject(method={"applyCarvers"}, at={@At(value="HEAD")}, cancellable=true)
    private void preApplyCarvers(class_3233 worldGenRegion, long l2, class_7138 randomState, class_4543 biomeManager, class_5138 structureManager, class_2791 chunkAccess, class_2893.class_2894 carving, CallbackInfo ci) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            ci.cancel();
        }
    }

    @Inject(method={"fillFromNoise"}, at={@At(value="HEAD")}, cancellable=true)
    private void preFillFromNoise(Executor executor, class_6748 blender, class_7138 randomState, class_5138 structureManager, class_2791 chunkAccess, CallbackInfoReturnable<CompletableFuture<class_2791>> cir) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            cir.setReturnValue(CompletableFuture.completedFuture(chunkAccess));
            cir.cancel();
        }
    }

    @Inject(method={"spawnOriginalMobs"}, at={@At(value="HEAD")}, cancellable=true)
    private void preSpawnOriginalMobs(class_3233 worldGenRegion, CallbackInfo ci) {
        class_1923 chunkPos = worldGenRegion.method_33561();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            ci.cancel();
        }
    }

    @Inject(method={"applyBiomeDecoration"}, at={@At(value="HEAD")}, cancellable=true)
    private void preApplyBiomeDecoration(class_5281 worldGenLevel, class_2791 chunkAccess, class_5138 structureManager, CallbackInfo callbackInfo) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            callbackInfo.cancel();
        }
    }

    public MixinMinecraftChunkGeneratorWrapper(class_1966 biomeSource) {
        super(biomeSource);
    }
}

