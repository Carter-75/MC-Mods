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
import net._void.civilizations.entity.client.ModModelLayers;
import net._void.civilizations.entity.client.NordicCivilianModel;
import net._void.civilizations.entity.custom.NordicCivilianEntity;
import net._void.civilizations.entity.custom.NordicCivilianVariant;
import net.minecraft.class_1308;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class NordicCivilianRenderer
extends class_927<NordicCivilianEntity, NordicCivilianModel<NordicCivilianEntity>> {
    public static final Map<NordicCivilianVariant, class_2960> LOCATION_BY_VARIANT = (Map)class_156.method_654((Object)Maps.newEnumMap(NordicCivilianVariant.class), map -> {
        map.put(NordicCivilianVariant.CIVILIAN1, new class_2960("civilizations", "textures/entity/nordic_civilian.png"));
        map.put(NordicCivilianVariant.CIVILIAN2, new class_2960("civilizations", "textures/entity/nordic_civilian_2.png"));
        map.put(NordicCivilianVariant.CIVILIAN3, new class_2960("civilizations", "textures/entity/nordic_civilian_3.png"));
        map.put(NordicCivilianVariant.CIVILIAN4, new class_2960("civilizations", "textures/entity/nordic_civilian_4.png"));
    });

    public NordicCivilianRenderer(class_5617.class_5618 context) {
        super(context, new NordicCivilianModel(context.method_32167(ModModelLayers.NORDIC_CIVILIAN)), 0.6f);
    }

    public class_2960 getTexture(NordicCivilianEntity entity) {
        return LOCATION_BY_VARIANT.get((Object)entity.getVariant());
    }

    public void render(NordicCivilianEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

