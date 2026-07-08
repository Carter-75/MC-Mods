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
import net._void.civilizations.entity.client.RomeGuardModel;
import net._void.civilizations.entity.custom.RomeGuardEntity;
import net._void.civilizations.entity.custom.RomeGuardVariant;
import net.minecraft.class_1308;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class RomeGuardRenderer
extends class_927<RomeGuardEntity, RomeGuardModel<RomeGuardEntity>> {
    public static final Map<RomeGuardVariant, class_2960> LOCATION_BY_VARIANT = (Map)class_156.method_654((Object)Maps.newEnumMap(RomeGuardVariant.class), map -> {
        map.put(RomeGuardVariant.CIVILIAN1, new class_2960("civilizations", "textures/entity/rome_guard.png"));
        map.put(RomeGuardVariant.CIVILIAN2, new class_2960("civilizations", "textures/entity/rome_guard_2.png"));
    });

    public RomeGuardRenderer(class_5617.class_5618 context) {
        super(context, new RomeGuardModel(context.method_32167(ModModelLayers.ROME_GUARD)), 0.6f);
    }

    public class_2960 getTexture(RomeGuardEntity entity) {
        return LOCATION_BY_VARIANT.get((Object)entity.getVariant());
    }

    public void render(RomeGuardEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
        matrixStack.method_22905(1.0f, 1.0f, 1.0f);
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

