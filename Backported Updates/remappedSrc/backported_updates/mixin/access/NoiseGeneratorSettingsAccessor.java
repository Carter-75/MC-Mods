/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5284
 *  net.minecraft.class_6686$class_6708
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.access;

import net.minecraft.class_5284;
import net.minecraft.class_6686;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_5284.class})
public interface NoiseGeneratorSettingsAccessor {
    @Mutable
    @Accessor
    public void setSurfaceRule(class_6686.class_6708 var1);
}

