/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.class_1308
 *  net.minecraft.class_156
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_927
 */
package net._void.civilizations.entity.client;

import com.google.common.collect.Maps;
import java.util.Map;
import net._void.civilizations.entity.client.EgyptCivilianModel;
import net._void.civilizations.entity.client.ModModelLayers;
import net._void.civilizations.entity.custom.EgyptCivilianEntity;
import net._void.civilizations.entity.custom.EgyptCivilianVariant;
import net.minecraft.class_1308;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class EgyptCivilianRenderer
extends class_927<EgyptCivilianEntity, EgyptCivilianModel<EgyptCivilianEntity>> {
    public static final Map<EgyptCivilianVariant, class_2960> LOCATION_BY_VARIANT = (Map)class_156.method_654((Object)Maps.newEnumMap(EgyptCivilianVariant.class), map -> {
        map.put(EgyptCivilianVariant.CIVILIAN1, new class_2960("civilizations", "textures/entity/egypt_civilian.png"));
        map.put(EgyptCivilianVariant.CIVILIAN2, new class_2960("civilizations", "textures/entity/egypt_civilian_2.png"));
        map.put(EgyptCivilianVariant.CIVILIAN3, new class_2960("civilizations", "textures/entity/egypt_civilian_3.png"));
        map.put(EgyptCivilianVariant.CIVILIAN4, new class_2960("civilizations", "textures/entity/egypt_civilian_4.png"));
        map.put(EgyptCivilianVariant.CIVILIAN5, new class_2960("civilizations", "textures/entity/egypt_civilian_5.png"));
        map.put(EgyptCivilianVariant.CIVILIAN6, new class_2960("civilizations", "textures/entity/egypt_civilian_6.png"));
        map.put(EgyptCivilianVariant.CIVILIAN7, new class_2960("civilizations", "textures/entity/egypt_civilian_7.png"));
        map.put(EgyptCivilianVariant.CIVILIAN8, new class_2960("civilizations", "textures/entity/egypt_civilian_8.png"));
    });

    public EgyptCivilianRenderer(class_5617.class_5618 context) {
        super(context, new EgyptCivilianModel(context.method_32167(ModModelLayers.EGYPT_CIVILIAN)), 0.6f);
    }

    public class_2960 getTexture(EgyptCivilianEntity entity) {
        return LOCATION_BY_VARIANT.get((Object)entity.getVariant());
    }

    public void render(EgyptCivilianEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

