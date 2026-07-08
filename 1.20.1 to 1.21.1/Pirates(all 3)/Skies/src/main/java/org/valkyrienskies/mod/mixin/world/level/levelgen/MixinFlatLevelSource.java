/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1923
 *  net.minecraft.class_2791
 *  net.minecraft.class_2897
 *  net.minecraft.class_5138
 *  net.minecraft.class_6748
 *  net.minecraft.class_7138
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.world.level.levelgen;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.class_1923;
import net.minecraft.class_2791;
import net.minecraft.class_2897;
import net.minecraft.class_5138;
import net.minecraft.class_6748;
import net.minecraft.class_7138;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VS2ChunkAllocator;

@Mixin(value={class_2897.class})
public class MixinFlatLevelSource {
    @Inject(method={"fillFromNoise"}, at={@At(value="HEAD")}, cancellable=true)
    private void preFillFromNoise(Executor executor, class_6748 blender, class_7138 randomState, class_5138 structureManager, class_2791 chunkAccess, CallbackInfoReturnable<CompletableFuture<class_2791>> cir) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            cir.setReturnValue(CompletableFuture.completedFuture(chunkAccess));
        }
    }
}

