/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Sets
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_4140
 *  net.minecraft.class_4208
 *  net.minecraft.class_7924
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
import net.minecraft.class_4140;
import net.minecraft.class_4208;
import net.minecraft.class_7924;

public class ModMemoryTypes {
    public static Supplier<class_4140<Integer>> TRANSPORT_ITEMS_COOLDOWN_TICKS;
    public static Supplier<class_4140<Set<class_4208>>> VISITED_BLOCK_POSITIONS;
    public static Supplier<class_4140<Set<class_4208>>> UNREACHABLE_TRANSPORT_BLOCK_POSITIONS;
    public static Supplier<class_4140<Integer>> GAZE_COOLDOWN_TICKS;
    public static Supplier<class_4140<Boolean>> IS_PRESSING_BUTTON;
    public static Supplier<class_4140<Long>> LAST_CONTAINER_EMPTY;

    public static void register() {
        Constants.LOG.info("Registering memory module types for {}", (Object)"Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        TRANSPORT_ITEMS_COOLDOWN_TICKS = helper.register(class_7924.field_41206, "transport_items_cooldown_ticks", () -> new class_4140(Optional.of(Codec.INT)));
        VISITED_BLOCK_POSITIONS = helper.register(class_7924.field_41206, "visited_block_positions", () -> new class_4140(Optional.of(class_4208.field_25066.listOf().xmap(Sets::newHashSet, Lists::newArrayList))));
        UNREACHABLE_TRANSPORT_BLOCK_POSITIONS = helper.register(class_7924.field_41206, "unreachable_transport_block_positions", () -> new class_4140(Optional.of(class_4208.field_25066.listOf().xmap(Sets::newHashSet, Lists::newArrayList))));
        GAZE_COOLDOWN_TICKS = helper.register(class_7924.field_41206, "gaze_cooldown_ticks", () -> new class_4140(Optional.of(Codec.INT)));
        IS_PRESSING_BUTTON = helper.register(class_7924.field_41206, "is_pressing_button", () -> new class_4140(Optional.of(Codec.BOOL)));
        LAST_CONTAINER_EMPTY = helper.register(class_7924.field_41206, "last_container_empty", () -> new class_4140(Optional.of(Codec.LONG)));
    }
}

