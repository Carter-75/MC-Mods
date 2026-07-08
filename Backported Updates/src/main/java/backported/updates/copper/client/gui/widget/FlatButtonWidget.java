/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.Drawable
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.client.gui.navigation.GuiNavigationPath
 *  net.minecraft.client.gui.navigation.GuiNavigation
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.input.KeyCodes
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.gui.widget;

import backported.updates.copper.client.gui.widget.AbstractWidget;
import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.Objects;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.text.StringVisitable;
import net.minecraft.client.gui.navigation.GuiNavigationPath;
import net.minecraft.client.gui.navigation.GuiNavigation;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.input.KeyCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FlatButtonWidget
extends AbstractWidget
implements Drawable {
    private final Dim2i dim;
    private final Runnable action;
    @NotNull
    private Style style = Style.defaults();
    private boolean selected;
    private boolean enabled = true;
    private boolean visible = true;
    private int borderColor = 0;
    private Text label;

    public FlatButtonWidget(Dim2i dim, Text label, Runnable action) {
        this.dim = dim;
        this.label = label;
        this.action = action;
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        if (!this.visible) {
            return;
        }
        this.hovered = this.dim.containsCursor(mouseX, mouseY);
        int backgroundColor = this.enabled ? (this.hovered ? this.style.bgHovered : this.style.bgDefault) : this.style.bgDisabled;
        int textColor = this.enabled ? this.style.textDefault : this.style.textDisabled;
        int strWidth = this.font.getWidth((StringVisitable)this.label);
        this.drawRect(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), backgroundColor);
        this.drawString(graphics, this.label, this.dim.getCenterX() - strWidth / 2, this.dim.getCenterY() - 4, textColor);
        if (this.enabled && this.selected) {
            this.drawRect(graphics, this.dim.x(), this.dim.getLimitY() - 1, this.dim.getLimitX(), this.dim.getLimitY(), -7019309);
        }
        if (this.enabled && this.borderColor != 0) {
            this.drawBorder(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), this.borderColor);
        } else if (this.enabled && this.isFocused()) {
            this.drawBorder(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), -1);
        }
    }

    public void setStyle(@NotNull Style style) {
        Objects.requireNonNull(style);
        this.style = style;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setBorderColor(int color) {
        this.borderColor = color;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (!this.enabled || !this.visible) {
            return false;
        }
        if (button == 0 && this.dim.containsCursor(mouseX, mouseY)) {
            this.doAction();
            return true;
        }
        return false;
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (!this.isFocused()) {
            return false;
        }
        if (KeyCodes.isToggle((int)keyCode)) {
            this.doAction();
            return true;
        }
        return false;
    }

    private void doAction() {
        this.action.run();
        this.playClickSound();
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setLabel(Text text) {
        this.label = text;
    }

    public Text getLabel() {
        return this.label;
    }

    public Dim2i getDimensions() {
        return this.dim;
    }

    @Override
    @Nullable
    public GuiNavigationPath getNavigationPath(GuiNavigation event) {
        if (!this.enabled || !this.visible) {
            return null;
        }
        return super.getNavigationPath(event);
    }

    public ScreenRect getNavigationFocus() {
        return new ScreenRect(this.dim.x(), this.dim.y(), this.dim.width(), this.dim.height());
    }

    public static class Style {
        public int bgHovered;
        public int bgDefault;
        public int bgDisabled;
        public int textDefault;
        public int textDisabled;

        public static Style defaults() {
            Style style = new Style();
            style.bgHovered = -536870912;
            style.bgDefault = -1879048192;
            style.bgDisabled = 0x60000000;
            style.textDefault = -1;
            style.textDisabled = -1862270977;
            return style;
        }
    }
}

