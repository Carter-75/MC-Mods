/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.trains.graph.TrackNodeLocation
 *  net.minecraft.class_2382
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.simibubi.create.content.trains.graph.TrackNodeLocation;
import net.minecraft.class_2382;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TrackNodeLocation.class})
public abstract class MixinTrackNodeLocation
extends class_2382 {
    public MixinTrackNodeLocation(int i2, int j2, int k2) {
        super(i2, j2, k2);
    }

    @Inject(method={"<init>(DDD)V"}, at={@At(value="RETURN")})
    private void removePrecisionError(double x, double y, double z, CallbackInfo ci) {
        this.method_20787((int)Math.round(x * 2.0));
        this.method_20788((int)Math.round(z * 2.0));
    }
}

