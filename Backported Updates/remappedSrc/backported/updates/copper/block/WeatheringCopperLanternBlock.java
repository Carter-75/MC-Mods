/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperLanternBlock;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class WeatheringCopperLanternBlock
extends CopperLanternBlock
implements class_5955 {
    public WeatheringCopperLanternBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(weatheringState, properties);
    }

    public static Optional<class_2248> getNextBlock(class_2248 block) {
        if (block == ModBlocks.COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    public static Optional<class_2248> getPreviousBlock(class_2248 block) {
        if (block == ModBlocks.EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.OXIDIZED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    public static Optional<class_2248> getWaxedBlock(class_2248 block) {
        if (block == ModBlocks.COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WAXED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.OXIDIZED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    @Override
    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        Optional<class_2248> previousBlock;
        Optional<class_2248> waxedBlock;
        if (stack.method_31574(class_1802.field_20414) && (waxedBlock = WeatheringCopperLanternBlock.getWaxedBlock(state.method_26204())).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3003, pos, 0);
            if (!level.field_9236) {
                class_2680 newState = waxedBlock.get().method_34725(state);
                level.method_8501(pos, newState);
                if (!player.method_7337()) {
                    stack.method_7934(1);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        if (stack.method_31573(class_3489.field_42612) && (previousBlock = WeatheringCopperLanternBlock.getPreviousBlock(state.method_26204())).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3005, pos, 0);
            if (!level.field_9236) {
                class_2680 newState = previousBlock.get().method_34725(state);
                level.method_8501(pos, newState);
                stack.method_7970(1, (class_1309)player, hand == class_1268.field_5808 ? class_1304.field_6173 : class_1304.field_6171);
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return class_9062.field_47731;
    }

    protected void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        WeatheringHelper.tryWeather(state, level, pos, random, WeatheringCopperLanternBlock::getNextBlock);
    }

    protected boolean method_9542(class_2680 state) {
        return WeatheringHelper.canWeather(state, WeatheringCopperLanternBlock::getNextBlock);
    }

    public class_5955.class_5811 getAge() {
        return this.getWeatheringState();
    }
}

