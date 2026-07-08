/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2389
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
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
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2389;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class CopperBarsBlock
extends class_2389 {
    private final class_5955.class_5811 weatheringState;

    public CopperBarsBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public class_5955.class_5811 getWeatheringState() {
        return this.weatheringState;
    }

    public Optional<class_2248> getUnwaxedBlock() {
        return switch (this.weatheringState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of((class_2248)ModBlocks.COPPER_BARS.get());
            case class_5955.class_5811.field_28705 -> Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_BARS.get());
            case class_5955.class_5811.field_28706 -> Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_BARS.get());
            case class_5955.class_5811.field_28707 -> Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_BARS.get());
        };
    }

    private class_2680 copyBarsState(class_2680 from, class_2680 to) {
        return (class_2680)((class_2680)((class_2680)((class_2680)((class_2680)to.method_11657((class_2769)field_10905, (Comparable)((Boolean)from.method_11654((class_2769)field_10905)))).method_11657((class_2769)field_10904, (Comparable)((Boolean)from.method_11654((class_2769)field_10904)))).method_11657((class_2769)field_10907, (Comparable)((Boolean)from.method_11654((class_2769)field_10907)))).method_11657((class_2769)field_10903, (Comparable)((Boolean)from.method_11654((class_2769)field_10903)))).method_11657((class_2769)field_10900, (Comparable)((Boolean)from.method_11654((class_2769)field_10900)));
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        Optional<class_2248> unwaxed;
        if (stack.method_31573(class_3489.field_42612) && (unwaxed = this.getUnwaxedBlock()).isPresent()) {
            class_2680 newState = this.copyBarsState(state, unwaxed.get().method_9564());
            level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3004, pos, 0);
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

