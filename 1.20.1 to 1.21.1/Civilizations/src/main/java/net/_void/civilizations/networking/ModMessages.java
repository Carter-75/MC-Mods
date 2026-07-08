/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.minecraft.class_2960
 */
package net._void.civilizations.networking;

import net._void.civilizations.networking.packet.BossMusicPlayS2CPacket;
import net._void.civilizations.networking.packet.TradeC2SPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2960;

public class ModMessages {
    public static final class_2960 BOSS_MUSIC_PLAY = new class_2960("civilizations", "boss_music_play");
    public static final class_2960 TRADE = new class_2960("civilizations", "trade");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver((class_2960)TRADE, TradeC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver((class_2960)BOSS_MUSIC_PLAY, BossMusicPlayS2CPacket::receive);
    }
}

