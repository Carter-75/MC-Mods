/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11
 *  net.minecraft.class_4459
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.world.level.pathfinder;

import java.util.Set;
import net.minecraft.class_11;
import net.minecraft.class_4459;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_11.class})
public interface PathAccessor {
    @Accessor(value="targetNodes")
    public Set<class_4459> getTargetNodes();
}

