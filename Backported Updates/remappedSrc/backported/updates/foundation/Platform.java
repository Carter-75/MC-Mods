/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5455
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package backported.updates.foundation;

import backported.updates.foundation.common.CommonSetup;
import backported.updates.foundation.common.resource.RegistryAwareJsonReloadListener;
import backported.updates.foundation.common.worldgen.modifier.BiomeManager;
import backported.updates.foundation.core.ModInstance;
import backported.updates.foundation.core.helper.AttachmentRegistry;
import backported.updates.foundation.core.networking.Networking;
import backported.updates.foundation.core.networking.packet.ClientboundConfigSyncPayload;
import backported.updates.foundation.core.util.config.ConfigLoader;
import net.minecraft.class_2960;
import net.minecraft.class_5455;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Platform {
    public static final String MOD_ID = "platform";
    public static final Logger LOGGER = LogManager.getLogger((String)"platform");
    public static final ModInstance INSTANCE = ModInstance.create("platform").common(CommonSetup::setup).build();

    public static void bootstrap() {
        INSTANCE.bootstrap();
        Networking.register(registrar -> registrar.registerToClient(ClientboundConfigSyncPayload.TYPE, ClientboundConfigSyncPayload.STREAM_CODEC, ClientboundConfigSyncPayload::handler));
        ConfigLoader.bootstrap();
        BiomeManager.bootstrap();
        AttachmentRegistry.bootstrap();
    }

    public static void afterDataReload(class_5455 registryAccess, boolean client) {
        RegistryAwareJsonReloadListener.runReloads(registryAccess);
    }

    public static class_2960 resource(String path) {
        return class_2960.method_60655((String)MOD_ID, (String)path);
    }
}

