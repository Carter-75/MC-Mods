/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableSet
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1308
 *  net.minecraft.class_3218
 *  net.minecraft.class_4095
 *  net.minecraft.class_4095$class_5303
 *  net.minecraft.class_4101
 *  net.minecraft.class_4110
 *  net.minecraft.class_4112
 *  net.minecraft.class_4118
 *  net.minecraft.class_4120
 *  net.minecraft.class_4125
 *  net.minecraft.class_4140
 *  net.minecraft.class_4148
 *  net.minecraft.class_4149
 *  net.minecraft.class_4168
 *  net.minecraft.class_4818
 *  net.minecraft.class_4822
 *  net.minecraft.class_4824
 *  net.minecraft.class_4828
 *  net.minecraft.class_6019
 *  net.minecraft.class_7895
 */
package backported.updates.content.common.level.entities.creaking;

import backported.updates.content.common.level.entities.creaking.Creaking;
import backported.updates.content.common.level.entities.creaking.CreakingMeleeAttack;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Set;
import net.minecraft.class_1308;
import net.minecraft.class_3218;
import net.minecraft.class_4095;
import net.minecraft.class_4101;
import net.minecraft.class_4110;
import net.minecraft.class_4112;
import net.minecraft.class_4118;
import net.minecraft.class_4120;
import net.minecraft.class_4125;
import net.minecraft.class_4140;
import net.minecraft.class_4148;
import net.minecraft.class_4149;
import net.minecraft.class_4168;
import net.minecraft.class_4818;
import net.minecraft.class_4822;
import net.minecraft.class_4824;
import net.minecraft.class_4828;
import net.minecraft.class_6019;
import net.minecraft.class_7895;

public class CreakingAi {
    protected static final ImmutableList<? extends class_4149<? extends class_4148<? super Creaking>>> SENSOR_TYPES = ImmutableList.of((Object)class_4149.field_18466, (Object)class_4149.field_18467);
    protected static final ImmutableList<? extends class_4140<?>> MEMORY_TYPES = ImmutableList.of((Object)class_4140.field_18441, (Object)class_4140.field_18442, (Object)class_4140.field_18444, (Object)class_4140.field_22354, (Object)class_4140.field_18446, (Object)class_4140.field_18445, (Object)class_4140.field_19293, (Object)class_4140.field_18449, (Object)class_4140.field_22355, (Object)class_4140.field_22475);

    static void initCoreActivity(class_4095<Creaking> brain) {
        brain.method_18882(class_4168.field_18594, 0, ImmutableList.of((Object)new class_4125(0.8f){

            protected boolean method_19010(class_3218 level, class_1308 owner) {
                Creaking creaking;
                if (owner instanceof Creaking && (creaking = (Creaking)owner).canMove()) {
                    return super.method_19010(level, owner);
                }
                return false;
            }
        }, (Object)new class_4110(45, 90), (Object)new class_4112()));
    }

    static void initIdleActivity(class_4095<Creaking> brain) {
        brain.method_18882(class_4168.field_18595, 10, ImmutableList.of((Object)class_4824.method_47120(Creaking::isActive, creaking -> creaking.method_18868().method_18904(class_4140.field_22354)), (Object)class_7895.method_47067((float)8.0f, (class_6019)class_6019.method_35017((int)30, (int)60)), (Object)new class_4118((List)ImmutableList.of((Object)Pair.of((Object)class_4818.method_47014((float)0.3f), (Object)2), (Object)Pair.of((Object)class_4120.method_47104((float)0.3f, (int)3), (Object)2), (Object)Pair.of((Object)new class_4101(30, 60), (Object)1)))));
    }

    static void initFightActivity(class_4095<Creaking> brain) {
        brain.method_24527(class_4168.field_22396, 10, ImmutableList.of((Object)class_4822.method_47094((float)1.0f), CreakingMeleeAttack.create(Creaking::canMove, 40), (Object)class_4828.method_47132()), class_4140.field_22355);
    }

    public static class_4095.class_5303<Creaking> brainProvider() {
        return class_4095.method_28311(MEMORY_TYPES, SENSOR_TYPES);
    }

    public static class_4095<Creaking> makeBrain(class_4095<Creaking> brain) {
        CreakingAi.initCoreActivity(brain);
        CreakingAi.initIdleActivity(brain);
        CreakingAi.initFightActivity(brain);
        brain.method_18890((Set)ImmutableSet.of((Object)class_4168.field_18594));
        brain.method_18897(class_4168.field_18595);
        brain.method_24536();
        return brain;
    }

    public static void updateActivity(Creaking creaking) {
        if (!creaking.canMove()) {
            creaking.method_18868().method_24536();
        } else {
            creaking.method_18868().method_24531((List)ImmutableList.of((Object)class_4168.field_22396, (Object)class_4168.field_18595));
        }
    }
}

