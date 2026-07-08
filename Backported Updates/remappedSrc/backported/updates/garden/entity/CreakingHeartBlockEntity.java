/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 */
package backported.updates.garden.entity;

import backported.updates.garden.Init;
import backported.updates.garden.block.CreakingHeartBlock;
import backported.updates.garden.entity.CreakingEntity;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2769;

public class CreakingHeartBlockEntity
extends class_2586 {
    public CreakingEntity creakingEntity = null;
    public int timing = 100;

    public CreakingHeartBlockEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
        super(type, pos, state);
    }

    public static void tick(class_1937 world, class_2338 pos, class_2680 state, CreakingHeartBlockEntity blockEntity) {
        if (((Boolean)state.method_11654((class_2769)CreakingHeartBlock.ACTIVATED)).booleanValue()) {
            blockEntity.checkAndSpawnCreaking(world, pos);
            if (state.method_26204() instanceof CreakingHeartBlock && blockEntity.timing <= 100) {
                ++blockEntity.timing;
            }
        }
    }

    public class_2338 findAirBlockPos() {
        int[][] offsets;
        class_2338 basePos = this.method_11016();
        for (int[] offset : offsets = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}}) {
            try {
                class_2338 pos = basePos.method_10069(offset[0], offset[1], offset[2]);
                if (this.field_11863.method_8320(pos).method_26204() != class_2246.field_10124) continue;
                return pos;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public void trySpawnResin() {
        if (this.timing >= 100) {
            class_1937 world = this.method_10997();
            class_1799 itemStack = new class_1799((class_1935)Init.RESIN_CLUMP);
            itemStack.method_7939(ThreadLocalRandom.current().nextInt(1, 4));
            class_2338 blockPos = this.method_11016();
            class_2338 blockPos2 = this.findAirBlockPos();
            if (blockPos2 != null) {
                blockPos = blockPos2;
            }
            try {
                world.method_8649((class_1297)new class_1542(world, (double)blockPos.method_10263(), (double)blockPos.method_10264(), (double)blockPos.method_10260(), itemStack));
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.timing = 0;
        }
    }

    private void checkAndSpawnCreaking(class_1937 world, class_2338 pos) {
        boolean creakingExists;
        boolean bl = creakingExists = this.creakingEntity != null && this.creakingEntity.method_5805();
        if (!creakingExists && world.method_23886()) {
            CreakingEntity creaking = new CreakingEntity(Init.CREAKING, world);
            creaking.boundHeart = this.method_11016();
            creaking.isHeartSpawn = true;
            this.creakingEntity = creaking;
            for (int x = -2; x <= 2; ++x) {
                for (int y = -2; y <= 2; ++y) {
                    for (int z = -2; z <= 2; ++z) {
                        class_2338 airPos = pos.method_10069(x, y, z);
                        if (!world.method_22347(airPos)) continue;
                        creaking.method_5808(airPos.method_10263(), airPos.method_10264(), airPos.method_10260(), 0.0f, 0.0f);
                        world.method_8649((class_1297)creaking);
                        return;
                    }
                }
            }
        }
    }
}

