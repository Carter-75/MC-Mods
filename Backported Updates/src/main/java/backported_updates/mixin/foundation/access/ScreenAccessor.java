/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Element
 *  net.minecraft.client.gui.Drawable
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.Selectable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import java.util.List;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.Selectable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Screen.class})
public interface ScreenAccessor {
    @Accessor
    public List<Selectable> getSelectables();

    @Accessor
    public List<Drawable> getDrawables();

    @Invoker
    public <T extends Element & Drawable> T callAddDrawableChild(T var1);

    @Invoker
    public <T extends Drawable> T callAddDrawable(T var1);

    @Invoker
    public <T extends Element & Selectable> T callAddSelectableChild(T var1);
}

