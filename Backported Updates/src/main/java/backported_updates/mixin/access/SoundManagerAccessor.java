/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.SoundSystem
 *  net.minecraft.client.sound.SoundManager
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.access;

import net.minecraft.client.sound.SoundSystem;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SoundManager.class})
public interface SoundManagerAccessor {
    @Accessor
    public SoundSystem getSoundSystem();
}

