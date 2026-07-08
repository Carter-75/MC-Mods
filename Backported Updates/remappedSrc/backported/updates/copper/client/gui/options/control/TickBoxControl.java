/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_5250;
import net.minecraft.class_5348;

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
        protected void renderControl(class_332 graphics, int mouseX, int mouseY, float partialTick) {
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
            class_5250 valueText = value ? class_2561.method_43471((String)"options.on").method_27692(class_124.field_1060) : class_2561.method_43471((String)"options.off").method_27692(class_124.field_1061);
            int textX = toggleX - 6 - this.getStringWidth((class_5348)valueText);
            int textY = this.dim.y() + (this.dim.height() - 8) / 2;
            this.drawString(graphics, (class_2561)valueText, textX, textY, -1);
        }

        @Override
        protected Dim2i getControlDim() {
            int controlX = this.dim.x() + this.dim.width() - 36 - 6;
            int controlY = this.dim.y() + (this.dim.height() - 16) / 2;
            return new Dim2i(controlX, controlY, 36, 16);
        }

        public boolean method_25402(double mouseX, double mouseY, int button) {
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

