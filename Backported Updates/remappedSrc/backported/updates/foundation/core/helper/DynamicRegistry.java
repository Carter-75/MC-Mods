/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_2378
 *  net.minecraft.class_5321
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.helper.fabric.DynamicRegistryImpl;
import com.mojang.serialization.Codec;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import net.minecraft.class_2378;
import net.minecraft.class_5321;

public class DynamicRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void onRegister(Consumer<Registrar> consumer) {
        DynamicRegistryImpl.onRegister(consumer);
    }

    public static interface Registrar {
        public <T> void registerDynamicRegistry(class_5321<class_2378<T>> var1, Codec<T> var2);
    }
}

