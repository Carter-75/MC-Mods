/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1309
 *  net.minecraft.class_4095
 *  net.minecraft.class_4095$class_5303
 *  net.minecraft.class_4110
 *  net.minecraft.class_4112
 *  net.minecraft.class_4118
 *  net.minecraft.class_4120
 *  net.minecraft.class_4125
 *  net.minecraft.class_4140
 *  net.minecraft.class_4141
 *  net.minecraft.class_4148
 *  net.minecraft.class_4149
 *  net.minecraft.class_4168
 *  net.minecraft.class_4818
 *  net.minecraft.class_5753
 *  net.minecraft.class_5754
 *  net.minecraft.class_6019
 *  net.minecraft.class_6028
 */
package backported.updates.content.common.level.entities.happyghast;

import backported.updates.content.common.level.entities.happyghast.GhastlingFollowAdult;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.registries.ModSensorTypes;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Set;
import net.minecraft.class_1309;
import net.minecraft.class_4095;
import net.minecraft.class_4110;
import net.minecraft.class_4112;
import net.minecraft.class_4118;
import net.minecraft.class_4120;
import net.minecraft.class_4125;
import net.minecraft.class_4140;
import net.minecraft.class_4141;
import net.minecraft.class_4148;
import net.minecraft.class_4149;
import net.minecraft.class_4168;
import net.minecraft.class_4818;
import net.minecraft.class_5753;
import net.minecraft.class_5754;
import net.minecraft.class_6019;
import net.minecraft.class_6028;

public class HappyGhastAi {
    private static final float IDLE_SPEED = 1.0f;
    private static final float TEMPTED_SPEED = 1.25f;
    private static final float FOLLOWING_ADULT_SPEED = 1.1f;
    private static final double CLOSE_ENOUGH_DIST = 5.0;
    private static final class_6019 ADULT_FOLLOW_RANGE = class_6019.method_35017((int)5, (int)16);
    private static final ImmutableList<class_4149<? extends class_4148<? super HappyGhast>>> SENSOR_TYPES = ImmutableList.of((Object)class_4149.field_18466, (Object)class_4149.field_18469, ModSensorTypes.HAPPY_GHAST_TEMPTATIONS.get(), ModSensorTypes.NEAREST_ADULT_ANY_TYPE.get(), (Object)class_4149.field_18467);
    private static final ImmutableList<class_4140<?>> MEMORY_TYPES = ImmutableList.of((Object)class_4140.field_18445, (Object)class_4140.field_18446, (Object)class_4140.field_19293, (Object)class_4140.field_18449, (Object)class_4140.field_18442, (Object)class_4140.field_28325, (Object)class_4140.field_28326, (Object)class_4140.field_28327, (Object)class_4140.field_18448, (Object)class_4140.field_39408, (Object)class_4140.field_18451, (Object)class_4140.field_25359, (Object[])new class_4140[]{class_4140.field_18443, class_4140.field_18444, class_4140.field_22354});

    public static class_4095.class_5303<HappyGhast> brainProvider() {
        return class_4095.method_28311(MEMORY_TYPES, SENSOR_TYPES);
    }

    protected static class_4095<?> makeBrain(class_4095<HappyGhast> brain) {
        HappyGhastAi.initCoreActivity(brain);
        HappyGhastAi.initIdleActivity(brain);
        HappyGhastAi.initPanicActivity(brain);
        brain.method_18890(Set.of(class_4168.field_18594));
        brain.method_18897(class_4168.field_18595);
        brain.method_24536();
        return brain;
    }

    private static void initCoreActivity(class_4095<HappyGhast> brain) {
        brain.method_18882(class_4168.field_18594, 0, ImmutableList.of((Object)new class_4125(0.8f), (Object)new class_6028(2.0f), (Object)new class_4110(45, 90), (Object)new class_4112(), (Object)new class_5753(class_4140.field_28326)));
    }

    private static void initIdleActivity(class_4095<HappyGhast> brain) {
        brain.method_18881(class_4168.field_18595, ImmutableList.of((Object)Pair.of((Object)1, (Object)new class_5754(entity -> Float.valueOf(1.25f), entity -> 5.0)), (Object)Pair.of((Object)2, GhastlingFollowAdult.create(ADULT_FOLLOW_RANGE, entity -> Float.valueOf(1.1f), (class_4140<? extends class_1309>)class_4140.field_18444)), (Object)Pair.of((Object)3, GhastlingFollowAdult.create(ADULT_FOLLOW_RANGE, entity -> Float.valueOf(1.1f), (class_4140<? extends class_1309>)class_4140.field_25359)), (Object)Pair.of((Object)4, (Object)new class_4118((List)ImmutableList.of((Object)Pair.of((Object)class_4818.method_47025((float)1.0f), (Object)1), (Object)Pair.of((Object)class_4120.method_47104((float)1.0f, (int)3), (Object)1))))));
    }

    private static void initPanicActivity(class_4095<HappyGhast> brain) {
        brain.method_24529(class_4168.field_18599, ImmutableList.of(), Set.of(Pair.of((Object)class_4140.field_39408, (Object)class_4141.field_18456)));
    }

    public static void updateActivity(HappyGhast happyGhast) {
        happyGhast.method_18868().method_24531((List)ImmutableList.of((Object)class_4168.field_18599, (Object)class_4168.field_18595));
    }
}

