/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.Entity
 *  net.minecraft.client.render.entity.model.EntityModelLoader
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.content.client.util;

import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public class LazyModel<T extends Entity, M extends EntityModel<T>>
implements Supplier<M> {
    private M model;
    private final Supplier<M> factory;

    private LazyModel(Supplier<M> factory) {
        this.factory = factory;
    }

    public static <T extends Entity, M extends EntityModel<T>> LazyModel<T, M> of(EntityModelLoader models, EntityModelLayer layer, Function<ModelPart, M> factory) {
        return new LazyModel<>(() -> factory.apply(models.getModelPart(layer)));
    }

    public static <T extends Entity, M extends EntityModel<T>> LazyModel<T, M> of(Supplier<M> factory) {
        return new LazyModel<T, M>(factory);
    }

    @Override
    public M get() {
        if (this.model == null) {
            this.model = this.factory.get();
        }
        return this.model;
    }
}

