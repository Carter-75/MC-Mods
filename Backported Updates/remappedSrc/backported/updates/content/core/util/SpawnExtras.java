/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3481
 *  net.minecraft.class_3532
 *  net.minecraft.class_3730
 *  net.minecraft.class_4538
 *  net.minecraft.class_5819
 *  net.minecraft.class_7244$class_7502
 */
package backported.updates.content.core.util;

import java.util.Optional;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3481;
import net.minecraft.class_3532;
import net.minecraft.class_3730;
import net.minecraft.class_4538;
import net.minecraft.class_5819;
import net.minecraft.class_7244;

public class SpawnExtras {
    public static final class_7244.class_7502 ON_TOP_OF_COLLIDER_NO_LEAVES = (level, pos, target, mutable, state) -> state.method_26220((class_1922)level, mutable).method_1110() && !target.method_26164(class_3481.field_15503) && class_2248.method_9501((class_265)target.method_26220((class_1922)level, pos), (class_2350)class_2350.field_11036);

    public static <T extends class_1308> Optional<T> trySpawnMob(class_1299<T> entityType, class_3730 spawnType, class_3218 level, class_2338 pos, int attempts, int spread, int yOffset, class_7244.class_7502 strategy, boolean checkForCollisions) {
        class_2338.class_2339 mutable = pos.method_25503();
        for (int i = 0; i < attempts; ++i) {
            class_1308 mob;
            int xOffset = class_3532.method_32751((class_5819)level.field_9229, (int)(-spread), (int)spread);
            int zOffset = class_3532.method_32751((class_5819)level.field_9229, (int)(-spread), (int)spread);
            mutable.method_25504((class_2382)pos, xOffset, yOffset, zOffset);
            if (!level.method_8621().method_11952((class_2338)mutable) || !SpawnExtras.moveToPossibleSpawnPosition(level, yOffset, mutable, strategy) || checkForCollisions && !level.method_18026(entityType.method_58629((double)mutable.method_10263() + 0.5, (double)mutable.method_10264(), (double)mutable.method_10260() + 0.5)) || (mob = (class_1308)entityType.method_5888(level, null, (class_2338)mutable, spawnType, false, false)) == null) continue;
            if (mob.method_5979((class_1936)level, spawnType) && mob.method_5957((class_4538)level)) {
                level.method_30771((class_1297)mob);
                mob.method_5966();
                return Optional.of(mob);
            }
            mob.method_31472();
        }
        return Optional.empty();
    }

    private static boolean moveToPossibleSpawnPosition(class_3218 level, int yOffset, class_2338.class_2339 pos, class_7244.class_7502 strategy) {
        class_2338.class_2339 mutable = new class_2338.class_2339().method_10101((class_2382)pos);
        class_2680 state = level.method_8320((class_2338)mutable);
        for (int i = yOffset; i >= -yOffset; --i) {
            pos.method_10098(class_2350.field_11033);
            mutable.method_25505((class_2382)pos, class_2350.field_11036);
            class_2680 target = level.method_8320((class_2338)pos);
            if (strategy.canSpawnOn(level, (class_2338)pos, target, (class_2338)mutable, state)) {
                pos.method_10098(class_2350.field_11036);
                return true;
            }
            state = target;
        }
        return false;
    }
}

