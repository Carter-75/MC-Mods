/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.wolf.WolfSoundVariant;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.registry.RegistryKey;

public class WolfSoundVariants {
    public static final RegistryKey<WolfSoundVariant> CLASSIC = WolfSoundVariants.register(SoundSet.CLASSIC, SoundEvents.ENTITY_WOLF_AMBIENT, SoundEvents.ENTITY_WOLF_DEATH, SoundEvents.ENTITY_WOLF_GROWL, SoundEvents.ENTITY_WOLF_HURT, SoundEvents.ENTITY_WOLF_PANT, SoundEvents.ENTITY_WOLF_WHINE);
    public static final RegistryKey<WolfSoundVariant> PUGLIN = WolfSoundVariants.register(SoundSet.PUGLIN, ModSoundEvents.WOLF_PUGLIN_AMBIENT.get(), ModSoundEvents.WOLF_PUGLIN_DEATH.get(), ModSoundEvents.WOLF_PUGLIN_GROWL.get(), ModSoundEvents.WOLF_PUGLIN_HURT.get(), ModSoundEvents.WOLF_PUGLIN_PANT.get(), ModSoundEvents.WOLF_PUGLIN_WHINE.get());
    public static final RegistryKey<WolfSoundVariant> SAD = WolfSoundVariants.register(SoundSet.SAD, ModSoundEvents.WOLF_SAD_AMBIENT.get(), ModSoundEvents.WOLF_SAD_DEATH.get(), ModSoundEvents.WOLF_SAD_GROWL.get(), ModSoundEvents.WOLF_SAD_HURT.get(), ModSoundEvents.WOLF_SAD_PANT.get(), ModSoundEvents.WOLF_SAD_WHINE.get());
    public static final RegistryKey<WolfSoundVariant> ANGRY = WolfSoundVariants.register(SoundSet.ANGRY, ModSoundEvents.WOLF_ANGRY_AMBIENT.get(), ModSoundEvents.WOLF_ANGRY_DEATH.get(), ModSoundEvents.WOLF_ANGRY_GROWL.get(), ModSoundEvents.WOLF_ANGRY_HURT.get(), ModSoundEvents.WOLF_ANGRY_PANT.get(), ModSoundEvents.WOLF_ANGRY_WHINE.get());
    public static final RegistryKey<WolfSoundVariant> GRUMPY = WolfSoundVariants.register(SoundSet.GRUMPY, ModSoundEvents.WOLF_GRUMPY_AMBIENT.get(), ModSoundEvents.WOLF_GRUMPY_DEATH.get(), ModSoundEvents.WOLF_GRUMPY_GROWL.get(), ModSoundEvents.WOLF_GRUMPY_HURT.get(), ModSoundEvents.WOLF_GRUMPY_PANT.get(), ModSoundEvents.WOLF_GRUMPY_WHINE.get());
    public static final RegistryKey<WolfSoundVariant> BIG = WolfSoundVariants.register(SoundSet.BIG, ModSoundEvents.WOLF_BIG_AMBIENT.get(), ModSoundEvents.WOLF_BIG_DEATH.get(), ModSoundEvents.WOLF_BIG_GROWL.get(), ModSoundEvents.WOLF_BIG_HURT.get(), ModSoundEvents.WOLF_BIG_PANT.get(), ModSoundEvents.WOLF_BIG_WHINE.get());
    public static final RegistryKey<WolfSoundVariant> CUTE = WolfSoundVariants.register(SoundSet.CUTE, ModSoundEvents.WOLF_CUTE_AMBIENT.get(), ModSoundEvents.WOLF_CUTE_DEATH.get(), ModSoundEvents.WOLF_CUTE_GROWL.get(), ModSoundEvents.WOLF_CUTE_HURT.get(), ModSoundEvents.WOLF_CUTE_PANT.get(), ModSoundEvents.WOLF_CUTE_WHINE.get());

    public static void bootstrap() {
        VanillaBackport.LOGGER.info("Wolf sound variants registered: {}", ModBuiltinRegistries.WOLF_SOUND_VARIANTS.entries().size());
    }

    private static RegistryKey<WolfSoundVariant> register(SoundSet soundSet, SoundEvent ambient, SoundEvent death, SoundEvent growl, SoundEvent hurt, SoundEvent pant, SoundEvent whine) {
        return ModBuiltinRegistries.WOLF_SOUND_VARIANTS.resource(soundSet.getIdentifier(), new WolfSoundVariant(ambient, death, growl, hurt, pant, whine));
    }

    public static enum SoundSet {
        CLASSIC("classic"),
        PUGLIN("puglin"),
        SAD("sad"),
        ANGRY("angry"),
        GRUMPY("grumpy"),
        BIG("big"),
        CUTE("cute");

        private final String identifier;

        private SoundSet(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return this.identifier;
        }
    }
}

