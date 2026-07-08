/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.JvmName
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0004\u001a\u00020\u0003H\u00a6B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H\u00a6\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00028\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/channels/ChannelIterator;", "E", "", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"})
public interface ChannelIterator<E> {
    @Nullable
    public Object hasNext(@NotNull Continuation<? super Boolean> var1);

    @Deprecated(message="Since 1.3.0, binary compatibility with versions <= 1.2.x", level=DeprecationLevel.HIDDEN)
    @JvmName(name="next")
    public /* synthetic */ Object next(Continuation var1);

    public E next();

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        /*
         * Unable to fully structure code
         */
        @Deprecated(message="Since 1.3.0, binary compatibility with versions <= 1.2.x", level=DeprecationLevel.HIDDEN)
        @JvmName(name="next")
        public static /* synthetic */ Object next(ChannelIterator var0, Continuation var1_1) {
            if (!(var1_1 instanceof next0.1)) ** GOTO lbl-1000
            var3_2 = var1_1;
            if ((var3_2.label & -2147483648) != 0) {
                var3_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl((Continuation<? super next0.1>)var1_1){
                    Object L$0;
                    /* synthetic */ Object result;
                    int label;

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return DefaultImpls.next(null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.L$0 = $this;
                    $continuation.label = 1;
                    v0 = $this.hasNext((Continuation<? super Boolean>)$continuation);
                    if (v0 == var4_4) {
                        return var4_4;
                    }
                    ** GOTO lbl22
                }
                case 1: {
                    $this = (ChannelIterator)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl22:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) {
                        throw new ClosedReceiveChannelException("Channel was closed");
                    }
                    return $this.next();
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

