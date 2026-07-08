/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Control;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public interface Option<T> {
    public Text getName();

    @Nullable
    public Text getTooltip();

    public Control<T> getControl();

    public T getValue();

    public void setValue(T var1);

    public T getDefaultValue();

    public void reset();

    public boolean hasChanged();

    public boolean isAvailable();

    public void applyChanges();
}

