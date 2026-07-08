/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.widget.ClickableWidget
 *  net.minecraft.client.gui.Element
 *  net.minecraft.client.gui.Drawable
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.Selectable
 */
package backported.updates.foundation.client.event.screen.api;

import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported_updates.mixin.foundation.access.ScreenAccessor;
import java.util.List;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.Selectable;

public class ScreenAccessImpl
implements ScreenAccess {
    private Screen screen;

    public ScreenAccessImpl(Screen screen) {
        this.screen = screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public Screen screen() {
        return this.screen;
    }

    @Override
    public List<Selectable> narratables() {
        return ((ScreenAccessor)this.screen).getSelectables();
    }

    @Override
    public List<Drawable> renderables() {
        return ((ScreenAccessor)this.screen).getDrawables();
    }

    @Override
    public <T extends ClickableWidget & Selectable> T addRenderableWidget(T widget) {
        return (T)((ClickableWidget)((ScreenAccessor)this.screen).callAddDrawableChild(widget));
    }

    @Override
    public <T extends Drawable> T addRenderableOnly(T listener) {
        return ((ScreenAccessor)this.screen).callAddDrawable(listener);
    }

    @Override
    public <T extends Element & Selectable> T addWidget(T listener) {
        return ((ScreenAccessor)this.screen).callAddSelectableChild(listener);
    }
}

