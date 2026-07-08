/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3419
 *  net.minecraft.class_3481
 *  net.minecraft.class_5819
 */
package backported.updates.content.client.level.sound;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.core.data.tags.ModBlockTags;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2902;
import net.minecraft.class_3419;
import net.minecraft.class_3481;
import net.minecraft.class_5819;

public class AmbientDesertBlockSoundsPlayer {
    private static final int IDLE_SOUND_CHANCE = 2100;
    private static final int DRY_GRASS_SOUND_CHANCE = 200;
    private static final int DEAD_BUSH_SOUND_CHANCE = 130;
    private static final int DEAD_BUSH_SOUND_BADLANDS_DECREASED_CHANCE = 3;
    private static final int SURROUNDING_BLOCKS_PLAY_SOUND_THRESHOLD = 3;
    private static final int SURROUNDING_BLOCKS_DISTANCE_HORIZONTAL_CHECK = 8;
    private static final int SURROUNDING_BLOCKS_DISTANCE_VERTICAL_CHECK = 5;
    private static final int HORIZONTAL_DIRECTIONS = 4;

    public static void playAmbientSandSounds(class_1937 level, class_2338 pos, class_5819 random) {
        if (!level.method_8320(pos).method_26164(class_3481.field_15466)) {
            return;
        }
        if (level.method_8320(pos.method_10084()).method_27852(class_2246.field_10124) && random.method_43048(2100) == 0 && AmbientDesertBlockSoundsPlayer.shouldPlayAmbientSandSound(level, pos)) {
            level.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), ModSoundEvents.SAND_IDLE.get(), class_3419.field_15256, 1.0f, 1.0f, false);
        }
    }

    public static void playAmbientDryGrassSounds(class_1937 level, class_2338 pos, class_5819 random) {
        if (random.method_43048(200) == 0 && AmbientDesertBlockSoundsPlayer.shouldPlayDesertDryVegetationBlockSounds(level, pos.method_10074())) {
            level.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), ModSoundEvents.DRY_GRASS.get(), class_3419.field_15256, 1.0f, 1.0f, false);
        }
    }

    public static void playAmbientDeadBushSounds(class_1937 level, class_2338 pos, class_5819 random) {
        if (random.method_43048(130) == 0) {
            class_2680 state = level.method_8320(pos.method_10074());
            if ((state.method_27852(class_2246.field_10534) || state.method_26164(class_3481.field_36265)) && random.method_43048(3) != 0) {
                return;
            }
            if (AmbientDesertBlockSoundsPlayer.shouldPlayDesertDryVegetationBlockSounds(level, pos.method_10074())) {
                level.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), ModSoundEvents.DEAD_BUSH_IDLE.get(), class_3419.field_15256, 1.0f, 1.0f, false);
            }
        }
    }

    public static boolean shouldPlayDesertDryVegetationBlockSounds(class_1937 level, class_2338 pos) {
        return level.method_8320(pos).method_26164(ModBlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS) && level.method_8320(pos.method_10074()).method_26164(ModBlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS);
    }

    private static boolean shouldPlayAmbientSandSound(class_1937 level, class_2338 pos) {
        int found = 0;
        int checked = 0;
        class_2338.class_2339 mutable = pos.method_25503();
        for (class_2350 direction : class_2350.class_2353.field_11062) {
            int remaining;
            int possible;
            mutable.method_10101((class_2382)pos).method_10104(direction, 8);
            if (AmbientDesertBlockSoundsPlayer.columnContainsTriggeringBlock(level, mutable) && found++ >= 3) {
                return true;
            }
            if ((possible = (remaining = 4 - ++checked) + found) >= 3) continue;
            return false;
        }
        return false;
    }

    private static boolean columnContainsTriggeringBlock(class_1937 level, class_2338.class_2339 mutable) {
        int surfaceY = level.method_8624(class_2902.class_2903.field_13202, mutable.method_10263(), mutable.method_10260()) - 1;
        if (Math.abs(surfaceY - mutable.method_10264()) > 5) {
            mutable.method_10104(class_2350.field_11036, 6);
            class_2680 state = level.method_8320((class_2338)mutable);
            mutable.method_10098(class_2350.field_11033);
            for (int i = 0; i < 10; ++i) {
                class_2680 localState = level.method_8320((class_2338)mutable);
                if (state.method_26215() && AmbientDesertBlockSoundsPlayer.canTriggerAmbientDesertSandSounds(localState)) {
                    return true;
                }
                state = localState;
                mutable.method_10098(class_2350.field_11033);
            }
            return false;
        }
        boolean hasAirAbove = level.method_8320((class_2338)mutable.method_33098(surfaceY + 1)).method_26215();
        return hasAirAbove && AmbientDesertBlockSoundsPlayer.canTriggerAmbientDesertSandSounds(level.method_8320((class_2338)mutable.method_33098(surfaceY)));
    }

    private static boolean canTriggerAmbientDesertSandSounds(class_2680 state) {
        return state.method_26164(ModBlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS);
    }
}

