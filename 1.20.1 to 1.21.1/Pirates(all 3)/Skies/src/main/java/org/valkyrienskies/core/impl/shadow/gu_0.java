/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gu
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Gu;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "p0", "Ljava/lang/Runnable;", "p1", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "a", "()V", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "<init>"})
public final class gu_0
extends CoroutineDispatcher {
    public final ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue();

    /*
     * WARNING - void declaration
     */
    @Override
    public final void dispatch(CoroutineContext context, Runnable block) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)context, (String)"");
        Intrinsics.checkNotNullParameter((Object)block, (String)"");
        this.a.add((Runnable)var2_2);
    }

    public final void a() {
        CollectionsKt.removeAll((Iterable)this.a, (Function1)1.a);
    }
}

