/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1430
 *  net.minecraft.class_560
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package backported.updates.content.client.level.entities.model.cow;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1430;
import net.minecraft.class_560;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class CowVariantModel<T extends class_1430>
extends class_560<T> {
    public CowVariantModel(class_630 root) {
        super(root);
    }

    static class_5609 createBaseCowModel() {
        class_5609 mesh = new class_5609();
        class_5610 root = mesh.method_32111();
        root.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-4.0f, -4.0f, -6.0f, 8.0f, 8.0f, 6.0f).method_32101(1, 33).method_32097(-3.0f, 1.0f, -7.0f, 6.0f, 3.0f, 1.0f).method_32101(22, 0).method_32102("right_horn", -5.0f, -5.0f, -5.0f, 1.0f, 3.0f, 1.0f).method_32101(22, 0).method_32102("left_horn", 4.0f, -5.0f, -5.0f, 1.0f, 3.0f, 1.0f), class_5603.method_32090((float)0.0f, (float)4.0f, (float)-8.0f));
        root.method_32117("body", class_5606.method_32108().method_32101(18, 4).method_32097(-6.0f, -10.0f, -7.0f, 12.0f, 18.0f, 10.0f).method_32101(52, 0).method_32097(-2.0f, 2.0f, -8.0f, 4.0f, 6.0f, 1.0f), class_5603.method_32091((float)0.0f, (float)5.0f, (float)2.0f, (float)1.5707964f, (float)0.0f, (float)0.0f));
        class_5606 leftLeg = class_5606.method_32108().method_32096().method_32101(0, 16).method_32097(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        class_5606 rightLeg = class_5606.method_32108().method_32101(0, 16).method_32097(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        root.method_32117("right_hind_leg", rightLeg, class_5603.method_32090((float)-4.0f, (float)12.0f, (float)7.0f));
        root.method_32117("left_hind_leg", leftLeg, class_5603.method_32090((float)4.0f, (float)12.0f, (float)7.0f));
        root.method_32117("right_front_leg", rightLeg, class_5603.method_32090((float)-4.0f, (float)12.0f, (float)-5.0f));
        root.method_32117("left_front_leg", leftLeg, class_5603.method_32090((float)4.0f, (float)12.0f, (float)-5.0f));
        return mesh;
    }
}

