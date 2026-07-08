/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_4081
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 */
package net._void.civilizations.effect;

import net._void.civilizations.Civilizations;
import net._void.civilizations.effect.CurseOfRaEffect;
import net.minecraft.class_1291;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4081;
import net.minecraft.class_6880;
import net.minecraft.class_7923;

public class ModEffects {
    public static final class_6880<class_1291> CURSE_OF_RA = ModEffects.registerStatusEffect("curse_of_ra", new CurseOfRaEffect(class_4081.field_18273, 16765007));

    private static class_6880<class_1291> registerStatusEffect(String name, class_1291 statusEffect) {
        return class_2378.method_47985((class_2378)class_7923.field_41174, (class_2960)class_2960.method_43902((String)"civilizations", (String)name), (Object)statusEffect);
    }

    public static void registerEffects() {
        Civilizations.LOGGER.info("Registering Mod Effects for civilizations");
    }
}

