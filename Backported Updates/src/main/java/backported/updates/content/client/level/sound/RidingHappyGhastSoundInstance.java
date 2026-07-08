/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.sound.MovingSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.client.sound.SoundInstance$AttenuationType
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.MathHelper
 */
package backported.updates.content.client.level.sound;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class RidingHappyGhastSoundInstance
extends MovingSoundInstance {
    private static final float VOLUME_MIN = 0.0f;
    private static final float VOLUME_MAX = 1.0f;
    private final PlayerEntity player;
    private final HappyGhast happyGhast;

    public RidingHappyGhastSoundInstance(PlayerEntity player, HappyGhast happyGhast) {
        super(ModSoundEvents.HAPPY_GHAST_RIDING.get(), happyGhast.getSoundCategory(), SoundInstance.createRandom());
        this.player = player;
        this.happyGhast = happyGhast;
        this.attenuationType = SoundInstance.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 0.0f;
    }

    public boolean shouldAlwaysPlay() {
        return true;
    }

    public void tick() {
        if (!this.happyGhast.isRemoved() && this.player.hasVehicle() && this.player.getVehicle() == this.happyGhast) {
            float speed = (float)this.happyGhast.getVelocity().length();
            this.volume = speed >= 0.01f ? 5.0f * MathHelper.clampedLerp((float)0.0f, (float)1.0f, (float)speed) : 0.0f;
        } else {
            this.setDone();
        }
    }
}

