/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_2960
 *  net.minecraft.class_3302
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.events.fabric.ResourceReloadManagerImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import net.minecraft.class_2960;
import net.minecraft.class_3302;

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
        public void register(class_2960 var1, class_3302 var2);
    }
}

