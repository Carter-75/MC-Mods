/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 */
package kotlinx.coroutines.sync;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\t\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u000e8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/sync/Mutex;", "", "owner", "", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "onLock", "kotlinx-coroutines-core"})
public interface Mutex {
    public boolean isLocked();

    public boolean tryLock(@Nullable Object var1);

    @Nullable
    public Object lock(@Nullable Object var1, @NotNull Continuation<? super Unit> var2);

    @NotNull
    public SelectClause2<Object, Mutex> getOnLock();

    public boolean holdsLock(@NotNull Object var1);

    public void unlock(@Nullable Object var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean tryLock$default(Mutex mutex, Object object, int n2, Object object2) {
            if (object2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((n2 & 1) != 0) {
                object = null;
            }
            return mutex.tryLock(object);
        }

        public static /* synthetic */ Object lock$default(Mutex mutex, Object object, Continuation continuation, int n2, Object object2) {
            if (object2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((n2 & 1) != 0) {
                object = null;
            }
            return mutex.lock(object, (Continuation<? super Unit>)continuation);
        }

        @Deprecated(message="Mutex.onLock deprecated without replacement. For additional details please refer to #2794", level=DeprecationLevel.WARNING)
        public static /* synthetic */ void getOnLock$annotations() {
        }

        public static /* synthetic */ void unlock$default(Mutex mutex, Object object, int n2, Object object2) {
            if (object2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((n2 & 1) != 0) {
                object = null;
            }
            mutex.unlock(object);
        }
    }
}

