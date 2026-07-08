/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder
 *  net.minecraft.registry.SimpleRegistry
 *  net.minecraft.registry.Registry
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.RegistryBuilder;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class RegistryBuilderImpl {
    public static RegistryBuilder create(String modId) {
        return new RegistryBuilder(modId){

            @Override
            public <T> Supplier<Registry<T>> registry(RegistryKey<Registry<T>> key) {
                SimpleRegistry registry = (SimpleRegistry)FabricRegistryBuilder.createSimple(key).buildAndRegister();
                return () -> registry;
            }
        };
    }
}

