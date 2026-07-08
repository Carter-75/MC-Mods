/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.ChickenEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.client.render.entity.model.ChickenEntityModel
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
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
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;

@Environment(value=EnvType.CLIENT)
public class ChickenVariantRenderer
extends AbstractVariantRenderer<ChickenEntity, ChickenEntityModel<ChickenEntity>, ChickenVariant, ChickenVariant.ModelType> {
    public ChickenVariantRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected Map<ChickenVariant.ModelType, ChickenEntityModel<ChickenEntity>> bakeModels(EntityRendererFactory.Context context) {
        EnumMap map = Maps.newEnumMap(ChickenVariant.ModelType.class);
        map.put(ChickenVariant.ModelType.NORMAL, null);
        map.put(ChickenVariant.ModelType.COLD, new ColdChickenModel(context.getPart(ModModelLayers.COLD_CHICKEN)));
        return map;
    }

    @Override
    protected ChickenVariant.ModelType getModelType(ChickenVariant variant) {
        return variant.modelAndTexture().model();
    }

    @Override
    protected Identifier getTexture(ChickenVariant variant) {
        return variant.modelAndTexture().asset().path();
    }

    @Override
    protected BuiltInCoreRegistry<ChickenVariant> getRegistry() {
        return ModBuiltinRegistries.CHICKEN_VARIANTS;
    }

    @Override
    protected RegistryKey<ChickenVariant> getDefaultVariant() {
        return ChickenVariants.TEMPERATE;
    }
}

