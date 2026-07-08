/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.common.collect.ImmutableSet
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketShipDataCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketShipRemove;
import org.valkyrienskies.core.impl.networking.impl.PhysEntityCreateData;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.CR;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.eq_0;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fp_0;
import org.valkyrienskies.core.impl.shadow.fu_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.util.VSCoreUtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB7\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001d00\u0012\u0006\u0010\u0007\u001a\u00020*\u0012\u0006\u0010\u0013\u001a\u00020*\u0012\u0006\u00101\u001a\u00020(\u0012\u0006\u00102\u001a\u00020\u001b\u00a2\u0006\u0004\b3\u00104J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002\u00a2\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0002\u00a2\u0006\u0004\b\u0010\u0010\nJ%\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002\u00a2\u0006\u0004\b\r\u0010\nJ+\u0010\f\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\f\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0016J\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\u001aR\u0014\u0010\f\u001a\u00020\u001b8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u001b\u0010\r\u001a\u00020\u001d8CX\u0083\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\f\u0010 R\u0016\u0010\t\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R4\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b\t\u0010&\"\u0004\b\r\u0010'R4\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0$0#8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010%\u001a\u0004\b\r\u0010&\"\u0004\b\f\u0010'R\u0014\u0010\u0019\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010)R\u0014\u0010\u0015\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010-R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010,"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EO;", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "p0", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "p1", "", "c", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;Ljava/lang/Iterable;)V", "Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "a", "b", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "d", "Lorg/valkyrienskies/core/impl/shadow/CR;", "Lorg/valkyrienskies/core/impl/shadow/Fu;", "p2", "(Ljava/lang/Iterable;Lorg/valkyrienskies/core/impl/shadow/CR;Lorg/valkyrienskies/core/impl/shadow/Fu;)V", "h", "()V", "f", "e", "g", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)Ljava/lang/Iterable;", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "Lorg/valkyrienskies/core/impl/shadow/Fb;", "Lorg/valkyrienskies/core/impl/shadow/Er;", "l", "Lorg/valkyrienskies/core/impl/shadow/dT;", "()Lorg/valkyrienskies/core/impl/shadow/Er;", "Lorg/valkyrienskies/core/impl/shadow/Fu;", "Ljava/lang/Iterable;", "Lcom/google/common/collect/ImmutableMap;", "Lcom/google/common/collect/ImmutableSet;", "Lcom/google/common/collect/ImmutableMap;", "()Lcom/google/common/collect/ImmutableMap;", "(Lcom/google/common/collect/ImmutableMap;)V", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/impl/shadow/EY;", "j", "Lorg/valkyrienskies/core/impl/shadow/EY;", "Lorg/valkyrienskies/core/impl/shadow/CR;", "i", "k", "Lorg/valkyrienskies/core/impl/shadow/dT;", "p3", "p4", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/dT;Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;Lorg/valkyrienskies/core/impl/shadow/Fb;)V"})
public final class EO {
    public static final a a;
    private static /* synthetic */ KProperty<Object>[] i;
    private final EY j;
    private final EY k;
    public final SimplePacketNetworking b;
    public final fb_0 c;
    private final dt_1 l;
    public Iterable<? extends VsiPlayer> d;
    public CR e;
    public fu_0 f;
    public volatile ImmutableMap<VsiPlayer, ImmutableSet<ServerShipInternal>> g;
    public volatile ImmutableMap<VsiPlayer, ImmutableSet<PhysicsEntityServer>> h;
    private static final Logger m;

    @Inject
    public EO(dt_1<er_0> object, EY eY, EY eY2, SimplePacketNetworking simplePacketNetworking, fb_0 fb_02) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY2, (String)"");
        Intrinsics.checkNotNullParameter((Object)simplePacketNetworking, (String)"");
        Intrinsics.checkNotNullParameter((Object)fb_02, (String)"");
        this.j = eY;
        this.k = eY2;
        this.b = simplePacketNetworking;
        this.c = fb_02;
        this.l = object;
        ImmutableMap immutableMap = ImmutableMap.of();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"");
        this.g = immutableMap;
        ImmutableMap immutableMap2 = ImmutableMap.of();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap2, (String)"");
        this.h = immutableMap2;
        object = this.j;
        this.j.b = true;
        object = this.k;
        this.k.b = true;
    }

    @JvmName(name="a")
    public final er_0 a() {
        return (er_0)FV.a(this.l, i[0]);
    }

    public final void a(Iterable<? extends VsiPlayer> iterable, CR cR, fu_0 fu_02) {
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter((Object)cR, (String)"");
        Intrinsics.checkNotNullParameter((Object)fu_02, (String)"");
        this.d = iterable;
        this.e = cR;
        this.f = fu_02;
        this.h();
        this.g();
        this.e();
        this.f();
    }

    private final Iterable<ServerShipInternal> a(VsiPlayer vsiPlayer) {
        CR cR = this.e;
        if (cR == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            cR = null;
        }
        return cR.a(vsiPlayer);
    }

    private final void e() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        CR cR = this.e;
        if (cR == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            cR = null;
        }
        Iterator<Map.Entry<VsiPlayer, Map<ServerShipInternal, LongSet>>> iterator2 = cR;
        iterator2 = cR.a;
        for (Map.Entry<VsiPlayer, Map<ServerShipInternal, LongSet>> entry : iterator2.entrySet()) {
            Object object = entry;
            object = entry;
            VsiPlayer vsiPlayer = entry.getKey();
            object = object.getValue();
            builder.put((Object)vsiPlayer, VSCoreUtilKt.toImmutableSet(object.keySet()));
        }
        ImmutableMap immutableMap = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"");
        this.g = immutableMap;
    }

    private final void f() {
        Object object;
        VsiPlayer vsiPlayer;
        ImmutableMap.Builder object22 = ImmutableMap.builder();
        fu_0 fu_02 = this.f;
        if (fu_02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            fu_02 = null;
        }
        Object object2 = fu_02;
        Object object3 = fu_02.a;
        for (Map.Entry<VsiPlayer, Set<Long>> entry : object3.entrySet()) {
            object3 = entry;
            object3 = entry;
            vsiPlayer = entry.getKey();
            object3 = object3.getValue();
            object = ImmutableSet.builder();
            object3 = (Iterable)object3;
            object3 = object3.iterator();
            while (object3.hasNext()) {
                object2 = object3.next();
                long l2 = ((Number)object2).longValue();
                object2 = this.a();
                PhysicsEntityServer physicsEntityServer = ((er_0)object2).f.get(l2);
                if (physicsEntityServer == null) continue;
                object.add((Object)physicsEntityServer);
            }
            object22.put((Object)vsiPlayer, (Object)object.build());
        }
        ImmutableMap immutableMap = object22.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"");
        this.h = immutableMap;
        Iterable<? extends VsiPlayer> iterable = this.d;
        if (iterable == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable = null;
        }
        for (VsiPlayer vsiPlayer2 : iterable) {
            Set set;
            Object object4 = this.f;
            if (object4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object4 = object2 = null;
            }
            if ((set = ((fu_0)object4).c.get(vsiPlayer2)) == null) {
                set = SetsKt.emptySet();
            }
            Set set2 = set;
            this.c(vsiPlayer2, set2);
        }
        fu_0 fu_03 = this.f;
        if (fu_03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            fu_03 = null;
        }
        object2 = fu_03;
        object3 = fu_03.b;
        for (Map.Entry<VsiPlayer, Set<Long>> entry : object3.entrySet()) {
            object3 = entry;
            object3 = entry;
            vsiPlayer = entry.getKey();
            object3 = object3.getValue();
            object = (Iterable)object3;
            Iterable iterable2 = object;
            object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
            for (Object t : iterable2) {
                long l3 = ((Number)t).longValue();
                Object object5 = object3;
                object2 = this.a();
                PhysicsEntityServer physicsEntityServer = ((er_0)object2).f.get(l3);
                Intrinsics.checkNotNull((Object)physicsEntityServer);
                object5.add(physicsEntityServer);
            }
            List list = (List)object3;
            this.d(vsiPlayer, list);
        }
    }

    @JvmName(name="b")
    public final ImmutableMap<VsiPlayer, ImmutableSet<ServerShipInternal>> b() {
        return this.g;
    }

    @JvmName(name="a")
    private void a(ImmutableMap<VsiPlayer, ImmutableSet<ServerShipInternal>> immutableMap) {
        Intrinsics.checkNotNullParameter(immutableMap, (String)"");
        this.g = immutableMap;
    }

    @JvmName(name="c")
    public final ImmutableMap<VsiPlayer, ImmutableSet<PhysicsEntityServer>> c() {
        return this.h;
    }

    @JvmName(name="b")
    private void b(ImmutableMap<VsiPlayer, ImmutableSet<PhysicsEntityServer>> immutableMap) {
        Intrinsics.checkNotNullParameter(immutableMap, (String)"");
        this.h = immutableMap;
    }

    private final void g() {
        Object object;
        Iterable<? extends VsiPlayer> iterable = this.d;
        if (iterable == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable = null;
        }
        for (VsiPlayer vsiPlayer : iterable) {
            Set set;
            Object object2 = this.e;
            if (object2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object2 = object = null;
            }
            if ((set = ((CR)object2).c.get(vsiPlayer)) == null) {
                set = SetsKt.emptySet();
            }
            object = set;
            Set set2 = object;
            CR cR = this.e;
            if (cR == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                cR = null;
            }
            object = cR;
            this.a(vsiPlayer, SetsKt.plus((Set)set2, (Iterable)cR.d));
            this.b(vsiPlayer);
        }
        CR cR = this.e;
        if (cR == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            cR = null;
        }
        object = cR;
        Object object3 = cR.b;
        for (Map.Entry entry : object3.entrySet()) {
            object3 = entry;
            object3 = entry;
            VsiPlayer vsiPlayer = (VsiPlayer)entry.getKey();
            object3 = (Set)object3.getValue();
            this.b(vsiPlayer, (Iterable)object3);
        }
    }

    private final void b(VsiPlayer vsiPlayer) {
        Object object;
        Object object2 = this.e;
        if (object2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            object2 = object = null;
        }
        if (((CR)object2).e.contains(vsiPlayer)) {
            Object object3 = this.e;
            if (object3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object3 = object = null;
            }
            if ((object = (Collection)((CR)object3).b.get(vsiPlayer)) == null || object.isEmpty()) {
                this.b.sendToClient(new PacketShipDataCreate(CollectionsKt.emptyList()), vsiPlayer);
            }
        }
    }

    private final void a(VsiPlayer vsiPlayer, Iterable<? extends ServerShipInternal> collection) {
        Object object = collection;
        collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (ServerShipInternal)object2;
            Collection collection2 = collection;
            collection2.add(object2.getId());
        }
        if ((collection = (List)collection).isEmpty()) {
            return;
        }
        org.valkyrienskies.core.impl.shadow.EO$a.a(a).debug("{} unwatched ships {}", (Object)vsiPlayer.getUuid(), (Object)collection);
        this.b.sendToClient(new PacketShipRemove((List<Long>)collection), vsiPlayer);
    }

    private final void b(VsiPlayer vsiPlayer, Iterable<? extends ServerShipInternal> collection) {
        Iterable<Long> iterable;
        Object object;
        Object object2;
        Iterable iterable2 = collection;
        Iterator iterator2 = iterable2;
        iterable2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            object2 = (ServerShipInternal)object2;
            object = iterable2;
            object.add(object2.asShipDataCommon());
        }
        collection = (List)iterable2;
        if (collection.isEmpty()) {
            return;
        }
        iterable2 = collection;
        UUID uUID = vsiPlayer.getUuid();
        String string = "{} watched ships: {}";
        object = org.valkyrienskies.core.impl.shadow.EO$a.a(a);
        iterator2 = iterable2;
        iterable2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable2, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            object2 = (ShipDataCommon)object2;
            iterable = iterable2;
            iterable.add(((ShipDataCommon)object2).getId());
        }
        iterable = (List)iterable2;
        object.debug(string, (Object)uUID, (Object)iterable);
        this.b.sendToClient(new PacketShipDataCreate((List<? extends ShipDataCommon>)collection), vsiPlayer);
    }

    private final void c(VsiPlayer vsiPlayer, Iterable<Long> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        org.valkyrienskies.core.impl.shadow.EO$a.a(a).debug("{} unwatched physics entities {}", (Object)vsiPlayer.getUuid(), (Object)iterable);
        this.b.sendToClient(new PacketPhysEntityRemove(CollectionsKt.toList(iterable)), vsiPlayer);
    }

    private final void d(VsiPlayer vsiPlayer, Iterable<PhysicsEntityServer> collection) {
        Iterable<Long> iterable;
        Object object;
        Object object2;
        Iterable iterable2 = collection;
        Iterator iterator2 = iterable2;
        iterable2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            object2 = (PhysicsEntityServer)object2;
            object = iterable2;
            object.add(new PhysEntityCreateData(((PhysicsEntityServer)object2).getId(), ((PhysicsEntityServer)object2).getDimensionId(), ((PhysicsEntityServer)object2).getShipTransform(), ((PhysicsEntityServer)object2).getCollisionShapeData()));
        }
        collection = (List)iterable2;
        if (collection.isEmpty()) {
            return;
        }
        iterable2 = collection;
        UUID uUID = vsiPlayer.getUuid();
        String string = "{} watched physics entities: {}";
        object = org.valkyrienskies.core.impl.shadow.EO$a.a(a);
        iterator2 = iterable2;
        iterable2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable2, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            object2 = (PhysEntityCreateData)object2;
            iterable = iterable2;
            iterable.add(((PhysEntityCreateData)object2).getId());
        }
        iterable = (List)iterable2;
        object.debug(string, (Object)uUID, (Object)iterable);
        this.b.sendToClient(new PacketPhysEntityCreate((List<PhysEntityCreateData>)collection), vsiPlayer);
    }

    private final void h() {
        Iterable<? extends VsiPlayer> iterable = this.d;
        if (iterable == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable = null;
        }
        for (VsiPlayer vsiPlayer : iterable) {
            Object object;
            Object object2;
            Set set;
            Object object3;
            ByteBuf byteBuf = Unpooled.buffer();
            Object object4 = this.e;
            if (object4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object4 = object3 = null;
            }
            if ((set = ((CR)object4).b.get(vsiPlayer)) == null) {
                set = SetsKt.emptySet();
            }
            Object object5 = set;
            Iterator iterator2 = this.a(vsiPlayer);
            object3 = new ArrayList();
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object2 = iterator2.next();
                object = (ServerShipInternal)object2;
                if (!(!object5.contains(object))) continue;
                object3.add(object2);
            }
            iterator2 = (List)object3;
            object3 = new ArrayList();
            object = iterator2.iterator();
            while (object.hasNext()) {
                Object e2 = object.next();
                object5 = e2;
                object5 = e2;
                object5 = (ServerShipInternal)e2;
                eq_0 eq_02 = this.a().a((ServerShipInternal)object5);
                if (eq_02 == null) continue;
                object5 = eq_02;
                object3.add(object5);
            }
            object5 = (List)object3;
            if (object5.isEmpty()) continue;
            iterator2 = (Iterable)object5;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object3 = iterator2.next();
                object3 = object5 = (eq_0)object3;
                byteBuf.writeLong(((eq_0)object3).b.getId());
                object3 = object5;
                object2 = VSJacksonUtil.INSTANCE.getDeltaMapper().valueToTree(((eq_0)object3).b);
                object3 = object5;
                fp_0<JsonNode> fp_02 = ((eq_0)object3).d;
                Intrinsics.checkNotNullExpressionValue(object2, (String)"");
                Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
                fp_02.a((JsonNode)object2, byteBuf);
            }
            object3 = this.c;
            fa_0 fa_02 = ((fb_0)object3).c;
            Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"");
            fa_02.a(byteBuf, vsiPlayer);
        }
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(EO.class, "parent", "getParent()Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;", 0)));
        i = kPropertyArray2;
        a = new a(null);
        m = FX.a("Woman Eater");
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\u00020\u00028CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EO$a;", "", "Lorg/apache/logging/log4j/Logger;", "m", "Lorg/apache/logging/log4j/Logger;", "a", "()Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
    public static final class a {
        private static /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        private final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = m;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = m;
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

