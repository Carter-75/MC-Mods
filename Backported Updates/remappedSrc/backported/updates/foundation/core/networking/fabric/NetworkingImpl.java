/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_1657
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.foundation.core.networking.fabric;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.networking.Networking;
import backported.updates.foundation.core.networking.PayloadContext;
import backported.updates.foundation.core.networking.fabric.ClientNetworking;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1657;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public class NetworkingImpl {
    public static void register(Consumer<Networking.Registrar> listener) {
        listener.accept(new Networking.Registrar(){

            @Override
            public <T extends class_8710> void registerToServer(class_8710.class_9154<T> type, class_9139<? super class_9129, T> codec, BiConsumer<T, PayloadContext> handler) {
                PayloadTypeRegistry.playC2S().register(type, codec);
                ServerPlayNetworking.registerGlobalReceiver(type, (payload, context) -> handler.accept(payload, NetworkingImpl.serverboundWrapper(context)));
            }

            @Override
            public <T extends class_8710> void registerToClient(class_8710.class_9154<T> type, class_9139<? super class_9129, T> codec, BiConsumer<T, PayloadContext> handler) {
                if (Environment.isClientSide()) {
                    ClientNetworking.registerToClient(type, codec, handler);
                }
            }
        });
    }

    private static PayloadContext serverboundWrapper(final ServerPlayNetworking.Context context) {
        return new PayloadContext(){

            @Override
            public class_1657 player() {
                return context.player();
            }

            @Override
            public CompletableFuture<Void> enqueueWork(Runnable runnable) {
                CompletableFuture<Void> future = new CompletableFuture<Void>();
                context.server().execute(() -> {
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
                context.server().execute(() -> {
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

