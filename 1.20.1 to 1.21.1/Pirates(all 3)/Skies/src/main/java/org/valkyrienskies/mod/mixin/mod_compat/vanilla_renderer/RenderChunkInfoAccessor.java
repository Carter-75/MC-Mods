/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2350
 *  net.minecraft.class_761$class_762
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.mod_compat.vanilla_renderer;

import net.minecraft.class_2350;
import net.minecraft.class_761;
import net.minecraft.class_846;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_761.class_762.class})
public interface RenderChunkInfoAccessor {
    @Accessor
    public class_846.class_851 getChunk();

    @Invoker(value="<init>")
    public static class_761.class_762 vs$new(class_846.class_851 chunk, @Nullable class_2350 direction, int propagationLevel) {
        throw new AssertionError((Object)"RenderChunkInfoAccessor failed to apply");
    }
}

