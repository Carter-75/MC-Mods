/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
 *  net.minecraft.class_1802
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2447
 *  net.minecraft.class_2450
 *  net.minecraft.class_2454
 *  net.minecraft.class_2456
 *  net.minecraft.class_3489
 *  net.minecraft.class_5794
 *  net.minecraft.class_6862
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7696
 *  net.minecraft.class_7699
 *  net.minecraft.class_7701
 *  net.minecraft.class_7800
 *  net.minecraft.class_8790
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
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2447;
import net.minecraft.class_2450;
import net.minecraft.class_2454;
import net.minecraft.class_2456;
import net.minecraft.class_3489;
import net.minecraft.class_5794;
import net.minecraft.class_6862;
import net.minecraft.class_7225;
import net.minecraft.class_7696;
import net.minecraft.class_7699;
import net.minecraft.class_7701;
import net.minecraft.class_7800;
import net.minecraft.class_8790;

public class RecipeGenerator
extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    public void method_10419(class_8790 output) {
        BlockFamilies.getAllFamilies().filter(class_5794::method_33478).forEach(family -> RecipeGenerator.method_33535((class_8790)output, (class_5794)family, (class_7699)class_7699.method_45398((class_7696)class_7701.field_40177)));
        RecipeGenerator.method_24475((class_8790)output, (class_1935)((class_1935)ModBlocks.PALE_OAK_PLANKS.get()), ModItemTags.PALE_OAK_LOGS, (int)4);
        RecipeGenerator.method_24476((class_8790)output, (class_1935)((class_1935)ModBlocks.PALE_OAK_WOOD.get()), (class_1935)((class_1935)ModBlocks.PALE_OAK_LOG.get()));
        RecipeGenerator.method_24476((class_8790)output, (class_1935)((class_1935)ModBlocks.STRIPPED_PALE_OAK_WOOD.get()), (class_1935)((class_1935)ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
        RecipeGenerator.method_24478((class_8790)output, (class_1935)((class_1935)ModItems.PALE_OAK_BOAT.get()), (class_1935)((class_1935)ModBlocks.PALE_OAK_PLANKS.get()));
        RecipeGenerator.method_42754((class_8790)output, (class_1935)((class_1935)ModItems.PALE_OAK_CHEST_BOAT.get()), (class_1935)((class_1935)ModItems.PALE_OAK_BOAT.get()));
        RecipeGenerator.method_46208((class_8790)output, (class_1935)((class_1935)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get()), (class_1935)((class_1935)ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
        RecipeGenerator.method_24885((class_8790)output, (class_1935)((class_1935)ModBlocks.PALE_MOSS_CARPET.get()), (class_1935)((class_1935)ModBlocks.PALE_MOSS_BLOCK.get()));
        RecipeGenerator.method_36444((class_8790)output, (class_1935)class_1802.field_8492, (class_1935)((class_1935)ModBlocks.OPEN_EYEBLOSSOM.get()), (String)"orange_dye");
        RecipeGenerator.method_36444((class_8790)output, (class_1935)class_1802.field_8298, (class_1935)((class_1935)ModBlocks.CLOSED_EYEBLOSSOM.get()), (String)"gray_dye");
        RecipeGenerator.method_36444((class_8790)output, (class_1935)class_1802.field_8192, (class_1935)((class_1935)ModBlocks.WILDFLOWERS.get()), (String)"yellow_dye");
        RecipeGenerator.method_46209((class_8790)output, (class_7800)class_7800.field_40634, (class_1935)((class_1935)ModBlocks.RESIN_BRICKS.get()), (class_1935)((class_1935)ModItems.RESIN_BRICK.get()));
        RecipeGenerator.method_36325((class_8790)output, (class_7800)class_7800.field_40642, (class_1935)((class_1935)ModBlocks.RESIN_CLUMP.get()), (class_7800)class_7800.field_40634, (class_1935)((class_1935)ModBlocks.RESIN_BLOCK.get()));
        RecipeGenerator.shaped(class_7800.field_40642, (class_1935)ModBlocks.CREAKING_HEART.get()).method_10434(Character.valueOf('R'), (class_1935)ModBlocks.RESIN_BLOCK.get()).method_10434(Character.valueOf('L'), (class_1935)ModBlocks.PALE_OAK_LOG.get()).method_10439(" L ").method_10439(" R ").method_10439(" L ").method_10429("has_resin_block", RecipeGenerator.method_10426((class_1935)((class_1935)ModBlocks.RESIN_BLOCK.get()))).method_10431(output);
        class_2454.method_17802((class_1856)class_1856.method_8091((class_1935[])new class_1935[]{(class_1935)ModBlocks.RESIN_CLUMP.get()}), (class_7800)class_7800.field_40642, (class_1935)((class_1935)ModItems.RESIN_BRICK.get()), (float)0.1f, (int)200).method_10469("has_resin_clump", RecipeGenerator.method_10426((class_1935)((class_1935)ModBlocks.RESIN_CLUMP.get()))).method_10431(output);
        RecipeGenerator.method_33715((class_8790)output, (class_7800)class_7800.field_40634, (class_1935)((class_1935)ModBlocks.RESIN_BRICK_SLAB.get()), (class_1935)((class_1935)ModBlocks.RESIN_BRICKS.get()), (int)2);
        RecipeGenerator.method_33717((class_8790)output, (class_7800)class_7800.field_40634, (class_1935)((class_1935)ModBlocks.RESIN_BRICK_STAIRS.get()), (class_1935)((class_1935)ModBlocks.RESIN_BRICKS.get()));
        RecipeGenerator.method_33717((class_8790)output, (class_7800)class_7800.field_40634, (class_1935)((class_1935)ModBlocks.RESIN_BRICK_WALL.get()), (class_1935)((class_1935)ModBlocks.RESIN_BRICKS.get()));
        RecipeGenerator.method_33717((class_8790)output, (class_7800)class_7800.field_40634, (class_1935)((class_1935)ModBlocks.CHISELED_RESIN_BRICKS.get()), (class_1935)((class_1935)ModBlocks.RESIN_BRICKS.get()));
        this.dryGhast(output, (class_1935)ModBlocks.DRIED_GHAST.get());
        this.harness(output, (class_1935)ModItems.WHITE_HARNESS.get(), (class_1935)class_2246.field_10446);
        this.harness(output, (class_1935)ModItems.ORANGE_HARNESS.get(), (class_1935)class_2246.field_10095);
        this.harness(output, (class_1935)ModItems.MAGENTA_HARNESS.get(), (class_1935)class_2246.field_10215);
        this.harness(output, (class_1935)ModItems.LIGHT_BLUE_HARNESS.get(), (class_1935)class_2246.field_10294);
        this.harness(output, (class_1935)ModItems.YELLOW_HARNESS.get(), (class_1935)class_2246.field_10490);
        this.harness(output, (class_1935)ModItems.LIME_HARNESS.get(), (class_1935)class_2246.field_10028);
        this.harness(output, (class_1935)ModItems.PINK_HARNESS.get(), (class_1935)class_2246.field_10459);
        this.harness(output, (class_1935)ModItems.GRAY_HARNESS.get(), (class_1935)class_2246.field_10423);
        this.harness(output, (class_1935)ModItems.LIGHT_GRAY_HARNESS.get(), (class_1935)class_2246.field_10222);
        this.harness(output, (class_1935)ModItems.CYAN_HARNESS.get(), (class_1935)class_2246.field_10619);
        this.harness(output, (class_1935)ModItems.PURPLE_HARNESS.get(), (class_1935)class_2246.field_10259);
        this.harness(output, (class_1935)ModItems.BLUE_HARNESS.get(), (class_1935)class_2246.field_10514);
        this.harness(output, (class_1935)ModItems.BROWN_HARNESS.get(), (class_1935)class_2246.field_10113);
        this.harness(output, (class_1935)ModItems.GREEN_HARNESS.get(), (class_1935)class_2246.field_10170);
        this.harness(output, (class_1935)ModItems.RED_HARNESS.get(), (class_1935)class_2246.field_10314);
        this.harness(output, (class_1935)ModItems.BLACK_HARNESS.get(), (class_1935)class_2246.field_10146);
        RecipeGenerator.shaped(class_7800.field_40639, (class_1935)class_1802.field_8175).method_10434(Character.valueOf('X'), (class_1935)class_1802.field_8745).method_10434(Character.valueOf('#'), (class_1935)class_1802.field_8620).method_10439(" X ").method_10439("X#X").method_10429("has_leather", RecipeGenerator.method_10426((class_1935)class_1802.field_8745)).method_10431(output);
        RecipeGenerator.shaped(class_7800.field_40638, (class_1935)class_1802.field_8719, 2).method_10434(Character.valueOf('~'), (class_1935)class_1802.field_8276).method_10439("~~ ").method_10439("~~ ").method_10439("  ~").method_10429("has_string", RecipeGenerator.method_10426((class_1935)class_1802.field_8276)).method_10431(output);
        RecipeGenerator.method_36444((class_8790)output, (class_1935)class_1802.field_8330, (class_1935)((class_1935)ModBlocks.CACTUS_FLOWER.get()), (String)"pink_dye");
        RecipeGenerator.shaped(class_7800.field_40635, (class_1935)class_2246.field_23261).method_10434(Character.valueOf('S'), (class_1935)class_1802.field_8525).method_10434(Character.valueOf('#'), (class_1935)class_1802.field_8620).method_10439("SSS").method_10439("S#S").method_10439("SSS").method_10429("has_iron_ingot", RecipeGenerator.method_10426((class_1935)class_1802.field_8620)).method_10429("has_lodestone", RecipeGenerator.method_10426((class_1935)class_1802.field_23256)).method_10431(output);
        RecipeGenerator.shaped(class_7800.field_40638, (class_1935)class_1802.field_27023).method_10434(Character.valueOf('-'), (class_1935)class_1802.field_8276).method_10434(Character.valueOf('#'), (class_1935)class_1802.field_8745).method_10439("-").method_10439("#").method_10429("has_string", RecipeGenerator.method_10426((class_1935)class_1802.field_8276)).method_10431(output);
        class_2450.method_10447((class_7800)class_7800.field_40640, (class_1935)class_1802.field_8741).method_10454((class_1935)class_2246.field_46282).method_10454((class_1935)class_1802.field_8479).method_10446(ModItemTags.EGGS).method_10442("has_carved_pumpkin", RecipeGenerator.method_10426((class_1935)class_2246.field_10147)).method_10442("has_pumpkin", RecipeGenerator.method_10426((class_1935)class_2246.field_46282)).method_10431(output);
        RecipeGenerator.shaped(class_7800.field_40640, (class_1935)class_2246.field_10183).method_10434(Character.valueOf('A'), (class_1935)class_1802.field_8103).method_10434(Character.valueOf('B'), (class_1935)class_1802.field_8479).method_10434(Character.valueOf('C'), (class_1935)class_1802.field_8861).method_10433(Character.valueOf('E'), ModItemTags.EGGS).method_10439("AAA").method_10439("BEB").method_10439("CCC").method_10429("has_egg", RecipeGenerator.method_10420(ModItemTags.EGGS)).method_10431(output);
        class_2454.method_17802((class_1856)class_1856.method_8106((class_6862)class_3489.field_15558), (class_7800)class_7800.field_40642, (class_1935)((class_1935)ModBlocks.LEAF_LITTER.get()), (float)0.1f, (int)200).method_10469("has_leaves", RecipeGenerator.method_10420((class_6862)class_3489.field_15558)).method_10431(output);
        class_2456.method_10476(BundleColoring::new).method_53820(output, "bundle_coloring");
    }

    public static class_2447 shaped(class_7800 category, class_1935 entry) {
        return class_2447.method_10437((class_7800)category, (class_1935)entry);
    }

    public static class_2447 shaped(class_7800 category, class_1935 entry, int amount) {
        return class_2447.method_10436((class_7800)category, (class_1935)entry, (int)amount);
    }

    private void dryGhast(class_8790 output, class_1935 ghast) {
        class_2447.method_10437((class_7800)class_7800.field_40634, (class_1935)ghast).method_10434(Character.valueOf('#'), (class_1935)class_1802.field_8070).method_10434(Character.valueOf('X'), (class_1935)class_1802.field_8067).method_10439("###").method_10439("#X#").method_10439("###").method_10435("dry_ghast").method_10429(RecipeGenerator.method_32807((class_1935)class_1802.field_8070), RecipeGenerator.method_10426((class_1935)class_1802.field_8070)).method_10431(output);
    }

    private void harness(class_8790 output, class_1935 harness, class_1935 carpet) {
        class_2447.method_10437((class_7800)class_7800.field_40637, (class_1935)harness).method_10434(Character.valueOf('#'), carpet).method_10434(Character.valueOf('G'), (class_1935)class_1802.field_8280).method_10434(Character.valueOf('L'), (class_1935)class_1802.field_8745).method_10439("LLL").method_10439("G#G").method_10435("harness").method_10429("has_dried_ghast", RecipeGenerator.method_10426((class_1935)((class_1935)ModBlocks.DRIED_GHAST.get()))).method_10431(output);
    }
}

