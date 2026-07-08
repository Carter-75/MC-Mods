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
import net._void.civilizations.entity.client.ChinaCivilianModel;
import net._void.civilizations.entity.client.ModModelLayers;
import net._void.civilizations.entity.custom.ChinaCivilianEntity;
import net._void.civilizations.entity.custom.ChinaCivilianVariant;
import net.minecraft.class_1308;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class ChinaCivilianRenderer
extends class_927<ChinaCivilianEntity, ChinaCivilianModel<ChinaCivilianEntity>> {
    public static final Map<ChinaCivilianVariant, class_2960> LOCATION_BY_VARIANT = (Map)class_156.method_654((Object)Maps.newEnumMap(ChinaCivilianVariant.class), map -> {
        map.put(ChinaCivilianVariant.CIVILIAN1, new class_2960("civilizations", "textures/entity/china_civilian.png"));
        map.put(ChinaCivilianVariant.CIVILIAN2, new class_2960("civilizations", "textures/entity/china_civilian_2.png"));
        map.put(ChinaCivilianVariant.CIVILIAN3, new class_2960("civilizations", "textures/entity/china_civilian_3.png"));
        map.put(ChinaCivilianVariant.CIVILIAN4, new class_2960("civilizations", "textures/entity/china_civilian_4.png"));
        map.put(ChinaCivilianVariant.CIVILIAN5, new class_2960("civilizations", "textures/entity/china_civilian_5.png"));
        map.put(ChinaCivilianVariant.CIVILIAN6, new class_2960("civilizations", "textures/entity/china_civilian_6.png"));
        map.put(ChinaCivilianVariant.CIVILIAN7, new class_2960("civilizations", "textures/entity/china_civilian_7.png"));
        map.put(ChinaCivilianVariant.CIVILIAN8, new class_2960("civilizations", "textures/entity/china_civilian_8.png"));
    });

    public ChinaCivilianRenderer(class_5617.class_5618 context) {
        super(context, new ChinaCivilianModel(context.method_32167(ModModelLayers.CHINA_CIVILIAN)), 0.6f);
    }

    public class_2960 getTexture(ChinaCivilianEntity entity) {
        return LOCATION_BY_VARIANT.get((Object)entity.getVariant());
    }

    public void render(ChinaCivilianEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

