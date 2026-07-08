/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_631$class_3681
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.accessors.client.world;

import net.minecraft.class_631;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_631.class_3681.class})
public interface ClientChunkCacheStorageAccessor {
    @Invoker(value="inRange")
    public boolean callInRange(int var1, int var2);
}

