/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.impl.shadow.FW;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007BE\u0012\u0006\u0010\u0004\u001a\u00020\u000e\u0012\u0006\u0010\u0006\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\nJ)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0014\u00a2\u0006\u0004\b\u0007\u0010\fJ/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u00a2\u0006\u0004\b\u0007\u0010\r"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FS;", "Ljava/util/concurrent/ThreadPoolExecutor;", "T", "Lorg/valkyrienskies/core/impl/shadow/FS$a$a;", "p0", "", "p1", "a", "(Lorg/valkyrienskies/core/impl/shadow/FS$a$a;)Lorg/valkyrienskies/core/impl/shadow/FS$a$a;", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)Lorg/valkyrienskies/core/impl/shadow/FS$a$a;", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Lorg/valkyrienskies/core/impl/shadow/FS$a$a;", "(JLjava/util/concurrent/Callable;)Lorg/valkyrienskies/core/impl/shadow/FS$a$a;", "", "p2", "p3", "Ljava/util/concurrent/TimeUnit;", "p4", "Ljava/util/concurrent/PriorityBlockingQueue;", "p5", "<init>", "(IIIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/PriorityBlockingQueue;)V"})
public final class FS
extends ThreadPoolExecutor {
    public static final a a = new a(null);
    private static final Logger b = FW.a(a, org.valkyrienskies.core.impl.shadow.FS$a.a[0]);

    private FS(int n2, int n3, int n4, long l2, TimeUnit timeUnit, PriorityBlockingQueue<Runnable> priorityBlockingQueue) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"");
        Intrinsics.checkNotNullParameter(priorityBlockingQueue, (String)"");
        super(n2, n3, l2, timeUnit, (BlockingQueue<Runnable>)priorityBlockingQueue, arg_0 -> FS.a(n4, arg_0));
    }

    public /* synthetic */ FS(int n2, int n3, int n4, long l2, TimeUnit timeUnit, PriorityBlockingQueue priorityBlockingQueue, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 4) != 0) {
            n4 = 5;
        }
        if ((n5 & 8) != 0) {
            l2 = 60L;
        }
        if ((n5 & 0x10) != 0) {
            timeUnit = TimeUnit.SECONDS;
        }
        if ((n5 & 0x20) != 0) {
            priorityBlockingQueue = new PriorityBlockingQueue<Runnable>();
        }
        this(n2, n3, n4, l2, timeUnit, priorityBlockingQueue);
    }

    private static <T> a.a<T> a(Runnable object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = "Not implemented";
        throw new NotImplementedError("An operation is not implemented: " + (String)object);
    }

    private static <T> a.a<T> a(Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, (String)"");
        return new a.a<T>(callable);
    }

    public final <T> a.a<T> a(long l2, Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, (String)"");
        a.b<T> b2 = new a.b<T>(l2, callable);
        Future future = this.submit(b2);
        Intrinsics.checkNotNull(future);
        return (a.a)future;
    }

    private static <T> a.a<T> a(a.a<T> a2) {
        Intrinsics.checkNotNullParameter(a2, (String)"");
        throw new NotImplementedError(null, 1, null);
    }

    private static final Thread a(int n2, Runnable runnable) {
        runnable = new Thread(runnable);
        ((Thread)runnable).setPriority(n2);
        return runnable;
    }

    private static final Object a(Runnable runnable, Object object) {
        runnable.run();
        return object;
    }

    public final /* synthetic */ RunnableFuture newTaskFor(Runnable p0, Object p1) {
        Object object = p0;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = "Not implemented";
        throw new NotImplementedError("An operation is not implemented: " + (String)object);
    }

    public final /* synthetic */ RunnableFuture newTaskFor(Callable p0) {
        Callable callable = p0;
        Intrinsics.checkNotNullParameter((Object)callable, (String)"");
        return new a.a(callable);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0005\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\u00020\u00028CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FS$a;", "", "Lorg/apache/logging/log4j/Logger;", "b", "Lorg/apache/logging/log4j/Logger;", "a", "()Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
    public static final class org.valkyrienskies.core.impl.shadow.FS$a {
        static final /* synthetic */ KProperty<Object>[] a;

        private org.valkyrienskies.core.impl.shadow.FS$a() {
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = b;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(org.valkyrienskies.core.impl.shadow.FS$a object) {
            KProperty<Object> kProperty = a[0];
            object = b;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return object;
        }

        public /* synthetic */ org.valkyrienskies.core.impl.shadow.FS$a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(org.valkyrienskies.core.impl.shadow.FS$a.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            a = kPropertyArray2;
        }

        public static final class a<T>
        extends FutureTask<T>
        implements Comparable<a<T>> {
            private final b<T> a;

            public a(Callable<T> callable) {
                Intrinsics.checkNotNullParameter(callable, (String)"");
                super(callable);
                this.a = (b)callable;
            }

            private b<T> a() {
                return this.a;
            }

            private int a(a<T> a2) {
                if (Intrinsics.areEqual((Object)this, a2)) {
                    return 0;
                }
                if (a2 == null) {
                    return 1;
                }
                b<T> b2 = this.a;
                b<T> b3 = b2;
                b3 = a2.a;
                if (b2.a == b3.a) {
                    if (this.hashCode() != a2.hashCode()) {
                        return Intrinsics.compare((int)this.hashCode(), (int)a2.hashCode());
                    }
                    org.valkyrienskies.core.impl.shadow.FS$a.a(FS.a).warn("Ruby says \"this should work just fine\", lets hope it does \ud83d\ude02");
                    return 1;
                }
                b<T> b4 = this.a;
                b3 = b4;
                b3 = a2.a;
                return Intrinsics.compare((long)b4.a, (long)b3.a);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public final /* synthetic */ int compareTo(Object other) {
                int n2;
                a a2 = this;
                a a3 = a2;
                if (Intrinsics.areEqual((Object)a2, (Object)a3)) {
                    return 0;
                }
                if (a3 == null) {
                    return 1;
                }
                b<T> b2 = a2.a;
                b<T> b3 = b2;
                b3 = a3.a;
                if (b2.a != b3.a) {
                    b<T> b4 = a2.a;
                    b3 = b4;
                    b3 = a3.a;
                    n2 = Intrinsics.compare((long)b4.a, (long)b3.a);
                    return n2;
                }
                if (a2.hashCode() != a3.hashCode()) {
                    n2 = Intrinsics.compare((int)a2.hashCode(), (int)a3.hashCode());
                    return n2;
                }
                org.valkyrienskies.core.impl.shadow.FS$a.a(FS.a).warn("Ruby says \"this should work just fine\", lets hope it does \ud83d\ude02");
                return 1;
            }
        }

        public static final class b<T>
        implements Callable<T> {
            final long a;
            private final Callable<T> b;

            public b(long l2, Callable<T> callable) {
                Intrinsics.checkNotNullParameter(callable, (String)"");
                this.a = l2;
                this.b = callable;
            }

            public final long a() {
                return this.a;
            }

            private Callable<T> b() {
                return this.b;
            }

            @Override
            public final T call() {
                try {
                    return this.b.call();
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(interruptedException);
                }
            }
        }
    }
}

