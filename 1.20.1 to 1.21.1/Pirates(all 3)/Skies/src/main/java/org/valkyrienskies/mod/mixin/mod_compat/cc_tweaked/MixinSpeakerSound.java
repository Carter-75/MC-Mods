/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dan200.computercraft.client.sound.SpeakerSound
 *  net.minecraft.class_1102
 *  net.minecraft.class_1937
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.cc_tweaked;

import dan200.computercraft.client.sound.SpeakerSound;
import net.minecraft.class_1102;
import net.minecraft.class_1937;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.client.audio.VelocityTickableSoundInstance;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Pseudo
@Mixin(value={SpeakerSound.class}, priority=2000)
public abstract class MixinSpeakerSound
extends class_1102
implements VelocityTickableSoundInstance {
    @Unique
    private Vector3dc position = null;
    @Unique
    private Vector3dc lastPosition = null;
    @Unique
    private Vector3dc velocity = new Vector3d();

    protected MixinSpeakerSound() {
        super((class_2960)null, null, null);
    }

    public double method_4784() {
        return this.position == null ? this.field_5439 : this.position.x();
    }

    public double method_4779() {
        return this.position == null ? this.field_5450 : this.position.y();
    }

    public double method_4778() {
        return this.position == null ? this.field_5449 : this.position.z();
    }

    @Override
    public Vector3dc getVelocity() {
        return this.velocity;
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    public void tick(CallbackInfo ci) {
        this.position = VSGameUtilsKt.toWorldCoordinates((class_1937)class_310.method_1551().field_1687, new Vector3d(this.field_5439, this.field_5450, this.field_5449));
        if (this.lastPosition != null) {
            this.velocity = this.position.sub(this.lastPosition, new Vector3d());
        }
        this.lastPosition = this.position;
    }
}

