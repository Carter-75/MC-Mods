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
import java.util.function.IntSupplier;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_5250;
import net.minecraft.class_5348;

public class IntegerFieldControl
implements Control<Integer> {
    private final Option<Integer> option;
    private final int minValue;
    private final int maxValue;
    private final IntSupplier dynamicMin;
    private final ValueFormatter formatter;

    public IntegerFieldControl(Option<Integer> option, int min, int max, ValueFormatter formatter) {
        this.option = option;
        this.minValue = min;
        this.maxValue = max;
        this.dynamicMin = null;
        this.formatter = formatter;
    }

    public IntegerFieldControl(Option<Integer> option, IntSupplier dynamicMin, int max, ValueFormatter formatter) {
        this.option = option;
        this.minValue = 0;
        this.maxValue = max;
        this.dynamicMin = dynamicMin;
        this.formatter = formatter;
    }

    @Override
    public ControlElement<Integer> createElement(Dim2i dim) {
        return new Element(this.option, dim, this.minValue, this.maxValue, this.dynamicMin, this.formatter);
    }

    @Override
    public Option<Integer> getOption() {
        return this.option;
    }

    @Override
    public int getMaxWidth() {
        return 100;
    }

    @FunctionalInterface
    public static interface ValueFormatter {
        public class_2561 format(int var1);

        public static ValueFormatter realMinutes() {
            return value -> {
                float minutes = (float)value / 1200.0f;
                if (minutes == (float)((int)minutes)) {
                    return class_2561.method_43469((String)"config.copperagebackport.minutes", (Object[])new Object[]{(int)minutes});
                }
                return class_2561.method_43469((String)"config.copperagebackport.minutes_decimal", (Object[])new Object[]{String.format("%.1f", Float.valueOf(minutes))});
            };
        }

        public static ValueFormatter percentage() {
            return value -> class_2561.method_43470((String)(value + "%"));
        }

        public static ValueFormatter withSuffix(String suffix) {
            return value -> class_2561.method_43470((String)(value + " " + suffix));
        }

        public static ValueFormatter number() {
            return value -> class_2561.method_43470((String)String.valueOf(value));
        }
    }

    private static class Element
    extends ControlElement<Integer> {
        private static final int FIELD_WIDTH = 70;
        private static final int FIELD_HEIGHT = 16;
        private static final int COLOR_BACKGROUND = -14803426;
        private static final int COLOR_BORDER = -11908534;
        private static final int COLOR_BORDER_FOCUSED = -5212112;
        private static final int COLOR_BORDER_ERROR = -48060;
        private static final int COLOR_TEXT = -1;
        private static final int COLOR_TEXT_DISABLED = -8355712;
        private static final int COLOR_CURSOR = -1;
        private static final int COLOR_SELECTION = -13408564;
        private static final int COLOR_HINT = -7829368;
        private final int minValue;
        private final int maxValue;
        private final IntSupplier dynamicMin;
        private final ValueFormatter formatter;
        private String text;
        private int cursorPosition;
        private int selectionStart;
        private int selectionEnd;
        private boolean editing;
        private boolean hasError;
        private boolean justStartedEditing;

        public Element(Option<Integer> option, Dim2i dim, int min, int max, IntSupplier dynamicMin, ValueFormatter formatter) {
            super(option, dim);
            this.minValue = min;
            this.maxValue = max;
            this.dynamicMin = dynamicMin;
            this.formatter = formatter;
            this.text = String.valueOf(option.getValue());
            this.cursorPosition = this.text.length();
            this.selectionStart = 0;
            this.selectionEnd = 0;
        }

        private int getEffectiveMin() {
            return this.dynamicMin != null ? Math.max(this.minValue, this.dynamicMin.getAsInt()) : this.minValue;
        }

        @Override
        protected void renderControl(class_332 graphics, int mouseX, int mouseY, float partialTick) {
            int hintX;
            Dim2i controlDim = this.getControlDim();
            int fieldX = controlDim.x();
            int fieldY = this.dim.y() + (this.dim.height() - 16) / 2;
            boolean enabled = this.option.isAvailable();
            int effectiveMin = this.getEffectiveMin();
            this.hasError = false;
            if (this.editing) {
                try {
                    int value = Integer.parseInt(this.text);
                    this.hasError = value < effectiveMin || value > this.maxValue;
                }
                catch (NumberFormatException e) {
                    this.hasError = !this.text.isEmpty();
                }
            } else {
                int currentValue = (Integer)this.option.getValue();
                this.hasError = currentValue < effectiveMin || currentValue > this.maxValue;
            }
            this.drawRect(graphics, fieldX, fieldY, fieldX + 70, fieldY + 16, -14803426);
            int borderColor = this.hasError ? -48060 : (this.editing ? -5212112 : -11908534);
            this.drawBorder(graphics, fieldX, fieldY, fieldX + 70, fieldY + 16, borderColor);
            String displayText = this.editing ? this.text : String.valueOf(this.option.getValue());
            int textColor = enabled ? -1 : -8355712;
            int textX = fieldX + 4;
            int textY = fieldY + 4;
            if (this.editing && this.selectionStart != this.selectionEnd) {
                int selStart = Math.min(this.selectionStart, this.selectionEnd);
                int selEnd = Math.max(this.selectionStart, this.selectionEnd);
                String beforeSel = displayText.substring(0, Math.min(selStart, displayText.length()));
                String selText = displayText.substring(Math.min(selStart, displayText.length()), Math.min(selEnd, displayText.length()));
                int selX1 = textX + this.font.method_1727(beforeSel);
                int selX2 = selX1 + this.font.method_1727(selText);
                this.drawRect(graphics, selX1, textY - 1, selX2, textY + 9, -13408564);
            }
            this.drawString(graphics, displayText, textX, textY, textColor);
            if (this.editing) {
                String beforeCursor = displayText.substring(0, Math.min(this.cursorPosition, displayText.length()));
                int cursorX = textX + this.font.method_1727(beforeCursor);
                this.drawRect(graphics, cursorX, textY - 1, cursorX + 1, textY + 9, -1);
            }
            if (this.formatter != null && !this.editing && !this.hasError) {
                class_2561 hint = this.formatter.format((Integer)this.option.getValue());
                hintX = fieldX - 8 - this.getStringWidth((class_5348)hint);
                this.drawString(graphics, hint, hintX, textY, -7829368);
            }
            if (this.hasError) {
                class_5250 errorHint = class_2561.method_43470((String)("Min: " + effectiveMin));
                hintX = fieldX - 8 - this.getStringWidth((class_5348)errorHint);
                this.drawString(graphics, (class_2561)errorHint, hintX, textY, -48060);
            }
        }

        @Override
        protected Dim2i getControlDim() {
            int controlX = this.dim.x() + this.dim.width() - 70 - 6;
            int controlY = this.dim.y() + (this.dim.height() - 16) / 2;
            return new Dim2i(controlX, controlY, 70, 16);
        }

        public boolean method_25402(double mouseX, double mouseY, int button) {
            if (!this.option.isAvailable()) {
                return false;
            }
            boolean clickedOnElement = this.dim.containsCursor(mouseX, mouseY);
            if (button == 0 && clickedOnElement) {
                if (!this.editing) {
                    this.startEditing();
                    this.playClickSound();
                } else if (this.isMouseOverControl(mouseX, mouseY)) {
                    Dim2i controlDim = this.getControlDim();
                    int relX = (int)mouseX - controlDim.x() - 4;
                    this.selectionStart = this.cursorPosition = this.getCharIndexAtX(relX);
                    this.selectionEnd = this.cursorPosition;
                } else {
                    this.finishEditing();
                }
                return true;
            }
            if (this.editing) {
                this.finishEditing();
            }
            return false;
        }

        private int getCharIndexAtX(int x) {
            int charWidth;
            int idx;
            int width = 0;
            for (idx = 0; idx < this.text.length() && width + (charWidth = this.font.method_1727(String.valueOf(this.text.charAt(idx)))) / 2 <= x; ++idx) {
                width += charWidth;
            }
            return idx;
        }

        private void startEditing() {
            this.justStartedEditing = true;
            this.editing = true;
            this.text = String.valueOf(this.option.getValue());
            this.cursorPosition = this.text.length();
            this.selectionStart = 0;
            this.selectionEnd = this.text.length();
        }

        private void finishEditing() {
            this.editing = false;
            try {
                int value = Integer.parseInt(this.text);
                int effectiveMin = this.getEffectiveMin();
                value = class_3532.method_15340((int)value, (int)effectiveMin, (int)this.maxValue);
                this.option.setValue(value);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            this.text = String.valueOf(this.option.getValue());
        }

        public boolean method_25404(int keyCode, int scanCode, int modifiers) {
            if (!this.editing) {
                if (this.focused && (keyCode == 257 || keyCode == 335)) {
                    this.startEditing();
                    return true;
                }
                return false;
            }
            boolean ctrl = (modifiers & 2) != 0;
            switch (keyCode) {
                case 259: {
                    if (this.hasSelection()) {
                        this.deleteSelection();
                    } else if (this.cursorPosition > 0) {
                        this.text = this.text.substring(0, this.cursorPosition - 1) + this.text.substring(this.cursorPosition);
                        --this.cursorPosition;
                    }
                    this.clearSelection();
                    return true;
                }
                case 261: {
                    if (this.hasSelection()) {
                        this.deleteSelection();
                    } else if (this.cursorPosition < this.text.length()) {
                        this.text = this.text.substring(0, this.cursorPosition) + this.text.substring(this.cursorPosition + 1);
                    }
                    this.clearSelection();
                    return true;
                }
                case 263: {
                    if (this.cursorPosition > 0) {
                        --this.cursorPosition;
                    }
                    if ((modifiers & 1) == 0) {
                        this.clearSelection();
                    } else {
                        this.selectionEnd = this.cursorPosition;
                    }
                    return true;
                }
                case 262: {
                    if (this.cursorPosition < this.text.length()) {
                        ++this.cursorPosition;
                    }
                    if ((modifiers & 1) == 0) {
                        this.clearSelection();
                    } else {
                        this.selectionEnd = this.cursorPosition;
                    }
                    return true;
                }
                case 268: {
                    this.cursorPosition = 0;
                    if ((modifiers & 1) == 0) {
                        this.clearSelection();
                    } else {
                        this.selectionEnd = this.cursorPosition;
                    }
                    return true;
                }
                case 269: {
                    this.cursorPosition = this.text.length();
                    if ((modifiers & 1) == 0) {
                        this.clearSelection();
                    } else {
                        this.selectionEnd = this.cursorPosition;
                    }
                    return true;
                }
                case 257: 
                case 335: {
                    this.finishEditing();
                    return true;
                }
                case 256: {
                    this.text = String.valueOf(this.option.getValue());
                    this.editing = false;
                    return true;
                }
                case 65: {
                    if (!ctrl) break;
                    this.selectionStart = 0;
                    this.selectionEnd = this.text.length();
                    this.cursorPosition = this.text.length();
                    return true;
                }
            }
            return false;
        }

        public boolean method_25400(char chr, int modifiers) {
            if (!this.editing) {
                return false;
            }
            if (Character.isDigit(chr) || chr == '-' && this.cursorPosition == 0 && !this.text.contains("-")) {
                if (this.hasSelection()) {
                    this.deleteSelection();
                }
                this.text = this.text.substring(0, this.cursorPosition) + chr + this.text.substring(this.cursorPosition);
                ++this.cursorPosition;
                this.clearSelection();
                return true;
            }
            return false;
        }

        private boolean hasSelection() {
            return this.selectionStart != this.selectionEnd;
        }

        private void clearSelection() {
            this.selectionStart = this.cursorPosition;
            this.selectionEnd = this.cursorPosition;
        }

        private void deleteSelection() {
            int start = Math.min(this.selectionStart, this.selectionEnd);
            int end = Math.max(this.selectionStart, this.selectionEnd);
            this.text = this.text.substring(0, start) + this.text.substring(end);
            this.cursorPosition = start;
            this.clearSelection();
        }

        public boolean method_25401(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
            if (!this.option.isAvailable()) {
                return false;
            }
            if (this.isMouseOverControl(mouseX, mouseY) || this.editing) {
                int effectiveMin = this.getEffectiveMin();
                int current = (Integer)this.option.getValue();
                int step = 24000;
                if (verticalAmount > 0.0) {
                    this.option.setValue(Math.min(this.maxValue, current + step));
                } else if (verticalAmount < 0.0) {
                    this.option.setValue(Math.max(effectiveMin, current - step));
                }
                if (!this.editing) {
                    this.text = String.valueOf(this.option.getValue());
                }
                return true;
            }
            return false;
        }

        @Override
        public void method_25365(boolean focused) {
            super.method_25365(focused);
            if (!focused && this.editing) {
                if (this.justStartedEditing) {
                    this.justStartedEditing = false;
                    return;
                }
                this.finishEditing();
            }
            if (focused) {
                this.justStartedEditing = false;
            }
        }
    }
}

