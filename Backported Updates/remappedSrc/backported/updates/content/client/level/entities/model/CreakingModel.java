/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_5597
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package backported.updates.content.client.level.entities.model;

import backported.updates.content.client.level.entities.animation.CreakingAnimation;
import backported.updates.content.common.level.entities.creaking.Creaking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class CreakingModel<T extends Creaking>
extends class_5597<T> {
    private final class_630 root;
    private final class_630 head;

    public CreakingModel(class_630 root) {
        this.root = root.method_32086("root");
        class_630 upperBody = this.root.method_32086("upper_body");
        this.head = upperBody.method_32086("head");
    }

    private static class_5609 createMesh() {
        class_5609 mesh = new class_5609();
        class_5610 base = mesh.method_32111();
        class_5610 root = base.method_32117("root", class_5606.method_32108(), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
        class_5610 upperBody = root.method_32117("upper_body", class_5606.method_32108(), class_5603.method_32090((float)-1.0f, (float)-19.0f, (float)0.0f));
        upperBody.method_32117("head", class_5606.method_32108().method_32101(0, 0).method_32097(-3.0f, -10.0f, -3.0f, 6.0f, 10.0f, 6.0f).method_32101(28, 31).method_32097(-3.0f, -13.0f, -3.0f, 6.0f, 3.0f, 6.0f).method_32101(12, 40).method_32097(3.0f, -13.0f, 0.0f, 9.0f, 14.0f, 0.0f).method_32101(34, 12).method_32097(-12.0f, -14.0f, 0.0f, 9.0f, 14.0f, 0.0f), class_5603.method_32090((float)-3.0f, (float)-11.0f, (float)0.0f));
        upperBody.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32097(0.0f, -3.0f, -3.0f, 6.0f, 13.0f, 5.0f).method_32101(24, 0).method_32097(-6.0f, -4.0f, -3.0f, 6.0f, 7.0f, 5.0f), class_5603.method_32090((float)0.0f, (float)-7.0f, (float)1.0f));
        upperBody.method_32117("right_arm", class_5606.method_32108().method_32101(22, 13).method_32097(-2.0f, -1.5f, -1.5f, 3.0f, 21.0f, 3.0f).method_32101(46, 0).method_32097(-2.0f, 19.5f, -1.5f, 3.0f, 4.0f, 3.0f), class_5603.method_32090((float)-7.0f, (float)-9.5f, (float)1.5f));
        upperBody.method_32117("left_arm", class_5606.method_32108().method_32101(30, 40).method_32097(0.0f, -1.0f, -1.5f, 3.0f, 16.0f, 3.0f).method_32101(52, 12).method_32097(0.0f, -5.0f, -1.5f, 3.0f, 4.0f, 3.0f).method_32101(52, 19).method_32097(0.0f, 15.0f, -1.5f, 3.0f, 4.0f, 3.0f), class_5603.method_32090((float)6.0f, (float)-9.0f, (float)0.5f));
        root.method_32117("left_leg", class_5606.method_32108().method_32101(42, 40).method_32097(-1.5f, 0.0f, -1.5f, 3.0f, 16.0f, 3.0f).method_32101(45, 55).method_32097(-1.5f, 15.7f, -4.5f, 5.0f, 0.0f, 9.0f), class_5603.method_32090((float)1.5f, (float)-16.0f, (float)0.5f));
        root.method_32117("right_leg", class_5606.method_32108().method_32101(0, 34).method_32097(-3.0f, -1.5f, -1.5f, 3.0f, 19.0f, 3.0f).method_32101(45, 46).method_32097(-5.0f, 17.2f, -4.5f, 5.0f, 0.0f, 9.0f).method_32101(12, 34).method_32097(-3.0f, -4.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.method_32090((float)-1.0f, (float)-17.5f, (float)0.5f));
        return mesh;
    }

    public static class_5607 createBodyLayer() {
        class_5609 mesh = CreakingModel.createMesh();
        return class_5607.method_32110((class_5609)mesh, (int)64, (int)64);
    }

    public class_630 method_32008() {
        return this.root;
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.method_32008().method_32088().forEach(class_630::method_41923);
        this.head.field_3654 = headPitch * ((float)Math.PI / 180);
        this.head.field_3675 = netHeadYaw * ((float)Math.PI / 180);
        if (((Creaking)((Object)entity)).canMove()) {
            this.method_48741(CreakingAnimation.CREAKING_WALK, limbSwing, limbSwingAmount, 1.0f, 1.0f);
        }
        this.method_43781(((Creaking)((Object)entity)).attackAnimationState, CreakingAnimation.CREAKING_ATTACK, ageInTicks);
        this.method_43781(((Creaking)((Object)entity)).invulnerabilityAnimationState, CreakingAnimation.CREAKING_INVULNERABLE, ageInTicks);
        this.method_43781(((Creaking)((Object)entity)).deathAnimationState, CreakingAnimation.CREAKING_DEATH, ageInTicks);
    }
}

