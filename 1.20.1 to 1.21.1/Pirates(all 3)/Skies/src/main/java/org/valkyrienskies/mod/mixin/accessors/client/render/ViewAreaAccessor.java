/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_769
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.accessors.client.render;

import net.minecraft.class_2338;
import net.minecraft.class_769;
import net.minecraft.class_846;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_769.class})
public interface ViewAreaAccessor {
    @Invoker(value="getRenderChunkAt")
    public class_846.class_851 callGetRenderChunkAt(class_2338 var1);
}

