/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.util.StringHelper
 *  net.minecraft.client.gui.Element
 *  net.minecraft.client.gui.Drawable
 *  net.minecraft.client.gui.Selectable
 *  net.minecraft.client.gui.Selectable$SelectionType
 *  net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
 */
package backported.updates.copper.client.gui.widget;

import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.function.Consumer;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.StringHelper;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;

public class SearchFieldWidget
implements Drawable,
Element,
Selectable {
    private final Dim2i dim;
    private final TextRenderer font;
    private final Text placeholder;
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

    public SearchFieldWidget(Dim2i dim, Text placeholder) {
        this.dim = dim;
        this.font = MinecraftClient.getInstance().textRenderer;
        this.placeholder = placeholder;
    }

    public void setResponder(Consumer<String> responder) {
        this.responder = responder;
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float partialTick) {
        this.hovered = this.dim.containsCursor(mouseX, mouseY);
        int bgColor = this.focused ? -536870912 : -1879048192;
        graphics.fill(this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), bgColor);
        int textX = this.dim.x() + 6;
        int textY = this.dim.y() + (this.dim.height() - 8) / 2;
        if (this.text.isEmpty() && !this.focused) {
            graphics.drawTextWithShadow(this.font, this.placeholder, textX, textY, -5592406);
        } else {
            graphics.drawTextWithShadow(this.font, this.text, textX, textY, -1);
            if (this.focused) {
                long time = System.currentTimeMillis();
                if (time - this.lastCursorBlink > 500L) {
                    this.cursorVisible = !this.cursorVisible;
                    this.lastCursorBlink = time;
                }
                if (this.cursorVisible) {
                    int cursorX = textX + this.font.getWidth(this.text.substring(0, this.cursorPosition));
                    graphics.fill(cursorX, textY - 1, cursorX + 1, textY + 9, -1);
                }
            }
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.dim.containsCursor(mouseX, mouseY)) {
            this.setFocused(true);
            if (button == 0) {
                int relX = (int)mouseX - this.dim.x() - 6;
                this.cursorPosition = 0;
                int i = 0;
                while (i <= this.text.length() && this.font.getWidth(this.text.substring(0, i)) <= relX) {
                    this.cursorPosition = i++;
                }
            }
            return true;
        }
        return false;
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
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
                this.setFocused(false);
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

    public boolean charTyped(char chr, int modifiers) {
        if (!this.focused) {
            return false;
        }
        if (StringHelper.isValidChar((char)chr)) {
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

    public void setFocused(boolean focused) {
        this.focused = focused;
        if (focused) {
            this.lastCursorBlink = System.currentTimeMillis();
            this.cursorVisible = true;
        }
    }

    public boolean isFocused() {
        return this.focused;
    }

    public Selectable.SelectionType getType() {
        return this.focused ? Selectable.SelectionType.FOCUSED : (this.hovered ? Selectable.SelectionType.HOVERED : Selectable.SelectionType.NONE);
    }

    public void appendNarrations(NarrationMessageBuilder output) {
    }
}

