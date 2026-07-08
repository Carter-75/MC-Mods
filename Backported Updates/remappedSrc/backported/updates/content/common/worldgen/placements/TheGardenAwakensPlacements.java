/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_2975
 *  net.minecraft.class_5321
 *  net.minecraft.class_5450
 *  net.minecraft.class_5925
 *  net.minecraft.class_5934
 *  net.minecraft.class_6792
 *  net.minecraft.class_6793
 *  net.minecraft.class_6796
 *  net.minecraft.class_6797
 *  net.minecraft.class_6799
 *  net.minecraft.class_6817
 *  net.minecraft.class_6880
 *  net.minecraft.class_7871
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.worldgen.placements;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import net.minecraft.class_2248;
import net.minecraft.class_2902;
import net.minecraft.class_2975;
import net.minecraft.class_5321;
import net.minecraft.class_5450;
import net.minecraft.class_5925;
import net.minecraft.class_5934;
import net.minecraft.class_6792;
import net.minecraft.class_6793;
import net.minecraft.class_6796;
import net.minecraft.class_6797;
import net.minecraft.class_6799;
import net.minecraft.class_6817;
import net.minecraft.class_6880;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class TheGardenAwakensPlacements {
    public static final WorldGenRegistry<class_6796> FEATURES = WorldGenRegistry.of(class_7924.field_41245, "minecraft");
    public static final class_5321<class_6796> PALE_OAK_CHECKED = FEATURES.create("pale_oak_checked");
    public static final class_5321<class_6796> PALE_OAK_CREAKING_CHECKED = FEATURES.create("pale_oak_creaking_checked");
    public static final class_5321<class_6796> FLOWER_PALE_GARDEN = FEATURES.create("flower_pale_garden");
    public static final class_5321<class_6796> PALE_GARDEN_VEGETATION = FEATURES.create("pale_garden_vegetation");
    public static final class_5321<class_6796> PALE_GARDEN_FLOWERS = FEATURES.create("pale_garden_flowers");
    public static final class_5321<class_6796> PALE_MOSS_PATCH = FEATURES.create("pale_moss_patch");

    public static void bootstrap(class_7891<class_6796> context) {
        class_7871 features = context.method_46799(class_7924.field_41239);
        FEATURES.register(context, PALE_OAK_CHECKED, (class_6880<class_2975<?, ?>>)features.method_46747(TheGardenAwakensFeatures.PALE_OAK), new class_6797[]{class_6817.method_40365((class_2248)ModBlocks.PALE_OAK_SAPLING.get())});
        FEATURES.register(context, PALE_OAK_CREAKING_CHECKED, (class_6880<class_2975<?, ?>>)features.method_46747(TheGardenAwakensFeatures.PALE_OAK_CREAKING), new class_6797[]{class_6817.method_40365((class_2248)ModBlocks.PALE_OAK_SAPLING.get())});
        FEATURES.register(context, FLOWER_PALE_GARDEN, (class_6880<class_2975<?, ?>>)features.method_46747(TheGardenAwakensFeatures.FLOWER_PALE_GARDEN), new class_6797[]{class_6799.method_39659((int)32), class_5450.method_39639(), class_6817.field_36078, class_6792.method_39614()});
        FEATURES.register(context, PALE_GARDEN_VEGETATION, (class_6880<class_2975<?, ?>>)features.method_46747(TheGardenAwakensFeatures.PALE_GARDEN_VEGETATION), new class_6797[]{class_6793.method_39623((int)16), class_5450.method_39639(), class_5934.method_39662((int)0), class_6817.field_36081, class_6792.method_39614()});
        FEATURES.register(context, PALE_GARDEN_FLOWERS, (class_6880<class_2975<?, ?>>)features.method_46747(TheGardenAwakensFeatures.PALE_GARDEN_FLOWERS), new class_6797[]{class_6799.method_39659((int)8), class_5450.method_39639(), class_5925.method_39638((class_2902.class_2903)class_2902.class_2903.field_13203), class_6792.method_39614()});
        FEATURES.register(context, PALE_MOSS_PATCH, (class_6880<class_2975<?, ?>>)features.method_46747(TheGardenAwakensFeatures.PALE_MOSS_PATCH), new class_6797[]{class_6793.method_39623((int)1), class_5450.method_39639(), class_5925.method_39638((class_2902.class_2903)class_2902.class_2903.field_13203), class_6792.method_39614()});
    }
}

