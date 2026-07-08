/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_2338
 *  net.minecraft.class_5425
 *  net.minecraft.class_6880
 */
package backported.updates.content.common.api.variant.spawn;

import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_5425;
import net.minecraft.class_6880;

public record SpawnContext(class_2338 pos, class_5425 level, class_6880<class_1959> biome) {
    public static SpawnContext create(class_5425 level, class_2338 pos) {
        class_6880 biome = level.method_23753(pos);
        return new SpawnContext(pos, level, (class_6880<class_1959>)biome);
    }
}

