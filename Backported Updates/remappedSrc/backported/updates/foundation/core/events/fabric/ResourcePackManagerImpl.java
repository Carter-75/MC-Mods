/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.resource.ResourceManagerHelper
 *  net.fabricmc.fabric.api.resource.ResourcePackActivationType
 *  net.fabricmc.loader.api.FabricLoader
 *  net.fabricmc.loader.api.ModContainer
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3264
 *  net.minecraft.class_3283
 *  net.minecraft.class_3285
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
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3264;
import net.minecraft.class_3283;
import net.minecraft.class_3285;

public class ResourcePackManagerImpl {
    public static final List<class_3285> PACKS = new ArrayList<class_3285>();

    public static void registerPack(Consumer<ResourcePackManager.Event> listener) {
        listener.accept((type, source) -> {
            class_3283 patt0$temp;
            if (Environment.isClientSide() && type == class_3264.field_14188 && (patt0$temp = class_310.method_1551().method_1520()) instanceof PackRepositoryAccessor) {
                PackRepositoryAccessor repository = (PackRepositoryAccessor)patt0$temp;
                HashSet<class_3285> sources = new HashSet<class_3285>(repository.getSources());
                sources.add(source);
                repository.setSources(sources);
            }
            if (type == class_3264.field_14190) {
                PACKS.add(source);
            }
        });
    }

    public static void registerBuiltResourcePack(class_2960 packId, String modId, String packName) {
        ResourceManagerHelper.registerBuiltinResourcePack((class_2960)packId, (ModContainer)((ModContainer)FabricLoader.getInstance().getModContainer(modId).orElseThrow()), (String)packName, (ResourcePackActivationType)ResourcePackActivationType.NORMAL);
    }
}

