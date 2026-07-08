/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.resource.featuretoggle.FeatureFlags
 *  net.minecraft.item.ItemGroups
 */
package backported.updates.content.client;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.foundation.common.CreativeTabs;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.item.ItemGroups;

public interface CreativeTabIntegration {
    public static final CreativeTabs.Modifier BUILDING_BLOCKS = (flag, output, operator) -> {
        output.addAllAfter((ItemConvertible)Items.CHERRY_BUTTON, List.of((ItemConvertible)ModBlocks.PALE_OAK_LOG.get(), (ItemConvertible)ModBlocks.PALE_OAK_WOOD.get(), (ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_LOG.get(), (ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), (ItemConvertible)ModBlocks.PALE_OAK_PLANKS.get(), (ItemConvertible)ModBlocks.PALE_OAK_STAIRS.get(), (ItemConvertible)ModBlocks.PALE_OAK_SLAB.get(), (ItemConvertible)ModBlocks.PALE_OAK_FENCE.get(), (ItemConvertible)ModBlocks.PALE_OAK_FENCE_GATE.get(), (ItemConvertible)ModBlocks.PALE_OAK_DOOR.get(), (ItemConvertible)ModBlocks.PALE_OAK_TRAPDOOR.get(), (ItemConvertible)ModBlocks.PALE_OAK_PRESSURE_PLATE.get(), (ItemConvertible)ModBlocks.PALE_OAK_BUTTON.get()));
        output.addAllAfter((ItemConvertible)Items.MUD_BRICK_WALL, List.of((ItemConvertible)ModBlocks.RESIN_BRICKS.get(), (ItemConvertible)ModBlocks.RESIN_BRICK_STAIRS.get(), (ItemConvertible)ModBlocks.RESIN_BRICK_SLAB.get(), (ItemConvertible)ModBlocks.RESIN_BRICK_WALL.get(), (ItemConvertible)ModBlocks.CHISELED_RESIN_BRICKS.get()));
    };
    public static final CreativeTabs.Modifier COLORED_BLOCKS = (flag, output, operator) -> {};
    public static final CreativeTabs.Modifier NATURAL_BLOCKS = (flag, output, operator) -> {
        output.addAllAfter((ItemConvertible)Items.MOSS_CARPET, List.of((ItemConvertible)ModBlocks.PALE_MOSS_BLOCK.get(), (ItemConvertible)ModBlocks.PALE_MOSS_CARPET.get(), (ItemConvertible)ModBlocks.PALE_HANGING_MOSS.get()));
        output.addAfter((ItemConvertible)Items.CHERRY_LOG, (ItemConvertible)ModBlocks.PALE_OAK_LOG.get());
        output.addAfter((ItemConvertible)Items.CHERRY_LEAVES, (ItemConvertible)ModBlocks.PALE_OAK_LEAVES.get());
        output.addAfter((ItemConvertible)Items.CHERRY_SAPLING, (ItemConvertible)ModBlocks.PALE_OAK_SAPLING.get());
        output.addAllAfter((ItemConvertible)Items.FERN, List.of((ItemConvertible)ModBlocks.SHORT_DRY_GRASS.get(), (ItemConvertible)ModBlocks.BUSH.get()));
        output.addAllAfter((ItemConvertible)Items.TORCHFLOWER, List.of((ItemConvertible)ModBlocks.CACTUS_FLOWER.get(), (ItemConvertible)ModBlocks.CLOSED_EYEBLOSSOM.get(), (ItemConvertible)ModBlocks.OPEN_EYEBLOSSOM.get()));
        output.addAllAfter((ItemConvertible)Items.PINK_PETALS, List.of((ItemConvertible)ModBlocks.WILDFLOWERS.get(), (ItemConvertible)ModBlocks.LEAF_LITTER.get()));
        output.addAfter((ItemConvertible)Items.SPORE_BLOSSOM, (ItemConvertible)ModBlocks.FIREFLY_BUSH.get());
        output.addAfter((ItemConvertible)Items.LARGE_FERN, (ItemConvertible)ModBlocks.TALL_DRY_GRASS.get());
        output.addAfter((ItemConvertible)Items.SNIFFER_EGG, (ItemConvertible)ModBlocks.DRIED_GHAST.get());
        output.addAfter((ItemConvertible)Items.HONEY_BLOCK, (ItemConvertible)ModBlocks.RESIN_BLOCK.get());
    };
    public static final CreativeTabs.Modifier FUNCTIONAL_BLOCKS = (flag, output, operator) -> output.addAllAfter((ItemConvertible)Items.CHERRY_HANGING_SIGN, List.of((ItemConvertible)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get(), (ItemConvertible)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get()));
    public static final CreativeTabs.Modifier REDSTONE_BLOCKS = (flag, output, operator) -> {};
    public static final CreativeTabs.Modifier TOOLS_AND_UTILITIES = (flag, output, operator) -> {
        if (flag.contains(FeatureFlags.BUNDLE)) {
            output.addAllAfter((ItemConvertible)Items.BUNDLE, List.of((ItemConvertible)ModItems.WHITE_BUNDLE.get(), (ItemConvertible)ModItems.LIGHT_GRAY_BUNDLE.get(), (ItemConvertible)ModItems.GRAY_BUNDLE.get(), (ItemConvertible)ModItems.BLACK_BUNDLE.get(), (ItemConvertible)ModItems.BROWN_BUNDLE.get(), (ItemConvertible)ModItems.RED_BUNDLE.get(), (ItemConvertible)ModItems.ORANGE_BUNDLE.get(), (ItemConvertible)ModItems.YELLOW_BUNDLE.get(), (ItemConvertible)ModItems.LIME_BUNDLE.get(), (ItemConvertible)ModItems.GREEN_BUNDLE.get(), (ItemConvertible)ModItems.CYAN_BUNDLE.get(), (ItemConvertible)ModItems.LIGHT_BLUE_BUNDLE.get(), (ItemConvertible)ModItems.BLUE_BUNDLE.get(), (ItemConvertible)ModItems.PURPLE_BUNDLE.get(), (ItemConvertible)ModItems.MAGENTA_BUNDLE.get(), (ItemConvertible)ModItems.PINK_BUNDLE.get()));
        }
        output.addAllAfter((ItemConvertible)Items.SADDLE, List.of((ItemConvertible)ModItems.WHITE_HARNESS.get(), (ItemConvertible)ModItems.LIGHT_GRAY_HARNESS.get(), (ItemConvertible)ModItems.GRAY_HARNESS.get(), (ItemConvertible)ModItems.BLACK_HARNESS.get(), (ItemConvertible)ModItems.BROWN_HARNESS.get(), (ItemConvertible)ModItems.RED_HARNESS.get(), (ItemConvertible)ModItems.ORANGE_HARNESS.get(), (ItemConvertible)ModItems.YELLOW_HARNESS.get(), (ItemConvertible)ModItems.LIME_HARNESS.get(), (ItemConvertible)ModItems.GREEN_HARNESS.get(), (ItemConvertible)ModItems.CYAN_HARNESS.get(), (ItemConvertible)ModItems.LIGHT_BLUE_HARNESS.get(), (ItemConvertible)ModItems.BLUE_HARNESS.get(), (ItemConvertible)ModItems.PURPLE_HARNESS.get(), (ItemConvertible)ModItems.MAGENTA_HARNESS.get(), (ItemConvertible)ModItems.PINK_HARNESS.get()));
        output.addAllAfter((ItemConvertible)Items.CHERRY_CHEST_BOAT, List.of((ItemConvertible)ModItems.PALE_OAK_BOAT.get(), (ItemConvertible)ModItems.PALE_OAK_CHEST_BOAT.get()));
        output.addAllAfter((ItemConvertible)Items.MUSIC_DISC_RELIC, List.of((ItemConvertible)ModItems.MUSIC_DISC_TEARS.get(), (ItemConvertible)ModItems.MUSIC_DISC_LAVA_CHICKEN.get()));
    };
    public static final CreativeTabs.Modifier COMBAT = (flag, output, operator) -> output.addAllAfter((ItemConvertible)Items.EGG, List.of((ItemConvertible)ModItems.BROWN_EGG.get(), (ItemConvertible)ModItems.BLUE_EGG.get()));
    public static final CreativeTabs.Modifier FOOD_AND_DRINKS = (flag, output, operator) -> {};
    public static final CreativeTabs.Modifier INGREDIENTS = (flag, output, operator) -> {
        output.addAllAfter((ItemConvertible)Items.EGG, List.of((ItemConvertible)ModItems.BROWN_EGG.get(), (ItemConvertible)ModItems.BLUE_EGG.get()));
        output.addAfter((ItemConvertible)Items.HONEYCOMB, (ItemConvertible)ModBlocks.RESIN_CLUMP.get());
        output.addAfter((ItemConvertible)Items.NETHER_BRICK, (ItemConvertible)ModItems.RESIN_BRICK.get());
    };
    public static final CreativeTabs.Modifier SPAWN_EGGS = (flag, output, operator) -> {
        output.addAfter((ItemConvertible)Items.SPAWNER, (ItemConvertible)ModBlocks.CREAKING_HEART.get());
        output.addAfter((ItemConvertible)Items.COW_SPAWN_EGG, (ItemConvertible)ModItems.CREAKING_SPAWN_EGG.get());
        output.addAfter((ItemConvertible)Items.GUARDIAN_SPAWN_EGG, (ItemConvertible)ModItems.HAPPY_GHAST_SPAWN_EGG.get());
    };

    public static void bootstrap() {
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.COLORED_BLOCKS, COLORED_BLOCKS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.NATURAL, NATURAL_BLOCKS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.FUNCTIONAL, FUNCTIONAL_BLOCKS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.REDSTONE, REDSTONE_BLOCKS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.TOOLS, TOOLS_AND_UTILITIES);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.COMBAT, COMBAT);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.FOOD_AND_DRINK, FOOD_AND_DRINKS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.INGREDIENTS, INGREDIENTS);
        CreativeTabs.modify((RegistryKey<ItemGroup>)ItemGroups.SPAWN_EGGS, SPAWN_EGGS);
    }
}

