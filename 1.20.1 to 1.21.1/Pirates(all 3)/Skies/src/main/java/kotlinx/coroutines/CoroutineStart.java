/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JE\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ^\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00022'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"Lkotlinx/coroutines/CoroutineStart;", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "completion", "", "invoke", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public final class CoroutineStart
extends Enum<CoroutineStart> {
    public static final /* enum */ CoroutineStart DEFAULT = new CoroutineStart();
    public static final /* enum */ CoroutineStart LAZY = new CoroutineStart();
    @ExperimentalCoroutinesApi
    public static final /* enum */ CoroutineStart ATOMIC = new CoroutineStart();
    public static final /* enum */ CoroutineStart UNDISPATCHED = new CoroutineStart();
    private static final /* synthetic */ CoroutineStart[] $VALUES;

    @InternalCoroutinesApi
    public final <T> void invoke(@NotNull Function1<? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> completion) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                CancellableKt.startCoroutineCancellable(block, completion);
                break;
            }
            case 2: {
                ContinuationKt.startCoroutine(block, completion);
                break;
            }
            case 3: {
                UndispatchedKt.startCoroutineUndispatched(block, completion);
                break;
            }
            case 4: {
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block, R receiver, @NotNull Continuation<? super T> completion) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                CancellableKt.startCoroutineCancellable$default(block, receiver, completion, null, 4, null);
                break;
            }
            case 2: {
                ContinuationKt.startCoroutine(block, receiver, completion);
                break;
            }
            case 3: {
                UndispatchedKt.startCoroutineUndispatched(block, receiver, completion);
                break;
            }
            case 4: {
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[])$VALUES.clone();
    }

    public static CoroutineStart valueOf(String value) {
        return Enum.valueOf(CoroutineStart.class, value);
    }

    static {
        $VALUES = coroutineStartArray = new CoroutineStart[]{CoroutineStart.DEFAULT, CoroutineStart.LAZY, CoroutineStart.ATOMIC, CoroutineStart.UNDISPATCHED};
    }

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[CoroutineStart.values().length];
            try {
                nArray[CoroutineStart.DEFAULT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CoroutineStart.ATOMIC.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CoroutineStart.LAZY.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

