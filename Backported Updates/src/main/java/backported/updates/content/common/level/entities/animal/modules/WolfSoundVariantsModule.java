/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.sound.SoundEvent
 */
package backported.updates.content.common.level.entities.animal.modules;

import backported.updates.content.common.api.wolf.WolfSoundVariantHolder;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.sound.SoundEvent;

public class WolfSoundVariantsModule {
    public static <T extends WolfEntity> SoundEvent getAmbientSound(T wolf) {
        if (!VanillaBackport.COMMON_CONFIG.hasWolfSoundVariants.get().booleanValue()) {
            return null;
        }
        if (wolf.hasAngerTime()) {
            return (SoundEvent)((WolfSoundVariantHolder)wolf).getSoundVariant().growlSound().value();
        }
        if (wolf.getRandom().nextInt(3) == 0) {
            return wolf.isTamed() && wolf.getHealth() < 20.0f ? (SoundEvent)((WolfSoundVariantHolder)wolf).getSoundVariant().whineSound().value() : (SoundEvent)((WolfSoundVariantHolder)wolf).getSoundVariant().pantSound().value();
        }
        return (SoundEvent)((WolfSoundVariantHolder)wolf).getSoundVariant().ambientSound().value();
    }

    public static <T extends WolfEntity> SoundEvent getHurtSound(T wolf) {
        if (!VanillaBackport.COMMON_CONFIG.hasWolfSoundVariants.get().booleanValue()) {
            return null;
        }
        return (SoundEvent)((WolfSoundVariantHolder)wolf).getSoundVariant().hurtSound().value();
    }

    public static <T extends WolfEntity> SoundEvent getDeathSound(T wolf) {
        if (!VanillaBackport.COMMON_CONFIG.hasWolfSoundVariants.get().booleanValue()) {
            return null;
        }
        return (SoundEvent)((WolfSoundVariantHolder)wolf).getSoundVariant().deathSound().value();
    }
}

