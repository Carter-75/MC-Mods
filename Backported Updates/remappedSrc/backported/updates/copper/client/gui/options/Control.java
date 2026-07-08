/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.Dim2i;

public interface Control<T> {
    public ControlElement<T> createElement(Dim2i var1);

    public Option<T> getOption();

    public int getMaxWidth();

    default public int getHeight(int availableWidth) {
        return 18;
    }
}

