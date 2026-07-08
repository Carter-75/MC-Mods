/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4227
 *  org.lwjgl.openal.AL10
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.feature.sound.client;

import net.minecraft.class_4227;
import org.joml.Vector3dc;
import org.lwjgl.openal.AL10;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.mod.mixinducks.com.mojang.blaze3d.audio.HasOpenALVelocity;

@Mixin(value={class_4227.class})
public class MixinListener
implements HasOpenALVelocity {
    @Override
    public void setVelocity(Vector3dc velocity) {
        AL10.alListener3f((int)4102, (float)((float)velocity.x()), (float)((float)velocity.y()), (float)((float)velocity.z()));
    }
}

