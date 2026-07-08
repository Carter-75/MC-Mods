/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3544
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_6379
 *  net.minecraft.class_6379$class_6380
 *  net.minecraft.class_6382
 */
package backported.updates.copper.client.gui.widget;

import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.function.Consumer;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3544;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_6379;
import net.minecraft.class_6382;

public class SearchFieldWidget
implements class_4068,
class_364,
class_6379 {
    private final Dim2i dim;
    private final class_327 font;
    private final class_2561 placeholder;
    private String text = "";
    private boolean focused;
    private boolean hovered;
    private int cursorPosition;
    private int selectionStart;
    private Consumer<String> responder;
    private long lastCursorBlink;
    private boolean cursorVisible = true;
    private static final int BACKGROUND_COLOR = -1879048192;
    private static final int BACKGROUND_COLOR_FOCUSED = -536870912;
    private static final int TEXT_COLOR = -1;
    private static final int PLACEHOLDER_COLOR = -5592406;

    public SearchFieldWidget(Dim2i dim, class_2561 placeholder) {
        this.dim = dim;
        this.font = class_310.method_1551().field_1772;
        this.placeholder = placeholder;
    }

    public void setResponder(Consumer<String> responder) {
        this.responder = responder;
    }

    public void method_25394(class_332 graphics, int mouseX, int mouseY, float partialTick) {
        this.hovered = this.dim.containsCursor(mouseX, mouseY);
        int bgColor = this.focused ? -536870912 : -1879048192;
        graphics.method_25294(this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), bgColor);
        int textX = this.dim.x() + 6;
        int textY = this.dim.y() + (this.dim.height() - 8) / 2;
        if (this.text.isEmpty() && !this.focused) {
            graphics.method_27535(this.font, this.placeholder, textX, textY, -5592406);
        } else {
            graphics.method_25303(this.font, this.text, textX, textY, -1);
            if (this.focused) {
                long time = System.currentTimeMillis();
                if (time - this.lastCursorBlink > 500L) {
                    this.cursorVisible = !this.cursorVisible;
                    this.lastCursorBlink = time;
                }
                if (this.cursorVisible) {
                    int cursorX = textX + this.font.method_1727(this.text.substring(0, this.cursorPosition));
                    graphics.method_25294(cursorX, textY - 1, cursorX + 1, textY + 9, -1);
                }
            }
        }
    }

    public boolean method_25402(double mouseX, double mouseY, int button) {
        if (this.dim.containsCursor(mouseX, mouseY)) {
            this.method_25365(true);
            if (button == 0) {
                int relX = (int)mouseX - this.dim.x() - 6;
                this.cursorPosition = 0;
                int i = 0;
                while (i <= this.text.length() && this.font.method_1727(this.text.substring(0, i)) <= relX) {
                    this.cursorPosition = i++;
                }
            }
            return true;
        }
        return false;
    }

    public boolean method_25404(int keyCode, int scanCode, int modifiers) {
        if (!this.focused) {
            return false;
        }
        switch (keyCode) {
            case 259: {
                if (this.cursorPosition > 0) {
                    this.text = this.text.substring(0, this.cursorPosition - 1) + this.text.substring(this.cursorPosition);
                    --this.cursorPosition;
                    this.onTextChanged();
                }
                return true;
            }
            case 261: {
                if (this.cursorPosition < this.text.length()) {
                    this.text = this.text.substring(0, this.cursorPosition) + this.text.substring(this.cursorPosition + 1);
                    this.onTextChanged();
                }
                return true;
            }
            case 263: {
                if (this.cursorPosition > 0) {
                    --this.cursorPosition;
                }
                return true;
            }
            case 262: {
                if (this.cursorPosition < this.text.length()) {
                    ++this.cursorPosition;
                }
                return true;
            }
            case 268: {
                this.cursorPosition = 0;
                return true;
            }
            case 269: {
                this.cursorPosition = this.text.length();
                return true;
            }
            case 256: {
                this.method_25365(false);
                return true;
            }
        }
        if (keyCode == 65 && (modifiers & 2) != 0) {
            this.text = "";
            this.cursorPosition = 0;
            this.onTextChanged();
            return true;
        }
        return false;
    }

    public boolean method_25400(char chr, int modifiers) {
        if (!this.focused) {
            return false;
        }
        if (class_3544.method_57175((char)chr)) {
            this.text = this.text.substring(0, this.cursorPosition) + chr + this.text.substring(this.cursorPosition);
            ++this.cursorPosition;
            this.onTextChanged();
            return true;
        }
        return false;
    }

    private void onTextChanged() {
        if (this.responder != null) {
            this.responder.accept(this.text);
        }
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        this.cursorPosition = text.length();
    }

    public void method_25365(boolean focused) {
        this.focused = focused;
        if (focused) {
            this.lastCursorBlink = System.currentTimeMillis();
            this.cursorVisible = true;
        }
    }

    public boolean method_25370() {
        return this.focused;
    }

    public class_6379.class_6380 method_37018() {
        return this.focused ? class_6379.class_6380.field_33786 : (this.hovered ? class_6379.class_6380.field_33785 : class_6379.class_6380.field_33784);
    }

    public void method_37020(class_6382 output) {
    }
}

