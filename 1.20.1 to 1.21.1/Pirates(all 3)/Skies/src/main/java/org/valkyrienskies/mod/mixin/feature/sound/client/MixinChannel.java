/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4224
 *  org.lwjgl.openal.AL10
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package org.valkyrienskies.mod.mixin.feature.sound.client;

import net.minecraft.class_4224;
import org.joml.Vector3dc;
import org.lwjgl.openal.AL10;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.valkyrienskies.mod.mixinducks.com.mojang.blaze3d.audio.HasOpenALVelocity;

@Mixin(value={class_4224.class})
public class MixinChannel
implements HasOpenALVelocity {
    @Shadow
    @Final
    private int field_18893;

    @Override
    public void setVelocity(Vector3dc velocity) {
        AL10.alSource3f((int)this.field_18893, (int)4102, (float)((float)velocity.x()), (float)((float)velocity.y()), (float)((float)velocity.z()));
    }
}

