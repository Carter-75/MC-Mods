/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.minecraft.class_1738
 *  net.minecraft.class_1792
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_4910$class_4913
 *  net.minecraft.class_4946
 *  net.minecraft.class_5794
 */
package backported.updates.content.data.client;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.data.client.BlockFamilies;
import backported.updates.content.data.client.model.provider.VanillaBlockModels;
import backported.updates.content.data.client.model.provider.VanillaItemModels;
import backported.updates.content.data.client.model.provider.VanillaModelGenerator;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.class_1738;
import net.minecraft.class_1792;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_4910;
import net.minecraft.class_4946;
import net.minecraft.class_5794;

public class ModelGenerator
extends VanillaModelGenerator {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(VanillaBlockModels gen) {
        BlockFamilies.getAllFamilies().filter(class_5794::method_33477).forEach(family -> gen.method_25650(family.method_33469()).method_33522(family));
        gen.method_46190(ModBlocks.STRIPPED_PALE_OAK_LOG.get(), (class_2248)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get(), (class_2248)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getSecond()).get());
        gen.method_25641(ModBlocks.PALE_MOSS_BLOCK.get());
        gen.method_25622(ModBlocks.PALE_OAK_LEAVES.get(), class_4946.field_23049);
        gen.method_25676(ModBlocks.PALE_OAK_LOG.get()).method_25730(ModBlocks.PALE_OAK_LOG.get()).method_25728(ModBlocks.PALE_OAK_WOOD.get());
        gen.method_25676(ModBlocks.STRIPPED_PALE_OAK_LOG.get()).method_25730(ModBlocks.STRIPPED_PALE_OAK_LOG.get()).method_25728(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        gen.method_25545(ModBlocks.PALE_OAK_SAPLING.get(), ModBlocks.POTTED_PALE_OAK_SAPLING.get(), class_4910.class_4913.field_22840);
        gen.method_25545(ModBlocks.OPEN_EYEBLOSSOM.get(), ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), class_4910.class_4913.field_22840);
        gen.method_25545(ModBlocks.CLOSED_EYEBLOSSOM.get(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), class_4910.class_4913.field_22840);
        gen.createMossyCarpet(ModBlocks.PALE_MOSS_CARPET.get());
        gen.createHangingMoss(ModBlocks.PALE_HANGING_MOSS.get());
        gen.createCreakingHeart(ModBlocks.CREAKING_HEART.get());
        gen.createMultiface(ModBlocks.RESIN_CLUMP.get(), ModBlocks.RESIN_CLUMP.get().method_8389());
        gen.method_25641(ModBlocks.RESIN_BLOCK.get());
        gen.createSpawnEgg((class_1935)ModItems.CREAKING_SPAWN_EGG.get());
        gen.createDriedGhastBlock();
        gen.createSpawnEgg((class_1935)ModItems.HAPPY_GHAST_SPAWN_EGG.get());
        gen.method_25548(ModBlocks.BUSH.get(), class_4910.class_4913.field_22839);
        gen.method_25603(ModBlocks.FIREFLY_BUSH.get(), class_4910.class_4913.field_22840);
        gen.method_25537(ModBlocks.FIREFLY_BUSH.get().method_8389());
        gen.createLeafLitter(ModBlocks.LEAF_LITTER.get());
        gen.method_49378(ModBlocks.WILDFLOWERS.get());
        gen.method_25548(ModBlocks.CACTUS_FLOWER.get(), class_4910.class_4913.field_22840);
        gen.method_25548(ModBlocks.SHORT_DRY_GRASS.get(), class_4910.class_4913.field_22840);
        gen.method_25548(ModBlocks.TALL_DRY_GRASS.get(), class_4910.class_4913.field_22840);
    }

    @Override
    public void generateItemModels(VanillaItemModels gen) {
        gen.createFlatItem(ModItems.RESIN_BRICK.get());
        gen.createFlatItem(ModItems.PALE_OAK_BOAT.get());
        gen.createFlatItem(ModItems.PALE_OAK_CHEST_BOAT.get());
        gen.createFlatItem(ModItems.WHITE_HARNESS.get());
        gen.createFlatItem(ModItems.ORANGE_HARNESS.get());
        gen.createFlatItem(ModItems.MAGENTA_HARNESS.get());
        gen.createFlatItem(ModItems.LIGHT_BLUE_HARNESS.get());
        gen.createFlatItem(ModItems.YELLOW_HARNESS.get());
        gen.createFlatItem(ModItems.LIME_HARNESS.get());
        gen.createFlatItem(ModItems.PINK_HARNESS.get());
        gen.createFlatItem(ModItems.GRAY_HARNESS.get());
        gen.createFlatItem(ModItems.LIGHT_GRAY_HARNESS.get());
        gen.createFlatItem(ModItems.CYAN_HARNESS.get());
        gen.createFlatItem(ModItems.PURPLE_HARNESS.get());
        gen.createFlatItem(ModItems.BLUE_HARNESS.get());
        gen.createFlatItem(ModItems.BROWN_HARNESS.get());
        gen.createFlatItem(ModItems.GREEN_HARNESS.get());
        gen.createFlatItem(ModItems.RED_HARNESS.get());
        gen.createFlatItem(ModItems.BLACK_HARNESS.get());
        gen.createMusicDisc(ModItems.MUSIC_DISC_TEARS.get());
        gen.createMusicDisc(ModItems.MUSIC_DISC_LAVA_CHICKEN.get());
        gen.createFlatItem(ModItems.BLUE_EGG.get());
        gen.createFlatItem(ModItems.BROWN_EGG.get());
        ModItems.COPPER_NUGGET.ifPresent(item -> gen.createFlatItem((class_1792)item.get()));
        ModItems.COPPER_AXE.ifPresent(item -> gen.createHandheldItem((class_1792)item.get()));
        ModItems.COPPER_HOE.ifPresent(item -> gen.createHandheldItem((class_1792)item.get()));
        ModItems.COPPER_PICKAXE.ifPresent(item -> gen.createHandheldItem((class_1792)item.get()));
        ModItems.COPPER_SHOVEL.ifPresent(item -> gen.createHandheldItem((class_1792)item.get()));
        ModItems.COPPER_SWORD.ifPresent(item -> gen.createHandheldItem((class_1792)item.get()));
        ModItems.COPPER_HELMET.ifPresent(item -> gen.method_48523((class_1738)item.get()));
        ModItems.COPPER_CHESTPLATE.ifPresent(item -> gen.method_48523((class_1738)item.get()));
        ModItems.COPPER_LEGGINGS.ifPresent(item -> gen.method_48523((class_1738)item.get()));
        ModItems.COPPER_BOOTS.ifPresent(item -> gen.method_48523((class_1738)item.get()));
        ModItems.COPPER_HORSE_ARMOR.ifPresent(item -> gen.createFlatItem((class_1792)item.get()));
    }
}

