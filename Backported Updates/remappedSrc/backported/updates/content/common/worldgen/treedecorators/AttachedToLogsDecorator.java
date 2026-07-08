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
 *  net.minecraft.class_2350
 *  net.minecraft.class_4651
 *  net.minecraft.class_4662
 *  net.minecraft.class_4662$class_7402
 *  net.minecraft.class_4663
 *  net.minecraft.class_5699
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.registries.ModTreeDecorators;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.class_156;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_4651;
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import net.minecraft.class_5699;
import net.minecraft.class_5819;

public class AttachedToLogsDecorator
extends class_4662 {
    public static final MapCodec<AttachedToLogsDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").forGetter(decorator -> Float.valueOf(decorator.probability)), (App)class_4651.field_24937.fieldOf("block_provider").forGetter(decorator -> decorator.blockProvider), (App)class_5699.method_36973((Codec)class_2350.field_29502.listOf()).fieldOf("directions").forGetter(decorator -> decorator.directions)).apply((Applicative)instance, AttachedToLogsDecorator::new));
    private final float probability;
    private final class_4651 blockProvider;
    private final List<class_2350> directions;

    public AttachedToLogsDecorator(float probability, class_4651 blockProvider, List<class_2350> directions) {
        this.probability = probability;
        this.blockProvider = blockProvider;
        this.directions = directions;
    }

    public void method_23469(class_4662.class_7402 context) {
        class_5819 random = context.method_43320();
        for (class_2338 pos : class_156.method_43027((ObjectArrayList)context.method_43321(), (class_5819)random)) {
            class_2350 direction = (class_2350)class_156.method_32309(this.directions, (class_5819)random);
            class_2338 offset = pos.method_10093(direction);
            if (!(random.method_43057() <= this.probability) || !context.method_43317(offset)) continue;
            context.method_43318(offset, this.blockProvider.method_23455(random, offset));
        }
    }

    protected class_4663<?> method_28893() {
        return ModTreeDecorators.ATTACHED_TO_LOGS.get();
    }
}

