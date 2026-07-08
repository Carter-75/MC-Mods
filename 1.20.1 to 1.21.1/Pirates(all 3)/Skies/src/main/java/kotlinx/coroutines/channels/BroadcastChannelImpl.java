/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.BroadcastChannelKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002?@B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b=\u0010>J\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\u00122\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\"\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u00060*j\u0002`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R<\u00100\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100.j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0017\u00109\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0019\u0010<\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\f\u0012\u0004\b;\u00108\u001a\u0004\b:\u00106\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006A"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "cause", "", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "cancelImpl", "close", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "element", "", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "s", "removeSubscriber", "(Lkotlinx/coroutines/channels/ReceiveChannel;)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "capacity", "I", "getCapacity", "()I", "isClosedForSend", "()Z", "lastConflatedElement", "Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSendInternalResult", "Ljava/util/HashMap;", "", "subscribers", "Ljava/util/List;", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "()V", "value", "getValueOrNull", "getValueOrNull$annotations", "valueOrNull", "<init>", "(I)V", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
public final class BroadcastChannelImpl<E>
extends BufferedChannel<E>
implements BroadcastChannel<E> {
    private final int capacity;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private List<? extends BufferedChannel<E>> subscribers;
    @Nullable
    private Object lastConflatedElement;
    @NotNull
    private final HashMap<SelectInstance<?>, Object> onSendInternalResult;

    public BroadcastChannelImpl(int capacity) {
        super(0, null);
        this.capacity = capacity;
        if (!(this.capacity >= 1 || this.capacity == -1)) {
            boolean bl = false;
            String string = "BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + this.capacity + " was specified";
            throw new IllegalArgumentException(string.toString());
        }
        this.lock = new ReentrantLock();
        this.subscribers = CollectionsKt.emptyList();
        this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
        this.onSendInternalResult = new HashMap();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        BufferedChannel bufferedChannel;
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            BufferedChannel s;
            boolean bl = false;
            BufferedChannel bufferedChannel2 = s = this.capacity == -1 ? (BufferedChannel)new SubscriberConflated() : (BufferedChannel)new SubscriberBuffered();
            if (this.isClosedForSend() && this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                s.close(this.getCloseCause());
                ReceiveChannel receiveChannel = s;
                return receiveChannel;
            }
            if (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                s.trySend-JP2dKIU(this.getValue());
            }
            this.subscribers = CollectionsKt.plus((Collection)this.subscribers, (Object)s);
            bufferedChannel = s;
        }
        finally {
            lock.unlock();
        }
        return bufferedChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void removeSubscriber(ReceiveChannel<? extends E> s) {
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            boolean bl = false;
            Iterable iterable = this.subscribers;
            BroadcastChannelImpl broadcastChannelImpl = this;
            boolean $i$f$filter = false;
            void var9_9 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                BufferedChannel it = (BufferedChannel)element$iv$iv;
                boolean bl2 = false;
                if (!(it != s)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            broadcastChannelImpl.subscribers = (List)destination$iv$iv;
            Unit unit = Unit.INSTANCE;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object send(E var1_1, @NotNull Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof send.1)) ** GOTO lbl-1000
        var12_3 = var2_2;
        if ((var12_3.label & -2147483648) != 0) {
            var12_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ BroadcastChannelImpl<E> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.send(null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var13_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$withLock$iv = this.lock;
                $i$f$withLock = false;
                var6_8 = $this$withLock$iv;
                var6_8.lock();
                try {
                    $i$a$-withLock-BroadcastChannelImpl$send$subs$1 = false;
                    if (this.isClosedForSend()) {
                        throw this.getSendException();
                    }
                    if (this.capacity == -1) {
                        this.lastConflatedElement = element;
                    }
                    var8_11 = this.subscribers;
                }
                finally {
                    var6_8.unlock();
                }
                subs = var8_11;
                $this$forEach$iv = subs;
                $i$f$forEach = false;
                var6_8 = $this$forEach$iv.iterator();
lbl32:
                // 2 sources

                while (var6_8.hasNext()) {
                    element$iv = var6_8.next();
                    it = (BufferedChannel)element$iv;
                    $i$a$-forEach-BroadcastChannelImpl$send$2 = false;
                    $continuation.L$0 = this;
                    $continuation.L$1 = element;
                    $continuation.L$2 = var6_8;
                    $continuation.label = 1;
                    v0 = it.sendBroadcast$kotlinx_coroutines_core(element, (Continuation<Boolean>)$continuation);
                    if (v0 == var13_5) {
                        return var13_5;
                    }
                    ** GOTO lbl53
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-BroadcastChannelImpl$send$2 = false;
                var6_8 = (Iterator)$continuation.L$2;
                element = $continuation.L$1;
                this = (BroadcastChannelImpl)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl53:
                // 2 sources

                if ((success = ((Boolean)v0).booleanValue()) || !this.isClosedForSend()) ** GOTO lbl32
                throw this.getSendException();
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            boolean shouldSuspend;
            BufferedChannel it;
            block12: {
                boolean bl;
                boolean bl2 = false;
                if (this.isClosedForSend()) {
                    Object object = super.trySend-JP2dKIU(element);
                    return object;
                }
                Iterable $this$any$iv = this.subscribers;
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        it = (BufferedChannel)element$iv;
                        boolean bl3 = false;
                        if (!it.shouldSendSuspend$kotlinx_coroutines_core()) continue;
                        bl = true;
                        break block12;
                    }
                    bl = shouldSuspend = false;
                }
            }
            if (shouldSuspend) {
                Object object = ChannelResult.Companion.failure-PtdJZtk();
                return object;
            }
            if (this.capacity == -1) {
                this.lastConflatedElement = element;
            }
            Iterable $this$forEach$iv = this.subscribers;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (BufferedChannel)element$iv;
                boolean bl = false;
                it.trySend-JP2dKIU(element);
            }
            Object object = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
            return object;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            boolean bl = false;
            Object result2 = this.onSendInternalResult.remove(select);
            if (result2 != null) {
                select.selectInRegistrationPhase(result2);
                return;
            }
            Unit unit = Unit.INSTANCE;
        }
        finally {
            lock.unlock();
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(select.getContext()), null, CoroutineStart.UNDISPATCHED, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, element, select, null){
            int label;
            final /* synthetic */ BroadcastChannelImpl<E> this$0;
            final /* synthetic */ Object $element;
            final /* synthetic */ SelectInstance<?> $select;
            {
                this.this$0 = $receiver;
                this.$element = $element;
                this.$select = $select;
                super(2, $completion);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var11_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        this.label = 1;
                        v0 = this.this$0.send(this.$element, (Continuation<Unit>)((Continuation)this));
                        ** if (v0 != var11_2) goto lbl11
lbl10:
                        // 1 sources

                        return var11_2;
lbl11:
                        // 1 sources

                        ** GOTO lbl17
                    }
                    case 1: {
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl17:
                            // 2 sources

                            var3_3 = true;
                        }
                        catch (Throwable t) {
                            if (!this.this$0.isClosedForSend() || !(t instanceof ClosedSendChannelException) && this.this$0.getSendException() != t) {
                                throw t;
                            }
                            var3_3 = false;
                        }
                        success = var3_3;
                        var3_4 = BroadcastChannelImpl.access$getLock$p(this.this$0);
                        var4_6 = this.this$0;
                        var5_8 = this.$select;
                        $i$f$withLock = false;
                        var7_10 = (Lock)$this$withLock$iv;
                        var7_10.lock();
                        try {
                            $i$a$-withLock-BroadcastChannelImpl$registerSelectForSend$2$1 = false;
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                $i$a$-assert-BroadcastChannelImpl$registerSelectForSend$2$1$1 = false;
                                if (!(BroadcastChannelImpl.access$getOnSendInternalResult$p(var4_6).get(var5_8) == null)) {
                                    throw new AssertionError();
                                }
                            }
                            ((Map)BroadcastChannelImpl.access$getOnSendInternalResult$p(var4_6)).put(var5_8, success != false ? Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED());
                            Intrinsics.checkNotNull(var5_8, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                            (SelectImplementation)var5_8;
                            trySelectResult = ((SelectImplementation)var5_8).trySelectDetailed(var4_6, Unit.INSTANCE);
                            if (trySelectResult != TrySelectDetailedResult.REREGISTER) {
                                BroadcastChannelImpl.access$getOnSendInternalResult$p(var4_6).remove(var5_8);
                            }
                            var10_14 = Unit.INSTANCE;
                        }
                        finally {
                            var7_10.unlock();
                        }
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    public boolean close(@Nullable Throwable cause) {
        boolean bl;
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            boolean bl2 = false;
            Iterable $this$forEach$iv = this.subscribers;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                BufferedChannel it = (BufferedChannel)element$iv;
                boolean bl3 = false;
                it.close(cause);
            }
            $this$forEach$iv = this.subscribers;
            BroadcastChannelImpl broadcastChannelImpl = this;
            boolean $i$f$filter = false;
            Iterator iterator2 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                BufferedChannel it = (BufferedChannel)element$iv$iv;
                boolean bl4 = false;
                if (!it.hasElements$kotlinx_coroutines_core()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            broadcastChannelImpl.subscribers = (List)destination$iv$iv;
            bl = super.close(cause);
        }
        finally {
            lock.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable cause) {
        boolean bl;
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            boolean bl2 = false;
            Iterable $this$forEach$iv = this.subscribers;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                BufferedChannel it = (BufferedChannel)element$iv;
                boolean bl3 = false;
                it.cancelImpl$kotlinx_coroutines_core(cause);
            }
            this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
            bl = super.cancelImpl$kotlinx_coroutines_core(cause);
        }
        finally {
            lock.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isClosedForSend() {
        boolean bl;
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            boolean bl2 = false;
            bl = super.isClosedForSend();
        }
        finally {
            lock.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final E getValue() {
        Object object;
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            boolean bl = false;
            if (this.isClosedForSend()) {
                Throwable throwable = this.getCloseCause();
                if (throwable == null) {
                    throwable = new IllegalStateException("This broadcast channel is closed");
                }
                throw throwable;
            }
            if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                throw new IllegalStateException("No value".toString());
            }
            object = this.lastConflatedElement;
        }
        finally {
            lock.unlock();
        }
        return (E)object;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final E getValueOrNull() {
        Object object;
        ReentrantLock $this$withLock$iv = this.lock;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock$iv;
        lock.lock();
        try {
            boolean bl = false;
            object = this.isClosedForReceive() ? null : (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p() ? null : this.lastConflatedElement);
        }
        finally {
            lock.unlock();
        }
        return (E)object;
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    @Override
    @NotNull
    public String toString() {
        return (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p() ? "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; " : "") + "BROADCAST=<" + super.toString() + ">; SUBSCRIBERS=" + CollectionsKt.joinToString$default((Iterable)this.subscribers, (CharSequence)";", (CharSequence)"<", (CharSequence)">", (int)0, null, null, (int)56, null);
    }

    public static final /* synthetic */ HashMap access$getOnSendInternalResult$p(BroadcastChannelImpl $this) {
        return $this.onSendInternalResult;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "", "cause", "", "cancelImpl", "(Ljava/lang/Throwable;)Z", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    private final class SubscriberBuffered
    extends BufferedChannel<E> {
        public SubscriberBuffered() {
            super(BroadcastChannelImpl.this.getCapacity(), null, 2, null);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        public boolean cancelImpl(@Nullable Throwable cause) {
            boolean bl;
            void $this$withLock$iv;
            ReentrantLock reentrantLock = BroadcastChannelImpl.this.lock;
            BroadcastChannelImpl broadcastChannelImpl = BroadcastChannelImpl.this;
            boolean $i$f$withLock = false;
            Lock lock = (Lock)$this$withLock$iv;
            lock.lock();
            try {
                boolean bl2 = false;
                broadcastChannelImpl.removeSubscriber(this);
                bl = super.cancelImpl$kotlinx_coroutines_core(cause);
            }
            finally {
                lock.unlock();
            }
            return bl;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "", "cause", "", "cancelImpl", "(Ljava/lang/Throwable;)Z", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "kotlinx-coroutines-core"})
    private final class SubscriberConflated
    extends ConflatedBufferedChannel<E> {
        public SubscriberConflated() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        public boolean cancelImpl(@Nullable Throwable cause) {
            BroadcastChannelImpl.this.removeSubscriber(this);
            return super.cancelImpl$kotlinx_coroutines_core(cause);
        }
    }
}

