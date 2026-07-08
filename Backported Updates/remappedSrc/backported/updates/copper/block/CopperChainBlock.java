/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5172
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
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5172;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class CopperChainBlock
extends class_5172 {
    private final class_5955.class_5811 weatheringState;

    public CopperChainBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public class_5955.class_5811 getWeatheringState() {
        return this.weatheringState;
    }

    public Optional<class_2680> getUnwaxedBlock() {
        return switch (this.weatheringState) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> Optional.of((class_2680)((class_2680)ModBlocks.COPPER_CHAIN.get().method_9564().method_11657((class_2769)field_11459, (Comparable)((class_2350.class_2351)this.method_9564().method_11654((class_2769)field_11459)))).method_11657((class_2769)field_24411, (Comparable)((Boolean)this.method_9564().method_11654((class_2769)field_24411))));
            case class_5955.class_5811.field_28705 -> Optional.of((class_2680)((class_2680)ModBlocks.EXPOSED_COPPER_CHAIN.get().method_9564().method_11657((class_2769)field_11459, (Comparable)((class_2350.class_2351)this.method_9564().method_11654((class_2769)field_11459)))).method_11657((class_2769)field_24411, (Comparable)((Boolean)this.method_9564().method_11654((class_2769)field_24411))));
            case class_5955.class_5811.field_28706 -> Optional.of((class_2680)((class_2680)ModBlocks.WEATHERED_COPPER_CHAIN.get().method_9564().method_11657((class_2769)field_11459, (Comparable)((class_2350.class_2351)this.method_9564().method_11654((class_2769)field_11459)))).method_11657((class_2769)field_24411, (Comparable)((Boolean)this.method_9564().method_11654((class_2769)field_24411))));
            case class_5955.class_5811.field_28707 -> Optional.of((class_2680)((class_2680)ModBlocks.OXIDIZED_COPPER_CHAIN.get().method_9564().method_11657((class_2769)field_11459, (Comparable)((class_2350.class_2351)this.method_9564().method_11654((class_2769)field_11459)))).method_11657((class_2769)field_24411, (Comparable)((Boolean)this.method_9564().method_11654((class_2769)field_24411))));
        };
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        Optional<class_2680> unwaxed;
        if (stack.method_31573(class_3489.field_42612) && (unwaxed = this.getUnwaxedBlock()).isPresent()) {
            class_2680 newState = (class_2680)((class_2680)unwaxed.get().method_11657((class_2769)field_11459, (Comparable)((class_2350.class_2351)state.method_11654((class_2769)field_11459)))).method_11657((class_2769)field_24411, (Comparable)((Boolean)state.method_11654((class_2769)field_24411)));
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

