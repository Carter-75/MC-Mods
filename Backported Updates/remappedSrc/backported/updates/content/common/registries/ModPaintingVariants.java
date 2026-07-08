/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1535
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.registries;

import net.minecraft.class_1535;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class ModPaintingVariants {
    public static final class_5321<class_1535> DENNIS = ModPaintingVariants.registryKey("dennis");

    public static void bootstrap(class_7891<class_1535> context) {
        ModPaintingVariants.register(context, DENNIS, 3, 3);
    }

    private static void register(class_7891<class_1535> context, class_5321<class_1535> key, int width, int height) {
        context.method_46838(key, (Object)new class_1535(width, height, key.method_29177()));
    }

    private static class_5321<class_1535> registryKey(String name) {
        return class_5321.method_29179((class_5321)class_7924.field_41209, (class_2960)class_2960.method_60656((String)name));
    }
}

