/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.bluecolored.bluemap.core.map.hires.TileModel
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.mod_compat.bluemap;

import de.bluecolored.bluemap.core.map.hires.TileModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={TileModel.class})
@Pseudo
public interface HiresTileModelAccessor {
    @Accessor(value="position")
    public float[] getPositions();
}

