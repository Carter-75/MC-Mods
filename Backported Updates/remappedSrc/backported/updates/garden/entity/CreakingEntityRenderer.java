/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_927
 */
package backported.updates.garden.entity;

import backported.updates.garden.ClientInit;
import backported.updates.garden.entity.CreakingEntity;
import backported.updates.garden.entity.CreakingModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_927;

@Environment(value=EnvType.CLIENT)
public class CreakingEntityRenderer
extends class_927<CreakingEntity, CreakingModel> {
    public CreakingEntityRenderer(class_5617.class_5618 context) {
        super(context, (class_583)new CreakingModel(context.method_32167(ClientInit.MODEL_CREAKING_LAYER)), 0.5f);
    }

    public class_2960 getTexture(CreakingEntity entity) {
        return class_2960.method_60655((String)"iwie", (String)"textures/entity/creaking/creaking.png");
    }
}

