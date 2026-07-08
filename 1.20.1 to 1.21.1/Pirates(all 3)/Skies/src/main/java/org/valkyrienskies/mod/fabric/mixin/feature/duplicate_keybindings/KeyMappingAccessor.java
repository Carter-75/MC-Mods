/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_3675$class_306
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.fabric.mixin.feature.duplicate_keybindings;

import net.minecraft.class_304;
import net.minecraft.class_3675;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_304.class})
public interface KeyMappingAccessor {
    @Accessor
    public class_3675.class_306 getKey();

    @Accessor
    public int getClickCount();

    @Accessor
    public void setClickCount(int var1);
}

