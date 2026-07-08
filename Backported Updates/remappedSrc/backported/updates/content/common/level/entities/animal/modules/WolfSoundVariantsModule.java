/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1493
 *  net.minecraft.class_3414
 */
package backported.updates.content.common.level.entities.animal.modules;

import backported.updates.content.common.api.wolf.WolfSoundVariantHolder;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.class_1493;
import net.minecraft.class_3414;

public class WolfSoundVariantsModule {
    public static <T extends class_1493> class_3414 getAmbientSound(T wolf) {
        if (!VanillaBackport.COMMON_CONFIG.hasWolfSoundVariants.get().booleanValue()) {
            return null;
        }
        if (wolf.method_29511()) {
            return (class_3414)((WolfSoundVariantHolder)wolf).getSoundVariant().growlSound().comp_349();
        }
        if (wolf.method_59922().method_43048(3) == 0) {
            return wolf.method_6181() && wolf.method_6032() < 20.0f ? (class_3414)((WolfSoundVariantHolder)wolf).getSoundVariant().whineSound().comp_349() : (class_3414)((WolfSoundVariantHolder)wolf).getSoundVariant().pantSound().comp_349();
        }
        return (class_3414)((WolfSoundVariantHolder)wolf).getSoundVariant().ambientSound().comp_349();
    }

    public static <T extends class_1493> class_3414 getHurtSound(T wolf) {
        if (!VanillaBackport.COMMON_CONFIG.hasWolfSoundVariants.get().booleanValue()) {
            return null;
        }
        return (class_3414)((WolfSoundVariantHolder)wolf).getSoundVariant().hurtSound().comp_349();
    }

    public static <T extends class_1493> class_3414 getDeathSound(T wolf) {
        if (!VanillaBackport.COMMON_CONFIG.hasWolfSoundVariants.get().booleanValue()) {
            return null;
        }
        return (class_3414)((WolfSoundVariantHolder)wolf).getSoundVariant().deathSound().comp_349();
    }
}

