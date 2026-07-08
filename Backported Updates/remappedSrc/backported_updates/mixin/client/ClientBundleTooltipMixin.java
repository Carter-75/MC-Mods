/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_124
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 *  net.minecraft.class_5682
 *  net.minecraft.class_5684
 *  net.minecraft.class_9276
 *  net.minecraft.class_9334
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
import net.minecraft.class_124;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_5682;
import net.minecraft.class_5684;
import net.minecraft.class_9276;
import net.minecraft.class_9334;
import org.apache.commons.lang3.math.Fraction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_5682.class})
public abstract class ClientBundleTooltipMixin
implements class_5684 {
    @Shadow
    @Final
    private class_9276 field_49537;
    @Unique
    private static final class_2960 PROGRESSBAR_BORDER_SPRITE = class_2960.method_60656((String)"container/bundle/bundle_progressbar_border");
    @Unique
    private static final class_2960 PROGRESSBAR_FILL_SPRITE = class_2960.method_60656((String)"container/bundle/bundle_progressbar_fill");
    @Unique
    private static final class_2960 PROGRESSBAR_FULL_SPRITE = class_2960.method_60656((String)"container/bundle/bundle_progressbar_full");
    @Unique
    private static final class_2960 BUNDLE_SLOT_HIGHLIGHT_BACK_TEXTURE = class_2960.method_60656((String)"textures/container/bundle/slot_highlight_back.png");
    @Unique
    private static final class_2960 BUNDLE_SLOT_HIGHLIGHT_FRONT_TEXTURE = class_2960.method_60656((String)"textures/container/bundle/slot_highlight_front.png");
    @Unique
    private static final class_2960 BUNDLE_SLOT_BACKGROUND_TEXTURE = class_2960.method_60656((String)"textures/container/bundle/slot_background.png");
    @Unique
    private static final class_2561 BUNDLE_EMPTY_DESCRIPTION = class_2561.method_43471((String)"item.minecraft.bundle.empty.description");
    @Unique
    private static final class_2561 BUNDLE_FULL = class_2561.method_43471((String)"item.minecraft.bundle.full");
    @Unique
    private static final class_2561 BUNDLE_EMPTY = class_2561.method_43471((String)"item.minecraft.bundle.empty");
    @Unique
    private int selectedItem;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void vb$onInit(class_9276 contents, CallbackInfo ci) {
        this.selectedItem = ((IBundle)contents).getSelectedItem();
    }

    @Unique
    private int getSelectedItem() {
        return this.selectedItem;
    }

    @Unique
    private boolean hasSelectedItem() {
        return this.selectedItem != -1;
    }

    public int method_32661() {
        return this.field_49537.method_57429() ? 39 : this.backgroundHeight();
    }

    public int method_32664(class_327 font) {
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
        return class_3532.method_38788((int)this.slotCount(), (int)4);
    }

    @Unique
    private int slotCount() {
        return Math.min(12, this.field_49537.method_57426());
    }

    @Inject(method={"renderImage"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$onRenderImage(class_327 font, int x, int y, class_332 graphics, CallbackInfo ci) {
        if (BundleFeatures.onBundleUpdate()) {
            ci.cancel();
            if (this.field_49537.method_57429()) {
                this.renderEmptyBundleTooltip(font, x, y, this.method_32664(font), graphics);
            } else {
                this.renderBundleWithItemsTooltip(font, x, y, this.method_32664(font), graphics);
            }
        }
    }

    @Unique
    private void renderEmptyBundleTooltip(class_327 font, int x, int y, int width, class_332 graphics) {
        this.drawEmptyBundleDescriptionText(x + this.getContentXOffset(width), y, font, graphics);
        this.drawProgressBar(x + this.getContentXOffset(width), y + this.getEmptyBundleDescriptionTextHeight(font) + 4, font, graphics);
    }

    @Unique
    private void renderBundleWithItemsTooltip(class_327 font, int x, int y, int width, class_332 graphics) {
        boolean maxDisplay = this.field_49537.method_57426() > 12;
        List<class_1799> stacks = this.getShownItems(((IBundle)this.field_49537).getNumberOfItemsToShow());
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
    private List<class_1799> getShownItems(int max) {
        int size = Math.min(this.field_49537.method_57426(), max);
        return this.field_49537.method_59707().toList().subList(0, size);
    }

    @Unique
    private boolean shouldRenderSurplusText(boolean maxDisplay, int column, int row) {
        return maxDisplay && column * row == 1;
    }

    @Unique
    private boolean shouldRenderItemSlot(List<class_1799> items, int itemIndex) {
        return items.size() >= itemIndex;
    }

    @Unique
    private int getAmountOfHiddenItems(List<class_1799> items) {
        return this.field_49537.method_59707().skip(items.size()).mapToInt(class_1799::method_7947).sum();
    }

    @Unique
    private void renderSlot(int index, int x, int y, List<class_1799> stacks, int seed, class_327 font, class_332 graphics) {
        int itemIndex = stacks.size() - index;
        boolean hasSelectedItem = itemIndex == this.getSelectedItem();
        class_1799 stack = stacks.get(itemIndex);
        if (hasSelectedItem) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            graphics.method_25291(BUNDLE_SLOT_HIGHLIGHT_BACK_TEXTURE, x, y, 0, 0.0f, 0.0f, 24, 24, 24, 24);
            RenderSystem.disableBlend();
        } else {
            graphics.method_25291(BUNDLE_SLOT_BACKGROUND_TEXTURE, x, y, 0, 0.0f, 0.0f, 24, 24, 24, 24);
        }
        graphics.method_51428(stack, x + 4, y + 4, seed);
        graphics.method_51431(font, stack, x + 4, y + 4);
        if (hasSelectedItem) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            graphics.method_25291(BUNDLE_SLOT_HIGHLIGHT_FRONT_TEXTURE, x, y, 0, 0.0f, 0.0f, 24, 24, 24, 24);
            RenderSystem.disableBlend();
        }
    }

    @Unique
    private void renderCount(int x, int y, int value, class_327 font, class_332 graphics) {
        graphics.method_25300(font, "+" + value, x + 12, y + 10, -1);
    }

    @Unique
    private void drawSelectedItemTooltip(class_327 font, class_332 graphics, int x, int y, int width) {
        if (this.hasSelectedItem()) {
            class_1799 stack = this.field_49537.method_57422(this.getSelectedItem());
            class_5250 component = class_2561.method_43473().method_10852(stack.method_7964()).method_27692(stack.method_7932().method_58413());
            if (stack.method_57826(class_9334.field_49631)) {
                component.method_27692(class_124.field_1056);
            }
            int textWidth = font.method_30880(component.method_30937());
            int xOffset = x + width / 2 - 12;
            graphics.method_51438(font, (class_2561)component, xOffset - textWidth / 2, y - 15);
        }
    }

    @Unique
    private void drawProgressBar(int x, int y, class_327 textRenderer, class_332 graphics) {
        graphics.method_52706(this.getProgressBarTexture(), x + 1, y, this.getProgressBarFill(), 13);
        graphics.method_52706(PROGRESSBAR_BORDER_SPRITE, x, y, 96, 13);
        class_2561 component = this.getProgressBarFillText();
        if (component != null) {
            graphics.method_27534(textRenderer, component, x + 48, y + 3, -1);
        }
    }

    @Unique
    private void drawEmptyBundleDescriptionText(int x, int y, class_327 font, class_332 graphics) {
        graphics.method_51440(font, (class_5348)BUNDLE_EMPTY_DESCRIPTION, x, y, 96, -5592406);
    }

    @Unique
    private int getEmptyBundleDescriptionTextHeight(class_327 font) {
        return font.method_1728((class_5348)BUNDLE_EMPTY_DESCRIPTION, 96).size() * 9;
    }

    @Unique
    private int getProgressBarFill() {
        return class_3532.method_15340((int)class_3532.method_59515((Fraction)this.field_49537.method_57428(), (int)94), (int)0, (int)94);
    }

    @Unique
    private class_2960 getProgressBarTexture() {
        return this.field_49537.method_57428().compareTo(Fraction.ONE) >= 0 ? PROGRESSBAR_FULL_SPRITE : PROGRESSBAR_FILL_SPRITE;
    }

    @Unique
    @Nullable
    private class_2561 getProgressBarFillText() {
        if (this.field_49537.method_57429()) {
            return BUNDLE_EMPTY;
        }
        return this.field_49537.method_57428().compareTo(Fraction.ONE) >= 0 ? BUNDLE_FULL : null;
    }
}

