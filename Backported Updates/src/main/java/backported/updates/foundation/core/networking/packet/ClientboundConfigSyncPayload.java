/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.network.packet.CustomPayload$Id
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodecs
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.foundation.core.networking.packet;

import backported.updates.foundation.Platform;
import backported.updates.foundation.core.networking.PayloadContext;
import backported.updates.foundation.core.util.config.ConfigTracker;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.codec.PacketCodec;

public record ClientboundConfigSyncPayload(String name, byte[] data) implements CustomPayload
{
    public static final CustomPayload.Id<ClientboundConfigSyncPayload> TYPE = new CustomPayload.Id(Platform.resource("clientbound_config_sync"));
    public static final PacketCodec<RegistryByteBuf, ClientboundConfigSyncPayload> STREAM_CODEC = PacketCodec.tuple((PacketCodec)PacketCodecs.STRING, ClientboundConfigSyncPayload::name, (PacketCodec)PacketCodecs.BYTE_ARRAY, ClientboundConfigSyncPayload::data, ClientboundConfigSyncPayload::new);

    public CustomPayload.Id<? extends CustomPayload> getId() {
        return TYPE;
    }

    public static void handler(ClientboundConfigSyncPayload payload, PayloadContext context) {
        context.enqueueWork(() -> ConfigTracker.INSTANCE.receiveSyncedConfig(payload));
    }
}

