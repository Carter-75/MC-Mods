/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2256
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2975
 *  net.minecraft.class_3218
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5281
 *  net.minecraft.class_5819
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2256;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2975;
import net.minecraft.class_3218;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_7924;

public class PaleMossBlock
extends class_2248
implements class_2256 {
    public static final MapCodec<PaleMossBlock> CODEC = PaleMossBlock.method_54094(PaleMossBlock::new);

    public PaleMossBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    protected MapCodec<? extends class_2248> method_53969() {
        return CODEC;
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return level.method_8320(pos.method_10084()).method_26215();
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        level.method_30349().method_33310(class_7924.field_41239).flatMap(registry -> registry.method_40264(TheGardenAwakensFeatures.PALE_MOSS_PATCH_BONEMEAL)).ifPresent(reference -> ((class_2975)reference.comp_349()).method_12862((class_5281)level, level.method_14178().method_12129(), random, pos.method_10084()));
    }
}

