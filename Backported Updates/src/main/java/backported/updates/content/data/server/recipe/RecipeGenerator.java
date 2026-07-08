/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
 *  net.minecraft.item.Items
 *  net.minecraft.recipe.Ingredient
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Blocks
 *  net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
 *  net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
 *  net.minecraft.data.server.recipe.CookingRecipeJsonBuilder
 *  net.minecraft.data.server.recipe.ComplexRecipeJsonBuilder
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.data.family.BlockFamily
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.resource.featuretoggle.FeatureFlag
 *  net.minecraft.resource.featuretoggle.FeatureSet
 *  net.minecraft.resource.featuretoggle.FeatureFlags
 *  net.minecraft.recipe.book.RecipeCategory
 *  net.minecraft.data.server.recipe.RecipeExporter
 */
package backported.updates.content.data.server.recipe;

import backported.updates.content.common.level.crafting.BundleColoring;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.data.client.BlockFamilies;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ComplexRecipeJsonBuilder;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.data.server.recipe.RecipeExporter;

public class RecipeGenerator
extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public void generate(RecipeExporter output) {
        BlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateRecipes).forEach(family -> RecipeGenerator.generateFamily((RecipeExporter)output, (BlockFamily)family, (FeatureSet)FeatureSet.of((FeatureFlag)FeatureFlags.VANILLA)));
        RecipeGenerator.offerPlanksRecipe2((RecipeExporter)output, (ItemConvertible)((ItemConvertible)ModBlocks.PALE_OAK_PLANKS.get()), ModItemTags.PALE_OAK_LOGS, (int)4);
        RecipeGenerator.offerBarkBlockRecipe((RecipeExporter)output, (ItemConvertible)((ItemConvertible)ModBlocks.PALE_OAK_WOOD.get()), (ItemConvertible)((ItemConvertible)ModBlocks.PALE_OAK_LOG.get()));
        RecipeGenerator.offerBarkBlockRecipe((RecipeExporter)output, (ItemConvertible)((ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_WOOD.get()), (ItemConvertible)((ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
        RecipeGenerator.offerBoatRecipe((RecipeExporter)output, (ItemConvertible)((ItemConvertible)ModItems.PALE_OAK_BOAT.get()), (ItemConvertible)((ItemConvertible)ModBlocks.PALE_OAK_PLANKS.get()));
        RecipeGenerator.offerChestBoatRecipe((RecipeExporter)output, (ItemConvertible)((ItemConvertible)ModItems.PALE_OAK_CHEST_BOAT.get()), (ItemConvertible)((ItemConvertible)ModItems.PALE_OAK_BOAT.get()));
        RecipeGenerator.offerHangingSignRecipe((RecipeExporter)output, (ItemConvertible)((ItemConvertible)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get()), (ItemConvertible)((ItemConvertible)ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
        RecipeGenerator.offerCarpetRecipe((RecipeExporter)output, (ItemConvertible)((ItemConvertible)ModBlocks.PALE_MOSS_CARPET.get()), (ItemConvertible)((ItemConvertible)ModBlocks.PALE_MOSS_BLOCK.get()));
        RecipeGenerator.offerSingleOutputShapelessRecipe((RecipeExporter)output, (ItemConvertible)Items.ORANGE_DYE, (ItemConvertible)((ItemConvertible)ModBlocks.OPEN_EYEBLOSSOM.get()), (String)"orange_dye");
        RecipeGenerator.offerSingleOutputShapelessRecipe((RecipeExporter)output, (ItemConvertible)Items.GRAY_DYE, (ItemConvertible)((ItemConvertible)ModBlocks.CLOSED_EYEBLOSSOM.get()), (String)"gray_dye");
        RecipeGenerator.offerSingleOutputShapelessRecipe((RecipeExporter)output, (ItemConvertible)Items.YELLOW_DYE, (ItemConvertible)((ItemConvertible)ModBlocks.WILDFLOWERS.get()), (String)"yellow_dye");
        RecipeGenerator.offer2x2CompactingRecipe((RecipeExporter)output, (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICKS.get()), (ItemConvertible)((ItemConvertible)ModItems.RESIN_BRICK.get()));
        RecipeGenerator.offerReversibleCompactingRecipes((RecipeExporter)output, (RecipeCategory)RecipeCategory.MISC, (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_CLUMP.get()), (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BLOCK.get()));
        RecipeGenerator.shaped(RecipeCategory.MISC, (ItemConvertible)ModBlocks.CREAKING_HEART.get()).input(Character.valueOf('R'), (ItemConvertible)ModBlocks.RESIN_BLOCK.get()).input(Character.valueOf('L'), (ItemConvertible)ModBlocks.PALE_OAK_LOG.get()).pattern(" L ").pattern(" R ").pattern(" L ").criterion("has_resin_block", RecipeGenerator.conditionsFromItem((ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BLOCK.get()))).offerTo(output);
        CookingRecipeJsonBuilder.createSmelting((Ingredient)Ingredient.ofItems((ItemConvertible[])new ItemConvertible[]{(ItemConvertible)ModBlocks.RESIN_CLUMP.get()}), (RecipeCategory)RecipeCategory.MISC, (ItemConvertible)((ItemConvertible)ModItems.RESIN_BRICK.get()), (float)0.1f, (int)200).criterion("has_resin_clump", RecipeGenerator.conditionsFromItem((ItemConvertible)((ItemConvertible)ModBlocks.RESIN_CLUMP.get()))).offerTo(output);
        RecipeGenerator.offerStonecuttingRecipe((RecipeExporter)output, (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICK_SLAB.get()), (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICKS.get()), (int)2);
        RecipeGenerator.offerStonecuttingRecipe((RecipeExporter)output, (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICK_STAIRS.get()), (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICKS.get()));
        RecipeGenerator.offerStonecuttingRecipe((RecipeExporter)output, (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICK_WALL.get()), (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICKS.get()));
        RecipeGenerator.offerStonecuttingRecipe((RecipeExporter)output, (RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)((ItemConvertible)ModBlocks.CHISELED_RESIN_BRICKS.get()), (ItemConvertible)((ItemConvertible)ModBlocks.RESIN_BRICKS.get()));
        this.dryGhast(output, (ItemConvertible)ModBlocks.DRIED_GHAST.get());
        this.harness(output, (ItemConvertible)ModItems.WHITE_HARNESS.get(), (ItemConvertible)Blocks.WHITE_WOOL);
        this.harness(output, (ItemConvertible)ModItems.ORANGE_HARNESS.get(), (ItemConvertible)Blocks.ORANGE_WOOL);
        this.harness(output, (ItemConvertible)ModItems.MAGENTA_HARNESS.get(), (ItemConvertible)Blocks.MAGENTA_WOOL);
        this.harness(output, (ItemConvertible)ModItems.LIGHT_BLUE_HARNESS.get(), (ItemConvertible)Blocks.LIGHT_BLUE_WOOL);
        this.harness(output, (ItemConvertible)ModItems.YELLOW_HARNESS.get(), (ItemConvertible)Blocks.YELLOW_WOOL);
        this.harness(output, (ItemConvertible)ModItems.LIME_HARNESS.get(), (ItemConvertible)Blocks.LIME_WOOL);
        this.harness(output, (ItemConvertible)ModItems.PINK_HARNESS.get(), (ItemConvertible)Blocks.PINK_WOOL);
        this.harness(output, (ItemConvertible)ModItems.GRAY_HARNESS.get(), (ItemConvertible)Blocks.GRAY_WOOL);
        this.harness(output, (ItemConvertible)ModItems.LIGHT_GRAY_HARNESS.get(), (ItemConvertible)Blocks.LIGHT_GRAY_WOOL);
        this.harness(output, (ItemConvertible)ModItems.CYAN_HARNESS.get(), (ItemConvertible)Blocks.CYAN_WOOL);
        this.harness(output, (ItemConvertible)ModItems.PURPLE_HARNESS.get(), (ItemConvertible)Blocks.PURPLE_WOOL);
        this.harness(output, (ItemConvertible)ModItems.BLUE_HARNESS.get(), (ItemConvertible)Blocks.BLUE_WOOL);
        this.harness(output, (ItemConvertible)ModItems.BROWN_HARNESS.get(), (ItemConvertible)Blocks.BROWN_WOOL);
        this.harness(output, (ItemConvertible)ModItems.GREEN_HARNESS.get(), (ItemConvertible)Blocks.GREEN_WOOL);
        this.harness(output, (ItemConvertible)ModItems.RED_HARNESS.get(), (ItemConvertible)Blocks.RED_WOOL);
        this.harness(output, (ItemConvertible)ModItems.BLACK_HARNESS.get(), (ItemConvertible)Blocks.BLACK_WOOL);
        RecipeGenerator.shaped(RecipeCategory.COMBAT, (ItemConvertible)Items.SADDLE).input(Character.valueOf('X'), (ItemConvertible)Items.LEATHER).input(Character.valueOf('#'), (ItemConvertible)Items.IRON_INGOT).pattern(" X ").pattern("X#X").criterion("has_leather", RecipeGenerator.conditionsFromItem((ItemConvertible)Items.LEATHER)).offerTo(output);
        RecipeGenerator.shaped(RecipeCategory.TOOLS, (ItemConvertible)Items.LEAD, 2).input(Character.valueOf('~'), (ItemConvertible)Items.STRING).pattern("~~ ").pattern("~~ ").pattern("  ~").criterion("has_string", RecipeGenerator.conditionsFromItem((ItemConvertible)Items.STRING)).offerTo(output);
        RecipeGenerator.offerSingleOutputShapelessRecipe((RecipeExporter)output, (ItemConvertible)Items.PINK_DYE, (ItemConvertible)((ItemConvertible)ModBlocks.CACTUS_FLOWER.get()), (String)"pink_dye");
        RecipeGenerator.shaped(RecipeCategory.DECORATIONS, (ItemConvertible)Blocks.LODESTONE).input(Character.valueOf('S'), (ItemConvertible)Items.CHISELED_STONE_BRICKS).input(Character.valueOf('#'), (ItemConvertible)Items.IRON_INGOT).pattern("SSS").pattern("S#S").pattern("SSS").criterion("has_iron_ingot", RecipeGenerator.conditionsFromItem((ItemConvertible)Items.IRON_INGOT)).criterion("has_lodestone", RecipeGenerator.conditionsFromItem((ItemConvertible)Items.LODESTONE)).offerTo(output);
        RecipeGenerator.shaped(RecipeCategory.TOOLS, (ItemConvertible)Items.BUNDLE).input(Character.valueOf('-'), (ItemConvertible)Items.STRING).input(Character.valueOf('#'), (ItemConvertible)Items.LEATHER).pattern("-").pattern("#").criterion("has_string", RecipeGenerator.conditionsFromItem((ItemConvertible)Items.STRING)).offerTo(output);
        ShapelessRecipeJsonBuilder.create((RecipeCategory)RecipeCategory.FOOD, (ItemConvertible)Items.PUMPKIN_PIE).input((ItemConvertible)Blocks.PUMPKIN).input((ItemConvertible)Items.SUGAR).input(ModItemTags.EGGS).criterion("has_carved_pumpkin", RecipeGenerator.conditionsFromItem((ItemConvertible)Blocks.CARVED_PUMPKIN)).criterion("has_pumpkin", RecipeGenerator.conditionsFromItem((ItemConvertible)Blocks.PUMPKIN)).offerTo(output);
        RecipeGenerator.shaped(RecipeCategory.FOOD, (ItemConvertible)Blocks.CAKE).input(Character.valueOf('A'), (ItemConvertible)Items.MILK_BUCKET).input(Character.valueOf('B'), (ItemConvertible)Items.SUGAR).input(Character.valueOf('C'), (ItemConvertible)Items.WHEAT).input(Character.valueOf('E'), ModItemTags.EGGS).pattern("AAA").pattern("BEB").pattern("CCC").criterion("has_egg", RecipeGenerator.conditionsFromTag(ModItemTags.EGGS)).offerTo(output);
        CookingRecipeJsonBuilder.createSmelting((Ingredient)Ingredient.fromTag((TagKey)ItemTags.LEAVES), (RecipeCategory)RecipeCategory.MISC, (ItemConvertible)((ItemConvertible)ModBlocks.LEAF_LITTER.get()), (float)0.1f, (int)200).criterion("has_leaves", RecipeGenerator.conditionsFromTag((TagKey)ItemTags.LEAVES)).offerTo(output);
        ComplexRecipeJsonBuilder.create(BundleColoring::new).offerTo(output, "bundle_coloring");
    }

    public static ShapedRecipeJsonBuilder shaped(RecipeCategory category, ItemConvertible entry) {
        return ShapedRecipeJsonBuilder.create((RecipeCategory)category, (ItemConvertible)entry);
    }

    public static ShapedRecipeJsonBuilder shaped(RecipeCategory category, ItemConvertible entry, int amount) {
        return ShapedRecipeJsonBuilder.create((RecipeCategory)category, (ItemConvertible)entry, (int)amount);
    }

    private void dryGhast(RecipeExporter output, ItemConvertible ghast) {
        ShapedRecipeJsonBuilder.create((RecipeCategory)RecipeCategory.BUILDING_BLOCKS, (ItemConvertible)ghast).input(Character.valueOf('#'), (ItemConvertible)Items.GHAST_TEAR).input(Character.valueOf('X'), (ItemConvertible)Items.SOUL_SAND).pattern("###").pattern("#X#").pattern("###").group("dry_ghast").criterion(RecipeGenerator.hasItem((ItemConvertible)Items.GHAST_TEAR), RecipeGenerator.conditionsFromItem((ItemConvertible)Items.GHAST_TEAR)).offerTo(output);
    }

    private void harness(RecipeExporter output, ItemConvertible harness, ItemConvertible carpet) {
        ShapedRecipeJsonBuilder.create((RecipeCategory)RecipeCategory.TRANSPORTATION, (ItemConvertible)harness).input(Character.valueOf('#'), carpet).input(Character.valueOf('G'), (ItemConvertible)Items.GLASS).input(Character.valueOf('L'), (ItemConvertible)Items.LEATHER).pattern("LLL").pattern("G#G").group("harness").criterion("has_dried_ghast", RecipeGenerator.conditionsFromItem((ItemConvertible)((ItemConvertible)ModBlocks.DRIED_GHAST.get()))).offerTo(output);
    }
}

