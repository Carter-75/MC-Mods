/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.player.PlayerEntity
 */
package backported.updates.foundation.client.event;

import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;

@Environment(value=EnvType.CLIENT)
public interface FovRendering {
    public static final Event<FovRendering> EVENT = Event.create(FovRendering.class, callback -> (player, fov) -> {
        for (FovRendering render : callback) {
            float newFov = render.setFov(player, fov);
            if (newFov == fov) continue;
            return newFov;
        }
        return fov;
    });

    public float setFov(PlayerEntity var1, float var2);
}

