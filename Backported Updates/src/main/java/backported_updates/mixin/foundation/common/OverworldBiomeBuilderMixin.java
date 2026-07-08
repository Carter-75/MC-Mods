/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$NoiseHypercube
 *  net.minecraft.world.biome.source.util.VanillaBiomeParameters
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
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={VanillaBiomeParameters.class})
public class OverworldBiomeBuilderMixin {
    @Inject(method={"writeOverworldBiomeParameters"}, at={@At(value="TAIL")})
    private void platform$addBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper, CallbackInfo ci) {
        BiomeSpawnPlacement.BIOME_ENTRIES.forEach(mapper);
        BiomePlacement.BIOME_PLACEMENTS.forEach(mapper);
    }
}

