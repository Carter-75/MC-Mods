/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceReloader
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.events.fabric.ResourceReloadManagerImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceReloader;

public class ResourceReloadManager {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerClient(Consumer<ListenerEvent> listener) {
        ResourceReloadManagerImpl.registerClient(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerServer(Consumer<ListenerEvent> listener) {
        ResourceReloadManagerImpl.registerServer(listener);
    }

    public static interface ListenerEvent {
        public void register(Identifier var1, ResourceReloader var2);
    }
}

