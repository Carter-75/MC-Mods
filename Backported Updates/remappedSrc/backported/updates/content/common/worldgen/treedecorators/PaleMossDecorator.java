/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.class_156
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2975
 *  net.minecraft.class_4662
 *  net.minecraft.class_4662$class_7402
 *  net.minecraft.class_4663
 *  net.minecraft.class_5281
 *  net.minecraft.class_5819
 *  net.minecraft.class_7924
 *  org.apache.commons.lang3.mutable.Mutable
 *  org.apache.commons.lang3.mutable.MutableObject
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.level.blocks.HangingMossBlock;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModTreeDecorators;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.class_156;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2975;
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_7924;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

public class PaleMossDecorator
extends class_4662 {
    public static final MapCodec<PaleMossDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("leaves_probability").forGetter(decorator -> Float.valueOf(decorator.leavesProbability)), (App)Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("trunk_probability").forGetter(decorator -> Float.valueOf(decorator.trunkProbability)), (App)Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("ground_probability").forGetter(decorator -> Float.valueOf(decorator.groundProbability))).apply((Applicative)instance, PaleMossDecorator::new));
    private final float leavesProbability;
    private final float trunkProbability;
    private final float groundProbability;

    public PaleMossDecorator(float leavesProbability, float trunkProbability, float groundProbability) {
        this.leavesProbability = leavesProbability;
        this.trunkProbability = trunkProbability;
        this.groundProbability = groundProbability;
    }

    protected class_4663<?> method_28893() {
        return ModTreeDecorators.PALE_MOSS.get();
    }

    public void method_23469(class_4662.class_7402 context) {
        class_5819 random = context.method_43320();
        class_5281 level = (class_5281)context.method_43316();
        List positions = class_156.method_43027((ObjectArrayList)context.method_43321(), (class_5819)random);
        if (!positions.isEmpty()) {
            MutableObject mutable = new MutableObject((Object)((class_2338)positions.getFirst()));
            positions.forEach(arg_0 -> PaleMossDecorator.lambda$place$4((Mutable)mutable, arg_0));
            class_2338 position = (class_2338)mutable.getValue();
            if (random.method_43057() < this.groundProbability) {
                level.method_30349().method_46759(class_7924.field_41239).flatMap(registry -> registry.method_46746(TheGardenAwakensFeatures.PALE_MOSS_PATCH)).ifPresent(reference -> ((class_2975)reference.comp_349()).method_12862(level, level.method_8410().method_14178().method_12129(), random, position.method_10084()));
            }
            context.method_43321().forEach(pos -> {
                class_2338 below;
                if (random.method_43057() < this.trunkProbability && context.method_43317(below = pos.method_10074())) {
                    PaleMossDecorator.addMossHanger(below, context);
                }
            });
            context.method_43322().forEach(pos -> {
                class_2338 below;
                if (random.method_43057() < this.leavesProbability && context.method_43317(below = pos.method_10074())) {
                    PaleMossDecorator.addMossHanger(below, context);
                }
            });
        }
    }

    private static void addMossHanger(class_2338 pos, class_4662.class_7402 context) {
        while (context.method_43317(pos.method_10074()) && context.method_43320().method_43057() >= 0.5f) {
            context.method_43318(pos, (class_2680)ModBlocks.PALE_HANGING_MOSS.get().method_9564().method_11657((class_2769)HangingMossBlock.TIP, (Comparable)Boolean.valueOf(false)));
            pos = pos.method_10074();
        }
        context.method_43318(pos, (class_2680)ModBlocks.PALE_HANGING_MOSS.get().method_9564().method_11657((class_2769)HangingMossBlock.TIP, (Comparable)Boolean.valueOf(true)));
    }

    private static /* synthetic */ void lambda$place$4(Mutable mutable, class_2338 pos) {
        if (pos.method_10264() < ((class_2338)mutable.getValue()).method_10264()) {
            mutable.setValue((Object)pos);
        }
    }
}

