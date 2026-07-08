/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.minecraft.network.packet.CustomPayload
 */
package backported.updates.foundation.core.networking.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.packet.CustomPayload;

public class ClientPayloadDistributor {
    @Environment(value=EnvType.CLIENT)
    public static void sendToServer(CustomPayload payload) {
        ClientPlayNetworking.send((CustomPayload)payload);
    }
}

