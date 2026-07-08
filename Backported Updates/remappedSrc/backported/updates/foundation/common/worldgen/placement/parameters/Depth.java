/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement.parameters;

import net.minecraft.class_6544;

public enum Depth {
    SURFACE(class_6544.class_6546.method_38120((float)0.0f)),
    UNDERGROUND(class_6544.class_6546.method_38121((float)0.2f, (float)0.9f)),
    FLOOR(class_6544.class_6546.method_38120((float)1.0f)),
    FULL_RANGE(class_6544.class_6546.method_38121((float)-1.0f, (float)1.0f));

    private final class_6544.class_6546 parameter;

    private Depth(class_6544.class_6546 parameter) {
        this.parameter = parameter;
    }

    public class_6544.class_6546 parameter() {
        return this.parameter;
    }

    public static class_6544.class_6546 span(Depth min, Depth max) {
        return class_6544.class_6546.method_38121((float)class_6544.method_38666((long)min.parameter().comp_103()), (float)class_6544.method_38666((long)max.parameter().comp_104()));
    }
}

