/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2754
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_2975
 *  net.minecraft.class_3031
 *  net.minecraft.class_3037
 *  net.minecraft.class_3175
 *  net.minecraft.class_4638
 *  net.minecraft.class_4651
 *  net.minecraft.class_4657
 *  net.minecraft.class_4662
 *  net.minecraft.class_4664
 *  net.minecraft.class_5321
 *  net.minecraft.class_6005
 *  net.minecraft.class_6005$class_6006
 *  net.minecraft.class_6017
 *  net.minecraft.class_6019
 *  net.minecraft.class_6646
 *  net.minecraft.class_6803
 *  net.minecraft.class_6817
 *  net.minecraft.class_6880
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 *  net.minecraft.class_8169
 */
package backported.updates.content.common.worldgen.features;

import backported.updates.content.common.level.features.FallenTreeConfiguration;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModFeatures;
import backported.updates.content.common.worldgen.treedecorators.AttachedToLogsDecorator;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import com.google.common.collect.ImmutableList;
import java.util.List;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2754;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3175;
import net.minecraft.class_4638;
import net.minecraft.class_4651;
import net.minecraft.class_4657;
import net.minecraft.class_4662;
import net.minecraft.class_4664;
import net.minecraft.class_5321;
import net.minecraft.class_6005;
import net.minecraft.class_6017;
import net.minecraft.class_6019;
import net.minecraft.class_6646;
import net.minecraft.class_6803;
import net.minecraft.class_6817;
import net.minecraft.class_6880;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_8169;

public class SpringToLifeFeatures {
    public static final WorldGenRegistry<class_2975<?, ?>> FEATURES = WorldGenRegistry.of(class_7924.field_41239, "minecraft");
    public static final class_5321<class_2975<?, ?>> PATCH_BUSH = FEATURES.create("patch_bush");
    public static final class_5321<class_2975<?, ?>> PATCH_FIREFLY_BUSH = FEATURES.create("patch_firefly_bush");
    public static final class_5321<class_2975<?, ?>> WILDFLOWERS_BIRCH_FOREST = FEATURES.create("wildflowers_birch_forest");
    public static final class_5321<class_2975<?, ?>> WILDFLOWERS_MEADOW = FEATURES.create("wildflowers_meadow");
    public static final class_5321<class_2975<?, ?>> PATCH_DRY_GRASS = FEATURES.create("patch_dry_grass");
    public static final class_5321<class_2975<?, ?>> PATCH_LEAF_LITTER = FEATURES.create("patch_leaf_litter");
    public static final class_5321<class_2975<?, ?>> LEAF_LITTER = FEATURES.create("leaf_litter");
    public static final class_5321<class_2975<?, ?>> CACTUS_FLOWER = FEATURES.create("cactus_flower");
    public static final class_5321<class_2975<?, ?>> FALLEN_OAK_TREE = FEATURES.create("fallen_oak_tree");
    public static final class_5321<class_2975<?, ?>> FALLEN_BIRCH_TREE = FEATURES.create("fallen_birch_tree");
    public static final class_5321<class_2975<?, ?>> FALLEN_SUPER_BIRCH_TREE = FEATURES.create("fallen_super_birch_tree");
    public static final class_5321<class_2975<?, ?>> FALLEN_JUNGLE_TREE = FEATURES.create("fallen_jungle_tree");
    public static final class_5321<class_2975<?, ?>> FALLEN_SPRUCE_TREE = FEATURES.create("fallen_spruce_tree");

    public static void bootstrap(class_7891<class_2975<?, ?>> context) {
        FEATURES.register(context, PATCH_BUSH, class_3031.field_21220, new class_4638(25, 5, 3, class_6817.method_40366((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)class_4651.method_38432((class_2248)ModBlocks.BUSH.get())))));
        FEATURES.register(context, PATCH_FIREFLY_BUSH, class_3031.field_21220, new class_4638(20, 4, 3, class_6817.method_40366((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)class_4651.method_38432((class_2248)ModBlocks.FIREFLY_BUSH.get())))));
        FEATURES.register(context, WILDFLOWERS_BIRCH_FOREST, class_3031.field_21219, new class_4638(64, 6, 2, class_6817.method_40366((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)new class_4657(SpringToLifeFeatures.flowerBedPatchBuilder(ModBlocks.WILDFLOWERS.get()))))));
        FEATURES.register(context, WILDFLOWERS_MEADOW, class_3031.field_21219, new class_4638(8, 6, 2, class_6817.method_40366((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)new class_4657(SpringToLifeFeatures.flowerBedPatchBuilder(ModBlocks.WILDFLOWERS.get()))))));
        FEATURES.register(context, PATCH_DRY_GRASS, class_3031.field_21220, SpringToLifeFeatures.grassPatch((class_4651)new class_4657(class_6005.method_34971().method_34975((Object)ModBlocks.SHORT_DRY_GRASS.get().method_9564(), 1).method_34975((Object)ModBlocks.TALL_DRY_GRASS.get().method_9564(), 1).method_34974()), 64));
        FEATURES.register(context, PATCH_LEAF_LITTER, class_3031.field_21220, class_6803.method_39703((int)32, (class_6880)class_6817.method_40367((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)new class_4657(SpringToLifeFeatures.leafLitterPatchBuilder(1, 3))), (class_6646)class_6646.method_38878((class_6646)class_6646.field_35696, (class_6646)class_6646.method_43288((class_2382)class_2350.field_11033.method_10163(), (class_2248[])new class_2248[]{class_2246.field_10219})))));
        FEATURES.register(context, FALLEN_OAK_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenOak().build());
        FEATURES.register(context, FALLEN_BIRCH_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenBirch(8).build());
        FEATURES.register(context, FALLEN_SUPER_BIRCH_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenBirch(15).build());
        FEATURES.register(context, FALLEN_JUNGLE_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenJungle().build());
        FEATURES.register(context, FALLEN_SPRUCE_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenSpruce().build());
        FEATURES.register(context, LEAF_LITTER, ModFeatures.LEAF_LITTER.get(), class_3037.field_13603);
        FEATURES.register(context, CACTUS_FLOWER, ModFeatures.CACTUS_FLOWER.get(), class_3037.field_13603);
    }

    private static class_4638 grassPatch(class_4651 provider, int tries) {
        return class_6803.method_39703((int)tries, (class_6880)class_6817.method_40366((class_3031)class_3031.field_13518, (class_3037)new class_3175(provider)));
    }

    private static class_6005.class_6006<class_2680> flowerBedPatchBuilder(class_2248 block) {
        return SpringToLifeFeatures.segmentedBlockPatchBuilder(block, 1, 4, class_8169.field_42765, (class_2754<class_2350>)class_8169.field_42764);
    }

    private static class_6005.class_6006<class_2680> leafLitterPatchBuilder(int min, int max) {
        return SpringToLifeFeatures.segmentedBlockPatchBuilder(ModBlocks.LEAF_LITTER.get(), min, max, class_8169.field_42765, (class_2754<class_2350>)class_8169.field_42764);
    }

    private static class_6005.class_6006<class_2680> segmentedBlockPatchBuilder(class_2248 block, int min, int max, class_2758 amount, class_2754<class_2350> facing) {
        class_6005.class_6006 builder = class_6005.method_34971();
        for (int i = min; i <= max; ++i) {
            for (class_2350 direction : class_2350.class_2353.field_11062) {
                builder.method_34975((Object)((class_2680)((class_2680)block.method_9564().method_11657((class_2769)amount, (Comparable)Integer.valueOf(i))).method_11657(facing, (Comparable)direction)), 1);
            }
        }
        return builder;
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenOak() {
        return SpringToLifeFeatures.createFallenTrees(class_2246.field_10431, 4, 7).stumpDecorators((List<class_4662>)ImmutableList.of((Object)class_4664.field_24965));
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenBirch(int i) {
        return SpringToLifeFeatures.createFallenTrees(class_2246.field_10511, 5, i);
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenJungle() {
        return SpringToLifeFeatures.createFallenTrees(class_2246.field_10306, 4, 11).stumpDecorators((List<class_4662>)ImmutableList.of((Object)class_4664.field_24965));
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenSpruce() {
        return SpringToLifeFeatures.createFallenTrees(class_2246.field_10037, 6, 10);
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenTrees(class_2248 block, int minLength, int maxLength) {
        return new FallenTreeConfiguration.FallenTreeConfigurationBuilder((class_4651)class_4651.method_38432((class_2248)block), (class_6017)class_6019.method_35017((int)minLength, (int)maxLength)).logDecorators((List<class_4662>)ImmutableList.of((Object)((Object)new AttachedToLogsDecorator(0.1f, (class_4651)new class_4657(class_6005.method_34971().method_34975((Object)class_2246.field_10559.method_9564(), 2).method_34975((Object)class_2246.field_10251.method_9564(), 1)), List.of(class_2350.field_11036)))));
    }
}

