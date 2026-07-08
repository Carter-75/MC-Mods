/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener
 *  net.fabricmc.fabric.api.resource.ResourceManagerHelper
 *  net.minecraft.class_2960
 *  net.minecraft.class_3264
 *  net.minecraft.class_3300
 *  net.minecraft.class_3302
 *  net.minecraft.class_3302$class_4045
 *  net.minecraft.class_3695
 *  org.jetbrains.annotations.NotNull
 */
package backported.updates.foundation.core.events.fabric;

import backported.updates.foundation.core.events.ResourceReloadManager;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.class_2960;
import net.minecraft.class_3264;
import net.minecraft.class_3300;
import net.minecraft.class_3302;
import net.minecraft.class_3695;
import org.jetbrains.annotations.NotNull;

public class ResourceReloadManagerImpl {
    public static void registerClient(Consumer<ResourceReloadManager.ListenerEvent> event) {
        event.accept((id, listener) -> ResourceManagerHelper.get((class_3264)class_3264.field_14188).registerReloadListener(ResourceReloadManagerImpl.listenerWrapper(id, listener)));
    }

    public static void registerServer(Consumer<ResourceReloadManager.ListenerEvent> event) {
        event.accept((id, listener) -> ResourceManagerHelper.get((class_3264)class_3264.field_14190).registerReloadListener(ResourceReloadManagerImpl.listenerWrapper(id, listener)));
    }

    private static IdentifiableResourceReloadListener listenerWrapper(final class_2960 id, final class_3302 listener) {
        return new IdentifiableResourceReloadListener(){

            public class_2960 getFabricId() {
                return id;
            }

            @NotNull
            public CompletableFuture<Void> method_25931(class_3302.class_4045 preparationBarrier, class_3300 resourceManager, class_3695 preparationsProfiler, class_3695 reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return listener.method_25931(preparationBarrier, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
            }
        };
    }
}

