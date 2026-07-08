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
 *  net.minecraft.class_2269
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2738
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_8177
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.block.WaxedCopperButtonBlock;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2738;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_8177;
import net.minecraft.class_9062;

public class CopperButtonBlock
extends class_2269
implements class_5955 {
    private final class_5955.class_5811 weatherState;
    private Supplier<WaxedCopperButtonBlock> waxedButton;

    public CopperButtonBlock(class_5955.class_5811 weatherState, class_4970.class_2251 properties) {
        super(class_8177.field_47100, 15, properties);
        this.weatherState = weatherState;
    }

    public void setWaxedButton(Supplier<WaxedCopperButtonBlock> waxedButton) {
        this.waxedButton = waxedButton;
    }

    public class_5955.class_5811 getAge() {
        return this.weatherState;
    }

    public static Optional<class_2248> getNextBlock(class_2248 block) {
        if (block == ModBlocks.COPPER_BUTTON.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_BUTTON.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_BUTTON.get()) {
            return Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_BUTTON.get());
        }
        return class_5955.method_34737((class_2248)block);
    }

    public static Optional<class_2248> getPreviousBlock(class_2248 block) {
        if (block == ModBlocks.OXIDIZED_COPPER_BUTTON.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_BUTTON.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_BUTTON.get()) {
            return Optional.of((class_2248)ModBlocks.COPPER_BUTTON.get());
        }
        return Optional.empty();
    }

    private Optional<class_2248> getWaxedBlock(class_2248 block) {
        if (this.waxedButton == null) {
            return Optional.empty();
        }
        return Optional.of((class_2248)this.waxedButton.get());
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        if (stack.method_31574(class_1802.field_20414) && this.waxedButton != null) {
            level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3003, pos, 0);
            if (!level.field_9236) {
                class_2680 waxedState = (class_2680)((class_2680)((class_2680)this.waxedButton.get().method_9564().method_11657((class_2769)field_11177, (Comparable)((class_2350)state.method_11654((class_2769)field_11177)))).method_11657((class_2769)field_10729, (Comparable)((Boolean)state.method_11654((class_2769)field_10729)))).method_11657((class_2769)field_11007, (Comparable)((class_2738)state.method_11654((class_2769)field_11007)));
                level.method_8652(pos, waxedState, 11);
                if (!player.method_7337()) {
                    stack.method_7934(1);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        if (stack.method_31573(class_3489.field_42612)) {
            class_2248 previousBlock = null;
            if (this == ModBlocks.OXIDIZED_COPPER_BUTTON.get()) {
                previousBlock = (class_2248)ModBlocks.WEATHERED_COPPER_BUTTON.get();
            } else if (this == ModBlocks.WEATHERED_COPPER_BUTTON.get()) {
                previousBlock = (class_2248)ModBlocks.EXPOSED_COPPER_BUTTON.get();
            } else if (this == ModBlocks.EXPOSED_COPPER_BUTTON.get()) {
                previousBlock = (class_2248)ModBlocks.COPPER_BUTTON.get();
            }
            if (previousBlock != null) {
                level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
                level.method_8444(player, 3005, pos, 0);
                if (!level.field_9236) {
                    class_2680 newState = (class_2680)((class_2680)((class_2680)previousBlock.method_9564().method_11657((class_2769)field_11177, (Comparable)((class_2350)state.method_11654((class_2769)field_11177)))).method_11657((class_2769)field_10729, (Comparable)((Boolean)state.method_11654((class_2769)field_10729)))).method_11657((class_2769)field_11007, (Comparable)((class_2738)state.method_11654((class_2769)field_11007)));
                    level.method_8652(pos, newState, 11);
                    if (!player.method_7337()) {
                        stack.method_7970(1, (class_1309)player, class_1304.field_6173);
                    }
                }
                return class_9062.method_55644((boolean)level.field_9236);
            }
        }
        return class_9062.field_47731;
    }

    protected void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (((Boolean)state.method_11654((class_2769)field_10729)).booleanValue()) {
            return;
        }
        WeatheringHelper.tryWeather(state, level, pos, random, CopperButtonBlock::getNextBlock);
    }

    protected boolean method_9542(class_2680 state) {
        if (((Boolean)state.method_11654((class_2769)field_10729)).booleanValue()) {
            return false;
        }
        return WeatheringHelper.canWeather(state, CopperButtonBlock::getNextBlock);
    }
}

