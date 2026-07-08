/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1769
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1852
 *  net.minecraft.class_1865
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_5537
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7710
 *  net.minecraft.class_9694
 */
package backported.updates.content.common.level.crafting;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.common.registries.ModRecipeSerializers;
import net.minecraft.class_1769;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1852;
import net.minecraft.class_1865;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_5537;
import net.minecraft.class_7225;
import net.minecraft.class_7710;
import net.minecraft.class_9694;

public class BundleColoring
extends class_1852 {
    public BundleColoring(class_7710 category) {
        super(category);
    }

    public boolean matches(class_9694 input, class_1937 level) {
        int bundles = 0;
        int dyes = 0;
        for (int slot = 0; slot < input.method_59983(); ++slot) {
            class_1799 stack = input.method_59984(slot);
            if (stack.method_7960()) continue;
            if (stack.method_7909() instanceof class_5537) {
                ++bundles;
            } else if (stack.method_7909() instanceof class_1769) {
                ++dyes;
            } else {
                return false;
            }
            if (dyes <= 1 && bundles <= 1) continue;
            return false;
        }
        return bundles == 1 && dyes == 1;
    }

    public class_1799 assemble(class_9694 input, class_7225.class_7874 registries) {
        class_1799 bundle = class_1799.field_8037;
        class_1769 dye = (class_1769)class_1802.field_8446;
        for (int slot = 0; slot < input.method_59983(); ++slot) {
            class_1799 stack = input.method_59984(slot);
            if (stack.method_7960()) continue;
            class_1792 item = stack.method_7909();
            if (item instanceof class_5537) {
                bundle = stack;
                continue;
            }
            if (!(item instanceof class_1769)) continue;
            dye = (class_1769)item;
        }
        class_1792 result = BundleFeatures.getByColor(dye.method_7802());
        return bundle.method_56701((class_1935)result, 1);
    }

    public boolean method_8113(int width, int height) {
        return width * height >= 2;
    }

    public class_1865<?> method_8119() {
        return ModRecipeSerializers.BUNDLE_COLORING.get();
    }
}

