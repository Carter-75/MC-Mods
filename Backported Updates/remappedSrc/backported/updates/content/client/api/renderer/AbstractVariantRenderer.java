/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1309
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
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
import net.minecraft.class_1309;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5617;
import net.minecraft.class_583;

@Environment(value=EnvType.CLIENT)
public abstract class AbstractVariantRenderer<T extends class_1309, M extends class_583<T>, V, E extends Enum<E>>
extends SpecialMobRenderer<T, M> {
    protected final Map<E, M> modelByVariant;

    public AbstractVariantRenderer(class_5617.class_5618 context) {
        this.modelByVariant = this.bakeModels(context);
    }

    protected abstract Map<E, M> bakeModels(class_5617.class_5618 var1);

    protected Optional<V> getVariant(T entity) {
        return VariantDataHolder.getHolder(entity).getVariantData();
    }

    protected abstract E getModelType(V var1);

    protected abstract class_2960 getTexture(V var1);

    protected abstract BuiltInCoreRegistry<V> getRegistry();

    protected abstract class_5321<V> getDefaultVariant();

    private boolean isDefaultVariant(V variant) {
        return VariantUtils.matches(this.getRegistry(), variant, this.getDefaultVariant());
    }

    @Override
    public Optional<class_2960> getTexture(T entity) {
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
        class_583 model = (class_583)this.modelByVariant.get(modelType);
        return Optional.ofNullable(model);
    }
}

