/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.gui.DrawContext
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.widget.AbstractWidget;
import backported.updates.copper.client.gui.widget.Dim2i;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;

public abstract class ControlElement<T>
extends AbstractWidget {
    protected final Option<T> option;
    protected Dim2i dim;
    protected static final int LABEL_COLOR = -1;
    protected static final int LABEL_COLOR_DISABLED = -8355712;
    protected static final int BACKGROUND_COLOR = -1879048192;
    protected static final int BACKGROUND_COLOR_HOVERED = -536870912;

    public ControlElement(Option<T> option, Dim2i dim) {
        this.option = option;
        this.dim = dim;
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float partialTick) {
        this.hovered = this.dim.containsCursor(mouseX, mouseY);
        int bgColor = this.hovered ? -536870912 : -1879048192;
        this.drawRect(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), bgColor);
        Text label = this.option.getName();
        int labelColor = this.option.isAvailable() ? -1 : -8355712;
        this.drawString(graphics, label, this.dim.x() + 6, this.dim.y() + (this.dim.height() - 8) / 2, labelColor);
        this.renderControl(graphics, mouseX, mouseY, partialTick);
        if (this.focused) {
            this.drawBorder(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), -1);
        }
    }

    protected abstract void renderControl(DrawContext var1, int var2, int var3, float var4);

    protected abstract Dim2i getControlDim();

    public boolean isMouseOver(double mouseX, double mouseY) {
        return this.dim.containsCursor(mouseX, mouseY);
    }

    protected boolean isMouseOverControl(double mouseX, double mouseY) {
        return this.getControlDim().containsCursor(mouseX, mouseY);
    }

    public Option<T> getOption() {
        return this.option;
    }

    public Dim2i getDim() {
        return this.dim;
    }

    public void setDim(Dim2i dim) {
        this.dim = dim;
    }
}

