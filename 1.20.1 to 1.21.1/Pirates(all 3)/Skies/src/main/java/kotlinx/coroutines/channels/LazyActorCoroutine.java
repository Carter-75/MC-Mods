/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.channels.ActorCoroutine;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.LazyActorCoroutine;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012\u0006\u0010#\u001a\u00020\"\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$\u0012-\u0010)\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\r0&\u00a2\u0006\u0002\b(\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0017\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR,\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001c8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006,"}, d2={"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "", "onSendRegFunction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "onStart", "()V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Lkotlin/coroutines/Continuation;", "continuation", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
final class LazyActorCoroutine<E>
extends ActorCoroutine<E> {
    @NotNull
    private Continuation<? super Unit> continuation;

    public LazyActorCoroutine(@NotNull CoroutineContext parentContext, @NotNull Channel<E> channel, @NotNull Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        super(parentContext, channel, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(block, (Object)this, (Continuation)this);
    }

    @Override
    protected void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, (Continuation)this);
    }

    @Override
    @Nullable
    public Object send(E element, @NotNull Continuation<? super Unit> $completion) {
        this.start();
        Object object = super.send(element, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}), level=DeprecationLevel.ERROR)
    public boolean offer(E element) {
        this.start();
        return super.offer(element);
    }

    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        this.start();
        return super.trySend-JP2dKIU(element);
    }

    @Override
    public boolean close(@Nullable Throwable cause) {
        boolean closed = super.close(cause);
        this.start();
        return closed;
    }

    @Override
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        onSend.1 v0 = onSend.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause2Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final void onSendRegFunction(SelectInstance<?> select, Object element) {
        this.onStart();
        super.getOnSend().getRegFunc().invoke((Object)this, select, element);
    }

    public static final /* synthetic */ void access$onSendRegFunction(LazyActorCoroutine $this, SelectInstance select, Object element) {
        $this.onSendRegFunction(select, element);
    }
}

