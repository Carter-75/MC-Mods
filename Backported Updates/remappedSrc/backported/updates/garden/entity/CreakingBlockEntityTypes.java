/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2591
 *  net.minecraft.class_2591$class_2592
 *  net.minecraft.class_2960
 *  net.minecraft.class_7923
 */
package backported.updates.garden.entity;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingHeartBlockEntity;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class CreakingBlockEntityTypes {
    public static class_2591<CreakingHeartBlockEntity> CREAKING_HEART_BLOCK = null;

    public static <T extends class_2591<?>> T register(String path, T blockEntityType) {
        return (T)((class_2591)class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)class_2960.method_60655((String)"iwie", (String)path), blockEntityType));
    }

    public static void initialize() {
    }

    static {
        CREAKING_HEART_BLOCK = CreakingBlockEntityTypes.register("creaking_heart", class_2591.class_2592.method_20528((pos, state) -> new CreakingHeartBlockEntity(CREAKING_HEART_BLOCK, pos, state), (class_2248[])new class_2248[]{Init.CREAKING_HEART}).method_11034(null));
    }
}

