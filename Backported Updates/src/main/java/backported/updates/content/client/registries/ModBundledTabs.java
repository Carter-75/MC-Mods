/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.MapEncoder
 *  net.minecraft.entity.decoration.painting.PaintingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.nbt.NbtOps
 *  net.minecraft.text.Text
 *  net.minecraft.registry.RegistryOps
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.component.type.NbtComponent
 *  net.minecraft.component.DataComponentTypes
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.api.tabs.BundledTabs;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.common.registries.ModPaintingVariants;
import backported.updates.content.core.FeatureFlag;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.nbt.NbtOps;
import net.minecraft.text.Text;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.component.DataComponentTypes;

public class ModBundledTabs {
    private static final Map<BundledTabs, FeatureFlag> FILTERS = new LinkedHashMap<BundledTabs, FeatureFlag>();
    public static final BundledTabs BUNDLES_OF_BRAVERY = ModBundledTabs.register(BundledTabs.builder().title((Text)Text.translatable((String)"bundled_tab.bundles_of_bravery.title")).icon(new ItemStack((ItemConvertible)Items.BUNDLE)).displayItems((provider, output) -> {
        output.accept((ItemConvertible)Items.BUNDLE);
        output.accept((ItemConvertible)ModItems.WHITE_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.LIGHT_GRAY_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.GRAY_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.BLACK_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.BROWN_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.RED_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.ORANGE_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.YELLOW_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.LIME_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.GREEN_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.CYAN_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.LIGHT_BLUE_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.BLUE_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.PURPLE_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.MAGENTA_BUNDLE.get());
        output.accept((ItemConvertible)ModItems.PINK_BUNDLE.get());
    }).build());
    public static final BundledTabs THE_GARDEN_AWAKENS = ModBundledTabs.register(BundledTabs.builder().title((Text)Text.translatable((String)"bundled_tab.the_garden_awakens.title")).icon(new ItemStack((ItemConvertible)ModBlocks.OPEN_EYEBLOSSOM.get())).displayItems((provider, output) -> {
        output.accept((ItemConvertible)ModBlocks.CREAKING_HEART.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_LOG.get());
        output.accept((ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_WOOD.get());
        output.accept((ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_PLANKS.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_STAIRS.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_SLAB.get());
        output.accept((ItemConvertible)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get());
        output.accept((ItemConvertible)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_BUTTON.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_DOOR.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_FENCE.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_FENCE_GATE.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_TRAPDOOR.get());
        output.accept((ItemConvertible)ModItems.PALE_OAK_BOAT.get());
        output.accept((ItemConvertible)ModItems.PALE_OAK_CHEST_BOAT.get());
        output.accept((ItemConvertible)ModBlocks.PALE_HANGING_MOSS.get());
        output.accept((ItemConvertible)ModBlocks.PALE_MOSS_BLOCK.get());
        output.accept((ItemConvertible)ModBlocks.PALE_MOSS_CARPET.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_LEAVES.get());
        output.accept((ItemConvertible)ModBlocks.PALE_OAK_SAPLING.get());
        output.accept((ItemConvertible)ModItems.CREAKING_SPAWN_EGG.get());
        output.accept((ItemConvertible)ModBlocks.CLOSED_EYEBLOSSOM.get());
        output.accept((ItemConvertible)ModBlocks.OPEN_EYEBLOSSOM.get());
        output.accept((ItemConvertible)ModBlocks.RESIN_BLOCK.get());
        output.accept((ItemConvertible)ModBlocks.RESIN_BRICKS.get());
        output.accept((ItemConvertible)ModBlocks.CHISELED_RESIN_BRICKS.get());
        output.accept((ItemConvertible)ModBlocks.RESIN_BRICK_STAIRS.get());
        output.accept((ItemConvertible)ModBlocks.RESIN_BRICK_SLAB.get());
        output.accept((ItemConvertible)ModBlocks.RESIN_BRICK_WALL.get());
        output.accept((ItemConvertible)ModBlocks.RESIN_CLUMP.get());
        output.accept((ItemConvertible)ModItems.RESIN_BRICK.get());
    }).build());
    public static final BundledTabs SPRING_TO_LIFE = ModBundledTabs.register(BundledTabs.builder().title((Text)Text.translatable((String)"bundled_tab.spring_to_life.title")).icon(new ItemStack((ItemConvertible)ModBlocks.WILDFLOWERS.get())).displayItems((provider, output) -> {
        output.accept((ItemConvertible)ModBlocks.BUSH.get());
        output.accept((ItemConvertible)ModBlocks.FIREFLY_BUSH.get());
        output.accept((ItemConvertible)ModBlocks.WILDFLOWERS.get());
        output.accept((ItemConvertible)ModBlocks.LEAF_LITTER.get());
        output.accept((ItemConvertible)ModBlocks.CACTUS_FLOWER.get());
        output.accept((ItemConvertible)ModBlocks.SHORT_DRY_GRASS.get());
        output.accept((ItemConvertible)ModBlocks.TALL_DRY_GRASS.get());
        output.accept((ItemConvertible)ModItems.BROWN_EGG.get());
        output.accept((ItemConvertible)ModItems.BLUE_EGG.get());
    }).build());
    public static final BundledTabs CHASE_THE_SKIES = ModBundledTabs.register(BundledTabs.builder().title((Text)Text.translatable((String)"bundled_tab.chase_the_skies.title")).icon(new ItemStack((ItemConvertible)ModItems.BLUE_HARNESS.get())).displayItems((provider, output) -> {
        output.accept((ItemConvertible)ModBlocks.DRIED_GHAST.get());
        output.accept((ItemConvertible)ModItems.HAPPY_GHAST_SPAWN_EGG.get());
        output.accept((ItemConvertible)ModItems.WHITE_HARNESS.get());
        output.accept((ItemConvertible)ModItems.ORANGE_HARNESS.get());
        output.accept((ItemConvertible)ModItems.MAGENTA_HARNESS.get());
        output.accept((ItemConvertible)ModItems.LIGHT_BLUE_HARNESS.get());
        output.accept((ItemConvertible)ModItems.YELLOW_HARNESS.get());
        output.accept((ItemConvertible)ModItems.LIME_HARNESS.get());
        output.accept((ItemConvertible)ModItems.PINK_HARNESS.get());
        output.accept((ItemConvertible)ModItems.GRAY_HARNESS.get());
        output.accept((ItemConvertible)ModItems.LIGHT_GRAY_HARNESS.get());
        output.accept((ItemConvertible)ModItems.CYAN_HARNESS.get());
        output.accept((ItemConvertible)ModItems.PURPLE_HARNESS.get());
        output.accept((ItemConvertible)ModItems.BLUE_HARNESS.get());
        output.accept((ItemConvertible)ModItems.BROWN_HARNESS.get());
        output.accept((ItemConvertible)ModItems.GREEN_HARNESS.get());
        output.accept((ItemConvertible)ModItems.RED_HARNESS.get());
        output.accept((ItemConvertible)ModItems.BLACK_HARNESS.get());
        output.accept((ItemConvertible)ModItems.MUSIC_DISC_TEARS.get());
    }).build());
    public static final BundledTabs HOT_AS_LAVA = ModBundledTabs.register(BundledTabs.builder().title((Text)Text.translatable((String)"bundled_tab.hot_as_lava.title")).icon(new ItemStack((ItemConvertible)ModItems.MUSIC_DISC_LAVA_CHICKEN.get())).displayItems((provider, output) -> {
        output.accept((ItemConvertible)ModItems.MUSIC_DISC_LAVA_CHICKEN.get());
        provider.getOptionalWrapper(RegistryKeys.PAINTING_VARIANT).ifPresent(variants -> variants.streamEntries().filter(holder -> holder.matchesKey(ModPaintingVariants.DENNIS)).forEach(reference -> {
            RegistryOps ops = provider.getOps((DynamicOps)NbtOps.INSTANCE);
            NbtComponent customData = ((NbtComponent)NbtComponent.DEFAULT.with((DynamicOps)ops, (MapEncoder)PaintingEntity.VARIANT_MAP_CODEC, reference).getOrThrow()).apply(tag -> tag.putString("id", "minecraft:painting"));
            ItemStack stack = new ItemStack((ItemConvertible)Items.PAINTING);
            stack.set(DataComponentTypes.ENTITY_DATA, customData);
            output.accept(stack);
        }));
    }).build());
    public static final BundledTabs COPPER_AGE = ModBundledTabs.register(BundledTabs.builder().title((Text)Text.translatable((String)"bundled_tab.copper_age.title")).icon(new ItemStack((ItemConvertible)Items.COPPER_INGOT)).displayItems((provider, output) -> {
        output.accept((ItemConvertible)ModItems.COPPER_SWORD.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_AXE.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_PICKAXE.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_SHOVEL.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_HOE.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_HELMET.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_CHESTPLATE.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_LEGGINGS.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_BOOTS.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_HORSE_ARMOR.get().get());
        output.accept((ItemConvertible)ModItems.COPPER_NUGGET.get().get());
    }).build(), FeatureFlag.COPPER_AGE);

    public static BundledTabs register(BundledTabs builder) {
        FILTERS.put(builder, FeatureFlag.DEFAULT);
        return builder;
    }

    public static BundledTabs register(BundledTabs builder, FeatureFlag flag) {
        FILTERS.put(builder, flag);
        return builder;
    }

    public static List<BundledTabs> getTabs() {
        return FILTERS.entrySet().stream().filter(entry -> ((FeatureFlag)entry.getValue()).isEnabled()).map(Map.Entry::getKey).toList();
    }
}

