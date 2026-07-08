/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2975
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5281
 *  net.minecraft.class_5807
 *  net.minecraft.class_5819
 *  net.minecraft.class_7924
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2975;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5281;
import net.minecraft.class_5807;
import net.minecraft.class_5819;
import net.minecraft.class_7924;

public class PaleMossBlock
extends class_5807 {
    public static final MapCodec<class_5807> CODEC = PaleMossBlock.method_54094(PaleMossBlock::new);

    public MapCodec<class_5807> method_53969() {
        return CODEC;
    }

    public PaleMossBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    public void method_9652(class_3218 world, class_5819 random, class_2338 pos, class_2680 state) {
        world.method_30349().method_33310(class_7924.field_41239).flatMap(key -> key.method_55841(Init.PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID)).ifPresent(entry -> ((class_2975)entry.comp_349()).method_12862((class_5281)world, world.method_14178().method_12129(), random, pos.method_10084()));
    }
}

