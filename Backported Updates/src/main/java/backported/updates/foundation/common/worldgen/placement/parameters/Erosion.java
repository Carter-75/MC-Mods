/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public enum Erosion {
    EROSION_0(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)-0.78f)),
    EROSION_1(MultiNoiseUtil.ParameterRange.of((float)-0.78f, (float)-0.375f)),
    EROSION_2(MultiNoiseUtil.ParameterRange.of((float)-0.375f, (float)-0.2225f)),
    EROSION_3(MultiNoiseUtil.ParameterRange.of((float)-0.2225f, (float)0.05f)),
    EROSION_4(MultiNoiseUtil.ParameterRange.of((float)0.05f, (float)0.45f)),
    EROSION_5(MultiNoiseUtil.ParameterRange.of((float)0.45f, (float)0.55f)),
    EROSION_6(MultiNoiseUtil.ParameterRange.of((float)0.55f, (float)1.0f)),
    FULL_RANGE(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)1.0f));

    private final MultiNoiseUtil.ParameterRange parameter;

    private Erosion(MultiNoiseUtil.ParameterRange parameter) {
        this.parameter = parameter;
    }

    public MultiNoiseUtil.ParameterRange parameter() {
        return this.parameter;
    }

    public static MultiNoiseUtil.ParameterRange span(Erosion min, Erosion max) {
        return MultiNoiseUtil.ParameterRange.of((float)MultiNoiseUtil.toFloat((long)min.parameter().min()), (float)MultiNoiseUtil.toFloat((long)max.parameter().max()));
    }
}

