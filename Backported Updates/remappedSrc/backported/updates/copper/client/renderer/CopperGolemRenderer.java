/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_927
 *  net.minecraft.class_989
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.client.renderer.layers.CopperGolemAntennaLayer;
import backported.updates.copper.client.renderer.layers.CopperGolemEyesLayer;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_927;
import net.minecraft.class_989;

public class CopperGolemRenderer
extends class_927<CopperGolemEntity, CopperGolemModel> {
    public CopperGolemRenderer(class_5617.class_5618 context) {
        super(context, (class_583)new CopperGolemModel(context.method_32167(CopperGolemModel.LAYER_LOCATION)), 0.5f);
        this.method_4046(new CopperGolemEyesLayer((class_3883<CopperGolemEntity, CopperGolemModel>)this));
        this.method_4046((class_3887)new class_989((class_3883)this, context.method_43338()));
        this.method_4046(new CopperGolemAntennaLayer((class_3883<CopperGolemEntity, CopperGolemModel>)this));
    }

    public class_2960 getTextureLocation(CopperGolemEntity entity) {
        return CopperGolemOxidationLevels.getOxidationLevel(entity.getWeatherState()).texture();
    }

    protected void scale(CopperGolemEntity entity, class_4587 poseStack, float partialTick) {
        poseStack.method_22904(0.0, 1.5, 0.0);
    }
}

