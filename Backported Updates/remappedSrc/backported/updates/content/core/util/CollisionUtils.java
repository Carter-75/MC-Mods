/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3610
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.core.util;

import java.util.List;
import net.minecraft.class_1309;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3610;
import org.jetbrains.annotations.Nullable;

public class CollisionUtils {
    public static boolean intersects(class_238 box, class_2338 pos) {
        return box.method_1003((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), (double)(pos.method_10263() + 1), (double)(pos.method_10264() + 1), (double)(pos.method_10260() + 1));
    }

    public static boolean collidedWithFluid(class_1309 entity, class_3610 state, class_2338 pos, class_243 origin, class_243 target) {
        class_238 box = CollisionUtils.getFluidAABB(state, (class_1922)entity.method_37908(), pos);
        return box != null && CollisionUtils.collidedWithShapeMovingFrom(entity, origin, target, List.of(box));
    }

    public static boolean collidedWithShapeMovingFrom(class_1309 entity, class_243 origin, class_243 target, List<class_238> boxes) {
        class_238 box = entity.field_18065.method_30757(origin);
        class_243 distance = target.method_1020(origin);
        return CollisionUtils.collidedAlongVector(box, distance, boxes);
    }

    @Nullable
    public static class_238 getFluidAABB(class_3610 state, class_1922 level, class_2338 pos) {
        if (state.method_15769()) {
            return null;
        }
        float fluidHeight = state.method_15763(level, pos);
        return new class_238((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), (double)pos.method_10263() + 1.0, (double)((float)pos.method_10264() + fluidHeight), (double)pos.method_10260() + 1.0);
    }

    public static boolean collidedAlongVector(class_238 entityBox, class_243 origin, List<class_238> obstacles) {
        class_243 center = entityBox.method_1005();
        class_243 distance = center.method_1019(origin);
        for (class_238 obstacle : obstacles) {
            class_238 box = obstacle.method_1009(entityBox.method_17939() * 0.5, entityBox.method_17940() * 0.5, entityBox.method_17941() * 0.5);
            if (box.method_1006(distance) || box.method_1006(center)) {
                return true;
            }
            if (!box.method_992(center, distance).isPresent()) continue;
            return true;
        }
        return false;
    }
}

