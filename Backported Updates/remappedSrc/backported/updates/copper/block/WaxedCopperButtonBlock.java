/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2269
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2738
 *  net.minecraft.class_2769
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_8177
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperButtonBlock;
import java.util.function.Supplier;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2269;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2738;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5955;
import net.minecraft.class_8177;
import net.minecraft.class_9062;

public class WaxedCopperButtonBlock
extends class_2269 {
    private final class_5955.class_5811 weatherState;
    private final Supplier<CopperButtonBlock> unwaxedButton;

    public WaxedCopperButtonBlock(class_5955.class_5811 weatherState, Supplier<CopperButtonBlock> unwaxedButton, class_4970.class_2251 properties) {
        super(class_8177.field_47100, 15, properties);
        this.weatherState = weatherState;
        this.unwaxedButton = unwaxedButton;
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        if (stack.method_31573(class_3489.field_42612)) {
            level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3004, pos, 0);
            if (!level.field_9236) {
                class_2680 unwaxedState = (class_2680)((class_2680)((class_2680)this.unwaxedButton.get().method_9564().method_11657((class_2769)field_11177, (Comparable)((class_2350)state.method_11654((class_2769)field_11177)))).method_11657((class_2769)field_10729, (Comparable)((Boolean)state.method_11654((class_2769)field_10729)))).method_11657((class_2769)field_11007, (Comparable)((class_2738)state.method_11654((class_2769)field_11007)));
                level.method_8652(pos, unwaxedState, 11);
                if (!player.method_7337()) {
                    stack.method_7970(1, (class_1309)player, class_1304.field_6173);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return class_9062.field_47731;
    }

    protected class_1269 method_55766(class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_3965 hitResult) {
        return super.method_55766(state, level, pos, player, hitResult);
    }

    protected boolean method_9542(class_2680 state) {
        return false;
    }
}

