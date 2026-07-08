/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 */
package backported.updates.copper.client.gui.options;

import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.OptionGroup;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2561;

public class OptionPage {
    private final class_2561 name;
    private final List<OptionGroup> groups;

    private OptionPage(class_2561 name, List<OptionGroup> groups) {
        this.name = name;
        this.groups = groups;
    }

    public class_2561 getName() {
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
        private class_2561 name;
        private final List<OptionGroup> groups = new ArrayList<OptionGroup>();

        public Builder name(class_2561 name) {
            this.name = name;
            return this;
        }

        public Builder name(String key) {
            this.name = class_2561.method_43471((String)key);
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

