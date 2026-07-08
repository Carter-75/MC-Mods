/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_927
 *  net.minecraft.class_989
 */
package ace.actually.pirates.entities.pirate_skeleton;

import ace.actually.pirates.client.PiratesClient;
import ace.actually.pirates.entities.pirate_skeleton.SkeletonPirateEntity;
import ace.actually.pirates.entities.pirate_skeleton.SkeletonPirateModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_5617;
import net.minecraft.class_927;
import net.minecraft.class_989;

@Environment(value=EnvType.CLIENT)
public class SkeletonPirateEntityRenderer
extends class_927<SkeletonPirateEntity, SkeletonPirateModel<SkeletonPirateEntity>> {
    public SkeletonPirateEntityRenderer(class_5617.class_5618 context) {
        super(context, new SkeletonPirateModel(context.method_32167(PiratesClient.SKELETON_PIRATE)), 0.5f);
        this.method_4046((class_3887)new class_989((class_3883)this, context.method_43338()));
    }

    public class_2960 getTextureLocation(SkeletonPirateEntity entity) {
        return new class_2960("pirates", "textures/entity/skeleton_pirate.png");
    }
}

