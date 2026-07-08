/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.class_6544;

public enum Humidity {
    ARID(class_6544.class_6546.method_38121((float)-1.0f, (float)-0.35f)),
    DRY(class_6544.class_6546.method_38121((float)-0.35f, (float)-0.1f)),
    NEUTRAL(class_6544.class_6546.method_38121((float)-0.1f, (float)0.1f)),
    WET(class_6544.class_6546.method_38121((float)0.1f, (float)0.3f)),
    HUMID(class_6544.class_6546.method_38121((float)0.3f, (float)1.0f)),
    FULL_RANGE(class_6544.class_6546.method_38121((float)-1.0f, (float)1.0f));

    private final class_6544.class_6546 parameter;

    private Humidity(class_6544.class_6546 parameter) {
        this.parameter = parameter;
    }

    public class_6544.class_6546 parameter() {
        return this.parameter;
    }

    public static class_6544.class_6546 span(Humidity min, Humidity max) {
        return class_6544.class_6546.method_38121((float)class_6544.method_38666((long)min.parameter().comp_103()), (float)class_6544.method_38666((long)max.parameter().comp_104()));
    }
}

