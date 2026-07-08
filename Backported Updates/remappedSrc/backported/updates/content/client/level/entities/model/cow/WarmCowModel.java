/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1430
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package backported.updates.content.client.level.entities.model.cow;

import backported.updates.content.client.level.entities.model.cow.CowVariantModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1430;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class WarmCowModel<T extends class_1430>
extends CowVariantModel<T> {
    public WarmCowModel(class_630 root) {
        super(root);
    }

    public static class_5607 createBodyLayer() {
        class_5609 mesh = WarmCowModel.createBaseCowModel();
        class_5610 root = mesh.method_32111();
        root.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-4.0f, -4.0f, -6.0f, 8.0f, 8.0f, 6.0f).method_32101(1, 33).method_32097(-3.0f, 1.0f, -7.0f, 6.0f, 3.0f, 1.0f).method_32101(27, 0).method_32097(-8.0f, -3.0f, -5.0f, 4.0f, 2.0f, 2.0f).method_32101(39, 0).method_32097(-8.0f, -5.0f, -5.0f, 2.0f, 2.0f, 2.0f).method_32101(27, 0).method_32096().method_32097(4.0f, -3.0f, -5.0f, 4.0f, 2.0f, 2.0f).method_32106(false).method_32101(39, 0).method_32096().method_32097(6.0f, -5.0f, -5.0f, 2.0f, 2.0f, 2.0f).method_32106(false), class_5603.method_32090((float)0.0f, (float)4.0f, (float)-8.0f));
        return class_5607.method_32110((class_5609)mesh, (int)64, (int)64);
    }
}

