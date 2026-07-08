/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1308
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_927
 */
package net._void.civilizations.entity.client;

import net._void.civilizations.entity.client.EgyptNpcModel;
import net._void.civilizations.entity.client.ModModelLayers;
import net._void.civilizations.entity.custom.EgyptNpcEntity;
import net.minecraft.class_1308;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class EgyptNpcRenderer
extends class_927<EgyptNpcEntity, EgyptNpcModel<EgyptNpcEntity>> {
    private static final class_2960 TEXTURE = new class_2960("civilizations", "textures/entity/egypt_npc.png");

    public EgyptNpcRenderer(class_5617.class_5618 context) {
        super(context, new EgyptNpcModel(context.method_32167(ModModelLayers.EGYPT_NPC)), 0.6f);
    }

    public class_2960 getTexture(EgyptNpcEntity entity) {
        return TEXTURE;
    }

    public void render(EgyptNpcEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

