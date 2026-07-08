/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_5819
 */
package backported.updates.copper.util;

import java.util.Optional;
import java.util.function.Function;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_5819;

public class WeatheringHelper {
    public static final float OXIDATION_CHANCE = 0.05688889f;

    public static boolean tryWeather(class_2680 state, class_3218 level, class_2338 pos, class_5819 random, Function<class_2248, Optional<class_2248>> getNextBlock) {
        Optional<class_2248> nextBlock = getNextBlock.apply(state.method_26204());
        if (nextBlock.isPresent() && random.method_43057() < 0.05688889f) {
            class_2680 newState = nextBlock.get().method_34725(state);
            level.method_8501(pos, newState);
            return true;
        }
        return false;
    }

    public static boolean canWeather(class_2680 state, Function<class_2248, Optional<class_2248>> getNextBlock) {
        return getNextBlock.apply(state.method_26204()).isPresent();
    }
}

