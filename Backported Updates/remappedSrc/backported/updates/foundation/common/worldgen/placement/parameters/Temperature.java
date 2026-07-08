/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.class_6544;

public enum Temperature {
    ICY(class_6544.class_6546.method_38121((float)-1.0f, (float)-0.45f)),
    COOL(class_6544.class_6546.method_38121((float)-0.45f, (float)-0.15f)),
    NEUTRAL(class_6544.class_6546.method_38121((float)-0.15f, (float)0.2f)),
    WARM(class_6544.class_6546.method_38121((float)0.2f, (float)0.55f)),
    HOT(class_6544.class_6546.method_38121((float)0.55f, (float)1.0f)),
    FROZEN(class_6544.class_6546.method_38121((float)-1.0f, (float)-0.45f)),
    UNFROZEN(class_6544.class_6546.method_38121((float)-0.45f, (float)1.0f)),
    FULL_RANGE(class_6544.class_6546.method_38121((float)-1.0f, (float)1.0f));

    private final class_6544.class_6546 parameter;

    private Temperature(class_6544.class_6546 parameter) {
        this.parameter = parameter;
    }

    public class_6544.class_6546 parameter() {
        return this.parameter;
    }

    public static class_6544.class_6546 span(Temperature min, Temperature max) {
        return class_6544.class_6546.method_38121((float)class_6544.method_38666((long)min.parameter().comp_103()), (float)class_6544.method_38666((long)max.parameter().comp_104()));
    }
}

