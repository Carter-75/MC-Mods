/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0001\u0010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0015j\b\u0012\u0004\u0012\u00028\u0000`\u00160\u00148\u0002X\u0082\u0004R\u0011\u0010\u0018\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "element", "", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "_cur", "isEmpty", "", "getSize", "()I", "size", "singleConsumer", "<init>", "(Z)V", "kotlinx-coroutines-core"})
public class LockFreeTaskQueue<E> {
    @Volatile
    @Nullable
    private volatile Object _cur;
    @NotNull
    private static final AtomicReferenceFieldUpdater _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");

    public LockFreeTaskQueue(boolean singleConsumer) {
        this._cur = new LockFreeTaskQueueCore(8, singleConsumer);
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore)_cur$FU.get(this)).isEmpty();
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore)_cur$FU.get(this)).getSize();
    }

    public final void close() {
        LockFreeTaskQueue lockFreeTaskQueue = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _cur$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            LockFreeTaskQueueCore cur = (LockFreeTaskQueueCore)atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (cur.close()) {
                return;
            }
            _cur$FU.compareAndSet(this, cur, cur.next());
        }
    }

    public final boolean addLast(@NotNull E element) {
        LockFreeTaskQueue lockFreeTaskQueue = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _cur$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            LockFreeTaskQueueCore cur = (LockFreeTaskQueueCore)atomicfu$handler$iv.get(this);
            boolean bl = false;
            switch (cur.addLast(element)) {
                case 0: {
                    return true;
                }
                case 2: {
                    return false;
                }
                case 1: {
                    _cur$FU.compareAndSet(this, cur, cur.next());
                }
            }
        }
    }

    @Nullable
    public final E removeFirstOrNull() {
        LockFreeTaskQueue lockFreeTaskQueue = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _cur$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            LockFreeTaskQueueCore cur = (LockFreeTaskQueueCore)atomicfu$handler$iv.get(this);
            boolean bl = false;
            Object result2 = cur.removeFirstOrNull();
            if (result2 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return (E)result2;
            }
            _cur$FU.compareAndSet(this, cur, cur.next());
        }
    }

    @NotNull
    public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> transform2) {
        return ((LockFreeTaskQueueCore)_cur$FU.get(this)).map(transform2);
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore)_cur$FU.get(this)).isClosed();
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }
}

