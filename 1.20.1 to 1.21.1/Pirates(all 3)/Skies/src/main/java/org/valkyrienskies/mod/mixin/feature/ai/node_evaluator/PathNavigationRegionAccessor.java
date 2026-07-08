/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_1950
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.feature.ai.node_evaluator;

import net.minecraft.class_1937;
import net.minecraft.class_1950;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1950.class})
public interface PathNavigationRegionAccessor {
    @Accessor(value="level")
    public class_1937 getLevel();
}

