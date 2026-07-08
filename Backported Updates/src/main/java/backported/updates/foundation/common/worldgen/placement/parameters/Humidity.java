/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public enum Humidity {
    ARID(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)-0.35f)),
    DRY(MultiNoiseUtil.ParameterRange.of((float)-0.35f, (float)-0.1f)),
    NEUTRAL(MultiNoiseUtil.ParameterRange.of((float)-0.1f, (float)0.1f)),
    WET(MultiNoiseUtil.ParameterRange.of((float)0.1f, (float)0.3f)),
    HUMID(MultiNoiseUtil.ParameterRange.of((float)0.3f, (float)1.0f)),
    FULL_RANGE(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)1.0f));

    private final MultiNoiseUtil.ParameterRange parameter;

    private Humidity(MultiNoiseUtil.ParameterRange parameter) {
        this.parameter = parameter;
    }

    public MultiNoiseUtil.ParameterRange parameter() {
        return this.parameter;
    }

    public static MultiNoiseUtil.ParameterRange span(Humidity min, Humidity max) {
        return MultiNoiseUtil.ParameterRange.of((float)MultiNoiseUtil.toFloat((long)min.parameter().min()), (float)MultiNoiseUtil.toFloat((long)max.parameter().max()));
    }
}

