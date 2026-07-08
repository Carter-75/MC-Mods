/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.foundation.collision.Matrix3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.accessors;

import com.simibubi.create.foundation.collision.Matrix3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Matrix3d.class})
public interface Matrix3dAccessor {
    @Accessor(value="m00")
    public double getM00();

    @Accessor(value="m01")
    public double getM01();

    @Accessor(value="m02")
    public double getM02();

    @Accessor(value="m10")
    public double getM10();

    @Accessor(value="m11")
    public double getM11();

    @Accessor(value="m12")
    public double getM12();

    @Accessor(value="m20")
    public double getM20();

    @Accessor(value="m21")
    public double getM21();

    @Accessor(value="m22")
    public double getM22();
}

