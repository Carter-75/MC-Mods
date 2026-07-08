/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.sound.SoundEvent
 */
package backported.updates.copper.entity;

import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;

public record CopperGolemOxidationLevel(SoundEvent spinHeadSound, SoundEvent hurtSound, SoundEvent deathSound, SoundEvent stepSound, Identifier texture, Identifier eyeTexture) {
}

