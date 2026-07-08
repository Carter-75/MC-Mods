/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Formatting
 *  net.minecraft.text.Text
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.StringVisitable
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;

public class TickBoxControl
implements Control<Boolean> {
    private final Option<Boolean> option;

    public TickBoxControl(Option<Boolean> option) {
        this.option = option;
    }

    @Override
    public ControlElement<Boolean> createElement(Dim2i dim) {
        return new Element(this.option, dim);
    }

    @Override
    public Option<Boolean> getOption() {
        return this.option;
    }

    @Override
    public int getMaxWidth() {
        return 36;
    }

    private static class Element
    extends ControlElement<Boolean> {
        private static final int TOGGLE_WIDTH = 36;
        private static final int TOGGLE_HEIGHT = 16;
        private static final int KNOB_SIZE = 12;
        private static final int COLOR_ON = -11751600;
        private static final int COLOR_OFF = -6381922;
        private static final int COLOR_DISABLED = -10395295;
        private static final int COLOR_KNOB = -1;

        public Element(Option<Boolean> option, Dim2i dim) {
            super(option, dim);
        }

        @Override
        protected void renderControl(DrawContext graphics, int mouseX, int mouseY, float partialTick) {
            Dim2i controlDim = this.getControlDim();
            int toggleX = controlDim.x();
            int toggleY = this.dim.y() + (this.dim.height() - 16) / 2;
            boolean enabled = this.option.isAvailable();
            boolean value = (Boolean)this.option.getValue();
            int bgColor = !enabled ? -10395295 : (value ? -11751600 : -6381922);
            this.drawRect(graphics, toggleX, toggleY, toggleX + 36, toggleY + 16, bgColor);
            int borderColor = this.focused ? -1 : -12566464;
            this.drawBorder(graphics, toggleX, toggleY, toggleX + 36, toggleY + 16, borderColor);
            int knobPadding = 2;
            int knobX = value ? toggleX + 36 - 12 - knobPadding : toggleX + knobPadding;
            int knobY = toggleY + knobPadding;
            this.drawRect(graphics, knobX, knobY, knobX + 12, knobY + 12, -1);
            MutableText valueText = value ? Text.translatable((String)"options.on").formatted(Formatting.GREEN) : Text.translatable((String)"options.off").formatted(Formatting.RED);
            int textX = toggleX - 6 - this.getStringWidth((StringVisitable)valueText);
            int textY = this.dim.y() + (this.dim.height() - 8) / 2;
            this.drawString(graphics, (Text)valueText, textX, textY, -1);
        }

        @Override
        protected Dim2i getControlDim() {
            int controlX = this.dim.x() + this.dim.width() - 36 - 6;
            int controlY = this.dim.y() + (this.dim.height() - 16) / 2;
            return new Dim2i(controlX, controlY, 36, 16);
        }

        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (!this.option.isAvailable()) {
                return false;
            }
            if (button == 0 && this.isMouseOverControl(mouseX, mouseY)) {
                this.option.setValue((Boolean)this.option.getValue() == false);
                this.playClickSound();
                return true;
            }
            return false;
        }
    }
}

