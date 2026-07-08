/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.ghostblock.GhostBlockParams
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.accessors;

import net.createmod.catnip.ghostblock.GhostBlockParams;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GhostBlockParams.class})
public interface GhostBlockParamsAccessor {
    @Accessor(value="pos")
    public class_2338 getPos();

    @Accessor(value="state")
    public class_2680 getState();
}

