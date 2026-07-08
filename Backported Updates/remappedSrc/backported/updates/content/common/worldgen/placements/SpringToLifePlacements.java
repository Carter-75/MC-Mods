/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_2975
 *  net.minecraft.class_3003
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_5321
 *  net.minecraft.class_5450
 *  net.minecraft.class_5925
 *  net.minecraft.class_6646
 *  net.minecraft.class_6658
 *  net.minecraft.class_6792
 *  net.minecraft.class_6793
 *  net.minecraft.class_6796
 *  net.minecraft.class_6797
 *  net.minecraft.class_6799
 *  net.minecraft.class_6817
 *  net.minecraft.class_6819
 *  net.minecraft.class_6880
 *  net.minecraft.class_6880$class_6883
 *  net.minecraft.class_7871
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.worldgen.placements;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.worldgen.features.SpringToLifeFeatures;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2902;
import net.minecraft.class_2975;
import net.minecraft.class_3003;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_5321;
import net.minecraft.class_5450;
import net.minecraft.class_5925;
import net.minecraft.class_6646;
import net.minecraft.class_6658;
import net.minecraft.class_6792;
import net.minecraft.class_6793;
import net.minecraft.class_6796;
import net.minecraft.class_6797;
import net.minecraft.class_6799;
import net.minecraft.class_6817;
import net.minecraft.class_6819;
import net.minecraft.class_6880;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class SpringToLifePlacements {
    public static final WorldGenRegistry<class_6796> FEATURES = WorldGenRegistry.of(class_7924.field_41245, "minecraft");
    public static final class_5321<class_6796> PATCH_BUSH = FEATURES.create("patch_bush");
    public static final class_5321<class_6796> PATCH_FIREFLY_BUSH_NEAR_WATER = FEATURES.create("patch_firefly_bush_near_water");
    public static final class_5321<class_6796> PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP = FEATURES.create("patch_firefly_bush_near_water_swamp");
    public static final class_5321<class_6796> PATCH_FIREFLY_BUSH_SWAMP = FEATURES.create("patch_firefly_bush_swamp");
    public static final class_5321<class_6796> WILDFLOWERS_BIRCH_FOREST = FEATURES.create("wildflowers_birch_forest");
    public static final class_5321<class_6796> WILDFLOWERS_MEADOW = FEATURES.create("wildflowers_meadow");
    public static final class_5321<class_6796> PATCH_DRY_GRASS_BADLANDS = FEATURES.create("patch_dry_grass_badlands");
    public static final class_5321<class_6796> PATCH_DRY_GRASS_DESERT = FEATURES.create("patch_dry_grass_desert");
    public static final class_5321<class_6796> PATCH_LEAF_LITTER = FEATURES.create("patch_leaf_litter");
    public static final class_5321<class_6796> LEAF_LITTER = FEATURES.create("leaf_litter");
    public static final class_5321<class_6796> CACTUS_FLOWER = FEATURES.create("cactus_flower");
    public static final class_5321<class_6796> FALLEN_OAK_TREE = FEATURES.create("fallen_oak_tree");
    public static final class_5321<class_6796> FALLEN_BIRCH_TREE = FEATURES.create("fallen_birch_tree");
    public static final class_5321<class_6796> FALLEN_SUPER_BIRCH_TREE = FEATURES.create("fallen_super_birch_tree");
    public static final class_5321<class_6796> FALLEN_JUNGLE_TREE = FEATURES.create("fallen_jungle_tree");
    public static final class_5321<class_6796> FALLEN_SPRUCE_TREE = FEATURES.create("fallen_spruce_tree");
    public static final class_5321<class_6796> PLACED_FALLEN_OAK_TREE = FEATURES.create("placed_fallen_oak_tree");
    public static final class_5321<class_6796> PLACED_RARE_FALLEN_BIRCH_TREE = FEATURES.create("placed_rare_fallen_birch_tree");
    public static final class_5321<class_6796> PLACED_FALLEN_BIRCH_TREE = FEATURES.create("placed_fallen_birch_tree");
    public static final class_5321<class_6796> PLACED_FALLEN_SUPER_BIRCH_TREE = FEATURES.create("placed_fallen_super_birch_tree");
    public static final class_5321<class_6796> PLACED_FALLEN_JUNGLE_TREE = FEATURES.create("placed_fallen_jungle_tree");
    public static final class_5321<class_6796> PLACED_FALLEN_SPRUCE_TREE = FEATURES.create("placed_fallen_spruce_tree");
    public static final class_5321<class_6796> PLACED_RARE_FALLEN_SPRUCE_TREE = FEATURES.create("placed_rare_fallen_spruce_tree");

    public static void bootstrap(class_7891<class_6796> context) {
        class_7871 features = context.method_46799(class_7924.field_41239);
        class_6880.class_6883 patch = features.method_46747(SpringToLifeFeatures.PATCH_FIREFLY_BUSH);
        FEATURES.register(context, PATCH_BUSH, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.PATCH_BUSH), new class_6797[]{class_6799.method_39659((int)4), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, PATCH_FIREFLY_BUSH_NEAR_WATER, (class_6880<class_2975<?, ?>>)patch, new class_6797[]{class_6793.method_39623((int)2), class_5450.method_39639(), class_5925.method_39638((class_2902.class_2903)class_2902.class_2903.field_13203), class_6792.method_39614(), SpringToLifePlacements.nearWaterPredicate(ModBlocks.FIREFLY_BUSH.get())});
        FEATURES.register(context, PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP, (class_6880<class_2975<?, ?>>)patch, new class_6797[]{class_6793.method_39623((int)3), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614(), SpringToLifePlacements.nearWaterPredicate(ModBlocks.FIREFLY_BUSH.get())});
        FEATURES.register(context, PATCH_FIREFLY_BUSH_SWAMP, (class_6880<class_2975<?, ?>>)patch, new class_6797[]{class_6799.method_39659((int)8), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, WILDFLOWERS_BIRCH_FOREST, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.WILDFLOWERS_BIRCH_FOREST), new class_6797[]{class_6793.method_39623((int)3), class_6799.method_39659((int)2), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, WILDFLOWERS_MEADOW, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.WILDFLOWERS_MEADOW), new class_6797[]{class_3003.method_39642((double)-0.8, (int)5, (int)10), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, PATCH_DRY_GRASS_BADLANDS, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.PATCH_DRY_GRASS), new class_6797[]{class_6799.method_39659((int)6), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, PATCH_DRY_GRASS_DESERT, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.PATCH_DRY_GRASS), new class_6797[]{class_6799.method_39659((int)3), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, PATCH_LEAF_LITTER, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.PATCH_LEAF_LITTER), class_6819.method_39738((int)2));
        FEATURES.register(context, FALLEN_OAK_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_OAK_TREE), new class_6797[]{class_6817.method_40365((class_2248)class_2246.field_10394)});
        FEATURES.register(context, FALLEN_BIRCH_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_BIRCH_TREE), new class_6797[]{class_6817.method_40365((class_2248)class_2246.field_10575)});
        FEATURES.register(context, FALLEN_SUPER_BIRCH_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_SUPER_BIRCH_TREE), new class_6797[]{class_6817.method_40365((class_2248)class_2246.field_10575)});
        FEATURES.register(context, FALLEN_SPRUCE_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_SPRUCE_TREE), new class_6797[]{class_6817.method_40365((class_2248)class_2246.field_10217)});
        FEATURES.register(context, FALLEN_JUNGLE_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_JUNGLE_TREE), new class_6797[]{class_6817.method_40365((class_2248)class_2246.field_10276)});
        FEATURES.register(context, LEAF_LITTER, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.LEAF_LITTER), class_6819.method_39740((class_6797)class_6817.method_39736((int)16, (float)0.1f, (int)1)));
        FEATURES.register(context, CACTUS_FLOWER, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.CACTUS_FLOWER), class_6819.method_39740((class_6797)class_6817.method_39736((int)16, (float)0.1f, (int)1)));
        FEATURES.register(context, PLACED_FALLEN_OAK_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_OAK_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)80), (class_2248)class_2246.field_10394));
        FEATURES.register(context, PLACED_RARE_FALLEN_BIRCH_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_BIRCH_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)400), (class_2248)class_2246.field_10575));
        FEATURES.register(context, PLACED_FALLEN_BIRCH_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_BIRCH_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)80), (class_2248)class_2246.field_10575));
        FEATURES.register(context, PLACED_FALLEN_SUPER_BIRCH_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_SUPER_BIRCH_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)160), (class_2248)class_2246.field_10575));
        FEATURES.register(context, PLACED_FALLEN_JUNGLE_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_JUNGLE_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)80), (class_2248)class_2246.field_10276));
        FEATURES.register(context, PLACED_FALLEN_SPRUCE_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_SPRUCE_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)80), (class_2248)class_2246.field_10217));
        FEATURES.register(context, PLACED_RARE_FALLEN_SPRUCE_TREE, (class_6880<class_2975<?, ?>>)features.method_46747(SpringToLifeFeatures.FALLEN_SPRUCE_TREE), class_6819.method_39741((class_6797)class_6799.method_39659((int)120), (class_2248)class_2246.field_10217));
    }

    public static class_6658 nearWaterPredicate(class_2248 block) {
        return class_6658.method_39618((class_6646)class_6646.method_38882((class_6646[])new class_6646[]{class_6646.field_35696, class_6646.method_39009((class_2680)block.method_9564(), (class_2382)class_2338.field_10980), class_6646.method_38887((class_6646[])new class_6646[]{class_6646.method_43289((class_2382)new class_2338(1, -1, 0), (class_3611[])new class_3611[]{class_3612.field_15910, class_3612.field_15909}), class_6646.method_43289((class_2382)new class_2338(-1, -1, 0), (class_3611[])new class_3611[]{class_3612.field_15910, class_3612.field_15909}), class_6646.method_43289((class_2382)new class_2338(0, -1, 1), (class_3611[])new class_3611[]{class_3612.field_15910, class_3612.field_15909}), class_6646.method_43289((class_2382)new class_2338(0, -1, -1), (class_3611[])new class_3611[]{class_3612.field_15910, class_3612.field_15909})})}));
    }
}

