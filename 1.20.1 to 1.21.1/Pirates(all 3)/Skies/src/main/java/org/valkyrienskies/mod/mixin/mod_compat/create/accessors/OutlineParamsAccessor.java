/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.outliner.Outline$OutlineParams
 *  net.createmod.catnip.render.BindableTexture
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.accessors;

import net.createmod.catnip.outliner.Outline;
import net.createmod.catnip.render.BindableTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Outline.OutlineParams.class})
public interface OutlineParamsAccessor {
    @Accessor(value="alpha")
    public float getAlpha();

    @Accessor(value="alpha")
    public void setAlpha(float var1);

    @Accessor
    public boolean getDisableCull();

    @Accessor
    public BindableTexture getFaceTexture();
}

