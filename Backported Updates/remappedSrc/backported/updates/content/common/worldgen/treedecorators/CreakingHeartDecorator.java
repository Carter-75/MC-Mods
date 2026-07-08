/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.class_156
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3481
 *  net.minecraft.class_4662
 *  net.minecraft.class_4662$class_7402
 *  net.minecraft.class_4663
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModTreeDecorators;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.Optional;
import net.minecraft.class_156;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3481;
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import net.minecraft.class_5819;

public class CreakingHeartDecorator
extends class_4662 {
    public static final MapCodec<CreakingHeartDecorator> CODEC = Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").xmap(CreakingHeartDecorator::new, decorator -> Float.valueOf(decorator.probability));
    private final float probability;

    public CreakingHeartDecorator(float probability) {
        this.probability = probability;
    }

    protected class_4663<?> method_28893() {
        return ModTreeDecorators.CREAKING_HEART.get();
    }

    public void method_23469(class_4662.class_7402 context) {
        class_5819 random = context.method_43320();
        ObjectArrayList logs = context.method_43321();
        if (!logs.isEmpty() && random.method_43057() < this.probability) {
            ArrayList heartPlacements = new ArrayList(context.method_43321());
            class_156.method_43028(heartPlacements, (class_5819)random);
            Optional<class_2338> targetPos = heartPlacements.stream().filter(pos -> {
                for (class_2350 dir : class_2350.values()) {
                    if (context.method_43316().method_16358(pos.method_10093(dir), state -> state.method_26164(class_3481.field_15475))) continue;
                    return false;
                }
                return true;
            }).findFirst();
            targetPos.ifPresent(pos -> context.method_43318(pos, (class_2680)((class_2680)ModBlocks.CREAKING_HEART.get().method_9564().method_11657(CreakingHeartBlock.STATE, (Comparable)((Object)CreakingHeartState.DORMANT))).method_11657((class_2769)CreakingHeartBlock.NATURAL, (Comparable)Boolean.valueOf(true))));
        }
    }
}

