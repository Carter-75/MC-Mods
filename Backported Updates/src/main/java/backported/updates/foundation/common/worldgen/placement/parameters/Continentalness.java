/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public enum Continentalness {
    MUSHROOM_FIELDS(MultiNoiseUtil.ParameterRange.of((float)-1.2f, (float)-1.05f)),
    DEEP_OCEAN(MultiNoiseUtil.ParameterRange.of((float)-1.05f, (float)-0.455f)),
    OCEAN(MultiNoiseUtil.ParameterRange.of((float)-0.455f, (float)-0.19f)),
    COAST(MultiNoiseUtil.ParameterRange.of((float)-0.19f, (float)-0.11f)),
    NEAR_INLAND(MultiNoiseUtil.ParameterRange.of((float)-0.11f, (float)0.03f)),
    MID_INLAND(MultiNoiseUtil.ParameterRange.of((float)0.03f, (float)0.3f)),
    FAR_INLAND(MultiNoiseUtil.ParameterRange.of((float)0.03f, (float)1.0f)),
    INLAND(MultiNoiseUtil.ParameterRange.of((float)-0.11f, (float)0.55f)),
    FULL_RANGE(MultiNoiseUtil.ParameterRange.of((float)-1.2f, (float)1.0f));

    private final MultiNoiseUtil.ParameterRange parameter;

    private Continentalness(MultiNoiseUtil.ParameterRange parameter) {
        this.parameter = parameter;
    }

    public MultiNoiseUtil.ParameterRange parameter() {
        return this.parameter;
    }

    public static MultiNoiseUtil.ParameterRange span(Continentalness min, Continentalness max) {
        return MultiNoiseUtil.ParameterRange.of((float)MultiNoiseUtil.toFloat((long)min.parameter().min()), (float)MultiNoiseUtil.toFloat((long)max.parameter().max()));
    }
}

