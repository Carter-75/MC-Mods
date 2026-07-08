/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1959
 *  net.minecraft.class_5321
 *  net.minecraft.class_6544$class_4762
 *  net.minecraft.class_6554
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.common;

import backported.updates.foundation.common.worldgen.placement.BiomePlacement;
import backported.updates.foundation.common.worldgen.placement.BiomeSpawnPlacement;
import com.mojang.datafixers.util.Pair;
import java.util.function.Consumer;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_6544;
import net.minecraft.class_6554;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_6554.class})
public class OverworldBiomeBuilderMixin {
    @Inject(method={"addBiomes"}, at={@At(value="TAIL")})
    private void platform$addBiomes(Consumer<Pair<class_6544.class_4762, class_5321<class_1959>>> mapper, CallbackInfo ci) {
        BiomeSpawnPlacement.BIOME_ENTRIES.forEach(mapper);
        BiomePlacement.BIOME_PLACEMENTS.forEach(mapper);
    }
}

