/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.CR;
import org.valkyrienskies.core.impl.shadow.CT;
import org.valkyrienskies.core.impl.shadow.CU;
import org.valkyrienskies.core.impl.shadow.CW;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;
import org.valkyrienskies.core.util.AABBdUtilKt;

public final class CY {
    private final VSCoreConfig.Server f;
    private final Map<String, DP> g;
    private final Long2ObjectMap<Set<VsiPlayer>> h;
    private final HashMap<VsiPlayer, Map<ServerShipInternal, LongSet>> i;
    final Long2ObjectOpenHashMap<Set<VsiPlayer>> a;
    final HashMap<VsiPlayer, Set<ServerShipInternal>> b;
    final HashMap<VsiPlayer, Set<ServerShipInternal>> c;
    final HashSet<ServerShipInternal> d;
    final HashSet<ServerShipInternal> e;
    private Set<? extends VsiPlayer> j;

    @Inject
    public CY(VSCoreConfig.Server server, @Named(value="dimensionInfo") Map<String, DP> map2) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        this.f = server;
        this.g = map2;
        this.h = (Long2ObjectMap)new Long2ObjectOpenHashMap();
        this.i = new HashMap();
        this.a = new Long2ObjectOpenHashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashSet();
        this.e = new HashSet();
        this.j = SetsKt.emptySet();
    }

    private VSCoreConfig.Server a() {
        return this.f;
    }

    private Map<String, DP> b() {
        return this.g;
    }

    private final void a(Iterable<? extends ServerShipInternal> object) {
        object = object.iterator();
        while (object.hasNext()) {
            ServerShipInternal serverShipInternal = (ServerShipInternal)object.next();
            Collection<Map<ServerShipInternal, LongSet>> collection = this.i.values();
            Intrinsics.checkNotNullExpressionValue(collection, (String)"");
            Object object2 = collection;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (Map)object3;
                object3.remove(serverShipInternal);
            }
            this.a.remove(serverShipInternal.getId());
            this.e.add(serverShipInternal);
            serverShipInternal.getActiveChunksSet().forEach((arg_0, arg_1) -> CY.a(this, arg_0, arg_1));
        }
    }

    private final void c() {
        this.d.clear();
        this.e.clear();
        this.b.clear();
        this.c.clear();
    }

    public final VsiChunkWatchTasks a(Set<? extends VsiPlayer> set, Set<? extends VsiPlayer> set2, Iterable<? extends ServerShipInternal> object, Iterable<? extends ServerShipInternal> iterable) {
        Object object2;
        Object object3;
        Map.Entry entry;
        Iterator iterator2;
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(set2, (String)"");
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Object object4 = this;
        ((CY)object4).d.clear();
        ((CY)object4).e.clear();
        ((CY)object4).b.clear();
        ((CY)object4).c.clear();
        Object object5 = iterable;
        object4 = this;
        Map.Entry entry22 = object5.iterator();
        while (entry22.hasNext()) {
            object5 = entry22.next();
            Collection<Map<ServerShipInternal, LongSet>> collection = ((CY)object4).i.values();
            Intrinsics.checkNotNullExpressionValue(collection, (String)"");
            iterator2 = collection;
            entry = iterator2.iterator();
            while (entry.hasNext()) {
                iterator2 = entry.next();
                object3 = (Map)((Object)iterator2);
                object3.remove(object5);
            }
            ((CY)object4).a.remove(object5.getId());
            ((CY)object4).e.add((ServerShipInternal)object5);
            object5.getActiveChunksSet().forEach((arg_0, arg_1) -> CY.a((CY)object4, arg_0, arg_1));
        }
        object5 = SetsKt.minus(set2, (Iterable)set);
        object4 = this;
        if (!object5.isEmpty()) {
            entry22 = (Iterable)object5;
            iterator2 = entry22.iterator();
            while (iterator2.hasNext()) {
                entry22 = iterator2.next();
                entry = (VsiPlayer)((Object)entry22);
                ((CY)object4).i.remove(entry);
            }
            entry22 = (Map)((CY)object4).a;
            for (Map.Entry entry22 : entry22.entrySet()) {
                entry = entry22;
                object3 = (Set)entry22.getValue();
                object3.removeAll((Collection)object5);
            }
            entry22 = (Map)((CY)object4).h;
            for (Map.Entry entry22 : entry22.entrySet()) {
                entry = entry22;
                object3 = (Set)entry22.getValue();
                object3.removeAll((Collection)object5);
            }
        }
        this.j = SetsKt.minus(set, (Iterable)set2);
        set2 = new TreeSet<VsiPlayer>();
        object4 = new TreeSet();
        double d2 = this.f.getShipLoadDistance();
        double d3 = this.f.getShipUnloadDistance();
        object5 = new Vector3d();
        AABBd aABBd = new AABBd();
        object = object.iterator();
        while (object.hasNext()) {
            object2 = object.next();
            object2 = (ServerShipInternal)object2;
            ShipTransform shipTransform = object2.getTransform();
            AABBic aABBic = object2.getShipAABB();
            Object object6 = (DP)MapsKt.getValue(this.g, (Object)object2.getChunkClaimDimension());
            object6 = ((DP)object6).b;
            object2.getActiveChunksSet().forEach((arg_0, arg_1) -> CY.a(aABBd, aABBic, (LevelYRange)object6, shipTransform, this, (ServerShipInternal)object2, set, (Vector3d)object5, d2, d3, set2, (TreeSet)object4, arg_0, arg_1));
        }
        object = iterable;
        object = object.iterator();
        while (object.hasNext()) {
            object2 = object.next();
            object2 = (ServerShipInternal)object2;
            object2.getActiveChunksSet().forEach((arg_0, arg_1) -> CY.a((TreeSet)object4, object2, set, arg_0, arg_1));
        }
        object5 = (SortedSet)object4;
        object4 = (SortedSet)set2;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        Intrinsics.checkNotNullParameter((Object)object5, (String)"");
        return new CW((SortedSet<VsiChunkWatchTask>)object4, (SortedSet<VsiChunkUnwatchTask>)object5);
    }

    public final CR a(Iterable<? extends VsiChunkWatchTask> iterator2, Iterable<? extends VsiChunkUnwatchTask> iterable) {
        Object object;
        ServerShipInternal serverShipInternal;
        long l2;
        Iterator iterator3;
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            VsiChunkWatchTask vsiChunkWatchTask = (VsiChunkWatchTask)((Object)iterator2.next());
            ServerShip serverShip = vsiChunkWatchTask.getShip();
            Intrinsics.checkNotNull((Object)serverShip);
            iterator3 = vsiChunkWatchTask.getPlayersNeedWatching();
            l2 = vsiChunkWatchTask.getChunkPos();
            serverShipInternal = (ServerShipInternal)serverShip;
            CY object2 = this;
            Object object3 = object2.h.computeIfAbsent(l2, CY::a);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
            CollectionsKt.addAll((Collection)((Collection)object3), iterator3);
            iterator3 = iterator3.iterator();
            while (iterator3.hasNext()) {
                object = iterator3.next();
                object = (VsiPlayer)object;
                object2.i.computeIfAbsent((VsiPlayer)object, (Function<VsiPlayer, Map<ServerShipInternal, LongSet>>)((Function<Object, Map>)arg_0 -> CY.a(1.a, arg_0))).compute(serverShipInternal, (arg_0, arg_1) -> CY.a((Function2)new Function2<ServerShipInternal, LongSet, LongSet>(object2, object, serverShipInternal, l2){
                    private /* synthetic */ CY a;
                    private /* synthetic */ VsiPlayer $b;
                    private /* synthetic */ ServerShipInternal $c;
                    private /* synthetic */ long $d;
                    {
                        this.a = cY;
                        this.$b = vsiPlayer;
                        this.$c = serverShipInternal;
                        this.$d = l2;
                        super(2);
                    }

                    public final LongSet a(ServerShipInternal object, LongSet object2) {
                        Intrinsics.checkNotNullParameter((Object)object, (String)"");
                        if (object2 == null) {
                            object2 = this.a;
                            object2.b.computeIfAbsent(this.$b, arg_0 -> 2.a(1.a, arg_0)).add(this.$c);
                            object = this.a;
                            object = (Set)((CY)object).a.computeIfAbsent(this.$c.getId(), 2::a);
                            if (object.isEmpty()) {
                                object2 = this.a;
                                object2.d.add(this.$c);
                            }
                            object.add(this.$b);
                            object = new LongOpenHashSet();
                            long l2 = this.$d;
                            object2 = object;
                            object2.add(l2);
                            return (LongSet)object;
                        }
                        object2.add(this.$d);
                        return object2;
                    }

                    private static final Set a(Function1 function1, Object object) {
                        return (Set)function1.invoke(object);
                    }

                    private static final HashSet a(long l2) {
                        return new HashSet();
                    }

                    /*
                     * WARNING - void declaration
                     */
                    public final /* synthetic */ Object invoke(Object p1, Object p2) {
                        void var2_2;
                        void var1_1;
                        return this.a((ServerShipInternal)var1_1, (LongSet)var2_2);
                    }
                }, arg_0, arg_1));
            }
        }
        for (VsiChunkUnwatchTask vsiChunkUnwatchTask : iterable) {
            ServerShip serverShip = vsiChunkUnwatchTask.getShip();
            Intrinsics.checkNotNull((Object)serverShip);
            iterator3 = vsiChunkUnwatchTask.getPlayersNeedUnwatching();
            l2 = vsiChunkUnwatchTask.getChunkPos();
            serverShipInternal = (ServerShipInternal)serverShip;
            CY cY = this;
            cY.h.computeIfPresent(l2, (arg_0, arg_1) -> CY.b((Function2)new Function2<Long, Set<VsiPlayer>, Set<VsiPlayer>>(iterator3){
                private /* synthetic */ Iterable<VsiPlayer> $a;
                {
                    this.$a = iterable;
                    super(2);
                }

                public final Set<VsiPlayer> a(Long object, Set<VsiPlayer> set) {
                    Intrinsics.checkNotNullExpressionValue(set, (String)"");
                    CollectionsKt.removeAll((Collection)set, this.$a);
                    object = set;
                    return (Set)(object.isEmpty() ? null : object);
                }

                /*
                 * WARNING - void declaration
                 */
                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                    void var2_2;
                    void var1_1;
                    return this.a((Long)var1_1, (Set)var2_2);
                }
            }, arg_0, arg_1));
            iterator3 = iterator3.iterator();
            while (iterator3.hasNext()) {
                object = iterator3.next();
                object = (VsiPlayer)object;
                cY.i.computeIfPresent((VsiPlayer)object, (BiFunction<VsiPlayer, Map<ServerShipInternal, LongSet>, Map<ServerShipInternal, LongSet>>)((BiFunction<Object, Object, Map>)(arg_0, arg_1) -> CY.c((Function2)new Function2<VsiPlayer, Map<ServerShipInternal, LongSet>, Map<ServerShipInternal, LongSet>>(serverShipInternal, l2, cY, object){
                    private /* synthetic */ ServerShipInternal $a;
                    private /* synthetic */ long $b;
                    private /* synthetic */ CY c;
                    private /* synthetic */ VsiPlayer $d;
                    {
                        this.$a = serverShipInternal;
                        this.$b = l2;
                        this.c = cY;
                        this.$d = vsiPlayer;
                        super(2);
                    }

                    public final Map<ServerShipInternal, LongSet> a(VsiPlayer vsiPlayer, Map<ServerShipInternal, LongSet> map2) {
                        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
                        Intrinsics.checkNotNullParameter(map2, (String)"");
                        map2.computeIfPresent(this.$a, (arg_0, arg_1) -> 4.a((Function2)new Function2<ServerShipInternal, LongSet, LongSet>(this.$b, this.c, this.$d, this.$a){
                            private /* synthetic */ long $a;
                            private /* synthetic */ CY b;
                            private /* synthetic */ VsiPlayer $c;
                            private /* synthetic */ ServerShipInternal $d;
                            {
                                this.$a = l2;
                                this.b = cY;
                                this.$c = vsiPlayer;
                                this.$d = serverShipInternal;
                                super(2);
                            }

                            public final LongSet a(ServerShipInternal object, LongSet longSet) {
                                Intrinsics.checkNotNullParameter((Object)object, (String)"");
                                Intrinsics.checkNotNullParameter((Object)longSet, (String)"");
                                if (longSet.size() == 1) {
                                    if (!longSet.contains(this.$a)) {
                                        object = "Last chunk on ship was not what we expected it to be";
                                        throw new IllegalStateException(object.toString());
                                    }
                                    object = this.b;
                                    ((CY)object).c.computeIfAbsent(this.$c, arg_0 -> 1.a(1.a, arg_0)).add(this.$d);
                                    object = this.b;
                                    Object object2 = ((CY)object).a.get(this.$d.getId());
                                    Intrinsics.checkNotNull((Object)object2);
                                    object = (Set)object2;
                                    object.remove(this.$c);
                                    if (object.isEmpty()) {
                                        object = this.b;
                                        ((CY)object).e.add(this.$d);
                                    }
                                    longSet.clear();
                                    return null;
                                }
                                if (!longSet.remove(this.$a)) {
                                    object = "Player not watching chunk that we thought they were";
                                    throw new IllegalStateException(object.toString());
                                }
                                return longSet;
                            }

                            private static final Set a(Function1 function1, Object object) {
                                return (Set)function1.invoke(object);
                            }

                            /*
                             * WARNING - void declaration
                             */
                            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                void var2_2;
                                void var1_1;
                                return this.a((ServerShipInternal)var1_1, (LongSet)var2_2);
                            }
                        }, arg_0, arg_1));
                        if (map2.isEmpty()) {
                            return null;
                        }
                        return map2;
                    }

                    private static final LongSet a(Function2 function2, Object object, Object object2) {
                        return (LongSet)function2.invoke(object, object2);
                    }

                    /*
                     * WARNING - void declaration
                     */
                    public final /* synthetic */ Object invoke(Object p1, Object p2) {
                        void var2_2;
                        void var1_1;
                        return this.a((VsiPlayer)var1_1, (Map)var2_2);
                    }
                }, arg_0, arg_1)));
            }
        }
        return new CR((Map<VsiPlayer, ? extends Map<ServerShipInternal, ? extends LongSet>>)this.i, (Long2ObjectMap<Set<VsiPlayer>>)((Long2ObjectMap)this.a), (Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>>)this.b, (Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>>)this.c, (Set<? extends ServerShipInternal>)this.d, (Set<? extends ServerShipInternal>)this.e, this.j);
    }

    public final Set<VsiPlayer> a(int n2, int n3, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        long l2 = IShipActiveChunksSet.Companion.chunkPosToLong(n2, n3);
        Set set = (Set)this.h.get(l2);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    private final void a(ServerShipInternal serverShipInternal, long l2, Iterable<? extends VsiPlayer> object) {
        Object object2 = this.h.computeIfAbsent(l2, CY::a);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
        CollectionsKt.addAll((Collection)((Collection)object2), object);
        object = object.iterator();
        while (object.hasNext()) {
            Object object3 = object.next();
            object3 = (VsiPlayer)object3;
            this.i.computeIfAbsent((VsiPlayer)object3, (Function<VsiPlayer, Map<ServerShipInternal, LongSet>>)((Function<Object, Map>)arg_0 -> CY.a(1.a, arg_0))).compute(serverShipInternal, (arg_0, arg_1) -> CY.a((Function2)new /* invalid duplicate definition of identical inner class */, arg_0, arg_1));
        }
    }

    private final void b(ServerShipInternal serverShipInternal, long l2, Iterable<? extends VsiPlayer> object) {
        this.h.computeIfPresent(l2, (arg_0, arg_1) -> CY.b((Function2)new /* invalid duplicate definition of identical inner class */, arg_0, arg_1));
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (VsiPlayer)object2;
            this.i.computeIfPresent((VsiPlayer)object2, (BiFunction<VsiPlayer, Map<ServerShipInternal, LongSet>, Map<ServerShipInternal, LongSet>>)((BiFunction<Object, Object, Map>)(arg_0, arg_1) -> CY.c((Function2)new /* invalid duplicate definition of identical inner class */, arg_0, arg_1)));
        }
    }

    private final void a(Set<? extends VsiPlayer> set) {
        Object object;
        if (set.isEmpty()) {
            return;
        }
        Iterator iterator2 = set;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            object = (VsiPlayer)object;
            this.i.remove(object);
        }
        iterator2 = (Map)this.a;
        for (Map.Entry entry : iterator2.entrySet()) {
            object = entry;
            object = entry;
            object = (Set)entry.getValue();
            object.removeAll((Collection)set);
        }
        iterator2 = (Map)this.h;
        for (Map.Entry entry : iterator2.entrySet()) {
            object = entry;
            object = entry;
            object = (Set)entry.getValue();
            object.removeAll((Collection)set);
        }
    }

    private static final void a(CY cY, int n2, int n3) {
        long l2 = IShipActiveChunksSet.Companion.chunkPosToLong(n2, n3);
        cY.h.remove(l2);
    }

    private static final void a(AABBd object, AABBic object2, LevelYRange object3, ShipTransform object4, CY object5, ServerShipInternal serverShipInternal, Set object6, Vector3d vector3d, double d2, double d3, TreeSet treeSet, TreeSet treeSet2, int n2, int n3) {
        AABBic aABBic = object2;
        AABBic aABBic2 = object2;
        object = AABBdUtilKt.set((AABBd)object, n2 << 4, aABBic != null ? (double)aABBic.minY() : (double)((LevelYRange)object3).getMinY(), n3 << 4, (double)(n2 << 4) + 16.0, (aABBic2 != null ? (double)aABBic2.maxY() : (double)((LevelYRange)object3).getMaxY()) + 1.0, (double)(n3 << 4) + 16.0).transform(object4.getShipToWorld());
        object2 = new ArrayList();
        object3 = new ArrayList();
        double d4 = Double.MAX_VALUE;
        double d5 = Double.MAX_VALUE;
        object4 = ((CY)object5).a(n2, n3, serverShipInternal.getChunkClaimDimension());
        long l2 = IShipActiveChunksSet.Companion.chunkPosToLong(n2, n3);
        object5 = object6.iterator();
        while (object5.hasNext()) {
            object6 = (VsiPlayer)object5.next();
            Vector3dc vector3dc = object6.getPosition(vector3d);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
            double d6 = AABBdUtilKt.signedDistanceTo((AABBdc)object, vector3dc);
            n2 = object4.contains(object6) ? 1 : 0;
            if (!Intrinsics.areEqual((Object)serverShipInternal.getChunkClaimDimension(), (Object)object6.getDimension())) {
                if (n2 == 0) continue;
                object3.add(object6);
                continue;
            }
            n3 = object6.getForceWatchingShips().contains(serverShipInternal.getId()) ? 1 : 0;
            if (d6 < d2 || n3 != 0) {
                if (n2 != 0) continue;
                object2.add(object6);
                d4 = Math.min(d4, d6);
                continue;
            }
            if (!(d6 > d3) || n2 == 0) continue;
            object3.add(object6);
            d5 = Math.min(d5, d6);
        }
        if (!((Collection)object2).isEmpty()) {
            object5 = serverShipInternal;
            double d7 = d4;
            object2 = (Iterable)object2;
            object = serverShipInternal.getChunkClaimDimension();
            long l3 = l2;
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Intrinsics.checkNotNullParameter((Object)object5, (String)"");
            object5 = new CU(l3, (String)object, (Iterable<? extends VsiPlayer>)object2, d7, (ServerShip)object5);
            treeSet.add(object5);
        }
        if (!((Collection)object3).isEmpty()) {
            boolean bl = object4.size() == object3.size();
            object6 = CT.a(l2, serverShipInternal.getChunkClaimDimension(), (Iterable)object3, bl, d5, serverShipInternal);
            treeSet2.add(object6);
        }
    }

    private static final void a(TreeSet treeSet, ServerShipInternal serverShipInternal, Set set, int n2, int n3) {
        treeSet.add(CT.a(IShipActiveChunksSet.Companion.chunkPosToLong(n2, n3), serverShipInternal.getChunkClaimDimension(), set, true, Double.POSITIVE_INFINITY, serverShipInternal));
    }

    private static final Set a(long l2) {
        return new HashSet();
    }

    private static final Map a(Function1 function1, Object object) {
        return (Map)function1.invoke(object);
    }

    private static final LongSet a(Function2 function2, Object object, Object object2) {
        return (LongSet)function2.invoke(object, object2);
    }

    private static final Set b(Function2 function2, Object object, Object object2) {
        return (Set)function2.invoke(object, object2);
    }

    private static final Map c(Function2 function2, Object object, Object object2) {
        return (Map)function2.invoke(object, object2);
    }

    public static final /* synthetic */ HashMap a(CY cY) {
        return cY.b;
    }

    public static final /* synthetic */ Long2ObjectOpenHashMap b(CY cY) {
        return cY.a;
    }

    public static final /* synthetic */ HashSet c(CY cY) {
        return cY.d;
    }

    public static final /* synthetic */ HashMap d(CY cY) {
        return cY.c;
    }

    public static final /* synthetic */ HashSet e(CY cY) {
        return cY.e;
    }
}

