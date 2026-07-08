/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.trains.track.TrackVisual
 *  dev.engine_room.flywheel.api.visual.LightUpdatedVisual
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.trains.track.TrackVisual;
import dev.engine_room.flywheel.api.visual.LightUpdatedVisual;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={TrackVisual.class})
public abstract class MixinTrackVisual
implements LightUpdatedVisual {
    public void updateLight(float partialTick) {
        this.update(partialTick);
    }
}

