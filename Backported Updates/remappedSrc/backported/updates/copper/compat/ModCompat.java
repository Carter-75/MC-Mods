/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat;

import backported.updates.copper.Constants;
import backported.updates.copper.compat.IChestHandler;
import backported.updates.copper.compat.IContainerCompat;
import backported.updates.copper.compat.IModCompatModule;
import backported.updates.copper.platform.Services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.class_1263;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import org.jetbrains.annotations.Nullable;

public class ModCompat {
    private static final Map<String, IModCompatModule> MODULES = new HashMap<String, IModCompatModule>();
    private static final List<IChestHandler> CHEST_HANDLERS = new ArrayList<IChestHandler>();
    private static final List<IContainerCompat> CONTAINER_HANDLERS = new ArrayList<IContainerCompat>();
    private static boolean initialized = false;

    public static void register(String modId, Supplier<IModCompatModule> moduleSupplier) {
        if (initialized) {
            Constants.LOG.warn("ModCompat: Tried to register module for '{}' after initialization!", (Object)modId);
            return;
        }
        if (MODULES.containsKey(modId)) {
            Constants.LOG.warn("ModCompat: Module for '{}' already registered, skipping duplicate", (Object)modId);
            return;
        }
        if (Services.PLATFORM.isModLoaded(modId)) {
            try {
                IModCompatModule module = moduleSupplier.get();
                MODULES.put(modId, module);
                Constants.LOG.info("ModCompat: Registered compatibility module for '{}'", (Object)modId);
            }
            catch (Exception e) {
                Constants.LOG.error("ModCompat: Failed to create module for '{}': {}", (Object)modId, (Object)e.getMessage());
            }
        } else {
            Constants.LOG.debug("ModCompat: Mod '{}' not loaded, skipping compatibility module", (Object)modId);
        }
    }

    public static void init() {
        if (initialized) {
            Constants.LOG.warn("ModCompat: Already initialized!");
            return;
        }
        Constants.LOG.info("ModCompat: Initializing {} compatibility modules...", (Object)MODULES.size());
        for (Map.Entry<String, IModCompatModule> entry : MODULES.entrySet()) {
            try {
                entry.getValue().init();
                IModCompatModule iModCompatModule = entry.getValue();
                if (iModCompatModule instanceof IChestHandler) {
                    IChestHandler handler = (IChestHandler)((Object)iModCompatModule);
                    CHEST_HANDLERS.add(handler);
                }
                if ((iModCompatModule = entry.getValue()) instanceof IContainerCompat) {
                    IContainerCompat containerCompat = (IContainerCompat)((Object)iModCompatModule);
                    CONTAINER_HANDLERS.add(containerCompat);
                }
                Constants.LOG.info("ModCompat: Initialized compatibility for '{}'", (Object)entry.getKey());
            }
            catch (Exception e) {
                Constants.LOG.error("ModCompat: Failed to initialize module for '{}': {}", (Object)entry.getKey(), (Object)e.getMessage());
            }
        }
        initialized = true;
        Constants.LOG.info("ModCompat: Initialization complete. {} chest handlers, {} container handlers registered.", (Object)CHEST_HANDLERS.size(), (Object)CONTAINER_HANDLERS.size());
    }

    public static boolean isModCompatLoaded(String modId) {
        return MODULES.containsKey(modId);
    }

    public static <T extends IModCompatModule> T getModule(String modId, Class<T> type) {
        IModCompatModule module = MODULES.get(modId);
        if (module != null && type.isInstance(module)) {
            return (T)module;
        }
        return null;
    }

    public static boolean handleChestOpen(class_1937 level, class_2338 pos, class_2680 state, boolean open) {
        for (IChestHandler handler : CHEST_HANDLERS) {
            if (!handler.canHandle(state)) continue;
            handler.setOpen(level, pos, state, open);
            return true;
        }
        return false;
    }

    public static boolean hasChestHandler(class_2680 state) {
        for (IChestHandler handler : CHEST_HANDLERS) {
            if (!handler.canHandle(state)) continue;
            return true;
        }
        return false;
    }

    public static boolean isValidModContainer(class_2680 state) {
        if (CONTAINER_HANDLERS.isEmpty()) {
            return false;
        }
        for (IContainerCompat containerCompat : CONTAINER_HANDLERS) {
            if (!containerCompat.isValidContainer(state)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    public static class_1263 getModContainer(class_2586 blockEntity, class_1937 level, class_2338 pos) {
        class_2680 state = level.method_8320(pos);
        for (IContainerCompat containerCompat : CONTAINER_HANDLERS) {
            class_1263 container;
            if (!containerCompat.isValidContainer(state) || (container = containerCompat.getContainer(blockEntity, level, pos)) == null) continue;
            return container;
        }
        return null;
    }

    public static Predicate<class_2680> getModContainerPredicate() {
        return ModCompat::isValidModContainer;
    }
}

