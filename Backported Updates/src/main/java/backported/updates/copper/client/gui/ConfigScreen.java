/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Util
 *  net.minecraft.text.Text
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.OrderedText
 */
package backported.updates.copper.client.gui;

import backported.updates.copper.client.gui.ConfigOptions;
import backported.updates.copper.client.gui.options.Control;
import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.OptionGroup;
import backported.updates.copper.client.gui.options.OptionPage;
import backported.updates.copper.client.gui.options.control.ControlElement;
import backported.updates.copper.client.gui.widget.AbstractWidget;
import backported.updates.copper.client.gui.widget.Dim2i;
import backported.updates.copper.client.gui.widget.FlatButtonWidget;
import backported.updates.copper.client.gui.widget.ScrollBarWidget;
import backported.updates.copper.client.gui.widget.SearchFieldWidget;
import backported.updates.copper.config.CommonConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import net.minecraft.util.Util;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.OrderedText;

public class ConfigScreen
extends Screen {
    private static final int SIDEBAR_WIDTH = 110;
    private static final int OPTION_WIDTH = 240;
    private static final int SCROLLBAR_WIDTH = 8;
    private static final int GROUP_HEADER_HEIGHT = 16;
    private static final int GROUP_HEADER_COLOR = -1;
    private final List<OptionPage> pages = new ArrayList<OptionPage>();
    private final List<ControlElement<?>> controls = new ArrayList();
    private final List<GroupHeader> groupHeaders = new ArrayList<GroupHeader>();
    private final Screen prevScreen;
    private OptionPage currentPage;
    private FlatButtonWidget applyButton;
    private FlatButtonWidget closeButton;
    private FlatButtonWidget undoButton;
    private FlatButtonWidget donateButton;
    private FlatButtonWidget hideDonateButton;
    private FlatButtonWidget discordButton;
    private SearchFieldWidget searchField;
    private ScrollBarWidget scrollBar;
    private String searchQuery = "";
    private boolean hasPendingChanges;
    private ControlElement<?> hoveredElement;
    private int scrollOffset = 0;
    private int optionsAreaY;
    private int optionsAreaHeight;
    private int totalContentHeight;

    public ConfigScreen(Screen prevScreen) {
        super((Text)Text.translatable((String)"config.copperagebackport.title"));
        this.prevScreen = prevScreen;
        this.pages.addAll(ConfigOptions.createPages());
    }

    public static ConfigScreen create(Screen parent) {
        return new ConfigScreen(parent);
    }

    public void setPage(OptionPage page) {
        this.currentPage = page;
        this.scrollOffset = 0;
        this.rebuildGUI();
    }

    protected void init() {
        super.init();
        this.rebuildGUI();
    }

    private void rebuildGUI() {
        this.controls.clear();
        this.clearChildren();
        if (this.currentPage == null) {
            if (this.pages.isEmpty()) {
                throw new IllegalStateException("No pages are available?!");
            }
            this.currentPage = this.pages.get(0);
        }
        int margin = 10;
        int topBarHeight = 26;
        int bottomBarHeight = 36;
        int contentY = topBarHeight + margin;
        int contentHeight = this.height - contentY - bottomBarHeight;
        int donateWidth = this.textRenderer.getWidth((StringVisitable)Text.translatable((String)"config.copperagebackport.donate")) + 14;
        this.donateButton = new FlatButtonWidget(new Dim2i(this.width - donateWidth - 28, 4, donateWidth, 20), (Text)Text.translatable((String)"config.copperagebackport.donate"), this::openDonatePage);
        this.hideDonateButton = new FlatButtonWidget(new Dim2i(this.width - 24, 4, 20, 20), (Text)Text.literal((String)"x"), this::closeScreen);
        int searchWidth = this.width - donateWidth - 32 - margin;
        this.searchField = new SearchFieldWidget(new Dim2i(margin, 4, searchWidth, 20), (Text)Text.translatable((String)"config.copperagebackport.search"));
        this.searchField.setResponder(this::onSearchChanged);
        this.addDrawableChild(this.searchField);
        this.addDrawableChild(this.donateButton);
        this.addDrawableChild(this.hideDonateButton);
        this.rebuildGUIPages(contentY, contentHeight);
        this.rebuildGUIOptions(contentY, contentHeight);
        this.undoButton = new FlatButtonWidget(new Dim2i(this.width - 211, this.height - 30, 65, 20), (Text)Text.translatable((String)"config.copperagebackport.reset"), this::undoChanges);
        this.applyButton = new FlatButtonWidget(new Dim2i(this.width - 142, this.height - 30, 65, 20), (Text)Text.translatable((String)"config.copperagebackport.apply"), this::applyChanges);
        this.closeButton = new FlatButtonWidget(new Dim2i(this.width - 73, this.height - 30, 65, 20), (Text)Text.translatable((String)"gui.done"), this::close);
        this.addDrawableChild(this.undoButton);
        this.addDrawableChild(this.applyButton);
        this.addDrawableChild(this.closeButton);
    }

    private void onSearchChanged(String query) {
        this.searchQuery = query.toLowerCase(Locale.ROOT);
        this.scrollOffset = 0;
        int margin = 10;
        int topBarHeight = 26;
        int bottomBarHeight = 36;
        int contentY = topBarHeight + margin;
        int contentHeight = this.height - contentY - bottomBarHeight;
        this.rebuildGUIOptions(contentY, contentHeight);
    }

    private void rebuildGUIPages(int contentY, int contentHeight) {
        int x = 10;
        int y = contentY;
        for (OptionPage page : this.pages) {
            FlatButtonWidget button = new FlatButtonWidget(new Dim2i(x, y, 98, 18), page.getName(), () -> this.setPage(page));
            button.setSelected(this.currentPage == page);
            y += 20;
            this.addDrawableChild(button);
        }
        this.discordButton = new FlatButtonWidget(new Dim2i(x, this.height - 30, 98, 20), (Text)Text.translatable((String)"config.copperagebackport.discord"), this::openDiscordPage);
        this.discordButton.setBorderColor(-10983950);
        this.addDrawableChild(this.discordButton);
    }

    private void rebuildGUIOptions(int contentY, int contentHeight) {
        Control<?> control;
        String optionName;
        boolean hasVisibleOptions;
        for (ControlElement<?> control2 : this.controls) {
            this.remove(control2);
        }
        this.controls.clear();
        if (this.scrollBar != null) {
            this.remove(this.scrollBar);
        }
        this.optionsAreaY = contentY;
        this.optionsAreaHeight = contentHeight;
        int x = 126;
        int y = contentY - this.scrollOffset;
        int optionWidth = this.width - x - 8 - 16;
        this.groupHeaders.clear();
        int calcY = 0;
        for (OptionGroup group : this.currentPage.getGroups()) {
            hasVisibleOptions = false;
            for (Option<?> option : group.getOptions()) {
                if (!this.searchQuery.isEmpty() && !(optionName = option.getName().getString().toLowerCase(Locale.ROOT)).contains(this.searchQuery)) continue;
                hasVisibleOptions = true;
                break;
            }
            if (hasVisibleOptions && group.getName() != null && !group.getName().getString().isEmpty()) {
                calcY += 16;
            }
            for (Option<?> option : group.getOptions()) {
                if (!this.searchQuery.isEmpty() && !(optionName = option.getName().getString().toLowerCase(Locale.ROOT)).contains(this.searchQuery)) continue;
                control = option.getControl();
                calcY += control.getHeight(optionWidth);
            }
            calcY += 4;
        }
        this.totalContentHeight = calcY;
        for (OptionGroup group : this.currentPage.getGroups()) {
            hasVisibleOptions = false;
            for (Option<?> option : group.getOptions()) {
                if (!this.searchQuery.isEmpty() && !(optionName = option.getName().getString().toLowerCase(Locale.ROOT)).contains(this.searchQuery)) continue;
                hasVisibleOptions = true;
                break;
            }
            if (hasVisibleOptions && group.getName() != null && !group.getName().getString().isEmpty()) {
                this.groupHeaders.add(new GroupHeader(group.getName(), y));
                y += 16;
            }
            for (Option<?> option : group.getOptions()) {
                if (!this.searchQuery.isEmpty() && !(optionName = option.getName().getString().toLowerCase(Locale.ROOT)).contains(this.searchQuery)) continue;
                control = option.getControl();
                int controlHeight = control.getHeight(optionWidth);
                ControlElement<?> element = control.createElement(new Dim2i(x, y, optionWidth, controlHeight));
                this.addDrawableChild(element);
                this.controls.add(element);
                y += controlHeight;
            }
            y += 4;
        }
        Dim2i scrollBarDim = new Dim2i(this.width - 8 - 10, contentY, 8, contentHeight);
        Dim2i scrollAreaDim = new Dim2i(120, contentY, this.width - 110 - 20, contentHeight);
        this.scrollBar = new ScrollBarWidget(scrollBarDim, this.totalContentHeight, contentHeight, this::onScroll, scrollAreaDim);
        this.scrollBar.setOffset(this.scrollOffset);
        this.addDrawableChild(this.scrollBar);
    }

    private void onScroll(int newOffset) {
        this.scrollOffset = newOffset;
        this.updateControlPositions();
    }

    private void updateControlPositions() {
        int x = 126;
        int y = this.optionsAreaY - this.scrollOffset;
        int optionWidth = this.width - x - 8 - 16;
        int controlIndex = 0;
        int headerIndex = 0;
        for (OptionGroup group : this.currentPage.getGroups()) {
            String optionName;
            boolean hasVisibleOptions = false;
            for (Option<?> option : group.getOptions()) {
                if (!this.searchQuery.isEmpty() && !(optionName = option.getName().getString().toLowerCase(Locale.ROOT)).contains(this.searchQuery)) continue;
                hasVisibleOptions = true;
                break;
            }
            if (hasVisibleOptions && group.getName() != null && !group.getName().getString().isEmpty()) {
                if (headerIndex < this.groupHeaders.size()) {
                    this.groupHeaders.get((int)headerIndex).y = y;
                    ++headerIndex;
                }
                y += 16;
            }
            for (Option<?> option : group.getOptions()) {
                if (!this.searchQuery.isEmpty() && !(optionName = option.getName().getString().toLowerCase(Locale.ROOT)).contains(this.searchQuery)) continue;
                Control<?> control = option.getControl();
                int controlHeight = control.getHeight(optionWidth);
                if (controlIndex < this.controls.size()) {
                    ControlElement<?> controlElement = this.controls.get(controlIndex);
                    controlElement.setDim(new Dim2i(x, y, optionWidth, controlHeight));
                    ++controlIndex;
                }
                y += controlHeight;
            }
            y += 4;
        }
    }

    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics, mouseX, mouseY, delta);
        this.updateControls();
        super.render(graphics, mouseX, mouseY, delta);
        if (this.optionsAreaHeight > 0) {
            int scissorX = 120;
            int scissorY = this.optionsAreaY;
            int scissorWidth = this.width - 110 - 20;
            int scissorHeight = this.optionsAreaHeight;
            graphics.enableScissor(scissorX, scissorY, scissorX + scissorWidth, scissorY + scissorHeight);
            for (GroupHeader groupHeader : this.groupHeaders) {
                int headerX = 126;
                graphics.drawText(this.textRenderer, groupHeader.name, headerX, groupHeader.y + 4, -1, false);
            }
            for (ControlElement controlElement : this.controls) {
                controlElement.render(graphics, mouseX, mouseY, delta);
            }
            graphics.disableScissor();
        }
        if (this.hoveredElement != null) {
            this.renderOptionTooltip(graphics, this.hoveredElement);
        }
    }

    private void updateControls() {
        ControlElement hovered = this.getActiveControls().filter(AbstractWidget::isHovered).findFirst().orElse(this.getActiveControls().filter(AbstractWidget::isFocused).findFirst().orElse(null));
        boolean hasChanges = this.getAllOptions().anyMatch(Option::hasChanged);
        this.applyButton.setEnabled(hasChanges);
        this.undoButton.setVisible(hasChanges);
        this.closeButton.setEnabled(!hasChanges);
        this.hasPendingChanges = hasChanges;
        this.hoveredElement = hovered;
    }

    private Stream<Option<?>> getAllOptions() {
        return this.pages.stream().flatMap(s -> s.getAllOptions().stream());
    }

    private Stream<ControlElement<?>> getActiveControls() {
        return this.controls.stream();
    }

    private void renderOptionTooltip(DrawContext graphics, ControlElement<?> element) {
        int boxYCutoff;
        int textPadding = 3;
        int boxPadding = 3;
        Dim2i dim = element.getDim();
        int boxX = dim.x();
        int boxY = dim.getLimitY() + boxPadding;
        int boxWidth = dim.width();
        Option<?> option = element.getOption();
        if (option.getTooltip() == null) {
            return;
        }
        int splitWidth = boxWidth - textPadding * 2;
        ArrayList tooltip = new ArrayList(this.textRenderer.wrapLines((StringVisitable)option.getTooltip(), splitWidth));
        int boxHeight = tooltip.size() * 12 + boxPadding;
        int boxYLimit = boxY + boxHeight;
        if (boxYLimit > (boxYCutoff = this.height - 40)) {
            boxY = dim.y() - boxHeight - boxPadding;
        }
        graphics.getMatrices().push();
        graphics.getMatrices().translate(0.0f, 0.0f, 400.0f);
        graphics.fill(boxX, boxY, boxX + boxWidth, boxY + boxHeight, -536870912);
        int borderColor = -7019309;
        graphics.fill(boxX, boxY, boxX + boxWidth, boxY + 1, borderColor);
        graphics.fill(boxX, boxY + boxHeight - 1, boxX + boxWidth, boxY + boxHeight, borderColor);
        graphics.fill(boxX, boxY, boxX + 1, boxY + boxHeight, borderColor);
        graphics.fill(boxX + boxWidth - 1, boxY, boxX + boxWidth, boxY + boxHeight, borderColor);
        for (int i = 0; i < tooltip.size(); ++i) {
            graphics.drawTextWithShadow(this.textRenderer, (OrderedText)tooltip.get(i), boxX + textPadding, boxY + textPadding + i * 12, -1);
        }
        graphics.getMatrices().pop();
    }

    private void applyChanges() {
        this.getAllOptions().forEach(option -> {
            if (option.hasChanged()) {
                option.applyChanges();
            }
        });
        CommonConfig.save();
    }

    private void undoChanges() {
        this.getAllOptions().forEach(Option::reset);
    }

    private void openDonatePage() {
        if (Util.getOperatingSystem() != null) {
            Util.getOperatingSystem().open("https://ko-fi.com/smallinger");
        }
    }

    private void openDiscordPage() {
        if (Util.getOperatingSystem() != null) {
            Util.getOperatingSystem().open("https://discord.gg/hGrWUW9vSb");
        }
    }

    private void closeScreen() {
        this.client.setScreen(this.prevScreen);
    }

    public void close() {
        this.client.setScreen(this.prevScreen);
    }

    public boolean shouldCloseOnEsc() {
        return !this.hasPendingChanges;
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.scrollBar != null && this.scrollBar.mouseScrolled(mouseX, mouseY, scrollX, scrollY)) {
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }

    private static class GroupHeader {
        final Text name;
        int y;

        GroupHeader(Text name, int y) {
            this.name = name;
            this.y = y;
        }
    }
}

