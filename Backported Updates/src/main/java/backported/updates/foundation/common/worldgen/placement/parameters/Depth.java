/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public enum Depth {
    SURFACE(MultiNoiseUtil.ParameterRange.of((float)0.0f)),
    UNDERGROUND(MultiNoiseUtil.ParameterRange.of((float)0.2f, (float)0.9f)),
    FLOOR(MultiNoiseUtil.ParameterRange.of((float)1.0f)),
    FULL_RANGE(MultiNoiseUtil.ParameterRange.of((float)-1.0f, (float)1.0f));

    private final MultiNoiseUtil.ParameterRange parameter;

    private Depth(MultiNoiseUtil.ParameterRange parameter) {
        this.parameter = parameter;
    }

    public MultiNoiseUtil.ParameterRange parameter() {
        return this.parameter;
    }

    public static MultiNoiseUtil.ParameterRange span(Depth min, Depth max) {
        return MultiNoiseUtil.ParameterRange.of((float)MultiNoiseUtil.toFloat((long)min.parameter().min()), (float)MultiNoiseUtil.toFloat((long)max.parameter().max()));
    }
}

