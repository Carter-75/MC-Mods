/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3031
 *  net.minecraft.class_3111
 *  net.minecraft.class_3481
 *  net.minecraft.class_4538
 *  net.minecraft.class_5281
 *  net.minecraft.class_5819
 *  net.minecraft.class_5821
 */
package backported.updates.content.common.level.features;

import backported.updates.content.common.level.blocks.LeafLitterBlock;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import com.mojang.serialization.Codec;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2902;
import net.minecraft.class_3031;
import net.minecraft.class_3111;
import net.minecraft.class_3481;
import net.minecraft.class_4538;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_5821;

public class LeafLitterFeature
extends class_3031<class_3111> {
    public LeafLitterFeature(Codec<class_3111> codec) {
        super(codec);
    }

    public boolean method_13151(class_5821<class_3111> context) {
        class_5281 level = context.method_33652();
        class_2338 origin = context.method_33655();
        class_5819 random = context.method_33654();
        class_2338.class_2339 mutable = new class_2338.class_2339();
        for (int xRange = 0; xRange < 16; ++xRange) {
            if (random.method_43056()) continue;
            for (int zRange = 0; zRange < 16; ++zRange) {
                if (random.method_43056()) continue;
                int x = origin.method_10263() + xRange;
                int z = origin.method_10260() + zRange;
                mutable.method_10103(x, level.method_8624(class_2902.class_2903.field_13197, x, z) - 1, z);
                if (!level.method_8320((class_2338)mutable).method_26164(class_3481.field_15503) || !level.method_8320((class_2338)mutable).method_26164(ModBlockTags.ALLOWS_LEAF_LITTER)) continue;
                mutable.method_10103(x, level.method_8624(class_2902.class_2903.field_13203, x, z), z);
                class_2680 state = (class_2680)((class_2680)ModBlocks.LEAF_LITTER.get().method_9564().method_11657((class_2769)LeafLitterBlock.AMOUNT, (Comparable)Integer.valueOf(random.method_39332(1, 4)))).method_11657((class_2769)LeafLitterBlock.FACING, (Comparable)class_2350.class_2353.field_11062.method_10183(random));
                if (level.method_8320((class_2338)mutable).method_27852(ModBlocks.LEAF_LITTER.get()) || !level.method_8320((class_2338)mutable).method_26215() || !state.method_26184((class_4538)level, (class_2338)mutable)) continue;
                level.method_8652((class_2338)mutable, state, 1);
            }
        }
        return true;
    }
}

