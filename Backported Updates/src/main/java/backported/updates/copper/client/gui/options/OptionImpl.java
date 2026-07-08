/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class OptionImpl<T>
implements Option<T> {
    private final Text name;
    private final Supplier<Text> tooltipSupplier;
    private final Control<T> control;
    private final Supplier<T> getter;
    private final Consumer<T> setter;
    private final T defaultValue;
    private final BooleanSupplier available;
    private T value;
    private T modifiedValue;

    private OptionImpl(Builder<T> builder) {
        this.name = builder.name;
        this.tooltipSupplier = builder.tooltipSupplier;
        this.getter = builder.getter;
        this.setter = builder.setter;
        this.defaultValue = builder.defaultValue;
        this.available = builder.available;
        this.control = builder.controlProvider.apply(this);
        this.value = this.getter.get();
        this.modifiedValue = this.value;
    }

    @Override
    public Text getName() {
        return this.name;
    }

    @Override
    @Nullable
    public Text getTooltip() {
        return this.tooltipSupplier != null ? this.tooltipSupplier.get() : null;
    }

    @Override
    public Control<T> getControl() {
        return this.control;
    }

    @Override
    public T getValue() {
        return this.modifiedValue;
    }

    @Override
    public void setValue(T value) {
        this.modifiedValue = value;
    }

    @Override
    public T getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public void reset() {
        this.value = this.getter.get();
        this.modifiedValue = this.value;
    }

    @Override
    public boolean hasChanged() {
        return !this.value.equals(this.modifiedValue);
    }

    @Override
    public boolean isAvailable() {
        return this.available.getAsBoolean();
    }

    @Override
    public void applyChanges() {
        this.setter.accept(this.modifiedValue);
        this.value = this.modifiedValue;
    }

    public static <T> Builder<T> builder(Class<T> type) {
        return new Builder();
    }

    public static class Builder<T> {
        private Text name;
        private Supplier<Text> tooltipSupplier;
        private Function<Option<T>, Control<T>> controlProvider;
        private Supplier<T> getter;
        private Consumer<T> setter;
        private T defaultValue;
        private BooleanSupplier available = () -> true;

        public Builder<T> name(Text name) {
            this.name = name;
            return this;
        }

        public Builder<T> name(String key) {
            this.name = Text.translatable((String)key);
            return this;
        }

        public Builder<T> tooltip(Text tooltip) {
            this.tooltipSupplier = () -> tooltip;
            return this;
        }

        public Builder<T> tooltip(String key) {
            this.tooltipSupplier = () -> Text.translatable((String)key);
            return this;
        }

        public Builder<T> tooltipSupplier(Supplier<Text> supplier) {
            this.tooltipSupplier = supplier;
            return this;
        }

        public Builder<T> control(Function<Option<T>, Control<T>> provider) {
            this.controlProvider = provider;
            return this;
        }

        public Builder<T> binding(Supplier<T> getter, Consumer<T> setter) {
            this.getter = getter;
            this.setter = setter;
            return this;
        }

        public Builder<T> defaultValue(T value) {
            this.defaultValue = value;
            return this;
        }

        public Builder<T> available(BooleanSupplier available) {
            this.available = available;
            return this;
        }

        public Option<T> build() {
            if (this.name == null) {
                throw new IllegalStateException("Option name is required");
            }
            if (this.getter == null || this.setter == null) {
                throw new IllegalStateException("Binding is required");
            }
            if (this.controlProvider == null) {
                throw new IllegalStateException("Control is required");
            }
            return new OptionImpl(this);
        }
    }
}

