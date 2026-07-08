/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$FabricTagBuilder
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$ItemTagProvider
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_3489
 *  net.minecraft.class_6862
 *  net.minecraft.class_7225$class_7874
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
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_3489;
import net.minecraft.class_6862;
import net.minecraft.class_7225;

public class ItemTagGenerator
extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void method_10514(class_7225.class_7874 provider) {
        new BlockItemTagGenerator(){

            @Override
            protected BlockItemTagGenerator.TagHolder tag(class_6862<class_2248> block, class_6862<class_1792> item) {
                return new BlockItemTagGenerator.TagHolder(ItemTagGenerator.this.getOrCreateTagBuilder(item), null);
            }
        }.addTags();
        this.handleConventionalTags();
        this.getOrCreateTagBuilder(class_3489.field_15536).add((Object)ModItems.PALE_OAK_BOAT.get());
        this.getOrCreateTagBuilder(class_3489.field_38080).add((Object)ModItems.PALE_OAK_CHEST_BOAT.get());
        this.getOrCreateTagBuilder(ModItemTags.BUNDLES).add((Object[])new class_1792[]{class_1802.field_27023, ModItems.BLACK_BUNDLE.get(), ModItems.BLUE_BUNDLE.get(), ModItems.BROWN_BUNDLE.get(), ModItems.CYAN_BUNDLE.get(), ModItems.GRAY_BUNDLE.get(), ModItems.GREEN_BUNDLE.get(), ModItems.LIGHT_BLUE_BUNDLE.get(), ModItems.LIGHT_GRAY_BUNDLE.get(), ModItems.LIME_BUNDLE.get(), ModItems.MAGENTA_BUNDLE.get(), ModItems.ORANGE_BUNDLE.get(), ModItems.PINK_BUNDLE.get(), ModItems.PURPLE_BUNDLE.get(), ModItems.RED_BUNDLE.get(), ModItems.YELLOW_BUNDLE.get(), ModItems.WHITE_BUNDLE.get()});
        this.getOrCreateTagBuilder(class_3489.field_41891).add((Object)ModItems.RESIN_BRICK.get());
        this.getOrCreateTagBuilder(ModItemTags.HARNESSES).add((Object[])new class_1792[]{ModItems.WHITE_HARNESS.get(), ModItems.ORANGE_HARNESS.get(), ModItems.MAGENTA_HARNESS.get(), ModItems.LIGHT_BLUE_HARNESS.get(), ModItems.YELLOW_HARNESS.get(), ModItems.LIME_HARNESS.get(), ModItems.PINK_HARNESS.get(), ModItems.GRAY_HARNESS.get(), ModItems.LIGHT_GRAY_HARNESS.get(), ModItems.CYAN_HARNESS.get(), ModItems.PURPLE_HARNESS.get(), ModItems.BLUE_HARNESS.get(), ModItems.BROWN_HARNESS.get(), ModItems.GREEN_HARNESS.get(), ModItems.RED_HARNESS.get(), ModItems.BLACK_HARNESS.get()});
        this.getOrCreateTagBuilder(ModItemTags.HAPPY_GHAST_FOOD).add((Object)class_1802.field_8543);
        this.getOrCreateTagBuilder(ModItemTags.HAPPY_GHAST_TEMPT_ITEMS).addTag(ModItemTags.HAPPY_GHAST_FOOD).addTag(ModItemTags.HARNESSES);
        this.getOrCreateTagBuilder(ModItemTags.EGGS).add((Object[])new class_1792[]{class_1802.field_8803, ModItems.BLUE_EGG.get(), ModItems.BROWN_EGG.get()});
    }

    private void handleConventionalTags() {
        this.getOrCreateTagBuilder(FabricItemTags.EGGS).addTag(ModItemTags.EGGS);
        this.getOrCreateTagBuilder(FabricItemTags.DYED).addTag(ModItemTags.HARNESSES).add((Object[])new class_1792[]{ModItems.BLACK_BUNDLE.get(), ModItems.BLUE_BUNDLE.get(), ModItems.BROWN_BUNDLE.get(), ModItems.CYAN_BUNDLE.get(), ModItems.GRAY_BUNDLE.get(), ModItems.GREEN_BUNDLE.get(), ModItems.LIGHT_BLUE_BUNDLE.get(), ModItems.LIGHT_GRAY_BUNDLE.get(), ModItems.LIME_BUNDLE.get(), ModItems.MAGENTA_BUNDLE.get(), ModItems.ORANGE_BUNDLE.get(), ModItems.PINK_BUNDLE.get(), ModItems.PURPLE_BUNDLE.get(), ModItems.RED_BUNDLE.get(), ModItems.YELLOW_BUNDLE.get(), ModItems.WHITE_BUNDLE.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_BLACK).add((Object[])new class_1792[]{ModItems.BLACK_BUNDLE.get(), ModItems.BLACK_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_BLUE).add((Object[])new class_1792[]{ModItems.BLUE_BUNDLE.get(), ModItems.BLUE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_BROWN).add((Object[])new class_1792[]{ModItems.BROWN_BUNDLE.get(), ModItems.BROWN_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_CYAN).add((Object[])new class_1792[]{ModItems.CYAN_BUNDLE.get(), ModItems.CYAN_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_GRAY).add((Object[])new class_1792[]{ModItems.GRAY_BUNDLE.get(), ModItems.GRAY_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_GREEN).add((Object[])new class_1792[]{ModItems.GREEN_BUNDLE.get(), ModItems.GREEN_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_LIGHT_BLUE).add((Object[])new class_1792[]{ModItems.LIGHT_BLUE_BUNDLE.get(), ModItems.LIGHT_BLUE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_LIGHT_GRAY).add((Object[])new class_1792[]{ModItems.LIGHT_GRAY_BUNDLE.get(), ModItems.LIGHT_GRAY_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_LIME).add((Object[])new class_1792[]{ModItems.LIME_BUNDLE.get(), ModItems.LIME_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_MAGENTA).add((Object[])new class_1792[]{ModItems.MAGENTA_BUNDLE.get(), ModItems.MAGENTA_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_ORANGE).add((Object[])new class_1792[]{ModItems.ORANGE_BUNDLE.get(), ModItems.ORANGE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_PINK).add((Object[])new class_1792[]{ModItems.PINK_BUNDLE.get(), ModItems.PINK_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_PURPLE).add((Object[])new class_1792[]{ModItems.PURPLE_BUNDLE.get(), ModItems.PURPLE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_RED).add((Object[])new class_1792[]{ModItems.RED_BUNDLE.get(), ModItems.RED_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_YELLOW).add((Object[])new class_1792[]{ModItems.YELLOW_BUNDLE.get(), ModItems.YELLOW_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.DYED_WHITE).add((Object[])new class_1792[]{ModItems.WHITE_BUNDLE.get(), ModItems.WHITE_HARNESS.get()});
        this.getOrCreateTagBuilder(FabricItemTags.MUSIC_DISCS).add((Object[])new class_1792[]{ModItems.MUSIC_DISC_TEARS.get(), ModItems.MUSIC_DISC_LAVA_CHICKEN.get()});
        this.getOrCreateTagBuilder(CreateItemTags.MODDED_STRIPPED_WOOD).add((Object)ModBlocks.STRIPPED_PALE_OAK_WOOD.get().method_8389());
        this.getOrCreateTagBuilder(CreateItemTags.MODDED_STRIPPED_LOGS).add((Object)ModBlocks.STRIPPED_PALE_OAK_LOG.get().method_8389());
    }

    protected DualTagHolder getDualTagBuilder(class_6862<class_1792> forge, class_6862<class_1792> fabric) {
        return new DualTagHolder(this.getOrCreateTagBuilder(fabric), this.getOrCreateTagBuilder(forge));
    }

    protected record DualTagHolder(FabricTagProvider.FabricTagBuilder forge, FabricTagProvider.FabricTagBuilder fabric) {
        public DualTagHolder add(class_1935 entry) {
            this.forge.add((Object)entry.method_8389());
            this.fabric.add((Object)entry.method_8389());
            return this;
        }

        public DualTagHolder add(class_1792 ... toAdd) {
            this.forge.add((Object[])toAdd);
            this.fabric.add((Object[])toAdd);
            return this;
        }

        public DualTagHolder addOptional(class_2960 location) {
            this.forge.addOptional(location);
            this.fabric.addOptional(location);
            return this;
        }

        public DualTagHolder addTag(class_6862<class_1792> tag) {
            this.forge.addTag(tag);
            this.fabric.addTag(tag);
            return this;
        }

        public DualTagHolder addOptionalTag(class_6862<class_1792> tag) {
            this.forge.addOptionalTag(tag);
            this.fabric.addOptionalTag(tag);
            return this;
        }
    }
}

