/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.class_6544;

public enum Erosion {
    EROSION_0(class_6544.class_6546.method_38121((float)-1.0f, (float)-0.78f)),
    EROSION_1(class_6544.class_6546.method_38121((float)-0.78f, (float)-0.375f)),
    EROSION_2(class_6544.class_6546.method_38121((float)-0.375f, (float)-0.2225f)),
    EROSION_3(class_6544.class_6546.method_38121((float)-0.2225f, (float)0.05f)),
    EROSION_4(class_6544.class_6546.method_38121((float)0.05f, (float)0.45f)),
    EROSION_5(class_6544.class_6546.method_38121((float)0.45f, (float)0.55f)),
    EROSION_6(class_6544.class_6546.method_38121((float)0.55f, (float)1.0f)),
    FULL_RANGE(class_6544.class_6546.method_38121((float)-1.0f, (float)1.0f));

    private final class_6544.class_6546 parameter;

    private Erosion(class_6544.class_6546 parameter) {
        this.parameter = parameter;
    }

    public class_6544.class_6546 parameter() {
        return this.parameter;
    }

    public static class_6544.class_6546 span(Erosion min, Erosion max) {
        return class_6544.class_6546.method_38121((float)class_6544.method_38666((long)min.parameter().comp_103()), (float)class_6544.method_38666((long)max.parameter().comp_104()));
    }
}

