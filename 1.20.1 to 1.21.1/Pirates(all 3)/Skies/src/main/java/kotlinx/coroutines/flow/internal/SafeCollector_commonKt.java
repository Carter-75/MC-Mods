/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aP\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0005\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000e\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\r\u001a\u00020\fH\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\"\u0010\u0012\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0080\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/Flow;", "unsafeFlow", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "checkContext", "(Lkotlinx/coroutines/flow/internal/SafeCollector;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/Job;", "collectJob", "transitiveCoroutineParent", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"})
public final class SafeCollector_commonKt {
    @JvmName(name="checkContext")
    public static final void checkContext(@NotNull SafeCollector<?> $this$checkContext, @NotNull CoroutineContext currentContext) {
        int result2 = ((Number)currentContext.fold((Object)0, (Function2)new Function2<Integer, CoroutineContext.Element, Integer>($this$checkContext){
            final /* synthetic */ SafeCollector<?> $this_checkContext;
            {
                this.$this_checkContext = $receiver;
                super(2);
            }

            @NotNull
            public final Integer invoke(int count2, @NotNull CoroutineContext.Element element) {
                CoroutineContext.Key key = element.getKey();
                CoroutineContext.Element collectElement = this.$this_checkContext.collectContext.get(key);
                if (key != Job.Key) {
                    return element != collectElement ? Integer.MIN_VALUE : count2 + 1;
                }
                Job collectJob = (Job)collectElement;
                Intrinsics.checkNotNull((Object)element, (String)"null cannot be cast to non-null type kotlinx.coroutines.Job");
                Job emissionParentJob = SafeCollector_commonKt.transitiveCoroutineParent((Job)element, collectJob);
                if (emissionParentJob != collectJob) {
                    throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + emissionParentJob + ", expected child of " + collectJob + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                }
                return collectJob == null ? count2 : count2 + 1;
            }
        })).intValue();
        if (result2 != $this$checkContext.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + $this$checkContext.collectContext + ",\n\t\tbut emission happened in " + currentContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    @Nullable
    public static final Job transitiveCoroutineParent(@Nullable Job $this$transitiveCoroutineParent, @Nullable Job collectJob) {
        while ($this$transitiveCoroutineParent != null) {
            if ($this$transitiveCoroutineParent == collectJob) {
                return $this$transitiveCoroutineParent;
            }
            if (!($this$transitiveCoroutineParent instanceof ScopeCoroutine)) {
                return $this$transitiveCoroutineParent;
            }
            Job job = $this$transitiveCoroutineParent.getParent();
            Job job2 = collectJob;
            $this$transitiveCoroutineParent = job;
            collectJob = job2;
        }
        return null;
    }

    @PublishedApi
    @NotNull
    public static final <T> Flow<T> unsafeFlow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>(block){
            final /* synthetic */ Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> $block;
            {
                this.$block = $block;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Object object = this.$block.invoke(collector2, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object collect$$forInline(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    final /* synthetic */ unsafeFlow.1<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                this.$block.invoke(collector2, $completion);
                return Unit.INSTANCE;
            }
        };
    }
}

