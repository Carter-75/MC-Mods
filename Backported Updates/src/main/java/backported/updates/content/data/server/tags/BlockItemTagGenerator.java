/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$FabricTagBuilder
 *  net.minecraft.item.Item
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.data.tags.fabric.FabricBlockTags;
import backported.updates.content.core.data.tags.fabric.FabricItemTags;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public abstract class BlockItemTagGenerator {
    protected void addTags() {
        this.handleConventionalTags();
        this.tag((TagKey<Block>)BlockTags.PLANKS, (TagKey<Item>)ItemTags.PLANKS).add(ModBlocks.PALE_OAK_PLANKS.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_BUTTONS, (TagKey<Item>)ItemTags.WOODEN_BUTTONS).add(ModBlocks.PALE_OAK_BUTTON.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_DOORS, (TagKey<Item>)ItemTags.WOODEN_DOORS).add(ModBlocks.PALE_OAK_DOOR.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_STAIRS, (TagKey<Item>)ItemTags.WOODEN_STAIRS).add(ModBlocks.PALE_OAK_STAIRS.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_SLABS, (TagKey<Item>)ItemTags.WOODEN_SLABS).add(ModBlocks.PALE_OAK_SLAB.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_FENCES, (TagKey<Item>)ItemTags.WOODEN_FENCES).add(ModBlocks.PALE_OAK_FENCE.get());
        this.tag((TagKey<Block>)BlockTags.FENCE_GATES, (TagKey<Item>)ItemTags.FENCE_GATES).add(ModBlocks.PALE_OAK_FENCE_GATE.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_PRESSURE_PLATES, (TagKey<Item>)ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        this.tag((TagKey<Block>)BlockTags.SAPLINGS, (TagKey<Item>)ItemTags.SAPLINGS).add(ModBlocks.PALE_OAK_SAPLING.get());
        this.tag(ModBlockTags.PALE_OAK_LOGS, ModItemTags.PALE_OAK_LOGS).add(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        this.tag((TagKey<Block>)BlockTags.LOGS_THAT_BURN, (TagKey<Item>)ItemTags.LOGS_THAT_BURN).addTag(ModBlockTags.PALE_OAK_LOGS);
        this.tag((TagKey<Block>)BlockTags.SLABS, (TagKey<Item>)ItemTags.SLABS).add(ModBlocks.RESIN_BRICK_SLAB.get());
        this.tag((TagKey<Block>)BlockTags.WALLS, (TagKey<Item>)ItemTags.WALLS).add(ModBlocks.RESIN_BRICK_WALL.get());
        this.tag((TagKey<Block>)BlockTags.STAIRS, (TagKey<Item>)ItemTags.STAIRS).add(ModBlocks.RESIN_BRICK_STAIRS.get());
        this.tag((TagKey<Block>)BlockTags.LEAVES, (TagKey<Item>)ItemTags.LEAVES).add(ModBlocks.PALE_OAK_LEAVES.get());
        this.tag((TagKey<Block>)BlockTags.WOODEN_TRAPDOORS, (TagKey<Item>)ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.PALE_OAK_TRAPDOOR.get());
        this.tag((TagKey<Block>)BlockTags.SMALL_FLOWERS, (TagKey<Item>)ItemTags.SMALL_FLOWERS).add(ModBlocks.OPEN_EYEBLOSSOM.get(), ModBlocks.CLOSED_EYEBLOSSOM.get());
        this.tag((TagKey<Block>)BlockTags.FLOWERS, (TagKey<Item>)ItemTags.FLOWERS).add(ModBlocks.WILDFLOWERS.get(), ModBlocks.CACTUS_FLOWER.get());
        this.tag((TagKey<Block>)BlockTags.DIRT, (TagKey<Item>)ItemTags.DIRT).add(ModBlocks.PALE_MOSS_BLOCK.get());
        this.tag((TagKey<Block>)BlockTags.STANDING_SIGNS, (TagKey<Item>)ItemTags.SIGNS).add((Block)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get());
        this.tag((TagKey<Block>)BlockTags.CEILING_HANGING_SIGNS, (TagKey<Item>)ItemTags.HANGING_SIGNS).add((Block)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get());
    }

    private void handleConventionalTags() {
        this.tag(FabricBlockTags.STRIPPED_LOGS, FabricItemTags.STRIPPED_LOGS).add(ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        this.tag(FabricBlockTags.STRIPPED_WOOD, FabricItemTags.STRIPPED_WOOD).add(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
    }

    protected abstract TagHolder tag(TagKey<Block> var1, TagKey<Item> var2);

    protected static class TagHolder {
        private final FabricTagProvider.FabricTagBuilder item;
        private final FabricTagProvider.FabricTagBuilder block;

        public TagHolder(FabricTagProvider.FabricTagBuilder item, FabricTagProvider.FabricTagBuilder block) {
            this.item = item;
            this.block = block;
        }

        public TagHolder add(Block block) {
            if (this.item != null) {
                this.item.add(block.asItem());
            } else {
                this.block.add(block);
            }
            return this;
        }

        public TagHolder add(Block ... toAdd) {
            if (this.item != null) {
                for (Block block : toAdd) {
                    this.item.add(block.asItem());
                }
            } else {
                this.block.add((Block[])toAdd);
            }
            return this;
        }

        private static TagKey<Item> blockTagToItemTag(TagKey<Block> tagKey) {
            return TagKey.of(RegistryKeys.ITEM, tagKey.id());
        }

        public TagHolder addOptional(Identifier location) {
            if (this.item != null) {
                this.item.addOptional(location);
            } else {
                this.block.addOptional(location);
            }
            return this;
        }

        public TagHolder addTag(TagKey<Block> tag) {
            if (this.item != null) {
                this.item.addTag(TagHolder.blockTagToItemTag(tag));
            } else {
                this.block.addTag(tag);
            }
            return this;
        }

        public TagHolder addOptionalTag(TagKey<Block> tag) {
            if (this.item != null) {
                this.item.addOptionalTag(TagHolder.blockTagToItemTag(tag));
            } else {
                this.block.addOptionalTag(tag);
            }
            return this;
        }
    }
}

