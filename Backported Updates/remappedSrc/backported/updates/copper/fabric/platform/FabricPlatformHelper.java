/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 */
package backported.updates.copper.fabric.platform;

import backported.updates.copper.fabric.compat.FastChestCompat;
import backported.updates.copper.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper
implements IPlatformHelper {
    private final FabricLoader loader = FabricLoader.getInstance();

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return this.loader.isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return this.loader.isDevelopmentEnvironment();
    }

    @Override
    public boolean isFastChestSimplifiedEnabled() {
        return FastChestCompat.isSimplifiedChestEnabled();
    }
}

