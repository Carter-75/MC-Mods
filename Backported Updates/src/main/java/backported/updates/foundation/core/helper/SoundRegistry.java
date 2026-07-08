/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sound.BlockSoundGroup
 *  net.minecraft.util.Identifier
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.registry.Registries
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import java.util.function.Supplier;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.Registries;

public class SoundRegistry {
    private final CoreRegistry<SoundEvent> sounds;
    private final String modId;

    public static SoundRegistry create(String modId) {
        return new SoundRegistry(modId);
    }

    private SoundRegistry(String modId) {
        this.modId = modId;
        this.sounds = CoreRegistry.create(Registries.SOUND_EVENT, modId);
    }

    public Supplier<SoundEvent> soundEvent(String name) {
        return this.sounds.register(name, () -> SoundEvent.of(Identifier.of((String)this.modId, (String)name)));
    }

    public BlockSoundGroup soundType(float volume, float pitch, Supplier<SoundEvent> breakSound, Supplier<SoundEvent> stepSound, Supplier<SoundEvent> placeSound, Supplier<SoundEvent> hitSound, Supplier<SoundEvent> fallSound) {
        return new SoundTypeImpl(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    public BlockSoundGroup soundType(Supplier<SoundEvent> breakSound, Supplier<SoundEvent> stepSound, Supplier<SoundEvent> placeSound, Supplier<SoundEvent> hitSound, Supplier<SoundEvent> fallSound) {
        return this.soundType(1.0f, 1.0f, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    public void register() {
        this.sounds.register();
    }

    public CoreRegistry<SoundEvent> registry() {
        return this.sounds;
    }

    static class SoundTypeImpl
    extends BlockSoundGroup {
        private final Supplier<SoundEvent> breakSound;
        private final Supplier<SoundEvent> stepSound;
        private final Supplier<SoundEvent> placeSound;
        private final Supplier<SoundEvent> hitSound;
        private final Supplier<SoundEvent> fallSound;

        public SoundTypeImpl(float volume, float pitch, Supplier<SoundEvent> breakSound, Supplier<SoundEvent> stepSound, Supplier<SoundEvent> placeSound, Supplier<SoundEvent> hitSound, Supplier<SoundEvent> fallSound) {
            super(volume, pitch, null, null, null, null, null);
            this.breakSound = breakSound;
            this.stepSound = stepSound;
            this.placeSound = placeSound;
            this.hitSound = hitSound;
            this.fallSound = fallSound;
        }

        public SoundEvent getBreakSound() {
            return this.breakSound.get();
        }

        public SoundEvent getStepSound() {
            return this.stepSound.get();
        }

        public SoundEvent getPlaceSound() {
            return this.placeSound.get();
        }

        public SoundEvent getHitSound() {
            return this.hitSound.get();
        }

        public SoundEvent getFallSound() {
            return this.fallSound.get();
        }
    }
}

