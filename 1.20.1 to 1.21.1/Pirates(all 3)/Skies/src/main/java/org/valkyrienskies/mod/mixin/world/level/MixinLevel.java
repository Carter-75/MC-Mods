/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_5321
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package org.valkyrienskies.mod.mixin.world.level;

import net.minecraft.class_1937;
import net.minecraft.class_5321;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.mod.common.util.DimensionIdProvider;
import org.valkyrienskies.mod.mixin.accessors.resource.ResourceKeyAccessor;

@Mixin(value={class_1937.class})
public abstract class MixinLevel
implements DimensionIdProvider {
    @Unique
    private String vsDimensionIdCached = null;

    @Override
    @NotNull
    public String getDimensionId() {
        if (this.vsDimensionIdCached == null) {
            class_5321<class_1937> dim = this.method_27983();
            this.vsDimensionIdCached = ((ResourceKeyAccessor)dim).getRegistryName().toString() + ":" + String.valueOf(dim.method_29177());
        }
        return this.vsDimensionIdCached;
    }

    @Shadow
    public abstract class_5321<class_1937> method_27983();
}

