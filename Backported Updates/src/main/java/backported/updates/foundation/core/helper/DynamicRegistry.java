/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.registry.Registry
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.helper.fabric.DynamicRegistryImpl;
import com.mojang.serialization.Codec;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class DynamicRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void onRegister(Consumer<Registrar> consumer) {
        DynamicRegistryImpl.onRegister(consumer);
    }

    public static interface Registrar {
        public <T> void registerDynamicRegistry(RegistryKey<Registry<T>> var1, Codec<T> var2);
    }
}

