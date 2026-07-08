/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1428
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_558
 *  net.minecraft.class_5617$class_5618
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.client.api.renderer.AbstractVariantRenderer;
import backported.updates.content.client.level.entities.model.chicken.ColdChickenModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.common.level.entities.animal.ChickenVariants;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import com.google.common.collect.Maps;
import java.util.EnumMap;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1428;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_558;
import net.minecraft.class_5617;

@Environment(value=EnvType.CLIENT)
public class ChickenVariantRenderer
extends AbstractVariantRenderer<class_1428, class_558<class_1428>, ChickenVariant, ChickenVariant.ModelType> {
    public ChickenVariantRenderer(class_5617.class_5618 context) {
        super(context);
    }

    @Override
    protected Map<ChickenVariant.ModelType, class_558<class_1428>> bakeModels(class_5617.class_5618 context) {
        EnumMap map = Maps.newEnumMap(ChickenVariant.ModelType.class);
        map.put(ChickenVariant.ModelType.NORMAL, null);
        map.put(ChickenVariant.ModelType.COLD, new ColdChickenModel(context.method_32167(ModModelLayers.COLD_CHICKEN)));
        return map;
    }

    @Override
    protected ChickenVariant.ModelType getModelType(ChickenVariant variant) {
        return variant.modelAndTexture().model();
    }

    @Override
    protected class_2960 getTexture(ChickenVariant variant) {
        return variant.modelAndTexture().asset().path();
    }

    @Override
    protected BuiltInCoreRegistry<ChickenVariant> getRegistry() {
        return ModBuiltinRegistries.CHICKEN_VARIANTS;
    }

    @Override
    protected class_5321<ChickenVariant> getDefaultVariant() {
        return ChickenVariants.TEMPERATE;
    }
}

