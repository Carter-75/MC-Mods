/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1761
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_339
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_4241
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_481
 *  net.minecraft.class_481$class_483
 *  net.minecraft.class_7919
 *  net.minecraft.class_9779
 */
package backported.updates.content.client.api.tabs;

import backported.updates.content.client.api.tabs.BundledTabs;
import backported.updates.content.client.registries.ModBundledTabs;
import backported.updates.content.client.registries.ModCreativeTabs;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.event.screen.HudRendering;
import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported_updates.mixin.access.CreativeModeInventoryScreenAccessor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_339;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_481;
import net.minecraft.class_7919;
import net.minecraft.class_9779;

public class BundledTabSelector {
    private static final class_2960 SELECTOR_BAR = VanillaBackport.resource("textures/gui/bundled_tabs/interface.png");
    private static final int VISIBLE_CATEGORIES = 5;
    private static BundledTabSelector instance;
    private int guiLeft;
    private int guiTop;
    private int scroll;
    private class_339 scrollUpButton;
    private class_339 scrollDownButton;
    private List<BundledTabs> bundles = null;
    private class_1761 lastTab;
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

    private void init(class_310 minecraft, class_437 screen, ScreenAccess access) {
        if (screen instanceof class_481) {
            class_481 creativeScreen = (class_481)screen;
            if (this.bundles == null) {
                this.bundles = new ArrayList<BundledTabs>(ModBundledTabs.getTabs());
            }
            this.guiLeft = creativeScreen.field_2776;
            this.guiTop = creativeScreen.field_2800;
            this.injectWidgets(creativeScreen, access::addRenderableWidget);
            this.itemCount = ModCreativeTabs.VANILLA_BACKPORT.get().method_47313().size();
        }
    }

    private void renderBackground(class_310 minecraft, class_465<?> screen, class_332 graphics, int mouseX, int mouseY, class_9779 timer) {
        if (screen instanceof class_481) {
            class_481 creativeScreen = (class_481)screen;
            class_1761 tab = CreativeModeInventoryScreenAccessor.getSelectedTab();
            graphics.method_51448().method_22903();
            graphics.method_51448().method_22904(0.0, 0.0, 0.0);
            if (this.isValidTab(tab)) {
                graphics.method_25302(SELECTOR_BAR, this.guiLeft - 30, this.guiTop + 2, 0, 0, 30, 120);
                if (this.hasSelectedBundle() && ((class_481.class_483)creativeScreen.method_17577()).field_2897.size() == this.itemCount) {
                    this.bundles.forEach(BundledTabs::deselect);
                }
            }
            if (this.lastTab != tab) {
                this.onSwitchCreativeTab(tab, creativeScreen);
                this.lastTab = tab;
            }
            graphics.method_51448().method_22909();
        }
    }

    private void onClose(class_310 minecraft, class_437 screen) {
        if (screen instanceof class_481) {
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

    private void injectWidgets(class_481 screen, Consumer<class_339> widgets) {
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
            tab.field_22764 = false;
            widgets.accept((class_339)tab);
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

    private void updateItems(class_481 screen) {
        HashSet seen = new HashSet();
        LinkedHashSet display = new LinkedHashSet();
        boolean hasSelection = this.hasSelectedBundle();
        ModCreativeTabs.VANILLA_BACKPORT.get().method_47313().forEach(stack -> {
            if (!hasSelection) {
                if (seen.add(stack)) {
                    display.add(stack.method_7972());
                }
            } else {
                this.bundles.stream().filter(BundledTabs::isSelected).filter(bundle -> bundle.contains((class_1799)stack)).findFirst().ifPresent(bundle -> {
                    if (seen.add(stack)) {
                        display.add(stack.method_7972());
                    }
                });
            }
        });
        class_2371 items = ((class_481.class_483)screen.method_17577()).field_2897;
        items.clear();
        items.addAll(display);
        ((class_481.class_483)screen.method_17577()).method_2473(0.0f);
    }

    private void updateWidgets() {
        this.bundles.forEach(bundle -> bundle.setVisible(false));
        for (int i = this.scroll; i < this.scroll + 5 && i < this.bundles.size(); ++i) {
            BundledTabs bundle2 = this.bundles.get(i);
            bundle2.setY(this.guiTop + 18 * (i - this.scroll) + 18);
            bundle2.setVisible(true);
        }
        boolean isValidTab = this.isValidTab(CreativeModeInventoryScreenAccessor.getSelectedTab());
        this.scrollUpButton.field_22764 = isValidTab && this.scroll > 0;
        this.scrollDownButton.field_22764 = isValidTab && this.scroll < this.getMaxScroll();
    }

    private void onSwitchCreativeTab(class_1761 tab, class_481 screen) {
        if (this.isValidTab(tab)) {
            this.updateWidgets();
            this.updateItems(screen);
        } else {
            this.scrollUpButton.field_22764 = false;
            this.scrollDownButton.field_22764 = false;
            this.bundles.forEach(bundle -> bundle.setVisible(false));
        }
    }

    private boolean isValidTab(class_1761 tab) {
        return tab == ModCreativeTabs.VANILLA_BACKPORT.get();
    }

    public static class ScrollButton
    extends class_4185 {
        private final int uOffset;

        public ScrollButton(int x, int y, int uOffset, class_4185.class_4241 onPress) {
            super(x, y, 18, 20, (class_2561)class_2561.method_43473(), onPress, field_40754);
            this.uOffset = uOffset;
        }

        public void method_48579(class_332 graphics, int mouseX, int mouseY, float partialTicks) {
            int textureY = this.field_22762 ? 12 : 0;
            graphics.method_51448().method_22903();
            graphics.method_51448().method_22904(0.0, 0.0, 20.0);
            graphics.method_25302(SELECTOR_BAR, this.method_46426(), this.method_46427(), this.uOffset, textureY, 18, 11);
            graphics.method_51448().method_22909();
        }
    }

    public static class Tab
    extends class_4185 {
        private final BundledTabs bundle;

        protected Tab(int x, int y, BundledTabs bundle, class_4185.class_4241 onPress) {
            super(x, y, 16, 16, (class_2561)class_2561.method_43473(), onPress, field_40754);
            this.bundle = bundle;
            bundle.setContentTab(this);
            this.method_47400(class_7919.method_47407((class_2561)bundle.getTooltip()));
        }

        protected void method_48579(class_332 graphics, int mouseX, int mouseY, float partialTick) {
            graphics.method_51448().method_22903();
            graphics.method_51448().method_22904(0.0, 0.0, 20.0);
            this.renderSelected(graphics);
            graphics.method_51427(this.bundle.getIcon(), this.method_46426(), this.method_46427());
            graphics.method_51448().method_22909();
            this.renderHighlight(graphics);
        }

        private void renderSelected(class_332 graphics) {
            if (this.bundle.isSelected()) {
                graphics.method_25302(SELECTOR_BAR, this.method_46426() - 7, this.method_46427() - 1, 36, 24, 30, 19);
            }
        }

        private void renderHighlight(class_332 graphics) {
            if (this.method_49606() && !this.bundle.isSelected()) {
                graphics.method_51448().method_22903();
                graphics.method_51448().method_22904(0.0, 0.0, 20.0);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                graphics.method_25302(SELECTOR_BAR, this.method_46426(), this.method_46427(), 32, 44, 16, 16);
                RenderSystem.disableBlend();
                graphics.method_51448().method_22909();
            }
        }
    }
}

