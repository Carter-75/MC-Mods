/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelSegment;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\"\u0012\"\b\u0002\u0010'\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010%j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`&\u00a2\u0006\u0004\b(\u0010)J%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000H\u0090@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\fH\u0010\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\fH\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0006\u001a\u00028\u0000H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0014J.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\fH\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006*"}, d2={"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "element", "", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "sendBroadcast$kotlinx_coroutines_core", "sendBroadcast", "shouldSendSuspend$kotlinx_coroutines_core", "()Z", "shouldSendSuspend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropLatest", "trySendDropOldest-JP2dKIU", "trySendDropOldest", "trySendImpl-Mj0NB7M", "trySendImpl", "", "capacity", "I", "isConflatedDropOldest", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
public class ConflatedBufferedChannel<E>
extends BufferedChannel<E> {
    private final int capacity;
    @NotNull
    private final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int capacity, @NotNull BufferOverflow onBufferOverflow, @Nullable Function1<? super E, Unit> onUndeliveredElement) {
        super(capacity, onUndeliveredElement);
        this.capacity = capacity;
        this.onBufferOverflow = onBufferOverflow;
        if (!(this.onBufferOverflow != BufferOverflow.SUSPEND)) {
            boolean $i$a$-require-ConflatedBufferedChannel$32 = false;
            String $i$a$-require-ConflatedBufferedChannel$32 = "This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead";
            throw new IllegalArgumentException($i$a$-require-ConflatedBufferedChannel$32.toString());
        }
        if (!(this.capacity >= 1)) {
            boolean bl = false;
            String string = "Buffered channel capacity must be at least 1, but " + this.capacity + " was specified";
            throw new IllegalArgumentException(string.toString());
        }
    }

    public /* synthetic */ ConflatedBufferedChannel(int n2, BufferOverflow bufferOverflow, Function1 function1, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            function1 = null;
        }
        this(n2, bufferOverflow, function1);
    }

    @Override
    protected boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    @Override
    @Nullable
    public Object send(E element, @NotNull Continuation<? super Unit> $completion) {
        return ConflatedBufferedChannel.send$suspendImpl(this, element, $completion);
    }

    static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> $this, E element, Continuation<? super Unit> $completion) {
        Object $this$onClosed_u2dWpGqRn0$iv = super.trySendImpl-Mj0NB7M(element, true);
        boolean bl = false;
        if ($this$onClosed_u2dWpGqRn0$iv instanceof ChannelResult.Closed) {
            Throwable it = ChannelResult.exceptionOrNull-impl($this$onClosed_u2dWpGqRn0$iv);
            boolean bl2 = false;
            Object object = $this.onUndeliveredElement;
            if (object != null && (object = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(object, element, null, 2, null)) != null) {
                Object it2 = object;
                boolean bl3 = false;
                ExceptionsKt.addSuppressed((Throwable)((Throwable)it2), (Throwable)$this.getSendException());
                throw it2;
            }
            throw $this.getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object sendBroadcast$kotlinx_coroutines_core(E element, @NotNull Continuation<? super Boolean> $completion) {
        return ConflatedBufferedChannel.sendBroadcast$suspendImpl(this, element, $completion);
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(ConflatedBufferedChannel<E> $this, E element, Continuation<? super Boolean> $completion) {
        Object $this$onSuccess_u2dWpGqRn0$iv = super.trySendImpl-Mj0NB7M(element, true);
        boolean bl = false;
        if (!($this$onSuccess_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) {
            Unit it = (Unit)$this$onSuccess_u2dWpGqRn0$iv;
            boolean bl2 = false;
            return Boxing.boxBoolean((boolean)true);
        }
        return Boxing.boxBoolean((boolean)false);
    }

    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        return this.trySendImpl-Mj0NB7M(element, false);
    }

    private final Object trySendImpl-Mj0NB7M(E element, boolean isSendOp) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? this.trySendDropLatest-Mj0NB7M(element, isSendOp) : this.trySendDropOldest-JP2dKIU(element);
    }

    private final Object trySendDropLatest-Mj0NB7M(E element, boolean isSendOp) {
        UndeliveredElementException undeliveredElementException;
        Function1 function1;
        Object result2 = super.trySend-JP2dKIU(element);
        if (ChannelResult.isSuccess-impl(result2) || ChannelResult.isClosed-impl(result2)) {
            return result2;
        }
        if (isSendOp && (function1 = this.onUndeliveredElement) != null && (undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, element, null, 2, null)) != null) {
            UndeliveredElementException it = undeliveredElementException;
            boolean bl = false;
            throw it;
        }
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    private final Object trySendDropOldest-JP2dKIU(E element) {
        Symbol waiter$iv = BufferedChannelKt.BUFFERED;
        boolean $i$f$sendImpl = false;
        ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.access$getSendSegment$FU$p().get((BufferedChannel)this);
        block8: while (true) {
            long sendersAndCloseStatusCur$iv;
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement((BufferedChannel)this);
            boolean $i$f$getSendersCounter = false;
            long s$iv = $this$sendersCounter$iv$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed$iv = BufferedChannel.access$isClosedForSend0(this, sendersAndCloseStatusCur$iv);
            long id$iv = s$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int)(s$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv && BufferedChannel.access$findSegmentSend(this, id$iv, segment$iv) == null) {
                if (!closed$iv) continue;
                boolean bl = false;
                return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
            }
            switch (BufferedChannel.access$updateCellSend(this, segment$iv, i$iv, element, s$iv, waiter$iv, closed$iv)) {
                case 0: {
                    segment$iv.cleanPrev();
                    boolean bl = false;
                    return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                }
                case 1: {
                    boolean bl = false;
                    return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                }
                case 2: {
                    void i2;
                    if (closed$iv) {
                        segment$iv.onSlotCleaned();
                        boolean bl = false;
                        return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                    }
                    Waiter waiter = waiter$iv instanceof Waiter ? (Waiter)((Object)waiter$iv) : null;
                    if (waiter != null) {
                        BufferedChannel.access$prepareSenderForSuspension(this, waiter, segment$iv, i$iv);
                    }
                    int n2 = i$iv;
                    ChannelSegment segm = segment$iv;
                    boolean bl = false;
                    this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(segm.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)i2);
                    return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                }
                case 4: {
                    if (s$iv < ((BufferedChannel)this).getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    boolean bl = false;
                    return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                }
                case 5: {
                    segment$iv.cleanPrev();
                    continue block8;
                }
                case 3: {
                    E e2 = element;
                    int n3 = i$iv;
                    ChannelSegment channelSegment = segment$iv;
                    boolean bl = false;
                    throw new IllegalStateException("unexpected".toString());
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        void $this$onClosed_u2dWpGqRn0$iv;
        Object it = this.trySend-JP2dKIU(element);
        boolean bl = false;
        Object $this$onSuccess_u2dWpGqRn0$iv = it;
        boolean bl2 = false;
        if (!($this$onSuccess_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) {
            Unit it2 = (Unit)$this$onSuccess_u2dWpGqRn0$iv;
            boolean bl3 = false;
            select.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        boolean bl4 = false;
        if ($this$onClosed_u2dWpGqRn0$iv instanceof ChannelResult.Closed) {
            Throwable it3 = ChannelResult.exceptionOrNull-impl($this$onClosed_u2dWpGqRn0$iv);
            boolean bl5 = false;
            select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
            return;
        }
        throw new IllegalStateException("unreachable".toString());
    }

    @Override
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }
}

