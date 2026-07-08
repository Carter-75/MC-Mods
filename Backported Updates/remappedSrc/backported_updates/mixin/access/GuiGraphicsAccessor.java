/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1058
 *  net.minecraft.class_332
 *  net.minecraft.class_8690$class_8691
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.class_1058;
import net.minecraft.class_332;
import net.minecraft.class_8690;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_332.class})
public interface GuiGraphicsAccessor {
    @Invoker
    public void callBlitNineSlicedSprite(class_1058 var1, class_8690.class_8691 var2, int var3, int var4, int var5, int var6, int var7);
}

