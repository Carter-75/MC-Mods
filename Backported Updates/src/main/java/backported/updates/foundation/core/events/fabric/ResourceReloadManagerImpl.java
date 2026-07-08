/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener
 *  net.fabricmc.fabric.api.resource.ResourceManagerHelper
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceType
 *  net.minecraft.resource.ResourceManager
 *  net.minecraft.resource.ResourceReloader
 *  net.minecraft.resource.ResourceReloader$Synchronizer
 *  net.minecraft.util.profiler.Profiler
 *  org.jetbrains.annotations.NotNull
 */
package backported.updates.foundation.core.events.fabric;

import backported.updates.foundation.core.events.ResourceReloadManager;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloader;
import net.minecraft.util.profiler.Profiler;
import org.jetbrains.annotations.NotNull;

public class ResourceReloadManagerImpl {
    public static void registerClient(Consumer<ResourceReloadManager.ListenerEvent> event) {
        event.accept((id, listener) -> ResourceManagerHelper.get((ResourceType)ResourceType.CLIENT_RESOURCES).registerReloadListener(ResourceReloadManagerImpl.listenerWrapper(id, listener)));
    }

    public static void registerServer(Consumer<ResourceReloadManager.ListenerEvent> event) {
        event.accept((id, listener) -> ResourceManagerHelper.get((ResourceType)ResourceType.SERVER_DATA).registerReloadListener(ResourceReloadManagerImpl.listenerWrapper(id, listener)));
    }

    private static IdentifiableResourceReloadListener listenerWrapper(final Identifier id, final ResourceReloader listener) {
        return new IdentifiableResourceReloadListener(){

            public Identifier getFabricId() {
                return id;
            }

            @NotNull
            public CompletableFuture<Void> reload(ResourceReloader.Synchronizer preparationBarrier, ResourceManager resourceManager, Profiler preparationsProfiler, Profiler reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return listener.reload(preparationBarrier, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
            }
        };
    }
}

