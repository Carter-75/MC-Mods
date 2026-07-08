/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
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
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_5348;
import net.minecraft.class_5481;

public class ConfigScreen
extends class_437 {
    private static final int SIDEBAR_WIDTH = 110;
    private static final int OPTION_WIDTH = 240;
    private static final int SCROLLBAR_WIDTH = 8;
    private static final int GROUP_HEADER_HEIGHT = 16;
    private static final int GROUP_HEADER_COLOR = -1;
    private final List<OptionPage> pages = new ArrayList<OptionPage>();
    private final List<ControlElement<?>> controls = new ArrayList();
    private final List<GroupHeader> groupHeaders = new ArrayList<GroupHeader>();
    private final class_437 prevScreen;
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

    public ConfigScreen(class_437 prevScreen) {
        super((class_2561)class_2561.method_43471((String)"config.copperagebackport.title"));
        this.prevScreen = prevScreen;
        this.pages.addAll(ConfigOptions.createPages());
    }

    public static ConfigScreen create(class_437 parent) {
        return new ConfigScreen(parent);
    }

    public void setPage(OptionPage page) {
        this.currentPage = page;
        this.scrollOffset = 0;
        this.rebuildGUI();
    }

    protected void method_25426() {
        super.method_25426();
        this.rebuildGUI();
    }

    private void rebuildGUI() {
        this.controls.clear();
        this.method_37067();
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
        int contentHeight = this.field_22790 - contentY - bottomBarHeight;
        int donateWidth = this.field_22793.method_27525((class_5348)class_2561.method_43471((String)"config.copperagebackport.donate")) + 14;
        this.donateButton = new FlatButtonWidget(new Dim2i(this.field_22789 - donateWidth - 28, 4, donateWidth, 20), (class_2561)class_2561.method_43471((String)"config.copperagebackport.donate"), this::openDonatePage);
        this.hideDonateButton = new FlatButtonWidget(new Dim2i(this.field_22789 - 24, 4, 20, 20), (class_2561)class_2561.method_43470((String)"x"), this::closeScreen);
        int searchWidth = this.field_22789 - donateWidth - 32 - margin;
        this.searchField = new SearchFieldWidget(new Dim2i(margin, 4, searchWidth, 20), (class_2561)class_2561.method_43471((String)"config.copperagebackport.search"));
        this.searchField.setResponder(this::onSearchChanged);
        this.method_37063(this.searchField);
        this.method_37063(this.donateButton);
        this.method_37063(this.hideDonateButton);
        this.rebuildGUIPages(contentY, contentHeight);
        this.rebuildGUIOptions(contentY, contentHeight);
        this.undoButton = new FlatButtonWidget(new Dim2i(this.field_22789 - 211, this.field_22790 - 30, 65, 20), (class_2561)class_2561.method_43471((String)"config.copperagebackport.reset"), this::undoChanges);
        this.applyButton = new FlatButtonWidget(new Dim2i(this.field_22789 - 142, this.field_22790 - 30, 65, 20), (class_2561)class_2561.method_43471((String)"config.copperagebackport.apply"), this::applyChanges);
        this.closeButton = new FlatButtonWidget(new Dim2i(this.field_22789 - 73, this.field_22790 - 30, 65, 20), (class_2561)class_2561.method_43471((String)"gui.done"), this::method_25419);
        this.method_37063(this.undoButton);
        this.method_37063(this.applyButton);
        this.method_37063(this.closeButton);
    }

    private void onSearchChanged(String query) {
        this.searchQuery = query.toLowerCase(Locale.ROOT);
        this.scrollOffset = 0;
        int margin = 10;
        int topBarHeight = 26;
        int bottomBarHeight = 36;
        int contentY = topBarHeight + margin;
        int contentHeight = this.field_22790 - contentY - bottomBarHeight;
        this.rebuildGUIOptions(contentY, contentHeight);
    }

    private void rebuildGUIPages(int contentY, int contentHeight) {
        int x = 10;
        int y = contentY;
        for (OptionPage page : this.pages) {
            FlatButtonWidget button = new FlatButtonWidget(new Dim2i(x, y, 98, 18), page.getName(), () -> this.setPage(page));
            button.setSelected(this.currentPage == page);
            y += 20;
            this.method_37063(button);
        }
        this.discordButton = new FlatButtonWidget(new Dim2i(x, this.field_22790 - 30, 98, 20), (class_2561)class_2561.method_43471((String)"config.copperagebackport.discord"), this::openDiscordPage);
        this.discordButton.setBorderColor(-10983950);
        this.method_37063(this.discordButton);
    }

    private void rebuildGUIOptions(int contentY, int contentHeight) {
        Control<?> control;
        String optionName;
        boolean hasVisibleOptions;
        for (ControlElement<?> control2 : this.controls) {
            this.method_37066(control2);
        }
        this.controls.clear();
        if (this.scrollBar != null) {
            this.method_37066(this.scrollBar);
        }
        this.optionsAreaY = contentY;
        this.optionsAreaHeight = contentHeight;
        int x = 126;
        int y = contentY - this.scrollOffset;
        int optionWidth = this.field_22789 - x - 8 - 16;
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
                this.method_37063(element);
                this.controls.add(element);
                y += controlHeight;
            }
            y += 4;
        }
        Dim2i scrollBarDim = new Dim2i(this.field_22789 - 8 - 10, contentY, 8, contentHeight);
        Dim2i scrollAreaDim = new Dim2i(120, contentY, this.field_22789 - 110 - 20, contentHeight);
        this.scrollBar = new ScrollBarWidget(scrollBarDim, this.totalContentHeight, contentHeight, this::onScroll, scrollAreaDim);
        this.scrollBar.setOffset(this.scrollOffset);
        this.method_37063(this.scrollBar);
    }

    private void onScroll(int newOffset) {
        this.scrollOffset = newOffset;
        this.updateControlPositions();
    }

    private void updateControlPositions() {
        int x = 126;
        int y = this.optionsAreaY - this.scrollOffset;
        int optionWidth = this.field_22789 - x - 8 - 16;
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

    public void method_25394(class_332 graphics, int mouseX, int mouseY, float delta) {
        this.method_25420(graphics, mouseX, mouseY, delta);
        this.updateControls();
        super.method_25394(graphics, mouseX, mouseY, delta);
        if (this.optionsAreaHeight > 0) {
            int scissorX = 120;
            int scissorY = this.optionsAreaY;
            int scissorWidth = this.field_22789 - 110 - 20;
            int scissorHeight = this.optionsAreaHeight;
            graphics.method_44379(scissorX, scissorY, scissorX + scissorWidth, scissorY + scissorHeight);
            for (GroupHeader groupHeader : this.groupHeaders) {
                int headerX = 126;
                graphics.method_51439(this.field_22793, groupHeader.name, headerX, groupHeader.y + 4, -1, false);
            }
            for (ControlElement controlElement : this.controls) {
                controlElement.method_25394(graphics, mouseX, mouseY, delta);
            }
            graphics.method_44380();
        }
        if (this.hoveredElement != null) {
            this.renderOptionTooltip(graphics, this.hoveredElement);
        }
    }

    private void updateControls() {
        ControlElement hovered = this.getActiveControls().filter(AbstractWidget::isHovered).findFirst().orElse(this.getActiveControls().filter(AbstractWidget::method_25370).findFirst().orElse(null));
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

    private void renderOptionTooltip(class_332 graphics, ControlElement<?> element) {
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
        ArrayList tooltip = new ArrayList(this.field_22793.method_1728((class_5348)option.getTooltip(), splitWidth));
        int boxHeight = tooltip.size() * 12 + boxPadding;
        int boxYLimit = boxY + boxHeight;
        if (boxYLimit > (boxYCutoff = this.field_22790 - 40)) {
            boxY = dim.y() - boxHeight - boxPadding;
        }
        graphics.method_51448().method_22903();
        graphics.method_51448().method_46416(0.0f, 0.0f, 400.0f);
        graphics.method_25294(boxX, boxY, boxX + boxWidth, boxY + boxHeight, -536870912);
        int borderColor = -7019309;
        graphics.method_25294(boxX, boxY, boxX + boxWidth, boxY + 1, borderColor);
        graphics.method_25294(boxX, boxY + boxHeight - 1, boxX + boxWidth, boxY + boxHeight, borderColor);
        graphics.method_25294(boxX, boxY, boxX + 1, boxY + boxHeight, borderColor);
        graphics.method_25294(boxX + boxWidth - 1, boxY, boxX + boxWidth, boxY + boxHeight, borderColor);
        for (int i = 0; i < tooltip.size(); ++i) {
            graphics.method_35720(this.field_22793, (class_5481)tooltip.get(i), boxX + textPadding, boxY + textPadding + i * 12, -1);
        }
        graphics.method_51448().method_22909();
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
        if (class_156.method_668() != null) {
            class_156.method_668().method_670("https://ko-fi.com/smallinger");
        }
    }

    private void openDiscordPage() {
        if (class_156.method_668() != null) {
            class_156.method_668().method_670("https://discord.gg/hGrWUW9vSb");
        }
    }

    private void closeScreen() {
        this.field_22787.method_1507(this.prevScreen);
    }

    public void method_25419() {
        this.field_22787.method_1507(this.prevScreen);
    }

    public boolean method_25422() {
        return !this.hasPendingChanges;
    }

    public boolean method_25401(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.scrollBar != null && this.scrollBar.method_25401(mouseX, mouseY, scrollX, scrollY)) {
            return true;
        }
        return super.method_25401(mouseX, mouseY, scrollX, scrollY);
    }

    private static class GroupHeader {
        final class_2561 name;
        int y;

        GroupHeader(class_2561 name, int y) {
            this.name = name;
            this.y = y;
        }
    }
}

