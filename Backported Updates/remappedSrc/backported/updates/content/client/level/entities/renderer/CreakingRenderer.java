/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_927
 */
package backported.updates.content.client.level.entities.renderer;

import backported.updates.content.client.level.entities.layer.LivingEntityEmissiveLayer;
import backported.updates.content.client.level.entities.model.CreakingModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.creaking.Creaking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_927;

@Environment(value=EnvType.CLIENT)
public class CreakingRenderer<T extends Creaking>
extends class_927<T, CreakingModel<T>> {
    private static final class_2960 TEXTURE_LOCATION = class_2960.method_60656((String)"textures/entity/creaking/creaking.png");
    private static final class_2960 EYES_TEXTURE_LOCATION = class_2960.method_60656((String)"textures/entity/creaking/creaking_eyes.png");

    public CreakingRenderer(class_5617.class_5618 context) {
        super(context, new CreakingModel(context.method_32167(ModModelLayers.CREAKING)), 0.7f);
        this.method_4046(new LivingEntityEmissiveLayer(this, creaking -> EYES_TEXTURE_LOCATION, (creaking, ageInTicks) -> creaking.shouldEyesGlow() ? 1.0f : 0.0f, new CreakingModel(context.method_32167(ModModelLayers.CREAKING)), class_1921::method_23026, true));
    }

    public class_2960 getTextureLocation(Creaking entity) {
        return TEXTURE_LOCATION;
    }
}

