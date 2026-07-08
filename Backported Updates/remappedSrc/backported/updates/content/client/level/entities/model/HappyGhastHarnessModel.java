/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1297
 *  net.minecraft.class_5597
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package backported.updates.content.client.level.entities.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class HappyGhastHarnessModel<T extends class_1297>
extends class_5597<T> {
    private final class_630 root;
    private final class_630 goggles;

    public HappyGhastHarnessModel(class_630 root) {
        this.root = root;
        this.goggles = root.method_32086("goggles");
    }

    public static class_5607 createHarnessLayer() {
        class_5609 mesh = new class_5609();
        class_5610 root = mesh.method_32111();
        root.method_32117("harness", class_5606.method_32108().method_32101(0, 0).method_32097(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        root.method_32117("goggles", class_5606.method_32108().method_32101(0, 32).method_32098(-8.0f, -2.5f, -2.5f, 16.0f, 5.0f, 5.0f, new class_5605(0.15f)), class_5603.method_32090((float)0.0f, (float)14.0f, (float)-5.5f));
        return class_5607.method_32110((class_5609)mesh, (int)64, (int)64);
    }

    public void method_2819(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.method_5782()) {
            this.goggles.field_3654 = 0.0f;
            this.goggles.field_3656 = 14.0f;
        } else {
            this.goggles.field_3654 = -0.7854f;
            this.goggles.field_3656 = 9.0f;
        }
    }

    public class_630 method_32008() {
        return this.root;
    }
}

