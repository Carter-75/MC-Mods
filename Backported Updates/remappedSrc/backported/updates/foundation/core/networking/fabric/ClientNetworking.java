/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking$Context
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.minecraft.class_1657
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.foundation.core.networking.fabric;

import backported.updates.foundation.core.networking.PayloadContext;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.class_1657;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public class ClientNetworking {
    public static <T extends class_8710> void registerToClient(class_8710.class_9154<T> type, class_9139<? super class_9129, T> codec, BiConsumer<T, PayloadContext> handler) {
        PayloadTypeRegistry.playS2C().register(type, codec);
        ClientPlayNetworking.registerGlobalReceiver(type, (payload, context) -> handler.accept(payload, ClientNetworking.clientboundWrapper(context)));
    }

    private static PayloadContext clientboundWrapper(final ClientPlayNetworking.Context context) {
        return new PayloadContext(){

            @Override
            public class_1657 player() {
                return context.player();
            }

            @Override
            public CompletableFuture<Void> enqueueWork(Runnable runnable) {
                CompletableFuture<Void> future = new CompletableFuture<Void>();
                context.client().execute(() -> {
                    try {
                        runnable.run();
                        future.complete(null);
                    }
                    catch (Exception exception) {
                        future.completeExceptionally(exception);
                    }
                });
                return future;
            }

            public <S> CompletableFuture<S> enqueueWork(Supplier<S> supplier) {
                CompletableFuture future = new CompletableFuture();
                context.client().execute(() -> {
                    try {
                        future.complete(supplier.get());
                    }
                    catch (Exception e) {
                        future.completeExceptionally(e);
                    }
                });
                return future;
            }
        };
    }
}

