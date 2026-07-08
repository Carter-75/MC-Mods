/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2791
 *  net.minecraft.class_2794
 *  net.minecraft.class_3195
 *  net.minecraft.class_3218
 *  net.minecraft.class_3485
 *  net.minecraft.class_5138
 *  net.minecraft.class_5281
 *  net.minecraft.class_5455
 *  net.minecraft.class_6880
 *  net.minecraft.class_6885
 *  net.minecraft.class_7869
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.world.level.chunk;

import com.mojang.datafixers.util.Pair;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2791;
import net.minecraft.class_2794;
import net.minecraft.class_3195;
import net.minecraft.class_3218;
import net.minecraft.class_3485;
import net.minecraft.class_5138;
import net.minecraft.class_5281;
import net.minecraft.class_5455;
import net.minecraft.class_6880;
import net.minecraft.class_6885;
import net.minecraft.class_7869;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VS2ChunkAllocator;

@Mixin(value={class_2794.class})
public class MixinChunkGenerator {
    @Inject(method={"findNearestMapStructure"}, at={@At(value="HEAD")}, cancellable=true)
    private void preFindNearestMapFeature(class_3218 serverLevel, class_6885<class_3195> holderSet, class_2338 blockPos, int i2, boolean bl, CallbackInfoReturnable<Pair<class_2338, class_6880<class_3195>>> cir) {
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(blockPos.method_10263() >> 4, blockPos.method_10260() >> 4)) {
            cir.setReturnValue(null);
        }
    }

    @Inject(method={"applyBiomeDecoration"}, at={@At(value="HEAD")}, cancellable=true)
    private void preApplyBiomeDecoration(class_5281 worldGenLevel, class_2791 chunkAccess, class_5138 structureManager, CallbackInfo callbackInfo) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"createStructures"}, at={@At(value="HEAD")}, cancellable=true)
    private void preCreateStructures(class_5455 registryAccess, class_7869 chunkGeneratorStructureState, class_5138 structureManager, class_2791 chunkAccess, class_3485 structureTemplateManager, CallbackInfo callbackInfo) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"createReferences"}, at={@At(value="HEAD")}, cancellable=true)
    private void preCreateReferences(class_5281 worldGenLevel, class_5138 structureManager, class_2791 chunkAccess, CallbackInfo callbackInfo) {
        class_1923 chunkPos = chunkAccess.method_12004();
        if (VS2ChunkAllocator.INSTANCE.isChunkInShipyardCompanion(chunkPos.field_9181, chunkPos.field_9180)) {
            callbackInfo.cancel();
        }
    }
}

