/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.gen.chunk.ChunkGeneratorSettings
 *  net.minecraft.world.gen.surfacebuilder.MaterialRules$MaterialRule
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.access;

import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ChunkGeneratorSettings.class})
public interface NoiseGeneratorSettingsAccessor {
    @Mutable
    @Accessor
    public void setSurfaceRule(MaterialRules.MaterialRule var1);
}

