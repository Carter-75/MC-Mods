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

import java.util.List;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.Selectable;

public interface ScreenAccess {
    public Screen screen();

    public List<Selectable> narratables();

    public List<Drawable> renderables();

    public <T extends ClickableWidget & Selectable> T addRenderableWidget(T var1);

    public <T extends Drawable> T addRenderableOnly(T var1);

    public <T extends Element & Selectable> T addWidget(T var1);
}

