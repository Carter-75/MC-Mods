/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9129
 *  net.minecraft.class_9135
 *  net.minecraft.class_9139
 */
package backported.updates.foundation.core.networking.packet;

import backported.updates.foundation.Platform;
import backported.updates.foundation.core.networking.PayloadContext;
import backported.updates.foundation.core.util.config.ConfigTracker;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;

public record ClientboundConfigSyncPayload(String name, byte[] data) implements class_8710
{
    public static final class_8710.class_9154<ClientboundConfigSyncPayload> TYPE = new class_8710.class_9154(Platform.resource("clientbound_config_sync"));
    public static final class_9139<class_9129, ClientboundConfigSyncPayload> STREAM_CODEC = class_9139.method_56435((class_9139)class_9135.field_48554, ClientboundConfigSyncPayload::name, (class_9139)class_9135.field_48987, ClientboundConfigSyncPayload::data, ClientboundConfigSyncPayload::new);

    public class_8710.class_9154<? extends class_8710> method_56479() {
        return TYPE;
    }

    public static void handler(ClientboundConfigSyncPayload payload, PayloadContext context) {
        context.enqueueWork(() -> ConfigTracker.INSTANCE.receiveSyncedConfig(payload));
    }
}

