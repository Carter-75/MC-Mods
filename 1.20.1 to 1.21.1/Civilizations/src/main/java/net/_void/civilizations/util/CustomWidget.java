/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_339
 *  net.minecraft.class_6382
 */
package net._void.civilizations.util;

import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_339;
import net.minecraft.class_6382;

public class CustomWidget
extends class_339 {
    public CustomWidget(int x, int y, int width, int height) {
        super(x, y, width, height, (class_2561)class_2561.method_43473());
    }

    protected void method_48579(class_332 context, int mouseX, int mouseY, float delta) {
        context.method_25294(this.method_46426(), this.method_46427(), this.method_46426() + this.field_22758, this.method_46427() + this.field_22759, 65391);
        if (this.method_25367()) {
            context.method_25292(this.method_46426(), this.method_46426() + this.field_22758 - 1, this.method_46427(), -1);
            context.method_25292(this.method_46426(), this.method_46426() + this.field_22758 - 1, this.method_46427() + this.field_22759 - 1, -1);
            context.method_25301(this.method_46426(), this.method_46427(), this.method_46427() + this.field_22759 - 1, -1);
            context.method_25301(this.method_46426() + this.field_22758 - 1, this.method_46427(), this.method_46427() + this.field_22759 - 1, -1);
        }
    }

    protected void method_47399(class_6382 builder) {
    }
}

