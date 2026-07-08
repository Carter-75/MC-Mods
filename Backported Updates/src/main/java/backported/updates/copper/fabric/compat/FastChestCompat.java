/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 */
package backported.updates.copper.fabric.compat;

import java.lang.reflect.Field;
import net.fabricmc.loader.api.FabricLoader;

public class FastChestCompat {
    private static final boolean FASTCHEST_LOADED = FabricLoader.getInstance().isModLoaded("fastchest");
    private static Field simplifiedChestField;

    public static boolean isFastChestLoaded() {
        return FASTCHEST_LOADED;
    }

    public static boolean isSimplifiedChestEnabled() {
        if (!FASTCHEST_LOADED || simplifiedChestField == null) {
            return false;
        }
        try {
            return simplifiedChestField.getBoolean(null);
        }
        catch (IllegalAccessException e) {
            return false;
        }
    }

    static {
        if (FASTCHEST_LOADED) {
            try {
                Class<?> configClass = Class.forName("re.domi.fastchest.config.Config");
                simplifiedChestField = configClass.getField("simplifiedChest");
            }
            catch (ClassNotFoundException | NoSuchFieldException e) {
                simplifiedChestField = null;
            }
        }
    }
}

