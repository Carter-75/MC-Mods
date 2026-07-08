/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1452
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_587
 *  net.minecraft.class_597
 *  net.minecraft.class_630
 */
package backported.updates.content.client.level.entities.model.pig;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1452;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_587;
import net.minecraft.class_597;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class ColdPigModel<T extends class_1452>
extends class_587<T> {
    public ColdPigModel(class_630 root) {
        super(root);
    }

    public static class_5607 createBodyLayer() {
        class_5609 mesh = class_597.method_32033((int)6, (class_5605)class_5605.field_27715);
        class_5610 root = mesh.method_32111();
        root.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-4.0f, -4.0f, -8.0f, 8.0f, 8.0f, 8.0f).method_32101(16, 16).method_32097(-2.0f, 0.0f, -9.0f, 4.0f, 3.0f, 1.0f), class_5603.method_32090((float)0.0f, (float)12.0f, (float)-6.0f));
        root.method_32117("body", class_5606.method_32108().method_32101(28, 8).method_32097(-5.0f, -10.0f, -7.0f, 10.0f, 16.0f, 8.0f).method_32101(28, 32).method_32098(-5.0f, -10.0f, -7.0f, 10.0f, 16.0f, 8.0f, new class_5605(0.5f)), class_5603.method_32091((float)0.0f, (float)11.0f, (float)2.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        return class_5607.method_32110((class_5609)mesh, (int)64, (int)64);
    }
}

