/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder
 *  net.minecraft.class_2370
 *  net.minecraft.class_2378
 *  net.minecraft.class_5321
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.RegistryBuilder;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.class_2370;
import net.minecraft.class_2378;
import net.minecraft.class_5321;

public class RegistryBuilderImpl {
    public static RegistryBuilder create(String modId) {
        return new RegistryBuilder(modId){

            @Override
            public <T> Supplier<class_2378<T>> registry(class_5321<class_2378<T>> key) {
                class_2370 registry = (class_2370)FabricRegistryBuilder.createSimple(key).buildAndRegister();
                return () -> registry;
            }
        };
    }
}

