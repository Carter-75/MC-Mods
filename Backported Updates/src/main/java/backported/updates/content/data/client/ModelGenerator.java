/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.data.client.BlockStateModelGenerator$TintType
 *  net.minecraft.data.client.TexturedModel
 *  net.minecraft.data.family.BlockFamily
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
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.data.family.BlockFamily;

public class ModelGenerator
extends VanillaModelGenerator {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(VanillaBlockModels gen) {
        BlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModels).forEach(family -> gen.registerCubeAllModelTexturePool(family.getBaseBlock()).family(family));
        gen.registerHangingSign(ModBlocks.STRIPPED_PALE_OAK_LOG.get(), (Block)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get(), (Block)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getSecond()).get());
        gen.registerSimpleCubeAll(ModBlocks.PALE_MOSS_BLOCK.get());
        gen.registerSingleton(ModBlocks.PALE_OAK_LEAVES.get(), TexturedModel.LEAVES);
        gen.registerLog(ModBlocks.PALE_OAK_LOG.get()).log(ModBlocks.PALE_OAK_LOG.get()).wood(ModBlocks.PALE_OAK_WOOD.get());
        gen.registerLog(ModBlocks.STRIPPED_PALE_OAK_LOG.get()).log(ModBlocks.STRIPPED_PALE_OAK_LOG.get()).wood(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        gen.registerFlowerPotPlant(ModBlocks.PALE_OAK_SAPLING.get(), ModBlocks.POTTED_PALE_OAK_SAPLING.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerFlowerPotPlant(ModBlocks.OPEN_EYEBLOSSOM.get(), ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerFlowerPotPlant(ModBlocks.CLOSED_EYEBLOSSOM.get(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.createMossyCarpet(ModBlocks.PALE_MOSS_CARPET.get());
        gen.createHangingMoss(ModBlocks.PALE_HANGING_MOSS.get());
        gen.createCreakingHeart(ModBlocks.CREAKING_HEART.get());
        gen.createMultiface(ModBlocks.RESIN_CLUMP.get(), ModBlocks.RESIN_CLUMP.get().asItem());
        gen.registerSimpleCubeAll(ModBlocks.RESIN_BLOCK.get());
        gen.createSpawnEgg((ItemConvertible)ModItems.CREAKING_SPAWN_EGG.get());
        gen.createDriedGhastBlock();
        gen.createSpawnEgg((ItemConvertible)ModItems.HAPPY_GHAST_SPAWN_EGG.get());
        gen.registerTintableCross(ModBlocks.BUSH.get(), BlockStateModelGenerator.TintType.TINTED);
        gen.registerTintableCrossBlockState(ModBlocks.FIREFLY_BUSH.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerItemModel(ModBlocks.FIREFLY_BUSH.get().asItem());
        gen.createLeafLitter(ModBlocks.LEAF_LITTER.get());
        gen.registerFlowerbed(ModBlocks.WILDFLOWERS.get());
        gen.registerTintableCross(ModBlocks.CACTUS_FLOWER.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerTintableCross(ModBlocks.SHORT_DRY_GRASS.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerTintableCross(ModBlocks.TALL_DRY_GRASS.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
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
        ModItems.COPPER_NUGGET.ifPresent(item -> gen.createFlatItem((Item)item.get()));
        ModItems.COPPER_AXE.ifPresent(item -> gen.createHandheldItem((Item)item.get()));
        ModItems.COPPER_HOE.ifPresent(item -> gen.createHandheldItem((Item)item.get()));
        ModItems.COPPER_PICKAXE.ifPresent(item -> gen.createHandheldItem((Item)item.get()));
        ModItems.COPPER_SHOVEL.ifPresent(item -> gen.createHandheldItem((Item)item.get()));
        ModItems.COPPER_SWORD.ifPresent(item -> gen.createHandheldItem((Item)item.get()));
        ModItems.COPPER_HELMET.ifPresent(item -> gen.registerArmor((ArmorItem)item.get()));
        ModItems.COPPER_CHESTPLATE.ifPresent(item -> gen.registerArmor((ArmorItem)item.get()));
        ModItems.COPPER_LEGGINGS.ifPresent(item -> gen.registerArmor((ArmorItem)item.get()));
        ModItems.COPPER_BOOTS.ifPresent(item -> gen.registerArmor((ArmorItem)item.get()));
        ModItems.COPPER_HORSE_ARMOR.ifPresent(item -> gen.createFlatItem((Item)item.get()));
    }
}

