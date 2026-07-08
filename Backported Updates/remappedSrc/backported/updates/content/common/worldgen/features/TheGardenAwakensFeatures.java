/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2975
 *  net.minecraft.class_3031
 *  net.minecraft.class_3037
 *  net.minecraft.class_3141
 *  net.minecraft.class_3175
 *  net.minecraft.class_3226
 *  net.minecraft.class_3481
 *  net.minecraft.class_4638
 *  net.minecraft.class_4643$class_4644
 *  net.minecraft.class_4647
 *  net.minecraft.class_4651
 *  net.minecraft.class_4657
 *  net.minecraft.class_5141
 *  net.minecraft.class_5201
 *  net.minecraft.class_5203
 *  net.minecraft.class_5206
 *  net.minecraft.class_5211
 *  net.minecraft.class_5321
 *  net.minecraft.class_5927
 *  net.minecraft.class_5932
 *  net.minecraft.class_6005
 *  net.minecraft.class_6016
 *  net.minecraft.class_6017
 *  net.minecraft.class_6019
 *  net.minecraft.class_6797
 *  net.minecraft.class_6803
 *  net.minecraft.class_6817
 *  net.minecraft.class_6880
 *  net.minecraft.class_7871
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.worldgen.features;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import backported.updates.content.common.worldgen.treedecorators.CreakingHeartDecorator;
import backported.updates.content.common.worldgen.treedecorators.PaleMossDecorator;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalInt;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3141;
import net.minecraft.class_3175;
import net.minecraft.class_3226;
import net.minecraft.class_3481;
import net.minecraft.class_4638;
import net.minecraft.class_4643;
import net.minecraft.class_4647;
import net.minecraft.class_4651;
import net.minecraft.class_4657;
import net.minecraft.class_5141;
import net.minecraft.class_5201;
import net.minecraft.class_5203;
import net.minecraft.class_5206;
import net.minecraft.class_5211;
import net.minecraft.class_5321;
import net.minecraft.class_5927;
import net.minecraft.class_5932;
import net.minecraft.class_6005;
import net.minecraft.class_6016;
import net.minecraft.class_6017;
import net.minecraft.class_6019;
import net.minecraft.class_6797;
import net.minecraft.class_6803;
import net.minecraft.class_6817;
import net.minecraft.class_6880;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class TheGardenAwakensFeatures {
    public static final WorldGenRegistry<class_2975<?, ?>> FEATURES = WorldGenRegistry.of(class_7924.field_41239, "minecraft");
    public static final class_5321<class_2975<?, ?>> PALE_OAK = FEATURES.create("pale_oak");
    public static final class_5321<class_2975<?, ?>> PALE_OAK_BONEMEAL = FEATURES.create("pale_oak_bonemeal");
    public static final class_5321<class_2975<?, ?>> PALE_OAK_CREAKING = FEATURES.create("pale_oak_creaking");
    public static final class_5321<class_2975<?, ?>> FLOWER_PALE_GARDEN = FEATURES.create("flower_pale_garden");
    public static final class_5321<class_2975<?, ?>> PALE_GARDEN_FLOWERS = FEATURES.create("pale_garden_flowers");
    public static final class_5321<class_2975<?, ?>> PALE_GARDEN_VEGETATION = FEATURES.create("pale_garden_vegetation");
    public static final class_5321<class_2975<?, ?>> PALE_MOSS_VEGETATION = FEATURES.create("pale_moss_vegetation");
    public static final class_5321<class_2975<?, ?>> PALE_MOSS_PATCH = FEATURES.create("pale_moss_patch");
    public static final class_5321<class_2975<?, ?>> PALE_MOSS_PATCH_BONEMEAL = FEATURES.create("pale_moss_patch_bonemeal");

    public static void bootstrap(class_7891<class_2975<?, ?>> context) {
        class_7871 features = context.method_46799(class_7924.field_41239);
        class_7871 placements = context.method_46799(class_7924.field_41245);
        FEATURES.register(context, PALE_OAK, class_3031.field_24134, new class_4643.class_4644((class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_OAK_LOG.get()), (class_5141)new class_5211(6, 2, 1), (class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_OAK_LEAVES.get()), (class_4647)new class_5206((class_6017)class_6016.method_34998((int)0), (class_6017)class_6016.method_34998((int)0)), (class_5201)new class_5203(1, 1, 0, 1, 2, OptionalInt.empty())).method_27376((List)ImmutableList.of((Object)((Object)new PaleMossDecorator(0.15f, 0.4f, 0.8f)))).method_27374().method_23445());
        FEATURES.register(context, PALE_OAK_BONEMEAL, class_3031.field_24134, new class_4643.class_4644((class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_OAK_LOG.get()), (class_5141)new class_5211(6, 2, 1), (class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_OAK_LEAVES.get()), (class_4647)new class_5206((class_6017)class_6016.method_34998((int)0), (class_6017)class_6016.method_34998((int)0)), (class_5201)new class_5203(1, 1, 0, 1, 2, OptionalInt.empty())).method_27374().method_23445());
        FEATURES.register(context, PALE_OAK_CREAKING, class_3031.field_24134, new class_4643.class_4644((class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_OAK_LOG.get()), (class_5141)new class_5211(6, 2, 1), (class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_OAK_LEAVES.get()), (class_4647)new class_5206((class_6017)class_6016.method_34998((int)0), (class_6017)class_6016.method_34998((int)0)), (class_5201)new class_5203(1, 1, 0, 1, 2, OptionalInt.empty())).method_27376((List)ImmutableList.of((Object)((Object)new PaleMossDecorator(0.15f, 0.4f, 0.8f)), (Object)((Object)new CreakingHeartDecorator(1.0f)))).method_27374().method_23445());
        FEATURES.register(context, FLOWER_PALE_GARDEN, class_3031.field_21219, new class_4638(1, 0, 0, class_6817.method_40366((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)class_4651.method_38432((class_2248)ModBlocks.CLOSED_EYEBLOSSOM.get())))));
        FEATURES.register(context, PALE_GARDEN_FLOWERS, class_3031.field_21220, class_6803.method_39704((class_3031)class_3031.field_13518, (class_3037)new class_3175((class_4651)class_4651.method_38432((class_2248)ModBlocks.CLOSED_EYEBLOSSOM.get()))));
        FEATURES.register(context, PALE_GARDEN_VEGETATION, class_3031.field_13593, new class_3141(List.of(new class_3226((class_6880)placements.method_46747(TheGardenAwakensPlacements.PALE_OAK_CREAKING_CHECKED), 0.1f), new class_3226((class_6880)placements.method_46747(TheGardenAwakensPlacements.PALE_OAK_CHECKED), 0.9f)), (class_6880)placements.method_46747(TheGardenAwakensPlacements.PALE_OAK_CHECKED)));
        FEATURES.register(context, PALE_MOSS_VEGETATION, class_3031.field_13518, new class_3175((class_4651)new class_4657(class_6005.method_34971().method_34975((Object)ModBlocks.PALE_MOSS_CARPET.get().method_9564(), 25).method_34975((Object)class_2246.field_10479.method_9564(), 25).method_34975((Object)class_2246.field_10214.method_9564(), 10))));
        FEATURES.register(context, PALE_MOSS_PATCH, class_3031.field_29250, new class_5927(class_3481.field_28622, (class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_MOSS_BLOCK.get()), class_6817.method_40369((class_6880)features.method_46747(PALE_MOSS_VEGETATION), (class_6797[])new class_6797[0]), class_5932.field_29314, (class_6017)class_6016.method_34998((int)1), 0.0f, 5, 0.3f, (class_6017)class_6019.method_35017((int)2, (int)4), 0.75f));
        FEATURES.register(context, PALE_MOSS_PATCH_BONEMEAL, class_3031.field_29250, new class_5927(class_3481.field_28622, (class_4651)class_4651.method_38432((class_2248)ModBlocks.PALE_MOSS_BLOCK.get()), class_6817.method_40369((class_6880)features.method_46747(PALE_MOSS_VEGETATION), (class_6797[])new class_6797[0]), class_5932.field_29314, (class_6017)class_6016.method_34998((int)1), 0.0f, 5, 0.6f, (class_6017)class_6019.method_35017((int)1, (int)2), 0.75f));
    }
}

