/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0017\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0004\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'\u00a2\u0006\u0004\b\u0004\u0010\tJ!\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH&\u00a2\u0006\u0004\b\u0004\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u00a6\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u00a6@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\b8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\b8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u001f8&X\u00a6\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b#\u0010!R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001f8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010\u0005\u001a\u0004\b%\u0010!\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006("}, d2={"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "", "cancel", "()V", "", "cause", "", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "receiveOrNull", "tryReceive-PtdJZtk", "tryReceive", "isClosedForReceive", "()Z", "isClosedForReceive$annotations", "isEmpty", "isEmpty$annotations", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "getOnReceiveOrNull", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "kotlinx-coroutines-core"})
public interface ReceiveChannel<E> {
    public boolean isClosedForReceive();

    public boolean isEmpty();

    @Nullable
    public Object receive(@NotNull Continuation<? super E> var1);

    @NotNull
    public SelectClause1<E> getOnReceive();

    @Nullable
    public Object receiveCatching-JP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> var1);

    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    @NotNull
    public Object tryReceive-PtdJZtk();

    @NotNull
    public ChannelIterator<E> iterator();

    public void cancel(@Nullable CancellationException var1);

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel();

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable var1);

    @Deprecated(message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
    @Nullable
    public E poll();

    @Deprecated(message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> var1);

    @NotNull
    public SelectClause1<E> getOnReceiveOrNull();

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @DelicateCoroutinesApi
        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isEmpty$annotations() {
        }

        public static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.cancel(cancellationException);
        }

        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(ReceiveChannel $this) {
            $this.cancel(null);
        }

        public static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable throwable, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                throwable = null;
            }
            return receiveChannel.cancel(throwable);
        }

        @Deprecated(message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
        @Nullable
        public static <E> E poll(@NotNull ReceiveChannel<? extends E> $this) {
            Object result2 = $this.tryReceive-PtdJZtk();
            if (ChannelResult.isSuccess-impl(result2)) {
                return (E)ChannelResult.getOrThrow-impl(result2);
            }
            Throwable throwable = ChannelResult.exceptionOrNull-impl(result2);
            if (throwable == null) {
                return null;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(throwable);
        }

        /*
         * Unable to fully structure code
         */
        @Deprecated(message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
        @LowPriorityInOverloadResolution
        @Nullable
        public static <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> var0, @NotNull Continuation<? super E> var1_1) {
            if (!(var1_1 instanceof receiveOrNull.1)) ** GOTO lbl-1000
            var3_2 = var1_1;
            if ((var3_2.label & -2147483648) != 0) {
                var3_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(var1_1){
                    /* synthetic */ Object result;
                    int label;

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return DefaultImpls.receiveOrNull(null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.label = 1;
                    v0 = $this.receiveCatching-JP2dKIU((Continuation<ChannelResult<E>>)$continuation);
                    if (v0 == var4_4) {
                        return var4_4;
                    }
                    ** GOTO lbl20
                }
                case 1: {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = ((ChannelResult)$result).unbox-impl();
lbl20:
                    // 2 sources

                    return ChannelResult.getOrNull-impl(v0);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @NotNull
        public static <E> SelectClause1<E> getOnReceiveOrNull(@NotNull ReceiveChannel<? extends E> $this) {
            Intrinsics.checkNotNull($this, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel)$this).getOnReceiveOrNull();
        }

        @Deprecated(message="Deprecated in favor of onReceiveCatching extension", replaceWith=@ReplaceWith(expression="onReceiveCatching", imports={}), level=DeprecationLevel.ERROR)
        public static /* synthetic */ void getOnReceiveOrNull$annotations() {
        }
    }
}

