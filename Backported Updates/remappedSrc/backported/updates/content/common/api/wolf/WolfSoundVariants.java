/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_5321
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.wolf.WolfSoundVariant;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5321;

public class WolfSoundVariants {
    public static final class_5321<WolfSoundVariant> CLASSIC = WolfSoundVariants.register(SoundSet.CLASSIC, class_3417.field_14724, class_3417.field_14659, class_3417.field_14575, class_3417.field_15218, class_3417.field_14922, class_3417.field_14807);
    public static final class_5321<WolfSoundVariant> PUGLIN = WolfSoundVariants.register(SoundSet.PUGLIN, ModSoundEvents.WOLF_PUGLIN_AMBIENT.get(), ModSoundEvents.WOLF_PUGLIN_DEATH.get(), ModSoundEvents.WOLF_PUGLIN_GROWL.get(), ModSoundEvents.WOLF_PUGLIN_HURT.get(), ModSoundEvents.WOLF_PUGLIN_PANT.get(), ModSoundEvents.WOLF_PUGLIN_WHINE.get());
    public static final class_5321<WolfSoundVariant> SAD = WolfSoundVariants.register(SoundSet.SAD, ModSoundEvents.WOLF_SAD_AMBIENT.get(), ModSoundEvents.WOLF_SAD_DEATH.get(), ModSoundEvents.WOLF_SAD_GROWL.get(), ModSoundEvents.WOLF_SAD_HURT.get(), ModSoundEvents.WOLF_SAD_PANT.get(), ModSoundEvents.WOLF_SAD_WHINE.get());
    public static final class_5321<WolfSoundVariant> ANGRY = WolfSoundVariants.register(SoundSet.ANGRY, ModSoundEvents.WOLF_ANGRY_AMBIENT.get(), ModSoundEvents.WOLF_ANGRY_DEATH.get(), ModSoundEvents.WOLF_ANGRY_GROWL.get(), ModSoundEvents.WOLF_ANGRY_HURT.get(), ModSoundEvents.WOLF_ANGRY_PANT.get(), ModSoundEvents.WOLF_ANGRY_WHINE.get());
    public static final class_5321<WolfSoundVariant> GRUMPY = WolfSoundVariants.register(SoundSet.GRUMPY, ModSoundEvents.WOLF_GRUMPY_AMBIENT.get(), ModSoundEvents.WOLF_GRUMPY_DEATH.get(), ModSoundEvents.WOLF_GRUMPY_GROWL.get(), ModSoundEvents.WOLF_GRUMPY_HURT.get(), ModSoundEvents.WOLF_GRUMPY_PANT.get(), ModSoundEvents.WOLF_GRUMPY_WHINE.get());
    public static final class_5321<WolfSoundVariant> BIG = WolfSoundVariants.register(SoundSet.BIG, ModSoundEvents.WOLF_BIG_AMBIENT.get(), ModSoundEvents.WOLF_BIG_DEATH.get(), ModSoundEvents.WOLF_BIG_GROWL.get(), ModSoundEvents.WOLF_BIG_HURT.get(), ModSoundEvents.WOLF_BIG_PANT.get(), ModSoundEvents.WOLF_BIG_WHINE.get());
    public static final class_5321<WolfSoundVariant> CUTE = WolfSoundVariants.register(SoundSet.CUTE, ModSoundEvents.WOLF_CUTE_AMBIENT.get(), ModSoundEvents.WOLF_CUTE_DEATH.get(), ModSoundEvents.WOLF_CUTE_GROWL.get(), ModSoundEvents.WOLF_CUTE_HURT.get(), ModSoundEvents.WOLF_CUTE_PANT.get(), ModSoundEvents.WOLF_CUTE_WHINE.get());

    public static void bootstrap() {
        VanillaBackport.LOGGER.info("Wolf sound variants registered: {}", (Object)ModBuiltinRegistries.WOLF_SOUND_VARIANTS.entries().size());
    }

    private static class_5321<WolfSoundVariant> register(SoundSet soundSet, class_3414 ambient, class_3414 death, class_3414 growl, class_3414 hurt, class_3414 pant, class_3414 whine) {
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

