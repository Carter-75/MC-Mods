/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.common.api.bundle;

public interface IBundle {
    public void setSelectedItem(int var1);

    default public int getSelectedItem() {
        return -1;
    }

    public int getNumberOfItemsToShow();

    public static interface Mutable {
        public void toggleSelectedItem(int var1);

        public boolean indexIsOutsideAllowedBounds(int var1);
    }
}

