/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 */
package backported.updates.copper.client.gui.widget;

import backported.updates.copper.client.gui.widget.AbstractWidget;
import backported.updates.copper.client.gui.widget.Dim2i;
import java.util.function.Consumer;
import net.minecraft.class_332;
import net.minecraft.class_3532;

public class ScrollBarWidget
extends AbstractWidget {
    private static final int SCROLL_STEP = 18;
    private final Dim2i dim;
    private final int contentHeight;
    private final int visibleHeight;
    private final int maxOffset;
    private final Consumer<Integer> onScroll;
    private final Dim2i scrollArea;
    private int offset = 0;
    private boolean dragging = false;
    private int dragOffset = 0;
    private Dim2i thumbDim;

    public ScrollBarWidget(Dim2i dim, int contentHeight, int visibleHeight, Consumer<Integer> onScroll, Dim2i scrollArea) {
        this.dim = dim;
        this.contentHeight = contentHeight;
        this.visibleHeight = visibleHeight;
        this.maxOffset = Math.max(0, contentHeight - visibleHeight);
        this.onScroll = onScroll;
        this.scrollArea = scrollArea;
        this.updateThumb();
    }

    private void updateThumb() {
        if (this.maxOffset <= 0) {
            this.thumbDim = new Dim2i(this.dim.x() + 2, this.dim.y() + 2, this.dim.width() - 4, this.dim.height() - 4);
            return;
        }
        int trackHeight = this.dim.height() - 4;
        int thumbHeight = Math.max(20, this.visibleHeight * trackHeight / this.contentHeight);
        int maxThumbOffset = trackHeight - thumbHeight;
        int thumbOffset = this.offset * maxThumbOffset / this.maxOffset;
        this.thumbDim = new Dim2i(this.dim.x() + 2, this.dim.y() + 2 + thumbOffset, this.dim.width() - 4, thumbHeight);
    }

    public void method_25394(class_332 graphics, int mouseX, int mouseY, float partialTick) {
        if (this.maxOffset <= 0) {
            return;
        }
        this.drawRect(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), 0x40000000);
        this.drawBorder(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), -12566464);
        int thumbColor = this.hovered || this.dragging ? -3355444 : -5592406;
        this.drawRect(graphics, this.thumbDim.x(), this.thumbDim.y(), this.thumbDim.getLimitX(), this.thumbDim.getLimitY(), thumbColor);
        if (this.focused) {
            this.drawBorder(graphics, this.dim.x(), this.dim.y(), this.dim.getLimitX(), this.dim.getLimitY(), -1);
        }
        this.hovered = this.dim.containsCursor(mouseX, mouseY);
    }

    public boolean method_25402(double mouseX, double mouseY, int button) {
        if (button != 0 || this.maxOffset <= 0) {
            return false;
        }
        if (this.dim.containsCursor(mouseX, mouseY)) {
            if (this.thumbDim.containsCursor(mouseX, mouseY)) {
                this.dragging = true;
                this.dragOffset = (int)(mouseY - (double)this.thumbDim.getCenterY());
            } else {
                int trackHeight = this.dim.height() - 4;
                int thumbHeight = this.thumbDim.height();
                int clickPos = (int)(mouseY - (double)this.dim.y() - 2.0 - (double)(thumbHeight / 2));
                int newOffset = clickPos * this.maxOffset / (trackHeight - thumbHeight);
                this.setOffset(newOffset);
            }
            return true;
        }
        return false;
    }

    public boolean method_25406(double mouseX, double mouseY, int button) {
        if (button == 0) {
            this.dragging = false;
        }
        return false;
    }

    public boolean method_25403(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.dragging && this.maxOffset > 0) {
            int trackHeight = this.dim.height() - 4;
            int thumbHeight = this.thumbDim.height();
            int dragPos = (int)(mouseY - (double)this.dragOffset - (double)this.dim.y() - 2.0 - (double)(thumbHeight / 2));
            int newOffset = dragPos * this.maxOffset / (trackHeight - thumbHeight);
            this.setOffset(newOffset);
            return true;
        }
        return false;
    }

    public boolean method_25401(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.maxOffset <= 0) {
            return false;
        }
        if (this.dim.containsCursor(mouseX, mouseY) || this.scrollArea != null && this.scrollArea.containsCursor(mouseX, mouseY)) {
            this.setOffset(this.offset - (int)(scrollY * 18.0));
            return true;
        }
        return false;
    }

    public void setOffset(int offset) {
        this.offset = class_3532.method_15340((int)offset, (int)0, (int)this.maxOffset);
        this.updateThumb();
        if (this.onScroll != null) {
            this.onScroll.accept(this.offset);
        }
    }

    public int getOffset() {
        return this.offset;
    }

    public boolean isScrollable() {
        return this.maxOffset > 0;
    }

    public boolean method_25405(double mouseX, double mouseY) {
        return this.dim.containsCursor(mouseX, mouseY);
    }
}

