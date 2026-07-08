/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Sets
 *  com.mojang.serialization.Codec
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.util.math.GlobalPos
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModMemoryTypes {
    public static Supplier<MemoryModuleType<Integer>> TRANSPORT_ITEMS_COOLDOWN_TICKS;
    public static Supplier<MemoryModuleType<Set<GlobalPos>>> VISITED_BLOCK_POSITIONS;
    public static Supplier<MemoryModuleType<Set<GlobalPos>>> UNREACHABLE_TRANSPORT_BLOCK_POSITIONS;
    public static Supplier<MemoryModuleType<Integer>> GAZE_COOLDOWN_TICKS;
    public static Supplier<MemoryModuleType<Boolean>> IS_PRESSING_BUTTON;
    public static Supplier<MemoryModuleType<Long>> LAST_CONTAINER_EMPTY;

    public static void register() {
        Constants.LOG.info("Registering memory module types for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        RegistryKey<? extends Registry<? super MemoryModuleType<Integer>>> intKey = (RegistryKey<? extends Registry<? super MemoryModuleType<Integer>>>) (RegistryKey<?>) RegistryKeys.MEMORY_MODULE_TYPE;
        RegistryKey<? extends Registry<? super MemoryModuleType<Set<GlobalPos>>>> setKey = (RegistryKey<? extends Registry<? super MemoryModuleType<Set<GlobalPos>>>>) (RegistryKey<?>) RegistryKeys.MEMORY_MODULE_TYPE;
        RegistryKey<? extends Registry<? super MemoryModuleType<Boolean>>> boolKey = (RegistryKey<? extends Registry<? super MemoryModuleType<Boolean>>>) (RegistryKey<?>) RegistryKeys.MEMORY_MODULE_TYPE;
        RegistryKey<? extends Registry<? super MemoryModuleType<Long>>> longKey = (RegistryKey<? extends Registry<? super MemoryModuleType<Long>>>) (RegistryKey<?>) RegistryKeys.MEMORY_MODULE_TYPE;

        TRANSPORT_ITEMS_COOLDOWN_TICKS = helper.register(intKey, "transport_items_cooldown_ticks", () -> new MemoryModuleType<Integer>(Optional.of(Codec.INT)));
        VISITED_BLOCK_POSITIONS = helper.register(setKey, "visited_block_positions", () -> new MemoryModuleType<Set<GlobalPos>>(Optional.of(GlobalPos.CODEC.listOf().xmap(Sets::newHashSet, Lists::newArrayList))));
        UNREACHABLE_TRANSPORT_BLOCK_POSITIONS = helper.register(setKey, "unreachable_transport_block_positions", () -> new MemoryModuleType<Set<GlobalPos>>(Optional.of(GlobalPos.CODEC.listOf().xmap(Sets::newHashSet, Lists::newArrayList))));
        GAZE_COOLDOWN_TICKS = helper.register(intKey, "gaze_cooldown_ticks", () -> new MemoryModuleType<Integer>(Optional.of(Codec.INT)));
        IS_PRESSING_BUTTON = helper.register(boolKey, "is_pressing_button", () -> new MemoryModuleType<Boolean>(Optional.of(Codec.BOOL)));
        LAST_CONTAINER_EMPTY = helper.register(longKey, "last_container_empty", () -> new MemoryModuleType<Long>(Optional.of(Codec.LONG)));
    }
}

