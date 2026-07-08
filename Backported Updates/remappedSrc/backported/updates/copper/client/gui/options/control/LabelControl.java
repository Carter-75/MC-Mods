/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.Objects;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_5250;
import net.minecraft.class_5348;

public class LabelControl
implements Control<String> {
    private final Option<String> option;

    public LabelControl(Option<String> option) {
        this.option = option;
    }

    @Override
    public ControlElement<String> createElement(Dim2i dim) {
        return new Element(this.option, dim);
    }

    @Override
    public Option<String> getOption() {
        return this.option;
    }

    @Override
    public int getMaxWidth() {
        return 200;
    }

    private static class Element
    extends ControlElement<String> {
        private static final int TEXT_COLOR = -5592406;

        public Element(Option<String> option, Dim2i dim) {
            super(option, dim);
        }

        @Override
        protected Dim2i getControlDim() {
            int controlWidth = 200;
            return new Dim2i(this.dim.x() + this.dim.width() - controlWidth - 5, this.dim.y(), controlWidth, this.dim.height());
        }

        @Override
        protected void renderControl(class_332 graphics, int mouseX, int mouseY, float partialTick) {
            class_327 font = class_310.method_1551().field_1772;
            String value = (String)this.option.getValue();
            if (value != null && !value.isEmpty()) {
                class_5250 text = class_2561.method_43471((String)value);
                int textWidth = font.method_27525((class_5348)text);
                int x = this.dim.x() + this.dim.width() - textWidth - 5;
                int n = this.dim.y();
                int n2 = this.dim.height();
                Objects.requireNonNull(font);
                int y = n + (n2 - 9) / 2;
                graphics.method_51439(font, (class_2561)text, x, y, -5592406, false);
            }
        }

        public boolean method_25402(double mouseX, double mouseY, int button) {
            return false;
        }

        public boolean method_25404(int keyCode, int scanCode, int modifiers) {
            return false;
        }

        public boolean method_25400(char chr, int modifiers) {
            return false;
        }
    }
}

