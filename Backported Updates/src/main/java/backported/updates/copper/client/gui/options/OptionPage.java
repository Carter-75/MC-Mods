/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.OptionGroup;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.text.Text;

public class OptionPage {
    private final Text name;
    private final List<OptionGroup> groups;

    private OptionPage(Text name, List<OptionGroup> groups) {
        this.name = name;
        this.groups = groups;
    }

    public Text getName() {
        return this.name;
    }

    public List<OptionGroup> getGroups() {
        return this.groups;
    }

    public List<Option<?>> getAllOptions() {
        ArrayList allOptions = new ArrayList();
        for (OptionGroup group : this.groups) {
            allOptions.addAll(group.getOptions());
        }
        return allOptions;
    }

    public boolean hasChanges() {
        for (Option<?> option : this.getAllOptions()) {
            if (!option.hasChanged()) continue;
            return true;
        }
        return false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Text name;
        private final List<OptionGroup> groups = new ArrayList<OptionGroup>();

        public Builder name(Text name) {
            this.name = name;
            return this;
        }

        public Builder name(String key) {
            this.name = Text.translatable((String)key);
            return this;
        }

        public Builder add(OptionGroup group) {
            this.groups.add(group);
            return this;
        }

        public OptionPage build() {
            if (this.name == null) {
                throw new IllegalStateException("Page name is required");
            }
            return new OptionPage(this.name, List.copyOf(this.groups));
        }
    }
}

