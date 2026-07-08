/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_156
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.world.feature;

import dev.mim1q.derelict.block.cobweb.FancyCornerCobwebBlock;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.world.feature.SpiderSilkPillarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_156;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010JA\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ?\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006$"}, d2={"Ldev/mim1q/derelict/world/feature/SilkPlacer;", "", "<init>", "()V", "Lnet/minecraft/class_1936;", "world", "Lnet/minecraft/class_5819;", "random", "Lkotlin/Function2;", "Lnet/minecraft/class_2338$class_2339;", "", "", "positionSetter", "rotation", "", "generate", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_5819;Lkotlin/jvm/functions/Function2;I)Z", "Lnet/minecraft/class_2338;", "pos", "up", "Lkotlin/Pair;", "Lnet/minecraft/class_2382;", "dir", "tryGenerateConnection", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_5819;Lnet/minecraft/class_2338;ZLkotlin/Pair;)Z", "setPositionsAndValidate", "(Lnet/minecraft/class_1936;Lkotlin/jvm/functions/Function2;)Ljava/lang/Integer;", "mutableOrigin", "sideOffset", "generateConnection", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_5819;Lnet/minecraft/class_2338$class_2339;Lnet/minecraft/class_2382;IZ)V", "", "positionStack", "[Lnet/minecraft/class_2338$class_2339;", "getPositionStack", "()[Lnet/minecraft/class_2338$class_2339;", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderSilkPillar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderSilkPillar.kt\ndev/mim1q/derelict/world/feature/SilkPlacer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,255:1\n1863#2,2:256\n1863#2,2:258\n*S KotlinDebug\n*F\n+ 1 SpiderSilkPillar.kt\ndev/mim1q/derelict/world/feature/SilkPlacer\n*L\n122#1:256,2\n136#1:258,2\n*E\n"})
final class SilkPlacer {
    @NotNull
    private final class_2338.class_2339[] positionStack;

    public SilkPlacer() {
        int n = 0;
        class_2338.class_2339[] class_2339Array = new class_2338.class_2339[64];
        SilkPlacer silkPlacer = this;
        while (n < 64) {
            int n2 = n++;
            Intrinsics.checkNotNullExpressionValue((Object)class_2338.field_10980.method_25503(), (String)"mutableCopy(...)");
        }
        silkPlacer.positionStack = class_2339Array;
    }

    @NotNull
    public final class_2338.class_2339[] getPositionStack() {
        return this.positionStack;
    }

    public final boolean generate(@NotNull class_1936 world, @NotNull class_5819 random, @NotNull Function2<? super class_2338.class_2339, ? super Integer, Unit> positionSetter, int rotation) {
        int n;
        int i;
        Pair it;
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter(positionSetter, (String)"positionSetter");
        Integer n2 = this.setPositionsAndValidate(world, positionSetter);
        if (n2 == null) {
            return false;
        }
        int height = n2;
        int lastX = this.positionStack[0].method_10263();
        int lastZ = this.positionStack[0].method_10260();
        for (int i2 = 0; i2 < height; ++i2) {
            class_2338.class_2339 pos = this.positionStack[i2];
            class_2338 class_23382 = (class_2338)pos;
            class_2680 class_26802 = ModBlocksAndItems.INSTANCE.getSPIDER_SILK().method_9564();
            Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getDefaultState(...)");
            SpiderSilkPillarKt.placeIfPossible(world, class_23382, class_26802);
            if (pos.method_10263() == lastX && pos.method_10260() == lastZ) continue;
            class_2338 class_23383 = pos.method_10084();
            Intrinsics.checkNotNullExpressionValue((Object)class_23383, (String)"up(...)");
            Object object = ((class_2680)SpiderSilkPillarKt.getRandomCornerWeb(random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf((rotation + 4) % 8))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)FancyCornerCobwebBlock.Type.BOTTOM));
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
            SpiderSilkPillarKt.placeIfPossible(world, class_23383, (class_2680)object);
            class_2338 class_23384 = new class_2338(lastX, pos.method_10264(), lastZ);
            Object object2 = ((class_2680)SpiderSilkPillarKt.getRandomCornerWeb(random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf(rotation))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)FancyCornerCobwebBlock.Type.TOP));
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"with(...)");
            SpiderSilkPillarKt.placeIfPossible(world, class_23384, (class_2680)object2);
            lastX = pos.method_10263();
            lastZ = pos.method_10260();
        }
        double chance = 0.0;
        chance = 0.8;
        List list = class_156.method_43253((Object[])SpiderSilkPillarKt.access$getPOSSIBLE_DIRECTIONS$p(), (class_5819)random);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"copyShuffled(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        block1: for (Object element$iv : $this$forEach$iv) {
            it = (Pair)element$iv;
            boolean bl = false;
            i = 3;
            n = Math.min(8, height - 1);
            if (i > n) continue;
            while (true) {
                if (random.method_43058() < chance) {
                    class_2338 class_23385 = (class_2338)this.positionStack[i];
                    Intrinsics.checkNotNull((Object)it);
                    if (this.tryGenerateConnection(world, random, class_23385, true, (Pair<? extends class_2382, Integer>)it)) {
                        chance -= 0.2;
                        continue block1;
                    }
                }
                if (i == n) continue block1;
                ++i;
            }
        }
        chance = 0.8;
        List list2 = class_156.method_43253((Object[])SpiderSilkPillarKt.access$getPOSSIBLE_DIRECTIONS$p(), (class_5819)random);
        Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"copyShuffled(...)");
        $this$forEach$iv = list2;
        $i$f$forEach = false;
        block3: for (Object element$iv : $this$forEach$iv) {
            it = (Pair)element$iv;
            boolean bl = false;
            i = 3;
            n = Math.min(8, height - 1);
            if (i > n) continue;
            while (true) {
                if (random.method_43058() < chance) {
                    class_2338 class_23386 = (class_2338)this.positionStack[height - i];
                    Intrinsics.checkNotNull((Object)it);
                    if (this.tryGenerateConnection(world, random, class_23386, false, (Pair<? extends class_2382, Integer>)it)) {
                        chance -= 0.2;
                        continue block3;
                    }
                }
                if (i == n) continue block3;
                ++i;
            }
        }
        return true;
    }

    public final boolean tryGenerateConnection(@NotNull class_1936 world, @NotNull class_5819 random, @NotNull class_2338 pos, boolean up, @NotNull Pair<? extends class_2382, Integer> dir) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter(dir, (String)"dir");
        class_2382 sideOffset = (class_2382)dir.getFirst();
        class_2382 offset = up ? new class_2382(sideOffset.method_10263() * 4, 4, sideOffset.method_10260() * 4) : new class_2382(sideOffset.method_10263() * 4, -4, sideOffset.method_10260() * 4);
        class_2338 checkPos = pos.method_10081(offset);
        if (up) {
            if (world.method_8320(checkPos).method_45474() && world.method_8320(checkPos.method_10084()).method_26206((class_1922)world, checkPos, class_2350.field_11033)) {
                class_2338.class_2339 class_23392 = checkPos.method_25503();
                Intrinsics.checkNotNullExpressionValue((Object)class_23392, (String)"mutableCopy(...)");
                this.generateConnection(world, random, class_23392, sideOffset, ((Number)dir.getSecond()).intValue(), true);
                return true;
            }
        } else if (world.method_8320(checkPos).method_45474() && world.method_8320(checkPos.method_10074()).method_26206((class_1922)world, checkPos, class_2350.field_11036)) {
            class_2338.class_2339 class_23393 = checkPos.method_25503();
            Intrinsics.checkNotNullExpressionValue((Object)class_23393, (String)"mutableCopy(...)");
            this.generateConnection(world, random, class_23393, sideOffset, ((Number)dir.getSecond()).intValue(), false);
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer setPositionsAndValidate(@NotNull class_1936 world, @NotNull Function2<? super class_2338.class_2339, ? super Integer, Unit> positionSetter) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter(positionSetter, (String)"positionSetter");
        for (int i = 0; i < 64; ++i) {
            positionSetter.invoke((Object)this.positionStack[i], (Object)i);
            class_2338.class_2339 currentPos = this.positionStack[i];
            if (!world.method_8320((class_2338)currentPos).method_45474() || !world.method_8320(currentPos.method_10074()).method_26206((class_1922)world, (class_2338)currentPos, class_2350.field_11033)) continue;
            return i >= 12 ? Integer.valueOf(i + 1) : null;
        }
        return null;
    }

    private final void generateConnection(class_1936 world, class_5819 random, class_2338.class_2339 mutableOrigin, class_2382 sideOffset, int rotation, boolean up) {
        class_2680 mainBlock = ModBlocksAndItems.INSTANCE.getSPIDER_SILK().method_9564();
        Function0 cornerBlock0 = () -> SilkPlacer.generateConnection$lambda$2(random, rotation, up);
        Function0 cornerBlock1 = () -> SilkPlacer.generateConnection$lambda$3(random, rotation, up);
        class_2382 negativeOffset = sideOffset.method_35862(-1);
        class_2382 verticalOffset = new class_2382(0, up ? -1 : 1, 0);
        class_2338 class_23382 = (class_2338)mutableOrigin;
        Object object = cornerBlock1.invoke();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"invoke(...)");
        SpiderSilkPillarKt.placeIfPossible(world, class_23382, (class_2680)object);
        mutableOrigin.method_30927(negativeOffset);
        class_2338 class_23383 = (class_2338)mutableOrigin;
        Intrinsics.checkNotNull((Object)mainBlock);
        SpiderSilkPillarKt.placeIfPossible(world, class_23383, mainBlock);
        mutableOrigin.method_30927(negativeOffset);
        class_2338 class_23384 = (class_2338)mutableOrigin;
        Object object2 = cornerBlock0.invoke();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"invoke(...)");
        SpiderSilkPillarKt.placeIfPossible(world, class_23384, (class_2680)object2);
        mutableOrigin.method_30927(sideOffset);
        mutableOrigin.method_30927(verticalOffset);
        class_2338 class_23385 = (class_2338)mutableOrigin;
        Object object3 = cornerBlock1.invoke();
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"invoke(...)");
        SpiderSilkPillarKt.placeIfPossible(world, class_23385, (class_2680)object3);
        mutableOrigin.method_30927(negativeOffset);
        SpiderSilkPillarKt.placeIfPossible(world, (class_2338)mutableOrigin, mainBlock);
        mutableOrigin.method_30927(negativeOffset);
        class_2338 class_23386 = (class_2338)mutableOrigin;
        Object object4 = cornerBlock0.invoke();
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"invoke(...)");
        SpiderSilkPillarKt.placeIfPossible(world, class_23386, (class_2680)object4);
        mutableOrigin.method_30927(sideOffset);
        mutableOrigin.method_30927(verticalOffset);
        class_2338 class_23387 = (class_2338)mutableOrigin;
        Object object5 = cornerBlock1.invoke();
        Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"invoke(...)");
        SpiderSilkPillarKt.placeIfPossible(world, class_23387, (class_2680)object5);
        mutableOrigin.method_30927(negativeOffset);
        SpiderSilkPillarKt.placeIfPossible(world, (class_2338)mutableOrigin, mainBlock);
        mutableOrigin.method_30927(verticalOffset);
        SpiderSilkPillarKt.placeIfPossible(world, (class_2338)mutableOrigin, mainBlock);
        mutableOrigin.method_30927(verticalOffset);
        class_2338 class_23388 = (class_2338)mutableOrigin;
        Object object6 = cornerBlock1.invoke();
        Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"invoke(...)");
        SpiderSilkPillarKt.placeIfPossible(world, class_23388, (class_2680)object6);
    }

    private static final class_2680 generateConnection$lambda$2(class_5819 $random, int $rotation, boolean $up) {
        Intrinsics.checkNotNullParameter((Object)$random, (String)"$random");
        return (class_2680)((class_2680)SpiderSilkPillarKt.getRandomCornerWeb($random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf($rotation))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)($up ? FancyCornerCobwebBlock.Type.BOTTOM : FancyCornerCobwebBlock.Type.TOP)));
    }

    private static final class_2680 generateConnection$lambda$3(class_5819 $random, int $rotation, boolean $up) {
        Intrinsics.checkNotNullParameter((Object)$random, (String)"$random");
        return (class_2680)((class_2680)SpiderSilkPillarKt.getRandomCornerWeb($random).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getROTATION(), (Comparable)Integer.valueOf(($rotation + 4) % 8))).method_11657((class_2769)FancyCornerCobwebBlock.Companion.getTYPE(), (Comparable)((Object)($up ? FancyCornerCobwebBlock.Type.TOP : FancyCornerCobwebBlock.Type.BOTTOM)));
    }
}

