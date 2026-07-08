/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public enum Temperature {
    ICY(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)-0.45f)),
    COOL(MultiNoiseUtil.ParameterRange.of((float)-0.45f, (float)-0.15f)),
    NEUTRAL(MultiNoiseUtil.ParameterRange.of((float)-0.15f, (float)0.2f)),
    WARM(MultiNoiseUtil.ParameterRange.of((float)0.2f, (float)0.55f)),
    HOT(MultiNoiseUtil.ParameterRange.of((float)0.55f, (float)1.0f)),
    FROZEN(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)-0.45f)),
    UNFROZEN(MultiNoiseUtil.ParameterRange.of((float)-0.45f, (float)1.0f)),
    FULL_RANGE(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)1.0f));

    private final MultiNoiseUtil.ParameterRange parameter;

    private Temperature(MultiNoiseUtil.ParameterRange parameter) {
        this.parameter = parameter;
    }

    public MultiNoiseUtil.ParameterRange parameter() {
        return this.parameter;
    }

    public static MultiNoiseUtil.ParameterRange span(Temperature min, Temperature max) {
        return MultiNoiseUtil.ParameterRange.of((float)MultiNoiseUtil.toFloat((long)min.parameter().min()), (float)MultiNoiseUtil.toFloat((long)max.parameter().max()));
    }
}

