/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Option;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2561;

public class OptionGroup {
    private final class_2561 name;
    private final List<Option<?>> options;
    private final boolean collapsed;

    private OptionGroup(class_2561 name, List<Option<?>> options, boolean collapsed) {
        this.name = name;
        this.options = options;
        this.collapsed = collapsed;
    }

    public class_2561 getName() {
        return this.name;
    }

    public List<Option<?>> getOptions() {
        return this.options;
    }

    public boolean isCollapsed() {
        return this.collapsed;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private class_2561 name;
        private final List<Option<?>> options = new ArrayList();
        private boolean collapsed = false;

        public Builder name(class_2561 name) {
            this.name = name;
            return this;
        }

        public Builder name(String key) {
            this.name = class_2561.method_43471((String)key);
            return this;
        }

        public Builder add(Option<?> option) {
            this.options.add(option);
            return this;
        }

        public Builder collapsed(boolean collapsed) {
            this.collapsed = collapsed;
            return this;
        }

        public OptionGroup build() {
            return new OptionGroup(this.name, List.copyOf(this.options), this.collapsed);
        }
    }
}

