/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.class_1297
 *  net.minecraft.class_173
 *  net.minecraft.class_1799
 *  net.minecraft.class_181
 *  net.minecraft.class_3218
 *  net.minecraft.class_52
 *  net.minecraft.class_5321
 *  net.minecraft.class_8567
 *  net.minecraft.class_8567$class_8568
 */
package backported.updates.content.core.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import net.minecraft.class_1297;
import net.minecraft.class_173;
import net.minecraft.class_1799;
import net.minecraft.class_181;
import net.minecraft.class_3218;
import net.minecraft.class_52;
import net.minecraft.class_5321;
import net.minecraft.class_8567;

public class LootUtils {
    public static boolean dropFromGiftLootTable(class_1297 entity, class_3218 level, class_5321<class_52> key, BiConsumer<class_3218, class_1799> consumer) {
        return LootUtils.dropFromLootTable(level, key, builder -> builder.method_51874(class_181.field_24424, (Object)entity.method_19538()).method_51874(class_181.field_1226, (Object)entity).method_51875(class_173.field_16235), consumer);
    }

    private static boolean dropFromLootTable(class_3218 level, class_5321<class_52> key, Function<class_8567.class_8568, class_8567> function, BiConsumer<class_3218, class_1799> consumer) {
        class_8567 lootParams;
        class_52 lootTable = level.method_8503().method_58576().method_58295(key);
        ObjectArrayList list = lootTable.method_51878(lootParams = function.apply(new class_8567.class_8568(level)));
        if (!list.isEmpty()) {
            list.forEach(stack -> consumer.accept(level, (class_1799)stack));
            return true;
        }
        return false;
    }
}

