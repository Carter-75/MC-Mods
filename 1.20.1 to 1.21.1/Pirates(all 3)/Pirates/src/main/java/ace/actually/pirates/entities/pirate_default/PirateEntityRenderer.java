/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_5602
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_927
 *  net.minecraft.class_989
 */
package ace.actually.pirates.entities.pirate_default;

import ace.actually.pirates.entities.pirate_default.PirateEntity;
import ace.actually.pirates.entities.pirate_default.PirateEntityModel;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_927;
import net.minecraft.class_989;

public class PirateEntityRenderer
extends class_927<PirateEntity, class_583<PirateEntity>> {
    public PirateEntityRenderer(class_5617.class_5618 context) {
        super(context, new PirateEntityModel(context.method_32167(class_5602.field_27576)), 0.5f);
        this.method_4046((class_3887)new class_989((class_3883)this, context.method_43338()));
    }

    public class_2960 getTextureLocation(PirateEntity entity) {
        return new class_2960("pirates", "textures/entity/pirate2.png");
    }
}

