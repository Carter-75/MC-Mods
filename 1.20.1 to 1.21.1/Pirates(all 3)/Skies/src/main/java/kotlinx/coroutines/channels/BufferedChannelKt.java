/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.reflect.KFunction
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelSegment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000T\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u001c\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\t\u001a1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0010\"\u0004\b\u0000\u0010\nH\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001aN\u0010 \u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0018\u001a\u00028\u00002%\b\u0002\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019H\u0002\u00a2\u0006\u0004\b \u0010!\"\u0014\u0010#\u001a\u00020\"8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010&\"\u0014\u0010'\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010&\"\u001a\u0010(\u001a\u00020\"8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010*\"\u0014\u0010+\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010$\"\u0014\u0010,\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010$\"\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010.\"\u0014\u00100\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010.\"\u0014\u00101\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u0010.\"\u0014\u00102\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010$\"\u0014\u00103\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010&\"\u0014\u00104\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u0010&\"\u0014\u00105\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010.\"\u0014\u00106\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010$\"\u0014\u00107\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010$\"\u0014\u00108\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010$\"\u0014\u00109\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010$\"\u0014\u0010:\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010$\"\u0014\u0010;\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010$\"\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\"\u0014\u0010?\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010$\"\u0014\u0010@\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b@\u0010.\"\u0014\u0010A\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bA\u0010.\"\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010.\"\u0014\u0010C\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bC\u0010.\"\u0014\u0010D\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bD\u0010.\"\u0014\u0010E\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bE\u0010.\"\u0014\u0010F\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010$\"\u0014\u0010G\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010$\"\u0014\u0010H\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010.\"\u0014\u0010I\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bI\u0010.\"\u0014\u0010J\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bJ\u0010&\"\u0014\u0010K\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010$\"\u0014\u0010L\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010$\"\u0019\u0010O\u001a\u00020\u0000*\u00020\u00008\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010N\"\u0019\u0010R\u001a\u00020\u0002*\u00020\u00008\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010Q\"\u0019\u0010U\u001a\u00020\u0006*\u00020\u00008\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\"\u0019\u0010W\u001a\u00020\u0000*\u00020\u00008\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010N\u00a8\u0006X"}, d2={"", "counter", "", "pauseEB", "constructEBCompletedAndPauseFlag", "(JZ)J", "", "closeStatus", "constructSendersAndCloseStatus", "(JI)J", "E", "id", "Lkotlinx/coroutines/channels/ChannelSegment;", "prev", "createSegment", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "Lkotlin/reflect/KFunction2;", "createSegmentFunction", "()Lkotlin/reflect/KFunction;", "capacity", "initialBufferEnd", "(I)J", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "tryResume0", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "Lkotlinx/coroutines/internal/Symbol;", "BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "BUFFER_END_RENDEZVOUS", "J", "BUFFER_END_UNLIMITED", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "CLOSE_STATUS_ACTIVE", "I", "CLOSE_STATUS_CANCELLATION_STARTED", "CLOSE_STATUS_CANCELLED", "CLOSE_STATUS_CLOSED", "DONE_RCV", "EB_COMPLETED_COUNTER_MASK", "EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "FAILED", "INTERRUPTED_RCV", "INTERRUPTED_SEND", "IN_BUFFER", "NO_CLOSE_CAUSE", "NO_RECEIVE_RESULT", "", "NULL_SEGMENT", "Lkotlinx/coroutines/channels/ChannelSegment;", "POISONED", "RESULT_BUFFERED", "RESULT_CLOSED", "RESULT_FAILED", "RESULT_RENDEZVOUS", "RESULT_SUSPEND", "RESULT_SUSPEND_NO_WAITER", "RESUMING_BY_EB", "RESUMING_BY_RCV", "SEGMENT_SIZE", "SENDERS_CLOSE_STATUS_SHIFT", "SENDERS_COUNTER_MASK", "SUSPEND", "SUSPEND_NO_WAITER", "getEbCompletedCounter", "(J)J", "ebCompletedCounter", "getEbPauseExpandBuffers", "(J)Z", "ebPauseExpandBuffers", "getSendersCloseStatus", "(J)I", "sendersCloseStatus", "getSendersCounter", "sendersCounter", "kotlinx-coroutines-core"})
public final class BufferedChannelKt {
    @NotNull
    private static final ChannelSegment<Object> NULL_SEGMENT = new ChannelSegment(-1L, null, null, 0);
    @JvmField
    public static final int SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
    private static final long BUFFER_END_RENDEZVOUS = 0L;
    private static final long BUFFER_END_UNLIMITED = Long.MAX_VALUE;
    @JvmField
    @NotNull
    public static final Symbol BUFFERED = new Symbol("BUFFERED");
    @NotNull
    private static final Symbol IN_BUFFER = new Symbol("SHOULD_BUFFER");
    @NotNull
    private static final Symbol RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
    @NotNull
    private static final Symbol RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
    @NotNull
    private static final Symbol POISONED = new Symbol("POISONED");
    @NotNull
    private static final Symbol DONE_RCV = new Symbol("DONE_RCV");
    @NotNull
    private static final Symbol INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
    @NotNull
    private static final Symbol INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
    @NotNull
    private static final Symbol CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
    @NotNull
    private static final Symbol SUSPEND = new Symbol("SUSPEND");
    @NotNull
    private static final Symbol SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
    @NotNull
    private static final Symbol FAILED = new Symbol("FAILED");
    private static final int RESULT_RENDEZVOUS = 0;
    private static final int RESULT_BUFFERED = 1;
    private static final int RESULT_SUSPEND = 2;
    private static final int RESULT_SUSPEND_NO_WAITER = 3;
    private static final int RESULT_CLOSED = 4;
    private static final int RESULT_FAILED = 5;
    @NotNull
    private static final Symbol NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
    @NotNull
    private static final Symbol CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
    @NotNull
    private static final Symbol CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
    @NotNull
    private static final Symbol NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");
    private static final int CLOSE_STATUS_ACTIVE = 0;
    private static final int CLOSE_STATUS_CANCELLATION_STARTED = 1;
    private static final int CLOSE_STATUS_CLOSED = 2;
    private static final int CLOSE_STATUS_CANCELLED = 3;
    private static final int SENDERS_CLOSE_STATUS_SHIFT = 60;
    private static final long SENDERS_COUNTER_MASK = 0xFFFFFFFFFFFFFFFL;
    private static final long EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT = 0x4000000000000000L;
    private static final long EB_COMPLETED_COUNTER_MASK = 0x3FFFFFFFFFFFFFFFL;

    @NotNull
    public static final <E> KFunction<ChannelSegment<E>> createSegmentFunction() {
        return (KFunction)createSegmentFunction.1.INSTANCE;
    }

    private static final <E> ChannelSegment<E> createSegment(long id, ChannelSegment<E> prev2) {
        return new ChannelSegment<E>(id, prev2, prev2.getChannel(), 0);
    }

    private static final <T> boolean tryResume0(CancellableContinuation<? super T> $this$tryResume0, T value, Function1<? super Throwable, Unit> onCancellation) {
        boolean bl;
        Object token2 = $this$tryResume0.tryResume(value, null, onCancellation);
        boolean bl2 = false;
        if (token2 != null) {
            $this$tryResume0.completeResume(token2);
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    static /* synthetic */ boolean tryResume0$default(CancellableContinuation cancellableContinuation, Object object, Function1 function1, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            function1 = null;
        }
        return BufferedChannelKt.tryResume0(cancellableContinuation, object, (Function1<? super Throwable, Unit>)function1);
    }

    private static final long initialBufferEnd(int capacity) {
        long l2;
        switch (capacity) {
            case 0: {
                l2 = 0L;
                break;
            }
            case 0x7FFFFFFF: {
                l2 = Long.MAX_VALUE;
                break;
            }
            default: {
                l2 = capacity;
            }
        }
        return l2;
    }

    @NotNull
    public static final Symbol getCHANNEL_CLOSED() {
        return CHANNEL_CLOSED;
    }

    private static final long getSendersCounter(long $this$sendersCounter) {
        boolean $i$f$getSendersCounter = false;
        return $this$sendersCounter & 0xFFFFFFFFFFFFFFFL;
    }

    private static final int getSendersCloseStatus(long $this$sendersCloseStatus) {
        boolean $i$f$getSendersCloseStatus = false;
        return (int)($this$sendersCloseStatus >> 60);
    }

    private static final long constructSendersAndCloseStatus(long counter, int closeStatus) {
        return ((long)closeStatus << 60) + counter;
    }

    private static final long getEbCompletedCounter(long $this$ebCompletedCounter) {
        boolean $i$f$getEbCompletedCounter = false;
        return $this$ebCompletedCounter & 0x3FFFFFFFFFFFFFFFL;
    }

    private static final boolean getEbPauseExpandBuffers(long $this$ebPauseExpandBuffers) {
        boolean $i$f$getEbPauseExpandBuffers = false;
        return ($this$ebPauseExpandBuffers & 0x4000000000000000L) != 0L;
    }

    private static final long constructEBCompletedAndPauseFlag(long counter, boolean pauseEB) {
        return (pauseEB ? 0x4000000000000000L : 0L) + counter;
    }

    public static final /* synthetic */ long access$initialBufferEnd(int capacity) {
        return BufferedChannelKt.initialBufferEnd(capacity);
    }

    public static final /* synthetic */ ChannelSegment access$getNULL_SEGMENT$p() {
        return NULL_SEGMENT;
    }

    public static final /* synthetic */ Symbol access$getNO_CLOSE_CAUSE$p() {
        return NO_CLOSE_CAUSE;
    }

    public static final /* synthetic */ Symbol access$getINTERRUPTED_SEND$p() {
        return INTERRUPTED_SEND;
    }

    public static final /* synthetic */ Symbol access$getDONE_RCV$p() {
        return DONE_RCV;
    }

    public static final /* synthetic */ Symbol access$getINTERRUPTED_RCV$p() {
        return INTERRUPTED_RCV;
    }

    public static final /* synthetic */ Symbol access$getIN_BUFFER$p() {
        return IN_BUFFER;
    }

    public static final /* synthetic */ Symbol access$getPOISONED$p() {
        return POISONED;
    }

    public static final /* synthetic */ boolean access$tryResume0(CancellableContinuation $receiver, Object value, Function1 onCancellation) {
        return BufferedChannelKt.tryResume0($receiver, value, (Function1<? super Throwable, Unit>)onCancellation);
    }

    public static final /* synthetic */ Symbol access$getFAILED$p() {
        return FAILED;
    }

    public static final /* synthetic */ Symbol access$getSUSPEND$p() {
        return SUSPEND;
    }

    public static final /* synthetic */ Symbol access$getSUSPEND_NO_WAITER$p() {
        return SUSPEND_NO_WAITER;
    }

    public static final /* synthetic */ Symbol access$getRESUMING_BY_EB$p() {
        return RESUMING_BY_EB;
    }

    public static final /* synthetic */ Symbol access$getRESUMING_BY_RCV$p() {
        return RESUMING_BY_RCV;
    }

    public static final /* synthetic */ int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p() {
        return EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
    }

    public static final /* synthetic */ long access$constructEBCompletedAndPauseFlag(long counter, boolean pauseEB) {
        return BufferedChannelKt.constructEBCompletedAndPauseFlag(counter, pauseEB);
    }

    public static final /* synthetic */ Symbol access$getNO_RECEIVE_RESULT$p() {
        return NO_RECEIVE_RESULT;
    }

    public static final /* synthetic */ Symbol access$getCLOSE_HANDLER_CLOSED$p() {
        return CLOSE_HANDLER_CLOSED;
    }

    public static final /* synthetic */ Symbol access$getCLOSE_HANDLER_INVOKED$p() {
        return CLOSE_HANDLER_INVOKED;
    }

    public static final /* synthetic */ long access$constructSendersAndCloseStatus(long counter, int closeStatus) {
        return BufferedChannelKt.constructSendersAndCloseStatus(counter, closeStatus);
    }

    public static final /* synthetic */ ChannelSegment access$createSegment(long id, ChannelSegment prev2) {
        return BufferedChannelKt.createSegment(id, prev2);
    }
}

