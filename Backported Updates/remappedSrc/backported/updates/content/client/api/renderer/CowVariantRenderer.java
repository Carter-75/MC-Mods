/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1430
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_560
 *  net.minecraft.class_5617$class_5618
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.client.api.renderer.AbstractVariantRenderer;
import backported.updates.content.client.level.entities.model.cow.ColdCowModel;
import backported.updates.content.client.level.entities.model.cow.WarmCowModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.animal.CowVariant;
import backported.updates.content.common.level.entities.animal.CowVariants;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import com.google.common.collect.Maps;
import java.util.EnumMap;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1430;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_560;
import net.minecraft.class_5617;

@Environment(value=EnvType.CLIENT)
public class CowVariantRenderer
extends AbstractVariantRenderer<class_1430, class_560<class_1430>, CowVariant, CowVariant.ModelType> {
    public CowVariantRenderer(class_5617.class_5618 context) {
        super(context);
    }

    @Override
    public Map<CowVariant.ModelType, class_560<class_1430>> bakeModels(class_5617.class_5618 context) {
        EnumMap map = Maps.newEnumMap(CowVariant.ModelType.class);
        map.put(CowVariant.ModelType.NORMAL, null);
        map.put(CowVariant.ModelType.WARM, new WarmCowModel(context.method_32167(ModModelLayers.WARM_COW)));
        map.put(CowVariant.ModelType.COLD, new ColdCowModel(context.method_32167(ModModelLayers.COLD_COW)));
        return map;
    }

    @Override
    protected CowVariant.ModelType getModelType(CowVariant variant) {
        return variant.modelAndTexture().model();
    }

    @Override
    protected class_2960 getTexture(CowVariant variant) {
        return variant.modelAndTexture().asset().path();
    }

    @Override
    protected BuiltInCoreRegistry<CowVariant> getRegistry() {
        return ModBuiltinRegistries.COW_VARIANTS;
    }

    @Override
    protected class_5321<CowVariant> getDefaultVariant() {
        return CowVariants.TEMPERATE;
    }
}

