/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  it.unimi.dsi.fastutil.booleans.BooleanConsumer
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.FunctionAdapter
 *  kotlin.jvm.internal.FunctionReferenceImpl
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;
import java.util.Map;
import javax.crypto.SecretKey;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.apache.logging.log4j.Logger;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.game.phys_entities.PhysicsEntityClient;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorld;
import org.valkyrienskies.core.impl.game.ships.ShipTransformImpl;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketRequestUdp;
import org.valkyrienskies.core.impl.networking.impl.PacketShipDataCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketShipRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketUdpState;
import org.valkyrienskies.core.impl.networking.impl.PhysEntityCreateData;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EX;
import org.valkyrienskies.core.impl.shadow.EZ;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.ea_2;
import org.valkyrienskies.core.impl.shadow.eb_2;
import org.valkyrienskies.core.impl.shadow.ec_2;
import org.valkyrienskies.core.impl.shadow.eo_0;
import org.valkyrienskies.core.impl.shadow.ep_0;
import org.valkyrienskies.core.impl.shadow.et_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fd_0;
import org.valkyrienskies.core.impl.shadow.fh_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fn_0;
import org.valkyrienskies.core.impl.shadow.fo_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.util.VSCoreUtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0002\b\u0012B+\b\u0007\u0012\b\b\u0001\u0010\u0006\u001a\u00020#\u0012\u0006\u00101\u001a\u00020\u001e\u0012\u0006\u00102\u001a\u00020*\u0012\u0006\u00103\u001a\u00020 \u00a2\u0006\u0004\b4\u00105J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0003\u0010\rJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\b\u0010\rJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\b\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0013\u00a2\u0006\u0004\b\b\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u0012\u001a\u00020\u00198\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\b\u0010\u001c\"\u0004\b\b\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0017\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010$\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010+R\u0016\u0010)\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010-\u001a\u00020/8CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u00100"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EL;", "", "", "c", "()V", "Lorg/valkyrienskies/core/impl/networking/impl/PacketPhysEntityCreate;", "p0", "Lkotlinx/coroutines/Job;", "a", "(Lorg/valkyrienskies/core/impl/networking/impl/PacketPhysEntityCreate;)Lkotlinx/coroutines/Job;", "Lorg/valkyrienskies/core/impl/networking/impl/PacketPhysEntityRemove;", "(Lorg/valkyrienskies/core/impl/networking/impl/PacketPhysEntityRemove;)Lkotlinx/coroutines/Job;", "Lorg/valkyrienskies/core/impl/shadow/EZ;", "(Lorg/valkyrienskies/core/impl/shadow/EZ;)V", "Lorg/valkyrienskies/core/impl/networking/impl/PacketShipDataCreate;", "(Lorg/valkyrienskies/core/impl/networking/impl/PacketShipDataCreate;)Lkotlinx/coroutines/Job;", "Lorg/valkyrienskies/core/impl/networking/impl/PacketShipRemove;", "(Lorg/valkyrienskies/core/impl/networking/impl/PacketShipRemove;)Lkotlinx/coroutines/Job;", "b", "Ljava/net/SocketAddress;", "(Ljava/net/SocketAddress;)V", "", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "e", "Ljava/util/List;", "", "g", "Z", "()Z", "(Z)V", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "d", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;", "h", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;", "Ljavax/crypto/SecretKey;", "f", "Ljavax/crypto/SecretKey;", "i", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "", "j", "I", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "p1", "p2", "p3", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;Lorg/valkyrienskies/core/impl/shadow/Fi;Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;Lorg/valkyrienskies/core/impl/shadow/Fb;)V"})
public final class EL {
    public static final a a = new a(null);
    private final ShipObjectClientWorld h;
    public final fi_0 b;
    public final SimplePacketNetworking c;
    public final fb_0 d;
    public List<? extends RegisteredListener> e;
    public SecretKey f;
    public volatile boolean g;
    private boolean i;
    private int j;
    private static final Logger k = FX.a("Man Eater");
    private static final BodyKinematicsFactory l = BodyKinematicsFactory.INSTANCE;

    @ec_2
    public EL(@ea_2 ShipObjectClientWorld shipObjectClientWorld, fi_0 fi_02, SimplePacketNetworking simplePacketNetworking, fb_0 fb_02) {
        Intrinsics.checkNotNullParameter((Object)shipObjectClientWorld, (String)"");
        Intrinsics.checkNotNullParameter((Object)fi_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)simplePacketNetworking, (String)"");
        Intrinsics.checkNotNullParameter((Object)fb_02, (String)"");
        this.h = shipObjectClientWorld;
        this.b = fi_02;
        this.c = simplePacketNetworking;
        this.d = fb_02;
        this.j = 100;
    }

    @JvmName(name="f")
    private final CoroutineScope f() {
        return this.h.getCoroutineScope();
    }

    @JvmName(name="a")
    public final boolean a() {
        return this.g;
    }

    @JvmName(name="a")
    public final void a(boolean bl) {
        this.g = true;
    }

    public final void b() {
        Object[] objectArray = new RegisteredListener[7];
        Object[] objectArray2 = objectArray;
        Object object = this.d;
        objectArray[0] = ((fb_0)object).d.a((EX)new FunctionAdapter(this){
            private /* synthetic */ EL a;
            {
                this.a = eL;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public final void handlePacket(EZ p0) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                EL.a(this.a, (EZ)var1_1);
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)new FunctionReferenceImpl(1, (Object)this.a, EL.class, "onShipTransform", "onShipTransform(Lorg/valkyrienskies/core/impl/networking/Packet;)V", 0);
            }

            /*
             * WARNING - void declaration
             */
            public final boolean equals(Object other) {
                if (other instanceof EX) {
                    if (other instanceof FunctionAdapter) {
                        void var1_1;
                        return Intrinsics.areEqual((Object)((FunctionAdapter)this).getFunctionDelegate(), (Object)((FunctionAdapter)var1_1).getFunctionDelegate());
                    }
                    return false;
                }
                return false;
            }

            public final int hashCode() {
                return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }
        });
        object = this.d;
        objectArray2[1] = ((fb_0)object).e.a((EX)new FunctionAdapter(this){
            private /* synthetic */ EL a;
            {
                this.a = eL;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public final void handlePacket(EZ p0) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                EL.b(this.a, (EZ)var1_1);
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)new FunctionReferenceImpl(1, (Object)this.a, EL.class, "onPhysEntityTransform", "onPhysEntityTransform(Lorg/valkyrienskies/core/impl/networking/Packet;)V", 0);
            }

            /*
             * WARNING - void declaration
             */
            public final boolean equals(Object other) {
                if (other instanceof EX) {
                    if (other instanceof FunctionAdapter) {
                        void var1_1;
                        return Intrinsics.areEqual((Object)((FunctionAdapter)this).getFunctionDelegate(), (Object)((FunctionAdapter)var1_1).getFunctionDelegate());
                    }
                    return false;
                }
                return false;
            }

            public final int hashCode() {
                return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }
        });
        object = this.d;
        objectArray2[2] = ((fb_0)object).c.a((EX)new FunctionAdapter(this){
            private /* synthetic */ EL a;
            {
                this.a = eL;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public final void handlePacket(EZ p0) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                EL.c(this.a, (EZ)var1_1);
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)new FunctionReferenceImpl(1, (Object)this.a, EL.class, "onShipDataDelta", "onShipDataDelta(Lorg/valkyrienskies/core/impl/networking/Packet;)V", 0);
            }

            /*
             * WARNING - void declaration
             */
            public final boolean equals(Object other) {
                if (other instanceof EX) {
                    if (other instanceof FunctionAdapter) {
                        void var1_1;
                        return Intrinsics.areEqual((Object)((FunctionAdapter)this).getFunctionDelegate(), (Object)((FunctionAdapter)var1_1).getFunctionDelegate());
                    }
                    return false;
                }
                return false;
            }

            public final int hashCode() {
                return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }
        });
        objectArray2[3] = this.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketShipDataCreate.class), (Function1)new Function1<PacketShipDataCreate, Unit>(this){

            private void a(PacketShipDataCreate packetShipDataCreate) {
                Intrinsics.checkNotNullParameter((Object)packetShipDataCreate, (String)"");
                EL.a((EL)this.receiver, packetShipDataCreate);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                k k2;
                PacketShipDataCreate packetShipDataCreate = (PacketShipDataCreate)((Object)k2);
                k2 = this;
                Intrinsics.checkNotNullParameter((Object)packetShipDataCreate, (String)"");
                EL.a((EL)k2.receiver, packetShipDataCreate);
                return Unit.INSTANCE;
            }
        });
        objectArray2[4] = this.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketShipRemove.class), (Function1)new Function1<PacketShipRemove, Unit>(this){

            private void a(PacketShipRemove packetShipRemove) {
                Intrinsics.checkNotNullParameter((Object)packetShipRemove, (String)"");
                EL.a((EL)this.receiver, packetShipRemove);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                l l2;
                PacketShipRemove packetShipRemove = (PacketShipRemove)((Object)l2);
                l2 = this;
                Intrinsics.checkNotNullParameter((Object)packetShipRemove, (String)"");
                EL.a((EL)l2.receiver, packetShipRemove);
                return Unit.INSTANCE;
            }
        });
        objectArray2[5] = this.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketPhysEntityCreate.class), (Function1)new Function1<PacketPhysEntityCreate, Unit>(this){

            private void a(PacketPhysEntityCreate packetPhysEntityCreate) {
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityCreate, (String)"");
                EL.a((EL)this.receiver, packetPhysEntityCreate);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                m m2;
                PacketPhysEntityCreate packetPhysEntityCreate = (PacketPhysEntityCreate)((Object)m2);
                m2 = this;
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityCreate, (String)"");
                EL.a((EL)m2.receiver, packetPhysEntityCreate);
                return Unit.INSTANCE;
            }
        });
        objectArray2[6] = this.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketPhysEntityRemove.class), (Function1)new Function1<PacketPhysEntityRemove, Unit>(this){

            private void a(PacketPhysEntityRemove packetPhysEntityRemove) {
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityRemove, (String)"");
                EL.a((EL)this.receiver, packetPhysEntityRemove);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                n n2;
                PacketPhysEntityRemove packetPhysEntityRemove = (PacketPhysEntityRemove)((Object)n2);
                n2 = this;
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityRemove, (String)"");
                EL.a((EL)n2.receiver, packetPhysEntityRemove);
                return Unit.INSTANCE;
            }
        });
        this.e = CollectionsKt.listOf((Object[])objectArray2);
        object = this.b;
        ((fi_0)object).b.b();
        object = this.b;
        ((fi_0)object).a.b();
    }

    public final void c() {
        List<? extends RegisteredListener> list = this.e;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            list = null;
        }
        fd_0.a((Iterable<? extends RegisteredListener>)list);
        this.f = null;
        fi_0 fi_02 = this.b;
        fi_02.b.c();
        fi_02 = this.b;
        fi_02.a.c();
    }

    private final Job a(PacketShipRemove packetShipRemove) {
        EL eL = this;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(packetShipRemove, this, null){
            private int a;
            private /* synthetic */ PacketShipRemove b;
            private /* synthetic */ EL c;
            {
                this.b = packetShipRemove;
                this.c = eL;
                super(2, continuation);
            }

            public final Object invokeSuspend(Object iterator2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure((Object)iterator2);
                iterator2 = this.b.getToRemove();
                ShipObjectClientWorld shipObjectClientWorld = this.c.h;
                iterator2 = iterator2.iterator();
                while (iterator2.hasNext()) {
                    Object t = iterator2.next();
                    long l2 = ((Number)t).longValue();
                    shipObjectClientWorld.removeShip(l2);
                }
                return Unit.INSTANCE;
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
                g g2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)g2);
                g2 = this;
                return (g2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 3, null);
    }

    private final Job a(PacketShipDataCreate packetShipDataCreate) {
        EL eL = this;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(packetShipDataCreate, this, null){
            private int a;
            private /* synthetic */ PacketShipDataCreate b;
            private /* synthetic */ EL c;
            {
                this.b = packetShipDataCreate;
                this.c = eL;
                super(2, continuation);
            }

            public final Object invokeSuspend(Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure((Object)object);
                object = this.b.getToCreate().iterator();
                while (object.hasNext()) {
                    Object object2 = object.next();
                    if (((et_0)this.c.h).getAllShips().getById(((ShipDataCommon)object2).getId()) == null) {
                        this.c.h.addShip((ShipDataCommon)object2);
                        continue;
                    }
                    ep_0 ep_02 = (ep_0)this.c.h.getShipObjects().get(Boxing.boxLong((long)((ShipDataCommon)object2).getId()));
                    if (ep_02 != null) {
                        object2 = ((ShipDataCommon)object2).getKinematics();
                        object = ep_02;
                        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                        ((ep_0)object).b = object2;
                    }
                    Throwable throwable = a.a().throwing((Throwable)new IllegalArgumentException("Received ship create packet for already loaded ship?!"));
                    Intrinsics.checkNotNullExpressionValue((Object)throwable, (String)"");
                    throw throwable;
                }
                boolean bl = true;
                object = this.c;
                this.c.g = true;
                return Unit.INSTANCE;
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
                e e2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)e2);
                e2 = this;
                return (e2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 3, null);
    }

    private final Job a(PacketPhysEntityCreate packetPhysEntityCreate) {
        EL eL = this;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(packetPhysEntityCreate, this, null){
            private int a;
            private /* synthetic */ PacketPhysEntityCreate b;
            private /* synthetic */ EL c;
            {
                this.b = packetPhysEntityCreate;
                this.c = eL;
                super(2, continuation);
            }

            public final Object invokeSuspend(Object iterator2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure((Object)iterator2);
                for (PhysEntityCreateData physEntityCreateData : this.b.getToCreate()) {
                    if (!this.c.h.getPhysicsEntities().containsKey(Boxing.boxLong((long)physEntityCreateData.getId()))) {
                        this.c.h.addPhysicsEntity(physEntityCreateData);
                        continue;
                    }
                    Throwable throwable = a.a().throwing((Throwable)new IllegalArgumentException("Received physics entity create packet for already loaded physics entity?!"));
                    Intrinsics.checkNotNullExpressionValue((Object)throwable, (String)"");
                    throw throwable;
                }
                return Unit.INSTANCE;
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
                c c2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)c2);
                c2 = this;
                return (c2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 3, null);
    }

    private final Job a(PacketPhysEntityRemove packetPhysEntityRemove) {
        EL eL = this;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(packetPhysEntityRemove, this, null){
            private int a;
            private /* synthetic */ PacketPhysEntityRemove b;
            private /* synthetic */ EL c;
            {
                this.b = packetPhysEntityRemove;
                this.c = eL;
                super(2, continuation);
            }

            public final Object invokeSuspend(Object iterator2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure((Object)iterator2);
                iterator2 = this.b.getToRemove();
                ShipObjectClientWorld shipObjectClientWorld = this.c.h;
                iterator2 = iterator2.iterator();
                while (iterator2.hasNext()) {
                    Object t = iterator2.next();
                    long l2 = ((Number)t).longValue();
                    shipObjectClientWorld.removePhysicsEntity(l2);
                }
                return Unit.INSTANCE;
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
                d d2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)d2);
                d2 = this;
                return (d2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 3, null);
    }

    private final void a(EZ eZ) {
        Object object = eZ;
        eZ = ((EZ)object).b.retain();
        object = this;
        BuildersKt.launch$default(((EL)object).h.getCoroutineScope(), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((ByteBuf)eZ, this, null){
            private int a;
            private /* synthetic */ ByteBuf b;
            private /* synthetic */ EL c;
            {
                this.b = byteBuf;
                this.c = eL;
                super(2, continuation);
            }

            public final Object invokeSuspend(Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure((Object)object);
                try {
                    while (this.b.isReadable()) {
                        long l2 = this.b.readLong();
                        object = (ep_0)((et_0)this.c.h).getLoadedShips().getById(l2);
                        if (object == null) {
                            a.a().warn("Received ship data delta for ship with unknown ID!");
                            Unit unit = Unit.INSTANCE;
                            return unit;
                        }
                        Object object2 = object;
                        fo_0<JsonNode> fo_02 = ((ep_0)object2).g;
                        ByteBuf byteBuf = this.b;
                        Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
                        Object object3 = byteBuf;
                        object2 = fo_02;
                        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
                        fn_0 fn_02 = ((fo_0)object2).a;
                        Object t = ((fo_0)object2).b;
                        Intrinsics.checkNotNull(t);
                        object3 = fn_02.a(t, (ByteBuf)object3);
                        Object t2 = object3;
                        ((fo_0)object2).b = t2;
                        object2 = (JsonNode)object3;
                        object3 = ((eo_0)object).a().getShipAABB();
                        VSJacksonUtil.INSTANCE.getDeltaMapper().readerForUpdating(((eo_0)object).a()).readValue((JsonNode)object2);
                        ((eo_0)object).a().setShipAABB((AABBic)object3);
                    }
                }
                catch (Exception exception) {
                    a.a().error("Failed reading ship delta", (Throwable)exception);
                }
                finally {
                    this.b.release();
                }
                return Unit.INSTANCE;
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
                f f2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)f2);
                f2 = this;
                return (f2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 3, null);
    }

    private final void b(EZ eZ) {
        eZ = eZ.b;
        a.a((ByteBuf)eZ, this.h.getShipObjects());
    }

    private final void c(EZ eZ) {
        eZ = eZ.b;
        a.b((ByteBuf)eZ, this.h.getPhysicsEntities());
    }

    public final void a(SocketAddress object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        fi_0 fi_02 = this.b;
        if (!fi_02.d && !this.i) {
            int n2 = this.j;
            this.j = n2 + -1;
            if (this.j <= 0) {
                SecretKey secretKey = this.f = fh_0.INSTANCE.a();
                Intrinsics.checkNotNull((Object)secretKey);
                BooleanConsumer booleanConsumer = arg_0 -> EL.a(this, arg_0);
                SecretKey secretKey2 = secretKey;
                SocketAddress socketAddress = object;
                object = this.b;
                Intrinsics.checkNotNullParameter((Object)socketAddress, (String)"");
                Intrinsics.checkNotNullParameter((Object)secretKey2, (String)"");
                Intrinsics.checkNotNullParameter((Object)booleanConsumer, (String)"");
                RegisteredListener registeredListener = ((fi_0)object).f;
                if (registeredListener != null) {
                    registeredListener.unregister();
                }
                SimplePacketNetworking simplePacketNetworking = ((fi_0)object).c;
                ((fi_0)object).f = simplePacketNetworking.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketUdpState.class), (Function1)new Function1<PacketUdpState, Unit>(booleanConsumer, socketAddress, (fi_0)object){
                    private /* synthetic */ BooleanConsumer $a;
                    private /* synthetic */ SocketAddress $b;
                    private /* synthetic */ fi_0 c;
                    {
                        this.$a = booleanConsumer;
                        this.$b = socketAddress;
                        this.c = fi_02;
                        super(1);
                    }

                    public final void a(PacketUdpState packetUdpState) {
                        Intrinsics.checkNotNullParameter((Object)packetUdpState, (String)"");
                        this.$a.accept(packetUdpState.getState());
                        if (packetUdpState.getState()) {
                            SocketAddress socketAddress = this.$b;
                            if (socketAddress instanceof InetSocketAddress && ((InetSocketAddress)socketAddress).getPort() != packetUdpState.getPort()) {
                                socketAddress = new InetSocketAddress(((InetSocketAddress)socketAddress).getAddress(), packetUdpState.getPort());
                            }
                            if (!fi_0.a(this.c, socketAddress, packetUdpState.getId())) {
                                fi_0.b(this.c);
                            }
                        }
                    }

                    /*
                     * WARNING - void declaration
                     */
                    public final /* synthetic */ Object invoke(Object p1) {
                        void var1_1;
                        this.a((PacketUdpState)var1_1);
                        return Unit.INSTANCE;
                    }
                });
                byte[] byArray = secretKey2.getEncoded();
                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"");
                simplePacketNetworking.sendToServer1(new PacketRequestUdp(0, byArray));
                this.j = 100;
            }
        }
    }

    private static final void a(EL eL, boolean bl) {
        if (!bl) {
            eL.i = true;
        }
    }

    public static final /* synthetic */ void a(EL eL, EZ eZ) {
        eZ = eZ.b;
        a.a((ByteBuf)eZ, eL.h.getShipObjects());
    }

    public static final /* synthetic */ void b(EL eL, EZ eZ) {
        eZ = eZ.b;
        a.b((ByteBuf)eZ, eL.h.getPhysicsEntities());
    }

    public static final /* synthetic */ void c(EL eL, EZ eZ) {
        Object object = eZ;
        eZ = ((EZ)object).b.retain();
        object = eL;
        BuildersKt.launch$default(((EL)object).h.getCoroutineScope(), null, null, (Function2)new /* invalid duplicate definition of identical inner class */, 3, null);
    }

    public static final /* synthetic */ Job a(EL eL, PacketShipDataCreate packetShipDataCreate) {
        EL eL2 = eL;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new /* invalid duplicate definition of identical inner class */, 3, null);
    }

    public static final /* synthetic */ Job a(EL eL, PacketShipRemove packetShipRemove) {
        EL eL2 = eL;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new /* invalid duplicate definition of identical inner class */, 3, null);
    }

    public static final /* synthetic */ Job a(EL eL, PacketPhysEntityCreate packetPhysEntityCreate) {
        EL eL2 = eL;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new /* invalid duplicate definition of identical inner class */, 3, null);
    }

    public static final /* synthetic */ Job a(EL eL, PacketPhysEntityRemove packetPhysEntityRemove) {
        EL eL2 = eL;
        return BuildersKt.launch$default(eL.h.getCoroutineScope(), null, null, (Function2)new /* invalid duplicate definition of identical inner class */, 3, null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ-\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\u0004\b\r\u0010\u000bR\u001b\u0010\r\u001a\u00020\u000e8CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EL$a;", "", "Lio/netty/buffer/ByteBuf;", "p0", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "Lorg/valkyrienskies/core/impl/game/phys_entities/PhysicsEntityClient;", "p1", "", "b", "(Lio/netty/buffer/ByteBuf;Ljava/util/Map;)V", "Lorg/valkyrienskies/core/impl/shadow/Ep;", "a", "Lorg/apache/logging/log4j/Logger;", "k", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "l", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "<init>", "()V"})
    public static final class a {
        private static /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = k;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public final void a(ByteBuf byteBuf, Map<Long, ep_0> map2) {
            Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
            Intrinsics.checkNotNullParameter(map2, (String)"");
            int n2 = byteBuf.readInt();
            try {
                while (byteBuf.isReadable()) {
                    long l2 = byteBuf.readLong();
                    ep_0 ep_02 = map2.get(l2);
                    if (ep_02 == null) {
                        this.a().debug("Received ship transform for ship with unknown id: " + l2);
                        byteBuf.skipBytes(120);
                        continue;
                    }
                    Object object = ep_02;
                    if (((ep_0)object).f >= n2) {
                        byteBuf.skipBytes(120);
                        continue;
                    }
                    object = VSCoreUtilKt.readVec3d(byteBuf);
                    Object object2 = VSCoreUtilKt.readVec3fAsDouble(byteBuf);
                    Quaterniond quaterniond = VSCoreUtilKt.read3FAsNormQuatd(byteBuf);
                    Vector3d vector3d = VSCoreUtilKt.readVec3d(byteBuf);
                    Vector3d vector3d2 = VSCoreUtilKt.readVec3fAsDouble(byteBuf);
                    Vector3d vector3d3 = VSCoreUtilKt.readVec3fAsDouble(byteBuf);
                    AABBi aABBi = VSCoreUtilKt.readAABBi(byteBuf);
                    object2 = l.create(vector3d2, vector3d3, vector3d, quaterniond, (Vector3dc)object2, (Vector3dc)object);
                    object = ep_02;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    ((ep_0)object).e = object2;
                    int n3 = n2;
                    object = ep_02;
                    ep_02.f = n3;
                    if (!aABBi.isValid()) continue;
                    ((eo_0)((Object)ep_02)).a().setShipAABB(aABBi);
                }
            }
            catch (Exception exception) {
                this.a().error("Something went wrong when reading ship transform packets", (Throwable)exception);
            }
        }

        public final void b(ByteBuf byteBuf, Map<Long, PhysicsEntityClient> map2) {
            Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
            Intrinsics.checkNotNullParameter(map2, (String)"");
            int n2 = byteBuf.readInt();
            try {
                while (byteBuf.isReadable()) {
                    long l2 = byteBuf.readLong();
                    PhysicsEntityClient physicsEntityClient = map2.get(l2);
                    if (physicsEntityClient == null) {
                        this.a().debug("Received ship transform for physics entity with unknown id: " + l2);
                        byteBuf.skipBytes(40);
                        continue;
                    }
                    if (physicsEntityClient.getLatestNetworkTTick() >= n2) {
                        byteBuf.skipBytes(40);
                        continue;
                    }
                    Vector3d vector3d = VSCoreUtilKt.readVec3d(byteBuf);
                    Quaterniond quaterniond = VSCoreUtilKt.read3FAsNormQuatd(byteBuf);
                    double d2 = byteBuf.readFloat();
                    physicsEntityClient.setLatestNetworkTransform(ShipTransformImpl.Companion.create(vector3d, new Vector3d(), quaterniond, new Vector3d(d2)));
                    physicsEntityClient.setLatestNetworkTTick(n2);
                }
            }
            catch (Exception exception) {
                this.a().error("Something went wrong when reading ship transform packets", (Throwable)exception);
            }
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

    @eb_2
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EL$b;", "", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;", "p0", "Lorg/valkyrienskies/core/impl/shadow/EL;", "a", "(Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;)Lorg/valkyrienskies/core/impl/shadow/EL;"})
    public static interface b {
        public EL a(ShipObjectClientWorld var1);
    }
}

