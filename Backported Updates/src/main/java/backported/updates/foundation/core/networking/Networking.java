/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.network.packet.CustomPayload$Id
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.foundation.core.networking;

import backported.updates.foundation.core.networking.PayloadContext;
import backported.updates.foundation.core.networking.fabric.NetworkingImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public class Networking {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void register(Consumer<Registrar> listener) {
        NetworkingImpl.register(listener);
    }

    public static interface Registrar {
        public <T extends CustomPayload> void registerToServer(CustomPayload.Id<T> var1, PacketCodec<? super RegistryByteBuf, T> var2, BiConsumer<T, PayloadContext> var3);

        public <T extends CustomPayload> void registerToClient(CustomPayload.Id<T> var1, PacketCodec<? super RegistryByteBuf, T> var2, BiConsumer<T, PayloadContext> var3);

        default public <T extends CustomPayload> void registerBidirectional(CustomPayload.Id<T> type, PacketCodec<? super RegistryByteBuf, T> codec, BiConsumer<T, PayloadContext> handler) {
            this.registerToServer(type, codec, handler);
            this.registerToClient(type, codec, handler);
        }
    }
}

