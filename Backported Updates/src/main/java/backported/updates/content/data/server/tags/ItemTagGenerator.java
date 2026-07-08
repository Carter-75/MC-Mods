/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$FabricTagBuilder
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$ItemTagProvider
 *  net.minecraft.item.Item
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.data.tags.create.CreateItemTags;
import backported.updates.content.core.data.tags.fabric.FabricItemTags;
import backported.updates.content.data.server.tags.BlockItemTagGenerator;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryWrapper;

public class ItemTagGenerator
extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider) {
        new BlockItemTagGenerator(){

            @Override
            protected BlockItemTagGenerator.TagHolder tag(TagKey<Block> block, TagKey<Item> item) {
                return new BlockItemTagGenerator.TagHolder(ItemTagGenerator.this.getOrCreateTagBuilder(item), null);
            }
        }.addTags();
        this.handleConventionalTags();
        this.getOrCreateTagBuilder(ItemTags.BOATS).add(ModItems.PALE_OAK_BOAT.get());
        this.getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModItems.PALE_OAK_CHEST_BOAT.get());
        this.getOrCreateTagBuilder(ModItemTags.BUNDLES).add(new Item[]{Items.BUNDLE, ModItems.BLACK_BUNDLE.get(), ModItems.BLUE_BUNDLE.get(), ModItems.BROWN_BUNDLE.get(), ModItems.CYAN_BUNDLE.get(), ModItems.GRAY_BUNDLE.get(), ModItems.GREEN_BUNDLE.get(), ModItems.LIGHT_BLUE_BUNDLE.get(), ModItems.LIGHT_GRAY_BUNDLE.get(), ModItems.LIME_BUNDLE.get(), ModItems.MAGENTA_BUNDLE.get(), ModItems.ORANGE_BUNDLE.get(), ModItems.PINK_BUNDLE.get(), ModItems.PURPLE_BUNDLE.get(), ModItems.RED_BUNDLE.get(), ModItems.YELLOW_BUNDLE.get(), ModItems.WHITE_BUNDLE.get()});
        this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.RESIN_BRICK.get());
        this.getOrCreateTagBuilder(ModItemTags.HARNESSES).add(new Item[]{ModItems.WHITE_HARNESS.get(), ModItems.ORANGE_HARNESS.get(), ModItems.MAGENTA_HARNESS.get(), ModItems.LIGHT_BLUE_HARNESS.get(), ModItems.YELLOW_HARNESS.get(), ModItems.LIME_HARNESS.get(), ModItems.PINK_HARNESS.get(), ModItems.GRAY_HARNESS.get(), ModItems.LIGHT_GRAY_HARNESS.get(), ModItems.CYAN_HARNESS.get(), ModItems.PURPLE_HARNESS.get(), ModItems.BLUE_HARNESS.get(), ModItems.BROWN_HARNESS.get(), ModItems.GREEN_HARNESS.get(), ModItems.RED_HARNESS.get(), ModItems.BLACK_HARNESS.get()});
        this.getOrCreateTagBuilder(ModItemTags.HAPPY_GHAST_FOOD).add(Items.SNOWBALL);
        this.getOrCreateTagBuilder(ModItemTags.HAPPY_GHAST_TEMPT_ITEMS).addTag(ModItemTags.HAPPY_GHAST_FOOD).addTag(ModItemTags.HARNESSES);
        this.getOrCreateTagBuilder(ModItemTags.EGGS).add(new Item[]{Items.EGG, ModItems.BLUE_EGG.get(), ModItems.BROWN_EGG.get()});
    }

    private void handleConventionalTags() {
        this.getOrCreateTagBuilder(FabricItemTags.EGGS).addTag(ModItemTags.EGGS);
        this.getOrCreateTagBuilder(FabricItemTags.DYED).addTag(ModItemTags.HARNESSES).add(new Item[]{ModItems.BLACK_BUNDLE.get(), ModItems.BLUE_BUNDLE.get(), ModItems.BROWN_BUNDLE.get(), ModItems.CYAN_BUNDLE.get(), ModItems.GRAY_BUNDLE.get(), ModItems.GREEN_BUNDLE.get(), ModItems.LIGHT_BLUE_BUNDLE.get(), ModItems.LIGHT_GRAY_BUNDLE.get(), ModItems.LIME_BUNDLE.get(), ModItems.MAGENTA_BUNDLE.get(), ModItems.ORANGE_BUNDLE.get(), ModItems.PINK_BUNDLE.get(), ModItems.PURPLE_BUNDLE.get(), ModItems.RED_BUNDLE.get(), ModItems.YELLOW_BUNDLE.get(), ModItems.WHITE_BUNDLE.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_BLACK).add(new Item[]{ModItems.BLACK_BUNDLE.get(), ModItems.BLACK_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_BLUE).add(new Item[]{ModItems.BLUE_BUNDLE.get(), ModItems.BLUE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_BROWN).add(new Item[]{ModItems.BROWN_BUNDLE.get(), ModItems.BROWN_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_CYAN).add(new Item[]{ModItems.CYAN_BUNDLE.get(), ModItems.CYAN_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_GRAY).add(new Item[]{ModItems.GRAY_BUNDLE.get(), ModItems.GRAY_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_GREEN).add(new Item[]{ModItems.GREEN_BUNDLE.get(), ModItems.GREEN_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_LIGHT_BLUE).add(new Item[]{ModItems.LIGHT_BLUE_BUNDLE.get(), ModItems.LIGHT_BLUE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_LIGHT_GRAY).add(new Item[]{ModItems.LIGHT_GRAY_BUNDLE.get(), ModItems.LIGHT_GRAY_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_LIME).add(new Item[]{ModItems.LIME_BUNDLE.get(), ModItems.LIME_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_MAGENTA).add(new Item[]{ModItems.MAGENTA_BUNDLE.get(), ModItems.MAGENTA_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_ORANGE).add(new Item[]{ModItems.ORANGE_BUNDLE.get(), ModItems.ORANGE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_PINK).add(new Item[]{ModItems.PINK_BUNDLE.get(), ModItems.PINK_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_PURPLE).add(new Item[]{ModItems.PURPLE_BUNDLE.get(), ModItems.PURPLE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_RED).add(new Item[]{ModItems.RED_BUNDLE.get(), ModItems.RED_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_YELLOW).add(new Item[]{ModItems.YELLOW_BUNDLE.get(), ModItems.YELLOW_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_WHITE).add(new Item[]{ModItems.WHITE_BUNDLE.get(), ModItems.WHITE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.MUSIC_DISCS).add(new Item[]{ModItems.MUSIC_DISC_TEARS.get(), ModItems.MUSIC_DISC_LAVA_CHICKEN.get()});
        this.getOrCreateTagBuilder(CreateItemTags.MODDED_STRIPPED_WOOD).add(ModBlocks.STRIPPED_PALE_OAK_WOOD.get().asItem());
        this.getOrCreateTagBuilder(CreateItemTags.MODDED_STRIPPED_LOGS).add(ModBlocks.STRIPPED_PALE_OAK_LOG.get().asItem());
    }

    protected DualTagHolder getDualTagBuilder(TagKey<Item> forge, TagKey<Item> fabric) {
        return new DualTagHolder(this.getOrCreateTagBuilder(fabric), this.getOrCreateTagBuilder(forge));
    }

    protected record DualTagHolder(FabricTagProvider.FabricTagBuilder forge, FabricTagProvider.FabricTagBuilder fabric) {
        public DualTagHolder add(ItemConvertible entry) {
            this.forge.add(entry.asItem());
            this.fabric.add(entry.asItem());
            return this;
        }

        public DualTagHolder add(Item ... toAdd) {
            this.forge.add((Item[])toAdd);
            this.fabric.add((Item[])toAdd);
            return this;
        }

        public DualTagHolder addOptional(Identifier location) {
            this.forge.addOptional(location);
            this.fabric.addOptional(location);
            return this;
        }

        public DualTagHolder addTag(TagKey<Item> tag) {
            this.forge.addTag(tag);
            this.fabric.addTag(tag);
            return this;
        }

        public DualTagHolder addOptionalTag(TagKey<Item> tag) {
            this.forge.addOptionalTag(tag);
            this.fabric.addOptionalTag(tag);
            return this;
        }
    }
}

