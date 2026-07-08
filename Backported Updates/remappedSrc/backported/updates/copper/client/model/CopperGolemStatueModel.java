/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2350
 *  net.minecraft.class_3879
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_630
 */
package backported.updates.copper.client.model;

import net.minecraft.class_1921;
import net.minecraft.class_2350;
import net.minecraft.class_3879;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_630;

public class CopperGolemStatueModel
extends class_3879 {
    private final class_630 root;

    public CopperGolemStatueModel(class_630 root) {
        super(class_1921::method_23578);
        this.root = root;
    }

    public void method_2828(class_4587 poseStack, class_4588 buffer, int packedLight, int packedOverlay, int color) {
        this.root.method_22699(poseStack, buffer, packedLight, packedOverlay, color);
    }

    public void setupAnim(class_2350 facing) {
        this.root.field_3656 = 0.0f;
        this.root.field_3675 = facing.method_10153().method_10144() * ((float)Math.PI / 180);
        this.root.field_3674 = (float)Math.PI;
    }
}

