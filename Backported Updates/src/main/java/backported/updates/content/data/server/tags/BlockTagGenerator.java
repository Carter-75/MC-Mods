/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$BlockTagProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$FabricTagBuilder
 *  net.minecraft.item.Item
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.data.server.tags.BlockItemTagGenerator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryWrapper;

public class BlockTagGenerator
extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider) {
        new BlockItemTagGenerator(){

            @Override
            protected BlockItemTagGenerator.TagHolder tag(TagKey<Block> block, TagKey<Item> item) {
                return new BlockItemTagGenerator.TagHolder(null, BlockTagGenerator.this.getOrCreateTagBuilder(block));
            }
        }.addTags();
        this.getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlocks.PALE_OAK_LOG.get());
        this.getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModBlocks.CACTUS_FLOWER.get());
        this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(new Block[]{ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), ModBlocks.POTTED_PALE_OAK_SAPLING.get()});
        this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(((Block)((Supplier)ModBlocks.PALE_OAK_SIGN.getSecond()).get()));
        this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(((Block)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getSecond()).get()));
        this.getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE).add(ModBlocks.CACTUS_FLOWER.get());
        this.getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(new Block[]{ModBlocks.WILDFLOWERS.get(), ModBlocks.LEAF_LITTER.get()});
        this.getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(new Block[]{ModBlocks.PALE_MOSS_CARPET.get(), ModBlocks.RESIN_CLUMP.get()});
        this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.CREAKING_HEART.get());
        this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(new Block[]{ModBlocks.PALE_OAK_LEAVES.get(), ModBlocks.PALE_MOSS_BLOCK.get(), ModBlocks.PALE_MOSS_CARPET.get()});
        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(new Block[]{ModBlocks.RESIN_BRICKS.get(), ModBlocks.RESIN_BRICK_SLAB.get(), ModBlocks.RESIN_BRICK_WALL.get(), ModBlocks.RESIN_BRICK_STAIRS.get(), ModBlocks.CHISELED_RESIN_BRICKS.get()});
        this.getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES).add(new Block[]{ModBlocks.PALE_MOSS_CARPET.get(), ModBlocks.BUSH.get(), ModBlocks.FIREFLY_BUSH.get(), ModBlocks.LEAF_LITTER.get(), ModBlocks.SHORT_DRY_GRASS.get(), ModBlocks.TALL_DRY_GRASS.get()});
        this.getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.PALE_MOSS_BLOCK.get());
        this.getOrCreateTagBuilder(ModBlockTags.HAPPY_GHAST_AVOIDS).add(new Block[]{Blocks.SWEET_BERRY_BUSH, Blocks.CACTUS, Blocks.WITHER_ROSE, Blocks.MAGMA_BLOCK, Blocks.FIRE, Blocks.POINTED_DRIPSTONE});
        this.getOrCreateTagBuilder(ModBlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS).add(new Block[]{Blocks.SAND, Blocks.RED_SAND});
        this.getOrCreateTagBuilder(ModBlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS).forceAddTag(BlockTags.TERRACOTTA).add(new Block[]{Blocks.SAND, Blocks.RED_SAND});
        this.getOrCreateTagBuilder(ModBlockTags.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS).add(new Block[]{Blocks.SOUL_SAND, Blocks.SOUL_SOIL});
        this.getOrCreateTagBuilder(ModBlockTags.SPAWN_FALLING_LEAVES).add(new Block[]{Blocks.OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.JUNGLE_LEAVES, Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES});
        this.getOrCreateTagBuilder(ModBlockTags.SPAWN_FALLING_NEEDLES).add(Blocks.SPRUCE_LEAVES);
        this.getOrCreateTagBuilder(ModBlockTags.ALLOWS_LEAF_LITTER).add(new Block[]{Blocks.OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.DARK_OAK_LEAVES});
        this.getOrCreateTagBuilder(ModBlockTags.CREAKING_HEART_HOLDERS).forceAddTag(ModBlockTags.PALE_OAK_LOGS);
        this.getOrCreateTagBuilder(ModBlockTags.CAMELS_SPAWNABLE_ON).forceAddTag(BlockTags.SAND);
    }

    protected DualTagHolder getDualTagBuilder(TagKey<Block> forge, TagKey<Block> fabric) {
        return new DualTagHolder(this.getOrCreateTagBuilder(fabric), this.getOrCreateTagBuilder(forge));
    }

    protected record DualTagHolder(FabricTagProvider.FabricTagBuilder forge, FabricTagProvider.FabricTagBuilder fabric) {
        public DualTagHolder add(Block entry) {
            this.forge.add(entry);
            this.fabric.add(entry);
            return this;
        }

        public DualTagHolder add(Block ... toAdd) {
            this.forge.add((Block[])toAdd);
            this.fabric.add((Block[])toAdd);
            return this;
        }

        public DualTagHolder addOptional(Identifier location) {
            this.forge.addOptional(location);
            this.fabric.addOptional(location);
            return this;
        }

        public DualTagHolder addTag(TagKey<Block> tag) {
            this.forge.addTag(tag);
            this.fabric.addTag(tag);
            return this;
        }

        public DualTagHolder addOptionalTag(TagKey<Block> tag) {
            this.forge.addOptionalTag(tag);
            this.fabric.addOptionalTag(tag);
            return this;
        }
    }
}

