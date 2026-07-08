/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.network.packet.CustomPayload$Id
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public class NetworkingImpl {
    public static void register(Consumer<Networking.Registrar> listener) {
        listener.accept(new Networking.Registrar(){

            @Override
            public <T extends CustomPayload> void registerToServer(CustomPayload.Id<T> type, PacketCodec<? super RegistryByteBuf, T> codec, BiConsumer<T, PayloadContext> handler) {
                PayloadTypeRegistry.playC2S().register(type, codec);
                ServerPlayNetworking.registerGlobalReceiver(type, (payload, context) -> handler.accept(payload, NetworkingImpl.serverboundWrapper(context)));
            }

            @Override
            public <T extends CustomPayload> void registerToClient(CustomPayload.Id<T> type, PacketCodec<? super RegistryByteBuf, T> codec, BiConsumer<T, PayloadContext> handler) {
                if (Environment.isClientSide()) {
                    ClientNetworking.registerToClient(type, codec, handler);
                }
            }
        });
    }

    private static PayloadContext serverboundWrapper(final ServerPlayNetworking.Context context) {
        return new PayloadContext(){

            @Override
            public PlayerEntity player() {
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

