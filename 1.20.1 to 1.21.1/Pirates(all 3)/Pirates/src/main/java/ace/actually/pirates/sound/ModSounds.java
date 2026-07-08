/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_7923
 */
package ace.actually.pirates.sound;

import ace.actually.pirates.Pirates;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;

public class ModSounds {
    public static class_3414 CANNONBALL_SHOT = ModSounds.registerSoundEvent("cannonball_shot");

    private static class_3414 registerSoundEvent(String name) {
        class_2960 id = new class_2960("pirates", name);
        return (class_3414)class_2378.method_10230((class_2378)class_7923.field_41172, (class_2960)id, (Object)class_3414.method_47908((class_2960)id));
    }

    public static void registerSounds() {
        Pirates.LOGGER.info("Registering sounds");
    }
}

