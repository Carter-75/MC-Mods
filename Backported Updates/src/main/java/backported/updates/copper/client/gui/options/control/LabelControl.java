/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.StringVisitable
 */
package backported.updates.copper.client.gui.options.control;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.Objects;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;

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
        protected void renderControl(DrawContext graphics, int mouseX, int mouseY, float partialTick) {
            TextRenderer font = MinecraftClient.getInstance().textRenderer;
            String value = (String)this.option.getValue();
            if (value != null && !value.isEmpty()) {
                MutableText text = Text.translatable((String)value);
                int textWidth = font.getWidth((StringVisitable)text);
                int x = this.dim.x() + this.dim.width() - textWidth - 5;
                int n = this.dim.y();
                int n2 = this.dim.height();
                Objects.requireNonNull(font);
                int y = n + (n2 - 9) / 2;
                graphics.drawText(font, (Text)text, x, y, -5592406, false);
            }
        }

        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            return false;
        }

        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            return false;
        }

        public boolean charTyped(char chr, int modifiers) {
            return false;
        }
    }
}

