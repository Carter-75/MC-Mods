/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_3746
 *  net.minecraft.class_4662
 *  net.minecraft.class_4662$class_7402
 *  net.minecraft.class_4663
 *  net.minecraft.class_4970$class_4971
 *  net.minecraft.class_5819
 */
package backported.updates.garden.decorator;

import backported.updates.garden.Init;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_3746;
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class CreakingHeartDecorator
extends class_4662 {
    public static final MapCodec<CreakingHeartDecorator> CODEC = Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").xmap(CreakingHeartDecorator::new, decorator -> Float.valueOf(decorator.probability));
    private final float probability;

    public CreakingHeartDecorator(float probability) {
        this.probability = probability;
    }

    protected class_4663<?> method_28893() {
        return null;
    }

    public void method_23469(class_4662.class_7402 generator) {
        class_5819 random = generator.method_43320();
        class_3746 testableWorld = generator.method_43316();
        float floatRandom = random.method_43057();
        if (floatRandom <= this.probability) {
            ObjectArrayList logPositions = generator.method_43321();
            ObjectArrayList filteredLogPositions = new ObjectArrayList();
            logPositions.forEach(blockPos -> {
                if ((testableWorld.method_16358(blockPos.method_10095(), class_4970.class_4971::method_26215) || testableWorld.method_16358(blockPos.method_10078(), class_4970.class_4971::method_26215) || testableWorld.method_16358(blockPos.method_10072(), class_4970.class_4971::method_26215) || testableWorld.method_16358(blockPos.method_10067(), class_4970.class_4971::method_26215)) && (testableWorld.method_16358(blockPos.method_10087(2), state -> state.method_27852(class_2246.field_10566)) || testableWorld.method_16358(blockPos.method_10087(3), state -> state.method_27852(class_2246.field_10566)))) {
                    filteredLogPositions.add(blockPos);
                }
            });
            class_2338 creakingPosition = (class_2338)filteredLogPositions.get(random.method_43048(filteredLogPositions.size()));
            generator.method_43318(creakingPosition, Init.CREAKING_HEART.method_9564());
        }
    }
}

