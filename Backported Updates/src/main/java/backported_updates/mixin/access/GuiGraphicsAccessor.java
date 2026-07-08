/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.texture.Sprite
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.texture.Scaling$NineSlice
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.client.texture.Sprite;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.Scaling;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={DrawContext.class})
public interface GuiGraphicsAccessor {
    @Invoker
    public void callDrawSprite(Sprite var1, Scaling.NineSlice var2, int var3, int var4, int var5, int var6, int var7);
}

