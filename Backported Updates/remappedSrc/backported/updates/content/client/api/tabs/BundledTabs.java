/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_2561
 *  net.minecraft.class_7225$class_7874
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.client.api.tabs;

import backported.updates.content.client.api.tabs.BundledTabSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_2561;
import net.minecraft.class_7225;
import org.jetbrains.annotations.Nullable;

public class BundledTabs {
    private final class_2561 tooltip;
    private final class_1799 icon;
    private final List<class_1799> displayItems;
    @Nullable
    private final BiConsumer<class_7225.class_7874, Output> provider;
    private boolean populated;
    @Nullable
    private BundledTabSelector.Tab tab;
    private boolean selected;

    private BundledTabs(class_2561 tooltip, class_1799 icon, List<class_1799> staticItems, @Nullable BiConsumer<class_7225.class_7874, Output> provider) {
        this.tooltip = tooltip;
        this.icon = icon;
        this.displayItems = staticItems;
        this.provider = provider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public class_2561 getTooltip() {
        return this.tooltip;
    }

    public class_1799 getIcon() {
        return this.icon;
    }

    public List<class_1799> getDisplayItems() {
        return Collections.unmodifiableList(this.displayItems);
    }

    public boolean contains(class_1799 stack) {
        return this.displayItems.contains(stack);
    }

    public void select() {
        this.selected = true;
    }

    public void deselect() {
        this.selected = false;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setContentTab(@Nullable BundledTabSelector.Tab tab) {
        this.tab = tab;
    }

    public void setVisible(boolean visible) {
        if (this.tab != null) {
            this.tab.field_22764 = visible;
        }
    }

    public void setY(int y) {
        if (this.tab != null) {
            this.tab.method_46419(y);
        }
    }

    public void populate(class_7225.class_7874 provider) {
        if (this.populated || this.provider == null) {
            return;
        }
        this.provider.accept(provider, new Output(){

            @Override
            public void accept(class_1935 item) {
                BundledTabs.this.displayItems.add(new class_1799(item));
            }

            @Override
            public void accept(class_1799 stack) {
                BundledTabs.this.displayItems.add(stack);
            }
        });
        this.populated = true;
    }

    public static class Builder {
        private class_2561 title;
        private class_1799 icon;
        private BiConsumer<class_7225.class_7874, Output> provider;

        public Builder title(class_2561 title) {
            this.title = title;
            return this;
        }

        public Builder icon(class_1799 icon) {
            this.icon = icon;
            return this;
        }

        public Builder displayItems(BiConsumer<class_7225.class_7874, Output> provider) {
            this.provider = provider;
            return this;
        }

        public BundledTabs build() {
            if (this.title == null) {
                this.title = class_2561.method_43473();
            }
            if (this.icon == null) {
                this.icon = class_1799.field_8037;
            }
            return new BundledTabs(this.title, this.icon, new ArrayList<class_1799>(), this.provider);
        }
    }

    public static interface Output {
        public void accept(class_1935 var1);

        public void accept(class_1799 var1);
    }
}

