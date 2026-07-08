/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.class_6544;

public enum Weirdness {
    MID_SLICE_NORMAL_ASCENDING(class_6544.class_6546.method_38121((float)-1.0f, (float)-0.93333334f)),
    HIGH_SLICE_NORMAL_ASCENDING(class_6544.class_6546.method_38121((float)-0.93333334f, (float)-0.7666667f)),
    PEAK_NORMAL(class_6544.class_6546.method_38121((float)-0.7666667f, (float)-0.56666666f)),
    HIGH_SLICE_NORMAL_DESCENDING(class_6544.class_6546.method_38121((float)-0.56666666f, (float)-0.4f)),
    MID_SLICE_NORMAL_DESCENDING(class_6544.class_6546.method_38121((float)-0.4f, (float)-0.26666668f)),
    LOW_SLICE_NORMAL_DESCENDING(class_6544.class_6546.method_38121((float)-0.26666668f, (float)-0.05f)),
    VALLEY(class_6544.class_6546.method_38121((float)-0.05f, (float)0.05f)),
    LOW_SLICE_VARIANT_ASCENDING(class_6544.class_6546.method_38121((float)0.05f, (float)0.26666668f)),
    MID_SLICE_VARIANT_ASCENDING(class_6544.class_6546.method_38121((float)0.26666668f, (float)0.4f)),
    HIGH_SLICE_VARIANT_ASCENDING(class_6544.class_6546.method_38121((float)0.4f, (float)0.56666666f)),
    PEAK_VARIANT(class_6544.class_6546.method_38121((float)0.56666666f, (float)0.7666667f)),
    HIGH_SLICE_VARIANT_DESCENDING(class_6544.class_6546.method_38121((float)0.7666667f, (float)0.93333334f)),
    MID_SLICE_VARIANT_DESCENDING(class_6544.class_6546.method_38121((float)0.93333334f, (float)1.0f)),
    FULL_RANGE(class_6544.class_6546.method_38121((float)-1.0f, (float)1.0f));

    private final class_6544.class_6546 parameter;

    private Weirdness(class_6544.class_6546 parameter) {
        this.parameter = parameter;
    }

    public class_6544.class_6546 parameter() {
        return this.parameter;
    }

    public static class_6544.class_6546 span(Weirdness min, Weirdness max) {
        return class_6544.class_6546.method_38121((float)class_6544.method_38666((long)min.parameter().comp_103()), (float)class_6544.method_38666((long)max.parameter().comp_104()));
    }
}

