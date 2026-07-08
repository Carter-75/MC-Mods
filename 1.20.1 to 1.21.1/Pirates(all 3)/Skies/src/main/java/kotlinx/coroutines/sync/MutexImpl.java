/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.SemaphoreImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u000234B\u000f\u0012\u0006\u00100\u001a\u00020\u0005\u00a2\u0006\u0004\b1\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\rJ%\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0007J\u0019\u0010\u001a\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u001a\u0010\nJ\u0019\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR(\u0010$\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00020\u001f8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!Rq\u0010-\u001a_\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0012\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000b0*0%j\u0002`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0013\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030/8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2={"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", "", "owner", "", "holdsLock", "(Ljava/lang/Object;)Z", "", "holdsLockImpl", "(Ljava/lang/Object;)I", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "result", "onLockProcessResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "onLockRegFunction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "tryLockImpl", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "onLock", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "param", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onSelectCancellationUnlockConstructor", "Lkotlin/jvm/functions/Function3;", "Lkotlinx/atomicfu/AtomicRef;", "locked", "<init>", "(Z)V", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
public class MutexImpl
extends SemaphoreImpl
implements Mutex {
    @Volatile
    @Nullable
    private volatile Object owner;
    @NotNull
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onSelectCancellationUnlockConstructor;
    @NotNull
    private static final AtomicReferenceFieldUpdater owner$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");

    public MutexImpl(boolean locked) {
        super(1, locked ? 1 : 0);
        this.owner = locked ? null : MutexKt.access$getNO_OWNER$p();
        this.onSelectCancellationUnlockConstructor = new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this){
            final /* synthetic */ MutexImpl this$0;
            {
                this.this$0 = $receiver;
                super(3);
            }

            @NotNull
            public final Function1<Throwable, Unit> invoke(@NotNull SelectInstance<?> selectInstance, @Nullable Object owner, @Nullable Object object) {
                return (Function1)new Function1<Throwable, Unit>(this.this$0, owner){
                    final /* synthetic */ MutexImpl this$0;
                    final /* synthetic */ Object $owner;
                    {
                        this.this$0 = $receiver;
                        this.$owner = $owner;
                        super(1);
                    }

                    public final void invoke(@NotNull Throwable it) {
                        this.this$0.unlock(this.$owner);
                    }
                };
            }
        };
    }

    @Override
    public boolean isLocked() {
        return this.getAvailablePermits() == 0;
    }

    @Override
    public boolean holdsLock(@NotNull Object owner) {
        return this.holdsLockImpl(owner) == 1;
    }

    private final int holdsLockImpl(Object owner) {
        Object curOwner;
        do {
            if (this.isLocked()) continue;
            return 0;
        } while ((curOwner = owner$FU.get(this)) == MutexKt.access$getNO_OWNER$p());
        return curOwner == owner ? 1 : 2;
    }

    @Override
    @Nullable
    public Object lock(@Nullable Object owner, @NotNull Continuation<? super Unit> $completion) {
        return MutexImpl.lock$suspendImpl(this, owner, $completion);
    }

    static /* synthetic */ Object lock$suspendImpl(MutexImpl $this, Object owner, Continuation<? super Unit> $completion) {
        if ($this.tryLock(owner)) {
            return Unit.INSTANCE;
        }
        Object object = $this.lockSuspend(owner, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Object lockSuspend(Object owner, Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont$iv));
        try {
            CancellableContinuationImpl cont = cancellable$iv;
            boolean bl2 = false;
            CancellableContinuationWithOwner contWithOwner = new CancellableContinuationWithOwner(cont, owner);
            this.acquire(contWithOwner);
        }
        catch (Throwable e$iv) {
            cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e$iv;
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    public boolean tryLock(@Nullable Object owner) {
        boolean bl;
        switch (this.tryLockImpl(owner)) {
            case 0: {
                bl = true;
                break;
            }
            case 1: {
                bl = false;
                break;
            }
            case 2: {
                throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
            }
            default: {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return bl;
    }

    private final int tryLockImpl(Object owner) {
        block5: while (true) {
            if (this.tryAcquire()) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(owner$FU.get(this) == MutexKt.access$getNO_OWNER$p())) {
                        throw new AssertionError();
                    }
                }
                owner$FU.set(this, owner);
                return 0;
            }
            if (owner == null) {
                return 1;
            }
            switch (this.holdsLockImpl(owner)) {
                case 1: {
                    return 2;
                }
                case 2: {
                    return 1;
                }
                case 0: {
                    continue block5;
                }
            }
        }
    }

    @Override
    public void unlock(@Nullable Object owner) {
        while (true) {
            if (!this.isLocked()) {
                boolean bl = false;
                String string = "This mutex is not locked";
                throw new IllegalStateException(string.toString());
            }
            Object curOwner = owner$FU.get(this);
            if (curOwner == MutexKt.access$getNO_OWNER$p()) continue;
            if (!(curOwner == owner || owner == null)) {
                boolean bl = false;
                String string = "This mutex is locked by " + curOwner + ", but " + owner + " is expected";
                throw new IllegalStateException(string.toString());
            }
            if (owner$FU.compareAndSet(this, curOwner, MutexKt.access$getNO_OWNER$p())) break;
        }
        this.release();
    }

    @Override
    @NotNull
    public SelectClause2<Object, Mutex> getOnLock() {
        onLock.1 v0 = onLock.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
        onLock.2 v2 = onLock.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v2), (int)3)), this.onSelectCancellationUnlockConstructor);
    }

    public static /* synthetic */ void getOnLock$annotations() {
    }

    protected void onLockRegFunction(@NotNull SelectInstance<?> select, @Nullable Object owner) {
        if (owner != null && this.holdsLock(owner)) {
            select.selectInRegistrationPhase(MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p());
        } else {
            Intrinsics.checkNotNull(select, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            this.onAcquireRegFunction(new SelectInstanceWithOwner((SelectInstanceInternal)select, owner), owner);
        }
    }

    @Nullable
    protected Object onLockProcessResult(@Nullable Object owner, @Nullable Object result2) {
        if (Intrinsics.areEqual((Object)result2, (Object)MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p())) {
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
        }
        return this;
    }

    @NotNull
    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + this.isLocked() + ",owner=" + owner$FU.get(this) + ']';
    }

    public static final /* synthetic */ Object access$lockSuspend(MutexImpl $this, Object owner, Continuation $completion) {
        return $this.lockSuspend(owner, (Continuation<? super Unit>)$completion);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020.\u0012\b\u00109\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b;\u0010<J\u001c\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0097\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002H\u0097\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0014\u001a\u00020\u00022'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00020\u000fj\u0002`\u0012H\u0096\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0014\u001a\u00020\u00022\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001\u00a2\u0006\u0004\b\u0014\u0010\u001aJ<\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0096\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\fJ&\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\tH\u0097\u0001\u00a2\u0006\u0004\b#\u0010$JH\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\t2#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b#\u0010%J\u001a\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\u0004H\u0097\u0001\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010*\u001a\u00020\u0002*\u00020)2\u0006\u0010\u001b\u001a\u00020\u0002H\u0097\u0001\u00a2\u0006\u0004\b*\u0010+J\u001c\u0010,\u001a\u00020\u0002*\u00020)2\u0006\u0010&\u001a\u00020\u0004H\u0097\u0001\u00a2\u0006\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002018\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u00020\u00068\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00068\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00068\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b8\u00106R\u0016\u00109\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2={"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "", "token", "completeResume", "(Ljava/lang/Object;)V", "initCancellability", "()V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "(Lkotlinx/coroutines/internal/Segment;I)V", "value", "onCancellation", "resume", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "idempotent", "tryResume", "(Lkotlin/Unit;Ljava/lang/Object;)Ljava/lang/Object;", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isActive", "()Z", "isCancelled", "isCompleted", "owner", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    private final class CancellableContinuationWithOwner
    implements CancellableContinuation<Unit>,
    Waiter {
        @JvmField
        @NotNull
        public final CancellableContinuationImpl<Unit> cont;
        @JvmField
        @Nullable
        public final Object owner;

        public CancellableContinuationWithOwner(@Nullable CancellableContinuationImpl<? super Unit> cont, Object owner) {
            this.cont = cont;
            this.owner = owner;
        }

        @NotNull
        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        @Override
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override
        public boolean isCancelled() {
            return this.cont.isCancelled();
        }

        @Override
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Override
        public boolean cancel(@Nullable Throwable cause) {
            return this.cont.cancel(cause);
        }

        @Override
        @InternalCoroutinesApi
        public void completeResume(@NotNull Object token2) {
            this.cont.completeResume(token2);
        }

        @Override
        @InternalCoroutinesApi
        public void initCancellability() {
            this.cont.initCancellability();
        }

        @Override
        public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> handler) {
            this.cont.invokeOnCancellation(handler);
        }

        public void resumeWith(@NotNull Object result2) {
            this.cont.resumeWith(result2);
        }

        @Override
        @InternalCoroutinesApi
        @Nullable
        public Object tryResume(@NotNull Unit value, @Nullable Object idempotent) {
            return this.cont.tryResume(value, idempotent);
        }

        @Override
        @InternalCoroutinesApi
        @Nullable
        public Object tryResumeWithException(@NotNull Throwable exception) {
            return this.cont.tryResumeWithException(exception);
        }

        @Override
        @ExperimentalCoroutinesApi
        public void resumeUndispatched(@NotNull CoroutineDispatcher $this$resumeUndispatched, @NotNull Unit value) {
            this.cont.resumeUndispatched($this$resumeUndispatched, value);
        }

        @Override
        @ExperimentalCoroutinesApi
        public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher $this$resumeUndispatchedWithException, @NotNull Throwable exception) {
            this.cont.resumeUndispatchedWithException($this$resumeUndispatchedWithException, exception);
        }

        @Override
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.cont.invokeOnCancellation(segment, index);
        }

        @Override
        @Nullable
        public Object tryResume(@NotNull Unit value, @Nullable Object idempotent, @Nullable Function1<? super Throwable, Unit> onCancellation) {
            Object token2;
            MutexImpl mutexImpl = MutexImpl.this;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(owner$FU.get(mutexImpl) == MutexKt.access$getNO_OWNER$p())) {
                    throw new AssertionError();
                }
            }
            if ((token2 = this.cont.tryResume(value, idempotent, (Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(MutexImpl.this, this){
                final /* synthetic */ MutexImpl this$0;
                final /* synthetic */ CancellableContinuationWithOwner this$1;
                {
                    this.this$0 = $receiver;
                    this.this$1 = $receiver2;
                    super(1);
                }

                public final void invoke(@NotNull Throwable it) {
                    MutexImpl mutexImpl = this.this$0;
                    CancellableContinuationWithOwner cancellableContinuationWithOwner = this.this$1;
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        boolean bl = false;
                        V it2 = MutexImpl.access$getOwner$FU$p().get(mutexImpl);
                        boolean bl2 = false;
                        if (!(it2 == MutexKt.access$getNO_OWNER$p() || it2 == cancellableContinuationWithOwner.owner)) {
                            throw new AssertionError();
                        }
                    }
                    MutexImpl.access$getOwner$FU$p().set(this.this$0, this.this$1.owner);
                    this.this$0.unlock(this.this$1.owner);
                }
            }))) != null) {
                MutexImpl mutexImpl2 = MutexImpl.this;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(owner$FU.get(mutexImpl2) == MutexKt.access$getNO_OWNER$p())) {
                        throw new AssertionError();
                    }
                }
                owner$FU.set(MutexImpl.this, this.owner);
            }
            return token2;
        }

        @Override
        public void resume(@NotNull Unit value, @Nullable Function1<? super Throwable, Unit> onCancellation) {
            MutexImpl mutexImpl = MutexImpl.this;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(owner$FU.get(mutexImpl) == MutexKt.access$getNO_OWNER$p())) {
                    throw new AssertionError();
                }
            }
            owner$FU.set(MutexImpl.this, this.owner);
            this.cont.resume(value, (Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(MutexImpl.this, this){
                final /* synthetic */ MutexImpl this$0;
                final /* synthetic */ CancellableContinuationWithOwner this$1;
                {
                    this.this$0 = $receiver;
                    this.this$1 = $receiver2;
                    super(1);
                }

                public final void invoke(@NotNull Throwable it) {
                    this.this$0.unlock(this.this$1.owner);
                }
            }));
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2={"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "", "disposeOnCompletion", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "", "internalResult", "selectInRegistrationPhase", "(Ljava/lang/Object;)V", "clauseObject", "result", "", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "owner", "Ljava/lang/Object;", "select", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    private final class SelectInstanceWithOwner<Q>
    implements SelectInstanceInternal<Q> {
        @JvmField
        @NotNull
        public final SelectInstanceInternal<Q> select;
        @JvmField
        @Nullable
        public final Object owner;

        public SelectInstanceWithOwner(@Nullable SelectInstanceInternal<Q> select, Object owner) {
            this.select = select;
            this.owner = owner;
        }

        @Override
        @NotNull
        public CoroutineContext getContext() {
            return this.select.getContext();
        }

        @Override
        public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
            this.select.disposeOnCompletion(disposableHandle);
        }

        @Override
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.select.invokeOnCancellation(segment, index);
        }

        @Override
        public boolean trySelect(@NotNull Object clauseObject, @Nullable Object result2) {
            MutexImpl mutexImpl = MutexImpl.this;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(owner$FU.get(mutexImpl) == MutexKt.access$getNO_OWNER$p())) {
                    throw new AssertionError();
                }
            }
            boolean bl = this.select.trySelect(clauseObject, result2);
            MutexImpl mutexImpl2 = MutexImpl.this;
            boolean success = bl;
            boolean bl2 = false;
            if (success) {
                owner$FU.set(mutexImpl2, this.owner);
            }
            return bl;
        }

        @Override
        public void selectInRegistrationPhase(@Nullable Object internalResult) {
            MutexImpl mutexImpl = MutexImpl.this;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(owner$FU.get(mutexImpl) == MutexKt.access$getNO_OWNER$p())) {
                    throw new AssertionError();
                }
            }
            owner$FU.set(MutexImpl.this, this.owner);
            this.select.selectInRegistrationPhase(internalResult);
        }
    }
}

