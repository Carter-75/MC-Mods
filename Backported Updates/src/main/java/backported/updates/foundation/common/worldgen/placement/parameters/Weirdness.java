/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public enum Weirdness {
    MID_SLICE_NORMAL_ASCENDING(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)-0.93333334f)),
    HIGH_SLICE_NORMAL_ASCENDING(MultiNoiseUtil.ParameterRange.of((float)-0.93333334f, (float)-0.7666667f)),
    PEAK_NORMAL(MultiNoiseUtil.ParameterRange.of((float)-0.7666667f, (float)-0.56666666f)),
    HIGH_SLICE_NORMAL_DESCENDING(MultiNoiseUtil.ParameterRange.of((float)-0.56666666f, (float)-0.4f)),
    MID_SLICE_NORMAL_DESCENDING(MultiNoiseUtil.ParameterRange.of((float)-0.4f, (float)-0.26666668f)),
    LOW_SLICE_NORMAL_DESCENDING(MultiNoiseUtil.ParameterRange.of((float)-0.26666668f, (float)-0.05f)),
    VALLEY(MultiNoiseUtil.ParameterRange.of((float)-0.05f, (float)0.05f)),
    LOW_SLICE_VARIANT_ASCENDING(MultiNoiseUtil.ParameterRange.of((float)0.05f, (float)0.26666668f)),
    MID_SLICE_VARIANT_ASCENDING(MultiNoiseUtil.ParameterRange.of((float)0.26666668f, (float)0.4f)),
    HIGH_SLICE_VARIANT_ASCENDING(MultiNoiseUtil.ParameterRange.of((float)0.4f, (float)0.56666666f)),
    PEAK_VARIANT(MultiNoiseUtil.ParameterRange.of((float)0.56666666f, (float)0.7666667f)),
    HIGH_SLICE_VARIANT_DESCENDING(MultiNoiseUtil.ParameterRange.of((float)0.7666667f, (float)0.93333334f)),
    MID_SLICE_VARIANT_DESCENDING(MultiNoiseUtil.ParameterRange.of((float)0.93333334f, (float)1.0f)),
    FULL_RANGE(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)1.0f));

    private final MultiNoiseUtil.ParameterRange parameter;

    private Weirdness(MultiNoiseUtil.ParameterRange parameter) {
        this.parameter = parameter;
    }

    public MultiNoiseUtil.ParameterRange parameter() {
        return this.parameter;
    }

    public static MultiNoiseUtil.ParameterRange span(Weirdness min, Weirdness max) {
        return MultiNoiseUtil.ParameterRange.of((float)MultiNoiseUtil.toFloat((long)min.parameter().min()), (float)MultiNoiseUtil.toFloat((long)max.parameter().max()));
    }
}

