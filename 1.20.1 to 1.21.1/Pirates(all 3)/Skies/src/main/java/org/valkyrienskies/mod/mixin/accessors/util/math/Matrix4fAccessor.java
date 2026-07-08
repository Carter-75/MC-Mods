/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.accessors.util.math;

import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Matrix4f.class})
public interface Matrix4fAccessor {
    @Accessor(value="m00")
    public void setM00(float var1);

    @Accessor(value="m01")
    public void setM01(float var1);

    @Accessor(value="m02")
    public void setM02(float var1);

    @Accessor(value="m03")
    public void setM03(float var1);

    @Accessor(value="m10")
    public void setM10(float var1);

    @Accessor(value="m11")
    public void setM11(float var1);

    @Accessor(value="m12")
    public void setM12(float var1);

    @Accessor(value="m13")
    public void setM13(float var1);

    @Accessor(value="m20")
    public void setM20(float var1);

    @Accessor(value="m21")
    public void setM21(float var1);

    @Accessor(value="m22")
    public void setM22(float var1);

    @Accessor(value="m23")
    public void setM23(float var1);

    @Accessor(value="m30")
    public void setM30(float var1);

    @Accessor(value="m31")
    public void setM31(float var1);

    @Accessor(value="m32")
    public void setM32(float var1);

    @Accessor(value="m33")
    public void setM33(float var1);

    @Accessor(value="m00")
    public float getM00();

    @Accessor(value="m01")
    public float getM01();

    @Accessor(value="m02")
    public float getM02();

    @Accessor(value="m03")
    public float getM03();

    @Accessor(value="m10")
    public float getM10();

    @Accessor(value="m11")
    public float getM11();

    @Accessor(value="m12")
    public float getM12();

    @Accessor(value="m13")
    public float getM13();

    @Accessor(value="m20")
    public float getM20();

    @Accessor(value="m21")
    public float getM21();

    @Accessor(value="m22")
    public float getM22();

    @Accessor(value="m23")
    public float getM23();

    @Accessor(value="m30")
    public float getM30();

    @Accessor(value="m31")
    public float getM31();

    @Accessor(value="m32")
    public float getM32();

    @Accessor(value="m33")
    public float getM33();
}

