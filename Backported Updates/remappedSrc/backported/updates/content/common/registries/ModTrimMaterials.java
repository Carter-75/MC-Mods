/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_1741
 *  net.minecraft.class_1792
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 *  net.minecraft.class_8054
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.registries.ModItems;
import java.util.Map;
import net.minecraft.class_156;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_8054;

public class ModTrimMaterials {
    public static final class_5321<class_8054> RESIN = ModTrimMaterials.registryKey("resin");

    public static void bootstrap(class_7891<class_8054> context) {
        ModTrimMaterials.register(context, RESIN, ModItems.RESIN_BRICK.get(), class_2583.field_24360.method_36139(16545810), 0.5f);
    }

    private static void register(class_7891<class_8054> context, class_5321<class_8054> materialKey, class_1792 ingredient, class_2583 style, float itemModelIndex) {
        ModTrimMaterials.register(context, materialKey, ingredient, style, itemModelIndex, Map.of());
    }

    private static void register(class_7891<class_8054> context, class_5321<class_8054> materialKey, class_1792 ingredient, class_2583 style, float itemModelIndex, Map<class_6880<class_1741>, String> overrideArmorMaterials) {
        class_8054 trimMaterial = class_8054.method_48438((String)materialKey.method_29177().method_12832(), (class_1792)ingredient, (float)itemModelIndex, (class_2561)class_2561.method_43471((String)class_156.method_646((String)"trim_material", (class_2960)materialKey.method_29177())).method_27696(style), overrideArmorMaterials);
        context.method_46838(materialKey, (Object)trimMaterial);
    }

    private static class_5321<class_8054> registryKey(String name) {
        return class_5321.method_29179((class_5321)class_7924.field_42083, (class_2960)class_2960.method_60656((String)name));
    }
}

