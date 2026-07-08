/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.WolfEntity
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.common.api.wolf.WolfSoundVariant;
import net.minecraft.entity.passive.WolfEntity;

public interface WolfSoundVariantHolder {
    public static WolfSoundVariantHolder of(WolfEntity wolf) {
        if (wolf instanceof WolfSoundVariantHolder) {
            WolfSoundVariantHolder holder = (WolfSoundVariantHolder)wolf;
            return holder;
        }
        return null;
    }

    public WolfSoundVariant getSoundVariant();

    public void setSoundVariant(WolfSoundVariant var1);
}

