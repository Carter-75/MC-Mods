/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.bearing.MechanicalBearingBlockEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.simibubi.create.content.contraptions.bearing.MechanicalBearingBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={MechanicalBearingBlockEntity.class})
public interface IMixinMechanicalBearingTileEntity {
    @Accessor
    public boolean isAssembleNextTick();
}

