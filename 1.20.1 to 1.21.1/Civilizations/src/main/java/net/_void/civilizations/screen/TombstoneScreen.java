/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 *  net.minecraft.class_465
 */
package net._void.civilizations.screen;

import net._void.civilizations.screen.TombstoneScreenHandler;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_465;

public class TombstoneScreen
extends class_465<TombstoneScreenHandler> {
    private static final class_2960 TEXTURE = new class_2960("textures/gui/container/generic_54.png");
    private final int rows;

    public TombstoneScreen(TombstoneScreenHandler handler, class_1661 inventory, class_2561 title) {
        super((class_1703)handler, inventory, title);
        int i = 222;
        int j = 114;
        this.rows = handler.getRows();
        this.field_2779 = 114 + this.rows * 18;
        this.field_25270 = this.field_2779 - 94;
    }

    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        super.method_25394(context, mouseX, mouseY, delta);
        this.method_2380(context, mouseX, mouseY);
    }

    protected void method_2389(class_332 context, float delta, int mouseX, int mouseY) {
        int i = (this.field_22789 - this.field_2792) / 2;
        int j = (this.field_22790 - this.field_2779) / 2;
        context.method_25302(TEXTURE, i, j, 0, 0, this.field_2792, this.rows * 18 + 17);
        context.method_25302(TEXTURE, i, j + this.rows * 18 + 17, 0, 126, this.field_2792, 96);
    }
}

