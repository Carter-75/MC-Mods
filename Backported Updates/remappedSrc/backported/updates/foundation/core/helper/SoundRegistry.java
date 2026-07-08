/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2498
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_7923
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import java.util.function.Supplier;
import net.minecraft.class_2498;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;

public class SoundRegistry {
    private final CoreRegistry<class_3414> sounds;
    private final String modId;

    public static SoundRegistry create(String modId) {
        return new SoundRegistry(modId);
    }

    private SoundRegistry(String modId) {
        this.modId = modId;
        this.sounds = CoreRegistry.create(class_7923.field_41172, modId);
    }

    public Supplier<class_3414> soundEvent(String name) {
        return this.sounds.register(name, () -> class_3414.method_47908((class_2960)class_2960.method_60655((String)this.modId, (String)name)));
    }

    public class_2498 soundType(float volume, float pitch, Supplier<class_3414> breakSound, Supplier<class_3414> stepSound, Supplier<class_3414> placeSound, Supplier<class_3414> hitSound, Supplier<class_3414> fallSound) {
        return new SoundTypeImpl(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    public class_2498 soundType(Supplier<class_3414> breakSound, Supplier<class_3414> stepSound, Supplier<class_3414> placeSound, Supplier<class_3414> hitSound, Supplier<class_3414> fallSound) {
        return this.soundType(1.0f, 1.0f, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    public void register() {
        this.sounds.register();
    }

    public CoreRegistry<class_3414> registry() {
        return this.sounds;
    }

    static class SoundTypeImpl
    extends class_2498 {
        private final Supplier<class_3414> breakSound;
        private final Supplier<class_3414> stepSound;
        private final Supplier<class_3414> placeSound;
        private final Supplier<class_3414> hitSound;
        private final Supplier<class_3414> fallSound;

        public SoundTypeImpl(float volume, float pitch, Supplier<class_3414> breakSound, Supplier<class_3414> stepSound, Supplier<class_3414> placeSound, Supplier<class_3414> hitSound, Supplier<class_3414> fallSound) {
            super(volume, pitch, null, null, null, null, null);
            this.breakSound = breakSound;
            this.stepSound = stepSound;
            this.placeSound = placeSound;
            this.hitSound = hitSound;
            this.fallSound = fallSound;
        }

        public class_3414 method_10595() {
            return this.breakSound.get();
        }

        public class_3414 method_10594() {
            return this.stepSound.get();
        }

        public class_3414 method_10598() {
            return this.placeSound.get();
        }

        public class_3414 method_10596() {
            return this.hitSound.get();
        }

        public class_3414 method_10593() {
            return this.fallSound.get();
        }
    }
}

