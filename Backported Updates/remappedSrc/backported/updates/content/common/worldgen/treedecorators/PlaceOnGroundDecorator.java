/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3341
 *  net.minecraft.class_4651
 *  net.minecraft.class_4662
 *  net.minecraft.class_4662$class_7402
 *  net.minecraft.class_4663
 *  net.minecraft.class_5699
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.registries.ModTreeDecorators;
import com.google.common.collect.Lists;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2902;
import net.minecraft.class_3341;
import net.minecraft.class_4651;
import net.minecraft.class_4662;
import net.minecraft.class_4663;
import net.minecraft.class_5699;
import net.minecraft.class_5819;

public class PlaceOnGroundDecorator
extends class_4662 {
    public static final MapCodec<PlaceOnGroundDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_5699.field_33442.fieldOf("tries").orElse((Object)128).forGetter(decorator -> decorator.tries), (App)class_5699.field_33441.fieldOf("radius").orElse((Object)2).forGetter(decorator -> decorator.radius), (App)class_5699.field_33441.fieldOf("height").orElse((Object)1).forGetter(decorator -> decorator.height), (App)class_4651.field_24937.fieldOf("block_state_provider").forGetter(decorator -> decorator.blockStateProvider)).apply((Applicative)instance, PlaceOnGroundDecorator::new));
    private final int tries;
    private final int radius;
    private final int height;
    private final class_4651 blockStateProvider;

    public PlaceOnGroundDecorator(int tries, int radius, int height, class_4651 blockStateProvider) {
        this.tries = tries;
        this.radius = radius;
        this.height = height;
        this.blockStateProvider = blockStateProvider;
    }

    protected class_4663<?> method_28893() {
        return ModTreeDecorators.PLACE_ON_GROUND.get();
    }

    public void method_23469(class_4662.class_7402 context) {
        ArrayList list = Lists.newArrayList();
        ObjectArrayList list2 = context.method_43323();
        ObjectArrayList list3 = context.method_43321();
        if (list2.isEmpty()) {
            list.addAll(list3);
        } else if (!list3.isEmpty() && ((class_2338)list2.get(0)).method_10264() == ((class_2338)list3.get(0)).method_10264()) {
            list.addAll(list3);
            list.addAll(list2);
        } else {
            list.addAll(list2);
        }
        if (!list.isEmpty()) {
            class_2338 blockPos = (class_2338)list.get(0);
            int i = blockPos.method_10264();
            int j = blockPos.method_10263();
            int k = blockPos.method_10263();
            int l = blockPos.method_10260();
            int m = blockPos.method_10260();
            for (class_2338 blockPos2 : list) {
                if (blockPos2.method_10264() != i) continue;
                j = Math.min(j, blockPos2.method_10263());
                k = Math.max(k, blockPos2.method_10263());
                l = Math.min(l, blockPos2.method_10260());
                m = Math.max(m, blockPos2.method_10260());
            }
            class_5819 randomSource = context.method_43320();
            class_3341 base = new class_3341(j, i, l, k, i, m);
            class_3341 boundingBox = new class_3341(base.method_35415() - this.radius, base.method_35416() - this.height, base.method_35417() - this.radius, base.method_35418() + this.radius, base.method_35419() + this.height, base.method_35420() + this.radius);
            class_2338.class_2339 mutableBlockPos = new class_2338.class_2339();
            for (int n = 0; n < this.tries; ++n) {
                mutableBlockPos.method_10103(randomSource.method_39332(boundingBox.method_35415(), boundingBox.method_35418()), randomSource.method_39332(boundingBox.method_35416(), boundingBox.method_35419()), randomSource.method_39332(boundingBox.method_35417(), boundingBox.method_35420()));
                this.attemptToPlaceBlockAbove(context, (class_2338)mutableBlockPos);
            }
        }
    }

    private void attemptToPlaceBlockAbove(class_4662.class_7402 context, class_2338 pos) {
        class_2338 above = pos.method_10084();
        if (context.method_43316().method_16358(above, state -> state.method_26215() || state.method_27852(class_2246.field_10597)) && context.method_43316().method_16358(pos, state -> state.method_26216((class_1922)context.method_43316(), pos)) && context.method_43316().method_8598(class_2902.class_2903.field_13203, pos).method_10264() <= above.method_10264()) {
            context.method_43318(above, this.blockStateProvider.method_23455(context.method_43320(), above));
        }
    }
}

