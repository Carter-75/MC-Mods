/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_7923
 */
package net._void.civilizations.sound;

import net._void.civilizations.Civilizations;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;

public class ModSounds {
    public static final class_3414 HIGH_MOUNTAINS_AND_FLOWING_WATER = ModSounds.registerSoundEvent("high_mountains_and_flowing_water");
    public static final class_3414 AUTUMN_MOON_OVER_HAN_PALACE = ModSounds.registerSoundEvent("autumn_moon_over_han_palace");
    public static final class_3414 EGYPT_BOSS_MUSIC = ModSounds.registerSoundEvent("egypt_boss_music");
    public static final class_3414 EGYPT_GOD_MUSIC = ModSounds.registerSoundEvent("egypt_god_music");
    public static final class_3414 CHINA_BOSS_MUSIC = ModSounds.registerSoundEvent("china_boss_music");
    public static final class_3414 CHINA_GOD_MUSIC = ModSounds.registerSoundEvent("china_god_music");
    public static final class_3414 NORDIC_BOSS_MUSIC = ModSounds.registerSoundEvent("nordic_boss_music");
    public static final class_3414 NORDIC_GOD_MUSIC = ModSounds.registerSoundEvent("nordic_god_music");
    public static final class_3414 GREECE_BOSS_MUSIC = ModSounds.registerSoundEvent("greece_boss_music");
    public static final class_3414 GREECE_GOD_MUSIC = ModSounds.registerSoundEvent("greece_god_music");
    public static final class_3414 ROME_BOSS_MUSIC = ModSounds.registerSoundEvent("rome_boss_music");
    public static final class_3414 ROME_GOD_MUSIC = ModSounds.registerSoundEvent("rome_god_music");

    private static class_3414 registerSoundEvent(String name) {
        class_2960 id = class_2960.method_43902((String)"civilizations", (String)name);
        return (class_3414)class_2378.method_10230((class_2378)class_7923.field_41172, (class_2960)id, (Object)class_3414.method_47908((class_2960)id));
    }

    public static void registerSounds() {
        Civilizations.LOGGER.info("Registering Mod Sounds for civilizations");
    }
}

