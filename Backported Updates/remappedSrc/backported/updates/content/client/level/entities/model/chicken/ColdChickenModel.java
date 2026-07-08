/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1428
 *  net.minecraft.class_558
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package backported.updates.content.client.level.entities.model.chicken;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1428;
import net.minecraft.class_558;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class ColdChickenModel<T extends class_1428>
extends class_558<T> {
    public ColdChickenModel(class_630 root) {
        super(root);
    }

    public static class_5607 createBodyLayer() {
        class_5609 mesh = new class_5609();
        class_5610 root = mesh.method_32111();
        root.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-2.0f, -6.0f, -2.0f, 4.0f, 6.0f, 3.0f), class_5603.method_32090((float)0.0f, (float)15.0f, (float)-4.0f));
        root.method_32117("beak", class_5606.method_32108().method_32101(14, 0).method_32097(-2.0f, -4.0f, -4.0f, 4.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)15.0f, (float)-4.0f));
        root.method_32117("red_thing", class_5606.method_32108().method_32101(14, 4).method_32097(-1.0f, -2.0f, -3.0f, 2.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)15.0f, (float)-4.0f));
        root.method_32117("body", class_5606.method_32108().method_32101(0, 9).method_32097(-3.0f, -4.0f, -3.0f, 6.0f, 8.0f, 6.0f), class_5603.method_32091((float)0.0f, (float)16.0f, (float)0.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        class_5606 legShape = class_5606.method_32108().method_32101(26, 0).method_32097(-1.0f, 0.0f, -3.0f, 3.0f, 5.0f, 3.0f);
        root.method_32117("right_leg", legShape, class_5603.method_32090((float)-2.0f, (float)19.0f, (float)1.0f));
        root.method_32117("left_leg", legShape, class_5603.method_32090((float)1.0f, (float)19.0f, (float)1.0f));
        root.method_32117("right_wing", class_5606.method_32108().method_32101(24, 13).method_32097(0.0f, 0.0f, -3.0f, 1.0f, 4.0f, 6.0f), class_5603.method_32090((float)-4.0f, (float)13.0f, (float)0.0f));
        root.method_32117("left_wing", class_5606.method_32108().method_32101(24, 13).method_32097(-1.0f, 0.0f, -3.0f, 1.0f, 4.0f, 6.0f), class_5603.method_32090((float)4.0f, (float)13.0f, (float)0.0f));
        root.method_32117("body", class_5606.method_32108().method_32101(0, 9).method_32097(-3.0f, -4.0f, -3.0f, 6.0f, 8.0f, 6.0f).method_32101(38, 9).method_32097(0.0f, 3.0f, -1.0f, 0.0f, 3.0f, 5.0f), class_5603.method_32091((float)0.0f, (float)16.0f, (float)0.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        root.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-2.0f, -6.0f, -2.0f, 4.0f, 6.0f, 3.0f).method_32101(44, 0).method_32097(-3.0f, -7.0f, -2.015f, 6.0f, 3.0f, 4.0f), class_5603.method_32090((float)0.0f, (float)15.0f, (float)-4.0f));
        return class_5607.method_32110((class_5609)mesh, (int)64, (int)32);
    }
}

