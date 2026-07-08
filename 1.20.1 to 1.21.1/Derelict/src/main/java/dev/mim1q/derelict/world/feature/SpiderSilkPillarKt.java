/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1936
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.world.feature;

import dev.mim1q.derelict.block.cobweb.FancyCobwebBlock;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1936;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/minecraft/class_1936;", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "", "placeIfPossible", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Z", "Lnet/minecraft/class_5819;", "random", "getRandomCornerWeb", "(Lnet/minecraft/class_5819;)Lnet/minecraft/class_2680;", "", "MIN_PILLAR_HEIGHT", "I", "MAX_PILLAR_HEIGHT", "SEARCH_RANGE", "", "Lkotlin/Pair;", "Lnet/minecraft/class_2382;", "POSSIBLE_DIRECTIONS", "[Lkotlin/Pair;", "derelict"})
public final class SpiderSilkPillarKt {
    private static final int MIN_PILLAR_HEIGHT = 12;
    private static final int MAX_PILLAR_HEIGHT = 64;
    private static final int SEARCH_RANGE = 32;
    @NotNull
    private static final Pair<class_2382, Integer>[] POSSIBLE_DIRECTIONS;

    public static final boolean placeIfPossible(@NotNull class_1936 $this$placeIfPossible, @NotNull class_2338 pos, @NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)$this$placeIfPossible, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        class_2680 currentState = $this$placeIfPossible.method_8320(pos);
        class_2248 block = state.method_26204();
        if (currentState.method_26215() || Intrinsics.areEqual((Object)block, (Object)((Object)ModBlocksAndItems.INSTANCE.getSPIDER_SILK())) || block instanceof FancyCobwebBlock) {
            $this$placeIfPossible.method_8652(pos, state, 2);
            return true;
        }
        return false;
    }

    @NotNull
    public static final class_2680 getRandomCornerWeb(@NotNull class_5819 random) {
        class_2680 class_26802;
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        if (random.method_43058() < 0.02) {
            class_2680 class_26803 = ModBlocksAndItems.INSTANCE.getFANCY_CORNER_COBWEB().method_9564();
            class_26802 = class_26803;
            Intrinsics.checkNotNullExpressionValue((Object)class_26803, (String)"getDefaultState(...)");
        } else {
            class_2680 class_26804 = ModBlocksAndItems.INSTANCE.getCORNER_COBWEB().method_9564();
            class_26802 = class_26804;
            Intrinsics.checkNotNullExpressionValue((Object)class_26804, (String)"getDefaultState(...)");
        }
        return class_26802;
    }

    public static final /* synthetic */ Pair[] access$getPOSSIBLE_DIRECTIONS$p() {
        return POSSIBLE_DIRECTIONS;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)new class_2382(1, 0, 0), (Object)6), TuplesKt.to((Object)new class_2382(1, 0, 1), (Object)7), TuplesKt.to((Object)new class_2382(0, 0, 1), (Object)0), TuplesKt.to((Object)new class_2382(-1, 0, 1), (Object)1), TuplesKt.to((Object)new class_2382(-1, 0, 0), (Object)2), TuplesKt.to((Object)new class_2382(-1, 0, -1), (Object)3), TuplesKt.to((Object)new class_2382(0, 0, -1), (Object)4), TuplesKt.to((Object)new class_2382(1, 0, -1), (Object)5)};
        POSSIBLE_DIRECTIONS = pairArray;
    }
}

