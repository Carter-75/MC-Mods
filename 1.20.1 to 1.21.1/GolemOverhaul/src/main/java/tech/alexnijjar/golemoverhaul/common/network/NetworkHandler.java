/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.network.NetworkChannel
 */
package tech.alexnijjar.golemoverhaul.common.network;

import com.teamresourceful.resourcefullib.common.network.NetworkChannel;
import tech.alexnijjar.golemoverhaul.common.network.packets.ServerboundGolemSummonPacket;

public class NetworkHandler {
    public static final NetworkChannel CHANNEL = new NetworkChannel("golemoverhaul", 1, "1");

    public static void init() {
        CHANNEL.register(ServerboundGolemSummonPacket.TYPE);
    }
}

