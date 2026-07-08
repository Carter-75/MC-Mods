/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$BlockTagProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$FabricTagBuilder
 *  net.minecraft.class_1792
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_3481
 *  net.minecraft.class_6862
 *  net.minecraft.class_7225$class_7874
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.data.server.tags.BlockItemTagGenerator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_1792;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_3481;
import net.minecraft.class_6862;
import net.minecraft.class_7225;

public class BlockTagGenerator
extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void method_10514(class_7225.class_7874 provider) {
        new BlockItemTagGenerator(){

            @Override
            protected BlockItemTagGenerator.TagHolder tag(class_6862<class_2248> block, class_6862<class_1792> item) {
                return new BlockItemTagGenerator.TagHolder(null, BlockTagGenerator.this.getOrCreateTagBuilder(block));
            }
        }.addTags();
        this.getOrCreateTagBuilder(class_3481.field_39030).add((Object)ModBlocks.PALE_OAK_LOG.get());
        this.getOrCreateTagBuilder(class_3481.field_15460).add((Object)ModBlocks.CACTUS_FLOWER.get());
        this.getOrCreateTagBuilder(class_3481.field_15470).add((Object[])new class_2248[]{ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), ModBlocks.POTTED_PALE_OAK_SAPLING.get()});
        this.getOrCreateTagBuilder(class_3481.field_15492).add((Object)((class_2248)((Supplier)ModBlocks.PALE_OAK_SIGN.getSecond()).get()));
        this.getOrCreateTagBuilder(class_3481.field_40104).add((Object)((class_2248)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getSecond()).get()));
        this.getOrCreateTagBuilder(class_3481.field_22276).add((Object)ModBlocks.CACTUS_FLOWER.get());
        this.getOrCreateTagBuilder(class_3481.field_28040).add((Object[])new class_2248[]{ModBlocks.WILDFLOWERS.get(), ModBlocks.LEAF_LITTER.get()});
        this.getOrCreateTagBuilder(class_3481.field_43170).add((Object[])new class_2248[]{ModBlocks.PALE_MOSS_CARPET.get(), ModBlocks.RESIN_CLUMP.get()});
        this.getOrCreateTagBuilder(class_3481.field_33713).add((Object)ModBlocks.CREAKING_HEART.get());
        this.getOrCreateTagBuilder(class_3481.field_33714).add((Object[])new class_2248[]{ModBlocks.PALE_OAK_LEAVES.get(), ModBlocks.PALE_MOSS_BLOCK.get(), ModBlocks.PALE_MOSS_CARPET.get()});
        this.getOrCreateTagBuilder(class_3481.field_33715).add((Object[])new class_2248[]{ModBlocks.RESIN_BRICKS.get(), ModBlocks.RESIN_BRICK_SLAB.get(), ModBlocks.RESIN_BRICK_WALL.get(), ModBlocks.RESIN_BRICK_STAIRS.get(), ModBlocks.CHISELED_RESIN_BRICKS.get()});
        this.getOrCreateTagBuilder(class_3481.field_44470).add((Object[])new class_2248[]{ModBlocks.PALE_MOSS_CARPET.get(), ModBlocks.BUSH.get(), ModBlocks.FIREFLY_BUSH.get(), ModBlocks.LEAF_LITTER.get(), ModBlocks.SHORT_DRY_GRASS.get(), ModBlocks.TALL_DRY_GRASS.get()});
        this.getOrCreateTagBuilder(class_3481.field_42607).add((Object)ModBlocks.PALE_MOSS_BLOCK.get());
        this.getOrCreateTagBuilder(ModBlockTags.HAPPY_GHAST_AVOIDS).add((Object[])new class_2248[]{class_2246.field_16999, class_2246.field_10029, class_2246.field_10606, class_2246.field_10092, class_2246.field_10036, class_2246.field_28048});
        this.getOrCreateTagBuilder(ModBlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS).add((Object[])new class_2248[]{class_2246.field_10102, class_2246.field_10534});
        this.getOrCreateTagBuilder(ModBlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS).forceAddTag(class_3481.field_36265).add((Object[])new class_2248[]{class_2246.field_10102, class_2246.field_10534});
        this.getOrCreateTagBuilder(ModBlockTags.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS).add((Object[])new class_2248[]{class_2246.field_10114, class_2246.field_22090});
        this.getOrCreateTagBuilder(ModBlockTags.SPAWN_FALLING_LEAVES).add((Object[])new class_2248[]{class_2246.field_10503, class_2246.field_10539, class_2246.field_10335, class_2246.field_10098, class_2246.field_10035, class_2246.field_28673, class_2246.field_28674});
        this.getOrCreateTagBuilder(ModBlockTags.SPAWN_FALLING_NEEDLES).add((Object)class_2246.field_9988);
        this.getOrCreateTagBuilder(ModBlockTags.ALLOWS_LEAF_LITTER).add((Object[])new class_2248[]{class_2246.field_10503, class_2246.field_10539, class_2246.field_10035});
        this.getOrCreateTagBuilder(ModBlockTags.CREAKING_HEART_HOLDERS).forceAddTag(ModBlockTags.PALE_OAK_LOGS);
        this.getOrCreateTagBuilder(ModBlockTags.CAMELS_SPAWNABLE_ON).forceAddTag(class_3481.field_15466);
    }

    protected DualTagHolder getDualTagBuilder(class_6862<class_2248> forge, class_6862<class_2248> fabric) {
        return new DualTagHolder(this.getOrCreateTagBuilder(fabric), this.getOrCreateTagBuilder(forge));
    }

    protected record DualTagHolder(FabricTagProvider.FabricTagBuilder forge, FabricTagProvider.FabricTagBuilder fabric) {
        public DualTagHolder add(class_2248 entry) {
            this.forge.add((Object)entry);
            this.fabric.add((Object)entry);
            return this;
        }

        public DualTagHolder add(class_2248 ... toAdd) {
            this.forge.add((Object[])toAdd);
            this.fabric.add((Object[])toAdd);
            return this;
        }

        public DualTagHolder addOptional(class_2960 location) {
            this.forge.addOptional(location);
            this.fabric.addOptional(location);
            return this;
        }

        public DualTagHolder addTag(class_6862<class_2248> tag) {
            this.forge.addTag(tag);
            this.fabric.addTag(tag);
            return this;
        }

        public DualTagHolder addOptionalTag(class_6862<class_2248> tag) {
            this.forge.addOptionalTag(tag);
            this.fabric.addOptionalTag(tag);
            return this;
        }
    }
}

