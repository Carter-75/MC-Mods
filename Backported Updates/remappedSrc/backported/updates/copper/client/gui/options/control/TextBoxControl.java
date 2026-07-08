/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_5348;
import net.minecraft.class_5481;

public class TextBoxControl
implements Control<String> {
    private static final int PADDING = 6;
    private static final int PARAGRAPH_SPACING = 6;
    private final Option<String> option;

    public TextBoxControl(Option<String> option) {
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
        return 0;
    }

    @Override
    public int getHeight(int availableWidth) {
        return TextBoxControl.calculateHeight(this.option.getValue(), availableWidth);
    }

    private static int calculateHeight(String translationKey, int availableWidth) {
        if (translationKey == null || translationKey.isEmpty()) {
            return 18;
        }
        class_327 font = class_310.method_1551().field_1772;
        String text = class_2561.method_43471((String)translationKey).getString();
        int maxWidth = availableWidth - 12;
        String[] paragraphs = text.split("\n");
        int totalHeight = 6;
        for (int i = 0; i < paragraphs.length; ++i) {
            String paragraph = paragraphs[i].trim();
            if (paragraph.isEmpty()) {
                totalHeight += 6;
                continue;
            }
            List lines = font.method_1728((class_5348)class_2561.method_43470((String)paragraph), maxWidth);
            int n = lines.size();
            Objects.requireNonNull(font);
            totalHeight += n * (9 + 2);
            if (i >= paragraphs.length - 1) continue;
            totalHeight += 6;
        }
        return Math.max(18, totalHeight += 6);
    }

    private static class Element
    extends ControlElement<String> {
        private static final int TEXT_COLOR = -5592406;

        public Element(Option<String> option, Dim2i dim) {
            super(option, dim);
        }

        @Override
        protected Dim2i getControlDim() {
            return new Dim2i(this.dim.x(), this.dim.y(), 0, 0);
        }

        @Override
        public void method_25394(class_332 graphics, int mouseX, int mouseY, float partialTick) {
            this.hovered = this.dim.containsCursor(mouseX, mouseY);
            int bgColor = this.hovered ? -536870912 : -1879048192;
            this.drawRect(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), bgColor);
            class_327 font = class_310.method_1551().field_1772;
            String value = (String)this.option.getValue();
            if (value != null && !value.isEmpty()) {
                String text = class_2561.method_43471((String)value).getString();
                int maxWidth = this.dim.width() - 12;
                String[] paragraphs = text.split("\n");
                int y = this.dim.y() + 6;
                for (int i = 0; i < paragraphs.length; ++i) {
                    String paragraph = paragraphs[i].trim();
                    if (paragraph.isEmpty()) {
                        y += 6;
                        continue;
                    }
                    List lines = font.method_1728((class_5348)class_2561.method_43470((String)paragraph), maxWidth);
                    for (class_5481 line : lines) {
                        graphics.method_51430(font, line, this.dim.x() + 6, y, -5592406, false);
                        Objects.requireNonNull(font);
                        y += 9 + 2;
                    }
                    if (i >= paragraphs.length - 1) continue;
                    y += 6;
                }
            }
            if (this.focused) {
                this.drawBorder(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), -1);
            }
        }

        @Override
        protected void renderControl(class_332 graphics, int mouseX, int mouseY, float partialTick) {
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

