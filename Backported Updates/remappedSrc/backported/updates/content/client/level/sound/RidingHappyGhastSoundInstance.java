/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1101
 *  net.minecraft.class_1113
 *  net.minecraft.class_1113$class_1114
 *  net.minecraft.class_1657
 *  net.minecraft.class_3532
 */
package backported.updates.content.client.level.sound;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1101;
import net.minecraft.class_1113;
import net.minecraft.class_1657;
import net.minecraft.class_3532;

@Environment(value=EnvType.CLIENT)
public class RidingHappyGhastSoundInstance
extends class_1101 {
    private static final float VOLUME_MIN = 0.0f;
    private static final float VOLUME_MAX = 1.0f;
    private final class_1657 player;
    private final HappyGhast happyGhast;

    public RidingHappyGhastSoundInstance(class_1657 player, HappyGhast happyGhast) {
        super(ModSoundEvents.HAPPY_GHAST_RIDING.get(), happyGhast.method_5634(), class_1113.method_43221());
        this.player = player;
        this.happyGhast = happyGhast;
        this.field_5440 = class_1113.class_1114.field_5478;
        this.field_5446 = true;
        this.field_5451 = 0;
        this.field_5442 = 0.0f;
    }

    public boolean method_4785() {
        return true;
    }

    public void method_16896() {
        if (!this.happyGhast.method_31481() && this.player.method_5765() && this.player.method_5854() == this.happyGhast) {
            float speed = (float)this.happyGhast.method_18798().method_1033();
            this.field_5442 = speed >= 0.01f ? 5.0f * class_3532.method_37166((float)0.0f, (float)1.0f, (float)speed) : 0.0f;
        } else {
            this.method_24876();
        }
    }
}

