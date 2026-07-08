/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  net.minecraft.class_3204
 *  net.minecraft.class_3228
 *  net.minecraft.class_4706
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.server.level;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.class_3204;
import net.minecraft.class_3228;
import net.minecraft.class_4706;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_3204.class})
public interface DistanceManagerAccessor {
    @Accessor(value="tickets")
    public Long2ObjectOpenHashMap<class_4706<class_3228<?>>> getTickets();
}

