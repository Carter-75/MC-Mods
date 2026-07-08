/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FM;
import org.valkyrienskies.core.impl.shadow.FQ;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.FY;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\t\u001a\u00020'\u0012\b\b\u0002\u0010\f\u001a\u00020\u0010\u00a2\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\n\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0007\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001b\u001a\u00020\u00108\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\n\u0010\u001e\"\u0004\b\n\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u001b\u0010\u000e\u001a\u0006*\u00020#0#8\u0007\u00a2\u0006\f\n\u0004\b\"\u0010$\u001a\u0004\b\u0018\u0010%R\u001b\u0010\u0003\u001a\u0006*\u00020#0#8\u0007\u00a2\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b\u001d\u0010%R\u001b\u0010&\u001a\u0006*\u00020#0#8\u0007\u00a2\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b\"\u0010%R\u0017\u0010\u000f\u001a\u00020\u00198\u0007\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u0014\u0010\u001cR\u0014\u0010\u0011\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010("}, d2={"Lorg/valkyrienskies/core/impl/shadow/FI;", "Ljava/lang/Runnable;", "", "h", "()D", "", "run", "()V", "", "p0", "a", "(J)V", "p1", "(DJ)V", "g", "j", "", "k", "I", "", "b", "Z", "l", "J", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "e", "()Ljava/util/concurrent/locks/ReentrantLock;", "d", "()I", "(I)V", "Ljava/util/Queue;", "Ljava/util/Queue;", "f", "Ljava/util/concurrent/locks/Condition;", "Ljava/util/concurrent/locks/Condition;", "()Ljava/util/concurrent/locks/Condition;", "i", "Lorg/valkyrienskies/core/impl/shadow/FM;", "Lorg/valkyrienskies/core/impl/shadow/FM;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/FM;I)V"})
public final class FI
implements Runnable {
    public static final a a = new a(null);
    private final FM j;
    private int k;
    boolean b;
    private long l;
    final Queue<Long> c;
    volatile int d;
    final ReentrantLock e;
    final Condition f;
    final Condition g;
    final ReentrantLock h;
    final Condition i;
    private static final long m = 1000000000L;
    private static final int n = 5000;
    private static final Logger o = FW.a(a, org.valkyrienskies.core.impl.shadow.FI$a.a[0]);

    private FI(FM fM, int n2) {
        Intrinsics.checkNotNullParameter((Object)fM, (String)"");
        this.j = fM;
        this.k = n2;
        this.c = new LinkedList();
        this.e = new ReentrantLock();
        this.f = this.e.newCondition();
        this.g = this.e.newCondition();
        this.h = new ReentrantLock();
        this.i = this.h.newCondition();
    }

    public /* synthetic */ FI(FM fM, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            n2 = 60;
        }
        this(fM, n2);
    }

    @JvmName(name="a")
    public final int a() {
        return this.d;
    }

    @JvmName(name="a")
    public final void a(int n2) {
        this.d = 0;
    }

    @JvmName(name="b")
    public final ReentrantLock b() {
        return this.e;
    }

    @JvmName(name="c")
    public final Condition c() {
        return this.f;
    }

    @JvmName(name="d")
    public final Condition d() {
        return this.g;
    }

    @JvmName(name="e")
    public final ReentrantLock e() {
        return this.h;
    }

    @JvmName(name="f")
    public final Condition f() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        try {
            while (!this.b) {
                double d2;
                Object object = this.j;
                if (((FM)object).c) {
                    int n2 = VSCoreConfig.SERVER.getPt().getPhysicsTicksPerGameTick();
                    double d3 = 1.0 / (double)(n2 * 20) * VSCoreConfig.SERVER.getPhysics().getPhysicsSpeed();
                    Lock lock = this.e;
                    lock.lock();
                    try {
                        while (this.d >= n2) {
                            this.g.await();
                        }
                        this.j.a(d3);
                        int n3 = this.d;
                        this.d = n3 + 1;
                        if (this.d < n2) continue;
                        this.f.signal();
                        continue;
                    }
                    finally {
                        lock.unlock();
                        continue;
                    }
                }
                if (this.j.getDeleteResources()) {
                    object = this.j;
                    if (((FM)object).getDeleteResources()) {
                        ((FM)object).setArePhysicsRunning(true);
                        FJ fJ = ((FM)object).b;
                        Intrinsics.checkNotNull((Object)fJ);
                        Object object2 = fJ;
                        FJ.a.a(FJ.a).info("Deleting VSPhysicsPipelineStage resources!");
                        if (((FJ)object2).j) {
                            throw new IllegalStateException("Physics engine has already been deleted!");
                        }
                        ((FJ)object2).g.clear();
                        ((FJ)object2).e.clear();
                        ((FJ)object2).i.close();
                        BuildersKt.launch$default(((FJ)object2).n, (CoroutineContext)Dispatchers.getDefault(), null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((FJ)object2, null){
                            private int a;
                            private /* synthetic */ FJ b;
                            {
                                this.b = fJ;
                                super(2, continuation);
                            }

                            /*
                             * Could not resolve type clashes
                             * Unable to fully structure code
                             */
                            public final Object invokeSuspend(Object var1_1) {
                                var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.a) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var1_1);
                                        FJ.d(this.b).shutdownNow();
                                        FJ.e(this.b).shutdownNow();
lbl9:
                                        // 2 sources

                                        while (true) {
                                            this.a = 1;
                                            v0 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), (Function2)new Function2<CoroutineScope, Continuation<? super Boolean>, Object>(this.b, null){
                                                private int a;
                                                private /* synthetic */ FJ b;
                                                {
                                                    this.b = fJ;
                                                    super(2, continuation);
                                                }

                                                public final Object invokeSuspend(Object object) {
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    ResultKt.throwOnFailure((Object)object);
                                                    return Boxing.boxBoolean((boolean)FJ.e(this.b).awaitTermination(5L, TimeUnit.SECONDS));
                                                }

                                                /*
                                                 * WARNING - void declaration
                                                 */
                                                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                                    void var2_2;
                                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                                }

                                                private Object a(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                                    FJ.1 var1_1;
                                                    CoroutineScope coroutineScope;
                                                    Continuation continuation = (Continuation)coroutineScope;
                                                    coroutineScope = (CoroutineScope)((Object)var1_1);
                                                    var1_1 = this;
                                                    return (var1_1.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }, (Continuation)this);
                                            if (v0 == var2_2) {
                                                return var2_2;
                                            }
                                            ** GOTO lbl18
                                            break;
                                        }
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)var1_1);
                                        v0 = var1_1;
lbl18:
                                        // 2 sources

                                        if (!((Boolean)v0).booleanValue()) {
                                            FJ.a.a(FJ.a).info("priorityExecutor thread pool is still terminating!");
                                            ** continue;
                                        }
lbl21:
                                        // 3 sources

                                        while (true) {
                                            this.a = 2;
                                            v1 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), (Function2)new Function2<CoroutineScope, Continuation<? super Boolean>, Object>(this.b, null){
                                                private int a;
                                                private /* synthetic */ FJ b;
                                                {
                                                    this.b = fJ;
                                                    super(2, continuation);
                                                }

                                                public final Object invokeSuspend(Object object) {
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    ResultKt.throwOnFailure((Object)object);
                                                    return Boxing.boxBoolean((boolean)FJ.d(this.b).awaitTermination(5L, TimeUnit.SECONDS));
                                                }

                                                /*
                                                 * WARNING - void declaration
                                                 */
                                                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                                    void var2_2;
                                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                                }

                                                private Object a(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                                    FJ.2 var1_1;
                                                    CoroutineScope coroutineScope;
                                                    Continuation continuation = (Continuation)coroutineScope;
                                                    coroutineScope = (CoroutineScope)((Object)var1_1);
                                                    var1_1 = this;
                                                    return (var1_1.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }, (Continuation)this);
                                            if (v1 == var2_2) {
                                                return var2_2;
                                            }
                                            ** GOTO lbl30
                                            break;
                                        }
                                    }
                                    case 2: {
                                        ResultKt.throwOnFailure((Object)var1_1);
                                        v1 = var1_1;
lbl30:
                                        // 2 sources

                                        if (!((Boolean)v1).booleanValue()) {
                                            FJ.a.a(FJ.a).info("chunkDeleterExecutor thread pool is still terminating!");
                                            ** continue;
                                        }
                                        var1_1 = this.b;
                                        var1_1 = var1_1.f;
                                        for (Map.Entry v2 : var1_1.entrySet()) {
                                            var2_2 = v2;
                                            var2_2 = v2;
                                            var2_2 = (Long2ObjectMap)v2.getValue();
                                            var2_2 = (Map)var2_2;
                                            for (Map.Entry<K, V> v3 : var2_2.entrySet()) {
                                                var3_3 = v3;
                                                var3_3 = v3;
                                                var3_3 = (PhysShipImpl)v3.getValue();
                                                v4 = var3_3.getRigidBodyReference$impl().c();
                                                if (v4 == null) continue;
                                                v4.close();
                                            }
                                        }
                                        var1_1 = this.b;
                                        var1_1.f.clear();
                                        var1_1 = FJ.b(this.b);
                                        for (Map.Entry<K, V> v5 : var1_1.entrySet()) {
                                            var2_2 = v5;
                                            var2_2 = v5;
                                            var2_2 = (FQ)v5.getValue();
                                            var2_2.b();
                                        }
                                        FJ.b(this.b).clear();
                                        FJ.a.a(FJ.a).info("VSPhysicsPipelineStage is fully deleted!");
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            /*
                             * WARNING - void declaration
                             */
                            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                void var2_2;
                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                            }

                            private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                FJ.c c2;
                                CoroutineScope coroutineScope;
                                Continuation continuation = (Continuation)coroutineScope;
                                coroutineScope = (CoroutineScope)((Object)c2);
                                c2 = this;
                                return (c2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, 2, null);
                        ((FJ)object2).j = true;
                        ((FM)object).b = null;
                        object2 = ((FM)object).d;
                        ((FM)object).d.b = true;
                    }
                    break;
                }
                if (!this.j.getArePhysicsRunning()) {
                    this.l = 0L;
                    this.c.clear();
                    Lock lock = this.h;
                    lock.lock();
                    try {
                        while (!this.j.getArePhysicsRunning()) {
                            this.i.await();
                        }
                    }
                    finally {
                        lock.unlock();
                    }
                }
                double d4 = 1.0E9 / (double)this.k;
                double d5 = d4 / 1.0E9 * VSCoreConfig.SERVER.getPhysics().getPhysicsSpeed();
                long l2 = System.nanoTime();
                this.j.a(d5);
                long l3 = System.nanoTime() - l2;
                object = this;
                long l4 = System.currentTimeMillis();
                ((FI)object).c.add(l4);
                while (!((Collection)((FI)object).c).isEmpty() && ((Number)((FI)object).c.peek()).longValue() + 5000L < l4) {
                    ((FI)object).c.remove();
                }
                long l5 = l3;
                double d6 = d4;
                object = this;
                double d7 = d6 - (double)l5;
                if (d2 < 0.0) {
                    ((FI)object).l = Math.min(((FI)object).l - (long)d7, 1000000000L);
                    continue;
                }
                if ((double)((FI)object).l > d7) {
                    ((FI)object).l -= (long)d7;
                    continue;
                }
                double d8 = d7 - (double)((FI)object).l;
                ((FI)object).l = 0L;
                long l6 = (long)d8;
                long l7 = System.nanoTime();
                long l8 = l6 - 1000000L;
                LockSupport.parkNanos(l8);
                while (System.nanoTime() - l7 < l6) {
                    FY.a();
                }
            }
        }
        catch (Exception exception) {
            org.valkyrienskies.core.impl.shadow.FI$a.a(a).error("Error in physics pipeline background task", (Throwable)exception);
            for (int i2 = 0; i2 < 10; ++i2) {
                org.valkyrienskies.core.impl.shadow.FI$a.a(a).error("!!!!!!! VS PHYSICS THREAD CRASHED !!!!!!!");
            }
        }
        org.valkyrienskies.core.impl.shadow.FI$a.a(a).warn("Physics pipeline ending");
    }

    public final void g() {
        this.b = true;
    }

    private final void j() {
        long l2 = System.currentTimeMillis();
        this.c.add(l2);
        while (!((Collection)this.c).isEmpty() && ((Number)this.c.peek()).longValue() + 5000L < l2) {
            this.c.remove();
        }
    }

    private final void a(double d2, long l2) {
        double d3;
        double d4 = d2 - (double)l2;
        if (d3 < 0.0) {
            this.l = Math.min(this.l - (long)d4, 1000000000L);
            return;
        }
        if ((double)this.l > d4) {
            this.l -= (long)d4;
            return;
        }
        double d5 = d4 - (double)this.l;
        this.l = 0L;
        FI.a((long)d5);
    }

    private static void a(long l2) {
        long l3 = System.nanoTime();
        long l4 = l2 - 1000000L;
        LockSupport.parkNanos(l4);
        while (System.nanoTime() - l3 < l2) {
            FY.a();
        }
    }

    public final double h() {
        return (double)this.c.size() / 5.0;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\r"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FI$a;", "", "", "m", "J", "a", "", "n", "I", "b", "Lorg/apache/logging/log4j/Logger;", "o", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "c", "<init>", "()V"})
    public static final class a {
        static final /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = o;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = o;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return object;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(a.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            a = kPropertyArray2;
        }
    }
}

