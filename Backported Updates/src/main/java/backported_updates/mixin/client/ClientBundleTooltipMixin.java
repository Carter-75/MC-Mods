/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.util.Formatting
 *  net.minecraft.item.ItemStack
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.client.gui.tooltip.BundleTooltipComponent
 *  net.minecraft.client.gui.tooltip.TooltipComponent
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.component.DataComponentTypes
 *  org.apache.commons.lang3.math.Fraction
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.common.api.bundle.IBundle;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.util.Formatting;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;
import net.minecraft.client.gui.tooltip.BundleTooltipComponent;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.DataComponentTypes;
import org.apache.commons.lang3.math.Fraction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BundleTooltipComponent.class})
public abstract class ClientBundleTooltipMixin
implements TooltipComponent {
    @Shadow
    @Final
    private BundleContentsComponent bundleContents;
    @Unique
    private static final Identifier PROGRESSBAR_BORDER_SPRITE = Identifier.ofVanilla((String)"container/bundle/bundle_progressbar_border");
    @Unique
    private static final Identifier PROGRESSBAR_FILL_SPRITE = Identifier.ofVanilla((String)"container/bundle/bundle_progressbar_fill");
    @Unique
    private static final Identifier PROGRESSBAR_FULL_SPRITE = Identifier.ofVanilla((String)"container/bundle/bundle_progressbar_full");
    @Unique
    private static final Identifier BUNDLE_SLOT_HIGHLIGHT_BACK_TEXTURE = Identifier.ofVanilla((String)"textures/container/bundle/slot_highlight_back.png");
    @Unique
    private static final Identifier BUNDLE_SLOT_HIGHLIGHT_FRONT_TEXTURE = Identifier.ofVanilla((String)"textures/container/bundle/slot_highlight_front.png");
    @Unique
    private static final Identifier BUNDLE_SLOT_BACKGROUND_TEXTURE = Identifier.ofVanilla((String)"textures/container/bundle/slot_background.png");
    @Unique
    private static final Text BUNDLE_EMPTY_DESCRIPTION = Text.translatable((String)"item.minecraft.bundle.empty.description");
    @Unique
    private static final Text BUNDLE_FULL = Text.translatable((String)"item.minecraft.bundle.full");
    @Unique
    private static final Text BUNDLE_EMPTY = Text.translatable((String)"item.minecraft.bundle.empty");
    @Unique
    private int selectedItem;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void vb$onInit(BundleContentsComponent contents, CallbackInfo ci) {
        this.selectedItem = ((IBundle)(Object)contents).getSelectedItem();
    }

    @Unique
    private int getSelectedItem() {
        return this.selectedItem;
    }

    @Unique
    private boolean hasSelectedItem() {
        return this.selectedItem != -1;
    }

    public int getHeight() {
        return this.bundleContents.isEmpty() ? 39 : this.backgroundHeight();
    }

    public int getWidth(TextRenderer font) {
        return 96;
    }

    @Unique
    private int backgroundHeight() {
        return this.itemGridHeight() + 13 + 8;
    }

    @Unique
    private int itemGridHeight() {
        return this.gridSizeY() * 24;
    }

    @Unique
    private int getContentXOffset(int width) {
        return (width - 96) / 2;
    }

    @Unique
    private int gridSizeY() {
        return MathHelper.ceilDiv((int)this.slotCount(), (int)4);
    }

    @Unique
    private int slotCount() {
        return Math.min(12, this.bundleContents.size());
    }

    @Inject(method={"drawItems"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$onRenderImage(TextRenderer font, int x, int y, DrawContext graphics, CallbackInfo ci) {
        if (BundleFeatures.onBundleUpdate()) {
            ci.cancel();
            if (this.bundleContents.isEmpty()) {
                this.renderEmptyBundleTooltip(font, x, y, this.getWidth(font), graphics);
            } else {
                this.renderBundleWithItemsTooltip(font, x, y, this.getWidth(font), graphics);
            }
        }
    }

    @Unique
    private void renderEmptyBundleTooltip(TextRenderer font, int x, int y, int width, DrawContext graphics) {
        this.drawEmptyBundleDescriptionText(x + this.getContentXOffset(width), y, font, graphics);
        this.drawProgressBar(x + this.getContentXOffset(width), y + this.getEmptyBundleDescriptionTextHeight(font) + 4, font, graphics);
    }

    @Unique
    private void renderBundleWithItemsTooltip(TextRenderer font, int x, int y, int width, DrawContext graphics) {
        boolean maxDisplay = this.bundleContents.size() > 12;
        List<ItemStack> stacks = this.getShownItems(((IBundle)(Object)this.bundleContents).getNumberOfItemsToShow());
        int xOffset = x + this.getContentXOffset(width) + 96;
        int yOffset = y + this.gridSizeY() * 24;
        int index = 1;
        for (int row = 1; row <= this.gridSizeY(); ++row) {
            for (int column = 1; column <= 4; ++column) {
                int slotX = xOffset - column * 24;
                int slotY = yOffset - row * 24;
                if (this.shouldRenderSurplusText(maxDisplay, column, row)) {
                    this.renderCount(slotX, slotY, this.getAmountOfHiddenItems(stacks), font, graphics);
                    continue;
                }
                if (!this.shouldRenderItemSlot(stacks, index)) continue;
                this.renderSlot(index, slotX, slotY, stacks, index, font, graphics);
                ++index;
            }
        }
        this.drawSelectedItemTooltip(font, graphics, x, y, width);
        this.drawProgressBar(x + this.getContentXOffset(width), y + this.itemGridHeight() + 4, font, graphics);
    }

    @Unique
    private List<ItemStack> getShownItems(int max) {
        int size = Math.min(this.bundleContents.size(), max);
        return this.bundleContents.stream().toList().subList(0, size);
    }

    @Unique
    private boolean shouldRenderSurplusText(boolean maxDisplay, int column, int row) {
        return maxDisplay && column * row == 1;
    }

    @Unique
    private boolean shouldRenderItemSlot(List<ItemStack> items, int itemIndex) {
        return items.size() >= itemIndex;
    }

    @Unique
    private int getAmountOfHiddenItems(List<ItemStack> items) {
        return this.bundleContents.stream().skip(items.size()).mapToInt(ItemStack::getCount).sum();
    }

    @Unique
    private void renderSlot(int index, int x, int y, List<ItemStack> stacks, int seed, TextRenderer font, DrawContext graphics) {
        int itemIndex = stacks.size() - index;
        boolean hasSelectedItem = itemIndex == this.getSelectedItem();
        ItemStack stack = stacks.get(itemIndex);
        if (hasSelectedItem) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            graphics.drawTexture(BUNDLE_SLOT_HIGHLIGHT_BACK_TEXTURE, x, y, 0, 0.0f, 0.0f, 24, 24, 24, 24);
            RenderSystem.disableBlend();
        } else {
            graphics.drawTexture(BUNDLE_SLOT_BACKGROUND_TEXTURE, x, y, 0, 0.0f, 0.0f, 24, 24, 24, 24);
        }
        graphics.drawItem(stack, x + 4, y + 4, seed);
        graphics.drawItemInSlot(font, stack, x + 4, y + 4);
        if (hasSelectedItem) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            graphics.drawTexture(BUNDLE_SLOT_HIGHLIGHT_FRONT_TEXTURE, x, y, 0, 0.0f, 0.0f, 24, 24, 24, 24);
            RenderSystem.disableBlend();
        }
    }

    @Unique
    private void renderCount(int x, int y, int value, TextRenderer font, DrawContext graphics) {
        graphics.drawCenteredTextWithShadow(font, "+" + value, x + 12, y + 10, -1);
    }

    @Unique
    private void drawSelectedItemTooltip(TextRenderer font, DrawContext graphics, int x, int y, int width) {
        if (this.hasSelectedItem()) {
            ItemStack stack = this.bundleContents.get(this.getSelectedItem());
            MutableText component = Text.empty().append(stack.getName()).formatted(stack.getRarity().getFormatting());
            if (stack.contains(DataComponentTypes.CUSTOM_NAME)) {
                component.formatted(Formatting.ITALIC);
            }
            int textWidth = font.getWidth(component.asOrderedText());
            int xOffset = x + width / 2 - 12;
            graphics.drawTooltip(font, (Text)component, xOffset - textWidth / 2, y - 15);
        }
    }

    @Unique
    private void drawProgressBar(int x, int y, TextRenderer textRenderer, DrawContext graphics) {
        graphics.drawGuiTexture(this.getProgressBarTexture(), x + 1, y, this.getProgressBarFill(), 13);
        graphics.drawGuiTexture(PROGRESSBAR_BORDER_SPRITE, x, y, 96, 13);
        Text component = this.getProgressBarFillText();
        if (component != null) {
            graphics.drawCenteredTextWithShadow(textRenderer, component, x + 48, y + 3, -1);
        }
    }

    @Unique
    private void drawEmptyBundleDescriptionText(int x, int y, TextRenderer font, DrawContext graphics) {
        graphics.drawTextWrapped(font, (StringVisitable)BUNDLE_EMPTY_DESCRIPTION, x, y, 96, -5592406);
    }

    @Unique
    private int getEmptyBundleDescriptionTextHeight(TextRenderer font) {
        return font.wrapLines((StringVisitable)BUNDLE_EMPTY_DESCRIPTION, 96).size() * 9;
    }

    @Unique
    private int getProgressBarFill() {
        return MathHelper.clamp((int)MathHelper.multiplyFraction((Fraction)this.bundleContents.getOccupancy(), (int)94), (int)0, (int)94);
    }

    @Unique
    private Identifier getProgressBarTexture() {
        return this.bundleContents.getOccupancy().compareTo(Fraction.ONE) >= 0 ? PROGRESSBAR_FULL_SPRITE : PROGRESSBAR_FILL_SPRITE;
    }

    @Unique
    @Nullable
    private Text getProgressBarFillText() {
        if (this.bundleContents.isEmpty()) {
            return BUNDLE_EMPTY;
        }
        return this.bundleContents.getOccupancy().compareTo(Fraction.ONE) >= 0 ? BUNDLE_FULL : null;
    }
}

