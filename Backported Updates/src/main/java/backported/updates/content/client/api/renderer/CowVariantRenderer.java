/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.passive.CowEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.client.render.entity.model.CowEntityModel
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
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
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;

@Environment(value=EnvType.CLIENT)
public class CowVariantRenderer
extends AbstractVariantRenderer<CowEntity, CowEntityModel<CowEntity>, CowVariant, CowVariant.ModelType> {
    public CowVariantRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Map<CowVariant.ModelType, CowEntityModel<CowEntity>> bakeModels(EntityRendererFactory.Context context) {
        EnumMap map = Maps.newEnumMap(CowVariant.ModelType.class);
        map.put(CowVariant.ModelType.NORMAL, null);
        map.put(CowVariant.ModelType.WARM, new WarmCowModel(context.getPart(ModModelLayers.WARM_COW)));
        map.put(CowVariant.ModelType.COLD, new ColdCowModel(context.getPart(ModModelLayers.COLD_COW)));
        return map;
    }

    @Override
    protected CowVariant.ModelType getModelType(CowVariant variant) {
        return variant.modelAndTexture().model();
    }

    @Override
    protected Identifier getTexture(CowVariant variant) {
        return variant.modelAndTexture().asset().path();
    }

    @Override
    protected BuiltInCoreRegistry<CowVariant> getRegistry() {
        return ModBuiltinRegistries.COW_VARIANTS;
    }

    @Override
    protected RegistryKey<CowVariant> getDefaultVariant() {
        return CowVariants.TEMPERATE;
    }
}

