/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.concurrent.ThreadsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.ServerTickListener;
import org.valkyrienskies.core.impl.api_impl.config.ConfigPhysicsBackendType;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.FC;
import org.valkyrienskies.core.impl.shadow.FD;
import org.valkyrienskies.core.impl.shadow.FF;
import org.valkyrienskies.core.impl.shadow.FH;
import org.valkyrienskies.core.impl.shadow.FI;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.Iv;
import org.valkyrienskies.core.impl.shadow.Iz;
import org.valkyrienskies.core.impl.shadow.eq_0;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.et_0;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.physics_api_krunch.KrunchDebug;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020-\u0012\u0006\u00101\u001a\u00020\u001e\u0012\b\u00102\u001a\u0004\u0018\u00010(\u0012\u0006\u00103\u001a\u00020#\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0007J\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00138\u0017@WX\u0097\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u00138WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u0014\u0010\u001f\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010$\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010'R\u0018\u0010\u0014\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u001a\u001a\u00020-8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b\u0011\u0010/R$\u00100\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00138\u0007@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FM;", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "", "computePhysTps", "()D", "", "c", "()V", "", "getLoadedVoxelChunks", "()I", "Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "getPhysicsBackendType", "()Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "postTickGame", "preTickGame", "p0", "a", "(D)V", "", "g", "Z", "getArePhysicsRunning", "()Z", "setArePhysicsRunning", "(Z)V", "i", "getDeleteResources", "setDeleteResources", "b", "Lorg/valkyrienskies/core/impl/shadow/FD;", "e", "Lorg/valkyrienskies/core/impl/shadow/FD;", "isUsingDummyPhysics", "d", "Lorg/valkyrienskies/core/impl/shadow/FF;", "f", "Lorg/valkyrienskies/core/impl/shadow/FF;", "Lorg/valkyrienskies/core/impl/shadow/FI;", "Lorg/valkyrienskies/core/impl/shadow/FI;", "Lorg/valkyrienskies/core/impl/shadow/FJ;", "Lorg/valkyrienskies/core/impl/shadow/FJ;", "Ljava/lang/Thread;", "h", "Ljava/lang/Thread;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "()Lorg/valkyrienskies/core/impl/shadow/Er;", "j", "p1", "p2", "p3", "Lorg/valkyrienskies/core/impl/shadow/EU;", "p4", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Er;Lorg/valkyrienskies/core/impl/shadow/FD;Lorg/valkyrienskies/core/impl/shadow/FJ;Lorg/valkyrienskies/core/impl/shadow/FF;Lorg/valkyrienskies/core/impl/shadow/EU;)V"})
public final class FM
implements VsiPipeline {
    public final er_0 a;
    private final FD e;
    FJ b;
    private final FF f;
    volatile boolean c;
    final FI d;
    private volatile boolean g;
    private final Thread h;
    private boolean i;

    @Inject
    public FM(er_0 er_02, FD fD, FJ fJ, FF fF, EU eU) {
        Intrinsics.checkNotNullParameter((Object)er_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)fD, (String)"");
        Intrinsics.checkNotNullParameter((Object)fF, (String)"");
        Intrinsics.checkNotNullParameter((Object)eU, (String)"");
        this.a = er_02;
        this.e = fD;
        this.b = fJ;
        this.f = fF;
        this.c = VSCoreConfig.SERVER.getPt().getSynchronizePhysics();
        this.d = new FI(this, 0, 2, null);
        this.g = !eU.isPhysicalClient();
        this.h = ThreadsKt.thread$default((boolean)true, (boolean)false, null, (String)"Physics thread", (int)8, (Function0)((Function0)new Function0<Unit>(this){
            private /* synthetic */ FM a;
            {
                this.a = fM;
                super(0);
            }

            public final void a() {
                this.a.d.run();
            }

            public final /* synthetic */ Object invoke() {
                this.a();
                return Unit.INSTANCE;
            }
        }), (int)6, null);
    }

    @JvmName(name="a")
    public final er_0 a() {
        return this.a;
    }

    @JvmName(name="b")
    public final boolean b() {
        return this.c;
    }

    @Override
    @JvmName(name="getArePhysicsRunning")
    public final boolean getArePhysicsRunning() {
        return this.g;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setArePhysicsRunning")
    public final void setArePhysicsRunning(boolean value) {
        void var1_1;
        this.g = value;
        if (var1_1 != false) {
            FI fI = this.d;
            Lock lock = fI.h;
            lock.lock();
            try {
                fI = this.d;
                fI.i.signal();
                return;
            }
            finally {
                lock.unlock();
            }
        }
    }

    @Override
    @JvmName(name="getDeleteResources")
    public final boolean getDeleteResources() {
        return this.i;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setDeleteResources")
    public final void setDeleteResources(boolean bl) {
        void var1_1;
        this.i = var1_1;
    }

    @Override
    @JvmName(name="isUsingDummyPhysics")
    public final boolean isUsingDummyPhysics() {
        FJ fJ = this.b;
        Intrinsics.checkNotNull((Object)fJ);
        FJ fJ2 = fJ;
        return fJ.o;
    }

    @Override
    public final void preTickGame() {
        Object object;
        boolean bl = this.c;
        this.c = VSCoreConfig.SERVER.getPt().getSynchronizePhysics();
        if (bl) {
            Object object2 = this.d;
            object2 = ((FI)object2).e;
            object2.lock();
            try {
                boolean bl2 = false;
                object = this.d;
                this.d.d = 0;
                object = this.d;
                ((FI)object).g.signal();
            }
            finally {
                object2.unlock();
            }
        }
        object = this.e;
        Iterator iterator2 = ((et_0)((FD)object).b).getLoadedShips();
        Iterator iterator3 = iterator2.iterator();
        while (iterator3.hasNext()) {
            iterator2 = iterator3.next();
            eq_0 eq_02 = (eq_0)((Object)iterator2);
            iterator2 = eq_02;
            iterator2 = eq_02;
            iterator2 = eq_02.f.values();
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                Object object3 = iterator2.next();
                object3 = (ServerTickListener)object3;
                object3.onServerTick();
            }
        }
        ((et_0)((FD)object).b).preTick();
    }

    @Override
    public final void postTickGame() {
        Object object;
        Object object2;
        if (this.c) {
            object2 = this.d;
            object2 = ((FI)object2).e;
            object2.lock();
            try {
                int n2 = VSCoreConfig.SERVER.getPt().getPhysicsTicksPerGameTick();
                while (true) {
                    object = this.d;
                    if (((FI)object).d >= n2) break;
                    object = this.d;
                    ((FI)object).f.await();
                }
            }
            finally {
                object2.unlock();
            }
        }
        object2 = this.e.b();
        FJ fJ = this.b;
        Intrinsics.checkNotNull((Object)fJ);
        object = fJ;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        if (((FJ)object).d.size() >= 800) {
            FJ.a.a(FJ.a).warn("Too many game frames in the game frame queue. Is the physics stage broken?");
            Thread.sleep(1000L);
        }
        ((FJ)object).d.add((FC)object2);
    }

    public final void c() {
        if (this.getDeleteResources()) {
            this.setArePhysicsRunning(true);
            FJ fJ = this.b;
            Intrinsics.checkNotNull((Object)fJ);
            fJ.k();
            this.b = null;
            FI fI = this.d;
            this.d.b = true;
        }
    }

    public final void a(double d2) {
        FJ fJ = this.b;
        Intrinsics.checkNotNull((Object)fJ);
        FH fH = fJ.a(d2, true);
        FJ fJ2 = this.b;
        Intrinsics.checkNotNull((Object)fJ2);
        this.e.a(fJ2);
        this.e.a(fH);
        this.f.a(fH);
    }

    @Override
    public final double computePhysTps() {
        FI fI = this.d;
        return (double)fI.c.size() / 5.0;
    }

    @Override
    public final int getLoadedVoxelChunks() {
        return KrunchDebug.getVoxelChunkCount();
    }

    @Override
    public final ConfigPhysicsBackendType getPhysicsBackendType() {
        FJ fJ = this.b;
        Intrinsics.checkNotNull((Object)fJ);
        Object object = fJ;
        object = fJ.h;
        switch (org.valkyrienskies.core.impl.shadow.FM$a.a[((Iv)object).g.ordinal()]) {
            case 1: {
                return ConfigPhysicsBackendType.KRUNCH_CLASSIC;
            }
            case 2: {
                return ConfigPhysicsBackendType.KRUNCH_PHYSX;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    public final class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] nArray = new int[Iz.values().length];
            try {
                nArray[Iz.KRUNCH_CLASSIC.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[Iz.KRUNCH_PHYSX.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = nArray;
        }
    }
}

