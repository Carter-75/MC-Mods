/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1304
 *  net.minecraft.class_3532
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

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1304;
import net.minecraft.class_3532;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class HappyGhastModel<T extends HappyGhast>
extends class_5597<T> {
    private final class_630 root;
    private final class_630 body;
    private final class_630 inner_body;
    private final class_630[] tentacles = new class_630[9];

    public HappyGhastModel(class_630 root) {
        this.root = root;
        this.body = root.method_32086("body");
        this.inner_body = this.body.method_32086("inner_body");
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i] = this.body.method_32086(HappyGhastModel.createTentacleName(i));
        }
    }

    private static String createTentacleName(int index) {
        return "tentacle" + index;
    }

    public static class_5607 createBodyLayer(class_5605 deformation) {
        class_5609 mesh = new class_5609();
        class_5610 root = mesh.method_32111();
        class_5610 body = root.method_32117("body", class_5606.method_32108().method_32101(0, 0).method_32098(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, deformation), class_5603.method_32090((float)0.0f, (float)16.0f, (float)0.0f));
        body.method_32117("inner_body", class_5606.method_32108().method_32101(0, 32).method_32098(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, deformation.method_32094(-0.5f)), class_5603.method_32090((float)0.0f, (float)8.0f, (float)0.0f));
        body.method_32117(HappyGhastModel.createTentacleName(0), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), class_5603.method_32090((float)-3.75f, (float)7.0f, (float)-5.0f));
        body.method_32117(HappyGhastModel.createTentacleName(1), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 7.0f, 2.0f, deformation), class_5603.method_32090((float)1.25f, (float)7.0f, (float)-5.0f));
        body.method_32117(HappyGhastModel.createTentacleName(2), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 4.0f, 2.0f, deformation), class_5603.method_32090((float)6.25f, (float)7.0f, (float)-5.0f));
        body.method_32117(HappyGhastModel.createTentacleName(3), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), class_5603.method_32090((float)-6.25f, (float)7.0f, (float)0.0f));
        body.method_32117(HappyGhastModel.createTentacleName(4), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), class_5603.method_32090((float)-1.25f, (float)7.0f, (float)0.0f));
        body.method_32117(HappyGhastModel.createTentacleName(5), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 7.0f, 2.0f, deformation), class_5603.method_32090((float)3.75f, (float)7.0f, (float)0.0f));
        body.method_32117(HappyGhastModel.createTentacleName(6), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 8.0f, 2.0f, deformation), class_5603.method_32090((float)-3.75f, (float)7.0f, (float)5.0f));
        body.method_32117(HappyGhastModel.createTentacleName(7), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 8.0f, 2.0f, deformation), class_5603.method_32090((float)1.25f, (float)7.0f, (float)5.0f));
        body.method_32117(HappyGhastModel.createTentacleName(8), class_5606.method_32108().method_32101(0, 0).method_32098(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, deformation), class_5603.method_32090((float)6.25f, (float)7.0f, (float)5.0f));
        return class_5607.method_32110((class_5609)mesh, (int)64, (int)64);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.inner_body.field_3665 = entity.method_6109();
        if (entity.method_6084(class_1304.field_6174)) {
            this.body.field_37938 = 0.9375f;
            this.body.field_37939 = 0.9375f;
            this.body.field_37940 = 0.9375f;
        }
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].field_3654 = 0.2f * class_3532.method_15374((float)(ageInTicks * 0.3f + (float)i)) + 0.4f;
        }
    }

    public class_630 method_32008() {
        return this.root;
    }
}

