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
import net._void.civilizations.entity.client.RomeCivilianModel;
import net._void.civilizations.entity.custom.RomeCivilianEntity;
import net._void.civilizations.entity.custom.RomeCivilianVariant;
import net.minecraft.class_1308;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class RomeCivilianRenderer
extends class_927<RomeCivilianEntity, RomeCivilianModel<RomeCivilianEntity>> {
    public static final Map<RomeCivilianVariant, class_2960> LOCATION_BY_VARIANT = (Map)class_156.method_654((Object)Maps.newEnumMap(RomeCivilianVariant.class), map -> {
        map.put(RomeCivilianVariant.CIVILIAN1, new class_2960("civilizations", "textures/entity/rome_civilian.png"));
        map.put(RomeCivilianVariant.CIVILIAN2, new class_2960("civilizations", "textures/entity/rome_civilian_2.png"));
        map.put(RomeCivilianVariant.CIVILIAN3, new class_2960("civilizations", "textures/entity/rome_civilian_3.png"));
        map.put(RomeCivilianVariant.CIVILIAN4, new class_2960("civilizations", "textures/entity/rome_civilian_4.png"));
        map.put(RomeCivilianVariant.CIVILIAN5, new class_2960("civilizations", "textures/entity/rome_civilian_5.png"));
        map.put(RomeCivilianVariant.CIVILIAN6, new class_2960("civilizations", "textures/entity/rome_civilian_6.png"));
        map.put(RomeCivilianVariant.CIVILIAN7, new class_2960("civilizations", "textures/entity/rome_civilian_7.png"));
        map.put(RomeCivilianVariant.CIVILIAN8, new class_2960("civilizations", "textures/entity/rome_civilian_8.png"));
    });

    public RomeCivilianRenderer(class_5617.class_5618 context) {
        super(context, new RomeCivilianModel(context.method_32167(ModModelLayers.ROME_CIVILIAN)), 0.6f);
    }

    public class_2960 getTexture(RomeCivilianEntity entity) {
        return LOCATION_BY_VARIANT.get((Object)entity.getVariant());
    }

    public void render(RomeCivilianEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

