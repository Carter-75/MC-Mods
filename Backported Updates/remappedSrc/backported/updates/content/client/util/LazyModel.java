/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1297
 *  net.minecraft.class_5599
 *  net.minecraft.class_5601
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 */
package backported.updates.content.client.util;

import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1297;
import net.minecraft.class_5599;
import net.minecraft.class_5601;
import net.minecraft.class_583;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public class LazyModel<T extends class_1297, M extends class_583<T>>
implements Supplier<M> {
    private M model;
    private final Supplier<M> factory;

    private LazyModel(Supplier<M> factory) {
        this.factory = factory;
    }

    public static <T extends class_1297, M extends class_583<T>> LazyModel<T, M> of(class_5599 models, class_5601 layer, Function<class_630, M> factory) {
        return new LazyModel<T, class_583>(() -> (class_583)factory.apply(models.method_32072(layer)));
    }

    public static <T extends class_1297, M extends class_583<T>> LazyModel<T, M> of(Supplier<M> factory) {
        return new LazyModel<T, M>(factory);
    }

    @Override
    public M get() {
        if (this.model == null) {
            this.model = (class_583)this.factory.get();
        }
        return this.model;
    }
}

