/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_339
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_437
 *  net.minecraft.class_6379
 */
package backported.updates.foundation.client.event.screen.api;

import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported_updates.mixin.foundation.access.ScreenAccessor;
import java.util.List;
import net.minecraft.class_339;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_437;
import net.minecraft.class_6379;

public class ScreenAccessImpl
implements ScreenAccess {
    private class_437 screen;

    public ScreenAccessImpl(class_437 screen) {
        this.screen = screen;
    }

    public void setScreen(class_437 screen) {
        this.screen = screen;
    }

    @Override
    public class_437 screen() {
        return this.screen;
    }

    @Override
    public List<class_6379> narratables() {
        return ((ScreenAccessor)this.screen).getNarratables();
    }

    @Override
    public List<class_4068> renderables() {
        return ((ScreenAccessor)this.screen).getRenderables();
    }

    @Override
    public <T extends class_339 & class_6379> T addRenderableWidget(T widget) {
        return (T)((class_339)((ScreenAccessor)this.screen).callAddRenderableWidget(widget));
    }

    @Override
    public <T extends class_4068> T addRenderableOnly(T listener) {
        return ((ScreenAccessor)this.screen).callAddRenderableOnly(listener);
    }

    @Override
    public <T extends class_364 & class_6379> T addWidget(T listener) {
        return ((ScreenAccessor)this.screen).callAddWidget(listener);
    }
}

