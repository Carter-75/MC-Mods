/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.PigEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.PigEntityModel
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
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.PigEntityModel;

@Environment(value=EnvType.CLIENT)
public class PigVariantRenderer
extends AbstractVariantRenderer<PigEntity, PigEntityModel<PigEntity>, PigVariant, PigVariant.ModelType> {
    public PigVariantRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Map<PigVariant.ModelType, PigEntityModel<PigEntity>> bakeModels(EntityRendererFactory.Context context) {
        EnumMap map = Maps.newEnumMap(PigVariant.ModelType.class);
        map.put(PigVariant.ModelType.NORMAL, null);
        map.put(PigVariant.ModelType.COLD, new ColdPigModel(context.getPart(ModModelLayers.COLD_PIG)));
        return map;
    }

    @Override
    protected PigVariant.ModelType getModelType(PigVariant variant) {
        return variant.modelAndTexture().model();
    }

    @Override
    protected Identifier getTexture(PigVariant variant) {
        return variant.modelAndTexture().asset().path();
    }

    @Override
    protected BuiltInCoreRegistry<PigVariant> getRegistry() {
        return ModBuiltinRegistries.PIG_VARIANTS;
    }

    @Override
    protected RegistryKey<PigVariant> getDefaultVariant() {
        return PigVariants.TEMPERATE;
    }
}

