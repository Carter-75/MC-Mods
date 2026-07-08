/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.OverworldBiomeCreator
 *  net.minecraft.world.biome.GenerationSettings$LookupBackedBuilder
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.GenerationSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={OverworldBiomeCreator.class})
public interface OverworldBiomesAccessor {
    @Invoker
    public static void callAddBasicFeatures(GenerationSettings.LookupBackedBuilder builder) {
    }
}

