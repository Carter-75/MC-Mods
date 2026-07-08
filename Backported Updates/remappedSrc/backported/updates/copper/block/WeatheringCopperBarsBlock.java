/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2389
 *  net.minecraft.class_2680
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
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModBlocks;
import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2389;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class WeatheringCopperBarsBlock
extends class_2389
implements class_5955 {
    private final class_5955.class_5811 weatherState;

    public WeatheringCopperBarsBlock(class_5955.class_5811 weatherState, class_4970.class_2251 properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public class_5955.class_5811 getAge() {
        return this.weatherState;
    }

    public Optional<class_2248> getNextBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_BARS.get());
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_BARS.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_BARS.get());
            case class_5955.class_5811.field_28707 -> Optional.empty();
        };
    }

    public Optional<class_2248> getPreviousBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.empty();
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.COPPER_BARS.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_BARS.get());
            case class_5955.class_5811.field_28707 -> Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_BARS.get());
        };
    }

    public Optional<class_2248> getWaxedBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of((class_2248)ModBlocks.WAXED_COPPER_BARS.get());
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_BARS.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_BARS.get());
            case class_5955.class_5811.field_28707 -> Optional.of((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get());
        };
    }

    protected void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        this.method_54764(state, level, pos, random);
    }

    public Optional<class_2680> method_31639(class_2680 state) {
        return this.getNextBlock().map(block -> this.copyBarsState(state, block.method_9564()));
    }

    private class_2680 copyBarsState(class_2680 from, class_2680 to) {
        return (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)to.method_11657((class_2769)field_10905, (Comparable)((Boolean)from.method_11654((class_2769)field_10905)))).method_11657((class_2769)field_10904, (Comparable)((Boolean)from.method_11654((class_2769)field_10904)))).method_11657((class_2769)field_10907, (Comparable)((Boolean)from.method_11654((class_2769)field_10907)))).method_11657((class_2769)field_10903, (Comparable)((Boolean)from.method_11654((class_2769)field_10903)))).method_11657((class_2769)field_10900, (Comparable)((Boolean)from.method_11654((class_2769)field_10900)));
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        Optional<class_2248> previous;
        Optional<class_2248> waxed;
        if (stack.method_31574(class_1802.field_20414) && (waxed = this.getWaxedBlock()).isPresent()) {
            class_2680 newState = this.copyBarsState(state, waxed.get().method_9564());
            level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3003, pos, 0);
            if (!level.field_9236) {
                level.method_8652(pos, newState, 11);
                if (!player.method_7337()) {
                    stack.method_7934(1);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        if (stack.method_31573(class_3489.field_42612) && (previous = this.getPreviousBlock()).isPresent()) {
            class_2680 newState = this.copyBarsState(state, previous.get().method_9564());
            level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3005, pos, 0);
            if (!level.field_9236) {
                level.method_8652(pos, newState, 11);
                if (!player.method_7337()) {
                    stack.method_7970(1, (class_1309)player, player.method_32326(stack));
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return super.method_55765(stack, state, level, pos, player, hand, hitResult);
    }
}

