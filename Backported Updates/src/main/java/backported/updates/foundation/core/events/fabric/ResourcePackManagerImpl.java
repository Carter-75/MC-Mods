/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.resource.ResourceManagerHelper
 *  net.fabricmc.fabric.api.resource.ResourcePackActivationType
 *  net.fabricmc.loader.api.FabricLoader
 *  net.fabricmc.loader.api.ModContainer
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.resource.ResourceType
 *  net.minecraft.resource.ResourcePackManager
 *  net.minecraft.resource.ResourcePackProvider
 */
package backported.updates.foundation.core.events.fabric;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.events.ResourcePackManager;
import backported_updates.mixin.foundation.access.PackRepositoryAccessor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.ResourcePackProvider;

public class ResourcePackManagerImpl {
    public static final List<ResourcePackProvider> PACKS = new ArrayList<ResourcePackProvider>();

    public static void registerPack(Consumer<ResourcePackManager.Event> listener) {
        listener.accept((type, source) -> {
            net.minecraft.resource.ResourcePackManager patt0$temp;
            if (Environment.isClientSide() && type == ResourceType.CLIENT_RESOURCES && (patt0$temp = MinecraftClient.getInstance().getResourcePackManager()) instanceof PackRepositoryAccessor) {
                PackRepositoryAccessor repository = (PackRepositoryAccessor)patt0$temp;
                HashSet<ResourcePackProvider> sources = new HashSet<ResourcePackProvider>(repository.getProviders());
                sources.add(source);
                repository.setProviders(sources);
            }
            if (type == ResourceType.SERVER_DATA) {
                PACKS.add(source);
            }
        });
    }

    public static void registerBuiltResourcePack(Identifier packId, String modId, String packName) {
        ResourceManagerHelper.registerBuiltinResourcePack(packId, (ModContainer)((ModContainer)FabricLoader.getInstance().getModContainer(modId).orElseThrow()), (String)packName, (ResourcePackActivationType)ResourcePackActivationType.NORMAL);
    }
}

