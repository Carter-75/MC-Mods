/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.copper.client.gui.widget;

public record Dim2i(int x, int y, int width, int height) {
    public int getLimitX() {
        return this.x + this.width;
    }

    public int getLimitY() {
        return this.y + this.height;
    }

    public boolean containsCursor(double x, double y) {
        return x >= (double)this.x && x < (double)this.getLimitX() && y >= (double)this.y && y < (double)this.getLimitY();
    }

    public int getCenterX() {
        return this.x + this.width / 2;
    }

    public int getCenterY() {
        return this.y + this.height / 2;
    }
}

