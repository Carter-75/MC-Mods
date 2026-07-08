/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.accessors.resource;

import net.minecraft.class_2960;
import net.minecraft.class_5321;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_5321.class})
public interface ResourceKeyAccessor {
    @Accessor
    public class_2960 getRegistryName();

    @Invoker
    public static <T> class_5321<T> callCreate(class_2960 parent, class_2960 location) {
        throw new AssertionError();
    }
}

