/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  it.unimi.dsi.fastutil.objects.ObjectCollection
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  kotlin.reflect.KProperty0
 *  org.valkyrienskies.core.impl.shadow.Er
 *  org.valkyrienskies.core.impl.shadow.In
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.event.SingleEvent;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.api.ShipInternal;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.game.ships.ShipInertiaDataImpl;
import org.valkyrienskies.core.impl.hooks.VSEvents;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketShipDataCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketShipRemove;
import org.valkyrienskies.core.impl.networking.impl.PhysEntityCreateData;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.CP;
import org.valkyrienskies.core.impl.shadow.CR;
import org.valkyrienskies.core.impl.shadow.CY;
import org.valkyrienskies.core.impl.shadow.DL;
import org.valkyrienskies.core.impl.shadow.DM;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.EO;
import org.valkyrienskies.core.impl.shadow.ER;
import org.valkyrienskies.core.impl.shadow.ET;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.Er;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.In;
import org.valkyrienskies.core.impl.shadow.ef_0;
import org.valkyrienskies.core.impl.shadow.eh_0;
import org.valkyrienskies.core.impl.shadow.em_0;
import org.valkyrienskies.core.impl.shadow.eo_0;
import org.valkyrienskies.core.impl.shadow.eq_0;
import org.valkyrienskies.core.impl.shadow.et_0;
import org.valkyrienskies.core.impl.shadow.ez_0;
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fg_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fp_0;
import org.valkyrienskies.core.impl.shadow.fu_0;
import org.valkyrienskies.core.impl.shadow.fy_0;
import org.valkyrienskies.core.impl.shadow.ge_0;
import org.valkyrienskies.core.impl.shadow.gh_0;
import org.valkyrienskies.core.impl.shadow.gw_0;
import org.valkyrienskies.core.impl.shadow.ii_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.ik_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.in_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiGameServer;
import org.valkyrienskies.core.internal.joints.VSJointAndId;
import org.valkyrienskies.core.internal.physics.PhysicsEntityData;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.ships.VsiMutableQueryableShipData;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;
import org.valkyrienskies.core.util.VSCoreUtilKt;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Er
 */
public final class er_0
extends et_0<eq_0>
implements VsiServerShipWorld {
    private static /* synthetic */ KProperty<Object>[] y;
    public final VsiMutableQueryableShipData<ShipData> a;
    public final ChunkAllocatorProvider b;
    public final ez_0 c;
    private final DN z;
    public final Map<String, DP> d;
    private final DW A;
    private final ShipData.Factory B;
    private final Provider C;
    public final ge_0<c> e;
    private Set<? extends VsiPlayer> D;
    private Set<? extends VsiPlayer> E;
    private VsiGameServer F;
    private final em_0<eq_0> G;
    public final Map<Long, PhysicsEntityServer> f;
    public final Map<String, Long> g;
    public final ArrayList<String> h;
    public final ArrayList<String> i;
    public final ArrayList<b> j;
    private final Set<fy_0> H;
    public final List<eq_0> k;
    public final List<PhysicsEntityServer> l;
    public final List<eq_0> m;
    public final List<PhysicsEntityServer> n;
    public final List<ShipData> o;
    public final List<Long> p;
    public List<ShipData> q;
    public List<VSJointAndId> r;
    public Map<Integer, VSJointAndId> s;
    public List<Integer> t;
    public List<fy_0> u;
    public List<fy_0> v;
    private final fg_0 I;
    public final Long2ObjectMap<BlockPos2ObjectOpenHashMap<il_0>> w;
    public final DL x;

    @Inject
    public er_0(VsiMutableQueryableShipData<ShipData> vsiMutableQueryableShipData, ChunkAllocatorProvider chunkAllocatorProvider, ez_0 ez_02, fi_0 fi_02, DN dN, @Named(value="mutableDimensionInfo") Map<String, DP> map2, DW dW, ShipData.Factory factory, Provider<VSCoreInternal> provider) {
        Intrinsics.checkNotNullParameter(vsiMutableQueryableShipData, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorProvider, (String)"");
        Intrinsics.checkNotNullParameter((Object)ez_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)fi_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)dN, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter((Object)dW, (String)"");
        Intrinsics.checkNotNullParameter((Object)factory, (String)"");
        Intrinsics.checkNotNullParameter(provider, (String)"");
        super(chunkAllocatorProvider, dN);
        this.a = vsiMutableQueryableShipData;
        this.b = chunkAllocatorProvider;
        this.c = ez_02;
        this.z = dN;
        this.d = map2;
        this.A = dW;
        this.B = factory;
        this.C = provider;
        this.e = gh_0.a(org.valkyrienskies.core.impl.shadow.Er$c.PRE_TICK, 3.a);
        this.D = SetsKt.emptySet();
        this.E = SetsKt.emptySet();
        this.G = new em_0(null, 1, null);
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.H = new HashSet();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = CollectionsKt.emptyList();
        this.r = new ArrayList();
        this.s = new HashMap();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.I = fi_02.f();
        this.w = ER.a(new Pair[0]);
        this.x = new DL();
    }

    public final VsiMutableQueryableShipData<ShipData> a() {
        return this.a;
    }

    public final ChunkAllocatorProvider b() {
        return this.b;
    }

    private VSCoreInternal k() {
        return (VSCoreInternal)FV.a(this.C, y[0]);
    }

    private Set<VsiPlayer> l() {
        return this.D;
    }

    @Override
    public final Set<VsiPlayer> getPlayers() {
        return this.E;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setPlayers(Set<? extends VsiPlayer> value) {
        void var1_1;
        Intrinsics.checkNotNullParameter(value, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.UPDATE_PLAYERS);
        this.D = this.E;
        this.E = var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setGameServer(VsiGameServer gameServer) {
        void var1_1;
        this.F = var1_1;
    }

    public final ImmutableMap<VsiPlayer, ImmutableSet<ServerShipInternal>> c() {
        Object object = this.c;
        object = ((ez_0)object).a;
        return ((EO)object).g;
    }

    private static KProperty0 b(er_0 er_02) {
        return Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)er_02.c, ez_0.class, "playersToTrackedShips", "getPlayersToTrackedShips()Lcom/google/common/collect/ImmutableMap;", 0)));
    }

    public final ImmutableMap<VsiPlayer, ImmutableSet<PhysicsEntityServer>> d() {
        Object object = this.c;
        object = ((ez_0)object).a;
        return ((EO)object).h;
    }

    private static KProperty0 c(er_0 er_02) {
        return Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)er_02.c, ez_0.class, "playersToTrackedPhysicsEntities", "getPlayersToTrackedPhysicsEntities()Lcom/google/common/collect/ImmutableMap;", 0)));
    }

    @Override
    public final VsiQueryableShipData<eq_0> getLoadedShips() {
        return this.G;
    }

    public final Map<Long, PhysicsEntityServer> e() {
        return this.f;
    }

    @Override
    public final Map<Long, PhysicsEntityServer> retrieveLoadedPhysicsEntities() {
        return this.f;
    }

    @Override
    public final Map<String, Long> getDimensionToGroundBodyIdImmutable() {
        return this.g;
    }

    private final List<ShipData> m() {
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.GET_LAST_TICK_CHANGES);
        return this.q;
    }

    public final Map<String, DP> f() {
        return this.d;
    }

    private static SingleEvent<VSEvents.ShipLoadEvent> n() {
        return VSEvents.INSTANCE.getShipLoadEvent();
    }

    @Deprecated(message="All events moved to VSEvents", replaceWith=@ReplaceWith(expression="ShipLoadEvent", imports={"org.valkyrienskies.core.impl.hooks.VSEvents.ShipLoadEvent"}))
    private static /* synthetic */ void o() {
    }

    private static KProperty0 p() {
        return Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl((Object)VSEvents.INSTANCE, VSEvents.class, "shipLoadEvent", "getShipLoadEvent()Lorg/valkyrienskies/core/api/event/SingleEvent;", 0)));
    }

    public final DL g() {
        return this.x;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isConnectedByAir(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, x2, y2, z2, 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isConnectedBySolid(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, x2, y2, z2, 1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isIsolatedAir(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isIsolatedSolid(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, 1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final DoubleAugmentation createDoubleSumAugmentation(String modId, String key) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)modId, (String)"");
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        return this.A.a((String)var1_1, (String)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final DoubleComponentAugmentation createDoubleSumComponentAugmentation(String modId, String key) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)modId, (String)"");
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        return this.A.b((String)var1_1, (String)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, double value) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.a((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension, value);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, DoubleUnaryOperator update) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)update, (String)"");
        this.A.a((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension, update);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void removeSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.b((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double collectSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.c((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setSolidComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension, double value) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.a((DoubleComponentAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension, value);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getSolidComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a((DoubleComponentAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void removeSolidComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.b((DoubleComponentAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachSolidComponent(DoubleAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a((DoubleAugmentation)var1_1, (String)var2_2, (ChunkClaim)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachSolidComponentRoot(DoubleComponentAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a((DoubleComponentAugmentation)var1_1, (String)var2_2, (ChunkClaim)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllSolidComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        return this.A.a((ChunkClaim)var2_2, (String)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final long getSolidComponentSize(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.a((int)var1_1, (int)var2_2, (int)var3_3, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void traverseSolidComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.a((int)var1_1, (int)var2_2, (int)var3_3, action, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.d((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, double value) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.b((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension, value);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, DoubleUnaryOperator update) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)update, (String)"");
        this.A.b((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension, update);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void removeAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.e((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double collectAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.f((DoubleAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setAirComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension, double value) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.b((DoubleComponentAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension, value);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getAirComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.c((DoubleComponentAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void removeAirComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.d((DoubleComponentAugmentation)var1_1, (int)var2_2, (int)var3_3, z, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final long getAirComponentSize(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.b((int)var1_1, (int)var2_2, (int)var3_3, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachAirComponent(DoubleAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.b((DoubleAugmentation)var1_1, (String)var2_2, (ChunkClaim)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachAirComponentRoot(DoubleComponentAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.A.b((DoubleComponentAugmentation)var1_1, (String)var2_2, (ChunkClaim)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllAirComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        return this.A.b((ChunkClaim)var2_2, (String)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void traverseAirComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.A.b((int)var1_1, (int)var2_2, (int)var3_3, action, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onSetBlock(int posX, int posY, int posZ, String dimensionId, VsiBlockType oldBlockType, VsiBlockType newBlockType, double oldBlockMass, double newBlockMass) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldBlockType, (String)"");
        Intrinsics.checkNotNullParameter((Object)newBlockType, (String)"");
        super.onSetBlock(posX, posY, posZ, dimensionId, oldBlockType, newBlockType, oldBlockMass, newBlockMass);
        if (!Intrinsics.areEqual((Object)oldBlockType, (Object)newBlockType)) {
            void var3_3;
            void var2_2;
            void var1_1;
            Object object;
            Vector3ic vector3ic = new Vector3i(posX >> 4, posY >> 4, posZ >> 4);
            Object object2 = this;
            Object object3 = (ShipData)((er_0)object2).a.getByChunkPos(vector3ic.x(), vector3ic.z(), dimensionId);
            object3 = object3 != null ? Long.valueOf(((ShipDataCommon)object3).getId()) : this.g.get(dimensionId);
            if (object3 == null) {
                EY.a.a().error("Could not find ship or dimension body for block update at " + posX + ", " + posY + ", " + posZ + " in dimension " + dimensionId);
                return;
            }
            Object object4 = (Map)this.w;
            Object object5 = object4.get(object3);
            if (object5 == null) {
                object2 = new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
                object4.put(object3, object2);
                object = object2;
            } else {
                object = object5;
            }
            BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap = (BlockPos2ObjectOpenHashMap)object;
            object4 = (il_0)blockPos2ObjectOpenHashMap.getOrPut(vector3ic, (Function0)new Function0<il_0>(vector3ic){
                private /* synthetic */ Vector3ic $a;
                {
                    this.$a = vector3ic;
                    super(0);
                }

                public final il_0 a() {
                    return in_0.a.a(this.$a);
                }

                public final /* synthetic */ Object invoke() {
                    return this.a();
                }
            });
            object2 = (DM)newBlockType;
            int n2 = ((DM)object2).a;
            object5 = (eq_0)((et_0)this).getLoadedShips().getById((Long)object3);
            if (object5 != null) {
                object2 = this.z;
                object2 = ((DN)object2).b;
                object2 = (VsiBlockState)((CP)object2).d.get(n2);
                DragController dragController = ((eq_0)object5).getDragController();
                Intrinsics.checkNotNull((Object)dragController);
                eh_0 eh_02 = (eh_0)dragController;
                Vector3ic vector3ic2 = new Vector3i(posX, posY, posZ);
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
                Object object6 = object2;
                eh_02.a(new ef_0(vector3ic2, (VsiBlockState)object6, ((VsiBlockState)object6).getSolidState() == null));
            }
            if ((object2 = object4) instanceof In) {
                ((In)object4).a(posX & 0xF, posY & 0xF, posZ & 0xF, n2);
            } else if (object2 instanceof ij_0) {
                ((ij_0)object4).a(posX & 0xF, posY & 0xF, posZ & 0xF, n2);
            } else if (object2 instanceof ik_0) {
                object4 = in_0.a.a(vector3ic);
                object4.a(posX & 0xF, posY & 0xF, posZ & 0xF, n2);
                blockPos2ObjectOpenHashMap.set(vector3ic, object4);
            } else {
                throw new NotImplementedError(null, 1, null);
            }
            object4 = newBlockType;
            int n3 = Intrinsics.areEqual((Object)object4, (Object)this.z.getAir()) ? 0 : ((Intrinsics.areEqual((Object)object4, (Object)this.z.getWater()) ? true : Intrinsics.areEqual((Object)object4, (Object)this.z.getLava())) ? 2 : 1);
            object4 = Intrinsics.areEqual((Object)object3, (Object)this.g.get(dimensionId)) ? null : object3;
            this.g.get(dimensionId);
            this.A.a(dimensionId, (Long)object4, (int)var1_1, (int)var2_2, (int)var3_3, n3);
        }
    }

    @Override
    public final void addTerrainUpdates(String dimensionId, List<? extends VsiTerrainUpdate> terrainUpdates) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter(terrainUpdates, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.UPDATE_CHUNKS);
        object4 = (Iterable)object4;
        Iterator iterator2 = object4;
        object4 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object4, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object3 = iterator2.next();
            object2 = (VsiTerrainUpdate)object3;
            object3 = object4;
            Intrinsics.checkNotNull((Object)object2);
            object = (ET)object2;
            object3.add((il_0)((ET)object).a);
        }
        object4 = (List)object4;
        this.j.add(new b(dimensionId, (List<? extends il_0>)object4));
        iterator2 = object4.iterator();
        while (iterator2.hasNext()) {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            object4 = iterator2.next();
            object4 = (il_0)object4;
            object = this;
            if ((ShipData)((er_0)object).a.getByChunkPos(object4.a(), object4.c(), dimensionId) == null) continue;
            object2 = (eq_0)((et_0)this).getLoadedShips().getById(((ShipDataCommon)object3).getId());
            Object object5 = object4;
            if (object5 instanceof ij_0 ? true : object5 instanceof ik_0) {
                ((ShipData)object3).onLoadChunk(object4.a(), object4.c());
                this.A.a(dimensionId, object4.a(), object4.b(), object4.c(), ((ShipDataCommon)object3).getId(), (il_0)object4);
            } else if (object5 instanceof ii_0) {
                ((ShipData)object3).onUnloadChunk(object4.a(), object4.c());
                this.A.a(dimensionId, object4.a(), object4.b(), object4.c());
            } else {
                throw new NotImplementedError(null, 1, null);
            }
            if (object4 instanceof ij_0) {
                object5 = (ij_0)object4;
                n9 = 0;
                while (n9 < 16) {
                    n8 = n9++;
                    n7 = 0;
                    while (n7 < 16) {
                        n6 = n7++;
                        n5 = 0;
                        while (n5 < 16) {
                            int n10;
                            int n11 = n10 = n5++;
                            n10 = n6;
                            n4 = n8;
                            n3 = n11;
                            int n12 = n4;
                            int n13 = n10;
                            n10 = ((ij_0)object5).a(n3, n4, n10);
                            n4 = n13;
                            n3 = n12;
                            n2 = n11;
                            ((ShipData)object3).updateShipAABBGenerator((object4.a() << 4) + n2, (object4.b() << 4) + n3, (object4.c() << 4) + n4, n10 != this.z.getAir().toInt());
                            if (object2 == null || ((eq_0)object2).getDragController() == null) continue;
                            DragController dragController = ((eq_0)object2).getDragController();
                            Intrinsics.checkNotNull((Object)dragController);
                            AABBic aABBic = ((eo_0)object2).getShipAABB();
                            object = (eh_0)dragController;
                            ((eh_0)dragController).b = aABBic;
                        }
                    }
                }
            }
            if (object2 == null || ((eq_0)object2).getDragController() == null) continue;
            DragController dragController = ((eq_0)object2).getDragController();
            Intrinsics.checkNotNull((Object)dragController);
            object2 = this.z;
            object3 = object4;
            object4 = (eh_0)dragController;
            Intrinsics.checkNotNullParameter((Object)object3, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            object5 = object3;
            if (object5 instanceof ij_0) {
                object5 = (ij_0)object3;
                n7 = 0;
                while (n7 < 16) {
                    n6 = n7++;
                    n5 = 0;
                    while (n5 < 16) {
                        n9 = n5++;
                        int n14 = 0;
                        while (n14 < 16) {
                            n8 = n14++;
                            n4 = n9;
                            int n15 = n6;
                            n2 = n8;
                            int n16 = n15;
                            int n17 = n4;
                            n4 = ((ij_0)object5).a(n2, n15, n4);
                            n15 = n17;
                            n8 = n16;
                            object = object2;
                            object = ((DN)object).b;
                            Object object6 = ((CP)object).d.get(n4);
                            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"");
                            if (eh_0.a((VsiBlockState)object6) && n4 != ((DN)object2).getEmpty().toInt()) {
                                Vector3i vector3i = new Vector3i((object3.a() << 4) + n2, (object3.b() << 4) + n8, (object3.c() << 4) + n15);
                                Vector3ic vector3ic = vector3i;
                                object = object2;
                                object = ((DN)object).b;
                                Object object7 = ((CP)object).d.get(n4);
                                Intrinsics.checkNotNull((Object)object7);
                                ((eh_0)object4).a(new ef_0(vector3ic, (VsiBlockState)object7, false));
                                continue;
                            }
                            Vector3i vector3i = new Vector3i((object3.a() << 4) + n2, (object3.b() << 4) + n8, (object3.c() << 4) + n15);
                            Vector3ic vector3ic = vector3i;
                            object = object2;
                            object = ((DN)object).b;
                            Object object8 = ((CP)object).d.get(n4);
                            Intrinsics.checkNotNull((Object)object8);
                            ((eh_0)object4).a(new ef_0(vector3ic, (VsiBlockState)object8, true));
                        }
                    }
                }
                continue;
            }
            if (!(object5 instanceof In)) continue;
            object5 = (In)object3;
            n9 = 0;
            object = object5;
            n8 = ((In)object).e.size();
            while (n9 < n8) {
                int n18 = n9++;
                object = object5;
                n6 = ((In)object).e.getShort(n18);
                object = object5;
                n5 = ((In)object).f.getInt(n18);
                int n19 = n6;
                n4 = n19 >> 8 & 0xF;
                n3 = n19 >> 4 & 0xF;
                n2 = n19 & 0xF;
                int n20 = n4;
                n18 = n2;
                n4 = n3;
                n3 = n20;
                n2 = n5;
                n3 = n4;
                n6 = n20;
                object = object2;
                object = ((DN)object).b;
                Object object9 = ((CP)object).d.get(n2);
                Intrinsics.checkNotNullExpressionValue((Object)object9, (String)"");
                if (eh_0.a((VsiBlockState)object9) && n2 != ((DN)object2).getEmpty().toInt()) {
                    Vector3i vector3i = new Vector3i((object3.a() << 4) + n6, (object3.b() << 4) + n3, (object3.c() << 4) + n18);
                    Vector3ic vector3ic = vector3i;
                    object = object2;
                    object = ((DN)object).b;
                    Object object10 = ((CP)object).d.get(n2);
                    Intrinsics.checkNotNull((Object)object10);
                    ((eh_0)object4).a(new ef_0(vector3ic, (VsiBlockState)object10, false));
                    continue;
                }
                Vector3i vector3i = new Vector3i((object3.a() << 4) + n6, (object3.b() << 4) + n3, (object3.c() << 4) + n18);
                Vector3ic vector3ic = vector3i;
                object = object2;
                object = ((DN)object).b;
                Object object11 = ((CP)object).d.get(n2);
                Intrinsics.checkNotNull((Object)object11);
                ((eh_0)object4).a(new ef_0(vector3ic, (VsiBlockState)object11, true));
            }
        }
    }

    public final eq_0 a(ServerShipInternal serverShipInternal) {
        Intrinsics.checkNotNullParameter((Object)serverShipInternal, (String)"");
        return (eq_0)((et_0)this).getLoadedShips().getById(serverShipInternal.getId());
    }

    @Override
    public final void preTick() {
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.PRE_TICK);
        super.preTick();
        Set<VsiPlayer> set = this.getPlayers();
        Object object = this;
        Iterable iterable = ((er_0)object).a;
        object = this;
        ((er_0)object).e.a(org.valkyrienskies.core.impl.shadow.Er$c.GET_LAST_TICK_CHANGES);
        Iterable iterable2 = ((er_0)object).q;
        Iterable iterable3 = iterable;
        Set<? extends VsiPlayer> set2 = this.D;
        Set<VsiPlayer> set3 = set;
        object = this.c;
        Intrinsics.checkNotNullParameter(set3, (String)"");
        Intrinsics.checkNotNullParameter(set2, (String)"");
        Intrinsics.checkNotNullParameter((Object)iterable3, (String)"");
        Intrinsics.checkNotNullParameter((Object)iterable2, (String)"");
        ((ez_0)object).e.a(ez_0.a.PRE_TICK);
        ((ez_0)object).h = ((ez_0)object).b.a(set3, set2, iterable3, iterable2);
    }

    public final void h() {
        Object object;
        Collection<Object> collection;
        Object object2;
        Object object3;
        ByteBuf byteBuf;
        Object object4;
        Iterable<? extends VsiChunkUnwatchTask> iterable;
        Object object5;
        Object object6;
        Object object7;
        Object object82;
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.POST_TICK_START);
        Object object12 = this;
        Object object11 = ((er_0)object12).a;
        Iterable object132 = object11;
        Object object92 = new ArrayList();
        for (Object object82 : object132) {
            ShipData shipData;
            object7 = (ShipData)object82;
            if (!(shipData.getInertiaData().getMass() < 1.0E-8)) continue;
            object92.add(object82);
        }
        object11 = (List)object92;
        Iterator iterator2 = object11.iterator();
        while (iterator2.hasNext()) {
            object92 = iterator2.next();
            ShipData shipData = (ShipData)object92;
            this.deleteShip(shipData);
        }
        object12 = this;
        object11 = ((er_0)object12).f;
        for (Object object92 : object11.entrySet()) {
            Map.Entry<Long, PhysicsEntityServer> entry = object92;
            object82 = object92.getValue();
            if (!((PhysicsEntityServer)object82).getNeedsUpdating()) continue;
            this.n.add((PhysicsEntityServer)object82);
            ((PhysicsEntityServer)object82).setNeedsUpdating(false);
        }
        object11 = ((et_0)this).getLoadedShips();
        Iterator iterator3 = object11.iterator();
        while (iterator3.hasNext()) {
            object92 = iterator3.next();
            eq_0 eq_02 = (eq_0)object92;
            ShipInertiaData shipInertiaData = eq_02.getInertiaData();
            Intrinsics.checkNotNull((Object)shipInertiaData);
            ((ShipInertiaDataImpl)shipInertiaData).setCmChangedThisTick(false);
            object12 = eq_02;
            ((eq_0)object12).b.setNeedsUpdating(false);
            this.m.add(eq_02);
        }
        object11 = new ArrayList();
        object12 = this;
        for (ShipData shipData : ((er_0)object12).a) {
            long l2 = shipData.getId();
            if (shipData.getInertiaData().getMass() == 0.0) {
                EY.a.a().warn("Ship with ID " + l2 + " has a mass of 0.0, this should NOT be possible!");
                continue;
            }
            if (this.G.contains(l2)) continue;
            eq_0 eq_03 = new eq_0(shipData);
            this.k.add(eq_03);
            this.G.add((eq_0)((Ship)eq_03));
            object11.add(eq_03);
        }
        Object object10 = this.j.iterator();
        while (object10.hasNext()) {
            b b2;
            b b3 = b2 = (b)object10.next();
            object92 = b2.a;
            b b4 = b2;
            List<il_0> list = b4.b;
            for (Object object82 : list) {
                Object object13;
                Object v;
                long l3;
                object7 = new Vector3i(object82.a(), object82.b(), object82.c());
                object12 = this;
                object6 = (ShipData)((er_0)object12).a.getByChunkPos(object7.x(), object7.z(), (String)object92);
                if (object6 != null) {
                    l3 = ((ShipDataCommon)object6).getId();
                } else {
                    Long l4 = this.g.get(object92);
                    Intrinsics.checkNotNull((Object)l4);
                    l3 = ((Number)l4).longValue();
                }
                long l5 = l3;
                Long l6 = this.g.get(object92);
                if (l6 != null && l3 == l6) {
                    if (VSCoreConfig.SERVER.getSp().getEnableWorldConnectivity()) {
                        Object object14 = object82;
                        if (object14 instanceof ij_0 ? true : object14 instanceof ik_0) {
                            this.A.a((String)object92, object82.a(), object82.b(), object82.c(), null, (il_0)object82);
                        } else if (object14 instanceof ii_0) {
                            this.A.a((String)object92, object82.a(), object82.b(), object82.c());
                        }
                    }
                } else if (VSCoreConfig.SERVER.getSp().getEnableConnectivity()) {
                    Object object15 = object82;
                    if (object15 instanceof ij_0 ? true : object15 instanceof ik_0) {
                        this.A.a((String)object92, object82.a(), object82.b(), object82.c(), l5, (il_0)object82);
                    } else if (object15 instanceof ii_0) {
                        this.A.a((String)object92, object82.a(), object82.b(), object82.c());
                    }
                }
                if ((v = (object12 = (Map)this.w).get(object5 = Long.valueOf(l5))) == null) {
                    BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap = new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
                    object12.put(object5, blockPos2ObjectOpenHashMap);
                    object13 = blockPos2ObjectOpenHashMap;
                } else {
                    object13 = v;
                }
                BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap = (BlockPos2ObjectOpenHashMap)object13;
                blockPos2ObjectOpenHashMap.set((Vector3ic)object7, object82);
            }
        }
        for (String string : this.d.keySet()) {
            object92 = this.A.a(string);
            HashSet hashSet = (HashSet)object92.component1();
            HashSet hashSet2 = (HashSet)object92.component2();
            object82 = this.A.b(string);
            object7 = (HashSet)object82.component1();
            object6 = (HashSet)object82.component2();
            object5 = hashSet;
            Iterator iterator4 = object5.iterator();
            while (iterator4.hasNext()) {
                object12 = iterator4.next();
                object5 = (SplitEvent)object12;
                object5.setDimensionId(string);
                this.k().getSplitEvent().emit((SplitEvent)object5);
            }
            object5 = hashSet2;
            Iterator iterator5 = object5.iterator();
            while (iterator5.hasNext()) {
                object12 = iterator5.next();
                object5 = (MergeEvent)object12;
                object5.setDimensionId(string);
                this.k().getMergeEvent().emit((MergeEvent)object5);
            }
            object5 = (Iterable)object7;
            Iterator iterator6 = object5.iterator();
            while (iterator6.hasNext()) {
                object12 = iterator6.next();
                object5 = (SplitEvent)object12;
                object5.setDimensionId(string);
                this.k().getSplitEvent().emit((SplitEvent)object5);
            }
            object5 = (Iterable)object6;
            Iterator iterator7 = object5.iterator();
            while (iterator7.hasNext()) {
                object12 = iterator7.next();
                object5 = (MergeEvent)object12;
                object5.setDimensionId(string);
                this.k().getMergeEvent().emit((MergeEvent)object5);
            }
        }
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.POST_TICK_GENERATED);
        object12 = this;
        Iterable iterable2 = this.p;
        object92 = ((er_0)object12).f.values();
        Set<? extends VsiPlayer> set = this.D;
        object10 = this.getPlayers();
        ez_0 ez_02 = this.c;
        Intrinsics.checkNotNullParameter((Object)object10, (String)"");
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(object92, (String)"");
        Intrinsics.checkNotNullParameter((Object)iterable2, (String)"");
        ez_02.e.a(ez_0.a.POST_TICK);
        ez_02.i = ez_02.d.a((Set<? extends VsiPlayer>)object10, set, (Iterable<PhysicsEntityServer>)object92, iterable2);
        CY cY = ez_02.b;
        Iterable<? extends VsiChunkWatchTask> iterable3 = ez_02.f;
        if (iterable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable3 = null;
        }
        if ((iterable = ez_02.g) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable = null;
        }
        CR cR = cY.a(iterable3, iterable);
        EO eO = ez_02.a;
        Iterable iterable4 = (Iterable)object10;
        fu_0 fu_02 = ez_02.i;
        if (fu_02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            fu_02 = null;
        }
        fu_0 fu_03 = fu_02;
        object92 = cR;
        Iterable iterable5 = iterable4;
        object10 = eO;
        Intrinsics.checkNotNullParameter((Object)iterable5, (String)"");
        Intrinsics.checkNotNullParameter(object92, (String)"");
        Intrinsics.checkNotNullParameter((Object)fu_03, (String)"");
        ((EO)object10).d = iterable5;
        ((EO)object10).e = object92;
        ((EO)object10).f = fu_03;
        ByteBuf byteBuf2 = object10;
        Iterable<? extends VsiPlayer> iterable6 = byteBuf2.d;
        if (iterable6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable6 = null;
        }
        for (VsiPlayer vsiPlayer : iterable6) {
            Set set2;
            ByteBuf byteBuf3 = Unpooled.buffer();
            Object object16 = byteBuf2.e;
            if (object16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object16 = object12 = null;
            }
            if ((set2 = ((CR)object16).b.get(vsiPlayer)) == null) {
                set2 = SetsKt.emptySet();
            }
            object82 = set2;
            object5 = vsiPlayer;
            object4 = byteBuf2;
            CR cR2 = ((EO)object4).e;
            if (cR2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                cR2 = null;
            }
            object6 = object5;
            byteBuf = cR2;
            Intrinsics.checkNotNullParameter((Object)object6, (String)"");
            Map map2 = byteBuf.a.get(object6);
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            object6 = object7 = (Iterable)map2.keySet();
            object7 = new ArrayList();
            object4 = object6.iterator();
            while (object4.hasNext()) {
                object12 = object4.next();
                object3 = (ServerShipInternal)object12;
                if (!(!object82.contains(object3))) continue;
                object7.add(object12);
            }
            object6 = object7 = (Iterable)((List)object7);
            object7 = new ArrayList();
            object4 = object6;
            object3 = object4.iterator();
            while (object3.hasNext()) {
                object2 = object4 = object3.next();
                ServerShipInternal serverShipInternal = (ServerShipInternal)object4;
                object5 = serverShipInternal;
                object4 = byteBuf2.a();
                Intrinsics.checkNotNullParameter((Object)object5, (String)"");
                eq_0 eq_04 = (eq_0)((et_0)object4).getLoadedShips().getById(object5.getId());
                if (eq_04 == null) continue;
                object4 = eq_04;
                object7.add(object4);
            }
            if ((object7 = (List)object7).isEmpty()) continue;
            object7 = (Iterable)object7;
            object6 = object7.iterator();
            while (object6.hasNext()) {
                object7 = object6.next();
                object12 = object5 = (eq_0)object7;
                byteBuf3.writeLong(((eq_0)object12).b.getId());
                object12 = object5;
                object12 = VSJacksonUtil.INSTANCE.getDeltaMapper().valueToTree(((eq_0)object12).b);
                object4 = object5;
                fp_0<JsonNode> fp_02 = ((eq_0)object4).d;
                Intrinsics.checkNotNullExpressionValue((Object)object12, (String)"");
                Intrinsics.checkNotNullExpressionValue((Object)byteBuf3, (String)"");
                byteBuf = byteBuf3;
                object5 = object12;
                object4 = fp_02;
                Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
                ((fp_0)object4).a.a(((fp_0)object4).b, object5, byteBuf);
                ((fp_0)object4).b = object5;
            }
            object12 = byteBuf2.c;
            fa_0 fa_02 = ((fb_0)object12).c;
            Intrinsics.checkNotNullExpressionValue((Object)byteBuf3, (String)"");
            fa_02.a(byteBuf3, vsiPlayer);
        }
        ByteBuf byteBuf4 = object10;
        Iterable<? extends VsiPlayer> iterable7 = byteBuf4.d;
        if (iterable7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable7 = null;
        }
        for (VsiPlayer vsiPlayer : iterable7) {
            CR cR3;
            Set set3;
            Set set4;
            Object object17 = byteBuf4.e;
            if (object17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object17 = object7 = null;
            }
            if ((set4 = ((CR)object17).c.get(vsiPlayer)) == null) {
                set4 = set3 = SetsKt.emptySet();
            }
            if ((cR3 = byteBuf4.e) == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                cR3 = null;
            }
            object7 = cR3;
            object4 = SetsKt.plus((Set)set3, (Iterable)cR3.d);
            object5 = vsiPlayer;
            object7 = byteBuf4;
            object2 = object3 = object4;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object3, (int)10));
            object = object2.iterator();
            while (object.hasNext()) {
                object4 = object.next();
                object4 = (ServerShipInternal)object4;
                byteBuf = collection;
                byteBuf.add(object4.getId());
            }
            object12 = (List)collection;
            if (!object12.isEmpty()) {
                EO.a.a(EO.a).debug("{} unwatched ships {}", (Object)object5.getUuid(), object12);
                ((EO)object7).b.sendToClient(new PacketShipRemove((List<Long>)object12), (VsiPlayer)object5);
            }
            object5 = vsiPlayer;
            object7 = byteBuf4;
            Object object18 = ((EO)object7).e;
            if (object18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object18 = object12 = null;
            }
            if (!((CR)object18).e.contains(object5)) continue;
            Object object19 = ((EO)object7).e;
            if (object19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                object19 = object12 = null;
            }
            if (!((object4 = (Collection)((CR)object19).b.get(object5)) == null || object4.isEmpty())) continue;
            ((EO)object7).b.sendToClient(new PacketShipDataCreate(CollectionsKt.emptyList()), (VsiPlayer)object5);
        }
        CR cR4 = byteBuf4.e;
        if (cR4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            cR4 = null;
        }
        object12 = cR4;
        object92 = cR4.b;
        Iterator<Map.Entry<VsiPlayer, Set<ServerShipInternal>>> iterator8 = object92.entrySet().iterator();
        while (iterator8.hasNext()) {
            object7 = object82 = iterator8.next();
            object92 = object82.getKey();
            object6 = (Set)object7.getValue();
            object4 = (Iterable)object6;
            object5 = object92;
            object7 = byteBuf4;
            object2 = object3 = object4;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(object3, (int)10));
            object = object2.iterator();
            while (object.hasNext()) {
                object4 = object.next();
                object4 = (ServerShipInternal)object4;
                byteBuf = collection;
                byteBuf.add(object4.asShipDataCommon());
            }
            object12 = (List)collection;
            if (object12.isEmpty()) continue;
            object3 = (Iterable)object12;
            object92 = object5.getUuid();
            object6 = "{} watched ships: {}";
            byteBuf = EO.a.a(EO.a);
            object2 = object3;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object3, (int)10));
            object = object2.iterator();
            while (object.hasNext()) {
                object4 = object.next();
                object4 = (ShipDataCommon)object4;
                Collection collection2 = collection;
                collection2.add(((ShipDataCommon)object4).getId());
            }
            List list = (List)collection;
            byteBuf.debug((String)object6, object92, (Object)list);
            ((EO)object7).b.sendToClient(new PacketShipDataCreate((List<? extends ShipDataCommon>)object12), (VsiPlayer)object5);
        }
        ByteBuf byteBuf5 = object10;
        object92 = ImmutableMap.builder();
        CR cR5 = byteBuf5.e;
        if (cR5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            cR5 = null;
        }
        object5 = cR5;
        Map<VsiPlayer, Map<ServerShipInternal, LongSet>> map3 = cR5.a;
        for (Map.Entry entry : map3.entrySet()) {
            object7 = entry;
            object7 = entry;
            object6 = (VsiPlayer)entry.getKey();
            object7 = (Map)object7.getValue();
            object92.put(object6, VSCoreUtilKt.toImmutableSet(object7.keySet()));
        }
        ImmutableMap immutableMap = object92.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"");
        byteBuf5.g = immutableMap;
        ByteBuf byteBuf6 = object10;
        object92 = ImmutableMap.builder();
        fu_0 fu_04 = byteBuf6.f;
        if (fu_04 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            fu_04 = null;
        }
        byteBuf = fu_04;
        Map<VsiPlayer, Set<Long>> map4 = fu_04.a;
        for (Map.Entry entry : map4.entrySet()) {
            object7 = entry;
            object7 = entry;
            object6 = (VsiPlayer)entry.getKey();
            object7 = (Set)object7.getValue();
            object5 = ImmutableSet.builder();
            object4 = (Iterable)object7;
            object3 = object4.iterator();
            while (object3.hasNext()) {
                object4 = object3.next();
                long l7 = ((Number)object4).longValue();
                object12 = byteBuf6.a();
                object = ((er_0)object12).f.get(l7);
                if (object == null) continue;
                object5.add(object);
            }
            object92.put(object6, (Object)object5.build());
        }
        ImmutableMap immutableMap2 = object92.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap2, (String)"");
        byteBuf6.h = immutableMap2;
        Iterable<? extends VsiPlayer> iterable8 = byteBuf6.d;
        if (iterable8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable8 = null;
        }
        for (VsiPlayer vsiPlayer : iterable8) {
            Set set5;
            fu_0 fu_05 = byteBuf6.f;
            if (fu_05 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"");
                fu_05 = byteBuf = null;
            }
            if ((set5 = fu_05.c.get(vsiPlayer)) == null) {
                set5 = SetsKt.emptySet();
            }
            object82 = set5;
            object92 = (Iterable)object82;
            object6 = vsiPlayer;
            byteBuf = byteBuf6;
            if (!object92.iterator().hasNext()) continue;
            EO.a.a(EO.a).debug("{} unwatched physics entities {}", (Object)object6.getUuid(), object92);
            byteBuf.b.sendToClient(new PacketPhysEntityRemove(CollectionsKt.toList((Iterable)object92)), (VsiPlayer)object6);
        }
        fu_0 fu_06 = byteBuf6.f;
        if (fu_06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            fu_06 = null;
        }
        byteBuf = fu_06;
        Map<VsiPlayer, Set<Long>> map5 = fu_06.b;
        for (Map.Entry entry : map5.entrySet()) {
            object7 = entry;
            object7 = entry;
            object6 = (VsiPlayer)entry.getKey();
            object7 = (Set)object7.getValue();
            object12 = object5 = (Iterable)object7;
            object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object5, (int)10));
            Iterator iterator9 = object12.iterator();
            while (iterator9.hasNext()) {
                collection = iterator9.next();
                long l8 = ((Number)((Object)collection)).longValue();
                object4 = object3;
                object12 = byteBuf6.a();
                PhysicsEntityServer physicsEntityServer = ((er_0)object12).f.get(l8);
                Intrinsics.checkNotNull((Object)physicsEntityServer);
                object4.add(physicsEntityServer);
            }
            object5 = (List)object3;
            object92 = (Iterable)object5;
            byteBuf = byteBuf6;
            object92 = object10 = object92;
            object10 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object10, (int)10));
            object92 = object92.iterator();
            while (object92.hasNext()) {
                Object e2 = object92.next();
                PhysicsEntityServer physicsEntityServer = (PhysicsEntityServer)e2;
                object7 = object10;
                object7.add(new PhysEntityCreateData(physicsEntityServer.getId(), physicsEntityServer.getDimensionId(), physicsEntityServer.getShipTransform(), physicsEntityServer.getCollisionShapeData()));
            }
            List list = (List)object10;
            if (list.isEmpty()) continue;
            object10 = list;
            object4 = object6.getUuid();
            object5 = "{} watched physics entities: {}";
            object7 = EO.a.a(EO.a);
            object92 = object10;
            object10 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object10, (int)10));
            object92 = object92.iterator();
            while (object92.hasNext()) {
                Object e3 = object92.next();
                PhysEntityCreateData physEntityCreateData = (PhysEntityCreateData)e3;
                object12 = object10;
                object12.add(physEntityCreateData.getId());
            }
            object12 = (List)object10;
            object7.debug((String)object5, object4, object12);
            byteBuf.b.sendToClient(new PacketPhysEntityCreate(list), (VsiPlayer)object6);
        }
        object10 = (Iterable)object11;
        object92 = object10.iterator();
        while (object92.hasNext()) {
            Object e4 = object92.next();
            eq_0 eq_05 = (eq_0)e4;
            VSEvents.INSTANCE.getShipLoadEvent().emit(new VSEvents.ShipLoadEvent(eq_05));
        }
        VSEvents.INSTANCE.getTickEndEvent().emit(new VSEvents.TickEndEvent(this));
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.POST_TICK_FINISH);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Iterator<VsiPlayer> getIPlayersWatchingShipChunk(int chunkX, int chunkZ, String dimensionId) {
        void var1_1;
        void var2_3;
        void var3_4;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        void var4_6 = var3_4;
        void var3_5 = var2_3;
        var2_3 = var1_1;
        ez_0 ez_02 = this.c;
        Intrinsics.checkNotNullParameter((Object)var4_6, (String)"");
        if (ez_02.c.forDimension((String)var4_6).isChunkInShipyard((int)var2_3, (int)var3_5)) {
            return ez_02.b.a((int)var2_3, (int)var3_5, (String)var4_6).iterator();
        }
        Iterator<VsiPlayer> iterator2 = Collections.emptyIterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
        return iterator2;
    }

    @Override
    public final VsiChunkWatchTasks getChunkWatchTasks() {
        ez_0 ez_02 = this.c;
        VsiChunkWatchTasks vsiChunkWatchTasks = ez_02.h;
        if (vsiChunkWatchTasks == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            vsiChunkWatchTasks = null;
        }
        return vsiChunkWatchTasks;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setExecutedChunkWatchTasks(Iterable<? extends VsiChunkWatchTask> watchTasks, Iterable<? extends VsiChunkUnwatchTask> unwatchTasks) {
        ez_0 ez_02;
        void var2_2;
        Intrinsics.checkNotNullParameter(watchTasks, (String)"");
        Intrinsics.checkNotNullParameter(unwatchTasks, (String)"");
        void var3_3 = var2_2;
        var2_2 = ez_02;
        ez_02 = this.c;
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
        ez_02.e.a(ez_0.a.SET_EXECUTED);
        ez_02.f = var2_2;
        ez_02.g = var3_3;
    }

    private CompletableFuture<ServerShip> a(Vector3ic object, boolean bl, double d2, String string) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        CompletableFuture<ServerShip> completableFuture = new CompletableFuture<ServerShip>();
        object = this.b((Vector3ic)object, bl, d2, string);
        VSEvents.ShipLoadEvent.Companion.once((Predicate<? super VSEvents.ShipLoadEvent>)((Predicate<Object>)arg_0 -> er_0.a((Function1)new Function1<VSEvents.ShipLoadEvent, Boolean>((ShipData)object){
            private /* synthetic */ ShipData $a;
            {
                this.$a = shipData;
                super(1);
            }

            public final Boolean a(VSEvents.ShipLoadEvent shipLoadEvent) {
                Intrinsics.checkNotNullParameter((Object)shipLoadEvent, (String)"");
                return shipLoadEvent.getShip().getId() == this.$a.getId();
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1) {
                void var1_1;
                return this.a((VSEvents.ShipLoadEvent)var1_1);
            }
        }, arg_0)), (Consumer<? super VSEvents.ShipLoadEvent>)((Consumer<Object>)arg_0 -> er_0.b((Function1)new Function1<VSEvents.ShipLoadEvent, Unit>(completableFuture){
            private /* synthetic */ CompletableFuture<ServerShip> $a;
            {
                this.$a = completableFuture;
                super(1);
            }

            public final void a(VSEvents.ShipLoadEvent shipLoadEvent) {
                Intrinsics.checkNotNullParameter((Object)shipLoadEvent, (String)"");
                this.$a.complete(shipLoadEvent.getShip());
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1) {
                void var1_1;
                this.a((VSEvents.ShipLoadEvent)var1_1);
                return Unit.INSTANCE;
            }
        }, arg_0)));
        return completableFuture;
    }

    private static /* synthetic */ CompletableFuture a(er_0 object, Vector3ic vector3ic, boolean bl, double d2, String string, int n2) {
        if ((n2 & 4) != 0) {
            d2 = 1.0;
        }
        String string2 = string;
        double d3 = d2;
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"");
        CompletableFuture<ServerShip> completableFuture = new CompletableFuture<ServerShip>();
        object = ((er_0)object).b(vector3ic, bl, d3, string2);
        VSEvents.ShipLoadEvent.Companion.once((Predicate<? super VSEvents.ShipLoadEvent>)((Predicate<Object>)arg_0 -> er_0.a((Function1)new /* invalid duplicate definition of identical inner class */, arg_0)), (Consumer<? super VSEvents.ShipLoadEvent>)((Consumer<Object>)arg_0 -> er_0.b((Function1)new /* invalid duplicate definition of identical inner class */, arg_0)));
        return completableFuture;
    }

    private ShipData b(Vector3ic object, boolean bl, double d2, String string) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        ChunkAllocator chunkAllocator = this.b.forDimension(string);
        ChunkClaim chunkClaim = chunkAllocator.allocateNewChunkClaim();
        String string2 = gw_0.INSTANCE.a();
        Vector3d vector3d = new Vector3d((Vector3ic)object).add(0.5, 0.5, 0.5);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        object = vector3d;
        Object object2 = ChunkClaim.getCenterBlockCoordinates$default(chunkClaim, this.a(string), null, 2, null);
        Vector3d vector3d2 = new Vector3d((Vector3ic)object2).add(0.5, 0.5, 0.5);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
        object2 = vector3d2;
        object = ShipData.Factory.createEmpty$default(this.B, string2, chunkAllocator.allocateShipId(), chunkClaim, string, (Vector3dc)object, (Vector3dc)object2, d2, false, 128, null);
        er_0 er_02 = this;
        er_02.a.add((ShipData)((Ship)object));
        if (bl) {
            object = "Not implemented";
            throw new NotImplementedError("An operation is not implemented: " + (String)object);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final PhysicsEntityServer createPhysicsEntity(PhysicsEntityData physicsEntityData, String dimensionId) {
        void var1_1;
        PhysicsEntityServer physicsEntityServer;
        Intrinsics.checkNotNullParameter((Object)physicsEntityData, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        if (this.f.containsKey(physicsEntityData.getShipId())) {
            throw new IllegalArgumentException("We already have a physics entity registered to id " + physicsEntityData.getShipId() + "!");
        }
        physicsEntityServer = new PhysicsEntityServer(physicsEntityData.getShipId(), (String)((Object)physicsEntityServer), physicsEntityData.getLinearVelocity(), physicsEntityData.getAngularVelocity(), physicsEntityData.getInertiaData(), physicsEntityData.getTransform(), physicsEntityData.getTransform(), 0, physicsEntityData.getCollisionShapeData(), physicsEntityData.getCollisionMask(), physicsEntityData.getStaticFrictionCoefficient(), physicsEntityData.getDynamicFrictionCoefficient(), physicsEntityData.getRestitutionCoefficient(), physicsEntityData.isStatic(), false, null, 49152, null);
        this.f.put(var1_1.getShipId(), physicsEntityServer);
        this.l.add(physicsEntityServer);
        return physicsEntityServer;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void deletePhysicsEntity(long id) {
        void var1_1;
        Long l2 = id;
        if (!this.f.containsKey(l2)) {
            throw new IllegalArgumentException("Trying to remove a physics entity that doesn't exist with id " + id + "!");
        }
        this.f.remove(id);
        this.p.add((long)var1_1);
    }

    @Override
    public final long allocateShipId(String dimensionId) {
        ChunkAllocator chunkAllocator;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        chunkAllocator = this.b.forDimension((String)((Object)chunkAllocator));
        return chunkAllocator.allocateShipId();
    }

    private final boolean a(long l2) {
        er_0 er_02 = this;
        return er_02.a.contains(l2) || this.f.containsKey(l2) || this.getDimensionToGroundBodyIdImmutable().containsValue(l2);
    }

    public final LevelYRange a(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = (DP)MapsKt.getValue(this.d, (Object)object);
        return ((DP)object).b;
    }

    @Override
    public final void destroyWorld() {
    }

    public final a i() {
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.GET_CURRENT_TICK_CHANGES);
        er_0 er_02 = this;
        return er_02.new a((Collection<eq_0>)er_02.k, (Collection<PhysicsEntityServer>)this.l, (Collection<eq_0>)this.m, (Collection<PhysicsEntityServer>)this.n, (Collection<ShipData>)this.o, (Collection<Long>)this.p, this.w, (Collection<String>)this.h, (Collection<String>)this.i, (Collection<VSJointAndId>)this.r, this.s.values(), (Collection<Integer>)this.t, this.u, this.v);
    }

    public final void j() {
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.CLEAR_FOR_RESET);
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.q = CollectionsKt.toList((Iterable)this.o);
        this.o.clear();
        this.p.clear();
        this.w.clear();
        this.j.clear();
        this.h.clear();
        Object object = this.i;
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            boolean bl = this.g.remove(object2 = (String)object2) != null;
            if (bl) continue;
            throw new IllegalStateException("Check failed.");
        }
        this.i.clear();
        this.r = new ArrayList();
        this.s = new HashMap();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addDimension(String dimensionId, LevelYRange yRange, Vector3dc gravity, double seaLevel, double maxY) {
        void var3_3;
        void var1_1;
        er_0 er_02;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)yRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)gravity, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.UPDATE_DIMENSIONS);
        if (!(!this.d.containsKey(dimensionId))) {
            dimensionId = "Failed requirement.";
            throw new IllegalArgumentException(dimensionId.toString());
        }
        if (!(!this.g.containsKey(dimensionId))) {
            dimensionId = "Failed requirement.";
            throw new IllegalArgumentException(dimensionId.toString());
        }
        this.h.add(dimensionId);
        this.g.put(dimensionId, this.b.forDimension(dimensionId).allocateShipId());
        this.d.put(dimensionId, new DP(dimensionId, (LevelYRange)((Object)er_02), new Vector3d(gravity)));
        er_02 = this;
        er_02.x.registerDimension((String)var1_1, maxY, seaLevel, -var3_3.y());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateDimension(String dimensionId, Vector3dc gravity, Double seaLevel, Double maxY) {
        void var2_2;
        DP dP;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)gravity, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.UPDATE_DIMENSIONS);
        DP dP2 = this.d.get(dimensionId);
        if (dP2 == null) {
            throw new IllegalArgumentException("No existing dimension info found for dimensionId: " + dimensionId);
        }
        DP dP3 = dP = dP2;
        Object object = dP3;
        object = dP;
        dP = new DP(dP3.a, ((DP)object).b, gravity);
        this.d.put(dimensionId, dP);
        object = this;
        ((er_0)object).x.updateGravityForDimension(dimensionId, -var2_2.y());
        if (seaLevel != null || maxY != null) {
            void var3_3;
            void var1_1;
            object = this;
            ((er_0)object).x.updateAerodynamicInfoForDimension((String)var1_1, maxY, (Double)var3_3);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void removeDimension(String dimensionId) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Er$c.UPDATE_DIMENSIONS);
        if (!this.d.containsKey(dimensionId)) {
            dimensionId = "Failed requirement.";
            throw new IllegalArgumentException(dimensionId.toString());
        }
        if (!this.g.containsKey(dimensionId)) {
            dimensionId = "Failed requirement.";
            throw new IllegalArgumentException(dimensionId.toString());
        }
        this.i.add(dimensionId);
        this.d.remove(dimensionId);
        Object object = this;
        object = ((er_0)object).x;
        ((DL)object).a.remove(var1_1);
    }

    @Override
    public final void onDisconnect(VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"");
        fg_0 fg_02 = this.I;
        if (fg_02 != null) {
            fg_0 fg_03;
            void var2_2 = fg_03;
            fg_03 = fg_02;
            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
            fg_03.b.inverse().remove((Object)var2_2);
            ((ObjectCollection)fg_03.c.values()).remove((Object)var2_2);
            fg_03.d.remove(var2_2);
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void deleteShip(ServerShip ship) {
        void var1_1;
        Object object;
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        if (this.G.contains(ship.getId())) {
            ShipData shipData;
            if (ship instanceof eq_0) {
                object = (eq_0)ship;
                shipData = ((eq_0)object).b;
            } else {
                shipData = (ShipData)ship;
            }
            object = shipData;
            this.o.add((ShipData)object);
            this.G.remove(ship.getId());
        }
        object = this;
        ((er_0)object).a.remove(ship.getId());
        this.w.remove(var1_1.getId());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportShip(ServerShip ship, ShipTeleportData teleportData) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        Intrinsics.checkNotNullParameter((Object)teleportData, (String)"");
        ServerShipInternal serverShipInternal = (eq_0)((et_0)this).getLoadedShips().getById(ship.getId());
        String string = teleportData.getNewDimension();
        boolean bl2 = bl = string != null && !Intrinsics.areEqual((Object)ship.getChunkClaimDimension(), (Object)string);
        if (serverShipInternal != null) {
            ((eq_0)serverShipInternal).teleportShip(teleportData);
            if (bl) {
                VsiGameServer vsiGameServer = this.F;
                Intrinsics.checkNotNull((Object)vsiGameServer);
                IShipActiveChunksSet iShipActiveChunksSet = ship.getActiveChunksSet();
                String string2 = ship.getChunkClaimDimension();
                String string3 = string;
                Intrinsics.checkNotNull((Object)string3);
                vsiGameServer.moveTerrainAcrossDimensions(iShipActiveChunksSet, string2, string3);
                this.G.remove(ship.getId());
                ServerShipInternal serverShipInternal2 = serverShipInternal;
                this.o.add(((eq_0)serverShipInternal2).b);
                ship.getActiveChunksSet().forEach((arg_0, arg_1) -> er_0.a((eq_0)serverShipInternal, arg_0, arg_1));
                ShipInternal cfr_ignored_0 = (ShipInternal)((Object)ship);
                ((ShipInternal)((Object)ship)).setChunkClaimDimension(string);
                return;
            }
        } else {
            void var2_2;
            er_0 er_02 = this;
            Object ShipType = er_02.a.getById(ship.getId());
            Intrinsics.checkNotNull(ShipType);
            serverShipInternal = (ShipData)ShipType;
            ((ShipDataCommon)((Object)serverShipInternal)).setKinematics(var2_2.createNewShipTransform(ship.getTransform()));
            ((ShipData)serverShipInternal).setNeedsUpdating(true);
            if (bl) {
                void var1_1;
                VsiGameServer vsiGameServer = this.F;
                Intrinsics.checkNotNull((Object)vsiGameServer);
                IShipActiveChunksSet iShipActiveChunksSet = ship.getActiveChunksSet();
                String string4 = var1_1.getChunkClaimDimension();
                String string5 = string;
                Intrinsics.checkNotNull((Object)string5);
                vsiGameServer.moveTerrainAcrossDimensions(iShipActiveChunksSet, string4, string5);
                ((ShipDataCommon)((Object)serverShipInternal)).setChunkClaimDimension(string);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportPhysicsEntity(PhysicsEntityServer physicsEntityServer, ShipTeleportData teleportData) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)physicsEntityServer, (String)"");
        Intrinsics.checkNotNullParameter((Object)teleportData, (String)"");
        int n2 = physicsEntityServer.getShipTeleportId();
        physicsEntityServer.setShipTeleportId(n2 + 1);
        BodyTransform bodyTransform = teleportData.createNewShipTransform(physicsEntityServer.getShipTransform()).getTransform();
        Intrinsics.checkNotNull((Object)bodyTransform);
        physicsEntityServer.setShipTransform((ShipTransform)bodyTransform);
        physicsEntityServer.setLinearVelocity(teleportData.getNewVel());
        physicsEntityServer.setAngularVelocity(var2_2.getNewOmega());
        var1_1.setNeedsUpdating(true);
    }

    private static final boolean a(Function1 function1, Object object) {
        return (Boolean)function1.invoke(object);
    }

    private static final void b(Function1 function1, Object object) {
        function1.invoke(object);
    }

    private static final void a(eq_0 eq_02, int n2, int n3) {
        eq_02.onUnloadChunk(n2, n3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final /* synthetic */ ServerShip createNewShipAtBlock(Vector3ic blockPosInWorldCoordinates, boolean createShipObjectImmediately, double scaling, String dimensionId) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.b((Vector3ic)var1_1, (boolean)var2_2, (double)var3_3, dimensionId);
    }

    public static final /* synthetic */ Map a(er_0 er_02) {
        return er_02.g;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(er_0.class, "vsCore", "getVsCore()Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", 0)));
        y = kPropertyArray2;
    }

    public final class a {
        public final Collection<eq_0> a;
        public final Collection<PhysicsEntityServer> b;
        public final Collection<eq_0> c;
        public final Collection<PhysicsEntityServer> d;
        public final Collection<ShipData> e;
        public final Collection<Long> f;
        public final Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> g;
        public final Collection<String> h;
        public final Collection<String> i;
        public final Collection<VSJointAndId> j;
        public final Collection<VSJointAndId> k;
        public final Collection<Integer> l;
        public final List<fy_0> m;
        public final List<fy_0> n;

        public a(Collection<eq_0> collection, Collection<PhysicsEntityServer> collection2, Collection<eq_0> collection3, Collection<PhysicsEntityServer> collection4, Collection<ShipData> collection5, Collection<Long> collection6, Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> long2ObjectMap, Collection<String> collection7, Collection<String> collection8, Collection<VSJointAndId> collection9, Collection<VSJointAndId> collection10, Collection<Integer> collection11, List<fy_0> list, List<fy_0> list2) {
            Intrinsics.checkNotNullParameter(collection, (String)"");
            Intrinsics.checkNotNullParameter(collection2, (String)"");
            Intrinsics.checkNotNullParameter(collection3, (String)"");
            Intrinsics.checkNotNullParameter(collection4, (String)"");
            Intrinsics.checkNotNullParameter(collection5, (String)"");
            Intrinsics.checkNotNullParameter(collection6, (String)"");
            Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
            Intrinsics.checkNotNullParameter(collection7, (String)"");
            Intrinsics.checkNotNullParameter(collection8, (String)"");
            Intrinsics.checkNotNullParameter(collection9, (String)"");
            Intrinsics.checkNotNullParameter(collection10, (String)"");
            Intrinsics.checkNotNullParameter(collection11, (String)"");
            Intrinsics.checkNotNullParameter(list, (String)"");
            Intrinsics.checkNotNullParameter(list2, (String)"");
            this.a = collection;
            this.b = collection2;
            this.c = collection3;
            this.d = collection4;
            this.e = collection5;
            this.f = collection6;
            this.g = long2ObjectMap;
            this.h = collection7;
            this.i = collection8;
            this.j = collection9;
            this.k = collection10;
            this.l = collection11;
            this.m = list;
            this.n = list2;
        }

        public final Collection<eq_0> a() {
            return this.a;
        }

        public final Collection<PhysicsEntityServer> b() {
            return this.b;
        }

        public final Collection<eq_0> c() {
            return this.c;
        }

        public final Collection<PhysicsEntityServer> d() {
            return this.d;
        }

        private Collection<ShipData> m() {
            return this.e;
        }

        private Collection<Long> n() {
            return this.f;
        }

        public final Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> e() {
            return this.g;
        }

        private Collection<String> o() {
            return this.h;
        }

        private Collection<String> p() {
            return this.i;
        }

        public final Collection<VSJointAndId> f() {
            return this.j;
        }

        public final Collection<VSJointAndId> g() {
            return this.k;
        }

        public final Collection<Integer> h() {
            return this.l;
        }

        public final List<fy_0> i() {
            return this.m;
        }

        public final List<fy_0> j() {
            return this.n;
        }

        public final List<Pair<String, Long>> k() {
            Iterable iterable = this.h;
            er_0 er_02 = er_0.this;
            Object object = iterable;
            iterable = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            object = object.iterator();
            while (object.hasNext()) {
                Object object2 = object.next();
                object2 = (String)object2;
                Iterable iterable2 = iterable;
                Object v = Er.a((er_0)er_02).get(object2);
                Intrinsics.checkNotNull(v);
                iterable2.add(new Pair(object2, v));
            }
            return (List)iterable;
        }

        public final List<Long> l() {
            Iterable iterable;
            Object object;
            Object object2 = this.i;
            Object object3 = er_0.this;
            Object object4 = object2;
            object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
            Iterator<Object> iterator2 = object4.iterator();
            while (iterator2.hasNext()) {
                object = iterator2.next();
                object4 = (String)object;
                iterable = object2;
                Object v = Er.a((er_0)object3).get(object4);
                Intrinsics.checkNotNull(v);
                iterable.add(((Number)v).longValue());
            }
            List list = (List)object2;
            object2 = list;
            object2 = this.e;
            iterable = list;
            object3 = object2;
            object4 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
            object2 = object3.iterator();
            while (object2.hasNext()) {
                iterator2 = object2.next();
                object = (ShipData)((Object)iterator2);
                object3 = object4;
                object3.add(((ShipDataCommon)object).getId());
            }
            return CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)iterable, (Iterable)((List)object4)), (Iterable)this.f);
        }
    }

    public static final class b {
        final String a;
        final List<il_0> b;

        public b(String string, List<? extends il_0> list) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"");
            Intrinsics.checkNotNullParameter(list, (String)"");
            this.a = string;
            this.b = list;
        }

        private String c() {
            return this.a;
        }

        private List<il_0> d() {
            return this.b;
        }

        public final String a() {
            return this.a;
        }

        public final List<il_0> b() {
            return this.b;
        }

        private static b a(String string, List<? extends il_0> list) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"");
            Intrinsics.checkNotNullParameter(list, (String)"");
            return new b(string, list);
        }

        private static /* synthetic */ b a(b object, String object2, List list, int n2) {
            if ((n2 & 1) != 0) {
                object2 = ((b)object).a;
            }
            if ((n2 & 2) != 0) {
                list = ((b)object).b;
            }
            String string = object2;
            object2 = list;
            object = string;
            Intrinsics.checkNotNullParameter((Object)string, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            return new b((String)object, (List<? extends il_0>)object2);
        }

        public final String toString() {
            return "LevelVoxelUpdates(dimensionId=" + this.a + ", updates=" + this.b + ")";
        }

        public final int hashCode() {
            int n2 = this.a.hashCode();
            n2 = n2 * 31 + ((Object)this.b).hashCode();
            return n2;
        }

        public final boolean equals(Object other) {
            b b2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b2 = b2;
            if (!Intrinsics.areEqual((Object)this.a, (Object)b2.a)) {
                return false;
            }
            return Intrinsics.areEqual(this.b, b2.b);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Er$c;", "", "<init>", "(Ljava/lang/String;I)V", "PRE_TICK", "POST_TICK_START", "POST_TICK_GENERATED", "POST_TICK_FINISH", "GET_CURRENT_TICK_CHANGES", "GET_LAST_TICK_CHANGES", "UPDATE_DIMENSIONS", "UPDATE_BLOCKS", "UPDATE_CHUNKS", "UPDATE_PLAYERS", "CLEAR_FOR_RESET"})
    public static final class c
    extends Enum<c> {
        public static final /* enum */ c PRE_TICK = new c();
        public static final /* enum */ c POST_TICK_START = new c();
        public static final /* enum */ c POST_TICK_GENERATED = new c();
        public static final /* enum */ c POST_TICK_FINISH = new c();
        public static final /* enum */ c GET_CURRENT_TICK_CHANGES = new c();
        public static final /* enum */ c GET_LAST_TICK_CHANGES = new c();
        public static final /* enum */ c UPDATE_DIMENSIONS = new c();
        public static final /* enum */ c UPDATE_BLOCKS = new c();
        public static final /* enum */ c UPDATE_CHUNKS = new c();
        public static final /* enum */ c UPDATE_PLAYERS = new c();
        public static final /* enum */ c CLEAR_FOR_RESET = new c();
        private static final /* synthetic */ c[] $VALUES;

        public static c[] values() {
            return (c[])$VALUES.clone();
        }

        public static c valueOf(String value) {
            String string;
            return Enum.valueOf(c.class, string);
        }

        private static final /* synthetic */ c[] a() {
            c[] cArray = new c[11];
            c[] cArray2 = cArray;
            cArray[0] = PRE_TICK;
            cArray2[1] = POST_TICK_START;
            cArray2[2] = POST_TICK_GENERATED;
            cArray2[3] = POST_TICK_FINISH;
            cArray2[4] = GET_CURRENT_TICK_CHANGES;
            cArray2[5] = GET_LAST_TICK_CHANGES;
            cArray2[6] = UPDATE_DIMENSIONS;
            cArray2[7] = UPDATE_BLOCKS;
            cArray2[8] = UPDATE_CHUNKS;
            cArray2[9] = UPDATE_PLAYERS;
            cArray2[10] = CLEAR_FOR_RESET;
            return cArray2;
        }

        static {
            c[] cArray = new c[11];
            c[] cArray2 = cArray;
            cArray[0] = PRE_TICK;
            cArray2[1] = POST_TICK_START;
            cArray2[2] = POST_TICK_GENERATED;
            cArray2[3] = POST_TICK_FINISH;
            cArray2[4] = GET_CURRENT_TICK_CHANGES;
            cArray2[5] = GET_LAST_TICK_CHANGES;
            cArray2[6] = UPDATE_DIMENSIONS;
            cArray2[7] = UPDATE_BLOCKS;
            cArray2[8] = UPDATE_CHUNKS;
            cArray2[9] = UPDATE_PLAYERS;
            cArray2[10] = CLEAR_FOR_RESET;
            $VALUES = cArray2;
        }
    }
}

