/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.fu_0;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fv
 */
public final class fv_0 {
    private final VSCoreConfig.Server a;
    private final HashMap<VsiPlayer, Set<Long>> b;
    private final Long2ObjectOpenHashMap<Set<VsiPlayer>> c;
    private final HashMap<VsiPlayer, Set<Long>> d;
    private final HashMap<VsiPlayer, Set<Long>> e;
    private Set<? extends VsiPlayer> f;

    @Inject
    public fv_0(VSCoreConfig.Server server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"");
        this.a = server;
        this.b = new HashMap();
        this.c = new Long2ObjectOpenHashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = SetsKt.emptySet();
    }

    private final void a(Iterable<Long> object) {
        object = object.iterator();
        while (object.hasNext()) {
            long l2 = ((Number)object.next()).longValue();
            Collection<Set<Long>> collection = this.b.values();
            Intrinsics.checkNotNullExpressionValue(collection, (String)"");
            Object object2 = collection;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (Set)object3;
                object3.remove(l2);
            }
            this.c.remove(l2);
        }
    }

    private final void a() {
        this.d.clear();
        this.e.clear();
    }

    public final fu_0 a(Set<? extends VsiPlayer> set, Set<? extends VsiPlayer> iterator2, Iterable<PhysicsEntityServer> entry, Iterable<Long> object) {
        long l2;
        Iterable<Object> iterable4;
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        Intrinsics.checkNotNullParameter(entry, (String)"");
        Intrinsics.checkNotNullParameter(object, (String)"");
        Object object2 = this;
        ((fv_0)object2).d.clear();
        ((fv_0)object2).e.clear();
        object2 = object.iterator();
        while (object2.hasNext()) {
            Set set2;
            Object object32;
            long l3 = ((Number)object2.next()).longValue();
            Collection<Set<Long>> collection = this.b.values();
            Intrinsics.checkNotNullExpressionValue(collection, (String)"");
            Iterable iterable2 = collection;
            for (Object object32 : iterable2) {
                set2 = (Set)object32;
                set2.remove(l3);
            }
            iterable2 = (Set)this.c.get(l3);
            if (iterable2 == null) continue;
            this.c.remove(l3);
            Iterable iterable3 = iterable2;
            object32 = iterable3.iterator();
            while (object32.hasNext()) {
                set2 = object32.next();
                VsiPlayer vsiPlayer = (VsiPlayer)((Object)set2);
                this.e.computeIfAbsent(vsiPlayer, arg_0 -> fv_0.a(1.a, arg_0)).add(l3);
            }
        }
        object2 = this;
        Iterator iterator3 = object.iterator();
        while (iterator3.hasNext()) {
            long l4 = ((Number)iterator3.next()).longValue();
            Collection<Set<Long>> collection = ((fv_0)object2).b.values();
            Intrinsics.checkNotNullExpressionValue(collection, (String)"");
            iterable4 = collection;
            for (Iterable<Object> iterable4 : iterable4) {
                iterable4 = (Set)iterable4;
                iterable4.remove(l4);
            }
            ((fv_0)object2).c.remove(l4);
        }
        object = SetsKt.minus(iterator2, (Iterable)set);
        object2 = this;
        if (!object.isEmpty()) {
            iterator3 = (Iterable)object;
            Object object4 = iterator3.iterator();
            while (object4.hasNext()) {
                iterable4 = object4.next();
                iterator3 = (VsiPlayer)((Object)iterable4);
                ((fv_0)object2).b.remove(iterator3);
            }
            iterator3 = ((Map)((fv_0)object2).c).entrySet().iterator();
            while (iterator3.hasNext()) {
                Map.Entry entry2 = iterator3.next();
                object4 = (Set)entry2.getValue();
                object4.removeAll((Collection)object);
                if (!object4.isEmpty()) continue;
                iterator3.remove();
            }
        }
        this.f = SetsKt.minus(set, (Iterable)((Iterable)((Object)iterator2)));
        object2 = new Vector3d();
        double d2 = this.a.getShipLoadDistance();
        double d3 = this.a.getShipUnloadDistance();
        double d4 = d2;
        double d5 = d4 * d4;
        double d6 = d3;
        double d7 = d6 * d6;
        iterator2 = entry;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            entry = iterator2.next();
            entry = (PhysicsEntityServer)((Object)entry);
            for (VsiPlayer vsiPlayer : set) {
                boolean bl;
                Vector3dc vector3dc = vsiPlayer.getPosition((Vector3d)object2);
                double d8 = ((PhysicsEntityServer)((Object)entry)).getShipTransform().getPositionInWorld().distanceSquared(vector3dc);
                Set<Long> set3 = this.b.get(vsiPlayer);
                boolean bl2 = bl = set3 != null ? set3.contains(((PhysicsEntityServer)((Object)entry)).getId()) : false;
                if (!Intrinsics.areEqual((Object)((PhysicsEntityServer)((Object)entry)).getDimensionId(), (Object)vsiPlayer.getDimension())) {
                    if (!bl) continue;
                    this.e.computeIfAbsent(vsiPlayer, arg_0 -> fv_0.b(2.a, arg_0)).add(((PhysicsEntityServer)((Object)entry)).getId());
                    continue;
                }
                if (d8 < d5) {
                    if (bl) continue;
                    this.d.computeIfAbsent(vsiPlayer, arg_0 -> fv_0.c(3.a, arg_0)).add(((PhysicsEntityServer)((Object)entry)).getId());
                    continue;
                }
                if (!(d8 > d7) || !bl) continue;
                this.e.computeIfAbsent(vsiPlayer, arg_0 -> fv_0.d(4.a, arg_0)).add(((PhysicsEntityServer)((Object)entry)).getId());
            }
        }
        iterator2 = this.e;
        for (Map.Entry entry3 : iterator2.entrySet()) {
            entry = entry3;
            entry = entry3;
            object = (VsiPlayer)entry3.getKey();
            Set set4 = (Set)entry.getValue();
            Iterable iterable52 = set4;
            for (Iterable iterable52 : iterable52) {
                l2 = ((Number)((Object)iterable52)).longValue();
                Set<Long> set5 = this.b.get(object);
                Intrinsics.checkNotNull(set5);
                set5.remove(l2);
                set = (Set)this.c.get(l2);
                if (set == null) continue;
                set.remove(object);
                if (!set.isEmpty()) continue;
                this.c.remove(l2);
            }
        }
        iterator2 = this.d;
        for (Map.Entry entry4 : iterator2.entrySet()) {
            entry = entry4;
            entry = entry4;
            object = (VsiPlayer)entry4.getKey();
            Set set6 = (Set)entry.getValue();
            Iterable iterable62 = set6;
            for (Iterable iterable62 : iterable62) {
                l2 = ((Number)((Object)iterable62)).longValue();
                this.b.computeIfAbsent((VsiPlayer)object, arg_0 -> fv_0.e(5.a, arg_0)).add(l2);
                ((Set)this.c.computeIfAbsent(l2, fv_0::a)).add(object);
            }
        }
        return new fu_0((Map<VsiPlayer, ? extends Set<Long>>)this.b, this.c, (Map<VsiPlayer, ? extends Set<Long>>)this.d, (Map<VsiPlayer, ? extends Set<Long>>)this.e);
    }

    private final void a(Set<? extends VsiPlayer> set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator iterator2 = set;
        Object object = iterator2.iterator();
        while (object.hasNext()) {
            iterator2 = object.next();
            iterator2 = (VsiPlayer)((Object)iterator2);
            this.b.remove(iterator2);
        }
        iterator2 = ((Map)this.c).entrySet().iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            object = (Set)object.getValue();
            object.removeAll((Collection)set);
            if (!object.isEmpty()) continue;
            iterator2.remove();
        }
    }

    private static final Set a(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set b(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set c(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set d(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set e(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final HashSet a(long l2) {
        return new HashSet();
    }
}

