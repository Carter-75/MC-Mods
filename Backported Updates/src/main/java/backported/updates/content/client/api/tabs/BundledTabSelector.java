/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.collection.DefaultedList
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.widget.ClickableWidget
 *  net.minecraft.client.gui.widget.ButtonWidget
 *  net.minecraft.client.gui.widget.ButtonWidget$PressAction
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
 *  net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen$CreativeScreenHandler
 *  net.minecraft.client.gui.tooltip.Tooltip
 *  net.minecraft.client.render.RenderTickCounter
 */
package backported.updates.content.client.api.tabs;

import backported.updates.content.client.api.tabs.BundledTabs;
import backported.updates.content.client.registries.ModBundledTabs;
import backported.updates.content.client.registries.ModCreativeTabs;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.event.screen.HudRendering;
import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported_updates.mixin.access.CreativeModeInventoryScreenAccessor;
import backported_updates.mixin.access.HandledScreenAccessor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.render.RenderTickCounter;

public class BundledTabSelector {
    private static final Identifier SELECTOR_BAR = VanillaBackport.resource("textures/gui/bundled_tabs/interface.png");
    private static final int VISIBLE_CATEGORIES = 5;
    private static BundledTabSelector instance;
    private int guiLeft;
    private int guiTop;
    private int scroll;
    private ClickableWidget scrollUpButton;
    private ClickableWidget scrollDownButton;
    private List<BundledTabs> bundles = null;
    private ItemGroup lastTab;
    private int itemCount;

    public static BundledTabSelector bootstrap() {
        if (instance == null) {
            instance = new BundledTabSelector();
        }
        return instance;
    }

    private BundledTabSelector() {
        HudRendering.POST_INITIALIZE.register(this::init);
        HudRendering.RENDER_BACKGROUND.register(this::renderBackground);
        HudRendering.CLOSE_CONTAINER.register(this::onClose);
    }

    private void init(MinecraftClient minecraft, Screen screen, ScreenAccess access) {
        if (screen instanceof CreativeInventoryScreen) {
            CreativeInventoryScreen creativeScreen = (CreativeInventoryScreen)screen;
            if (this.bundles == null) {
                this.bundles = new ArrayList<BundledTabs>(ModBundledTabs.getTabs());
            }
            this.guiLeft = ((HandledScreenAccessor)creativeScreen).getX();
            this.guiTop = ((HandledScreenAccessor)creativeScreen).getY();
            this.injectWidgets(creativeScreen, access::addRenderableWidget);
            this.itemCount = ModCreativeTabs.VANILLA_BACKPORT.get().getDisplayStacks().size();
        }
    }

    private void renderBackground(MinecraftClient minecraft, HandledScreen<?> screen, DrawContext graphics, int mouseX, int mouseY, RenderTickCounter timer) {
        if (screen instanceof CreativeInventoryScreen) {
            CreativeInventoryScreen creativeScreen = (CreativeInventoryScreen)screen;
            ItemGroup tab = CreativeModeInventoryScreenAccessor.getSelectedTab();
            graphics.getMatrices().push();
            graphics.getMatrices().translate(0.0, 0.0, 0.0);
            if (this.isValidTab(tab)) {
                graphics.drawTexture(SELECTOR_BAR, this.guiLeft - 30, this.guiTop + 2, 0, 0, 30, 120);
                if (this.hasSelectedBundle() && ((CreativeInventoryScreen.CreativeScreenHandler)creativeScreen.getScreenHandler()).itemList.size() == this.itemCount) {
                    this.bundles.forEach(BundledTabs::deselect);
                }
            }
            if (this.lastTab != tab) {
                this.onSwitchCreativeTab(tab, creativeScreen);
                this.lastTab = tab;
            }
            graphics.getMatrices().pop();
        }
    }

    private void onClose(MinecraftClient minecraft, Screen screen) {
        if (screen instanceof CreativeInventoryScreen) {
            this.scrollUpButton = null;
            this.scrollDownButton = null;
            this.bundles.forEach(bundle -> {
                bundle.setContentTab(null);
                bundle.deselect();
            });
        }
    }

    private boolean hasSelectedBundle() {
        return this.bundles != null && this.bundles.stream().anyMatch(BundledTabs::isSelected);
    }

    private void injectWidgets(CreativeInventoryScreen screen, Consumer<ClickableWidget> widgets) {
        this.bundles.forEach(category -> {
            Tab tab = new Tab(this.guiLeft - 23, this.guiTop + 7, (BundledTabs)category, button -> {
                if (category.isSelected()) {
                    category.deselect();
                } else {
                    this.bundles.forEach(BundledTabs::deselect);
                    category.select();
                }
                this.updateItems(screen);
            });
            tab.visible = false;
            widgets.accept((ClickableWidget)tab);
        });
        this.scrollUpButton = new ScrollButton(this.guiLeft - 24, this.guiTop + 6, 32, b -> {
            if (this.scroll > 0) {
                --this.scroll;
            }
            this.updateWidgets();
        });
        this.scrollDownButton = new ScrollButton(this.guiLeft - 24, this.guiTop + 108, 52, b -> {
            if (this.scroll < this.getMaxScroll()) {
                ++this.scroll;
            }
            this.updateWidgets();
        });
        widgets.accept(this.scrollUpButton);
        widgets.accept(this.scrollDownButton);
        this.updateWidgets();
        this.onSwitchCreativeTab(CreativeModeInventoryScreenAccessor.getSelectedTab(), screen);
    }

    private int getMaxScroll() {
        return Math.max(0, this.bundles.size() - 5);
    }

    private void updateItems(CreativeInventoryScreen screen) {
        HashSet seen = new HashSet();
        LinkedHashSet display = new LinkedHashSet();
        boolean hasSelection = this.hasSelectedBundle();
        ModCreativeTabs.VANILLA_BACKPORT.get().getDisplayStacks().forEach(stack -> {
            if (!hasSelection) {
                if (seen.add(stack)) {
                    display.add(stack.copy());
                }
            } else {
                this.bundles.stream().filter(BundledTabs::isSelected).filter(bundle -> bundle.contains((ItemStack)stack)).findFirst().ifPresent(bundle -> {
                    if (seen.add(stack)) {
                        display.add(stack.copy());
                    }
                });
            }
        });
        DefaultedList items = ((CreativeInventoryScreen.CreativeScreenHandler)screen.getScreenHandler()).itemList;
        items.clear();
        items.addAll(display);
        ((CreativeInventoryScreen.CreativeScreenHandler)screen.getScreenHandler()).scrollItems(0.0f);
    }

    private void updateWidgets() {
        this.bundles.forEach(bundle -> bundle.setVisible(false));
        for (int i = this.scroll; i < this.scroll + 5 && i < this.bundles.size(); ++i) {
            BundledTabs bundle2 = this.bundles.get(i);
            bundle2.setY(this.guiTop + 18 * (i - this.scroll) + 18);
            bundle2.setVisible(true);
        }
        boolean isValidTab = this.isValidTab(CreativeModeInventoryScreenAccessor.getSelectedTab());
        this.scrollUpButton.visible = isValidTab && this.scroll > 0;
        this.scrollDownButton.visible = isValidTab && this.scroll < this.getMaxScroll();
    }

    private void onSwitchCreativeTab(ItemGroup tab, CreativeInventoryScreen screen) {
        if (this.isValidTab(tab)) {
            this.updateWidgets();
            this.updateItems(screen);
        } else {
            this.scrollUpButton.visible = false;
            this.scrollDownButton.visible = false;
            this.bundles.forEach(bundle -> bundle.setVisible(false));
        }
    }

    private boolean isValidTab(ItemGroup tab) {
        return tab == ModCreativeTabs.VANILLA_BACKPORT.get();
    }

    public static class ScrollButton
    extends ButtonWidget {
        private final int uOffset;

        public ScrollButton(int x, int y, int uOffset, ButtonWidget.PressAction onPress) {
            super(x, y, 18, 20, (Text)Text.empty(), onPress, DEFAULT_NARRATION_SUPPLIER);
            this.uOffset = uOffset;
        }

        public void renderWidget(DrawContext graphics, int mouseX, int mouseY, float partialTicks) {
            int textureY = this.hovered ? 12 : 0;
            graphics.getMatrices().push();
            graphics.getMatrices().translate(0.0, 0.0, 20.0);
            graphics.drawTexture(SELECTOR_BAR, this.getX(), this.getY(), this.uOffset, textureY, 18, 11);
            graphics.getMatrices().pop();
        }
    }

    public static class Tab
    extends ButtonWidget {
        private final BundledTabs bundle;

        protected Tab(int x, int y, BundledTabs bundle, ButtonWidget.PressAction onPress) {
            super(x, y, 16, 16, (Text)Text.empty(), onPress, DEFAULT_NARRATION_SUPPLIER);
            this.bundle = bundle;
            bundle.setContentTab(this);
            this.setTooltip(Tooltip.of((Text)bundle.getTooltip()));
        }

        protected void renderWidget(DrawContext graphics, int mouseX, int mouseY, float partialTick) {
            graphics.getMatrices().push();
            graphics.getMatrices().translate(0.0, 0.0, 20.0);
            this.renderSelected(graphics);
            graphics.drawItem(this.bundle.getIcon(), this.getX(), this.getY());
            graphics.getMatrices().pop();
            this.renderHighlight(graphics);
        }

        private void renderSelected(DrawContext graphics) {
            if (this.bundle.isSelected()) {
                graphics.drawTexture(SELECTOR_BAR, this.getX() - 7, this.getY() - 1, 36, 24, 30, 19);
            }
        }

        private void renderHighlight(DrawContext graphics) {
            if (this.isHovered() && !this.bundle.isSelected()) {
                graphics.getMatrices().push();
                graphics.getMatrices().translate(0.0, 0.0, 20.0);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                graphics.drawTexture(SELECTOR_BAR, this.getX(), this.getY(), 32, 44, 16, 16);
                RenderSystem.disableBlend();
                graphics.getMatrices().pop();
            }
        }
    }
}

