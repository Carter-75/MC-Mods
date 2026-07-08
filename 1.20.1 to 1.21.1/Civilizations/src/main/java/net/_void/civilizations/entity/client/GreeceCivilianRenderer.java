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
import net._void.civilizations.entity.client.GreeceCivilianModel;
import net._void.civilizations.entity.client.ModModelLayers;
import net._void.civilizations.entity.custom.GreeceCivilianEntity;
import net._void.civilizations.entity.custom.GreeceCivilianVariant;
import net.minecraft.class_1308;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class GreeceCivilianRenderer
extends class_927<GreeceCivilianEntity, GreeceCivilianModel<GreeceCivilianEntity>> {
    public static final Map<GreeceCivilianVariant, class_2960> LOCATION_BY_VARIANT = (Map)class_156.method_654((Object)Maps.newEnumMap(GreeceCivilianVariant.class), map -> {
        map.put(GreeceCivilianVariant.CIVILIAN1, new class_2960("civilizations", "textures/entity/greece_civilian.png"));
        map.put(GreeceCivilianVariant.CIVILIAN2, new class_2960("civilizations", "textures/entity/greece_civilian_2.png"));
        map.put(GreeceCivilianVariant.CIVILIAN3, new class_2960("civilizations", "textures/entity/greece_civilian_3.png"));
        map.put(GreeceCivilianVariant.CIVILIAN4, new class_2960("civilizations", "textures/entity/greece_civilian_4.png"));
        map.put(GreeceCivilianVariant.CIVILIAN5, new class_2960("civilizations", "textures/entity/greece_civilian_5.png"));
        map.put(GreeceCivilianVariant.CIVILIAN6, new class_2960("civilizations", "textures/entity/greece_civilian_6.png"));
        map.put(GreeceCivilianVariant.CIVILIAN7, new class_2960("civilizations", "textures/entity/greece_civilian_7.png"));
        map.put(GreeceCivilianVariant.CIVILIAN8, new class_2960("civilizations", "textures/entity/greece_civilian_8.png"));
    });

    public GreeceCivilianRenderer(class_5617.class_5618 context) {
        super(context, new GreeceCivilianModel(context.method_32167(ModModelLayers.GREECE_CIVILIAN)), 0.6f);
    }

    public class_2960 getTexture(GreeceCivilianEntity entity) {
        return LOCATION_BY_VARIANT.get((Object)entity.getVariant());
    }

    public void render(GreeceCivilianEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

