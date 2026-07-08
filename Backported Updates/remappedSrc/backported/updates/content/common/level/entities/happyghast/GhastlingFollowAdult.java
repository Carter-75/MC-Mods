/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_4102
 *  net.minecraft.class_4115
 *  net.minecraft.class_4140
 *  net.minecraft.class_4142
 *  net.minecraft.class_6019
 *  net.minecraft.class_7894
 *  net.minecraft.class_7898
 */
package backported.updates.content.common.level.entities.happyghast;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_4102;
import net.minecraft.class_4115;
import net.minecraft.class_4140;
import net.minecraft.class_4142;
import net.minecraft.class_6019;
import net.minecraft.class_7894;
import net.minecraft.class_7898;

public class GhastlingFollowAdult {
    public static class_7894<class_1309> create(class_6019 followRange, float speed) {
        return GhastlingFollowAdult.create(followRange, entity -> Float.valueOf(speed), (class_4140<? extends class_1309>)class_4140.field_25359);
    }

    public static class_7894<class_1309> create(class_6019 followRange, Function<class_1309, Float> speedFactory, class_4140<? extends class_1309> memory) {
        return class_7898.method_47224(instance -> instance.group((App)instance.method_47244(memory), (App)instance.method_47235(class_4140.field_18446), (App)instance.method_47245(class_4140.field_18445)).apply((Applicative)instance, (followTarget, lookTarget, walkTarget) -> (level, entity, gameTme) -> {
            if (!entity.method_6109()) {
                return false;
            }
            class_1309 leader = (class_1309)instance.method_47243(followTarget);
            if (entity.method_24516((class_1297)leader, (double)(followRange.method_35011() + 1)) && !entity.method_24516((class_1297)leader, (double)followRange.method_35009())) {
                class_4142 target = new class_4142((class_4115)new class_4102((class_1297)leader, false), ((Float)speedFactory.apply(entity)).floatValue(), followRange.method_35009() - 1);
                lookTarget.method_47249((Object)new class_4102((class_1297)leader, true));
                walkTarget.method_47249((Object)target);
                return true;
            }
            return false;
        }));
    }
}

