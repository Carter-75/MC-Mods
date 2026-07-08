/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1452
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_587
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.client.api.renderer.AbstractVariantRenderer;
import backported.updates.content.client.level.entities.model.pig.ColdPigModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.animal.PigVariant;
import backported.updates.content.common.level.entities.animal.PigVariants;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import com.google.common.collect.Maps;
import java.util.EnumMap;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1452;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5617;
import net.minecraft.class_587;

@Environment(value=EnvType.CLIENT)
public class PigVariantRenderer
extends AbstractVariantRenderer<class_1452, class_587<class_1452>, PigVariant, PigVariant.ModelType> {
    public PigVariantRenderer(class_5617.class_5618 context) {
        super(context);
    }

    @Override
    public Map<PigVariant.ModelType, class_587<class_1452>> bakeModels(class_5617.class_5618 context) {
        EnumMap map = Maps.newEnumMap(PigVariant.ModelType.class);
        map.put(PigVariant.ModelType.NORMAL, null);
        map.put(PigVariant.ModelType.COLD, new ColdPigModel(context.method_32167(ModModelLayers.COLD_PIG)));
        return map;
    }

    @Override
    protected PigVariant.ModelType getModelType(PigVariant variant) {
        return variant.modelAndTexture().model();
    }

    @Override
    protected class_2960 getTexture(PigVariant variant) {
        return variant.modelAndTexture().asset().path();
    }

    @Override
    protected BuiltInCoreRegistry<PigVariant> getRegistry() {
        return ModBuiltinRegistries.PIG_VARIANTS;
    }

    @Override
    protected class_5321<PigVariant> getDefaultVariant() {
        return PigVariants.TEMPERATE;
    }
}

