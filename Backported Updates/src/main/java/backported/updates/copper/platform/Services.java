/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.copper.platform;

import backported.updates.copper.Constants;
import backported.updates.copper.platform.services.IBlockEntityHelper;
import backported.updates.copper.platform.services.IPlatformHelper;
import backported.updates.copper.registry.ModItemHelper;
import java.util.ServiceLoader;

public class Services {
    public static final IPlatformHelper PLATFORM = Services.load(IPlatformHelper.class);
    public static final IBlockEntityHelper BLOCK_ENTITY = Services.load(IBlockEntityHelper.class);
    public static final ModItemHelper ITEM_HELPER = Services.load(ModItemHelper.class);

    public static <T> T load(Class<T> clazz) {
        T loadedService = ServiceLoader.load(clazz).findFirst().orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}

