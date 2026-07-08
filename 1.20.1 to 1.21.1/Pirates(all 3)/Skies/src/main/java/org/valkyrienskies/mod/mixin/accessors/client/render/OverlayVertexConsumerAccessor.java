/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4583
 *  net.minecraft.class_4588
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.client.render;

import net.minecraft.class_4583;
import net.minecraft.class_4588;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_4583.class})
public interface OverlayVertexConsumerAccessor {
    @Accessor(value="delegate")
    public class_4588 getDelegate();
}

