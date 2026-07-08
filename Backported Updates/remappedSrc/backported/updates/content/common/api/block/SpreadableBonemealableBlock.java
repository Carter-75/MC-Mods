/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2256
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2680
 *  net.minecraft.class_4538
 */
package backported.updates.content.common.api.block;

import java.util.List;
import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_2256;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_4538;

public interface SpreadableBonemealableBlock
extends class_2256 {
    public static boolean hasSpreadableNeighbourPos(class_4538 level, class_2338 pos, class_2680 state) {
        return SpreadableBonemealableBlock.getSpreadableNeighbourPos(class_2350.class_2353.field_11062.method_29716().toList(), level, pos, state).isPresent();
    }

    public static Optional<class_2338> findSpreadableNeighbourPos(class_1937 level, class_2338 pos, class_2680 state) {
        return SpreadableBonemealableBlock.getSpreadableNeighbourPos(class_2350.class_2353.field_11062.method_43342(level.field_9229), (class_4538)level, pos, state);
    }

    private static Optional<class_2338> getSpreadableNeighbourPos(List<class_2350> directions, class_4538 level, class_2338 pos, class_2680 state) {
        for (class_2350 direction : directions) {
            class_2338 offset = pos.method_10093(direction);
            if (!level.method_22347(offset) || !state.method_26184(level, offset)) continue;
            return Optional.of(offset);
        }
        return Optional.empty();
    }
}

