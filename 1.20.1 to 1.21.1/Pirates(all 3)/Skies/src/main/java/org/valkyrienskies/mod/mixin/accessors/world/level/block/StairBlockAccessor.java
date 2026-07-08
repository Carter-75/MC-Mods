/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2510
 *  net.minecraft.class_265
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.world.level.block;

import net.minecraft.class_2510;
import net.minecraft.class_265;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_2510.class})
public interface StairBlockAccessor {
    @Accessor(value="TOP_SHAPES")
    public static class_265[] getTopShapes() {
        throw new AssertionError();
    }

    @Accessor(value="BOTTOM_SHAPES")
    public static class_265[] getBottomShapes() {
        throw new AssertionError();
    }
}

