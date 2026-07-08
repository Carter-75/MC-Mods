/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.fabricmc.fabric.api.event.registry.DynamicRegistries
 *  net.fabricmc.fabric.api.event.registry.DynamicRegistries$SyncOption
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.foundation.core.helper.fabric;

import backported.updates.foundation.core.helper.DynamicRegistry;
import com.mojang.serialization.Codec;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.registry.RegistryKey;

public class DynamicRegistryImpl {
    public static void onRegister(Consumer<DynamicRegistry.Registrar> listener) {
        listener.accept(new DynamicRegistry.Registrar(){

            @Override
            public <T> void registerDynamicRegistry(RegistryKey<net.minecraft.registry.Registry<T>> key, Codec<T> codec) {
                DynamicRegistries.registerSynced(key, codec, new DynamicRegistries.SyncOption[0]);
            }
        });
    }
}

