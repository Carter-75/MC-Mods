/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_2941
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.helper.fabric.DataSerializerRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Supplier;
import net.minecraft.class_2941;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public abstract class DataSerializerRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static DataSerializerRegistry create(String modId) {
        return DataSerializerRegistryImpl.create(modId);
    }

    public <T> Supplier<class_2941<T>> register(String name, class_9139<? super class_9129, T> codec) {
        return this.register(name, () -> class_2941.method_56031((class_9139)codec));
    }

    public abstract <T> Supplier<class_2941<T>> register(String var1, Supplier<class_2941<T>> var2);

    public abstract void register();
}

