/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.client.api.renderer.RenderConditions;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_1309;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_583;

public abstract class SpecialMobRenderer<T extends class_1309, M extends class_583<T>> {
    public static <R> Optional<Supplier<R>> create(final class_5617.class_5618 context, final Function<class_5617.class_5618, R> factory, RenderConditions conditions) {
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

    public static <R> Optional<Supplier<R>> create(class_5617.class_5618 context, Function<class_5617.class_5618, R> factory) {
        return SpecialMobRenderer.create(context, factory, RenderConditions.DEFAULT);
    }

    public abstract Optional<class_2960> getTexture(T var1);

    public abstract Optional<M> getModel(T var1);
}

