/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0011\u0010\tR\u000b\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2={"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "clearInterrupt", "()V", "", "state", "", "invalidState", "(I)Ljava/lang/Void;", "invoke", "(Ljava/lang/Throwable;)V", "setup", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "targetThread", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"})
final class ThreadState
implements Function1<Throwable, Unit> {
    @NotNull
    private final Job job;
    @Volatile
    private volatile int _state;
    private final Thread targetThread;
    @Nullable
    private DisposableHandle cancelHandle;
    @NotNull
    private static final AtomicIntegerFieldUpdater _state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");

    public ThreadState(@NotNull Job job) {
        this.job = job;
        this.targetThread = Thread.currentThread();
    }

    public final void setup() {
        this.cancelHandle = this.job.invokeOnCompletion(true, true, (Function1<? super Throwable, Unit>)((Function1)this));
        ThreadState threadState = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        block4: while (true) {
            int state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            switch (state) {
                case 0: {
                    if (!_state$FU.compareAndSet(this, state, 0)) continue block4;
                    return;
                }
                case 2: 
                case 3: {
                    return;
                }
                default: {
                    this.invalidState(state);
                    throw new KotlinNothingValueException();
                }
            }
            break;
        }
    }

    public final void clearInterrupt() {
        ThreadState threadState = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        block5: while (true) {
            int state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            switch (state) {
                case 0: {
                    if (!_state$FU.compareAndSet(this, state, 1)) continue block5;
                    DisposableHandle disposableHandle = this.cancelHandle;
                    if (disposableHandle != null) {
                        disposableHandle.dispose();
                    }
                    return;
                }
                case 2: {
                    break;
                }
                case 3: {
                    Thread.interrupted();
                    return;
                }
                default: {
                    this.invalidState(state);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public void invoke(@Nullable Throwable cause) {
        ThreadState threadState = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        block4: while (true) {
            int state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            switch (state) {
                case 0: {
                    if (!_state$FU.compareAndSet(this, state, 2)) continue block4;
                    this.targetThread.interrupt();
                    _state$FU.set(this, 3);
                    return;
                }
                case 1: 
                case 2: 
                case 3: {
                    return;
                }
                default: {
                    this.invalidState(state);
                    throw new KotlinNothingValueException();
                }
            }
            break;
        }
    }

    private final Void invalidState(int state) {
        throw new IllegalStateException(("Illegal state " + state).toString());
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicfu$handler, Function1<? super Integer, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            int n2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)n2);
        }
    }
}

