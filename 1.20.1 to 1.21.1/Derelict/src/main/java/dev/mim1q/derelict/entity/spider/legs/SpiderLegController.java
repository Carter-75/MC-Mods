/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin._Assertions
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity.spider.legs;

import dev.mim1q.derelict.entity.spider.legs.SpiderLegIKSolver;
import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bBo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012B\u0010\u000b\u001a\"\u0012\u001e\b\u0001\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\t0\b\"\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\t\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "", "Lnet/minecraft/class_1309;", "entity", "Lkotlin/Function0;", "", "upperLimbLength", "lowerLimbLength", "", "Lkotlin/Pair;", "Lnet/minecraft/class_243;", "offsetsAndTargets", "<init>", "(Lnet/minecraft/class_1309;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;[Lkotlin/Pair;)V", "", "tick", "()V", "", "index", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "getIk", "(I)Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "Lnet/minecraft/class_1309;", "Lkotlin/jvm/functions/Function0;", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController$SingleLegController;", "legs", "[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController$SingleLegController;", "SingleLegController", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderLegController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderLegController.kt\ndev/mim1q/derelict/entity/spider/legs/SpiderLegController\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,118:1\n11192#2:119\n11303#2,4:120\n13411#2,3:126\n37#3,2:124\n*S KotlinDebug\n*F\n+ 1 SpiderLegController.kt\ndev/mim1q/derelict/entity/spider/legs/SpiderLegController\n*L\n21#1:119\n21#1:120,4\n26#1:126,3\n23#1:124,2\n*E\n"})
public final class SpiderLegController {
    @NotNull
    private final class_1309 entity;
    @NotNull
    private final Function0<Float> upperLimbLength;
    @NotNull
    private final Function0<Float> lowerLimbLength;
    @NotNull
    private final SingleLegController[] legs;

    /*
     * WARNING - void declaration
     */
    public SpiderLegController(@NotNull class_1309 entity, @NotNull Function0<Float> upperLimbLength, @NotNull Function0<Float> lowerLimbLength, Pair<? extends Function0<? extends class_243>, ? extends Function0<? extends class_243>> ... offsetsAndTargets) {
        void $this$toTypedArray$iv;
        void $this$mapIndexedTo$iv$iv;
        Collection $this$mapIndexed$iv;
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter(upperLimbLength, (String)"upperLimbLength");
        Intrinsics.checkNotNullParameter(lowerLimbLength, (String)"lowerLimbLength");
        Intrinsics.checkNotNullParameter(offsetsAndTargets, (String)"offsetsAndTargets");
        this.entity = entity;
        this.upperLimbLength = upperLimbLength;
        this.lowerLimbLength = lowerLimbLength;
        boolean bl2 = bl = offsetsAndTargets.length == 8;
        if (_Assertions.ENABLED && !bl) {
            String string = "Assertion failed";
            throw new AssertionError((Object)string);
        }
        Pair<? extends Function0<? extends class_243>, ? extends Function0<? extends class_243>>[] pairArray = offsetsAndTargets;
        SpiderLegController spiderLegController = this;
        boolean $i$f$mapIndexed = false;
        void var7_10 = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(((void)$this$mapIndexed$iv).length);
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (void item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void index;
            void it;
            int n = index$iv$iv++;
            void var14_17 = item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(new SingleLegController((Function0<? extends class_243>)((Function0)it.getFirst()), (Function0<? extends class_243>)((Function0)it.getSecond()), index >= 4));
        }
        $this$mapIndexed$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        void thisCollection$iv = $this$toTypedArray$iv;
        spiderLegController.legs = thisCollection$iv.toArray(new SingleLegController[0]);
    }

    /*
     * WARNING - void declaration
     */
    public final void tick() {
        SingleLegController[] $this$forEachIndexed$iv = this.legs;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (SingleLegController item$iv : $this$forEachIndexed$iv) {
            void leg;
            int n = index$iv++;
            SingleLegController singleLegController = item$iv;
            int index = n;
            boolean bl = false;
            int offset = index % 2 == 0 ^ index >= 4 ? 6 : 0;
            boolean isTimeToMove = this.entity.field_6012 % 12 == offset + index % 2 * 2;
            leg.step(isTimeToMove || this.entity.field_6012 == 1);
        }
    }

    @NotNull
    public final SpiderLegIKSolver getIk(int index) {
        return this.legs[index].getIkSolver();
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R$\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00102\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b1\u0010!\u00a8\u00063"}, d2={"Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController$SingleLegController;", "", "Lkotlin/Function0;", "Lnet/minecraft/class_243;", "offset", "target", "", "right", "<init>", "(Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "shouldMove", "", "step", "(Z)V", "base", "", "findLegY", "(Lnet/minecraft/class_243;)D", "Lkotlin/jvm/functions/Function0;", "getOffset", "()Lkotlin/jvm/functions/Function0;", "getTarget", "Z", "getRight", "()Z", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "ikSolver", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "getIkSolver", "()Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "prevTargetPos", "Lnet/minecraft/class_243;", "getPrevTargetPos", "()Lnet/minecraft/class_243;", "setPrevTargetPos", "(Lnet/minecraft/class_243;)V", "currentTargetPos", "getCurrentTargetPos", "setCurrentTargetPos", "nextTargetPos", "getNextTargetPos", "setNextTargetPos", "", "targetChangeTicks", "I", "getTargetChangeTicks", "()I", "setTargetChangeTicks", "(I)V", "getCloserTarget", "closerTarget", "derelict"})
    private final class SingleLegController {
        @NotNull
        private final Function0<class_243> offset;
        @NotNull
        private final Function0<class_243> target;
        private final boolean right;
        @NotNull
        private final SpiderLegIKSolver ikSolver;
        @NotNull
        private class_243 prevTargetPos;
        @NotNull
        private class_243 currentTargetPos;
        @Nullable
        private class_243 nextTargetPos;
        private int targetChangeTicks;

        public SingleLegController(@NotNull Function0<? extends class_243> offset, Function0<? extends class_243> target, boolean right) {
            Intrinsics.checkNotNullParameter(offset, (String)"offset");
            Intrinsics.checkNotNullParameter(target, (String)"target");
            this.offset = offset;
            this.target = target;
            this.right = right;
            this.ikSolver = new SpiderLegIKSolver((Function0<Float>)SpiderLegController.this.upperLimbLength, (Function0<Float>)SpiderLegController.this.lowerLimbLength);
            class_243 class_2432 = SpiderLegController.this.entity.method_19538();
            Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getPos(...)");
            this.prevTargetPos = class_2432;
            class_243 class_2433 = SpiderLegController.this.entity.method_19538();
            Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getPos(...)");
            this.currentTargetPos = class_2433;
            this.nextTargetPos = SpiderLegController.this.entity.method_19538();
        }

        @NotNull
        public final Function0<class_243> getOffset() {
            return this.offset;
        }

        @NotNull
        public final Function0<class_243> getTarget() {
            return this.target;
        }

        public final boolean getRight() {
            return this.right;
        }

        @NotNull
        public final SpiderLegIKSolver getIkSolver() {
            return this.ikSolver;
        }

        @NotNull
        public final class_243 getPrevTargetPos() {
            return this.prevTargetPos;
        }

        public final void setPrevTargetPos(@NotNull class_243 class_2432) {
            Intrinsics.checkNotNullParameter((Object)class_2432, (String)"<set-?>");
            this.prevTargetPos = class_2432;
        }

        @NotNull
        public final class_243 getCurrentTargetPos() {
            return this.currentTargetPos;
        }

        public final void setCurrentTargetPos(@NotNull class_243 class_2432) {
            Intrinsics.checkNotNullParameter((Object)class_2432, (String)"<set-?>");
            this.currentTargetPos = class_2432;
        }

        @Nullable
        public final class_243 getNextTargetPos() {
            return this.nextTargetPos;
        }

        public final void setNextTargetPos(@Nullable class_243 class_2432) {
            this.nextTargetPos = class_2432;
        }

        public final int getTargetChangeTicks() {
            return this.targetChangeTicks;
        }

        public final void setTargetChangeTicks(int n) {
            this.targetChangeTicks = n;
        }

        @NotNull
        public final class_243 getCloserTarget() {
            class_243 calculatedTarget = (class_243)this.target.invoke();
            double length = calculatedTarget.method_37267();
            boolean bl = false;
            return new class_243(calculatedTarget.field_1352 / length * (length - 0.2), calculatedTarget.field_1351, calculatedTarget.field_1350 / length * (length - 0.1));
        }

        public final void step(boolean shouldMove) {
            if (shouldMove) {
                this.prevTargetPos = this.currentTargetPos;
                class_243 velocity = new class_243(SpiderLegController.this.entity.method_23317() - ((SpiderLegController)SpiderLegController.this).entity.field_6014, SpiderLegController.this.entity.method_23318() - ((SpiderLegController)SpiderLegController.this).entity.field_6036, SpiderLegController.this.entity.method_23321() - ((SpiderLegController)SpiderLegController.this).entity.field_5969).method_1029();
                class_243 class_2432 = MathExtensionsKt.getLocallyOffsetPos((class_1297)SpiderLegController.this.entity, this.getCloserTarget()).method_1019(velocity);
                Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"add(...)");
                double posY = this.findLegY(class_2432);
                this.nextTargetPos = MathExtensionsKt.getLocallyOffsetPos((class_1297)SpiderLegController.this.entity, (class_243)this.target.invoke()).method_1019(velocity).method_38499(class_2350.class_2351.field_11052, posY);
            }
            double transitionTime = 6.0;
            if (this.nextTargetPos != null) {
                if (this.currentTargetPos.method_1025(this.nextTargetPos) > 0.1) {
                    this.currentTargetPos = this.prevTargetPos.method_35590(this.nextTargetPos, (double)this.targetChangeTicks / transitionTime).method_1031(0.0, 0.5 * (Math.sin(((double)this.targetChangeTicks - transitionTime / 4.0) * (double)MathUtilsKt.getTWO_PI() / transitionTime) + 1.0), 0.0);
                }
                int n = this.targetChangeTicks;
                this.targetChangeTicks = n + 1;
                if ((double)this.targetChangeTicks > transitionTime) {
                    this.nextTargetPos = null;
                }
            } else {
                this.targetChangeTicks = 0;
            }
            this.ikSolver.convertToLocalAndSolve((class_1297)SpiderLegController.this.entity, (class_243)this.offset.invoke(), this.currentTargetPos, true, 5.0);
        }

        private final double findLegY(class_243 base) {
            for (int i = 1; -4 < i; --i) {
                class_2338 pos = class_2338.method_49638((class_2374)((class_2374)base)).method_10086(i);
                class_2680 block = SpiderLegController.this.entity.method_37908().method_8320(pos);
                class_265 shape = block.method_26220((class_1922)SpiderLegController.this.entity.method_37908(), pos);
                if (shape.method_1110()) continue;
                return (double)pos.method_10264() + shape.method_1105(class_2350.class_2351.field_11052);
            }
            return base.field_1351;
        }
    }
}

