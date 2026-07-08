/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1109
 *  net.minecraft.class_1113
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_5348
 *  net.minecraft.class_6379
 *  net.minecraft.class_6379$class_6380
 *  net.minecraft.class_6381
 *  net.minecraft.class_6382
 *  net.minecraft.class_8015
 *  net.minecraft.class_8016
 *  net.minecraft.class_8023
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.gui.widget;

import net.minecraft.class_1109;
import net.minecraft.class_1113;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_5348;
import net.minecraft.class_6379;
import net.minecraft.class_6381;
import net.minecraft.class_6382;
import net.minecraft.class_8015;
import net.minecraft.class_8016;
import net.minecraft.class_8023;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractWidget
implements class_4068,
class_364,
class_6379 {
    protected final class_327 font;
    protected boolean focused;
    protected boolean hovered;

    protected AbstractWidget() {
        this.font = class_310.method_1551().field_1772;
    }

    protected void drawString(class_332 graphics, String text, int x, int y, int color) {
        graphics.method_25303(this.font, text, x, y, color);
    }

    protected void drawString(class_332 graphics, class_2561 text, int x, int y, int color) {
        graphics.method_27535(this.font, text, x, y, color);
    }

    public boolean isHovered() {
        return this.hovered;
    }

    protected void drawRect(class_332 graphics, int x1, int y1, int x2, int y2, int color) {
        graphics.method_25294(x1, y1, x2, y2, color);
    }

    protected void playClickSound() {
        class_310.method_1551().method_1483().method_4873((class_1113)class_1109.method_4758((class_3414)((class_3414)class_3417.field_15015.comp_349()), (float)1.0f));
    }

    protected int getStringWidth(class_5348 text) {
        return this.font.method_27525(text);
    }

    public // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull class_6379.class_6380 method_37018() {
        if (this.focused) {
            return class_6379.class_6380.field_33786;
        }
        if (this.hovered) {
            return class_6379.class_6380.field_33785;
        }
        return class_6379.class_6380.field_33784;
    }

    public void method_37020(class_6382 builder) {
        if (this.focused) {
            builder.method_37034(class_6381.field_33791, (class_2561)class_2561.method_43471((String)"narration.button.usage.focused"));
        } else if (this.hovered) {
            builder.method_37034(class_6381.field_33791, (class_2561)class_2561.method_43471((String)"narration.button.usage.hovered"));
        }
    }

    @Nullable
    public class_8016 method_48205(class_8023 event) {
        return !this.method_25370() ? class_8016.method_48193((class_364)this) : null;
    }

    public boolean method_25370() {
        return this.focused;
    }

    public void method_25365(boolean focused) {
        if (!focused) {
            this.focused = false;
        } else {
            class_8015 inputType = class_310.method_1551().method_48186();
            if (inputType == class_8015.field_41780 || inputType == class_8015.field_43097) {
                this.focused = true;
            }
        }
    }

    protected void drawBorder(class_332 graphics, int x1, int y1, int x2, int y2, int color) {
        graphics.method_25294(x1, y1, x2, y1 + 1, color);
        graphics.method_25294(x1, y2 - 1, x2, y2, color);
        graphics.method_25294(x1, y1, x1 + 1, y2, color);
        graphics.method_25294(x2 - 1, y1, x2, y2, color);
    }
}

