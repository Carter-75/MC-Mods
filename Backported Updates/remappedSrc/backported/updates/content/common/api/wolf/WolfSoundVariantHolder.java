/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1493
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.common.api.wolf.WolfSoundVariant;
import net.minecraft.class_1493;

public interface WolfSoundVariantHolder {
    public static WolfSoundVariantHolder of(class_1493 wolf) {
        if (wolf instanceof WolfSoundVariantHolder) {
            WolfSoundVariantHolder holder = (WolfSoundVariantHolder)wolf;
            return holder;
        }
        return null;
    }

    public WolfSoundVariant getSoundVariant();

    public void setSoundVariant(WolfSoundVariant var1);
}

