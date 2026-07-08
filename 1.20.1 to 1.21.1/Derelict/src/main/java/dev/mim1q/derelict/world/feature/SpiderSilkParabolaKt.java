/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  net.minecraft.class_2382
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.world.feature;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import net.minecraft.class_2382;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"&\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"", "SEARCH_RANGE", "I", "", "Lkotlin/Pair;", "Lnet/minecraft/class_2382;", "POSSIBLE_DIRECTIONS", "[Lkotlin/Pair;", "derelict"})
public final class SpiderSilkParabolaKt {
    private static final int SEARCH_RANGE = 32;
    @NotNull
    private static final Pair<class_2382, Integer>[] POSSIBLE_DIRECTIONS;

    public static final /* synthetic */ Pair[] access$getPOSSIBLE_DIRECTIONS$p() {
        return POSSIBLE_DIRECTIONS;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)new class_2382(1, 0, 0), (Object)6), TuplesKt.to((Object)new class_2382(1, 0, 1), (Object)7), TuplesKt.to((Object)new class_2382(0, 0, 1), (Object)0), TuplesKt.to((Object)new class_2382(-1, 0, 1), (Object)1), TuplesKt.to((Object)new class_2382(-1, 0, 0), (Object)2), TuplesKt.to((Object)new class_2382(-1, 0, -1), (Object)3), TuplesKt.to((Object)new class_2382(0, 0, -1), (Object)4), TuplesKt.to((Object)new class_2382(1, 0, -1), (Object)5)};
        POSSIBLE_DIRECTIONS = pairArray;
    }
}

