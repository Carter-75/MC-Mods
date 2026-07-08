/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  org.jetbrains.annotations.Nullable
 */
package ace.actually.pirates.blocks;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.entity.StableBlockEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;

public class StableBlock
extends class_2237 {
    public StableBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new StableBlockEntity(pos, state);
    }

    public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        if (world instanceof class_3218) {
            class_3218 serverWorld = (class_3218)world;
            if (hand == class_1268.field_5808) {
                StableBlockEntity be = (StableBlockEntity)serverWorld.method_8321(pos);
                String name = player.method_6047().method_7964().getString();
                System.out.println(name);
                try {
                    double mult = Double.parseDouble(name);
                    be.setMultiplier(mult);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        return super.method_9534(state, world, pos, player, hand, hit);
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        return StableBlock.method_31618(type, (class_2591)((class_2591)Pirates.STABLE_BLOCK_ENTITY.get()), StableBlockEntity::tick);
    }
}

