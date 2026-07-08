/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2482
 *  net.minecraft.class_265
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.world.level.block;

import net.minecraft.class_2482;
import net.minecraft.class_265;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_2482.class})
public interface SlabBlockAccessor {
    @Accessor(value="BOTTOM_AABB")
    public static class_265 getBottomAABB() {
        throw new AssertionError();
    }

    @Accessor(value="TOP_AABB")
    public static class_265 getTopAABB() {
        throw new AssertionError();
    }
}

