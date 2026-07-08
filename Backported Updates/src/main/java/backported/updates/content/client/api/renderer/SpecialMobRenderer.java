/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.client.api.renderer.RenderConditions;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;

public abstract class SpecialMobRenderer<T extends LivingEntity, M extends EntityModel<T>> {
    public static <R> Optional<Supplier<R>> create(final EntityRendererFactory.Context context, final Function<EntityRendererFactory.Context, R> factory, RenderConditions conditions) {
        if (!conditions.apply()) {
            return Optional.empty();
        }
        return Optional.of(new Supplier<R>(){
            private R instance;

            @Override
            public R get() {
                if (this.instance == null) {
                    this.instance = factory.apply(context);
                }
                return this.instance;
            }
        });
    }

    public static <R> Optional<Supplier<R>> create(EntityRendererFactory.Context context, Function<EntityRendererFactory.Context, R> factory) {
        return SpecialMobRenderer.create(context, factory, RenderConditions.DEFAULT);
    }

    public abstract Optional<Identifier> getTexture(T var1);

    public abstract Optional<M> getModel(T var1);
}

