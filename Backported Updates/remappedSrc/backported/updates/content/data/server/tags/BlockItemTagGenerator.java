/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$FabricTagBuilder
 *  net.minecraft.class_1792
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_3481
 *  net.minecraft.class_3489
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.data.tags.fabric.FabricBlockTags;
import backported.updates.content.core.data.tags.fabric.FabricItemTags;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_3481;
import net.minecraft.class_3489;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public abstract class BlockItemTagGenerator {
    protected void addTags() {
        this.handleConventionalTags();
        this.tag((class_6862<class_2248>)class_3481.field_15471, (class_6862<class_1792>)class_3489.field_15537).add(ModBlocks.PALE_OAK_PLANKS.get());
        this.tag((class_6862<class_2248>)class_3481.field_15499, (class_6862<class_1792>)class_3489.field_15555).add(ModBlocks.PALE_OAK_BUTTON.get());
        this.tag((class_6862<class_2248>)class_3481.field_15494, (class_6862<class_1792>)class_3489.field_15552).add(ModBlocks.PALE_OAK_DOOR.get());
        this.tag((class_6862<class_2248>)class_3481.field_15502, (class_6862<class_1792>)class_3489.field_15557).add(ModBlocks.PALE_OAK_STAIRS.get());
        this.tag((class_6862<class_2248>)class_3481.field_15468, (class_6862<class_1792>)class_3489.field_15534).add(ModBlocks.PALE_OAK_SLAB.get());
        this.tag((class_6862<class_2248>)class_3481.field_17619, (class_6862<class_1792>)class_3489.field_17620).add(ModBlocks.PALE_OAK_FENCE.get());
        this.tag((class_6862<class_2248>)class_3481.field_25147, (class_6862<class_1792>)class_3489.field_40858).add(ModBlocks.PALE_OAK_FENCE_GATE.get());
        this.tag((class_6862<class_2248>)class_3481.field_15477, (class_6862<class_1792>)class_3489.field_15540).add(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        this.tag((class_6862<class_2248>)class_3481.field_15462, (class_6862<class_1792>)class_3489.field_15528).add(ModBlocks.PALE_OAK_SAPLING.get());
        this.tag(ModBlockTags.PALE_OAK_LOGS, ModItemTags.PALE_OAK_LOGS).add(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        this.tag((class_6862<class_2248>)class_3481.field_23210, (class_6862<class_1792>)class_3489.field_23212).addTag(ModBlockTags.PALE_OAK_LOGS);
        this.tag((class_6862<class_2248>)class_3481.field_15469, (class_6862<class_1792>)class_3489.field_15535).add(ModBlocks.RESIN_BRICK_SLAB.get());
        this.tag((class_6862<class_2248>)class_3481.field_15504, (class_6862<class_1792>)class_3489.field_15560).add(ModBlocks.RESIN_BRICK_WALL.get());
        this.tag((class_6862<class_2248>)class_3481.field_15459, (class_6862<class_1792>)class_3489.field_15526).add(ModBlocks.RESIN_BRICK_STAIRS.get());
        this.tag((class_6862<class_2248>)class_3481.field_15503, (class_6862<class_1792>)class_3489.field_15558).add(ModBlocks.PALE_OAK_LEAVES.get());
        this.tag((class_6862<class_2248>)class_3481.field_15491, (class_6862<class_1792>)class_3489.field_15550).add(ModBlocks.PALE_OAK_TRAPDOOR.get());
        this.tag((class_6862<class_2248>)class_3481.field_15480, (class_6862<class_1792>)class_3489.field_15543).add(ModBlocks.OPEN_EYEBLOSSOM.get(), ModBlocks.CLOSED_EYEBLOSSOM.get());
        this.tag((class_6862<class_2248>)class_3481.field_20339, (class_6862<class_1792>)class_3489.field_20344).add(ModBlocks.WILDFLOWERS.get(), ModBlocks.CACTUS_FLOWER.get());
        this.tag((class_6862<class_2248>)class_3481.field_29822, (class_6862<class_1792>)class_3489.field_36269).add(ModBlocks.PALE_MOSS_BLOCK.get());
        this.tag((class_6862<class_2248>)class_3481.field_15472, (class_6862<class_1792>)class_3489.field_15533).add((class_2248)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get());
        this.tag((class_6862<class_2248>)class_3481.field_40103, (class_6862<class_1792>)class_3489.field_40108).add((class_2248)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get());
    }

    private void handleConventionalTags() {
        this.tag(FabricBlockTags.STRIPPED_LOGS, FabricItemTags.STRIPPED_LOGS).add(ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        this.tag(FabricBlockTags.STRIPPED_WOOD, FabricItemTags.STRIPPED_WOOD).add(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
    }

    protected abstract TagHolder tag(class_6862<class_2248> var1, class_6862<class_1792> var2);

    protected static class TagHolder {
        private final FabricTagProvider.FabricTagBuilder item;
        private final FabricTagProvider.FabricTagBuilder block;

        public TagHolder(FabricTagProvider.FabricTagBuilder item, FabricTagProvider.FabricTagBuilder block) {
            this.item = item;
            this.block = block;
        }

        public TagHolder add(class_2248 block) {
            if (this.item != null) {
                this.item.add((Object)block.method_8389());
            } else {
                this.block.add((Object)block);
            }
            return this;
        }

        public TagHolder add(class_2248 ... toAdd) {
            if (this.item != null) {
                for (class_2248 block : toAdd) {
                    this.item.add((Object)block.method_8389());
                }
            } else {
                this.block.add((Object[])toAdd);
            }
            return this;
        }

        private static class_6862<class_1792> blockTagToItemTag(class_6862<class_2248> tagKey) {
            return class_6862.method_40092((class_5321)class_7924.field_41197, (class_2960)tagKey.comp_327());
        }

        public TagHolder addOptional(class_2960 location) {
            if (this.item != null) {
                this.item.addOptional(location);
            } else {
                this.block.addOptional(location);
            }
            return this;
        }

        public TagHolder addTag(class_6862<class_2248> tag) {
            if (this.item != null) {
                this.item.addTag(TagHolder.blockTagToItemTag(tag));
            } else {
                this.block.addTag(tag);
            }
            return this;
        }

        public TagHolder addOptionalTag(class_6862<class_2248> tag) {
            if (this.item != null) {
                this.item.addOptionalTag(TagHolder.blockTagToItemTag(tag));
            } else {
                this.block.addOptionalTag(tag);
            }
            return this;
        }
    }
}

