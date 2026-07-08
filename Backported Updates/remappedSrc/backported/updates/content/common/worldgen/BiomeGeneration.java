/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.common.worldgen;

import backported.updates.content.common.registries.ModBiomes;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.common.worldgen.placement.BiomePlacement;
import backported.updates.foundation.common.worldgen.placement.Placement;
import backported.updates.foundation.common.worldgen.placement.parameters.Continentalness;
import backported.updates.foundation.common.worldgen.placement.parameters.Erosion;
import backported.updates.foundation.common.worldgen.placement.parameters.Humidity;
import backported.updates.foundation.common.worldgen.placement.parameters.Temperature;

public class BiomeGeneration {
    public static void bootstrap(BiomePlacement.Event event) {
        if (VanillaBackport.COMMON_CONFIG.hasPaleGarden.get().booleanValue()) {
            event.addSurfaceBiome(Placement.PEAK_VARIANT, Temperature.NEUTRAL.parameter(), Humidity.HUMID.parameter(), Continentalness.span(Continentalness.MID_INLAND, Continentalness.FAR_INLAND), Erosion.EROSION_2.parameter(), 0.0f, ModBiomes.PALE_GARDEN);
            event.addSurfaceBiome(Placement.PEAK_VARIANT, Temperature.NEUTRAL.parameter(), Humidity.HUMID.parameter(), Continentalness.FAR_INLAND.parameter(), Erosion.EROSION_3.parameter(), 0.0f, ModBiomes.PALE_GARDEN);
            event.addSurfaceBiome(Placement.HIGH_SLICE_VARIANT, Temperature.NEUTRAL.parameter(), Humidity.HUMID.parameter(), Continentalness.span(Continentalness.MID_INLAND, Continentalness.FAR_INLAND), Erosion.EROSION_2.parameter(), 0.0f, ModBiomes.PALE_GARDEN);
            event.addSurfaceBiome(Placement.HIGH_SLICE_VARIANT, Temperature.NEUTRAL.parameter(), Humidity.HUMID.parameter(), Continentalness.FAR_INLAND.parameter(), Erosion.EROSION_3.parameter(), 0.0f, ModBiomes.PALE_GARDEN);
            event.addSurfaceBiome(Placement.MID_SLICE_VARIANT, Temperature.NEUTRAL.parameter(), Humidity.HUMID.parameter(), Continentalness.FAR_INLAND.parameter(), Erosion.EROSION_1.parameter(), 0.0f, ModBiomes.PALE_GARDEN);
            event.addSurfaceBiome(Placement.MID_SLICE_VARIANT, Temperature.NEUTRAL.parameter(), Humidity.HUMID.parameter(), Continentalness.FAR_INLAND.parameter(), Erosion.EROSION_2.parameter(), 0.0f, ModBiomes.PALE_GARDEN);
        }
    }
}

