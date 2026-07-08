/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1352
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.goal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1352;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\r0\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR/\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR/\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\r0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001a\u00a8\u0006\u001d"}, d2={"Ldev/mim1q/derelict/entity/goal/TickingGoal;", "Lnet/minecraft/class_1352;", "", "length", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ticks", "", "onTick", "Lkotlin/Function0;", "onStart", "onStop", "", "startPredicate", "shouldContinuePredicate", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "canStart", "()Z", "start", "()V", "stop", "shouldContinue", "tick", "shouldRunEveryTick", "I", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "derelict"})
public class TickingGoal
extends class_1352 {
    private final int length;
    @NotNull
    private final Function1<Integer, Unit> onTick;
    @NotNull
    private final Function0<Unit> onStart;
    @NotNull
    private final Function0<Unit> onStop;
    @NotNull
    private final Function0<Boolean> startPredicate;
    @NotNull
    private final Function1<Integer, Boolean> shouldContinuePredicate;
    private int ticks;

    public TickingGoal(int length, @NotNull Function1<? super Integer, Unit> onTick, @NotNull Function0<Unit> onStart, @NotNull Function0<Unit> onStop, @NotNull Function0<Boolean> startPredicate, @NotNull Function1<? super Integer, Boolean> shouldContinuePredicate) {
        Intrinsics.checkNotNullParameter(onTick, (String)"onTick");
        Intrinsics.checkNotNullParameter(onStart, (String)"onStart");
        Intrinsics.checkNotNullParameter(onStop, (String)"onStop");
        Intrinsics.checkNotNullParameter(startPredicate, (String)"startPredicate");
        Intrinsics.checkNotNullParameter(shouldContinuePredicate, (String)"shouldContinuePredicate");
        this.length = length;
        this.onTick = onTick;
        this.onStart = onStart;
        this.onStop = onStop;
        this.startPredicate = startPredicate;
        this.shouldContinuePredicate = shouldContinuePredicate;
    }

    public /* synthetic */ TickingGoal(int n, Function1 function1, Function0 function0, Function0 function02, Function0 function03, Function1 function12, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 100;
        }
        if ((n2 & 2) != 0) {
            function1 = TickingGoal::_init_$lambda$0;
        }
        if ((n2 & 4) != 0) {
            function0 = TickingGoal::_init_$lambda$1;
        }
        if ((n2 & 8) != 0) {
            function02 = TickingGoal::_init_$lambda$2;
        }
        if ((n2 & 0x10) != 0) {
            function03 = TickingGoal::_init_$lambda$3;
        }
        if ((n2 & 0x20) != 0) {
            function12 = TickingGoal::_init_$lambda$4;
        }
        this(n, (Function1<? super Integer, Unit>)function1, (Function0<Unit>)function0, (Function0<Unit>)function02, (Function0<Boolean>)function03, (Function1<? super Integer, Boolean>)function12);
    }

    public boolean method_6264() {
        return (Boolean)this.startPredicate.invoke();
    }

    public void method_6269() {
        this.ticks = 0;
        this.onStart.invoke();
    }

    public void method_6270() {
        this.ticks = 0;
        this.onStop.invoke();
    }

    public boolean method_6266() {
        return this.ticks < this.length && (Boolean)this.shouldContinuePredicate.invoke((Object)this.ticks) != false;
    }

    public void method_6268() {
        int n = this.ticks;
        this.ticks = n + 1;
        this.onTick.invoke((Object)this.ticks);
    }

    public boolean method_38846() {
        return true;
    }

    private static final Unit _init_$lambda$0(int it) {
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1() {
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2() {
        return Unit.INSTANCE;
    }

    private static final boolean _init_$lambda$3() {
        return true;
    }

    private static final boolean _init_$lambda$4(int it) {
        return true;
    }

    public TickingGoal() {
        this(0, null, null, null, null, null, 63, null);
    }
}

