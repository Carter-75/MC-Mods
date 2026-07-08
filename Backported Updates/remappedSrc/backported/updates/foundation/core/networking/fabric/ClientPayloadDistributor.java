/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.minecraft.class_8710
 */
package backported.updates.foundation.core.networking.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.class_8710;

public class ClientPayloadDistributor {
    @Environment(value=EnvType.CLIENT)
    public static void sendToServer(class_8710 payload) {
        ClientPlayNetworking.send((class_8710)payload);
    }
}

