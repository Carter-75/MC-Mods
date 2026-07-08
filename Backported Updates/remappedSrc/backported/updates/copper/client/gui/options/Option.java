/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Control;
import net.minecraft.class_2561;
import org.jetbrains.annotations.Nullable;

public interface Option<T> {
    public class_2561 getName();

    @Nullable
    public class_2561 getTooltip();

    public Control<T> getControl();

    public T getValue();

    public void setValue(T var1);

    public T getDefaultValue();

    public void reset();

    public boolean hasChanged();

    public boolean isAvailable();

    public void applyChanges();
}

