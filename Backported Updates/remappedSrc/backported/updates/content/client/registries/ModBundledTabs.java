/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.MapEncoder
 *  net.minecraft.class_1534
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2509
 *  net.minecraft.class_2561
 *  net.minecraft.class_6903
 *  net.minecraft.class_7924
 *  net.minecraft.class_9279
 *  net.minecraft.class_9334
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
import net.minecraft.class_1534;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2509;
import net.minecraft.class_2561;
import net.minecraft.class_6903;
import net.minecraft.class_7924;
import net.minecraft.class_9279;
import net.minecraft.class_9334;

public class ModBundledTabs {
    private static final Map<BundledTabs, FeatureFlag> FILTERS = new LinkedHashMap<BundledTabs, FeatureFlag>();
    public static final BundledTabs BUNDLES_OF_BRAVERY = ModBundledTabs.register(BundledTabs.builder().title((class_2561)class_2561.method_43471((String)"bundled_tab.bundles_of_bravery.title")).icon(new class_1799((class_1935)class_1802.field_27023)).displayItems((provider, output) -> {
        output.accept((class_1935)class_1802.field_27023);
        output.accept((class_1935)ModItems.WHITE_BUNDLE.get());
        output.accept((class_1935)ModItems.LIGHT_GRAY_BUNDLE.get());
        output.accept((class_1935)ModItems.GRAY_BUNDLE.get());
        output.accept((class_1935)ModItems.BLACK_BUNDLE.get());
        output.accept((class_1935)ModItems.BROWN_BUNDLE.get());
        output.accept((class_1935)ModItems.RED_BUNDLE.get());
        output.accept((class_1935)ModItems.ORANGE_BUNDLE.get());
        output.accept((class_1935)ModItems.YELLOW_BUNDLE.get());
        output.accept((class_1935)ModItems.LIME_BUNDLE.get());
        output.accept((class_1935)ModItems.GREEN_BUNDLE.get());
        output.accept((class_1935)ModItems.CYAN_BUNDLE.get());
        output.accept((class_1935)ModItems.LIGHT_BLUE_BUNDLE.get());
        output.accept((class_1935)ModItems.BLUE_BUNDLE.get());
        output.accept((class_1935)ModItems.PURPLE_BUNDLE.get());
        output.accept((class_1935)ModItems.MAGENTA_BUNDLE.get());
        output.accept((class_1935)ModItems.PINK_BUNDLE.get());
    }).build());
    public static final BundledTabs THE_GARDEN_AWAKENS = ModBundledTabs.register(BundledTabs.builder().title((class_2561)class_2561.method_43471((String)"bundled_tab.the_garden_awakens.title")).icon(new class_1799((class_1935)ModBlocks.OPEN_EYEBLOSSOM.get())).displayItems((provider, output) -> {
        output.accept((class_1935)ModBlocks.CREAKING_HEART.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_LOG.get());
        output.accept((class_1935)ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_WOOD.get());
        output.accept((class_1935)ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_PLANKS.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_STAIRS.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_SLAB.get());
        output.accept((class_1935)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get());
        output.accept((class_1935)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get());
        output.accept((class_1935)ModBlocks.PALE_OAK_BUTTON.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_DOOR.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_FENCE.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_FENCE_GATE.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_TRAPDOOR.get());
        output.accept((class_1935)ModItems.PALE_OAK_BOAT.get());
        output.accept((class_1935)ModItems.PALE_OAK_CHEST_BOAT.get());
        output.accept((class_1935)ModBlocks.PALE_HANGING_MOSS.get());
        output.accept((class_1935)ModBlocks.PALE_MOSS_BLOCK.get());
        output.accept((class_1935)ModBlocks.PALE_MOSS_CARPET.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_LEAVES.get());
        output.accept((class_1935)ModBlocks.PALE_OAK_SAPLING.get());
        output.accept((class_1935)ModItems.CREAKING_SPAWN_EGG.get());
        output.accept((class_1935)ModBlocks.CLOSED_EYEBLOSSOM.get());
        output.accept((class_1935)ModBlocks.OPEN_EYEBLOSSOM.get());
        output.accept((class_1935)ModBlocks.RESIN_BLOCK.get());
        output.accept((class_1935)ModBlocks.RESIN_BRICKS.get());
        output.accept((class_1935)ModBlocks.CHISELED_RESIN_BRICKS.get());
        output.accept((class_1935)ModBlocks.RESIN_BRICK_STAIRS.get());
        output.accept((class_1935)ModBlocks.RESIN_BRICK_SLAB.get());
        output.accept((class_1935)ModBlocks.RESIN_BRICK_WALL.get());
        output.accept((class_1935)ModBlocks.RESIN_CLUMP.get());
        output.accept((class_1935)ModItems.RESIN_BRICK.get());
    }).build());
    public static final BundledTabs SPRING_TO_LIFE = ModBundledTabs.register(BundledTabs.builder().title((class_2561)class_2561.method_43471((String)"bundled_tab.spring_to_life.title")).icon(new class_1799((class_1935)ModBlocks.WILDFLOWERS.get())).displayItems((provider, output) -> {
        output.accept((class_1935)ModBlocks.BUSH.get());
        output.accept((class_1935)ModBlocks.FIREFLY_BUSH.get());
        output.accept((class_1935)ModBlocks.WILDFLOWERS.get());
        output.accept((class_1935)ModBlocks.LEAF_LITTER.get());
        output.accept((class_1935)ModBlocks.CACTUS_FLOWER.get());
        output.accept((class_1935)ModBlocks.SHORT_DRY_GRASS.get());
        output.accept((class_1935)ModBlocks.TALL_DRY_GRASS.get());
        output.accept((class_1935)ModItems.BROWN_EGG.get());
        output.accept((class_1935)ModItems.BLUE_EGG.get());
    }).build());
    public static final BundledTabs CHASE_THE_SKIES = ModBundledTabs.register(BundledTabs.builder().title((class_2561)class_2561.method_43471((String)"bundled_tab.chase_the_skies.title")).icon(new class_1799((class_1935)ModItems.BLUE_HARNESS.get())).displayItems((provider, output) -> {
        output.accept((class_1935)ModBlocks.DRIED_GHAST.get());
        output.accept((class_1935)ModItems.HAPPY_GHAST_SPAWN_EGG.get());
        output.accept((class_1935)ModItems.WHITE_HARNESS.get());
        output.accept((class_1935)ModItems.ORANGE_HARNESS.get());
        output.accept((class_1935)ModItems.MAGENTA_HARNESS.get());
        output.accept((class_1935)ModItems.LIGHT_BLUE_HARNESS.get());
        output.accept((class_1935)ModItems.YELLOW_HARNESS.get());
        output.accept((class_1935)ModItems.LIME_HARNESS.get());
        output.accept((class_1935)ModItems.PINK_HARNESS.get());
        output.accept((class_1935)ModItems.GRAY_HARNESS.get());
        output.accept((class_1935)ModItems.LIGHT_GRAY_HARNESS.get());
        output.accept((class_1935)ModItems.CYAN_HARNESS.get());
        output.accept((class_1935)ModItems.PURPLE_HARNESS.get());
        output.accept((class_1935)ModItems.BLUE_HARNESS.get());
        output.accept((class_1935)ModItems.BROWN_HARNESS.get());
        output.accept((class_1935)ModItems.GREEN_HARNESS.get());
        output.accept((class_1935)ModItems.RED_HARNESS.get());
        output.accept((class_1935)ModItems.BLACK_HARNESS.get());
        output.accept((class_1935)ModItems.MUSIC_DISC_TEARS.get());
    }).build());
    public static final BundledTabs HOT_AS_LAVA = ModBundledTabs.register(BundledTabs.builder().title((class_2561)class_2561.method_43471((String)"bundled_tab.hot_as_lava.title")).icon(new class_1799((class_1935)ModItems.MUSIC_DISC_LAVA_CHICKEN.get())).displayItems((provider, output) -> {
        output.accept((class_1935)ModItems.MUSIC_DISC_LAVA_CHICKEN.get());
        provider.method_46759(class_7924.field_41209).ifPresent(variants -> variants.method_42017().filter(holder -> holder.method_40225(ModPaintingVariants.DENNIS)).forEach(reference -> {
            class_6903 ops = provider.method_57093((DynamicOps)class_2509.field_11560);
            class_9279 customData = ((class_9279)class_9279.field_49302.method_57447((DynamicOps)ops, (MapEncoder)class_1534.field_49238, reference).getOrThrow()).method_57451(tag -> tag.method_10582("id", "minecraft:painting"));
            class_1799 stack = new class_1799((class_1935)class_1802.field_8892);
            stack.method_57379(class_9334.field_49609, (Object)customData);
            output.accept(stack);
        }));
    }).build());
    public static final BundledTabs COPPER_AGE = ModBundledTabs.register(BundledTabs.builder().title((class_2561)class_2561.method_43471((String)"bundled_tab.copper_age.title")).icon(new class_1799((class_1935)class_1802.field_27022)).displayItems((provider, output) -> {
        output.accept((class_1935)ModItems.COPPER_SWORD.get().get());
        output.accept((class_1935)ModItems.COPPER_AXE.get().get());
        output.accept((class_1935)ModItems.COPPER_PICKAXE.get().get());
        output.accept((class_1935)ModItems.COPPER_SHOVEL.get().get());
        output.accept((class_1935)ModItems.COPPER_HOE.get().get());
        output.accept((class_1935)ModItems.COPPER_HELMET.get().get());
        output.accept((class_1935)ModItems.COPPER_CHESTPLATE.get().get());
        output.accept((class_1935)ModItems.COPPER_LEGGINGS.get().get());
        output.accept((class_1935)ModItems.COPPER_BOOTS.get().get());
        output.accept((class_1935)ModItems.COPPER_HORSE_ARMOR.get().get());
        output.accept((class_1935)ModItems.COPPER_NUGGET.get().get());
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

