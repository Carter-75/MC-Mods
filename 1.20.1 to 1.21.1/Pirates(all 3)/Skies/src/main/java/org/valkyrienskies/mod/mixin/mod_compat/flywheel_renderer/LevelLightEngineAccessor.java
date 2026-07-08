/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3558
 *  net.minecraft.class_3568
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.mod_compat.flywheel_renderer;

import net.minecraft.class_3558;
import net.minecraft.class_3568;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_3568.class})
public interface LevelLightEngineAccessor {
    @Accessor(value="blockEngine")
    public void setBlockLightEngine(class_3558<?, ?> var1);

    @Accessor(value="blockEngine")
    public class_3558<?, ?> getBlockLightEngine();
}

