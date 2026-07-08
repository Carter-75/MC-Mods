/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PacketSender
 *  net.minecraft.class_2540
 *  net.minecraft.class_3222
 *  net.minecraft.class_3244
 *  net.minecraft.server.MinecraftServer
 */
package net._void.civilizations.networking.packet;

import net._void.civilizations.block.entity.TradingStationBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import net.minecraft.server.MinecraftServer;

public class TradeC2SPacket {
    public static void receive(MinecraftServer server, class_3222 player, class_3244 handler, class_2540 buf, PacketSender responseSender) {
        TradingStationBlockEntity.TRADE = buf.readInt();
    }
}

