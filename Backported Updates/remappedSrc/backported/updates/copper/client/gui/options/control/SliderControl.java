/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_5250;
import net.minecraft.class_5348;

public class SliderControl
implements Control<Integer> {
    private final Option<Integer> option;
    private final int min;
    private final int max;
    private final int step;
    private final String suffix;

    public SliderControl(Option<Integer> option, int min, int max, int step, String suffix) {
        this.option = option;
        this.min = min;
        this.max = max;
        this.step = step;
        this.suffix = suffix;
    }

    public SliderControl(Option<Integer> option, int min, int max, int step) {
        this(option, min, max, step, "");
    }

    @Override
    public ControlElement<Integer> createElement(Dim2i dim) {
        return new Element(this.option, dim, this.min, this.max, this.step, this.suffix);
    }

    @Override
    public Option<Integer> getOption() {
        return this.option;
    }

    @Override
    public int getMaxWidth() {
        return 100;
    }

    private static class Element
    extends ControlElement<Integer> {
        private static final int SLIDER_WIDTH = 100;
        private static final int SLIDER_HEIGHT = 6;
        private static final int HANDLE_WIDTH = 8;
        private static final int HANDLE_HEIGHT = 14;
        private static final int COLOR_TRACK = -12961222;
        private static final int COLOR_TRACK_FILLED = -5212112;
        private static final int COLOR_HANDLE = -1;
        private static final int COLOR_HANDLE_HOVERED = -8824;
        private final int min;
        private final int max;
        private final int step;
        private final String suffix;
        private boolean dragging;

        public Element(Option<Integer> option, Dim2i dim, int min, int max, int step, String suffix) {
            super(option, dim);
            this.min = min;
            this.max = max;
            this.step = step;
            this.suffix = suffix;
        }

        @Override
        protected void renderControl(class_332 graphics, int mouseX, int mouseY, float partialTick) {
            Dim2i controlDim = this.getControlDim();
            int sliderX = controlDim.x();
            int sliderY = this.dim.y() + (this.dim.height() - 6) / 2;
            boolean enabled = this.option.isAvailable();
            int value = (Integer)this.option.getValue();
            float progress = (float)(value - this.min) / (float)(this.max - this.min);
            this.drawRect(graphics, sliderX, sliderY, sliderX + 100, sliderY + 6, -12961222);
            int filledWidth = (int)(100.0f * progress);
            if (filledWidth > 0) {
                this.drawRect(graphics, sliderX, sliderY, sliderX + filledWidth, sliderY + 6, enabled ? -5212112 : -8363968);
            }
            int handleX = sliderX + filledWidth - 4;
            int handleY = this.dim.y() + (this.dim.height() - 14) / 2;
            boolean handleHovered = this.isMouseOverHandle(mouseX, mouseY, handleX);
            int handleColor = handleHovered || this.dragging ? -8824 : -1;
            this.drawRect(graphics, handleX, handleY, handleX + 8, handleY + 14, handleColor);
            this.drawBorder(graphics, handleX, handleY, handleX + 8, handleY + 14, this.focused ? -1 : -12566464);
            class_5250 valueText = class_2561.method_43470((String)(value + this.suffix));
            int textX = sliderX - 8 - this.getStringWidth((class_5348)valueText);
            int textY = this.dim.y() + (this.dim.height() - 8) / 2;
            this.drawString(graphics, (class_2561)valueText, textX, textY, enabled ? -1 : -8355712);
        }

        private boolean isMouseOverHandle(double mouseX, double mouseY, int handleX) {
            int handleY = this.dim.y() + (this.dim.height() - 14) / 2;
            return mouseX >= (double)handleX && mouseX < (double)(handleX + 8) && mouseY >= (double)handleY && mouseY < (double)(handleY + 14);
        }

        @Override
        protected Dim2i getControlDim() {
            int controlX = this.dim.x() + this.dim.width() - 100 - 6;
            int controlY = this.dim.y() + (this.dim.height() - 6) / 2;
            return new Dim2i(controlX, controlY, 100, 6);
        }

        public boolean method_25402(double mouseX, double mouseY, int button) {
            if (!this.option.isAvailable()) {
                return false;
            }
            if (button == 0 && this.isMouseOverControl(mouseX, mouseY)) {
                this.dragging = true;
                this.updateValue(mouseX);
                this.playClickSound();
                return true;
            }
            return false;
        }

        public boolean method_25403(double mouseX, double mouseY, int button, double dragX, double dragY) {
            if (this.dragging) {
                this.updateValue(mouseX);
                return true;
            }
            return false;
        }

        public boolean method_25406(double mouseX, double mouseY, int button) {
            if (this.dragging) {
                this.dragging = false;
                return true;
            }
            return false;
        }

        public boolean method_25401(double mouseX, double mouseY, double scrollX, double scrollY) {
            if (!this.option.isAvailable()) {
                return false;
            }
            if (this.isMouseOverControl(mouseX, mouseY)) {
                int value = (Integer)this.option.getValue();
                if (scrollY > 0.0) {
                    value = Math.min(this.max, value + this.step);
                } else if (scrollY < 0.0) {
                    value = Math.max(this.min, value - this.step);
                }
                this.option.setValue(value);
                return true;
            }
            return false;
        }

        private void updateValue(double mouseX) {
            Dim2i controlDim = this.getControlDim();
            float progress = class_3532.method_15363((float)((float)(mouseX - (double)controlDim.x()) / 100.0f), (float)0.0f, (float)1.0f);
            int rawValue = this.min + (int)(progress * (float)(this.max - this.min));
            int steppedValue = (rawValue - this.min + this.step / 2) / this.step * this.step + this.min;
            this.option.setValue(class_3532.method_15340((int)steppedValue, (int)this.min, (int)this.max));
        }
    }
}

