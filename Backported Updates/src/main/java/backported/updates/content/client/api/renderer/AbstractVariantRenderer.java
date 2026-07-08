/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.client.api.renderer.SpecialMobRenderer;
import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantUtils;
import backported.updates.content.core.ModChecker;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import java.util.Map;
import java.util.Optional;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(value=EnvType.CLIENT)
public abstract class AbstractVariantRenderer<T extends LivingEntity, M extends EntityModel<T>, V, E extends Enum<E>>
extends SpecialMobRenderer<T, M> {
    protected final Map<E, M> modelByVariant;

    public AbstractVariantRenderer(EntityRendererFactory.Context context) {
        this.modelByVariant = this.bakeModels(context);
    }

    protected abstract Map<E, M> bakeModels(EntityRendererFactory.Context var1);

    protected Optional<V> getVariant(T entity) {
        return VariantDataHolder.<V>getHolder(entity).getVariantData();
    }

    protected abstract E getModelType(V var1);

    protected abstract Identifier getTexture(V var1);

    protected abstract BuiltInCoreRegistry<V> getRegistry();

    protected abstract RegistryKey<V> getDefaultVariant();

    private boolean isDefaultVariant(V variant) {
        return VariantUtils.matches(this.getRegistry(), variant, this.getDefaultVariant());
    }

    @Override
    public Optional<Identifier> getTexture(T entity) {
        Optional<V> variant = this.getVariant(entity);
        return variant.filter(v -> !this.isDefaultVariant(v)).map(this::getTexture);
    }

    @Override
    public Optional<M> getModel(T entity) {
        if (ModChecker.MIXED_LITTER_LOADED) {
            return Optional.empty();
        }
        Optional<V> variant = this.getVariant(entity);
        if (variant.isEmpty()) {
            return Optional.empty();
        }
        E modelType = this.getModelType(variant.get());
        M model = this.modelByVariant.get(modelType);
        return Optional.ofNullable(model);
    }
}

