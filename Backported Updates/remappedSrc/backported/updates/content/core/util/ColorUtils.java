/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1767
 *  net.minecraft.class_1769
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_3532
 *  net.minecraft.class_3955
 *  net.minecraft.class_3956
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_9694
 *  net.minecraft.class_9695
 */
package backported.updates.content.core.util;

import java.util.List;
import net.minecraft.class_1767;
import net.minecraft.class_1769;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_3532;
import net.minecraft.class_3955;
import net.minecraft.class_3956;
import net.minecraft.class_5253;
import net.minecraft.class_7225;
import net.minecraft.class_9694;
import net.minecraft.class_9695;

public class ColorUtils {
    public static int scaleRGB(int color, float red, float green, float blue) {
        return class_5253.class_5254.method_27764((int)class_5253.class_5254.method_27762((int)color), (int)class_3532.method_15340((int)((int)((float)class_5253.class_5254.method_27765((int)color) * red)), (int)0, (int)255), (int)class_3532.method_15340((int)((int)((float)class_5253.class_5254.method_27766((int)color) * green)), (int)0, (int)255), (int)class_3532.method_15340((int)((int)((float)class_5253.class_5254.method_27767((int)color) * blue)), (int)0, (int)255));
    }

    public static int colorFromFloat(float alpha, float red, float green, float blue) {
        return class_5253.class_5254.method_27764((int)((int)(alpha * 255.0f)), (int)((int)(red * 255.0f)), (int)((int)(green * 255.0f)), (int)((int)(blue * 255.0f)));
    }

    public static class_1767 getMixedColor(class_3218 level, class_1767 colorA, class_1767 colorB) {
        class_9694 container = ColorUtils.makeCraftColorInput(colorA, colorB);
        return level.method_8433().method_8132(class_3956.field_17545, (class_9695)container, (class_1937)level).map(recipe -> ((class_3955)recipe.comp_1933()).method_8116((class_9695)container, (class_7225.class_7874)level.method_30349())).map(class_1799::method_7909).filter(class_1769.class::isInstance).map(class_1769.class::cast).map(class_1769::method_7802).orElseGet(() -> level.field_9229.method_43056() ? colorA : colorB);
    }

    private static class_9694 makeCraftColorInput(class_1767 colorA, class_1767 colorB) {
        return class_9694.method_59986((int)2, (int)1, List.of(new class_1799((class_1935)class_1769.method_7803((class_1767)colorA)), new class_1799((class_1935)class_1769.method_7803((class_1767)colorB))));
    }
}

