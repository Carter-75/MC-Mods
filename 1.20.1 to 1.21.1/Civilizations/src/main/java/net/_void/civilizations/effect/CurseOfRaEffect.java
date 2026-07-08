/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_4081
 */
package net._void.civilizations.effect;

import java.util.Random;
import net.minecraft.class_1291;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_4081;

public class CurseOfRaEffect
extends class_1291 {
    protected CurseOfRaEffect(class_4081 category, int color) {
        super(category, color);
    }

    public void method_5572(class_1309 pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.method_37908().method_8608()) {
            for (int i = 0; i < 3; ++i) {
                class_2338 pos;
                Random rand = new Random();
                int x = (int)pLivingEntity.method_23317() + rand.nextInt(11) - 5;
                int y = (int)pLivingEntity.method_23318() + rand.nextInt(3) + 4;
                int z = (int)pLivingEntity.method_23321() + rand.nextInt(11) - 5;
                class_1937 world = pLivingEntity.method_37908();
                class_2680 stateInBlock = world.method_8320(pos = new class_2338(x, y, z));
                if (!stateInBlock.method_27852(class_2246.field_10124)) continue;
                class_2680 state = stateInBlock.method_27852(class_2246.field_10102) ? stateInBlock : class_2246.field_10102.method_9564();
                world.method_8501(pos, state);
            }
        }
        super.method_5572(pLivingEntity, pAmplifier);
    }

    public boolean method_5552(int pDuration, int pAmplifier) {
        return true;
    }
}

