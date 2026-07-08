/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.client.gui.Element
 *  net.minecraft.client.gui.Drawable
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.client.gui.Selectable
 *  net.minecraft.client.gui.Selectable$SelectionType
 *  net.minecraft.client.gui.screen.narration.NarrationPart
 *  net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
 *  net.minecraft.client.gui.navigation.GuiNavigationType
 *  net.minecraft.client.gui.navigation.GuiNavigationPath
 *  net.minecraft.client.gui.navigation.GuiNavigation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.client.gui.widget;

import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Drawable;
import net.minecraft.text.StringVisitable;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.narration.NarrationPart;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.navigation.GuiNavigationType;
import net.minecraft.client.gui.navigation.GuiNavigationPath;
import net.minecraft.client.gui.navigation.GuiNavigation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractWidget
implements Drawable,
Element,
Selectable {
    protected final TextRenderer font;
    protected boolean focused;
    protected boolean hovered;

    protected AbstractWidget() {
        this.font = MinecraftClient.getInstance().textRenderer;
    }

    protected void drawString(DrawContext graphics, String text, int x, int y, int color) {
        graphics.drawTextWithShadow(this.font, text, x, y, color);
    }

    protected void drawString(DrawContext graphics, Text text, int x, int y, int color) {
        graphics.drawTextWithShadow(this.font, text, x, y, color);
    }

    public boolean isHovered() {
        return this.hovered;
    }

    protected void drawRect(DrawContext graphics, int x1, int y1, int x2, int y2, int color) {
        graphics.fill(x1, y1, x2, y2, color);
    }

    protected void playClickSound() {
        MinecraftClient.getInstance().getSoundManager().play((SoundInstance)PositionedSoundInstance.master((SoundEvent)((SoundEvent)SoundEvents.UI_BUTTON_CLICK.value()), (float)1.0f));
    }

    protected int getStringWidth(StringVisitable text) {
        return this.font.getWidth(text);
    }

    public // Could not load outer class - annotation placement on inner may be incorrect
    @NotNull Selectable.SelectionType getType() {
        if (this.focused) {
            return Selectable.SelectionType.FOCUSED;
        }
        if (this.hovered) {
            return Selectable.SelectionType.HOVERED;
        }
        return Selectable.SelectionType.NONE;
    }

    public void appendNarrations(NarrationMessageBuilder builder) {
        if (this.focused) {
            builder.put(NarrationPart.USAGE, (Text)Text.translatable((String)"narration.button.usage.focused"));
        } else if (this.hovered) {
            builder.put(NarrationPart.USAGE, (Text)Text.translatable((String)"narration.button.usage.hovered"));
        }
    }

    @Nullable
    public GuiNavigationPath getNavigationPath(GuiNavigation event) {
        return !this.isFocused() ? GuiNavigationPath.of((Element)this) : null;
    }

    public boolean isFocused() {
        return this.focused;
    }

    public void setFocused(boolean focused) {
        if (!focused) {
            this.focused = false;
        } else {
            GuiNavigationType inputType = MinecraftClient.getInstance().getNavigationType();
            if (inputType == GuiNavigationType.KEYBOARD_TAB || inputType == GuiNavigationType.KEYBOARD_ARROW) {
                this.focused = true;
            }
        }
    }

    protected void drawBorder(DrawContext graphics, int x1, int y1, int x2, int y2, int color) {
        graphics.fill(x1, y1, x2, y1 + 1, color);
        graphics.fill(x1, y2 - 1, x2, y2, color);
        graphics.fill(x1, y1, x1 + 1, y2, color);
        graphics.fill(x2 - 1, y1, x2, y2, color);
    }
}

