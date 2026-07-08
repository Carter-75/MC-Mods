/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3031
 *  net.minecraft.class_3111
 *  net.minecraft.class_5281
 *  net.minecraft.class_5819
 *  net.minecraft.class_5821
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.world.feature;

import dev.mim1q.derelict.block.cobweb.FancyCornerCobwebBlock;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.world.feature.SpiderSilkParabolaKt;
import dev.mim1q.derelict.world.feature.SpiderSilkPillarKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3031;
import net.minecraft.class_3111;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_5821;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/world/feature/SpiderSilkParabola;", "Lnet/minecraft/class_3031;", "Lnet/minecraft/class_3111;", "<init>", "()V", "Lnet/minecraft/class_5821;", "context", "", "generate", "(Lnet/minecraft/class_5821;)Z", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderSilkParabola.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderSilkParabola.kt\ndev/mim1q/derelict/world/feature/SpiderSilkParabola\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class SpiderSilkParabola
extends class_3031<class_3111> {
    public SpiderSilkParabola() {
        super(class_3111.field_24893);
    }

    public boolean method_13151(@NotNull class_5821<class_3111> context) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Pair direction = (Pair)ArraysKt.random((Object[])SpiderSilkParabolaKt.access$getPOSSIBLE_DIRECTIONS$p(), (Random)((Random)Random.Default));
        class_2338.class_2339 pos = context.method_33655().method_10059(((class_2382)direction.getFirst()).method_35862(16)).method_25503();
        class_5281 world = context.method_33652();
        for (int i = 0; !(i >= 33 || world.method_8320((class_2338)pos).method_26215() && world.method_8320(pos.method_10084()).method_26206((class_1922)world, (class_2338)pos, class_2350.field_11033)); ++i) {
            if (i == 32) {
                return false;
            }
            pos.method_10100(0, 1, 0);
        }
        Integer[][] integerArrayArray = new Integer[3][];
        Integer[] integerArray = new Integer[]{-2, -2, -1, -1, 0, 1, 1, 1, 2, 2, 4};
        integerArrayArray[0] = integerArray;
        integerArray = new Integer[]{-2, -2, -1, 0, 0, 1, 1, 2, 2, 3};
        integerArrayArray[1] = integerArray;
        integerArray = new Integer[]{-2, -2, -1, -1, -1, 0, 0, 1, 1, 1, 1, 2, 2, 3};
        integerArrayArray[2] = integerArray;
        Integer[][] heightArrays = integerArrayArray;
        Object[] heights = heightArrays[context.method_33654().method_43048(((Object[])heightArrays).length)];
        ArrayList<class_2338> positions = new ArrayList<class_2338>();
        block1: for (int i = 0; i < 33; ++i) {
            int it;
            Integer n;
            if (i == 32) {
                return false;
            }
            Object[] objectArray = heights;
            boolean bl = 0 <= i ? i < objectArray.length : false;
            if (bl) {
                n = objectArray[i];
            } else {
                it = i;
                boolean bl2 = false;
                n = ((Number)ArraysKt.last((Object[])heights)).intValue();
            }
            int height = ((Number)n).intValue();
            it = RangesKt.coerceAtLeast((int)Math.abs(height), (int)1);
            for (int unused = 0; unused < it; ++unused) {
                if (!world.method_8320((class_2338)pos).method_26215()) break block1;
                positions.add(pos.method_10062());
                pos.method_10100(0, (int)Math.signum((double)height), 0);
            }
            pos.method_10100(((class_2382)direction.getFirst()).method_10263(), 0, ((class_2382)direction.getFirst()).method_10260());
        }
        if (positions.size() < 5) {
            return false;
        }
        class_2338 lastPos = (class_2338)CollectionsKt.first((List)positions);
        int rot = ((Number)direction.getSecond()).intValue();
        int counterRot = (((Number)direction.getSecond()).intValue() + 4) % 8;
        class_5819 random = context.method_33654();
        Iterator iterator = positions.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            Object e = iterator2.next();
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            class_2338 position = (class_2338)e;
            Intrinsics.checkNotNull((Object)world);
            class_1936 class_19362 = (class_1936)world;
            class_2680 class_26802 = ModBlocksAndItems.INSTANCE.getSPIDER_SILK().method_9564();
            Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getDefaultState(...)");
            SpiderSilkPillarKt.placeIfPossible(class_19362, position, class_26802);
            if (position.method_10264() < lastPos.method_10264()) {
                class_1936 class_19363 = (class_1936)world;
                class_2338 class_23382 = lastPos.method_10074();
                Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"down(...)");
                Intrinsics.checkNotNull((Object)random);
                Object object = ((class_2680)SpiderSilkPillarKt.getRandomCornerWeb(random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf(rot))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)FancyCornerCobwebBlock.Type.TOP));
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
                SpiderSilkPillarKt.placeIfPossible(class_19363, class_23382, (class_2680)object);
                class_1936 class_19364 = (class_1936)world;
                class_2338 class_23383 = position.method_10084();
                Intrinsics.checkNotNullExpressionValue((Object)class_23383, (String)"up(...)");
                Object object2 = ((class_2680)SpiderSilkPillarKt.getRandomCornerWeb(random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf(counterRot))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)FancyCornerCobwebBlock.Type.BOTTOM));
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"with(...)");
                SpiderSilkPillarKt.placeIfPossible(class_19364, class_23383, (class_2680)object2);
            } else if (position.method_10264() > lastPos.method_10264()) {
                class_1936 class_19365 = (class_1936)world;
                class_2338 class_23384 = position.method_10074();
                Intrinsics.checkNotNullExpressionValue((Object)class_23384, (String)"down(...)");
                Intrinsics.checkNotNull((Object)random);
                Object object = ((class_2680)SpiderSilkPillarKt.getRandomCornerWeb(random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf(counterRot))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)FancyCornerCobwebBlock.Type.TOP));
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
                SpiderSilkPillarKt.placeIfPossible(class_19365, class_23384, (class_2680)object);
                class_1936 class_19366 = (class_1936)world;
                class_2338 class_23385 = lastPos.method_10084();
                Intrinsics.checkNotNullExpressionValue((Object)class_23385, (String)"up(...)");
                Object object3 = ((class_2680)SpiderSilkPillarKt.getRandomCornerWeb(random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf(rot))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)FancyCornerCobwebBlock.Type.BOTTOM));
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"with(...)");
                SpiderSilkPillarKt.placeIfPossible(class_19366, class_23385, (class_2680)object3);
            }
            lastPos = position;
        }
        return true;
    }
}

