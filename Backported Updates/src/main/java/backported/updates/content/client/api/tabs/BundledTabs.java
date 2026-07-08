/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.text.Text
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.client.api.tabs;

import backported.updates.content.client.api.tabs.BundledTabSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.text.Text;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

public class BundledTabs {
    private final Text tooltip;
    private final ItemStack icon;
    private final List<ItemStack> displayItems;
    @Nullable
    private final BiConsumer<RegistryWrapper.WrapperLookup, Output> provider;
    private boolean populated;
    @Nullable
    private BundledTabSelector.Tab tab;
    private boolean selected;

    private BundledTabs(Text tooltip, ItemStack icon, List<ItemStack> staticItems, @Nullable BiConsumer<RegistryWrapper.WrapperLookup, Output> provider) {
        this.tooltip = tooltip;
        this.icon = icon;
        this.displayItems = staticItems;
        this.provider = provider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Text getTooltip() {
        return this.tooltip;
    }

    public ItemStack getIcon() {
        return this.icon;
    }

    public List<ItemStack> getDisplayItems() {
        return Collections.unmodifiableList(this.displayItems);
    }

    public boolean contains(ItemStack stack) {
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
            this.tab.visible = visible;
        }
    }

    public void setY(int y) {
        if (this.tab != null) {
            this.tab.setY(y);
        }
    }

    public void populate(RegistryWrapper.WrapperLookup provider) {
        if (this.populated || this.provider == null) {
            return;
        }
        this.provider.accept(provider, new Output(){

            @Override
            public void accept(ItemConvertible item) {
                BundledTabs.this.displayItems.add(new ItemStack(item));
            }

            @Override
            public void accept(ItemStack stack) {
                BundledTabs.this.displayItems.add(stack);
            }
        });
        this.populated = true;
    }

    public static class Builder {
        private Text title;
        private ItemStack icon;
        private BiConsumer<RegistryWrapper.WrapperLookup, Output> provider;

        public Builder title(Text title) {
            this.title = title;
            return this;
        }

        public Builder icon(ItemStack icon) {
            this.icon = icon;
            return this;
        }

        public Builder displayItems(BiConsumer<RegistryWrapper.WrapperLookup, Output> provider) {
            this.provider = provider;
            return this;
        }

        public BundledTabs build() {
            if (this.title == null) {
                this.title = Text.empty();
            }
            if (this.icon == null) {
                this.icon = ItemStack.EMPTY;
            }
            return new BundledTabs(this.title, this.icon, new ArrayList<ItemStack>(), this.provider);
        }
    }

    public static interface Output {
        public void accept(ItemConvertible var1);

        public void accept(ItemStack var1);
    }
}

