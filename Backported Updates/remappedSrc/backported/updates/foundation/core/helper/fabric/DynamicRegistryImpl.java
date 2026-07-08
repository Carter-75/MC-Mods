/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.fabricmc.fabric.api.event.registry.DynamicRegistries
 *  net.fabricmc.fabric.api.event.registry.DynamicRegistries$SyncOption
 *  net.minecraft.class_5321
 */
package backported.updates.foundation.core.helper.fabric;

import backported.updates.foundation.core.helper.DynamicRegistry;
import com.mojang.serialization.Codec;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.class_5321;

public class DynamicRegistryImpl {
    public static void onRegister(Consumer<DynamicRegistry.Registrar> listener) {
        listener.accept((x$0, x$1) -> DynamicRegistries.registerSynced((class_5321)x$0, (Codec)x$1, (DynamicRegistries.SyncOption[])new DynamicRegistries.SyncOption[0]));
    }
}

