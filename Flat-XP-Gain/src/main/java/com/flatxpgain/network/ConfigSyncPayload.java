package com.flatxpgain.network;

import com.flatxpgain.FlatXpGain;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ConfigSyncPayload(boolean modEnabled, boolean flatXpEnabled, boolean linearXpEnabled, int level1XpCost, int nextXpAddition) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ConfigSyncPayload> ID = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(FlatXpGain.MOD_ID, "config_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ConfigSyncPayload> CODEC = CustomPacketPayload.codec(ConfigSyncPayload::write, ConfigSyncPayload::new);

    public ConfigSyncPayload(RegistryFriendlyByteBuf buf) {
        this(buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readInt(), buf.readInt());
    }

    public void write(RegistryFriendlyByteBuf buf) {
        buf.writeBoolean(this.modEnabled);
        buf.writeBoolean(this.flatXpEnabled);
        buf.writeBoolean(this.linearXpEnabled);
        buf.writeInt(this.level1XpCost);
        buf.writeInt(this.nextXpAddition);
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
