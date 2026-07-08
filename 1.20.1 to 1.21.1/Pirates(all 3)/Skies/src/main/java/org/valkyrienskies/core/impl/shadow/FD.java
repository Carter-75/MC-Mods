/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  org.valkyrienskies.core.impl.shadow.Er
 *  org.valkyrienskies.core.impl.shadow.Ha
 *  org.valkyrienskies.core.impl.shadow.Hc
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.joml.Matrix3d;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.ships.ServerShipTransformProvider;
import org.valkyrienskies.core.api.ships.ServerTickListener;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.chunk_tracking.ShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.game.ships.ShipInertiaDataImpl;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.game.ships.ShipTransformImpl;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.ER;
import org.valkyrienskies.core.impl.shadow.Er;
import org.valkyrienskies.core.impl.shadow.FA;
import org.valkyrienskies.core.impl.shadow.FB;
import org.valkyrienskies.core.impl.shadow.FC;
import org.valkyrienskies.core.impl.shadow.FH;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.Ha;
import org.valkyrienskies.core.impl.shadow.Hc;
import org.valkyrienskies.core.impl.shadow.ek_0;
import org.valkyrienskies.core.impl.shadow.eo_0;
import org.valkyrienskies.core.impl.shadow.eq_0;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.et_0;
import org.valkyrienskies.core.impl.shadow.fy_0;
import org.valkyrienskies.core.impl.shadow.fz_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.internal.joints.VSJointAndId;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSVoxelCollisionShapeData;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiPlayerState;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0011\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0005\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0005\u0010\tJ\r\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\rJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00168CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FD;", "", "Lorg/valkyrienskies/core/impl/shadow/FH;", "p0", "", "b", "(Lorg/valkyrienskies/core/impl/shadow/FH;)V", "Lorg/valkyrienskies/core/impl/shadow/FC;", "f", "()Lorg/valkyrienskies/core/impl/shadow/FC;", "Lorg/valkyrienskies/core/impl/shadow/FJ;", "a", "(Lorg/valkyrienskies/core/impl/shadow/FJ;)V", "()V", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "e", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "c", "Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "d", "Ljavax/inject/Provider;", "()Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "Ljavax/inject/Provider;", "p1", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Er;Ljavax/inject/Provider;)V"})
public final class FD {
    public static final a a;
    private static /* synthetic */ KProperty<Object>[] c;
    final er_0 b;
    private final Provider d;
    private final ConcurrentLinkedQueue<FH> e;
    private final BodyKinematicsFactory f;
    private static int g = 20;
    private static final BodyKinematicsFactory h;
    private static final Logger i;

    @Inject
    public FD(er_0 er_02, Provider<VSCoreInternal> provider) {
        Intrinsics.checkNotNullParameter((Object)er_02, (String)"");
        Intrinsics.checkNotNullParameter(provider, (String)"");
        this.b = er_02;
        this.d = provider;
        this.e = new ConcurrentLinkedQueue();
        this.f = BodyKinematicsFactory.INSTANCE;
    }

    @JvmName(name="e")
    private final VSCoreInternal e() {
        return (VSCoreInternal)FV.a(this.d, c[0]);
    }

    public final void a(FH fH) {
        Intrinsics.checkNotNullParameter((Object)fH, (String)"");
        if (this.e.size() >= 800) {
            org.valkyrienskies.core.impl.shadow.FD$a.a(a).warn("Too many physics frames in the physics frame queue. Is the game stage broken?");
            Thread.sleep(1000L);
        }
        this.e.add(fH);
    }

    public final void a(FJ fJ) {
        Intrinsics.checkNotNullParameter((Object)fJ, (String)"");
        FJ fJ2 = fJ;
        fJ2.k.forEach((arg_0, arg_1) -> FD.a((Function2)new Function2<Pair<? extends Long, ? extends Long>, CollisionEvent, Unit>(this){
            private /* synthetic */ FD a;
            {
                this.a = fD;
                super(2);
            }

            public final void a(Pair<Long, Long> pair, CollisionEvent collisionEvent) {
                Intrinsics.checkNotNullParameter(pair, (String)"");
                Intrinsics.checkNotNullParameter((Object)collisionEvent, (String)"");
                FD.a(this.a).getCollisionStartEvent().emit(collisionEvent);
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                void var2_2;
                void var1_1;
                this.a((Pair<Long, Long>)((Pair)var1_1), (CollisionEvent)var2_2);
                return Unit.INSTANCE;
            }
        }, arg_0, arg_1));
        fJ2 = fJ;
        fJ2.k.clear();
        fJ2 = fJ;
        fJ2.l.forEach((arg_0, arg_1) -> FD.b((Function2)new Function2<Pair<? extends Long, ? extends Long>, CollisionEvent, Unit>(this){
            private /* synthetic */ FD a;
            {
                this.a = fD;
                super(2);
            }

            public final void a(Pair<Long, Long> pair, CollisionEvent collisionEvent) {
                Intrinsics.checkNotNullParameter(pair, (String)"");
                Intrinsics.checkNotNullParameter((Object)collisionEvent, (String)"");
                FD.a(this.a).getCollisionEndEvent().emit(collisionEvent);
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                void var2_2;
                void var1_1;
                this.a((Pair<Long, Long>)((Pair)var1_1), (CollisionEvent)var2_2);
                return Unit.INSTANCE;
            }
        }, arg_0, arg_1));
        fJ2 = fJ;
        fJ2.l.clear();
        fJ2 = fJ;
        fJ2.m.forEach((arg_0, arg_1) -> FD.c((Function2)new Function2<Pair<? extends Long, ? extends Long>, CollisionEvent, Unit>(this){
            private /* synthetic */ FD a;
            {
                this.a = fD;
                super(2);
            }

            public final void a(Pair<Long, Long> pair, CollisionEvent collisionEvent) {
                Intrinsics.checkNotNullParameter(pair, (String)"");
                Intrinsics.checkNotNullParameter((Object)collisionEvent, (String)"");
                FD.a(this.a).getCollisionPersistEvent().emit(collisionEvent);
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                void var2_2;
                void var1_1;
                this.a((Pair<Long, Long>)((Pair)var1_1), (CollisionEvent)var2_2);
                return Unit.INSTANCE;
            }
        }, arg_0, arg_1));
        fJ2 = fJ;
        fJ2.m.clear();
    }

    public final void a() {
        Object object = ((et_0)this.b).getLoadedShips();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            eq_0 eq_02 = (eq_0)object2;
            object2 = eq_02;
            object2 = eq_02;
            object2 = eq_02.f.values();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (ServerTickListener)object3;
                object3.onServerTick();
            }
        }
        ((et_0)this.b).preTick();
    }

    public final FC b() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        Collection collection;
        Object object8;
        Object object9;
        Object object10;
        List<fy_0> list;
        List<fy_0> list2;
        Object object11;
        Object object12;
        Object object13;
        Iterator iterator2;
        Object object14;
        Object object15;
        Object object1622;
        Object object17 = ((et_0)this.b).getLoadedShips();
        Object object18 = object17.iterator();
        while (object18.hasNext()) {
            object1622 = object18.next();
            object15 = (Long2ObjectMap)object1622;
            object14 = object15;
            object15.b.updatePrevTickShipTransform();
        }
        while (!((Collection)this.e).isEmpty()) {
            object17 = (FH)this.e.remove();
            Intrinsics.checkNotNullExpressionValue(object17, (String)"");
            object1622 = object17;
            object17 = this;
            object14 = object1622;
            object18 = (Map)((FH)object14).a;
            iterator2 = object18.entrySet().iterator();
            while (iterator2.hasNext()) {
                Object object16;
                Object object20 = object13 = iterator2.next();
                object12 = (Long)object13.getKey();
                object11 = (FA)object20.getValue();
                VsiQueryableShipData vsiQueryableShipData = ((et_0)((FD)object17).b).getLoadedShips();
                Intrinsics.checkNotNullExpressionValue((Object)object12, (String)"");
                list2 = (eq_0)vsiQueryableShipData.getById((Long)object12);
                if (list2 != null) {
                    object14 = list2;
                    object16 = ((eq_0)((Object)list2)).b;
                } else {
                    object16 = list = null;
                }
                if (object16 != null) {
                    object14 = object11;
                    boolean bl = ((eq_0)((Object)list2)).getShipTeleportId() == ((FA)object14).d;
                    if (!bl) continue;
                    Intrinsics.checkNotNullExpressionValue((Object)object11, (String)"");
                    object20 = org.valkyrienskies.core.impl.shadow.FD$a.a((FA)object11, (ServerShipInternal)((Object)list));
                    ((ShipDataCommon)((Object)list)).setKinematics((BodyKinematics)object20);
                    continue;
                }
                object14 = ((FD)object17).b;
                PhysicsEntityServer physicsEntityServer = (PhysicsEntityServer)((Er)object14).f.get(object12);
                if (physicsEntityServer != null) {
                    object14 = object11;
                    boolean bl = physicsEntityServer.getShipTeleportId() == ((FA)object14).d;
                    if (!bl) continue;
                    object14 = object11;
                    hc_0 hc_02 = ((FA)object14).a;
                    object14 = hc_02;
                    object14 = object11;
                    object14 = ((FA)object14).a;
                    object10 = ShipTransformImpl.Companion.create(((Hc)hc_02).b, new Vector3d(), ((Hc)object14).c);
                    object14 = object11;
                    object14 = ((FA)object14).a;
                    physicsEntityServer.setLinearVelocity(((Hc)object14).d);
                    object14 = object11;
                    object14 = ((FA)object14).a;
                    physicsEntityServer.setAngularVelocity(((Hc)object14).e);
                    physicsEntityServer.setShipTransform((ShipTransform)object10);
                    continue;
                }
                if (((FD)object17).b.getDimensionToGroundBodyIdImmutable().containsValue(object12)) continue;
                org.valkyrienskies.core.impl.shadow.FD$a.a(a).warn("Received physics frame update for ship with ShipId: " + (Long)object12 + ", but a ship with this ShipId does not exist!");
            }
        }
        for (Object object1622 : (Iterable)((et_0)this.b).getLoadedShips()) {
            Vector3dc vector3dc;
            ServerShipTransformProvider serverShipTransformProvider = ((eq_0)object1622).getTransformProvider();
            object18 = serverShipTransformProvider != null ? serverShipTransformProvider.provideNextTransformAndVelocity(((eo_0)object1622).getPrevTickTransform(), ((eo_0)object1622).getTransform()) : null;
            if (object18 == null) continue;
            object14 = object1622;
            ShipData shipData = ((eq_0)object14).b;
            Vector3dc vector3dc2 = ((ServerShipTransformProvider.NextTransformAndVelocityData)object18).getNextVel();
            if (vector3dc2 == null) {
                object14 = object1622;
                vector3dc2 = ((eq_0)object14).b.getKinematics().getVelocity();
            }
            if ((vector3dc = ((ServerShipTransformProvider.NextTransformAndVelocityData)object18).getNextOmega()) == null) {
                object14 = object1622;
                vector3dc = ((eq_0)object14).b.getKinematics().getAngularVelocity();
            }
            shipData.setKinematics(this.f.create(vector3dc2, vector3dc, ((ServerShipTransformProvider.NextTransformAndVelocityData)object18).getNextTransform()));
            object14 = object1622;
            ((eq_0)object14).b.setNeedsUpdating(true);
            Object object19 = object1622;
            int n2 = ((eq_0)object19).getShipTeleportId() + 1;
            object14 = object19;
            ((eq_0)object19).c = n2;
        }
        this.b.h();
        object17 = this;
        object1622 = new ArrayList();
        object18 = new ArrayList();
        object15 = ER.a(new Pair[0]);
        iterator2 = ER.a(new Pair[0]);
        Object object22 = ((FD)object17).b;
        ((Er)object22).e.a(er_0.c.GET_CURRENT_TICK_CHANGES);
        er_0 er_02 = object22;
        object22 = object13 = er_02.new er_0.a(((Er)er_02).k, ((Er)object22).l, ((Er)object22).m, ((Er)object22).n, ((Er)object22).o, ((Er)object22).p, (Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>>)((Er)object22).w, ((Er)object22).h, ((Er)object22).i, ((Er)object22).r, ((Er)object22).s.values(), ((Er)object22).t, ((Er)object22).u, ((Er)object22).v);
        Iterable iterable = ((er_0.a)object13).h;
        Object object23 = ((er_0.a)object22).er_0.this;
        Object object2422 = iterable;
        Object object25 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        Iterator iterator3 = object2422.iterator();
        while (iterator3.hasNext()) {
            object9 = iterator3.next();
            object8 = (String)object9;
            Collection collection2 = object25;
            Object v = Er.a((er_0)object23).get(object8);
            Intrinsics.checkNotNull(v);
            collection2.add(new Pair(object8, v));
        }
        Object object26 = (List)object25;
        object22 = object13;
        object10 = ((er_0.a)object22).a;
        object22 = object13;
        object12 = ((er_0.a)object22).b;
        object22 = object13;
        object11 = ((er_0.a)object22).c;
        object22 = object13;
        list2 = ((er_0.a)object22).d;
        object22 = object13;
        object23 = ((er_0.a)object22).i;
        er_0 er_03 = ((er_0.a)object22).er_0.this;
        object25 = object23;
        Collection collection3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object23, (int)10));
        object9 = object25.iterator();
        while (object9.hasNext()) {
            object8 = object9.next();
            String string = object8;
            collection = collection3;
            Object v = Er.a((er_0)er_03).get(string);
            Intrinsics.checkNotNull(v);
            collection.add(((Number)v).longValue());
        }
        iterable = (List)collection3;
        object23 = ((er_0.a)object22).e;
        collection = (Collection)iterable;
        object2422 = object23;
        object25 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object23, (int)10));
        iterator3 = object2422.iterator();
        while (iterator3.hasNext()) {
            object9 = iterator3.next();
            object8 = (ShipData)object9;
            Object object27 = object25;
            object27.add(((ShipDataCommon)object8).getId());
        }
        list = CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)collection, (Iterable)((List)object25)), (Iterable)((er_0.a)object22).f);
        object22 = object13;
        Object object28 = ((er_0.a)object22).g;
        object26 = (Iterable)object26;
        Object object29 = object26.iterator();
        while (object29.hasNext()) {
            object7 = object29.next();
            object7 = (Pair)object7;
            String string = (String)object7.getFirst();
            long l2 = ((Number)object7.getSecond()).longValue();
            object6 = ((FD)object17).b.a(string);
            object5 = new Vector3i(Integer.MIN_VALUE, ((LevelYRange)object6).getMinY(), Integer.MIN_VALUE);
            object4 = new Vector3i(Integer.MAX_VALUE, ((LevelYRange)object6).getMaxY(), Integer.MAX_VALUE);
            object26 = Ha.a.a();
            ek_0 ek_02 = new ek_0(10.0, new Matrix3d(10.0, 0.0, 0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 10.0), new Vector3d(0.5, 0.5, 0.5), false, 8, null);
            hc_0 hc_03 = hc_0.a.a(new Vector3d(0.5, 0.5, 0.5), new Quaterniond());
            VSVoxelCollisionShapeData vSVoxelCollisionShapeData = new VSVoxelCollisionShapeData((Vector3ic)object5, (Vector3ic)object4, (AABBic)object26, false, null);
            object26 = new fz_0(l2, string, vSVoxelCollisionShapeData, 1.0, ek_02, new ShipPhysicsData(new Vector3d(), new Vector3d()), hc_03, true, null, CollectionsKt.emptyList(), null, 0, -1, 0.3, 0.3, 0.6, true);
            ((ArrayList)object1622).add(object26);
        }
        object26 = (Iterable)object10;
        object29 = object26.iterator();
        while (object29.hasNext()) {
            object7 = object29.next();
            object14 = object7 = (eq_0)object7;
            long l3 = ((eq_0)object7).b.getId();
            object3 = new Vector3i();
            object6 = new Vector3i();
            object5 = ((FD)object17).b.a(((eo_0)object7).getChunkClaimDimension());
            object4 = ((eo_0)object7).getShipAABB();
            if (object4 != null) {
                ((Vector3i)object3).set(object4.minX(), object4.minY(), object4.minZ());
                ((Vector3i)object6).set(object4.maxX(), object4.maxY(), object4.maxZ());
            } else {
                object14 = object7;
                ((Vector3i)object3).set(((eq_0)object14).b.getTransform().getPositionInShip());
                object14 = object7;
                ((Vector3i)object6).set(((eq_0)object14).b.getTransform().getPositionInShip());
            }
            object26 = ChunkClaim.getTotalVoxelRegion$default(((eo_0)object7).getChunkClaim(), (LevelYRange)object5, null, 2, null);
            object14 = object7;
            double d2 = ((eq_0)object14).b.getTransform().getShipToWorldScaling().x();
            Object object20 = object7;
            object14 = object20;
            object14 = object7;
            object10 = hc_0.a.a(((eq_0)object20).b.getTransform().getPositionInWorld(), ((eq_0)object14).b.getTransform().getShipToWorldRotation());
            object14 = object7;
            boolean bl = ((eq_0)object14).b.isStatic();
            object14 = object7;
            PhysPose physPose = ((eq_0)object14).b.getKinematicTarget();
            object14 = object7;
            boolean bl2 = ((eq_0)object14).b.areVoxelsFullyLoaded();
            Intrinsics.checkNotNull((Object)((eq_0)object7).getAttachment(WingManager.class));
            int n3 = ((eq_0)object7).getShipTeleportId();
            Vector3ic vector3ic2 = (Vector3ic)object3;
            vector3ic2 = (Vector3ic)object6;
            AABBic aABBic = (AABBic)object26;
            object14 = object7;
            IShipActiveChunksSet iShipActiveChunksSet = ((eq_0)object14).b.getActiveChunksSet();
            Intrinsics.checkNotNull((Object)iShipActiveChunksSet);
            object2 = new VSVoxelCollisionShapeData(vector3ic, vector3ic2, aABBic, bl2, ((ShipActiveChunksSet)iShipActiveChunksSet).clone());
            Object object21 = object7;
            object14 = object21;
            Object object24 = object7;
            object14 = object24;
            Object object27 = object7;
            object14 = object27;
            object14 = object7;
            object14 = object7;
            object26 = new fz_0(l3, ((eq_0)object21).b.getChunkClaimDimension(), (VSCollisionShapeData)object2, d2, ((eq_0)object24).b.getInertiaData().copyToPhyInertia(d2), new ShipPhysicsData(((eq_0)object27).b.getKinematics().getVelocity(), ((eq_0)object14).b.getKinematics().getAngularVelocity()), (hc_0)object10, bl, physPose, CollectionsKt.toMutableList(((eq_0)object14).e.values()), object.getWingChanges(), n3, -1, 0.3, 0.3, 0.6, false);
            ((ArrayList)object1622).add(object26);
        }
        object26 = (Iterable)object12;
        object29 = object26.iterator();
        while (object29.hasNext()) {
            object7 = object29.next();
            object7 = (PhysicsEntityServer)object7;
            long l4 = ((PhysicsEntityServer)object7).getId();
            object3 = ((PhysicsEntityServer)object7).getDimensionId();
            object6 = hc_0.a.a(((PhysicsEntityServer)object7).getShipTransform().getPositionInWorld(), ((PhysicsEntityServer)object7).getShipTransform().getShipToWorldRotation());
            boolean bl = ((PhysicsEntityServer)object7).isStatic();
            int n4 = ((PhysicsEntityServer)object7).getShipTeleportId();
            object10 = ((PhysicsEntityServer)object7).getCollisionShapeData();
            ShipPhysicsData shipPhysicsData = new ShipPhysicsData(((PhysicsEntityServer)object7).getLinearVelocity(), ((PhysicsEntityServer)object7).getAngularVelocity());
            int n5 = ((PhysicsEntityServer)object7).getCollisionMask();
            double d3 = ((PhysicsEntityServer)object7).getStaticFrictionCoefficient();
            double d4 = ((PhysicsEntityServer)object7).getDynamicFrictionCoefficient();
            double d5 = ((PhysicsEntityServer)object7).getRestitutionCoefficient();
            ShipInertiaData shipInertiaData = ((PhysicsEntityServer)object7).getInertiaData();
            Intrinsics.checkNotNull((Object)shipInertiaData);
            object26 = new fz_0(l4, (String)object3, (VSCollisionShapeData)object10, 1.0, ShipInertiaDataImpl.copyToPhyInertia$default((ShipInertiaDataImpl)shipInertiaData, 0.0, 1, null), shipPhysicsData, (hc_0)object6, bl, null, CollectionsKt.toMutableList((Collection)((PhysicsEntityServer)object7).getPhysicsListeners()), null, n4, n5, d3, d4, d5, false);
            ((ArrayList)object1622).add(object26);
        }
        object26 = (Iterable)object11;
        object29 = object26.iterator();
        while (object29.hasNext()) {
            WingManager wingManager;
            object7 = object29.next();
            object14 = object7 = (eq_0)object7;
            long l5 = ((eq_0)object7).b.getId();
            object14 = object7;
            double d6 = ((eq_0)object14).b.getTransform().getShipToWorldScaling().x();
            object14 = object7;
            boolean bl = ((eq_0)object14).b.isStatic();
            object14 = object7;
            object4 = ((eq_0)object14).b.getKinematicTarget();
            object14 = object7;
            boolean bl3 = ((eq_0)object14).b.areVoxelsFullyLoaded();
            Intrinsics.checkNotNull((Object)((eq_0)object7).getAttachment(WingManager.class));
            int n6 = ((eq_0)object7).getShipTeleportId();
            object14 = object7;
            object10 = ((eq_0)object14).b.getTransform().getPositionInWorld();
            object14 = object7;
            Quaterniondc quaterniondc = ((eq_0)object14).b.getTransform().getShipToWorldRotation();
            Vector3dc vector3dc = ((eo_0)object7).getKinematics().getVelocity();
            Vector3dc vector3dc3 = ((eo_0)object7).getKinematics().getAngularVelocity();
            AABBic aABBic = ((eo_0)object7).getShipAABB();
            if (aABBic == null) {
                Object object30 = object7;
                object14 = object30;
                object14 = object7;
                aABBic = new AABBi(new Vector3i().set(((eq_0)object30).b.getTransform().getPositionInShip()), new Vector3i().set(((eq_0)object14).b.getTransform().getPositionInShip()));
            }
            object = aABBic;
            Object object31 = object7;
            object14 = object31;
            object14 = object7;
            FB fB = new FB(l5, d6, ((eq_0)object31).b.getInertiaData().copyToPhyInertia(d6), new ShipPhysicsData(((eo_0)object7).getKinematics().getVelocity(), ((eo_0)object7).getKinematics().getAngularVelocity()), bl, (PhysPose)object4, bl3, CollectionsKt.toMutableList(((eq_0)object14).e.values()), wingManager.getWingChanges(), n6, (Vector3dc)object10, quaterniondc, vector3dc, vector3dc3, (AABBic)object);
            object2 = l5;
            ((Map)object15).put(object2, fB);
        }
        Object object36 = list2;
        object29 = object36.iterator();
        while (object29.hasNext()) {
            object7 = object29.next();
            object7 = (PhysicsEntityServer)object7;
            long l6 = ((PhysicsEntityServer)object7).getId();
            boolean bl = ((PhysicsEntityServer)object7).isStatic();
            int n7 = ((PhysicsEntityServer)object7).getShipTeleportId();
            Vector3dc vector3dc = ((PhysicsEntityServer)object7).getShipTransform().getPositionInWorld();
            object10 = ((PhysicsEntityServer)object7).getShipTransform().getShipToWorldRotation();
            Vector3dc vector3dc4 = ((PhysicsEntityServer)object7).getLinearVelocity();
            Vector3dc vector3dc5 = ((PhysicsEntityServer)object7).getAngularVelocity();
            ShipPhysicsData shipPhysicsData = new ShipPhysicsData(((PhysicsEntityServer)object7).getLinearVelocity(), ((PhysicsEntityServer)object7).getAngularVelocity());
            ShipInertiaData shipInertiaData = ((PhysicsEntityServer)object7).getInertiaData();
            Intrinsics.checkNotNull((Object)shipInertiaData);
            object = new FB(l6, 1.0, ShipInertiaDataImpl.copyToPhyInertia$default((ShipInertiaDataImpl)shipInertiaData, 0.0, 1, null), shipPhysicsData, bl, null, true, CollectionsKt.toMutableList((Collection)((PhysicsEntityServer)object7).getPhysicsListeners()), null, n7, vector3dc, (Quaterniondc)object10, vector3dc4, vector3dc5, null);
            Long l7 = l6;
            ((Map)object15).put(l7, object);
        }
        ((ArrayList)object18).addAll((Collection)list);
        object36 = (Map)object28;
        for (Map.Entry entry : object36.entrySet()) {
            object7 = entry;
            object7 = entry;
            Long l8 = (Long)entry.getKey();
            BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap = (BlockPos2ObjectOpenHashMap)object7.getValue();
            ((Map)((Object)iterator2)).put(l8, blockPos2ObjectOpenHashMap);
        }
        object22 = object13;
        object36 = CollectionsKt.toList((Iterable)((er_0.a)object22).j);
        object22 = object13;
        object10 = CollectionsKt.toList((Iterable)((er_0.a)object22).k);
        object22 = object13;
        object29 = CollectionsKt.toList((Iterable)((er_0.a)object22).l);
        object22 = ((FD)object17).b;
        ((Er)object22).e.a(er_0.c.CLEAR_FOR_RESET);
        ((Er)object22).k.clear();
        ((Er)object22).l.clear();
        ((Er)object22).m.clear();
        ((Er)object22).n.clear();
        ((Er)object22).q = CollectionsKt.toList((Iterable)((Er)object22).o);
        ((Er)object22).o.clear();
        ((Er)object22).p.clear();
        ((Er)object22).w.clear();
        ((Er)object22).j.clear();
        ((Er)object22).h.clear();
        iterable = ((Er)object22).i;
        for (Object object2422 : iterable) {
            object25 = (String)object2422;
            boolean bl = ((Er)object22).g.remove(object25) != null;
            if (bl) continue;
            throw new IllegalStateException("Check failed.");
        }
        ((Er)object22).i.clear();
        ((Er)object22).r = new ArrayList();
        ((Er)object22).s = new HashMap();
        ((Er)object22).t = new ArrayList();
        ((Er)object22).u = new ArrayList();
        ((Er)object22).v = new ArrayList();
        Object object37 = object7 = (Iterable)((FD)object17).b.getPlayers();
        Object object38 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object7, (int)10));
        object6 = object37.iterator();
        while (object6.hasNext()) {
            Object t = object6.next();
            object4 = (VsiPlayer)t;
            object12 = object38;
            object12.add(object4.getPlayerState());
        }
        Object object33 = object7 = (List)object38;
        object33 = object13;
        object22 = object33;
        object22 = object13;
        object14 = ((FD)object17).b;
        object7 = ((Er)object14).d;
        list = ((er_0.a)object22).n;
        list2 = ((er_0.a)object33).m;
        object11 = object32;
        object12 = object29;
        object13 = object36;
        object18 = (List)object18;
        object1622 = (List)object1622;
        object37 = object7;
        object38 = new LinkedHashMap(MapsKt.mapCapacity((int)object7.size()));
        object6 = object37.entrySet();
        object4 = object6.iterator();
        while (object4.hasNext()) {
            object36 = object4.next();
            Map.Entry entry = (Map.Entry)object36;
            Object object41 = object38;
            Map.Entry entry2 = (Map.Entry)object36;
            object36 = entry.getKey();
            object28 = object41;
            object22 = (DP)entry2.getValue();
            object29 = ((DP)object22).c;
            object28.put(object36, object29);
        }
        object28 = object38;
        object14 = ((FD)object17).b;
        object37 = object7 = ((Er)object14).d;
        object38 = new LinkedHashMap(MapsKt.mapCapacity((int)object7.size()));
        object6 = object37.entrySet();
        object4 = object6.iterator();
        while (object4.hasNext()) {
            object36 = object4.next();
            Map.Entry entry = (Map.Entry)object36;
            Object object42 = object38;
            Map.Entry entry3 = (Map.Entry)object36;
            object29 = entry.getKey();
            object36 = object42;
            object14 = (DP)entry3.getValue();
            object17 = ((DP)object14).b;
            object36.put(object29, object17);
        }
        object36 = object38;
        Object object34 = object1622;
        object17 = object36;
        object1622 = object28;
        List<fy_0> list3 = list;
        List<fy_0> list4 = list2;
        Object object44 = object11;
        Object object45 = object12;
        Object object46 = object10;
        Object object47 = object13;
        Iterator iterator4 = iterator2;
        Long2ObjectMap long2ObjectMap = object15;
        ArrayList<Long> arrayList = object18;
        Object object48 = object34;
        object17 = new FC((List<fz_0>)object48, (List<Long>)arrayList, (Long2ObjectMap<? extends FB>)long2ObjectMap, (Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>>)iterator4, (List<VSJointAndId>)object47, (List<VSJointAndId>)object46, (List<Integer>)object45, (List<VsiPlayerState>)object44, list4, list3, (Map<String, ? extends Vector3dc>)object1622, (Map<String, LevelYRange>)object17);
        object1622 = ((et_0)this.b).getLoadedShips();
        object1622 = object1622.iterator();
        while (object1622.hasNext()) {
            object15 = object1622.next();
            object18 = (eq_0)object15;
            WingManager wingManager = ((eq_0)object18).getAttachment(WingManager.class);
            Intrinsics.checkNotNull((Object)wingManager);
            object18 = wingManager;
            wingManager.clearWingChanges();
        }
        return object17;
    }

    private final void b(FH iterator2) {
        Object object = iterator2;
        iterator2 = (Map)((FH)object).a;
        for (Map.Entry entry : iterator2.entrySet()) {
            ShipData shipData;
            ShipData shipData2;
            Object object2 = entry;
            object2 = entry;
            Object object3 = (Long)entry.getKey();
            object2 = (FA)object2.getValue();
            VsiQueryableShipData vsiQueryableShipData = ((et_0)this.b).getLoadedShips();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
            Object object4 = (eq_0)vsiQueryableShipData.getById((Long)object3);
            if (object4 != null) {
                object = object4;
                shipData2 = ((eq_0)object4).b;
            } else {
                shipData2 = shipData = null;
            }
            if (shipData2 != null) {
                object = object2;
                boolean bl = ((eq_0)object4).getShipTeleportId() == ((FA)object).d;
                if (!bl) continue;
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                object3 = org.valkyrienskies.core.impl.shadow.FD$a.a((FA)object2, shipData);
                shipData.setKinematics((BodyKinematics)object3);
                continue;
            }
            object = this.b;
            object4 = (PhysicsEntityServer)((Er)object).f.get(object3);
            if (object4 != null) {
                object = object2;
                boolean bl = ((PhysicsEntityServer)object4).getShipTeleportId() == ((FA)object).d;
                if (!bl) continue;
                object = object2;
                hc_0 hc_02 = ((FA)object).a;
                object = hc_02;
                object = object2;
                object = ((FA)object).a;
                ShipTransform shipTransform = ShipTransformImpl.Companion.create(((Hc)hc_02).b, new Vector3d(), ((Hc)object).c);
                object = object2;
                object = ((FA)object).a;
                ((PhysicsEntityServer)object4).setLinearVelocity(((Hc)object).d);
                object = object2;
                object = ((FA)object).a;
                ((PhysicsEntityServer)object4).setAngularVelocity(((Hc)object).e);
                ((PhysicsEntityServer)object4).setShipTransform(shipTransform);
                continue;
            }
            if (this.b.getDimensionToGroundBodyIdImmutable().containsValue(object3)) continue;
            org.valkyrienskies.core.impl.shadow.FD$a.a(a).warn("Received physics frame update for ship with ShipId: " + (Long)object3 + ", but a ship with this ShipId does not exist!");
        }
    }

    private final FC f() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        Object object8 = new ArrayList<Object>();
        Object object9 = new ArrayList();
        Object object10 = ER.a(new Pair[0]);
        Object object11 = ER.a(new Pair[0]);
        Object object12 = this.b.i();
        Object object13 = ((er_0.a)object12).k();
        Object object14 = object12;
        Object object15 = ((er_0.a)object14).a;
        object14 = object12;
        Object object16 = ((er_0.a)object14).b;
        object14 = object12;
        Long2ObjectMap long2ObjectMap = ((er_0.a)object14).c;
        object14 = object12;
        Collection<PhysicsEntityServer> collection = ((er_0.a)object14).d;
        List<Object> list = ((er_0.a)object12).l();
        object14 = object12;
        Object object17 = ((er_0.a)object14).g;
        object13 = (Iterable)object13;
        Object object18 = object13.iterator();
        while (object18.hasNext()) {
            object7 = object18.next();
            object7 = (Pair)object7;
            String string = (String)object7.getFirst();
            long l2 = ((Number)object7.getSecond()).longValue();
            object6 = this.b.a(string);
            object5 = new Vector3i(Integer.MIN_VALUE, ((LevelYRange)object6).getMinY(), Integer.MIN_VALUE);
            object4 = new Vector3i(Integer.MAX_VALUE, ((LevelYRange)object6).getMaxY(), Integer.MAX_VALUE);
            object13 = Ha.a.a();
            ek_0 ek_02 = new ek_0(10.0, new Matrix3d(10.0, 0.0, 0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 10.0), new Vector3d(0.5, 0.5, 0.5), false, 8, null);
            hc_0 hc_02 = hc_0.a.a(new Vector3d(0.5, 0.5, 0.5), new Quaterniond());
            VSVoxelCollisionShapeData vSVoxelCollisionShapeData = new VSVoxelCollisionShapeData((Vector3ic)object5, (Vector3ic)object4, (AABBic)object13, false, null);
            object13 = new fz_0(l2, string, vSVoxelCollisionShapeData, 1.0, ek_02, new ShipPhysicsData(new Vector3d(), new Vector3d()), hc_02, true, null, CollectionsKt.emptyList(), null, 0, -1, 0.3, 0.3, 0.6, true);
            ((ArrayList)object8).add(object13);
        }
        object13 = (Iterable)object15;
        object18 = object13.iterator();
        while (object18.hasNext()) {
            object7 = object18.next();
            object14 = object7 = (eq_0)object7;
            long l3 = ((eq_0)object7).b.getId();
            object3 = new Vector3i();
            object6 = new Vector3i();
            object5 = this.b.a(((eo_0)object7).getChunkClaimDimension());
            object4 = ((eo_0)object7).getShipAABB();
            if (object4 != null) {
                ((Vector3i)object3).set(object4.minX(), object4.minY(), object4.minZ());
                ((Vector3i)object6).set(object4.maxX(), object4.maxY(), object4.maxZ());
            } else {
                object14 = object7;
                ((Vector3i)object3).set(((eq_0)object14).b.getTransform().getPositionInShip());
                object14 = object7;
                ((Vector3i)object6).set(((eq_0)object14).b.getTransform().getPositionInShip());
            }
            object13 = ChunkClaim.getTotalVoxelRegion$default(((eo_0)object7).getChunkClaim(), (LevelYRange)object5, null, 2, null);
            object14 = object7;
            double d2 = ((eq_0)object14).b.getTransform().getShipToWorldScaling().x();
            Object object19 = object7;
            object14 = object19;
            object14 = object7;
            object15 = hc_0.a.a(((eq_0)object19).b.getTransform().getPositionInWorld(), ((eq_0)object14).b.getTransform().getShipToWorldRotation());
            object14 = object7;
            boolean bl = ((eq_0)object14).b.isStatic();
            object14 = object7;
            PhysPose physPose = ((eq_0)object14).b.getKinematicTarget();
            object14 = object7;
            boolean bl2 = ((eq_0)object14).b.areVoxelsFullyLoaded();
            Intrinsics.checkNotNull((Object)((eq_0)object7).getAttachment(WingManager.class));
            int n2 = ((eq_0)object7).getShipTeleportId();
            Vector3ic vector3ic2 = (Vector3ic)object3;
            vector3ic2 = (Vector3ic)object6;
            AABBic aABBic = (AABBic)object13;
            object14 = object7;
            IShipActiveChunksSet iShipActiveChunksSet = ((eq_0)object14).b.getActiveChunksSet();
            Intrinsics.checkNotNull((Object)iShipActiveChunksSet);
            object2 = new VSVoxelCollisionShapeData(vector3ic, vector3ic2, aABBic, bl2, ((ShipActiveChunksSet)iShipActiveChunksSet).clone());
            Object object20 = object7;
            object14 = object20;
            Object object21 = object7;
            object14 = object21;
            Object object22 = object7;
            object14 = object22;
            object14 = object7;
            object14 = object7;
            object13 = new fz_0(l3, ((eq_0)object20).b.getChunkClaimDimension(), (VSCollisionShapeData)object2, d2, ((eq_0)object21).b.getInertiaData().copyToPhyInertia(d2), new ShipPhysicsData(((eq_0)object22).b.getKinematics().getVelocity(), ((eq_0)object14).b.getKinematics().getAngularVelocity()), (hc_0)object15, bl, physPose, CollectionsKt.toMutableList(((eq_0)object14).e.values()), object.getWingChanges(), n2, -1, 0.3, 0.3, 0.6, false);
            ((ArrayList)object8).add(object13);
        }
        object13 = (Iterable)object16;
        object18 = object13.iterator();
        while (object18.hasNext()) {
            object7 = object18.next();
            object7 = (PhysicsEntityServer)object7;
            long l4 = ((PhysicsEntityServer)object7).getId();
            object3 = ((PhysicsEntityServer)object7).getDimensionId();
            object6 = hc_0.a.a(((PhysicsEntityServer)object7).getShipTransform().getPositionInWorld(), ((PhysicsEntityServer)object7).getShipTransform().getShipToWorldRotation());
            boolean bl = ((PhysicsEntityServer)object7).isStatic();
            int n3 = ((PhysicsEntityServer)object7).getShipTeleportId();
            object15 = ((PhysicsEntityServer)object7).getCollisionShapeData();
            ShipPhysicsData shipPhysicsData = new ShipPhysicsData(((PhysicsEntityServer)object7).getLinearVelocity(), ((PhysicsEntityServer)object7).getAngularVelocity());
            int n4 = ((PhysicsEntityServer)object7).getCollisionMask();
            double d3 = ((PhysicsEntityServer)object7).getStaticFrictionCoefficient();
            double d4 = ((PhysicsEntityServer)object7).getDynamicFrictionCoefficient();
            double d5 = ((PhysicsEntityServer)object7).getRestitutionCoefficient();
            ShipInertiaData shipInertiaData = ((PhysicsEntityServer)object7).getInertiaData();
            Intrinsics.checkNotNull((Object)shipInertiaData);
            object13 = new fz_0(l4, (String)object3, (VSCollisionShapeData)object15, 1.0, ShipInertiaDataImpl.copyToPhyInertia$default((ShipInertiaDataImpl)shipInertiaData, 0.0, 1, null), shipPhysicsData, (hc_0)object6, bl, null, CollectionsKt.toMutableList((Collection)((PhysicsEntityServer)object7).getPhysicsListeners()), null, n3, n4, d3, d4, d5, false);
            ((ArrayList)object8).add(object13);
        }
        object13 = (Iterable)long2ObjectMap;
        object18 = object13.iterator();
        while (object18.hasNext()) {
            WingManager wingManager;
            object7 = object18.next();
            object14 = object7 = (eq_0)object7;
            long l5 = ((eq_0)object7).b.getId();
            object14 = object7;
            double d6 = ((eq_0)object14).b.getTransform().getShipToWorldScaling().x();
            object14 = object7;
            boolean bl = ((eq_0)object14).b.isStatic();
            object14 = object7;
            object4 = ((eq_0)object14).b.getKinematicTarget();
            object14 = object7;
            boolean bl3 = ((eq_0)object14).b.areVoxelsFullyLoaded();
            Intrinsics.checkNotNull((Object)((eq_0)object7).getAttachment(WingManager.class));
            int n5 = ((eq_0)object7).getShipTeleportId();
            object14 = object7;
            object15 = ((eq_0)object14).b.getTransform().getPositionInWorld();
            object14 = object7;
            Quaterniondc quaterniondc = ((eq_0)object14).b.getTransform().getShipToWorldRotation();
            Vector3dc vector3dc = ((eo_0)object7).getKinematics().getVelocity();
            Vector3dc vector3dc2 = ((eo_0)object7).getKinematics().getAngularVelocity();
            AABBic aABBic = ((eo_0)object7).getShipAABB();
            if (aABBic == null) {
                Object object23 = object7;
                object14 = object23;
                object14 = object7;
                aABBic = new AABBi(new Vector3i().set(((eq_0)object23).b.getTransform().getPositionInShip()), new Vector3i().set(((eq_0)object14).b.getTransform().getPositionInShip()));
            }
            object = aABBic;
            Object object24 = object7;
            object14 = object24;
            object14 = object7;
            FB fB = new FB(l5, d6, ((eq_0)object24).b.getInertiaData().copyToPhyInertia(d6), new ShipPhysicsData(((eo_0)object7).getKinematics().getVelocity(), ((eo_0)object7).getKinematics().getAngularVelocity()), bl, (PhysPose)object4, bl3, CollectionsKt.toMutableList(((eq_0)object14).e.values()), wingManager.getWingChanges(), n5, (Vector3dc)object15, quaterniondc, vector3dc, vector3dc2, (AABBic)object);
            object2 = l5;
            ((Map)object10).put(object2, fB);
        }
        object13 = collection;
        object18 = object13.iterator();
        while (object18.hasNext()) {
            object7 = object18.next();
            object7 = (PhysicsEntityServer)object7;
            long l6 = ((PhysicsEntityServer)object7).getId();
            boolean bl = ((PhysicsEntityServer)object7).isStatic();
            int n6 = ((PhysicsEntityServer)object7).getShipTeleportId();
            Vector3dc vector3dc = ((PhysicsEntityServer)object7).getShipTransform().getPositionInWorld();
            object15 = ((PhysicsEntityServer)object7).getShipTransform().getShipToWorldRotation();
            Vector3dc vector3dc3 = ((PhysicsEntityServer)object7).getLinearVelocity();
            Vector3dc vector3dc4 = ((PhysicsEntityServer)object7).getAngularVelocity();
            ShipPhysicsData shipPhysicsData = new ShipPhysicsData(((PhysicsEntityServer)object7).getLinearVelocity(), ((PhysicsEntityServer)object7).getAngularVelocity());
            ShipInertiaData shipInertiaData = ((PhysicsEntityServer)object7).getInertiaData();
            Intrinsics.checkNotNull((Object)shipInertiaData);
            object = new FB(l6, 1.0, ShipInertiaDataImpl.copyToPhyInertia$default((ShipInertiaDataImpl)shipInertiaData, 0.0, 1, null), shipPhysicsData, bl, null, true, CollectionsKt.toMutableList((Collection)((PhysicsEntityServer)object7).getPhysicsListeners()), null, n6, vector3dc, (Quaterniondc)object15, vector3dc3, vector3dc4, null);
            Long l7 = l6;
            ((Map)object10).put(l7, object);
        }
        ((ArrayList)object9).addAll((Collection)list);
        object13 = (Map)object17;
        for (Map.Entry entry : object13.entrySet()) {
            object7 = entry;
            object7 = entry;
            Long l8 = (Long)entry.getKey();
            BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap = (BlockPos2ObjectOpenHashMap)object7.getValue();
            ((Map)object11).put(l8, blockPos2ObjectOpenHashMap);
        }
        object14 = object12;
        object13 = CollectionsKt.toList((Iterable)((er_0.a)object14).j);
        object14 = object12;
        object15 = CollectionsKt.toList((Iterable)((er_0.a)object14).k);
        object14 = object12;
        object18 = CollectionsKt.toList((Iterable)((er_0.a)object14).l);
        this.b.j();
        Object object25 = object7 = (Iterable)this.b.getPlayers();
        Object object26 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object7, (int)10));
        object6 = object25.iterator();
        while (object6.hasNext()) {
            Object t = object6.next();
            object4 = (VsiPlayer)t;
            object16 = object26;
            object16.add(object4.getPlayerState());
        }
        Object object27 = object7 = (List)object26;
        er_0.a a2 = object12;
        object14 = a2;
        er_0.a a3 = object12;
        object14 = a3;
        object14 = this.b;
        object7 = ((Er)object14).d;
        list = a3.n;
        collection = a2.m;
        long2ObjectMap = object27;
        object16 = object18;
        object12 = object13;
        object9 = (List)object9;
        object8 = (List)object8;
        object25 = object7;
        object26 = new LinkedHashMap(MapsKt.mapCapacity((int)object7.size()));
        object6 = object25.entrySet();
        object4 = object6.iterator();
        while (object4.hasNext()) {
            object13 = object4.next();
            Map.Entry entry = (Map.Entry)object13;
            Object object28 = object26;
            Map.Entry entry2 = (Map.Entry)object13;
            object13 = entry.getKey();
            object17 = object28;
            object14 = (DP)entry2.getValue();
            object18 = ((DP)object14).c;
            object17.put(object13, object18);
        }
        object17 = object26;
        object14 = this.b;
        object25 = object7 = ((Er)object14).d;
        object26 = new LinkedHashMap(MapsKt.mapCapacity((int)object7.size()));
        object6 = object25.entrySet();
        object4 = object6.iterator();
        while (object4.hasNext()) {
            object13 = object4.next();
            Map.Entry entry = (Map.Entry)object13;
            Object object29 = object26;
            Map.Entry entry3 = (Map.Entry)object13;
            object18 = entry.getKey();
            object13 = object29;
            object14 = (DP)entry3.getValue();
            object7 = ((DP)object14).b;
            object13.put(object18, object7);
        }
        object13 = object26;
        List<fz_0> list2 = object8;
        ArrayList<Long> arrayList = object9;
        Long2ObjectMap long2ObjectMap3 = object10;
        long2ObjectMap3 = object11;
        Object object28 = object12;
        object8 = object13;
        object9 = object17;
        object10 = list;
        object11 = collection;
        object12 = long2ObjectMap;
        object13 = object16;
        object16 = object28;
        long2ObjectMap = long2ObjectMap3;
        collection = long2ObjectMap2;
        ArrayList<Long> arrayList2 = arrayList;
        List<fz_0> list3 = list2;
        return new FC(list3, (List<Long>)arrayList2, (Long2ObjectMap<? extends FB>)collection, (Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>>)long2ObjectMap, (List<VSJointAndId>)object16, (List<VSJointAndId>)object15, (List<Integer>)object13, (List<VsiPlayerState>)object12, (List<fy_0>)object11, (List<fy_0>)object10, (Map<String, ? extends Vector3dc>)object9, (Map<String, LevelYRange>)object8);
    }

    private static final void a(Function2 function2, Object object, Object object2) {
        function2.invoke(object, object2);
    }

    private static final void b(Function2 function2, Object object, Object object2) {
        function2.invoke(object, object2);
    }

    private static final void c(Function2 function2, Object object, Object object2) {
        function2.invoke(object, object2);
    }

    public static final /* synthetic */ VSCoreInternal a(FD fD) {
        return (VSCoreInternal)FV.a(fD.d, c[0]);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FD.class, "vsCore", "getVsCore()Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", 0)));
        c = kPropertyArray2;
        a = new a(null);
        h = BodyKinematicsFactory.INSTANCE;
        i = FW.a(a, org.valkyrienskies.core.impl.shadow.FD$a.a[0]);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0007\u0010\u0013"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FD$a;", "", "Lorg/valkyrienskies/core/impl/shadow/FA;", "p0", "Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "p1", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "a", "(Lorg/valkyrienskies/core/impl/shadow/FA;Lorg/valkyrienskies/core/impl/api/ServerShipInternal;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "", "g", "I", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "h", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "b", "Lorg/apache/logging/log4j/Logger;", "i", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "c", "<init>", "()V"})
    public static final class a {
        static final /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        public static BodyKinematics a(FA object, ServerShipInternal object2) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Object object3 = object;
            Object object4 = ((FA)object3).a;
            Object object5 = object;
            object5 = ((FA)object5).b;
            Vector3dc vector3dc = object2.getInertiaData().getCenterOfMass().mul(-1.0, new Vector3d());
            object3 = object;
            double d2 = ((FA)object3).c;
            object3 = object4;
            object = ((hc_0)object3).c.transform(vector3dc.sub((Vector3dc)object5, new Vector3d()));
            ((Vector3d)object).mul(d2);
            object3 = object4;
            object = ((hc_0)object3).b.sub((Vector3dc)object, new Vector3d());
            object5 = h;
            object3 = object4;
            vector3dc = ((hc_0)object3).d;
            object3 = object4;
            Vector3dc vector3dc2 = ((hc_0)object3).e;
            object2 = object2.getInertiaData().getCenterOfMassInShip();
            object3 = object4;
            object4 = ((hc_0)object3).c;
            Vector3d vector3d = new Vector3d(d2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
            return ((BodyKinematicsFactory)object5).create(vector3dc, vector3dc2, (Vector3dc)object, (Quaterniondc)object4, vector3d, (Vector3dc)object2);
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = i;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = i;
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

