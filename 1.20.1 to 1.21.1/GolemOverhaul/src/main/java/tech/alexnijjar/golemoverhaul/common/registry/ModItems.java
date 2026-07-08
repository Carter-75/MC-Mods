/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1747
 *  net.minecraft.class_1761
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1826
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1747;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_1826;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.common.items.HoneyBlobItem;
import tech.alexnijjar.golemoverhaul.common.registry.ModBlocks;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.golemoverhaul.common.registry.fabric.ModItemsImpl;

public class ModItems {
    public static final ResourcefulRegistry<class_1792> ITEMS = ResourcefulRegistries.create((class_2378)class_7923.field_41178, (String)"golemoverhaul");
    public static final ResourcefulRegistry<class_1792> SPAWN_EGGS = ResourcefulRegistries.create(ITEMS);
    public static final Supplier<class_1761> TAB = new ResourcefulCreativeTab(GolemOverhaul.asResource("main")).setItemIcon(() -> (class_1935)CLAY_GOLEM_STATUE.get()).addRegistry(ITEMS).build();
    public static final RegistryEntry<class_1792> BARREL_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("barrel_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.BARREL_GOLEM, 11829060, 6306861, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> CANDLE_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("candle_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.CANDLE_GOLEM, 14994052, 9792074, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> COAL_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("coal_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.COAL_GOLEM, 16310118, 13924129, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> HAY_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("hay_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.HAY_GOLEM, 13471031, 14271347, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> HONEY_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("honey_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.HONEY_GOLEM, 15577155, 14389580, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> KELP_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("kelp_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.KELP_GOLEM, 5689526, 5538596, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> NETHERITE_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("netherite_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.NETHERITE_GOLEM, 3090473, 0x3B393B, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> SLIME_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("slime_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.SLIME_GOLEM, 14545250, 8436807, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> TERRACOTTA_GOLEM_SPAWN_EGG = SPAWN_EGGS.register("terracotta_golem_spawn_egg", () -> ModItems.createSpawnEgg(ModEntityTypes.TERRACOTTA_GOLEM, 11437879, 8870204, new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> CANDLE_GOLEM_BLOCK = ITEMS.register("candle_golem_block", () -> new class_1747((class_2248)ModBlocks.CANDLE_GOLEM_BLOCK.get(), new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> CLAY_GOLEM_STATUE = ITEMS.register("clay_golem_statue", () -> new class_1747((class_2248)ModBlocks.CLAY_GOLEM_STATUE.get(), new class_1792.class_1793()));
    public static final RegistryEntry<class_1792> HONEY_BLOB = ITEMS.register("honey_blob", () -> new HoneyBlobItem(new class_1792.class_1793()));

    /*
     * WARNING - void declaration
     */
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static class_1826 createSpawnEgg(Supplier<? extends class_1299<? extends class_1308>> type, int backgroundColor, int highlightColor, class_1792.class_1793 properties) {
        void var3_3;
        void var2_2;
        void var1_1;
        return ModItemsImpl.createSpawnEgg(type, (int)var1_1, (int)var2_2, (class_1792.class_1793)var3_3);
    }
}

