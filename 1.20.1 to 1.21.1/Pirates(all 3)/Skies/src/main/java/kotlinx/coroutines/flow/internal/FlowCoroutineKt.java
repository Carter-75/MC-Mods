/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.FlowCoroutine;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002)\b\u0001\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u00a2\u0006\u0002\b\u0005H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001aU\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000025\b\u0001\u0010\u0006\u001a/\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t\u00a2\u0006\u0002\b\u0005H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"R", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "flowScope", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlinx/coroutines/flow/Flow;", "scopedFlow", "(Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nFlowCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,63:1\n107#2:64\n*S KotlinDebug\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n50#1:64\n*E\n"})
public final class FlowCoroutineKt {
    @Nullable
    public static final <R> Object flowScope(@BuilderInference @NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> block, @NotNull Continuation<? super R> $completion) {
        Continuation<? super R> uCont = $completion;
        boolean bl = false;
        FlowCoroutine<? super R> coroutine = new FlowCoroutine<R>(uCont.getContext(), uCont);
        Object object = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)coroutine, coroutine, block);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @NotNull
    public static final <R> Flow<R> scopedFlow(@BuilderInference @NotNull Function3<? super CoroutineScope, ? super FlowCollector<? super R>, ? super Continuation<? super Unit>, ? extends Object> block) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>(block){
            final /* synthetic */ Function3 $block$inlined;
            {
                this.$block$inlined = function3;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$scopedFlow_u24lambda_u241 = collector2;
                boolean bl = false;
                Object object = FlowCoroutineKt.flowScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$block$inlined, $this$scopedFlow_u24lambda_u241, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ Function3<CoroutineScope, FlowCollector<? super R>, Continuation<? super Unit>, Object> $block;
                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                    {
                        this.$block = $block;
                        this.$this_unsafeFlow = $receiver;
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
                                CoroutineScope $this$flowScope = (CoroutineScope)this.L$0;
                                this.label = 1;
                                Object object3 = this.$block.invoke((Object)$this$flowScope, this.$this_unsafeFlow, (Object)((Object)this));
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
        };
    }
}

