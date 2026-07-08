/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_1959$class_5482
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.access;

import net.minecraft.class_1959;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1959.class})
public interface BiomeAccessor {
    @Accessor
    public class_1959.class_5482 getClimateSettings();
}

