/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2350
 *  net.minecraft.class_761$class_762
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.mod_compat.optifine;

import net.minecraft.class_2350;
import net.minecraft.class_761;
import net.minecraft.class_846;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_761.class_762.class})
public interface RenderChunkInfoAccessorOptifine {
    @Invoker(value="<init>", remap=false)
    public static class_761.class_762 vs$new(class_846.class_851 chunk, @Nullable class_2350 direction, int propagationLevel) {
        throw new AssertionError((Object)"RenderChunkInfoAccessorOptifine failed to apply");
    }
}

