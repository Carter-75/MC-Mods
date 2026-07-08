/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.DynamicRegistryManager
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
import net.minecraft.util.Identifier;
import net.minecraft.registry.DynamicRegistryManager;
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

    public static void afterDataReload(DynamicRegistryManager registryAccess, boolean client) {
        RegistryAwareJsonReloadListener.runReloads(registryAccess);
    }

    public static Identifier resource(String path) {
        return Identifier.of((String)MOD_ID, (String)path);
    }
}

