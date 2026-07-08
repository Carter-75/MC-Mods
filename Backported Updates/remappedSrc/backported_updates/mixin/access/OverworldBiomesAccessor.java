/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5478
 *  net.minecraft.class_5485$class_5495
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.class_5478;
import net.minecraft.class_5485;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_5478.class})
public interface OverworldBiomesAccessor {
    @Invoker
    public static void callGlobalOverworldGeneration(class_5485.class_5495 builder) {
    }
}

