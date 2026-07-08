/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1761
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_5321
 *  net.minecraft.class_7701
 *  net.minecraft.class_7706
 */
package backported.updates.content.client;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.foundation.common.CreativeTabs;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_1761;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_5321;
import net.minecraft.class_7701;
import net.minecraft.class_7706;

public interface CreativeTabIntegration {
    public static final CreativeTabs.Modifier BUILDING_BLOCKS = (flag, output, operator) -> {
        output.addAllAfter((class_1935)class_1802.field_42701, List.of((class_1935)ModBlocks.PALE_OAK_LOG.get(), (class_1935)ModBlocks.PALE_OAK_WOOD.get(), (class_1935)ModBlocks.STRIPPED_PALE_OAK_LOG.get(), (class_1935)ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), (class_1935)ModBlocks.PALE_OAK_PLANKS.get(), (class_1935)ModBlocks.PALE_OAK_STAIRS.get(), (class_1935)ModBlocks.PALE_OAK_SLAB.get(), (class_1935)ModBlocks.PALE_OAK_FENCE.get(), (class_1935)ModBlocks.PALE_OAK_FENCE_GATE.get(), (class_1935)ModBlocks.PALE_OAK_DOOR.get(), (class_1935)ModBlocks.PALE_OAK_TRAPDOOR.get(), (class_1935)ModBlocks.PALE_OAK_PRESSURE_PLATE.get(), (class_1935)ModBlocks.PALE_OAK_BUTTON.get()));
        output.addAllAfter((class_1935)class_1802.field_37521, List.of((class_1935)ModBlocks.RESIN_BRICKS.get(), (class_1935)ModBlocks.RESIN_BRICK_STAIRS.get(), (class_1935)ModBlocks.RESIN_BRICK_SLAB.get(), (class_1935)ModBlocks.RESIN_BRICK_WALL.get(), (class_1935)ModBlocks.CHISELED_RESIN_BRICKS.get()));
    };
    public static final CreativeTabs.Modifier COLORED_BLOCKS = (flag, output, operator) -> {};
    public static final CreativeTabs.Modifier NATURAL_BLOCKS = (flag, output, operator) -> {
        output.addAllAfter((class_1935)class_1802.field_28653, List.of((class_1935)ModBlocks.PALE_MOSS_BLOCK.get(), (class_1935)ModBlocks.PALE_MOSS_CARPET.get(), (class_1935)ModBlocks.PALE_HANGING_MOSS.get()));
        output.addAfter((class_1935)class_1802.field_42692, (class_1935)ModBlocks.PALE_OAK_LOG.get());
        output.addAfter((class_1935)class_1802.field_42694, (class_1935)ModBlocks.PALE_OAK_LEAVES.get());
        output.addAfter((class_1935)class_1802.field_42688, (class_1935)ModBlocks.PALE_OAK_SAPLING.get());
        output.addAllAfter((class_1935)class_1802.field_8471, List.of((class_1935)ModBlocks.SHORT_DRY_GRASS.get(), (class_1935)ModBlocks.BUSH.get()));
        output.addAllAfter((class_1935)class_1802.field_42695, List.of((class_1935)ModBlocks.CACTUS_FLOWER.get(), (class_1935)ModBlocks.CLOSED_EYEBLOSSOM.get(), (class_1935)ModBlocks.OPEN_EYEBLOSSOM.get()));
        output.addAllAfter((class_1935)class_1802.field_42696, List.of((class_1935)ModBlocks.WILDFLOWERS.get(), (class_1935)ModBlocks.LEAF_LITTER.get()));
        output.addAfter((class_1935)class_1802.field_28652, (class_1935)ModBlocks.FIREFLY_BUSH.get());
        output.addAfter((class_1935)class_1802.field_8561, (class_1935)ModBlocks.TALL_DRY_GRASS.get());
        output.addAfter((class_1935)class_1802.field_43193, (class_1935)ModBlocks.DRIED_GHAST.get());
        output.addAfter((class_1935)class_1802.field_21086, (class_1935)ModBlocks.RESIN_BLOCK.get());
    };
    public static final CreativeTabs.Modifier FUNCTIONAL_BLOCKS = (flag, output, operator) -> output.addAllAfter((class_1935)class_1802.field_42708, List.of((class_1935)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get(), (class_1935)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get()));
    public static final CreativeTabs.Modifier REDSTONE_BLOCKS = (flag, output, operator) -> {};
    public static final CreativeTabs.Modifier TOOLS_AND_UTILITIES = (flag, output, operator) -> {
        if (flag.method_45403(class_7701.field_40178)) {
            output.addAllAfter((class_1935)class_1802.field_27023, List.of((class_1935)ModItems.WHITE_BUNDLE.get(), (class_1935)ModItems.LIGHT_GRAY_BUNDLE.get(), (class_1935)ModItems.GRAY_BUNDLE.get(), (class_1935)ModItems.BLACK_BUNDLE.get(), (class_1935)ModItems.BROWN_BUNDLE.get(), (class_1935)ModItems.RED_BUNDLE.get(), (class_1935)ModItems.ORANGE_BUNDLE.get(), (class_1935)ModItems.YELLOW_BUNDLE.get(), (class_1935)ModItems.LIME_BUNDLE.get(), (class_1935)ModItems.GREEN_BUNDLE.get(), (class_1935)ModItems.CYAN_BUNDLE.get(), (class_1935)ModItems.LIGHT_BLUE_BUNDLE.get(), (class_1935)ModItems.BLUE_BUNDLE.get(), (class_1935)ModItems.PURPLE_BUNDLE.get(), (class_1935)ModItems.MAGENTA_BUNDLE.get(), (class_1935)ModItems.PINK_BUNDLE.get()));
        }
        output.addAllAfter((class_1935)class_1802.field_8175, List.of((class_1935)ModItems.WHITE_HARNESS.get(), (class_1935)ModItems.LIGHT_GRAY_HARNESS.get(), (class_1935)ModItems.GRAY_HARNESS.get(), (class_1935)ModItems.BLACK_HARNESS.get(), (class_1935)ModItems.BROWN_HARNESS.get(), (class_1935)ModItems.RED_HARNESS.get(), (class_1935)ModItems.ORANGE_HARNESS.get(), (class_1935)ModItems.YELLOW_HARNESS.get(), (class_1935)ModItems.LIME_HARNESS.get(), (class_1935)ModItems.GREEN_HARNESS.get(), (class_1935)ModItems.CYAN_HARNESS.get(), (class_1935)ModItems.LIGHT_BLUE_HARNESS.get(), (class_1935)ModItems.BLUE_HARNESS.get(), (class_1935)ModItems.PURPLE_HARNESS.get(), (class_1935)ModItems.MAGENTA_HARNESS.get(), (class_1935)ModItems.PINK_HARNESS.get()));
        output.addAllAfter((class_1935)class_1802.field_42707, List.of((class_1935)ModItems.PALE_OAK_BOAT.get(), (class_1935)ModItems.PALE_OAK_CHEST_BOAT.get()));
        output.addAllAfter((class_1935)class_1802.field_44705, List.of((class_1935)ModItems.MUSIC_DISC_TEARS.get(), (class_1935)ModItems.MUSIC_DISC_LAVA_CHICKEN.get()));
    };
    public static final CreativeTabs.Modifier COMBAT = (flag, output, operator) -> output.addAllAfter((class_1935)class_1802.field_8803, List.of((class_1935)ModItems.BROWN_EGG.get(), (class_1935)ModItems.BLUE_EGG.get()));
    public static final CreativeTabs.Modifier FOOD_AND_DRINKS = (flag, output, operator) -> {};
    public static final CreativeTabs.Modifier INGREDIENTS = (flag, output, operator) -> {
        output.addAllAfter((class_1935)class_1802.field_8803, List.of((class_1935)ModItems.BROWN_EGG.get(), (class_1935)ModItems.BLUE_EGG.get()));
        output.addAfter((class_1935)class_1802.field_20414, (class_1935)ModBlocks.RESIN_CLUMP.get());
        output.addAfter((class_1935)class_1802.field_8729, (class_1935)ModItems.RESIN_BRICK.get());
    };
    public static final CreativeTabs.Modifier SPAWN_EGGS = (flag, output, operator) -> {
        output.addAfter((class_1935)class_1802.field_8849, (class_1935)ModBlocks.CREAKING_HEART.get());
        output.addAfter((class_1935)class_1802.field_8433, (class_1935)ModItems.CREAKING_SPAWN_EGG.get());
        output.addAfter((class_1935)class_1802.field_8409, (class_1935)ModItems.HAPPY_GHAST_SPAWN_EGG.get());
    };

    public static void bootstrap() {
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_40195, BUILDING_BLOCKS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_41059, COLORED_BLOCKS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_40743, NATURAL_BLOCKS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_40197, FUNCTIONAL_BLOCKS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_40198, REDSTONE_BLOCKS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_41060, TOOLS_AND_UTILITIES);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_40202, COMBAT);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_41061, FOOD_AND_DRINKS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_41062, INGREDIENTS);
        CreativeTabs.modify((class_5321<class_1761>)class_7706.field_40205, SPAWN_EGGS);
    }
}

