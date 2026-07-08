/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_1948
 *  net.minecraft.class_1948$class_5262
 *  net.minecraft.class_2818
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.mob_spawning;

import net.minecraft.class_1937;
import net.minecraft.class_1948;
import net.minecraft.class_2818;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;

@Mixin(value={class_1948.class})
public class NaturalSpawnerMixin {
    @Inject(method={"spawnForChunk"}, at={@At(value="HEAD")}, cancellable=true)
    private static void determineSpawningOnShips(class_3218 level, class_2818 chunk, class_1948.class_5262 spawnState, boolean spawnFriendlies, boolean spawnMonsters, boolean bl, CallbackInfo ci) {
        if (VSGameUtilsKt.isChunkInShipyard((class_1937)level, chunk.method_12004().field_9181, chunk.method_12004().field_9180) && !VSGameConfig.SERVER.getAllowMobSpawns()) {
            ci.cancel();
        }
    }
}

