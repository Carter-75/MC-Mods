/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b-\u0010.J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H$\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\f\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b \u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R9\u0010'\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"8@X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u0014\u0010,\u001a\u00020\u00118@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "create", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "toString", "I", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "collectToFun", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/BufferOverflow;", "getProduceCapacity$kotlinx_coroutines_core", "()I", "produceCapacity", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
@SourceDebugExtension(value={"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
public abstract class ChannelFlow<T>
implements FusibleFlow<T> {
    @JvmField
    @NotNull
    public final CoroutineContext context;
    @JvmField
    public final int capacity;
    @JvmField
    @NotNull
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        this.context = context;
        this.capacity = capacity;
        this.onBufferOverflow = onBufferOverflow;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.capacity != -1)) {
                throw new AssertionError();
            }
        }
    }

    @NotNull
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> getCollectToFun$kotlinx_coroutines_core() {
        return new Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object>(this, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ ChannelFlow<T> this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        ProducerScope it = (ProducerScope)this.L$0;
                        this.label = 1;
                        Object object3 = this.this$0.collectTo(it, (Continuation<Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super T> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        };
    }

    public final int getProduceCapacity$kotlinx_coroutines_core() {
        return this.capacity == -3 ? -2 : this.capacity;
    }

    @Nullable
    public Flow<T> dropChannelOperators() {
        return null;
    }

    @Override
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(capacity != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext newContext = context.plus(this.context);
        int newCapacity = 0;
        BufferOverflow newOverflow = null;
        if (onBufferOverflow != BufferOverflow.SUSPEND) {
            newCapacity = capacity;
            newOverflow = onBufferOverflow;
        } else {
            int n2;
            if (this.capacity == -3) {
                n2 = capacity;
            } else if (capacity == -3) {
                n2 = this.capacity;
            } else if (this.capacity == -2) {
                n2 = capacity;
            } else if (capacity == -2) {
                n2 = this.capacity;
            } else {
                int sum;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(this.capacity >= 0)) {
                        throw new AssertionError();
                    }
                }
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(capacity >= 0)) {
                        throw new AssertionError();
                    }
                }
                n2 = (sum = this.capacity + capacity) >= 0 ? sum : Integer.MAX_VALUE;
            }
            newCapacity = n2;
            newOverflow = this.onBufferOverflow;
        }
        if (Intrinsics.areEqual((Object)newContext, (Object)this.context) && newCapacity == this.capacity && newOverflow == this.onBufferOverflow) {
            return this;
        }
        return this.create(newContext, newCapacity, newOverflow);
    }

    @NotNull
    protected abstract ChannelFlow<T> create(@NotNull CoroutineContext var1, int var2, @NotNull BufferOverflow var3);

    @Nullable
    protected abstract Object collectTo(@NotNull ProducerScope<? super T> var1, @NotNull Continuation<? super Unit> var2);

    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope scope) {
        return ProduceKt.produce$default(scope, this.context, this.getProduceCapacity$kotlinx_coroutines_core(), this.onBufferOverflow, CoroutineStart.ATOMIC, null, this.getCollectToFun$kotlinx_coroutines_core(), 16, null);
    }

    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
        return ChannelFlow.collect$suspendImpl(this, collector2, $completion);
    }

    static /* synthetic */ <T> Object collect$suspendImpl(ChannelFlow<T> $this, FlowCollector<? super T> collector2, Continuation<? super Unit> $completion) {
        Object object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(collector2, $this, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ FlowCollector<T> $collector;
            final /* synthetic */ ChannelFlow<T> this$0;
            {
                this.$collector = $collector;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        CoroutineScope $this$coroutineScope = (CoroutineScope)this.L$0;
                        this.label = 1;
                        Object object3 = FlowKt.emitAll(this.$collector, this.this$0.produceImpl($this$coroutineScope), (Continuation<? super Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    protected String additionalToStringProps() {
        return null;
    }

    @NotNull
    public String toString() {
        ArrayList<String> props = new ArrayList<String>(4);
        String string = this.additionalToStringProps();
        if (string != null) {
            String it = string;
            boolean bl = false;
            props.add(it);
        }
        if (this.context != EmptyCoroutineContext.INSTANCE) {
            props.add("context=" + this.context);
        }
        if (this.capacity != -3) {
            props.add("capacity=" + this.capacity);
        }
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            props.add("onBufferOverflow=" + (Object)((Object)this.onBufferOverflow));
        }
        return DebugStringsKt.getClassSimpleName(this) + '[' + CollectionsKt.joinToString$default((Iterable)props, (CharSequence)", ", null, null, (int)0, null, null, (int)62, null) + ']';
    }
}

