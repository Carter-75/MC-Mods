/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollectorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\"D\u0010\u0005\u001a,\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "", "emitFun", "Lkotlin/jvm/functions/Function3;", "getEmitFun$annotations", "()V", "kotlinx-coroutines-core"})
public final class SafeCollectorKt {
    @NotNull
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> emitFun;

    private static /* synthetic */ void getEmitFun$annotations() {
    }

    public static final /* synthetic */ Function3 access$getEmitFun$p() {
        return emitFun;
    }

    static {
        emitFun.1 v0 = emitFun.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        emitFun = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
    }
}

