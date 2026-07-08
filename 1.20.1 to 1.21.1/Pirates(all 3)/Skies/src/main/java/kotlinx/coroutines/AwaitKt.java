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
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitAll;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0001\"\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\r\u001a\u001d\u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2={"T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "", "awaitAll", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "jobs", "", "joinAll", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n37#2,2:128\n13579#3,2:130\n1855#4,2:132\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n42#1:128,2\n54#1:130,2\n66#1:132,2\n*E\n"})
public final class AwaitKt {
    @Nullable
    public static final <T> Object awaitAll(@NotNull Deferred<? extends T>[] deferreds, @NotNull Continuation<? super List<? extends T>> $completion) {
        if (!(deferreds.length == 0)) {
            return new AwaitAll<T>(deferreds).await($completion);
        }
        return CollectionsKt.emptyList();
    }

    @Nullable
    public static final <T> Object awaitAll(@NotNull Collection<? extends Deferred<? extends T>> $this$awaitAll, @NotNull Continuation<? super List<? extends T>> $completion) {
        if (!$this$awaitAll.isEmpty()) {
            Collection<Deferred<Deferred>> $this$toTypedArray$iv = $this$awaitAll;
            boolean $i$f$toTypedArray = false;
            Collection<Deferred<Deferred>> thisCollection$iv = $this$toTypedArray$iv;
            return new AwaitAll(thisCollection$iv.toArray(new Deferred[0])).await($completion);
        }
        return CollectionsKt.emptyList();
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object joinAll(@NotNull Job[] var0, @NotNull Continuation<? super Unit> var1_1) {
        if (!(var1_1 instanceof joinAll.1)) ** GOTO lbl-1000
        var10_2 = var1_1;
        if ((var10_2.label & -2147483648) != 0) {
            var10_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return AwaitKt.joinAll(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var11_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$forEach$iv = jobs;
                $i$f$forEach = false;
                var4_7 = 0;
                var5_8 = $this$forEach$iv.length;
lbl16:
                // 2 sources

                while (var4_7 < var5_8) {
                    it = element$iv = $this$forEach$iv[var4_7];
                    $i$a$-forEach-AwaitKt$joinAll$2 = false;
                    $continuation.L$0 = $this$forEach$iv;
                    $continuation.I$0 = var4_7;
                    $continuation.I$1 = var5_8;
                    $continuation.label = 1;
                    v0 = it.join((Continuation<? super Unit>)$continuation);
                    if (v0 == var11_4) {
                        return var11_4;
                    }
                    ** GOTO lbl36
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-AwaitKt$joinAll$2 = false;
                var5_8 = $continuation.I$1;
                var4_7 = $continuation.I$0;
                $this$forEach$iv = (Job[])$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl36:
                // 2 sources

                ++var4_7;
                ** GOTO lbl16
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object joinAll(@NotNull Collection<? extends Job> var0, @NotNull Continuation<? super Unit> var1_1) {
        if (!(var1_1 instanceof joinAll.3)) ** GOTO lbl-1000
        var9_2 = var1_1;
        if ((var9_2.label & -2147483648) != 0) {
            var9_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return AwaitKt.joinAll(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$forEach$iv = $this$joinAll;
                $i$f$forEach = false;
                var4_7 = $this$forEach$iv.iterator();
lbl15:
                // 3 sources

                while (var4_7.hasNext()) {
                    element$iv = var4_7.next();
                    it = (Job)element$iv;
                    $i$a$-forEach-AwaitKt$joinAll$4 = false;
                    $continuation.L$0 = var4_7;
                    $continuation.label = 1;
                    v0 = it.join((Continuation<? super Unit>)$continuation);
                    if (v0 != var10_4) continue;
                    return var10_4;
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-AwaitKt$joinAll$4 = false;
                var4_7 = (Iterator<T>)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
                ** GOTO lbl15
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

