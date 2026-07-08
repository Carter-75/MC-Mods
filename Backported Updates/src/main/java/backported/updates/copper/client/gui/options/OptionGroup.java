/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Option;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.text.Text;

public class OptionGroup {
    private final Text name;
    private final List<Option<?>> options;
    private final boolean collapsed;

    private OptionGroup(Text name, List<Option<?>> options, boolean collapsed) {
        this.name = name;
        this.options = options;
        this.collapsed = collapsed;
    }

    public Text getName() {
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
        private Text name;
        private final List<Option<?>> options = new ArrayList();
        private boolean collapsed = false;

        public Builder name(Text name) {
            this.name = name;
            return this;
        }

        public Builder name(String key) {
            this.name = Text.translatable((String)key);
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

