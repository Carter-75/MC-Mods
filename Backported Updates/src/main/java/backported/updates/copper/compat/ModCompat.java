/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
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
import net.minecraft.inventory.Inventory;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import org.jetbrains.annotations.Nullable;

public class ModCompat {
    private static final Map<String, IModCompatModule> MODULES = new HashMap<String, IModCompatModule>();
    private static final List<IChestHandler> CHEST_HANDLERS = new ArrayList<IChestHandler>();
    private static final List<IContainerCompat> CONTAINER_HANDLERS = new ArrayList<IContainerCompat>();
    private static boolean initialized = false;

    public static void register(String modId, Supplier<IModCompatModule> moduleSupplier) {
        if (initialized) {
            Constants.LOG.warn("ModCompat: Tried to register module for '{}' after initialization!", modId);
            return;
        }
        if (MODULES.containsKey(modId)) {
            Constants.LOG.warn("ModCompat: Module for '{}' already registered, skipping duplicate", modId);
            return;
        }
        if (Services.PLATFORM.isModLoaded(modId)) {
            try {
                IModCompatModule module = moduleSupplier.get();
                MODULES.put(modId, module);
                Constants.LOG.info("ModCompat: Registered compatibility module for '{}'", modId);
            }
            catch (Exception e) {
                Constants.LOG.error("ModCompat: Failed to create module for '{}': {}", modId, e.getMessage());
            }
        } else {
            Constants.LOG.debug("ModCompat: Mod '{}' not loaded, skipping compatibility module", modId);
        }
    }

    public static void init() {
        if (initialized) {
            Constants.LOG.warn("ModCompat: Already initialized!");
            return;
        }
        Constants.LOG.info("ModCompat: Initializing {} compatibility modules...", MODULES.size());
        for (Map.Entry<String, IModCompatModule> entry : MODULES.entrySet()) {
            try {
                entry.getValue().init();
                IModCompatModule iModCompatModule = entry.getValue();
                if (iModCompatModule instanceof IChestHandler) {
                    IChestHandler handler = (IChestHandler)(iModCompatModule);
                    CHEST_HANDLERS.add(handler);
                }
                if ((iModCompatModule = entry.getValue()) instanceof IContainerCompat) {
                    IContainerCompat containerCompat = (IContainerCompat)(iModCompatModule);
                    CONTAINER_HANDLERS.add(containerCompat);
                }
                Constants.LOG.info("ModCompat: Initialized compatibility for '{}'", entry.getKey());
            }
            catch (Exception e) {
                Constants.LOG.error("ModCompat: Failed to initialize module for '{}': {}", entry.getKey(), e.getMessage());
            }
        }
        initialized = true;
        Constants.LOG.info("ModCompat: Initialization complete. {} chest handlers, {} container handlers registered.", CHEST_HANDLERS.size(), CONTAINER_HANDLERS.size());
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

    public static boolean handleChestOpen(World level, BlockPos pos, BlockState state, boolean open) {
        for (IChestHandler handler : CHEST_HANDLERS) {
            if (!handler.canHandle(state)) continue;
            handler.setOpen(level, pos, state, open);
            return true;
        }
        return false;
    }

    public static boolean hasChestHandler(BlockState state) {
        for (IChestHandler handler : CHEST_HANDLERS) {
            if (!handler.canHandle(state)) continue;
            return true;
        }
        return false;
    }

    public static boolean isValidModContainer(BlockState state) {
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
    public static Inventory getModContainer(BlockEntity blockEntity, World level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        for (IContainerCompat containerCompat : CONTAINER_HANDLERS) {
            Inventory container;
            if (!containerCompat.isValidContainer(state) || (container = containerCompat.getContainer(blockEntity, level, pos)) == null) continue;
            return container;
        }
        return null;
    }

    public static Predicate<BlockState> getModContainerPredicate() {
        return ModCompat::isValidModContainer;
    }
}

