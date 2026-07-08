/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_763
 *  net.minecraft.class_918
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net._void.civilizations.mixin;

import net.minecraft.class_763;
import net.minecraft.class_918;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_918.class})
public interface ItemRendererAccessor {
    @Accessor(value="models")
    public class_763 mccourse$getModels();
}

