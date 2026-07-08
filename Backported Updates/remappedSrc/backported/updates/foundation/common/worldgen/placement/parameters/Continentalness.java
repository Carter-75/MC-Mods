/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.class_6544;

public enum Continentalness {
    MUSHROOM_FIELDS(class_6544.class_6546.method_38121((float)-1.2f, (float)-1.05f)),
    DEEP_OCEAN(class_6544.class_6546.method_38121((float)-1.05f, (float)-0.455f)),
    OCEAN(class_6544.class_6546.method_38121((float)-0.455f, (float)-0.19f)),
    COAST(class_6544.class_6546.method_38121((float)-0.19f, (float)-0.11f)),
    NEAR_INLAND(class_6544.class_6546.method_38121((float)-0.11f, (float)0.03f)),
    MID_INLAND(class_6544.class_6546.method_38121((float)0.03f, (float)0.3f)),
    FAR_INLAND(class_6544.class_6546.method_38121((float)0.03f, (float)1.0f)),
    INLAND(class_6544.class_6546.method_38121((float)-0.11f, (float)0.55f)),
    FULL_RANGE(class_6544.class_6546.method_38121((float)-1.2f, (float)1.0f));

    private final class_6544.class_6546 parameter;

    private Continentalness(class_6544.class_6546 parameter) {
        this.parameter = parameter;
    }

    public class_6544.class_6546 parameter() {
        return this.parameter;
    }

    public static class_6544.class_6546 span(Continentalness min, Continentalness max) {
        return class_6544.class_6546.method_38121((float)class_6544.method_38666((long)min.parameter().comp_103()), (float)class_6544.method_38666((long)max.parameter().comp_104()));
    }
}

